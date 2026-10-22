package com.obric.capabilitykit.sync;

import android.net.Uri;
import android.os.Bundle;
import com.obric.capabilitykit.EntityProvider;
import com.obric.capabilitykit.EntitySupplier;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.logger.Logger;
import com.obric.capabilitykit.p;
import com.obric.capabilitykit.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J[\u0010\u000e\u001a\u00020\u00042\u0016\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00110\u0010j\b\u0012\u0004\u0012\u00020\u0011`\u00122\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00192\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00160\u001bH\u0002¢\u0006\u0002\u0010\u001cJp\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010!\u001a\u0004\u0018\u00010\"2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00040$2\"\b\u0002\u0010%\u001a\u001c\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060$\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u001e\u0018\u00010&2\"\u0010'\u001a\u001e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010*\u0012\u0006\u0012\u0004\u0018\u00010*0(R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/obric/capabilitykit/sync/EntitySyncUtil;", "", "()V", "MAX_SIZE_ONE_GROUP", "", "METHOD_SYNC_DATA_CHECK_COUNT_DIFF", "", "METHOD_SYNC_DATA_CHECK_HASH_CODE_DIFF", "PARAMS_SYNC_COUNT_HASH_CODE_SLOT_DATA", "PARAMS_SYNC_COUNT_TIME_SLOT_DATA", "PARAMS_SYNC_DATA_ENTITY_TYPE", "PARAMS_SYNC_DATA_LAZY_DELETE", "RESULT_DATA_CHECK_DIFF", "RESULT_DATA_LAZY_DELETE", "buildTimeSlotEntityTree", "tree", "Ljava/util/ArrayList;", "Lcom/obric/capabilitykit/sync/EntityCountTimeSlotData;", "Lkotlin/collections/ArrayList;", "leftIndex", "rightIndex", "startTime", "", "endTime", "sumArray", "", "timeArray", "", "(Ljava/util/ArrayList;IIJJ[I[Ljava/lang/Long;)I", "syncData", "", "entitySyncDataSupplier", "Lcom/obric/capabilitykit/sync/EntitySyncDataSupplier;", "entitySupplier", "Lcom/obric/capabilitykit/EntitySupplier;", "indexedEntityTypes", "", "deleteCall", "Lkotlin/Function2;", "innerCall", "Lkotlin/Function3;", "Landroid/net/Uri;", "Landroid/os/Bundle;", "capabilitykit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
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

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void syncData$default(EntitySyncUtil r6, EntitySyncDataSupplier r7, EntitySupplier r8, List r9, Function2 r10, Function3 r11, int r12, Object r13) {
        if ((r12 & 8) == 0) goto L5;
        r10 = null;
    L5:
        r6.syncData(r7, r8, r9, r10, r11);
    }

    public final void syncData(EntitySyncDataSupplier r28, EntitySupplier r29, List<Integer> r30, Function2<? super List<String>, ? super Integer, Unit> r31, Function3<? super Uri, ? super String, ? super Bundle, Bundle> r32) {
        Intrinsics.checkNotNullParameter(r30, "indexedEntityTypes");
        Intrinsics.checkNotNullParameter(r32, "innerCall");
        p.a.b();
        if (r28 != null) goto L5;
        EntitySyncDataSupplier r2 = new y(r29);
    L6:
        List<EntityIdData> r4 = r2.provideSampleEntities();
        LinkedHashMap r5 = new LinkedHashMap();
        Iterator<T> r6 = r4.iterator();
    L8:
        if (r6.hasNext() == false) goto L13;
        Object r7 = r6.next();
        Integer r8 = Integer.valueOf(((EntityIdData) r7).getType());
        Object r9 = r5.get(r8);
        if (r9 != null) goto L12;
        r9 = new ArrayList();
        r5.put(r8, r9);
    L12:
        ((List) r9).add(r7);
        goto L8
    L13:
        Map r10 = MapsKt.toMutableMap(r5);
        Iterator<T> r3 = r30.iterator();
    L15:
        if (r3.hasNext() == false) goto L19;
        int r11 = ((Number) r3.next()).intValue();
        if (r10.containsKey(Integer.valueOf(r11)) == true) goto L15;
        r10.put(Integer.valueOf(r11), CollectionsKt.emptyList());
        goto L15
    L19:
        Iterator r12 = r10.entrySet().iterator();
    L21:
        if (r12.hasNext() == false) goto L116;
        Map.Entry r13 = (Map.Entry) r12.next();
        int r14 = ((Number) r13.getKey()).intValue();
        List r15 = (List) r13.getValue();
        Logger.INSTANCE.d(EntityProvider.TAG, "start sync entity for type " + r14 + " , total " + r15.size());
        LinkedHashMap r16 = new LinkedHashMap();
        Iterator r17 = r15.iterator();
    L24:
        if (r17.hasNext() == false) goto L29;
        Object r18 = r17.next();
        Long r19 = Long.valueOf(((EntityIdData) r18).getLastModifyTime());
        Object r110 = r16.get(r19);
        if (r110 != null) goto L28;
        r110 = new ArrayList();
        r16.put(r19, r110);
    L28:
        ((List) r110).add(r18);
        goto L24
    L29:
        Object[] r20 = CollectionsKt.sorted(r16.keySet()).toArray(new Long[0]);
        if (r20 == null) goto L115;
        Long[] r21 = (Long[]) r20;
        int[] r111 = new int[r21.length];
        int r112 = r21.length;
        int r113 = 0;
    L32:
        if (r113 >= r112) goto L41;
        List r114 = (List) r16.get(r21[r113]);
        if (r114 == null) goto L36;
        int r115 = r114.size();
    L37:
        if (r113 == 0) goto L40;
        r115 = r115 + r111[r113 - 1];
    L40:
        r111[r113] = r115;
        r113 = r113 + 1;
        goto L32
    L36:
        r115 = 0;
        goto L37
    L41:
        ArrayList<EntityCountTimeSlotData> r22 = new ArrayList();
        INSTANCE.buildTimeSlotEntityTree(r22, 0, r21.length - 1, Long.MIN_VALUE, Long.MAX_VALUE, r111, r21);
        if (r22.size() != 0) goto L44;
        r22.add(new EntityCountTimeSlotData(Long.MIN_VALUE, Long.MAX_VALUE, 0, -1, -1));
    L44:
        Logger.INSTANCE.d(EntityProvider.TAG, "syncdata buildTimeSlotEntityTree: " + r22.size());
        Uri r23 = EntityProvider.INSTANCE.getENTITY_URI$capabilitykit_release();
        Intrinsics.checkNotNullExpressionValue(r23, "ENTITY_URI");
        Bundle r116 = new Bundle();
        r116.putParcelableArrayList(PARAMS_SYNC_COUNT_TIME_SLOT_DATA, r22);
        r116.putInt(PARAMS_SYNC_DATA_ENTITY_TYPE, r14);
        Bundle r24 = r32.invoke(r23, METHOD_SYNC_DATA_CHECK_COUNT_DIFF, r116);
        if (r24 == null) goto L21;
        r24.setClassLoader(EntityCountTimeSlotData.class.getClassLoader());
        ArrayList r25 = r24.getParcelableArrayList(RESULT_DATA_CHECK_DIFF);
        if (r25 == null) goto L49;
        ArrayList r117 = new ArrayList();
        LinkedHashSet r118 = new LinkedHashSet();
        LinkedHashMap r119 = new LinkedHashMap();
        Iterator r26 = r25.iterator();
    L52:
        if (r26.hasNext() == false) goto L91;
        EntityCountTimeSlotData r120 = (EntityCountTimeSlotData) r26.next();
        r12 = r12;
        ArrayList r27 = new ArrayList();
        if (r120.getLeftTimeArrayIndex() < 0) goto L79;
        r26 = r26;
        if (r120.getLeftTimeArrayIndex() >= r21.length) goto L80;
        if (r120.getRightTimeArrayIndex() < 0) goto L80;
        if (r120.getRightTimeArrayIndex() >= r21.length) goto L80;
        int r0 = r120.getLeftTimeArrayIndex();
        int r33 = r120.getRightTimeArrayIndex();
        if (r0 > r33) goto L80;
        r15 = r15;
    L64:
        List r34 = (List) r16.get(r21[r0]);
        if (r34 != null) goto L67;
        r2 = r2;
    L76:
        if (r0 == r33) goto L81;
        r0 = r0 + 1;
        r16 = r16;
        r21 = r21;
        r118 = r118;
        r2 = r2;
    L81:
        Uri r1 = EntityProvider.INSTANCE.getENTITY_URI$capabilitykit_release();
        Intrinsics.checkNotNullExpressionValue(r1, "ENTITY_URI");
        Bundle r35 = new Bundle();
        r35.putParcelable(PARAMS_SYNC_COUNT_HASH_CODE_SLOT_DATA, new EntityCheckHashCodeSlotData(r120.getStartTime(), r120.getEndTimeLong(), r27));
        r35.putInt(PARAMS_SYNC_DATA_ENTITY_TYPE, r14);
        r35.putBoolean(PARAMS_SYNC_DATA_LAZY_DELETE, true);
        Bundle r36 = r32.invoke(r1, METHOD_SYNC_DATA_CHECK_HASH_CODE_DIFF, r35);
        if (r36 == null) goto L83;
        ArrayList<String> r37 = r36.getStringArrayList(RESULT_DATA_CHECK_DIFF);
        ArrayList<String> r38 = r36.getStringArrayList(RESULT_DATA_LAZY_DELETE);
        if (r37 == null) goto L87;
        r117.addAll(r37);
    L87:
        if (r38 == null) goto L89;
        LinkedHashSet r39 = r118;
        r39.addAll(r38);
        r118 = r39;
    L90:
        r2 = r2;
        goto L52
    L89:
        r118 = r118;
        goto L90
    L83:
        r12 = r12;
        r2 = r2;
        goto L21
    L67:
        ArrayList r40 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r34, 10));
        Iterator r41 = r34.iterator();
    L69:
        if (r41.hasNext() == false) goto L71;
        r40.add(((EntityIdData) r41.next()).getId());
        goto L69
    L71:
        List<AppEntity> r42 = r2.getWholeEntities(r40, r14);
        ArrayList r43 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r42, 10));
        Iterator<T> r44 = r42.iterator();
    L73:
        if (r44.hasNext() == false) goto L75;
        AppEntity r45 = (AppEntity) r44.next();
        r119.put(r45.getId(), r45);
        r43.add(new EntityHashData(r45.getId(), r45.hashCode()));
        r2 = r2;
        goto L73
    L75:
        r2 = r2;
        r27.addAll(r43);
    L80:
        r118 = r118;
        goto L81
    L79:
        r26 = r26;
        goto L80
    L91:
        EntitySyncDataSupplier r121 = r2;
        Iterator r210 = r12;
        List r211 = r15;
        LinkedHashSet r46 = r118;
        ArrayList r47 = new ArrayList(r117.size());
        Iterator r48 = r117.iterator();
    L93:
        if (r48.hasNext() == false) goto L98;
        AppEntity r49 = (AppEntity) r119.get((String) r48.next());
        if (r49 == null) goto L93;
        r47.add(r49);
        goto L93
    L98:
        if ((!r46.isEmpty()) == false) goto L104;
        Iterator r50 = r211.iterator();
    L101:
        if (r50.hasNext() == false) goto L104;
        r46.remove(((EntityIdData) r50.next()).getId());
    L104:
        if ((!r46.isEmpty()) == false) goto L109;
        Function2<? super List<String>, ? super Integer, Unit> r51 = r31;
        if (r51 == null) goto L108;
        r51.invoke(CollectionsKt.toList(r46), Integer.valueOf(r14));
    L111:
        if ((!r47.isEmpty()) == false) goto L113;
        EntityProvider.bulkIndex$default(EntityProvider.INSTANCE, r47, null, 2, null);
    L113:
        r2 = r121;
        r12 = r210;
        goto L21
    L108:
        EntityProvider.INSTANCE.bulkDelete(CollectionsKt.toList(r46), r14);
        goto L111
    L109:
        r51 = r31;
        goto L111
    L49:
        return;
    L115:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    L116:
        return;
    L5:
        r2 = r28;
        goto L6
    }
}
