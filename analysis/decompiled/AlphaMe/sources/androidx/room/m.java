package androidx.room;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    public static final m f4220a;

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ m[] f4221b;

    /* JADX INFO: Fake field, exist only in values array */
    m EF0;

    static {
        m mVar = new m("FTS3", 0);
        m mVar2 = new m("FTS4", 1);
        f4220a = mVar2;
        f4221b = new m[]{mVar, mVar2};
    }

    public static m valueOf(String str) {
        return (m) Enum.valueOf(m.class, str);
    }

    public static m[] values() {
        return (m[]) f4221b.clone();
    }
}
