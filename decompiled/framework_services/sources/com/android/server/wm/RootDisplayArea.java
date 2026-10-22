package com.android.server.wm;

import android.util.Slog;
import com.android.server.policy.WindowManagerPolicy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
class RootDisplayArea extends DisplayArea.Dimmable {
    private DisplayArea.Tokens[] mAreaForLayer;
    Map<DisplayAreaPolicyBuilder.Feature, List<DisplayArea<WindowContainer>>> mFeatureToDisplayAreas;
    List<DisplayAreaPolicyBuilder.Feature> mFeatures;
    private boolean mHasBuiltHierarchy;

    RootDisplayArea(WindowManagerService wms, String name, int featureId) {
        super(wms, DisplayArea.Type.ANY, name, featureId);
    }

    @Override // com.android.server.wm.WindowContainer
    RootDisplayArea getRootDisplayArea() {
        return this;
    }

    @Override // com.android.server.wm.WindowContainer
    RootDisplayArea asRootDisplayArea() {
        return this;
    }

    boolean isOrientationDifferentFromDisplay() {
        return false;
    }

    boolean placeImeContainer(DisplayArea.Tokens imeContainer) {
        RootDisplayArea previousRoot = imeContainer.getRootDisplayArea();
        List<DisplayAreaPolicyBuilder.Feature> features = this.mFeatures;
        int i = 0;
    L4:
        if (i >= features.size()) goto L15;
        DisplayAreaPolicyBuilder.Feature feature = features.get(i);
        if (feature.getId() == 7) goto L7;
        i = i + 1;
        goto L4
    L7:
        List<DisplayArea<WindowContainer>> imeDisplayAreas = this.mFeatureToDisplayAreas.get(feature);
        if (imeDisplayAreas.size() != 1) goto L12;
        previousRoot.updateImeContainerForLayers(null);
        imeContainer.reparent(imeDisplayAreas.get(0), Integer.MAX_VALUE);
        updateImeContainerForLayers(imeContainer);
        return true;
    L12:
        throw new IllegalStateException("There must be exactly one DisplayArea for the FEATURE_IME_PLACEHOLDER");
    L15:
        if (isDescendantOf(previousRoot) == true) goto L17;
        Slog.w("WindowManager", "The IME target is not in the same root as the IME container, but there is no DisplayArea of FEATURE_IME_PLACEHOLDER in the target RootDisplayArea");
    L17:
        return false;
    }

    DisplayArea.Tokens findAreaForTokenInLayer(WindowToken token) {
        return findAreaForWindowTypeInLayer(token.windowType, token.mOwnerCanManageAppTokens, token.mRoundedCornerOverlay);
    }

    DisplayArea.Tokens findAreaForWindowTypeInLayer(int windowType, boolean ownerCanManageAppTokens, boolean roundedCornerOverlay) {
        int windowLayerFromType = this.mWmService.mPolicy.getWindowLayerFromTypeLw(windowType, ownerCanManageAppTokens, roundedCornerOverlay);
        if (windowLayerFromType == 2) goto L7;
        return this.mAreaForLayer[windowLayerFromType];
    L7:
        throw new IllegalArgumentException("There shouldn't be WindowToken on APPLICATION_LAYER");
    }

    void onHierarchyBuilt(ArrayList<DisplayAreaPolicyBuilder.Feature> features, DisplayArea.Tokens[] areaForLayer, Map<DisplayAreaPolicyBuilder.Feature, List<DisplayArea<WindowContainer>>> featureToDisplayAreas) {
        if (this.mHasBuiltHierarchy == true) goto L7;
        this.mHasBuiltHierarchy = true;
        this.mFeatures = Collections.unmodifiableList(features);
        this.mAreaForLayer = areaForLayer;
        this.mFeatureToDisplayAreas = featureToDisplayAreas;
        return;
    L7:
        throw new IllegalStateException("Root should only build the hierarchy once");
    }

    private void updateImeContainerForLayers(DisplayArea.Tokens imeContainer) {
        WindowManagerPolicy policy = this.mWmService.mPolicy;
        this.mAreaForLayer[policy.getWindowLayerFromTypeLw(2011)] = imeContainer;
        this.mAreaForLayer[policy.getWindowLayerFromTypeLw(2012)] = imeContainer;
    }
}
