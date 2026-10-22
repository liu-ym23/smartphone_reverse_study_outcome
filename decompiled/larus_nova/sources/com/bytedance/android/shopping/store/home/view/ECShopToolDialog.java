package com.bytedance.android.shopping.store.home.view;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;
import com.bytedance.android.btm.api.BtmHostDependManager;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.hybrid.card.api.ECLynxLoadParam;
import com.bytedance.android.ec.hybrid.card.impl.ECLynxCard;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.android.shopping.store.home.entity.ToolType;
import com.bytedance.android.shopping.store.viewmodel.ECStoreViewModel;
import com.bytedance.mira.core.opt.res.NewMiraResourcesManager;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.gson.JsonObject;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0002\u0002\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/shopping/store/home/view/ECShopToolDialog;", "Lcom/google/android/material/bottomsheet/BottomSheetDialog;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECShopToolDialog extends BottomSheetDialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ViewGroup f184544a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ECStoreViewModel f184545b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f184546c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<com.bytedance.android.ec.model.h> f184547d;

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f184548a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f184549b;

        public b() {
        }
    }

    public static final class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ECShopToolDialog f184550a;

        public c(ECShopToolDialog r100) {
            this.f184550a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            ECShopToolDialog r101 = this.f184550a;
            Handler r102 = DialogLancet.resolveDialogHandler(r101);
            if (r102 != null) goto L5;
        L7:
            DialogLancet.beforeDialogDismiss(r101);
            r101.dismiss();     // Catch: Throwable -> L10 Exception -> L12
        L16:
            DialogLancet.afterDialogDismiss(r101);
            return;
        L10:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r101);
            throw th;
        L12:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
            Throwable r103 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
            if (r103 == null) goto L16;
            com.bytedance.crash.d.d(r103, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
            goto L16
        L5:
            if (Looper.myLooper() == r102.getLooper()) goto L7;
            r102.post(DialogLancet.createDismissRunnable(r101));
        }
    }

    static {
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        Handler r100 = DialogLancet.resolveDialogHandler(this);
        if (r100 != null) goto L5;
    L7:
        DialogLancet.beforeDialogDismiss(this);
        super.dismiss();     // Catch: Throwable -> L10 Exception -> L12
    L16:
        DialogLancet.afterDialogDismiss(this);
    L17:
        ad.a.a(this, null);
        return;
    L12:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
        Throwable r101 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
        if (r101 == null) goto L16;
        com.bytedance.crash.d.d(r101, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        DialogLancet.afterDialogDismiss(this);
        throw th;
    L5:
        if (Looper.myLooper() == r100.getLooper()) goto L7;
        r100.post(DialogLancet.createDismissRunnable(this));
        goto L17
    }

    @Override // android.app.Dialog
    public final void show() {
        if (DialogLancet.shouldBlockDialogShow(this) == false) goto L10;
        DialogLancet.handleBlockedDialogShow(this);
    L7:
        ad.a.b(this);
        return;
    L10:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L9
    L6:
        DialogLancet.beforeDialogShow(this);
        super.show();
        DialogLancet.afterDialogShow(this);
        goto L7
    }

    public static View I0(Window r100) {
        View r101 = r100.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == com.larus.home.impl.utils.c.f346341a) goto L7;
        com.larus.home.impl.utils.c.a(r102, "getDecorView");
    L7:
        return r101;
    }

    public final int J0(int r100) {
        Resources r101 = th.a.e(getContext(), true).getResources();
        return (int) (r100 * WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics()).density);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v7 */
    @Override // com.google.android.material.bottomsheet.BottomSheetDialog, androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public final void onCreate(Bundle r110) {
        super.onCreate(r110);
        int r100 = ad.a.f2930a;
        BtmSDK.INSTANCE.getDepend().getClass();
        BtmHostDependManager.l(this, "a1.b6269", false);
        Window r101 = getWindow();
        if (r101 == null) goto L5;
        r101.clearFlags(67108864);
        r101.addFlags(Integer.MIN_VALUE);
        I0(r101).setSystemUiVisibility(I0(r101).getSystemUiVisibility() | 1280);
        r101.setStatusBarColor(0);
    L5:
        ImageView r102 = (ImageView) findViewById(R.id.ec_shop_dialog_close_btn);
        if (r102 == null) goto L8;
        r102.setOnClickListener(new c(this));
    L8:
        this.f184544a = (ViewGroup) findViewById(R.id.ec_shop_container_coupon);
        b r103 = this.f184546c;
        String r104 = r103.f184549b;
        int r105 = 1;
        if (r104 != null) goto L11;
    L14:
        boolean r106 = true;
    L16:
        if (r106 == true) goto L32;
        String r107 = r103.f184548a;
        if (r107 != null) goto L20;
    L23:
        boolean r108 = true;
    L24:
        if (r108 == true) goto L32;
        if (Intrinsics.areEqual(r103.f184549b, "\"null\"") == true) goto L32;
        ViewGroup r109 = this.f184544a;
        if (r109 == null) goto L35;
        ECLynxCard r111 = new ECLynxCard();
        r109.setVisibility(0);
        Map<String, Object> r112 = this.f184545b.getMetaInfo(null);
        JsonObject r113 = new JsonObject();
        r113.addProperty("coupon_data", r103.f184549b);
        Context r114 = getContext();
        String r115 = r103.f184548a;
        Intrinsics.checkNotNull(r115);
        ECLynxLoadParam.a r116 = new ECLynxLoadParam.a(r114, r115, r109);
        r116.j(2000);
        r116.f46345j = com.bytedance.android.ec.hybrid.list.util.k.d(r113);
        d r117 = new d(r111);
        Intrinsics.checkNotNullParameter(r117, NewBroadcastMonitor.STAGE.LIFECYCLE);
        r116.f46350o = r117;
        r116.h(this.f184545b.getSceneId());
        r116.e(MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("meta_info", MapsKt.toMap(r112))}));
        r111.j(new ECLynxLoadParam(r116));
    L35:
        LinearLayout r118 = (LinearLayout) findViewById(R.id.ec_shop_container_tools);
        Iterator<T> r119 = this.f184547d.iterator();
        int r120 = 0;
    L37:
        if (r119.hasNext() == false) goto L65;
        Object r121 = r119.next();
        int r122 = r120 + 1;
        if (r120 >= 0) goto L41;
        CollectionsKt.throwIndexOverflow();
    L41:
        com.bytedance.android.ec.model.h r123 = (com.bytedance.android.ec.model.h) r121;
        if (r118 == null) goto L44;
        LinearLayout r124 = new LinearLayout(getContext());
        r124.setOrientation(r105);
        r124.setGravity(16);
        r124.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        Configuration r125 = new Configuration(r124.getContext().getResources().getConfiguration());
        r125.uiMode = 16 | (r125.uiMode & (-49));
        Context r126 = r124.getContext().createConfigurationContext(r125);
        NewMiraResourcesManager.getInstance().install(r126);
        ImageView r127 = new ImageView(r126);
        r127.setImageResource(r123.f47865b);
        r127.setLayoutParams(new LinearLayout.LayoutParams(J0(48), J0(48)));
        r124.addView(r127);
        TextView r128 = new TextView(th.a.e(r124.getContext(), r105));
        r128.setText(r123.f47867d);
        r128.setTextSize(11.0f);
        r128.setGravity(r105);
        LinearLayout.LayoutParams r129 = new LinearLayout.LayoutParams(-1, -2);
        r129.topMargin = J0(10);
        Unit r130 = Unit.INSTANCE;
        r128.setLayoutParams(r129);
        r128.setTextColor(th.a.e(r128.getContext(), r105).getResources().getColor(R.color.rc_shop_tool_text_color));
        r124.addView(r128);
        r124.setOnClickListener(new com.bytedance.android.shopping.store.home.view.c(this, r123));
        r118.addView(r124);
    L44:
        Map<String, Object> r131 = BtmSDK.INSTANCE.createReportParams("a1.b6269.c25145.d289907", PageFinder.via(r118));
        ArrayList r132 = new ArrayList(r131.size());
        Iterator<Map.Entry<String, Object>> r133 = r131.entrySet().iterator();
    L46:
        if (r133.hasNext() == false) goto L48;
        Map.Entry<String, Object> r134 = r133.next();
        r132.add(TuplesKt.to(r134.getKey(), String.valueOf(r134.getValue())));
        goto L46
    L48:
        Map<String, String> r135 = MapsKt.toMap(r132);
        ECStoreViewModel r136 = this.f184545b;
        Pair<String, String>[] r137 = new Pair[r105];
        ToolType.a r138 = ToolType.Companion;
        int r139 = r123.getType();
        r138.getClass();
        ToolType[] r140 = ToolType.values();
        int r141 = r140.length;
        int r142 = 0;
    L49:
        if (r142 >= r141) goto L57;
        ToolType r143 = r140[r142];
        if (r143.getType() != r139) goto L53;
        boolean r144 = true;
    L54:
        if (r144 == true) goto L58;
        r142 = r142 + 1;
    L58:
        if (r143 != null) goto L60;
        r143 = ToolType.UNKNOWN;
    L60:
        r137[0] = TuplesKt.to("entry_name", f.a(r143));
        r136.doEventAction("shop_tools_panel_entrance_show", r135, r137);
        if (r120 == CollectionsKt.getLastIndex(this.f184547d)) goto L64;
        if (r118 == null) goto L64;
        Space r145 = new Space(getContext());
        LinearLayout.LayoutParams r146 = new LinearLayout.LayoutParams(J0(0), J0(0));
        r146.weight = 1.0f;
        Unit r147 = Unit.INSTANCE;
        r145.setLayoutParams(r146);
        r118.addView(r145);
    L64:
        r120 = r122;
        r105 = 1;
        goto L37
    L53:
        r144 = false;
        goto L54
    L57:
        r143 = null;
        goto L58
    L65:
        return;
    L20:
        if (r107.length() == 0) goto L23;
        r108 = false;
    L32:
        ViewGroup r148 = this.f184544a;
        if (r148 == null) goto L35;
        r148.setVisibility(8);
        goto L35
    L11:
        if (r104.length() == 0) goto L14;
        r106 = false;
        goto L16
    }

    public ECShopToolDialog(Context r100, ECStoreViewModel r101, b r102, List<com.bytedance.android.ec.model.h> r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "viewModel");
        Intrinsics.checkNotNullParameter(r102, "couponData");
        Intrinsics.checkNotNullParameter(r103, "entryList");
        super(r100, R.style.ToolsDialogTheme);
        this.f184545b = r101;
        this.f184546c = r102;
        this.f184547d = r103;
        setContentView(R.layout.ec_shop_dialog_tools);
        setCancelable(true);
    }
}
