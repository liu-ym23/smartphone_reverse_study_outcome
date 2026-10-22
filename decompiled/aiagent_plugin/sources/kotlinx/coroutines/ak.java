package kotlinx.coroutines;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: CoroutineContext.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class ak extends d.c.a implements cy<String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f38839a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f38840b;

    /* JADX INFO: compiled from: CoroutineContext.kt */
    public static final class a implements d.c.g.c<ak> {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    static {
        f38839a = new a(null);
    }

    public boolean equals(Object r7) {
        if (this != r7) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r7, ak.class) == true) goto L8;
        return false;
    L8:
        ak r8 = (ak) ZeusTransformUtils.preCheckCast(r7, ak.class, "com.obric.aiagent.plugin");
        if (this.f38840b == r8.f38840b) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        return Long.hashCode(this.f38840b);
    }

    @Override // kotlinx.coroutines.cy
    public /* synthetic */ void a(d.c.g r3, String r4) {
        a2((d.c.g) ZeusTransformUtils.wrapperContextForParams(r3, d.c.g.class, "com.obric.aiagent.plugin"), (String) ZeusTransformUtils.preCheckCast(r4, String.class, "com.obric.aiagent.plugin"));
    }

    @Override // kotlinx.coroutines.cy
    public /* synthetic */ String b(d.c.g r3) {
        return a((d.c.g) ZeusTransformUtils.wrapperContextForParams(r3, d.c.g.class, "com.obric.aiagent.plugin"));
    }

    public final long a() {
        return this.f38840b;
    }

    public ak(long r4) {
        super((d.c.g.c) ZeusTransformUtils.preCheckCast(f38839a, d.c.g.c.class, "com.obric.aiagent.plugin"));
        this.f38840b = r4;
    }

    public String toString() {
        return "CoroutineId(" + this.f38840b + ')';
    }

    public String a(d.c.g r10) {
        al r11 = (al) ZeusTransformUtils.preCheckCast(((d.c.g) ZeusTransformUtils.wrapperContextForParams(r10, d.c.g.class, "com.obric.aiagent.plugin")).get((d.c.g.c) ZeusTransformUtils.preCheckCast(al.f38841a, d.c.g.c.class, "com.obric.aiagent.plugin")), al.class, "com.obric.aiagent.plugin");
        if (r11 == null) goto L6;
        String r12 = r11.a();
        if (r12 == null) goto L6;
    L7:
        Thread r0 = Thread.currentThread();
        String r2 = r0.getName();
        int r1 = d.o.o.b((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.aiagent.plugin"), " @", 0, false, 6, null);
        if (r1 >= 0) goto L10;
        r1 = r2.length();
    L10:
        StringBuilder r4 = new StringBuilder((r12.length() + r1) + 10);
        String r3 = r2.substring(0, r1);
        d.h.b.o.c(r3, "substring(...)");
        r4.append(r3);
        r4.append(" @");
        r4.append(r12);
        r4.append('#');
        r4.append(this.f38840b);
        String r9 = r4.toString();
        d.h.b.o.c(r9, "toString(...)");
        r0.setName(r9);
        return r2;
    L6:
        r12 = "coroutine";
        goto L7
    }

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    public void a2(d.c.g r2, String r3) {
        d.c.g r1 = (d.c.g) ZeusTransformUtils.wrapperContextForParams(r2, d.c.g.class, "com.obric.aiagent.plugin");
        Thread.currentThread().setName(r3);
    }
}
