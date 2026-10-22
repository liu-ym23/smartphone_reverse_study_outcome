package com.stepos.ailauncher.network.interceptor;

import H5.a;
import La.D;
import O6.l;
import android.content.Context;
import com.stepos.aiengine.args.SingleFileBundle;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import tb.C5528A;
import tb.C5530C;
import tb.w;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B#\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0017R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0018R\u0014\u0010\u0006\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0018¨\u0006\u001a"}, d2 = {"Lcom/stepos/ailauncher/network/interceptor/BizInterceptor;", "Ltb/w;", "Landroid/content/Context;", "context", "", "includeDeviceId", "includeGatewayAuth", "<init>", "(Landroid/content/Context;ZZ)V", "", "message", "secret", "hmacSha256", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "", SingleFileBundle.KEY_BYTES, "bytesToHex", "([B)Ljava/lang/String;", "Ltb/w$a;", "chain", "Ltb/C;", "intercept", "(Ltb/w$a;)Ltb/C;", "Landroid/content/Context;", "Z", "Companion", "network_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class BizInterceptor implements w {
    private static final String HMAC_SHA256_ALGORITHM = "HmacSHA256";
    private final Context context;
    private final boolean includeDeviceId;
    private final boolean includeGatewayAuth;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static String APP_ID = "83649570121923358340";
    private static String APP_SECRET = "a8hiwms21nelv5jd9bt4pgyq0okfzx7c";

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0010R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u000e\u0010\r\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/stepos/ailauncher/network/interceptor/BizInterceptor$Companion;", "", "<init>", "()V", "APP_ID", "", "getAPP_ID", "()Ljava/lang/String;", "setAPP_ID", "(Ljava/lang/String;)V", "APP_SECRET", "getAPP_SECRET", "setAPP_SECRET", "HMAC_SHA256_ALGORITHM", "getAppId", "context", "Landroid/content/Context;", "getAppSecret", "network_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final String getAPP_ID() {
            return BizInterceptor.APP_ID;
        }

        public final String getAPP_SECRET() {
            return BizInterceptor.APP_SECRET;
        }

        public final String getAppId(Context context) {
            p.i(context, "context");
            String appId = a.INSTANCE.a(context).getAppId();
            BizInterceptor.INSTANCE.setAPP_ID(appId);
            return appId;
        }

        public final String getAppSecret(Context context) {
            p.i(context, "context");
            String strI = a.INSTANCE.a(context).i();
            BizInterceptor.INSTANCE.setAPP_SECRET(strI);
            return strI;
        }

        public final void setAPP_ID(String str) {
            p.i(str, "<set-?>");
            BizInterceptor.APP_ID = str;
        }

        public final void setAPP_SECRET(String str) {
            p.i(str, "<set-?>");
            BizInterceptor.APP_SECRET = str;
        }

        private Companion() {
        }
    }

    public BizInterceptor(Context context, boolean z10, boolean z11) {
        p.i(context, "context");
        this.context = context;
        this.includeDeviceId = z10;
        this.includeGatewayAuth = z11;
    }

    private final String bytesToHex(byte[] bytes) {
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

    private final String hmacSha256(String message, String secret) throws IllegalStateException, NoSuchAlgorithmException, InvalidKeyException {
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
        return bytesToHex(bArrDoFinal);
    }

    @Override // tb.w
    public C5530C intercept(w.a chain) throws IllegalStateException, NoSuchAlgorithmException, InvalidKeyException {
        p.i(chain, "chain");
        C5528A.a aVarI = chain.getRequest().i();
        C6.a aVar = C6.a.INSTANCE;
        C5528A.a aVarA = aVarI.a("zy-device-model", aVar.f()).a("zy-device-brand", aVar.c()).a("zy-client-type", "Android").a("zy-client-lang", aVar.e()).a("zy-system-ver", aVar.i()).a("zy-app-ver-name", aVar.b(this.context)).a("zy-app-ver-code", String.valueOf(aVar.a(this.context))).a("Content-Type", "application/json");
        if (this.includeGatewayAuth) {
            String string = UUID.randomUUID().toString();
            p.h(string, "toString(...)");
            String strT = D.T(string, l.DATE_SEPARATOR, "", false, 4, null);
            String strValueOf = String.valueOf(System.currentTimeMillis());
            aVarA.a("zy-app-id", APP_ID).a("zy-nonce", strT).a("zy-timestamp", strValueOf).a("zy-sign", hmacSha256(APP_ID + strT + strValueOf + APP_SECRET, APP_SECRET));
        }
        if (this.includeDeviceId) {
            aVarA.a("zy-device-id", aVar.d(this.context));
        }
        return chain.i(aVarA.b());
    }

    public /* synthetic */ BizInterceptor(Context context, boolean z10, boolean z11, int i10, i iVar) {
        this(context, (i10 & 2) != 0 ? true : z10, (i10 & 4) != 0 ? true : z11);
    }
}
