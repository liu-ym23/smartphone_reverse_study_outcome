package com.bytedance.android.live.core.tetris.componentx.schedule;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.LiveInfraSettingKeys;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class BatchTogetherConditionManager extends com.bytedance.android.live.core.tetris.componentx.schedule.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f65542a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Map<Integer, Set<BatchLoadConditionType>> f65543b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<Integer, Map<BatchLoadConditionType, Boolean>> f65544c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final b f65545d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final LinkedHashMap<Integer, m> f65546e;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/core/tetris/componentx/schedule/BatchTogetherConditionManager$BatchLoadConditionType;", "", "END_WIDGET", "END_DELAY_TIME", "END_BATCH_ONLOAD", "END_ROOM_ENTER", "tetris_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum BatchLoadConditionType extends Enum<BatchLoadConditionType> {
        public static final BatchLoadConditionType END_BATCH_ONLOAD = null;
        public static final BatchLoadConditionType END_DELAY_TIME = null;
        public static final BatchLoadConditionType END_ROOM_ENTER = null;
        public static final BatchLoadConditionType END_WIDGET = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ BatchLoadConditionType[] f65547a = null;

        static {
            BatchLoadConditionType r100 = new BatchLoadConditionType("END_WIDGET", 0);
            END_WIDGET = r100;
            BatchLoadConditionType r101 = new BatchLoadConditionType("END_DELAY_TIME", 1);
            END_DELAY_TIME = r101;
            BatchLoadConditionType r102 = new BatchLoadConditionType("END_BATCH_ONLOAD", 2);
            END_BATCH_ONLOAD = r102;
            BatchLoadConditionType r103 = new BatchLoadConditionType("END_ROOM_ENTER", 3);
            END_ROOM_ENTER = r103;
            f65547a = new BatchLoadConditionType[]{r100, r101, r102, r103};
        }

        public static BatchLoadConditionType valueOf(String r100) {
            return (BatchLoadConditionType) r27.a.a(BatchLoadConditionType.class, r100);
        }

        public static BatchLoadConditionType[] values() {
            return (BatchLoadConditionType[]) f65547a.clone();
        }

        public BatchLoadConditionType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {
    }

    public interface b {
        void a(int r100);
    }

    static {
    }

    @Override // com.bytedance.android.live.core.tetris.componentx.schedule.b
    public final void a(Map<Integer, Set<BatchLoadConditionType>> r100) {
        Intrinsics.checkNotNullParameter(r100, "conditionsMap");
        if (r100.isEmpty() == false) goto L5;
        return;
    L5:
        this.f65543b.clear();
        this.f65543b = r100;
        Iterator<Map.Entry<Integer, Set<BatchLoadConditionType>>> r101 = r100.entrySet().iterator();
    L7:
        if (r101.hasNext() == false) goto L13;
        Map.Entry<Integer, Set<BatchLoadConditionType>> r102 = r101.next();
        int r103 = r102.getKey().intValue();
        Set<BatchLoadConditionType> r104 = r102.getValue();
        LinkedHashMap r105 = new LinkedHashMap();
        Iterator<BatchLoadConditionType> r106 = r104.iterator();
    L10:
        if (r106.hasNext() == false) goto L12;
        r105.put(r106.next(), Boolean.FALSE);
        goto L10
    L12:
        this.f65544c.put(Integer.valueOf(r103), r105);
        goto L7
    L13:
        b(0, BatchLoadConditionType.END_BATCH_ONLOAD);
    }

    public final boolean d(int r100) {
        Map r101 = (Map) ((LinkedHashMap) this.f65544c).get(Integer.valueOf(r100));
        boolean r102 = false;
        if (r101 != null) goto L5;
        ALogger.i(this.f65542a, "Stage " + r100 + ": Condition status not found.");
    L23:
        return r102;
    L5:
        if (r101.isEmpty() == false) goto L7;
    L6:
        r102 = true;
    L12:
        if (r102 == false) goto L14;
        ALogger.i(this.f65542a, "Stage " + r100 + ": All conditions met. currentTimeMillis = " + System.currentTimeMillis());
        goto L23
    L14:
        ALogger.i(this.f65542a, "Stage " + r100 + ": Not all conditions met. currentTimeMillis = " + System.currentTimeMillis());
        Iterator r103 = r101.entrySet().iterator();
    L16:
        if (r103.hasNext() == false) goto L23;
        Map.Entry r104 = (Map.Entry) r103.next();
        BatchLoadConditionType r105 = (BatchLoadConditionType) r104.getKey();
        boolean r106 = ((Boolean) r104.getValue()).booleanValue();
        String r107 = this.f65542a;
        StringBuilder r108 = new StringBuilder("Stage ");
        r108.append(r100);
        r108.append(": Condition ");
        r108.append(r105);
        r108.append(" is ");
        if (r106 == false) goto L20;
        String r109 = "met";
    L21:
        r108.append(r109);
        r108.append(". currentTimeMillis = ");
        r108.append(System.currentTimeMillis());
        ALogger.i(r107, r108.toString());
        goto L16
    L20:
        r109 = "not met";
        goto L21
    L7:
        Iterator r110 = r101.entrySet().iterator();
    L9:
        if (r110.hasNext() == false) goto L6;
        if (((Boolean) ((Map.Entry) r110.next()).getValue()).booleanValue() == true) goto L9;
        goto L12
    }

    public final void e(int r100) {
        ALogger.i(this.f65542a, "Stage " + r100 + ": All conditions met, notifying LoadListener...");
        b r101 = this.f65545d;
        if (r101 == null) goto L6;
        r101.a(r100);
        return;
    }

    public BatchTogetherConditionManager(h r100, LinkedHashMap r101) {
        Intrinsics.checkNotNullParameter(r101, "componentSchedulingList");
        this.f65545d = r100;
        this.f65546e = r101;
        this.f65542a = "BatchTogetherConditionManager";
        this.f65543b = new LinkedHashMap();
        this.f65544c = new LinkedHashMap();
    }

    @Override // com.bytedance.android.live.core.tetris.componentx.schedule.b
    public final void b(int r100, BatchLoadConditionType r101) {
        if (r101 == null) goto L25;
        Map r102 = (Map) ((LinkedHashMap) this.f65544c).get(Integer.valueOf(r100));
        if (r102 == null) goto L25;
        if (r102.containsKey(r101) != true) goto L25;
        if (LiveInfraSettingKeys.LIVE_COMPONENTS_BATCH_CONDITIONS_FIX.getValue().booleanValue() == true) goto L11;
        Map r103 = (Map) ((LinkedHashMap) this.f65544c).get(Integer.valueOf(r100));
        if (r103 == null) goto L22;
        r103.put(r101, Boolean.TRUE);
    L22:
        ALogger.i(this.f65542a, "stage " + r100 + ": Condition updated: " + r101);
        if (d(r100) == false) goto L30;
        e(r100);
        return;
    L30:
        return;
    L11:
        if (d(r100) == true) goto L18;
        ALogger.i(this.f65542a, "Stage " + r100 + ": 当前不满足条件，需要更新加载条件");
        Map r104 = (Map) ((LinkedHashMap) this.f65544c).get(Integer.valueOf(r100));
        if (r104 == null) goto L15;
        r104.put(r101, Boolean.TRUE);
    L15:
        ALogger.i(this.f65542a, "stage " + r100 + ": Condition updated: " + r101);
        if (d(r100) == false) goto L27;
        ALogger.i(this.f65542a, "Stage " + r100 + ": 满足所有条件，触发加载");
        e(r100);
        return;
    L27:
        return;
    L18:
        ALogger.i(this.f65542a, "Stage " + r100 + ": 已经满足过条件，不用再次更新&加载");
        return;
    L25:
        ALogger.i(this.f65542a, "Stage " + r100 + ": Invalid or null condition provided: " + r101);
    }

    @Override // com.bytedance.android.live.core.tetris.componentx.schedule.b
    public final void c(int r100, BatchLoadConditionType r101) {
        if (r101 != BatchLoadConditionType.END_BATCH_ONLOAD) goto L8;
        int r102 = d80.a.f467382a;
        Integer r103 = (Integer) d80.a.a(this.f65546e, Integer.valueOf(r100));
        if (r103 == null) goto L7;
        r100 = r103.intValue();
        goto L8
    L7:
        r100 = Integer.MAX_VALUE;
    L8:
        b(r100, r101);
    }
}
