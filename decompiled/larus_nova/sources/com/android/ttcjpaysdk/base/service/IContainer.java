package com.android.ttcjpaysdk.base.service;

import android.app.Activity;
import android.content.Context;
import com.android.ttcjpaysdk.base.service.jsb.IJsbCallback;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J<\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH&J\u001c\u0010\r\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u000fH&¨\u0006\u0010"}, d2 = {"Lcom/android/ttcjpaysdk/base/service/IContainer;", "Lcom/android/ttcjpaysdk/base/service/ICJPayService;", "callJSB", "", "jsbName", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/app/Activity;", "param", "", "", "callBack", "Lcom/android/ttcjpaysdk/base/service/jsb/IJsbCallback;", "open", "scheme", "Landroid/content/Context;", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface IContainer extends ICJPayService {
    void callJSB(String r100, Activity r101, Map<String, ? extends Object> r102, IJsbCallback r103);

    void open(String r100, Context r101);
}
