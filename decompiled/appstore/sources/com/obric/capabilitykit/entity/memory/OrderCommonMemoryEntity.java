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
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 (2\u00020\u00012\u00020\u0002:\u0001(B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005BQ\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\u0011J\b\u0010\u001c\u001a\u00020\u001dH\u0016J\u000e\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001fH\u0016J\"\u0010!\u001a\u00020\"2\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010%\u001a\u00020\fH\u0016J\u0018\u0010&\u001a\u00020\"2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010'\u001a\u00020\fH\u0016R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0013\"\u0004\b\u0017\u0010\u0015R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0013\"\u0004\b\u0019\u0010\u0015R\u001a\u0010\r\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0013\"\u0004\b\u001b\u0010\u0015¨\u0006)"}, d2 = {"Lcom/obric/capabilitykit/entity/memory/OrderCommonMemoryEntity;", "Lcom/obric/capabilitykit/entity/memory/MemoryEntity;", "Lcom/obric/capabilitykit/common/execution/urishare/IUriSharerEntity;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "id", "", "createTime", "", "modifyTime", "productType", "", "orderName", "orderDesc", "orderCreateDate", "orderCreateTime", "(Ljava/lang/String;JJILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getOrderCreateDate", "()Ljava/lang/String;", "setOrderCreateDate", "(Ljava/lang/String;)V", "getOrderCreateTime", "setOrderCreateTime", "getOrderDesc", "setOrderDesc", "getOrderName", "setOrderName", "convertToModelInput", "Lorg/json/JSONObject;", "getSharedUris", "", "Landroid/net/Uri;", "onReadSubClassExtensionField", "", "currentClassLoader", "Ljava/lang/ClassLoader;", "version", "writeToParcel", "flags", "CREATOR", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class OrderCommonMemoryEntity extends MemoryEntity implements IUriSharerEntity {

    @NotNull
    public static final CREATOR CREATOR = null;
    private static final int FIELD_VERSION = 0;
    private static final int RELATED_VERSION = 0;

    @Nullable
    private String orderCreateDate;

    @Nullable
    private String orderCreateTime;

    @Nullable
    private String orderDesc;

    @NotNull
    private String orderName;

    @Keep
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\b\u0087\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\tH\u0016J\u0006\u0010\n\u001a\u00020\u0005J\u001d\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\f2\u0006\u0010\r\u001a\u00020\u0005H\u0016¢\u0006\u0002\u0010\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/obric/capabilitykit/entity/memory/OrderCommonMemoryEntity$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/obric/capabilitykit/entity/memory/OrderCommonMemoryEntity;", "()V", "FIELD_VERSION", "", "RELATED_VERSION", "createFromParcel", "parcel", "Landroid/os/Parcel;", "getVersion", "newArray", "", "size", "(I)[Lcom/obric/capabilitykit/entity/memory/OrderCommonMemoryEntity;", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class CREATOR implements Parcelable.Creator<OrderCommonMemoryEntity> {
        private CREATOR() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public OrderCommonMemoryEntity createFromParcel(@NotNull Parcel r10) {
            q.g(r10, "parcel");
            AppEntity r11 = AppEntity.CREATOR.createFromParcel(r10);
            q.e(r11, "null cannot be cast to non-null type com.obric.capabilitykit.entity.memory.OrderCommonMemoryEntity");
            return (OrderCommonMemoryEntity) r11;
        }

        public final int getVersion() {
            return 0;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public OrderCommonMemoryEntity[] newArray(int r10) {
            return new OrderCommonMemoryEntity[r10];
        }

        public /* synthetic */ CREATOR(DefaultConstructorMarker r10) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ OrderCommonMemoryEntity createFromParcel(Parcel r10) {
            return createFromParcel(r10);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ OrderCommonMemoryEntity[] newArray(int r10) {
            return newArray(r10);
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public OrderCommonMemoryEntity(@NotNull Parcel r13) {
        q.g(r13, "parcel");
        this(EntityExtKt.f(r13), r13.readLong(), r13.readLong(), r13.readInt(), EntityExtKt.f(r13), r13.readString(), r13.readString(), r13.readString());
        readMemoryExtensionFieldFromParcel$capabilitykitcommon_release(r13);
        readSubClassExtensionFieldFromParcel$capabilitykitcommon_release(r13, 0, r13.readInt());
    }

    @Override // com.obric.capabilitykit.entity.memory.MemoryEntity
    @NotNull
    public JSONObject convertToModelInput() {
        JSONObject r10 = new JSONObject();
        r10.put("type", getType());
        r10.put("createTime", getCreateTime());
        r10.put("modifyTime", getLastModifiedTime());
        r10.put("ecaId", getEcaId());
        r10.put("orderName", makeModelInputValue("订单名称", this.orderName));
        String r11 = this.orderDesc;
        if (r11 == null) goto L5;
        q.d(r11);
        r10.put("orderDesc", makeModelInputValue("订单描述", r11));
    L5:
        String r12 = this.orderCreateDate;
        if (r12 == null) goto L8;
        q.d(r12);
        r10.put("orderCreateDate", makeModelInputValue("订单创建日期", r12));
    L8:
        String r13 = this.orderCreateTime;
        if (r13 == null) goto L11;
        q.d(r13);
        r10.put("orderCreateTime", makeModelInputValue("订单创建时间", r13));
    L11:
        return r10;
    }

    @Nullable
    public final String getOrderCreateDate() {
        return this.orderCreateDate;
    }

    @Nullable
    public final String getOrderCreateTime() {
        return this.orderCreateTime;
    }

    @Nullable
    public final String getOrderDesc() {
        return this.orderDesc;
    }

    @NotNull
    public final String getOrderName() {
        return this.orderName;
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
    }

    public final void setOrderCreateDate(@Nullable String r10) {
        this.orderCreateDate = r10;
    }

    public final void setOrderCreateTime(@Nullable String r10) {
        this.orderCreateTime = r10;
    }

    public final void setOrderDesc(@Nullable String r10) {
        this.orderDesc = r10;
    }

    public final void setOrderName(@NotNull String r10) {
        q.g(r10, "<set-?>");
        this.orderName = r10;
    }

    @Override // com.obric.capabilitykit.entity.memory.MemoryEntity, com.obric.capabilitykit.entity.app.AppEntity, android.os.Parcelable
    public void writeToParcel(@NotNull Parcel r10, int r11) {
        q.g(r10, "parcel");
        writeMemoryBaseFieldToParcel$capabilitykitcommon_release(r10);
        r10.writeString(this.orderName);
        r10.writeString(this.orderDesc);
        r10.writeString(this.orderCreateDate);
        r10.writeString(this.orderCreateTime);
        writeMemoryExtensionFieldToParcel$capabilitykitcommon_release(r10, r11);
        r10.writeInt(0);
    }

    public OrderCommonMemoryEntity(@NotNull String r11, long r12, long r14, int r16, @NotNull String r17, @Nullable String r18, @Nullable String r19, @Nullable String r20) {
        q.g(r11, "id");
        q.g(r17, "orderName");
        super(r11, r12, r14, 10005, r16);
        this.orderName = r17;
        this.orderDesc = r18;
        this.orderCreateDate = r19;
        this.orderCreateTime = r20;
    }

    public /* synthetic */ OrderCommonMemoryEntity(String r15, long r16, long r18, int r20, String r21, String r22, String r23, String r24, int r25, DefaultConstructorMarker r26) {
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
}
