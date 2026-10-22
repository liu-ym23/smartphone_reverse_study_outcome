package com.bytedance.android.livesdk.chatroom.model.interact;

import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\t\n\u0002\b\f\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b!\u0010\"R*\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR$\u0010\u000b\u001a\u0004\u0018\u00010\u00048\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0011\u001a\u0004\u0018\u00010\u00048\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R$\u0010\u0014\u001a\u0004\u0018\u00010\u00048\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\f\u001a\u0004\b\u0015\u0010\u000e\"\u0004\b\u0016\u0010\u0010R\"\u0010\u0018\u001a\u00020\u00178\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010\u001e\u001a\u00020\u00048\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\f\u001a\u0004\b\u001f\u0010\u000e\"\u0004\b \u0010\u0010¨\u0006#"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/interact/SelfDisciplineInfo;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/chatroom/model/interact/o1;", "", "", "targetList", "Ljava/util/List;", "getTargetList", "()Ljava/util/List;", "setTargetList", "(Ljava/util/List;)V", "currentTarget", "Ljava/lang/String;", "getCurrentTarget", "()Ljava/lang/String;", "setCurrentTarget", "(Ljava/lang/String;)V", "targetIconUri", "getTargetIconUri", "setTargetIconUri", "indicatorText", "getIndicatorText", "setIndicatorText", "", "punchDuration", "J", "getPunchDuration", "()J", "setPunchDuration", "(J)V", "roomPunchCount", "getRoomPunchCount", "setRoomPunchCount", "<init>", "()V", "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SelfDisciplineInfo extends FlexModelBase<o1> implements o1, vh7.h {

    @SerializedName("current_target")
    protected String currentTarget;

    @SerializedName("text")
    protected String indicatorText;

    @SerializedName("punch_duration")
    protected long punchDuration;

    @SerializedName("room_punch_count")
    protected String roomPunchCount;

    @SerializedName("target_icon_uri")
    protected String targetIconUri;

    @SerializedName("target_list")
    protected List<String> targetList;

    public SelfDisciplineInfo() {
        super(o1.class);
        this.punchDuration = 600;
        this.roomPunchCount = "";
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.interact.o1
    public String getCurrentTarget() {
        return this.currentTarget;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.interact.o1
    public String getIndicatorText() {
        return this.indicatorText;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.interact.o1
    public long getPunchDuration() {
        return this.punchDuration;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.interact.o1
    public String getRoomPunchCount() {
        return this.roomPunchCount;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.interact.o1
    public String getTargetIconUri() {
        return this.targetIconUri;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.interact.o1
    public List<String> getTargetList() {
        return this.targetList;
    }

    public SelfDisciplineInfo(am3.g r100) {
        super(o1.class);
        this.targetList = new ArrayList();
        boolean r101 = false;
        setThreadSafe(false);
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L24;
        am3.g.a r104 = decodeExtensionFields(r103, r100);
        if (r103 != 1) goto L8;
        this.targetList.add(am3.h.c(r100));
        goto L3
    L8:
        if (r103 != 2) goto L10;
        this.currentTarget = am3.h.c(r100);
        goto L3
    L10:
        if (r103 != 3) goto L12;
        this.targetIconUri = am3.h.c(r100);
        goto L3
    L12:
        if (r103 != 4) goto L14;
        this.indicatorText = am3.h.c(r100);
        goto L3
    L14:
        if (r103 != 6) goto L16;
        this.punchDuration = r100.j();
        r101 = r101 | true;
        goto L3
    L16:
        if (r103 != 7) goto L17;
        this.roomPunchCount = am3.h.c(r100);
        goto L3
    L17:
        am3.h.d(r104, r100);
        goto L3
    L24:
        r100.d(r102);
        setThreadSafe(true);
        if ((r101 & true) == true) goto L28;
        this.punchDuration = 600;
    L28:
        if (this.roomPunchCount != null) goto L52;
        this.roomPunchCount = "";
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.interact.o1
    public void setCurrentTarget(String r100) {
        this.currentTarget = r100;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.interact.o1
    public void setIndicatorText(String r100) {
        this.indicatorText = r100;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.interact.o1
    public void setPunchDuration(long r100) {
        this.punchDuration = r100;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.interact.o1
    public void setRoomPunchCount(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.roomPunchCount = r100;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.interact.o1
    public void setTargetIconUri(String r100) {
        this.targetIconUri = r100;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.interact.o1
    public void setTargetList(List<String> r100) {
        this.targetList = r100;
    }
}
