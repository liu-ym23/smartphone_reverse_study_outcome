package kotlinx.coroutines.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: BufferOverflow.kt */
/* JADX INFO: loaded from: classes4.dex */
public final enum a extends Enum<a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f38771a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f38772b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f38773c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final /* synthetic */ a[] f38774d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final /* synthetic */ d.d.a f38775e = null;

    private static final /* synthetic */ a[] a() {
        return new a[]{f38771a, f38772b, f38773c};
    }

    public static a valueOf(String r2) {
        return (a) ZeusTransformUtils.preCheckCast(Enum.valueOf(a.class, r2), a.class, "com.obric.aiagent.plugin");
    }

    public static a[] values() {
        return (a[]) ZeusTransformUtils.preCheckCast(f38774d.clone(), a[].class, "com.obric.aiagent.plugin");
    }

    private a(String r1, int r2) {
        super(r1, r2);
    }

    static {
        f38771a = new a("SUSPEND", 0);
        f38772b = new a("DROP_OLDEST", 1);
        f38773c = new a("DROP_LATEST", 2);
        a[] r0 = a();
        f38774d = r0;
        f38775e = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }
}
