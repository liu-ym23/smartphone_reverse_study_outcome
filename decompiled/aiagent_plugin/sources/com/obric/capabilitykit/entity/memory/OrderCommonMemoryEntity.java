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
public final class OrderCommonMemoryEntity extends MemoryEntity implements IUriSharerEntity {
    public static final CREATOR CREATOR = null;
    private static final int FIELD_VERSION = 0;
    private static final int RELATED_VERSION = 0;
    private String orderCreateDate;
    private String orderCreateTime;
    private String orderDesc;
    private String orderName;

    public static final class CREATOR implements Parcelable.Creator<OrderCommonMemoryEntity> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(h r1) {
            this();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public OrderCommonMemoryEntity createFromParcel(Parcel r2) {
            o.e(r2, "parcel");
            AppEntity r1 = AppEntity.CREATOR.createFromParcel(r2);
            o.a(r1, "null cannot be cast to non-null type com.obric.capabilitykit.entity.memory.OrderCommonMemoryEntity");
            return (OrderCommonMemoryEntity) ZeusTransformUtils.preCheckCast(r1, OrderCommonMemoryEntity.class, "com.obric.aiagent.plugin");
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ OrderCommonMemoryEntity createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        public final int getVersion() {
            return 0;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public OrderCommonMemoryEntity[] newArray(int r1) {
            return new OrderCommonMemoryEntity[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ OrderCommonMemoryEntity[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public OrderCommonMemoryEntity(Parcel r13) {
        o.e(r13, "parcel");
        this(EntityExtKt.a(r13), r13.readLong(), r13.readLong(), r13.readInt(), EntityExtKt.a(r13), r13.readString(), r13.readString(), r13.readString());
        readMemoryExtensionFieldFromParcel$capabilitykitcommon_release(r13);
        readSubClassExtensionFieldFromParcel$capabilitykitcommon_release(r13, 0, r13.readInt());
    }

    public OrderCommonMemoryEntity(String r11, long r12, long r14, int r16, String r17, String r18, String r19, String r20) {
        o.e(r11, DbHelper.COL_ID);
        o.e(r17, "orderName");
        super(r11, r12, r14, 10005, r16);
        this.orderName = r17;
        this.orderDesc = r18;
        this.orderCreateDate = r19;
        this.orderCreateTime = r20;
    }

    public /* synthetic */ OrderCommonMemoryEntity(String r15, long r16, long r18, int r20, String r21, String r22, String r23, String r24, int r25, h r26) {
        if ((r25 & 32) == 0) goto L5;
        String r11 = null;
    L7:
        if ((r25 & 64) == 0) goto L9;
        String r12 = null;
    L11:
        if ((r25 & 128) == 0) goto L13;
        String r13 = null;
    L14:
        this(r15, r16, r18, r20, r21, r11, r12, r13);
        return;
    L13:
        r13 = r24;
        goto L14
    L9:
        r12 = r23;
        goto L11
    L5:
        r11 = r22;
        goto L7
    }

    @Override // com.obric.capabilitykit.entity.memory.MemoryEntity
    public JSONObject convertToModelInput() {
        JSONObject r0 = new JSONObject();
        r0.put("type", getType());
        r0.put("createTime", getCreateTime());
        r0.put("modifyTime", getLastModifiedTime());
        r0.put("ecaId", getEcaId());
        r0.put("orderName", makeModelInputValue("订单名称", this.orderName));
        String r1 = this.orderDesc;
        if (r1 == null) goto L5;
        o.a(r1);
        r0.put("orderDesc", makeModelInputValue("订单描述", r1));
    L5:
        String r2 = this.orderCreateDate;
        if (r2 == null) goto L8;
        o.a(r2);
        r0.put("orderCreateDate", makeModelInputValue("订单创建日期", r2));
    L8:
        String r3 = this.orderCreateTime;
        if (r3 == null) goto L11;
        o.a(r3);
        r0.put("orderCreateTime", makeModelInputValue("订单创建时间", r3));
    L11:
        return r0;
    }

    public final String getOrderCreateDate() {
        return this.orderCreateDate;
    }

    public final String getOrderCreateTime() {
        return this.orderCreateTime;
    }

    public final String getOrderDesc() {
        return this.orderDesc;
    }

    public final String getOrderName() {
        return this.orderName;
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
    public void onReadSubClassExtensionField(Parcel r1, ClassLoader r2, int r3) {
        o.e(r1, "parcel");
    }

    public final void setOrderCreateDate(String r1) {
        this.orderCreateDate = r1;
    }

    public final void setOrderCreateTime(String r1) {
        this.orderCreateTime = r1;
    }

    public final void setOrderDesc(String r1) {
        this.orderDesc = r1;
    }

    public final void setOrderName(String r2) {
        o.e(r2, "<set-?>");
        this.orderName = r2;
    }

    @Override // com.obric.capabilitykit.entity.memory.MemoryEntity, com.obric.capabilitykit.entity.app.AppEntity, android.os.Parcelable
    public void writeToParcel(Parcel r2, int r3) {
        o.e(r2, "parcel");
        writeMemoryBaseFieldToParcel$capabilitykitcommon_release(r2);
        r2.writeString(this.orderName);
        r2.writeString(this.orderDesc);
        r2.writeString(this.orderCreateDate);
        r2.writeString(this.orderCreateTime);
        writeMemoryExtensionFieldToParcel$capabilitykitcommon_release(r2, r3);
        r2.writeInt(0);
    }
}
