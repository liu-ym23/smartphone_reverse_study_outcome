package com.bytedance.android.livesdk.chatroom.viewmodule;

import android.content.Context;
import android.view.ViewGroup;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.core.utils.StatusBarUtil;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livehostapi.platform.IHostAction;
import com.larus.nova.R;
import com.ss.android.lark.picker.base.widget.utils.FakePickerAvatarCreator;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/LiveWaterMaskWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveWaterMaskWidget extends LiveRecyclableWidget {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public HSImageView f114986a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public HSImageView f114987b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f114988c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f114989d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Boolean f114990e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f114991f;

    @Override // com.bytedance.ies.sdk.widgets.Widget
    public final int getLayoutId() {
        return R.layout.ttlive_water_mask;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onUnload() {
    }

    public LiveWaterMaskWidget() {
        this.f114988c = StatusBarUtil.isStatusBarTransparent();
        this.f114990e = com.bytedance.android.livesdk.r2.f156923a.getValue();
        this.f114991f = FakePickerAvatarCreator.GRAY;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onInit(Object[] r100) {
        this.f114986a = (HSImageView) this.contentView.findViewById(R.id.room_top_mask_view);
        this.f114987b = (HSImageView) this.contentView.findViewById(R.id.room_bottom_mask_view);
        this.f114989d = StatusBarUtil.getStatusBarHeight(this.context);
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onLoad(Object[] r100) {
        if (com.bytedance.android.live.core.utils.v.a() == true) goto L5;
    L12:
        Object r101 = null;
        if (isScreenPortrait() == false) goto L57;
        HSImageView r102 = this.f114987b;
        if (r102 == null) goto L17;
        UtilityKotlinExtentionsKt.w(r102);
    L17:
        HSImageView r103 = this.f114986a;
        if (r103 == null) goto L20;
        ViewGroup.LayoutParams r104 = r103.getLayoutParams();
    L22:
        if ((r104 instanceof ViewGroup.MarginLayoutParams) == true) goto L24;
        r104 = null;
    L24:
        ViewGroup.MarginLayoutParams r105 = (ViewGroup.MarginLayoutParams) r104;
        if (r105 != null) goto L27;
        return;
    L27:
        r105.height = UtilityKotlinExtentionsKt.i(72);
        if (this.f114988c == false) goto L30;
        int r106 = this.f114989d;
    L31:
        r105.topMargin = r106;
        r105.leftMargin = UtilityKotlinExtentionsKt.i(9);
        r105.rightMargin = UtilityKotlinExtentionsKt.i(9);
        HSImageView r107 = this.f114986a;
        if (r107 == null) goto L34;
        r107.setLayoutParams(r105);
    L34:
        HSImageView r108 = this.f114987b;
        if (r108 == null) goto L37;
        ViewGroup.LayoutParams r109 = r108.getLayoutParams();
    L39:
        if ((r109 instanceof ViewGroup.MarginLayoutParams) == true) goto L41;
        r109 = null;
    L41:
        ViewGroup.MarginLayoutParams r110 = (ViewGroup.MarginLayoutParams) r109;
        if (r110 != null) goto L44;
        return;
    L44:
        r110.height = UtilityKotlinExtentionsKt.i(144);
        r110.leftMargin = UtilityKotlinExtentionsKt.i(9);
        r110.rightMargin = UtilityKotlinExtentionsKt.i(6);
        r110.bottomMargin = UtilityKotlinExtentionsKt.i(52);
        HSImageView r111 = this.f114987b;
        if (r111 == null) goto L47;
        r111.setLayoutParams(r110);
    L47:
        HSImageView r112 = this.f114987b;
        if (r112 == null) goto L81;
        Object r113 = this.context;
        if ((r113 instanceof LifecycleOwner) == true) goto L52;
        r113 = null;
    L52:
        LifecycleOwner r114 = (LifecycleOwner) r113;
        if (r114 == null) goto L81;
        IHostAction r115 = (IHostAction) jc1.k.f(IHostAction.class);
        if (r115 == null) goto L81;
        r115.putWatermarkInView(r114, r112);
    L81:
        HSImageView r116 = this.f114986a;
        if (r116 == null) goto L93;
        Context r117 = this.context;
        if ((r117 instanceof LifecycleOwner) == false) goto L87;
        r101 = r117;
    L87:
        LifecycleOwner r118 = (LifecycleOwner) r101;
        if (r118 == null) goto L94;
        IHostAction r119 = (IHostAction) jc1.k.f(IHostAction.class);
        if (r119 == null) goto L95;
        r119.putWatermarkInView(r118, r116);
        return;
    L95:
        return;
    L94:
        return;
    L93:
        return;
    L37:
        r109 = null;
        goto L39
    L30:
        r106 = UtilityKotlinExtentionsKt.i(2);
        goto L31
    L20:
        r104 = null;
        goto L22
    L57:
        HSImageView r120 = this.f114987b;
        if (r120 == null) goto L60;
        UtilityKotlinExtentionsKt.t(r120);
    L60:
        HSImageView r121 = this.f114986a;
        if (r121 == null) goto L63;
        ViewGroup.LayoutParams r122 = r121.getLayoutParams();
    L65:
        if ((r122 instanceof ViewGroup.MarginLayoutParams) == true) goto L67;
        r122 = null;
    L67:
        ViewGroup.MarginLayoutParams r123 = (ViewGroup.MarginLayoutParams) r122;
        if (r123 != null) goto L70;
        return;
    L70:
        r123.height = UtilityKotlinExtentionsKt.i(72);
        r123.topMargin = UtilityKotlinExtentionsKt.i(9);
        if (this.f114988c == false) goto L73;
        int r124 = UtilityKotlinExtentionsKt.i(46);
    L74:
        r123.leftMargin = r124;
        if (this.f114988c == false) goto L77;
        int r125 = UtilityKotlinExtentionsKt.i(46);
    L78:
        r123.rightMargin = r125;
        HSImageView r126 = this.f114986a;
        if (r126 == null) goto L81;
        r126.setLayoutParams(r123);
        goto L81
    L77:
        r125 = UtilityKotlinExtentionsKt.i(56) - this.f114989d;
        goto L78
    L73:
        r124 = UtilityKotlinExtentionsKt.i(56) - this.f114989d;
        goto L74
    L63:
        r122 = null;
        goto L65
    L5:
        if (this.f114990e.booleanValue() == false) goto L12;
        HSImageView r127 = this.f114986a;
        if (r127 == null) goto L9;
        r127.setBackgroundColor(this.f114991f);
    L9:
        HSImageView r128 = this.f114987b;
        if (r128 == null) goto L12;
        r128.setBackgroundColor(this.f114991f);
        goto L12
    }
}
