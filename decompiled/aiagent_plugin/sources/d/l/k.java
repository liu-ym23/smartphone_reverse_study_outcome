package d.l;

import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.am;
import java.util.Iterator;

/* JADX INFO: compiled from: Progressions.kt */
/* JADX INFO: loaded from: classes4.dex */
public class k implements d.h.b.a.a, Iterable<Long> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f38543a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f38544b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f38545c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f38546d;

    /* JADX INFO: compiled from: Progressions.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    static {
        f38543a = new a(null);
    }

    public k(long r3, long r5, long r7) {
        if (r7 == 0) goto L11;
        if (r7 == Long.MIN_VALUE) goto L9;
        this.f38544b = r3;
        this.f38545c = d.e.c.a(r3, r5, r7);
        this.f38546d = r7;
        return;
    L9:
        throw new IllegalArgumentException("Step must be greater than Long.MIN_VALUE to avoid overflow on negation.");
    L11:
        throw new IllegalArgumentException("Step must be non-zero.");
    }

    @Override // java.lang.Iterable
    public /* synthetic */ Iterator<Long> iterator() {
        return (Iterator) ZeusTransformUtils.preCheckCast(c(), Iterator.class, "com.obric.aiagent.plugin");
    }

    public final long a() {
        return this.f38544b;
    }

    public final long b() {
        return this.f38545c;
    }

    public am c() {
        return (am) ZeusTransformUtils.preCheckCast(new l(this.f38544b, this.f38545c, this.f38546d), am.class, "com.obric.aiagent.plugin");
    }

    public boolean d() {
        long r0 = this.f38546d;
        long r3 = this.f38544b;
        long r5 = this.f38545c;
        if (r0 <= 0) goto L6;
        if (r3 <= r5) goto L9;
        return true;
    L9:
        return false;
    L6:
        if (r3 >= r5) goto L9;
        return true;
    }

    public boolean equals(Object r8) {
        if (ZeusTransformUtils.instanceOf(r8, k.class) == true) goto L5;
    L15:
        return false;
    L5:
        if (d() == false) goto L9;
        if (((k) ZeusTransformUtils.preCheckCast(r8, k.class, "com.obric.aiagent.plugin")).d() == false) goto L9;
    L14:
        return true;
    L9:
        if (this.f38544b != ((k) ZeusTransformUtils.preCheckCast(r8, k.class, "com.obric.aiagent.plugin")).f38544b) goto L15;
        if (this.f38545c != ((k) ZeusTransformUtils.preCheckCast(r8, k.class, "com.obric.aiagent.plugin")).f38545c) goto L15;
        if (this.f38546d != ((k) ZeusTransformUtils.preCheckCast(r8, k.class, "com.obric.aiagent.plugin")).f38546d) goto L15;
        goto L14
    }

    public int hashCode() {
        if (d() == false) goto L5;
        return -1;
    L5:
        long r0 = 31;
        long r2 = this.f38544b;
        long r5 = this.f38545c;
        long r1 = r0 * (((r2 ^ (r2 >>> 32)) * r0) + (r5 ^ (r5 >>> 32)));
        long r3 = this.f38546d;
        return (int) (r1 + (r3 ^ (r3 >>> 32)));
    }

    public String toString() {
        if (this.f38546d <= 0) goto L5;
        StringBuilder r0 = new StringBuilder().append(this.f38544b).append(DownloadConstants.VULNERABILITY_PATH).append(this.f38545c).append(" step ");
        long r1 = this.f38546d;
    L7:
        return r0.append(r1).toString();
    L5:
        r0 = new StringBuilder().append(this.f38544b).append(" downTo ").append(this.f38545c).append(" step ");
        r1 = -this.f38546d;
        goto L7
    }
}
