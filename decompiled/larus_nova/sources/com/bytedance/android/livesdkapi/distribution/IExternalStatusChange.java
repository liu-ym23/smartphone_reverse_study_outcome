package com.bytedance.android.livesdkapi.distribution;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016J\b\u0010\u0007\u001a\u00020\u0003H\u0016J8\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\fH\u0016J\u0018\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\nH\u0016J\u0010\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u001a\u0010\u0017\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u001a\u0010\u001a\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u001a\u0010\u001b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0018\u001a\u00020\u0019H\u0016¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/livesdkapi/distribution/IExternalStatusChange;", "", "onDislikeItem", "", "roomId", "", "onEndPageExit", "onEndPageShow", "onInteractionViewsAdapt", "isPortrait", "", "interactionLayout", "Landroid/view/View;", "closeView", "shadowOfTopLayout", "orientationSwitch", "onMaskLayerChanged", "layerType", "", "isShowing", "onOrientationChange", "orientation", "Lcom/bytedance/android/livesdkapi/distribution/ORIENTATION;", "onPageScrollEnd", "position", "", "onPageScrollStart", "onPageSelected", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IExternalStatusChange {

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public static final class DefaultImpls {
        public static void onDislikeItem(IExternalStatusChange r100, long r101) {
        }

        public static void onEndPageExit(IExternalStatusChange r100) {
        }

        public static void onEndPageShow(IExternalStatusChange r100) {
        }

        public static void onInteractionViewsAdapt(IExternalStatusChange r100, boolean r101, View r102, View r103, View r104, View r105) {
        }

        public static void onMaskLayerChanged(IExternalStatusChange r100, String r101, boolean r102) {
            Intrinsics.checkNotNullParameter(r101, "layerType");
        }

        public static void onOrientationChange(IExternalStatusChange r100, ORIENTATION r101) {
            Intrinsics.checkNotNullParameter(r101, "orientation");
        }

        public static void onPageScrollEnd(IExternalStatusChange r100, String r101, int r102) {
        }

        public static void onPageScrollStart(IExternalStatusChange r100, String r101, int r102) {
        }

        public static void onPageSelected(IExternalStatusChange r100, String r101, int r102) {
        }
    }

    void onDislikeItem(long r100);

    void onEndPageExit();

    void onEndPageShow();

    void onInteractionViewsAdapt(boolean r100, View r101, View r102, View r103, View r104);

    void onMaskLayerChanged(String r100, boolean r101);

    void onOrientationChange(ORIENTATION r100);

    void onPageScrollEnd(String r100, int r101);

    void onPageScrollStart(String r100, int r101);

    void onPageSelected(String r100, int r101);
}
