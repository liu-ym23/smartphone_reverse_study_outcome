package i8;

import X8.A;
import X8.w;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.agentbus.generated.AgentBusWakeContract;
import h8.InterfaceC1503K;
import h8.InterfaceC1522e;
import java.util.Map;

/* renamed from: i8.c, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1557c implements InterfaceC1556b {

    /* renamed from: a, reason: collision with root package name */
    public final w f4609a;
    public final Map b;
    public final InterfaceC1503K c;

    public C1557c(A a3, Map map, InterfaceC1503K interfaceC1503K) {
        if (a3 == null) {
            c(0);
            throw null;
        }
        if (map == null) {
            c(1);
            throw null;
        }
        this.f4609a = a3;
        this.b = map;
        this.c = interfaceC1503K;
    }

    public static /* synthetic */ void c(int i) {
        String str = (i == 3 || i == 4 || i == 5) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 3 || i == 4 || i == 5) ? 2 : 3];
        if (i == 1) {
            objArr[0] = "valueArguments";
        } else if (i == 2) {
            objArr[0] = AgentBusWakeContract.EXTRA_SOURCE;
        } else if (i == 3 || i == 4 || i == 5) {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/annotations/AnnotationDescriptorImpl";
        } else {
            objArr[0] = "annotationType";
        }
        if (i == 3) {
            objArr[1] = "getType";
        } else if (i == 4) {
            objArr[1] = "getAllValueArguments";
        } else if (i != 5) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/annotations/AnnotationDescriptorImpl";
        } else {
            objArr[1] = "getSource";
        }
        if (i != 3 && i != 4 && i != 5) {
            objArr[2] = AppAgent.CONSTRUCT;
        }
        String str2 = String.format(str, objArr);
        if (i != 3 && i != 4 && i != 5) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    @Override // i8.InterfaceC1556b
    public final Map a() {
        Map map = this.b;
        if (map != null) {
            return map;
        }
        c(4);
        throw null;
    }

    @Override // i8.InterfaceC1556b
    public final G8.c b() {
        InterfaceC1522e interfaceC1522eD = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.d(this);
        if (interfaceC1522eD != null) {
            if (Z8.i.f(interfaceC1522eD)) {
                interfaceC1522eD = null;
            }
            if (interfaceC1522eD != null) {
                return kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.c(interfaceC1522eD);
            }
        }
        return null;
    }

    @Override // i8.InterfaceC1556b
    public final InterfaceC1503K getSource() {
        InterfaceC1503K interfaceC1503K = this.c;
        if (interfaceC1503K != null) {
            return interfaceC1503K;
        }
        c(5);
        throw null;
    }

    @Override // i8.InterfaceC1556b
    public final w getType() {
        w wVar = this.f4609a;
        if (wVar != null) {
            return wVar;
        }
        c(3);
        throw null;
    }

    public final String toString() {
        return I8.g.c.v(this, null);
    }
}
