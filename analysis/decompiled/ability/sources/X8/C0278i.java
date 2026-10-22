package X8;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import h8.C1504L;
import h8.InterfaceC1522e;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/* renamed from: X8.i, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0278i extends AbstractC0271b {
    public final k8.y c;
    public final List d;
    public final Collection e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0278i(k8.y yVar, List list, Collection collection, W8.l lVar) {
        super(lVar);
        if (list == null) {
            l(1);
            throw null;
        }
        if (collection == null) {
            l(2);
            throw null;
        }
        if (lVar == null) {
            l(3);
            throw null;
        }
        this.c = yVar;
        this.d = Collections.unmodifiableList(new ArrayList(list));
        this.e = Collections.unmodifiableCollection(collection);
    }

    public static /* synthetic */ void l(int i) {
        String str = (i == 4 || i == 5 || i == 6 || i == 7) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 4 || i == 5 || i == 6 || i == 7) ? 2 : 3];
        switch (i) {
            case 1:
                objArr[0] = "parameters";
                break;
            case 2:
                objArr[0] = "supertypes";
                break;
            case 3:
                objArr[0] = "storageManager";
                break;
            case 4:
            case 5:
            case 6:
            case 7:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/types/ClassTypeConstructorImpl";
                break;
            default:
                objArr[0] = "classDescriptor";
                break;
        }
        if (i == 4) {
            objArr[1] = "getParameters";
        } else if (i == 5) {
            objArr[1] = "getDeclarationDescriptor";
        } else if (i == 6) {
            objArr[1] = "computeSupertypes";
        } else if (i != 7) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/types/ClassTypeConstructorImpl";
        } else {
            objArr[1] = "getSupertypeLoopChecker";
        }
        if (i != 4 && i != 5 && i != 6 && i != 7) {
            objArr[2] = AppAgent.CONSTRUCT;
        }
        String str2 = String.format(str, objArr);
        if (i != 4 && i != 5 && i != 6 && i != 7) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    @Override // X8.AbstractC0275f
    public final Collection b() {
        Collection collection = this.e;
        if (collection != null) {
            return collection;
        }
        l(6);
        throw null;
    }

    @Override // X8.K
    public final boolean f() {
        return true;
    }

    @Override // X8.K
    public final List getParameters() {
        List list = this.d;
        if (list != null) {
            return list;
        }
        l(4);
        throw null;
    }

    @Override // X8.AbstractC0275f
    public final C1504L h() {
        return C1504L.c;
    }

    @Override // X8.AbstractC0271b
    /* renamed from: m */
    public final InterfaceC1522e d() {
        k8.y yVar = this.c;
        if (yVar != null) {
            return yVar;
        }
        l(5);
        throw null;
    }

    public final String toString() {
        String str = J8.e.g(this.c).f689a;
        if (str != null) {
            return str;
        }
        G8.e.a(4);
        throw null;
    }
}
