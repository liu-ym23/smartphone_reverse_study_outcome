package kotlin.reflect.jvm.internal.impl.load.java;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes4.dex */
public final class SpecialGenericSignatures$SpecialSignatureInfo {

    /* renamed from: a, reason: collision with root package name */
    public static final SpecialGenericSignatures$SpecialSignatureInfo f4990a;
    public static final SpecialGenericSignatures$SpecialSignatureInfo b;
    public static final SpecialGenericSignatures$SpecialSignatureInfo c;
    public static final /* synthetic */ SpecialGenericSignatures$SpecialSignatureInfo[] d;

    static {
        SpecialGenericSignatures$SpecialSignatureInfo specialGenericSignatures$SpecialSignatureInfo = new SpecialGenericSignatures$SpecialSignatureInfo("ONE_COLLECTION_PARAMETER", 0);
        f4990a = specialGenericSignatures$SpecialSignatureInfo;
        SpecialGenericSignatures$SpecialSignatureInfo specialGenericSignatures$SpecialSignatureInfo2 = new SpecialGenericSignatures$SpecialSignatureInfo("OBJECT_PARAMETER_NON_GENERIC", 1);
        b = specialGenericSignatures$SpecialSignatureInfo2;
        SpecialGenericSignatures$SpecialSignatureInfo specialGenericSignatures$SpecialSignatureInfo3 = new SpecialGenericSignatures$SpecialSignatureInfo("OBJECT_PARAMETER_GENERIC", 2);
        c = specialGenericSignatures$SpecialSignatureInfo3;
        SpecialGenericSignatures$SpecialSignatureInfo[] specialGenericSignatures$SpecialSignatureInfoArr = {specialGenericSignatures$SpecialSignatureInfo, specialGenericSignatures$SpecialSignatureInfo2, specialGenericSignatures$SpecialSignatureInfo3};
        d = specialGenericSignatures$SpecialSignatureInfoArr;
        kotlin.enums.a.a(specialGenericSignatures$SpecialSignatureInfoArr);
    }

    public static SpecialGenericSignatures$SpecialSignatureInfo valueOf(String str) {
        return (SpecialGenericSignatures$SpecialSignatureInfo) Enum.valueOf(SpecialGenericSignatures$SpecialSignatureInfo.class, str);
    }

    public static SpecialGenericSignatures$SpecialSignatureInfo[] values() {
        return (SpecialGenericSignatures$SpecialSignatureInfo[]) d.clone();
    }
}
