package com.bytedance.android.annie.bridge.method.permission;

import android.content.Context;
import androidx.core.content.ContextCompat;
import com.bytedance.android.annie.bridge.method.abs.CheckPermissionParamModel;
import com.bytedance.android.annie.bridge.method.abs.CheckPermissionResultModel;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@XBridgeMethod(biz = "webcast_sdk", name = "checkPermission")
public final class a extends e7.b<CheckPermissionParamModel, CheckPermissionResultModel> {

    /* JADX INFO: renamed from: com.bytedance.android.annie.bridge.method.permission.a$a, reason: collision with other inner class name */
    public /* synthetic */ class C0728a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f38772a = null;

        static {
            int[] r100 = new int[Permission.values().length];
            r100[Permission.PHOTOALBUM.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[Permission.WRITE_PHOTOALBUM.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[Permission.READ_PHOTOALBUM.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f38772a = r100;
        }
    }

    public a() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        CheckPermissionParamModel r102 = (CheckPermissionParamModel) r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        CheckPermissionParamModel.Permission r103 = r102.a();
        if (r103 != null) goto L5;
        CheckPermissionResultModel r104 = new CheckPermissionResultModel();
        r104.a(CheckPermissionResultModel.Code.InvalidParam);
        r104.b("Illegal permission");
        finishWithResult(r104);
        return;
    L5:
        Permission.a r105 = Permission.Companion;
        String r106 = r103.toString();
        r105.getClass();
        Permission r107 = Permission.a.a(r106);
        if (r107 != Permission.UNKNOWN) goto L9;
        CheckPermissionResultModel r108 = new CheckPermissionResultModel();
        r108.a(CheckPermissionResultModel.Code.InvalidParam);
        r108.b("Illegal permission");
        finishWithResult(r108);
        return;
    L9:
        if (r107 != Permission.NOTIFICATION) goto L14;
        Map<String, c.b> r109 = c.f38773a;
        if (c.g(r101.getContext()) == false) goto L13;
        CheckPermissionResultModel r110 = new CheckPermissionResultModel();
        r110.a(CheckPermissionResultModel.Code.Success);
        CheckPermissionResultModel.Status r111 = CheckPermissionResultModel.Status.Permitted;
        r110.c(r111.toString());
        r110.b(r111.toString());
        finishWithResult(r110);
        return;
    L13:
        CheckPermissionResultModel r112 = new CheckPermissionResultModel();
        r112.a(CheckPermissionResultModel.Code.Success);
        CheckPermissionResultModel.Status r113 = CheckPermissionResultModel.Status.Denied;
        r112.c(r113.toString());
        r112.b(r113.toString());
        finishWithResult(r112);
        return;
    L14:
        boolean r114 = true;
        boolean r115 = false;
        if (r107 != Permission.LOCATION) goto L34;
        Map<String, c.b> r116 = c.f38773a;
        if (c.i(r101.getContext()) == true) goto L19;
        CheckPermissionResultModel r117 = new CheckPermissionResultModel();
        r117.a(CheckPermissionResultModel.Code.Success);
        CheckPermissionResultModel.Status r118 = CheckPermissionResultModel.Status.Restricted;
        r117.c(r118.toString());
        r117.b(r118.toString());
        finishWithResult(r117);
        return;
    L19:
        Context r119 = r101.getContext();
        Intrinsics.checkNotNullParameter(r119, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (ContextCompat.checkSelfPermission(r119, "android.permission.ACCESS_COARSE_LOCATION") != (-1)) goto L22;
    L24:
        r114 = false;
    L25:
        CheckPermissionResultModel r120 = new CheckPermissionResultModel();
        r120.a(CheckPermissionResultModel.Code.Success);
        if (r114 == false) goto L28;
        CheckPermissionResultModel.Status r121 = CheckPermissionResultModel.Status.Permitted;
    L29:
        r120.c(r121.toString());
        if (r114 == false) goto L32;
        CheckPermissionResultModel.Status r122 = CheckPermissionResultModel.Status.Permitted;
    L33:
        r120.b(r122.toString());
        finishWithResult(r120);
        return;
    L32:
        r122 = CheckPermissionResultModel.Status.Denied;
        goto L33
    L28:
        r121 = CheckPermissionResultModel.Status.Denied;
        goto L29
    L22:
        if (ContextCompat.checkSelfPermission(r119, "android.permission.ACCESS_FINE_LOCATION") == (-1)) goto L24;
    L34:
        int r123 = C0728a.f38772a[r107.ordinal()];
        if (r123 != 1) goto L37;
        List<String> r124 = c.c();
    L45:
        if (r124.size() != 1) goto L54;
        String r125 = (String) CollectionsKt.first(r124);
        if (r125 == null) goto L66;
        Context r126 = r101.getContext();
        if (r126 == null) goto L66;
        if (ContextCompat.checkSelfPermission(r126, r125) != (-1)) goto L65;
    L64:
        r114 = false;
    L65:
        r115 = r114;
    L66:
        if (r115 == false) goto L68;
        CheckPermissionResultModel r127 = new CheckPermissionResultModel();
        r127.a(CheckPermissionResultModel.Code.Success);
        CheckPermissionResultModel.Status r128 = CheckPermissionResultModel.Status.Permitted;
        r127.c(r128.toString());
        r127.b(r128.toString());
        finishWithResult(r127);
        return;
    L68:
        CheckPermissionResultModel r129 = new CheckPermissionResultModel();
        r129.a(CheckPermissionResultModel.Code.Success);
        CheckPermissionResultModel.Status r130 = CheckPermissionResultModel.Status.Denied;
        r129.c(r130.toString());
        r129.b(r130.toString());
        finishWithResult(r129);
        return;
    L54:
        Context r131 = r101.getContext();
        if (r131 == null) goto L64;
        Iterator<String> r132 = r124.iterator();
    L59:
        if (r132.hasNext() == false) goto L65;
        String r133 = r132.next();
        if (r133 == null) goto L59;
        if (ContextCompat.checkSelfPermission(r131, r133) != (-1)) goto L59;
    L37:
        if (r123 != 2) goto L39;
        r124 = c.f();
        goto L45
    L39:
        if (r123 == 3) goto L41;
        r124 = r107.getPermission();
        goto L45
    L41:
        r124 = c.d();
        goto L45
    }
}
