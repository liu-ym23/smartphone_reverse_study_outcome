package com.stepos.ailauncher.container.api;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\t\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0004H&¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H&¢\u0006\u0004\b\r\u0010\fJ\u0019\u0010\u000f\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u000eH&¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0014\u0010\fJ\u0017\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0018\u0010\fJ\u000f\u0010\u0019\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0019\u0010\f¨\u0006\u001aÀ\u0006\u0003"}, d2 = {"Lcom/stepos/ailauncher/container/api/IOverlayPageView;", "", "Lcom/stepos/ailauncher/container/api/IOverlayPageHost;", "host", "LY8/t;", "onPageCreate", "(Lcom/stepos/ailauncher/container/api/IOverlayPageHost;)V", "Lcom/stepos/ailauncher/container/api/OverlayPageResumeReason;", "reason", "onPageResume", "(Lcom/stepos/ailauncher/container/api/OverlayPageResumeReason;)V", "onPagePause", "()V", "onPageStop", "Lcom/stepos/ailauncher/container/api/OverlayPageDestroyReason;", "onPageDestroy", "(Lcom/stepos/ailauncher/container/api/OverlayPageDestroyReason;)V", "", "onBackPressed", "()Z", "onNavigateHome", "visible", "onAllTasksEntryVisibilityChanged", "(Z)V", "onEnterSystemRecents", "hideImeForHomeConsume", "container_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface IOverlayPageView {

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static void hideImeForHomeConsume(IOverlayPageView iOverlayPageView) {
            IOverlayPageView.super.hideImeForHomeConsume();
        }

        @Deprecated
        public static void onAllTasksEntryVisibilityChanged(IOverlayPageView iOverlayPageView, boolean z10) {
            IOverlayPageView.super.onAllTasksEntryVisibilityChanged(z10);
        }

        @Deprecated
        public static boolean onBackPressed(IOverlayPageView iOverlayPageView) {
            return IOverlayPageView.super.onBackPressed();
        }

        @Deprecated
        public static void onEnterSystemRecents(IOverlayPageView iOverlayPageView) {
            IOverlayPageView.super.onEnterSystemRecents();
        }

        @Deprecated
        public static void onNavigateHome(IOverlayPageView iOverlayPageView) {
            IOverlayPageView.super.onNavigateHome();
        }
    }

    static /* synthetic */ void onPageDestroy$default(IOverlayPageView iOverlayPageView, OverlayPageDestroyReason overlayPageDestroyReason, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onPageDestroy");
        }
        if ((i10 & 1) != 0) {
            overlayPageDestroyReason = OverlayPageDestroyReason.DESTROY;
        }
        iOverlayPageView.onPageDestroy(overlayPageDestroyReason);
    }

    static /* synthetic */ void onPageResume$default(IOverlayPageView iOverlayPageView, OverlayPageResumeReason overlayPageResumeReason, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onPageResume");
        }
        if ((i10 & 1) != 0) {
            overlayPageResumeReason = OverlayPageResumeReason.OVERLAY_ACTIVITY_RESUME;
        }
        iOverlayPageView.onPageResume(overlayPageResumeReason);
    }

    default void hideImeForHomeConsume() {
    }

    default void onAllTasksEntryVisibilityChanged(boolean visible) {
    }

    default boolean onBackPressed() {
        return false;
    }

    default void onEnterSystemRecents() {
    }

    default void onNavigateHome() {
    }

    void onPageCreate(IOverlayPageHost host);

    void onPageDestroy(OverlayPageDestroyReason reason);

    void onPagePause();

    void onPageResume(OverlayPageResumeReason reason);

    void onPageStop();
}
