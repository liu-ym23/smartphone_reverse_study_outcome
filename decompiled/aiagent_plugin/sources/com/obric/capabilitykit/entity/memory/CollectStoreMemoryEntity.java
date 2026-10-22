package com.obric.capabilitykit.entity.memory;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.bytedance.security.zenmobile.io.SensitiveType;
import com.obric.capabilitykit.common.execution.urishare.IUriSharerEntity;
import com.obric.capabilitykit.entity.EntityExtKt;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.EntityType;
import com.obric.capabilitykit.entity.app.FileEntity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.h;
import d.h.b.o;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class CollectStoreMemoryEntity extends MemoryEntity implements IUriSharerEntity {
    public static final CREATOR CREATOR = null;
    private static final int FIELD_VERSION = 1;
    private static final int RELATED_VERSION = 0;
    private String address;
    private String appName;
    private String appPkgName;
    private String city;
    private String storeName;
    private String storeType;

    public static final class CREATOR implements Parcelable.Creator<CollectStoreMemoryEntity> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(h r1) {
            this();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CollectStoreMemoryEntity createFromParcel(Parcel r2) {
            o.e(r2, "parcel");
            AppEntity r1 = AppEntity.CREATOR.createFromParcel(r2);
            o.a(r1, "null cannot be cast to non-null type com.obric.capabilitykit.entity.memory.CollectStoreMemoryEntity");
            return (CollectStoreMemoryEntity) ZeusTransformUtils.preCheckCast(r1, CollectStoreMemoryEntity.class, "com.obric.aiagent.plugin");
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ CollectStoreMemoryEntity createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        public final int getVersion() {
            return 1;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CollectStoreMemoryEntity[] newArray(int r1) {
            return new CollectStoreMemoryEntity[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ CollectStoreMemoryEntity[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public CollectStoreMemoryEntity(Parcel r18) {
        o.e(r18, "parcel");
        this(EntityExtKt.a(r18), r18.readLong(), r18.readLong(), r18.readInt(), EntityExtKt.a(r18), r18.readString(), r18.readString(), r18.readString(), r18.readString(), null, 512, null);
        readMemoryExtensionFieldFromParcel$capabilitykitcommon_release(r18);
        readSubClassExtensionFieldFromParcel$capabilitykitcommon_release(r18, 1, r18.readInt());
    }

    public CollectStoreMemoryEntity(String r11, long r12, long r14, int r16, String r17, String r18, String r19, String r20, String r21, String r22) {
        o.e(r11, DbHelper.COL_ID);
        o.e(r17, "storeName");
        super(r11, r12, r14, EntityType.MEMORY_COLLECT_STORE, r16);
        this.storeName = r17;
        this.appName = r18;
        this.appPkgName = r19;
        this.address = r20;
        this.storeType = r21;
        this.city = r22;
    }

    public /* synthetic */ CollectStoreMemoryEntity(String r17, long r18, long r20, int r22, String r23, String r24, String r25, String r26, String r27, String r28, int r29, h r30) {
        if ((r29 & 32) == 0) goto L5;
        String r11 = null;
    L7:
        if ((r29 & 64) == 0) goto L9;
        String r12 = null;
    L11:
        if ((r29 & 128) == 0) goto L13;
        String r13 = null;
    L15:
        if ((r29 & 256) == 0) goto L17;
        String r14 = null;
    L19:
        if ((r29 & 512) == 0) goto L21;
        String r15 = null;
    L22:
        this(r17, r18, r20, r22, r23, r11, r12, r13, r14, r15);
        return;
    L21:
        r15 = r28;
        goto L22
    L17:
        r14 = r27;
        goto L19
    L13:
        r13 = r26;
        goto L15
    L9:
        r12 = r25;
        goto L11
    L5:
        r11 = r24;
        goto L7
    }

    @Override // com.obric.capabilitykit.entity.memory.MemoryEntity
    public JSONObject convertToModelInput() {
        JSONObject r0 = new JSONObject();
        r0.put("type", getType());
        r0.put("createTime", getCreateTime());
        r0.put("modifyTime", getLastModifiedTime());
        r0.put("ecaId", getEcaId());
        r0.put("storeName", makeModelInputValue("店铺名称", this.storeName));
        String r1 = this.appName;
        if (r1 == null) goto L5;
        o.a(r1);
        r0.put("appName", makeModelInputValue("店铺平台", r1));
    L5:
        String r2 = this.address;
        if (r2 == null) goto L8;
        o.a(r2);
        r0.put(SensitiveType.ADDRESS, makeModelInputValue("店铺地址", r2));
    L8:
        String r3 = this.storeType;
        if (r3 == null) goto L11;
        o.a(r3);
        r0.put("storeType", makeModelInputValue("店铺类型", r3));
    L11:
        String r4 = this.city;
        if (r4 == null) goto L14;
        o.a(r4);
        r0.put("city", makeModelInputValue("店铺城市", r4));
    L14:
        return r0;
    }

    public final String getAddress() {
        return this.address;
    }

    public final String getAppName() {
        return this.appName;
    }

    public final String getAppPkgName() {
        return this.appPkgName;
    }

    public final String getCity() {
        return this.city;
    }

    @Override // com.obric.capabilitykit.common.execution.urishare.IUriSharerEntity
    public List<Uri> getSharedUris() {
        FileEntity r0 = getScreenshot();
        if (r0 == null) goto L7;
        List<Uri> r1 = r0.getSharedUris();
        if (r1 == null) goto L7;
        return r1;
    L7:
        return p.b();
    }

    public final String getStoreName() {
        return this.storeName;
    }

    public final String getStoreType() {
        return this.storeType;
    }

    @Override // com.obric.capabilitykit.entity.app.AppEntity
    public void onReadSubClassExtensionField(Parcel r2, ClassLoader r3, int r4) {
        o.e(r2, "parcel");
        if (r4 != 1) goto L6;
        this.city = (String) ZeusTransformUtils.preCheckCast(r2.readValue(r3), String.class, "com.obric.aiagent.plugin");
        return;
    }

    public final void setAddress(String r1) {
        this.address = r1;
    }

    public final void setAppName(String r1) {
        this.appName = r1;
    }

    public final void setAppPkgName(String r1) {
        this.appPkgName = r1;
    }

    public final void setCity(String r1) {
        this.city = r1;
    }

    public final void setStoreName(String r2) {
        o.e(r2, "<set-?>");
        this.storeName = r2;
    }

    public final void setStoreType(String r1) {
        this.storeType = r1;
    }

    @Override // com.obric.capabilitykit.entity.memory.MemoryEntity, com.obric.capabilitykit.entity.app.AppEntity, android.os.Parcelable
    public void writeToParcel(Parcel r2, int r3) {
        o.e(r2, "parcel");
        writeMemoryBaseFieldToParcel$capabilitykitcommon_release(r2);
        r2.writeString(this.storeName);
        r2.writeString(this.appName);
        r2.writeString(this.appPkgName);
        r2.writeString(this.address);
        r2.writeString(this.storeType);
        writeMemoryExtensionFieldToParcel$capabilitykitcommon_release(r2, r3);
        r2.writeInt(1);
        r2.writeValue(this.city);
    }
}
