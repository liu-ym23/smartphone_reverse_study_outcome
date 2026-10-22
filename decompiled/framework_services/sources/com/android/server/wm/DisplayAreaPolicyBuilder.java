package com.android.server.wm;

import android.app.ActivityOptions;
import android.os.Bundle;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.window.WindowContainerToken;
import com.android.internal.protolog.ProtoLogImpl_798997914;
import com.android.internal.protolog.WmProtoLogGroups;
import com.android.server.policy.WindowManagerPolicy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.Function;

/* JADX INFO: loaded from: classes3.dex */
class DisplayAreaPolicyBuilder {
    private final ArrayList<HierarchyBuilder> mDisplayAreaGroupHierarchyBuilders;
    private HierarchyBuilder mRootHierarchyBuilder;
    private BiFunction<Integer, Bundle, RootDisplayArea> mSelectRootForWindowFunc;
    private Function<Bundle, TaskDisplayArea> mSelectTaskDisplayAreaFunc;

    private static class DefaultSelectRootForWindowFunction implements BiFunction<Integer, Bundle, RootDisplayArea> {
        final List<RootDisplayArea> mDisplayAreaGroupRoots;
        final RootDisplayArea mDisplayRoot;

        @Override // java.util.function.BiFunction
        public /* bridge */ /* synthetic */ RootDisplayArea apply(Integer r1, Bundle r2) {
            return apply2(r1, r2);
        }

        DefaultSelectRootForWindowFunction(RootDisplayArea displayRoot, List<RootDisplayArea> displayAreaGroupRoots) {
            this.mDisplayRoot = displayRoot;
            this.mDisplayAreaGroupRoots = Collections.unmodifiableList(displayAreaGroupRoots);
        }

        /* JADX INFO: renamed from: apply, reason: avoid collision after fix types in other method */
        public RootDisplayArea apply2(Integer windowType, Bundle options) {
            if (this.mDisplayAreaGroupRoots.isEmpty() == true) goto L5;
            if (options == null) goto L21;
            if (options.containsKey("root_display_area_id") == false) goto L21;
            int rootId = options.getInt("root_display_area_id");
            if (this.mDisplayRoot.mFeatureId == rootId) goto L12;
            int i = this.mDisplayAreaGroupRoots.size() - 1;
        L14:
            if (i < 0) goto L21;
            if (this.mDisplayAreaGroupRoots.get(i).mFeatureId == rootId) goto L18;
            i = i - 1;
            goto L14
        L18:
            return this.mDisplayAreaGroupRoots.get(i);
        L12:
            return this.mDisplayRoot;
        L21:
            return this.mDisplayRoot;
        L5:
            return this.mDisplayRoot;
        }
    }

    private static class DefaultSelectTaskDisplayAreaFunction implements Function<Bundle, TaskDisplayArea> {
        private final TaskDisplayArea mDefaultTaskDisplayArea;
        private final int mDisplayId;

        @Override // java.util.function.Function
        public /* bridge */ /* synthetic */ TaskDisplayArea apply(Bundle r1) {
            return apply2(r1);
        }

        DefaultSelectTaskDisplayAreaFunction(TaskDisplayArea defaultTaskDisplayArea) {
            this.mDefaultTaskDisplayArea = defaultTaskDisplayArea;
            this.mDisplayId = defaultTaskDisplayArea.getDisplayId();
        }

        /* JADX INFO: renamed from: apply, reason: avoid collision after fix types in other method */
        public TaskDisplayArea apply2(Bundle options) {
            if (options == null) goto L4;
            ActivityOptions activityOptions = new ActivityOptions(options);
            WindowContainerToken tdaToken = activityOptions.getLaunchTaskDisplayArea();
            if (tdaToken == null) goto L8;
            TaskDisplayArea tda = WindowContainer.fromBinder(tdaToken.asBinder()).asTaskDisplayArea();
            if (tda != null) goto L17;
            if (ProtoLogImpl_798997914.Cache.WM_DEBUG_WINDOW_ORGANIZER_enabled[3] == false) goto L15;
            String protoLogParam0 = String.valueOf(tdaToken);
            ProtoLogImpl_798997914.w(WmProtoLogGroups.WM_DEBUG_WINDOW_ORGANIZER, 4917824058925068521L, 0, new Object[]{protoLogParam0});
        L15:
            return this.mDefaultTaskDisplayArea;
        L17:
            if (tda.getDisplayId() != this.mDisplayId) goto L20;
            return tda;
        L20:
            throw new IllegalArgumentException("The specified TaskDisplayArea must attach to Display#" + this.mDisplayId + ", but it is in Display#" + tda.getDisplayId());
        L8:
            return this.mDefaultTaskDisplayArea;
        L4:
            return this.mDefaultTaskDisplayArea;
        }
    }

    static class Feature {
        private final int mId;
        private final String mName;
        private final NewDisplayAreaSupplier mNewDisplayAreaSupplier;
        private final boolean[] mWindowLayers;

        static class Builder {
            private boolean mExcludeRoundedCorner;
            private final int mId;
            private final boolean[] mLayers;
            private final String mName;
            private NewDisplayAreaSupplier mNewDisplayAreaSupplier;
            private final WindowManagerPolicy mPolicy;

            Builder(WindowManagerPolicy policy, String name, int id) {
                this.mNewDisplayAreaSupplier = new DisplayAreaPolicyBuilder$Feature$Builder$$ExternalSyntheticLambda0();
                this.mExcludeRoundedCorner = true;
                this.mPolicy = policy;
                this.mName = name;
                this.mId = id;
                this.mLayers = new boolean[this.mPolicy.getMaxWindowLayer() + 1];
            }

            Builder all() {
                Arrays.fill(this.mLayers, true);
                return this;
            }

            Builder and(int... types) {
                int i = 0;
            L4:
                if (i >= types.length) goto L7;
                int type = types[i];
                set(type, true);
                i = i + 1;
                goto L4
            L7:
                return this;
            }

            Builder except(int... types) {
                int i = 0;
            L4:
                if (i >= types.length) goto L7;
                int type = types[i];
                set(type, false);
                i = i + 1;
                goto L4
            L7:
                return this;
            }

            Builder upTo(int typeInclusive) {
                int max = layerFromType(typeInclusive, false);
                int i = 0;
            L4:
                if (i >= max) goto L6;
                this.mLayers[i] = true;
                i = i + 1;
                goto L4
            L6:
                set(typeInclusive, true);
                return this;
            }

            Builder setNewDisplayAreaSupplier(NewDisplayAreaSupplier newDisplayAreaSupplier) {
                this.mNewDisplayAreaSupplier = newDisplayAreaSupplier;
                return this;
            }

            Builder setExcludeRoundedCornerOverlay(boolean excludeRoundedCorner) {
                this.mExcludeRoundedCorner = excludeRoundedCorner;
                return this;
            }

            Feature build() {
                if (this.mExcludeRoundedCorner == false) goto L6;
                this.mLayers[this.mPolicy.getMaxWindowLayer()] = false;
            L6:
                return new Feature(this.mName, this.mId, (boolean[]) this.mLayers.clone(), this.mNewDisplayAreaSupplier, null);
            }

            private void set(int type, boolean value) {
                this.mLayers[layerFromType(type, true)] = value;
                if (type != 2038) goto L6;
                this.mLayers[layerFromType(type, true)] = value;
                this.mLayers[layerFromType(2003, false)] = value;
                this.mLayers[layerFromType(2006, false)] = value;
                this.mLayers[layerFromType(2010, false)] = value;
                return;
            }

            private int layerFromType(int type, boolean internalWindows) {
                return this.mPolicy.getWindowLayerFromTypeLw(type, internalWindows);
            }
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmId, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m9876$$Nest$fgetmId(Feature r0) {
            return r0.mId;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmName, reason: not valid java name */
        static /* bridge */ /* synthetic */ String m9877$$Nest$fgetmName(Feature r0) {
            return r0.mName;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmNewDisplayAreaSupplier, reason: not valid java name */
        static /* bridge */ /* synthetic */ NewDisplayAreaSupplier m9878$$Nest$fgetmNewDisplayAreaSupplier(Feature r0) {
            return r0.mNewDisplayAreaSupplier;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmWindowLayers, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean[] m9879$$Nest$fgetmWindowLayers(Feature r0) {
            return r0.mWindowLayers;
        }

        /* synthetic */ Feature(String r1, int r2, boolean[] r3, NewDisplayAreaSupplier r4, DisplayAreaPolicyBuilderIA r5) {
            this(r1, r2, r3, r4);
        }

        private Feature(String name, int id, boolean[] windowLayers, NewDisplayAreaSupplier newDisplayAreaSupplier) {
            this.mName = name;
            this.mId = id;
            this.mWindowLayers = windowLayers;
            this.mNewDisplayAreaSupplier = newDisplayAreaSupplier;
        }

        public int getId() {
            return this.mId;
        }

        public String toString() {
            return "Feature(\"" + this.mName + "\", " + this.mId + '}';
        }
    }

    static class HierarchyBuilder {
        private static final int LEAF_TYPE_IME_CONTAINERS = 2;
        private static final int LEAF_TYPE_TASK_CONTAINERS = 1;
        private static final int LEAF_TYPE_TOKENS = 0;
        private final ArrayList<Feature> mFeatures;
        private DisplayArea.Tokens mImeContainer;
        private final RootDisplayArea mRoot;
        private final ArrayList<TaskDisplayArea> mTaskDisplayAreas;

        /* JADX INFO: renamed from: -$$Nest$fgetmFeatures, reason: not valid java name */
        static /* bridge */ /* synthetic */ ArrayList m9880$$Nest$fgetmFeatures(HierarchyBuilder r0) {
            return r0.mFeatures;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmImeContainer, reason: not valid java name */
        static /* bridge */ /* synthetic */ DisplayArea.Tokens m9881$$Nest$fgetmImeContainer(HierarchyBuilder r0) {
            return r0.mImeContainer;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmRoot, reason: not valid java name */
        static /* bridge */ /* synthetic */ RootDisplayArea m9882$$Nest$fgetmRoot(HierarchyBuilder r0) {
            return r0.mRoot;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmTaskDisplayAreas, reason: not valid java name */
        static /* bridge */ /* synthetic */ ArrayList m9883$$Nest$fgetmTaskDisplayAreas(HierarchyBuilder r0) {
            return r0.mTaskDisplayAreas;
        }

        /* JADX INFO: renamed from: -$$Nest$mbuild, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m9884$$Nest$mbuild(HierarchyBuilder r0) {
            r0.build();
        }

        /* JADX INFO: renamed from: -$$Nest$mbuild, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m9885$$Nest$mbuild(HierarchyBuilder r0, List r1) {
            r0.build(r1);
        }

        HierarchyBuilder(RootDisplayArea root) {
            this.mFeatures = new ArrayList();
            this.mTaskDisplayAreas = new ArrayList();
            this.mRoot = root;
        }

        HierarchyBuilder addFeature(Feature feature) {
            this.mFeatures.add(feature);
            return this;
        }

        HierarchyBuilder setTaskDisplayAreas(List<TaskDisplayArea> taskDisplayAreas) {
            this.mTaskDisplayAreas.clear();
            this.mTaskDisplayAreas.addAll(taskDisplayAreas);
            return this;
        }

        HierarchyBuilder setImeContainer(DisplayArea.Tokens imeContainer) {
            this.mImeContainer = imeContainer;
            return this;
        }

        private void build() {
            build(null);
        }

        private void build(List<HierarchyBuilder> displayAreaGroupHierarchyBuilders) {
            WindowManagerPolicy policy = this.mRoot.mWmService.mPolicy;
            int maxWindowLayerCount = policy.getMaxWindowLayer() + 1;
            DisplayArea.Tokens[] displayAreaForLayer = new DisplayArea.Tokens[maxWindowLayerCount];
            Map<Feature, List<DisplayArea<WindowContainer>>> featureAreas = new ArrayMap(this.mFeatures.size());
            int i = 0;
        L4:
            if (i >= this.mFeatures.size()) goto L6;
            featureAreas.put(this.mFeatures.get(i), new ArrayList());
            i = i + 1;
            goto L4
        L6:
            PendingArea[] areaForLayer = new PendingArea[maxWindowLayerCount];
            PendingArea root = new PendingArea(null, 0, null);
            Arrays.fill(areaForLayer, root);
            int size = this.mFeatures.size();
            int i2 = 0;
        L7:
            if (i2 >= size) goto L20;
            Feature feature = this.mFeatures.get(i2);
            PendingArea featureArea = null;
            int layer = 0;
        L9:
            if (layer >= maxWindowLayerCount) goto L19;
            if (Feature.m9879$$Nest$fgetmWindowLayers(feature)[layer] == false) goto L17;
            if (featureArea != null) goto L14;
        L15:
            featureArea = new PendingArea(feature, layer, areaForLayer[layer]);
            areaForLayer[layer].mChildren.add(featureArea);
        L16:
            areaForLayer[layer] = featureArea;
        L18:
            layer = layer + 1;
            goto L9
        L14:
            if (featureArea.mParent == areaForLayer[layer]) goto L16;
        L17:
            featureArea = null;
            goto L18
        L19:
            i2 = i2 + 1;
            goto L7
        L20:
            PendingArea leafArea = null;
            int leafType = 0;
            int layer2 = 0;
        L21:
            if (layer2 >= maxWindowLayerCount) goto L37;
            int type = typeOfLayer(policy, layer2);
            if (leafArea != null) goto L25;
        L29:
            PendingArea leafArea2 = new PendingArea(null, layer2, areaForLayer[layer2]);
            PendingArea leafArea3 = areaForLayer[layer2];
            leafArea3.mChildren.add(leafArea2);
            if (type != 1) goto L33;
            addTaskDisplayAreasToApplicationLayer(areaForLayer[layer2]);
            addDisplayAreaGroupsToApplicationLayer(areaForLayer[layer2], displayAreaGroupHierarchyBuilders);
            leafArea2.mSkipTokens = true;
        L35:
            leafType = type;
            leafArea = leafArea2;
        L36:
            leafArea.mMaxLayer = layer2;
            layer2 = layer2 + 1;
            goto L21
        L33:
            if (type != 2) goto L35;
            leafArea2.mExisting = this.mImeContainer;
            leafArea2.mSkipTokens = true;
            goto L35
        L25:
            if (leafArea.mParent != areaForLayer[layer2]) goto L29;
            if (type == leafType) goto L36;
        L37:
            root.computeMaxLayer();
            root.instantiateChildren(this.mRoot, displayAreaForLayer, 0, featureAreas);
            this.mRoot.onHierarchyBuilt(this.mFeatures, displayAreaForLayer, featureAreas);
        }

        private void addTaskDisplayAreasToApplicationLayer(PendingArea parentPendingArea) {
            int count = this.mTaskDisplayAreas.size();
            int i = 0;
        L3:
            if (i >= count) goto L6;
            PendingArea leafArea = new PendingArea(null, 2, parentPendingArea);
            leafArea.mExisting = this.mTaskDisplayAreas.get(i);
            leafArea.mMaxLayer = 2;
            parentPendingArea.mChildren.add(leafArea);
            i = i + 1;
            goto L3
        }

        private void addDisplayAreaGroupsToApplicationLayer(PendingArea parentPendingArea, List<HierarchyBuilder> displayAreaGroupHierarchyBuilders) {
            if (displayAreaGroupHierarchyBuilders != null) goto L4;
            return;
        L4:
            int count = displayAreaGroupHierarchyBuilders.size();
            int i = 0;
        L5:
            if (i >= count) goto L8;
            PendingArea leafArea = new PendingArea(null, 2, parentPendingArea);
            leafArea.mExisting = displayAreaGroupHierarchyBuilders.get(i).mRoot;
            leafArea.mMaxLayer = 2;
            parentPendingArea.mChildren.add(leafArea);
            i = i + 1;
            goto L5
        }

        boolean hasValidWindowingLayer() {
            if (this.mFeatures.isEmpty() == false) goto L5;
            return false;
        L5:
            if (DisplayAreaPolicyBuilder.canBeWindowingLayer(Feature.m9876$$Nest$fgetmId(this.mFeatures.get(0))) == false) goto L9;
            return true;
        L9:
            return false;
        }

        private static int typeOfLayer(WindowManagerPolicy policy, int layer) {
            if (layer != 2) goto L7;
            return 1;
        L7:
            if (layer != policy.getWindowLayerFromTypeLw(2011)) goto L9;
        L13:
            return 2;
        L9:
            if (layer == policy.getWindowLayerFromTypeLw(2012)) goto L13;
            return 0;
        }
    }

    interface NewDisplayAreaSupplier {
        DisplayArea create(WindowManagerService r1, DisplayArea.Type r2, String r3, int r4);
    }

    static class PendingArea {
        final ArrayList<PendingArea> mChildren;
        DisplayArea mExisting;
        final Feature mFeature;
        int mMaxLayer;
        final int mMinLayer;
        final PendingArea mParent;
        boolean mSkipTokens;

        public static /* synthetic */ int $r8$lambda$VwU16eW1PmOKwR0U1Wij7qH1PtU(PendingArea r0) {
            return lambda$instantiateChildren$0(r0);
        }

        PendingArea(Feature feature, int minLayer, PendingArea parent) {
            this.mChildren = new ArrayList();
            this.mSkipTokens = false;
            this.mMinLayer = minLayer;
            this.mFeature = feature;
            this.mParent = parent;
        }

        int computeMaxLayer() {
            int i = 0;
        L4:
            if (i >= this.mChildren.size()) goto L6;
            this.mMaxLayer = Math.max(this.mMaxLayer, this.mChildren.get(i).computeMaxLayer());
            i = i + 1;
            goto L4
        L6:
            int i2 = this.mMaxLayer;
            return i2;
        }

        private static /* synthetic */ int lambda$instantiateChildren$0(PendingArea pendingArea) {
            return pendingArea.mMinLayer;
        }

        void instantiateChildren(DisplayArea<DisplayArea> parent, DisplayArea.Tokens[] areaForLayer, int level, Map<Feature, List<DisplayArea<WindowContainer>>> areas) {
            this.mChildren.sort(Comparator.comparingInt(new DisplayAreaPolicyBuilder$PendingArea$$ExternalSyntheticLambda0()));
            int i = 0;
        L4:
            if (i >= this.mChildren.size()) goto L14;
            PendingArea r1 = this.mChildren.get(i);
            DisplayArea r2 = r1.createArea(parent, areaForLayer);
            if (r2 == null) goto L12;
            parent.addChild(r2, Integer.MAX_VALUE);
            if (r1.mFeature == null) goto L11;
            areas.get(r1.mFeature).add(r2);
        L11:
            r1.instantiateChildren(r2, areaForLayer, level + 1, areas);
        L12:
            i = i + 1;
            goto L4
        }

        private DisplayArea createArea(DisplayArea<DisplayArea> parent, DisplayArea.Tokens[] areaForLayer) {
            if (this.mExisting == null) goto L10;
            if (this.mExisting.asTokens() == null) goto L8;
            fillAreaForLayers(this.mExisting.asTokens(), areaForLayer);
        L8:
            return this.mExisting;
        L10:
            if (this.mSkipTokens == false) goto L14;
            return null;
        L14:
            if (this.mMinLayer <= 2) goto L17;
            DisplayArea.Type type = DisplayArea.Type.ABOVE_TASKS;
        L21:
            if (this.mFeature != null) goto L25;
            DisplayArea.Tokens leaf = new DisplayArea.Tokens(parent.mWmService, type, "Leaf:" + this.mMinLayer + ":" + this.mMaxLayer);
            fillAreaForLayers(leaf, areaForLayer);
            return leaf;
        L25:
            return Feature.m9878$$Nest$fgetmNewDisplayAreaSupplier(this.mFeature).create(parent.mWmService, type, Feature.m9877$$Nest$fgetmName(this.mFeature) + ":" + this.mMinLayer + ":" + this.mMaxLayer, Feature.m9876$$Nest$fgetmId(this.mFeature));
        L17:
            if (this.mMaxLayer >= 2) goto L19;
            type = DisplayArea.Type.BELOW_TASKS;
            goto L21
        L19:
            type = DisplayArea.Type.ANY;
            goto L21
        }

        private void fillAreaForLayers(DisplayArea.Tokens leaf, DisplayArea.Tokens[] areaForLayer) {
            int i = this.mMinLayer;
        L4:
            if (i > this.mMaxLayer) goto L7;
            areaForLayer[i] = leaf;
            i = i + 1;
            goto L4
        }
    }

    static class Result extends DisplayAreaPolicy {
        private final TaskDisplayArea mDefaultTaskDisplayArea;
        final List<RootDisplayArea> mDisplayAreaGroupRoots;
        final BiFunction<Integer, Bundle, RootDisplayArea> mSelectRootForWindowFunc;
        private final Function<Bundle, TaskDisplayArea> mSelectTaskDisplayAreaFunc;

        public static /* synthetic */ TaskDisplayArea $r8$lambda$YTS6mATtwOUjwC_PPe0TcCmppOQ(TaskDisplayArea r0) {
            return lambda$new$0(r0);
        }

        Result(WindowManagerService wmService, RootDisplayArea root, List<RootDisplayArea> displayAreaGroupRoots, BiFunction<Integer, Bundle, RootDisplayArea> selectRootForWindowFunc, Function<Bundle, TaskDisplayArea> selectTaskDisplayAreaFunc) {
            super(wmService, root);
            this.mDisplayAreaGroupRoots = Collections.unmodifiableList(displayAreaGroupRoots);
            this.mSelectRootForWindowFunc = selectRootForWindowFunc;
            this.mDefaultTaskDisplayArea = (TaskDisplayArea) this.mRoot.getItemFromTaskDisplayAreas(new DisplayAreaPolicyBuilder$Result$$ExternalSyntheticLambda0());
            if (this.mDefaultTaskDisplayArea == null) goto L10;
            if (selectTaskDisplayAreaFunc == null) goto L6;
            Function<Bundle, TaskDisplayArea> r0 = selectTaskDisplayAreaFunc;
        L7:
            this.mSelectTaskDisplayAreaFunc = r0;
            return;
        L6:
            r0 = new DefaultSelectTaskDisplayAreaFunction(this.mDefaultTaskDisplayArea);
            goto L7
        L10:
            throw new IllegalStateException("No display area with FEATURE_DEFAULT_TASK_CONTAINER");
        }

        private static /* synthetic */ TaskDisplayArea lambda$new$0(TaskDisplayArea taskDisplayArea) {
            if (taskDisplayArea.mFeatureId == 1) goto L7;
            return null;
        L7:
            return taskDisplayArea;
        }

        @Override // com.android.server.wm.DisplayAreaPolicy
        public void addWindow(WindowToken token) {
            DisplayArea.Tokens area = findAreaForToken(token);
            area.addChild(token);
        }

        DisplayArea.Tokens findAreaForToken(WindowToken token) {
            return this.mSelectRootForWindowFunc.apply(Integer.valueOf(token.windowType), token.mOptions).findAreaForTokenInLayer(token);
        }

        @Override // com.android.server.wm.DisplayAreaPolicy
        public DisplayArea.Tokens findAreaForWindowType(int type, Bundle options, boolean ownerCanManageAppTokens, boolean roundedCornerOverlay) {
            return this.mSelectRootForWindowFunc.apply(Integer.valueOf(type), options).findAreaForWindowTypeInLayer(type, ownerCanManageAppTokens, roundedCornerOverlay);
        }

        List<Feature> getFeatures() {
            Set<Feature> features = new ArraySet();
            features.addAll(this.mRoot.mFeatures);
            int i = 0;
        L4:
            if (i >= this.mDisplayAreaGroupRoots.size()) goto L7;
            features.addAll(this.mDisplayAreaGroupRoots.get(i).mFeatures);
            i = i + 1;
            goto L4
        L7:
            return new ArrayList(features);
        }

        @Override // com.android.server.wm.DisplayAreaPolicy
        public List<DisplayArea<? extends WindowContainer>> getDisplayAreas(int featureId) {
            List<DisplayArea<? extends WindowContainer>> displayAreas = new ArrayList();
            getDisplayAreas(this.mRoot, featureId, displayAreas);
            int i = 0;
        L4:
            if (i >= this.mDisplayAreaGroupRoots.size()) goto L7;
            getDisplayAreas(this.mDisplayAreaGroupRoots.get(i), featureId, displayAreas);
            i = i + 1;
            goto L4
        L7:
            return displayAreas;
        }

        private static void getDisplayAreas(RootDisplayArea root, int featureId, List<DisplayArea<? extends WindowContainer>> displayAreas) {
            List<Feature> features = root.mFeatures;
            int i = 0;
        L4:
            if (i >= features.size()) goto L10;
            Feature feature = features.get(i);
            if (Feature.m9876$$Nest$fgetmId(feature) != featureId) goto L8;
            displayAreas.addAll(root.mFeatureToDisplayAreas.get(feature));
        L8:
            i = i + 1;
            goto L4
        }

        @Override // com.android.server.wm.DisplayAreaPolicy
        public DisplayArea<? extends WindowContainer> getWindowingArea() {
            if (this.mRoot.mFeatures.isEmpty() == true) goto L13;
            Feature feature = this.mRoot.mFeatures.get(0);
            if (DisplayAreaPolicyBuilder.canBeWindowingLayer(Feature.m9876$$Nest$fgetmId(feature)) == false) goto L11;
            List<DisplayArea<WindowContainer>> areas = this.mRoot.mFeatureToDisplayAreas.get(feature);
            if (areas.size() != 1) goto L11;
            return areas.get(0);
        L11:
            throw new IllegalStateException("There must be exactly one DisplayArea at top for the FEATURE_WINDOWED_MAGNIFICATION or FEATURE_WINDOWING_LAYER");
        L13:
            throw new IllegalStateException("There must be at least one feature.");
        }

        @Override // com.android.server.wm.DisplayAreaPolicy
        public TaskDisplayArea getDefaultTaskDisplayArea() {
            return this.mDefaultTaskDisplayArea;
        }

        @Override // com.android.server.wm.DisplayAreaPolicy
        public TaskDisplayArea getTaskDisplayArea(Bundle options) {
            return this.mSelectTaskDisplayAreaFunc.apply(options);
        }
    }

    DisplayAreaPolicyBuilder() {
        this.mDisplayAreaGroupHierarchyBuilders = new ArrayList();
    }

    DisplayAreaPolicyBuilder setRootHierarchy(HierarchyBuilder rootHierarchyBuilder) {
        this.mRootHierarchyBuilder = rootHierarchyBuilder;
        return this;
    }

    DisplayAreaPolicyBuilder addDisplayAreaGroupHierarchy(HierarchyBuilder displayAreaGroupHierarchy) {
        this.mDisplayAreaGroupHierarchyBuilders.add(displayAreaGroupHierarchy);
        return this;
    }

    DisplayAreaPolicyBuilder setSelectRootForWindowFunc(BiFunction<Integer, Bundle, RootDisplayArea> selectRootForWindowFunc) {
        this.mSelectRootForWindowFunc = selectRootForWindowFunc;
        return this;
    }

    DisplayAreaPolicyBuilder setSelectTaskDisplayAreaFunc(Function<Bundle, TaskDisplayArea> selectTaskDisplayAreaFunc) {
        this.mSelectTaskDisplayAreaFunc = selectTaskDisplayAreaFunc;
        return this;
    }

    private void validate() {
        if (this.mRootHierarchyBuilder == null) goto L47;
        Set<Integer> uniqueIdSet = new ArraySet();
        Set<Integer> allIdSet = new ArraySet();
        validateIds(this.mRootHierarchyBuilder, uniqueIdSet, allIdSet);
        if (HierarchyBuilder.m9881$$Nest$fgetmImeContainer(this.mRootHierarchyBuilder) == null) goto L7;
        boolean containsImeContainer = true;
    L8:
        boolean containsDefaultTda = containsDefaultTaskDisplayArea(this.mRootHierarchyBuilder);
        int i = 0;
    L10:
        if (i >= this.mDisplayAreaGroupHierarchyBuilders.size()) goto L35;
        HierarchyBuilder hierarchyBuilder = this.mDisplayAreaGroupHierarchyBuilders.get(i);
        validateIds(hierarchyBuilder, uniqueIdSet, allIdSet);
        if (HierarchyBuilder.m9883$$Nest$fgetmTaskDisplayAreas(hierarchyBuilder).isEmpty() == true) goto L33;
        if (containsImeContainer == false) goto L20;
        if (HierarchyBuilder.m9881$$Nest$fgetmImeContainer(hierarchyBuilder) != null) goto L18;
    L24:
        if (containsDefaultTda == true) goto L26;
        containsDefaultTda = containsDefaultTaskDisplayArea(hierarchyBuilder);
    L31:
        i = i + 1;
        goto L10
    L26:
        if (containsDefaultTaskDisplayArea(hierarchyBuilder) == false) goto L31;
        throw new IllegalStateException("Only one TaskDisplayArea can have the feature id of FEATURE_DEFAULT_TASK_CONTAINER");
    L18:
        throw new IllegalStateException("Only one DisplayArea hierarchy can contain the IME container");
    L20:
        if (HierarchyBuilder.m9881$$Nest$fgetmImeContainer(hierarchyBuilder) == null) goto L22;
        boolean r8 = true;
    L23:
        containsImeContainer = r8;
        goto L24
    L22:
        r8 = false;
        goto L23
    L33:
        throw new IllegalStateException("DisplayAreaGroup must contain at least one TaskDisplayArea.");
    L35:
        if (containsImeContainer == false) goto L45;
        if (containsDefaultTda == false) goto L43;
        if (this.mRootHierarchyBuilder.hasValidWindowingLayer() == false) goto L41;
        return;
    L41:
        throw new IllegalStateException("WindowingLayer must exist at the top level index");
    L43:
        throw new IllegalStateException("There must be a default TaskDisplayArea with id of FEATURE_DEFAULT_TASK_CONTAINER.");
    L45:
        throw new IllegalStateException("IME container must be set.");
    L7:
        containsImeContainer = false;
        goto L8
    L47:
        throw new IllegalStateException("Root must be set for the display area policy.");
    }

    private static boolean containsDefaultTaskDisplayArea(HierarchyBuilder displayAreaHierarchy) {
        int i = 0;
    L4:
        if (i >= HierarchyBuilder.m9883$$Nest$fgetmTaskDisplayAreas(displayAreaHierarchy).size()) goto L9;
        if (((TaskDisplayArea) HierarchyBuilder.m9883$$Nest$fgetmTaskDisplayAreas(displayAreaHierarchy).get(i)).mFeatureId == 1) goto L7;
        i = i + 1;
        goto L4
    L7:
        return true;
    L9:
        return false;
    }

    static boolean canBeWindowingLayer(int featureId) {
        if (featureId != 4) goto L5;
    L8:
        return true;
    L5:
        if (featureId == 9) goto L8;
        return false;
    }

    private static void validateIds(HierarchyBuilder displayAreaHierarchy, Set<Integer> uniqueIdSet, Set<Integer> allIdSet) {
        int rootId = HierarchyBuilder.m9882$$Nest$fgetmRoot(displayAreaHierarchy).mFeatureId;
        if (allIdSet.add(Integer.valueOf(rootId)) == false) goto L41;
        if (uniqueIdSet.add(Integer.valueOf(rootId)) == false) goto L41;
        if (rootId > 20001) goto L39;
        int i = 0;
    L10:
        if (i >= HierarchyBuilder.m9883$$Nest$fgetmTaskDisplayAreas(displayAreaHierarchy).size()) goto L21;
        int taskDisplayAreaId = ((TaskDisplayArea) HierarchyBuilder.m9883$$Nest$fgetmTaskDisplayAreas(displayAreaHierarchy).get(i)).mFeatureId;
        if (allIdSet.add(Integer.valueOf(taskDisplayAreaId)) == false) goto L20;
        if (uniqueIdSet.add(Integer.valueOf(taskDisplayAreaId)) == false) goto L20;
        if (taskDisplayAreaId > 20001) goto L18;
        i = i + 1;
        goto L10
    L18:
        throw new IllegalStateException("TaskDisplayArea declared in the policy should nothave an id greater than FEATURE_VENDOR_LAST.");
    L20:
        throw new IllegalStateException("TaskDisplayArea must have unique id, but id=" + taskDisplayAreaId + " is not unique.");
    L21:
        Set<Integer> featureIdSet = new ArraySet();
        int i2 = 0;
    L23:
        if (i2 >= HierarchyBuilder.m9880$$Nest$fgetmFeatures(displayAreaHierarchy).size()) goto L36;
        int featureId = ((Feature) HierarchyBuilder.m9880$$Nest$fgetmFeatures(displayAreaHierarchy).get(i2)).getId();
        if (uniqueIdSet.contains(Integer.valueOf(featureId)) == true) goto L35;
        if (featureIdSet.add(Integer.valueOf(featureId)) == false) goto L33;
        if (featureId > 20001) goto L31;
        i2 = i2 + 1;
        goto L23
    L31:
        throw new IllegalStateException("Feature should not have an id greater than FEATURE_VENDOR_LAST.");
    L33:
        throw new IllegalStateException("Feature below the same root must have unique id, but id=" + featureId + " is not unique.");
    L35:
        throw new IllegalStateException("Feature must not have same id with any RootDisplayArea or TaskDisplayArea, but id=" + featureId + " is used");
    L36:
        allIdSet.addAll(featureIdSet);
        return;
    L39:
        throw new IllegalStateException("RootDisplayArea should not have an id greater than FEATURE_VENDOR_LAST.");
    L41:
        throw new IllegalStateException("RootDisplayArea must have unique id, but id=" + rootId + " is not unique.");
    }

    Result build(WindowManagerService wmService) {
        if (this.mRootHierarchyBuilder != null) goto L5;
    L7:
        validate();
        HierarchyBuilder.m9885$$Nest$mbuild(this.mRootHierarchyBuilder, this.mDisplayAreaGroupHierarchyBuilders);
        List<RootDisplayArea> displayAreaGroupRoots = new ArrayList(this.mDisplayAreaGroupHierarchyBuilders.size());
        int i = 0;
    L9:
        if (i >= this.mDisplayAreaGroupHierarchyBuilders.size()) goto L12;
        HierarchyBuilder hierarchyBuilder = this.mDisplayAreaGroupHierarchyBuilders.get(i);
        HierarchyBuilder.m9884$$Nest$mbuild(hierarchyBuilder);
        displayAreaGroupRoots.add(HierarchyBuilder.m9882$$Nest$fgetmRoot(hierarchyBuilder));
        i = i + 1;
        goto L9
    L12:
        if (this.mSelectRootForWindowFunc != null) goto L15;
        this.mSelectRootForWindowFunc = new DefaultSelectRootForWindowFunction(HierarchyBuilder.m9882$$Nest$fgetmRoot(this.mRootHierarchyBuilder), displayAreaGroupRoots);
    L15:
        return new Result(wmService, HierarchyBuilder.m9882$$Nest$fgetmRoot(this.mRootHierarchyBuilder), displayAreaGroupRoots, this.mSelectRootForWindowFunc, this.mSelectTaskDisplayAreaFunc);
    L5:
        if (this.mRootHierarchyBuilder.hasValidWindowingLayer() == true) goto L7;
        HierarchyBuilder.m9880$$Nest$fgetmFeatures(this.mRootHierarchyBuilder).add(0, new Feature.Builder(wmService.mPolicy, "WindowingLayer", 9).setExcludeRoundedCornerOverlay(false).all().build());
        goto L7
    }
}
