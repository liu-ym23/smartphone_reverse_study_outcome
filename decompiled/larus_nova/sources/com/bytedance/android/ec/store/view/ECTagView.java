package com.bytedance.android.ec.store.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import com.amap.api.col.s.ce;
import com.bytedance.android.bcm.api.model.BcmParams;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.core.utils.y;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.store.common.uiext.ExtensionsKt;
import com.bytedance.android.ec.store.product.EventActionImplOpt;
import com.bytedance.android.ec.store.repository.vo.ActionType;
import com.bytedance.android.ec.store.repository.vo.ClickAction;
import com.bytedance.android.ec.store.repository.vo.DividerLineType;
import com.bytedance.android.ec.store.repository.vo.ECTagContainerDTO;
import com.bytedance.android.ec.store.repository.vo.ElementAlignment;
import com.bytedance.android.ec.store.repository.vo.OverLengthStrategy;
import com.bytedance.android.ec.store.repository.vo.SubTagType;
import com.bytedance.android.ec.store.repository.vo.TagContainerUI;
import com.bytedance.android.shopping.store.arch.ECStoreFoldPhoneHelper;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.bytedance.android.ui.ec.widget.toast.ECToast;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0015B'\b\u0007\u0012\u0006\u0010G\u001a\u00020F\u0012\n\b\u0002\u0010I\u001a\u0004\u0018\u00010H\u0012\b\b\u0002\u0010J\u001a\u00020\u000e¢\u0006\u0004\bK\u0010LJ\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002J\u001a\u0010\n\u001a\u00020\u00052\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007J\b\u0010\f\u001a\u0004\u0018\u00010\u000bJ\u0016\u0010\u0010\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000eJ\u0017\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0011H\u0096\u0001J\t\u0010\u0013\u001a\u00020\bH\u0096\u0001R\"\u0010\u001b\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\"\u0010\"\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0017\u0010(\u001a\u00020#8\u0006¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u0017\u0010.\u001a\u00020)8\u0006¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R$\u00105\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R$\u00109\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b6\u00100\u001a\u0004\b7\u00102\"\u0004\b8\u00104R\"\u0010=\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b:\u0010\u0016\u001a\u0004\b;\u0010\u0018\"\u0004\b<\u0010\u001aR\"\u0010A\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b>\u0010\u0016\u001a\u0004\b?\u0010\u0018\"\u0004\b@\u0010\u001aR$\u0010E\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bB\u00100\u001a\u0004\bC\u00102\"\u0004\bD\u00104¨\u0006M"}, d2 = {"Lcom/bytedance/android/ec/store/view/ECTagView;", "Landroid/widget/LinearLayout;", "Lcom/bytedance/android/ec/core/event/c;", "Lcom/bytedance/android/ec/store/repository/vo/TagContainerUI;", "tagContainerUI", "", "setTagLayoutParams", "", "", "params", "setBaseEventParams", "Lcom/bytedance/android/ec/store/repository/vo/ECTagContainerDTO;", "getTagData", "tagVO", "", "overLengthStrategy", "update", "", "getBaseParams", "getBaseParamsJson", "", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Z", "getNeedClip", "()Z", "setNeedClip", "(Z)V", "needClip", "b", "I", "getCurrentBoderCorlor", "()I", "setCurrentBoderCorlor", "(I)V", "currentBoderCorlor", "Landroid/graphics/Paint;", "c", "Landroid/graphics/Paint;", "getBorderPaint", "()Landroid/graphics/Paint;", "borderPaint", "Landroid/graphics/Path;", "d", "Landroid/graphics/Path;", "getBorderPath", "()Landroid/graphics/Path;", "borderPath", "e", "Ljava/lang/String;", "getShowEventName", "()Ljava/lang/String;", "setShowEventName", "(Ljava/lang/String;)V", "showEventName", "f", "getClickEventName", "setClickEventName", "clickEventName", ce.f26391f, "getHasReportSingleTagShowEvent", "setHasReportSingleTagShowEvent", "hasReportSingleTagShowEvent", "h", "getHasReportCommonTagShowEvent", "setHasReportCommonTagShowEvent", "hasReportCommonTagShowEvent", RXScreenCaptureService.KEY_INDEX, "getBtmId", "setBtmId", "btmId", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECTagView extends LinearLayout implements com.bytedance.android.ec.core.event.c {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final /* synthetic */ int f48880q = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f48881a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f48882b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Paint f48883c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Path f48884d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f48885e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f48886f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f48887g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f48888h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f48889i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f48890j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public xm.c f48891k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Map<String, String> f48892l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public ECTagContainerDTO f48893m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f48894n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f48895o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final /* synthetic */ EventActionImplOpt f48896p;

    public static final class a {
        public static TextView a(Context r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            TextView r101 = new TextView(r100);
            r101.setIncludeFontPadding(true);
            r101.setGravity(16);
            r101.setMaxLines(1);
            r101.getLayoutParams();
            return r101;
        }
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ClickAction f48897a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ECTagView f48898b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ View f48899c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.android.ec.store.repository.vo.s f48900d;

        public b(ClickAction r100, ECTagView r101, View r102, com.bytedance.android.ec.store.repository.vo.s r103) {
            this.f48897a = r100;
            this.f48898b = r101;
            this.f48899c = r102;
            this.f48900d = r103;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            Map<String, String> r101 = this.f48900d.c();
            if (r101 == null) goto L6;
            String r102 = r101.get("btm_id");
            if (r102 == null) goto L6;
        L7:
            ECTagView r103 = this.f48898b;
            View r104 = this.f48899c;
            int r105 = ECTagView.f48880q;
            r103.getClass();
            String r106 = BtmSDK.INSTANCE.createJumpSourceBtmToken(r102, PageFinder.via(r104), new BcmParams());
            com.bytedance.android.ec.sdk.helper.p r107 = com.bytedance.android.ec.sdk.helper.p.f48130a;
            Context r108 = r100.getContext();
            int r109 = com.bytedance.android.ec.store.utils.b.f48663a;
            Lazy r110 = ECStoreFoldPhoneHelper.f183487a;
            String r111 = this.f48897a.getJumpUrl();
            ECStoreFoldPhoneHelper.b(r111);
            r107.openSchema(r108, com.bytedance.android.ec.store.utils.b.a(r111, r106));
            String r112 = this.f48900d.b();
            if (r112 == null) goto L16;
            ECTagView r113 = this.f48898b;
            PageFinder r114 = PageFinder.via(this.f48897a);
            Map<String, String> r115 = this.f48898b.f48892l;
            com.bytedance.android.ec.store.repository.vo.s r116 = this.f48900d;
            if (r116 == null) goto L13;
            Map<String, String> r117 = r116.c();
            if (r117 == null) goto L13;
        L14:
            r113.doEventAction(r112, r102, r114, MapsKt.plus(r115, r117));
            return;
        L13:
            r117 = MapsKt.emptyMap();
            goto L14
        L16:
            return;
        L6:
            r102 = "";
            goto L7
        }
    }

    public static final class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ClickAction f48901a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ECTagView f48902b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ View f48903c;

        public c(ClickAction r100, ECTagView r101, View r102) {
            this.f48901a = r100;
            this.f48902b = r101;
            this.f48903c = r102;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            ECToast.showToast$default(ECToast.INSTANCE, this.f48902b.getContext(), this.f48901a.getToastText(), null, 4, null);
            this.f48902b.e();
        }
    }

    static {
    }

    public ECTagView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ECTagView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // com.bytedance.android.ec.core.event.c
    public final void appendEventParams(Map<String, String> r100) {
        Intrinsics.checkNotNullParameter(r100, "paramsMap");
        this.f48896p.appendEventParams(r100);
    }

    @Override // com.bytedance.android.ec.core.event.c
    public final void appendEventParams(Pair<String, String>... r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        this.f48896p.appendEventParams(r100);
    }

    @Override // com.bytedance.android.ec.core.event.c
    public final void bindMonitorId(Long r100) {
        this.f48896p.getClass();
    }

    @Override // com.bytedance.android.ec.core.event.c
    public final void clearEventParams() {
        this.f48896p.clearEventParams();
    }

    @Override // com.bytedance.android.ec.core.event.c
    public final void doAnyEventAction(String r100, Map<String, ? extends Object> r101, Pair<String, ? extends Object>... r102) {
        Intrinsics.checkNotNullParameter(r100, "actionName");
        Intrinsics.checkNotNullParameter(r102, "params");
        this.f48896p.doAnyEventAction(r100, r101, r102);
    }

    @Override // com.bytedance.android.ec.core.event.c
    public final void doAnyEventActionWithBtm(String r100, PageFinder r101, String r110, Map<String, ? extends Object> r111, Pair<String, ? extends Object>... r112) {
        Intrinsics.checkNotNullParameter(r100, "btm");
        Intrinsics.checkNotNullParameter(r101, "pageFinder");
        Intrinsics.checkNotNullParameter(r110, "actionName");
        Intrinsics.checkNotNullParameter(r112, "params");
        this.f48896p.doAnyEventActionWithBtm(r100, r101, r110, r111, r112);
    }

    @Override // com.bytedance.android.ec.core.event.c
    public final void doEventAction(String r100, String r101, PageFinder r102, Map<String, String> r103) {
        Intrinsics.checkNotNullParameter(r100, "actionName");
        Intrinsics.checkNotNullParameter(r103, "paramMap");
        this.f48896p.doEventAction(r100, r101, r102, r103);
    }

    @Override // com.bytedance.android.ec.core.event.c
    public final void doEventAction(String r100, String r101, PageFinder r102, Pair<String, String>... r103) {
        Intrinsics.checkNotNullParameter(r100, "actionName");
        Intrinsics.checkNotNullParameter(r103, "params");
        this.f48896p.doEventAction(r100, r101, r102, r103);
    }

    @Override // com.bytedance.android.ec.core.event.c
    public final void doEventAction(String r100, Map<String, String> r101, Pair<String, String>... r102) {
        Intrinsics.checkNotNullParameter(r100, "actionName");
        Intrinsics.checkNotNullParameter(r102, "params");
        this.f48896p.doEventAction(r100, r101, r102);
    }

    @Override // com.bytedance.android.ec.core.event.c
    public final void doEventAction(String r100, Pair<String, String>... r101) {
        Intrinsics.checkNotNullParameter(r100, "actionName");
        Intrinsics.checkNotNullParameter(r101, "params");
        this.f48896p.doEventAction(r100, r101);
    }

    @Override // com.bytedance.android.ec.core.event.c
    public String getBaseParamsJson() {
        return this.f48896p.getBaseParamsJson();
    }

    @Override // com.bytedance.android.ec.core.event.c
    public final void initEventContext(Map<String, String> r100) {
        Intrinsics.checkNotNullParameter(r100, "paramsMap");
        this.f48896p.initEventContext(r100);
    }

    @Override // com.bytedance.android.ec.core.event.c
    public final void initEventContext(Pair<String, String>... r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        this.f48896p.initEventContext(r100);
    }

    public final void e() {
        String r100 = this.f48886f;
        if (r100 == null) goto L10;
        String r101 = this.f48889i;
        PageFinder r102 = PageFinder.via(this);
        Map<String, String> r103 = this.f48892l;
        ECTagContainerDTO r104 = this.f48893m;
        if (r104 == null) goto L8;
        Map<String, String> r105 = r104.getClickParams();
        if (r105 == null) goto L8;
    L9:
        doEventAction(r100, r101, r102, MapsKt.plus(r103, r105));
    L8:
        r105 = MapsKt.emptyMap();
    L10:
        LinkedHashMap r106 = new LinkedHashMap();
        ECTagContainerDTO r107 = this.f48893m;
        String r108 = "";
        if (r107 == null) goto L14;
        String r109 = r107.getTagType();
        if (r109 == null) goto L14;
    L15:
        r106.put("type", r109);
        String r110 = this.f48890j;
        if (r110 == null) goto L19;
        r108 = r110;
    L19:
        r106.put("scene", r108);
        doEventAction("ec_shop_tag_click", this.f48889i, PageFinder.via(this), MapsKt.plus(this.f48892l, r106));
        return;
    L14:
        r109 = "";
        goto L15
    }

    public final void f() {
        if (this.f48887g == true) goto L13;
        String r100 = this.f48885e;
        if (r100 == null) goto L13;
        this.f48887g = true;
        String r101 = this.f48889i;
        PageFinder r102 = PageFinder.via(this);
        Map<String, String> r103 = this.f48892l;
        ECTagContainerDTO r104 = this.f48893m;
        if (r104 == null) goto L10;
        Map<String, String> r105 = r104.getShowParams();
        if (r105 == null) goto L10;
    L11:
        doEventAction(r100, r101, r102, MapsKt.plus(r103, r105));
    L10:
        r105 = MapsKt.emptyMap();
    L13:
        if (this.f48888h == false) goto L15;
        return;
    L15:
        if (wg.a.b(this) <= 0.5d) goto L28;
        LinkedHashMap r106 = new LinkedHashMap();
        ECTagContainerDTO r107 = this.f48893m;
        String r108 = "";
        if (r107 == null) goto L20;
        String r109 = r107.getTagType();
        if (r109 == null) goto L20;
    L21:
        r106.put("type", r109);
        String r110 = this.f48890j;
        if (r110 == null) goto L25;
        r108 = r110;
    L25:
        r106.put("scene", r108);
        doEventAction("ec_shop_tag_show", this.f48889i, PageFinder.via(this), MapsKt.plus(this.f48892l, r106));
        this.f48888h = true;
        return;
    L20:
        r109 = "";
        goto L21
    }

    @Override // com.bytedance.android.ec.core.event.c
    public Map<String, String> getBaseParams() {
        return this.f48896p.b();
    }

    public final Paint getBorderPaint() {
        return this.f48883c;
    }

    public final Path getBorderPath() {
        return this.f48884d;
    }

    public final String getBtmId() {
        return this.f48889i;
    }

    public final String getClickEventName() {
        return this.f48886f;
    }

    public final int getCurrentBoderCorlor() {
        return this.f48882b;
    }

    public final boolean getHasReportCommonTagShowEvent() {
        return this.f48888h;
    }

    public final boolean getHasReportSingleTagShowEvent() {
        return this.f48887g;
    }

    public final boolean getNeedClip() {
        return this.f48881a;
    }

    public final String getShowEventName() {
        return this.f48885e;
    }

    public final ECTagContainerDTO getTagData() {
        return this.f48893m;
    }

    private final void setTagLayoutParams(TagContainerUI r110) {
        int r100 = com.bytedance.android.ec.core.utils.s.f45717a;
        if (r110 == null) goto L5;
        String r101 = r110.getBgColor();
    L6:
        Integer r102 = com.bytedance.android.ec.core.utils.s.b(r101);
        if (r102 == null) goto L9;
        int r103 = r102.intValue();
    L10:
        GradientDrawable r104 = new GradientDrawable();
        r104.setColor(r103);
        if (r110 != null) goto L13;
    L24:
        ViewCompat.setBackground(this, r104);
        if (r110 == null) goto L27;
        Integer r105 = Integer.valueOf(r110.getElementAliment());
    L28:
        int r106 = ElementAlignment.LEADING.getType();
        if (r105 != null) goto L32;
    L34:
        int r107 = ElementAlignment.CENTER.getType();
        if (r105 != null) goto L38;
    L40:
        int r108 = ElementAlignment.TRAILING.getType();
        if (r105 != null) goto L44;
    L46:
        int r109 = GravityCompat.START;
    L47:
        setGravity(r109 | 16);
        if (r110 == null) goto L50;
        int r111 = com.bytedance.android.shopping.store.utils.o.a(Integer.valueOf(r110.getHeight()));
    L51:
        setLayoutParams(new LinearLayout.LayoutParams(-2, r111));
        if (r110 == null) goto L54;
        int r112 = ExtensionsKt.a(Integer.valueOf((int) r110.getMaxWidth()));
    L55:
        this.f48894n = r112;
        if (r110 == null) goto L96;
        List<Float> r113 = r110.getBorderRadius();
        if (r113 == null) goto L97;
        List<Float> r114 = r113;
        if ((r114 instanceof Collection) == true) goto L62;
    L64:
        Iterator<T> r115 = r114.iterator();
    L66:
        if (r115.hasNext() == false) goto L73;
        if (((Number) r115.next()).floatValue() <= 0) goto L70;
        boolean r116 = true;
    L71:
        if (r116 == false) goto L66;
        boolean r117 = true;
    L74:
        if (r117 != true) goto L98;
        List<Float> r118 = r110.getBorderRadius();
        if (r118 == null) goto L78;
        Integer r119 = Integer.valueOf(r118.size());
    L80:
        if (r119.intValue() < 4) goto L99;
        float r120 = ((Number) ListProtector.get(r110.getBorderRadius(), 0)).floatValue();
        float r121 = ((Number) ListProtector.get(r110.getBorderRadius(), 1)).floatValue();
        float r122 = ((Number) ListProtector.get(r110.getBorderRadius(), 2)).floatValue();
        float r123 = ((Number) ListProtector.get(r110.getBorderRadius(), 3)).floatValue();
        Lazy r124 = ExtensionsKt.f48229a;
        Intrinsics.checkNotNullParameter(this, "$this$setRadius");
        float r125 = ExtensionsKt.b(Float.valueOf(r120));
        float r126 = ExtensionsKt.b(Float.valueOf(r121));
        float r127 = ExtensionsKt.b(Float.valueOf(r122));
        float r128 = ExtensionsKt.b(Float.valueOf(r123));
        Float r129 = ArraysKt.maxOrNull(new float[]{r125, r126, r127, r128});
        if (r129 == null) goto L84;
        float r130 = r129.floatValue();
    L86:
        if (r130 <= 0) goto L88;
        setClipToOutline(true);
        setOutlineProvider(new com.bytedance.android.ec.store.common.uiext.a(r130, r125, r128, r126, r127));
        return;
    L88:
        setClipToOutline(false);
        setOutlineProvider(null);
        return;
    L84:
        r130 = 0.0f;
        goto L86
    L99:
        return;
    L78:
        r119 = null;
        goto L80
    L98:
        return;
    L70:
        r116 = false;
    L73:
        r117 = false;
        goto L74
    L62:
        if (r114.isEmpty() == false) goto L64;
    L97:
        return;
    L96:
        return;
    L54:
        r112 = 0;
        goto L55
    L50:
        r111 = 0;
        goto L51
    L44:
        if (r105.intValue() != r108) goto L46;
        r109 = GravityCompat.END;
        goto L47
    L38:
        if (r105.intValue() != r107) goto L40;
        r109 = 17;
        goto L47
    L32:
        if (r105.intValue() != r106) goto L34;
    L27:
        r105 = null;
        goto L28
    L13:
        if (r110.getHasBorder() != true) goto L24;
        List<Float> r131 = r110.getBorderRadius();
        if (r131.size() < 4) goto L20;
        float[] r132 = new float[8];
        int r133 = 0;
    L17:
        if (r133 >= 4) goto L19;
        int r134 = r133 * 2;
        r132[r134] = ExtensionsKt.b((Number) ListProtector.get(r131, r133));
        r132[r134 + 1] = ExtensionsKt.b((Number) ListProtector.get(r131, r133));
        r133 = r133 + 1;
        goto L17
    L19:
        r104.setCornerRadii(r132);
    L20:
        int r135 = com.bytedance.android.ec.core.utils.s.f45717a;
        Integer r136 = com.bytedance.android.ec.core.utils.s.b(r110.getBorderColor());
        if (r136 == null) goto L23;
        int r137 = r136.intValue();
        r104.setStroke(ExtensionsKt.a(Double.valueOf(r110.getBorderWidth())), r137);
        this.f48882b = r137;
    L23:
        setElevation(r110.getElevation());
        goto L24
    L9:
        r103 = 16777215;
        goto L10
    L5:
        r101 = null;
        goto L6
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r110) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        super.dispatchDraw(r110);
        ECTagContainerDTO r100 = this.f48893m;
        if (r100 == null) goto L46;
        TagContainerUI r101 = r100.getTagContainerUI();
        if (r101 != null) goto L8;
        return;
    L8:
        if (this.f48881a == false) goto L13;
        if (r101.getHasBorder() == false) goto L13;
        float r102 = ExtensionsKt.a(Double.valueOf(r101.getBorderWidth()));
        this.f48883c.setColor(this.f48882b);
        this.f48883c.setStrokeWidth(r102);
        r110.drawPath(d(r101, r102), this.f48883c);
    L13:
        if (r101.getHasBorder() == false) goto L47;
        List<String> r103 = r101.getBorderColors();
        if (r103 != null) goto L17;
        return;
    L17:
        if ((!r103.isEmpty()) == true) goto L19;
        return;
    L19:
        if (r101.getBorderWidth() <= 0) goto L50;
        List<String> r104 = r101.getBorderColors();
        if (r104 == null) goto L51;
        ArrayList r105 = new ArrayList();
        Iterator<T> r106 = r104.iterator();
    L24:
        if (r106.hasNext() == false) goto L28;
        Integer r107 = com.bytedance.android.ec.core.utils.s.b((String) r106.next());
        if (r107 == null) goto L24;
        r105.add(r107);
        goto L24
    L28:
        int[] r108 = CollectionsKt.toIntArray(r105);
        if (r108 == null) goto L54;
        List<Float> r109 = r101.getBorderPositions();
        if (r109 == null) goto L52;
        float[] r111 = CollectionsKt.toFloatArray(r109);
        if (r111 != null) goto L37;
        return;
    L37:
        if (r108.length == r111.length) goto L39;
        return;
    L39:
        float r112 = RangesKt.coerceAtLeast(ExtensionsKt.a(Double.valueOf(r101.getBorderWidth())), 1.0f);
        float r113 = getWidth() / 2.0f;
        float r114 = getHeight() / 2.0f;
        float r115 = ((float) Math.hypot(getWidth(), getHeight())) / 2.0f;
        double r116 = Math.toRadians(r101.getBorderOrientation());
        float r117 = (((float) Math.cos(r116)) * r115) + r113;
        float r118 = r114 + (r115 * ((float) Math.sin(r116)));
        float r119 = 2;
        this.f48883c.setShader(new LinearGradient((r113 * r119) - r117, (r119 * r114) - r118, r117, r118, r108, r111, Shader.TileMode.CLAMP));
        this.f48883c.setStrokeWidth(r112);
        r110.drawPath(d(r101, r112), this.f48883c);
        return;
    L52:
        return;
    L54:
        return;
    L51:
        return;
    L50:
        return;
    L47:
        return;
    }

    public final void g(int r110) {
        ECTagContainerDTO r100 = this.f48893m;
        Integer r101 = null;
        if (r100 == null) goto L34;
        List<com.bytedance.android.ec.store.repository.vo.s> r102 = r100.getSubTagList();
        if (r102 == null) goto L34;
        Iterator<T> r103 = r102.iterator();
        int r104 = Integer.MIN_VALUE;
        Integer r105 = null;
        int r106 = 0;
        int r107 = 0;
        int r108 = 0;
    L8:
        if (r103.hasNext() == false) goto L33;
        Object r109 = r103.next();
        int r111 = r108 + 1;
        if (r108 >= 0) goto L12;
        CollectionsKt.throwIndexOverflow();
    L12:
        com.bytedance.android.ec.store.repository.vo.s r112 = (com.bytedance.android.ec.store.repository.vo.s) r109;
        View r113 = getChildAt(r108);
        if (r113 == null) goto L32;
        Integer r114 = r112.k();
        if (r114 == null) goto L17;
        int r115 = r114.intValue();
    L18:
        measureChild(r113, View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        ViewGroup.LayoutParams r116 = r113.getLayoutParams();
        if ((r116 instanceof ViewGroup.MarginLayoutParams) == true) goto L21;
        r116 = null;
    L21:
        ViewGroup.MarginLayoutParams r117 = (ViewGroup.MarginLayoutParams) r116;
        int r118 = r113.getMeasuredWidth();
        if (r117 == null) goto L24;
        int r119 = r117.leftMargin;
    L25:
        int r120 = r118 + r119;
        if (r117 == null) goto L28;
        int r121 = r117.rightMargin;
    L29:
        r107 = r107 + (r120 + r121);
        if (r115 <= r104) goto L32;
        r105 = Integer.valueOf(r108);
        r106 = r113.getMeasuredWidth();
        r104 = r115;
        goto L32
    L28:
        r121 = 0;
        goto L29
    L24:
        r119 = 0;
        goto L25
    L17:
        r115 = 0;
    L32:
        r108 = r111;
        goto L8
    L33:
        r101 = r105;
    L35:
        if (r107 <= r110) goto L48;
        int r122 = RangesKt.coerceAtMost(RangesKt.coerceAtLeast(r110 - (r107 - r106), 0), r110);
        if (r101 == null) goto L49;
        View r123 = getChildAt(r101.intValue());
        if (r123 != null) goto L41;
        return;
    L41:
        if ((r123 instanceof TextView) == false) goto L51;
        TextView r124 = (TextView) r123;
        ViewGroup.LayoutParams r125 = r124.getLayoutParams();
        r125.width = r122;
        Unit r126 = Unit.INSTANCE;
        r124.setLayoutParams(r125);
        return;
    L51:
        return;
    L49:
        return;
    L48:
        return;
    L34:
        r106 = 0;
        r107 = 0;
        goto L35
    }

    public final void setBaseEventParams(Map<String, String> r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        this.f48892l.putAll(r100);
    }

    public final void setBtmId(String r100) {
        this.f48889i = r100;
    }

    public final void setClickEventName(String r100) {
        this.f48886f = r100;
    }

    public final void setCurrentBoderCorlor(int r100) {
        this.f48882b = r100;
    }

    public final void setHasReportCommonTagShowEvent(boolean r100) {
        this.f48888h = r100;
    }

    public final void setHasReportSingleTagShowEvent(boolean r100) {
        this.f48887g = r100;
    }

    public final void setNeedClip(boolean r100) {
        this.f48881a = r100;
    }

    public final void setShowEventName(String r100) {
        this.f48885e = r100;
    }

    public static void c(ECTagView r100, com.bytedance.android.ec.store.repository.vo.s r101) {
        String r102 = r101.l();
        if (r102 == null) goto L14;
        Map<String, String> r103 = r101.c();
        if (r103 == null) goto L8;
        String r104 = r103.get("btm_id");
        if (r104 == null) goto L8;
    L9:
        PageFinder r105 = PageFinder.via(r100);
        Map<String, String> r106 = r100.f48892l;
        Map<String, String> r107 = r101.c();
        if (r107 != null) goto L12;
        r107 = MapsKt.emptyMap();
    L12:
        r100.doEventAction(r102, r104, r105, MapsKt.plus(r106, r107));
        return;
    L8:
        r104 = "";
        goto L9
    }

    public final Path d(TagContainerUI r100, float r101) {
        this.f48884d.reset();
        float r102 = r101 * 0.5f;
        RectF r103 = new RectF(r102, r102, getWidth() - r102, getHeight() - r102);
        List<Float> r104 = r100.getBorderRadius();
        if (r104 != null) goto L5;
        float[] r105 = {0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
    L44:
        this.f48884d.addRoundRect(r103, r105, Path.Direction.CW);
        return this.f48884d;
    L5:
        List<Float> r106 = r104;
        ArrayList r107 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r106, 10));
        Iterator<T> r108 = r106.iterator();
    L7:
        if (r108.hasNext() == false) goto L10;
        r107.add(Float.valueOf(ExtensionsKt.b(Float.valueOf(((Number) r108.next()).floatValue()))));
        goto L7
    L10:
        if (r104.size() < 4) goto L43;
        r105 = new float[8];
        Float r109 = (Float) CollectionsKt.getOrNull(r107, 0);
        float r110 = 0.0f;
        if (r109 == null) goto L14;
        float r111 = r109.floatValue();
    L15:
        r105[0] = r111;
        Float r112 = (Float) CollectionsKt.getOrNull(r107, 0);
        if (r112 == null) goto L18;
        float r113 = r112.floatValue();
    L19:
        r105[1] = r113;
        Float r114 = (Float) CollectionsKt.getOrNull(r107, 1);
        if (r114 == null) goto L22;
        float r115 = r114.floatValue();
    L23:
        r105[2] = r115;
        Float r116 = (Float) CollectionsKt.getOrNull(r107, 1);
        if (r116 == null) goto L26;
        float r117 = r116.floatValue();
    L27:
        r105[3] = r117;
        Float r118 = (Float) CollectionsKt.getOrNull(r107, 2);
        if (r118 == null) goto L30;
        float r119 = r118.floatValue();
    L31:
        r105[4] = r119;
        Float r120 = (Float) CollectionsKt.getOrNull(r107, 2);
        if (r120 == null) goto L34;
        float r121 = r120.floatValue();
    L35:
        r105[5] = r121;
        Float r122 = (Float) CollectionsKt.getOrNull(r107, 3);
        if (r122 == null) goto L38;
        float r123 = r122.floatValue();
    L39:
        r105[6] = r123;
        Float r124 = (Float) CollectionsKt.getOrNull(r107, 3);
        if (r124 == null) goto L42;
        r110 = r124.floatValue();
    L42:
        r105[7] = r110;
        goto L44
    L38:
        r123 = 0.0f;
        goto L39
    L34:
        r121 = 0.0f;
        goto L35
    L30:
        r119 = 0.0f;
        goto L31
    L26:
        r117 = 0.0f;
        goto L27
    L22:
        r115 = 0.0f;
        goto L23
    L18:
        r113 = 0.0f;
        goto L19
    L14:
        r111 = 0.0f;
        goto L15
    L43:
        r105 = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
        goto L44
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        if (this.f48895o == OverLengthStrategy.TRUNCATE.getStrategy()) goto L5;
        return;
    L5:
        if (this.f48894n <= 0) goto L11;
        int r102 = getMeasuredWidth();
        int r103 = this.f48894n;
        if (r102 <= r103) goto L12;
        setMeasuredDimension(r103, getMeasuredHeight());
        return;
    L12:
        return;
    }

    public final void update(ECTagContainerDTO r100, int r110) {
        Intrinsics.checkNotNullParameter(r100, "tagVO");
        removeAllViews();
        a(r100, null, null, r110, null, null);
    }

    public ECTagView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f48896p = new EventActionImplOpt();
        setGravity(16);
        Paint r103 = new Paint(1);
        r103.setStyle(Paint.Style.STROKE);
        Unit r104 = Unit.INSTANCE;
        this.f48883c = r103;
        this.f48884d = new Path();
        this.f48892l = new LinkedHashMap();
        this.f48895o = -1;
    }

    public final void b(ClickAction r100, View r101, com.bytedance.android.ec.store.repository.vo.s r102) {
        if (r100 == null) goto L20;
        Integer r103 = r100.getActionType();
        int r104 = ActionType.OPEN_SCHEMA.getType();
        if (r103 != null) goto L7;
    L11:
        Integer r105 = r100.getActionType();
        int r106 = ActionType.TOAST.getType();
        if (r105 != null) goto L15;
        return;
    L15:
        if (r105.intValue() == r106) goto L17;
        return;
    L17:
        if (com.bytedance.android.shopping.extensions.k.c(r100.getToastText()) == false) goto L23;
        r101.setOnClickListener(new c(r100, this, r101));
        return;
    L23:
        return;
    L7:
        if (r103.intValue() != r104) goto L11;
        if (com.bytedance.android.shopping.extensions.k.c(r100.getJumpUrl()) == false) goto L11;
        r101.setOnClickListener(new b(r100, this, r101, r102));
        return;
    }

    public /* synthetic */ ECTagView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v0, types: [android.util.AttributeSet] */
    /* JADX WARN: Type inference failed for: r11v46 */
    public final void a(ECTagContainerDTO r210, String r211, xm.c r212, int r213, Function0<String> r214, String r310) {
        Intrinsics.checkNotNullParameter(r210, "tagVO");
        this.f48893m = r210;
        this.f48891k = r212;
        this.f48895o = r213;
        this.f48889i = r310;
        List<com.bytedance.android.ec.store.repository.vo.s> r100 = r210.getSubTagList();
        boolean r101 = true;
        int r102 = 0;
        if (r100 == null) goto L167;
        Iterator<T> r103 = r100.iterator();
        int r104 = 0;
    L6:
        if (r103.hasNext() == false) goto L167;
        Object r105 = r103.next();
        int r106 = r104 + 1;
        if (r104 >= 0) goto L10;
        CollectionsKt.throwIndexOverflow();
    L10:
        com.bytedance.android.ec.store.repository.vo.s r107 = (com.bytedance.android.ec.store.repository.vo.s) r105;
        if (r210.getShouldDropOverflowSubTags() == true) goto L13;
    L15:
        int r108 = r107.getType();
        Long r110 = 0;
        TextView r111 = null;
        r111 = null;
        Integer r112 = null;
        if (r108 != SubTagType.TEXT.getType()) goto L29;
        xm.c r109 = this.f48891k;
        if (r109 == null) goto L22;
        String r113 = r107.n().g();
        Intrinsics.checkNotNullParameter(r113, "text");
        LinkedList<TextView> r114 = r109.f564528b.get(r113);
        if (r114 == null) goto L22;
        r111 = r114.poll();
    L22:
        if (r111 == null) goto L24;
        p.a(r111, r107, false);
    L26:
        if (r107.a() == null) goto L28;
        b(r107.a(), r111, r107);
    L28:
        addView(r111);
        c(this, r107);
    L166:
        r104 = r106;
        goto L6
    L24:
        r111 = a.a(getContext());
        p.a(r111, r107, true);
        goto L26
    L29:
        int r115 = 6;
        int r116 = -2;
        if (r108 != SubTagType.ICON.getType()) goto L57;
        if (r107.m() != null) goto L46;
        xm.c r117 = this.f48891k;
        if (r117 == null) goto L37;
        ECDraweeView r118 = (ECDraweeView) r117.a(ECDraweeView.class, new ECTagView$getIconView$iconView$1(this));
        ECDraweeView r119 = r118;
        if (r118 == null) goto L37;
    L38:
        r119.setAdjustMode(1);
        ECUrlModel r120 = r107.f();
        if (r120 == null) goto L41;
        r116 = com.bytedance.android.shopping.store.utils.o.a(Integer.valueOf(r120.getWidth()));
    L41:
        ECUrlModel r121 = r107.f();
        if (r121 == null) goto L44;
        int r122 = r121.getHeight();
    L45:
        ViewGroup.MarginLayoutParams r123 = new ViewGroup.MarginLayoutParams(r116, com.bytedance.android.shopping.store.utils.o.a(Integer.valueOf(r122)));
        r123.setMargins(r119.getDp(Double.valueOf(r107.g())), 0, r119.getDp(Double.valueOf(r107.h())), 0);
        Unit r124 = Unit.INSTANCE;
        r119.setLayoutParams(r123);
        y.a(r119, r107.f());
        View r125 = r119;
    L53:
        if (r107.a() == null) goto L55;
        b(r107.a(), r125, r107);
    L55:
        c(this, r107);
        addView(r125);
        goto L166
    L44:
        r122 = 14;
    L37:
        ECDraweeView r126 = new ECDraweeView(getContext(), null, 0, 6, null);
        r126.setAdjustMode(1);
        r119 = r126;
        goto L38
    L46:
        xm.c r127 = this.f48891k;
        if (r127 == null) goto L50;
        ECTagDoubleIconView r128 = (ECTagDoubleIconView) r127.a(ECTagDoubleIconView.class, new ECTagView$getIconView$doubleIconView$1(this));
        ECTagDoubleIconView r129 = r128;
        if (r128 == null) goto L50;
    L51:
        Intrinsics.checkNotNullParameter(r107, "subTag");
        i.a(r129.f48866a, r107.f());
        i.a(r129.f48867b, r107.m());
        ViewGroup.MarginLayoutParams r130 = new ViewGroup.MarginLayoutParams(-2, -2);
        r130.setMargins(ExtensionsKt.a(Double.valueOf(r107.g())), 0, ExtensionsKt.a(Double.valueOf(r107.h())), 0);
        Unit r131 = Unit.INSTANCE;
        r129.setLayoutParams(r130);
        r125 = r129;
    L50:
        r129 = new ECTagDoubleIconView(getContext(), r110, r115, r102);
        goto L51
    L57:
        if (r108 != SubTagType.DIVIDER.getType()) goto L91;
        xm.c r132 = this.f48891k;
        if (r132 == null) goto L62;
        ECStoreVerticalDashLine r133 = (ECStoreVerticalDashLine) r132.a(ECStoreVerticalDashLine.class, new ECTagView$getDividerLineView$lineView$1(this));
        if (r133 == null) goto L62;
    L63:
        Number r134 = r107.e().d();
        if (r134 != null) goto L67;
        r134 = 1;
    L67:
        ViewGroup.MarginLayoutParams r135 = new ViewGroup.MarginLayoutParams(ExtensionsKt.a(r134), -1);
        r135.setMargins(ExtensionsKt.a(Double.valueOf(r107.g())), 0, ExtensionsKt.a(Double.valueOf(r107.h())), 0);
        Unit r136 = Unit.INSTANCE;
        r133.setLayoutParams(r135);
        com.bytedance.android.ec.store.repository.vo.d r137 = r107.e();
        Intrinsics.checkNotNullParameter(r137, "config");
        r133.f48840c = r137;
        if (r137.c() != DividerLineType.DASHED_LINE.getType()) goto L79;
        List<Double> r138 = r137.b();
        if (r138 == null) goto L73;
        r112 = Integer.valueOf(r138.size());
    L73:
        if (r112 != null) goto L75;
    L77:
        float r139 = r133.f48843f;
        r133.f48844g = new DashPathEffect(new float[]{r139, r139}, 0.0f);
    L82:
        int r140 = com.bytedance.android.ec.core.utils.s.f45717a;
        r133.f48841d = com.bytedance.android.ec.core.utils.s.a(r137.a(), (int) 2164210514L);
        Number r141 = r137.d();
        if (r141 != null) goto L86;
        r141 = 1;
    L86:
        r133.f48842e = com.bytedance.android.ec.core.utils.q.a(r141);
        r133.invalidate();
        if (r107.a() == null) goto L89;
        b(r107.a(), r133, r107);
    L89:
        c(this, r107);
        addView(r133);
        goto L166
    L75:
        if (r137.b().size() < 2) goto L77;
        r133.f48844g = new DashPathEffect(new float[]{com.bytedance.android.ec.core.utils.q.a((Number) ListProtector.get(r137.b(), 0)), com.bytedance.android.ec.core.utils.q.a((Number) ListProtector.get(r137.b(), 1))}, 0.0f);
        goto L82
    L79:
        if (r137.c() != DividerLineType.SOLID_LINE.getType()) goto L81;
        r133.f48844g = null;
        goto L82
    L81:
        r133.f48844g = null;
    L62:
        r133 = new ECStoreVerticalDashLine(getContext(), r110, r115, r102);
        goto L63
    L91:
        if (r108 != SubTagType.COUNTDOWN.getType()) goto L166;
        xm.c r142 = this.f48891k;
        if (r142 == null) goto L96;
        final ECTagCountdownView r143 = (ECTagCountdownView) r142.a(ECTagCountdownView.class, new ECTagView$getCountdownView$countDownView$1(this));
        if (r143 == null) goto L96;
    L97:
        Intrinsics.checkNotNullParameter(r107, "subTag");
        r143.h();
        r143.f48857i = r107;
        ViewGroup.MarginLayoutParams r144 = new ViewGroup.MarginLayoutParams(-2, -2);
        r144.setMargins(ExtensionsKt.a(Double.valueOf(r107.g())), 0, ExtensionsKt.a(Double.valueOf(r107.h())), 0);
        Unit r145 = Unit.INSTANCE;
        r143.setLayoutParams(r144);
        com.bytedance.android.ec.store.repository.vo.u r146 = r107.j();
        if (r146 == null) goto L100;
        int r147 = (int) r146.b();
    L101:
        int r148 = ExtensionsKt.a(Integer.valueOf(r147));
        com.bytedance.android.ec.store.repository.vo.u r149 = r107.j();
        if (r149 == null) goto L104;
        int r150 = (int) r149.d();
    L105:
        int r151 = ExtensionsKt.a(Integer.valueOf(r150));
        com.bytedance.android.ec.store.repository.vo.u r152 = r107.j();
        if (r152 == null) goto L108;
        int r153 = (int) r152.c();
    L109:
        int r154 = ExtensionsKt.a(Integer.valueOf(r153));
        com.bytedance.android.ec.store.repository.vo.u r155 = r107.j();
        if (r155 == null) goto L112;
        int r156 = (int) r155.a();
    L113:
        r143.setPadding(r148, r151, r154, ExtensionsKt.a(Integer.valueOf(r156)));
        r143.setGravity(16);
        r143.b(r143.f48849a, r143.g());
        r143.b(r143.f48851c, r143.a());
        r143.b(r143.f48852d, r143.a());
        r143.b(r143.f48853e, r143.a());
        r143.b(r143.f48854f, r143.a());
        r143.b(r143.f48855g, r143.a());
        TextView r157 = r143.f48856h;
        com.bytedance.android.ec.store.repository.vo.s r158 = r143.f48857i;
        if (r158 == null) goto L119;
        com.bytedance.android.ec.store.repository.vo.c r159 = r158.d();
        if (r159 == null) goto L119;
        com.bytedance.android.ec.store.repository.vo.v r160 = r159.b();
        if (r160 == null) goto L119;
    L120:
        r143.b(r157, r160);
        com.bytedance.android.ec.store.repository.vo.s r161 = r143.f48857i;
        long r162 = 0;
        if (r161 == null) goto L153;
        com.bytedance.android.ec.store.repository.vo.c r163 = r161.d();
        if (r163 == null) goto L153;
        long r164 = r163.c() * 1000;
        if (r164 <= 0) goto L153;
        long r165 = SystemClock.elapsedRealtime();
        ECTagCountdownView.b r215 = ECTagCountdownView.b.f48862b;
        long r216 = r163.e();
        monitor-enter(r215);
        if (ECTagCountdownView.b.f48861a == null) goto L133;
    L141:
        monitor-exit(r215);
    L142:
        Long r166 = ECTagCountdownView.b.f48861a;
        if (r166 == null) goto L146;
        r162 = RangesKt.coerceAtLeast(r164 - r166.longValue(), 0);
        goto L153
    L146:
        if (r163.e() <= 0) goto L148;
        long r167 = r163.e() * 1000;
    L149:
        r162 = RangesKt.coerceAtLeast(r164 - r167, 0) + r165;
        goto L153
    L148:
        r167 = System.currentTimeMillis();
        goto L149
    L133:
        if (r216 <= 0) goto L141;
        Long r217 = Long.valueOf(r216 * 1000);     // Catch: Throwable -> L150
        if (r217 == null) goto L138;
        r110 = Long.valueOf(r217.longValue() - r165);     // Catch: Throwable -> L150
    L138:
        ECTagCountdownView.b.f48861a = r110;     // Catch: Throwable -> L150
        monitor-exit(r215);
    L150:
        th = move-exception;
        throw th;
    L153:
        r143.f48858j = r162;
        if (r162 > SystemClock.elapsedRealtime()) goto L156;
        boolean r168 = true;
    L157:
        r143.f48860l = r168;
        r143.j(r168);
        if (r143.i(SystemClock.elapsedRealtime()) == false) goto L163;
        r143.f48859k = true;
        Handler r169 = ECTagCountdownTickScheduler.f48845a;
        Intrinsics.checkNotNullParameter(r143, "listener");
        List<WeakReference<ECTagCountdownTickScheduler.a>> r170 = ECTagCountdownTickScheduler.f48846b;
        CollectionsKt.removeAll(r170, new ECTagCountdownTickScheduler$addListener$1(r143));
        ((ArrayList) r170).add(new WeakReference(r143));
        if (ECTagCountdownTickScheduler.f48847c == true) goto L163;
        ECTagCountdownTickScheduler.f48847c = true;
        ECTagCountdownTickScheduler.f48845a.post(ECTagCountdownTickScheduler.f48848d);
    L163:
        if (r107.a() == null) goto L165;
        b(r107.a(), r143, r107);
    L165:
        c(this, r107);
        addView(r143);
        goto L166
    L156:
        r168 = false;
    L119:
        r160 = r143.a();
        goto L120
    L112:
        r156 = 0;
        goto L113
    L108:
        r153 = 0;
        goto L109
    L104:
        r150 = 0;
        goto L105
    L100:
        r147 = 0;
    L96:
        r143 = new ECTagCountdownView(getContext(), null);
        goto L97
    L13:
        if (r210.canDropSubTag(r104) == false) goto L15;
    L167:
        setTagLayoutParams(r210.getTagContainerUI());
        ClickAction r171 = r210.getClickAction();
        if (r171 == null) goto L185;
        Integer r172 = r171.getActionType();
        int r173 = ActionType.OPEN_SCHEMA.getType();
        if (r172 != null) goto L173;
    L177:
        Integer r174 = r171.getActionType();
        int r175 = ActionType.TOAST.getType();
        if (r174 == null) goto L185;
        if (r174.intValue() != r175) goto L185;
        if (com.bytedance.android.shopping.extensions.k.c(r171.getToastText()) == false) goto L185;
        setOnClickListener(new o(r171, this, this, r214));
        goto L185
    L173:
        if (r172.intValue() != r173) goto L177;
        if (com.bytedance.android.shopping.extensions.k.c(r171.getJumpUrl()) == false) goto L177;
        setOnClickListener(new n(r171, this, this, r214));
    L185:
        String r176 = this.f48885e;
        if (r176 != null) goto L188;
    L191:
        boolean r177 = true;
    L192:
        if (r177 == false) goto L194;
        this.f48885e = r210.getShowEventName();
    L194:
        String r178 = this.f48886f;
        if (r178 != null) goto L197;
    L200:
        if (r101 == false) goto L203;
        this.f48886f = r210.getClickEventName();
    L203:
        if (com.bytedance.android.shopping.extensions.k.c(r211) == false) goto L215;
        this.f48890j = r211;
        return;
    L215:
        return;
    L197:
        if (r178.length() == 0) goto L200;
        r101 = false;
        goto L200
    L188:
        if (r176.length() == 0) goto L191;
        r177 = false;
        goto L192
    }
}
