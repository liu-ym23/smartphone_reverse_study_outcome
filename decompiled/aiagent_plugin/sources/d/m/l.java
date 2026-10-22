package d.m;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: KVisibility.kt */
/* JADX INFO: loaded from: classes4.dex */
public final enum l extends Enum<l> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final l f38555a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final l f38556b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final l f38557c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final l f38558d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final /* synthetic */ l[] f38559e = null;
    private static final /* synthetic */ d.d.a f = null;

    private static final /* synthetic */ l[] a() {
        return new l[]{f38555a, f38556b, f38557c, f38558d};
    }

    public static l valueOf(String r2) {
        return (l) ZeusTransformUtils.preCheckCast(Enum.valueOf(l.class, r2), l.class, "com.obric.aiagent.plugin");
    }

    public static l[] values() {
        return (l[]) ZeusTransformUtils.preCheckCast(f38559e.clone(), l[].class, "com.obric.aiagent.plugin");
    }

    private l(String r1, int r2) {
        super(r1, r2);
    }

    static {
        f38555a = new l("PUBLIC", 0);
        f38556b = new l("PROTECTED", 1);
        f38557c = new l("INTERNAL", 2);
        f38558d = new l("PRIVATE", 3);
        l[] r0 = a();
        f38559e = r0;
        f = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }
}
