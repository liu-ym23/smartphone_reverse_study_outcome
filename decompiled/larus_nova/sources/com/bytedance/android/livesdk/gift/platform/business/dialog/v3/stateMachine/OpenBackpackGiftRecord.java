package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine;

import android.content.Context;
import com.bytedance.android.livesdk.gift.framework.base.TraceExclude;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/OpenBackpackGiftRecord;", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftUIAction;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OpenBackpackGiftRecord extends GiftUIAction {

    @TraceExclude
    private final Context context;

    public final Context getContext() {
        return this.context;
    }

    public OpenBackpackGiftRecord(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(false, "OpenBackpackGiftRecord", 1, null);
        this.context = r100;
    }
}
