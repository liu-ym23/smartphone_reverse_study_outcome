package com.bytedance.android.live.broadcastgame.api.model;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.liveinteract.api.utils.LiveSeiUtil;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.f2;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.o2;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.downloadlib.constants.EventConstants;
import com.tencent.open.SocialConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
@ProtoMessage("webcast.api.stamp.InteractEntranceCell")
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0002$%R\u0016\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0016\u0010\b\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0018\u0010\n\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\n\u0010\tR\u0018\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u000f\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\tR\u001e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0013R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\tR\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\tR\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\tR\u001e\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u0013R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\tR\u001e\u0010 \u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b \u0010\u0013R\u001e\u0010\"\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\"\u0010\u0013R\u0018\u0010#\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b#\u0010\t¨\u0006&"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/api/model/InteractEntranceCell;", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/f2$b;", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/o2$b;", "Lcom/bytedance/android/live/broadcastgame/api/model/l;", "", "interactType", "I", "", "title", "Ljava/lang/String;", SocialConstants.PARAM_APP_DESC, "Lcom/bytedance/android/live/base/model/ImageModel;", "icon", "Lcom/bytedance/android/live/base/model/ImageModel;", "", "groupType", "J", "", "serverScenes", "Ljava/util/List;", "extra", "Lcom/bytedance/android/live/broadcastgame/api/model/v;", "labels", "Lcom/bytedance/android/live/broadcastgame/api/model/k0;", "rightButton", "Lcom/bytedance/android/live/broadcastgame/api/model/k0;", "gameCardExtra", "extendExtra", "iconLabel", "selectKeys", "titleLabel", "Lcom/bytedance/android/live/broadcastgame/api/model/t;", "highlightLabel", "Lcom/bytedance/android/live/broadcastgame/api/model/s;", "highlightDesc", "highlightIcon", "AppPrivilege", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livebroadcastgame-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class InteractEntranceCell implements f2.b, o2.b, l, vh7.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f59319a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public r f59320b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public List<y> f59321c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f59322d;

    @SerializedName(SocialConstants.PARAM_APP_DESC)
    public String desc;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f59323e;

    @SerializedName("extend_extra")
    public String extendExtra;

    @SerializedName("extra")
    public String extra;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final n f59324f;

    @SerializedName("game_card_extra")
    public String gameCardExtra;

    @SerializedName("group_id")
    public long groupType;

    @SerializedName("highlight_desc")
    public List<s> highlightDesc;

    @SerializedName("highlight_icon")
    public String highlightIcon;

    @SerializedName("highlight_label")
    public List<t> highlightLabel;

    @SerializedName("icon")
    public ImageModel icon;

    @SerializedName("icon_label")
    public String iconLabel;

    @SerializedName("interact_type")
    public int interactType;

    @SerializedName("labels")
    public List<v> labels;

    @SerializedName("button")
    public k0 rightButton;

    @SerializedName("select_keys")
    public List<String> selectKeys;

    @SerializedName("call_server_scenes")
    public List<String> serverScenes;

    @SerializedName("title")
    public String title;

    @SerializedName("title_label")
    public String titleLabel;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/api/model/InteractEntranceCell$AppPrivilege;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "BIND_SELF_MOUNT", "BIND_DCD", "livebroadcastgame-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum AppPrivilege extends Enum<AppPrivilege> {
        public static final AppPrivilege BIND_DCD = null;
        public static final AppPrivilege BIND_SELF_MOUNT = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ AppPrivilege[] f59325a = null;
        private final String value;

        static {
            AppPrivilege r100 = new AppPrivilege("BIND_SELF_MOUNT", 0, "bind_self");
            BIND_SELF_MOUNT = r100;
            AppPrivilege r101 = new AppPrivilege("BIND_DCD", 1, "bind_dcd");
            BIND_DCD = r101;
            f59325a = new AppPrivilege[]{r100, r101};
        }

        public static AppPrivilege valueOf(String r100) {
            return (AppPrivilege) r27.a.a(AppPrivilege.class, r100);
        }

        public static AppPrivilege[] values() {
            return (AppPrivilege[]) f59325a.clone();
        }

        public final String getValue() {
            return this.value;
        }

        public AppPrivilege(String r100, int r101, String r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class a {
    }

    static {
    }

    public final String toString() {
        return "InteractEntranceCell(interactType=" + this.interactType + ", title=" + this.title + ", desc=" + this.desc + ", icon=" + this.icon + ", groupType=" + this.groupType + ", serverScenes=" + this.serverScenes + ", extra=" + this.extra + ", labels=" + this.labels + ", rightButton=" + this.rightButton + ", gameCardExtra=" + this.gameCardExtra + ", extendExtra=" + this.extendExtra + ", iconLabel=" + this.iconLabel + ", selectKeys=" + this.selectKeys + ", titleLabel=" + this.titleLabel + ", highlightLabel=" + this.highlightLabel + ", highlightDesc=" + this.highlightDesc + ", highlightIcon=" + this.highlightIcon + ")";
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.o2.b
    public final String c() {
        if (this.f59324f.f59364c == true) goto L6;
        return String.valueOf(this.interactType);
    L6:
        return h();
    }

    public final r e() {
        boolean r100 = this.f59319a;
        if (r100 == true) goto L34;
        if (r100 == true) goto L34;
        String r101 = this.extra;
        if (r101 != null) goto L9;
    L12:
        boolean r102 = true;
    L13:
        if (r102 == false) goto L35;
    L32:
        this.f59319a = true;
        goto L34
    L35:
        JsonObject r103 = GsonHelper.parser().parse(this.extra).getAsJsonObject();     // Catch: Exception -> L30
        r103.addProperty(EventConstants.ExtraJson.GAME_NAME, this.title);     // Catch: Exception -> L30
        r103.addProperty("anchor_live_version", Integer.valueOf(com.bytedance.android.livesdk.paas.c.b()));     // Catch: Exception -> L30
        if (InteractID.OpenMicroGame.getValue() != this.interactType) goto L23;
        JsonObject r104 = r103.getAsJsonObject("micro_game_info");     // Catch: Exception -> L30
        if (r104 == null) goto L23;
        JsonElement r105 = r104.get("game_id");     // Catch: Exception -> L30
        if (r105 == null) goto L23;
        String r106 = r105.getAsString();     // Catch: Exception -> L30
        if (r106 == null) goto L23;
        r103.addProperty("app_id", r106);     // Catch: Exception -> L30
    L23:
        r r107 = (r) GsonHelper.get().fromJson(r103, r.class);     // Catch: Exception -> L30
        this.f59320b = r107;     // Catch: Exception -> L30
        if (r107 != null) goto L26;
    L28:
        r103.toString();     // Catch: Exception -> L30
        goto L32
    L26:
        if (this.interactType != InteractID.EffectGame.getValue()) goto L28;
        r103.addProperty("game_identifier", Long.valueOf(r107.l()));     // Catch: Exception -> L30
    L30:
        e = move-exception;
        e.printStackTrace();
        goto L32
    L9:
        if (r101.length() == 0) goto L12;
        r102 = false;
    L34:
        return this.f59320b;
    }

    public final boolean f() {
        return Intrinsics.areEqual(new JSONObject(this.extendExtra).optString("app_privilege", ""), AppPrivilege.BIND_SELF_MOUNT.getValue());
    L4:
        return false;
    }

    public final String g() {
        return new JSONObject(this.extendExtra).optString("recommend_reason", "");
    L8:
        return "";
    }

    public final String h() {
        int r100 = w.f59380a;
        return w.a.a(this.interactType, this.title, e(), this.extra);
    }

    public final int hashCode() {
        int r100 = this.title.hashCode() * 31;
        ImageModel r101 = this.icon;
        int r102 = 0;
        if (r101 == null) goto L5;
        int r103 = r101.hashCode();
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.extra;
        if (r105 == null) goto L10;
        r102 = r105.hashCode();
    L10:
        return r104 + r102;
    L5:
        r103 = 0;
        goto L6
    }

    public final u i() {
        ArrayList r100 = new ArrayList();
        Iterator<T> r101 = this.f59321c.iterator();
    L3:
        String r102 = "";
        if (r101.hasNext() == false) goto L12;
        y r103 = (y) r101.next();
        if (r103 == null) goto L11;
        String r104 = r103.text;
        if (r104 == null) goto L11;
        r102 = r104;
    L11:
        r100.add(r102);
        goto L3
    L12:
        List<Long> r105 = null;
        if (this.interactType != InteractID.OpenGame.getValue()) goto L15;
    L77:
        String r106 = this.extra;
        if (r106 != null) goto L104;
    L82:
        JSONObject r107 = null;
    L83:
        int r108 = this.interactType;
        String r109 = this.title;
        if (r109 != null) goto L86;
        String r110 = "";
    L87:
        ImageModel r111 = this.icon;
        if (r111 == null) goto L91;
        List r112 = r111.mUrls;
        if (r112 == null) goto L91;
    L92:
        List r113 = r112;
        long r114 = this.groupType;
        r r115 = e();
        if (r115 == null) goto L95;
        r105 = r115.supportiveEntrance;
    L95:
        List<Long> r116 = r105;
        if (r107 == null) goto L101;
        String r117 = r107.toString();
        if (r117 == null) goto L101;
        String r118 = r117;
    L102:
        u r119 = new u(r108, r110, r113, 0, r114, r116, r118);
        n r120 = this.f59324f;
        Intrinsics.checkNotNullParameter(r120, "<set-?>");
        r119.f59370b = r120;
        r119.f59371c = this.f59322d;
        r119.f59375g = this.f59323e;
        String r121 = r100.toString();
        Intrinsics.checkNotNullParameter(r121, "<set-?>");
        r119.f59374f = r121;
        return r119;
    L101:
        r118 = "";
    L91:
        r112 = new ArrayList();
        goto L92
    L86:
        r110 = r109;
        goto L87
    L104:
        LiveSeiUtil.f71508i.getClass();     // Catch: Exception -> L81
        JSONObject r122 = LiveSeiUtil.c(r106);     // Catch: Exception -> L81
        r122.put("game_card_extra", this.gameCardExtra);     // Catch: Exception -> L81
        r107 = r122.put(SocialConstants.PARAM_APP_DESC, this.desc);     // Catch: Exception -> L81
    L15:
        if (this.interactType == InteractID.SonicMiniGame.getValue()) goto L77;
        if (this.interactType != InteractID.InteractLoki.getValue()) goto L20;
    L42:
        String r123 = this.extra;
        if (r123 != null) goto L106;
    L55:
        JSONObject r124 = null;
    L56:
        int r125 = this.interactType;
        String r126 = this.title;
        if (r126 != null) goto L59;
        String r127 = "";
    L60:
        ImageModel r128 = this.icon;
        if (r128 == null) goto L64;
        List r129 = r128.mUrls;
        if (r129 == null) goto L64;
    L65:
        List r130 = r129;
        long r131 = this.groupType;
        r r132 = e();
        if (r132 == null) goto L68;
        r105 = r132.supportiveEntrance;
    L68:
        List<Long> r133 = r105;
        if (r124 == null) goto L74;
        String r134 = r124.toString();
        if (r134 == null) goto L74;
        String r135 = r134;
    L75:
        u r136 = new u(r125, r127, r130, 0, r131, r133, r135);
        n r137 = this.f59324f;
        Intrinsics.checkNotNullParameter(r137, "<set-?>");
        r136.f59370b = r137;
        r136.f59371c = this.f59322d;
        r136.f59375g = this.f59323e;
        String r138 = r100.toString();
        Intrinsics.checkNotNullParameter(r138, "<set-?>");
        r136.f59374f = r138;
        return r136;
    L74:
        r135 = "";
    L64:
        r129 = new ArrayList();
        goto L65
    L59:
        r127 = r126;
        goto L60
    L106:
        LiveSeiUtil.f71508i.getClass();     // Catch: Exception -> L54
        JSONObject r139 = LiveSeiUtil.c(r123);     // Catch: Exception -> L54
        k0 r140 = this.rightButton;     // Catch: Exception -> L54
        if (r140 == null) goto L47;
        String r141 = r140.schemeUrl;     // Catch: Exception -> L54
    L48:
        r139.put("button_schema_url", r141);     // Catch: Exception -> L54
        k0 r142 = this.rightButton;     // Catch: Exception -> L54
        if (r142 == null) goto L51;
        String r143 = r142.extra;     // Catch: Exception -> L54
    L52:
        r124 = r139.put("button_extra", r143);     // Catch: Exception -> L54
    L51:
        r143 = null;
        goto L52
    L47:
        r141 = null;
        goto L48
    L20:
        if (this.interactType == InteractID.InteractGamePlus.getValue()) goto L42;
        if (this.interactType == InteractID.InteractMiniApp.getValue()) goto L42;
        int r144 = this.interactType;
        String r145 = this.title;
        if (r145 != null) goto L27;
        String r146 = "";
    L28:
        ImageModel r147 = this.icon;
        if (r147 == null) goto L32;
        List r148 = r147.mUrls;
        if (r148 == null) goto L32;
    L33:
        List r149 = r148;
        long r150 = this.groupType;
        r r151 = e();
        if (r151 == null) goto L36;
        r105 = r151.supportiveEntrance;
    L36:
        List<Long> r152 = r105;
        String r153 = this.extra;
        if (r153 != null) goto L39;
        String r154 = "";
    L40:
        u r155 = new u(r144, r146, r149, 0, r150, r152, r154);
        n r156 = this.f59324f;
        Intrinsics.checkNotNullParameter(r156, "<set-?>");
        r155.f59370b = r156;
        r155.f59371c = this.f59322d;
        r155.f59375g = this.f59323e;
        String r157 = r100.toString();
        Intrinsics.checkNotNullParameter(r157, "<set-?>");
        r155.f59374f = r157;
        r155.f59378j = this.serverScenes;
        return r155;
    L39:
        r154 = r153;
    L32:
        r148 = new ArrayList();
        goto L33
    L27:
        r146 = r145;
        goto L28
    }

    public InteractEntranceCell() {
        this.f59321c = new ArrayList();
        this.f59323e = -1;
        this.f59324f = new n(0);
        this.interactType = 0;
        this.title = "";
        this.desc = "";
        this.icon = null;
        this.groupType = 0;
        this.serverScenes = new ArrayList();
        this.extra = "";
        this.labels = new ArrayList();
        this.rightButton = null;
        this.gameCardExtra = "";
        this.extendExtra = "";
        this.iconLabel = null;
        this.selectKeys = new ArrayList();
        this.titleLabel = null;
        this.highlightLabel = new ArrayList();
        this.highlightDesc = new ArrayList();
        this.highlightIcon = null;
    }

    @Override // com.bytedance.android.live.broadcastgame.api.model.l
    public final List<Long> a() {
        r r100 = e();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.supportiveEntrance;
    }

    @Override // com.bytedance.android.live.broadcastgame.api.model.l
    public final r d() {
        return e();
    }

    @Override // com.bytedance.android.live.broadcastgame.api.model.l
    public final int b() {
        return this.interactType;
    }

    public InteractEntranceCell(am3.g r100) {
        this.serverScenes = new ArrayList();
        this.labels = new ArrayList();
        this.selectKeys = new ArrayList();
        this.highlightLabel = new ArrayList();
        this.highlightDesc = new ArrayList();
        this.f59321c = new ArrayList();
        this.f59323e = -1;
        this.f59324f = new n(0);
        long r101 = r100.c();
        int r102 = 0;
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L27;
        switch(r103) {
            case 1: goto L23;
            case 2: goto L22;
            case 3: goto L21;
            case 4: goto L20;
            case 5: goto L19;
            case 6: goto L16;
            case 7: goto L15;
            case 8: goto L14;
            case 9: goto L13;
            case 10: goto L12;
            case 11: goto L11;
            case 12: goto L10;
            case 13: goto L9;
            case 14: goto L8;
            default: goto L6;
        };
    L8:
        this.highlightIcon = am3.h.c(r100);
        goto L3
    L9:
        List r104 = this.highlightLabel;
        Object r105 = new t(r100);
    L18:
        r104.add(r105);
        goto L3
    L10:
        r104 = this.highlightDesc;
        r105 = new s(r100);
        goto L18
    L11:
        this.titleLabel = am3.h.c(r100);
        goto L3
    L12:
        r104 = this.selectKeys;
    L17:
        r105 = am3.h.c(r100);
        goto L18
    L13:
        this.iconLabel = am3.h.c(r100);
        goto L3
    L14:
        this.rightButton = new k0(r100);
        goto L3
    L15:
        r104 = this.labels;
        r105 = new v(r100);
        goto L18
    L16:
        r104 = this.serverScenes;
        goto L17
    L19:
        this.groupType = r100.j();
        r102 = r102 | 2;
        goto L3
    L20:
        this.icon = com.bytedance.android.live.base.model.x.a(r100);
        goto L3
    L21:
        this.desc = am3.h.c(r100);
        goto L3
    L22:
        this.title = am3.h.c(r100);
        goto L3
    L23:
        this.interactType = r100.i();
        r102 = r102 | 1;
        goto L3
    L6:
        switch(r103) {
            case 99: goto L26;
            case 100: goto L25;
            case 101: goto L24;
            default: goto L7;
        };
    L24:
        this.extendExtra = am3.h.c(r100);
        goto L3
    L25:
        this.gameCardExtra = am3.h.c(r100);
        goto L3
    L26:
        this.extra = am3.h.c(r100);
        goto L3
    L7:
        am3.h.e(r100);
        goto L3
    L27:
        r100.d(r101);
        if ((r102 & 1) != 0) goto L31;
        this.interactType = 0;
    L31:
        if (this.title != null) goto L34;
        this.title = "";
    L34:
        if (this.desc != null) goto L37;
        this.desc = "";
    L37:
        if (this.icon != null) goto L40;
        this.icon = null;
    L40:
        if ((r102 & 2) != 0) goto L43;
        this.groupType = 0;
    L43:
        if (this.serverScenes.isEmpty() == false) goto L46;
        this.serverScenes = new ArrayList();
    L46:
        if (this.extra != null) goto L49;
        this.extra = "";
    L49:
        if (this.labels.isEmpty() == false) goto L52;
        this.labels = new ArrayList();
    L52:
        if (this.rightButton != null) goto L55;
        this.rightButton = null;
    L55:
        if (this.gameCardExtra != null) goto L58;
        this.gameCardExtra = "";
    L58:
        if (this.extendExtra != null) goto L61;
        this.extendExtra = "";
    L61:
        if (this.iconLabel != null) goto L64;
        this.iconLabel = null;
    L64:
        if (this.selectKeys.isEmpty() == false) goto L67;
        this.selectKeys = new ArrayList();
    L67:
        if (this.titleLabel != null) goto L70;
        this.titleLabel = null;
    L70:
        if (this.highlightLabel.isEmpty() == false) goto L73;
        this.highlightLabel = new ArrayList();
    L73:
        if (this.highlightDesc.isEmpty() == false) goto L76;
        this.highlightDesc = new ArrayList();
    L76:
        if (this.highlightIcon != null) goto L114;
        this.highlightIcon = null;
        return;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L5;
        return true;
    L5:
        String r101 = null;
        if (r100 == null) goto L8;
        Class<?> r102 = r100.getClass();
    L10:
        if ((!Intrinsics.areEqual(InteractEntranceCell.class, r102)) == false) goto L13;
        return false;
    L13:
        if ((r100 instanceof InteractEntranceCell) == true) goto L15;
        return false;
    L15:
        InteractEntranceCell r103 = (InteractEntranceCell) r100;
        if ((!Intrinsics.areEqual(this.title, r103.title)) == false) goto L18;
        return false;
    L18:
        ImageModel r104 = this.icon;
        if (r104 == null) goto L21;
        String r105 = r104.mUri;
    L22:
        ImageModel r106 = r103.icon;
        if (r106 == null) goto L26;
        r101 = r106.mUri;
    L26:
        if ((!Intrinsics.areEqual(r105, r101)) == false) goto L29;
        return false;
    L29:
        if ((!Intrinsics.areEqual(h(), r103.h())) == false) goto L31;
        return false;
    L31:
        return true;
    L21:
        r105 = null;
        goto L22
    L8:
        r102 = null;
        goto L10
    }

    public /* synthetic */ InteractEntranceCell(int r210, String r211, String r212, ImageModel r213, long r214, String r215, int r216) {
        if ((r216 & 1) == 0) goto L5;
        int r100 = 0;
    L7:
        if ((r216 & 2) == 0) goto L9;
        String r101 = "";
    L11:
        if ((r216 & 4) == 0) goto L13;
        String r102 = "";
    L15:
        if ((r216 & 8) == 0) goto L17;
        ImageModel r103 = null;
    L19:
        if ((r216 & 16) == 0) goto L21;
        long r104 = 0;
    L23:
        if ((r216 & 32) == 0) goto L25;
        ArrayList r105 = new ArrayList();
    L27:
        if ((r216 & 64) == 0) goto L29;
        String r110 = "";
    L31:
        if ((r216 & 128) == 0) goto L33;
        ArrayList r111 = new ArrayList();
    L35:
        if ((r216 & 512) == 0) goto L37;
        String r112 = "";
    L39:
        if ((r216 & 1024) == 0) goto L41;
        String r113 = "";
    L43:
        if ((r216 & 4096) == 0) goto L45;
        ArrayList r114 = new ArrayList();
    L47:
        if ((r216 & 16384) == 0) goto L49;
        ArrayList r115 = new ArrayList();
    L51:
        if ((r216 & 32768) == 0) goto L53;
        ArrayList r116 = new ArrayList();
    L54:
        this(r100, r101, r102, r103, r104, r105, r110, r111, null, r112, r113, null, r114, null, r115, r116, null);
        return;
    L53:
        r116 = null;
        goto L54
    L49:
        r115 = null;
        goto L51
    L45:
        r114 = null;
        goto L47
    L41:
        r113 = null;
        goto L43
    L37:
        r112 = null;
        goto L39
    L33:
        r111 = null;
        goto L35
    L29:
        r110 = r215;
        goto L31
    L25:
        r105 = null;
        goto L27
    L21:
        r104 = r214;
        goto L23
    L17:
        r103 = r213;
        goto L19
    L13:
        r102 = r212;
        goto L15
    L9:
        r101 = r211;
        goto L11
    L5:
        r100 = r210;
        goto L7
    }

    public InteractEntranceCell(int r100, String r101, String r102, ImageModel r103, long r104, List<String> r110, String r111, List<v> r112, k0 r113, String r114, String r115, String r116, List<String> r117, String r118, List<t> r119, List<s> r210, String r211) {
        Intrinsics.checkNotNullParameter(r101, "title");
        this.interactType = r100;
        this.title = r101;
        this.desc = r102;
        this.icon = r103;
        this.groupType = r104;
        this.serverScenes = r110;
        this.extra = r111;
        this.labels = r112;
        this.rightButton = r113;
        this.gameCardExtra = r114;
        this.extendExtra = r115;
        this.iconLabel = r116;
        this.selectKeys = r117;
        this.titleLabel = r118;
        this.highlightLabel = r119;
        this.highlightDesc = r210;
        this.highlightIcon = r211;
        this.f59321c = new ArrayList();
        this.f59323e = -1;
        this.f59324f = new n(0);
    }
}
