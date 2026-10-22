package com.bytedance.android.livesdkapi.room.handler.enterroom;

import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\u001bJ\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH&J\u000e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH&J\u000e\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH&J)\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00142\u0017\u0010\u0015\u001a\u0013\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00100\u0016¢\u0006\u0002\b\u0018H&J$\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00142\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00140\u001aH&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/livesdkapi/room/handler/enterroom/ILivePreviewBusinessBridge;", "", "onBridgeReleaseCd", "Lio/reactivex/disposables/CompositeDisposable;", "getOnBridgeReleaseCd", "()Lio/reactivex/disposables/CompositeDisposable;", AppbrandHostConstants.SCHEMA_INSPECT.SESSION, "Lcom/bytedance/android/livesdkapi/room/handler/enterroom/ILivePreviewBusinessSession;", "getSession", "()Lcom/bytedance/android/livesdkapi/room/handler/enterroom/ILivePreviewBusinessSession;", "enterRoom", "", "callback", "Lcom/bytedance/android/livesdkapi/room/handler/enterroom/ILiveEnterRoomCallback;", "observeVHSelect", "Lio/reactivex/Observable;", "", "observeVHUnselect", "sendLogger", "eventName", "", "builder", "Lkotlin/Function1;", "Lcom/bytedance/android/livesdkapi/room/handler/enterroom/PreviewReportBuilder;", "Lkotlin/ExtensionFunctionType;", "logExtra", "", "Provider", "live-room-controller-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ILivePreviewBusinessBridge {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdkapi/room/handler/enterroom/ILivePreviewBusinessBridge$Provider;", "", "provide", "Lcom/bytedance/android/livesdkapi/room/handler/enterroom/ILivePreviewBusinessBridge;", "live-room-controller-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public interface Provider {
        ILivePreviewBusinessBridge provide();
    }

    boolean enterRoom(ILiveEnterRoomCallback r100);

    CompositeDisposable getOnBridgeReleaseCd();

    ILivePreviewBusinessSession getSession();

    Observable<Unit> observeVHSelect();

    Observable<Unit> observeVHUnselect();

    void sendLogger(String r100, Map<String, String> r101);

    void sendLogger(String r100, Function1<? super PreviewReportBuilder, Unit> r101);
}
