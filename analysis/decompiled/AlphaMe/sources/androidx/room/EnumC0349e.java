package androidx.room;

import ch.qos.logback.core.joran.action.ActionConst;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: androidx.room.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class EnumC0349e {

    /* renamed from: a, reason: collision with root package name */
    public static final EnumC0349e f4201a;

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumC0349e[] f4202b;

    /* JADX INFO: Fake field, exist only in values array */
    EnumC0349e EF0;

    static {
        EnumC0349e enumC0349e = new EnumC0349e("ENABLED", 0);
        EnumC0349e enumC0349e2 = new EnumC0349e("DISABLED", 1);
        EnumC0349e enumC0349e3 = new EnumC0349e(ActionConst.INHERITED, 2);
        f4201a = enumC0349e3;
        f4202b = new EnumC0349e[]{enumC0349e, enumC0349e2, enumC0349e3};
    }

    public static EnumC0349e valueOf(String str) {
        return (EnumC0349e) Enum.valueOf(EnumC0349e.class, str);
    }

    public static EnumC0349e[] values() {
        return (EnumC0349e[]) f4202b.clone();
    }
}
