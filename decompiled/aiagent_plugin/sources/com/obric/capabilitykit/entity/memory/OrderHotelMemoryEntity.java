package com.obric.capabilitykit.entity.memory;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.capabilitykit.common.execution.urishare.IUriSharerEntity;
import com.obric.capabilitykit.entity.EntityExtKt;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.FileEntity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.h;
import d.h.b.o;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class OrderHotelMemoryEntity extends MemoryEntity implements IUriSharerEntity {
    public static final CREATOR CREATOR = null;
    private static final int FIELD_VERSION = 1;
    private static final int RELATED_VERSION = 0;
    private String checkInDate;
    private String checkInTime;
    private String checkOutDate;
    private String checkOutTime;
    private String city;
    private String hotelAddress;
    private String hotelName;

    public static final class CREATOR implements Parcelable.Creator<OrderHotelMemoryEntity> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(h r1) {
            this();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public OrderHotelMemoryEntity createFromParcel(Parcel r2) {
            o.e(r2, "parcel");
            AppEntity r1 = AppEntity.CREATOR.createFromParcel(r2);
            o.a(r1, "null cannot be cast to non-null type com.obric.capabilitykit.entity.memory.OrderHotelMemoryEntity");
            return (OrderHotelMemoryEntity) ZeusTransformUtils.preCheckCast(r1, OrderHotelMemoryEntity.class, "com.obric.aiagent.plugin");
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ OrderHotelMemoryEntity createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        public final int getVersion() {
            return 1;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public OrderHotelMemoryEntity[] newArray(int r1) {
            return new OrderHotelMemoryEntity[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ OrderHotelMemoryEntity[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public OrderHotelMemoryEntity(Parcel r19) {
        o.e(r19, "parcel");
        this(EntityExtKt.a(r19), r19.readLong(), r19.readLong(), r19.readInt(), EntityExtKt.a(r19), EntityExtKt.a(r19), r19.readString(), r19.readString(), r19.readString(), r19.readString(), null, 1024, null);
        readMemoryExtensionFieldFromParcel$capabilitykitcommon_release(r19);
        readSubClassExtensionFieldFromParcel$capabilitykitcommon_release(r19, 1, r19.readInt());
    }

    public OrderHotelMemoryEntity(String r12, long r13, long r15, int r17, String r18, String r19, String r20, String r21, String r22, String r23, String r24) {
        o.e(r12, DbHelper.COL_ID);
        o.e(r18, "checkInDate");
        o.e(r19, "hotelName");
        super(r12, r13, r15, 10004, r17);
        this.checkInDate = r18;
        this.hotelName = r19;
        this.checkOutDate = r20;
        this.hotelAddress = r21;
        this.checkInTime = r22;
        this.checkOutTime = r23;
        this.city = r24;
    }

    public /* synthetic */ OrderHotelMemoryEntity(String r18, long r19, long r21, int r23, String r24, String r25, String r26, String r27, String r28, String r29, String r30, int r31, h r32) {
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

    @Override // com.obric.capabilitykit.entity.memory.MemoryEntity
    public JSONObject convertToModelInput() {
        JSONObject r0 = new JSONObject();
        r0.put("type", getType());
        r0.put("createTime", getCreateTime());
        r0.put("modifyTime", getLastModifiedTime());
        r0.put("ecaId", getEcaId());
        r0.put("checkInDate", makeModelInputValue("入住日期", this.checkInDate));
        r0.put("hotelName", makeModelInputValue("酒店名称", this.hotelName));
        String r1 = this.checkOutDate;
        if (r1 == null) goto L5;
        o.a(r1);
        r0.put("checkOutDate", makeModelInputValue("退房日期", r1));
    L5:
        String r2 = this.city;
        if (r2 == null) goto L8;
        o.a(r2);
        r0.put("city", makeModelInputValue("城市", r2));
    L8:
        String r3 = this.hotelAddress;
        if (r3 == null) goto L11;
        o.a(r3);
        r0.put("hotelAddress", makeModelInputValue("酒店地址", r3));
    L11:
        String r4 = this.checkInTime;
        if (r4 == null) goto L14;
        o.a(r4);
        r0.put("checkInTime", makeModelInputValue("入住时间", r4));
    L14:
        String r5 = this.checkOutTime;
        if (r5 == null) goto L17;
        o.a(r5);
        r0.put("checkOutTime", makeModelInputValue("退房时间", r5));
    L17:
        return r0;
    }

    public final String getCheckInDate() {
        return this.checkInDate;
    }

    public final String getCheckInTime() {
        return this.checkInTime;
    }

    public final String getCheckOutDate() {
        return this.checkOutDate;
    }

    public final String getCheckOutTime() {
        return this.checkOutTime;
    }

    public final String getCity() {
        return this.city;
    }

    public final String getHotelAddress() {
        return this.hotelAddress;
    }

    public final String getHotelName() {
        return this.hotelName;
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

    @Override // com.obric.capabilitykit.entity.app.AppEntity
    public void onReadSubClassExtensionField(Parcel r2, ClassLoader r3, int r4) {
        o.e(r2, "parcel");
        if (r4 != 1) goto L6;
        this.city = (String) ZeusTransformUtils.preCheckCast(r2.readValue(r3), String.class, "com.obric.aiagent.plugin");
        return;
    }

    public final void setCheckInDate(String r2) {
        o.e(r2, "<set-?>");
        this.checkInDate = r2;
    }

    public final void setCheckInTime(String r1) {
        this.checkInTime = r1;
    }

    public final void setCheckOutDate(String r1) {
        this.checkOutDate = r1;
    }

    public final void setCheckOutTime(String r1) {
        this.checkOutTime = r1;
    }

    public final void setCity(String r1) {
        this.city = r1;
    }

    public final void setHotelAddress(String r1) {
        this.hotelAddress = r1;
    }

    public final void setHotelName(String r2) {
        o.e(r2, "<set-?>");
        this.hotelName = r2;
    }

    @Override // com.obric.capabilitykit.entity.memory.MemoryEntity, com.obric.capabilitykit.entity.app.AppEntity, android.os.Parcelable
    public void writeToParcel(Parcel r2, int r3) {
        o.e(r2, "parcel");
        writeMemoryBaseFieldToParcel$capabilitykitcommon_release(r2);
        r2.writeString(this.checkInDate);
        r2.writeString(this.hotelName);
        r2.writeString(this.checkOutDate);
        r2.writeString(this.hotelAddress);
        r2.writeString(this.checkInTime);
        r2.writeString(this.checkOutTime);
        writeMemoryExtensionFieldToParcel$capabilitykitcommon_release(r2, r3);
        r2.writeInt(1);
        r2.writeValue(this.city);
    }
}
