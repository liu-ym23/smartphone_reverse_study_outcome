package kotlinx.coroutines;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: CoroutineName.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class al extends d.c.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f38841a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f38842b;

    /* JADX INFO: compiled from: CoroutineName.kt */
    public static final class a implements d.c.g.c<al> {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    static {
        f38841a = new a(null);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, al.class) == true) goto L8;
        return false;
    L8:
        al r6 = (al) ZeusTransformUtils.preCheckCast(r5, al.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f38842b, r6.f38842b) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        return this.f38842b.hashCode();
    }

    public final String a() {
        return this.f38842b;
    }

    public String toString() {
        return "CoroutineName(" + this.f38842b + ')';
    }
}
