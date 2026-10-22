package com.obric.capabilitykit.entity.app;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.google.gson.JsonParser;
import com.obric.capabilitykit.PackageUtils;
import com.obric.capabilitykit.common.ah;
import com.obric.capabilitykit.common.d;
import com.obric.capabilitykit.common.u;
import com.obric.capabilitykit.entity.EntityContextHolder;
import com.obric.capabilitykit.entity.EntityExtKt;
import com.obric.capabilitykit.entity.utils.ParcelUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.a.b;
import d.h.b.h;
import d.h.b.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public abstract class AppEntity implements Parcelable {
    public static final CREATOR CREATOR = null;
    private static final int FIELD_VERSION = 9;
    private static final int RELATED_VERSION = 0;
    private String _packageName;
    private String contentHash;
    private long createTime;
    private String ecaId;
    private String ecaRawContent;
    private transient Object extra;
    private String extraData;
    private List<ExtraEntity> extras;
    private int hashCodeValue;
    private String id;
    private long lastModifiedTime;
    private Integer poisonLabel;
    private Integer poisonLabelVersion;
    private final int type;
    private String uuid;

    public static final class CREATOR implements Parcelable.Creator<AppEntity> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(h r1) {
            this();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AppEntity createFromParcel(Parcel r4) {
            o.e(r4, "parcel");
            int r3 = r4.readInt();
            EntityClassData r0 = (EntityClassData) ZeusTransformUtils.preCheckCast(EntityType.INSTANCE.getClassMap().get(Integer.valueOf(r3)), EntityClassData.class, "com.obric.aiagent.plugin");
            if (r0 == null) goto L9;
            b r1 = r0.getParcelConstructor();
            if (r1 == null) goto L9;
            return (AppEntity) ZeusTransformUtils.preCheckCast(r1.invoke(r4), AppEntity.class, "com.obric.aiagent.plugin");
        L9:
            throw new UnsupportedOperationException("failed to construct AppEntity for type " + r3);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ AppEntity createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        public final AppEntity fromJson(String r2) {
            o.e(r2, "json");
            Object r1 = EntityExtKt.a().fromJson(r2, AppEntity.class);
            o.c(r1, "entityGson.fromJson(json, AppEntity::class.java)");
            return (AppEntity) ZeusTransformUtils.preCheckCast(r1, AppEntity.class, "com.obric.aiagent.plugin");
        }

        public final AppEntity fromJsonKeepTimeStamp(String r4) {
            o.e(r4, "json");
            int r3 = new JsonParser().parse(r4).getAsJsonObject().get("type").getAsInt();
            EntityClassData r0 = (EntityClassData) ZeusTransformUtils.preCheckCast(EntityType.INSTANCE.getClassMap().get(Integer.valueOf(r3)), EntityClassData.class, "com.obric.aiagent.plugin");
            if (r0 == null) goto L9;
            Class r1 = r0.getClazz();
            if (r1 == null) goto L9;
            Object r5 = EntityExtKt.c().fromJson(r4, r1);
            o.c(r5, "entityKeepTimeStampGson.…omJson(json, targetClass)");
            return (AppEntity) ZeusTransformUtils.preCheckCast(r5, AppEntity.class, "com.obric.aiagent.plugin");
        L9:
            throw new IllegalArgumentException("Unknown entity type: " + r3);
        }

        public final int getVersion() {
            return 9;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AppEntity[] newArray(int r1) {
            return new AppEntity[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ AppEntity[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public AppEntity(Parcel r9) {
        o.e(r9, "parcel");
        this(EntityExtKt.a(r9), r9.readLong(), r9.readLong(), r9.readInt());
        throw new UnsupportedOperationException("Don't construct AppEntity Directly, use subclass instead");
    }

    public AppEntity(String r2, long r3, long r5, int r7) {
        o.e(r2, DbHelper.COL_ID);
        this.id = r2;
        this.createTime = r3;
        this.lastModifiedTime = r5;
        this.type = r7;
        this._packageName = "";
        String r4 = EntityContextHolder.INSTANCE.getPackageName();
        if (PackageUtils.INSTANCE.isMemoryPackageName(r4) == false) goto L13;
        if (ZeusTransformUtils.instanceOf(this, ContactEntity.class) == false) goto L7;
    L16:
        r4 = "com.android.contacts";
    L17:
        this._packageName = r4;
        return;
    L7:
        if (ZeusTransformUtils.instanceOf(this, CallHistoryEntity.class) == true) goto L16;
        if (ZeusTransformUtils.instanceOf(this, MessageEntity.class) == false) goto L17;
        this._packageName = "com.android.mms";
        return;
    L13:
        if (o.a("com.android.mms", r4) == false) goto L17;
        if (ZeusTransformUtils.instanceOf(this, ContactEntity.class) == false) goto L17;
        goto L16
    }

    public final void addExtraEntity(ExtraEntity r2) {
        o.e(r2, "extra");
        if (this.extras != null) goto L5;
        this.extras = new ArrayList();
    L5:
        List<ExtraEntity> r1 = this.extras;
        o.a(r1);
        r1.add(r2);
    }

    public final void countHashCode() {
        this.hashCodeValue = hashCode();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final String getContentHash() {
        return this.contentHash;
    }

    public final long getCreateTime() {
        return this.createTime;
    }

    public DisplayRepresentation getDisplayRepresentation() {
        throw new UnsupportedOperationException("entity not implementation getDisplayRepresentation method");
    }

    public final String getEcaId() {
        return this.ecaId;
    }

    public final String getEcaRawContent() {
        return this.ecaRawContent;
    }

    public final Object getExtra() {
        return this.extra;
    }

    public final String getExtraData() {
        return this.extraData;
    }

    public final ExtraEntity getExtraEntity(String r5) {
        o.e(r5, "key");
        List<ExtraEntity> r4 = this.extras;
        Object r0 = null;
        if (r4 == null) goto L15;
        Iterator<T> r6 = r4.iterator();
    L6:
        if (r6.hasNext() == false) goto L11;
        Object r1 = r6.next();
        if (o.a(((ExtraEntity) ZeusTransformUtils.preCheckCast(r1, ExtraEntity.class, "com.obric.aiagent.plugin")).getKey(), r5) == false) goto L6;
        r0 = r1;
    L11:
        return (ExtraEntity) ZeusTransformUtils.preCheckCast(r0, ExtraEntity.class, "com.obric.aiagent.plugin");
    L15:
        return null;
    }

    public final List<ExtraEntity> getExtras() {
        return this.extras;
    }

    public final int getHashCodeValue() {
        return this.hashCodeValue;
    }

    public final String getId() {
        return this.id;
    }

    public final long getLastModifiedTime() {
        return this.lastModifiedTime;
    }

    public final String getPackageName() {
        return this._packageName;
    }

    public final Integer getPoisonLabel() {
        return this.poisonLabel;
    }

    public final Integer getPoisonLabelVersion() {
        return this.poisonLabelVersion;
    }

    public final int getType() {
        return this.type;
    }

    public final String getUuid() {
        return this.uuid;
    }

    public final String get_packageName() {
        return this._packageName;
    }

    public int hashCode() {
        d r0 = (d) ZeusTransformUtils.preCheckCast(ah.f32039a.a().get(getClass().getName()), d.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L7;
        return (r0.a(this) * 31) + u.f32068a.a(this);
    L7:
        throw new IllegalStateException("not found entity generatorHashCode function, entityName: " + getClass().getName());
    }

    public abstract void onReadSubClassExtensionField(Parcel r1, ClassLoader r2, int r3);

    public final void readExtensionFieldFromParcel$capabilitykitcommon_release(Parcel r9) {
        o.e(r9, "parcel");
        int r0 = r9.readInt();
        this._packageName = EntityExtKt.a(r9);
        this.extras = r9.createTypedArrayList(ExtraEntity.CREATOR);
        int r1 = 9;
        if (r0 > 9) goto L6;
        r1 = r0;
    L6:
        ClassLoader r2 = AppEntity.class.getClassLoader();
        int r3 = 1;
    L7:
        if (r3 > r1) goto L42;
        String r4 = null;
        String r5 = null;
        Integer r6 = null;
        Integer r7 = null;
        String r8 = null;
        String r10 = null;
        String r11 = null;
        switch(r3) {
            case 1: goto L40;
            case 2: goto L39;
            case 3: goto L35;
            case 4: goto L31;
            case 5: goto L27;
            case 6: goto L23;
            case 7: goto L19;
            case 8: goto L15;
            case 9: goto L11;
            default: goto L41;
        };
    L11:
        Object r12 = ParcelUtils.INSTANCE.readValueSafely(r9, r2);
        if (ZeusTransformUtils.instanceOf(r12, String.class) == false) goto L14;
        r5 = (String) ZeusTransformUtils.preCheckCast(r12, String.class, "com.obric.aiagent.plugin");
    L14:
        this.contentHash = r5;
        goto L41
    L15:
        Object r13 = ParcelUtils.INSTANCE.readValueSafely(r9, r2);
        if (ZeusTransformUtils.instanceOf(r13, Integer.class) == false) goto L18;
        r6 = (Integer) ZeusTransformUtils.preCheckCast(r13, Integer.class, "com.obric.aiagent.plugin");
    L18:
        this.poisonLabelVersion = r6;
        goto L41
    L19:
        Object r14 = ParcelUtils.INSTANCE.readValueSafely(r9, r2);
        if (ZeusTransformUtils.instanceOf(r14, Integer.class) == false) goto L22;
        r7 = (Integer) ZeusTransformUtils.preCheckCast(r14, Integer.class, "com.obric.aiagent.plugin");
    L22:
        this.poisonLabel = r7;
        goto L41
    L23:
        Object r15 = ParcelUtils.INSTANCE.readValueSafely(r9, r2);
        if (ZeusTransformUtils.instanceOf(r15, String.class) == false) goto L26;
        r8 = (String) ZeusTransformUtils.preCheckCast(r15, String.class, "com.obric.aiagent.plugin");
    L26:
        this.uuid = r8;
        goto L41
    L27:
        Object r16 = ParcelUtils.INSTANCE.readValueSafely(r9, r2);
        if (ZeusTransformUtils.instanceOf(r16, String.class) == false) goto L30;
        r10 = (String) ZeusTransformUtils.preCheckCast(r16, String.class, "com.obric.aiagent.plugin");
    L30:
        this.ecaRawContent = r10;
        goto L41
    L31:
        Object r17 = ParcelUtils.INSTANCE.readValueSafely(r9, r2);
        if (ZeusTransformUtils.instanceOf(r17, String.class) == false) goto L34;
        r11 = (String) ZeusTransformUtils.preCheckCast(r17, String.class, "com.obric.aiagent.plugin");
    L34:
        this.ecaId = r11;
        goto L41
    L35:
        Object r18 = ParcelUtils.INSTANCE.readValueSafely(r9, r2);
        if (ZeusTransformUtils.instanceOf(r18, String.class) == false) goto L38;
        r4 = (String) ZeusTransformUtils.preCheckCast(r18, String.class, "com.obric.aiagent.plugin");
    L38:
        this.extraData = r4;
        goto L41
    L39:
        Object r19 = r9.readValue(r2);
        o.a(r19, "null cannot be cast to non-null type kotlin.Int");
        this.hashCodeValue = ((Integer) ZeusTransformUtils.preCheckCast(r19, Integer.class, "com.obric.aiagent.plugin")).intValue();
        goto L41
    L40:
        setExtra(ParcelUtils.INSTANCE.readValueSafely(r9, r2));
    L41:
        r3 = r3 + 1;
    L42:
        if (r3 > r0) goto L44;
        ParcelUtils.INSTANCE.skipValueSafely(r9, r2);
        r3 = r3 + 1;
        goto L42
    }

    public final void readSubClassExtensionFieldFromParcel$capabilitykitcommon_release(Parcel r3, int r4, int r5) {
        o.e(r3, "parcel");
        if (r5 > r4) goto L6;
        r4 = r5;
    L6:
        ClassLoader r0 = AppEntity.class.getClassLoader();
        int r1 = 1;
    L7:
        if (r1 > r4) goto L9;
        onReadSubClassExtensionField(r3, r0, r1);
        r1 = r1 + 1;
    L9:
        if (r1 > r5) goto L11;
        ParcelUtils.INSTANCE.skipValueSafely(r3, r0);
        r1 = r1 + 1;
        goto L9
    }

    public final void setContentHash(String r1) {
        this.contentHash = r1;
    }

    public final void setCreateTime(long r1) {
        this.createTime = r1;
    }

    public final void setEcaId(String r1) {
        this.ecaId = r1;
    }

    public final void setEcaRawContent(String r1) {
        this.ecaRawContent = r1;
    }

    public final void setExtra(Object r3) {
        if (EntityExtKt.a(r3) == false) goto L6;
        this.extra = r3;
        return;
    L6:
        StringBuilder r0 = new StringBuilder().append("extra value type ");
        o.a(r3);
        throw new IllegalArgumentException(r0.append(r3.getClass().getName()).append(" is not supported").toString());
    }

    public final void setExtraData(String r1) {
        this.extraData = r1;
    }

    public final void setExtras(List<ExtraEntity> r3) {
        this.extras = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
    }

    public final void setId(String r2) {
        o.e(r2, "<set-?>");
        this.id = r2;
    }

    public final void setLastModifiedTime(long r1) {
        this.lastModifiedTime = r1;
    }

    public final void setPoisonLabel(Integer r1) {
        this.poisonLabel = r1;
    }

    public final void setPoisonLabelVersion(Integer r1) {
        this.poisonLabelVersion = r1;
    }

    public final void setUuid(String r1) {
        this.uuid = r1;
    }

    public final void set_packageName(String r2) {
        o.e(r2, "<set-?>");
        this._packageName = r2;
    }

    public String toString() {
        return EntityExtKt.toJson(this);
    }

    public final void writeBaseFieldToParcel$capabilitykitcommon_release(Parcel r3) {
        o.e(r3, "parcel");
        r3.writeInt(this.type);
        r3.writeString(this.id);
        r3.writeLong(this.createTime);
        r3.writeLong(this.lastModifiedTime);
    }

    public final void writeExtensionFieldToParcel$capabilitykitcommon_release(Parcel r2) {
        o.e(r2, "parcel");
        r2.writeInt(9);
        r2.writeString(this._packageName);
        r2.writeTypedList(this.extras);
        r2.writeValue(this.extra);
        r2.writeValue(Integer.valueOf(this.hashCodeValue));
        r2.writeValue(this.extraData);
        r2.writeValue(this.ecaId);
        r2.writeValue(this.ecaRawContent);
        r2.writeValue(this.uuid);
        r2.writeValue(this.poisonLabel);
        r2.writeValue(this.poisonLabelVersion);
        r2.writeValue(this.contentHash);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        o.e(r1, "parcel");
        throw new UnsupportedOperationException("Don't construct AppEntity Directly, use subclass instead");
    }
}
