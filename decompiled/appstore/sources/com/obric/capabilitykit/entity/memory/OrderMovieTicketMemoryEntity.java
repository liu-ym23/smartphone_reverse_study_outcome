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
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 62\u00020\u00012\u00020\u0002:\u00016B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u007f\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u0007\u0012\u0006\u0010\u000f\u001a\u00020\u0007\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0015¢\u0006\u0002\u0010\u0016J\b\u0010+\u001a\u00020,H\u0016J\u000e\u0010-\u001a\b\u0012\u0004\u0012\u00020.0\u0015H\u0016J\"\u0010/\u001a\u0002002\u0006\u0010\u0003\u001a\u00020\u00042\b\u00101\u001a\u0004\u0018\u0001022\u0006\u00103\u001a\u00020\fH\u0016J\u0018\u00104\u001a\u0002002\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u00105\u001a\u00020\fH\u0016R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u000e\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0018\"\u0004\b\u001c\u0010\u001aR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0018\"\u0004\b\u001e\u0010\u001aR\u001a\u0010\r\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0018\"\u0004\b \u0010\u001aR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0018\"\u0004\b\"\u0010\u001aR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0018\"\u0004\b$\u0010\u001aR\"\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001a\u0010\u000f\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0018\"\u0004\b*\u0010\u001a¨\u00067"}, d2 = {"Lcom/obric/capabilitykit/entity/memory/OrderMovieTicketMemoryEntity;", "Lcom/obric/capabilitykit/entity/memory/MemoryEntity;", "Lcom/obric/capabilitykit/common/execution/urishare/IUriSharerEntity;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "id", "", "createTime", "", "modifyTime", "productType", "", "movieName", "movieDate", "startTime", "endTime", "movieTheaterName", "movieTheaterAddress", "movieHallNumber", "seatNumber", "", "(Ljava/lang/String;JJILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getEndTime", "()Ljava/lang/String;", "setEndTime", "(Ljava/lang/String;)V", "getMovieDate", "setMovieDate", "getMovieHallNumber", "setMovieHallNumber", "getMovieName", "setMovieName", "getMovieTheaterAddress", "setMovieTheaterAddress", "getMovieTheaterName", "setMovieTheaterName", "getSeatNumber", "()Ljava/util/List;", "setSeatNumber", "(Ljava/util/List;)V", "getStartTime", "setStartTime", "convertToModelInput", "Lorg/json/JSONObject;", "getSharedUris", "Landroid/net/Uri;", "onReadSubClassExtensionField", "", "currentClassLoader", "Ljava/lang/ClassLoader;", "version", "writeToParcel", "flags", "CREATOR", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class OrderMovieTicketMemoryEntity extends MemoryEntity implements IUriSharerEntity {

    @NotNull
    public static final CREATOR CREATOR = null;
    private static final int FIELD_VERSION = 0;
    private static final int RELATED_VERSION = 0;

    @Nullable
    private String endTime;

    @NotNull
    private String movieDate;

    @Nullable
    private String movieHallNumber;

    @NotNull
    private String movieName;

    @Nullable
    private String movieTheaterAddress;

    @Nullable
    private String movieTheaterName;

    @Nullable
    private List<String> seatNumber;

    @NotNull
    private String startTime;

    @Keep
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\b\u0087\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\tH\u0016J\u0006\u0010\n\u001a\u00020\u0005J\u001d\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\f2\u0006\u0010\r\u001a\u00020\u0005H\u0016¢\u0006\u0002\u0010\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/obric/capabilitykit/entity/memory/OrderMovieTicketMemoryEntity$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/obric/capabilitykit/entity/memory/OrderMovieTicketMemoryEntity;", "()V", "FIELD_VERSION", "", "RELATED_VERSION", "createFromParcel", "parcel", "Landroid/os/Parcel;", "getVersion", "newArray", "", "size", "(I)[Lcom/obric/capabilitykit/entity/memory/OrderMovieTicketMemoryEntity;", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class CREATOR implements Parcelable.Creator<OrderMovieTicketMemoryEntity> {
        private CREATOR() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public OrderMovieTicketMemoryEntity createFromParcel(@NotNull Parcel r10) {
            q.g(r10, "parcel");
            AppEntity r11 = AppEntity.CREATOR.createFromParcel(r10);
            q.e(r11, "null cannot be cast to non-null type com.obric.capabilitykit.entity.memory.OrderMovieTicketMemoryEntity");
            return (OrderMovieTicketMemoryEntity) r11;
        }

        public final int getVersion() {
            return 0;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public OrderMovieTicketMemoryEntity[] newArray(int r10) {
            return new OrderMovieTicketMemoryEntity[r10];
        }

        public /* synthetic */ CREATOR(DefaultConstructorMarker r10) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ OrderMovieTicketMemoryEntity createFromParcel(Parcel r10) {
            return createFromParcel(r10);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ OrderMovieTicketMemoryEntity[] newArray(int r10) {
            return newArray(r10);
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public OrderMovieTicketMemoryEntity(@NotNull Parcel r18) {
        q.g(r18, "parcel");
        this(EntityExtKt.f(r18), r18.readLong(), r18.readLong(), r18.readInt(), EntityExtKt.f(r18), EntityExtKt.f(r18), EntityExtKt.f(r18), r18.readString(), r18.readString(), r18.readString(), r18.readString(), r18.createStringArrayList());
        readMemoryExtensionFieldFromParcel$capabilitykitcommon_release(r18);
        readSubClassExtensionFieldFromParcel$capabilitykitcommon_release(r18, 0, r18.readInt());
    }

    @Override // com.obric.capabilitykit.entity.memory.MemoryEntity
    @NotNull
    public JSONObject convertToModelInput() {
        JSONObject r10 = new JSONObject();
        r10.put("type", getType());
        r10.put("createTime", getCreateTime());
        r10.put("modifyTime", getLastModifiedTime());
        r10.put("ecaId", getEcaId());
        r10.put("movieName", makeModelInputValue("电影名称", this.movieName));
        r10.put("movieDate", makeModelInputValue("观影日期", this.movieDate));
        r10.put("startTime", makeModelInputValue("开场时间", this.startTime));
        String r11 = this.endTime;
        if (r11 == null) goto L5;
        q.d(r11);
        r10.put("endTime", makeModelInputValue("结束时间", r11));
    L5:
        String r12 = this.movieTheaterName;
        if (r12 == null) goto L8;
        q.d(r12);
        r10.put("movieTheaterName", makeModelInputValue("电影院名称", r12));
    L8:
        String r13 = this.movieTheaterAddress;
        if (r13 == null) goto L11;
        q.d(r13);
        r10.put("movieTheaterAddress", makeModelInputValue("电影院地址", r13));
    L11:
        String r14 = this.movieHallNumber;
        if (r14 == null) goto L14;
        q.d(r14);
        r10.put("movieHallNumber", makeModelInputValue("电影厅号", r14));
    L14:
        List<String> r15 = this.seatNumber;
        if (r15 == null) goto L17;
        r10.put("seatNumber", makeModelInputValue("座位号", String.valueOf(r15)));
    L17:
        return r10;
    }

    @Nullable
    public final String getEndTime() {
        return this.endTime;
    }

    @NotNull
    public final String getMovieDate() {
        return this.movieDate;
    }

    @Nullable
    public final String getMovieHallNumber() {
        return this.movieHallNumber;
    }

    @NotNull
    public final String getMovieName() {
        return this.movieName;
    }

    @Nullable
    public final String getMovieTheaterAddress() {
        return this.movieTheaterAddress;
    }

    @Nullable
    public final String getMovieTheaterName() {
        return this.movieTheaterName;
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

    public final void setEndTime(@Nullable String r10) {
        this.endTime = r10;
    }

    public final void setMovieDate(@NotNull String r10) {
        q.g(r10, "<set-?>");
        this.movieDate = r10;
    }

    public final void setMovieHallNumber(@Nullable String r10) {
        this.movieHallNumber = r10;
    }

    public final void setMovieName(@NotNull String r10) {
        q.g(r10, "<set-?>");
        this.movieName = r10;
    }

    public final void setMovieTheaterAddress(@Nullable String r10) {
        this.movieTheaterAddress = r10;
    }

    public final void setMovieTheaterName(@Nullable String r10) {
        this.movieTheaterName = r10;
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
        r10.writeString(this.movieName);
        r10.writeString(this.movieDate);
        r10.writeString(this.startTime);
        r10.writeString(this.endTime);
        r10.writeString(this.movieTheaterName);
        r10.writeString(this.movieTheaterAddress);
        r10.writeString(this.movieHallNumber);
        r10.writeStringList(this.seatNumber);
        writeMemoryExtensionFieldToParcel$capabilitykitcommon_release(r10, r11);
        r10.writeInt(0);
    }

    public OrderMovieTicketMemoryEntity(@NotNull String r13, long r14, long r16, int r18, @NotNull String r19, @NotNull String r20, @NotNull String r21, @Nullable String r22, @Nullable String r23, @Nullable String r24, @Nullable String r25, @Nullable List<String> r26) {
        q.g(r13, "id");
        q.g(r19, "movieName");
        q.g(r20, "movieDate");
        q.g(r21, "startTime");
        super(r13, r14, r16, 10003, r18);
        this.movieName = r19;
        this.movieDate = r20;
        this.startTime = r21;
        this.endTime = r22;
        this.movieTheaterName = r23;
        this.movieTheaterAddress = r24;
        this.movieHallNumber = r25;
        this.seatNumber = r26;
    }

    public /* synthetic */ OrderMovieTicketMemoryEntity(String r19, long r20, long r22, int r24, String r25, String r26, String r27, String r28, String r29, String r30, String r31, List r32, int r33, DefaultConstructorMarker r34) {
        if ((r33 & 128) == 0) goto L5;
        String r13 = null;
    L7:
        if ((r33 & 256) == 0) goto L9;
        String r14 = null;
    L11:
        if ((r33 & 512) == 0) goto L13;
        String r15 = null;
    L15:
        if ((r33 & 1024) == 0) goto L17;
        String r16 = null;
    L19:
        if ((r33 & 2048) == 0) goto L21;
        List r17 = null;
    L22:
        this(r19, r20, r22, r24, r25, r26, r27, r13, r14, r15, r16, r17);
        return;
    L21:
        r17 = r32;
        goto L22
    L17:
        r16 = r31;
        goto L19
    L13:
        r15 = r30;
        goto L15
    L9:
        r14 = r29;
        goto L11
    L5:
        r13 = r28;
        goto L7
    }
}
