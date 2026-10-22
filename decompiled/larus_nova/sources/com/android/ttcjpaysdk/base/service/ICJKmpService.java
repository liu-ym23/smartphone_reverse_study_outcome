package com.android.ttcjpaysdk.base.service;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import com.bytedance.caijing.sdk.infra.base.core.di.ICJService;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\u0003H&J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH&J$\u0010\r\u001a\u00020\u00032\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H&J6\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00132\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u000e2\b\u0010\u0014\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000f\u001a\u00020\u0015H&J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0017\u001a\u00020\u0007H&J\u0010\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0013H&J4\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H&J\b\u0010\u001e\u001a\u00020\nH&¨\u0006\u001f"}, d2 = {"Lcom/android/ttcjpaysdk/base/service/ICJKmpService;", "Lcom/bytedance/caijing/sdk/infra/base/core/di/ICJService;", "clearSignHost", "", "closePreloadedUnifyCounter", "closeUnifyCounter", "paySessionId", "", "initCJKmp", "isIntegratedUnifyCounter", "", "data", "", "launchSign", "", "callback", "Lcom/android/ttcjpaysdk/base/service/KmpSignCallback;", "launchUnifyCounter", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "tradeCreateBean", "Lcom/android/ttcjpaysdk/base/service/KmpUnifyCounterPayCallback;", "parseUnifyCounterData", "rawJson", "preloadUnifyCounter", "prepareSignHost", "activity", "Landroid/app/Activity;", "rootView", "Landroid/view/ViewGroup;", "tryHandleSignBackPress", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface ICJKmpService extends ICJService {
    void clearSignHost();

    void closePreloadedUnifyCounter();

    void closeUnifyCounter(String r100);

    void initCJKmp();

    boolean isIntegratedUnifyCounter(Object r100);

    void launchSign(Map<String, String> r100, KmpSignCallback r101);

    String launchUnifyCounter(Context r100, Map<String, String> r101, Object r102, KmpUnifyCounterPayCallback r103);

    Object parseUnifyCounterData(String r100);

    boolean preloadUnifyCounter(Context r100);

    void prepareSignHost(Activity r100, ViewGroup r101, Map<String, String> r102, KmpSignCallback r103);

    boolean tryHandleSignBackPress();
}
