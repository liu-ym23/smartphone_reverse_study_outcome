package com.bytedance.android.livesdkapi.paramtransfer.consume;

import android.os.Bundle;
import com.bytedance.android.livesdk.paramtransfer.RoomParamsConsumeStage;
import com.bytedance.android.livesdkapi.paramtransfer.model.RoomBundleParams;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J:\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0014\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011H\u0016J \u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\n\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0016\u001a\u00020\u0017R\u0019\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/livesdkapi/paramtransfer/consume/BaseRoomParamsConsumer;", "Lcom/bytedance/android/livesdkapi/paramtransfer/consume/IRoomParamsConsumer;", "()V", "roomParamsConsumeObservers", "", "Lcom/bytedance/android/livesdkapi/paramtransfer/consume/IRoomParamsConsumeObserver;", "getRoomParamsConsumeObservers", "()Ljava/util/List;", "consume", "", "data", "Lcom/bytedance/android/livesdkapi/paramtransfer/model/RoomBundleParams;", "stage", "Lcom/bytedance/android/livesdk/paramtransfer/RoomParamsConsumeStage;", "bundle", "Landroid/os/Bundle;", "map", "", "", "dispatchConsumeObserver", "type", "", "roomId", "", "room_saasRelease"}, k = 1, mv = {1, 4, 3})
public class BaseRoomParamsConsumer implements IRoomParamsConsumer {
    private final List<IRoomParamsConsumeObserver> roomParamsConsumeObservers;

    @Override // com.bytedance.android.livesdkapi.paramtransfer.consume.IRoomParamsConsumer
    public void consume(RoomBundleParams r100, RoomParamsConsumeStage r101, Bundle r102, Map<String, String> r103) {
        Intrinsics.checkNotNullParameter(r101, "stage");
    }

    public BaseRoomParamsConsumer() {
        this.roomParamsConsumeObservers = new ArrayList();
    }

    @Override // com.bytedance.android.livesdkapi.paramtransfer.consume.IRoomParamsConsumer
    public String getBundleKey() {
        return IRoomParamsConsumer.DefaultImpls.getBundleKey(this);
    }

    public final List<IRoomParamsConsumeObserver> getRoomParamsConsumeObservers() {
        return this.roomParamsConsumeObservers;
    }

    @Override // com.bytedance.android.livesdkapi.paramtransfer.consume.IRoomParamsConsumer
    public String getClickParam(RoomBundleParams r100) {
        return IRoomParamsConsumer.DefaultImpls.getClickParam(this, r100);
    }

    @Override // com.bytedance.android.livesdkapi.paramtransfer.consume.IRoomParamsConsumer
    public String getCommonParam(RoomBundleParams r100) {
        return IRoomParamsConsumer.DefaultImpls.getCommonParam(this, r100);
    }

    @Override // com.bytedance.android.livesdkapi.paramtransfer.consume.IRoomParamsConsumer
    public String getFirstShowParam(RoomBundleParams r100) {
        return IRoomParamsConsumer.DefaultImpls.getFirstShowParam(this, r100);
    }

    public final void dispatchConsumeObserver(int r100, Bundle r101, long r102) {
        if (r101 != null) goto L4;
        return;
    L4:
        List<IRoomParamsConsumeObserver> r103 = this.roomParamsConsumeObservers;
        if (r103 == null) goto L19;
        Iterator<T> r104 = r103.iterator();
    L8:
        if (r104.hasNext() == false) goto L31;
        IRoomParamsConsumeObserver r105 = (IRoomParamsConsumeObserver) r104.next();
        if (r100 != 1) goto L12;
        r105.onCommonDataReady(r101, r102);
        goto L8
    L12:
        if (r100 != 2) goto L14;
        r105.onClickDataReady(r101, r102);
        goto L8
    L14:
        if (r100 != 3) goto L8;
        r105.onFirstShowDataReady(r101, r102);
        goto L8
    L31:
        return;
    }
}
