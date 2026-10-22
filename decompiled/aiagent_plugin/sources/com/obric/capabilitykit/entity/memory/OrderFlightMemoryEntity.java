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
public final class OrderFlightMemoryEntity extends MemoryEntity implements IUriSharerEntity {
    public static final CREATOR CREATOR = null;
    private static final int FIELD_VERSION = 0;
    private static final int RELATED_VERSION = 0;
    private String boardingGate;
    private String departureAirport;
    private String departureDate;
    private String departurePlace;
    private String departureTime;
    private String destination;
    private String flightNumber;
    private String landingAirport;
    private String landingDate;
    private String landingTime;
    private List<String> passengerName;
    private List<String> seatNumber;

    public static final class CREATOR implements Parcelable.Creator<OrderFlightMemoryEntity> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(h r1) {
            this();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public OrderFlightMemoryEntity createFromParcel(Parcel r2) {
            o.e(r2, "parcel");
            AppEntity r1 = AppEntity.CREATOR.createFromParcel(r2);
            o.a(r1, "null cannot be cast to non-null type com.obric.capabilitykit.entity.memory.OrderFlightMemoryEntity");
            return (OrderFlightMemoryEntity) ZeusTransformUtils.preCheckCast(r1, OrderFlightMemoryEntity.class, "com.obric.aiagent.plugin");
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ OrderFlightMemoryEntity createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        public final int getVersion() {
            return 0;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public OrderFlightMemoryEntity[] newArray(int r1) {
            return new OrderFlightMemoryEntity[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ OrderFlightMemoryEntity[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public OrderFlightMemoryEntity(Parcel r21) {
        o.e(r21, "parcel");
        this(EntityExtKt.a(r21), r21.readLong(), r21.readLong(), r21.readInt(), EntityExtKt.a(r21), EntityExtKt.a(r21), EntityExtKt.a(r21), EntityExtKt.a(r21), EntityExtKt.a(r21), EntityExtKt.a(r21), r21.readString(), r21.readString(), r21.readString(), r21.readString(), r21.createStringArrayList(), r21.createStringArrayList());
        readMemoryExtensionFieldFromParcel$capabilitykitcommon_release(r21);
        readSubClassExtensionFieldFromParcel$capabilitykitcommon_release(r21, 0, r21.readInt());
    }

    public OrderFlightMemoryEntity(String r18, long r19, long r21, int r23, String r24, String r25, String r26, String r27, String r28, String r29, String r30, String r31, String r32, String r33, List<String> r34, List<String> r35) {
        List<String> r15 = (List) ZeusTransformUtils.wrapperContextForParams(r34, List.class, "com.obric.aiagent.plugin");
        List<String> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r35, List.class, "com.obric.aiagent.plugin");
        o.e(r18, DbHelper.COL_ID);
        o.e(r24, "departureDate");
        o.e(r25, "departurePlace");
        o.e(r26, "destination");
        o.e(r27, "departureTime");
        o.e(r28, "landingTime");
        o.e(r29, "flightNumber");
        super(r18, r19, r21, 10001, r23);
        this.departureDate = r24;
        this.departurePlace = r25;
        this.destination = r26;
        this.departureTime = r27;
        this.landingTime = r28;
        this.flightNumber = r29;
        this.landingDate = r30;
        this.departureAirport = r31;
        this.landingAirport = r32;
        this.boardingGate = r33;
        this.passengerName = r15;
        this.seatNumber = r7;
    }

    public /* synthetic */ OrderFlightMemoryEntity(String r25, long r26, long r28, int r30, String r31, String r32, String r33, String r34, String r35, String r36, String r37, String r38, String r39, String r40, List r41, List r42, int r43, h r44) {
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
        r0.put("departureTime", makeModelInputValue("起飞时间", this.departureTime));
        r0.put("landingTime", makeModelInputValue("落地时间", this.landingTime));
        r0.put("flightNumber", makeModelInputValue("航班号", this.flightNumber));
        String r1 = this.landingDate;
        if (r1 == null) goto L5;
        o.a(r1);
        r0.put("landingDate", makeModelInputValue("落地日期", r1));
    L5:
        String r2 = this.departureAirport;
        if (r2 == null) goto L8;
        o.a(r2);
        r0.put("departureAirport", makeModelInputValue("起飞机场", r2));
    L8:
        String r3 = this.landingAirport;
        if (r3 == null) goto L11;
        o.a(r3);
        r0.put("landingAirport", makeModelInputValue("落地机场", r3));
    L11:
        String r4 = this.boardingGate;
        if (r4 == null) goto L14;
        o.a(r4);
        r0.put("boardingGate", makeModelInputValue("登机口", r4));
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

    public final String getBoardingGate() {
        return this.boardingGate;
    }

    public final String getDepartureAirport() {
        return this.departureAirport;
    }

    public final String getDepartureDate() {
        return this.departureDate;
    }

    public final String getDeparturePlace() {
        return this.departurePlace;
    }

    public final String getDepartureTime() {
        return this.departureTime;
    }

    public final String getDestination() {
        return this.destination;
    }

    public final String getFlightNumber() {
        return this.flightNumber;
    }

    public final String getLandingAirport() {
        return this.landingAirport;
    }

    public final String getLandingDate() {
        return this.landingDate;
    }

    public final String getLandingTime() {
        return this.landingTime;
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

    @Override // com.obric.capabilitykit.entity.app.AppEntity
    public void onReadSubClassExtensionField(Parcel r1, ClassLoader r2, int r3) {
        o.e(r1, "parcel");
    }

    public final void setBoardingGate(String r1) {
        this.boardingGate = r1;
    }

    public final void setDepartureAirport(String r1) {
        this.departureAirport = r1;
    }

    public final void setDepartureDate(String r2) {
        o.e(r2, "<set-?>");
        this.departureDate = r2;
    }

    public final void setDeparturePlace(String r2) {
        o.e(r2, "<set-?>");
        this.departurePlace = r2;
    }

    public final void setDepartureTime(String r2) {
        o.e(r2, "<set-?>");
        this.departureTime = r2;
    }

    public final void setDestination(String r2) {
        o.e(r2, "<set-?>");
        this.destination = r2;
    }

    public final void setFlightNumber(String r2) {
        o.e(r2, "<set-?>");
        this.flightNumber = r2;
    }

    public final void setLandingAirport(String r1) {
        this.landingAirport = r1;
    }

    public final void setLandingDate(String r1) {
        this.landingDate = r1;
    }

    public final void setLandingTime(String r2) {
        o.e(r2, "<set-?>");
        this.landingTime = r2;
    }

    public final void setPassengerName(List<String> r3) {
        this.passengerName = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
    }

    public final void setSeatNumber(List<String> r3) {
        this.seatNumber = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.capabilitykit.entity.memory.MemoryEntity, com.obric.capabilitykit.entity.app.AppEntity, android.os.Parcelable
    public void writeToParcel(Parcel r2, int r3) {
        o.e(r2, "parcel");
        writeMemoryBaseFieldToParcel$capabilitykitcommon_release(r2);
        r2.writeString(this.departureDate);
        r2.writeString(this.departurePlace);
        r2.writeString(this.destination);
        r2.writeString(this.departureTime);
        r2.writeString(this.landingTime);
        r2.writeString(this.flightNumber);
        r2.writeString(this.landingDate);
        r2.writeString(this.departureAirport);
        r2.writeString(this.landingAirport);
        r2.writeString(this.boardingGate);
        r2.writeStringList(this.passengerName);
        r2.writeStringList(this.seatNumber);
        writeMemoryExtensionFieldToParcel$capabilitykitcommon_release(r2, r3);
        r2.writeInt(0);
    }
}
