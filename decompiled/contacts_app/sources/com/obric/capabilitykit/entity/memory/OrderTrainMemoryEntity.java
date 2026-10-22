package com.obric.capabilitykit.entity.memory;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.apm.constant.PerfConsts;
import com.obric.capabilitykit.common.execution.urishare.IUriSharerEntity;
import com.obric.capabilitykit.entity.EntityExtKt;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.FileEntity;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import obric.widget.search.data.GloableSearchConfig;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 B2\u00020\u00012\u00020\u0002:\u0001BB\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B©\u0001\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u0007\u0012\u0006\u0010\u000f\u001a\u00020\u0007\u0012\u0006\u0010\u0010\u001a\u00020\u0007\u0012\u0006\u0010\u0011\u001a\u00020\u0007\u0012\u0006\u0010\u0012\u001a\u00020\u0007\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0018\u0012\u0010\b\u0002\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0018¢\u0006\u0002\u0010\u001aJ\b\u00107\u001a\u000208H\u0016J\u000e\u00109\u001a\b\u0012\u0004\u0012\u00020:0\u0018H\u0016J\"\u0010;\u001a\u00020<2\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010=\u001a\u0004\u0018\u00010>2\u0006\u0010?\u001a\u00020\fH\u0016J\u0018\u0010@\u001a\u00020<2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010A\u001a\u00020\fH\u0016R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u001c\"\u0004\b \u0010\u001eR\u001a\u0010\u0011\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001c\"\u0004\b\"\u0010\u001eR\u001a\u0010\r\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001c\"\u0004\b$\u0010\u001eR\u001a\u0010\u000e\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u001c\"\u0004\b&\u0010\u001eR\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u001c\"\u0004\b(\u0010\u001eR\u001a\u0010\u0010\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u001c\"\u0004\b*\u0010\u001eR\u001a\u0010\u000f\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u001c\"\u0004\b,\u0010\u001eR\"\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\"\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010.\"\u0004\b2\u00100R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u001c\"\u0004\b4\u0010\u001eR\u001a\u0010\u0012\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u001c\"\u0004\b6\u0010\u001e¨\u0006C"}, d2 = {"Lcom/obric/capabilitykit/entity/memory/OrderTrainMemoryEntity;", "Lcom/obric/capabilitykit/entity/memory/MemoryEntity;", "Lcom/obric/capabilitykit/common/execution/urishare/IUriSharerEntity;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "id", "", "createTime", "", "modifyTime", "productType", "", "departureDate", "departurePlace", "destination", "departureTime", "arrivalTime", "trainNumber", "arrivalDate", "departureStation", "arrivalStation", "ticketGate", "passengerName", "", "seatNumber", "(Ljava/lang/String;JJILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;)V", "getArrivalDate", "()Ljava/lang/String;", "setArrivalDate", "(Ljava/lang/String;)V", "getArrivalStation", "setArrivalStation", "getArrivalTime", "setArrivalTime", "getDepartureDate", "setDepartureDate", "getDeparturePlace", "setDeparturePlace", "getDepartureStation", "setDepartureStation", "getDepartureTime", "setDepartureTime", "getDestination", "setDestination", "getPassengerName", "()Ljava/util/List;", "setPassengerName", "(Ljava/util/List;)V", "getSeatNumber", "setSeatNumber", "getTicketGate", "setTicketGate", "getTrainNumber", "setTrainNumber", "convertToModelInput", "Lorg/json/JSONObject;", "getSharedUris", "Landroid/net/Uri;", "onReadSubClassExtensionField", "", "currentClassLoader", "Ljava/lang/ClassLoader;", GloableSearchConfig.KEY_VERSION, "writeToParcel", "flags", "CREATOR", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class OrderTrainMemoryEntity extends MemoryEntity implements IUriSharerEntity {
    public static final CREATOR CREATOR = null;
    private static final int FIELD_VERSION = 0;
    private static final int RELATED_VERSION = 0;
    private String arrivalDate;
    private String arrivalStation;
    private String arrivalTime;
    private String departureDate;
    private String departurePlace;
    private String departureStation;
    private String departureTime;
    private String destination;
    private List<String> passengerName;
    private List<String> seatNumber;
    private String ticketGate;
    private String trainNumber;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\b\u0087\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\tH\u0016J\u0006\u0010\n\u001a\u00020\u0005J\u001d\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\f2\u0006\u0010\r\u001a\u00020\u0005H\u0016¢\u0006\u0002\u0010\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/obric/capabilitykit/entity/memory/OrderTrainMemoryEntity$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/obric/capabilitykit/entity/memory/OrderTrainMemoryEntity;", "()V", "FIELD_VERSION", "", "RELATED_VERSION", "createFromParcel", "parcel", "Landroid/os/Parcel;", "getVersion", "newArray", "", PerfConsts.PERF_DISK_FILE_SIZE, "(I)[Lcom/obric/capabilitykit/entity/memory/OrderTrainMemoryEntity;", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class CREATOR implements Parcelable.Creator<OrderTrainMemoryEntity> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(DefaultConstructorMarker r1) {
            this();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public OrderTrainMemoryEntity createFromParcel(Parcel r1) {
            Intrinsics.checkNotNullParameter(r1, "parcel");
            AppEntity r0 = AppEntity.CREATOR.createFromParcel(r1);
            Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.obric.capabilitykit.entity.memory.OrderTrainMemoryEntity");
            return (OrderTrainMemoryEntity) r0;
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ OrderTrainMemoryEntity createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        public final int getVersion() {
            return 0;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public OrderTrainMemoryEntity[] newArray(int r1) {
            return new OrderTrainMemoryEntity[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ OrderTrainMemoryEntity[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public OrderTrainMemoryEntity(Parcel r21) {
        Intrinsics.checkNotNullParameter(r21, "parcel");
        this(EntityExtKt.readStringOrEmpty(r21), r21.readLong(), r21.readLong(), r21.readInt(), EntityExtKt.readStringOrEmpty(r21), EntityExtKt.readStringOrEmpty(r21), EntityExtKt.readStringOrEmpty(r21), EntityExtKt.readStringOrEmpty(r21), EntityExtKt.readStringOrEmpty(r21), EntityExtKt.readStringOrEmpty(r21), r21.readString(), r21.readString(), r21.readString(), r21.readString(), r21.createStringArrayList(), r21.createStringArrayList());
        readMemoryExtensionFieldFromParcel$capabilitykitcommon_release(r21);
        readSubClassExtensionFieldFromParcel$capabilitykitcommon_release(r21, 0, r21.readInt());
    }

    public OrderTrainMemoryEntity(String r16, long r17, long r19, int r21, String r22, String r23, String r24, String r25, String r26, String r27, String r28, String r29, String r30, String r31, List<String> r32, List<String> r33) {
        Intrinsics.checkNotNullParameter(r16, "id");
        Intrinsics.checkNotNullParameter(r22, "departureDate");
        Intrinsics.checkNotNullParameter(r23, "departurePlace");
        Intrinsics.checkNotNullParameter(r24, "destination");
        Intrinsics.checkNotNullParameter(r25, "departureTime");
        Intrinsics.checkNotNullParameter(r26, "arrivalTime");
        Intrinsics.checkNotNullParameter(r27, "trainNumber");
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
        if ((r41 & 32768) == 0) goto L25;
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

    @Override // com.obric.capabilitykit.entity.memory.MemoryEntity
    public JSONObject convertToModelInput() {
        JSONObject r0 = new JSONObject();
        r0.put("type", getType());
        r0.put("createTime", getCreateTime());
        r0.put("modifyTime", getLastModifiedTime());
        r0.put("ecaId", getEcaId());
        r0.put("departureDate", makeModelInputValue("出发日期", this.departureDate));
        r0.put("departurePlace", makeModelInputValue("出发地", this.departurePlace));
        r0.put("destination", makeModelInputValue("目的地", this.destination));
        r0.put("departureTime", makeModelInputValue("出发时间", this.departureTime));
        r0.put("arrivalTime", makeModelInputValue("到达时间", this.arrivalTime));
        r0.put("trainNumber", makeModelInputValue("班次号", this.trainNumber));
        String r1 = this.arrivalDate;
        if (r1 == null) goto L5;
        Intrinsics.checkNotNull(r1);
        r0.put("arrivalDate", makeModelInputValue("到达日期", r1));
    L5:
        String r2 = this.departureStation;
        if (r2 == null) goto L8;
        Intrinsics.checkNotNull(r2);
        r0.put("departureStation", makeModelInputValue("出发站点", r2));
    L8:
        String r3 = this.arrivalStation;
        if (r3 == null) goto L11;
        Intrinsics.checkNotNull(r3);
        r0.put("arrivalStation", makeModelInputValue("到达站点", r3));
    L11:
        String r4 = this.ticketGate;
        if (r4 == null) goto L14;
        Intrinsics.checkNotNull(r4);
        r0.put("ticketGate", makeModelInputValue("检票口", r4));
    L14:
        List<String> r5 = this.passengerName;
        if (r5 == null) goto L17;
        r0.put("passengerName", makeModelInputValue("乘客名", String.valueOf(r5)));
    L17:
        List<String> r6 = this.seatNumber;
        if (r6 == null) goto L20;
        r0.put("seatNumber", makeModelInputValue("座位号", String.valueOf(r6)));
    L20:
        return r0;
    }

    public final String getArrivalDate() {
        return this.arrivalDate;
    }

    public final String getArrivalStation() {
        return this.arrivalStation;
    }

    public final String getArrivalTime() {
        return this.arrivalTime;
    }

    public final String getDepartureDate() {
        return this.departureDate;
    }

    public final String getDeparturePlace() {
        return this.departurePlace;
    }

    public final String getDepartureStation() {
        return this.departureStation;
    }

    public final String getDepartureTime() {
        return this.departureTime;
    }

    public final String getDestination() {
        return this.destination;
    }

    public final List<String> getPassengerName() {
        return this.passengerName;
    }

    public final List<String> getSeatNumber() {
        return this.seatNumber;
    }

    @Override // com.obric.capabilitykit.common.execution.urishare.IUriSharerEntity
    public List<Uri> getSharedUris() {
        FileEntity r0 = getScreenshot();
        if (r0 == null) goto L7;
        List<Uri> r1 = r0.getSharedUris();
        if (r1 == null) goto L7;
        return r1;
    L7:
        return CollectionsKt.emptyList();
    }

    public final String getTicketGate() {
        return this.ticketGate;
    }

    public final String getTrainNumber() {
        return this.trainNumber;
    }

    @Override // com.obric.capabilitykit.entity.app.AppEntity
    public void onReadSubClassExtensionField(Parcel r1, ClassLoader r2, int r3) {
        Intrinsics.checkNotNullParameter(r1, "parcel");
    }

    public final void setArrivalDate(String r1) {
        this.arrivalDate = r1;
    }

    public final void setArrivalStation(String r1) {
        this.arrivalStation = r1;
    }

    public final void setArrivalTime(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.arrivalTime = r2;
    }

    public final void setDepartureDate(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.departureDate = r2;
    }

    public final void setDeparturePlace(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.departurePlace = r2;
    }

    public final void setDepartureStation(String r1) {
        this.departureStation = r1;
    }

    public final void setDepartureTime(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.departureTime = r2;
    }

    public final void setDestination(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.destination = r2;
    }

    public final void setPassengerName(List<String> r1) {
        this.passengerName = r1;
    }

    public final void setSeatNumber(List<String> r1) {
        this.seatNumber = r1;
    }

    public final void setTicketGate(String r1) {
        this.ticketGate = r1;
    }

    public final void setTrainNumber(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.trainNumber = r2;
    }

    @Override // com.obric.capabilitykit.entity.memory.MemoryEntity, com.obric.capabilitykit.entity.app.AppEntity, android.os.Parcelable
    public void writeToParcel(Parcel r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "parcel");
        writeMemoryBaseFieldToParcel$capabilitykitcommon_release(r2);
        r2.writeString(this.departureDate);
        r2.writeString(this.departurePlace);
        r2.writeString(this.destination);
        r2.writeString(this.departureTime);
        r2.writeString(this.arrivalTime);
        r2.writeString(this.trainNumber);
        r2.writeString(this.arrivalDate);
        r2.writeString(this.departureStation);
        r2.writeString(this.arrivalStation);
        r2.writeString(this.ticketGate);
        r2.writeStringList(this.passengerName);
        r2.writeStringList(this.seatNumber);
        writeMemoryExtensionFieldToParcel$capabilitykitcommon_release(r2, r3);
        r2.writeInt(0);
    }
}
