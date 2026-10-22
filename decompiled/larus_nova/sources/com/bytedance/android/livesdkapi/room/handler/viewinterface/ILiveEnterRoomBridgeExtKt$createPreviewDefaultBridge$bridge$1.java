package com.bytedance.android.livesdkapi.room.handler.viewinterface;

import android.os.Bundle;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.livesdkapi.room.handler.enterroom.ILiveEnterRoomCallback;
import com.bytedance.android.livesdkapi.room.handler.enterroom.ILiveEnterRoomParams;
import com.bytedance.android.livesdkapi.room.handler.enterroom.ILiveEnterRoomScene;
import com.bytedance.android.livesdkapi.room.handler.enterroom.ILivePreviewBusinessBridge;
import com.bytedance.android.livesdkapi.room.handler.enterroom.ILivePreviewBusinessSession;
import com.bytedance.android.livesdkapi.room.handler.enterroom.PreviewReportBuilder;
import com.bytedance.android.livesdkapi.room.handler.enterroom.PreviewReportData;
import com.bytedance.livesdk.preview.merge.AbsMergeWidget;
import com.bytedance.livesdk.preview.merge.MergeDataContext;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000M\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u000e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0016J\u000e\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0016J)\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00142\u0017\u0010\u0015\u001a\u0013\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00100\u0016¢\u0006\u0002\b\u0018H\u0016J$\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00142\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00140\u001aH\u0016R\u0014\u0010\u0002\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u001b"}, d2 = {"com/bytedance/android/livesdkapi/room/handler/viewinterface/ILiveEnterRoomBridgeExtKt$createPreviewDefaultBridge$bridge$1", "Lcom/bytedance/android/livesdkapi/room/handler/enterroom/ILivePreviewBusinessBridge;", "onBridgeReleaseCd", "Lio/reactivex/disposables/CompositeDisposable;", "getOnBridgeReleaseCd", "()Lio/reactivex/disposables/CompositeDisposable;", AppbrandHostConstants.SCHEMA_INSPECT.SESSION, "Lcom/bytedance/android/livesdkapi/room/handler/enterroom/ILivePreviewBusinessSession;", "getSession", "()Lcom/bytedance/android/livesdkapi/room/handler/enterroom/ILivePreviewBusinessSession;", "enterRoom", "", "callback", "Lcom/bytedance/android/livesdkapi/room/handler/enterroom/ILiveEnterRoomCallback;", "observeVHSelect", "Lio/reactivex/Observable;", "", "observeVHUnselect", "sendLogger", "eventName", "", "builder", "Lkotlin/Function1;", "Lcom/bytedance/android/livesdkapi/room/handler/enterroom/PreviewReportBuilder;", "Lkotlin/ExtensionFunctionType;", "logExtra", "", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ILiveEnterRoomBridgeExtKt$createPreviewDefaultBridge$bridge$1 implements ILivePreviewBusinessBridge {
    final /* synthetic */ ILiveEnterRoomScene $scene;
    final /* synthetic */ AbsMergeWidget $this_createPreviewDefaultBridge;
    private final ILivePreviewBusinessSession session;

    @Override // com.bytedance.android.livesdkapi.room.handler.enterroom.ILivePreviewBusinessBridge
    public CompositeDisposable getOnBridgeReleaseCd() {
        return ((IPreviewBridgeHost) this.$this_createPreviewDefaultBridge).getOnReleaseCd();
    }

    @Override // com.bytedance.android.livesdkapi.room.handler.enterroom.ILivePreviewBusinessBridge
    public Observable<Unit> observeVHSelect() {
        return ((IPreviewBridgeHost) this.$this_createPreviewDefaultBridge).getVhSelectObservable();
    }

    @Override // com.bytedance.android.livesdkapi.room.handler.enterroom.ILivePreviewBusinessBridge
    public Observable<Unit> observeVHUnselect() {
        return ((IPreviewBridgeHost) this.$this_createPreviewDefaultBridge).getVhUnSelectObservable();
    }

    @Override // com.bytedance.android.livesdkapi.room.handler.enterroom.ILivePreviewBusinessBridge
    public ILivePreviewBusinessSession getSession() {
        return this.session;
    }

    @Override // com.bytedance.android.livesdkapi.room.handler.enterroom.ILivePreviewBusinessBridge
    public boolean enterRoom(ILiveEnterRoomCallback r110) {
        Intrinsics.checkNotNullParameter(r110, "callback");
        if (this.$this_createPreviewDefaultBridge.getLoadedEnvironment() == AbsMergeWidget.MergeWidgetEnvironment.PREVIEW) goto L6;
        return false;
    L6:
        ILiveEnterRoomParams r100 = r110.getEnterParams(getSession());
        String r101 = r100.getEnterKey().getName();
        String r102 = r100.getClickMethod();
        Bundle r103 = r100.getBusinessBundle();
        Bundle r104 = r100.getFirstRoomLogParams();
        Map<String, String> r105 = r100.getCommonLogParams();
        if (v.a() == false) goto L9;
        ALogger.i("DefaultBridge_" + Reflection.getOrCreateKotlinClass(this.$this_createPreviewDefaultBridge.getClass()).getSimpleName(), "businesskey:" + r100.getEnterKey().getName() + "\tbusinessBundle:" + r103 + "\tfirstRoomLogParams:" + r104 + "\tcommonLogParams:" + r105);
    L9:
        r110.onBeforeEnterRoom(getSession());
        this.$this_createPreviewDefaultBridge.mergeEnterRoomWithAction(r101, r103, r102, r104, r105);
        return true;
    }

    /* JADX WARN: Incorrect types in method signature: (TT;Lcom/bytedance/android/livesdkapi/room/handler/enterroom/ILiveEnterRoomScene;)V */
    public ILiveEnterRoomBridgeExtKt$createPreviewDefaultBridge$bridge$1(AbsMergeWidget r100, ILiveEnterRoomScene r101) {
        this.$this_createPreviewDefaultBridge = r100;
        this.$scene = r101;
        this.session = new ILiveEnterRoomBridgeExtKt$createPreviewDefaultBridge$bridge$1$session$1(this);
    }

    @Override // com.bytedance.android.livesdkapi.room.handler.enterroom.ILivePreviewBusinessBridge
    public void sendLogger(String r100, Map<String, String> r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r101, "logExtra");
        MergeDataContext r102 = this.$this_createPreviewDefaultBridge.getMergeContext();
        if (r102 == null) goto L15;
        Function2<String, HashMap<String, String>, Unit> r103 = r102.getPreviewMobAction();
        if (r103 != null) goto L7;
        return;
    L7:
        if ((r101 instanceof HashMap) == true) goto L9;
        Map<String, String> r104 = null;
    L10:
        HashMap<String, String> r105 = (HashMap) r104;
        if (r105 != null) goto L13;
        r105 = new HashMap(r101);
    L13:
        Unit r106 = r103.invoke(r100, r105);
        return;
    L9:
        r104 = r101;
        goto L10
    }

    @Override // com.bytedance.android.livesdkapi.room.handler.enterroom.ILivePreviewBusinessBridge
    public void sendLogger(String r100, Function1<? super PreviewReportBuilder, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r101, "builder");
        PreviewReportBuilder r102 = new PreviewReportBuilder(this.$this_createPreviewDefaultBridge.dataCenter);
        r101.invoke(r102);
        PreviewReportData r103 = r102.build();
        r103.setDataCenter(r103.getDataCenter());
        sendLogger(r100, r103.getReportMap());
    }
}
