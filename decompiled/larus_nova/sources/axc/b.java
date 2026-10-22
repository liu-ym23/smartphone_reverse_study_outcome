package axc;

import android.os.Bundle;
import com.ss.android.downloadlib.addownload.compliance.ComplianceResult;

/* JADX INFO: loaded from: classes41.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f16656a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f16657b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f16658c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f16659d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f16660e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String[] f16661f;

    public b(Bundle r100) {
        this.f16656a = r100.getString("positiveButton");
        this.f16657b = r100.getString("negativeButton");
        this.f16660e = r100.getString("rationaleMsg");
        this.f16658c = r100.getInt("theme");
        this.f16659d = r100.getInt("requestCode");
        this.f16661f = r100.getStringArray(ComplianceResult.JsonKey.PERMISSIONS);
    }
}
