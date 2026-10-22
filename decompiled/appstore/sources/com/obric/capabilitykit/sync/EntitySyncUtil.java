package com.obric.capabilitykit.sync;

import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.Keep;
import cb.x;
import com.obric.capabilitykit.EntityProvider;
import com.obric.capabilitykit.EntitySupplier;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.logger.Logger;
import com.obric.capabilitykit.p;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.b0;
import kotlin.collections.k0;
import kotlin.collections.t;
import kotlin.collections.u;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
@Keep
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J[\u0010\u000e\u001a\u00020\u00042\u0016\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00110\u0010j\b\u0012\u0004\u0012\u00020\u0011`\u00122\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00192\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00160\u001bH\u0002¢\u0006\u0002\u0010\u001cJp\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010!\u001a\u0004\u0018\u00010\"2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00040$2\"\b\u0002\u0010%\u001a\u001c\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060$\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u001e\u0018\u00010&2\"\u0010'\u001a\u001e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010*\u0012\u0006\u0012\u0004\u0018\u00010*0(R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/obric/capabilitykit/sync/EntitySyncUtil;", "", "()V", "MAX_SIZE_ONE_GROUP", "", "METHOD_SYNC_DATA_CHECK_COUNT_DIFF", "", "METHOD_SYNC_DATA_CHECK_HASH_CODE_DIFF", "PARAMS_SYNC_COUNT_HASH_CODE_SLOT_DATA", "PARAMS_SYNC_COUNT_TIME_SLOT_DATA", "PARAMS_SYNC_DATA_ENTITY_TYPE", "PARAMS_SYNC_DATA_LAZY_DELETE", "RESULT_DATA_CHECK_DIFF", "RESULT_DATA_LAZY_DELETE", "buildTimeSlotEntityTree", "tree", "Ljava/util/ArrayList;", "Lcom/obric/capabilitykit/sync/EntityCountTimeSlotData;", "Lkotlin/collections/ArrayList;", "leftIndex", "rightIndex", "startTime", "", "endTime", "sumArray", "", "timeArray", "", "(Ljava/util/ArrayList;IIJJ[I[Ljava/lang/Long;)I", "syncData", "", "entitySyncDataSupplier", "Lcom/obric/capabilitykit/sync/EntitySyncDataSupplier;", "entitySupplier", "Lcom/obric/capabilitykit/EntitySupplier;", "indexedEntityTypes", "", "deleteCall", "Lkotlin/Function2;", "innerCall", "Lkotlin/Function3;", "Landroid/net/Uri;", "Landroid/os/Bundle;", "capabilitykit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class EntitySyncUtil {

    @NotNull
    public static final EntitySyncUtil INSTANCE = null;
    private static final int MAX_SIZE_ONE_GROUP = 50;

    @NotNull
    private static final String METHOD_SYNC_DATA_CHECK_COUNT_DIFF = "syncDataCheckCountDiff";

    @NotNull
    private static final String METHOD_SYNC_DATA_CHECK_HASH_CODE_DIFF = "syncDataCheckHashCodeDiff";

    @NotNull
    private static final String PARAMS_SYNC_COUNT_HASH_CODE_SLOT_DATA = "syncHashCodeSlotDataList";

    @NotNull
    private static final String PARAMS_SYNC_COUNT_TIME_SLOT_DATA = "syncCountTimeSlotDataList";

    @NotNull
    private static final String PARAMS_SYNC_DATA_ENTITY_TYPE = "syncDataEntityType";

    @NotNull
    private static final String PARAMS_SYNC_DATA_LAZY_DELETE = "syncDataLazyDelete";

    @NotNull
    private static final String RESULT_DATA_CHECK_DIFF = "checkDiffResult";

    @NotNull
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
        int r10 = r23[r18];
        if (r17 >= 1) goto L9;
        int r11 = 0;
    L10:
        int r12 = r10 - r11;
        int r13 = r16.size();
        EntityCountTimeSlotData r14 = new EntityCountTimeSlotData(r19, r21, r12, r17, r18);
        r16.add(r14);
        if (r12 <= 50) goto L14;
        if (r17 >= r18) goto L14;
        int r15 = (r17 + r18) / 2;
        r14.setLeftIndex(buildTimeSlotEntityTree(r16, r17, r15, r19, r24[r15].longValue(), r23, r24));
        r14.setRightIndex(buildTimeSlotEntityTree(r16, r15 + 1, r18, r24[r15].longValue() + 1, r21, r23, r24));
    L14:
        return r13;
    L9:
        r11 = r23[r17 - 1];
        goto L10
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void syncData$default(EntitySyncUtil r10, EntitySyncDataSupplier r11, EntitySupplier r12, List r13, Function2 r14, Function3 r15, int r16, Object r17) {
        if ((r16 & 8) == 0) goto L5;
        r14 = null;
    L5:
        r10.syncData(r11, r12, r13, r14, r15);
    }

    public final void syncData(@Nullable EntitySyncDataSupplier r28, @Nullable EntitySupplier r29, @NotNull List<Integer> r30, @Nullable Function2<? super List<String>, ? super Integer, Unit> r31, @NotNull Function3<? super Uri, ? super String, ? super Bundle, Bundle> r32) {
        q.g(r30, "indexedEntityTypes");
        q.g(r32, "innerCall");
        p.f11375a.f();
        if (r28 != null) goto L5;
        EntitySyncDataSupplier r10 = new x(r29);
    L6:
        List<EntityIdData> r11 = r10.provideSampleEntities();
        LinkedHashMap r12 = new LinkedHashMap();
        Iterator<T> r13 = r11.iterator();
    L8:
        if (r13.hasNext() == false) goto L13;
        Object r14 = r13.next();
        Integer r15 = Integer.valueOf(((EntityIdData) r14).getType());
        Object r16 = r12.get(r15);
        if (r16 != null) goto L12;
        r16 = new ArrayList();
        r12.put(r15, r16);
    L12:
        ((List) r16).add(r14);
        goto L8
    L13:
        Map r17 = k0.u(r12);
        Iterator<T> r18 = r30.iterator();
    L15:
        if (r18.hasNext() == false) goto L19;
        int r19 = ((Number) r18.next()).intValue();
        if (r17.containsKey(Integer.valueOf(r19)) == true) goto L15;
        r17.put(Integer.valueOf(r19), t.i());
        goto L15
    L19:
        Iterator r20 = r17.entrySet().iterator();
    L21:
        if (r20.hasNext() == false) goto L116;
        Map.Entry r21 = (Map.Entry) r20.next();
        int r22 = ((Number) r21.getKey()).intValue();
        List r23 = (List) r21.getValue();
        Logger.INSTANCE.d(EntityProvider.TAG, "start sync entity for type " + r22 + " , total " + r23.size());
        LinkedHashMap r24 = new LinkedHashMap();
        Iterator r25 = r23.iterator();
    L24:
        if (r25.hasNext() == false) goto L29;
        Object r26 = r25.next();
        Long r110 = Long.valueOf(((EntityIdData) r26).getLastModifyTime());
        Object r111 = r24.get(r110);
        if (r111 != null) goto L28;
        r111 = new ArrayList();
        r24.put(r110, r111);
    L28:
        ((List) r111).add(r26);
        goto L24
    L29:
        Object[] r27 = b0.s0(r24.keySet()).toArray(new Long[0]);
        if (r27 == null) goto L115;
        Long[] r33 = (Long[]) r27;
        int[] r112 = new int[r33.length];
        int r113 = r33.length;
        int r114 = 0;
    L32:
        if (r114 >= r113) goto L41;
        List r115 = (List) r24.get(r33[r114]);
        if (r115 == null) goto L36;
        int r116 = r115.size();
    L37:
        if (r114 == 0) goto L40;
        r116 = r116 + r112[r114 - 1];
    L40:
        r112[r114] = r116;
        r114 = r114 + 1;
        goto L32
    L36:
        r116 = 0;
        goto L37
    L41:
        ArrayList<EntityCountTimeSlotData> r34 = new ArrayList();
        INSTANCE.buildTimeSlotEntityTree(r34, 0, r33.length - 1, Long.MIN_VALUE, Long.MAX_VALUE, r112, r33);
        if (r34.size() != 0) goto L44;
        r34.add(new EntityCountTimeSlotData(Long.MIN_VALUE, Long.MAX_VALUE, 0, -1, -1));
    L44:
        Logger.INSTANCE.d(EntityProvider.TAG, "syncdata buildTimeSlotEntityTree: " + r34.size());
        Uri r35 = EntityProvider.INSTANCE.getENTITY_URI$capabilitykit_release();
        q.f(r35, "ENTITY_URI");
        Bundle r117 = new Bundle();
        r117.putParcelableArrayList(PARAMS_SYNC_COUNT_TIME_SLOT_DATA, r34);
        r117.putInt(PARAMS_SYNC_DATA_ENTITY_TYPE, r22);
        Bundle r36 = r32.invoke(r35, METHOD_SYNC_DATA_CHECK_COUNT_DIFF, r117);
        if (r36 == null) goto L21;
        r36.setClassLoader(EntityCountTimeSlotData.class.getClassLoader());
        ArrayList r37 = r36.getParcelableArrayList(RESULT_DATA_CHECK_DIFF);
        if (r37 == null) goto L49;
        ArrayList r118 = new ArrayList();
        LinkedHashSet r119 = new LinkedHashSet();
        LinkedHashMap r120 = new LinkedHashMap();
        Iterator r38 = r37.iterator();
    L52:
        if (r38.hasNext() == false) goto L91;
        EntityCountTimeSlotData r121 = (EntityCountTimeSlotData) r38.next();
        r20 = r20;
        ArrayList r39 = new ArrayList();
        if (r121.getLeftTimeArrayIndex() < 0) goto L80;
        r38 = r38;
        if (r121.getLeftTimeArrayIndex() >= r33.length) goto L79;
        if (r121.getRightTimeArrayIndex() < 0) goto L79;
        if (r121.getRightTimeArrayIndex() >= r33.length) goto L79;
        int r40 = r121.getLeftTimeArrayIndex();
        int r41 = r121.getRightTimeArrayIndex();
        if (r40 > r41) goto L79;
        r23 = r23;
    L64:
        List r42 = (List) r24.get(r33[r40]);
        if (r42 != null) goto L67;
        r10 = r10;
    L76:
        if (r40 == r41) goto L81;
        r40 = r40 + 1;
        r24 = r24;
        r33 = r33;
        r119 = r119;
        r10 = r10;
    L81:
        Uri r43 = EntityProvider.INSTANCE.getENTITY_URI$capabilitykit_release();
        q.f(r43, "ENTITY_URI");
        Bundle r44 = new Bundle();
        r44.putParcelable(PARAMS_SYNC_COUNT_HASH_CODE_SLOT_DATA, new EntityCheckHashCodeSlotData(r121.getStartTime(), r121.getEndTimeLong(), r39));
        r44.putInt(PARAMS_SYNC_DATA_ENTITY_TYPE, r22);
        r44.putBoolean(PARAMS_SYNC_DATA_LAZY_DELETE, true);
        Bundle r45 = r32.invoke(r43, METHOD_SYNC_DATA_CHECK_HASH_CODE_DIFF, r44);
        if (r45 == null) goto L83;
        ArrayList<String> r46 = r45.getStringArrayList(RESULT_DATA_CHECK_DIFF);
        ArrayList<String> r47 = r45.getStringArrayList(RESULT_DATA_LAZY_DELETE);
        if (r46 == null) goto L87;
        r118.addAll(r46);
    L87:
        if (r47 == null) goto L90;
        LinkedHashSet r48 = r119;
        r48.addAll(r47);
        r119 = r48;
    L89:
        r10 = r10;
        goto L52
    L90:
        r119 = r119;
        goto L89
    L83:
        r20 = r20;
        r10 = r10;
        goto L21
    L67:
        ArrayList r49 = new ArrayList(u.r(r42, 10));
        Iterator r50 = r42.iterator();
    L69:
        if (r50.hasNext() == false) goto L71;
        r49.add(((EntityIdData) r50.next()).getId());
        goto L69
    L71:
        List<AppEntity> r51 = r10.getWholeEntities(r49, r22);
        ArrayList r52 = new ArrayList(u.r(r51, 10));
        Iterator<T> r53 = r51.iterator();
    L73:
        if (r53.hasNext() == false) goto L75;
        AppEntity r54 = (AppEntity) r53.next();
        r120.put(r54.getId(), r54);
        r52.add(new EntityHashData(r54.getId(), r54.hashCode()));
        r10 = r10;
        goto L73
    L75:
        r10 = r10;
        r39.addAll(r52);
    L79:
        r119 = r119;
        goto L81
    L80:
        r38 = r38;
        goto L79
    L91:
        EntitySyncDataSupplier r122 = r10;
        Iterator r210 = r20;
        List r211 = r23;
        LinkedHashSet r55 = r119;
        ArrayList r56 = new ArrayList(r118.size());
        Iterator r57 = r118.iterator();
    L93:
        if (r57.hasNext() == false) goto L98;
        AppEntity r58 = (AppEntity) r120.get((String) r57.next());
        if (r58 == null) goto L93;
        r56.add(r58);
        goto L93
    L98:
        if (r55.isEmpty() == true) goto L104;
        Iterator r59 = r211.iterator();
    L101:
        if (r59.hasNext() == false) goto L104;
        r55.remove(((EntityIdData) r59.next()).getId());
    L104:
        if (r55.isEmpty() == true) goto L109;
        Function2<? super List<String>, ? super Integer, Unit> r60 = r31;
        if (r60 == null) goto L108;
        r60.mo0invoke(b0.x0(r55), Integer.valueOf(r22));
    L111:
        if (r56.isEmpty() == true) goto L113;
        EntityProvider.bulkIndex$default(EntityProvider.INSTANCE, r56, null, 2, null);
    L113:
        r10 = r122;
        r20 = r210;
        goto L21
    L108:
        EntityProvider.INSTANCE.bulkDelete(b0.x0(r55), r22);
        goto L111
    L109:
        r60 = r31;
        goto L111
    L49:
        return;
    L115:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    L116:
        return;
    L5:
        r10 = r28;
        goto L6
    }
}
