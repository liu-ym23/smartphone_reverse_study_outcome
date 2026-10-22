package com.bytedance.android.live.base.model.dynamic;

import com.bytedance.android.livesdkapi.performance.ILoadStallMonitor;
import com.bytedance.android.tools.pbadapter.annotation.IgnoreProtoFieldCheck;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes45.dex */
@IgnoreProtoFieldCheck
@ProtoMessage("webcast.api.moment.HistoryPrecipitationDetail")
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\b\n\u0002\b\u000f\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b@\u0010AR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR$\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u0017\u001a\u00020\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0017\u0010\u0019\"\u0004\b\u001a\u0010\u001bR*\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R*\u0010$\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b$\u0010\u001f\u001a\u0004\b%\u0010!\"\u0004\b&\u0010#R*\u0010'\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b'\u0010\u001f\u001a\u0004\b(\u0010!\"\u0004\b)\u0010#R\"\u0010*\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b*\u0010\u0004\u001a\u0004\b+\u0010\u0006\"\u0004\b,\u0010\bR*\u0010-\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b-\u0010\u001f\u001a\u0004\b.\u0010!\"\u0004\b/\u0010#R*\u00100\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b0\u0010\u001f\u001a\u0004\b1\u0010!\"\u0004\b2\u0010#R\"\u00104\u001a\u0002038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b4\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\"\u0010:\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b:\u0010\u0004\u001a\u0004\b;\u0010\u0006\"\u0004\b<\u0010\bR\"\u0010=\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b=\u0010\u0004\u001a\u0004\b>\u0010\u0006\"\u0004\b?\u0010\b¨\u0006B"}, d2 = {"Lcom/bytedance/android/live/base/model/dynamic/b;", "Lcom/bytedance/android/live/base/model/dynamic/c;", "", "startLiveTime", "J", "getStartLiveTime", "()J", "setStartLiveTime", "(J)V", "endLiveTime", "getEndLiveTime", "setEndLiveTime", "roomId", "getRoomId", "setRoomId", "", "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", com.alipay.sdk.m.x.d.f25925o, "(Ljava/lang/String;)V", "", "isHide", "Z", "()Z", "setHide", "(Z)V", "", "Lcom/bytedance/android/live/base/model/dynamic/g;", "momentList", "Ljava/util/List;", "getMomentList", "()Ljava/util/List;", "setMomentList", "(Ljava/util/List;)V", "recordList", "getRecordList", "setRecordList", "replayList", "getReplayList", "setReplayList", "totalUser", "getTotalUser", "setTotalUser", "unpublishMomentList", "getUnpublishMomentList", "setUnpublishMomentList", "unpublishReplayList", "getUnpublishReplayList", "setUnpublishReplayList", "", "type", "I", "getType", "()I", "setType", "(I)V", "foldCount", "getFoldCount", "setFoldCount", "foldMaxTime", "getFoldMaxTime", "setFoldMaxTime", "<init>", "()V", "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class b extends c implements h {

    @SerializedName("end_time")
    protected long endLiveTime;

    @SerializedName("fold_count")
    protected long foldCount;

    @SerializedName("fold_max_time")
    protected long foldMaxTime;

    @SerializedName("is_hide")
    protected boolean isHide;

    @SerializedName("moment_list")
    protected List<g> momentList;

    @SerializedName("record_list")
    protected List<g> recordList;

    @SerializedName("replay_list")
    protected List<g> replayList;

    @SerializedName("room_id")
    protected long roomId;

    @SerializedName(ILoadStallMonitor.START_TIME)
    protected long startLiveTime;

    @SerializedName("title")
    protected String title;

    @SerializedName("total_user")
    protected long totalUser;

    @SerializedName("type")
    protected int type;

    @SerializedName("unpublish_moment_list")
    protected List<g> unpublishMomentList;

    @SerializedName("unpublish_replay_list")
    protected List<g> unpublishReplayList;

    public b() {
    }

    public final int getType() {
        return this.type;
    }

    public b(am3.g r100) {
        this.momentList = new ArrayList();
        this.recordList = new ArrayList();
        this.replayList = new ArrayList();
        this.unpublishMomentList = new ArrayList();
        this.unpublishReplayList = new ArrayList();
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L22;
        switch(r102) {
            case 1: goto L21;
            case 2: goto L20;
            case 3: goto L19;
            case 4: goto L18;
            case 5: goto L17;
            case 6: goto L15;
            case 7: goto L14;
            case 8: goto L13;
            case 9: goto L12;
            case 10: goto L11;
            case 11: goto L10;
            case 12: goto L9;
            case 13: goto L8;
            case 14: goto L7;
            default: goto L6;
        };
    L7:
        this.foldMaxTime = r100.j();
        goto L3
    L8:
        this.foldCount = r100.j();
        goto L3
    L9:
        this.type = r100.i();
        goto L3
    L10:
        List<g> r103 = this.unpublishReplayList;
        g r104 = new g(r100);
    L16:
        r103.add(r104);
        goto L3
    L11:
        r103 = this.unpublishMomentList;
        r104 = new g(r100);
        goto L16
    L12:
        this.totalUser = r100.j();
        goto L3
    L13:
        r103 = this.replayList;
        r104 = new g(r100);
        goto L16
    L14:
        r103 = this.recordList;
        r104 = new g(r100);
        goto L16
    L15:
        r103 = this.momentList;
        r104 = new g(r100);
        goto L16
    L17:
        this.isHide = am3.h.a(r100);
        goto L3
    L18:
        this.title = am3.h.c(r100);
        goto L3
    L19:
        this.roomId = r100.j();
        goto L3
    L20:
        this.endLiveTime = r100.j();
        goto L3
    L21:
        this.startLiveTime = r100.j();
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L22:
        r100.d(r101);
    }
}
