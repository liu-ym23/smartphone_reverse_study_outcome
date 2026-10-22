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
public final class OrderMovieTicketMemoryEntity extends MemoryEntity implements IUriSharerEntity {
    public static final CREATOR CREATOR = null;
    private static final int FIELD_VERSION = 0;
    private static final int RELATED_VERSION = 0;
    private String endTime;
    private String movieDate;
    private String movieHallNumber;
    private String movieName;
    private String movieTheaterAddress;
    private String movieTheaterName;
    private List<String> seatNumber;
    private String startTime;

    public static final class CREATOR implements Parcelable.Creator<OrderMovieTicketMemoryEntity> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(h r1) {
            this();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public OrderMovieTicketMemoryEntity createFromParcel(Parcel r2) {
            o.e(r2, "parcel");
            AppEntity r1 = AppEntity.CREATOR.createFromParcel(r2);
            o.a(r1, "null cannot be cast to non-null type com.obric.capabilitykit.entity.memory.OrderMovieTicketMemoryEntity");
            return (OrderMovieTicketMemoryEntity) ZeusTransformUtils.preCheckCast(r1, OrderMovieTicketMemoryEntity.class, "com.obric.aiagent.plugin");
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ OrderMovieTicketMemoryEntity createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        public final int getVersion() {
            return 0;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public OrderMovieTicketMemoryEntity[] newArray(int r1) {
            return new OrderMovieTicketMemoryEntity[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ OrderMovieTicketMemoryEntity[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public OrderMovieTicketMemoryEntity(Parcel r18) {
        o.e(r18, "parcel");
        this(EntityExtKt.a(r18), r18.readLong(), r18.readLong(), r18.readInt(), EntityExtKt.a(r18), EntityExtKt.a(r18), EntityExtKt.a(r18), r18.readString(), r18.readString(), r18.readString(), r18.readString(), r18.createStringArrayList());
        readMemoryExtensionFieldFromParcel$capabilitykitcommon_release(r18);
        readSubClassExtensionFieldFromParcel$capabilitykitcommon_release(r18, 0, r18.readInt());
    }

    public OrderMovieTicketMemoryEntity(String r14, long r15, long r17, int r19, String r20, String r21, String r22, String r23, String r24, String r25, String r26, List<String> r27) {
        List<String> r12 = (List) ZeusTransformUtils.wrapperContextForParams(r27, List.class, "com.obric.aiagent.plugin");
        o.e(r14, DbHelper.COL_ID);
        o.e(r20, "movieName");
        o.e(r21, "movieDate");
        o.e(r22, "startTime");
        super(r14, r15, r17, 10003, r19);
        this.movieName = r20;
        this.movieDate = r21;
        this.startTime = r22;
        this.endTime = r23;
        this.movieTheaterName = r24;
        this.movieTheaterAddress = r25;
        this.movieHallNumber = r26;
        this.seatNumber = r12;
    }

    public /* synthetic */ OrderMovieTicketMemoryEntity(String r20, long r21, long r23, int r25, String r26, String r27, String r28, String r29, String r30, String r31, String r32, List r33, int r34, h r35) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r33, List.class, "com.obric.aiagent.plugin");
        if ((r34 & 128) == 0) goto L5;
        String r14 = null;
    L7:
        if ((r34 & 256) == 0) goto L9;
        String r15 = null;
    L11:
        if ((r34 & 512) == 0) goto L13;
        String r16 = null;
    L15:
        if ((r34 & 1024) == 0) goto L17;
        String r17 = null;
    L19:
        if ((r34 & 2048) == 0) goto L21;
        List r18 = null;
    L22:
        this(r20, r21, r23, r25, r26, r27, r28, r14, r15, r16, r17, r18);
        return;
    L21:
        r18 = r1;
        goto L22
    L17:
        r17 = r32;
        goto L19
    L13:
        r16 = r31;
        goto L15
    L9:
        r15 = r30;
        goto L11
    L5:
        r14 = r29;
        goto L7
    }

    @Override // com.obric.capabilitykit.entity.memory.MemoryEntity
    public JSONObject convertToModelInput() {
        JSONObject r0 = new JSONObject();
        r0.put("type", getType());
        r0.put("createTime", getCreateTime());
        r0.put("modifyTime", getLastModifiedTime());
        r0.put("ecaId", getEcaId());
        r0.put("movieName", makeModelInputValue("电影名称", this.movieName));
        r0.put("movieDate", makeModelInputValue("观影日期", this.movieDate));
        r0.put("startTime", makeModelInputValue("开场时间", this.startTime));
        String r1 = this.endTime;
        if (r1 == null) goto L5;
        o.a(r1);
        r0.put("endTime", makeModelInputValue("结束时间", r1));
    L5:
        String r2 = this.movieTheaterName;
        if (r2 == null) goto L8;
        o.a(r2);
        r0.put("movieTheaterName", makeModelInputValue("电影院名称", r2));
    L8:
        String r3 = this.movieTheaterAddress;
        if (r3 == null) goto L11;
        o.a(r3);
        r0.put("movieTheaterAddress", makeModelInputValue("电影院地址", r3));
    L11:
        String r4 = this.movieHallNumber;
        if (r4 == null) goto L14;
        o.a(r4);
        r0.put("movieHallNumber", makeModelInputValue("电影厅号", r4));
    L14:
        List<String> r5 = this.seatNumber;
        if (r5 == null) goto L17;
        r0.put("seatNumber", makeModelInputValue("座位号", String.valueOf(r5)));
    L17:
        return r0;
    }

    public final String getEndTime() {
        return this.endTime;
    }

    public final String getMovieDate() {
        return this.movieDate;
    }

    public final String getMovieHallNumber() {
        return this.movieHallNumber;
    }

    public final String getMovieName() {
        return this.movieName;
    }

    public final String getMovieTheaterAddress() {
        return this.movieTheaterAddress;
    }

    public final String getMovieTheaterName() {
        return this.movieTheaterName;
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

    public final String getStartTime() {
        return this.startTime;
    }

    @Override // com.obric.capabilitykit.entity.app.AppEntity
    public void onReadSubClassExtensionField(Parcel r1, ClassLoader r2, int r3) {
        o.e(r1, "parcel");
    }

    public final void setEndTime(String r1) {
        this.endTime = r1;
    }

    public final void setMovieDate(String r2) {
        o.e(r2, "<set-?>");
        this.movieDate = r2;
    }

    public final void setMovieHallNumber(String r1) {
        this.movieHallNumber = r1;
    }

    public final void setMovieName(String r2) {
        o.e(r2, "<set-?>");
        this.movieName = r2;
    }

    public final void setMovieTheaterAddress(String r1) {
        this.movieTheaterAddress = r1;
    }

    public final void setMovieTheaterName(String r1) {
        this.movieTheaterName = r1;
    }

    public final void setSeatNumber(List<String> r3) {
        this.seatNumber = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
    }

    public final void setStartTime(String r2) {
        o.e(r2, "<set-?>");
        this.startTime = r2;
    }

    @Override // com.obric.capabilitykit.entity.memory.MemoryEntity, com.obric.capabilitykit.entity.app.AppEntity, android.os.Parcelable
    public void writeToParcel(Parcel r2, int r3) {
        o.e(r2, "parcel");
        writeMemoryBaseFieldToParcel$capabilitykitcommon_release(r2);
        r2.writeString(this.movieName);
        r2.writeString(this.movieDate);
        r2.writeString(this.startTime);
        r2.writeString(this.endTime);
        r2.writeString(this.movieTheaterName);
        r2.writeString(this.movieTheaterAddress);
        r2.writeString(this.movieHallNumber);
        r2.writeStringList(this.seatNumber);
        writeMemoryExtensionFieldToParcel$capabilitykitcommon_release(r2, r3);
        r2.writeInt(0);
    }
}
