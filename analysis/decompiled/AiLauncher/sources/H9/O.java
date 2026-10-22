package H9;

import E9.AbstractC0811p;
import E9.InterfaceC0803h;
import E9.b0;
import E9.i0;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import io.modelcontextprotocol.spec.McpSchema;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.a;
import kotlin.reflect.jvm.internal.impl.descriptors.e;

/* loaded from: classes5.dex */
public class O extends AbstractC0839s implements kotlin.reflect.jvm.internal.impl.descriptors.g {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public O(InterfaceC0803h interfaceC0803h, kotlin.reflect.jvm.internal.impl.descriptors.g gVar, F9.g gVar2, ga.e eVar, CallableMemberDescriptor.Kind kind, E9.W w10) {
        super(interfaceC0803h, gVar, gVar2, eVar, kind, w10);
        if (interfaceC0803h == null) {
            T(0);
        }
        if (gVar2 == null) {
            T(1);
        }
        if (eVar == null) {
            T(2);
        }
        if (kind == null) {
            T(3);
        }
        if (w10 == null) {
            T(4);
        }
    }

    private static /* synthetic */ void T(int i10) {
        String str = (i10 == 13 || i10 == 18 || i10 == 23 || i10 == 24 || i10 == 29 || i10 == 30) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i10 == 13 || i10 == 18 || i10 == 23 || i10 == 24 || i10 == 29 || i10 == 30) ? 2 : 3];
        switch (i10) {
            case 1:
            case 6:
            case 27:
                objArr[0] = "annotations";
                break;
            case 2:
            case 7:
                objArr[0] = "name";
                break;
            case 3:
            case 8:
            case 26:
                objArr[0] = "kind";
                break;
            case 4:
            case 9:
            case 28:
                objArr[0] = "source";
                break;
            case 5:
            default:
                objArr[0] = "containingDeclaration";
                break;
            case 10:
            case 15:
            case 20:
                objArr[0] = "typeParameters";
                break;
            case 11:
            case 16:
            case 21:
                objArr[0] = "unsubstitutedValueParameters";
                break;
            case 12:
            case 17:
            case 22:
                objArr[0] = "visibility";
                break;
            case 13:
            case 18:
            case 23:
            case 24:
            case 29:
            case 30:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/SimpleFunctionDescriptorImpl";
                break;
            case 14:
            case 19:
                objArr[0] = "contextReceiverParameters";
                break;
            case 25:
                objArr[0] = "newOwner";
                break;
        }
        if (i10 == 13 || i10 == 18 || i10 == 23) {
            objArr[1] = McpSchema.METHOD_INITIALIZE;
        } else if (i10 == 24) {
            objArr[1] = "getOriginal";
        } else if (i10 == 29) {
            objArr[1] = ChatTracker.CLICK_COPY;
        } else if (i10 != 30) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/SimpleFunctionDescriptorImpl";
        } else {
            objArr[1] = "newCopyBuilder";
        }
        switch (i10) {
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                objArr[2] = "create";
                break;
            case 10:
            case 11:
            case 12:
            case 14:
            case 15:
            case 16:
            case 17:
            case 19:
            case 20:
            case 21:
            case 22:
                objArr[2] = McpSchema.METHOD_INITIALIZE;
                break;
            case 13:
            case 18:
            case 23:
            case 24:
            case 29:
            case 30:
                break;
            case 25:
            case 26:
            case 27:
            case 28:
                objArr[2] = "createSubstitutedCopy";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        if (i10 != 13 && i10 != 18 && i10 != 23 && i10 != 24 && i10 != 29 && i10 != 30) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    public static O f1(InterfaceC0803h interfaceC0803h, F9.g gVar, ga.e eVar, CallableMemberDescriptor.Kind kind, E9.W w10) {
        if (interfaceC0803h == null) {
            T(5);
        }
        if (gVar == null) {
            T(6);
        }
        if (eVar == null) {
            T(7);
        }
        if (kind == null) {
            T(8);
        }
        if (w10 == null) {
            T(9);
        }
        return new O(interfaceC0803h, null, gVar, eVar, kind, w10);
    }

    @Override // H9.AbstractC0839s
    public AbstractC0839s F0(InterfaceC0803h interfaceC0803h, kotlin.reflect.jvm.internal.impl.descriptors.e eVar, CallableMemberDescriptor.Kind kind, ga.e eVar2, F9.g gVar, E9.W w10) {
        if (interfaceC0803h == null) {
            T(25);
        }
        if (kind == null) {
            T(26);
        }
        if (gVar == null) {
            T(27);
        }
        if (w10 == null) {
            T(28);
        }
        kotlin.reflect.jvm.internal.impl.descriptors.g gVar2 = (kotlin.reflect.jvm.internal.impl.descriptors.g) eVar;
        if (eVar2 == null) {
            eVar2 = getName();
        }
        return new O(interfaceC0803h, gVar2, gVar, eVar2, kind, w10);
    }

    @Override // H9.AbstractC0839s, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
    /* renamed from: e1 */
    public kotlin.reflect.jvm.internal.impl.descriptors.g y(InterfaceC0803h interfaceC0803h, Modality modality, AbstractC0811p abstractC0811p, CallableMemberDescriptor.Kind kind, boolean z10) {
        kotlin.reflect.jvm.internal.impl.descriptors.g gVar = (kotlin.reflect.jvm.internal.impl.descriptors.g) super.y(interfaceC0803h, modality, abstractC0811p, kind, z10);
        if (gVar == null) {
            T(29);
        }
        return gVar;
    }

    @Override // H9.AbstractC0839s, H9.AbstractC0835n
    /* renamed from: g1, reason: merged with bridge method [inline-methods] */
    public kotlin.reflect.jvm.internal.impl.descriptors.g a() {
        kotlin.reflect.jvm.internal.impl.descriptors.g gVar = (kotlin.reflect.jvm.internal.impl.descriptors.g) super.a();
        if (gVar == null) {
            T(24);
        }
        return gVar;
    }

    @Override // H9.AbstractC0839s
    /* renamed from: h1, reason: merged with bridge method [inline-methods] */
    public O L0(E9.S s10, E9.S s11, List<E9.S> list, List<? extends b0> list2, List<i0> list3, ya.S s12, Modality modality, AbstractC0811p abstractC0811p) {
        if (list == null) {
            T(14);
        }
        if (list2 == null) {
            T(15);
        }
        if (list3 == null) {
            T(16);
        }
        if (abstractC0811p == null) {
            T(17);
        }
        O oI1 = i1(s10, s11, list, list2, list3, s12, modality, abstractC0811p, null);
        if (oI1 == null) {
            T(18);
        }
        return oI1;
    }

    public O i1(E9.S s10, E9.S s11, List<E9.S> list, List<? extends b0> list2, List<i0> list3, ya.S s12, Modality modality, AbstractC0811p abstractC0811p, Map<? extends a.InterfaceC0437a<?>, ?> map) {
        if (list == null) {
            T(19);
        }
        if (list2 == null) {
            T(20);
        }
        if (list3 == null) {
            T(21);
        }
        if (abstractC0811p == null) {
            T(22);
        }
        super.L0(s10, s11, list, list2, list3, s12, modality, abstractC0811p);
        if (map != null && !map.isEmpty()) {
            this.f3164D = new LinkedHashMap(map);
        }
        return this;
    }

    @Override // H9.AbstractC0839s, kotlin.reflect.jvm.internal.impl.descriptors.e, kotlin.reflect.jvm.internal.impl.descriptors.g
    public e.a<? extends kotlin.reflect.jvm.internal.impl.descriptors.g> s() {
        e.a aVarS = super.s();
        if (aVarS == null) {
            T(30);
        }
        return aVarS;
    }
}
