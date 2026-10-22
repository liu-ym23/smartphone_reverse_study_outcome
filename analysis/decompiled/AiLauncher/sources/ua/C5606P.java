package ua;

import E9.AbstractC0811p;
import E9.C0810o;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$MemberKind;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Visibility;

/* renamed from: ua.P, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C5606P {

    /* renamed from: ua.P$a */
    public static final /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f42573a;

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f42574b;

        /* renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ int[] f42575c;

        static {
            int[] iArr = new int[ProtoBuf$MemberKind.values().length];
            try {
                iArr[ProtoBuf$MemberKind.DECLARATION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ProtoBuf$MemberKind.FAKE_OVERRIDE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ProtoBuf$MemberKind.DELEGATION.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ProtoBuf$MemberKind.SYNTHESIZED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f42573a = iArr;
            int[] iArr2 = new int[CallableMemberDescriptor.Kind.values().length];
            try {
                iArr2[CallableMemberDescriptor.Kind.DECLARATION.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[CallableMemberDescriptor.Kind.FAKE_OVERRIDE.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[CallableMemberDescriptor.Kind.DELEGATION.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr2[CallableMemberDescriptor.Kind.SYNTHESIZED.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            f42574b = iArr2;
            int[] iArr3 = new int[ProtoBuf$Visibility.values().length];
            try {
                iArr3[ProtoBuf$Visibility.INTERNAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr3[ProtoBuf$Visibility.PRIVATE.ordinal()] = 2;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr3[ProtoBuf$Visibility.PRIVATE_TO_THIS.ordinal()] = 3;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr3[ProtoBuf$Visibility.PROTECTED.ordinal()] = 4;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr3[ProtoBuf$Visibility.PUBLIC.ordinal()] = 5;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr3[ProtoBuf$Visibility.LOCAL.ordinal()] = 6;
            } catch (NoSuchFieldError unused14) {
            }
            f42575c = iArr3;
        }
    }

    public static final AbstractC0811p a(C5605O c5605o, ProtoBuf$Visibility protoBuf$Visibility) {
        kotlin.jvm.internal.p.i(c5605o, "<this>");
        switch (protoBuf$Visibility == null ? -1 : a.f42575c[protoBuf$Visibility.ordinal()]) {
            case 1:
                AbstractC0811p INTERNAL = C0810o.f2472d;
                kotlin.jvm.internal.p.h(INTERNAL, "INTERNAL");
                return INTERNAL;
            case 2:
                AbstractC0811p PRIVATE = C0810o.f2469a;
                kotlin.jvm.internal.p.h(PRIVATE, "PRIVATE");
                return PRIVATE;
            case 3:
                AbstractC0811p PRIVATE_TO_THIS = C0810o.f2470b;
                kotlin.jvm.internal.p.h(PRIVATE_TO_THIS, "PRIVATE_TO_THIS");
                return PRIVATE_TO_THIS;
            case 4:
                AbstractC0811p PROTECTED = C0810o.f2471c;
                kotlin.jvm.internal.p.h(PROTECTED, "PROTECTED");
                return PROTECTED;
            case 5:
                AbstractC0811p PUBLIC = C0810o.f2473e;
                kotlin.jvm.internal.p.h(PUBLIC, "PUBLIC");
                return PUBLIC;
            case 6:
                AbstractC0811p LOCAL = C0810o.f2474f;
                kotlin.jvm.internal.p.h(LOCAL, "LOCAL");
                return LOCAL;
            default:
                AbstractC0811p PRIVATE2 = C0810o.f2469a;
                kotlin.jvm.internal.p.h(PRIVATE2, "PRIVATE");
                return PRIVATE2;
        }
    }

    public static final CallableMemberDescriptor.Kind b(C5605O c5605o, ProtoBuf$MemberKind protoBuf$MemberKind) {
        kotlin.jvm.internal.p.i(c5605o, "<this>");
        int i10 = protoBuf$MemberKind == null ? -1 : a.f42573a[protoBuf$MemberKind.ordinal()];
        return i10 != 1 ? i10 != 2 ? i10 != 3 ? i10 != 4 ? CallableMemberDescriptor.Kind.DECLARATION : CallableMemberDescriptor.Kind.SYNTHESIZED : CallableMemberDescriptor.Kind.DELEGATION : CallableMemberDescriptor.Kind.FAKE_OVERRIDE : CallableMemberDescriptor.Kind.DECLARATION;
    }
}
