package com.bytedance.android.live.liveinteract.plantform.model;

import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\b\u0087\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B+\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u001b\u0010\u001cJ\u000b\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\n\u001a\u00020\u00002\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\t\u0010\u000b\u001a\u00020\u0003HÖ\u0001J\t\u0010\r\u001a\u00020\fHÖ\u0001J\u0013\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003R$\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\b\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\b\u0010\u0012\u001a\u0004\b\u0017\u0010\u0014\"\u0004\b\u0018\u0010\u0016R$\u0010\t\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0012\u001a\u0004\b\u0019\u0010\u0014\"\u0004\b\u001a\u0010\u0016¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/model/LinkmicStreamInfo;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/liveinteract/plantform/model/r;", "", "component1", "component2", "component3", "liveCoreExtInfo", "rtcExtInfo", "bizTag", "copy", "toString", "", "hashCode", "", "other", "", "equals", "Ljava/lang/String;", "getLiveCoreExtInfo", "()Ljava/lang/String;", "setLiveCoreExtInfo", "(Ljava/lang/String;)V", "getRtcExtInfo", "setRtcExtInfo", "getBizTag", "setBizTag", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class LinkmicStreamInfo extends FlexModelBase<r> implements r, vh7.h {

    @SerializedName("biz_tag")
    protected String bizTag;

    @SerializedName("live_core_ext_info")
    protected String liveCoreExtInfo;

    @SerializedName("rtc_ext_info")
    protected String rtcExtInfo;

    public LinkmicStreamInfo(String r100, String r101, String r102) {
        super(r.class);
        this.liveCoreExtInfo = r100;
        this.rtcExtInfo = r101;
        this.bizTag = r102;
    }

    public static /* synthetic */ LinkmicStreamInfo copy$default(LinkmicStreamInfo r100, String r101, String r102, String r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.getLiveCoreExtInfo();
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.getRtcExtInfo();
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.getBizTag();
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final String component1() {
        return getLiveCoreExtInfo();
    }

    public final String component2() {
        return getRtcExtInfo();
    }

    public final String component3() {
        return getBizTag();
    }

    public final LinkmicStreamInfo copy(String r100, String r101, String r102) {
        return new LinkmicStreamInfo(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof LinkmicStreamInfo) == false) goto L12;
        LinkmicStreamInfo r101 = (LinkmicStreamInfo) r100;
        if (Intrinsics.areEqual(getLiveCoreExtInfo(), r101.getLiveCoreExtInfo()) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(getRtcExtInfo(), r101.getRtcExtInfo()) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(getBizTag(), r101.getBizTag()) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public int hashCode() {
        String r100 = getLiveCoreExtInfo();
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = getRtcExtInfo();
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = getBizTag();
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        return r106 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "LinkmicStreamInfo(liveCoreExtInfo=" + getLiveCoreExtInfo() + ", rtcExtInfo=" + getRtcExtInfo() + ", bizTag=" + getBizTag() + ")";
    }

    public LinkmicStreamInfo() {
        super(r.class);
        this.liveCoreExtInfo = "";
        this.rtcExtInfo = "";
        this.bizTag = "";
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.r
    public String getBizTag() {
        return this.bizTag;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.r
    public String getLiveCoreExtInfo() {
        return this.liveCoreExtInfo;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.r
    public String getRtcExtInfo() {
        return this.rtcExtInfo;
    }

    public LinkmicStreamInfo(am3.g r100) {
        super(r.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        am3.g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this.liveCoreExtInfo = am3.h.c(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.rtcExtInfo = am3.h.c(r100);
        goto L3
    L10:
        if (r102 != 3) goto L11;
        this.bizTag = am3.h.c(r100);
        goto L3
    L11:
        am3.h.d(r103, r100);
        goto L3
    L15:
        r100.d(r101);
        setThreadSafe(true);
        if (this.liveCoreExtInfo != null) goto L19;
        this.liveCoreExtInfo = "";
    L19:
        if (this.rtcExtInfo != null) goto L22;
        this.rtcExtInfo = "";
    L22:
        if (this.bizTag != null) goto L37;
        this.bizTag = "";
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.r
    public void setBizTag(String r100) {
        this.bizTag = r100;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.r
    public void setLiveCoreExtInfo(String r100) {
        this.liveCoreExtInfo = r100;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.r
    public void setRtcExtInfo(String r100) {
        this.rtcExtInfo = r100;
    }

    public /* synthetic */ LinkmicStreamInfo(String r100, String r101, String r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = "";
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = "";
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = "";
    L11:
        this(r100, r101, r102);
    }
}
