package kotlinx.coroutines.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SharingStarted.kt */
/* JADX INFO: loaded from: classes4.dex */
public final enum af extends Enum<af> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final af f38972a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final af f38973b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final af f38974c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final /* synthetic */ af[] f38975d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final /* synthetic */ d.d.a f38976e = null;

    private static final /* synthetic */ af[] a() {
        return new af[]{f38972a, f38973b, f38974c};
    }

    public static af valueOf(String r2) {
        return (af) ZeusTransformUtils.preCheckCast(Enum.valueOf(af.class, r2), af.class, "com.obric.aiagent.plugin");
    }

    public static af[] values() {
        return (af[]) ZeusTransformUtils.preCheckCast(f38975d.clone(), af[].class, "com.obric.aiagent.plugin");
    }

    private af(String r1, int r2) {
        super(r1, r2);
    }

    static {
        f38972a = new af("START", 0);
        f38973b = new af("STOP", 1);
        f38974c = new af("STOP_AND_RESET_REPLAY_CACHE", 2);
        af[] r0 = a();
        f38975d = r0;
        f38976e = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }
}
