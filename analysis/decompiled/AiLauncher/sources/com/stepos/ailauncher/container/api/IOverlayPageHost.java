package com.stepos.ailauncher.container.api;

import kotlin.Metadata;
import kotlin.jvm.internal.p;
import x5.d;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006J\u0017\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\r\u0010\u0006J\u0017\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000f\u0010\u0006J\u000f\u0010\u0010\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012À\u0006\u0003"}, d2 = {"Lcom/stepos/ailauncher/container/api/IOverlayPageHost;", "", "", "animate", "LY8/t;", "closeOverlay", "(Z)V", "requestOpenOverlay", "", "pageId", "navigateToPage", "(Ljava/lang/String;)V", d.EXTRA_ENABLED, "setEdgeBackGestureEnabled", "owns", "setContentOwnsHorizontalGesture", "flushPendingPageResume", "()V", "container_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface IOverlayPageHost {

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static void flushPendingPageResume(IOverlayPageHost iOverlayPageHost) {
            IOverlayPageHost.super.flushPendingPageResume();
        }

        @Deprecated
        public static void navigateToPage(IOverlayPageHost iOverlayPageHost, String pageId) {
            p.i(pageId, "pageId");
            IOverlayPageHost.super.navigateToPage(pageId);
        }

        @Deprecated
        public static void requestOpenOverlay(IOverlayPageHost iOverlayPageHost, boolean z10) {
            IOverlayPageHost.super.requestOpenOverlay(z10);
        }

        @Deprecated
        public static void setContentOwnsHorizontalGesture(IOverlayPageHost iOverlayPageHost, boolean z10) {
            IOverlayPageHost.super.setContentOwnsHorizontalGesture(z10);
        }

        @Deprecated
        public static void setEdgeBackGestureEnabled(IOverlayPageHost iOverlayPageHost, boolean z10) {
            IOverlayPageHost.super.setEdgeBackGestureEnabled(z10);
        }
    }

    void closeOverlay(boolean animate);

    default void flushPendingPageResume() {
    }

    default void navigateToPage(String pageId) {
        p.i(pageId, "pageId");
    }

    default void requestOpenOverlay(boolean animate) {
    }

    default void setContentOwnsHorizontalGesture(boolean owns) {
    }

    default void setEdgeBackGestureEnabled(boolean enabled) {
    }
}
