package com.android.ttcjpaysdk.base.adapter;

import android.content.Context;
import android.net.Uri;
import com.android.ttcjpaysdk.base.service.ICJExternalLynxCardCallback;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH&¨\u0006\n"}, d2 = {"Lcom/android/ttcjpaysdk/base/adapter/ICJExternalLynxServiceAdapter;", "", "createHybridCard", "Lcom/android/ttcjpaysdk/base/adapter/ICJExternalLynxCardAdapter;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "uri", "Landroid/net/Uri;", "callback", "Lcom/android/ttcjpaysdk/base/service/ICJExternalLynxCardCallback;", "cj-host-service-api_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface ICJExternalLynxServiceAdapter {
    ICJExternalLynxCardAdapter createHybridCard(Context r100, Uri r101, ICJExternalLynxCardCallback r102);
}
