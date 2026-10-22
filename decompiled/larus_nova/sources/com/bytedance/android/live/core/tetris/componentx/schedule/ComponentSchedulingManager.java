package com.bytedance.android.live.core.tetris.componentx.schedule;

import androidx.camera.video.AudioStats;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.LiveInfraSettingKeys;
import com.bytedance.android.live.core.tetris.layer.core.descriptor.LayerDescriptorList;
import com.bytedance.android.live.core.tetris.layer.view.ElementConstraint;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.ComponentBatchPriorityCellConfig;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.ComponentBatchPriorityMappingConfig;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.ComponentManagerABHelper;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.videoarch.strategy.dataCenter.config.model.FeatureConfigInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class ComponentSchedulingManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f65557a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public j f65558b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public f f65559c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public SchedueType f65560d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public g70.a f65561e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Map<f70.b, LayerDescriptorList> f65562f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public b f65563g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public q f65564h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ComponentBatchBaseLoadState f65565i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f65566j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f65567k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ScenInfo f65568l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public h70.b f65569m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final LinkedHashMap<f70.b, LinkedHashMap<Integer, m>> f65570n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public LinkedHashMap<Integer, m> f65571o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Map<String, j70.h<? extends h70.b>> f65572p;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/core/tetris/componentx/schedule/ComponentSchedulingManager$ScenInfo;", "", "AUDIENCE_LANDSCAPE", "AUDIENCE_PORTRAIT", FeatureConfigInfo.ANCHOR_PROFILE_FEATURE_TYPE_ID, "tetris_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum ScenInfo extends Enum<ScenInfo> {
        public static final ScenInfo ANCHOR = null;
        public static final ScenInfo AUDIENCE_LANDSCAPE = null;
        public static final ScenInfo AUDIENCE_PORTRAIT = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ScenInfo[] f65573a = null;

        static {
            ScenInfo r100 = new ScenInfo("AUDIENCE_LANDSCAPE", 0);
            AUDIENCE_LANDSCAPE = r100;
            ScenInfo r101 = new ScenInfo("AUDIENCE_PORTRAIT", 1);
            AUDIENCE_PORTRAIT = r101;
            ScenInfo r102 = new ScenInfo(FeatureConfigInfo.ANCHOR_PROFILE_FEATURE_TYPE_ID, 2);
            ANCHOR = r102;
            f65573a = new ScenInfo[]{r100, r101, r102};
        }

        public static ScenInfo valueOf(String r100) {
            return (ScenInfo) r27.a.a(ScenInfo.class, r100);
        }

        public static ScenInfo[] values() {
            return (ScenInfo[]) f65573a.clone();
        }

        public ScenInfo(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/core/tetris/componentx/schedule/ComponentSchedulingManager$SchedueType;", "", "", "key", "Ljava/lang/String;", "getKey", "()Ljava/lang/String;", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "TOGETHER", "INORDER", "tetris_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum SchedueType extends Enum<SchedueType> {
        public static final a Companion = null;
        public static final SchedueType INORDER = null;
        public static final SchedueType TOGETHER = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ SchedueType[] f65574a = null;
        private final String key;

        public static final class a {
            public a() {
            }
        }

        static {
            SchedueType r100 = new SchedueType("TOGETHER", 0, "together");
            TOGETHER = r100;
            SchedueType r101 = new SchedueType("INORDER", 1, "inorder");
            INORDER = r101;
            f65574a = new SchedueType[]{r100, r101};
            Companion = new a();
        }

        public static SchedueType valueOf(String r100) {
            return (SchedueType) r27.a.a(SchedueType.class, r100);
        }

        public static SchedueType[] values() {
            return (SchedueType[]) f65574a.clone();
        }

        public final String getKey() {
            return this.key;
        }

        public SchedueType(String r100, int r101, String r102) {
            super(r100, r101);
            this.key = r102;
        }
    }

    public interface a {
        void a(f70.b r100, int r101, m r102);
    }

    public interface b {
        void a(int r100, m r101, boolean r102);
    }

    public final List<j70.f> c() {
        ArrayList r100 = new ArrayList();
        Map<String, j70.h<? extends h70.b>> r101 = this.f65572p;
        if (r101 == null) goto L16;
        Iterator r102 = ((LinkedHashMap) r101).entrySet().iterator();
    L6:
        if (r102.hasNext() == false) goto L16;
        Map.Entry r103 = (Map.Entry) r102.next();
        h70.b r104 = this.f65569m;
        if (r104 == null) goto L6;
        j70.h r105 = (j70.h) r103.getValue();
        if ((r105 instanceof j70.h) == true) goto L12;
        r105 = null;
    L12:
        if (r105 == null) goto L6;
        j70.f r106 = r105.C(r104);
        if (r106 == null) goto L6;
        r100.add(r106);
    L16:
        return r100;
    }

    public final void g() {
        ComponentBatchBaseLoadState r100 = this.f65565i;
        if (r100 == null) goto L5;
        r100.a();
    L5:
        Map<String, j70.h<? extends h70.b>> r101 = this.f65572p;
        if (r101 == null) goto L8;
        ((LinkedHashMap) r101).clear();
    L8:
        LinkedHashMap<Integer, m> r102 = this.f65571o;
        if (r102 == null) goto L11;
        r102.clear();
    L11:
        LinkedHashMap<f70.b, LinkedHashMap<Integer, m>> r103 = this.f65570n;
        if (r103 == null) goto L14;
        r103.clear();
    L14:
        this.f65566j = false;
        this.f65558b = null;
        ALogger.i(this.f65557a, "OnDestory");
    }

    public ComponentSchedulingManager() {
        this.f65557a = "ComponentSchedulingManager";
        this.f65560d = SchedueType.TOGETHER;
        this.f65567k = 3;
        this.f65568l = ScenInfo.AUDIENCE_PORTRAIT;
        this.f65570n = new LinkedHashMap();
        this.f65571o = new LinkedHashMap();
        this.f65572p = new LinkedHashMap();
    }

    public final LayerDescriptorList a(LayerDescriptorList r100) {
        Intrinsics.checkNotNullParameter(r100, "descriptorList");
        g70.a r101 = this.f65561e;
        if (r101 == null) goto L5;
        LayerDescriptorList r102 = r101.a(r100);
    L6:
        this.f65566j = true;
        if (r102 != null) goto L10;
        return r100;
    L10:
        return r102;
    L5:
        r102 = null;
        goto L6
    }

    public final l b(j70.h<h70.b> r110) {
        l r100 = new l();
        h70.b r101 = this.f65569m;
        if (r101 == null) goto L77;
        j70.f r102 = r110.C(r101);
        String r103 = "";
        if (r102 == null) goto L8;
        String r104 = r102.f497559b;
        if (r104 == null) goto L8;
    L9:
        j70.f r105 = r110.C(r101);
        if (r105 == null) goto L15;
        String r106 = r105.f497558a;
        if (r106 == null) goto L15;
        r103 = r106;
    L15:
        String r107 = r104.concat(r103);
        Intrinsics.checkNotNullParameter(r107, "<set-?>");
        r100.f65619a = r107;
        h70.b r108 = this.f65569m;
        double r109 = AudioStats.AUDIO_AMPLITUDE_NONE;
        if (r108 != null) goto L18;
        double r111 = 0.0d;
    L29:
        h70.b r112 = this.f65569m;
        ElementConstraint r113 = null;
        if (r112 == null) goto L59;
        j70.f r114 = r110.C(r112);
        if (r114 == null) goto L34;
        String r115 = r114.f497559b;
    L35:
        ALogger.d("ComponentLocalPrioritysConfig", "enable = " + LiveInfraSettingKeys.LIVE_COMPONENT_DYNAMIC_BATCH_CONFIG.getValue().getEnable());
        f r116 = this.f65559c;
        if (r116 != null) goto L38;
    L46:
        j r117 = this.f65558b;
        if (r117 == null) goto L51;
        Map<String, Double> r118 = r117.f65617c;
        if (r118 == null) goto L51;
        Double r119 = r118.get(r115);
    L52:
        if (r119 != null) goto L55;
        r109 = r111;
        goto L59
    L55:
        if ((true ^ Intrinsics.areEqual(r111, r119)) == false) goto L57;
        double r120 = r119.doubleValue();
    L58:
        r109 = r120;
        goto L59
    L57:
        r120 = r119.doubleValue();
    L51:
        r119 = null;
        goto L52
    L38:
        if (r116.b() != true) goto L46;
        f r121 = this.f65559c;
        Intrinsics.checkNotNull(r121);
        r121.getClass();
        Double r122 = (Double) ((LinkedHashMap) k.f65618a).get(r115);
        if (r122 == null) goto L42;
        double r123 = r122.doubleValue();
    L44:
        if (r123 == AudioStats.AUDIO_AMPLITUDE_NONE) goto L46;
        ALogger.d("ComponentLocalPrioritysConfig", "tag is " + r115 + "  localPriority = " + r123);
        r111 = r123;
        goto L46
    L42:
        r123 = 0.0d;
        goto L44
    L34:
        r115 = null;
    L59:
        r100.f65620b = r109;
        if ((r110 instanceof j70.n) == false) goto L63;
        ((j70.n) r110).h();
    L63:
        if ((r110 instanceof e70.a) == false) goto L65;
        ((e70.a) r110).O().u();
    L65:
        int r124 = d80.a.f467382a;
        h70.b r125 = this.f65569m;
        if (r125 == null) goto L68;
        r113 = r110.J(r125);
    L68:
        LinkedHashMap r126 = new LinkedHashMap();
        if (r113 == null) goto L76;
        List<ElementConstraint.c> r127 = r113.f65832j;
        if (r127 == null) goto L76;
        Iterator r128 = ((ArrayList) r127).iterator();
    L74:
        if (r128.hasNext() == false) goto L76;
        r126.put(DependencyEnum.BEFORE, ((ElementConstraint.c) r128.next()).f65841b.f65839c);
    L76:
        Intrinsics.checkNotNullParameter(r126, "<set-?>");
        r110.B(r101);
        r100.f65621c = r110;
        goto L77
    L18:
        int r129 = n.f65625b[this.f65568l.ordinal()];
        if (r129 != 1) goto L21;
        h70.b r130 = this.f65569m;
        Intrinsics.checkNotNull(r130);
        r111 = r110.F(r130);
        goto L29
    L21:
        if (r129 != 2) goto L23;
        h70.b r131 = this.f65569m;
        Intrinsics.checkNotNull(r131);
        r111 = r110.H(r131);
        goto L29
    L23:
        if (r129 != 3) goto L26;
        h70.b r132 = this.f65569m;
        Intrinsics.checkNotNull(r132);
        r111 = r110.G(r132);
        goto L29
    L26:
        throw new NoWhenBranchMatchedException();
    L8:
        r104 = "";
    L77:
        return r100;
    }

    public final Map<f70.b, LayerDescriptorList> d(Map<f70.b, List<j70.f>> r100) {
        Intrinsics.checkNotNullParameter(r100, "componentsElementTypeList");
        LinkedHashMap r101 = new LinkedHashMap();
        Iterator<Map.Entry<f70.b, List<j70.f>>> r102 = r100.entrySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L18;
        Map.Entry<f70.b, List<j70.f>> r103 = r102.next();
        LayerDescriptorList r104 = new LayerDescriptorList();
        Iterator<T> r105 = r103.getValue().iterator();
    L7:
        if (r105.hasNext() == false) goto L17;
        j70.f r106 = (j70.f) r105.next();
        Map<String, j70.h<? extends h70.b>> r107 = this.f65572p;
        String r108 = null;
        if (r106 == null) goto L11;
        String r109 = r106.f497559b;
    L12:
        if (r106 == null) goto L14;
        r108 = r106.f497558a;
    L14:
        j70.h r110 = (j70.h) ((LinkedHashMap) r107).get(Intrinsics.stringPlus(r109, r108));
        if (r110 == null) goto L7;
        r104.add(r110);
        goto L7
    L11:
        r109 = null;
        goto L12
    L17:
        r101.put(r103.getKey(), r104);
        goto L4
    L18:
        return r101;
    }

    public final void e(Map<f70.b, LayerDescriptorList> r210) {
        int r100 = n.f65624a[this.f65560d.ordinal()];
        String r101 = " description = ";
        String r102 = "createComponentSchedulingInfo ___ tag = ";
        if (r100 != 1) goto L5;
        Intrinsics.checkNotNullParameter(r210, "layerDescriptorList");
        Iterator<Map.Entry<f70.b, LayerDescriptorList>> r103 = r210.entrySet().iterator();
    L101:
        if (r103.hasNext() == false) goto L212;
        Map.Entry<f70.b, LayerDescriptorList> r104 = r103.next();
        f70.b r105 = r104.getKey();
        LayerDescriptorList r106 = a(r104.getValue());
        LinkedHashMap r107 = new LinkedHashMap();
        if (r106 == null) goto L144;
        Iterator<j70.h<? extends h70.b>> r108 = r106.iterator();
    L106:
        if (r108.hasNext() == false) goto L144;
        j70.h<h70.b> r110 = (j70.h) r108.next();
        h70.b r111 = this.f65569m;
        if (r111 == null) goto L106;
        boolean r112 = r110 instanceof j70.h;
        if (r112 == true) goto L112;
        j70.h<h70.b> r113 = null;
    L113:
        if (r113 == null) goto L118;
        j70.f r114 = r113.C(r111);
        if (r114 == null) goto L118;
        String r115 = r114.f497559b;
        if (r115 == null) goto L118;
    L119:
        if (r112 == true) goto L121;
        j70.h<h70.b> r116 = null;
    L122:
        if (r116 == null) goto L127;
        j70.f r117 = r116.C(r111);
        if (r117 == null) goto L127;
        String r118 = r117.f497558a;
        if (r118 == null) goto L127;
    L128:
        if (r112 == true) goto L130;
        j70.h<h70.b> r119 = null;
    L131:
        if (r119 == null) goto L133;
        l r120 = b(r119);
    L135:
        if (ComponentManagerABHelper.INSTANCE.enableFullLog() == false) goto L137;
        ALogger.i(this.f65557a, r102 + r115 + r101 + r118);
    L137:
        r107.put(r115.concat(r118), r120);
        if (r112 == true) goto L140;
        j70.h<h70.b> r109 = null;
    L141:
        if (r109 == null) goto L106;
        Map<String, j70.h<? extends h70.b>> r121 = this.f65572p;
        StringBuilder r122 = new StringBuilder();
        h70.b r123 = this.f65569m;
        Intrinsics.checkNotNull(r123);
        r122.append(r109.C(r123).f497559b);
        h70.b r124 = this.f65569m;
        Intrinsics.checkNotNull(r124);
        r122.append(r109.C(r124).f497558a);
        r121.put(r122.toString(), r110);
        goto L106
    L140:
        r109 = r110;
        goto L141
    L133:
        r120 = null;
        goto L135
    L130:
        r119 = r110;
    L127:
        r118 = "";
        goto L128
    L121:
        r116 = r110;
    L118:
        r115 = "";
        goto L119
    L112:
        r113 = r110;
    L144:
        Iterator r125 = r107.entrySet().iterator();
    L146:
        if (r125.hasNext() == false) goto L101;
        Map.Entry r126 = (Map.Entry) r125.next();
        l r127 = (l) r126.getValue();
        if (r127 == null) goto L150;
        double r128 = r127.f65620b;
    L151:
        l r129 = (l) r126.getValue();
        if (r129 == null) goto L155;
        String r130 = r129.f65619a;
        if (r130 == null) goto L155;
    L156:
        int r131 = f(r128, r130);
        m r132 = this.f65571o.get(Integer.valueOf(r131));
        m r133 = this.f65571o.get(Integer.valueOf(r131));
        if (r133 == null) goto L159;
        List<l> r134 = r133.f65622a;
    L160:
        m r135 = this.f65571o.get(Integer.valueOf(r131));
        if (r135 == null) goto L163;
        LayerDescriptorList r136 = r135.f65623b;
    L164:
        if (r134 != null) goto L166;
        r134 = new ArrayList();
    L166:
        if (r136 != null) goto L168;
        r136 = new LayerDescriptorList();
    L168:
        if (r132 != null) goto L170;
        r132 = new m(r134, r136);
    L170:
        l r137 = (l) r126.getValue();
        if (r137 == null) goto L199;
        j70.h r138 = (j70.h) ((LinkedHashMap) this.f65572p).get(r137.f65619a);
        if (r138 == null) goto L199;
        if (r136.contains(r138) == true) goto L198;
        Intrinsics.checkNotNullParameter(r137, "newInfo");
        Intrinsics.checkNotNullParameter(r134, "infoList");
        Iterator<l> r139 = r134.iterator();
        int r140 = 0;
    L177:
        Iterator<Map.Entry<f70.b, LayerDescriptorList>> r141 = r103;
        if (r139.hasNext() == false) goto L186;
        Iterator r142 = r125;
        String r211 = r101;
        String r212 = r102;
        if (r139.next().f65620b <= r137.f65620b) goto L182;
        boolean r143 = true;
    L183:
        if (r143 == true) goto L184;
        r140 = r140 + 1;
        r125 = r142;
        r103 = r141;
        r101 = r211;
        r102 = r212;
        goto L177
    L184:
        int r144 = -1;
    L187:
        if (r140 != r144) goto L189;
        r134.add(r137);
    L196:
        if (ComponentManagerABHelper.INSTANCE.enableFullLog() == false) goto L200;
        ALogger.i(this.f65557a, "loadingList  当前添加的组件为 " + r138);
    L200:
        r136.clear();
        ArrayList r145 = new ArrayList();
        Iterator<T> r146 = r134.iterator();
    L202:
        if (r146.hasNext() == false) goto L206;
        j70.h<? extends h70.b> r147 = ((l) r146.next()).f65621c;
        if (r147 == null) goto L202;
        r145.add(r147);
        goto L202
    L206:
        Iterator r148 = r145.iterator();
    L208:
        if (r148.hasNext() == false) goto L210;
        r136.add((j70.h) r148.next());
        goto L208
    L210:
        r132.f65622a = r134;
        r132.f65623b = r136;
        this.f65571o.put(Integer.valueOf(r131), r132);
        r125 = r142;
        r103 = r141;
        r101 = r211;
        r102 = r212;
        goto L146
    L189:
        l r149 = (l) CollectionsKt.getOrNull(r134, r140);
        if (r149 != null) goto L192;
    L194:
        ListProtector.add(r134, r140, r137);
        goto L196
    L192:
        if (r149.f65620b != r137.f65620b) goto L194;
        r134.add(r137);
        goto L196
    L182:
        r143 = false;
        goto L183
    L186:
        r142 = r125;
        r211 = r101;
        r212 = r102;
        r144 = -1;
        r140 = -1;
        goto L187
    L198:
        r141 = r103;
        r142 = r125;
        r211 = r101;
        r212 = r102;
        ALogger.i(this.f65557a, "重复组件 loadingList " + r138);
    L199:
        r141 = r103;
        r142 = r125;
        r211 = r101;
        r212 = r102;
        goto L200
    L163:
        r136 = null;
        goto L164
    L159:
        r134 = null;
    L155:
        r130 = "unknow";
        goto L156
    L150:
        r128 = AudioStats.AUDIO_AMPLITUDE_NONE;
        goto L151
    L212:
        LinkedHashMap<Integer, m> r150 = this.f65571o;
        if (ComponentManagerABHelper.INSTANCE.enableRoomSceneSchedulerPrioritylevelCheck() == true) goto L217;
        if (r150 == null) goto L216;
        SortedMap r151 = MapsKt.toSortedMap(r150);
    L241:
        this.f65571o = new LinkedHashMap(r151);
        return;
    L216:
        r151 = null;
        goto L241
    L217:
        f r152 = this.f65559c;
        if (r152 != null) goto L220;
        int r153 = this.f65567k;
    L229:
        if (r153 < 0) goto L237;
        int r154 = 0;
    L232:
        if (r150.containsKey(Integer.valueOf(r154)) == true) goto L234;
        SortedMap r155 = null;
        r150.put(Integer.valueOf(r154), new m(null, null));
    L235:
        if (r154 == r153) goto L238;
        r154 = r154 + 1;
    L238:
        if (r150 == null) goto L240;
        r151 = MapsKt.toSortedMap(r150);
        goto L241
    L240:
        r151 = r155;
        goto L241
    L234:
        r155 = null;
        goto L235
    L237:
        r155 = null;
        goto L238
    L220:
        if (r152.b() == false) goto L227;
        List<ComponentBatchPriorityCellConfig> r156 = r152.f65600a;
        if (r156 == null) goto L226;
        ComponentBatchPriorityCellConfig r157 = (ComponentBatchPriorityCellConfig) CollectionsKt.last(r156);
        if (r157 == null) goto L226;
        r153 = r157.getBatch();
    L226:
        r153 = 0;
        goto L229
    L227:
        r153 = 3;
        goto L229
    L5:
        if (r100 != 2) goto L272;
        Intrinsics.checkNotNullParameter(r210, "layerDescriptorList");
        Iterator<Map.Entry<f70.b, LayerDescriptorList>> r158 = r210.entrySet().iterator();
    L9:
        if (r158.hasNext() == false) goto L273;
        Map.Entry<f70.b, LayerDescriptorList> r159 = r158.next();
        f70.b r160 = r159.getKey();
        LayerDescriptorList r161 = r159.getValue();
        LinkedHashMap r162 = new LinkedHashMap();
        LayerDescriptorList r163 = a(r161);
        if (r163 == null) goto L53;
        Iterator<j70.h<? extends h70.b>> r164 = r163.iterator();
    L14:
        if (r164.hasNext() == false) goto L53;
        j70.h<h70.b> r165 = (j70.h) r164.next();
        h70.b r166 = this.f65569m;
        if (r166 == null) goto L14;
        boolean r167 = r165 instanceof j70.h;
        if (r167 == true) goto L20;
        j70.h<h70.b> r168 = null;
    L21:
        if (r168 == null) goto L26;
        j70.f r169 = r168.C(r166);
        if (r169 == null) goto L26;
        String r170 = r169.f497559b;
        if (r170 == null) goto L26;
    L27:
        if (r167 == true) goto L29;
        j70.h<h70.b> r171 = null;
    L30:
        if (r171 == null) goto L35;
        j70.f r172 = r171.C(r166);
        if (r172 == null) goto L35;
        String r173 = r172.f497558a;
        if (r173 == null) goto L35;
    L36:
        if (r167 == true) goto L38;
        j70.h<h70.b> r174 = null;
    L39:
        if (r174 == null) goto L41;
        l r175 = b(r174);
    L43:
        if (ComponentManagerABHelper.INSTANCE.enableFullLog() == false) goto L46;
        ALogger.i(this.f65557a, "createComponentSchedulingInfo ___ tag = " + r170 + " description = " + r173);
    L46:
        r162.put(r170.concat(r173), r175);
        if (r167 == true) goto L49;
        j70.h<h70.b> r176 = null;
    L50:
        if (r176 == null) goto L52;
        Map<String, j70.h<? extends h70.b>> r177 = this.f65572p;
        StringBuilder r178 = new StringBuilder();
        h70.b r179 = this.f65569m;
        Intrinsics.checkNotNull(r179);
        r178.append(r176.C(r179).f497559b);
        h70.b r180 = this.f65569m;
        Intrinsics.checkNotNull(r180);
        r178.append(r176.C(r180).f497558a);
        r177.put(r178.toString(), r165);
    L52:
        r158 = r158;
        goto L14
    L49:
        r176 = r165;
        goto L50
    L41:
        r175 = null;
        goto L43
    L38:
        r174 = r165;
    L35:
        r173 = "";
        goto L36
    L29:
        r171 = r165;
    L26:
        r170 = "";
        goto L27
    L20:
        r168 = r165;
    L53:
        Iterator<Map.Entry<f70.b, LayerDescriptorList>> r213 = r158;
        LinkedHashMap r181 = new LinkedHashMap();
        Iterator r182 = r162.entrySet().iterator();
    L55:
        if (r182.hasNext() == false) goto L98;
        Map.Entry r183 = (Map.Entry) r182.next();
        l r184 = (l) r183.getValue();
        if (r184 == null) goto L59;
        double r185 = r184.f65620b;
    L60:
        l r186 = (l) r183.getValue();
        if (r186 == null) goto L64;
        String r187 = r186.f65619a;
        if (r187 == null) goto L64;
    L65:
        int r188 = f(r185, r187);
        m r189 = (m) r181.get(Integer.valueOf(r188));
        m r190 = (m) r181.get(Integer.valueOf(r188));
        if (r190 == null) goto L68;
        List<l> r191 = r190.f65622a;
    L69:
        m r192 = (m) r181.get(Integer.valueOf(r188));
        if (r192 == null) goto L72;
        LayerDescriptorList r193 = r192.f65623b;
    L73:
        if (r191 != null) goto L75;
        r191 = new ArrayList();
    L75:
        if (r193 != null) goto L77;
        r193 = new LayerDescriptorList();
    L77:
        if (r189 != null) goto L79;
        r189 = new m(r191, r193);
    L79:
        l r194 = (l) r183.getValue();
        if (r194 == null) goto L87;
        j70.h r195 = (j70.h) ((LinkedHashMap) this.f65572p).get(r194.f65619a);
        if (r195 == null) goto L87;
        if (r193.contains(r195) == true) goto L86;
        r193.add(r195);
        r191.add(r194);
        goto L87
    L86:
        ALogger.i(this.f65557a, "重复组件 loadingList " + r195);
    L87:
        r193.clear();
        ArrayList r196 = new ArrayList();
        Iterator<T> r197 = r191.iterator();
    L89:
        if (r197.hasNext() == false) goto L93;
        j70.h<? extends h70.b> r198 = ((l) r197.next()).f65621c;
        if (r198 == null) goto L89;
        r196.add(r198);
        goto L89
    L93:
        Iterator r199 = r196.iterator();
    L95:
        if (r199.hasNext() == false) goto L97;
        r193.add((j70.h) r199.next());
        goto L95
    L97:
        r189.f65622a = r191;
        r189.f65623b = r193;
        this.f65571o.put(Integer.valueOf(r188), r189);
        goto L55
    L72:
        r193 = null;
        goto L73
    L68:
        r191 = null;
    L64:
        r187 = "unknow";
        goto L65
    L59:
        r185 = AudioStats.AUDIO_AMPLITUDE_NONE;
        goto L60
    L98:
        this.f65570n.put(r160, new LinkedHashMap(MapsKt.toSortedMap(r181)));
        r158 = r213;
        goto L9
    L273:
        return;
    }

    public final int f(double r100, String r110) {
        Intrinsics.checkNotNullParameter(r110, "name");
        f r101 = this.f65559c;
        if (r101 != null) goto L5;
        int r102 = (int) r100;
    L25:
        ALogger.i(this.f65557a, "name = " + r110 + " ____ priority = " + r100 + " ____ priorityLevel = " + r102);
        return r102;
    L5:
        if (r101.b() == false) goto L23;
        List<ComponentBatchPriorityCellConfig> r103 = r101.f65600a;
        ComponentBatchPriorityCellConfig r104 = null;
        Object r105 = null;
        if (r103 == null) goto L20;
        Iterator<T> r106 = r103.iterator();
    L10:
        if (r106.hasNext() == false) goto L19;
        Object r107 = r106.next();
        ComponentBatchPriorityCellConfig r108 = (ComponentBatchPriorityCellConfig) r107;
        if (r100 >= r108.getStart()) goto L14;
    L16:
        boolean r109 = false;
    L17:
        if (r109 == false) goto L10;
        r105 = r107;
        goto L19
    L14:
        if (r100 >= r108.getEnd()) goto L16;
        r109 = true;
    L19:
        r104 = (ComponentBatchPriorityCellConfig) r105;
    L20:
        if (r104 == null) goto L22;
        r102 = r104.getBatch();
        goto L25
    L22:
        r102 = f.c(r100);
        goto L25
    L23:
        r102 = f.c(r100);
        goto L25
    }

    public final void h(c r110, com.bytedance.android.live.core.tetris.componentx.c r111, q r112) {
        Intrinsics.checkNotNullParameter(r110, "conditionConfig");
        Intrinsics.checkNotNullParameter(r111, "loadNotify");
        this.f65563g = r111;
        f r100 = this.f65559c;
        LinkedHashMap r101 = new LinkedHashMap();
        int r102 = 0;
    L4:
        if (r102 >= 10) goto L28;
        if (r100 == null) goto L23;
        if (r100.b() != true) goto L23;
        if (LiveInfraSettingKeys.LIVE_SUBBATCH_LOAD_FIX.getValue().booleanValue() == false) goto L16;
        ComponentBatchPriorityMappingConfig r103 = LiveInfraSettingKeys.LIVE_COMPONENT_DYNAMIC_BATCH_CONFIG.getValue().getPriorityMapping();
        if (r103 == null) goto L14;
        int r104 = r103.getP0_end();
    L15:
        int r105 = r104 + 1;
    L18:
        if (r110.f65587a == false) goto L21;
        if (r102 != r105) goto L21;
        r101.put(Integer.valueOf(r102), SetsKt.mutableSetOf(new BatchTogetherConditionManager.BatchLoadConditionType[]{BatchTogetherConditionManager.BatchLoadConditionType.END_DELAY_TIME, BatchTogetherConditionManager.BatchLoadConditionType.END_BATCH_ONLOAD, BatchTogetherConditionManager.BatchLoadConditionType.END_ROOM_ENTER}));
    L27:
        r102 = r102 + 1;
    L21:
        r101.put(Integer.valueOf(r102), SetsKt.mutableSetOf(new BatchTogetherConditionManager.BatchLoadConditionType[]{BatchTogetherConditionManager.BatchLoadConditionType.END_DELAY_TIME, BatchTogetherConditionManager.BatchLoadConditionType.END_BATCH_ONLOAD}));
        goto L27
    L14:
        r104 = 0;
        goto L15
    L16:
        r105 = 1;
    L23:
        if (r110.f65587a == false) goto L26;
        if (r102 != 1) goto L26;
        r101.put(Integer.valueOf(r102), SetsKt.mutableSetOf(new BatchTogetherConditionManager.BatchLoadConditionType[]{BatchTogetherConditionManager.BatchLoadConditionType.END_DELAY_TIME, BatchTogetherConditionManager.BatchLoadConditionType.END_BATCH_ONLOAD, BatchTogetherConditionManager.BatchLoadConditionType.END_ROOM_ENTER}));
    L26:
        r101.put(Integer.valueOf(r102), SetsKt.mutableSetOf(new BatchTogetherConditionManager.BatchLoadConditionType[]{BatchTogetherConditionManager.BatchLoadConditionType.END_DELAY_TIME, BatchTogetherConditionManager.BatchLoadConditionType.END_BATCH_ONLOAD}));
        goto L27
    L28:
        int r113 = n.f65626c[this.f65560d.ordinal()];
        if (r113 == 1) goto L33;
        if (r113 != 2) goto L41;
        e r114 = new e(this.f65570n, this.f65558b, r112, new p(this, r111));
        this.f65565i = r114;
        r114.g(r101);
        return;
    L41:
        return;
    L33:
        i r115 = new i(this.f65571o, r112, new o(this, r111), this.f65559c);
        this.f65565i = r115;
        r115.e(r101);
    }
}
