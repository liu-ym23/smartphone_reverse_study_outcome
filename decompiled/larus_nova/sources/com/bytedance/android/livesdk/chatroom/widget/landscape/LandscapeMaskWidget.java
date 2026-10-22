package com.bytedance.android.livesdk.chatroom.widget.landscape;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.utils.VrUtils;
import com.bytedance.android.livesdk.chatroom.widget.RoomRecyclableWidget;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.rxbus.RxBusAbility;
import com.bytedance.android.livesdkapi.util.InfraKotlinExtsKt;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.larus.nova.R;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import zg1.n3;
import zg1.x0;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/widget/landscape/LandscapeMaskWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/RoomRecyclableWidget;", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LandscapeMaskWidget extends RoomRecyclableWidget {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f118901a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f118902b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f118903c;

    public static final class a<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LandscapeMaskWidget f118904a;

        public a(LandscapeMaskWidget r100) {
            this.f118904a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            n3 r101 = (n3) r100;
            Intrinsics.checkNotNullParameter(r101, "event");
            LandscapeMaskWidget r102 = this.f118904a;
            DataCenter r103 = r102.dataCenter;
            int r104 = 0;
            if (VrUtils.s() == true) goto L8;
            View r105 = r102.contentView;
            if (r105 == null) goto L8;
            r105.setVisibility(0);
        L8:
            if (VrUtils.t(r102.dataCenter, false) == true) goto L12;
            View r106 = r102.contentView;
            if (r106 == null) goto L20;
            r106.setVisibility(0);
            return;
        L20:
            return;
        L12:
            View r107 = r102.contentView;
            if (r107 == null) goto L22;
            if (r101 != null) goto L16;
        L18:
            r107.setVisibility(r104);
            return;
        L16:
            if (r101.f571889a != true) goto L18;
            r104 = 8;
            goto L18
        }
    }

    public final class b implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f118905a;

        public b(Function1 r100) {
            this.f118905a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final /* synthetic */ void accept(Object r100) {
            this.f118905a.invoke(r100);
        }
    }

    @Override // com.bytedance.ies.sdk.widgets.Widget
    public final int getLayoutId() {
        return R.layout.ttlive_landscape_mask_new;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onUnload() {
    }

    public LandscapeMaskWidget() {
        this.f118903c = InfraKotlinExtsKt.mainThreadLazy(LandscapeMaskWidget$maskAlpha$2.INSTANCE);
    }

    public final void onEvent(x0 r100) {
        RoomContext r101 = getDataContext();
        if (r101 == null) goto L9;
        com.bytedance.live.datacontext.m<Boolean> r102 = r101.isOptLandscapeMargin();
        if (r102 == null) goto L9;
        int r103 = 1;
        if (r102.getValue().booleanValue() != true) goto L9;
    L10:
        int r104 = (-r100.f571977c) - r103;
        int r105 = -r100.f571978d;
        UIUtils.updateLayoutMargin(this.contentView, r104, -3, r105, -3);
        return;
    L9:
        r103 = 0;
        goto L10
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onInit(Object[] r100) {
        this.f118901a = findViewById(R.id.top_mask);
        this.f118902b = findViewById(R.id.landscape_bottom_mask);
        View r101 = this.f118901a;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("topMaskView");
    L5:
        r101.setAlpha(((Number) this.f118903c.getValue()).floatValue());
        View r102 = this.f118902b;
        if (r102 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("bottomMaskView");
    L8:
        r102.setAlpha(((Number) this.f118903c.getValue()).floatValue());
        View r103 = this.contentView;
        if (r103 == null) goto L17;
        ((ViewGroup) r103).setClipToPadding(false);
        View r104 = this.contentView;
        if (r104 == null) goto L15;
        ((ViewGroup) r104).setClipChildren(false);
        return;
    L15:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    L17:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onLoad(Object[] r100) {
        View r101 = this.f118901a;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("topMaskView");
    L5:
        r101.setTranslationY(0.0f);
        View r102 = this.f118902b;
        if (r102 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("bottomMaskView");
    L8:
        r102.setTranslationY(0.0f);
        if (z.o(this.dataCenter).isMediaRoom() == false) goto L14;
        View r103 = this.f118902b;
        if (r103 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("bottomMaskView");
    L13:
        r103.setVisibility(8);
    L18:
        RoomContext r104 = getDataContext();
        if (r104 == null) goto L24;
        com.bytedance.live.datacontext.m<x0> r105 = r104.getLandscapeRootChange();
        if (r105 == null) goto L24;
        onEvent(r105.getValue());
        ((ObservableSubscribeProxy) r105.a().observeOn(AndroidSchedulers.mainThread()).as(autoDispose())).subscribe(new b(new LandscapeMaskWidget$onLoad$1$1(this)));
    L24:
        if (VrUtils.t(this.dataCenter, false) == false) goto L27;
        a r106 = new a(this);
        ((ObservableSubscribeProxy) RxBusAbility.INSTANCE.getRxBus(this.dataCenter).b(n3.class).observeOn(AndroidSchedulers.mainThread()).as(AutoDispose.bind(this))).subscribe(r106);
    L27:
        if (VrUtils.s() == true) goto L29;
    L33:
        View r107 = this.contentView;
        if (r107 == null) goto L39;
        r107.setVisibility(0);
        return;
    L39:
        return;
    L29:
        if (VrUtils.t(this.dataCenter, false) == false) goto L33;
        View r108 = this.contentView;
        if (r108 == null) goto L37;
        r108.setVisibility(8);
        return;
    L37:
        return;
    L14:
        View r109 = this.f118902b;
        if (r109 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("bottomMaskView");
    L17:
        r109.setVisibility(0);
        goto L18
    }
}
