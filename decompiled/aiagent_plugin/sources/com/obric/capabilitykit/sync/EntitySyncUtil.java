package com.obric.capabilitykit.sync;

import android.net.Uri;
import android.os.Bundle;
import com.obric.capabilitykit.EntityProvider;
import com.obric.capabilitykit.EntitySupplier;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.l;
import com.obric.capabilitykit.logger.Logger;
import com.obric.capabilitykit.t;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import d.a.p;
import d.h.a.m;
import d.h.a.q;
import d.h.b.o;
import d.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes4.dex */
public final class EntitySyncUtil {
    public static final EntitySyncUtil INSTANCE = null;
    private static final int MAX_SIZE_ONE_GROUP = 50;
    private static final String METHOD_SYNC_DATA_CHECK_COUNT_DIFF = "syncDataCheckCountDiff";
    private static final String METHOD_SYNC_DATA_CHECK_HASH_CODE_DIFF = "syncDataCheckHashCodeDiff";
    private static final String PARAMS_SYNC_COUNT_HASH_CODE_SLOT_DATA = "syncHashCodeSlotDataList";
    private static final String PARAMS_SYNC_COUNT_TIME_SLOT_DATA = "syncCountTimeSlotDataList";
    private static final String PARAMS_SYNC_DATA_ENTITY_TYPE = "syncDataEntityType";
    private static final String PARAMS_SYNC_DATA_LAZY_DELETE = "syncDataLazyDelete";
    private static final String RESULT_DATA_CHECK_DIFF = "checkDiffResult";
    private static final String RESULT_DATA_LAZY_DELETE = "dataLazyDelete";

    static {
        INSTANCE = new EntitySyncUtil();
    }

    private EntitySyncUtil() {
    }

    private final int buildTimeSlotEntityTree(ArrayList<EntityCountTimeSlotData> r16, int r17, int r18, long r19, long r21, int[] r23, Long[] r24) {
        if (r17 <= r18) goto L6;
        return -1;
    L6:
        int r0 = r23[r18];
        if (r17 >= 1) goto L9;
        int r1 = 0;
    L10:
        int r9 = r0 - r1;
        int r11 = r16.size();
        EntityCountTimeSlotData r12 = new EntityCountTimeSlotData(r19, r21, r9, r17, r18);
        r16.add(r12);
        if (r9 <= 50) goto L14;
        if (r17 >= r18) goto L14;
        int r14 = (r17 + r18) / 2;
        r12.setLeftIndex(buildTimeSlotEntityTree(r16, r17, r14, r19, r24[r14].longValue(), r23, r24));
        r12.setRightIndex(buildTimeSlotEntityTree(r16, r14 + 1, r18, r24[r14].longValue() + 1, r21, r23, r24));
    L14:
        return r11;
    L9:
        r1 = r23[r17 - 1];
        goto L10
    }

    public static /* synthetic */ void syncData$default(EntitySyncUtil r2, EntitySyncDataSupplier r3, EntitySupplier r4, List r5, m r6, q r7, int r8, Object r9) {
        EntitySyncDataSupplier r10 = (EntitySyncDataSupplier) ZeusTransformUtils.wrapperContextForParams(r3, EntitySyncDataSupplier.class, "com.obric.aiagent.plugin");
        EntitySupplier r11 = (EntitySupplier) ZeusTransformUtils.wrapperContextForParams(r4, EntitySupplier.class, "com.obric.aiagent.plugin");
        List<Integer> r1 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        m<? super List<String>, ? super Integer, x> r12 = (m) ZeusTransformUtils.wrapperContextForParams(r6, m.class, "com.obric.aiagent.plugin");
        q<? super Uri, ? super String, ? super Bundle, Bundle> r0 = (q) ZeusTransformUtils.wrapperContextForParams(r7, q.class, "com.obric.aiagent.plugin");
        if ((r8 & 8) == 0) goto L5;
        r12 = null;
    L5:
        r2.syncData(r10, r11, r1, r12, r0);
    }

    public final void syncData(EntitySyncDataSupplier r28, EntitySupplier r29, List<Integer> r30, m<? super List<String>, ? super Integer, x> r31, q<? super Uri, ? super String, ? super Bundle, Bundle> r32) {
        EntitySyncDataSupplier r0 = (EntitySyncDataSupplier) ZeusTransformUtils.wrapperContextForParams(r28, EntitySyncDataSupplier.class, "com.obric.aiagent.plugin");
        EntitySupplier r2 = (EntitySupplier) ZeusTransformUtils.wrapperContextForParams(r29, EntitySupplier.class, "com.obric.aiagent.plugin");
        List r3 = (List) ZeusTransformUtils.wrapperContextForParams(r30, List.class, "com.obric.aiagent.plugin");
        m r4 = (m) ZeusTransformUtils.wrapperContextForParams(r31, m.class, "com.obric.aiagent.plugin");
        q r5 = (q) ZeusTransformUtils.wrapperContextForParams(r32, q.class, "com.obric.aiagent.plugin");
        o.e(r3, "indexedEntityTypes");
        o.e(r5, "innerCall");
        l.f32157a.a();
        if (r0 != null) goto L5;
        r0 = new t(r2);
    L5:
        List<EntityIdData> r6 = r0.provideSampleEntities();
        LinkedHashMap r7 = new LinkedHashMap();
        Iterator<T> r8 = r6.iterator();
    L7:
        if (r8.hasNext() == false) goto L12;
        Object r9 = r8.next();
        Integer r10 = Integer.valueOf(((EntityIdData) ZeusTransformUtils.preCheckCast(r9, EntityIdData.class, "com.obric.aiagent.plugin")).getType());
        Object r11 = r7.get(r10);
        if (r11 != null) goto L11;
        r11 = new ArrayList();
        r7.put(r10, r11);
    L11:
        ((List) ZeusTransformUtils.preCheckCast(r11, List.class, "com.obric.aiagent.plugin")).add(r9);
        goto L7
    L12:
        Map r12 = ao.e(r7);
        Iterator r13 = r3.iterator();
    L14:
        if (r13.hasNext() == false) goto L18;
        int r14 = ((Number) ZeusTransformUtils.preCheckCast(r13.next(), Number.class, "com.obric.aiagent.plugin")).intValue();
        if (r12.containsKey(Integer.valueOf(r14)) == true) goto L14;
        r12.put(Integer.valueOf(r14), p.b());
        goto L14
    L18:
        Iterator r15 = r12.entrySet().iterator();
    L20:
        if (r15.hasNext() == false) goto L111;
        Map.Entry r16 = (Map.Entry) ZeusTransformUtils.preCheckCast(r15.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        int r17 = ((Number) ZeusTransformUtils.preCheckCast(r16.getKey(), Number.class, "com.obric.aiagent.plugin")).intValue();
        List r18 = (List) ZeusTransformUtils.preCheckCast(r16.getValue(), List.class, "com.obric.aiagent.plugin");
        Logger.INSTANCE.d(EntityProvider.TAG, "start sync entity for type " + r17 + " , total " + r18.size());
        LinkedHashMap r19 = new LinkedHashMap();
        Iterator r20 = r18.iterator();
    L23:
        if (r20.hasNext() == false) goto L28;
        Object r110 = r20.next();
        Long r111 = Long.valueOf(((EntityIdData) ZeusTransformUtils.preCheckCast(r110, EntityIdData.class, "com.obric.aiagent.plugin")).getLastModifyTime());
        Object r112 = r19.get(r111);
        if (r112 != null) goto L27;
        r112 = new ArrayList();
        r19.put(r111, r112);
    L27:
        ((List) ZeusTransformUtils.preCheckCast(r112, List.class, "com.obric.aiagent.plugin")).add(r110);
        goto L23
    L28:
        Object[] r21 = p.m(r19.keySet()).toArray(new Long[0]);
        Objects.requireNonNull(r21, "null cannot be cast to non-null type kotlin.Array<T>");
        Long[] r22 = (Long[]) ZeusTransformUtils.preCheckCast(r21, Long[].class, "com.obric.aiagent.plugin");
        int[] r113 = new int[r22.length];
        int r114 = r22.length;
        int r115 = 0;
    L29:
        if (r115 >= r114) goto L38;
        List r116 = (List) ZeusTransformUtils.preCheckCast(r19.get(r22[r115]), List.class, "com.obric.aiagent.plugin");
        if (r116 == null) goto L33;
        int r117 = r116.size();
    L34:
        if (r115 == 0) goto L37;
        r117 = r117 + r113[r115 - 1];
    L37:
        r113[r115] = r117;
        r115 = r115 + 1;
        goto L29
    L33:
        r117 = 0;
        goto L34
    L38:
        ArrayList<EntityCountTimeSlotData> r118 = new ArrayList();
        INSTANCE.buildTimeSlotEntityTree(r118, 0, r22.length - 1, Long.MIN_VALUE, Long.MAX_VALUE, r113, r22);
        if (r118.size() != 0) goto L41;
        r118.add(new EntityCountTimeSlotData(Long.MIN_VALUE, Long.MAX_VALUE, 0, -1, -1));
    L41:
        Logger.INSTANCE.d(EntityProvider.TAG, "syncdata buildTimeSlotEntityTree: " + r118.size());
        Uri r23 = EntityProvider.INSTANCE.getENTITY_URI$capabilitykit_release();
        o.c(r23, "ENTITY_URI");
        Bundle r119 = new Bundle();
        r119.putParcelableArrayList(PARAMS_SYNC_COUNT_TIME_SLOT_DATA, r118);
        r119.putInt(PARAMS_SYNC_DATA_ENTITY_TYPE, r17);
        Bundle r24 = (Bundle) ZeusTransformUtils.preCheckCast(r5.invoke(r23, METHOD_SYNC_DATA_CHECK_COUNT_DIFF, r119), Bundle.class, "com.obric.aiagent.plugin");
        if (r24 == null) goto L20;
        r24.setClassLoader(EntityCountTimeSlotData.class.getClassLoader());
        ArrayList r25 = r24.getParcelableArrayList(RESULT_DATA_CHECK_DIFF);
        if (r25 == null) goto L46;
        ArrayList r120 = new ArrayList();
        LinkedHashSet r121 = new LinkedHashSet();
        LinkedHashMap r122 = new LinkedHashMap();
        Iterator r26 = r25.iterator();
    L49:
        if (r26.hasNext() == false) goto L89;
        r15 = r15;
        r26 = r26;
        EntityCountTimeSlotData r27 = (EntityCountTimeSlotData) ZeusTransformUtils.preCheckCast(r26.next(), EntityCountTimeSlotData.class, "com.obric.aiagent.plugin");
        ArrayList r33 = new ArrayList();
        if (r27.getLeftTimeArrayIndex() < 0) goto L76;
        r4 = r4;
        List r34 = r18;
        if (r27.getLeftTimeArrayIndex() >= r22.length) goto L77;
        if (r27.getRightTimeArrayIndex() < 0) goto L77;
        if (r27.getRightTimeArrayIndex() >= r22.length) goto L77;
        int r35 = r27.getLeftTimeArrayIndex();
        int r36 = r27.getRightTimeArrayIndex();
        if (r35 > r36) goto L77;
    L61:
        r19 = r19;
        List r37 = (List) ZeusTransformUtils.preCheckCast(r19.get(r22[r35]), List.class, "com.obric.aiagent.plugin");
        if (r37 != null) goto L64;
        r0 = r0;
    L73:
        if (r35 == r36) goto L78;
        r35 = r35 + 1;
        r19 = r19;
        r22 = r22;
        r120 = r120;
        r0 = r0;
    L78:
        Uri r1 = EntityProvider.INSTANCE.getENTITY_URI$capabilitykit_release();
        o.c(r1, "ENTITY_URI");
        Bundle r38 = new Bundle();
        r38.putParcelable(PARAMS_SYNC_COUNT_HASH_CODE_SLOT_DATA, new EntityCheckHashCodeSlotData(r27.getStartTime(), r27.getEndTimeLong(), r33));
        r38.putInt(PARAMS_SYNC_DATA_ENTITY_TYPE, r17);
        r38.putBoolean(PARAMS_SYNC_DATA_LAZY_DELETE, true);
        Bundle r39 = (Bundle) ZeusTransformUtils.preCheckCast(r5.invoke(r1, METHOD_SYNC_DATA_CHECK_HASH_CODE_DIFF, r38), Bundle.class, "com.obric.aiagent.plugin");
        if (r39 == null) goto L80;
        ArrayList<String> r40 = r39.getStringArrayList(RESULT_DATA_CHECK_DIFF);
        ArrayList<String> r41 = r39.getStringArrayList(RESULT_DATA_LAZY_DELETE);
        r120 = r120;
        if (r40 == null) goto L85;
        r120.addAll(r40);
    L85:
        if (r41 == null) goto L87;
        LinkedHashSet r42 = r121;
        r42.addAll(r41);
        r121 = r42;
    L88:
        r18 = r34;
        goto L49
    L87:
        r121 = r121;
        goto L88
    L80:
        r15 = r15;
        r4 = r4;
    L81:
        r0 = r0;
        goto L20
    L64:
        ArrayList r123 = new ArrayList(p.a(r37, 10));
        Iterator r43 = r37.iterator();
    L66:
        if (r43.hasNext() == false) goto L68;
        r123.add(((EntityIdData) ZeusTransformUtils.preCheckCast(r43.next(), EntityIdData.class, "com.obric.aiagent.plugin")).getId());
        goto L66
    L68:
        List<AppEntity> r44 = r0.getWholeEntities(r123, r17);
        ArrayList r45 = new ArrayList(p.a(r44, 10));
        Iterator<T> r46 = r44.iterator();
    L70:
        if (r46.hasNext() == false) goto L72;
        AppEntity r124 = (AppEntity) ZeusTransformUtils.preCheckCast(r46.next(), AppEntity.class, "com.obric.aiagent.plugin");
        r122.put(r124.getId(), r124);
        r45.add(new EntityHashData(r124.getId(), r124.hashCode()));
        r0 = r0;
        goto L70
    L72:
        r0 = r0;
        r33.addAll(r45);
    L77:
        r19 = r19;
        r22 = r22;
        r120 = r120;
        goto L78
    L76:
        r34 = r18;
        r4 = r4;
        goto L77
    L89:
        r0 = r0;
        Iterator r210 = r15;
        List r310 = r18;
        m r211 = r4;
        ArrayList r47 = r120;
        LinkedHashSet r48 = r121;
        ArrayList r49 = new ArrayList(r47.size());
        Iterator r50 = r47.iterator();
    L91:
        if (r50.hasNext() == false) goto L96;
        AppEntity r51 = (AppEntity) ZeusTransformUtils.preCheckCast(r122.get((String) ZeusTransformUtils.preCheckCast(r50.next(), String.class, "com.obric.aiagent.plugin")), AppEntity.class, "com.obric.aiagent.plugin");
        if (r51 == null) goto L91;
        r49.add(r51);
        goto L91
    L96:
        if ((!r48.isEmpty()) == false) goto L102;
        Iterator r52 = r310.iterator();
    L99:
        if (r52.hasNext() == false) goto L102;
        r48.remove(((EntityIdData) ZeusTransformUtils.preCheckCast(r52.next(), EntityIdData.class, "com.obric.aiagent.plugin")).getId());
    L102:
        if ((!r48.isEmpty()) == false) goto L106;
        if (r211 == null) goto L105;
        m r53 = r211;
        r53.invoke(p.o(r48), Integer.valueOf(r17));
    L108:
        if ((!r49.isEmpty()) == false) goto L110;
        EntityProvider.bulkIndex$default(EntityProvider.INSTANCE, r49, null, 2, null);
    L110:
        r15 = r210;
        r4 = r53;
        goto L81
    L105:
        r53 = r211;
        EntityProvider.INSTANCE.bulkDelete(p.o(r48), r17);
        goto L108
    L106:
        r53 = r211;
        goto L108
    L46:
        return;
    }
}
