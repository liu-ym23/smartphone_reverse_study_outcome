package com.bytedance.android.live.openplatform.impl.miniappanchor.choose.model;

import am3.g;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.base.model.x;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import com.tencent.open.SocialConstants;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import vh7.h;

/* JADX INFO: loaded from: classes46.dex */
@ProtoMessage("webcast.api.stamp.MicroappInteractEntranceCell")
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001R\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u0004R\u0016\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u0004R\u001c\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0004¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappanchor/choose/model/MiniAppEntranceCell;", "", "", "title", "Ljava/lang/String;", SocialConstants.PARAM_APP_DESC, "Lcom/bytedance/android/live/base/model/ImageModel;", "icon", "Lcom/bytedance/android/live/base/model/ImageModel;", "", "groupId", "J", "appId", "schema", "", "serverScenes", "Ljava/util/List;", "extendExtra", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MiniAppEntranceCell implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f84118a;

    @SerializedName("appid")
    public String appId;

    @SerializedName(SocialConstants.PARAM_APP_DESC)
    public String desc;

    @SerializedName("extend_extra")
    public String extendExtra;

    @SerializedName("group_id")
    public long groupId;

    @SerializedName("icon")
    public ImageModel icon;

    @SerializedName("schema")
    public String schema;

    @SerializedName("call_server_scenes")
    public List<String> serverScenes;

    @SerializedName("title")
    public String title;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof MiniAppEntranceCell) == false) goto L22;
        MiniAppEntranceCell r101 = (MiniAppEntranceCell) r100;
        if (Intrinsics.areEqual(this.title, r101.title) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.desc, r101.desc) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.icon, r101.icon) == true) goto L12;
        return false;
    L12:
        if (this.groupId == r101.groupId) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.appId, r101.appId) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.schema, r101.schema) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.serverScenes, r101.serverScenes) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.extendExtra, r101.extendExtra) == true) goto L34;
        return false;
    L34:
        return true;
    L22:
        return false;
    }

    public final int hashCode() {
        String r100 = this.title;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.desc;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        ImageModel r107 = this.icon;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        long r110 = this.groupId;
        int r111 = (r109 + ((int) (r110 ^ (r110 >>> 32)))) * 31;
        String r112 = this.appId;
        if (r112 == null) goto L17;
        int r113 = r112.hashCode();
    L18:
        int r114 = (r111 + r113) * 31;
        String r115 = this.schema;
        if (r115 == null) goto L21;
        int r116 = r115.hashCode();
    L22:
        int r117 = (r114 + r116) * 31;
        List<String> r118 = this.serverScenes;
        if (r118 == null) goto L25;
        int r119 = r118.hashCode();
    L26:
        int r120 = (r117 + r119) * 31;
        String r121 = this.extendExtra;
        if (r121 == null) goto L30;
        r101 = r121.hashCode();
    L30:
        return r120 + r101;
    L25:
        r119 = 0;
        goto L26
    L21:
        r116 = 0;
        goto L22
    L17:
        r113 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "MiniAppEntranceCell(title=" + this.title + ", desc=" + this.desc + ", icon=" + this.icon + ", groupId=" + this.groupId + ", appId=" + this.appId + ", schema=" + this.schema + ", serverScenes=" + this.serverScenes + ", extendExtra=" + this.extendExtra + ")";
    }

    public final String a() {
        return ((JSONObject) this.f84118a.getValue()).optString("recommend_reason", "");
    }

    public MiniAppEntranceCell() {
        this.f84118a = LazyKt.lazy(new MiniAppEntranceCell$extendExtraJson$2(this));
        this.title = null;
        this.desc = null;
        this.icon = null;
        this.groupId = 0;
        this.appId = null;
        this.schema = null;
        this.serverScenes = new ArrayList();
        this.extendExtra = null;
    }

    public MiniAppEntranceCell(g r100) {
        this.serverScenes = new ArrayList();
        this.f84118a = LazyKt.lazy(new MiniAppEntranceCell$extendExtraJson$2(this));
        long r101 = r100.c();
        boolean r102 = false;
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L17;
        if (r103 != 101) goto L7;
        this.extendExtra = am3.h.c(r100);
        goto L3
    L7:
        switch(r103) {
            case 1: goto L15;
            case 2: goto L14;
            case 3: goto L13;
            case 4: goto L12;
            case 5: goto L11;
            case 6: goto L10;
            case 7: goto L9;
            default: goto L8;
        };
    L9:
        this.serverScenes.add(am3.h.c(r100));
        goto L3
    L10:
        this.schema = am3.h.c(r100);
        goto L3
    L11:
        this.appId = am3.h.c(r100);
        goto L3
    L12:
        this.groupId = r100.i();
        r102 = r102 | true;
        goto L3
    L13:
        this.icon = x.a(r100);
        goto L3
    L14:
        this.desc = am3.h.c(r100);
        goto L3
    L15:
        this.title = am3.h.c(r100);
        goto L3
    L8:
        am3.h.e(r100);
        goto L3
    L17:
        r100.d(r101);
        if (this.title != null) goto L21;
        this.title = null;
    L21:
        if (this.desc != null) goto L24;
        this.desc = null;
    L24:
        if (this.icon != null) goto L27;
        this.icon = null;
    L27:
        if ((r102 & true) == true) goto L30;
        this.groupId = 0;
    L30:
        if (this.appId != null) goto L33;
        this.appId = null;
    L33:
        if (this.schema != null) goto L36;
        this.schema = null;
    L36:
        if (this.serverScenes.isEmpty() == false) goto L39;
        this.serverScenes = new ArrayList();
    L39:
        if (this.extendExtra != null) goto L63;
        this.extendExtra = null;
        return;
    }

    public MiniAppEntranceCell(String r100, String r101, ImageModel r102, long r103, String r104, String r105, List<String> r106, String r107) {
        this.title = r100;
        this.desc = r101;
        this.icon = r102;
        this.groupId = r103;
        this.appId = r104;
        this.schema = r105;
        this.serverScenes = r106;
        this.extendExtra = r107;
        this.f84118a = LazyKt.lazy(new MiniAppEntranceCell$extendExtraJson$2(this));
    }
}
