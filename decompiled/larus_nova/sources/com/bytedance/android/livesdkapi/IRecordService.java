package com.bytedance.android.livesdkapi;

import android.app.Service;
import android.os.Binder;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\u0004H&J\b\u0010\b\u001a\u00020\u0004H&J\u0016\u0010\t\u001a\u00020\u00042\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u000bH&J\b\u0010\f\u001a\u00020\u0004H&J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H&¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdkapi/IRecordService;", "Landroid/os/Binder;", "()V", "bindService", "", "service", "Landroid/app/Service;", WidgetCostModule.TYPE_ON_CREATE, LiveCommonConstants.REASON_ON_DEDTROY, "startRecord", "record", "Lkotlin/Function0;", "stopRecord", "unBindService", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class IRecordService extends Binder {
    public abstract void bindService(Service r100);

    public abstract void onCreate();

    public abstract void onDestroy();

    public abstract void startRecord(Function0<Unit> r100);

    public abstract void stopRecord();

    public abstract void unBindService(Service r100);

    public IRecordService() {
    }
}
