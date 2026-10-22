package androidx.lifecycle;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    public static final m f714a;

    /* renamed from: b, reason: collision with root package name */
    public static final m f715b;

    /* renamed from: c, reason: collision with root package name */
    public static final m f716c;
    public static final m d;

    /* renamed from: e, reason: collision with root package name */
    public static final m f717e;

    /* renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ m[] f718f;

    static {
        m mVar = new m("DESTROYED", 0);
        f714a = mVar;
        m mVar2 = new m("INITIALIZED", 1);
        f715b = mVar2;
        m mVar3 = new m("CREATED", 2);
        f716c = mVar3;
        m mVar4 = new m("STARTED", 3);
        d = mVar4;
        m mVar5 = new m("RESUMED", 4);
        f717e = mVar5;
        f718f = new m[]{mVar, mVar2, mVar3, mVar4, mVar5};
    }

    public static m valueOf(String str) {
        return (m) Enum.valueOf(m.class, str);
    }

    public static m[] values() {
        return (m[]) f718f.clone();
    }
}
