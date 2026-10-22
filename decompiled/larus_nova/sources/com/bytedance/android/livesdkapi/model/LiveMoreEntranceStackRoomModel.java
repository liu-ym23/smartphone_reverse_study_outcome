package com.bytedance.android.livesdkapi.model;

import android.os.Bundle;
import com.bytedance.android.livesdkapi.depend.live.StackContext;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\t\u0018\u00002\u00020\u0001B)\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000f¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/LiveMoreEntranceStackRoomModel;", "", "info", "Landroid/os/Bundle;", "refInfo", PerfLog.PARAM_KEY_CONTEXT_ID, "Lcom/bytedance/android/livesdkapi/depend/live/StackContext;", "addTime", "", "(Landroid/os/Bundle;Landroid/os/Bundle;Lcom/bytedance/android/livesdkapi/depend/live/StackContext;J)V", "getAddTime", "()J", "getContext", "()Lcom/bytedance/android/livesdkapi/depend/live/StackContext;", "getInfo", "()Landroid/os/Bundle;", "getRefInfo", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveMoreEntranceStackRoomModel {
    private final long addTime;
    private final StackContext context;
    private final Bundle info;
    private final Bundle refInfo;

    public final long getAddTime() {
        return this.addTime;
    }

    public final StackContext getContext() {
        return this.context;
    }

    public final Bundle getInfo() {
        return this.info;
    }

    public final Bundle getRefInfo() {
        return this.refInfo;
    }

    public LiveMoreEntranceStackRoomModel(Bundle r100, Bundle r101, StackContext r102, long r103) {
        Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.info = r100;
        this.refInfo = r101;
        this.context = r102;
        this.addTime = r103;
    }
}
