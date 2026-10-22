package com.bytedance.android.livehostapi.business;

import android.content.Context;
import android.net.Uri;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livehostapi/business/LiveHostPadDummy;", "Lcom/bytedance/android/livehostapi/business/IHostPad;", "()V", "showInSplit", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "uri", "Landroid/net/Uri;", "livehostadapter_release"}, k = 1, mv = {1, 4, 3})
public final class LiveHostPadDummy implements IHostPad {
    public LiveHostPadDummy() {
    }

    @Override // com.bytedance.android.livehostapi.business.IHostPad
    public boolean showInSplit(Context r100, Uri r101) {
        return false;
    }
}
