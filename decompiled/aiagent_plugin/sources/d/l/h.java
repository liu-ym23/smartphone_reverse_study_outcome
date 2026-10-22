package d.l;

import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.al;
import java.util.Iterator;

/* JADX INFO: compiled from: Progressions.kt */
/* JADX INFO: loaded from: classes4.dex */
public class h implements d.h.b.a.a, Iterable<Integer> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f38533a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f38534b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f38535c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f38536d;

    /* JADX INFO: compiled from: Progressions.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }

        public final h a(int r1, int r2, int r3) {
            return new h(r1, r2, r3);
        }
    }

    static {
        f38533a = new a(null);
    }

    public h(int r2, int r3, int r4) {
        if (r4 == 0) goto L11;
        if (r4 == Integer.MIN_VALUE) goto L9;
        this.f38534b = r2;
        this.f38535c = d.e.c.a(r2, r3, r4);
        this.f38536d = r4;
        return;
    L9:
        throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
    L11:
        throw new IllegalArgumentException("Step must be non-zero.");
    }

    @Override // java.lang.Iterable
    public /* synthetic */ Iterator<Integer> iterator() {
        return (Iterator) ZeusTransformUtils.preCheckCast(e(), Iterator.class, "com.obric.aiagent.plugin");
    }

    public final int a() {
        return this.f38534b;
    }

    public final int b() {
        return this.f38535c;
    }

    public final int c() {
        return this.f38536d;
    }

    public al e() {
        return (al) ZeusTransformUtils.preCheckCast(new i(this.f38534b, this.f38535c, this.f38536d), al.class, "com.obric.aiagent.plugin");
    }

    public boolean d() {
        if (this.f38536d <= 0) goto L8;
        if (this.f38534b <= this.f38535c) goto L11;
        return true;
    L11:
        return false;
    L8:
        if (this.f38534b >= this.f38535c) goto L11;
        return true;
    }

    public boolean equals(Object r5) {
        if (ZeusTransformUtils.instanceOf(r5, h.class) == true) goto L5;
    L15:
        return false;
    L5:
        if (d() == false) goto L9;
        if (((h) ZeusTransformUtils.preCheckCast(r5, h.class, "com.obric.aiagent.plugin")).d() == false) goto L9;
    L14:
        return true;
    L9:
        if (this.f38534b != ((h) ZeusTransformUtils.preCheckCast(r5, h.class, "com.obric.aiagent.plugin")).f38534b) goto L15;
        if (this.f38535c != ((h) ZeusTransformUtils.preCheckCast(r5, h.class, "com.obric.aiagent.plugin")).f38535c) goto L15;
        if (this.f38536d != ((h) ZeusTransformUtils.preCheckCast(r5, h.class, "com.obric.aiagent.plugin")).f38536d) goto L15;
        goto L14
    }

    public int hashCode() {
        if (d() == false) goto L5;
        return -1;
    L5:
        int r0 = ((this.f38534b * 31) + this.f38535c) * 31;
        return this.f38536d + r0;
    }

    public String toString() {
        if (this.f38536d <= 0) goto L5;
        StringBuilder r0 = new StringBuilder().append(this.f38534b).append(DownloadConstants.VULNERABILITY_PATH).append(this.f38535c).append(" step ");
        int r3 = this.f38536d;
    L7:
        return r0.append(r3).toString();
    L5:
        r0 = new StringBuilder().append(this.f38534b).append(" downTo ").append(this.f38535c).append(" step ");
        r3 = -this.f38536d;
        goto L7
    }
}
