package com.bytedance.android.annie.bridge.method.permission;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import com.bytedance.android.annie.bridge.method.abs.OpenPermissionSettingsParamModel;
import com.bytedance.android.annie.bridge.method.abs.OpenPermissionSettingsResultModel;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.ss.android.downloadlib.addownload.compliance.ComplianceResult;
import com.ss.android.lark.utils.statistics.PerfLog;
import e7.o;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@XBridgeMethod(biz = "webcast", name = "openPermissionSettings")
public final class OpenPermissionSettingsMethod extends o<OpenPermissionSettingsParamModel, OpenPermissionSettingsResultModel> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Lifecycle.Event f38748a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Context f38749b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Permission f38750c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f38751d;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f38752a = null;

        static {
            int[] r100 = new int[Permission.values().length];
            r100[Permission.PHOTOALBUM.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L15:
            r100[Permission.WRITE_PHOTOALBUM.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L23:
            r100[Permission.READ_PHOTOALBUM.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L17:
            r100[Permission.NOTIFICATION.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L19:
            r100[Permission.LOCATION.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L8:
            f38752a = r100;
        }
    }

    public OpenPermissionSettingsMethod() {
        this.f38751d = LazyKt.lazy(new OpenPermissionSettingsMethod$lifeCycleMonitorListener$2(this));
    }

    public static PermissionStatus j(Context r100, Permission r101) {
        int[] r102 = a.f38752a;
        int r103 = r102[r101.ordinal()];
        if (r103 == 4) goto L66;
        boolean r104 = true;
        if (r103 == 5) goto L53;
        int r105 = r102[r101.ordinal()];
        if (r105 != 1) goto L9;
        List<String> r106 = c.c();
    L17:
        if (r106.size() != 1) goto L21;
        String r107 = (String) CollectionsKt.first(r106);
        if (r107 == null) goto L31;
        boolean r108 = c.a(r100, r107);
    L33:
        Map<String, c.b> r109 = c.f38773a;
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r106, ComplianceResult.JsonKey.PERMISSIONS);
        if ((r100 instanceof Activity) == false) goto L36;
        Activity r110 = (Activity) r100;
    L37:
        if (r110 == null) goto L47;
        Iterator<T> r111 = r106.iterator();
    L41:
        if (r111.hasNext() == false) goto L47;
        String r112 = (String) r111.next();
        if (r112 == null) goto L41;
        if (ActivityCompat.shouldShowRequestPermissionRationale(r110, r112) == true) goto L41;
    L48:
        if (r108 == true) goto L82;
        if (r104 == false) goto L84;
        return PermissionStatus.DENIED;
    L84:
        return PermissionStatus.UNDETERMINED;
    L82:
        return PermissionStatus.PERMITTED;
    L47:
        r104 = false;
        goto L48
    L36:
        r110 = null;
    L31:
        r108 = false;
        goto L33
    L21:
        Map<String, c.b> r113 = c.f38773a;
        Intrinsics.checkNotNullParameter(r106, ComplianceResult.JsonKey.PERMISSIONS);
        if (r100 == null) goto L31;
        Iterator<String> r114 = r106.iterator();
    L26:
        if (r114.hasNext() == false) goto L32;
        String r115 = r114.next();
        if (r115 == null) goto L26;
        if (ContextCompat.checkSelfPermission(r100, r115) != (-1)) goto L26;
    L32:
        r108 = true;
        goto L33
    L9:
        if (r105 != 2) goto L11;
        r106 = c.f();
        goto L17
    L11:
        if (r105 == 3) goto L13;
        r106 = r101.getPermission();
        goto L17
    L13:
        r106 = c.d();
        goto L17
    L53:
        Map<String, c.b> r116 = c.f38773a;
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (c.i(r100) == false) goto L85;
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (ContextCompat.checkSelfPermission(r100, "android.permission.ACCESS_COARSE_LOCATION") != (-1)) goto L59;
    L61:
        r104 = false;
    L62:
        if (r104 == false) goto L87;
        return PermissionStatus.PERMITTED;
    L87:
        return PermissionStatus.DENIED;
    L59:
        if (ContextCompat.checkSelfPermission(r100, "android.permission.ACCESS_FINE_LOCATION") == (-1)) goto L61;
    L85:
        return PermissionStatus.DENIED;
    L66:
        if (c.g(r100) == false) goto L69;
        return PermissionStatus.PERMITTED;
    L69:
        return PermissionStatus.UNDETERMINED;
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        OpenPermissionSettingsParamModel r102 = (OpenPermissionSettingsParamModel) r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        OpenPermissionSettingsParamModel.Permission r103 = r102.a();
        if (r103 != null) goto L5;
        OpenPermissionSettingsResultModel r104 = new OpenPermissionSettingsResultModel();
        r104.a(OpenPermissionSettingsResultModel.Code.InvalidParam);
        r104.b("Illegal permission");
        finishWithResult(r104);
        return;
    L5:
        Permission.a r105 = Permission.Companion;
        String r106 = r103.toString();
        r105.getClass();
        Permission r107 = Permission.a.a(r106);
        this.f38750c = r107;
        this.f38749b = r101.getContext();
        if (r107 != Permission.UNKNOWN) goto L8;
        OpenPermissionSettingsResultModel r108 = new OpenPermissionSettingsResultModel();
        r108.a(OpenPermissionSettingsResultModel.Code.InvalidParam);
        r108.b("Illegal permission");
        finishWithResult(r108);
        return;
    L8:
        PermissionStatus r109 = j(r101.getContext(), r107);
        PermissionStatus r110 = PermissionStatus.PERMITTED;
        if (r109 != r110) goto L19;
        OpenPermissionSettingsResultModel r111 = new OpenPermissionSettingsResultModel();
        r111.a(OpenPermissionSettingsResultModel.Code.Success);
        String r112 = r110.name();
        if (r112 == null) goto L18;
        r111.b(r112.toLowerCase());
        String r113 = r110.name();
        if (r113 == null) goto L16;
        r111.c(r113.toLowerCase());
        finishWithResult(r111);
        return;
    L16:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L18:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L19:
        Context r114 = r101.getContext();
        if ((r114 instanceof FragmentActivity) == false) goto L22;
        FragmentActivity r115 = (FragmentActivity) r114;
    L23:
        if (r115 == null) goto L28;
        Lifecycle r116 = r115.getLifecycle();
        if (r116 == null) goto L28;
        r116.addObserver((LifecycleObserver) this.f38751d.getValue());
    L28:
        if (r107 != Permission.LOCATION) goto L38;
        if (r109 != PermissionStatus.DENIED) goto L38;
        Context r117 = r101.getContext();
        Map<String, c.b> r118 = c.f38773a;
        Intrinsics.checkNotNullParameter(r117, PerfLog.PARAM_KEY_CONTEXT_ID);
        c.b r119 = c.f38773a.get(Build.MANUFACTURER.toLowerCase());
        if (r119 == null) goto L35;
        Intent r120 = r119.c(r117);
        if (r120 == null) goto L35;
    L36:
        r117.startActivity(r120);
        return;
    L35:
        Intrinsics.checkNotNullParameter(r117, PerfLog.PARAM_KEY_CONTEXT_ID);
        r120 = new Intent("android.settings.LOCATION_SOURCE_SETTINGS");
        r120.addFlags(268435456);
    L38:
        if (r107 != Permission.NOTIFICATION) goto L40;
        Context r121 = r101.getContext();
        r121.startActivity(c.b(r121));
        return;
    L40:
        Context r122 = r101.getContext();
        Map<String, c.b> r123 = c.f38773a;
        Intrinsics.checkNotNullParameter(r122, PerfLog.PARAM_KEY_CONTEXT_ID);
        c.b r124 = c.f38773a.get(Build.MANUFACTURER.toLowerCase());
        if (r124 == null) goto L44;
        Intent r125 = r124.a(r122);
        if (r125 == null) goto L44;
    L45:
        r122.startActivity(r125);
        return;
    L44:
        Intrinsics.checkNotNullParameter(r122, PerfLog.PARAM_KEY_CONTEXT_ID);
        r125 = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        r125.addFlags(268435456);
        r125.setData(Uri.fromParts("package", r122.getPackageName(), null));
        goto L45
    L22:
        r115 = null;
        goto L23
    }
}
