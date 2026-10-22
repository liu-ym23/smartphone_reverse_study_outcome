package com.bytedance.android.livesdk.interactivity.barrage.setting.vs;

import a62.d;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.interactivity.api.barrage.model.BarrageSetting;
import com.bytedance.android.livesdk.interactivity.api.settings.config.a1;
import com.bytedance.android.livesdk.interactivity.barrage.setting.InterceptConstraintLayout;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import jc1.k;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/barrage/setting/vs/BarrageSettingBlockWidget;", "Lcom/bytedance/android/livesdk/interactivity/barrage/setting/vs/AbsBarrageSettingWidget;", "Landroid/view/View$OnClickListener;", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BarrageSettingBlockWidget extends AbsBarrageSettingWidget implements View.OnClickListener {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ImageView f133940c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f133941d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f133942e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ImageView f133943f;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BarrageSettingBlockWidget f133944a;

        public a(BarrageSettingBlockWidget r100) {
            this.f133944a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            BarrageSettingBlockWidget r100 = this.f133944a;     // Catch: Throwable -> L12
            TextView r101 = r100.f133941d;     // Catch: Throwable -> L12
            if (r101 == null) goto L5;
            r101.setOnClickListener(r100);     // Catch: Throwable -> L12
        L5:
            ImageView r102 = r100.f133940c;     // Catch: Throwable -> L12
            if (r102 == null) goto L8;
            r102.setOnClickListener(r100);     // Catch: Throwable -> L12
        L8:
            BarrageSettingBlockWidget r103 = this.f133944a;     // Catch: Throwable -> L12
            ImageView r104 = r103.f133940c;     // Catch: Throwable -> L12
            if (r104 == null) goto L15;
            r104.setSelected(r103.f133928a.isGiftOpen());     // Catch: Throwable -> L12
            return;
        L15:
            return;
        L12:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L19;
            throw th;
        }
    }

    @Override // com.bytedance.ies.sdk.widgets.Widget
    public final int getLayoutId() {
        return R.layout.ttlive_layout_vs_live_barrage_setting_block;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onUnload() {
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        ImageView r101 = this.f133940c;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.setSelected(!r101.isSelected());
        this.f133928a.setGiftOpen(r101.isSelected());
        this.f133929b.X50(this.f133928a);
        wq();
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onInit(Object[] r100) {
        this.f133940c = (ImageView) findViewById(R.id.live_barrage_giftmessage);
        this.f133941d = (TextView) findViewById(R.id.ttlive_barrage_setting_gift_text);
        this.f133942e = findViewById(R.id.live_barrage_carnival_layout);
        this.f133943f = (ImageView) findViewById(R.id.live_barrage_carnival_icon);
        TextView r101 = (TextView) findViewById(R.id.live_barrage_carnival_text);
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onLoad(Object[] r100) {
        ViewGroup r101 = this.containerView;
        if (r101 == null) goto L5;
        r101.post(new a(this));
    L5:
        IRoomContextService r102 = (IRoomContextService) k.f(IRoomContextService.class);
        if (r102 == null) goto L8;
        o r103 = IRoomContextService.a.a(r102, this.dataCenter, 0, 2);
    L9:
        if (r103 == null) goto L11;
        Boolean r104 = r103.isVSRoom();
    L13:
        if (Intrinsics.areEqual(r104, Boolean.TRUE) == false) goto L17;
        int r105 = a1.f133760a;
        if (a1.a.a().d() == false) goto L17;
        boolean r106 = true;
    L18:
        if (r106 == false) goto L25;
        View r107 = this.f133942e;
        if (r107 == null) goto L22;
        UtilityKotlinExtentionsKt.w(r107);
    L22:
        View r108 = this.f133942e;
        if (r108 == null) goto L31;
        r108.setOnClickListener(new d(this));
    L31:
        ImageView r109 = this.f133943f;
        if (r109 == null) goto L35;
        r109.setSelected(this.f133928a.isCarnivalBarrageOpen());
        return;
    L35:
        return;
    L25:
        View r110 = this.f133942e;
        if (r110 == null) goto L28;
        UtilityKotlinExtentionsKt.t(r110);
    L28:
        View r111 = this.f133942e;
        if (r111 == null) goto L31;
        r111.setOnClickListener(null);
    L17:
        r106 = false;
        goto L18
    L11:
        r104 = null;
        goto L13
    L8:
        r103 = null;
        goto L9
    }

    @Override // com.bytedance.android.livesdk.interactivity.barrage.setting.vs.AbsBarrageSettingWidget
    public final void xq(BarrageSetting r100) {
        Intrinsics.checkNotNullParameter(r100, "barrageSetting");
        Intrinsics.checkNotNullParameter(r100, "barrageSetting");
        this.f133928a = r100;
        ImageView r101 = this.f133940c;
        if (r101 == null) goto L5;
        r101.setSelected(r100.isGiftOpen());
    L5:
        ImageView r102 = this.f133943f;
        if (r102 == null) goto L9;
        r102.setSelected(this.f133928a.isCarnivalBarrageOpen());
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.barrage.setting.vs.AbsBarrageSettingWidget
    public final void yq(boolean r100) {
        View r101 = this.contentView;
        if ((r101 instanceof InterceptConstraintLayout) == true) goto L5;
        r101 = null;
    L5:
        InterceptConstraintLayout r102 = (InterceptConstraintLayout) r101;
        if (r102 == null) goto L13;
        r102.setmIsIntercept(r100);
        if (r100 == false) goto L10;
        float r103 = 0.5f;
    L11:
        r102.setAlpha(r103);
        return;
    L10:
        r103 = 1.0f;
        goto L11
    }

    public BarrageSettingBlockWidget(BarrageSetting r100, AbsBarrageSettingWidget.a r101) {
        Intrinsics.checkNotNullParameter(r100, "barrageSetting");
        Intrinsics.checkNotNullParameter(r101, "callback");
        super(r100, r101);
    }
}
