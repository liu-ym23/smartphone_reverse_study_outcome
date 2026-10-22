package com.bytedance.android.annie.xbridge.mix;

import com.bytedance.ies.bullet.service.base.bridge.IBridgeMethod;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/annie/xbridge/mix/IStatefulToXBridge;", "Lcom/bytedance/android/annie/xbridge/mix/BaseA2BBridgeMethod;", "annie_release"}, k = 1, mv = {1, 4, 3})
public abstract class IStatefulToXBridge extends BaseA2BBridgeMethod {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ConcurrentLinkedQueue<com.bytedance.ies.web.jsbridge2.f<Object, Object>> f40132c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile com.bytedance.ies.web.jsbridge2.f<Object, Object> f40133d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public IBridgeMethod.Access f40134e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final IBridgeMethod.Access f40135f;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f40136a = null;

        static {
            int[] r100 = new int[PermissionGroup.values().length];
            r100[PermissionGroup.PRIVATE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r100[PermissionGroup.PROTECTED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r100[PermissionGroup.PUBLIC.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r100[PermissionGroup.SECURE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            f40136a = r100;
        }
    }

    public abstract com.bytedance.ies.web.jsbridge2.f<?, ?> b(m16.b r100);

    @Override // com.bytedance.ies.bullet.core.kit.bridge.j, com.bytedance.ies.bullet.service.base.i0
    public final void release() {
        Iterator<T> r100 = this.f40132c.iterator();
    L4:
        if (r100.hasNext() == false) goto L8;
        com.bytedance.ies.web.jsbridge2.f r101 = (com.bytedance.ies.web.jsbridge2.f) r100.next();
        if (r101 == null) goto L4;
        r101.terminateActualProxy();
        goto L4
    L8:
        this.f40132c.clear();
        com.bytedance.ies.web.jsbridge2.f<Object, Object> r102 = this.f40133d;
        if (r102 == null) goto L11;
        r102.terminateActualProxy();
    L11:
        this.f40133d = null;
    }

    @Override // com.bytedance.ies.bullet.core.kit.bridge.j, com.bytedance.ies.bullet.service.base.bridge.a
    public final IBridgeMethod.Access getAccess() {
        return this.f40135f;
    }

    public IStatefulToXBridge(m16.b r100) {
        Intrinsics.checkNotNullParameter(r100, "contextProviderFactory");
        super(r100);
        this.f40132c = new ConcurrentLinkedQueue();
        IBridgeMethod.Access r101 = this.f40134e;
        if (r101 != null) goto L27;
        this.f40133d = b(this.f246554a);
        com.bytedance.ies.web.jsbridge2.f<Object, Object> r102 = this.f40133d;
        if (r102 == null) goto L7;
        PermissionGroup r103 = r102.getPermission();
    L8:
        if (r103 != null) goto L10;
        int r104 = -1;
    L12:
        if (r104 != 1) goto L14;
        r101 = IBridgeMethod.Access.PRIVATE;
    L24:
        this.f40134e = r101;
        if (r101 != null) goto L27;
        r101 = IBridgeMethod.Access.PRIVATE;
        goto L27
    L14:
        if (r104 != 2) goto L16;
        r101 = IBridgeMethod.Access.PROTECT;
        goto L24
    L16:
        if (r104 != 3) goto L18;
        r101 = IBridgeMethod.Access.PUBLIC;
        goto L24
    L18:
        if (r104 == 4) goto L20;
        r101 = IBridgeMethod.Access.PRIVATE;
        goto L24
    L20:
        r101 = IBridgeMethod.Access.SECURE;
        goto L24
    L10:
        r104 = a.f40136a[r103.ordinal()];
        goto L12
    L7:
        r103 = null;
    L27:
        this.f40135f = r101;
    }

    @Override // com.bytedance.android.annie.xbridge.mix.BaseA2BBridgeMethod
    public final void a(JSONObject r100, BaseA2BBridgeMethod.b r101) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "iReturn");
        com.bytedance.ies.web.jsbridge2.f<?, ?> r102 = this.f40133d;
        if (r102 != null) goto L5;
        r102 = b(this.f246554a);
    L5:
        this.f40133d = null;
        if (r102 != null) goto L20;
        r101.onFailed(new Throwable("stateful method null"));
    L20:
        CallContext r103 = b.a(this.f246554a);     // Catch: Throwable -> L17
        this.f40132c.add(r102);     // Catch: Throwable -> L17
        if (r102 == null) goto L11;
        g r104 = new g(this);     // Catch: Throwable -> L17
        Intrinsics.checkNotNullParameter(r104, "callBack");     // Catch: Throwable -> L17
        Intrinsics.checkNotNullParameter(r103, "callContext");     // Catch: Throwable -> L17
        Intrinsics.checkNotNullParameter(r101, "iReturn");     // Catch: Throwable -> L17
        r102.setProxy(new h(r103, r101, r104, r102));     // Catch: Throwable -> L17
    L11:
        if (r102 == null) goto L21;
        c.a r105 = c.f40160a;     // Catch: Throwable -> L17
        Intrinsics.checkNotNullParameter(r100, "params");     // Catch: Throwable -> L17
        Intrinsics.checkNotNullParameter(r102, PickerReporterConstants.KEY.TARGET);     // Catch: Throwable -> L17
        Type r106 = r102.getClass().getGenericSuperclass();     // Catch: Throwable -> L17
        if (r106 == null) goto L16;
        r102.invokeProxy(c.b(r100, ((ParameterizedType) r106).getActualTypeArguments()[0]), r103);     // Catch: Throwable -> L17
        return;
    L16:
        throw new IllegalStateException("Method is not parameterized?!");     // Catch: Throwable -> L17
    L21:
        return;
    L17:
        th = move-exception;
        th.printStackTrace();
        r101.onFailed(new Throwable("stateful handle error: " + th.getMessage()));
    }
}
