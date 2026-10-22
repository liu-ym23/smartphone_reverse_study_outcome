package d.l;

import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;

/* JADX INFO: compiled from: Progressions.kt */
/* JADX INFO: loaded from: classes4.dex */
public class a implements d.h.b.a.a, Iterable<Character> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C1041a f38519a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final char f38520b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final char f38521c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f38522d;

    /* JADX INFO: renamed from: d.l.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: Progressions.kt */
    public static final class C1041a {
        public /* synthetic */ C1041a(d.h.b.h r1) {
            this();
        }

        private C1041a() {
        }
    }

    static {
        f38519a = new C1041a(null);
    }

    public a(char r2, char r3, int r4) {
        if (r4 == 0) goto L11;
        if (r4 == Integer.MIN_VALUE) goto L9;
        this.f38520b = r2;
        this.f38521c = (char) d.e.c.a(r2, r3, r4);
        this.f38522d = r4;
        return;
    L9:
        throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
    L11:
        throw new IllegalArgumentException("Step must be non-zero.");
    }

    @Override // java.lang.Iterable
    public /* synthetic */ Iterator<Character> iterator() {
        return (Iterator) ZeusTransformUtils.preCheckCast(c(), Iterator.class, "com.obric.aiagent.plugin");
    }

    public final char a() {
        return this.f38520b;
    }

    public final char b() {
        return this.f38521c;
    }

    public d.a.o c() {
        return (d.a.o) ZeusTransformUtils.preCheckCast(new b(this.f38520b, this.f38521c, this.f38522d), d.a.o.class, "com.obric.aiagent.plugin");
    }

    public boolean d() {
        if (this.f38522d <= 0) goto L8;
        if (d.h.b.o.a(this.f38520b, this.f38521c) <= 0) goto L11;
        return true;
    L11:
        return false;
    L8:
        if (d.h.b.o.a(this.f38520b, this.f38521c) >= 0) goto L11;
        return true;
    }

    public boolean equals(Object r5) {
        if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L5;
    L15:
        return false;
    L5:
        if (d() == false) goto L9;
        if (((a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin")).d() == false) goto L9;
    L14:
        return true;
    L9:
        if (this.f38520b != ((a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin")).f38520b) goto L15;
        if (this.f38521c != ((a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin")).f38521c) goto L15;
        if (this.f38522d != ((a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin")).f38522d) goto L15;
        goto L14
    }

    public int hashCode() {
        if (d() == false) goto L5;
        return -1;
    L5:
        int r0 = ((this.f38520b * 31) + this.f38521c) * 31;
        return this.f38522d + r0;
    }

    public String toString() {
        if (this.f38522d <= 0) goto L5;
        StringBuilder r0 = new StringBuilder().append(this.f38520b).append(DownloadConstants.VULNERABILITY_PATH).append(this.f38521c).append(" step ");
        int r3 = this.f38522d;
    L7:
        return r0.append(r3).toString();
    L5:
        r0 = new StringBuilder().append(this.f38520b).append(" downTo ").append(this.f38521c).append(" step ");
        r3 = -this.f38522d;
        goto L7
    }
}
