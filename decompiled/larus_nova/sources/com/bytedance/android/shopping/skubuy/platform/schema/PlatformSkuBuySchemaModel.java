package com.bytedance.android.shopping.skubuy.platform.schema;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import com.bytedance.android.bcm.api.model.BcmParams;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.common.api.entranceinfo.IEntranceInfoService;
import com.bytedance.android.ec.core.buynow.OrderSchemaNotSupportException;
import com.bytedance.android.ec.core.hybrid.utils.j;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.utils.UrlBuilderV2;
import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.android.ec.core.utils.z1;
import com.bytedance.android.ec.model.abscontainer.ISkuBuySchemaModel;
import com.bytedance.android.ec.model.entranceinfo.EntranceInfoScene;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.shopping.extensions.k;
import com.ss.android.ugc.aweme.search.vision.model.data.PhotoEnterModel;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010.\u001a\u00020-¢\u0006\u0004\b0\u00101B\u0019\b\u0016\u0012\u0006\u00102\u001a\u00020\u0003\u0012\u0006\u00104\u001a\u000203¢\u0006\u0004\b0\u00105B\u0019\b\u0016\u0012\u0006\u00102\u001a\u000206\u0012\u0006\u00104\u001a\u000203¢\u0006\u0004\b0\u00107J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0016\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00050\tH\u0016J\u0018\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003H\u0016J\b\u0010\f\u001a\u00020\u0003H\u0016J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u00032\u0006\u0010\r\u001a\u00020\u0003H\u0016J\u0016\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030\tH\u0016J\n\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J\u0014\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050\tH\u0016J2\u0010\u0017\u001a\u00020\u00072\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0015\u001a\u00020\u00032\u0016\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\tH\u0016J\u0018\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\tH\u0016J\u0016\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0019H\u0016J\u0010\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0003H\u0016J\n\u0010\u001d\u001a\u0004\u0018\u00010\u0003H\u0016J\u0016\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0019H\u0016J\t\u0010 \u001a\u00020\u001fHÖ\u0001J\u0019\u0010$\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020\u001fHÖ\u0001R$\u0010%\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010&R$\u0010'\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010&R\u0018\u0010(\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010)R\u001a\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00030*8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0014\u0010.\u001a\u00020-8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010/¨\u00068"}, d2 = {"Lcom/bytedance/android/shopping/skubuy/platform/schema/PlatformSkuBuySchemaModel;", "Lcom/bytedance/android/ec/model/abscontainer/ISkuBuySchemaModel;", "Ljava/io/Serializable;", "", "key", "", "value", "", "putValueInSkuLogData", "", "getSkuLogData", "replaceOrAppendParam", "formatToUrl", "queryName", "getQueryParam", "getAllQueryParams", "Lgl/a;", "getEntranceInfo", "recordInfo", "Landroid/view/View;", "view", "btmId", "params", "appendBtmToken", "getMegaObject", "", "skuBuyTimestamp", "entranceInfo", "setFixEntranceInfoStr", "getFixEntranceInfoStr", "getSimplifyQueryParams", "", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "writeToParcel", "megaObject", "Ljava/util/Map;", "timestamps", "fixEntranceInfo", "Ljava/lang/String;", "", "queryNameBlackList", "Ljava/util/Set;", "Lcom/bytedance/android/ec/core/utils/UrlBuilderV2;", "urlBuilder", "Lcom/bytedance/android/ec/core/utils/UrlBuilderV2;", "<init>", "(Lcom/bytedance/android/ec/core/utils/UrlBuilderV2;)V", "originUrl", "Lcom/bytedance/android/ec/model/entranceinfo/EntranceInfoScene;", "entranceInfoScene", "(Ljava/lang/String;Lcom/bytedance/android/ec/model/entranceinfo/EntranceInfoScene;)V", "Landroid/net/Uri;", "(Landroid/net/Uri;Lcom/bytedance/android/ec/model/entranceinfo/EntranceInfoScene;)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PlatformSkuBuySchemaModel implements ISkuBuySchemaModel, Serializable {
    public static final Parcelable.Creator<PlatformSkuBuySchemaModel> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient gl.a f183171a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final transient Map<String, Object> f183172b;
    private String fixEntranceInfo;
    private Map<String, Object> megaObject;
    private final Set<String> queryNameBlackList;
    private Map<String, Object> timestamps;
    private final UrlBuilderV2 urlBuilder;

    public static class a implements Parcelable.Creator<PlatformSkuBuySchemaModel> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final PlatformSkuBuySchemaModel createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "in");
            return new PlatformSkuBuySchemaModel((UrlBuilderV2) r100.readSerializable());
        }

        @Override // android.os.Parcelable.Creator
        public final PlatformSkuBuySchemaModel[] newArray(int r100) {
            return new PlatformSkuBuySchemaModel[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeSerializable(this.urlBuilder);
    }

    public final void a() {
        gl.a r100 = this.f183171a;
        if (r100 == null) goto L5;
        this.megaObject.put(com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_INFO, r100.h());
    L5:
        Map<String, Object> r101 = this.f183172b;
        this.megaObject.put("sku_log_data", r101.toString());
        Map<String, Object> r102 = this.megaObject;
        this.urlBuilder.addOrReplaceParam("mega_object", r102.toString());
    }

    @Override // com.bytedance.android.ec.model.abscontainer.ISkuBuySchemaModel
    public Map<String, Object> getMegaObject() {
        String r100 = this.fixEntranceInfo;
        if (r100 == null) goto L6;
        this.megaObject.put(com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_INFO, r100);
    L6:
        return this.megaObject;
    }

    @Override // com.bytedance.android.ec.model.abscontainer.ISkuBuySchemaModel
    public Map<String, String> getSimplifyQueryParams() {
        Map<String, String> r100 = MapsKt.toMutableMap(this.urlBuilder.getMMap());
        r100.remove("mega_object");
        r100.remove("buynow_time");
        r100.remove("log_data");
        r100.remove(com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_INFO);
        r100.remove("detail_url");
        r100.put("show_detail_entrance", String.valueOf(k.c(this.urlBuilder.getMMap().get("detail_url"))));
        return r100;
    }

    @Override // com.bytedance.android.ec.model.abscontainer.ISchemaModel
    public Map<String, Object> recordInfo() {
        return k.b(this.timestamps);
    }

    @Override // com.bytedance.android.ec.model.abscontainer.ISchemaModel
    public String formatToUrl() {
        a();
        return this.urlBuilder.toString();
    }

    public Map<String, String> getAllQueryParams() {
        a();
        return this.urlBuilder.getMMap();
    }

    @Override // com.bytedance.android.ec.model.abscontainer.ISchemaModel
    public gl.a getEntranceInfo() {
        return this.f183171a;
    }

    @Override // com.bytedance.android.ec.model.abscontainer.ISkuBuySchemaModel
    public String getFixEntranceInfoStr() {
        return this.fixEntranceInfo;
    }

    @Override // com.bytedance.android.ec.model.abscontainer.ISkuBuySchemaModel
    public Map<String, Object> getSkuLogData() {
        return this.f183172b;
    }

    @Override // com.bytedance.android.ec.model.abscontainer.ISkuBuySchemaModel
    public Map<String, Object> skuBuyTimestamp() {
        return this.timestamps;
    }

    public PlatformSkuBuySchemaModel(UrlBuilderV2 r100) {
        Intrinsics.checkNotNullParameter(r100, "urlBuilder");
        this.urlBuilder = r100;
        Map<String, Object> r101 = k.z(r100.getQuery("mega_object"));
        if (r101 != null) goto L5;
        r101 = new LinkedHashMap();
    L5:
        this.megaObject = r101;
        Object r102 = r101.get("sku_log_data");
        Object r103 = null;
        if ((r102 instanceof String) == true) goto L8;
        r102 = null;
    L8:
        String r104 = (String) r102;
        if (r104 == null) goto L12;
        Map<String, Object> r105 = k.z(r104);
        if (r105 == null) goto L12;
    L13:
        this.f183172b = r105;
        Object r106 = this.megaObject.get("buynow_time");
        if ((r106 instanceof String) == false) goto L17;
        r103 = r106;
    L17:
        String r107 = (String) r103;
        if (r107 == null) goto L21;
        Map<String, Object> r108 = k.z(r107);
        if (r108 == null) goto L21;
    L22:
        this.timestamps = r108;
        this.queryNameBlackList = SetsKt.setOf(new String[]{"mega_object", com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_INFO, "log_data", "sku_log_data"});
        return;
    L21:
        r108 = new LinkedHashMap();
    L12:
        r105 = new LinkedHashMap();
        goto L13
    }

    public final void b(EntranceInfoScene r100) {
        int r101 = ECSdk.f48106a;
        IEntranceInfoService r102 = (IEntranceInfoService) ECSdk.a(IEntranceInfoService.class);
        gl.a r103 = null;
        Object r104 = null;
        if (r102 == null) goto L9;
        Object r105 = this.megaObject.get(com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_INFO);
        if ((r105 instanceof String) == false) goto L8;
        r104 = r105;
    L8:
        r103 = r102.initEntranceInfo(r100, (String) r104);
    L9:
        this.f183171a = r103;
        String r106 = this.urlBuilder.getQuery(com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_INFO);
        if (r106 == null) goto L14;
        JSONObject r107 = z1.f(r106);
        gl.a r108 = this.f183171a;
        if (r108 == null) goto L14;
        r108.i(r107);
    L14:
        String[] r109 = j.f44313b;
        int r110 = r109.length;
        int r111 = 0;
    L15:
        if (r111 >= r110) goto L20;
        String r112 = r109[r111];
        String r113 = this.urlBuilder.getQuery(r112);
        if (r113 == null) goto L19;
        this.megaObject.put(r112, r113);
    L19:
        this.urlBuilder.removeParam(r112);
        r111 = r111 + 1;
        goto L15
    L20:
        this.megaObject.remove(com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_INFO);
        this.megaObject.remove("log_data");
    }

    @Override // com.bytedance.android.ec.model.abscontainer.ISchemaModel
    public String getQueryParam(String r100) {
        Intrinsics.checkNotNullParameter(r100, "queryName");
        if (this.queryNameBlackList.contains(r100) == false) goto L8;
        if (ECAppInfoService.f48114e.i() == false) goto L8;
        ECExceptionMonitor.e(new OrderSchemaNotSupportException("不支持直接获取 " + r100));
    L8:
        return this.urlBuilder.getMMap().get(r100);
    }

    @Override // com.bytedance.android.ec.model.abscontainer.ISkuBuySchemaModel
    public void setFixEntranceInfoStr(String r100) {
        Intrinsics.checkNotNullParameter(r100, "entranceInfo");
        this.fixEntranceInfo = r100;
    }

    public PlatformSkuBuySchemaModel(Uri r100, EntranceInfoScene r101) {
        Intrinsics.checkNotNullParameter(r100, "originUrl");
        Intrinsics.checkNotNullParameter(r101, "entranceInfoScene");
        this(new UrlBuilderV2(r100));
        b(r101);
    }

    @Override // com.bytedance.android.ec.model.abscontainer.ISkuBuySchemaModel
    public void putValueInSkuLogData(String r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "value");
        this.f183172b.put(r100, r101);
    }

    @Override // com.bytedance.android.ec.model.abscontainer.ISchemaModel
    public void replaceOrAppendParam(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "value");
        if (this.queryNameBlackList.contains(r100) == true) goto L5;
    L7:
        this.urlBuilder.addOrReplaceParam(r100, r101);
        return;
    L5:
        if (ECAppInfoService.f48114e.i() == false) goto L7;
        ECExceptionMonitor.e(new OrderSchemaNotSupportException("不支持直接更新 " + r100));
        goto L7
    }

    public PlatformSkuBuySchemaModel(String r100, EntranceInfoScene r101) {
        Intrinsics.checkNotNullParameter(r100, "originUrl");
        Intrinsics.checkNotNullParameter(r101, "entranceInfoScene");
        this(new UrlBuilderV2(r100));
        b(r101);
    }

    @Override // com.bytedance.android.ec.model.abscontainer.ISchemaModel
    public void appendBtmToken(View r100, String r101, Map<String, ? extends Object> r102) {
        Intrinsics.checkNotNullParameter(r101, "btmId");
        BcmParams.Companion.getClass();
        BcmParams r103 = BcmParams.a.c(r102);
        String r104 = a2.d(BtmSDK.INSTANCE.createJumpSourceBtmToken(r101, PageFinder.via(r100), r103));
        if (r104 == null) goto L6;
        this.urlBuilder.addOrReplaceParam(PhotoEnterModel.SOURCE_BTM_TOKEN, r104);
        return;
    }
}
