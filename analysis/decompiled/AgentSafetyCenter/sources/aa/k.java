package aa;

import com.stepos.policy.sdk.util.ReadClipboardUtils;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class k implements InvocationHandler {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f329a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f330b;

    public /* synthetic */ k(int i) {
        this.f329a = i;
    }

    @Override // java.lang.reflect.InvocationHandler
    public final Object invoke(Object obj, Method method, Object[] objArr) {
        int i = this.f329a;
        Object obj2 = this.f330b;
        switch (i) {
            case 0:
                n nVar = (n) obj2;
                if (yb.k.a(method.getName(), "providePath")) {
                    return nVar.f337h;
                }
                if (yb.k.a(method.getName(), "hashCode")) {
                    return Integer.valueOf(System.identityHashCode(obj));
                }
                boolean z10 = false;
                if (yb.k.a(method.getName(), "equals")) {
                    if (objArr != null && objArr.length != 0 && objArr[0] == obj) {
                        z10 = true;
                    }
                    return Boolean.valueOf(z10);
                }
                if (yb.k.a(method.getName(), "toString")) {
                    return "GlyphPathProvider";
                }
                if (method.getReturnType().isArray()) {
                    return Array.newInstance(method.getReturnType().getComponentType(), 0);
                }
                return null;
            default:
                return ReadClipboardUtils.lambda$injectClipboardManager$1(obj2, obj, method, objArr);
        }
    }
}
