package com.bytedance.android.livesdkapi.depend.model.live.linker;

import am3.g;
import com.bytedance.android.live.base.model.user.o0;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import r27.a;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.im.LinkerKickOutContent")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\t\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002:\u0002,-B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010+\u001a\u00020\u0017H\u0016R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001e\u0010\r\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u001e\u0010\u0010\u001a\u00020\u00118\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0016\u001a\u00020\u00178F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R \u0010\u001a\u001a\u0004\u0018\u00010\u00178\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0019\"\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001e\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0007R\u0014\u0010 \u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\u0007R\u0014\u0010\"\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b#\u0010\u0007R\"\u0010$\u001a\u0004\u0018\u00010%8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010*\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)¨\u0006."}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/linker/LinkerKickOutContent;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ILinkerKickOutContent;", "()V", "_kickOutSource", "", "get_kickOutSource", "()I", "set_kickOutSource", "(I)V", "_link_duration", "get_link_duration", "set_link_duration", "_paid_count", "get_paid_count", "set_paid_count", "fromUserId", "", "getFromUserId", "()J", "setFromUserId", "(J)V", "fromUserIdString", "", "getFromUserIdString", "()Ljava/lang/String;", "fromUserOpenId", "getFromUserOpenId", "setFromUserOpenId", "(Ljava/lang/String;)V", "kickOutSource", "getKickOutSource", "link_duration", "getLink_duration", "paid_count", "getPaid_count", "switchToSilence", "", "getSwitchToSilence", "()Ljava/lang/Boolean;", "setSwitchToSilence", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "toString", "KickOutSource", "LinkmicActionSource", "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LinkerKickOutContent extends FlexModelBase<ILinkerKickOutContent> implements ILinkerKickOutContent, h {

    @SerializedName("kick_out_source")
    protected int _kickOutSource;

    @SerializedName("link_duration")
    protected int _link_duration;

    @SerializedName("paid_count")
    protected int _paid_count;

    @SerializedName("from_user_id")
    protected long fromUserId;

    @SerializedName("from_open_id")
    protected String fromUserOpenId;

    @SerializedName("switch_to_silence")
    protected Boolean switchToSilence;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/linker/LinkerKickOutContent$KickOutSource;", "", "(Ljava/lang/String;I)V", "Unknown", "FromOrganizer", "General", "RTCLeave", "RTCUnLink", "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum KickOutSource extends Enum<KickOutSource> {
        private static final /* synthetic */ KickOutSource[] $VALUES = null;
        public static final KickOutSource FromOrganizer = null;
        public static final KickOutSource General = null;
        public static final KickOutSource RTCLeave = null;
        public static final KickOutSource RTCUnLink = null;
        public static final KickOutSource Unknown = null;

        static {
            KickOutSource r100 = new KickOutSource("Unknown", 0);
            Unknown = r100;
            KickOutSource r101 = new KickOutSource("FromOrganizer", 1);
            FromOrganizer = r101;
            KickOutSource r102 = new KickOutSource("General", 2);
            General = r102;
            KickOutSource r103 = new KickOutSource("RTCLeave", 3);
            RTCLeave = r103;
            KickOutSource r104 = new KickOutSource("RTCUnLink", 4);
            RTCUnLink = r104;
            $VALUES = new KickOutSource[]{r100, r101, r102, r103, r104};
        }

        public static KickOutSource valueOf(String r100) {
            return (KickOutSource) a.a(KickOutSource.class, r100);
        }

        public static KickOutSource[] values() {
            return (KickOutSource[]) $VALUES.clone();
        }

        private KickOutSource(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/linker/LinkerKickOutContent$LinkmicActionSource;", "", "(Ljava/lang/String;I)V", "ActionSourceUndefined", "ActionSourceOrigin", "ActionSourceGamePannel", "ActionSourceRoomBattleUnselected", "ActionSourceSmallWindowToPKKicked", "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum LinkmicActionSource extends Enum<LinkmicActionSource> {
        private static final /* synthetic */ LinkmicActionSource[] $VALUES = null;
        public static final LinkmicActionSource ActionSourceGamePannel = null;
        public static final LinkmicActionSource ActionSourceOrigin = null;
        public static final LinkmicActionSource ActionSourceRoomBattleUnselected = null;
        public static final LinkmicActionSource ActionSourceSmallWindowToPKKicked = null;
        public static final LinkmicActionSource ActionSourceUndefined = null;

        static {
            LinkmicActionSource r100 = new LinkmicActionSource("ActionSourceUndefined", 0);
            ActionSourceUndefined = r100;
            LinkmicActionSource r101 = new LinkmicActionSource("ActionSourceOrigin", 1);
            ActionSourceOrigin = r101;
            LinkmicActionSource r102 = new LinkmicActionSource("ActionSourceGamePannel", 2);
            ActionSourceGamePannel = r102;
            LinkmicActionSource r103 = new LinkmicActionSource("ActionSourceRoomBattleUnselected", 3);
            ActionSourceRoomBattleUnselected = r103;
            LinkmicActionSource r104 = new LinkmicActionSource("ActionSourceSmallWindowToPKKicked", 4);
            ActionSourceSmallWindowToPKKicked = r104;
            $VALUES = new LinkmicActionSource[]{r100, r101, r102, r103, r104};
        }

        public static LinkmicActionSource valueOf(String r100) {
            return (LinkmicActionSource) a.a(LinkmicActionSource.class, r100);
        }

        public static LinkmicActionSource[] values() {
            return (LinkmicActionSource[]) $VALUES.clone();
        }

        private LinkmicActionSource(String r100, int r101) {
            super(r100, r101);
        }
    }

    public LinkerKickOutContent() {
        super(ILinkerKickOutContent.class);
    }

    public final String getFromUserIdString() {
        o0.a r100 = o0.f58946a;
        Long r101 = Long.valueOf(getFromUserId());
        String r102 = getFromUserOpenId();
        r100.getClass();
        return o0.a.g(r101, r102);
    }

    public String toString() {
        return "LinkerKickOutContent{fromUserId=" + getFromUserId() + ", paid_count=" + getPaid_count() + ", link_duration=" + getLink_duration() + ", kickOutSource=" + getKickOutSource() + '}';
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerKickOutContent
    public long getFromUserId() {
        return this.fromUserId;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerKickOutContent
    public String getFromUserOpenId() {
        return this.fromUserOpenId;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerKickOutContent
    public int getKickOutSource() {
        return this._kickOutSource;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerKickOutContent
    public int getLink_duration() {
        return this._link_duration;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerKickOutContent
    public int getPaid_count() {
        return this._paid_count;
    }

    public final Boolean getSwitchToSilence() {
        return this.switchToSilence;
    }

    public final int get_kickOutSource() {
        return this._kickOutSource;
    }

    public final int get_link_duration() {
        return this._link_duration;
    }

    public final int get_paid_count() {
        return this._paid_count;
    }

    public LinkerKickOutContent(g r100) {
        super(ILinkerKickOutContent.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L24;
        g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this.fromUserId = r100.j();
        goto L3
    L8:
        if (r102 != 5000) goto L10;
        this.fromUserOpenId = am3.h.c(r100);
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this._paid_count = (int) r100.j();
        goto L3
    L12:
        if (r102 != 4) goto L14;
        this._link_duration = (int) r100.j();
        goto L3
    L14:
        if (r102 != 5) goto L16;
        this._kickOutSource = r100.i();
        goto L3
    L16:
        if (r102 != 6) goto L17;
        this.switchToSilence = Boolean.valueOf(am3.h.a(r100));
        goto L3
    L17:
        am3.h.d(r103, r100);
        goto L3
    L24:
        r100.d(r101);
        setThreadSafe(true);
    }

    public void setFromUserId(long r100) {
        this.fromUserId = r100;
    }

    public void setFromUserOpenId(String r100) {
        this.fromUserOpenId = r100;
    }

    public final void setSwitchToSilence(Boolean r100) {
        this.switchToSilence = r100;
    }

    public final void set_kickOutSource(int r100) {
        this._kickOutSource = r100;
    }

    public final void set_link_duration(int r100) {
        this._link_duration = r100;
    }

    public final void set_paid_count(int r100) {
        this._paid_count = r100;
    }
}
