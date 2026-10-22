package d;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: Lazy.kt */
/* JADX INFO: loaded from: classes4.dex */
public final enum j extends Enum<j> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j f38505a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final j f38506b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final j f38507c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final /* synthetic */ j[] f38508d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final /* synthetic */ d.d.a f38509e = null;

    private static final /* synthetic */ j[] a() {
        return new j[]{f38505a, f38506b, f38507c};
    }

    public static j valueOf(String r2) {
        return (j) ZeusTransformUtils.preCheckCast(Enum.valueOf(j.class, r2), j.class, "com.obric.aiagent.plugin");
    }

    public static j[] values() {
        return (j[]) ZeusTransformUtils.preCheckCast(f38508d.clone(), j[].class, "com.obric.aiagent.plugin");
    }

    private j(String r1, int r2) {
        super(r1, r2);
    }

    static {
        f38505a = new j("SYNCHRONIZED", 0);
        f38506b = new j("PUBLICATION", 1);
        f38507c = new j("NONE", 2);
        j[] r0 = a();
        f38508d = r0;
        f38509e = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }
}
