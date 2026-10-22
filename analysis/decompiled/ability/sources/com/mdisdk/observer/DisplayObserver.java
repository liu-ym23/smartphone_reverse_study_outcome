package com.mdisdk.observer;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0003\u0002\u0003\u0004¨\u0006\u0005"}, d2 = {"Lcom/mdisdk/observer/DisplayObserver;", "", "OnForegroundAppChangedListener", "OnVisibleWindowChangedListener", "OnAppDiedListener", "mdisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface DisplayObserver {

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/mdisdk/observer/DisplayObserver$OnAppDiedListener;", "", "Lcom/mdisdk/observer/AppDiedInfo;", "info", "LC7/r;", "onAppDied", "(Lcom/mdisdk/observer/AppDiedInfo;)V", "mdisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface OnAppDiedListener {
        void onAppDied(AppDiedInfo info);
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/mdisdk/observer/DisplayObserver$OnForegroundAppChangedListener;", "", "Lcom/mdisdk/observer/ForegroundAppInfo;", "info", "LC7/r;", "onForegroundAppChanged", "(Lcom/mdisdk/observer/ForegroundAppInfo;)V", "mdisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface OnForegroundAppChangedListener {
        void onForegroundAppChanged(ForegroundAppInfo info);
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/mdisdk/observer/DisplayObserver$OnVisibleWindowChangedListener;", "", "Lcom/mdisdk/observer/VisibleWindowInfo;", "info", "LC7/r;", "onVisibleWindowChanged", "(Lcom/mdisdk/observer/VisibleWindowInfo;)V", "mdisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface OnVisibleWindowChangedListener {
        void onVisibleWindowChanged(VisibleWindowInfo info);
    }
}
