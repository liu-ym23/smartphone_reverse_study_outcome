package com.bytedance.android.shopping.anchorv4.nav.controls;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.lifecycle.Lifecycle;
import com.bytedance.android.btm.api.model.BtmItemBuilder;
import com.bytedance.android.ec.common.api.abilities.IShoppingAbilities;
import com.bytedance.android.ec.core.anchorv3.PdpPerfOpt;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.monitor.ECProcessMonitor;
import com.bytedance.android.ec.core.opt.ab.u;
import com.bytedance.android.ec.model.ECAdLogExtra;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.ec.sdk.helper.p;
import com.bytedance.android.shopping.anchorv3.widget.AnchorV3SearchEditView;
import com.bytedance.android.shopping.anchorv4.bottom.CollectMeta;
import com.bytedance.android.shopping.anchorv4.bottom.IMComponent;
import com.bytedance.android.shopping.anchorv4.bottom.IMMeta;
import com.bytedance.android.shopping.anchorv4.bottom.h0;
import com.bytedance.android.shopping.anchorv4.bottom.r;
import com.bytedance.android.shopping.anchorv4.bottom.x;
import com.bytedance.android.shopping.anchorv4.data.AnchorV4DataManager;
import com.bytedance.android.shopping.anchorv4.dto.base.Action;
import com.bytedance.android.shopping.anchorv4.dto.components.TagsScrollBoxComponent;
import com.bytedance.android.shopping.anchorv4.dto.elements.TextWithOneIconElement;
import com.bytedance.android.shopping.anchorv4.dto.meta.CommonMeta;
import com.bytedance.android.shopping.anchorv4.log.AdLogUtils;
import com.bytedance.android.shopping.anchorv4.nav.AnchorV4SearchEditView;
import com.bytedance.android.shopping.anchorv4.nav.ShareComponent;
import com.bytedance.android.shopping.anchorv4.nav.ShareMeta;
import com.bytedance.android.shopping.anchorv4.tracker.AnchorV4TrackerImpl;
import com.bytedance.android.shopping.anchorv4.vm.AnchorV4VM;
import com.bytedance.android.shopping.anchorv4.voavhs.base.components.TagsScrollBoxComponentView;
import com.bytedance.android.shopping.anchorv4.voavhs.base.extensions.ExtensionsKt;
import com.bytedance.android.shopping.utils.i0;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.larus.bmhome.share.panel.ShareChannel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public final class l implements com.bytedance.android.shopping.anchorv4.voavhs.base.design.a, com.bytedance.android.shopping.anchorv4.log.d, com.bytedance.android.shopping.anchorv4.vm.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TopRightControlsVO f167151a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public c f167152b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AnchorV4VM f167153c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ViewGroup f167154d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TagsScrollBoxComponentView f167155e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final TagsScrollBoxComponentView f167156f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ViewGroup f167157g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final TagsScrollBoxComponentView f167158h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final AnchorV3SearchEditView f167159i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final TextView f167160j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ViewGroup f167161k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final com.bytedance.android.ec.core.async.b f167162l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Lifecycle f167163m;

    @Override // com.bytedance.android.shopping.anchorv4.log.d
    public final int M0() {
        return 0;
    }

    @Override // com.bytedance.android.shopping.anchorv4.log.d
    public final void onVisible() {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.a
    public final Function0<Unit> p0(Action r100) {
        return null;
    }

    @Override // com.bytedance.android.shopping.anchorv4.log.d
    public final View t() {
        return null;
    }

    @Override // com.bytedance.android.shopping.anchorv4.vm.e
    public final void L() {
        AnchorV3SearchEditView r100 = this.f167159i;
        if (r100 == null) goto L6;
        r100.setEnabled(true);
        return;
    }

    @Override // com.bytedance.android.shopping.anchorv4.log.d
    public final void onScan() {
        if (PdpPerfOpt.d() == true) goto L5;
        ViewGroup r100 = this.f167157g;
    L9:
        if (r100 != null) goto L11;
        return;
    L11:
        if (this.f167153c.pageStatus().f167742h == true) goto L14;
        r100 = null;
    L14:
        if (r100 == null) goto L18;
        ExtensionsKt.b(r100, this);
        return;
    L18:
        return;
    L5:
        if (com.bytedance.android.shopping.anchorv4.experiment.e.a() == false) goto L7;
        r100 = this.f167154d;
        goto L9
    L7:
        r100 = this.f167157g;
        goto L9
    }

    @Override // com.bytedance.android.shopping.anchorv4.vm.e
    public final void M(int r100) {
        AnchorV3SearchEditView r101 = this.f167159i;
        if (r101 == null) goto L6;
        r101.setEnabled(false);
        return;
    }

    public final void a(TopRightControlsVO r210) {
        TagsScrollBoxComponent r100 = r210.getDarkElements();
        TagsScrollBoxComponentView r101 = null;
        if (r100 == null) goto L7;
        List<TextWithOneIconElement> r102 = r100.getButtonList();
        if (r102 == null) goto L7;
        Integer r103 = Integer.valueOf(r102.size());
    L9:
        if (com.bytedance.android.shopping.extensions.k.f(r103) <= 0) goto L19;
        TagsScrollBoxComponent r104 = r210.getLightElements();
        if (r104 == null) goto L15;
        List<TextWithOneIconElement> r105 = r104.getButtonList();
        if (r105 == null) goto L15;
        Integer r106 = Integer.valueOf(r105.size());
    L17:
        if (com.bytedance.android.shopping.extensions.k.f(r106) <= 0) goto L19;
        boolean r107 = true;
    L20:
        if (r107 == false) goto L22;
        TopRightControlsVO r108 = r210;
    L23:
        if (r108 == null) goto L73;
        ViewGroup r109 = this.f167157g;
        if (r109 == null) goto L27;
        r109.setVisibility(0);
    L27:
        TagsScrollBoxComponentView r110 = this.f167158h;
        if (r110 == null) goto L30;
        TagsScrollBoxComponentView.b(r110, r108.getDarkElements(), r108.getShowExtraElement(), 12);
    L30:
        ViewGroup r111 = this.f167154d;
        if (r111 == null) goto L33;
        r111.setVisibility(0);
    L33:
        TagsScrollBoxComponentView r112 = this.f167155e;
        if (r112 == null) goto L36;
        TagsScrollBoxComponentView.b(r112, r108.getLightElements(), r108.getShowExtraElement(), 12);
    L36:
        TagsScrollBoxComponentView r113 = this.f167155e;
        TagsScrollBoxComponent r114 = r108.getLightElements();
        TopRightControlsVO r115 = this.f167151a;
        if (r115 == null) goto L39;
        TopRightControlsMeta r116 = r115.getTopRightMeta();
    L40:
        m r117 = new m(r113, r114, r116, this.f167163m, this.f167153c);
        Iterator<T> r118 = r117.f167165b.iterator();
    L42:
        if (r118.hasNext() == false) goto L44;
        ((d) r118.next()).a();
        goto L42
    L44:
        Unit r119 = Unit.INSTANCE;
        this.f167152b = r117;
        TagsScrollBoxComponent r120 = new TagsScrollBoxComponent(null, null, 0, 0, null, false, 0, null, null, null, 1023, null);
        TagsScrollBoxComponent r121 = r108.getLightElements();
        if (r121 == null) goto L68;
        List<TextWithOneIconElement> r122 = r121.getButtonList();
        if (r122 == null) goto L68;
        ArrayList r123 = new ArrayList();
        Iterator<T> r124 = r122.iterator();
    L50:
        if (r124.hasNext() == false) goto L69;
        Object r125 = r124.next();
        TextWithOneIconElement r126 = (TextWithOneIconElement) r125;
        Action r127 = r126.getAction();
        if (r127 == null) goto L54;
        String r128 = r127.getId();
    L56:
        if (Intrinsics.areEqual(r128, "action_share") == true) goto L65;
        Action r129 = r126.getAction();
        if (r129 == null) goto L60;
        String r130 = r129.getId();
    L62:
        if (Intrinsics.areEqual(r130, "action_collect") == true) goto L65;
        boolean r131 = false;
    L66:
        if (r131 == false) goto L50;
        r123.add(r125);
        goto L50
    L60:
        r130 = null;
    L65:
        r131 = true;
        goto L66
    L54:
        r128 = null;
    L69:
        r120.setButtonList(r123);
        TagsScrollBoxComponentView r132 = this.f167156f;
        if (r132 == null) goto L72;
        TagsScrollBoxComponentView.b(r132, r120, null, 14);
        r101 = r132;
    L72:
        if (r101 == null) goto L73;
    L79:
        TagsScrollBoxComponentView r133 = this.f167155e;
        if (r133 == null) goto L82;
        ExtensionsKt.e(r133, this);
    L82:
        TagsScrollBoxComponentView r134 = this.f167158h;
        if (r134 == null) goto L85;
        ExtensionsKt.e(r134, this);
    L85:
        TagsScrollBoxComponentView r135 = this.f167156f;
        if (r135 == null) goto L88;
        ExtensionsKt.e(r135, this);
    L88:
        this.f167153c.visibleLogger().b(this, r210, 0);
        return;
    L68:
        r123 = null;
        goto L69
    L39:
        r116 = null;
    L73:
        ViewGroup r136 = this.f167157g;
        if (r136 == null) goto L76;
        r136.setVisibility(8);
    L76:
        ViewGroup r137 = this.f167154d;
        if (r137 == null) goto L79;
        r137.setVisibility(8);
        Unit r138 = Unit.INSTANCE;
        goto L79
    L22:
        r108 = null;
    L15:
        r106 = null;
    L19:
        r107 = false;
    L7:
        r103 = null;
        goto L9
    }

    public final void b(boolean r100, boolean r101) {
        CommonMeta r102 = this.f167153c.commonMeta();
        String r103 = null;
        if (r102 == null) goto L8;
        ECAdLogExtra r104 = r102.getAdLogExtra();
        if (r104 == null) goto L8;
        String r105 = r104.getCreativeId();
        if (r105 == null) goto L8;
    L16:
        if (r105 != null) goto L18;
        return;
    L18:
        CommonMeta r106 = this.f167153c.commonMeta();
        if (r106 == null) goto L21;
        Map<String, Object> r107 = h73.a.a(r106);
    L22:
        CommonMeta r108 = this.f167153c.commonMeta();
        if (r108 == null) goto L29;
        String r109 = r108.getEntranceInfo();
        if (r109 == null) goto L29;
        JSONObject r110 = com.bytedance.android.shopping.extensions.k.w(r109);
        if (r110 == null) goto L29;
        r103 = r110.optString("log_extra");
    L29:
        if (r100 == false) goto L31;
        AdLogUtils.r(r105, r107, r103);
        return;
    L31:
        if (r101 == true) goto L33;
        AdLogUtils.l(r105, r107, r103);
        return;
    L33:
        AdLogUtils.m(r105, r107, r103);
        return;
    L21:
        r107 = null;
    L8:
        CommonMeta r111 = this.f167153c.commonMeta();
        if (r111 == null) goto L15;
        String r112 = r111.getEntranceInfo();
        if (r112 == null) goto L15;
        JSONObject r113 = com.bytedance.android.shopping.extensions.k.w(r112);
        if (r113 == null) goto L15;
        r105 = r113.optString("creative_id");
    L15:
        r105 = null;
        goto L16
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.a
    public final void l0(Action r110, Object r111) {
        if (r110 == null) goto L4;
        String r112 = r110.getId();
    L5:
        if (r112 != null) goto L8;
        return;
    L8:
        switch(r112.hashCode()) {
            case -966266847: goto L41;
            case 198295501: goto L36;
            case 1497533277: goto L31;
            case 1525717969: goto L26;
            case 1583526525: goto L21;
            case 1583540158: goto L16;
            case 1850421398: goto L11;
            default: goto L67;
        };
    L67:
        return;
    L11:
        if (r112.equals("action_share") == false) goto L46;
        int r113 = com.bytedance.android.shopping.anchorv4.tracker.a.f167502a;
        AnchorV4TrackerImpl r100 = com.bytedance.android.shopping.anchorv4.tracker.a.b(this.f167153c);
        if (r100 == null) goto L47;
        r100.f167498c = MapsKt.hashMapOf(new Pair[]{TuplesKt.to("button_location", "top")});
        AnchorV4TrackerImpl.b(r100, com.bytedance.android.ec.core.event.a.KEY_PDP_GALLERY_SHARE_BUTTON_SHOW, false, null, false, null, 28);
        return;
    L47:
        return;
    L46:
        return;
    L16:
        if (r112.equals("action_more") == false) goto L49;
        int r114 = com.bytedance.android.shopping.anchorv4.tracker.a.f167502a;
        AnchorV4TrackerImpl r101 = com.bytedance.android.shopping.anchorv4.tracker.a.b(this.f167153c);
        if (r101 == null) goto L50;
        r101.f167498c = MapsKt.mapOf(TuplesKt.to("icon_name", "guide"));
        AnchorV4TrackerImpl.b(r101, "product_detail_icon_show", false, null, false, null, 28);
        return;
    L50:
        return;
    L49:
        return;
    L21:
        if (r112.equals("action_mall") == false) goto L52;
        int r115 = com.bytedance.android.shopping.anchorv4.tracker.a.f167502a;
        AnchorV4TrackerImpl r102 = com.bytedance.android.shopping.anchorv4.tracker.a.b(this.f167153c);
        if (r102 == null) goto L53;
        r102.f167498c = MapsKt.mapOf(TuplesKt.to("icon_name", "mall"));
        AnchorV4TrackerImpl.b(r102, "product_detail_icon_show", false, null, false, null, 28);
        return;
    L53:
        return;
    L52:
        return;
    L26:
        if (r112.equals("action_search") == false) goto L55;
        String r116 = new BtmItemBuilder("a1.b8094.c9263.d4884", Boolean.FALSE).withView(this.f167159i).createBtmId();
        int r117 = com.bytedance.android.shopping.anchorv4.tracker.a.f167502a;
        AnchorV4TrackerImpl r103 = com.bytedance.android.shopping.anchorv4.tracker.a.b(this.f167153c);
        if (r103 == null) goto L56;
        r103.f167498c = MapsKt.hashMapOf(new Pair[]{TuplesKt.to("enter_from", "search_product_detail"), TuplesKt.to("btm_id", r116)});
        AnchorV4TrackerImpl.b(r103, "show_search", false, null, false, null, 28);
        return;
    L56:
        return;
    L55:
        return;
    L31:
        if (r112.equals("action_report") == false) goto L58;
        int r118 = com.bytedance.android.shopping.anchorv4.tracker.a.f167502a;
        AnchorV4TrackerImpl r104 = com.bytedance.android.shopping.anchorv4.tracker.a.b(this.f167153c);
        if (r104 == null) goto L59;
        r104.f167498c = MapsKt.mapOf(TuplesKt.to("btn_name", "report"));
        AnchorV4TrackerImpl.b(r104, "pd_more_btn_show", false, null, false, null, 28);
        return;
    L59:
        return;
    L58:
        return;
    L36:
        if (r112.equals("action_im") == false) goto L61;
        int r119 = com.bytedance.android.shopping.anchorv4.tracker.a.f167502a;
        AnchorV4TrackerImpl r105 = com.bytedance.android.shopping.anchorv4.tracker.a.b(this.f167153c);
        if (r105 == null) goto L62;
        AnchorV4TrackerImpl.b(r105, "show_consultation", false, null, false, null, 28);
        return;
    L62:
        return;
    L61:
        return;
    L41:
        if (r112.equals("action_collect") == false) goto L64;
        int r120 = com.bytedance.android.shopping.anchorv4.tracker.a.f167502a;
        AnchorV4TrackerImpl r106 = com.bytedance.android.shopping.anchorv4.tracker.a.b(this.f167153c);
        if (r106 == null) goto L65;
        AnchorV4TrackerImpl.b(r106, "show_wish_button", false, null, false, null, 28);
        return;
    L65:
        return;
    L64:
        return;
    L4:
        r112 = null;
        goto L5
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.a
    public final void O0(View r510, Action r511, Object r512) {
        Intrinsics.checkNotNullParameter(r510, "view");
        Intrinsics.checkNotNullParameter(r511, "action");
        TopRightControlsVO r100 = this.f167151a;
        if (r100 == null) goto L123;
        TopRightControlsMeta r101 = r100.getTopRightMeta();
        if (r101 == null) goto L150;
        boolean r102 = this.f167153c.pageStatus().f167742h;
        long r103 = this.f167153c.pageStatus().f167737c;
        String r104 = r511.getId();
        if (r104 == null) goto L151;
        IMMeta r105 = null;
        Context r106 = null;
        Context r107 = null;
        Context r108 = null;
        String r109 = null;
        r109 = null;
        r109 = null;
        r105 = null;
        switch(r104.hashCode()) {
            case -966266847: goto L110;
            case 198295501: goto L91;
            case 1497533277: goto L75;
            case 1525717969: goto L70;
            case 1583526525: goto L56;
            case 1583540158: goto L28;
            case 1850421398: goto L14;
            default: goto L152;
        };
    L152:
        return;
    L14:
        if (r104.equals("action_share") == false) goto L124;
        ShareMeta r110 = r101.getShareMeta();
        if (r110 != null) goto L18;
        return;
    L18:
        ShareMeta r111 = r110.fillCommonMeta(this.f167153c.commonMeta());
        if (r111 == null) goto L153;
        String r112 = Intrinsics.stringPlus(r111.getProductId(), "_" + System.currentTimeMillis());
        ShareMeta r113 = ShareMeta.copy$default(r111, null, null, null, null, null, 0, null, null, 0, null, null, null, null, null, false, null, null, 0, null, null, null, null, null, 0, null, false, null, null, null, null, null, r112, com.bytedance.android.ec.core.event.a.VALUE_PRODUCT_DETAIL, null, Integer.MAX_VALUE, 2, null);
        ih3.f r114 = ih3.f.f489805b;
        r114.createDurationMonitor(r112);
        r114.a(r112);
        c r115 = this.f167152b;
        if (r115 == null) goto L26;
        ShareBtnAnimController r116 = r115.a();
        if (r116 == null) goto L26;
        r116.f167125d = true;
    L26:
        new ShareComponent(this.f167153c, r510, r113, "top", this.f167152b, 32).a();
        b(true, false);
        return;
    L153:
        return;
    L124:
        return;
    L28:
        if (r104.equals("action_more") == false) goto L126;
        CustomMeta r117 = r101.getMoreMeta();
        if (r117 != null) goto L32;
        return;
    L32:
        int r118 = com.bytedance.android.shopping.anchorv4.tracker.a.f167502a;
        AnchorV4TrackerImpl r119 = com.bytedance.android.shopping.anchorv4.tracker.a.b(this.f167153c);
        if (r119 == null) goto L122;
        AnchorV4TrackerImpl.b(r119, "pd_more_bar_click", false, null, false, null, 30);
    L122:
        Result.Companion r120 = Result.Companion;     // Catch: Throwable -> L50
        String r121 = r117.getData();     // Catch: Throwable -> L50
        if (r121 == null) goto L38;
        JSONObject r122 = new JSONObject(r121);     // Catch: Throwable -> L50
    L40:
        if (r122.optBoolean("handle_schema_by_host", false) == false) goto L45;
        p r123 = p.f48130a;     // Catch: Throwable -> L50
        ViewGroup r124 = this.f167161k;     // Catch: Throwable -> L50
        if (r124 == null) goto L44;
        r106 = r124.getContext();     // Catch: Throwable -> L50
    L44:
        r123.openSchema(r106, r117.getSchema());     // Catch: Throwable -> L50
        return;
    L45:
        ViewGroup r125 = this.f167161k;     // Catch: Throwable -> L50
        if (r125 == null) goto L48;
        r107 = r125.getContext();     // Catch: Throwable -> L50
    L48:
        String r126 = r117.getSchema();     // Catch: Throwable -> L50
        r122.put(LocationMonitorConst.IDENTIFIER, AnchorV4DataManager.f166338d);     // Catch: Throwable -> L50
        Unit r127 = Unit.INSTANCE;     // Catch: Throwable -> L50
        com.bytedance.android.shopping.anchorv4.containers.b.b(r107, r126, r122, false);     // Catch: Throwable -> L50
        Object r128 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L50
    L52:
        Throwable r129 = Result.m9452exceptionOrNullimpl(r128);
        if (r129 == null) goto L128;
        ECExceptionMonitor.e(r129);
        return;
    L128:
        return;
    L38:
        r122 = new JSONObject();     // Catch: Throwable -> L50
    L50:
        th = move-exception;
        Result.Companion r130 = Result.Companion;
        r128 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L52
    L126:
        return;
    L56:
        if (r104.equals("action_mall") == false) goto L130;
        CustomMeta r131 = r101.getMallMeta();
        if (r131 != null) goto L60;
        return;
    L60:
        ViewGroup r132 = this.f167161k;
        if (r132 == null) goto L63;
        r108 = r132.getContext();
    L63:
        String r133 = r131.getSchema();
        if (r108 == null) goto L131;
        if (r133 == null) goto L132;
        p.f48130a.openSchema(r108, r133);
        int r134 = com.bytedance.android.shopping.anchorv4.tracker.a.f167502a;
        AnchorV4TrackerImpl r135 = com.bytedance.android.shopping.anchorv4.tracker.a.b(this.f167153c);
        if (r135 == null) goto L133;
        r135.f167498c = MapsKt.mapOf(TuplesKt.to("icon_name", "mall"));
        AnchorV4TrackerImpl.b(r135, "product_detail_icon_click", false, null, false, null, 30);
        return;
    L133:
        return;
    L132:
        return;
    L131:
        return;
    L130:
        return;
    L70:
        if (r104.equals("action_search") == false) goto L135;
        AnchorV3SearchEditView r136 = this.f167159i;
        if (r136 == null) goto L136;
        r136.a(r510);
        return;
    L136:
        return;
    L135:
        return;
    L75:
        if (r104.equals("action_report") == false) goto L138;
        ViewGroup r137 = this.f167161k;
        if (r137 == null) goto L139;
        Context r138 = r137.getContext();
        if (r138 == null) goto L140;
        p r139 = p.f48130a;
        TopRightControlsVO r140 = this.f167151a;
        if (r140 == null) goto L87;
        TopRightControlsMeta r141 = r140.getTopRightMeta();
        if (r141 == null) goto L87;
        h0 r142 = r141.getReportMeta();
        if (r142 == null) goto L87;
        r109 = r142.a();
    L87:
        r139.openSchema(r138, r109);
        int r143 = com.bytedance.android.shopping.anchorv4.tracker.a.f167502a;
        AnchorV4TrackerImpl r144 = com.bytedance.android.shopping.anchorv4.tracker.a.b(this.f167153c);
        if (r144 == null) goto L141;
        r144.f167498c = MapsKt.mapOf(TuplesKt.to("btn_name", "report"));
        AnchorV4TrackerImpl.b(r144, "pd_more_btn_click", false, null, false, null, 28);
        return;
    L141:
        return;
    L140:
        return;
    L139:
        return;
    L138:
        return;
    L91:
        if (r104.equals("action_im") == false) goto L143;
        AnchorV4VM r145 = this.f167153c;
        CommonMeta r146 = r145.commonMeta();
        TopRightControlsVO r147 = this.f167151a;
        if (r147 == null) goto L97;
        TopRightControlsMeta r148 = r147.getTopRightMeta();
        if (r148 == null) goto L97;
        r105 = r148.getImMeta();
    L97:
        if (r105 == null) goto L144;
        IMMeta r149 = r105.fillCommonMeta(r146);
        if (r149 != null) goto L102;
        return;
    L102:
        if (u.c() != 1) goto L108;
        String r150 = r149.getImUrl();
        if (r150 == null) goto L145;
        int r151 = ECSdk.f48106a;
        IShoppingAbilities r152 = (IShoppingAbilities) ECSdk.a(IShoppingAbilities.class);
        if (r152 == null) goto L146;
        r152.openIM(r510.getContext(), new df.m(r150, r510, "a1.b8094.c9263.d197106"), new df.l(r149.getPromotionSource(), r149.getSourcePage(), r149.getEnterMethod()), new k(r510, r145));
        return;
    L146:
        return;
    L145:
        return;
    L108:
        new IMComponent(r145, r510, r149, "a1.b8094.c9263.d197106").b();
        return;
    L144:
        return;
    L143:
        return;
    L110:
        if (r104.equals("action_collect") == false) goto L149;
        CollectMeta r153 = r101.getCollectMeta();
        if (r153 != null) goto L114;
        return;
    L114:
        Set<String> r154 = ECProcessMonitor.f45118a;
        com.bytedance.android.ec.core.monitor.listener.c r155 = ECProcessMonitor.c("ec_product_detail", ShareChannel.COLLECT);
        int r156 = i0.f187148a;
        String r157 = i0.a(this.f167153c);
        if (r157 != null) goto L117;
        r157 = "";
    L117:
        r155.f(MapsKt.mapOf(TuplesKt.to("product_type", r157)));
        TagsScrollBoxComponentView r158 = this.f167158h;
        TagsScrollBoxComponentView r159 = this.f167155e;
        TagsScrollBoxComponentView r160 = this.f167156f;
        CommonMeta r161 = this.f167153c.commonMeta();
        x r162 = new x(r103, r102, this.f167153c.compositeDisposable(), r512);
        CollectMeta r163 = r153.fillCommonMeta(r161);
        if (r163 == null) goto L155;
        new r(this.f167153c, r510.getContext(), r158, r159, r160, r163, r162).a();
        b(false, r163.getCollected());
        return;
    L155:
        return;
    L149:
        return;
    L151:
        return;
    L150:
        return;
    }

    public l(AnchorV4VM r100, ViewGroup r101, TagsScrollBoxComponentView r102, TagsScrollBoxComponentView r103, ViewGroup r104, TagsScrollBoxComponentView r105, AnchorV4SearchEditView r106, TextView r107, ViewGroup r110, com.bytedance.android.ec.core.async.b r111, Lifecycle r112) {
        Intrinsics.checkNotNullParameter(r100, "anchorV4VM");
        Intrinsics.checkNotNullParameter(r111, "disposableScope");
        this.f167153c = r100;
        this.f167154d = r101;
        this.f167155e = r102;
        this.f167156f = r103;
        this.f167157g = r104;
        this.f167158h = r105;
        this.f167159i = r106;
        this.f167160j = r107;
        this.f167161k = r110;
        this.f167162l = r111;
        this.f167163m = r112;
        r100.watchNetworkFlow(this);
    }
}
