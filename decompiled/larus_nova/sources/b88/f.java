package b88;

import aw3.o0;
import com.larus.platform.api.k4;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes24.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f18200a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f18201b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final k4 f18202c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final JSONObject f18203d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f18204e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f18205f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f18206g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f18207h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f18208i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Function1<String, Unit> f18209j;

    public f() {
        throw null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L8;
        return false;
    L8:
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.f18200a, r101.f18200a) == true) goto L12;
        return false;
    L12:
        if (this.f18201b == r101.f18201b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f18202c, r101.f18202c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f18203d, r101.f18203d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f18204e, r101.f18204e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f18205f, r101.f18205f) == true) goto L27;
        return false;
    L27:
        if (this.f18206g == r101.f18206g) goto L30;
        return false;
    L30:
        if (this.f18207h == r101.f18207h) goto L33;
        return false;
    L33:
        if (this.f18208i == r101.f18208i) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f18209j, r101.f18209j) == true) goto L38;
        return false;
    L38:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((((((this.f18200a.hashCode() * 31) + this.f18201b) * 31) + this.f18202c.hashCode()) * 31) + this.f18203d.hashCode()) * 31) + this.f18204e.hashCode()) * 31) + this.f18205f.hashCode()) * 31;
        int r101 = 1231;
        if (this.f18206g == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.f18207h == false) goto L9;
        int r104 = 1231;
    L10:
        int r105 = (r103 + r104) * 31;
        if (this.f18208i == true) goto L14;
        r101 = 1237;
    L14:
        int r106 = (r105 + r101) * 31;
        Function1<String, Unit> r107 = this.f18209j;
        if (r107 != null) goto L17;
        int r108 = 0;
    L19:
        return r106 + r108;
    L17:
        r108 = r107.hashCode();
        goto L19
    L9:
        r104 = 1237;
        goto L10
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "UrlAudioPlayerConfig(url=" + this.f18200a + ", sourceType=" + this.f18201b + ", mediaScene=" + this.f18202c + ", traceInfo=" + this.f18203d + ", focusScene=" + this.f18204e + ", globalAudioScene=" + this.f18205f + ", reportGlobalPlayTriggeredOnFocusSuccess=" + this.f18206g + ", reportGlobalErrorOnPlayerError=" + this.f18207h + ", requestAudioFocusOnPlay=" + this.f18208i + ", onRequireAudioFocusFailure=" + this.f18209j + ')';
    }

    public f(String r100, int r101, k4 r102, JSONObject r103, String r110, String r111, o0 r112, int r113) {
        if ((r113 & 8) == 0) goto L5;
        r103 = new JSONObject();
    L5:
        boolean r104 = true;
        if ((r113 & 64) == 0) goto L8;
        boolean r105 = true;
    L10:
        if ((r113 & 128) == 0) goto L12;
        boolean r106 = true;
    L14:
        if ((r113 & 256) != 0) goto L18;
        r104 = false;
    L18:
        if ((r113 & 512) == 0) goto L20;
        r112 = null;
    L20:
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r102, "mediaScene");
        Intrinsics.checkNotNullParameter(r103, "traceInfo");
        Intrinsics.checkNotNullParameter(r110, "focusScene");
        Intrinsics.checkNotNullParameter(r111, "globalAudioScene");
        this.f18200a = r100;
        this.f18201b = r101;
        this.f18202c = r102;
        this.f18203d = r103;
        this.f18204e = r110;
        this.f18205f = r111;
        this.f18206g = r105;
        this.f18207h = r106;
        this.f18208i = r104;
        this.f18209j = r112;
        return;
    L12:
        r106 = false;
        goto L14
    L8:
        r105 = false;
        goto L10
    }
}
