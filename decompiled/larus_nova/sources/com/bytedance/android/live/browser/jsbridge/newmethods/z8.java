package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.broadcast.api.IBroadcastService;
import com.bytedance.android.live.link.ILinkServiceExternal;
import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.android.livesdk.config.setting.NewBroadcastSharedConfig;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
@XBridgeMethod(biz = "webcast", name = "openPanel")
public final class z8 extends com.bytedance.ies.web.jsbridge2.g<b, JSONObject> {

    public static final class a {
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/live/browser/jsbridge/newmethods/z8$b;", "", "", "type", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "enterFrom", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Lcom/google/gson/JsonObject;", "extra", "Lcom/google/gson/JsonObject;", "b", "()Lcom/google/gson/JsonObject;", "livehybrid-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class b {

        @SerializedName("enter_from")
        private final String enterFrom;

        @SerializedName("extra")
        private final JsonObject extra;

        @SerializedName("type")
        private final String type;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof b) == false) goto L12;
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.type, r101.type) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.enterFrom, r101.enterFrom) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.extra, r101.extra) == true) goto L19;
            return false;
        L19:
            return true;
        L12:
            return false;
        }

        public final int hashCode() {
            String r100 = this.type;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            String r104 = this.enterFrom;
            if (r104 == null) goto L9;
            int r105 = r104.hashCode();
        L10:
            int r106 = (r103 + r105) * 31;
            JsonObject r107 = this.extra;
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

        public final String toString() {
            return "Param(type=" + this.type + ", enterFrom=" + this.enterFrom + ", extra=" + this.extra + ")";
        }

        public final String a() {
            return this.enterFrom;
        }

        public final JsonObject b() {
            return this.extra;
        }

        public final String getType() {
            return this.type;
        }
    }

    static {
    }

    public z8() {
    }

    public static List j(JsonObject r100) {
        if (r100 == null) goto L4;
        ArrayList r101 = new ArrayList();
        JsonArray r102 = r100.getAsJsonArray("highlight");
        if (r102 == null) goto L11;
        Iterator<JsonElement> r103 = r102.iterator();
    L9:
        if (r103.hasNext() == false) goto L11;
        r101.add(r103.next().getAsString());
    L11:
        return r101;
    L4:
        return CollectionsKt.emptyList();
    }

    public static void k(int r100, b r101) {
        if ((!Intrinsics.areEqual(r101.a(), "newbie_task")) == false) goto L6;
        return;
    L6:
        if (NewBroadcastSharedConfig.a().booleanValue() == false) goto L10;
        g00.d r102 = (g00.d) com.bytedance.android.scope.m.f163449e.d(f00.a.f474945b, g00.d.class);
        if (r102 == null) goto L15;
        r102.markEnterSceneFromJsb(r100);
        return;
    L15:
        return;
    L10:
        IBroadcastService r103 = (IBroadcastService) va1.b.a.f553922a.a(IBroadcastService.class);
        if (r103 != null) goto L13;
        return;
    L13:
        r103.markEnterSceneFromJsb(r100);
    }

    @Override // com.bytedance.ies.web.jsbridge2.g
    public final JSONObject invoke(b r100, CallContext r101) {
        b r102 = r100;
        Intrinsics.checkNotNullParameter(r102, "param");
        Intrinsics.checkNotNullParameter(r101, "callcontext");
        String r103 = r102.getType();
        int r104 = r103.hashCode();
        boolean r105 = true;
        int r106 = 0;
        if (r104 == (-1897185795)) goto L57;
        if (r104 == (-1624529469)) goto L46;
        if (r104 == 3579) goto L34;
        if (r104 == 1787165519) goto L12;
    L59:
        String r107 = r102.getType();
        switch(r107.hashCode()) {
            case -1890252483: goto L92;
            case -1393028996: goto L89;
            case -810698576: goto L85;
            case -365719550: goto L82;
            case -195439392: goto L79;
            case 3449699: goto L77;
            case 155698919: goto L75;
            case 545099575: goto L72;
            case 747804969: goto L69;
            case 1224424441: goto L66;
            case 1260517896: goto L63;
            default: goto L94;
        };
    L77:
        r107.equals("prop");
    L94:
        Object r108 = null;
    L95:
        if (r108 == null) goto L97;
        xs2.b.a().post(r108);
    L97:
        return null;
    L63:
        if (r107.equals(UserProfileEvent.POSITION_ROOM_INTRO) == false) goto L94;
        r108 = new zg1.b2(4);
        goto L95
    L66:
        if (r107.equals("webview") == false) goto L94;
        JsonObject r109 = r102.b();
        r109.get("type").toString();
        r109.get("url").toString();
        r109.get("level").getAsInt();
        r108 = new zg1.f2();
        goto L95
    L69:
        if (r107.equals("position") == false) goto L94;
        r108 = new zg1.b2(2);
        goto L95
    L72:
        if (r107.equals("gesture_magic") == false) goto L94;
        r108 = new zg1.z1();
        goto L95
    L75:
        if (r107.equals("gameCenter") == false) goto L94;
        Object r110 = new b30.l(j(r102.b()));
        k(15, r102);
    L87:
        r108 = r110;
        goto L95
    L79:
        if (r107.equals("bgMusic") == false) goto L94;
        r110 = new zg1.b2(3);
        k(14, r102);
        goto L87
    L82:
        if (r107.equals("audienceConnection") == false) goto L94;
        r110 = new zg1.b2(1);
        k(19, r102);
        goto L87
    L85:
        if (r107.equals("decoration") == false) goto L94;
        r110 = new b30.j(j(r102.b()));
        goto L87
    L89:
        if (r107.equals("beauty") == false) goto L94;
        r108 = new zg1.b2(0);
        goto L95
    L92:
        if (r107.equals("sticker") == false) goto L94;
        r108 = new zg1.c2(null);
        goto L95
    L12:
        if (r103.equals("pkStartDialog") == false) goto L59;
        JsonObject r111 = r102.b();
        if (r111 != null) goto L16;
    L22:
        int r112 = -1;
    L23:
        JsonObject r113 = r102.b();
        if (r113 != null) goto L26;
    L32:
        ((ILinkServiceExternal) jc1.k.n(ILinkServiceExternal.class)).getPanelServiceExternal().b(r106, r112);
        goto L97
    L26:
        if (r113.has("tabIndex") != true) goto L32;
        JsonObject r114 = r102.b();
        if (r114 == null) goto L32;
        JsonElement r115 = r114.get("tabIndex");
        if (r115 == null) goto L32;
        r106 = r115.getAsInt();
        goto L32
    L16:
        if (r111.has("selectTopPanel") != true) goto L22;
        JsonObject r116 = r102.b();
        if (r116 == null) goto L22;
        JsonElement r117 = r116.get("selectTopPanel");
        if (r117 == null) goto L22;
        r112 = r117.getAsInt();
        goto L23
    L34:
        if (r103.equals(PbRequest.SwitchType.PK) == false) goto L59;
        if (r102.b().has("position") == false) goto L43;
        JsonObject r118 = r102.b();
        if (r118 == null) goto L43;
        JsonElement r119 = r118.get("position");
        if (r119 == null) goto L43;
        String r120 = r119.getAsString();
        if (r120 == null) goto L43;
    L44:
        ((ILinkServiceExternal) jc1.k.n(ILinkServiceExternal.class)).getPanelServiceExternal().a(r120);
    L43:
        r120 = "";
        goto L44
    L46:
        if (r103.equals("link_list") == false) goto L59;
        if (r102.b() != null) goto L50;
    L54:
        r105 = false;
    L55:
        ((ILinkServiceExternal) jc1.k.n(ILinkServiceExternal.class)).getPanelServiceExternal().d(r105);
        goto L97
    L50:
        if (r102.b().has("highlight") == false) goto L54;
        if (r102.b().get("highlight").getAsJsonArray() == null) goto L54;
    L57:
        if (r103.equals("startPk") == false) goto L59;
        ((ILinkServiceExternal) jc1.k.n(ILinkServiceExternal.class)).getPanelServiceExternal().c();
        k(17, r102);
        goto L97
    }
}
