package d;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: UInt.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class u implements Comparable<u> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f38689a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f38690b;

    /* JADX INFO: compiled from: UInt.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    static {
        f38689a = new a(null);
    }

    public static boolean a(int r3, Object r4) {
        if (ZeusTransformUtils.instanceOf(r4, u.class) == true) goto L6;
        return false;
    L6:
        if (r3 == ((u) ZeusTransformUtils.preCheckCast(r4, u.class, "com.obric.aiagent.plugin")).a()) goto L8;
        return false;
    L8:
        return true;
    }

    public static int b(int r0) {
        return Integer.hashCode(r0);
    }

    public static int c(int r0) {
        return r0;
    }

    public final /* synthetic */ int a() {
        return this.f38690b;
    }

    public boolean equals(Object r1) {
        return a(this.f38690b, r1);
    }

    public int hashCode() {
        return b(this.f38690b);
    }

    @Override // java.lang.Comparable
    public /* synthetic */ int compareTo(u r3) {
        int r4 = ((u) ZeusTransformUtils.preCheckCast(r3, u.class, "com.obric.aiagent.plugin")).a();
        return z.a(a(), r4);
    }

    public static String a(int r4) {
        return String.valueOf(((long) r4) & 4294967295L);
    }

    public String toString() {
        return a(this.f38690b);
    }
}
