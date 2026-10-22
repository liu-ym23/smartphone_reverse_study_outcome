package com.stepos.ailauncher.container.api;

import android.view.View;
import android.view.ViewGroup;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\tH\u0016¨\u0006\nÀ\u0006\u0003"}, d2 = {"Lcom/stepos/ailauncher/container/api/IOverlayPageProvider;", "", "createView", "Landroid/view/View;", "parent", "Landroid/view/ViewGroup;", "getPageId", "", "getLoadPolicy", "Lcom/stepos/ailauncher/container/api/OverlayPageLoadPolicy;", "container_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface IOverlayPageProvider {

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static OverlayPageLoadPolicy getLoadPolicy(IOverlayPageProvider iOverlayPageProvider) {
            return IOverlayPageProvider.super.getLoadPolicy();
        }

        @Deprecated
        public static String getPageId(IOverlayPageProvider iOverlayPageProvider) {
            return IOverlayPageProvider.super.getPageId();
        }
    }

    View createView(ViewGroup parent);

    default OverlayPageLoadPolicy getLoadPolicy() {
        return OverlayPageLoadPolicy.IMMEDIATE;
    }

    default String getPageId() {
        String name = getClass().getName();
        p.h(name, "getName(...)");
        return name;
    }
}
