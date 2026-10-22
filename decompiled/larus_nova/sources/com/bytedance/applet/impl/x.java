package com.bytedance.applet.impl;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.ai.bridge.method.system.AbsOpenMapAppMethodIDL;
import com.bytedance.ai.bridge.service.IHostMapDepend;
import com.bytedance.ai.bridge.service.Location;
import com.bytedance.ai.bridge.service.NavigateMode;
import com.bytedance.ai.bridge.service.UserAction;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.locationmessage.ui.navigation.MapRouteService;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class x implements IHostMapDepend {
    public x() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.ai.bridge.service.IHostMapDepend
    public final void openMapApp(final Context r110, final NavigateMode r111, final Location r112, final Location r113, final Function1<? super AbsOpenMapAppMethodIDL.b, Unit> r114) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, "mode");
        Intrinsics.checkNotNullParameter(r112, "dest");
        Intrinsics.checkNotNullParameter(r114, "callback");
        xv3.h.f565166a.getClass();
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, "mode");
        Intrinsics.checkNotNullParameter(r112, "dest");
        Intrinsics.checkNotNullParameter(r114, "callback");
        if ((r110 instanceof Activity) == false) goto L9;
        Activity r100 = (Activity) r110;
        if (r100.isDestroyed() == false) goto L7;
        return;
    L7:
        if (r100.isFinishing() == false) goto L9;
        return;
    L9:
        ArrayList r101 = (ArrayList) xv3.h.f565172g;
        r101.clear();
        xv3.h.f565168c = xv3.h.b(r110, MapRouteService.MapPackageName.PACKAGE_NAME_AMAP);
        xv3.h.f565169d = xv3.h.b(r110, MapRouteService.MapPackageName.PACKAGE_NAME_QQMAP);
        xv3.h.f565170e = xv3.h.b(r110, MapRouteService.MapPackageName.PACKAGE_NAME_BAIDUMAP);
        if (xv3.h.f565168c == false) goto L13;
        r101.add(new Pair(r110.getString(R.string.larus_map_plugin_open_autonavi_map), new xv3.d(r110, r112, r111, r113)));
    L13:
        if (xv3.h.f565169d == false) goto L16;
        r101.add(new Pair(r110.getString(R.string.larus_map_plugin_open_tencent_map), new xv3.e(r110, r112, r111, r113)));
    L16:
        if (xv3.h.f565170e == false) goto L19;
        r101.add(new Pair(r110.getString(R.string.larus_map_plugin_open_baidu_map), new xv3.f(r110, r112, r111, r113)));
    L19:
        if (r101.isEmpty() == false) goto L25;
        StringBuilder r102 = new StringBuilder();
        r102.append(r110.getString(R.string.larus_gold_map));
        if (xv3.h.f565168c == false) goto L23;
        String r103 = "";
    L24:
        r102.append(r103);
        r101.add(new Pair(r102.toString(), new xv3.g(r110, r112, r111, r113)));
        goto L25
    L23:
        r103 = r110.getString(R.string.larus_not_install);
    L25:
        String[] r115 = new String[r101.size()];
        int r116 = r101.size();
        int r117 = 0;
    L26:
        if (r117 >= r116) goto L28;
        r115[r117] = ((Pair) ListProtector.get(xv3.h.f565172g, r117)).getFirst();
        r117 = r117 + 1;
        goto L26
    L28:
        AlertDialog r118 = xv3.h.f565171f;
        if (r118 == null) goto L47;
        Handler r119 = DialogLancet.resolveDialogHandler(r118);
        if (r119 != null) goto L33;
    L35:
        DialogLancet.beforeDialogDismiss(r118);
        r118.dismiss();     // Catch: Throwable -> L38 Exception -> L40
    L44:
        DialogLancet.afterDialogDismiss(r118);
        goto L47
    L40:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L38
        Throwable r120 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L38
        if (r120 == null) goto L44;
        com.bytedance.crash.d.d(r120, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L38
    L38:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r118);
        throw th;
    L33:
        if (Looper.myLooper() == r119.getLooper()) goto L35;
        r119.post(DialogLancet.createDismissRunnable(r118));
    L47:
        List<Pair<String, Function0<Unit>>> r121 = xv3.h.f565172g;
        final ArrayList r122 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r121, 10));
        Iterator r123 = ((ArrayList) r121).iterator();
    L49:
        if (r123.hasNext() == false) goto L67;
        Pair r104 = (Pair) r123.next();
        xv3.h r105 = xv3.h.f565166a;
        String r106 = (String) r104.getFirst();
        r105.getClass();
        if (Intrinsics.areEqual(r106, r110.getString(R.string.larus_select_map)) == false) goto L54;
        String r107 = UserAction.SELECT_MAP.getValue();
    L66:
        r122.add(r107);
        goto L49
    L54:
        if (Intrinsics.areEqual(r106, r110.getString(R.string.larus_map_plugin_open_autonavi_map)) == false) goto L57;
        r107 = UserAction.AUTONAVI.getValue();
        goto L66
    L57:
        if (Intrinsics.areEqual(r106, r110.getString(R.string.larus_map_plugin_open_tencent_map)) == false) goto L60;
        r107 = UserAction.TENCENT.getValue();
        goto L66
    L60:
        if (Intrinsics.areEqual(r106, r110.getString(R.string.larus_map_plugin_open_baidu_map)) == false) goto L63;
        r107 = UserAction.BAIDU.getValue();
        goto L66
    L63:
        if (Intrinsics.areEqual(r106, r110.getString(R.string.larus_gold_map) + r110.getString(R.string.larus_not_install)) == false) goto L65;
        r107 = UserAction.INSTALL_AUTONAVI.getValue();
        goto L66
    L65:
        r107 = "";
        goto L66
    L67:
        AlertDialog r124 = new AlertDialog.Builder(r110).setTitle(r110.getString(R.string.larus_select_map)).setItems(r115, new xv3.a(r114, r122)).setOnCancelListener(new xv3.b(r114, r122)).setOnDismissListener(new xv3.c()).create();
        xv3.h.f565171f = r124;
        if (r124 != null) goto L70;
        return;
    L70:
        if (DialogLancet.shouldBlockDialogShow(r124) == false) goto L79;
        DialogLancet.handleBlockedDialogShow(r124);
        return;
    L79:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L75
    L73:
        DialogLancet.beforeDialogShow(r124);
        r124.show();
        DialogLancet.afterDialogShow(r124);
    }
}
