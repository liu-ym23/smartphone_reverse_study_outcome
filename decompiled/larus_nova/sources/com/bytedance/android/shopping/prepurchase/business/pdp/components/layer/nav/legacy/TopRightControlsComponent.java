package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav.legacy;

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
import com.bytedance.android.ec.model.ECAdLogExtra;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.shopping.anchorv3.widget.AnchorV3SearchEditView;
import com.bytedance.android.shopping.anchorv4.bottom.CollectMeta;
import com.bytedance.android.shopping.anchorv4.bottom.IMMeta;
import com.bytedance.android.shopping.anchorv4.bottom.h0;
import com.bytedance.android.shopping.anchorv4.data.AnchorV4DataManager;
import com.bytedance.android.shopping.anchorv4.dto.base.Action;
import com.bytedance.android.shopping.anchorv4.dto.components.TagsScrollBoxComponent;
import com.bytedance.android.shopping.anchorv4.dto.elements.TextWithOneIconElement;
import com.bytedance.android.shopping.anchorv4.dto.meta.CommonMeta;
import com.bytedance.android.shopping.anchorv4.log.AdLogUtils;
import com.bytedance.android.shopping.anchorv4.nav.AnchorV4SearchEditView;
import com.bytedance.android.shopping.anchorv4.nav.ShareComponentV2;
import com.bytedance.android.shopping.anchorv4.nav.ShareMeta;
import com.bytedance.android.shopping.anchorv4.nav.controls.CustomMeta;
import com.bytedance.android.shopping.anchorv4.nav.controls.ShareBtnAnimController;
import com.bytedance.android.shopping.anchorv4.nav.controls.TopRightControlsMeta;
import com.bytedance.android.shopping.anchorv4.nav.controls.TopRightControlsVO;
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
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public final class TopRightControlsComponent implements com.bytedance.android.shopping.anchorv4.voavhs.base.design.a, com.bytedance.android.shopping.anchorv4.log.d, com.bytedance.android.shopping.anchorv4.vm.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TopRightControlsVO f181343a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.bytedance.android.shopping.anchorv4.nav.controls.c f181344b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a0 f181345c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ViewGroup f181346d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TagsScrollBoxComponentView f181347e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final TagsScrollBoxComponentView f181348f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ViewGroup f181349g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final TagsScrollBoxComponentView f181350h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final AnchorV3SearchEditView f181351i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final TextView f181352j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ViewGroup f181353k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Lifecycle f181354l;

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
        AnchorV3SearchEditView r100 = this.f181351i;
        if (r100 == null) goto L6;
        r100.setEnabled(true);
        return;
    }

    @Override // com.bytedance.android.shopping.anchorv4.log.d
    public final void onScan() {
        if (PdpPerfOpt.d() == true) goto L5;
        ViewGroup r100 = this.f181349g;
    L9:
        if (r100 != null) goto L11;
        return;
    L11:
        if (this.f181345c.isExpanded() == true) goto L14;
        r100 = null;
    L14:
        if (r100 == null) goto L18;
        ExtensionsKt.b(r100, this);
        return;
    L18:
        return;
    L5:
        if (com.bytedance.android.shopping.anchorv4.experiment.e.a() == false) goto L7;
        r100 = this.f181346d;
        goto L9
    L7:
        r100 = this.f181349g;
        goto L9
    }

    @Override // com.bytedance.android.shopping.anchorv4.vm.e
    public final void M(int r100) {
        AnchorV3SearchEditView r101 = this.f181351i;
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
        ViewGroup r109 = this.f181349g;
        if (r109 == null) goto L27;
        r109.setVisibility(0);
    L27:
        TagsScrollBoxComponentView r110 = this.f181350h;
        if (r110 == null) goto L30;
        TagsScrollBoxComponentView.b(r110, r108.getDarkElements(), r108.getShowExtraElement(), 12);
    L30:
        ViewGroup r111 = this.f181346d;
        if (r111 == null) goto L33;
        r111.setVisibility(0);
    L33:
        TagsScrollBoxComponentView r112 = this.f181347e;
        if (r112 == null) goto L36;
        TagsScrollBoxComponentView.b(r112, r108.getLightElements(), r108.getShowExtraElement(), 12);
    L36:
        TagsScrollBoxComponentView r113 = this.f181347e;
        TagsScrollBoxComponent r114 = r108.getLightElements();
        TopRightControlsVO r115 = this.f181343a;
        if (r115 == null) goto L39;
        TopRightControlsMeta r116 = r115.getTopRightMeta();
    L40:
        TopRightWidgetController r117 = new TopRightWidgetController(r113, r114, r116, this.f181354l, this.f181345c);
        Iterator<T> r118 = r117.f181360b.iterator();
    L42:
        if (r118.hasNext() == false) goto L44;
        ((com.bytedance.android.shopping.anchorv4.nav.controls.d) r118.next()).a();
        goto L42
    L44:
        Unit r119 = Unit.INSTANCE;
        this.f181344b = r117;
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
        TagsScrollBoxComponentView r132 = this.f181348f;
        if (r132 == null) goto L72;
        TagsScrollBoxComponentView.b(r132, r120, null, 14);
        r101 = r132;
    L72:
        if (r101 == null) goto L73;
    L79:
        TagsScrollBoxComponentView r133 = this.f181347e;
        if (r133 == null) goto L82;
        ExtensionsKt.e(r133, this);
    L82:
        TagsScrollBoxComponentView r134 = this.f181350h;
        if (r134 == null) goto L85;
        ExtensionsKt.e(r134, this);
    L85:
        TagsScrollBoxComponentView r135 = this.f181348f;
        if (r135 == null) goto L88;
        ExtensionsKt.e(r135, this);
    L88:
        this.f181345c.q(this, r210, 0);
        return;
    L68:
        r123 = null;
        goto L69
    L39:
        r116 = null;
    L73:
        ViewGroup r136 = this.f181349g;
        if (r136 == null) goto L76;
        r136.setVisibility(8);
    L76:
        ViewGroup r137 = this.f181346d;
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

    public final void c(Function1<? super vg3.z, Unit> r100) {
        this.f181345c.d(r100);
    }

    public final void b(boolean r100, boolean r101) {
        CommonMeta r102 = this.f181345c.a();
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
        CommonMeta r106 = this.f181345c.a();
        if (r106 == null) goto L21;
        Map<String, Object> r107 = h73.a.a(r106);
    L22:
        CommonMeta r108 = this.f181345c.a();
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
        CommonMeta r111 = this.f181345c.a();
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
    public final void l0(Action r100, Object r101) {
        if (r100 == null) goto L4;
        String r102 = r100.getId();
    L5:
        if (r102 != null) goto L8;
        return;
    L8:
        switch(r102.hashCode()) {
            case -966266847: goto L29;
            case 198295501: goto L26;
            case 1497533277: goto L23;
            case 1525717969: goto L20;
            case 1583526525: goto L17;
            case 1583540158: goto L14;
            case 1850421398: goto L11;
            default: goto L46;
        };
    L46:
        return;
    L11:
        if (r102.equals("action_share") == false) goto L32;
        c(TopRightControlsComponent$handleShowToHub$3.INSTANCE);
        return;
    L32:
        return;
    L14:
        if (r102.equals("action_more") == false) goto L34;
        c(TopRightControlsComponent$handleShowToHub$6.INSTANCE);
        return;
    L34:
        return;
    L17:
        if (r102.equals("action_mall") == false) goto L36;
        c(TopRightControlsComponent$handleShowToHub$5.INSTANCE);
        return;
    L36:
        return;
    L20:
        if (r102.equals("action_search") == false) goto L38;
        final String r103 = new BtmItemBuilder("a1.b8094.c9263.d4884", Boolean.FALSE).withView(this.f181351i).createBtmId();
        c(new TopRightControlsComponent$handleShowToHub$2(r103));
        return;
    L38:
        return;
    L23:
        if (r102.equals("action_report") == false) goto L40;
        c(TopRightControlsComponent$handleShowToHub$7.INSTANCE);
        return;
    L40:
        return;
    L26:
        if (r102.equals("action_im") == false) goto L42;
        c(TopRightControlsComponent$handleShowToHub$4.INSTANCE);
        return;
    L42:
        return;
    L29:
        if (r102.equals("action_collect") == false) goto L44;
        c(TopRightControlsComponent$handleShowToHub$1.INSTANCE);
        return;
    L44:
        return;
    L4:
        r102 = null;
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
    public final void O0(final View r510, Action r511, Object r512) {
        Intrinsics.checkNotNullParameter(r510, "view");
        Intrinsics.checkNotNullParameter(r511, "action");
        TopRightControlsVO r100 = this.f181343a;
        if (r100 == null) goto L114;
        TopRightControlsMeta r101 = r100.getTopRightMeta();
        if (r101 == null) goto L139;
        boolean r102 = this.f181345c.isExpanded();
        long r103 = this.f181345c.p();
        String r104 = r511.getId();
        if (r104 == null) goto L140;
        IMMeta r105 = null;
        Context r106 = null;
        Context r107 = null;
        String r108 = null;
        r108 = null;
        r108 = null;
        r105 = null;
        switch(r104.hashCode()) {
            case -966266847: goto L101;
            case 198295501: goto L82;
            case 1497533277: goto L68;
            case 1525717969: goto L63;
            case 1583526525: goto L51;
            case 1583540158: goto L28;
            case 1850421398: goto L14;
            default: goto L141;
        };
    L141:
        return;
    L14:
        if (r104.equals("action_share") == false) goto L115;
        ShareMeta r109 = r101.getShareMeta();
        if (r109 != null) goto L18;
        return;
    L18:
        String r110 = "top";
        ShareMeta r111 = r109.fillCommonMeta(this.f181345c.a());
        if (r111 == null) goto L142;
        String r112 = Intrinsics.stringPlus(r111.getProductId(), "_" + System.currentTimeMillis());
        ShareMeta r113 = ShareMeta.copy$default(r111, null, null, null, null, null, 0, null, null, 0, null, null, null, null, null, false, null, null, 0, null, null, null, null, null, 0, null, false, null, null, null, null, null, r112, com.bytedance.android.ec.core.event.a.VALUE_PRODUCT_DETAIL, null, Integer.MAX_VALUE, 2, null);
        ih3.f r114 = ih3.f.f489805b;
        r114.createDurationMonitor(r112);
        r114.a(r112);
        com.bytedance.android.shopping.anchorv4.nav.controls.c r115 = this.f181344b;
        if (r115 == null) goto L26;
        ShareBtnAnimController r116 = r115.a();
        if (r116 == null) goto L26;
        r116.f167125d = true;
    L26:
        new ShareComponentV2(new n(this.f181345c), r510, r113, r110, this.f181344b).a();
        b(true, false);
        return;
    L142:
        return;
    L115:
        return;
    L28:
        if (r104.equals("action_more") == false) goto L117;
        CustomMeta r117 = r101.getMoreMeta();
        if (r117 != null) goto L32;
        return;
    L32:
        c(TopRightControlsComponent$handlerMoreWithMeta$1.INSTANCE);
        Result.Companion r118 = Result.Companion;     // Catch: Throwable -> L45
        String r119 = r117.getData();     // Catch: Throwable -> L45
        if (r119 == null) goto L36;
        JSONObject r120 = new JSONObject(r119);     // Catch: Throwable -> L45
    L38:
        if (r120.optBoolean("handle_schema_by_host", false) == false) goto L40;
        this.f181345c.openSchema(r117.getSchema());     // Catch: Throwable -> L45
        return;
    L40:
        ViewGroup r121 = this.f181353k;     // Catch: Throwable -> L45
        if (r121 == null) goto L43;
        r106 = r121.getContext();     // Catch: Throwable -> L45
    L43:
        String r122 = r117.getSchema();     // Catch: Throwable -> L45
        r120.put(LocationMonitorConst.IDENTIFIER, AnchorV4DataManager.f166338d);     // Catch: Throwable -> L45
        Unit r123 = Unit.INSTANCE;     // Catch: Throwable -> L45
        com.bytedance.android.shopping.anchorv4.containers.b.b(r106, r122, r120, false);     // Catch: Throwable -> L45
        Object r124 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L45
    L47:
        Throwable r125 = Result.m9452exceptionOrNullimpl(r124);
        if (r125 == null) goto L119;
        ECExceptionMonitor.e(r125);
        return;
    L119:
        return;
    L36:
        r120 = new JSONObject();     // Catch: Throwable -> L45
    L45:
        th = move-exception;
        Result.Companion r126 = Result.Companion;
        r124 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L47
    L117:
        return;
    L51:
        if (r104.equals("action_mall") == false) goto L121;
        CustomMeta r127 = r101.getMallMeta();
        if (r127 != null) goto L55;
        return;
    L55:
        ViewGroup r128 = this.f181353k;
        if (r128 == null) goto L58;
        r107 = r128.getContext();
    L58:
        String r129 = r127.getSchema();
        if (r107 == null) goto L122;
        if (r129 == null) goto L123;
        this.f181345c.openSchema(r129);
        c(TopRightControlsComponent$handlerMallWithMeta$1$1.INSTANCE);
        return;
    L123:
        return;
    L122:
        return;
    L121:
        return;
    L63:
        if (r104.equals("action_search") == false) goto L125;
        AnchorV3SearchEditView r130 = this.f181351i;
        if (r130 == null) goto L126;
        r130.a(r510);
        return;
    L126:
        return;
    L125:
        return;
    L68:
        if (r104.equals("action_report") == false) goto L128;
        ViewGroup r131 = this.f181353k;
        if (r131 != null) goto L72;
        return;
    L72:
        if (r131.getContext() == null) goto L130;
        a0 r132 = this.f181345c;
        TopRightControlsVO r133 = this.f181343a;
        if (r133 == null) goto L80;
        TopRightControlsMeta r134 = r133.getTopRightMeta();
        if (r134 == null) goto L80;
        h0 r135 = r134.getReportMeta();
        if (r135 == null) goto L80;
        r108 = r135.a();
    L80:
        r132.openSchema(r108);
        c(TopRightControlsComponent$handleActionToHub$1$1.INSTANCE);
        return;
    L130:
        return;
    L128:
        return;
    L82:
        if (r104.equals("action_im") == false) goto L132;
        final a0 r136 = this.f181345c;
        CommonMeta r137 = r136.a();
        TopRightControlsVO r138 = this.f181343a;
        if (r138 == null) goto L88;
        TopRightControlsMeta r139 = r138.getTopRightMeta();
        if (r139 == null) goto L88;
        r105 = r139.getImMeta();
    L88:
        if (r105 == null) goto L133;
        IMMeta r140 = r105.fillCommonMeta(r137);
        if (r140 != null) goto L93;
        return;
    L93:
        if (com.bytedance.android.ec.core.opt.ab.u.c() != 1) goto L99;
        String r141 = r140.getImUrl();
        if (r141 == null) goto L134;
        int r142 = ECSdk.f48106a;
        IShoppingAbilities r143 = (IShoppingAbilities) ECSdk.a(IShoppingAbilities.class);
        if (r143 == null) goto L135;
        r143.openIM(r510.getContext(), new df.m(r141, r510, "a1.b8094.c9263.d197106"), new df.l(r140.getPromotionSource(), r140.getSourcePage(), r140.getEnterMethod()), new TopRightControlsComponent$handleIMWithMeta$$inlined$let$lambda$1(this, r510, r136));
        return;
    L135:
        return;
    L134:
        return;
    L99:
        new IMComponent(r136, r510, r140, "a1.b8094.c9263.d197106").b();
        return;
    L133:
        return;
    L132:
        return;
    L101:
        if (r104.equals("action_collect") == false) goto L138;
        CollectMeta r144 = r101.getCollectMeta();
        if (r144 != null) goto L105;
        return;
    L105:
        Set<String> r145 = ECProcessMonitor.f45118a;
        com.bytedance.android.ec.core.monitor.listener.c r146 = ECProcessMonitor.c("ec_product_detail", ShareChannel.COLLECT);
        int r147 = i0.f187148a;
        String r148 = i0.b(this.f181345c.b());
        if (r148 != null) goto L108;
        r148 = "";
    L108:
        r146.f(MapsKt.mapOf(TuplesKt.to("product_type", r148)));
        TagsScrollBoxComponentView r149 = this.f181350h;
        TagsScrollBoxComponentView r150 = this.f181347e;
        TagsScrollBoxComponentView r151 = this.f181348f;
        CommonMeta r152 = this.f181345c.a();
        com.bytedance.android.shopping.anchorv4.bottom.x r153 = new com.bytedance.android.shopping.anchorv4.bottom.x(r103, r102, this.f181345c.compositeDisposable(), r512);
        CollectMeta r154 = r144.fillCommonMeta(r152);
        if (r154 == null) goto L144;
        new com.bytedance.android.shopping.anchorv4.bottom.v(new TopRightControlsComponent$handleFavouriteWithMeta$1(this), r510.getContext(), r149, r150, r151, r154, r153, null).a();
        b(false, r154.getCollected());
        return;
    L144:
        return;
    L138:
        return;
    L140:
        return;
    L139:
        return;
    }

    public TopRightControlsComponent(TopNavigationComponentV1$dependency$1 r100, ViewGroup r101, TagsScrollBoxComponentView r102, TagsScrollBoxComponentView r103, ViewGroup r104, TagsScrollBoxComponentView r105, AnchorV4SearchEditView r106, TextView r107, ViewGroup r110, Lifecycle r111) {
        Intrinsics.checkNotNullParameter(r100, "anchorV4VM");
        this.f181345c = r100;
        this.f181346d = r101;
        this.f181347e = r102;
        this.f181348f = r103;
        this.f181349g = r104;
        this.f181350h = r105;
        this.f181351i = r106;
        this.f181352j = r107;
        this.f181353k = r110;
        this.f181354l = r111;
    }
}
