package com.bytedance.android.gamecp.host_api.model;

import android.util.Log;
import com.bytedance.android.gamecp.host_api.model.toolbar.LiveToolbarData;
import com.bytedance.android.gamecp.host_api.model.toolbar.RoomGameData;
import com.bytedance.android.gamecp.host_api.model.toolbar.ToolbarComponentData;
import com.bytedance.android.gamecp.host_api.model.user.User;
import com.bytedance.android.gamecp.host_api.util.gson.GsonHelper;
import com.bytedance.android.tools.pbadapter.annotation.IgnoreProtoFieldCheck;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.common.utility.Logger;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
@ProtoMessage("webcast.data.Room")
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\bd\u0010eJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0006\u0010\u0006\u001a\u00020\u0005J\u0017\u0010\t\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u000b\u001a\u00020\u0007H\u0016J\b\u0010\r\u001a\u0004\u0018\u00010\fR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010\u000eR$\u0010\u000f\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u000e\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\nR$\u0010\u0013\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0011\"\u0004\b\u0015\u0010\nR$\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR$\u0010\u001e\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R$\u0010$\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b$\u0010\u0018\u001a\u0004\b%\u0010\u001a\"\u0004\b&\u0010\u001cR$\u0010'\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b'\u0010\u0018\u001a\u0004\b(\u0010\u001a\"\u0004\b)\u0010\u001cR$\u0010*\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b*\u0010\u0018\u001a\u0004\b+\u0010\u001a\"\u0004\b,\u0010\u001cR\"\u0010.\u001a\u00020-8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\"\u00104\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b4\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109R$\u0010:\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b:\u0010\u0018\u001a\u0004\b;\u0010\u001a\"\u0004\b<\u0010\u001cR$\u0010>\u001a\u0004\u0018\u00010=8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b>\u0010?\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR$\u0010D\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bD\u0010\u0018\u001a\u0004\bE\u0010\u001a\"\u0004\bF\u0010\u001cR$\u0010G\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bG\u0010\u0018\u001a\u0004\bH\u0010\u001a\"\u0004\bI\u0010\u001cR$\u0010K\u001a\u0004\u0018\u00010J8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bK\u0010L\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR$\u0010Q\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bQ\u0010R\u001a\u0004\bQ\u0010S\"\u0004\bT\u0010UR$\u0010W\u001a\u0004\u0018\u00010V8F@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bW\u0010X\u001a\u0004\bY\u0010Z\"\u0004\b[\u0010\\R*\u0010^\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010]8F@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b^\u0010_\u001a\u0004\b`\u0010a\"\u0004\bb\u0010c¨\u0006f"}, d2 = {"Lcom/bytedance/android/gamecp/host_api/model/Room;", "Lcom/bytedance/android/gamecp/host_api/model/d;", "", "initGameImageBundler", "parseToolbarData", "", "isGameCPRoom", "", "id", "setId", "(Ljava/lang/Long;)V", "getId", "Lcom/bytedance/android/gamecp/host_api/model/toolbar/a;", "getIntroducingGame", "Ljava/lang/Long;", "hasGamePromote", "getHasGamePromote", "()Ljava/lang/Long;", "setHasGamePromote", "roomId", "getRoomId", "setRoomId", "", "ownerUserId", "Ljava/lang/String;", "getOwnerUserId", "()Ljava/lang/String;", "setOwnerUserId", "(Ljava/lang/String;)V", "Lcom/bytedance/android/gamecp/host_api/model/user/User;", "owner", "Lcom/bytedance/android/gamecp/host_api/model/user/User;", "getOwner", "()Lcom/bytedance/android/gamecp/host_api/model/user/User;", "setOwner", "(Lcom/bytedance/android/gamecp/host_api/model/user/User;)V", "idStr", "getIdStr", "setIdStr", "requestId", "getRequestId", "setRequestId", "streamUrl", "getStreamUrl", "setStreamUrl", "", "userCount", "I", "getUserCount", "()I", "setUserCount", "(I)V", "diggCount", "J", "getDiggCount", "()J", "setDiggCount", "(J)V", "promoteInstanceId", "getPromoteInstanceId", "setPromoteInstanceId", "Lcom/bytedance/android/gamecp/host_api/model/toolbar/LiveToolbarData;", "toolbarData", "Lcom/bytedance/android/gamecp/host_api/model/toolbar/LiveToolbarData;", "getToolbarData", "()Lcom/bytedance/android/gamecp/host_api/model/toolbar/LiveToolbarData;", "setToolbarData", "(Lcom/bytedance/android/gamecp/host_api/model/toolbar/LiveToolbarData;)V", "message", "getMessage", "setMessage", "prompts", "getPrompts", "setPrompts", "Lcom/bytedance/android/gamecp/host_api/model/toolbar/RoomGameData;", "roomGameData", "Lcom/bytedance/android/gamecp/host_api/model/toolbar/RoomGameData;", "getRoomGameData", "()Lcom/bytedance/android/gamecp/host_api/model/toolbar/RoomGameData;", "setRoomGameData", "(Lcom/bytedance/android/gamecp/host_api/model/toolbar/RoomGameData;)V", "isScreenRecord", "Ljava/lang/Boolean;", "()Ljava/lang/Boolean;", "setScreenRecord", "(Ljava/lang/Boolean;)V", "Lcom/bytedance/android/gamecp/host_api/model/GameImageBundler;", "iconBundle", "Lcom/bytedance/android/gamecp/host_api/model/GameImageBundler;", "getIconBundle", "()Lcom/bytedance/android/gamecp/host_api/model/GameImageBundler;", "setIconBundle", "(Lcom/bytedance/android/gamecp/host_api/model/GameImageBundler;)V", "", "gameInfoList", "Ljava/util/List;", "getGameInfoList", "()Ljava/util/List;", "setGameInfoList", "(Ljava/util/List;)V", "<init>", "()V", "gamecp-host-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class Room implements d, vh7.h {
    private long diggCount;
    private List<com.bytedance.android.gamecp.host_api.model.toolbar.a> gameInfoList;
    private Long hasGamePromote;
    private GameImageBundler iconBundle;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private Long f57368id;
    private String idStr;
    private Boolean isScreenRecord;

    @IgnoreProtoFieldCheck
    @SerializedName("message")
    private String message;
    private User owner;
    private String ownerUserId;
    private String promoteInstanceId;

    @IgnoreProtoFieldCheck
    @SerializedName("prompts")
    private String prompts;
    private String requestId;

    @SerializedName("game_data")
    protected RoomGameData roomGameData;
    private Long roomId;
    private String streamUrl;

    @SerializedName("toolbar_data")
    protected LiveToolbarData toolbarData;
    private int userCount;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00040\u0001¨\u0006\u0005"}, d2 = {"com/bytedance/android/gamecp/host_api/model/Room$a", "Lcom/google/gson/reflect/TypeToken;", "Ljava/util/ArrayList;", "Lcom/bytedance/android/gamecp/host_api/model/toolbar/a;", "Lkotlin/collections/ArrayList;", "gamecp-host-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a extends TypeToken<ArrayList<com.bytedance.android.gamecp.host_api.model.toolbar.a>> {
        public a() {
        }
    }

    private final void initGameImageBundler() {
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L23
        if (isGameCPRoom() == true) goto L5;
        return;
    L5:
        com.bytedance.android.gamecp.host_api.model.toolbar.a r101 = getIntroducingGame();     // Catch: Throwable -> L23
        if (r101 == null) goto L20;
        String r102 = r101.gameAttr;     // Catch: Throwable -> L23
        if (r102 == null) goto L20;
        Unit r103 = null;
        if ((!StringsKt.isBlank(r102)) == true) goto L13;
        r102 = null;
    L13:
        if (r102 == null) goto L20;
        JSONObject r104 = new JSONObject(r102).optJSONObject("game_icon_bundler");     // Catch: Throwable -> L23
        if (r104 == null) goto L19;
        String r105 = r104.toString();     // Catch: Throwable -> L23
        if (r105 == null) goto L19;
        this.iconBundle = (GameImageBundler) new Gson().fromJson(r105, GameImageBundler.class);     // Catch: Throwable -> L23
        r103 = Unit.INSTANCE;     // Catch: Throwable -> L23
    L19:
        if (r103 == null) goto L20;
    L21:
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L23
        return;
    L20:
        Logger.e("PromoteCardIconPreloadOpt", "gameAttr has no image info.");     // Catch: Throwable -> L23
        Unit r106 = Unit.INSTANCE;     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }

    private final void parseToolbarData() {
        LiveToolbarData r100 = this.toolbarData;
        if (r100 == null) goto L37;
        List<ToolbarComponentData> r101 = r100.getToolbarDataList();
        if (r101 == null) goto L38;
        Iterator<T> r102 = r101.iterator();
    L7:
        JsonElement r103 = null;
        if (r102.hasNext() == false) goto L15;
        Object r104 = r102.next();
        if (((ToolbarComponentData) r104).getId() != 5) goto L12;
        boolean r105 = true;
    L13:
        if (r105 == false) goto L7;
    L16:
        ToolbarComponentData r106 = (ToolbarComponentData) r104;
        if (r106 == null) goto L39;
        JsonElement r107 = GsonHelper.a.f57436d.parse(r106.getExtraData());     // Catch: Throwable -> L27
        if (r107 == null) goto L21;
        JsonObject r108 = r107.getAsJsonObject();     // Catch: Throwable -> L27
    L22:
        Gson r109 = GsonHelper.get();     // Catch: Throwable -> L27
        if (r108 == null) goto L25;
        r103 = r108.get("game_info");     // Catch: Throwable -> L27
    L25:
        this.gameInfoList = (List) GsonHelper.get().fromJson(r109.toJson(r103), new a().getType());     // Catch: Throwable -> L27
        return;
    L21:
        r108 = null;
    L27:
        th = move-exception;
        this.gameInfoList = CollectionsKt.emptyList();
        Logger.e("Error parsing json", Log.getStackTraceString(th));
        return;
    L39:
        return;
    L12:
        r105 = false;
        goto L13
    L15:
        r104 = null;
        goto L16
    L38:
        return;
    }

    public final List<com.bytedance.android.gamecp.host_api.model.toolbar.a> getGameInfoList() {
        if (this.gameInfoList != null) goto L6;
        parseToolbarData();
    L6:
        return this.gameInfoList;
    }

    public final GameImageBundler getIconBundle() {
        if (this.iconBundle != null) goto L6;
        initGameImageBundler();
    L6:
        return this.iconBundle;
    }

    public long getId() {
        Long r100 = this.f57368id;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.longValue();
    }

    public final boolean isGameCPRoom() {
        Long r100 = this.hasGamePromote;
        if (r100 != null) goto L6;
    L8:
        LiveToolbarData r101 = this.toolbarData;
        if (r101 == null) goto L26;
        List<ToolbarComponentData> r102 = r101.getToolbarDataList();
        if (r102 == null) goto L26;
        List<ToolbarComponentData> r103 = r102;
        if ((r103 instanceof Collection) == true) goto L15;
    L17:
        Iterator<T> r104 = r103.iterator();
    L19:
        if (r104.hasNext() == false) goto L26;
        if (((ToolbarComponentData) r104.next()).getId() != 5) goto L23;
        boolean r105 = true;
    L24:
        if (r105 == false) goto L19;
        return true;
    L23:
        r105 = false;
        goto L24
    L15:
        if (r103.isEmpty() == false) goto L17;
    L26:
        return false;
    L6:
        if (r100.longValue() != 1) goto L8;
        return true;
    }

    public Room() {
        this.f57368id = 0L;
        this.hasGamePromote = 0L;
        this.roomId = 0L;
        this.ownerUserId = "0";
        this.userCount = -1;
        this.diggCount = -1;
    }

    public final com.bytedance.android.gamecp.host_api.model.toolbar.a getIntroducingGame() {
        List<com.bytedance.android.gamecp.host_api.model.toolbar.a> r100 = getGameInfoList();
        Object r101 = null;
        if (r100 == null) goto L15;
        Iterator<T> r102 = r100.iterator();
    L6:
        if (r102.hasNext() == false) goto L11;
        Object r103 = r102.next();
        if (((com.bytedance.android.gamecp.host_api.model.toolbar.a) r103).isIntroducing == false) goto L6;
        r101 = r103;
    L11:
        return (com.bytedance.android.gamecp.host_api.model.toolbar.a) r101;
    L15:
        return null;
    }

    public final long getDiggCount() {
        return this.diggCount;
    }

    public final Long getHasGamePromote() {
        return this.hasGamePromote;
    }

    public final String getIdStr() {
        return this.idStr;
    }

    public final String getMessage() {
        return this.message;
    }

    public final User getOwner() {
        return this.owner;
    }

    public final String getOwnerUserId() {
        return this.ownerUserId;
    }

    public final String getPromoteInstanceId() {
        return this.promoteInstanceId;
    }

    public final String getPrompts() {
        return this.prompts;
    }

    public final String getRequestId() {
        return this.requestId;
    }

    public final RoomGameData getRoomGameData() {
        return this.roomGameData;
    }

    public final Long getRoomId() {
        return this.roomId;
    }

    public final String getStreamUrl() {
        return this.streamUrl;
    }

    public final LiveToolbarData getToolbarData() {
        return this.toolbarData;
    }

    public final int getUserCount() {
        return this.userCount;
    }

    public final Boolean isScreenRecord() {
        return this.isScreenRecord;
    }

    public Room(am3.g r100) {
        this.f57368id = 0L;
        this.hasGamePromote = 0L;
        this.roomId = 0L;
        this.ownerUserId = "0";
        this.userCount = -1;
        this.diggCount = -1;
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L12;
        if (r102 != 205) goto L8;
        this.toolbarData = new LiveToolbarData(r100);
        goto L3
    L8:
        if (r102 != 307) goto L9;
        this.roomGameData = new RoomGameData(r100);
        goto L3
    L9:
        am3.h.e(r100);
        goto L3
    L12:
        r100.d(r101);
    }

    public final void setDiggCount(long r100) {
        this.diggCount = r100;
    }

    public final void setGameInfoList(List<com.bytedance.android.gamecp.host_api.model.toolbar.a> r100) {
        this.gameInfoList = r100;
    }

    public final void setHasGamePromote(Long r100) {
        this.hasGamePromote = r100;
    }

    public final void setIconBundle(GameImageBundler r100) {
        this.iconBundle = r100;
    }

    public final void setId(Long r100) {
        this.f57368id = r100;
    }

    public final void setIdStr(String r100) {
        this.idStr = r100;
    }

    public final void setMessage(String r100) {
        this.message = r100;
    }

    public final void setOwner(User r100) {
        this.owner = r100;
    }

    public final void setOwnerUserId(String r100) {
        this.ownerUserId = r100;
    }

    public final void setPromoteInstanceId(String r100) {
        this.promoteInstanceId = r100;
    }

    public final void setPrompts(String r100) {
        this.prompts = r100;
    }

    public final void setRequestId(String r100) {
        this.requestId = r100;
    }

    public final void setRoomGameData(RoomGameData r100) {
        this.roomGameData = r100;
    }

    public final void setRoomId(Long r100) {
        this.roomId = r100;
    }

    public final void setScreenRecord(Boolean r100) {
        this.isScreenRecord = r100;
    }

    public final void setStreamUrl(String r100) {
        this.streamUrl = r100;
    }

    public final void setToolbarData(LiveToolbarData r100) {
        this.toolbarData = r100;
    }

    public final void setUserCount(int r100) {
        this.userCount = r100;
    }
}
