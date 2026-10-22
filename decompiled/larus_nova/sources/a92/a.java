package a92;

import androidx.camera.video.AudioStats;
import com.bytedance.android.livesdkapi.model.CropSeiData;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import org.json.JSONArray;
import org.json.JSONObject;
import z82.f;
import z82.g;

/* JADX INFO: loaded from: classes9.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f2267a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f2268b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f2269c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f2270d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final g f2271e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final z82.a f2272f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L18;
        a r101 = (a) r100;
        if (this.f2267a == r101.f2267a) goto L8;
        return false;
    L8:
        if (this.f2268b == r101.f2268b) goto L10;
        return false;
    L10:
        if (this.f2269c == r101.f2269c) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f2270d, r101.f2270d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f2271e, r101.f2271e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f2272f, r101.f2272f) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v2, types: [int] */
    public final int hashCode() {
        int r100 = ((this.f2267a * 31) + this.f2268b) * 31;
        boolean r101 = this.f2269c;
        ?? r102 = r101;
        if (r101 == false) goto L5;
        r102 = 1;
    L5:
        int r103 = (r100 + r102) * 31;
        String r104 = this.f2270d;
        int r105 = 0;
        if (r104 == null) goto L8;
        int r106 = r104.hashCode();
    L9:
        int r107 = (r103 + r106) * 31;
        g r108 = this.f2271e;
        if (r108 == null) goto L12;
        int r109 = r108.hashCode();
    L13:
        int r110 = (r107 + r109) * 31;
        z82.a r111 = this.f2272f;
        if (r111 == null) goto L17;
        r105 = r111.hashCode();
    L17:
        return r110 + r105;
    L12:
        r109 = 0;
        goto L13
    L8:
        r106 = 0;
        goto L9
    }

    public final String toString() {
        return "TransferParam(parentW=" + this.f2267a + ", parentH=" + this.f2268b + ", isFullScreen=" + this.f2269c + ", sei=" + this.f2270d + ", statusBarOption=" + this.f2271e + ", components=" + this.f2272f + ")";
    }

    public final Float a() {
        JSONArray r100 = f.b(this.f2270d);
        if (r100 != null) goto L5;
        return null;
    L5:
        double r101 = f.f(r100);
        double r102 = f.c(r100);
        if (r101 > AudioStats.AUDIO_AMPLITUDE_NONE) goto L8;
        return null;
    L8:
        if (r102 <= AudioStats.AUDIO_AMPLITUDE_NONE) goto L34;
        CropSeiData r103 = f.a(this.f2270d);
        if (r103 == null) goto L17;
        Pair r104 = TuplesKt.to(Integer.valueOf(r103.cropW), Integer.valueOf(r103.cropH));
        int r105 = ((Number) r104.component1()).intValue();
        int r106 = ((Number) r104.component2()).intValue();
        if (r105 == 0) goto L17;
        if (r106 == 0) goto L17;
        return Float.valueOf(((float) (((double) r105) * r101)) / ((float) (((double) r106) * r102)));
    L17:
        String r107 = this.f2270d;
        Intrinsics.checkNotNullParameter(r107, "sei");
        JSONObject r108 = f.g(r107);
        if (r108 != null) goto L21;
    L19:
        Pair r109 = null;
    L24:
        if (r109 != null) goto L26;
        r109 = TuplesKt.to(0, 0);
    L26:
        int r110 = ((Number) r109.component1()).intValue();
        int r111 = ((Number) r109.component2()).intValue();
        if (r110 == 0) goto L33;
        if (r111 != 0) goto L31;
        return null;
    L31:
        return Float.valueOf(((float) (((double) r110) * r101)) / ((float) (((double) r111) * r102)));
    L33:
        return null;
    L21:
        if (r108.has("app_data") == false) goto L19;
        JSONObject r112 = new JSONObject(new JSONObject(new Regex("\\\\").replace(JSONObjectProtectorUtils.getString(r108, "app_data"), "")).optString("canvas"));
        r109 = TuplesKt.to(Integer.valueOf(r112.optInt("width")), Integer.valueOf(r112.optInt("height")));
        goto L24
    L34:
        return null;
    }

    public a(int r100, int r101, String r102, g r103, z82.a r104) {
        Intrinsics.checkNotNullParameter(r102, "sei");
        Intrinsics.checkNotNullParameter(r103, "statusBarOption");
        this.f2267a = r100;
        this.f2268b = r101;
        this.f2269c = true;
        this.f2270d = r102;
        this.f2271e = r103;
        this.f2272f = r104;
    }
}
