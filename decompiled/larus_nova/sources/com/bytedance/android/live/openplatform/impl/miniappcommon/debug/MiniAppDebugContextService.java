package com.bytedance.android.live.openplatform.impl.miniappcommon.debug;

import android.util.Base64;
import com.alipay.sdk.m.n.d;
import com.baidu.mapauto.auth.util.RSAUtil;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContextService;
import com.bytedance.android.live.openplatform.impl.base.utils.t;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.nio.charset.Charset;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.Signature;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.X509EncodedKeySpec;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001:\u0001\u0006B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappcommon/debug/MiniAppDebugContextService;", "Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContextService;", "Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContext;", "openPlatformContext", "<init>", "(Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContext;)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class MiniAppDebugContextService extends OpenPlatformContextService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f85014a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f85015b;

    public static final class a {
    }

    static {
    }

    public MiniAppDebugContextService(OpenPlatformContext r100) {
        Intrinsics.checkNotNullParameter(r100, "openPlatformContext");
        super(r100);
        this.f85014a = "";
        this.f85015b = "";
    }

    public final boolean f(long r100, String r101, int r102, String r103, long r104) {
        Intrinsics.checkNotNullParameter(r101, "appId");
        Intrinsics.checkNotNullParameter(r103, "sign");
        StringBuilder r105 = new StringBuilder();
        r105.append(String.valueOf(r100));
        r105.append(r101);
        r105.append(String.valueOf(r102));
        int r106 = t.f84075a;
        byte[] r107 = Base64.decode("MWVlMTExZmVjZmZjMTJkMTcxOWE5NzBkZDE3N2UxZGE=", 0);
        Charset r108 = Charsets.UTF_8;
        r105.append(new String(r107, r108));
        String r109 = r105.toString();
        if (r104 != 8) goto L22;
        String r110 = new String(Base64.decode("TUlJQklqQU5CZ2txaGtpRzl3MEJBUUVGQUFPQ0FROEFNSUlCQ2dLQ0FRRUFzY1BaL08vek00MjV3N1BLYXU5cHYzVUtZL0I2VmtzaHhjMlpodW02Vm12Q082dTVHeXl2R0dWUHlsWWF6Wi9lNFQ2a1orOVBEc0V6UHZUbzVRb0ZDaTdkZTZlcktEa0o5VW4wY3NwbWFKKzlnT0JiaHZodEw4d2xYREVVUDBlMzRpdmJXMWw3NGNFelJjT1hNTUJIYVNWNlZWZEJteVZhemdVYzFtZmFKK09rT3BLRFdveDFwOXUvU3BlVXJEQ2pzZXJvajJ1aldwYjArYW92bnd4M2VOSVR5ZnJuN2NkNFlSYnFTMXkwalk3U3BhMTVJaFVWTkdlU1VabGFkbkZmbUZZaXRhb2JEdGttQ2h4UWo1OG5BZ1ZrTnBwZHF1VXBza1g5Zk1tNURINUI4QUppSzJTaGhQNUJQa2FjYUVERllHdkNhdzBQMWVsdkNjbmZnbHlDSHdJREFRQUI=", 0), r108);
        Intrinsics.checkNotNullParameter(r109, "data");
        Intrinsics.checkNotNullParameter(r110, "senderPublicKey");
        Intrinsics.checkNotNullParameter(r103, "sign");
        byte[] r111 = Base64.decode(r110, 0);     // Catch: Throwable -> L20
        KeyFactory r112 = KeyFactory.getInstance(d.f25615a);     // Catch: Throwable -> L20
        if (r112 == null) goto L13;
        PublicKey r113 = r112.generatePublic(new X509EncodedKeySpec(r111));     // Catch: Throwable -> L20
        if (r113 == null) goto L12;
        RSAPublicKey r114 = (RSAPublicKey) r113;     // Catch: Throwable -> L20
    L14:
        if (r114 != null) goto L16;
        boolean r115 = false;
    L17:
        if (r115 == false) goto L23;
        return true;
    L23:
        return false;
    L16:
        Signature r116 = Signature.getInstance(RSAUtil.SIGNATURE_ALGORITHM);
        r116.initVerify(r114);
        r116.update(r109.getBytes(Charsets.UTF_8));
        r115 = r116.verify(Base64.decode(r103, 0));
        goto L17
    L12:
        throw new NullPointerException("null cannot be cast to non-null type java.security.interfaces.RSAPublicKey");     // Catch: Throwable -> L20
    L13:
        r114 = null;
        goto L14
    L22:
        return false;
    }
}
