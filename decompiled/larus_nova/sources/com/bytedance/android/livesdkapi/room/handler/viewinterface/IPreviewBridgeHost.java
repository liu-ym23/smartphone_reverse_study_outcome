package com.bytedance.android.livesdkapi.room.handler.viewinterface;

import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.Metadata;
import kotlin.Unit;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0018\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0018\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\n¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdkapi/room/handler/viewinterface/IPreviewBridgeHost;", "", "onReleaseCd", "Lio/reactivex/disposables/CompositeDisposable;", "getOnReleaseCd", "()Lio/reactivex/disposables/CompositeDisposable;", "vhSelectObservable", "Lio/reactivex/Observable;", "", "getVhSelectObservable", "()Lio/reactivex/Observable;", "vhUnSelectObservable", "getVhUnSelectObservable", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IPreviewBridgeHost {
    CompositeDisposable getOnReleaseCd();

    Observable<Unit> getVhSelectObservable();

    Observable<Unit> getVhUnSelectObservable();
}
