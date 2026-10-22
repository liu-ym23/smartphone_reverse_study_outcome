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
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 92\u00020\u00012\u00020\u0002:\u00019B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u008b\u0001\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u0007\u0012\u0006\u0010\u000f\u001a\u00020\u0007\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0016¢\u0006\u0002\u0010\u0017J\b\u0010.\u001a\u00020/H\u0016J\u000e\u00100\u001a\b\u0012\u0004\u0012\u0002010\u0016H\u0016J\"\u00102\u001a\u0002032\u0006\u0010\u0003\u001a\u00020\u00042\b\u00104\u001a\u0004\u0018\u0001052\u0006\u00106\u001a\u00020\fH\u0016J\u0018\u00107\u001a\u0002032\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u00108\u001a\u00020\fH\u0016R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0019\"\u0004\b\u001d\u0010\u001bR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0019\"\u0004\b\u001f\u0010\u001bR\u001a\u0010\u000e\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0019\"\u0004\b!\u0010\u001bR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0019\"\u0004\b#\u0010\u001bR\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0019\"\u0004\b%\u0010\u001bR\u001a\u0010\r\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0019\"\u0004\b'\u0010\u001bR\"\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001a\u0010\u000f\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0019\"\u0004\b-\u0010\u001b¨\u0006:"}, d2 = {"Lcom/obric/capabilitykit/entity/memory/OrderTicketMemoryEntity;", "Lcom/obric/capabilitykit/entity/memory/MemoryEntity;", "Lcom/obric/capabilitykit/common/execution/urishare/IUriSharerEntity;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "id", "", "createTime", "", "modifyTime", "productType", "", "name", "date", "startTime", "endTime", "city", "auditoriumName", "auditoriumAddress", "hallNumber", "seatNumber", "", "(Ljava/lang/String;JJILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getAuditoriumAddress", "()Ljava/lang/String;", "setAuditoriumAddress", "(Ljava/lang/String;)V", "getAuditoriumName", "setAuditoriumName", "getCity", "setCity", "getDate", "setDate", "getEndTime", "setEndTime", "getHallNumber", "setHallNumber", "getName", "setName", "getSeatNumber", "()Ljava/util/List;", "setSeatNumber", "(Ljava/util/List;)V", "getStartTime", "setStartTime", "convertToModelInput", "Lorg/json/JSONObject;", "getSharedUris", "Landroid/net/Uri;", "onReadSubClassExtensionField", "", "currentClassLoader", "Ljava/lang/ClassLoader;", "version", "writeToParcel", "flags", "CREATOR", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class OrderTicketMemoryEntity extends MemoryEntity implements IUriSharerEntity {

    @NotNull
    public static final CREATOR CREATOR = null;
    private static final int FIELD_VERSION = 0;
    private static final int RELATED_VERSION = 0;

    @Nullable
    private String auditoriumAddress;

    @Nullable
    private String auditoriumName;

    @Nullable
    private String city;

    @NotNull
    private String date;

    @Nullable
    private String endTime;

    @Nullable
    private String hallNumber;

    @NotNull
    private String name;

    @Nullable
    private List<String> seatNumber;

    @NotNull
    private String startTime;

    @Keep
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\b\u0087\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\tH\u0016J\u0006\u0010\n\u001a\u00020\u0005J\u001d\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\f2\u0006\u0010\r\u001a\u00020\u0005H\u0016¢\u0006\u0002\u0010\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/obric/capabilitykit/entity/memory/OrderTicketMemoryEntity$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/obric/capabilitykit/entity/memory/OrderTicketMemoryEntity;", "()V", "FIELD_VERSION", "", "RELATED_VERSION", "createFromParcel", "parcel", "Landroid/os/Parcel;", "getVersion", "newArray", "", "size", "(I)[Lcom/obric/capabilitykit/entity/memory/OrderTicketMemoryEntity;", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class CREATOR implements Parcelable.Creator<OrderTicketMemoryEntity> {
        private CREATOR() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public OrderTicketMemoryEntity createFromParcel(@NotNull Parcel r10) {
            q.g(r10, "parcel");
            AppEntity r11 = AppEntity.CREATOR.createFromParcel(r10);
            q.e(r11, "null cannot be cast to non-null type com.obric.capabilitykit.entity.memory.OrderTicketMemoryEntity");
            return (OrderTicketMemoryEntity) r11;
        }

        public final int getVersion() {
            return 0;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public OrderTicketMemoryEntity[] newArray(int r10) {
            return new OrderTicketMemoryEntity[r10];
        }

        public /* synthetic */ CREATOR(DefaultConstructorMarker r10) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ OrderTicketMemoryEntity createFromParcel(Parcel r10) {
            return createFromParcel(r10);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ OrderTicketMemoryEntity[] newArray(int r10) {
            return newArray(r10);
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public OrderTicketMemoryEntity(@NotNull Parcel r19) {
        q.g(r19, "parcel");
        this(EntityExtKt.f(r19), r19.readLong(), r19.readLong(), r19.readInt(), EntityExtKt.f(r19), EntityExtKt.f(r19), EntityExtKt.f(r19), r19.readString(), r19.readString(), r19.readString(), r19.readString(), r19.readString(), r19.createStringArrayList());
        readMemoryExtensionFieldFromParcel$capabilitykitcommon_release(r19);
        readSubClassExtensionFieldFromParcel$capabilitykitcommon_release(r19, 0, r19.readInt());
    }

    @Override // com.obric.capabilitykit.entity.memory.MemoryEntity
    @NotNull
    public JSONObject convertToModelInput() {
        JSONObject r10 = new JSONObject();
        r10.put("type", getType());
        r10.put("createTime", getCreateTime());
        r10.put("modifyTime", getLastModifiedTime());
        r10.put("ecaId", getEcaId());
        r10.put("name", makeModelInputValue("名称", this.name));
        r10.put("date", makeModelInputValue("日期", this.date));
        r10.put("startTime", makeModelInputValue("开始时间", this.startTime));
        String r11 = this.endTime;
        if (r11 == null) goto L5;
        q.d(r11);
        r10.put("endTime", makeModelInputValue("结束时间", r11));
    L5:
        String r12 = this.city;
        if (r12 == null) goto L8;
        q.d(r12);
        r10.put("city", makeModelInputValue("城市", r12));
    L8:
        String r13 = this.auditoriumName;
        if (r13 == null) goto L11;
        q.d(r13);
        r10.put("auditoriumName", makeModelInputValue("影院/演出厅名称", r13));
    L11:
        String r14 = this.auditoriumAddress;
        if (r14 == null) goto L14;
        q.d(r14);
        r10.put("auditoriumAddress", makeModelInputValue("具体地址", r14));
    L14:
        String r15 = this.hallNumber;
        if (r15 == null) goto L17;
        q.d(r15);
        r10.put("hallNumber", makeModelInputValue("厅号", r15));
    L17:
        List<String> r16 = this.seatNumber;
        if (r16 == null) goto L20;
        r10.put("seatNumber", makeModelInputValue("座位号", String.valueOf(r16)));
    L20:
        return r10;
    }

    @Nullable
    public final String getAuditoriumAddress() {
        return this.auditoriumAddress;
    }

    @Nullable
    public final String getAuditoriumName() {
        return this.auditoriumName;
    }

    @Nullable
    public final String getCity() {
        return this.city;
    }

    @NotNull
    public final String getDate() {
        return this.date;
    }

    @Nullable
    public final String getEndTime() {
        return this.endTime;
    }

    @Nullable
    public final String getHallNumber() {
        return this.hallNumber;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @Nullable
    public final List<String> getSeatNumber() {
        return this.seatNumber;
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
    public final String getStartTime() {
        return this.startTime;
    }

    @Override // com.obric.capabilitykit.entity.app.AppEntity
    public void onReadSubClassExtensionField(@NotNull Parcel r10, @Nullable ClassLoader r11, int r12) {
        q.g(r10, "parcel");
    }

    public final void setAuditoriumAddress(@Nullable String r10) {
        this.auditoriumAddress = r10;
    }

    public final void setAuditoriumName(@Nullable String r10) {
        this.auditoriumName = r10;
    }

    public final void setCity(@Nullable String r10) {
        this.city = r10;
    }

    public final void setDate(@NotNull String r10) {
        q.g(r10, "<set-?>");
        this.date = r10;
    }

    public final void setEndTime(@Nullable String r10) {
        this.endTime = r10;
    }

    public final void setHallNumber(@Nullable String r10) {
        this.hallNumber = r10;
    }

    public final void setName(@NotNull String r10) {
        q.g(r10, "<set-?>");
        this.name = r10;
    }

    public final void setSeatNumber(@Nullable List<String> r10) {
        this.seatNumber = r10;
    }

    public final void setStartTime(@NotNull String r10) {
        q.g(r10, "<set-?>");
        this.startTime = r10;
    }

    @Override // com.obric.capabilitykit.entity.memory.MemoryEntity, com.obric.capabilitykit.entity.app.AppEntity, android.os.Parcelable
    public void writeToParcel(@NotNull Parcel r10, int r11) {
        q.g(r10, "parcel");
        writeMemoryBaseFieldToParcel$capabilitykitcommon_release(r10);
        r10.writeString(this.name);
        r10.writeString(this.date);
        r10.writeString(this.startTime);
        r10.writeString(this.endTime);
        r10.writeString(this.city);
        r10.writeString(this.auditoriumName);
        r10.writeString(this.auditoriumAddress);
        r10.writeString(this.hallNumber);
        r10.writeStringList(this.seatNumber);
        writeMemoryExtensionFieldToParcel$capabilitykitcommon_release(r10, r11);
        r10.writeInt(0);
    }

    public OrderTicketMemoryEntity(@NotNull String r13, long r14, long r16, int r18, @NotNull String r19, @NotNull String r20, @NotNull String r21, @Nullable String r22, @Nullable String r23, @Nullable String r24, @Nullable String r25, @Nullable String r26, @Nullable List<String> r27) {
        q.g(r13, "id");
        q.g(r19, "name");
        q.g(r20, "date");
        q.g(r21, "startTime");
        super(r13, r14, r16, 10006, r18);
        this.name = r19;
        this.date = r20;
        this.startTime = r21;
        this.endTime = r22;
        this.city = r23;
        this.auditoriumName = r24;
        this.auditoriumAddress = r25;
        this.hallNumber = r26;
        this.seatNumber = r27;
    }

    public /* synthetic */ OrderTicketMemoryEntity(String r20, long r21, long r23, int r25, String r26, String r27, String r28, String r29, String r30, String r31, String r32, String r33, List r34, int r35, DefaultConstructorMarker r36) {
        if ((r35 & 128) == 0) goto L5;
        String r13 = null;
    L7:
        if ((r35 & 256) == 0) goto L9;
        String r14 = null;
    L11:
        if ((r35 & 512) == 0) goto L13;
        String r15 = null;
    L15:
        if ((r35 & 1024) == 0) goto L17;
        String r16 = null;
    L19:
        if ((r35 & 2048) == 0) goto L21;
        String r17 = null;
    L23:
        if ((r35 & 4096) == 0) goto L25;
        List r18 = null;
    L26:
        this(r20, r21, r23, r25, r26, r27, r28, r13, r14, r15, r16, r17, r18);
        return;
    L25:
        r18 = r34;
        goto L26
    L21:
        r17 = r33;
        goto L23
    L17:
        r16 = r32;
        goto L19
    L13:
        r15 = r31;
        goto L15
    L9:
        r14 = r30;
        goto L11
    L5:
        r13 = r29;
        goto L7
    }
}
