package com.bytedance.android.livesdkapi.depend.event;

import java.util.HashSet;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0007\u001a\u00020\bJ\u0006\u0010\t\u001a\u00020\bJ\u0006\u0010\n\u001a\u00020\bJ\u0006\u0010\u000b\u001a\u00020\bJ\u000e\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000eJ\u0006\u0010\u000f\u001a\u00020\bJ\u0006\u0010\u0010\u001a\u00020\bJ\u0006\u0010\u0011\u001a\u00020\bJ\u0006\u0010\u0012\u001a\u00020\bJ\u000e\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0005R\u001e\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/event/LiveEventCenter;", "", "()V", "listeners", "Ljava/util/HashSet;", "Lcom/bytedance/android/livesdkapi/depend/event/ILiveEventListener;", "Lkotlin/collections/HashSet;", "onLiveActivityCreate", "", "onLiveActivityDestroy", "onLivePreviewStart", "onLivePreviewStop", "onLiveViewPagerScroll", "isStart", "", "onLiveWidgetLoaded", "onStartLiveActivityCreate", "onStartLiveActivityDestroy", "onStartLiveWidgetLoaded", "registerLiveEventListener", "listener", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveEventCenter {
    public static final LiveEventCenter INSTANCE = null;
    private static final HashSet<ILiveEventListener> listeners = null;

    private LiveEventCenter() {
    }

    static {
        INSTANCE = new LiveEventCenter();
        listeners = new HashSet();
    }

    public final void onLiveActivityCreate() {
        Iterator<T> r100 = listeners.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((ILiveEventListener) r100.next()).onLiveActivityCreate();
        goto L4
    }

    public final void onLiveActivityDestroy() {
        Iterator<T> r100 = listeners.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((ILiveEventListener) r100.next()).onLiveActivityDestroy();
        goto L4
    }

    public final void onLivePreviewStart() {
        Iterator<T> r100 = listeners.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((ILiveEventListener) r100.next()).onLivePreviewStart();
        goto L4
    }

    public final void onLivePreviewStop() {
        Iterator<T> r100 = listeners.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((ILiveEventListener) r100.next()).onLivePreviewStop();
        goto L4
    }

    public final void onLiveWidgetLoaded() {
        Iterator<T> r100 = listeners.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((ILiveEventListener) r100.next()).onLiveWidgetLoaded();
        goto L4
    }

    public final void onStartLiveActivityCreate() {
        Iterator<T> r100 = listeners.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((ILiveEventListener) r100.next()).onStartLiveActivityCreate();
        goto L4
    }

    public final void onStartLiveActivityDestroy() {
        Iterator<T> r100 = listeners.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((ILiveEventListener) r100.next()).onStartLiveActivityDestroy();
        goto L4
    }

    public final void onStartLiveWidgetLoaded() {
        Iterator<T> r100 = listeners.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((ILiveEventListener) r100.next()).onStartLiveWidgetLoaded();
        goto L4
    }

    public final void onLiveViewPagerScroll(boolean r100) {
        Iterator<T> r101 = listeners.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((ILiveEventListener) r101.next()).onLiveViewPagerScroll(r100);
        goto L4
    }

    public final void registerLiveEventListener(ILiveEventListener r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        listeners.add(r100);
    }
}
