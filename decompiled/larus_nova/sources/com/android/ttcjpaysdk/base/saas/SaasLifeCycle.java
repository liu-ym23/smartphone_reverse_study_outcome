package com.android.ttcjpaysdk.base.saas;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\tB\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0007R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/android/ttcjpaysdk/base/saas/SaasLifeCycle;", "Landroidx/lifecycle/LifecycleObserver;", "owner", "Landroidx/lifecycle/LifecycleOwner;", "listener", "Lcom/android/ttcjpaysdk/base/saas/SaasLifeCycle$SaasLifeCycleListener;", "(Landroidx/lifecycle/LifecycleOwner;Lcom/android/ttcjpaysdk/base/saas/SaasLifeCycle$SaasLifeCycleListener;)V", LiveCommonConstants.REASON_ON_DEDTROY, "", "SaasLifeCycleListener", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SaasLifeCycle implements LifecycleObserver {
    private final SaasLifeCycleListener listener;
    private final LifecycleOwner owner;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/android/ttcjpaysdk/base/saas/SaasLifeCycle$SaasLifeCycleListener;", "", "saasPageEnd", "", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface SaasLifeCycleListener {
        void saasPageEnd();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onDestroy() {
        LifecycleOwner r100 = this.owner;
        if (r100 == null) goto L7;
        Lifecycle r101 = r100.getLifecycle();
        if (r101 == null) goto L7;
        r101.removeObserver(this);
    L7:
        SaasLifeCycleListener r102 = this.listener;
        if (r102 == null) goto L11;
        r102.saasPageEnd();
        return;
    }

    public SaasLifeCycle(LifecycleOwner r100, SaasLifeCycleListener r101) {
        this.owner = r100;
        this.listener = r101;
        if (r100 == null) goto L8;
        Lifecycle r102 = r100.getLifecycle();
        if (r102 == null) goto L9;
        r102.addObserver(this);
        return;
    L9:
        return;
    }
}
