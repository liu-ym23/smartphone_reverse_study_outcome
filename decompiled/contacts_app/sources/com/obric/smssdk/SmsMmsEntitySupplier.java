package com.obric.smssdk;

import android.content.Context;
import com.obric.callandsms.common.Logger;
import com.obric.capabilitykit.EntitySupplier;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.MessageEntity;
import com.obric.capabilitykit.sync.EntityIdData;
import com.obric.capabilitykit.sync.EntitySyncDataSupplier;
import com.obric.smssdk.utils.SmsMmsDatabaseUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: SmsMmsEntitySupplier.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00182\u00020\u00012\u00020\u0002:\u0002\u0018\u0019B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J \u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0002J$\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\t0\u000e2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\tH\u0002J\u000e\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0016J\u000e\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00070\u000eH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/obric/smssdk/SmsMmsEntitySupplier;", "Lcom/obric/capabilitykit/EntitySupplier;", "Lcom/obric/capabilitykit/sync/EntitySyncDataSupplier;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "buildEntityIdData", "Lcom/obric/capabilitykit/sync/EntityIdData;", "sourceType", "", "rowId", "", "lastModifyTime", "getWholeEntities", "", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "idList", "type", "", "parseEntityId", "Lcom/obric/smssdk/SmsMmsEntitySupplier$ParsedEntityId;", "entityId", "provideAllEntities", "provideSampleEntities", "Companion", "ParsedEntityId", "contactsdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SmsMmsEntitySupplier implements EntitySupplier, EntitySyncDataSupplier {
    public static final Companion Companion = null;
    private static final String MMS_PREFIX = "mms_";
    private static final String SMS_PREFIX = "sms_";
    public static final String TAG = "SmsMmsDataManager";
    private final Context context;

    /* JADX INFO: compiled from: SmsMmsEntitySupplier.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/obric/smssdk/SmsMmsEntitySupplier$Companion;", "", "()V", "MMS_PREFIX", "", "SMS_PREFIX", "TAG", "contactsdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: SmsMmsEntitySupplier.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/obric/smssdk/SmsMmsEntitySupplier$ParsedEntityId;", "", "entityId", "", "rowId", "sourceType", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getEntityId", "()Ljava/lang/String;", "getRowId", "getSourceType", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "contactsdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class ParsedEntityId {
        private final String entityId;
        private final String rowId;
        private final String sourceType;

        public static /* synthetic */ ParsedEntityId copy$default(ParsedEntityId r0, String r1, String r2, String r3, int r4, Object r5) {
            if ((r4 & 1) == 0) goto L6;
            r1 = r0.entityId;
        L6:
            if ((r4 & 2) == 0) goto L9;
            r2 = r0.rowId;
        L9:
            if ((r4 & 4) == 0) goto L12;
            r3 = r0.sourceType;
        L12:
            return r0.copy(r1, r2, r3);
        }

        public final String component1() {
            return this.entityId;
        }

        public final String component2() {
            return this.rowId;
        }

        public final String component3() {
            return this.sourceType;
        }

        public final ParsedEntityId copy(String r1, String r2, String r3) {
            Intrinsics.checkNotNullParameter(r1, "entityId");
            Intrinsics.checkNotNullParameter(r2, "rowId");
            Intrinsics.checkNotNullParameter(r3, "sourceType");
            return new ParsedEntityId(r1, r2, r3);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof ParsedEntityId) == true) goto L8;
            return false;
        L8:
            ParsedEntityId r6 = (ParsedEntityId) r5;
            if (Intrinsics.areEqual(this.entityId, r6.entityId) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.rowId, r6.rowId) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.sourceType, r6.sourceType) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((this.entityId.hashCode() * 31) + this.rowId.hashCode()) * 31) + this.sourceType.hashCode();
        }

        public String toString() {
            return "ParsedEntityId(entityId=" + this.entityId + ", rowId=" + this.rowId + ", sourceType=" + this.sourceType + ')';
        }

        public ParsedEntityId(String r2, String r3, String r4) {
            Intrinsics.checkNotNullParameter(r2, "entityId");
            Intrinsics.checkNotNullParameter(r3, "rowId");
            Intrinsics.checkNotNullParameter(r4, "sourceType");
            this.entityId = r2;
            this.rowId = r3;
            this.sourceType = r4;
        }

        public final String getEntityId() {
            return this.entityId;
        }

        public final String getRowId() {
            return this.rowId;
        }

        public final String getSourceType() {
            return this.sourceType;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public SmsMmsEntitySupplier(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.context = r2;
    }

    @Override // com.obric.capabilitykit.EntitySupplier
    public List<AppEntity> provideAllEntities() {
        Logger.INSTANCE.i(TAG, "in provideAllEntities");
        ArrayList r0 = new ArrayList(SmsMmsDatabaseUtil.INSTANCE.getAllMessages(this.context));
        Logger.INSTANCE.i(TAG, "provideAllEntities, allMessageEntities size = " + r0.size());
        return r0;
    }

    @Override // com.obric.capabilitykit.sync.EntitySyncDataSupplier
    public List<AppEntity> getWholeEntities(List<String> r14, int r15) {
        Intrinsics.checkNotNullParameter(r14, "idList");
        if (r14.isEmpty() == false) goto L7;
        Logger.e$default(Logger.INSTANCE, TAG, "getWholeEntities: idList is empty", null, 4, null);
        return CollectionsKt.emptyList();
    L7:
        if (r15 == 101) goto L10;
        Logger.e$default(Logger.INSTANCE, TAG, "getWholeEntities: unknown entity type: " + r15, null, 4, null);
        return CollectionsKt.emptyList();
    L10:
        ArrayList r0 = new ArrayList();
        ArrayList r1 = new ArrayList();
        List<String> r16 = r14;
        Iterator<T> r2 = r16.iterator();
    L12:
        if (r2.hasNext() == false) goto L22;
        String r3 = (String) r2.next();
        ParsedEntityId r6 = parseEntityId(r3);
        if (r6 == null) goto L15;
        String r4 = r6.getSourceType();
        if (Intrinsics.areEqual(r4, SmsMmsDatabaseUtil.SMS_TYPE) == true) goto L18;
        if (Intrinsics.areEqual(r4, SmsMmsDatabaseUtil.MMS_TYPE) == false) goto L12;
        r1.add(r6.getRowId());
        goto L12
    L18:
        r0.add(r6.getRowId());
        goto L12
    L15:
        Logger.e$default(Logger.INSTANCE, TAG, "getWholeEntities: unknown entity id format: " + r3 + ", type=" + r15, null, 4, null);
        goto L12
    L22:
        ArrayList r17 = new ArrayList();
    L30:
        e = move-exception;
        Logger.INSTANCE.e(TAG, "getWholeEntities error", e);
    L32:
        ArrayList r18 = r17;
        LinkedHashMap r5 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r18, 10)), 16));
        Iterator r13 = r18.iterator();
    L34:
        if (r13.hasNext() == false) goto L36;
        Object r19 = r13.next();
        r5.put(((MessageEntity) r19).getId(), r19);
        goto L34
    L36:
        ArrayList r110 = new ArrayList();
        Iterator<T> r111 = r16.iterator();
    L38:
        if (r111.hasNext() == false) goto L43;
        MessageEntity r112 = (MessageEntity) r5.get((String) r111.next());
        if (r112 == null) goto L38;
        r110.add(r112);
        goto L38
    L43:
        return r110;
    L24:
        if ((!r0.isEmpty()) == false) goto L27;
        r17.addAll(SmsMmsDatabaseUtil.INSTANCE.getSmsMmsByRowIds(r0, SmsMmsDatabaseUtil.SMS_TYPE, this.context));     // Catch: Exception -> L30
    L27:
        if ((!r1.isEmpty()) == false) goto L32;
        r17.addAll(SmsMmsDatabaseUtil.INSTANCE.getSmsMmsByRowIds(r1, SmsMmsDatabaseUtil.MMS_TYPE, this.context));     // Catch: Exception -> L30
        goto L32
    }

    @Override // com.obric.capabilitykit.sync.EntitySyncDataSupplier
    public List<EntityIdData> provideSampleEntities() {
        List<SmsMmsDatabaseUtil.MessageSyncSample> r0 = SmsMmsDatabaseUtil.INSTANCE.getMessageSyncSamples(this.context);
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
        Iterator<T> r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        SmsMmsDatabaseUtil.MessageSyncSample r3 = (SmsMmsDatabaseUtil.MessageSyncSample) r2.next();
        r1.add(buildEntityIdData(r3.getType(), r3.getRowId(), r3.getLastModifyTime()));
        goto L4
    L6:
        ArrayList r4 = r1;
        Logger.INSTANCE.i(TAG, "provideSampleEntities size = " + r4.size());
        return r4;
    }

    private final EntityIdData buildEntityIdData(String r1, long r2, long r4) {
        if (Intrinsics.areEqual(r1, SmsMmsDatabaseUtil.SMS_TYPE) == false) goto L6;
        String r0 = SMS_PREFIX + r2;
    L10:
        return new EntityIdData(r0, 101, r4);
    L6:
        if (Intrinsics.areEqual(r1, SmsMmsDatabaseUtil.MMS_TYPE) == false) goto L8;
        r0 = MMS_PREFIX + r2;
        goto L10
    L8:
        r0 = String.valueOf(r2);
        goto L10
    }

    private final ParsedEntityId parseEntityId(String r5) {
        if (StringsKt.startsWith$default(r5, SMS_PREFIX, false, 2, null) == false) goto L6;
        return new ParsedEntityId(r5, StringsKt.removePrefix(r5, SMS_PREFIX), SmsMmsDatabaseUtil.SMS_TYPE);
    L6:
        if (StringsKt.startsWith$default(r5, MMS_PREFIX, false, 2, null) == true) goto L8;
        return null;
    L8:
        return new ParsedEntityId(r5, StringsKt.removePrefix(r5, MMS_PREFIX), SmsMmsDatabaseUtil.MMS_TYPE);
    }
}
