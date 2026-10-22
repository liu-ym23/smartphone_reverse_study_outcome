package kotlin.reflect.jvm.internal;

import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\b\u0084\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"kotlin/reflect/jvm/internal/KDeclarationContainerImpl$MemberBelonginess", "", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl$MemberBelonginess;", "kotlin-reflection"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class KDeclarationContainerImpl$MemberBelonginess {

    /* renamed from: a, reason: collision with root package name */
    public static final KDeclarationContainerImpl$MemberBelonginess f4938a;
    public static final KDeclarationContainerImpl$MemberBelonginess b;
    public static final /* synthetic */ KDeclarationContainerImpl$MemberBelonginess[] c;

    static {
        KDeclarationContainerImpl$MemberBelonginess kDeclarationContainerImpl$MemberBelonginess = new KDeclarationContainerImpl$MemberBelonginess("DECLARED", 0);
        f4938a = kDeclarationContainerImpl$MemberBelonginess;
        KDeclarationContainerImpl$MemberBelonginess kDeclarationContainerImpl$MemberBelonginess2 = new KDeclarationContainerImpl$MemberBelonginess("INHERITED", 1);
        b = kDeclarationContainerImpl$MemberBelonginess2;
        KDeclarationContainerImpl$MemberBelonginess[] kDeclarationContainerImpl$MemberBelonginessArr = {kDeclarationContainerImpl$MemberBelonginess, kDeclarationContainerImpl$MemberBelonginess2};
        c = kDeclarationContainerImpl$MemberBelonginessArr;
        kotlin.enums.a.a(kDeclarationContainerImpl$MemberBelonginessArr);
    }

    public static KDeclarationContainerImpl$MemberBelonginess valueOf(String str) {
        return (KDeclarationContainerImpl$MemberBelonginess) Enum.valueOf(KDeclarationContainerImpl$MemberBelonginess.class, str);
    }

    public static KDeclarationContainerImpl$MemberBelonginess[] values() {
        return (KDeclarationContainerImpl$MemberBelonginess[]) c.clone();
    }
}
