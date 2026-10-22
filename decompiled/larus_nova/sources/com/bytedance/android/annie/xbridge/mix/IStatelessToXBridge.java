package com.bytedance.android.annie.xbridge.mix;

import com.bytedance.ies.bullet.service.base.bridge.IBridgeMethod;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/annie/xbridge/mix/IStatelessToXBridge;", "Lcom/bytedance/android/annie/xbridge/mix/BaseA2BBridgeMethod;", "annie_release"}, k = 1, mv = {1, 4, 3})
public abstract class IStatelessToXBridge extends BaseA2BBridgeMethod {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.bytedance.ies.web.jsbridge2.g<Object, Object> f40137c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f40138d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final IBridgeMethod.Access f40139e;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f40140a = null;

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
            f40140a = r100;
        }
    }

    public abstract com.bytedance.ies.web.jsbridge2.g<?, ?> b(m16.b r100);

    @Override // com.bytedance.ies.bullet.core.kit.bridge.j, com.bytedance.ies.bullet.service.base.i0
    public final void release() {
    }

    @Override // com.bytedance.ies.bullet.core.kit.bridge.j, com.bytedance.ies.bullet.service.base.bridge.a
    public final IBridgeMethod.Access getAccess() {
        return this.f40139e;
    }

    @Override // com.bytedance.android.annie.xbridge.mix.BaseA2BBridgeMethod, com.bytedance.ies.bullet.service.base.bridge.a
    public final boolean i90() {
        return this.f40138d;
    }

    public IStatelessToXBridge(m16.b r100) {
        Intrinsics.checkNotNullParameter(r100, "contextProviderFactory");
        super(r100);
        this.f40138d = true;
        if (this.f40137c != null) goto L5;
        this.f40137c = b(this.f246554a);
    L5:
        com.bytedance.ies.web.jsbridge2.g<Object, Object> r101 = this.f40137c;
        if (r101 == null) goto L8;
        PermissionGroup r102 = r101.getPermission();
    L9:
        if (r102 != null) goto L11;
        int r103 = -1;
    L12:
        if (r103 != 1) goto L14;
        IBridgeMethod.Access r104 = IBridgeMethod.Access.PRIVATE;
    L24:
        this.f40139e = r104;
        return;
    L14:
        if (r103 != 2) goto L16;
        r104 = IBridgeMethod.Access.PROTECT;
        goto L24
    L16:
        if (r103 != 3) goto L18;
        r104 = IBridgeMethod.Access.PUBLIC;
        goto L24
    L18:
        if (r103 == 4) goto L20;
        r104 = IBridgeMethod.Access.PRIVATE;
        goto L24
    L20:
        r104 = IBridgeMethod.Access.SECURE;
        goto L24
    L11:
        r103 = a.f40140a[r102.ordinal()];
        goto L12
    L8:
        r102 = null;
        goto L9
    }

    @Override // com.bytedance.android.annie.xbridge.mix.BaseA2BBridgeMethod
    public final void a(JSONObject r100, BaseA2BBridgeMethod.b r101) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "iReturn");
        if (this.f40137c != null) goto L6;
        this.f40137c = b(this.f246554a);
    L6:
        if (this.f40137c != null) goto L18;
        r101.onFailed(new Throwable("stateless method null"));
    L18:
        com.bytedance.ies.web.jsbridge2.g<Object, Object> r102 = this.f40137c;     // Catch: Throwable -> L15
        if (r102 == null) goto L19;
        Intrinsics.checkNotNullParameter(r101, "iReturn");     // Catch: Throwable -> L15
        r102.setProxy(new i(r101));     // Catch: Throwable -> L15
        c.a r103 = c.f40160a;     // Catch: Throwable -> L15
        Intrinsics.checkNotNullParameter(r100, "params");     // Catch: Throwable -> L15
        Intrinsics.checkNotNullParameter(r102, PickerReporterConstants.KEY.TARGET);     // Catch: Throwable -> L15
        Type r104 = r102.getClass().getGenericSuperclass();     // Catch: Throwable -> L15
        if (r104 == null) goto L14;
        r101.b(r102.invoke(c.b(r100, ((ParameterizedType) r104).getActualTypeArguments()[0]), b.a(this.f246554a)));     // Catch: Throwable -> L15
        return;
    L14:
        throw new IllegalStateException("Method is not parameterized?!");     // Catch: Throwable -> L15
    L19:
        return;
    L15:
        th = move-exception;
        th.printStackTrace();
        r101.onFailed(new Throwable("stateless handle error: " + th.getMessage()));
    }
}
