package com.bytedance.android.live.openplatform.impl.miniappanchor.api.response;

import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.openplatform.api.model.shelf.ProductInfo;
import com.bytedance.android.live.openplatform.api.model.shelf.ShelfCardInfo;
import com.bytedance.android.live.openplatform.api.model.shelf.ShelfMicroAppInfo;
import com.bytedance.android.live.openplatform.api.utils.SchemaInfo;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes46.dex */
@ProtoMessage("webcast.api.stamp.PresetCardList")
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\"\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappanchor/api/response/m;", "", "", "appId", "Ljava/lang/String;", "getAppId", "()Ljava/lang/String;", "appName", "getAppName", "appIcon", "getAppIcon", "", "Lcom/bytedance/android/live/openplatform/impl/miniappanchor/api/response/l;", "presetCardList", "Ljava/util/List;", "getPresetCardList", "()Ljava/util/List;", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class m implements vh7.h {

    @SerializedName("app_icon")
    protected String appIcon;

    @SerializedName("app_id")
    protected String appId;

    @SerializedName("app_name")
    protected String appName;

    @SerializedName("preset_card_list")
    protected List<l> presetCardList;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof m) == false) goto L14;
        m r101 = (m) r100;
        if (Intrinsics.areEqual(this.appId, r101.appId) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.appName, r101.appName) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.appIcon, r101.appIcon) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.presetCardList, r101.presetCardList) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        String r100 = this.appId;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.appName;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.appIcon;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        List<l> r110 = this.presetCardList;
        if (r110 == null) goto L18;
        r101 = r110.hashCode();
    L18:
        return r109 + r101;
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
        return "PresetCardList(appId=" + this.appId + ", appName=" + this.appName + ", appIcon=" + this.appIcon + ", presetCardList=" + this.presetCardList + ")";
    }

    public m() {
        this.appId = null;
        this.appName = null;
        this.appIcon = null;
        this.presetCardList = null;
    }

    public m(am3.g r100) {
        this.presetCardList = new ArrayList();
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L18;
        if (r102 != 1) goto L8;
        this.appId = am3.h.c(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.appName = am3.h.c(r100);
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.appIcon = am3.h.c(r100);
        goto L3
    L12:
        if (r102 != 4) goto L13;
        this.presetCardList.add(new l(r100));
        goto L3
    L13:
        am3.h.e(r100);
        goto L3
    L18:
        r100.d(r101);
        if (this.appId != null) goto L22;
        this.appId = null;
    L22:
        if (this.appName != null) goto L25;
        this.appName = null;
    L25:
        if (this.appIcon != null) goto L28;
        this.appIcon = null;
    L28:
        if (this.presetCardList.isEmpty() == false) goto L46;
        this.presetCardList = null;
        return;
    }

    public final List<ShelfCardInfo> a(boolean r310) {
        ArrayList r100 = new ArrayList();
        List<l> r101 = this.presetCardList;
        if (r101 == null) goto L24;
        Iterator<T> r102 = r101.iterator();
    L6:
        if (r102.hasNext() == false) goto L24;
        l r103 = (l) r102.next();
        String r110 = r103.sourcePath;
        String r104 = r103.schema;
        String r105 = r103.title;
        ImageModel r106 = r103.image;
        if (r106 == null) goto L12;
        List<String> r107 = r106.getUrls();
        if (r107 == null) goto L12;
        String r111 = (String) CollectionsKt.firstOrNull(r107);
    L13:
        int r112 = ShelfCardInfo.Source.Phone.getValue();
        JSONObject r108 = new JSONObject();
        if (r310 == false) goto L16;
        String r109 = "in_live";
    L17:
        r108.put("adding_page_live_status", r109);
        Unit r113 = Unit.INSTANCE;
        String r114 = r108.toString();
        ProductInfo r115 = r103.productInfo;
        ImageModel r116 = r103.image;
        if (r116 == null) goto L22;
        List<String> r117 = r116.getUrls();
        if (r117 == null) goto L22;
        String r210 = (String) CollectionsKt.firstOrNull(r117);
    L23:
        String r118 = r111;
        String r119 = r210;
        r100.add(new ShelfCardInfo(r104, r105, r118, null, null, r110, false, 0, r112, r114, null, r115, null, r119, null, r103.title, null, 1, 0, 528383459, 5));
    L22:
        r210 = null;
        goto L23
    L16:
        r109 = "before_live";
    L12:
        r111 = null;
    L24:
        return r100;
    }

    public final ShelfMicroAppInfo b(boolean r100) {
        String r101 = this.appId;
        String r102 = this.appName;
        String r103 = null;
        ImageModel r104 = new ImageModel(null, CollectionsKt.listOf(this.appIcon));
        SchemaInfo.a r105 = new SchemaInfo.a();
        String r106 = this.appId;
        if (r106 != null) goto L5;
        r106 = "";
    L5:
        r105.a(r106);
        SchemaInfo r107 = r105.c();
        if (r107 == null) goto L8;
        r103 = r107.h();
    L8:
        int r108 = r100 ? 1 : 0;
        return new ShelfMicroAppInfo(r101, r102, r104, r103, r108, 32);
    }
}
