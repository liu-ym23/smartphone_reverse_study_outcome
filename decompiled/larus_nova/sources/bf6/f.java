package bf6;

import com.bytedance.lego.init.model.InitPeriod;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class f implements Comparable<f> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f18824a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f18825b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d f18826c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f18827d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f18828e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<String> f18829f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final float f18830g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final List<String> f18831h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final List<String> f18832i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final List<String> f18833j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public volatile InitPeriod f18834k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public volatile long f18835l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public volatile boolean f18836m;

    public final String toString() {
        return this.f18830g + "," + this.f18824a + "," + this.f18827d;
    }

    public f() {
        this.f18830g = 0.0f;
    }

    @Override // java.lang.Comparable
    public final int compareTo(f r100) {
        f r101 = r100;
        float r102 = r101.f18830g - this.f18830g;
        if (r102 <= 0.0f) goto L6;
        return 1;
    L6:
        if (r102 >= 0.0f) goto L9;
        return -1;
    L9:
        return this.f18825b.compareTo(r101.f18825b);
    }

    public f(String r100, float r101, List r102, List r103, List r104, List r105, InitPeriod r106) {
        this.f18830g = 0.0f;
        this.f18824a = r100;
        this.f18827d = true;
        this.f18829f = r102;
        this.f18830g = r101;
        this.f18831h = r103;
        this.f18832i = r104;
        this.f18833j = r105;
        this.f18825b = "init_shceduler_internal_task";
        this.f18834k = r106;
        this.f18828e = false;
    }

    public f(String r100, boolean r101, boolean r102, float r103, List<String> r104, List<String> r105, List<String> r106, List<String> r107, String r110, d r111, InitPeriod r112) {
        this.f18830g = 0.0f;
        this.f18824a = r100;
        this.f18827d = r101;
        this.f18829f = r104;
        this.f18830g = r103;
        this.f18831h = r105;
        this.f18832i = r106;
        this.f18833j = r107;
        this.f18825b = r110;
        this.f18826c = r111;
        this.f18834k = r112;
        this.f18828e = r102;
    }
}
