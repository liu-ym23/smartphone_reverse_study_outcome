package com.bytedance.android.livehostapi.business;

import android.content.Context;
import android.net.Uri;
import com.bytedance.android.live.base.IService;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&¨\u0006\bÀ\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livehostapi/business/IHostPad;", "Lcom/bytedance/android/live/base/IService;", "showInSplit", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "uri", "Landroid/net/Uri;", "hostapp-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IHostPad extends IService {
    boolean showInSplit(Context r100, Uri r101);
}
