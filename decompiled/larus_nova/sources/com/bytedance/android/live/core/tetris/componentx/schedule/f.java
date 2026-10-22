package com.bytedance.android.live.core.tetris.componentx.schedule;

import androidx.camera.video.AudioStats;
import com.bytedance.android.live.core.setting.LiveInfraSettingKeys;
import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.ComponentBatchPriorityCellConfig;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.ComponentBatchPriorityConfig;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.ComponentBatchPriorityMappingConfig;
import java.util.Comparator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: classes45.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<ComponentBatchPriorityCellConfig> f65600a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final j f65601b;

    public static final class a<T> implements Comparator<T> {
        public a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r100, T r101) {
            return ComparisonsKt.compareValues(Double.valueOf(((ComponentBatchPriorityCellConfig) r100).getStart()), Double.valueOf(((ComponentBatchPriorityCellConfig) r101).getStart()));
        }
    }

    public static int c(double r100) {
        if (r100 < AudioStats.AUDIO_AMPLITUDE_NONE) goto L8;
        if (r100 > 1.0d) goto L8;
        return 0;
    L8:
        if (r100 < 1.0d) goto L13;
        if (r100 > 2.0d) goto L13;
        return 1;
    L13:
        if (r100 < 2.0d) goto L18;
        if (r100 > 3.0d) goto L18;
        return 2;
    L18:
        if (r100 < 3.0d) goto L23;
        if (r100 > 4.0d) goto L23;
        return 3;
    L23:
        if (r100 < 4.0d) goto L28;
        if (r100 > 5.0d) goto L28;
        return 4;
    L28:
        if (r100 < 5.0d) goto L33;
        if (r100 > 6.0d) goto L33;
        return 5;
    L33:
        return (int) r100;
    }

    public final boolean b() {
        SettingKey<ComponentBatchPriorityConfig> r100 = LiveInfraSettingKeys.LIVE_COMPONENT_DYNAMIC_BATCH_CONFIG;
        if (r100.getValue().getEnable() == false) goto L14;
        List<Integer> r101 = r100.getValue().getStrategyList();
        if (r101 == null) goto L15;
        j r102 = this.f65601b;
        if (r102 == null) goto L9;
        int r103 = r102.f65615a;
    L11:
        if (r101.contains(Integer.valueOf(r103)) != true) goto L16;
        return true;
    L16:
        return false;
    L9:
        r103 = 0;
        goto L11
    L15:
        return false;
    L14:
        return false;
    }

    public f(j r100) {
        this.f65601b = r100;
        this.f65600a = CollectionsKt.emptyList();
        List<ComponentBatchPriorityCellConfig> r101 = LiveInfraSettingKeys.LIVE_COMPONENT_DYNAMIC_BATCH_CONFIG.getValue().getCells();
        if (r101 == null) goto L5;
        List<ComponentBatchPriorityCellConfig> r102 = CollectionsKt.sortedWith(r101, new a());
    L6:
        this.f65600a = r102;
        return;
    L5:
        r102 = null;
        goto L6
    }

    public final String a(int r100, boolean r101) {
        if (b() == false) goto L53;
        if (r101 == false) goto L26;
        SettingKey<ComponentBatchPriorityConfig> r102 = LiveInfraSettingKeys.LIVE_COMPONENT_DYNAMIC_BATCH_CONFIG;
        ComponentBatchPriorityMappingConfig r103 = r102.getValue().getPriorityMapping();
        if (r103 != null) goto L9;
    L11:
        ComponentBatchPriorityMappingConfig r104 = r102.getValue().getPriorityMapping();
        if (r104 != null) goto L14;
    L16:
        ComponentBatchPriorityMappingConfig r105 = r102.getValue().getPriorityMapping();
        if (r105 != null) goto L19;
    L21:
        ComponentBatchPriorityMappingConfig r106 = r102.getValue().getPriorityMapping();
        if (r106 == null) goto L47;
        if (r100 != r106.getP3_start()) goto L47;
        return "3";
    L47:
        if (LiveInfraSettingKeys.LIVE_SUBBATCH_LOAD_FIX.getValue().booleanValue() == false) goto L51;
        return "";
    L51:
        return String.valueOf(r100);
    L19:
        if (r100 != r105.getP2_start()) goto L21;
        return "2";
    L14:
        if (r100 != r104.getP1_start()) goto L16;
        return "1";
    L9:
        if (r100 != r103.getP0_start()) goto L11;
        return "0";
    L26:
        SettingKey<ComponentBatchPriorityConfig> r107 = LiveInfraSettingKeys.LIVE_COMPONENT_DYNAMIC_BATCH_CONFIG;
        ComponentBatchPriorityMappingConfig r108 = r107.getValue().getPriorityMapping();
        if (r108 != null) goto L29;
    L31:
        ComponentBatchPriorityMappingConfig r109 = r107.getValue().getPriorityMapping();
        if (r109 != null) goto L34;
    L36:
        ComponentBatchPriorityMappingConfig r110 = r107.getValue().getPriorityMapping();
        if (r110 != null) goto L39;
    L41:
        ComponentBatchPriorityMappingConfig r111 = r107.getValue().getPriorityMapping();
        if (r111 == null) goto L47;
        if (r100 != r111.getP3_end()) goto L47;
        return "3";
    L39:
        if (r100 != r110.getP2_end()) goto L41;
        return "2";
    L34:
        if (r100 != r109.getP1_end()) goto L36;
        return "1";
    L29:
        if (r100 != r108.getP0_end()) goto L31;
        return "0";
    L53:
        return String.valueOf(r100);
    }
}
