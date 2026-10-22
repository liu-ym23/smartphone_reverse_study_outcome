package com.bytedance.android.livesdkapi.depend.message.wrds;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import com.ss.android.dypay.api.DyPayConstant;
import com.tencent.qqmusic.third.api.contract.Keys;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.im.PreviewPromotionSyncData.LuckyMoney")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001BE\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\u0010\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0013J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\bHÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\nHÆ\u0003JN\u0010'\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u0010(J\u0013\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010,\u001a\u00020\bHÖ\u0001J\t\u0010-\u001a\u00020\nHÖ\u0001R\u001e\u0010\u0005\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0006\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u000fR\"\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000fR\u001e\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR \u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 ¨\u0006."}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/message/wrds/RedPacket;", "", "id", "", DyPayConstant.KEY_START_TIME, "delayTime", Keys.API_PARAM_KEY_SDK_EXPIRETIME, "status", "", "text", "", "(Ljava/lang/Long;JJJILjava/lang/String;)V", "getDelayTime", "()J", "setDelayTime", "(J)V", "getExpireTime", "setExpireTime", "getId", "()Ljava/lang/Long;", "setId", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getStartTime", "setStartTime", "getStatus", "()I", "setStatus", "(I)V", "getText", "()Ljava/lang/String;", "setText", "(Ljava/lang/String;)V", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/Long;JJJILjava/lang/String;)Lcom/bytedance/android/livesdkapi/depend/message/wrds/RedPacket;", "equals", "", "other", "hashCode", "toString", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RedPacket implements h {

    @SerializedName("delay_seconds")
    protected long delayTime;

    @SerializedName("display_end_at")
    protected long expireTime;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("box_id")
    protected Long f162574id;

    @SerializedName("start_at")
    protected long startTime;

    @SerializedName("status")
    protected int status;

    @SerializedName("text")
    protected String text;

    public RedPacket(Long r100, long r101, long r102, long r103, int r104, String r105) {
        this.f162574id = r100;
        this.startTime = r101;
        this.delayTime = r102;
        this.expireTime = r103;
        this.status = r104;
        this.text = r105;
    }

    public static /* synthetic */ RedPacket copy$default(RedPacket r110, Long r111, long r112, long r113, long r114, int r115, String r116, int r210, Object r211) {
        if ((r210 & 1) == 0) goto L5;
        Long r100 = r110.f162574id;
    L7:
        if ((r210 & 2) == 0) goto L9;
        long r101 = r110.startTime;
    L11:
        if ((r210 & 4) == 0) goto L13;
        long r102 = r110.delayTime;
    L15:
        if ((r210 & 8) == 0) goto L17;
        long r103 = r110.expireTime;
    L19:
        if ((r210 & 16) == 0) goto L21;
        int r104 = r110.status;
    L23:
        if ((r210 & 32) == 0) goto L25;
        String r105 = r110.text;
    L27:
        return r110.copy(r100, r101, r102, r103, r104, r105);
    L25:
        r105 = r116;
        goto L27
    L21:
        r104 = r115;
        goto L23
    L17:
        r103 = r114;
        goto L19
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public final Long component1() {
        return this.f162574id;
    }

    public final long component2() {
        return this.startTime;
    }

    public final long component3() {
        return this.delayTime;
    }

    public final long component4() {
        return this.expireTime;
    }

    public final int component5() {
        return this.status;
    }

    public final String component6() {
        return this.text;
    }

    public final RedPacket copy(Long r110, long r111, long r112, long r113, int r114, String r210) {
        return new RedPacket(r110, r111, r112, r113, r114, r210);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof RedPacket) == false) goto L18;
        RedPacket r101 = (RedPacket) r100;
        if (Intrinsics.areEqual(this.f162574id, r101.f162574id) == true) goto L8;
        return false;
    L8:
        if (this.startTime == r101.startTime) goto L10;
        return false;
    L10:
        if (this.delayTime == r101.delayTime) goto L12;
        return false;
    L12:
        if (this.expireTime == r101.expireTime) goto L14;
        return false;
    L14:
        if (this.status == r101.status) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.text, r101.text) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public int hashCode() {
        Long r100 = this.f162574id;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        long r103 = this.startTime;
        int r104 = ((r102 * 31) + ((int) (r103 ^ (r103 >>> 32)))) * 31;
        long r105 = this.delayTime;
        int r106 = (r104 + ((int) (r105 ^ (r105 >>> 32)))) * 31;
        long r107 = this.expireTime;
        int r108 = (((r106 + ((int) (r107 ^ (r107 >>> 32)))) * 31) + this.status) * 31;
        String r109 = this.text;
        if (r109 == null) goto L10;
        r101 = r109.hashCode();
    L10:
        return r108 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "RedPacket(id=" + this.f162574id + ", startTime=" + this.startTime + ", delayTime=" + this.delayTime + ", expireTime=" + this.expireTime + ", status=" + this.status + ", text=" + this.text + ")";
    }

    public RedPacket() {
        this.f162574id = 0L;
        this.startTime = 0;
        this.delayTime = 0;
        this.expireTime = 0;
        this.status = 0;
        this.text = "";
    }

    public final long getDelayTime() {
        return this.delayTime;
    }

    public final long getExpireTime() {
        return this.expireTime;
    }

    public final Long getId() {
        return this.f162574id;
    }

    public final long getStartTime() {
        return this.startTime;
    }

    public final int getStatus() {
        return this.status;
    }

    public final String getText() {
        return this.text;
    }

    public RedPacket(g r100) {
        long r101 = r100.c();
        int r102 = 0;
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L13;
        switch(r103) {
            case 1: goto L12;
            case 2: goto L11;
            case 3: goto L10;
            case 4: goto L9;
            case 5: goto L8;
            case 6: goto L7;
            default: goto L6;
        };
    L7:
        this.text = am3.h.c(r100);
        goto L3
    L8:
        this.status = (int) r100.j();
        r102 = r102 | 8;
        goto L3
    L9:
        this.expireTime = r100.j();
        r102 = r102 | 4;
        goto L3
    L10:
        this.delayTime = r100.j();
        r102 = r102 | 2;
        goto L3
    L11:
        this.startTime = r100.j();
        r102 = r102 | 1;
        goto L3
    L12:
        this.f162574id = Long.valueOf(r100.j());
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L13:
        r100.d(r101);
        if (this.f162574id != null) goto L17;
        this.f162574id = 0L;
    L17:
        if ((r102 & 1) != 0) goto L20;
        this.startTime = 0;
    L20:
        if ((r102 & 2) != 0) goto L23;
        this.delayTime = 0;
    L23:
        if ((r102 & 4) != 0) goto L26;
        this.expireTime = 0;
    L26:
        if ((r102 & 8) != 0) goto L29;
        this.status = 0;
    L29:
        if (this.text != null) goto L48;
        this.text = "";
        return;
    }

    public final void setDelayTime(long r100) {
        this.delayTime = r100;
    }

    public final void setExpireTime(long r100) {
        this.expireTime = r100;
    }

    public final void setId(Long r100) {
        this.f162574id = r100;
    }

    public final void setStartTime(long r100) {
        this.startTime = r100;
    }

    public final void setStatus(int r100) {
        this.status = r100;
    }

    public final void setText(String r100) {
        this.text = r100;
    }

    public /* synthetic */ RedPacket(Long r110, long r111, long r112, long r113, int r114, String r115, int r116, DefaultConstructorMarker r210) {
        long r100 = 0;
        if ((r116 & 1) == 0) goto L5;
        Long r101 = 0L;
    L7:
        if ((r116 & 2) == 0) goto L9;
        long r102 = 0;
    L11:
        if ((r116 & 4) == 0) goto L13;
        long r103 = 0;
    L15:
        if ((r116 & 8) != 0) goto L19;
        r100 = r113;
    L19:
        if ((r116 & 16) == 0) goto L21;
        int r104 = 0;
    L23:
        if ((r116 & 32) == 0) goto L25;
        String r105 = "";
    L26:
        this(r101, r102, r103, r100, r104, r105);
        return;
    L25:
        r105 = r115;
        goto L26
    L21:
        r104 = r114;
        goto L23
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }
}
