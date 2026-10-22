package com.bytedance.android.livesdk.chatroom.record;

import android.app.Service;
import com.bytedance.android.livesdkapi.IRecordService;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\u0005H\u0016J\b\u0010\u000b\u001a\u00020\u0005H\u0016J\u0016\u0010\f\u001a\u00020\u00052\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016J\b\u0010\r\u001a\u00020\u0005H\u0016J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0007H\u0016R\u0016\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/record/RecordServiceImpl;", "Lcom/bytedance/android/livesdkapi/IRecordService;", "()V", "record", "Lkotlin/Function0;", "", "stub", "Landroid/app/Service;", "bindService", "service", WidgetCostModule.TYPE_ON_CREATE, LiveCommonConstants.REASON_ON_DEDTROY, "startRecord", "stopRecord", "unBindService", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RecordServiceImpl extends IRecordService {
    private Function0<Unit> record;
    private Service stub;

    @Override // com.bytedance.android.livesdkapi.IRecordService
    public void onDestroy() {
        this.record = null;
    }

    @Override // com.bytedance.android.livesdkapi.IRecordService
    public void onCreate() {
        Function0<Unit> r100 = this.record;
        if (r100 == null) goto L6;
        Unit r101 = r100.invoke();
        return;
    }

    @Override // com.bytedance.android.livesdkapi.IRecordService
    public void stopRecord() {
        Service r100 = this.stub;
        if (r100 == null) goto L6;
        r100.stopSelf();
        return;
    }

    public RecordServiceImpl() {
    }

    @Override // com.bytedance.android.livesdkapi.IRecordService
    public void bindService(Service r100) {
        Intrinsics.checkNotNullParameter(r100, "service");
        this.stub = r100;
    }

    @Override // com.bytedance.android.livesdkapi.IRecordService
    public void startRecord(Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "record");
        r100.invoke();
    }

    @Override // com.bytedance.android.livesdkapi.IRecordService
    public void unBindService(Service r100) {
        Intrinsics.checkNotNullParameter(r100, "service");
        this.stub = null;
    }
}
