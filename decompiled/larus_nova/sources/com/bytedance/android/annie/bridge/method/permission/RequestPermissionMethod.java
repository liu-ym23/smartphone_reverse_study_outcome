package com.bytedance.android.annie.bridge.method.permission;

import android.app.Activity;
import android.content.Context;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import com.bytedance.android.annie.Annie;
import com.bytedance.android.annie.bridge.method.abs.RequestPermissionParamModel;
import com.bytedance.android.annie.bridge.method.abs.RequestPermissionResultModel;
import com.bytedance.android.annie.container.fragment.q;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.ss.android.downloadlib.addownload.compliance.ComplianceResult;
import com.ss.android.lark.utils.statistics.PerfLog;
import e7.w;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@XBridgeMethod(biz = "webcast_sdk", name = "requestPermission")
public final class RequestPermissionMethod extends w<RequestPermissionParamModel, RequestPermissionResultModel> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final q f38765a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Lifecycle.Event f38766b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Context f38767c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f38768d;

    public static final class a implements com.bytedance.android.annie.bridge.method.permission.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RequestPermissionMethod f38769a;

        public a(RequestPermissionMethod r100) {
            this.f38769a = r100;
        }

        @Override // com.bytedance.android.annie.bridge.method.permission.b
        public final void onRequestPermissionsResult(int r100, String[] r101, int[] r102) {
            Intrinsics.checkNotNullParameter(r101, ComplianceResult.JsonKey.PERMISSIONS);
            Intrinsics.checkNotNullParameter(r102, "grantResults");
            if (r100 != 200) goto L10;
            RequestPermissionMethod r103 = this.f38769a;
            RequestPermissionResultModel r104 = new RequestPermissionResultModel();
            r104.a(RequestPermissionResultModel.Code.Success);
            if (com.bytedance.android.annie.bridge.method.permission.c.h(r102) == false) goto L7;
            String r105 = RequestPermissionResultModel.Status.Permitted.toString();
        L8:
            r104.c(r105);
            r104.b("Request Permission Success !");
            r103.finishWithResult(r104);
            return;
        L7:
            r105 = RequestPermissionResultModel.Status.Denied.toString();
            goto L8
        }
    }

    public static final class b {
    }

    public /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f38770a = null;

        static {
            int[] r100 = new int[Permission.values().length];
            r100[Permission.PHOTOALBUM.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[Permission.WRITE_PHOTOALBUM.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[Permission.READ_PHOTOALBUM.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f38770a = r100;
        }
    }

    static {
    }

    public RequestPermissionMethod(m16.b r100) {
        Intrinsics.checkNotNullParameter(r100, "providerFactory");
        q r101 = this.f38765a;
        if (r101 == null) goto L5;
        r101.registerOnRequestPermissionsCallBack(new a(this));
    L5:
        this.f38768d = LazyKt.lazy(new RequestPermissionMethod$lifeCycleMonitorListener$2(this));
        q r102 = (q) r100.c(q.class);
        if (r102 == null) goto L9;
        this.f38765a = r102;
        return;
    }

    public RequestPermissionMethod(q r100) {
        q r101 = this.f38765a;
        if (r101 == null) goto L5;
        r101.registerOnRequestPermissionsCallBack(new a(this));
    L5:
        this.f38768d = LazyKt.lazy(new RequestPermissionMethod$lifeCycleMonitorListener$2(this));
        this.f38765a = r100;
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r110) {
        RequestPermissionParamModel r101 = (RequestPermissionParamModel) r100;
        Intrinsics.checkNotNullParameter(r101, "params");
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f38767c = r110.getContext();
        RequestPermissionParamModel.Permission r102 = r101.a();
        if (r102 != null) goto L5;
        RequestPermissionResultModel r103 = new RequestPermissionResultModel();
        r103.a(RequestPermissionResultModel.Code.InvalidParam);
        r103.b("Illegal permission");
        finishWithResult(r103);
        return;
    L5:
        Permission.a r104 = Permission.Companion;
        String r105 = r102.toString();
        r104.getClass();
        Permission r106 = Permission.a.a(r105);
        if (r106 != Permission.UNKNOWN) goto L8;
        RequestPermissionResultModel r107 = new RequestPermissionResultModel();
        r107.a(RequestPermissionResultModel.Code.InvalidParam);
        r107.b("Illegal permission");
        finishWithResult(r107);
        return;
    L8:
        d r108 = null;
        FragmentActivity r109 = null;
        if (r106 != Permission.NOTIFICATION) goto L21;
        Map<String, com.bytedance.android.annie.bridge.method.permission.c.b> r111 = com.bytedance.android.annie.bridge.method.permission.c.f38773a;
        if (com.bytedance.android.annie.bridge.method.permission.c.g(r110.getContext()) == false) goto L13;
        RequestPermissionResultModel r112 = new RequestPermissionResultModel();
        r112.a(RequestPermissionResultModel.Code.Success);
        RequestPermissionResultModel.Status r113 = RequestPermissionResultModel.Status.Permitted;
        r112.b(r113.toString());
        r112.c(r113.toString());
        finishWithResult(r112);
        return;
    L13:
        Context r114 = r110.getContext();
        if ((r114 instanceof FragmentActivity) == false) goto L16;
        r109 = (FragmentActivity) r114;
    L16:
        if (r109 == null) goto L20;
        Lifecycle r115 = r109.getLifecycle();
        if (r115 == null) goto L20;
        r115.addObserver((LifecycleObserver) this.f38768d.getValue());
    L20:
        Context r116 = r110.getContext();
        r116.startActivity(com.bytedance.android.annie.bridge.method.permission.c.b(r116));
        return;
    L21:
        boolean r117 = false;
        if (r106 != Permission.LOCATION) goto L55;
        Map<String, com.bytedance.android.annie.bridge.method.permission.c.b> r118 = com.bytedance.android.annie.bridge.method.permission.c.f38773a;
        Context r119 = r110.getContext();
        Intrinsics.checkNotNullParameter(r119, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (com.bytedance.android.annie.bridge.method.permission.c.i(r119) == true) goto L26;
        PermissionStatus r120 = PermissionStatus.DENIED;
    L35:
        if (r120 != PermissionStatus.PERMITTED) goto L37;
    L46:
        RequestPermissionResultModel r121 = new RequestPermissionResultModel();
        r121.a(RequestPermissionResultModel.Code.Success);
        String r122 = r120.name();
        if (r122 == null) goto L54;
        r121.c(r122.toLowerCase());
        String r123 = r120.name();
        if (r123 == null) goto L52;
        r121.b(r123.toLowerCase());
        finishWithResult(r121);
        return;
    L52:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L54:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L37:
        if (r120 == PermissionStatus.DENIED) goto L46;
        if ((r110.getContext() instanceof Activity) == true) goto L42;
        return;
    L42:
        if (this.f38765a != null) goto L44;
        e r124 = new e(this, r110);
    L45:
        q9.b r125 = (q9.b) Annie.getService$default(q9.b.class, null, 2, null);
        Context r126 = r110.getContext();
        Intrinsics.checkNotNull(r126, "null cannot be cast to non-null type android.app.Activity");
        r125.n((Activity) r126, this.f38765a, r124, new String[]{"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"});
        return;
    L44:
        r124 = null;
        goto L45
    L26:
        Intrinsics.checkNotNullParameter(r119, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (ContextCompat.checkSelfPermission(r119, "android.permission.ACCESS_COARSE_LOCATION") != (-1)) goto L29;
    L31:
        if (r117 == false) goto L33;
        r120 = PermissionStatus.PERMITTED;
        goto L35
    L33:
        r120 = PermissionStatus.DENIED;
        goto L35
    L29:
        if (ContextCompat.checkSelfPermission(r119, "android.permission.ACCESS_FINE_LOCATION") == (-1)) goto L31;
        r117 = true;
        goto L31
    L55:
        int r127 = c.f38770a[r106.ordinal()];
        if (r127 == 1) goto L63;
        if (r127 != 2) goto L59;
        List<String> r128 = com.bytedance.android.annie.bridge.method.permission.c.f();
    L64:
        q9.b r129 = (q9.b) Annie.getService$default(q9.b.class, null, 2, null);
        Context r130 = r110.getContext();
        List<String> r131 = r128;
        ArrayList r132 = new ArrayList();
        Iterator<T> r133 = r131.iterator();
    L66:
        if (r133.hasNext() == false) goto L70;
        String r134 = (String) r133.next();
        if (r134 == null) goto L66;
        r132.add(r134);
        goto L66
    L70:
        Object[] r135 = r132.toArray(new String[0]);
        if (r135 == null) goto L93;
        String[] r136 = (String[]) r135;
        if (r129.isPermissionAllGranted(r130, (String[]) Arrays.copyOf(r136, r136.length)) == false) goto L75;
        RequestPermissionResultModel r137 = new RequestPermissionResultModel();
        r137.a(RequestPermissionResultModel.Code.Success);
        RequestPermissionResultModel.Status r138 = RequestPermissionResultModel.Status.Permitted;
        r137.c(r138.toString());
        r137.b(r138.toString());
        finishWithResult(r137);
        return;
    L75:
        Context r139 = r110.getContext();
        r110.a();
        if ((r139 instanceof Activity) == false) goto L111;
        q9.b r140 = (q9.b) Annie.getService$default(q9.b.class, null, 2, null);
        q r141 = this.f38765a;
        if (r141 != null) goto L80;
        r108 = new d(this);
    L80:
        Activity r142 = (Activity) r139;
        ArrayList r143 = new ArrayList();
        Iterator<T> r144 = r131.iterator();
    L82:
        if (r144.hasNext() == false) goto L86;
        String r145 = (String) r144.next();
        if (r145 == null) goto L82;
        r143.add(r145);
        goto L82
    L86:
        Object[] r146 = r143.toArray(new String[0]);
        if (r146 == null) goto L90;
        String[] r147 = (String[]) r146;
        r140.n(r142, r141, r108, (String[]) Arrays.copyOf(r147, r147.length));
        return;
    L90:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    L111:
        return;
    L93:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    L59:
        if (r127 == 3) goto L61;
        r128 = r106.getPermission();
        goto L64
    L61:
        r128 = com.bytedance.android.annie.bridge.method.permission.c.d();
        goto L64
    L63:
        r128 = com.bytedance.android.annie.bridge.method.permission.c.c();
        goto L64
    }
}
