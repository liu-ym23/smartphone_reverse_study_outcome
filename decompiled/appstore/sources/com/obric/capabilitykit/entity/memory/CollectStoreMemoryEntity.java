package com.obric.capabilitykit.entity.memory;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import com.obric.capabilitykit.common.execution.urishare.IUriSharerEntity;
import com.obric.capabilitykit.entity.EntityExtKt;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.EntityType;
import com.obric.capabilitykit.entity.app.FileEntity;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.t;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
@Keep
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 .2\u00020\u00012\u00020\u0002:\u0001.B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005Bi\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\u0013J\b\u0010\"\u001a\u00020#H\u0016J\u000e\u0010$\u001a\b\u0012\u0004\u0012\u00020&0%H\u0016J\"\u0010'\u001a\u00020(2\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010)\u001a\u0004\u0018\u00010*2\u0006\u0010+\u001a\u00020\fH\u0016J\u0018\u0010,\u001a\u00020(2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010-\u001a\u00020\fH\u0016R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0015\"\u0004\b\u0019\u0010\u0017R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0015\"\u0004\b\u001b\u0010\u0017R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0015\"\u0004\b\u001d\u0010\u0017R\u001a\u0010\r\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0015\"\u0004\b\u001f\u0010\u0017R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0015\"\u0004\b!\u0010\u0017¨\u0006/"}, d2 = {"Lcom/obric/capabilitykit/entity/memory/CollectStoreMemoryEntity;", "Lcom/obric/capabilitykit/entity/memory/MemoryEntity;", "Lcom/obric/capabilitykit/common/execution/urishare/IUriSharerEntity;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "id", "", "createTime", "", "modifyTime", "productType", "", "storeName", "appName", "appPkgName", "address", "storeType", "city", "(Ljava/lang/String;JJILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAddress", "()Ljava/lang/String;", "setAddress", "(Ljava/lang/String;)V", "getAppName", "setAppName", "getAppPkgName", "setAppPkgName", "getCity", "setCity", "getStoreName", "setStoreName", "getStoreType", "setStoreType", "convertToModelInput", "Lorg/json/JSONObject;", "getSharedUris", "", "Landroid/net/Uri;", "onReadSubClassExtensionField", "", "currentClassLoader", "Ljava/lang/ClassLoader;", "version", "writeToParcel", "flags", "CREATOR", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class CollectStoreMemoryEntity extends MemoryEntity implements IUriSharerEntity {

    @NotNull
    public static final CREATOR CREATOR = null;
    private static final int FIELD_VERSION = 1;
    private static final int RELATED_VERSION = 0;

    @Nullable
    private String address;

    @Nullable
    private String appName;

    @Nullable
    private String appPkgName;

    @Nullable
    private String city;

    @NotNull
    private String storeName;

    @Nullable
    private String storeType;

    @Keep
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\b\u0087\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\tH\u0016J\u0006\u0010\n\u001a\u00020\u0005J\u001d\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\f2\u0006\u0010\r\u001a\u00020\u0005H\u0016¢\u0006\u0002\u0010\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/obric/capabilitykit/entity/memory/CollectStoreMemoryEntity$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/obric/capabilitykit/entity/memory/CollectStoreMemoryEntity;", "()V", "FIELD_VERSION", "", "RELATED_VERSION", "createFromParcel", "parcel", "Landroid/os/Parcel;", "getVersion", "newArray", "", "size", "(I)[Lcom/obric/capabilitykit/entity/memory/CollectStoreMemoryEntity;", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class CREATOR implements Parcelable.Creator<CollectStoreMemoryEntity> {
        private CREATOR() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public CollectStoreMemoryEntity createFromParcel(@NotNull Parcel r10) {
            q.g(r10, "parcel");
            AppEntity r11 = AppEntity.CREATOR.createFromParcel(r10);
            q.e(r11, "null cannot be cast to non-null type com.obric.capabilitykit.entity.memory.CollectStoreMemoryEntity");
            return (CollectStoreMemoryEntity) r11;
        }

        public final int getVersion() {
            return 1;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public CollectStoreMemoryEntity[] newArray(int r10) {
            return new CollectStoreMemoryEntity[r10];
        }

        public /* synthetic */ CREATOR(DefaultConstructorMarker r10) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ CollectStoreMemoryEntity createFromParcel(Parcel r10) {
            return createFromParcel(r10);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ CollectStoreMemoryEntity[] newArray(int r10) {
            return newArray(r10);
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public CollectStoreMemoryEntity(@NotNull Parcel r18) {
        q.g(r18, "parcel");
        String r14 = null;
        this(EntityExtKt.f(r18), r18.readLong(), r18.readLong(), r18.readInt(), EntityExtKt.f(r18), r18.readString(), r18.readString(), r18.readString(), r18.readString(), r14, 512, null);
        readMemoryExtensionFieldFromParcel$capabilitykitcommon_release(r18);
        readSubClassExtensionFieldFromParcel$capabilitykitcommon_release(r18, 1, r18.readInt());
    }

    @Override // com.obric.capabilitykit.entity.memory.MemoryEntity
    @NotNull
    public JSONObject convertToModelInput() {
        JSONObject r10 = new JSONObject();
        r10.put("type", getType());
        r10.put("createTime", getCreateTime());
        r10.put("modifyTime", getLastModifiedTime());
        r10.put("ecaId", getEcaId());
        r10.put("storeName", makeModelInputValue("店铺名称", this.storeName));
        String r11 = this.appName;
        if (r11 == null) goto L5;
        q.d(r11);
        r10.put("appName", makeModelInputValue("店铺平台", r11));
    L5:
        String r12 = this.address;
        if (r12 == null) goto L8;
        q.d(r12);
        r10.put("address", makeModelInputValue("店铺地址", r12));
    L8:
        String r13 = this.storeType;
        if (r13 == null) goto L11;
        q.d(r13);
        r10.put("storeType", makeModelInputValue("店铺类型", r13));
    L11:
        String r14 = this.city;
        if (r14 == null) goto L14;
        q.d(r14);
        r10.put("city", makeModelInputValue("店铺城市", r14));
    L14:
        return r10;
    }

    @Nullable
    public final String getAddress() {
        return this.address;
    }

    @Nullable
    public final String getAppName() {
        return this.appName;
    }

    @Nullable
    public final String getAppPkgName() {
        return this.appPkgName;
    }

    @Nullable
    public final String getCity() {
        return this.city;
    }

    @Override // com.obric.capabilitykit.common.execution.urishare.IUriSharerEntity
    @NotNull
    public List<Uri> getSharedUris() {
        FileEntity r10 = getScreenshot();
        if (r10 == null) goto L7;
        List<Uri> r11 = r10.getSharedUris();
        if (r11 == null) goto L7;
        return r11;
    L7:
        return t.i();
    }

    @NotNull
    public final String getStoreName() {
        return this.storeName;
    }

    @Nullable
    public final String getStoreType() {
        return this.storeType;
    }

    @Override // com.obric.capabilitykit.entity.app.AppEntity
    public void onReadSubClassExtensionField(@NotNull Parcel r10, @Nullable ClassLoader r11, int r12) {
        q.g(r10, "parcel");
        if (r12 != 1) goto L6;
        this.city = (String) r10.readValue(r11);
        return;
    }

    public final void setAddress(@Nullable String r10) {
        this.address = r10;
    }

    public final void setAppName(@Nullable String r10) {
        this.appName = r10;
    }

    public final void setAppPkgName(@Nullable String r10) {
        this.appPkgName = r10;
    }

    public final void setCity(@Nullable String r10) {
        this.city = r10;
    }

    public final void setStoreName(@NotNull String r10) {
        q.g(r10, "<set-?>");
        this.storeName = r10;
    }

    public final void setStoreType(@Nullable String r10) {
        this.storeType = r10;
    }

    @Override // com.obric.capabilitykit.entity.memory.MemoryEntity, com.obric.capabilitykit.entity.app.AppEntity, android.os.Parcelable
    public void writeToParcel(@NotNull Parcel r10, int r11) {
        q.g(r10, "parcel");
        writeMemoryBaseFieldToParcel$capabilitykitcommon_release(r10);
        r10.writeString(this.storeName);
        r10.writeString(this.appName);
        r10.writeString(this.appPkgName);
        r10.writeString(this.address);
        r10.writeString(this.storeType);
        writeMemoryExtensionFieldToParcel$capabilitykitcommon_release(r10, r11);
        r10.writeInt(1);
        r10.writeValue(this.city);
    }

    public CollectStoreMemoryEntity(@NotNull String r11, long r12, long r14, int r16, @NotNull String r17, @Nullable String r18, @Nullable String r19, @Nullable String r20, @Nullable String r21, @Nullable String r22) {
        q.g(r11, "id");
        q.g(r17, "storeName");
        super(r11, r12, r14, EntityType.MEMORY_COLLECT_STORE, r16);
        this.storeName = r17;
        this.appName = r18;
        this.appPkgName = r19;
        this.address = r20;
        this.storeType = r21;
        this.city = r22;
    }

    public /* synthetic */ CollectStoreMemoryEntity(String r17, long r18, long r20, int r22, String r23, String r24, String r25, String r26, String r27, String r28, int r29, DefaultConstructorMarker r30) {
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
}
