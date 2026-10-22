package kotlinx.coroutines;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: JobSupport.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class cj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final kotlinx.coroutines.internal.al f39202a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final kotlinx.coroutines.internal.al f39203b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final kotlinx.coroutines.internal.al f39204c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final kotlinx.coroutines.internal.al f39205d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final kotlinx.coroutines.internal.al f39206e = null;
    private static final bi f = null;
    private static final bi g = null;

    public static final /* synthetic */ bi a() {
        return g;
    }

    public static final /* synthetic */ bi b() {
        return f;
    }

    public static final /* synthetic */ kotlinx.coroutines.internal.al c() {
        return f39203b;
    }

    public static final /* synthetic */ kotlinx.coroutines.internal.al d() {
        return f39205d;
    }

    public static final /* synthetic */ kotlinx.coroutines.internal.al e() {
        return f39204c;
    }

    public static final /* synthetic */ kotlinx.coroutines.internal.al f() {
        return f39206e;
    }

    public static final Object a(Object r3) {
        if (ZeusTransformUtils.instanceOf(r3, bu.class) == true) goto L5;
        return r3;
    L5:
        return new bv((bu) ZeusTransformUtils.preCheckCast(r3, bu.class, "com.obric.aiagent.plugin"));
    }

    public static final Object b(Object r2) {
        if (ZeusTransformUtils.instanceOf(r2, bv.class) == false) goto L5;
        bv r0 = (bv) ZeusTransformUtils.preCheckCast(r2, bv.class, "com.obric.aiagent.plugin");
    L6:
        if (r0 == null) goto L12;
        bu r1 = r0.f39171a;
        if (r1 != null) goto L11;
        return r2;
    L11:
        return r1;
    L12:
        return r2;
    L5:
        r0 = null;
        goto L6
    }

    static {
        f39203b = new kotlinx.coroutines.internal.al("COMPLETING_ALREADY");
        f39202a = new kotlinx.coroutines.internal.al("COMPLETING_WAITING_CHILDREN");
        f39204c = new kotlinx.coroutines.internal.al("COMPLETING_RETRY");
        f39205d = new kotlinx.coroutines.internal.al("TOO_LATE_TO_CANCEL");
        f39206e = new kotlinx.coroutines.internal.al("SEALED");
        f = new bi(false);
        g = new bi(true);
    }
}
