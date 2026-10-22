package com.bytedance.android.live.broadcastgame.api.model;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import com.ss.android.downloadlib.constants.EventConstants;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@ProtoMessage("webcast.api.room.RoomInteractData")
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\b\u0087\b\u0018\u00002\u00020\u0001R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u001c\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\f\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u000e\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\rR\u001e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\nR\u0016\u0010\u0010\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/api/model/u;", "Lcom/bytedance/android/live/broadcastgame/api/model/l;", "", "interactId", "I", "", "name", "Ljava/lang/String;", "", "iconUrl", "Ljava/util/List;", "", "rank", "J", "groupType", "supportiveEntrance", "extra", "livebroadcastgame-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class u implements l, vh7.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f59369a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public n f59370b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f59371c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f59372d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f59373e;

    @SerializedName("extra")
    public String extra;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f59374f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f59375g;

    @SerializedName("group_type")
    public long groupType;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public com.bytedance.android.live.broadcastgame.api.interactgame.p f59376h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f59377i;

    @SerializedName("icon_url")
    public List<String> iconUrl;

    @SerializedName("interact_id")
    public int interactId;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public List<String> f59378j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public r f59379k;

    @SerializedName("name")
    public String name;

    @SerializedName("rank")
    public long rank;

    @SerializedName("support_live_entrance_list")
    public List<Long> supportiveEntrance;

    public final String toString() {
        return "InteractItem(interactId=" + this.interactId + ", name=" + this.name + ", iconUrl=" + this.iconUrl + ", rank=" + this.rank + ", groupType=" + this.groupType + ", supportiveEntrance=" + this.supportiveEntrance + ", extra=" + this.extra + ")";
    }

    public final r c() {
        boolean r100 = this.f59369a;
        if (r100 == true) goto L25;
        if (r100 == true) goto L25;
        String r101 = this.extra;
        if (r101 != null) goto L9;
    L12:
        boolean r102 = true;
    L13:
        if (r102 == false) goto L26;
    L23:
        this.f59369a = true;
        goto L25
    L26:
        JsonObject r103 = GsonHelper.parser().parse(this.extra).getAsJsonObject();     // Catch: Exception -> L21
        r103.addProperty(EventConstants.ExtraJson.GAME_NAME, this.name);     // Catch: Exception -> L21
        r103.addProperty("anchor_live_version", Integer.valueOf(com.bytedance.android.livesdk.paas.c.b()));     // Catch: Exception -> L21
        r r104 = (r) GsonHelper.get().fromJson(r103, r.class);     // Catch: Exception -> L21
        this.f59379k = r104;     // Catch: Exception -> L21
        if (r104 != null) goto L17;
    L19:
        r103.toString();     // Catch: Exception -> L21
        goto L23
    L17:
        if (this.interactId != InteractID.EffectGame.getValue()) goto L19;
        r103.addProperty("game_identifier", Long.valueOf(r104.l()));     // Catch: Exception -> L21
    L21:
        e = move-exception;
        e.printStackTrace();
        goto L23
    L9:
        if (r101.length() == 0) goto L12;
        r102 = false;
    L25:
        return this.f59379k;
    }

    public final String e() {
        int r100 = w.f59380a;
        return w.a.a(this.interactId, this.name, c(), this.extra);
    }

    public final int hashCode() {
        return (((this.name.hashCode() * 31) + this.iconUrl.hashCode()) * 31) + this.extra.hashCode();
    }

    public u() {
        this.f59370b = new n(0);
        this.f59372d = "";
        this.f59374f = "";
        this.f59375g = -1;
        this.f59377i = "";
        this.f59378j = new ArrayList();
        this.interactId = InteractID.Unknown.getValue();
        this.name = "";
        this.iconUrl = new ArrayList();
        this.rank = 0;
        this.groupType = 0;
        this.supportiveEntrance = new ArrayList();
        this.extra = "";
    }

    @Override // com.bytedance.android.live.broadcastgame.api.model.l
    public final r d() {
        return c();
    }

    @Override // com.bytedance.android.live.broadcastgame.api.model.l
    public final List<Long> a() {
        return this.supportiveEntrance;
    }

    @Override // com.bytedance.android.live.broadcastgame.api.model.l
    public final int b() {
        return this.interactId;
    }

    public u(am3.g r100) {
        this.iconUrl = new ArrayList();
        this.supportiveEntrance = new ArrayList();
        int r101 = 0;
        this.f59370b = new n(0);
        this.f59372d = "";
        this.f59374f = "";
        this.f59375g = -1;
        this.f59377i = "";
        this.f59378j = new ArrayList();
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L15;
        switch(r103) {
            case 1: goto L14;
            case 2: goto L13;
            case 3: goto L11;
            case 4: goto L10;
            case 5: goto L9;
            case 6: goto L8;
            case 7: goto L7;
            default: goto L6;
        };
    L7:
        List r104 = this.supportiveEntrance;
        Comparable r105 = Long.valueOf(r100.j());
    L12:
        r104.add(r105);
        goto L3
    L8:
        this.extra = am3.h.c(r100);
        goto L3
    L9:
        this.groupType = r100.j();
        r101 = r101 | 4;
        goto L3
    L10:
        this.rank = r100.j();
        r101 = r101 | 2;
        goto L3
    L11:
        r104 = this.iconUrl;
        r105 = am3.h.c(r100);
        goto L12
    L13:
        this.name = am3.h.c(r100);
        goto L3
    L14:
        this.interactId = r100.i();
        r101 = r101 | 1;
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L15:
        r100.d(r102);
        if ((r101 & 1) != 0) goto L19;
        this.interactId = InteractID.Unknown.getValue();
    L19:
        if (this.name != null) goto L22;
        this.name = "";
    L22:
        if (this.iconUrl.isEmpty() == false) goto L25;
        this.iconUrl = new ArrayList();
    L25:
        if ((r101 & 2) != 0) goto L28;
        this.rank = 0;
    L28:
        if ((r101 & 4) != 0) goto L31;
        this.groupType = 0;
    L31:
        if (this.supportiveEntrance.isEmpty() == false) goto L34;
        this.supportiveEntrance = new ArrayList();
    L34:
        if (this.extra != null) goto L54;
        this.extra = "";
        return;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 == null) goto L8;
        Class<?> r101 = r100.getClass();
    L10:
        if ((!Intrinsics.areEqual(u.class, r101)) == false) goto L12;
        return false;
    L12:
        if (r100 == null) goto L24;
        u r102 = (u) r100;
        if ((!Intrinsics.areEqual(this.name, r102.name)) == false) goto L17;
        return false;
    L17:
        if ((!Intrinsics.areEqual(this.iconUrl, r102.iconUrl)) == false) goto L20;
        return false;
    L20:
        if ((!Intrinsics.areEqual(e(), r102.e())) == false) goto L22;
        return false;
    L22:
        return true;
    L24:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.broadcastgame.api.model.InteractItem");
    L8:
        r101 = null;
        goto L10
    }

    public /* synthetic */ u(int r110, String r111, List r112, String r113, int r114) {
        if ((r114 & 1) == 0) goto L5;
        r110 = InteractID.Unknown.getValue();
    L5:
        int r100 = r110;
        if ((r114 & 2) == 0) goto L8;
        String r101 = "";
    L10:
        if ((r114 & 4) == 0) goto L12;
        r112 = new ArrayList();
    L12:
        List r102 = r112;
        if ((r114 & 32) == 0) goto L15;
        ArrayList r115 = new ArrayList();
    L16:
        ArrayList r103 = r115;
        if ((r114 & 64) == 0) goto L19;
        String r104 = "";
    L20:
        this(r100, r101, r102, 0, 0, r103, r104);
        return;
    L19:
        r104 = r113;
        goto L20
    L15:
        r115 = null;
        goto L16
    L8:
        r101 = r111;
        goto L10
    }

    public u(int r100, String r101, List<String> r102, long r103, long r104, List<Long> r105, String r110) {
        Intrinsics.checkNotNullParameter(r101, "name");
        Intrinsics.checkNotNullParameter(r102, "iconUrl");
        Intrinsics.checkNotNullParameter(r110, "extra");
        this.interactId = r100;
        this.name = r101;
        this.iconUrl = r102;
        this.rank = r103;
        this.groupType = r104;
        this.supportiveEntrance = r105;
        this.extra = r110;
        this.f59370b = new n(0);
        this.f59372d = "";
        this.f59374f = "";
        this.f59375g = -1;
        this.f59377i = "";
        this.f59378j = new ArrayList();
    }
}
