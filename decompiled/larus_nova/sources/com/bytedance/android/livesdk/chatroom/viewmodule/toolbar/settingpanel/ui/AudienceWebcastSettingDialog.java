package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.settingpanel.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.setting.SettingUtil;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.settingpanel.adapter.AudiencePortraitSettingAdapter;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.settingpanel.item.DiggItem;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.settingpanel.item.IndependentTaskItem;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.settingpanel.item.PermissionGrantedItem;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.settingpanel.item.PublicScreenConfigItem;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.settingpanel.item.SmallWindowItem;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.utils.g;
import com.bytedance.android.livesdk.interactivity.api.settings.config.x;
import com.bytedance.android.livesdk.utils.b1;
import com.bytedance.android.livesdk.widget.CommonStandardBottomDialog;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/settingpanel/ui/AudienceWebcastSettingDialog;", "Lcom/bytedance/android/livesdk/widget/CommonStandardBottomDialog;", "DivideItemDecoration", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AudienceWebcastSettingDialog extends CommonStandardBottomDialog {
    public List<np1.b> B;
    public Pair<? extends np1.c, ? extends Disposable> C;
    public np1.c D;
    public RecyclerView E;
    public DataCenter F;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/settingpanel/ui/AudienceWebcastSettingDialog$DivideItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class DivideItemDecoration extends RecyclerView.ItemDecoration {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Paint f116762a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final float f116763b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final float f116764c;

        public DivideItemDecoration() {
            Paint r100 = new Paint(5);
            if (g.b() == false) goto L5;
            int r101 = 336992291;
        L6:
            r100.setColor(r101);
            r100.setStyle(Paint.Style.FILL);
            Unit r102 = Unit.INSTANCE;
            this.f116762a = r100;
            this.f116763b = UtilityKotlinExtentionsKt.h(16);
            this.f116764c = UtilityKotlinExtentionsKt.h(0.5f);
            return;
        L5:
            r101 = 352321535;
            goto L6
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public final void onDraw(Canvas r100, RecyclerView r110, RecyclerView.State r111) {
            Intrinsics.checkNotNullParameter(r100, "c");
            Intrinsics.checkNotNullParameter(r110, "parent");
            Intrinsics.checkNotNullParameter(r111, "state");
            super.onDraw(r100, r110, r111);
            int r112 = r110.getChildCount();
            int r101 = 0;
        L3:
            if (r101 >= r112) goto L8;
            View r102 = r110.getChildAt(r101);
            if (r110.getChildAdapterPosition(r102) == 0) goto L7;
            float r103 = r102.getTop();
            r100.drawLine(this.f116763b, r103, r110.getMeasuredWidth() - this.f116763b, r103 + this.f116764c, this.f116762a);
        L7:
            r101 = r101 + 1;
            goto L3
        }
    }

    @Override // com.bytedance.android.livesdk.widget.CommonStandardBottomDialog
    public final int getLayoutId() {
        return R.layout.ttlive_dialog_webcast_setting;
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
        Pair<? extends np1.c, ? extends Disposable> r101 = this.C;
        if (r101 == null) goto L28;
        Disposable r102 = r101.getSecond();
        if (r102 == null) goto L29;
        r102.dispose();
        return;
    L29:
        return;
    L28:
        return;
    L12:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
        Throwable r103 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
        if (r103 == null) goto L16;
        com.bytedance.crash.d.d(r103, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        DialogLancet.afterDialogDismiss(this);
        throw th;
    L5:
        if (Looper.myLooper() == r100.getLooper()) goto L7;
        r100.post(DialogLancet.createDismissRunnable(this));
        goto L17
    }

    public AudienceWebcastSettingDialog(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, false);
        this.B = new ArrayList();
    }

    @Override // com.bytedance.android.livesdk.widget.CommonStandardBottomDialog, com.bytedance.android.livesdk.pannel.SheetBaseDialog, androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        int r101 = b1.f158888a;
        Function0<Unit> r102 = new AudienceWebcastSettingDialog$initDialogUI$1(this);
        Intrinsics.checkNotNullParameter(this, "dialog");
        Intrinsics.checkNotNullParameter(r102, "keepCurSetting");
        if (((Boolean) SettingUtil.getValue("key_ttlive_sdk_setting", "live_panel_standardized", Boolean.TYPE, Boolean.FALSE)).booleanValue() == false) goto L5;
        N0();
    L6:
        b1.b(true, new AudienceWebcastSettingDialog$initDialogUI$2(this));
        Pair<? extends np1.c, ? extends Disposable> r103 = com.bytedance.live.datacontext.d.a(new AudienceWebcastSettingDialog$initData$1(this));
        this.C = r103;
        if (r103 == null) goto L54;
        np1.c r104 = r103.getFirst();
        if (r104 == null) goto L54;
        this.D = r104;
        List<np1.b> r105 = this.B;
        np1.b r106 = SmallWindowItem.a(r104);
        if (r106 == null) goto L14;
        r105.add(r106);
    L14:
        List<np1.b> r107 = this.B;
        int r108 = IndependentTaskItem.f116719a;
        np1.c r109 = this.D;
        if (r109 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("panelContext");
    L17:
        np1.b r110 = IndependentTaskItem.a(r109);
        if (r110 == null) goto L20;
        r107.add(r110);
    L20:
        List<np1.b> r111 = this.B;
        int r112 = DiggItem.f116717a;
        np1.c r113 = this.D;
        if (r113 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("panelContext");
    L23:
        np1.b r114 = DiggItem.a(r113);
        if (r114 == null) goto L26;
        r111.add(r114);
    L26:
        List<np1.b> r115 = this.B;
        np1.c r116 = this.D;
        if (r116 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("panelContext");
    L29:
        PermissionGrantedItem r117 = new PermissionGrantedItem(r116);
        r117.f116720a = true;
        r117.f116721b = new qk1.a();
        r117.f116724e.getCd().add(Disposables.fromAction(new com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.settingpanel.item.a(r117)));
        Unit r118 = Unit.INSTANCE;
        np1.c r119 = this.D;
        if (r119 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("panelContext");
    L32:
        np1.b r120 = r117.a(r119);
        if (r120 == null) goto L35;
        r115.add(r120);
    L35:
        List<np1.b> r121 = this.B;
        x r122 = PublicScreenConfigItem.f116739a;
        np1.c r123 = this.D;
        if (r123 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("panelContext");
    L38:
        np1.b r124 = PublicScreenConfigItem.a(r123);
        if (r124 == null) goto L41;
        r121.add(r124);
    L41:
        List<np1.b> r125 = this.B;
        ArrayList r126 = new ArrayList();
        Iterator<T> r127 = r125.iterator();
    L43:
        if (r127.hasNext() == false) goto L53;
        Object r128 = r127.next();
        np1.b r129 = (np1.b) r128;
        if ((r129 instanceof np1.g) == true) goto L47;
    L50:
        boolean r130 = true;
    L51:
        if (r130 == false) goto L43;
        r126.add(r128);
        goto L43
    L47:
        if (((ArrayList) ((np1.g) r129).f520024d).isEmpty() == false) goto L50;
        r130 = false;
        goto L51
    L53:
        this.B = CollectionsKt.toMutableList(r126);
    L54:
        this.E = (RecyclerView) findViewById(R.id.recyclerView);
        AudiencePortraitSettingAdapter r131 = new AudiencePortraitSettingAdapter(this.B, false);
        RecyclerView r132 = this.E;
        if (r132 == null) goto L57;
        r132.setAdapter(r131);
    L57:
        RecyclerView r133 = this.E;
        if (r133 == null) goto L66;
        r133.addItemDecoration(new DivideItemDecoration());
        return;
    L66:
        return;
    L5:
        r102.invoke();
        goto L6
    }
}
