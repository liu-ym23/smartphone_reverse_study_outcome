package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.experencepanel;

import am2.x;
import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextPaint;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.live.ktv.common.util.KtvUtilsKt;
import com.bytedance.android.live.room.api.experience.utils.PlatformExpUtils;
import com.bytedance.android.live.room.api.playopt.base.LivePlayOptUtils;
import com.bytedance.android.live.room.api.playopt.topspeed.TopSpeedModeUtils;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.settingpanel.adapter.AudiencePortraitSettingAdapter;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.utils.k4;
import com.bytedance.android.livesdk.widget.CommonStandardBottomDialog;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0002\u0002\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/experencepanel/AudienceExperienceSettingDialog;", "Lcom/bytedance/android/livesdk/widget/CommonStandardBottomDialog;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "DivideItemDecoration", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AudienceExperienceSettingDialog extends CommonStandardBottomDialog {
    public static final /* synthetic */ int M = 0;
    public List<np1.b> B;
    public AudiencePortraitSettingAdapter<? extends np1.b> C;
    public Pair<? extends np1.c, ? extends Disposable> D;
    public np1.c E;
    public final Lazy F;
    public final Lazy G;
    public LinearLayout H;
    public RecyclerView I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public DataCenter f116246J;
    public View K;
    public TextView L;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/experencepanel/AudienceExperienceSettingDialog$DivideItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class DivideItemDecoration extends RecyclerView.ItemDecoration {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Paint f116247a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final float f116248b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final float f116249c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final List<np1.b> f116250d;

        public DivideItemDecoration(List<np1.b> r100) {
            Intrinsics.checkNotNullParameter(r100, "models");
            this.f116250d = r100;
            Paint r101 = new Paint(5);
            r101.setColor(336992291);
            r101.setStyle(Paint.Style.FILL);
            Unit r102 = Unit.INSTANCE;
            this.f116247a = r101;
            this.f116248b = UtilityKotlinExtentionsKt.h(16);
            this.f116249c = UtilityKotlinExtentionsKt.h(0.5f);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public final void onDraw(Canvas r100, RecyclerView r110, RecyclerView.State r111) {
            Intrinsics.checkNotNullParameter(r100, "c");
            Intrinsics.checkNotNullParameter(r110, "parent");
            Intrinsics.checkNotNullParameter(r111, "state");
            super.onDraw(r100, r110, r111);
            Lazy r112 = LivePlayOptUtils.f99053a;
            if (TopSpeedModeUtils.a() == true) goto L17;
            int r113 = r110.getChildCount();
            int r101 = 0;
        L5:
            if (r101 >= r113) goto L22;
            View r102 = r110.getChildAt(r101);
            int r103 = r110.getChildAdapterPosition(r102);
            if (r103 == 0) goto L16;
            Object r104 = ListProtector.get(this.f116250d, r103);
            if ((r104 instanceof np1.g) == true) goto L11;
            r104 = null;
        L11:
            np1.g r105 = (np1.g) r104;
            if (r105 != null) goto L14;
        L15:
            float r106 = r102.getTop();
            r100.drawLine(this.f116248b, r106, r110.getMeasuredWidth() - this.f116248b, r106 + this.f116249c, this.f116247a);
            goto L16
        L14:
            if (r105.f520025e != true) goto L15;
        L16:
            r101 = r101 + 1;
            goto L5
        L22:
            return;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public final void getItemOffsets(Rect r100, View r101, RecyclerView r102, RecyclerView.State r103) {
            Intrinsics.checkNotNullParameter(r100, "outRect");
            Intrinsics.checkNotNullParameter(r101, "view");
            Intrinsics.checkNotNullParameter(r102, "parent");
            Intrinsics.checkNotNullParameter(r103, "state");
            super.getItemOffsets(r100, r101, r102, r103);
            Lazy r104 = LivePlayOptUtils.f99053a;
            if (TopSpeedModeUtils.a() == false) goto L6;
            r100.bottom = UtilityKotlinExtentionsKt.i(8);
            return;
        }
    }

    public static final class a {
        @JvmStatic
        public static void a(Context r100, DataCenter r101) {
            if (r100 != null) goto L4;
            return;
        L4:
            if (r101 != null) goto L6;
            return;
        L6:
            Activity r102 = k4.b(r100);
            if (r102 != null) goto L9;
        L11:
            if (r102 != null) goto L13;
        L15:
            AudienceExperienceSettingDialog r103 = new AudienceExperienceSettingDialog(r100);
            r103.f116246J = r101;
            if (DialogLancet.shouldBlockDialogShow(r103) == false) goto L22;
            DialogLancet.handleBlockedDialogShow(r103);
            return;
        L22:
            DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L21
        L19:
            DialogLancet.beforeDialogShow(r103);
            r103.show();
            DialogLancet.afterDialogShow(r103);
            return;
        L13:
            if (r102.isDestroyed() != true) goto L15;
            return;
        L9:
            if (r102.isFinishing() != true) goto L11;
        }
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.widget.CommonStandardBottomDialog
    public final int getLayoutId() {
        return R.layout.ttlive_dialog_experence_setting;
    }

    @Override // com.bytedance.android.livesdk.widget.LiveStandardSheetDialog, com.bytedance.android.livesdk.pannel.SheetBaseDialog, androidx.appcompat.app.AppCompatDialog, android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        Handler r100 = DialogLancet.resolveDialogHandler(this);
        if (r100 != null) goto L5;
    L7:
        DialogLancet.beforeDialogDismiss(this);
        super.dismiss();     // Catch: Throwable -> L10 Exception -> L12
    L16:
        DialogLancet.afterDialogDismiss(this);
    L17:
        g r101 = (g) this.F.getValue();
        if (r101 == null) goto L20;
        r101.f116285a.clear();
    L20:
        h r102 = (h) this.G.getValue();
        if (r102 == null) goto L23;
        r102.f116287b.clear();
    L23:
        Pair<? extends np1.c, ? extends Disposable> r103 = this.D;
        if (r103 == null) goto L34;
        Disposable r104 = r103.getSecond();
        if (r104 == null) goto L35;
        r104.dispose();
        return;
    L35:
        return;
    L34:
        return;
    L12:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
        Throwable r105 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
        if (r105 == null) goto L16;
        com.bytedance.crash.d.d(r105, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        DialogLancet.afterDialogDismiss(this);
        throw th;
    L5:
        if (Looper.myLooper() == r100.getLooper()) goto L7;
        r100.post(DialogLancet.createDismissRunnable(this));
        goto L17
    }

    public AudienceExperienceSettingDialog(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, false);
        this.B = new ArrayList();
        this.F = LazyKt.lazy(AudienceExperienceSettingDialog$fluencyPlayItem$2.INSTANCE);
        this.G = LazyKt.lazy(AudienceExperienceSettingDialog$topSpeedModeItem$2.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.livesdk.widget.CommonStandardBottomDialog, com.bytedance.android.livesdk.pannel.SheetBaseDialog, androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public final void onCreate(Bundle r110) {
        super.onCreate(r110);
        N0();
        TextView r100 = (TextView) findViewById(R.id.tvTitle);
        if (r100 == null) goto L7;
        TextPaint r101 = r100.getPaint();
        if (r101 == null) goto L7;
        r101.setFakeBoldText(true);
    L7:
        this.H = (LinearLayout) findViewById(R.id.play_opt_root_view);
        this.K = findViewById(R.id.vDivider);
        this.L = (TextView) findViewById(R.id.tvTitle);
        Pair<? extends np1.c, ? extends Disposable> r111 = com.bytedance.live.datacontext.d.a(new AudienceExperienceSettingDialog$initData$1(this));
        this.D = r111;
        if (r111 == null) goto L129;
        np1.c r112 = r111.getFirst();
        if (r112 == null) goto L129;
        this.E = r112;
        TextView r113 = this.L;
        np1.b r102 = null;
        if (r113 == null) goto L15;
        ViewGroup.LayoutParams r114 = r113.getLayoutParams();
    L17:
        if ((r114 instanceof LinearLayout.LayoutParams) == true) goto L19;
        r114 = null;
    L19:
        LinearLayout.LayoutParams r115 = (LinearLayout.LayoutParams) r114;
        if (TopSpeedModeUtils.a() == false) goto L47;
        View r103 = this.K;
        if (r103 == null) goto L24;
        r103.setVisibility(8);
    L24:
        LinearLayout r104 = this.H;
        if (r104 == null) goto L27;
        r104.setBackgroundResource(R.drawable.ttlive_bg_play_opt_new);
    L27:
        List<np1.b> r105 = this.B;
        final h r106 = (h) this.G.getValue();
        final np1.c r107 = this.E;
        if (r107 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("panelContext");
    L30:
        r106.getClass();
        Intrinsics.checkNotNullParameter(r107, "panelContext");
        Intrinsics.checkNotNullParameter(r107, "panelContext");
        DataCenter r108 = r107.getDataCenter();
        if (r108 != null) goto L33;
    L39:
        boolean r109 = false;
    L40:
        if (r109 == true) goto L42;
        np1.b r116 = null;
    L43:
        if (r116 == null) goto L45;
        r105.add(r116);
    L45:
        if (r115 == null) goto L91;
        r115.setMargins(0, UtilityKotlinExtentionsKt.i(12), 0, UtilityKotlinExtentionsKt.i(22));
    L91:
        List<np1.b> r117 = this.B;
        final np1.c r118 = this.E;
        if (r118 != null) goto L94;
        Intrinsics.throwUninitializedPropertyAccessException("panelContext");
    L94:
        Intrinsics.checkNotNullParameter(r118, "panelContext");
        int r119 = d.f116282a;
        Intrinsics.checkNotNullParameter(r118, "panelContext");
        DataCenter r120 = r118.getDataCenter();
        if (r120 != null) goto L97;
    L101:
        boolean r121 = false;
    L102:
        if (r121 == true) goto L104;
        np1.b r122 = null;
    L105:
        if (r122 == null) goto L107;
        r117.add(r122);
    L107:
        List<np1.b> r123 = this.B;
        final c r124 = new c();
        final np1.c r125 = this.E;
        if (r125 != null) goto L110;
        Intrinsics.throwUninitializedPropertyAccessException("panelContext");
    L110:
        Intrinsics.checkNotNullParameter(r125, "panelContext");
        Intrinsics.checkNotNullParameter(r125, "panelContext");
        if (j40.h.f497230a.getValue().getEnable() == false) goto L114;
        np1.b.a r126 = np1.b.f520007a;
        Function0<np1.g> r127 = new CleanGiftCacheItem$provide$1(r125);
        Function1<np1.g, Unit> r128 = new CleanGiftCacheItem$provide$2(r124);
        r126.getClass();
        r102 = np1.b.a.a(r127, r128);
    L114:
        if (r102 == null) goto L116;
        r123.add(r102);
    L116:
        List<np1.b> r129 = this.B;
        ArrayList r130 = new ArrayList();
        Iterator<T> r131 = r129.iterator();
    L118:
        if (r131.hasNext() == false) goto L128;
        Object r132 = r131.next();
        np1.b r133 = (np1.b) r132;
        if ((r133 instanceof np1.g) == true) goto L122;
    L125:
        boolean r134 = true;
    L126:
        if (r134 == false) goto L118;
        r130.add(r132);
        goto L118
    L122:
        if (((ArrayList) ((np1.g) r133).f520024d).isEmpty() == false) goto L125;
        r134 = false;
        goto L126
    L128:
        this.B = CollectionsKt.toMutableList(r130);
        goto L129
    L104:
        np1.b.a r135 = np1.b.f520007a;
        Function0<np1.g> r136 = new NetworkOptItem$provide$1(r118);
        Function1<np1.g, Unit> r137 = new NetworkOptItem$provide$2(r118);
        r135.getClass();
        r122 = np1.b.a.a(r136, r137);
        goto L105
    L97:
        if (z.e(r120, false) == true) goto L101;
        if (z.m(r120, true) == false) goto L101;
        r121 = true;
        goto L102
    L42:
        np1.b.a r138 = np1.b.f520007a;
        Function0<np1.g> r139 = new TopSpeedModeItem$provide$1(r107);
        Function1<np1.g, Unit> r140 = new TopSpeedModeItem$provide$2(r106);
        r138.getClass();
        r116 = np1.b.a.a(r139, r140);
        goto L43
    L33:
        if (z.e(r108, false) == true) goto L39;
        if (z.m(r108, true) == false) goto L39;
        if (TopSpeedModeUtils.a() == false) goto L39;
        r109 = true;
        goto L40
    L47:
        View r141 = this.K;
        if (r141 == null) goto L50;
        r141.setVisibility(0);
    L50:
        if (r115 == null) goto L52;
        r115.setMargins(0, 12, 0, 0);
    L52:
        LinearLayout r142 = this.H;
        if (r142 == null) goto L56;
        r142.setBackgroundColor(KtvUtilsKt.f(R.color.ttlive_dialog_standard_bg));
    L56:
        if (PlatformExpUtils.b() == false) goto L75;
        List<np1.b> r143 = this.B;
        final g r144 = (g) this.F.getValue();
        final np1.c r145 = this.E;
        if (r145 != null) goto L60;
        Intrinsics.throwUninitializedPropertyAccessException("panelContext");
    L60:
        r144.getClass();
        Intrinsics.checkNotNullParameter(r145, "panelContext");
        Intrinsics.checkNotNullParameter(r145, "panelContext");
        DataCenter r146 = r145.getDataCenter();
        if (r146 != null) goto L63;
    L69:
        boolean r147 = false;
    L70:
        if (r147 == true) goto L72;
        np1.b r148 = null;
    L73:
        if (r148 == null) goto L91;
        r143.add(r148);
        goto L91
    L72:
        np1.b.a r149 = np1.b.f520007a;
        Function0<np1.g> r150 = new FluencyPlayItem$provide$1(r145);
        Function1<np1.g, Unit> r151 = new FluencyPlayItem$provide$2(r144, r145);
        r149.getClass();
        r148 = np1.b.a.a(r150, r151);
        goto L73
    L63:
        if (z.e(r146, false) == true) goto L69;
        if (z.m(r146, true) == false) goto L69;
        if (PlatformExpUtils.b() == false) goto L69;
        r147 = true;
        goto L70
    L75:
        List<np1.b> r152 = this.B;
        int r153 = d.f116282a;
        final np1.c r154 = this.E;
        if (r154 != null) goto L78;
        Intrinsics.throwUninitializedPropertyAccessException("panelContext");
    L78:
        Intrinsics.checkNotNullParameter(r154, "panelContext");
        Intrinsics.checkNotNullParameter(r154, "panelContext");
        DataCenter r155 = r154.getDataCenter();
        if (r155 != null) goto L81;
    L85:
        boolean r156 = false;
    L86:
        if (r156 == true) goto L88;
        np1.b r157 = null;
    L89:
        if (r157 == null) goto L91;
        r152.add(r157);
        goto L91
    L88:
        np1.b.a r158 = np1.b.f520007a;
        Function0<np1.g> r159 = new DegradeItem$provide$1(r154);
        DegradeItem$provide$2 r160 = new DegradeItem$provide$2(r154);
        r158.getClass();
        r157 = np1.b.a.a(r159, r160);
        goto L89
    L81:
        if (z.e(r155, false) == true) goto L85;
        if (z.m(r155, true) == false) goto L85;
        r156 = true;
        goto L86
    L15:
        r114 = null;
    L129:
        this.I = (RecyclerView) findViewById(R.id.recyclerView);
        AudiencePortraitSettingAdapter<? extends np1.b> r161 = new AudiencePortraitSettingAdapter(this.B, TopSpeedModeUtils.a());
        this.C = r161;
        RecyclerView r162 = this.I;
        if (r162 == null) goto L132;
        r162.setAdapter(r161);
    L132:
        RecyclerView r163 = this.I;
        if (r163 == null) goto L135;
        r163.addItemDecoration(new DivideItemDecoration(this.B));
    L135:
        int r164 = com.bytedance.android.live.room.api.playopt.topspeed.log.a.f99080a;
        LinkedHashMap r165 = new LinkedHashMap();
        r165.put("capability_status", TopSpeedModeUtils.c());
        if (((Boolean) com.bytedance.android.live.room.api.playopt.base.a.f99056c.f64752a).booleanValue() == false) goto L138;
        String r166 = "on";
    L139:
        r165.put("topspeed_mode_on_off", r166);
        j0.l().sendLog("livesdk_experienceopt_page_show", r165, new Object[]{x.class, Room.class});
        return;
    L138:
        r166 = "off";
        goto L139
    }
}
