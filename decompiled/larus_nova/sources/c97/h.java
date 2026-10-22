package c97;

import android.text.TextUtils;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import java.io.File;

/* JADX INFO: loaded from: classes21.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient File f22881a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f22882b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public transient File f22883c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f22884d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f22885e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public transient File f22886f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f22887g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f22888h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f22889i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f22890j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f22891k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f22892l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f22893m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f22894n;

    public final h a() {
        h r100 = new h();
        r100.f22881a = this.f22881a;
        r100.f22882b = this.f22882b;
        r100.f22883c = this.f22883c;
        r100.f22884d = this.f22884d;
        r100.f22885e = this.f22885e;
        r100.f22886f = this.f22886f;
        r100.f22887g = this.f22887g;
        r100.f22890j = this.f22890j;
        r100.f22888h = this.f22888h;
        r100.f22889i = this.f22889i;
        r100.f22891k = this.f22891k;
        r100.f22892l = this.f22892l;
        r100.f22893m = this.f22893m;
        r100.f22894n = this.f22894n;
        return r100;
    }

    public final int hashCode() {
        return TTVideoEngineInterface.PLAYER_OPTION_ABR_STALL_PENALTY_PARAMETER + this.f22887g.hashCode();
    }

    public final String toString() {
        return "{issueId = " + this.f22888h + ", patchId = " + this.f22890j + ", md5 = " + this.f22887g + ", hostAppVersion = " + this.f22891k + ", isAsyncLoad = " + this.f22892l + ", isSupportSubProcess = " + this.f22893m + ", installPath = " + w87.d.a(this.f22881a) + ", hasJavaPatch = " + this.f22882b + ", hasSoLibraries = " + this.f22884d + com.alipay.sdk.m.u.i.f25855d;
    }

    public h() {
        this.f22885e = false;
        this.f22892l = true;
        this.f22894n = false;
    }

    public final boolean equals(Object r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if ((r100 instanceof h) == true) goto L8;
        return false;
    L8:
        h r101 = (h) r100;
        if (w87.b.e(this.f22881a, r101.f22881a) == true) goto L11;
        return false;
    L11:
        if (this.f22882b == r101.f22882b) goto L13;
        return false;
    L13:
        if (w87.b.e(this.f22883c, r101.f22883c) == true) goto L15;
        return false;
    L15:
        if (this.f22884d == r101.f22884d) goto L17;
        return false;
    L17:
        if (w87.b.e(this.f22886f, r101.f22886f) == true) goto L19;
        return false;
    L19:
        if (TextUtils.equals(this.f22887g, r101.f22887g) == true) goto L21;
        return false;
    L21:
        if (TextUtils.equals(this.f22890j, r101.f22890j) == true) goto L23;
        return false;
    L23:
        if (TextUtils.equals(this.f22888h, r101.f22888h) == true) goto L25;
        return false;
    L25:
        if (TextUtils.equals(this.f22889i, r101.f22889i) == true) goto L27;
        return false;
    L27:
        if (TextUtils.equals(this.f22891k, r101.f22891k) == true) goto L29;
        return false;
    L29:
        if (this.f22892l == r101.f22892l) goto L31;
        return false;
    L31:
        if (this.f22893m != r101.f22893m) goto L45;
        return true;
    L45:
        return false;
    }
}
