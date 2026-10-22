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

    public static final class CREATOR implements Parcelable.Creator<OrderTrainMemoryEntity> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(h r1) {
            this();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public OrderTrainMemoryEntity createFromParcel(Parcel r2) {
            o.e(r2, "parcel");
            AppEntity r1 = AppEntity.CREATOR.createFromParcel(r2);
            o.a(r1, "null cannot be cast to non-null type com.obric.capabilitykit.entity.memory.OrderTrainMemoryEntity");
            return (OrderTrainMemoryEntity) ZeusTransformUtils.preCheckCast(r1, OrderTrainMemoryEntity.class, "com.obric.aiagent.plugin");
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
        o.e(r21, "parcel");
        this(EntityExtKt.a(r21), r21.readLong(), r21.readLong(), r21.readInt(), EntityExtKt.a(r21), EntityExtKt.a(r21), EntityExtKt.a(r21), EntityExtKt.a(r21), EntityExtKt.a(r21), EntityExtKt.a(r21), r21.readString(), r21.readString(), r21.readString(), r21.readString(), r21.createStringArrayList(), r21.createStringArrayList());
        readMemoryExtensionFieldFromParcel$capabilitykitcommon_release(r21);
        readSubClassExtensionFieldFromParcel$capabilitykitcommon_release(r21, 0, r21.readInt());
    }

    public OrderTrainMemoryEntity(String r18, long r19, long r21, int r23, String r24, String r25, String r26, String r27, String r28, String r29, String r30, String r31, String r32, String r33, List<String> r34, List<String> r35) {
        List<String> r15 = (List) ZeusTransformUtils.wrapperContextForParams(r34, List.class, "com.obric.aiagent.plugin");
        List<String> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r35, List.class, "com.obric.aiagent.plugin");
        o.e(r18, DbHelper.COL_ID);
        o.e(r24, "departureDate");
        o.e(r25, "departurePlace");
        o.e(r26, "destination");
        o.e(r27, "departureTime");
        o.e(r28, "arrivalTime");
        o.e(r29, "trainNumber");
        super(r18, r19, r21, 10002, r23);
        this.departureDate = r24;
        this.departurePlace = r25;
        this.destination = r26;
        this.departureTime = r27;
        this.arrivalTime = r28;
        this.trainNumber = r29;
        this.arrivalDate = r30;
        this.departureStation = r31;
        this.arrivalStation = r32;
        this.ticketGate = r33;
        this.passengerName = r15;
        this.seatNumber = r7;
    }

    public /* synthetic */ OrderTrainMemoryEntity(String r25, long r26, long r28, int r30, String r31, String r32, String r33, String r34, String r35, String r36, String r37, String r38, String r39, String r40, List r41, List r42, int r43, h r44) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r41, List.class, "com.obric.aiagent.plugin");
        List r2 = (List) ZeusTransformUtils.wrapperContextForParams(r42, List.class, "com.obric.aiagent.plugin");
        if ((r43 & 1024) == 0) goto L5;
        String r18 = null;
    L7:
        if ((r43 & 2048) == 0) goto L9;
        String r19 = null;
    L11:
        if ((r43 & 4096) == 0) goto L13;
        String r20 = null;
    L15:
        if ((r43 & 8192) == 0) goto L17;
        String r21 = null;
    L19:
        if ((r43 & 16384) == 0) goto L21;
        List r22 = null;
    L23:
        if ((r43 & 32768) == 0) goto L25;
        List r23 = null;
    L26:
        this(r25, r26, r28, r30, r31, r32, r33, r34, r35, r36, r18, r19, r20, r21, r22, r23);
        return;
    L25:
        r23 = r2;
        goto L26
    L21:
        r22 = r1;
        goto L23
    L17:
        r21 = r40;
        goto L19
    L13:
        r20 = r39;
        goto L15
    L9:
        r19 = r38;
        goto L11
    L5:
        r18 = r37;
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
        o.a(r1);
        r0.put("arrivalDate", makeModelInputValue("到达日期", r1));
    L5:
        String r2 = this.departureStation;
        if (r2 == null) goto L8;
        o.a(r2);
        r0.put("departureStation", makeModelInputValue("出发站点", r2));
    L8:
        String r3 = this.arrivalStation;
        if (r3 == null) goto L11;
        o.a(r3);
        r0.put("arrivalStation", makeModelInputValue("到达站点", r3));
    L11:
        String r4 = this.ticketGate;
        if (r4 == null) goto L14;
        o.a(r4);
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
        return p.b();
    }

    public final String getTicketGate() {
        return this.ticketGate;
    }

    public final String getTrainNumber() {
        return this.trainNumber;
    }

    @Override // com.obric.capabilitykit.entity.app.AppEntity
    public void onReadSubClassExtensionField(Parcel r1, ClassLoader r2, int r3) {
        o.e(r1, "parcel");
    }

    public final void setArrivalDate(String r1) {
        this.arrivalDate = r1;
    }

    public final void setArrivalStation(String r1) {
        this.arrivalStation = r1;
    }

    public final void setArrivalTime(String r2) {
        o.e(r2, "<set-?>");
        this.arrivalTime = r2;
    }

    public final void setDepartureDate(String r2) {
        o.e(r2, "<set-?>");
        this.departureDate = r2;
    }

    public final void setDeparturePlace(String r2) {
        o.e(r2, "<set-?>");
        this.departurePlace = r2;
    }

    public final void setDepartureStation(String r1) {
        this.departureStation = r1;
    }

    public final void setDepartureTime(String r2) {
        o.e(r2, "<set-?>");
        this.departureTime = r2;
    }

    public final void setDestination(String r2) {
        o.e(r2, "<set-?>");
        this.destination = r2;
    }

    public final void setPassengerName(List<String> r3) {
        this.passengerName = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
    }

    public final void setSeatNumber(List<String> r3) {
        this.seatNumber = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
    }

    public final void setTicketGate(String r1) {
        this.ticketGate = r1;
    }

    public final void setTrainNumber(String r2) {
        o.e(r2, "<set-?>");
        this.trainNumber = r2;
    }

    @Override // com.obric.capabilitykit.entity.memory.MemoryEntity, com.obric.capabilitykit.entity.app.AppEntity, android.os.Parcelable
    public void writeToParcel(Parcel r2, int r3) {
        o.e(r2, "parcel");
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
