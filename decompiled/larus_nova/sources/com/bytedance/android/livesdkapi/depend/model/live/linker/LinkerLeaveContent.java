package com.bytedance.android.livesdkapi.depend.model.live.linker;

import am3.g;
import com.alipay.sdk.m.u.i;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.base.model.user.o0;
import com.bytedance.android.live.liveinteract.multianchor.model.AnchorLinkUser;
import com.bytedance.android.live.liveinteract.plantform.model.RoomLinkerContent;
import com.bytedance.android.live.liveinteract.plantform.model.p1;
import com.bytedance.android.livesdk.link.model.bridge.k;
import com.bytedance.android.livesdkapi.depend.message.ClientUIInfo;
import com.bytedance.android.tools.pbadapter.annotation.IgnoreProtoFieldCheck;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.tencent.connect.common.Constants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import r27.a;
import vh7.f;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.im.LinkerLeaveContent")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0012\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\t\b\u0007\u0018\u0000 I2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002:\u0002IJB\u0007¢\u0006\u0004\bH\u0010\u0010J\b\u0010\u0004\u001a\u00020\u0003H\u0016R\"\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR(\u0010\f\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\b\f\u0010\u0007\u0012\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR*\u0010\u0011\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\b\u0011\u0010\u0012\u0012\u0004\b\u0017\u0010\u0010\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R*\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR*\u0010 \u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b \u0010\u001b\u001a\u0004\b!\u0010\u001d\"\u0004\b\"\u0010\u001fR0\u0010%\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020$\u0018\u00010#8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\"\u0010+\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b+\u0010\u0007\u001a\u0004\b,\u0010\t\"\u0004\b-\u0010\u000bR$\u0010/\u001a\u0004\u0018\u00010.8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u0014\u00106\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b5\u0010\u0014R\u0016\u00108\u001a\u0004\u0018\u00010\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b7\u0010\u0014R\u0018\u0010;\u001a\u00060\u0005j\u0002`98VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b:\u0010\tR(\u0010?\u001a\u0016\u0012\u0004\u0012\u00020<\u0018\u00010\u0018j\n\u0012\u0004\u0012\u00020<\u0018\u0001`=8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b>\u0010\u001dR\"\u0010A\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020$\u0018\u00010#8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b@\u0010(R\u0014\u0010E\u001a\u00020B8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bC\u0010DR(\u0010G\u001a\u0016\u0012\u0004\u0012\u00020<\u0018\u00010\u0018j\n\u0012\u0004\u0012\u00020<\u0018\u0001`=8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bF\u0010\u001d¨\u0006K"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/linker/LinkerLeaveContent;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ILinkerLeaveContentBridge;", "", "toString", "", "_version", "J", "get_version", "()J", "set_version", "(J)V", "mUserId", "getMUserId", "setMUserId", "getMUserId$annotations", "()V", "openUserId", "Ljava/lang/String;", "getOpenUserId", "()Ljava/lang/String;", "setOpenUserId", "(Ljava/lang/String;)V", "getOpenUserId$annotations", "", "Lcom/bytedance/android/live/liveinteract/multianchor/model/AnchorLinkUser;", "mLinkUsers", "Ljava/util/List;", "getMLinkUsers", "()Ljava/util/List;", "setMLinkUsers", "(Ljava/util/List;)V", "_preOnlineUsers", "get_preOnlineUsers", "set_preOnlineUsers", "", "Lcom/bytedance/android/live/liveinteract/plantform/model/RoomLinkerContent;", "_linkerContentMap", "Ljava/util/Map;", "get_linkerContentMap", "()Ljava/util/Map;", "set_linkerContentMap", "(Ljava/util/Map;)V", "_leaveSource", "get_leaveSource", "set_leaveSource", "Lcom/bytedance/android/livesdkapi/depend/message/ClientUIInfo;", "clientUIInfo", "Lcom/bytedance/android/livesdkapi/depend/message/ClientUIInfo;", "getClientUIInfo", "()Lcom/bytedance/android/livesdkapi/depend/message/ClientUIInfo;", "setClientUIInfo", "(Lcom/bytedance/android/livesdkapi/depend/message/ClientUIInfo;)V", "getUserIdStr", "userIdStr", "getUserId", "userId", "Lcom/bytedance/android/livesdkapi/depend/model/live/typedef/VersionNum;", "getVersion", "version", "Lcom/bytedance/android/livesdk/link/model/bridge/k;", "Lcom/bytedance/revenue/platform/api/core/KmpList;", "getPreOnlineUsers", "preOnlineUsers", "getLinkerContentMap", "linkerContentMap", "", "getLeaveSource", "()I", "leaveSource", "getLinkUsers", "linkUsers", "<init>", "Companion", "LeaveSource", "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LinkerLeaveContent extends FlexModelBase<ILinkerLeaveContentBridge> implements ILinkerLeaveContentBridge, h {
    public static final Companion Companion = null;
    public static final int LeaveSource_AnchorFinishRoom = 5;
    public static final int LeaveSource_AnchorLeaveLinkMic = 3;
    public static final int LeaveSource_AnchorRTCUnlink = 4;

    @SerializedName("leave_source")
    protected long _leaveSource;

    @SerializedName("linker_content_map")
    protected Map<Long, ? extends RoomLinkerContent> _linkerContentMap;

    @IgnoreProtoFieldCheck
    @SerializedName("pre_link_users")
    protected List<AnchorLinkUser> _preOnlineUsers;

    @SerializedName("version")
    protected long _version;

    @SerializedName("client_ui_info")
    protected ClientUIInfo clientUIInfo;

    @SerializedName("linked_users")
    protected List<AnchorLinkUser> mLinkUsers;

    @SerializedName("user_id")
    protected long mUserId;

    @SerializedName(Constants.JumpUrlConstants.URL_KEY_OPENID)
    protected String openUserId;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/linker/LinkerLeaveContent$Companion;", "", "()V", "LeaveSource_AnchorFinishRoom", "", "LeaveSource_AnchorLeaveLinkMic", "LeaveSource_AnchorRTCUnlink", "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/linker/LinkerLeaveContent$LeaveSource;", "", "(Ljava/lang/String;I)V", "AnchorLeaveSourceUnknown", "AnchorLeaveSourceOrganizerKickOut", "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum LeaveSource extends Enum<LeaveSource> {
        private static final /* synthetic */ LeaveSource[] $VALUES = null;
        public static final LeaveSource AnchorLeaveSourceOrganizerKickOut = null;
        public static final LeaveSource AnchorLeaveSourceUnknown = null;

        static {
            LeaveSource r100 = new LeaveSource("AnchorLeaveSourceUnknown", 0);
            AnchorLeaveSourceUnknown = r100;
            LeaveSource r101 = new LeaveSource("AnchorLeaveSourceOrganizerKickOut", 1);
            AnchorLeaveSourceOrganizerKickOut = r101;
            $VALUES = new LeaveSource[]{r100, r101};
        }

        public static LeaveSource valueOf(String r100) {
            return (LeaveSource) a.a(LeaveSource.class, r100);
        }

        public static LeaveSource[] values() {
            return (LeaveSource[]) $VALUES.clone();
        }

        private LeaveSource(String r100, int r101) {
            super(r100, r101);
        }
    }

    static {
        Companion = new Companion(null);
    }

    public LinkerLeaveContent() {
        super(ILinkerLeaveContentBridge.class);
    }

    @Deprecated(message = "不要直接访问这个字段，使用包装方法 getUserIdStr")
    public static /* synthetic */ void getMUserId$annotations() {
    }

    @Deprecated(message = "不要直接访问这个字段，使用包装方法 getUserIdStr")
    public static /* synthetic */ void getOpenUserId$annotations() {
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerLeaveContentBridgeDef
    public int getLeaveSource() {
        return (int) this._leaveSource;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerLeaveContentBridge
    public String getUserIdStr() {
        o0.a r100 = o0.f58946a;
        Long r101 = Long.valueOf(this.mUserId);
        String r102 = this.openUserId;
        r100.getClass();
        return o0.a.g(r101, r102);
    }

    public String toString() {
        if (this.mLinkUsers == null) goto L5;
        StringBuilder r100 = new StringBuilder("LeaveContent{ mUserId=");
        r100.append(getUserIdStr());
        r100.append(",size=");
        List<AnchorLinkUser> r101 = this.mLinkUsers;
        Intrinsics.checkNotNull(r101);
        r100.append(r101.size());
        r100.append(",version=");
        r100.append(getVersion());
        r100.append(" ");
        List<AnchorLinkUser> r102 = this.mLinkUsers;
        Intrinsics.checkNotNull(r102);
        Iterator<AnchorLinkUser> r103 = r102.iterator();
    L8:
        if (r103.hasNext() == false) goto L20;
        AnchorLinkUser r104 = r103.next();
        r100.append("[");
        if (r104.getMUser() == null) goto L19;
        r100.append("uid=");
        User r105 = r104.getMUser();
        String r106 = null;
        if (r105 == null) goto L14;
        String r107 = r105.getIdString();
    L15:
        r100.append(r107);
        r100.append(",name=");
        User r108 = r104.getMUser();
        if (r108 == null) goto L18;
        r106 = r108.getRealNickName();
    L18:
        r100.append(r106);
        r100.append(",");
        goto L19
    L14:
        r107 = null;
    L19:
        r100.append("pos=");
        r100.append(r104.getMUserPosition());
        r100.append(",role=");
        r100.append(r104.getMRoleType());
        r100.append(",silence=");
        r100.append(r104.getMSilenceStatus());
        r100.append(",linkId=");
        r100.append(r104.getMLinkmicIdStr());
        r100.append(",linkType=");
        r100.append(r104.getMLinkType());
        r100.append(",isBg=");
        r100.append(r104.isBackground());
        r100.append(",isCPos=");
        r100.append(CPositionModeUtil.isCPositionUser(r104));
        r100.append(",mc=");
        r100.append(r104.getMcStatus());
        r100.append(",extra=");
        r100.append(r104.getExtra());
        r100.append("] ");
        goto L8
    L20:
        r100.append("preOnlineList.size=");
        int r109 = 0;
        if (getPreOnlineUsers() != null) goto L23;
        int r110 = 0;
    L24:
        r100.append(r110);
        r100.append(" linkerContentMap.size= ");
        if (getLinkerContentMap() == null) goto L28;
        Map<Long, RoomLinkerContent> r111 = getLinkerContentMap();
        Intrinsics.checkNotNull(r111);
        r109 = r111.size();
    L28:
        r100.append(r109);
        r100.append(" ");
        if (getLinkerContentMap() == null) goto L33;
        Map<Long, RoomLinkerContent> r112 = getLinkerContentMap();
        Intrinsics.checkNotNull(r112);
        if (r112.size() <= 0) goto L33;
        r100.append("linkerContentMap=");
        r100.append(String.valueOf(getLinkerContentMap()));
        r100.append(" ");
    L33:
        r100.append(i.f25855d);
        return r100.toString();
    L23:
        List<k> r113 = getPreOnlineUsers();
        Intrinsics.checkNotNull(r113);
        r110 = r113.size();
        goto L24
    L5:
        return "LeaveContent{mUserId=" + getUserIdStr() + '}';
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerLeaveContentBridge
    public String getUserId() {
        return getUserIdStr();
    }

    public final ClientUIInfo getClientUIInfo() {
        return this.clientUIInfo;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerLeaveContentBridgeDef
    public List<k> getLinkUsers() {
        return this.mLinkUsers;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerLeaveContentBridgeDef
    public Map<Long, RoomLinkerContent> getLinkerContentMap() {
        return this._linkerContentMap;
    }

    public final List<AnchorLinkUser> getMLinkUsers() {
        return this.mLinkUsers;
    }

    public final long getMUserId() {
        return this.mUserId;
    }

    public final String getOpenUserId() {
        return this.openUserId;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerLeaveContentBridgeDef
    public List<k> getPreOnlineUsers() {
        return this._preOnlineUsers;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerLeaveContentBridgeDef
    public long getVersion() {
        return this._version;
    }

    public final long get_leaveSource() {
        return this._leaveSource;
    }

    public final Map<Long, RoomLinkerContent> get_linkerContentMap() {
        return this._linkerContentMap;
    }

    public final List<AnchorLinkUser> get_preOnlineUsers() {
        return this._preOnlineUsers;
    }

    public final long get_version() {
        return this._version;
    }

    /* JADX WARN: Type inference failed for: r2v5, types: [com.bytedance.android.livesdkapi.depend.message.ClientUIInfo, java.lang.Object] */
    public LinkerLeaveContent(g r110) {
        super(ILinkerLeaveContentBridge.class);
        this.mLinkUsers = new ArrayList();
        this._preOnlineUsers = new ArrayList();
        this._linkerContentMap = new HashMap();
        setThreadSafe(false);
        long r100 = r110.c();
    L3:
        int r101 = r110.f();
        if (r101 == (-1)) goto L46;
        g.a r102 = decodeExtensionFields(r101, r110);
        if (r101 != 1) goto L8;
        this.mUserId = r110.j();
        goto L3
    L8:
        if (r101 == 2) goto L43;
        if (r101 != 4) goto L12;
        List<AnchorLinkUser> r103 = this._preOnlineUsers;
        AnchorLinkUser r104 = new AnchorLinkUser(r110);
    L44:
        r103.add(r104);
        goto L3
    L12:
        if (r101 != 5) goto L14;
        this._version = r110.j();
        goto L3
    L14:
        if (r101 != 6) goto L16;
        long r105 = r110.c();
        Long r106 = null;
        RoomLinkerContent r107 = null;
    L26:
        int r108 = r110.f();
        if (r108 == (-1)) goto L33;
        if (r108 != 1) goto L29;
        r106 = Long.valueOf(r110.j());
        goto L26
    L29:
        if (r108 != 2) goto L30;
        r107 = p1.a(r110);
        goto L26
    L30:
        am3.h.e(r110);
        goto L26
    L33:
        r110.d(r105);
        Map<Long, ? extends RoomLinkerContent> r109 = this._linkerContentMap;
        if (r106 == null) goto L40;
        if (r107 == null) goto L38;
        r109.put(r106, r107);
        goto L3
    L38:
        throw new IllegalStateException("Value must not be null");
    L40:
        throw new IllegalStateException("Key must not be null");
    L16:
        if (r101 != 7) goto L18;
        this._leaveSource = r110.i();
        goto L3
    L18:
        if (r101 != 12) goto L20;
        this.clientUIInfo = f.a(r110, ClientUIInfo.class);
        goto L3
    L20:
        if (r101 != 5000) goto L21;
        this.openUserId = am3.h.c(r110);
        goto L3
    L21:
        am3.h.d(r102, r110);
        goto L3
    L43:
        r103 = this.mLinkUsers;
        r104 = new AnchorLinkUser(r110);
        goto L44
    L46:
        r110.d(r100);
        setThreadSafe(true);
    }

    public final void setClientUIInfo(ClientUIInfo r100) {
        this.clientUIInfo = r100;
    }

    public final void setMLinkUsers(List<AnchorLinkUser> r100) {
        this.mLinkUsers = r100;
    }

    public final void setMUserId(long r100) {
        this.mUserId = r100;
    }

    public final void setOpenUserId(String r100) {
        this.openUserId = r100;
    }

    public final void set_leaveSource(long r100) {
        this._leaveSource = r100;
    }

    public final void set_linkerContentMap(Map<Long, ? extends RoomLinkerContent> r100) {
        this._linkerContentMap = r100;
    }

    public final void set_preOnlineUsers(List<AnchorLinkUser> r100) {
        this._preOnlineUsers = r100;
    }

    public final void set_version(long r100) {
        this._version = r100;
    }
}
