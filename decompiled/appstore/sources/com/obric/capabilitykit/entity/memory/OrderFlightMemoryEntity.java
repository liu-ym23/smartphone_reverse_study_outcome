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
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 B2\u00020\u00012\u00020\u0002:\u0001BB\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B©\u0001\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u0007\u0012\u0006\u0010\u000f\u001a\u00020\u0007\u0012\u0006\u0010\u0010\u001a\u00020\u0007\u0012\u0006\u0010\u0011\u001a\u00020\u0007\u0012\u0006\u0010\u0012\u001a\u00020\u0007\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0018\u0012\u0010\b\u0002\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0018¢\u0006\u0002\u0010\u001aJ\b\u00107\u001a\u000208H\u0016J\u000e\u00109\u001a\b\u0012\u0004\u0012\u00020:0\u0018H\u0016J\"\u0010;\u001a\u00020<2\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010=\u001a\u0004\u0018\u00010>2\u0006\u0010?\u001a\u00020\fH\u0016J\u0018\u0010@\u001a\u00020<2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010A\u001a\u00020\fH\u0016R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u001c\"\u0004\b \u0010\u001eR\u001a\u0010\r\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001c\"\u0004\b\"\u0010\u001eR\u001a\u0010\u000e\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001c\"\u0004\b$\u0010\u001eR\u001a\u0010\u0010\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u001c\"\u0004\b&\u0010\u001eR\u001a\u0010\u000f\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u001c\"\u0004\b(\u0010\u001eR\u001a\u0010\u0012\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u001c\"\u0004\b*\u0010\u001eR\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u001c\"\u0004\b,\u0010\u001eR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u001c\"\u0004\b.\u0010\u001eR\u001a\u0010\u0011\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u001c\"\u0004\b0\u0010\u001eR\"\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\"\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00102\"\u0004\b6\u00104¨\u0006C"}, d2 = {"Lcom/obric/capabilitykit/entity/memory/OrderFlightMemoryEntity;", "Lcom/obric/capabilitykit/entity/memory/MemoryEntity;", "Lcom/obric/capabilitykit/common/execution/urishare/IUriSharerEntity;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "id", "", "createTime", "", "modifyTime", "productType", "", "departureDate", "departurePlace", "destination", "departureTime", "landingTime", "flightNumber", "landingDate", "departureAirport", "landingAirport", "boardingGate", "passengerName", "", "seatNumber", "(Ljava/lang/String;JJILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;)V", "getBoardingGate", "()Ljava/lang/String;", "setBoardingGate", "(Ljava/lang/String;)V", "getDepartureAirport", "setDepartureAirport", "getDepartureDate", "setDepartureDate", "getDeparturePlace", "setDeparturePlace", "getDepartureTime", "setDepartureTime", "getDestination", "setDestination", "getFlightNumber", "setFlightNumber", "getLandingAirport", "setLandingAirport", "getLandingDate", "setLandingDate", "getLandingTime", "setLandingTime", "getPassengerName", "()Ljava/util/List;", "setPassengerName", "(Ljava/util/List;)V", "getSeatNumber", "setSeatNumber", "convertToModelInput", "Lorg/json/JSONObject;", "getSharedUris", "Landroid/net/Uri;", "onReadSubClassExtensionField", "", "currentClassLoader", "Ljava/lang/ClassLoader;", "version", "writeToParcel", "flags", "CREATOR", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class OrderFlightMemoryEntity extends MemoryEntity implements IUriSharerEntity {

    @NotNull
    public static final CREATOR CREATOR = null;
    private static final int FIELD_VERSION = 0;
    private static final int RELATED_VERSION = 0;

    @Nullable
    private String boardingGate;

    @Nullable
    private String departureAirport;

    @NotNull
    private String departureDate;

    @NotNull
    private String departurePlace;

    @NotNull
    private String departureTime;

    @NotNull
    private String destination;

    @NotNull
    private String flightNumber;

    @Nullable
    private String landingAirport;

    @Nullable
    private String landingDate;

    @NotNull
    private String landingTime;

    @Nullable
    private List<String> passengerName;

    @Nullable
    private List<String> seatNumber;

    @Keep
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\b\u0087\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\tH\u0016J\u0006\u0010\n\u001a\u00020\u0005J\u001d\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\f2\u0006\u0010\r\u001a\u00020\u0005H\u0016¢\u0006\u0002\u0010\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/obric/capabilitykit/entity/memory/OrderFlightMemoryEntity$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/obric/capabilitykit/entity/memory/OrderFlightMemoryEntity;", "()V", "FIELD_VERSION", "", "RELATED_VERSION", "createFromParcel", "parcel", "Landroid/os/Parcel;", "getVersion", "newArray", "", "size", "(I)[Lcom/obric/capabilitykit/entity/memory/OrderFlightMemoryEntity;", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class CREATOR implements Parcelable.Creator<OrderFlightMemoryEntity> {
        private CREATOR() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public OrderFlightMemoryEntity createFromParcel(@NotNull Parcel r10) {
            q.g(r10, "parcel");
            AppEntity r11 = AppEntity.CREATOR.createFromParcel(r10);
            q.e(r11, "null cannot be cast to non-null type com.obric.capabilitykit.entity.memory.OrderFlightMemoryEntity");
            return (OrderFlightMemoryEntity) r11;
        }

        public final int getVersion() {
            return 0;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public OrderFlightMemoryEntity[] newArray(int r10) {
            return new OrderFlightMemoryEntity[r10];
        }

        public /* synthetic */ CREATOR(DefaultConstructorMarker r10) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ OrderFlightMemoryEntity createFromParcel(Parcel r10) {
            return createFromParcel(r10);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ OrderFlightMemoryEntity[] newArray(int r10) {
            return newArray(r10);
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public OrderFlightMemoryEntity(@NotNull Parcel r21) {
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
        r10.put("departureTime", makeModelInputValue("起飞时间", this.departureTime));
        r10.put("landingTime", makeModelInputValue("落地时间", this.landingTime));
        r10.put("flightNumber", makeModelInputValue("航班号", this.flightNumber));
        String r11 = this.landingDate;
        if (r11 == null) goto L5;
        q.d(r11);
        r10.put("landingDate", makeModelInputValue("落地日期", r11));
    L5:
        String r12 = this.departureAirport;
        if (r12 == null) goto L8;
        q.d(r12);
        r10.put("departureAirport", makeModelInputValue("起飞机场", r12));
    L8:
        String r13 = this.landingAirport;
        if (r13 == null) goto L11;
        q.d(r13);
        r10.put("landingAirport", makeModelInputValue("落地机场", r13));
    L11:
        String r14 = this.boardingGate;
        if (r14 == null) goto L14;
        q.d(r14);
        r10.put("boardingGate", makeModelInputValue("登机口", r14));
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
    public final String getBoardingGate() {
        return this.boardingGate;
    }

    @Nullable
    public final String getDepartureAirport() {
        return this.departureAirport;
    }

    @NotNull
    public final String getDepartureDate() {
        return this.departureDate;
    }

    @NotNull
    public final String getDeparturePlace() {
        return this.departurePlace;
    }

    @NotNull
    public final String getDepartureTime() {
        return this.departureTime;
    }

    @NotNull
    public final String getDestination() {
        return this.destination;
    }

    @NotNull
    public final String getFlightNumber() {
        return this.flightNumber;
    }

    @Nullable
    public final String getLandingAirport() {
        return this.landingAirport;
    }

    @Nullable
    public final String getLandingDate() {
        return this.landingDate;
    }

    @NotNull
    public final String getLandingTime() {
        return this.landingTime;
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

    @Override // com.obric.capabilitykit.entity.app.AppEntity
    public void onReadSubClassExtensionField(@NotNull Parcel r10, @Nullable ClassLoader r11, int r12) {
        q.g(r10, "parcel");
    }

    public final void setBoardingGate(@Nullable String r10) {
        this.boardingGate = r10;
    }

    public final void setDepartureAirport(@Nullable String r10) {
        this.departureAirport = r10;
    }

    public final void setDepartureDate(@NotNull String r10) {
        q.g(r10, "<set-?>");
        this.departureDate = r10;
    }

    public final void setDeparturePlace(@NotNull String r10) {
        q.g(r10, "<set-?>");
        this.departurePlace = r10;
    }

    public final void setDepartureTime(@NotNull String r10) {
        q.g(r10, "<set-?>");
        this.departureTime = r10;
    }

    public final void setDestination(@NotNull String r10) {
        q.g(r10, "<set-?>");
        this.destination = r10;
    }

    public final void setFlightNumber(@NotNull String r10) {
        q.g(r10, "<set-?>");
        this.flightNumber = r10;
    }

    public final void setLandingAirport(@Nullable String r10) {
        this.landingAirport = r10;
    }

    public final void setLandingDate(@Nullable String r10) {
        this.landingDate = r10;
    }

    public final void setLandingTime(@NotNull String r10) {
        q.g(r10, "<set-?>");
        this.landingTime = r10;
    }

    public final void setPassengerName(@Nullable List<String> r10) {
        this.passengerName = r10;
    }

    public final void setSeatNumber(@Nullable List<String> r10) {
        this.seatNumber = r10;
    }

    @Override // com.obric.capabilitykit.entity.memory.MemoryEntity, com.obric.capabilitykit.entity.app.AppEntity, android.os.Parcelable
    public void writeToParcel(@NotNull Parcel r10, int r11) {
        q.g(r10, "parcel");
        writeMemoryBaseFieldToParcel$capabilitykitcommon_release(r10);
        r10.writeString(this.departureDate);
        r10.writeString(this.departurePlace);
        r10.writeString(this.destination);
        r10.writeString(this.departureTime);
        r10.writeString(this.landingTime);
        r10.writeString(this.flightNumber);
        r10.writeString(this.landingDate);
        r10.writeString(this.departureAirport);
        r10.writeString(this.landingAirport);
        r10.writeString(this.boardingGate);
        r10.writeStringList(this.passengerName);
        r10.writeStringList(this.seatNumber);
        writeMemoryExtensionFieldToParcel$capabilitykitcommon_release(r10, r11);
        r10.writeInt(0);
    }

    public OrderFlightMemoryEntity(@NotNull String r16, long r17, long r19, int r21, @NotNull String r22, @NotNull String r23, @NotNull String r24, @NotNull String r25, @NotNull String r26, @NotNull String r27, @Nullable String r28, @Nullable String r29, @Nullable String r30, @Nullable String r31, @Nullable List<String> r32, @Nullable List<String> r33) {
        q.g(r16, "id");
        q.g(r22, "departureDate");
        q.g(r23, "departurePlace");
        q.g(r24, "destination");
        q.g(r25, "departureTime");
        q.g(r26, "landingTime");
        q.g(r27, "flightNumber");
        super(r16, r17, r19, 10001, r21);
        this.departureDate = r22;
        this.departurePlace = r23;
        this.destination = r24;
        this.departureTime = r25;
        this.landingTime = r26;
        this.flightNumber = r27;
        this.landingDate = r28;
        this.departureAirport = r29;
        this.landingAirport = r30;
        this.boardingGate = r31;
        this.passengerName = r32;
        this.seatNumber = r33;
    }

    public /* synthetic */ OrderFlightMemoryEntity(String r23, long r24, long r26, int r28, String r29, String r30, String r31, String r32, String r33, String r34, String r35, String r36, String r37, String r38, List r39, List r40, int r41, DefaultConstructorMarker r42) {
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
