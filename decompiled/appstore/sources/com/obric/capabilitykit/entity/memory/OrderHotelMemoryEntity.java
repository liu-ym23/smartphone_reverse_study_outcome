package com.obric.capabilitykit.entity.memory;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import com.obric.capabilitykit.common.execution.urishare.IUriSharerEntity;
import com.obric.capabilitykit.entity.EntityExtKt;
import com.obric.capabilitykit.entity.app.AppEntity;
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
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 12\u00020\u00012\u00020\u0002:\u00011B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005Bq\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u0007\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\u0014J\b\u0010%\u001a\u00020&H\u0016J\u000e\u0010'\u001a\b\u0012\u0004\u0012\u00020)0(H\u0016J\"\u0010*\u001a\u00020+2\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010,\u001a\u0004\u0018\u00010-2\u0006\u0010.\u001a\u00020\fH\u0016J\u0018\u0010/\u001a\u00020+2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u00100\u001a\u00020\fH\u0016R\u001a\u0010\r\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0016\"\u0004\b\u001a\u0010\u0018R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0016\"\u0004\b\u001c\u0010\u0018R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0016\"\u0004\b\u001e\u0010\u0018R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0016\"\u0004\b \u0010\u0018R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0016\"\u0004\b\"\u0010\u0018R\u001a\u0010\u000e\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0016\"\u0004\b$\u0010\u0018¨\u00062"}, d2 = {"Lcom/obric/capabilitykit/entity/memory/OrderHotelMemoryEntity;", "Lcom/obric/capabilitykit/entity/memory/MemoryEntity;", "Lcom/obric/capabilitykit/common/execution/urishare/IUriSharerEntity;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "id", "", "createTime", "", "modifyTime", "productType", "", "checkInDate", "hotelName", "checkOutDate", "hotelAddress", "checkInTime", "checkOutTime", "city", "(Ljava/lang/String;JJILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCheckInDate", "()Ljava/lang/String;", "setCheckInDate", "(Ljava/lang/String;)V", "getCheckInTime", "setCheckInTime", "getCheckOutDate", "setCheckOutDate", "getCheckOutTime", "setCheckOutTime", "getCity", "setCity", "getHotelAddress", "setHotelAddress", "getHotelName", "setHotelName", "convertToModelInput", "Lorg/json/JSONObject;", "getSharedUris", "", "Landroid/net/Uri;", "onReadSubClassExtensionField", "", "currentClassLoader", "Ljava/lang/ClassLoader;", "version", "writeToParcel", "flags", "CREATOR", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class OrderHotelMemoryEntity extends MemoryEntity implements IUriSharerEntity {

    @NotNull
    public static final CREATOR CREATOR = null;
    private static final int FIELD_VERSION = 1;
    private static final int RELATED_VERSION = 0;

    @NotNull
    private String checkInDate;

    @Nullable
    private String checkInTime;

    @Nullable
    private String checkOutDate;

    @Nullable
    private String checkOutTime;

    @Nullable
    private String city;

    @Nullable
    private String hotelAddress;

    @NotNull
    private String hotelName;

    @Keep
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\b\u0087\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\tH\u0016J\u0006\u0010\n\u001a\u00020\u0005J\u001d\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\f2\u0006\u0010\r\u001a\u00020\u0005H\u0016¢\u0006\u0002\u0010\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/obric/capabilitykit/entity/memory/OrderHotelMemoryEntity$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/obric/capabilitykit/entity/memory/OrderHotelMemoryEntity;", "()V", "FIELD_VERSION", "", "RELATED_VERSION", "createFromParcel", "parcel", "Landroid/os/Parcel;", "getVersion", "newArray", "", "size", "(I)[Lcom/obric/capabilitykit/entity/memory/OrderHotelMemoryEntity;", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class CREATOR implements Parcelable.Creator<OrderHotelMemoryEntity> {
        private CREATOR() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public OrderHotelMemoryEntity createFromParcel(@NotNull Parcel r10) {
            q.g(r10, "parcel");
            AppEntity r11 = AppEntity.CREATOR.createFromParcel(r10);
            q.e(r11, "null cannot be cast to non-null type com.obric.capabilitykit.entity.memory.OrderHotelMemoryEntity");
            return (OrderHotelMemoryEntity) r11;
        }

        public final int getVersion() {
            return 1;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public OrderHotelMemoryEntity[] newArray(int r10) {
            return new OrderHotelMemoryEntity[r10];
        }

        public /* synthetic */ CREATOR(DefaultConstructorMarker r10) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ OrderHotelMemoryEntity createFromParcel(Parcel r10) {
            return createFromParcel(r10);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ OrderHotelMemoryEntity[] newArray(int r10) {
            return newArray(r10);
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public OrderHotelMemoryEntity(@NotNull Parcel r19) {
        q.g(r19, "parcel");
        String r15 = null;
        this(EntityExtKt.f(r19), r19.readLong(), r19.readLong(), r19.readInt(), EntityExtKt.f(r19), EntityExtKt.f(r19), r19.readString(), r19.readString(), r19.readString(), r19.readString(), r15, 1024, null);
        readMemoryExtensionFieldFromParcel$capabilitykitcommon_release(r19);
        readSubClassExtensionFieldFromParcel$capabilitykitcommon_release(r19, 1, r19.readInt());
    }

    @Override // com.obric.capabilitykit.entity.memory.MemoryEntity
    @NotNull
    public JSONObject convertToModelInput() {
        JSONObject r10 = new JSONObject();
        r10.put("type", getType());
        r10.put("createTime", getCreateTime());
        r10.put("modifyTime", getLastModifiedTime());
        r10.put("ecaId", getEcaId());
        r10.put("checkInDate", makeModelInputValue("入住日期", this.checkInDate));
        r10.put("hotelName", makeModelInputValue("酒店名称", this.hotelName));
        String r11 = this.checkOutDate;
        if (r11 == null) goto L5;
        q.d(r11);
        r10.put("checkOutDate", makeModelInputValue("退房日期", r11));
    L5:
        String r12 = this.city;
        if (r12 == null) goto L8;
        q.d(r12);
        r10.put("city", makeModelInputValue("城市", r12));
    L8:
        String r13 = this.hotelAddress;
        if (r13 == null) goto L11;
        q.d(r13);
        r10.put("hotelAddress", makeModelInputValue("酒店地址", r13));
    L11:
        String r14 = this.checkInTime;
        if (r14 == null) goto L14;
        q.d(r14);
        r10.put("checkInTime", makeModelInputValue("入住时间", r14));
    L14:
        String r15 = this.checkOutTime;
        if (r15 == null) goto L17;
        q.d(r15);
        r10.put("checkOutTime", makeModelInputValue("退房时间", r15));
    L17:
        return r10;
    }

    @NotNull
    public final String getCheckInDate() {
        return this.checkInDate;
    }

    @Nullable
    public final String getCheckInTime() {
        return this.checkInTime;
    }

    @Nullable
    public final String getCheckOutDate() {
        return this.checkOutDate;
    }

    @Nullable
    public final String getCheckOutTime() {
        return this.checkOutTime;
    }

    @Nullable
    public final String getCity() {
        return this.city;
    }

    @Nullable
    public final String getHotelAddress() {
        return this.hotelAddress;
    }

    @NotNull
    public final String getHotelName() {
        return this.hotelName;
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

    @Override // com.obric.capabilitykit.entity.app.AppEntity
    public void onReadSubClassExtensionField(@NotNull Parcel r10, @Nullable ClassLoader r11, int r12) {
        q.g(r10, "parcel");
        if (r12 != 1) goto L6;
        this.city = (String) r10.readValue(r11);
        return;
    }

    public final void setCheckInDate(@NotNull String r10) {
        q.g(r10, "<set-?>");
        this.checkInDate = r10;
    }

    public final void setCheckInTime(@Nullable String r10) {
        this.checkInTime = r10;
    }

    public final void setCheckOutDate(@Nullable String r10) {
        this.checkOutDate = r10;
    }

    public final void setCheckOutTime(@Nullable String r10) {
        this.checkOutTime = r10;
    }

    public final void setCity(@Nullable String r10) {
        this.city = r10;
    }

    public final void setHotelAddress(@Nullable String r10) {
        this.hotelAddress = r10;
    }

    public final void setHotelName(@NotNull String r10) {
        q.g(r10, "<set-?>");
        this.hotelName = r10;
    }

    @Override // com.obric.capabilitykit.entity.memory.MemoryEntity, com.obric.capabilitykit.entity.app.AppEntity, android.os.Parcelable
    public void writeToParcel(@NotNull Parcel r10, int r11) {
        q.g(r10, "parcel");
        writeMemoryBaseFieldToParcel$capabilitykitcommon_release(r10);
        r10.writeString(this.checkInDate);
        r10.writeString(this.hotelName);
        r10.writeString(this.checkOutDate);
        r10.writeString(this.hotelAddress);
        r10.writeString(this.checkInTime);
        r10.writeString(this.checkOutTime);
        writeMemoryExtensionFieldToParcel$capabilitykitcommon_release(r10, r11);
        r10.writeInt(1);
        r10.writeValue(this.city);
    }

    public OrderHotelMemoryEntity(@NotNull String r12, long r13, long r15, int r17, @NotNull String r18, @NotNull String r19, @Nullable String r20, @Nullable String r21, @Nullable String r22, @Nullable String r23, @Nullable String r24) {
        q.g(r12, "id");
        q.g(r18, "checkInDate");
        q.g(r19, "hotelName");
        super(r12, r13, r15, 10004, r17);
        this.checkInDate = r18;
        this.hotelName = r19;
        this.checkOutDate = r20;
        this.hotelAddress = r21;
        this.checkInTime = r22;
        this.checkOutTime = r23;
        this.city = r24;
    }

    public /* synthetic */ OrderHotelMemoryEntity(String r18, long r19, long r21, int r23, String r24, String r25, String r26, String r27, String r28, String r29, String r30, int r31, DefaultConstructorMarker r32) {
        if ((r31 & 64) == 0) goto L5;
        String r12 = null;
    L7:
        if ((r31 & 128) == 0) goto L9;
        String r13 = null;
    L11:
        if ((r31 & 256) == 0) goto L13;
        String r14 = null;
    L15:
        if ((r31 & 512) == 0) goto L17;
        String r15 = null;
    L19:
        if ((r31 & 1024) == 0) goto L21;
        String r16 = null;
    L22:
        this(r18, r19, r21, r23, r24, r25, r12, r13, r14, r15, r16);
        return;
    L21:
        r16 = r30;
        goto L22
    L17:
        r15 = r29;
        goto L19
    L13:
        r14 = r28;
        goto L15
    L9:
        r13 = r27;
        goto L11
    L5:
        r12 = r26;
        goto L7
    }
}
