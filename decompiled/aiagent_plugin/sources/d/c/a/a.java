package d.c.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: Intrinsics.kt */
/* JADX INFO: loaded from: classes4.dex */
public final enum a extends Enum<a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f38396a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f38397b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f38398c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final /* synthetic */ a[] f38399d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final /* synthetic */ d.d.a f38400e = null;

    private static final /* synthetic */ a[] a() {
        return new a[]{f38396a, f38397b, f38398c};
    }

    public static a valueOf(String r2) {
        return (a) ZeusTransformUtils.preCheckCast(Enum.valueOf(a.class, r2), a.class, "com.obric.aiagent.plugin");
    }

    public static a[] values() {
        return (a[]) ZeusTransformUtils.preCheckCast(f38399d.clone(), a[].class, "com.obric.aiagent.plugin");
    }

    private a(String r1, int r2) {
        super(r1, r2);
    }

    static {
        f38396a = new a("COROUTINE_SUSPENDED", 0);
        f38397b = new a("UNDECIDED", 1);
        f38398c = new a("RESUMED", 2);
        a[] r0 = a();
        f38399d = r0;
        f38400e = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }
}
