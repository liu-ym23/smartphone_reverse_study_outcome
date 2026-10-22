package com.obric.capabilitykit.entity.memory;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import com.obric.capabilitykit.common.UiType;
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
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 B2\u00020\u00012\u00020\u0002:\u0001BB\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B©\u0001\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u0007\u0012\u0006\u0010\u000f\u001a\u00020\u0007\u0012\u0006\u0010\u0010\u001a\u00020\u0007\u0012\u0006\u0010\u0011\u001a\u00020\u0007\u0012\u0006\u0010\u0012\u001a\u00020\u0007\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0018\u0012\u0010\b\u0002\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0018¢\u0006\u0002\u0010\u001aJ\b\u00107\u001a\u000208H\u0016J\u000e\u00109\u001a\b\u0012\u0004\u0012\u00020:0\u0018H\u0016J\"\u0010;\u001a\u00020<2\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010=\u001a\u0004\u0018\u00010>2\u0006\u0010?\u001a\u00020\fH\u0016J\u0018\u0010@\u001a\u00020<2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010A\u001a\u00020\fH\u0016R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u001c\"\u0004\b \u0010\u001eR\u001a\u0010\u0011\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001c\"\u0004\b\"\u0010\u001eR\u001a\u0010\r\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001c\"\u0004\b$\u0010\u001eR\u001a\u0010\u000e\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u001c\"\u0004\b&\u0010\u001eR\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u001c\"\u0004\b(\u0010\u001eR\u001a\u0010\u0010\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u001c\"\u0004\b*\u0010\u001eR\u001a\u0010\u000f\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u001c\"\u0004\b,\u0010\u001eR\"\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\"\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010.\"\u0004\b2\u00100R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u001c\"\u0004\b4\u0010\u001eR\u001a\u0010\u0012\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u001c\"\u0004\b6\u0010\u001e¨\u0006C"}, d2 = {"Lcom/obric/capabilitykit/entity/memory/OrderTrainMemoryEntity;", "Lcom/obric/capabilitykit/entity/memory/MemoryEntity;", "Lcom/obric/capabilitykit/common/execution/urishare/IUriSharerEntity;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "id", "", "createTime", "", "modifyTime", "productType", "", "departureDate", "departurePlace", "destination", "departureTime", "arrivalTime", "trainNumber", "arrivalDate", "departureStation", "arrivalStation", "ticketGate", "passengerName", "", "seatNumber", "(Ljava/lang/String;JJILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;)V", "getArrivalDate", "()Ljava/lang/String;", "setArrivalDate", "(Ljava/lang/String;)V", "getArrivalStation", "setArrivalStation", "getArrivalTime", "setArrivalTime", "getDepartureDate", "setDepartureDate", "getDeparturePlace", "setDeparturePlace", "getDepartureStation", "setDepartureStation", "getDepartureTime", "setDepartureTime", "getDestination", "setDestination", "getPassengerName", "()Ljava/util/List;", "setPassengerName", "(Ljava/util/List;)V", "getSeatNumber", "setSeatNumber", "getTicketGate", "setTicketGate", "getTrainNumber", "setTrainNumber", "convertToModelInput", "Lorg/json/JSONObject;", "getSharedUris", "Landroid/net/Uri;", "onReadSubClassExtensionField", "", "currentClassLoader", "Ljava/lang/ClassLoader;", "version", "writeToParcel", "flags", "CREATOR", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class OrderTrainMemoryEntity extends MemoryEntity implements IUriSharerEntity {

    @NotNull
    public static final CREATOR CREATOR = null;
    private static final int FIELD_VERSION = 0;
    private static final int RELATED_VERSION = 0;

    @Nullable
    private String arrivalDate;

    @Nullable
    private String arrivalStation;

    @NotNull
    private String arrivalTime;

    @NotNull
    private String departureDate;

    @NotNull
    private String departurePlace;

    @Nullable
    private String departureStation;

    @NotNull
    private String departureTime;

    @NotNull
    private String destination;

    @Nullable
    private List<String> passengerName;

    @Nullable
    private List<String> seatNumber;

    @Nullable
    private String ticketGate;

    @NotNull
    private String trainNumber;

    @Keep
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\b\u0087\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\tH\u0016J\u0006\u0010\n\u001a\u00020\u0005J\u001d\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\f2\u0006\u0010\r\u001a\u00020\u0005H\u0016¢\u0006\u0002\u0010\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/obric/capabilitykit/entity/memory/OrderTrainMemoryEntity$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/obric/capabilitykit/entity/memory/OrderTrainMemoryEntity;", "()V", "FIELD_VERSION", "", "RELATED_VERSION", "createFromParcel", "parcel", "Landroid/os/Parcel;", "getVersion", "newArray", "", "size", "(I)[Lcom/obric/capabilitykit/entity/memory/OrderTrainMemoryEntity;", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class CREATOR implements Parcelable.Creator<OrderTrainMemoryEntity> {
        private CREATOR() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public OrderTrainMemoryEntity createFromParcel(@NotNull Parcel r10) {
            q.g(r10, "parcel");
            AppEntity r11 = AppEntity.CREATOR.createFromParcel(r10);
            q.e(r11, "null cannot be cast to non-null type com.obric.capabilitykit.entity.memory.OrderTrainMemoryEntity");
            return (OrderTrainMemoryEntity) r11;
        }

        public final int getVersion() {
            return 0;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public OrderTrainMemoryEntity[] newArray(int r10) {
            return new OrderTrainMemoryEntity[r10];
        }

        public /* synthetic */ CREATOR(DefaultConstructorMarker r10) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ OrderTrainMemoryEntity createFromParcel(Parcel r10) {
            return createFromParcel(r10);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ OrderTrainMemoryEntity[] newArray(int r10) {
            return newArray(r10);
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public OrderTrainMemoryEntity(@NotNull Parcel r21) {
        q.g(r21, "parcel");
        this(EntityExtKt.f(r21), r21.readLong(), r21.readLong(), r21.readInt(), EntityExtKt.f(r21), EntityExtKt.f(r21), EntityExtKt.f(r21), EntityExtKt.f(r21), EntityExtKt.f(r21), EntityExtKt.f(r21), r21.readString(), r21.readString(), r21.readString(), r21.readString(), r21.createStringArrayList(), r21.createStringArrayList());
        readMemoryExtensionFieldFromParcel$capabilitykitcommon_release(r21);
        readSubClassExtensionFieldFromParcel$capabilitykitcommon_release(r21, 0, r21.readInt());
    }

    @Override // com.obric.capabilitykit.entity.memory.MemoryEntity
    @NotNull
    public JSONObject convertToModelInput() {
        JSONObject r10 = new JSONObject();
        r10.put("type", getType());
        r10.put("createTime", getCreateTime());
        r10.put("modifyTime", getLastModifiedTime());
        r10.put("ecaId", getEcaId());
        r10.put("departureDate", makeModelInputValue("出发日期", this.departureDate));
        r10.put("departurePlace", makeModelInputValue("出发地", this.departurePlace));
        r10.put("destination", makeModelInputValue("目的地", this.destination));
        r10.put("departureTime", makeModelInputValue("出发时间", this.departureTime));
        r10.put("arrivalTime", makeModelInputValue("到达时间", this.arrivalTime));
        r10.put("trainNumber", makeModelInputValue("班次号", this.trainNumber));
        String r11 = this.arrivalDate;
        if (r11 == null) goto L5;
        q.d(r11);
        r10.put("arrivalDate", makeModelInputValue("到达日期", r11));
    L5:
        String r12 = this.departureStation;
        if (r12 == null) goto L8;
        q.d(r12);
        r10.put("departureStation", makeModelInputValue("出发站点", r12));
    L8:
        String r13 = this.arrivalStation;
        if (r13 == null) goto L11;
        q.d(r13);
        r10.put("arrivalStation", makeModelInputValue("到达站点", r13));
    L11:
        String r14 = this.ticketGate;
        if (r14 == null) goto L14;
        q.d(r14);
        r10.put("ticketGate", makeModelInputValue("检票口", r14));
    L14:
        List<String> r15 = this.passengerName;
        if (r15 == null) goto L17;
        r10.put("passengerName", makeModelInputValue("乘客名", String.valueOf(r15)));
    L17:
        List<String> r16 = this.seatNumber;
        if (r16 == null) goto L20;
        r10.put("seatNumber", makeModelInputValue("座位号", String.valueOf(r16)));
    L20:
        return r10;
    }

    @Nullable
    public final String getArrivalDate() {
        return this.arrivalDate;
    }

    @Nullable
    public final String getArrivalStation() {
        return this.arrivalStation;
    }

    @NotNull
    public final String getArrivalTime() {
        return this.arrivalTime;
    }

    @NotNull
    public final String getDepartureDate() {
        return this.departureDate;
    }

    @NotNull
    public final String getDeparturePlace() {
        return this.departurePlace;
    }

    @Nullable
    public final String getDepartureStation() {
        return this.departureStation;
    }

    @NotNull
    public final String getDepartureTime() {
        return this.departureTime;
    }

    @NotNull
    public final String getDestination() {
        return this.destination;
    }

    @Nullable
    public final List<String> getPassengerName() {
        return this.passengerName;
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

    @Nullable
    public final String getTicketGate() {
        return this.ticketGate;
    }

    @NotNull
    public final String getTrainNumber() {
        return this.trainNumber;
    }

    @Override // com.obric.capabilitykit.entity.app.AppEntity
    public void onReadSubClassExtensionField(@NotNull Parcel r10, @Nullable ClassLoader r11, int r12) {
        q.g(r10, "parcel");
    }

    public final void setArrivalDate(@Nullable String r10) {
        this.arrivalDate = r10;
    }

    public final void setArrivalStation(@Nullable String r10) {
        this.arrivalStation = r10;
    }

    public final void setArrivalTime(@NotNull String r10) {
        q.g(r10, "<set-?>");
        this.arrivalTime = r10;
    }

    public final void setDepartureDate(@NotNull String r10) {
        q.g(r10, "<set-?>");
        this.departureDate = r10;
    }

    public final void setDeparturePlace(@NotNull String r10) {
        q.g(r10, "<set-?>");
        this.departurePlace = r10;
    }

    public final void setDepartureStation(@Nullable String r10) {
        this.departureStation = r10;
    }

    public final void setDepartureTime(@NotNull String r10) {
        q.g(r10, "<set-?>");
        this.departureTime = r10;
    }

    public final void setDestination(@NotNull String r10) {
        q.g(r10, "<set-?>");
        this.destination = r10;
    }

    public final void setPassengerName(@Nullable List<String> r10) {
        this.passengerName = r10;
    }

    public final void setSeatNumber(@Nullable List<String> r10) {
        this.seatNumber = r10;
    }

    public final void setTicketGate(@Nullable String r10) {
        this.ticketGate = r10;
    }

    public final void setTrainNumber(@NotNull String r10) {
        q.g(r10, "<set-?>");
        this.trainNumber = r10;
    }

    @Override // com.obric.capabilitykit.entity.memory.MemoryEntity, com.obric.capabilitykit.entity.app.AppEntity, android.os.Parcelable
    public void writeToParcel(@NotNull Parcel r10, int r11) {
        q.g(r10, "parcel");
        writeMemoryBaseFieldToParcel$capabilitykitcommon_release(r10);
        r10.writeString(this.departureDate);
        r10.writeString(this.departurePlace);
        r10.writeString(this.destination);
        r10.writeString(this.departureTime);
        r10.writeString(this.arrivalTime);
        r10.writeString(this.trainNumber);
        r10.writeString(this.arrivalDate);
        r10.writeString(this.departureStation);
        r10.writeString(this.arrivalStation);
        r10.writeString(this.ticketGate);
        r10.writeStringList(this.passengerName);
        r10.writeStringList(this.seatNumber);
        writeMemoryExtensionFieldToParcel$capabilitykitcommon_release(r10, r11);
        r10.writeInt(0);
    }

    public OrderTrainMemoryEntity(@NotNull String r16, long r17, long r19, int r21, @NotNull String r22, @NotNull String r23, @NotNull String r24, @NotNull String r25, @NotNull String r26, @NotNull String r27, @Nullable String r28, @Nullable String r29, @Nullable String r30, @Nullable String r31, @Nullable List<String> r32, @Nullable List<String> r33) {
        q.g(r16, "id");
        q.g(r22, "departureDate");
        q.g(r23, "departurePlace");
        q.g(r24, "destination");
        q.g(r25, "departureTime");
        q.g(r26, "arrivalTime");
        q.g(r27, "trainNumber");
        super(r16, r17, r19, 10002, r21);
        this.departureDate = r22;
        this.departurePlace = r23;
        this.destination = r24;
        this.departureTime = r25;
        this.arrivalTime = r26;
        this.trainNumber = r27;
        this.arrivalDate = r28;
        this.departureStation = r29;
        this.arrivalStation = r30;
        this.ticketGate = r31;
        this.passengerName = r32;
        this.seatNumber = r33;
    }

    public /* synthetic */ OrderTrainMemoryEntity(String r23, long r24, long r26, int r28, String r29, String r30, String r31, String r32, String r33, String r34, String r35, String r36, String r37, String r38, List r39, List r40, int r41, DefaultConstructorMarker r42) {
        if ((r41 & 1024) == 0) goto L5;
        String r16 = null;
    L7:
        if ((r41 & 2048) == 0) goto L9;
        String r17 = null;
    L11:
        if ((r41 & 4096) == 0) goto L13;
        String r18 = null;
    L15:
        if ((r41 & 8192) == 0) goto L17;
        String r19 = null;
    L19:
        if ((r41 & 16384) == 0) goto L21;
        List r20 = null;
    L23:
        if ((r41 & UiType.FLAG_SETTINGS_CARD) == 0) goto L25;
        List r21 = null;
    L26:
        this(r23, r24, r26, r28, r29, r30, r31, r32, r33, r34, r16, r17, r18, r19, r20, r21);
        return;
    L25:
        r21 = r40;
        goto L26
    L21:
        r20 = r39;
        goto L23
    L17:
        r19 = r38;
        goto L19
    L13:
        r18 = r37;
        goto L15
    L9:
        r17 = r36;
        goto L11
    L5:
        r16 = r35;
        goto L7
    }
}
