package af4;

import com.bytedance.sdk.xbridge.cn.protocol.MethodFinder;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class a extends MethodFinder {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final HashMap<String, IDLXBridgeMethod> f3171e = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, IDLXBridgeMethod> f3172d;

    /* JADX INFO: renamed from: af4.a$a, reason: collision with other inner class name */
    public static final class C0059a {
    }

    @Override // com.bytedance.sdk.xbridge.cn.protocol.MethodFinder
    public final String f() {
        return "xbridge3";
    }

    static {
        f3171e = new HashMap();
    }

    public a(int r100) {
        this.f3172d = null;
    }

    @Override // com.bytedance.sdk.xbridge.cn.protocol.MethodFinder
    public final IDLXBridgeMethod h(String r100) {
        Intrinsics.checkNotNullParameter(r100, "methodName");
        HashMap<String, IDLXBridgeMethod> r101 = f3171e;     // Catch: Throwable -> L15
        if (r101.containsKey(r100) == true) goto L6;
        Map<String, IDLXBridgeMethod> r102 = this.f3172d;     // Catch: Throwable -> L15
        if (r102 != null) goto L10;
        return null;
    L10:
        if (r102.containsKey(r100) == true) goto L12;
        return null;
    L12:
        return this.f3172d.get(r100);
    L6:
        return r101.get(r100);
    L18:
        return null;
    }
}
