package com.bytedance.android.shopping.store.tabkit.model;

import com.amap.api.col.s.ce;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.officesdk.api.init.OfficeSDKRequestTag;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001(B\u0007¢\u0006\u0004\bM\u0010NR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR*\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R$\u0010\u0018\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0013\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u0017R$\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R$\u0010\"\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\"\u0010\u001d\u001a\u0004\b#\u0010\u001f\"\u0004\b$\u0010!R$\u0010&\u001a\u0004\u0018\u00010%8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R0\u0010.\u001a\u0010\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020-\u0018\u00010,8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R$\u00105\u001a\u0004\u0018\u0001048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R$\u0010<\u001a\u0004\u0018\u00010;8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR$\u0010C\u001a\u0004\u0018\u00010B8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bC\u0010D\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR0\u0010J\u001a\u0010\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020I\u0018\u00010,8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bJ\u0010/\u001a\u0004\bK\u00101\"\u0004\bL\u00103¨\u0006O"}, d2 = {"Lcom/bytedance/android/shopping/store/tabkit/model/z;", "", "Lcom/bytedance/android/shopping/store/tabkit/model/e;", "navbarConfig", "Lcom/bytedance/android/shopping/store/tabkit/model/e;", "f", "()Lcom/bytedance/android/shopping/store/tabkit/model/e;", "o", "(Lcom/bytedance/android/shopping/store/tabkit/model/e;)V", "", "Lcom/bytedance/android/shopping/store/tabkit/model/k;", "tabs", "Ljava/util/List;", ce.f26395j, "()Ljava/util/List;", "p", "(Ljava/util/List;)V", "Lcom/bytedance/android/shopping/store/tabkit/model/q;", "topTabBarStyle", "Lcom/bytedance/android/shopping/store/tabkit/model/q;", "l", "()Lcom/bytedance/android/shopping/store/tabkit/model/q;", "q", "(Lcom/bytedance/android/shopping/store/tabkit/model/q;)V", "bottomTabBarStyle", "d", OfficeSDKRequestTag.KEY_NEW_USER, "Lcom/bytedance/android/shopping/store/tabkit/model/m;", "topTabBarDynamicConfig", "Lcom/bytedance/android/shopping/store/tabkit/model/m;", ce.f26396k, "()Lcom/bytedance/android/shopping/store/tabkit/model/m;", "setTopTabBarDynamicConfig", "(Lcom/bytedance/android/shopping/store/tabkit/model/m;)V", "bottomTabBarDynamicConfig", "c", "setBottomTabBarDynamicConfig", "", "anchoredTabId", "Ljava/lang/Integer;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/Integer;", "m", "(Ljava/lang/Integer;)V", "", "", "logExtra", "Ljava/util/Map;", "e", "()Ljava/util/Map;", "setLogExtra", "(Ljava/util/Map;)V", "Lcom/bytedance/android/shopping/store/tabkit/model/j;", "splitStyleConfig", "Lcom/bytedance/android/shopping/store/tabkit/model/j;", "h", "()Lcom/bytedance/android/shopping/store/tabkit/model/j;", "setSplitStyleConfig", "(Lcom/bytedance/android/shopping/store/tabkit/model/j;)V", "Lcom/bytedance/android/shopping/store/tabkit/model/h;", "popupConfig", "Lcom/bytedance/android/shopping/store/tabkit/model/h;", ce.f26391f, "()Lcom/bytedance/android/shopping/store/tabkit/model/h;", "setPopupConfig", "(Lcom/bytedance/android/shopping/store/tabkit/model/h;)V", "Lcom/bytedance/android/shopping/store/tabkit/model/b;", "backgroundConfig", "Lcom/bytedance/android/shopping/store/tabkit/model/b;", "b", "()Lcom/bytedance/android/shopping/store/tabkit/model/b;", "setBackgroundConfig", "(Lcom/bytedance/android/shopping/store/tabkit/model/b;)V", "Lcom/bytedance/android/shopping/store/tabkit/model/r;", "tabDowngradeConfig", RXScreenCaptureService.KEY_INDEX, "setTabDowngradeConfig", "<init>", "()V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class z {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f186839b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient boolean f186840a;

    @SerializedName("anchored_tab_id")
    private Integer anchoredTabId;

    @SerializedName("background_config")
    private b backgroundConfig;

    @SerializedName("bottom_tabbar_dynamic_config")
    private m bottomTabBarDynamicConfig;

    @SerializedName("bottom_tabbar_style")
    private q bottomTabBarStyle;

    @SerializedName("log_extra")
    private Map<String, String> logExtra;

    @SerializedName("navbar_config")
    private e navbarConfig;

    @SerializedName("popup_config")
    private h popupConfig;

    @SerializedName("split_style_config")
    private j splitStyleConfig;

    @SerializedName("tab_downgrade_config")
    private Map<String, r> tabDowngradeConfig;

    @SerializedName("tabs")
    private List<? extends k> tabs;

    @SerializedName("top_tabbar_dynamic_config")
    private m topTabBarDynamicConfig;

    @SerializedName("top_tabbar_style")
    private q topTabBarStyle;

    public static final class a {
    }

    static {
    }

    public z() {
    }

    public final Integer a() {
        return this.anchoredTabId;
    }

    public final b b() {
        return this.backgroundConfig;
    }

    public final m c() {
        return this.bottomTabBarDynamicConfig;
    }

    public final q d() {
        return this.bottomTabBarStyle;
    }

    public final Map<String, String> e() {
        return this.logExtra;
    }

    public final e f() {
        return this.navbarConfig;
    }

    public final h g() {
        return this.popupConfig;
    }

    public final j h() {
        return this.splitStyleConfig;
    }

    public final Map<String, r> i() {
        return this.tabDowngradeConfig;
    }

    public final List<k> j() {
        return this.tabs;
    }

    public final m k() {
        return this.topTabBarDynamicConfig;
    }

    public final q l() {
        return this.topTabBarStyle;
    }

    public final void m(Integer r100) {
        this.anchoredTabId = r100;
    }

    public final void n(q r100) {
        this.bottomTabBarStyle = r100;
    }

    public final void o(e r100) {
        this.navbarConfig = r100;
    }

    public final void p(List<? extends k> r100) {
        this.tabs = r100;
    }

    public final void q(q r100) {
        this.topTabBarStyle = r100;
    }
}
