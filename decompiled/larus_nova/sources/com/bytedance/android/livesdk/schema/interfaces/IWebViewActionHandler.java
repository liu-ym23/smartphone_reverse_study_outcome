package com.bytedance.android.livesdk.schema.interfaces;

import android.content.Context;
import android.net.Uri;
import com.bytedance.android.annie.api.card.IHybridComponent;
import com.bytedance.android.live.browser.webview.fragment.BaseWebDialogFragment;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Deprecated;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H'J\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u00062\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\bH'¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/schema/interfaces/IWebViewActionHandler;", "", "createPopupFragment", "Lcom/bytedance/android/live/browser/webview/fragment/BaseWebDialogFragment;", "uri", "Landroid/net/Uri;", "Lcom/bytedance/android/annie/api/card/IHybridComponent;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "liveroom-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IWebViewActionHandler {
    @Deprecated(message = "临时方法，误用")
    IHybridComponent createPopupFragment(Uri r100, Context r101);

    @Deprecated(message = "这个方法后续不再维护，请使用handle方法")
    BaseWebDialogFragment createPopupFragment(Uri r100);
}
