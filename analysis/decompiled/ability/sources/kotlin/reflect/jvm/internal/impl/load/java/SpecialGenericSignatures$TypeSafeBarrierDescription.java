package kotlin.reflect.jvm.internal.impl.load.java;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes4.dex */
public class SpecialGenericSignatures$TypeSafeBarrierDescription {
    public static final SpecialGenericSignatures$TypeSafeBarrierDescription b;
    public static final SpecialGenericSignatures$TypeSafeBarrierDescription c;
    public static final SpecialGenericSignatures$TypeSafeBarrierDescription d;
    public static final SpecialGenericSignatures$TypeSafeBarrierDescription e;
    public static final /* synthetic */ SpecialGenericSignatures$TypeSafeBarrierDescription[] f;

    /* renamed from: a, reason: collision with root package name */
    public final Object f4991a;

    public static final class MAP_GET_OR_DEFAULT extends SpecialGenericSignatures$TypeSafeBarrierDescription {
    }

    static {
        SpecialGenericSignatures$TypeSafeBarrierDescription specialGenericSignatures$TypeSafeBarrierDescription = new SpecialGenericSignatures$TypeSafeBarrierDescription("NULL", 0, null);
        b = specialGenericSignatures$TypeSafeBarrierDescription;
        SpecialGenericSignatures$TypeSafeBarrierDescription specialGenericSignatures$TypeSafeBarrierDescription2 = new SpecialGenericSignatures$TypeSafeBarrierDescription("INDEX", 1, -1);
        c = specialGenericSignatures$TypeSafeBarrierDescription2;
        SpecialGenericSignatures$TypeSafeBarrierDescription specialGenericSignatures$TypeSafeBarrierDescription3 = new SpecialGenericSignatures$TypeSafeBarrierDescription("FALSE", 2, Boolean.FALSE);
        d = specialGenericSignatures$TypeSafeBarrierDescription3;
        MAP_GET_OR_DEFAULT map_get_or_default = new MAP_GET_OR_DEFAULT("MAP_GET_OR_DEFAULT", 3, null);
        e = map_get_or_default;
        SpecialGenericSignatures$TypeSafeBarrierDescription[] specialGenericSignatures$TypeSafeBarrierDescriptionArr = {specialGenericSignatures$TypeSafeBarrierDescription, specialGenericSignatures$TypeSafeBarrierDescription2, specialGenericSignatures$TypeSafeBarrierDescription3, map_get_or_default};
        f = specialGenericSignatures$TypeSafeBarrierDescriptionArr;
        kotlin.enums.a.a(specialGenericSignatures$TypeSafeBarrierDescriptionArr);
    }

    public SpecialGenericSignatures$TypeSafeBarrierDescription(String str, int i, Object obj) {
        this.f4991a = obj;
    }

    public static SpecialGenericSignatures$TypeSafeBarrierDescription valueOf(String str) {
        return (SpecialGenericSignatures$TypeSafeBarrierDescription) Enum.valueOf(SpecialGenericSignatures$TypeSafeBarrierDescription.class, str);
    }

    public static SpecialGenericSignatures$TypeSafeBarrierDescription[] values() {
        return (SpecialGenericSignatures$TypeSafeBarrierDescription[]) f.clone();
    }
}
