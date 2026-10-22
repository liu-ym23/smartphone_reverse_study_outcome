package com.android.ttcjpaysdk.integrated.sign.counter.activity;

import com.android.ttcjpaysdk.base.eventbus.BaseEvent;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\u0005H&J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH&J\b\u0010\u000f\u001a\u00020\u0005H&¨\u0006\u0010"}, d2 = {"Lcom/android/ttcjpaysdk/integrated/sign/counter/activity/ISignCounterSceneHandler;", "", "onBackPressed", "", WidgetCostModule.TYPE_ON_CREATE, "", "host", "Lcom/android/ttcjpaysdk/integrated/sign/counter/activity/ISignCounterHost;", "args", "Lcom/android/ttcjpaysdk/integrated/sign/counter/activity/SignCounterLaunchArgs;", LiveCommonConstants.REASON_ON_DEDTROY, "onEvent", "event", "Lcom/android/ttcjpaysdk/base/eventbus/BaseEvent;", "onNewIntent", "onNext", "integrated-sign-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface ISignCounterSceneHandler {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static void onEvent(ISignCounterSceneHandler r100, BaseEvent r101) {
            Intrinsics.checkNotNullParameter(r101, "event");
        }
    }

    boolean onBackPressed();

    void onCreate(ISignCounterHost r100, SignCounterLaunchArgs r101);

    void onDestroy();

    void onEvent(BaseEvent r100);

    void onNewIntent(SignCounterLaunchArgs r100);

    void onNext();
}
