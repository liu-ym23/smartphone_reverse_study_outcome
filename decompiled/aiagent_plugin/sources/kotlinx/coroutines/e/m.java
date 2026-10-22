package kotlinx.coroutines.e;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: Select.kt */
/* JADX INFO: loaded from: classes4.dex */
public final enum m extends Enum<m> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m f39312a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final m f39313b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final m f39314c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final m f39315d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final /* synthetic */ m[] f39316e = null;
    private static final /* synthetic */ d.d.a f = null;

    private static final /* synthetic */ m[] a() {
        return new m[]{f39312a, f39313b, f39314c, f39315d};
    }

    public static m valueOf(String r2) {
        return (m) ZeusTransformUtils.preCheckCast(Enum.valueOf(m.class, r2), m.class, "com.obric.aiagent.plugin");
    }

    public static m[] values() {
        return (m[]) ZeusTransformUtils.preCheckCast(f39316e.clone(), m[].class, "com.obric.aiagent.plugin");
    }

    private m(String r1, int r2) {
        super(r1, r2);
    }

    static {
        f39312a = new m("SUCCESSFUL", 0);
        f39313b = new m("REREGISTER", 1);
        f39314c = new m("CANCELLED", 2);
        f39315d = new m("ALREADY_SELECTED", 3);
        m[] r0 = a();
        f39316e = r0;
        f = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }
}
