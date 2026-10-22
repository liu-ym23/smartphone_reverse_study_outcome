package com.bytedance.android.live.liveinteract.feedv2.feedview;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.livesdk.ktvapi.IKtvService;
import com.bytedance.android.livesdk.message.model.cj;
import com.bytedance.android.livesdk.message.model.qb;
import com.bytedance.android.livesdkapi.depend.message.RoomLinkMicSyncData;
import com.bytedance.android.livesdkapi.feed.IInteractFeedView;
import com.bytedance.android.livesdkapi.feed.IKtvRoomFeedView;
import com.bytedance.android.livesdkapi.feed.data.IPreviewMultiLinkOuterConfigProvider;
import com.bytedance.android.livesdkapi.interact.data.LinkFeedTypeConstant;
import com.bytedance.android.livesdkapi.model.SeiAppData;
import com.bytedance.android.livesdkapi.roomplayer.LivePlayerView;
import com.bytedance.android.livesdkapi.view.IRenderView;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.BehaviorSubject;
import java.util.HashMap;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes46.dex */
public final class g0 implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public IPreviewMultiLinkOuterConfigProvider f73157a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public te0.a f73158b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public IKtvRoomFeedView f73159c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CompositeDisposable f73160d;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.live.liveinteract.feedv2.feedview.a
    public final void f(qb r100) {
    }

    @Override // com.bytedance.android.live.liveinteract.feedv2.feedview.a
    public final String getFeedViewName() {
        return "MultiLinkKtvRoomFeedPreview";
    }

    @Override // com.bytedance.android.live.liveinteract.feedv2.feedview.a
    public final void j(cj r100) {
    }

    @Override // com.bytedance.android.live.liveinteract.feedv2.feedview.a
    public final void m(int r100, int r101, List<Integer> r102) {
    }

    @Override // com.bytedance.android.live.liveinteract.feedv2.feedview.a
    public final void onLivePlayerVideoSizeChanged() {
    }

    @Override // com.bytedance.android.live.liveinteract.feedv2.feedview.a
    public final void removeEffectView() {
    }

    @Override // com.bytedance.android.live.liveinteract.feedv2.feedview.a
    public final void s() {
    }

    private final Context getContext() {
        IPreviewMultiLinkOuterConfigProvider r100 = this.f73157a;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L6:
        return r100.getContext();
    }

    @Override // com.bytedance.android.live.liveinteract.feedv2.feedview.b
    public final Object getCurrentSeiParseResultData() {
        IKtvRoomFeedView r100 = this.f73159c;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getCurrentSeiParseResultData();
    }

    @Override // com.bytedance.android.live.liveinteract.feedv2.feedview.b
    public final String getCurrentSingUserIdString() {
        IKtvRoomFeedView r100 = this.f73159c;
        if (r100 == null) goto L6;
        String r101 = r100.getCurrentSingUserIdString();
        if (r101 == null) goto L6;
        return r101;
    L6:
        return "";
    }

    @Override // com.bytedance.android.live.liveinteract.feedv2.feedview.a
    public final FrameLayout.LayoutParams getKtvComponentLayoutParams() {
        return new FrameLayout.LayoutParams(-1, -2);
    }

    @Override // com.bytedance.android.live.liveinteract.feedv2.feedview.b
    public final HashMap<String, Object> getKtvEnterRoomExtraParam() {
        IKtvRoomFeedView r100 = this.f73159c;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getKtvEnterRoomExtraParam();
    }

    @Override // com.bytedance.android.live.liveinteract.feedv2.feedview.b
    public final Object getKtvSeiModelObject() {
        IKtvRoomFeedView r100 = this.f73159c;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getKtvSeiModelObject();
    }

    @Override // com.bytedance.android.live.liveinteract.feedv2.feedview.a
    public final View getViewCompat() {
        IKtvRoomFeedView r100 = this.f73159c;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getViewCompat();
    }

    @Override // com.bytedance.android.live.liveinteract.feedv2.feedview.a
    public final void onViewHolderPause() {
        IKtvRoomFeedView r100 = this.f73159c;
        if (r100 == null) goto L6;
        r100.onViewHolderPause();
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.feedv2.feedview.a
    public final void onViewHolderResume() {
        IKtvRoomFeedView r100 = this.f73159c;
        if (r100 == null) goto L6;
        r100.onViewHolderResume();
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.feedv2.feedview.a
    public final void onViewHolderSelected() {
        IPreviewMultiLinkOuterConfigProvider r100 = this.f73157a;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L5:
        IPreviewMultiLinkOuterConfigProvider.DefaultImpls.printALogger$default(r100, "MultiLinkKtvRoomFeedPreview", hashCode(), "onViewHolderSelected", false, 8, null);
        IKtvRoomFeedView r101 = this.f73159c;
        if (r101 == null) goto L9;
        r101.onViewHolderSelected();
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.feedv2.feedview.a
    public final void onViewHolderUnSelected() {
        IPreviewMultiLinkOuterConfigProvider r100 = this.f73157a;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L5:
        IPreviewMultiLinkOuterConfigProvider.DefaultImpls.printALogger$default(r100, "MultiLinkKtvRoomFeedPreview", hashCode(), "onViewHolderUnSelected", false, 8, null);
        IKtvRoomFeedView r101 = this.f73159c;
        if (r101 == null) goto L9;
        r101.onViewHolderUnSelected();
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.feedv2.feedview.a
    public final void release() {
        this.f73160d.dispose();
        IKtvRoomFeedView r100 = this.f73159c;
        if (r100 == null) goto L6;
        r100.reset();
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.feedv2.feedview.b
    public final void resetKtvSeiModelObject() {
        IKtvRoomFeedView r100 = this.f73159c;
        if (r100 == null) goto L6;
        r100.resetKtvSeiModelObject();
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.feedv2.feedview.b
    public final void setRenderViewBitmapToMockView() {
        IKtvRoomFeedView r100 = this.f73159c;
        if (r100 == null) goto L6;
        r100.setRenderViewBitmapToMockView();
        return;
    }

    public g0() {
        this.f73160d = new CompositeDisposable();
    }

    @Override // com.bytedance.android.live.liveinteract.feedv2.feedview.a
    public final void e(String r100) {
        Intrinsics.checkNotNullParameter(r100, "seiString");
        IKtvRoomFeedView r101 = this.f73159c;
        if (r101 == null) goto L6;
        r101.onSeiUpdatedRaw(r100);
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.feedv2.feedview.a
    public final void h(SeiAppData r100) {
        Intrinsics.checkNotNullParameter(r100, "seiAppData");
        IKtvRoomFeedView r101 = this.f73159c;
        if (r101 == null) goto L6;
        r101.onSeiUpdated(r100);
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.feedv2.feedview.b
    public final void onKtvVideoStateChange(ld0.a r100) {
        Intrinsics.checkNotNullParameter(r100, "seiData");
        IKtvRoomFeedView r101 = this.f73159c;
        if (r101 == null) goto L6;
        r101.onKtvVideoStateChange(r100);
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.feedv2.feedview.a
    public final void updateMvControllerSei(String r100) {
        Intrinsics.checkNotNullParameter(r100, "sei");
        Intrinsics.checkNotNullParameter(r100, "sei");
        Intrinsics.checkNotNullParameter(r100, "sei");
    }

    @Override // com.bytedance.android.live.liveinteract.feedv2.feedview.a
    public final void updatePreloadRoomLinkMicSyncData(RoomLinkMicSyncData r100) {
        Intrinsics.checkNotNullParameter(r100, "wrds");
        Intrinsics.checkNotNullParameter(r100, "wrds");
        Intrinsics.checkNotNullParameter(r100, "wrds");
    }

    @Override // com.bytedance.android.live.liveinteract.feedv2.feedview.a
    public final void updateRadioSei(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "sei");
        Intrinsics.checkNotNullParameter(r100, "sei");
        Intrinsics.checkNotNullParameter(r100, "sei");
    }

    @Override // com.bytedance.android.live.liveinteract.feedv2.feedview.a
    public final void updateRadioTextSei(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "sei");
        Intrinsics.checkNotNullParameter(r100, "sei");
        Intrinsics.checkNotNullParameter(r100, "sei");
    }

    @Override // com.bytedance.android.live.liveinteract.feedv2.feedview.a
    public final void updateSpeechRecognitionSei(String r100) {
        Intrinsics.checkNotNullParameter(r100, "sei");
        Intrinsics.checkNotNullParameter(r100, "sei");
        Intrinsics.checkNotNullParameter(r100, "sei");
    }

    @Override // com.bytedance.android.live.liveinteract.feedv2.feedview.a
    public final void updateSpeechRhythmSei(String r100) {
        Intrinsics.checkNotNullParameter(r100, "sei");
        Intrinsics.checkNotNullParameter(r100, "sei");
        Intrinsics.checkNotNullParameter(r100, "sei");
    }

    @Override // com.bytedance.android.live.liveinteract.feedv2.feedview.a
    public final void updateSubtitleSei(String r100) {
        Intrinsics.checkNotNullParameter(r100, "sei");
        Intrinsics.checkNotNullParameter(r100, "sei");
        Intrinsics.checkNotNullParameter(r100, "sei");
    }

    @Override // com.bytedance.android.live.liveinteract.feedv2.feedview.a
    public final void b(String r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "syncKey");
        IKtvRoomFeedView r102 = this.f73159c;
        if (r102 == null) goto L6;
        r102.onWrdsDataUpdate(r100, r101);
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.feedv2.feedview.a
    public final void insertEffectView(View r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r100, "view");
    }

    @Override // com.bytedance.android.live.liveinteract.feedv2.feedview.a
    public final void o(IPreviewMultiLinkOuterConfigProvider r110, te0.a r111) {
        Intrinsics.checkNotNullParameter(r110, "configOuterProvider");
        Intrinsics.checkNotNullParameter(r111, "configInnerProvider");
        this.f73157a = r110;
        this.f73158b = r111;
        if (r110 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L5:
        IPreviewMultiLinkOuterConfigProvider.DefaultImpls.printALogger$default(r110, "MultiLinkKtvRoomFeedPreview", hashCode(), "initView", false, 8, null);
        LinkFeedTypeConstant.Companion r112 = LinkFeedTypeConstant.Companion;
        IPreviewMultiLinkOuterConfigProvider r113 = this.f73157a;
        if (r113 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L8:
        boolean r114 = !r112.isDouyinFullScreen(r113.getShowFrom());
        IKtvService r115 = (IKtvService) jc1.k.f(IKtvService.class);
        IRenderView r100 = null;
        if (r115 == null) goto L14;
        Context r101 = getContext();
        IPreviewMultiLinkOuterConfigProvider r102 = this.f73157a;
        if (r102 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L13:
        IInteractFeedView r116 = r115.getKtvRoomFeedView(r101, r114, r102.getShowFrom());
    L15:
        if (r116 == null) goto L83;
        IKtvRoomFeedView r117 = (IKtvRoomFeedView) r116;
        this.f73159c = r117;
        IPreviewMultiLinkOuterConfigProvider r118 = this.f73157a;
        if (r118 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L19:
        r117.updateMessageHub(r118.getMessageHub());
        int r119 = com.bytedance.android.live.liveinteract.plantform.datamergev2.g.f76654a;
        IPreviewMultiLinkOuterConfigProvider r120 = this.f73157a;
        if (r120 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L23:
        if (com.bytedance.android.live.liveinteract.plantform.datamergev2.g.a(r120.getShowFrom()) == false) goto L32;
        te0.a r121 = this.f73158b;
        if (r121 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("configInnerProvider");
    L27:
        com.bytedance.android.live.liveinteract.plantform.datamergev2.h r122 = r121.c();
        if (r122 == null) goto L40;
        IKtvRoomFeedView r123 = this.f73159c;
        if (r123 == null) goto L40;
        r123.setDataMergeCenterV2(r122);
    L40:
        IKtvRoomFeedView r124 = this.f73159c;
        if (r124 == null) goto L49;
        IPreviewMultiLinkOuterConfigProvider r125 = this.f73157a;
        if (r125 != null) goto L45;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L45:
        String r126 = r125.getEnterFromMerge();
        IPreviewMultiLinkOuterConfigProvider r103 = this.f73157a;
        if (r103 != null) goto L48;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L48:
        r124.updateEnterFrom(r126, r103.getEnterMethod());
    L49:
        IKtvRoomFeedView r127 = this.f73159c;
        if (r127 == null) goto L55;
        IPreviewMultiLinkOuterConfigProvider r128 = this.f73157a;
        if (r128 != null) goto L54;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L54:
        r127.updateRoom(r128.getRoom());
    L55:
        IKtvRoomFeedView r129 = this.f73159c;
        if (r129 == null) goto L61;
        IPreviewMultiLinkOuterConfigProvider r130 = this.f73157a;
        if (r130 != null) goto L60;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L60:
        r129.setLivePlayerContainerAbility(r130.getPlayerContainerAbility());
    L61:
        IKtvRoomFeedView r131 = this.f73159c;
        if (r131 == null) goto L71;
        IPreviewMultiLinkOuterConfigProvider r132 = this.f73157a;
        if (r132 != null) goto L66;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L66:
        if (r132 == null) goto L70;
        LivePlayerView r133 = r132.getLivePlayerView();
        if (r133 == null) goto L70;
        r100 = r133.getRenderView();
    L70:
        r131.setLivePlayerView(r100);
    L71:
        te0.a r134 = this.f73158b;
        if (r134 != null) goto L74;
        Intrinsics.throwUninitializedPropertyAccessException("configInnerProvider");
    L74:
        ue0.c r135 = r134.f();
        if (r135 == null) goto L84;
        BehaviorSubject<List<ch0.e>> r136 = r135.f549768b;
        if (r136 == null) goto L85;
        Disposable r137 = r136.subscribe(new h0(this));
        if (r137 == null) goto L86;
        RxUtilKt.c(r137, this.f73160d);
        return;
    L86:
        return;
    L85:
        return;
    L84:
        return;
    L32:
        te0.a r138 = this.f73158b;
        if (r138 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("configInnerProvider");
    L35:
        ue0.c r139 = r138.f();
        if (r139 == null) goto L40;
        IKtvRoomFeedView r140 = this.f73159c;
        if (r140 == null) goto L40;
        r140.setDataMergeCenter(r139);
        goto L40
    L83:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdkapi.feed.IKtvRoomFeedView");
    L14:
        r116 = null;
        goto L15
    }
}
