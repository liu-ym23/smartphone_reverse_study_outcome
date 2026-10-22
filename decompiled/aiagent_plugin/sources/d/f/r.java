package d.f;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: Utils.kt */
/* JADX INFO: loaded from: classes4.dex */
public final enum r extends Enum<r> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final r f38472a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final r f38473b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final /* synthetic */ r[] f38474c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final /* synthetic */ d.d.a f38475d = null;

    private static final /* synthetic */ r[] a() {
        return new r[]{f38472a, f38473b};
    }

    public static r valueOf(String r2) {
        return (r) ZeusTransformUtils.preCheckCast(Enum.valueOf(r.class, r2), r.class, "com.obric.aiagent.plugin");
    }

    public static r[] values() {
        return (r[]) ZeusTransformUtils.preCheckCast(f38474c.clone(), r[].class, "com.obric.aiagent.plugin");
    }

    private r(String r1, int r2) {
        super(r1, r2);
    }

    static {
        f38472a = new r("SKIP", 0);
        f38473b = new r("TERMINATE", 1);
        r[] r0 = a();
        f38474c = r0;
        f38475d = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }
}
