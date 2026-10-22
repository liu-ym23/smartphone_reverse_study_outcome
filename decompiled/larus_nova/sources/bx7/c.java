package bx7;

import com.ivy.ivykit.api.bridge.core.IvyBridgeMethod;
import ex7.d;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes23.dex */
public abstract class c implements IvyBridgeMethod {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public d f21364a;

    public c() {
    }

    @Override // com.ivy.ivykit.api.bridge.core.IvyBridgeMethod
    public void release() {
    }

    @Override // com.ivy.ivykit.api.bridge.core.IvyBridgeMethod
    public IvyBridgeMethod.Access getAccess() {
        return IvyBridgeMethod.Access.PRIVATE;
    }

    @Override // com.ivy.ivykit.api.bridge.core.IvyBridgeMethod
    public final void b(d r100) {
        this.f21364a = r100;
    }

    public final <T> T e(Class<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "clz");
        d r101 = this.f21364a;
        if (r101 != null) goto L7;
        return null;
    L7:
        return (T) r101.a(r100);
    }

    public static void d(c r100, IvyBridgeMethod.a r101, Map r102) {
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "callback");
        Intrinsics.checkNotNullParameter(r102, "data");
        Intrinsics.checkNotNullParameter("", "msg");
        LinkedHashMap r103 = new LinkedHashMap();
        r103.put("code", 1);
        r103.put("msg", "");
        r103.put("data", r102);
        r101.invoke(r103);
    }

    public static void c(c r100, IvyBridgeMethod.a r101, int r102, String r103, int r104) {
        if ((r104 & 4) == 0) goto L6;
        r103 = "";
    L6:
        if ((r104 & 8) == 0) goto L8;
        LinkedHashMap r105 = new LinkedHashMap();
    L9:
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "callback");
        Intrinsics.checkNotNullParameter(r103, "msg");
        Intrinsics.checkNotNullParameter(r105, "data");
        LinkedHashMap r106 = new LinkedHashMap();
        r106.put("code", Integer.valueOf(r102));
        r106.put("msg", r103);
        r106.put("data", r105);
        r101.invoke(r106);
        return;
    L8:
        r105 = null;
        goto L9
    }
}
