package com.bytedance.android.bcm.impl.model;

import com.amap.api.col.s.ce;
import com.bytedance.android.bcm.api.model.BcmParams;
import com.bytedance.android.btm.api.inner.ALogger;
import com.bytedance.android.btm.impl.page.model.PageInfo;
import com.bytedance.android.btm.impl.page.model.i;
import com.bytedance.android.btm.impl.setting.BtmSetting;
import com.lynx.serval.svg.SVGRenderEngine;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 ,2\u00020\u00012\u00020\u0002:\u0001-B\u0007¢\u0006\u0004\b*\u0010+J\b\u0010\u0003\u001a\u00020\u0000H\u0016J\u001a\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\r\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\nH\u0016J\u0006\u0010\u000f\u001a\u00020\u000eJ\u0010\u0010\u0010\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004R0\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00118F@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R0\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00118F@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u0014\u001a\u0004\b\u001b\u0010\u0016\"\u0004\b\u001c\u0010\u0018R2\u0010!\u001a\u0012\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00118F@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u0014\u001a\u0004\b\u001f\u0010\u0016\"\u0004\b \u0010\u0018R$\u0010)\u001a\u0004\u0018\u00010\"8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(¨\u0006."}, d2 = {"Lcom/bytedance/android/bcm/impl/model/BcmPageInfo;", "Lcom/bytedance/android/btm/impl/page/model/PageInfo;", "Ljava/io/Serializable;", "copy", "", "page", "Lcom/bytedance/android/btm/impl/page/model/i;", "pausedInfo", "", "onPause", "", SVGRenderEngine.SAVE, "data", "parse", "Lkc/c;", "snapshot", "setPageParamsByProvider", "", "Lcom/bytedance/android/bcm/api/model/BcmParams;", "f", "Ljava/util/Map;", "getPageParams", "()Ljava/util/Map;", "setPageParams", "(Ljava/util/Map;)V", "pageParams", ce.f26391f, "getUnitParams", "setUnitParams", "unitParams", "h", "getEventParams", "setEventParams", "eventParams", "Lcom/bytedance/android/bcm/api/provider/a;", RXScreenCaptureService.KEY_INDEX, "Lcom/bytedance/android/bcm/api/provider/a;", "getPageParamsProvider", "()Lcom/bytedance/android/bcm/api/provider/a;", "setPageParamsProvider", "(Lcom/bytedance/android/bcm/api/provider/a;)V", "pageParamsProvider", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "bcm-impl_cnRelease"}, k = 1, mv = {1, 4, 0})
public final class BcmPageInfo extends PageInfo {
    public static final a Companion = null;
    private static final long serialVersionUID = 20220211;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public transient Map<String, BcmParams> f41812f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public transient Map<String, BcmParams> f41813g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public transient Map<String, Object> f41814h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public transient com.bytedance.android.bcm.api.provider.a f41815i;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.bytedance.android.btm.impl.page.model.PageInfo
    public BcmPageInfo copy() {
        c r100 = c.f41818a;
        BcmPageInfo r101 = new BcmPageInfo();
        super.copy(r101);
        r101.f41812f = getPageParams();
        r101.f41813g = getUnitParams();
        r101.f41814h = getEventParams();
        return r101;
    }

    public final Map<String, Object> getEventParams() {
        if (this.f41814h != null) goto L6;
        this.f41814h = new LinkedHashMap();
    L6:
        return this.f41814h;
    }

    public final Map<String, BcmParams> getPageParams() {
        if (this.f41812f != null) goto L6;
        this.f41812f = new LinkedHashMap();
    L6:
        return this.f41812f;
    }

    public final Map<String, BcmParams> getUnitParams() {
        if (this.f41813g != null) goto L6;
        this.f41813g = new LinkedHashMap();
    L6:
        return this.f41813g;
    }

    public final kc.c snapshot() {
        kc.c r100 = new kc.c(getPageParams(), getUnitParams());
        getClassSimpleName();
        return r100;
    }

    @Override // com.bytedance.android.btm.impl.page.model.PageInfo, xc.a
    public String save() {
        return super.save();
    }

    public BcmPageInfo() {
    }

    public final com.bytedance.android.bcm.api.provider.a getPageParamsProvider() {
        return this.f41815i;
    }

    @Override // com.bytedance.android.btm.impl.page.model.PageInfo
    public /* bridge */ /* synthetic */ PageInfo copy() {
        return copy();
    }

    @Override // com.bytedance.android.btm.impl.page.model.PageInfo, xc.a
    public PageInfo parse(String r100) {
        return super.parse(r100);
    }

    public final void setEventParams(Map<String, Object> r100) {
        this.f41814h = r100;
    }

    public final void setPageParams(Map<String, BcmParams> r100) {
        this.f41812f = r100;
    }

    public final void setPageParamsByProvider(Object r100) {
        com.bytedance.android.bcm.api.provider.a r101 = this.f41815i;
        com.bytedance.android.bcm.api.provider.a r102 = r101;
        if (r101 == null) goto L6;
    L9:
        if (r102 == null) goto L27;
        getPageBtm();
        if (getPageParams() != null) goto L14;
        new LinkedHashMap();
    L14:
        Map r103 = r102.a();
        if (BtmSetting.f42469d.c().b().F() == 1) goto L17;
        this.f41812f = MapsKt.toMutableMap(r103);
    L25:
        ALogger.f41996d.a("BcmPageInfo_setPageParamsByProvider", false, new BcmPageInfo$setPageParamsByProvider$$inlined$let$lambda$1(this));
        return;
    L17:
        if (r103 == getPageParams()) goto L25;
        Map<String, BcmParams> r104 = getPageParams();
        if (r104 == null) goto L21;
        r104.clear();
    L21:
        Map<String, BcmParams> r105 = getPageParams();
        if (r105 == null) goto L25;
        r105.putAll(r103);
        goto L25
    L27:
        return;
    L6:
        if ((r100 instanceof com.bytedance.android.bcm.api.provider.a) == true) goto L8;
        r100 = null;
    L8:
        r102 = (com.bytedance.android.bcm.api.provider.a) r100;
        goto L9
    }

    public final void setPageParamsProvider(com.bytedance.android.bcm.api.provider.a r100) {
        this.f41815i = r100;
    }

    public final void setUnitParams(Map<String, BcmParams> r100) {
        this.f41813g = r100;
    }

    @Override // com.bytedance.android.btm.impl.page.model.PageInfo, xc.a
    public /* bridge */ /* synthetic */ Object parse(String r100) {
        return parse(r100);
    }

    @Override // com.bytedance.android.btm.impl.page.model.PageInfo
    public void onPause(Object r100, i r101) {
        if (BtmSetting.f42469d.c().b().G() != 1) goto L5;
        setPageParamsByProvider(r100);
    L5:
        super.onPause(r100, r101);
    }
}
