package n4;

import C7.f;
import D7.q;
import android.content.Context;
import android.content.pm.Signature;
import android.content.pm.SigningInfo;
import com.fasterxml.jackson.core.json.ByteSourceJsonBootstrapper;
import java.security.MessageDigest;
import kotlin.jvm.internal.k;

/* renamed from: n4.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC1740a {
    public static volatile Context b;

    /* renamed from: a, reason: collision with root package name */
    public static final byte[] f5347a = {43, 84, 121, -92, -99, 58, 91, 28, -125, -103, -13, -38, -23, -100, 4, -43, 39, -57, 54, 44, -6, 118, 6, 58, 65, 32, -56, ByteSourceJsonBootstrapper.UTF8_BOM_1, -35, 108, -72, 123, 111, 50, 16, -51, 90, -42};
    public static final f c = kotlin.a.a(new com.uxsense.parse.a(28));

    public static byte[] a() {
        Signature[] apkContentsSigners;
        Signature signature;
        Context context = b;
        if (context == null) {
            throw new IllegalStateException("ApiConfigs.init(context) not called");
        }
        SigningInfo signingInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 134217728).signingInfo;
        if (signingInfo == null || (apkContentsSigners = signingInfo.getApkContentsSigners()) == null || (signature = (Signature) q.n0(apkContentsSigners)) == null) {
            throw new IllegalStateException("no signing certificate available");
        }
        byte[] bArrDigest = MessageDigest.getInstance("SHA-256").digest(signature.toByteArray());
        k.e(bArrDigest, "digest(...)");
        return bArrDigest;
    }
}
