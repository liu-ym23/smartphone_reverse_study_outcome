package kotlinx.coroutines;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: CoroutineStart.kt */
/* JADX INFO: loaded from: classes4.dex */
public final enum ao extends Enum<ao> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ao f38851a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ao f38852b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ao f38853c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ao f38854d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final /* synthetic */ ao[] f38855e = null;
    private static final /* synthetic */ d.d.a f = null;

    /* JADX INFO: compiled from: CoroutineStart.kt */
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f38856a = null;

        static {
            int[] r0 = new int[ao.values().length];
            r0[ao.f38851a.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[ao.f38853c.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[ao.f38854d.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[ao.f38852b.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            f38856a = r0;
        }
    }

    private static final /* synthetic */ ao[] b() {
        return new ao[]{f38851a, f38852b, f38853c, f38854d};
    }

    public static ao valueOf(String r2) {
        return (ao) ZeusTransformUtils.preCheckCast(Enum.valueOf(ao.class, r2), ao.class, "com.obric.aiagent.plugin");
    }

    public static ao[] values() {
        return (ao[]) ZeusTransformUtils.preCheckCast(f38855e.clone(), ao[].class, "com.obric.aiagent.plugin");
    }

    private ao(String r1, int r2) {
        super(r1, r2);
    }

    static {
        f38851a = new ao("DEFAULT", 0);
        f38852b = new ao("LAZY", 1);
        f38853c = new ao("ATOMIC", 2);
        f38854d = new ao("UNDISPATCHED", 3);
        ao[] r0 = b();
        f38855e = r0;
        f = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }

    public final <R, T> void a(d.h.a.m<? super R, ? super d.c.d<? super T>, ? extends Object> r9, R r10, d.c.d<? super T> r11) {
        d.h.a.m r2 = (d.h.a.m) ZeusTransformUtils.wrapperContextForParams(r9, d.h.a.m.class, "com.obric.aiagent.plugin");
        d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r11, d.c.d.class, "com.obric.aiagent.plugin");
        int r8 = a.f38856a[ordinal()];
        if (r8 != 1) goto L5;
        kotlinx.coroutines.c.a.a(r2, r10, r4, null, 4, null);
        return;
    L5:
        if (r8 != 2) goto L7;
        d.c.f.a(r2, r10, r4);
        return;
    L7:
        if (r8 != 3) goto L9;
        kotlinx.coroutines.c.b.a(r2, r10, r4);
        return;
    L9:
        if (r8 != 4) goto L12;
        return;
    L12:
        throw new d.k();
    }

    public final boolean a() {
        if (this != f38852b) goto L5;
        return true;
    L5:
        return false;
    }
}
