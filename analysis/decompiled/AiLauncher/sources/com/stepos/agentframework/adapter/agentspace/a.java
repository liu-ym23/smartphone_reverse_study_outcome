package com.stepos.agentframework.adapter.agentspace;

import La.D;
import O6.l;
import android.content.Context;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.aiengine.args.SingleFileBundle;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import tb.C5528A;
import tb.C5530C;
import tb.w;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0006\u0018\u0000 \u00152\u00020\u0001:\u0001\u0012B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0014¨\u0006\u0016"}, d2 = {"Lcom/stepos/agentframework/adapter/agentspace/a;", "Ltb/w;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Ltb/w$a;", "chain", "Ltb/C;", "intercept", "(Ltb/w$a;)Ltb/C;", "", "message", "secret", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "", SingleFileBundle.KEY_BYTES, Const.INTENT_KEY_APIKEY, "([B)Ljava/lang/String;", "Landroid/content/Context;", "Companion", "business_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class a implements w {
    private static final String APP_ID = "agentframework";
    private static final String APP_SECRET = "KIBn9xhmgp5O3JjfGTV8";
    private static final String HMAC_SHA256_ALGORITHM = "HmacSHA256";
    private final Context context;

    public a(Context context) {
        p.i(context, "context");
        this.context = context;
    }

    public final String a(byte[] bytes) {
        StringBuilder sb2 = new StringBuilder(bytes.length * 2);
        for (byte b10 : bytes) {
            String hexString = Integer.toHexString(b10 & 255);
            if (hexString.length() == 1) {
                sb2.append('0');
            }
            sb2.append(hexString);
        }
        String string = sb2.toString();
        p.h(string, "toString(...)");
        return string;
    }

    public final String b(String message, String secret) throws IllegalStateException, NoSuchAlgorithmException, InvalidKeyException {
        Mac mac = Mac.getInstance(HMAC_SHA256_ALGORITHM);
        Charset UTF_8 = StandardCharsets.UTF_8;
        p.h(UTF_8, "UTF_8");
        byte[] bytes = secret.getBytes(UTF_8);
        p.h(bytes, "getBytes(...)");
        mac.init(new SecretKeySpec(bytes, HMAC_SHA256_ALGORITHM));
        p.h(UTF_8, "UTF_8");
        byte[] bytes2 = message.getBytes(UTF_8);
        p.h(bytes2, "getBytes(...)");
        byte[] bArrDoFinal = mac.doFinal(bytes2);
        p.f(bArrDoFinal);
        return a(bArrDoFinal);
    }

    @Override // tb.w
    public C5530C intercept(w.a chain) throws IllegalStateException, NoSuchAlgorithmException, InvalidKeyException {
        p.i(chain, "chain");
        C5528A request = chain.getRequest();
        String string = UUID.randomUUID().toString();
        p.h(string, "toString(...)");
        String strT = D.T(string, l.DATE_SEPARATOR, "", false, 4, null);
        String strValueOf = String.valueOf(System.currentTimeMillis());
        String strB = b(APP_ID + strT + strValueOf + APP_SECRET, APP_SECRET);
        C5528A.a aVarI = request.i();
        e eVar = e.INSTANCE;
        return chain.i(aVarI.a("zy-device-id", eVar.d(this.context)).a("zy-device-model", eVar.f()).a("zy-device-brand", eVar.c()).a("zy-client-type", "Android").a("zy-client-lang", eVar.e()).a("zy-app-id", APP_ID).a("zy-system-ver", eVar.h()).a("zy-app-ver-name", eVar.b(this.context)).a("zy-app-ver-code", String.valueOf(eVar.a(this.context))).a("zy-nonce", strT).a("zy-timestamp", strValueOf).a("zy-sign", strB).a("Content-Type", "application/json").b());
    }
}
