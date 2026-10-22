package com.bytedance.android.ec.window.base.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import com.amap.api.col.s.ce;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.base.service.ECServiceManager;
import com.bytedance.android.ec.core.utils.font.ECFontHelper;
import com.bytedance.android.ec.core.utils.q;
import com.bytedance.android.ec.core.utils.s;
import com.bytedance.android.ec.core.utils.y;
import com.bytedance.android.ec.host.api.service.IECHostService;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.window.base.common.uiext.ExtensionsKt;
import com.bytedance.android.ec.window.base.product.WindowEventActionImplOpt;
import com.bytedance.android.ec.window.base.repository.vo.ActionType;
import com.bytedance.android.ec.window.base.repository.vo.ClickAction;
import com.bytedance.android.ec.window.base.repository.vo.DividerLineType;
import com.bytedance.android.ec.window.base.repository.vo.ECWindowTagContainerDTO;
import com.bytedance.android.ec.window.base.repository.vo.ElementAlignment;
import com.bytedance.android.ec.window.base.repository.vo.OverLengthStrategy;
import com.bytedance.android.ec.window.base.repository.vo.TagContainerUI;
import com.bytedance.android.ec.window.base.repository.vo.TextOverLengthStrategy;
import com.bytedance.android.ec.window.base.repository.vo.WindowSubTagType;
import com.bytedance.android.ec.window.base.repository.vo.WindowTextFontType;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
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
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0016B'\b\u0007\u0012\u0006\u0010N\u001a\u00020M\u0012\n\b\u0002\u0010P\u001a\u0004\u0018\u00010O\u0012\b\b\u0002\u0010Q\u001a\u00020\u000e¢\u0006\u0004\bR\u0010SJ\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002J\u001a\u0010\n\u001a\u00020\u00052\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007J\b\u0010\f\u001a\u0004\u0018\u00010\u000bJ\u001e\u0010\u0012\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010J\u0017\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0013H\u0096\u0001J\t\u0010\u0015\u001a\u00020\bH\u0096\u0001R\"\u0010\u001c\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\"\u0010#\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u0017\u0010)\u001a\u00020$8\u0006¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R\u0017\u0010/\u001a\u00020*8\u0006¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.R\u001d\u00105\u001a\u0004\u0018\u0001008BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u00104R$\u0010<\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b6\u00107\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R$\u0010@\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b=\u00107\u001a\u0004\b>\u00109\"\u0004\b?\u0010;R\"\u0010D\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bA\u0010\u0017\u001a\u0004\bB\u0010\u0019\"\u0004\bC\u0010\u001bR\"\u0010H\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bE\u0010\u0017\u001a\u0004\bF\u0010\u0019\"\u0004\bG\u0010\u001bR$\u0010L\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bI\u00107\u001a\u0004\bJ\u00109\"\u0004\bK\u0010;¨\u0006T"}, d2 = {"Lcom/bytedance/android/ec/window/base/view/ECWindowTagView;", "Landroid/widget/LinearLayout;", "Lcom/bytedance/android/ec/core/event/c;", "Lcom/bytedance/android/ec/window/base/repository/vo/TagContainerUI;", "tagContainerUI", "", "setTagLayoutParams", "", "", "params", "setBaseEventParams", "Lcom/bytedance/android/ec/window/base/repository/vo/ECWindowTagContainerDTO;", "getTagData", "tagVO", "", "overLengthStrategy", "", "useDouyinNumberABCTypeface", "update", "", "getBaseParams", "getBaseParamsJson", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Z", "getNeedClip", "()Z", "setNeedClip", "(Z)V", "needClip", "b", "I", "getCurrentBoderCorlor", "()I", "setCurrentBoderCorlor", "(I)V", "currentBoderCorlor", "Landroid/graphics/Paint;", "c", "Landroid/graphics/Paint;", "getBorderPaint", "()Landroid/graphics/Paint;", "borderPaint", "Landroid/graphics/Path;", "d", "Landroid/graphics/Path;", "getBorderPath", "()Landroid/graphics/Path;", "borderPath", "Landroid/graphics/Typeface;", "e", "Lkotlin/Lazy;", "getDouyinNumberABCTypeface", "()Landroid/graphics/Typeface;", "douyinNumberABCTypeface", "f", "Ljava/lang/String;", "getShowEventName", "()Ljava/lang/String;", "setShowEventName", "(Ljava/lang/String;)V", "showEventName", ce.f26391f, "getClickEventName", "setClickEventName", "clickEventName", "h", "getHasReportSingleTagShowEvent", "setHasReportSingleTagShowEvent", "hasReportSingleTagShowEvent", RXScreenCaptureService.KEY_INDEX, "getHasReportCommonTagShowEvent", "setHasReportCommonTagShowEvent", "hasReportCommonTagShowEvent", ce.f26395j, "getBtmId", "setBtmId", "btmId", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECWindowTagView extends LinearLayout implements com.bytedance.android.ec.core.event.c {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final /* synthetic */ int f49848r = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f49849a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f49850b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Paint f49851c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Path f49852d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f49853e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f49854f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f49855g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f49856h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f49857i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f49858j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f49859k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ap.c f49860l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Map<String, String> f49861m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public ECWindowTagContainerDTO f49862n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f49863o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f49864p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final /* synthetic */ WindowEventActionImplOpt f49865q;

    public static final class a {
    }

    static {
    }

    public ECWindowTagView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ECWindowTagView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    private final Typeface getDouyinNumberABCTypeface() {
        return (Typeface) this.f49853e.getValue();
    }

    @Override // com.bytedance.android.ec.core.event.c
    public final void appendEventParams(Map<String, String> r100) {
        Intrinsics.checkNotNullParameter(r100, "paramsMap");
        this.f49865q.appendEventParams(r100);
    }

    @Override // com.bytedance.android.ec.core.event.c
    public final void appendEventParams(Pair<String, String>... r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        this.f49865q.appendEventParams(r100);
    }

    @Override // com.bytedance.android.ec.core.event.c
    public final void bindMonitorId(Long r100) {
        this.f49865q.getClass();
    }

    @Override // com.bytedance.android.ec.core.event.c
    public final void clearEventParams() {
        this.f49865q.clearEventParams();
    }

    @Override // com.bytedance.android.ec.core.event.c
    public final void doAnyEventAction(String r100, Map<String, ? extends Object> r101, Pair<String, ? extends Object>... r102) {
        Intrinsics.checkNotNullParameter(r100, "actionName");
        Intrinsics.checkNotNullParameter(r102, "params");
        this.f49865q.doAnyEventAction(r100, r101, r102);
    }

    @Override // com.bytedance.android.ec.core.event.c
    public final void doAnyEventActionWithBtm(String r100, PageFinder r101, String r110, Map<String, ? extends Object> r111, Pair<String, ? extends Object>... r112) {
        Intrinsics.checkNotNullParameter(r100, "btm");
        Intrinsics.checkNotNullParameter(r101, "pageFinder");
        Intrinsics.checkNotNullParameter(r110, "actionName");
        Intrinsics.checkNotNullParameter(r112, "params");
        this.f49865q.doAnyEventActionWithBtm(r100, r101, r110, r111, r112);
    }

    @Override // com.bytedance.android.ec.core.event.c
    public final void doEventAction(String r100, String r101, PageFinder r102, Map<String, String> r103) {
        Intrinsics.checkNotNullParameter(r100, "actionName");
        Intrinsics.checkNotNullParameter(r103, "paramMap");
        this.f49865q.doEventAction(r100, r101, r102, r103);
    }

    @Override // com.bytedance.android.ec.core.event.c
    public final void doEventAction(String r100, String r101, PageFinder r102, Pair<String, String>... r103) {
        Intrinsics.checkNotNullParameter(r100, "actionName");
        Intrinsics.checkNotNullParameter(r103, "params");
        this.f49865q.doEventAction(r100, r101, r102, r103);
    }

    @Override // com.bytedance.android.ec.core.event.c
    public final void doEventAction(String r100, Map<String, String> r101, Pair<String, String>... r102) {
        Intrinsics.checkNotNullParameter(r100, "actionName");
        Intrinsics.checkNotNullParameter(r102, "params");
        this.f49865q.doEventAction(r100, r101, r102);
    }

    @Override // com.bytedance.android.ec.core.event.c
    public final void doEventAction(String r100, Pair<String, String>... r101) {
        Intrinsics.checkNotNullParameter(r100, "actionName");
        Intrinsics.checkNotNullParameter(r101, "params");
        this.f49865q.doEventAction(r100, r101);
    }

    @Override // com.bytedance.android.ec.core.event.c
    public String getBaseParamsJson() {
        return this.f49865q.getBaseParamsJson();
    }

    @Override // com.bytedance.android.ec.core.event.c
    public final void initEventContext(Map<String, String> r100) {
        Intrinsics.checkNotNullParameter(r100, "paramsMap");
        this.f49865q.initEventContext(r100);
    }

    @Override // com.bytedance.android.ec.core.event.c
    public final void initEventContext(Pair<String, String>... r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        this.f49865q.initEventContext(r100);
    }

    public final void b() {
        String r100 = this.f49855g;
        if (r100 == null) goto L10;
        String r101 = this.f49858j;
        PageFinder r102 = PageFinder.via(this);
        Map<String, String> r103 = this.f49861m;
        ECWindowTagContainerDTO r104 = this.f49862n;
        if (r104 == null) goto L8;
        Map<String, String> r105 = r104.getClickParams();
        if (r105 == null) goto L8;
    L9:
        doEventAction(r100, r101, r102, MapsKt.plus(r103, r105));
    L8:
        r105 = MapsKt.emptyMap();
    L10:
        LinkedHashMap r106 = new LinkedHashMap();
        ECWindowTagContainerDTO r107 = this.f49862n;
        String r108 = "";
        if (r107 == null) goto L14;
        String r109 = r107.getTagType();
        if (r109 == null) goto L14;
    L15:
        r106.put("type", r109);
        String r110 = this.f49859k;
        if (r110 == null) goto L19;
        r108 = r110;
    L19:
        r106.put("scene", r108);
        doEventAction("ec_shop_tag_click", this.f49858j, PageFinder.via(this), MapsKt.plus(this.f49861m, r106));
        return;
    L14:
        r109 = "";
        goto L15
    }

    public final void c() {
        if (this.f49856h == true) goto L13;
        String r100 = this.f49854f;
        if (r100 == null) goto L13;
        this.f49856h = true;
        String r101 = this.f49858j;
        PageFinder r102 = PageFinder.via(this);
        Map<String, String> r103 = this.f49861m;
        ECWindowTagContainerDTO r104 = this.f49862n;
        if (r104 == null) goto L10;
        Map<String, String> r105 = r104.getShowParams();
        if (r105 == null) goto L10;
    L11:
        doEventAction(r100, r101, r102, MapsKt.plus(r103, r105));
    L10:
        r105 = MapsKt.emptyMap();
    L13:
        if (this.f49857i == false) goto L15;
        return;
    L15:
        if (wg.a.b(this) <= 0.5d) goto L28;
        LinkedHashMap r106 = new LinkedHashMap();
        ECWindowTagContainerDTO r107 = this.f49862n;
        String r108 = "";
        if (r107 == null) goto L20;
        String r109 = r107.getTagType();
        if (r109 == null) goto L20;
    L21:
        r106.put("type", r109);
        String r110 = this.f49859k;
        if (r110 == null) goto L25;
        r108 = r110;
    L25:
        r106.put("scene", r108);
        doEventAction("ec_shop_tag_show", this.f49858j, PageFinder.via(this), MapsKt.plus(this.f49861m, r106));
        this.f49857i = true;
        return;
    L20:
        r109 = "";
        goto L21
    }

    @Override // com.bytedance.android.ec.core.event.c
    public Map<String, String> getBaseParams() {
        return this.f49865q.b();
    }

    public final Paint getBorderPaint() {
        return this.f49851c;
    }

    public final Path getBorderPath() {
        return this.f49852d;
    }

    public final String getBtmId() {
        return this.f49858j;
    }

    public final String getClickEventName() {
        return this.f49855g;
    }

    public final int getCurrentBoderCorlor() {
        return this.f49850b;
    }

    public final boolean getHasReportCommonTagShowEvent() {
        return this.f49857i;
    }

    public final boolean getHasReportSingleTagShowEvent() {
        return this.f49856h;
    }

    public final boolean getNeedClip() {
        return this.f49849a;
    }

    public final String getShowEventName() {
        return this.f49854f;
    }

    public final ECWindowTagContainerDTO getTagData() {
        return this.f49862n;
    }

    private final void setTagLayoutParams(TagContainerUI r110) {
        int r100 = s.f45717a;
        if (r110 == null) goto L5;
        String r101 = r110.getBgColor();
    L6:
        Integer r102 = s.b(r101);
        if (r102 == null) goto L9;
        int r103 = r102.intValue();
    L10:
        GradientDrawable r104 = new GradientDrawable();
        r104.setColor(r103);
        if (r110 != null) goto L13;
    L33:
        ViewCompat.setBackground(this, r104);
        if (r110 == null) goto L36;
        Integer r105 = Integer.valueOf(r110.getElementAliment());
    L37:
        int r106 = ElementAlignment.LEADING.getType();
        if (r105 != null) goto L41;
    L43:
        int r107 = ElementAlignment.CENTER.getType();
        if (r105 != null) goto L47;
    L49:
        int r108 = ElementAlignment.TRAILING.getType();
        if (r105 != null) goto L53;
    L55:
        int r109 = GravityCompat.START;
    L56:
        setGravity(r109 | 16);
        if (r110 == null) goto L59;
        Integer r111 = Integer.valueOf(r110.getHeight());
        Lazy r112 = ExtensionsKt.f49216a;
        Intrinsics.checkNotNullParameter(r111, "$this$sp");
        int r113 = (int) TypedValue.applyDimension(2, r111.floatValue(), (DisplayMetrics) ExtensionsKt.f49216a.getValue());
    L60:
        setLayoutParams(new LinearLayout.LayoutParams(-2, r113));
        if (r110 == null) goto L63;
        int r114 = ExtensionsKt.a(Integer.valueOf((int) r110.getMaxWidth()));
    L64:
        this.f49863o = r114;
        if (r110 == null) goto L123;
        List<Float> r115 = r110.getBorderRadius();
        if (r115 == null) goto L124;
        List<Float> r116 = r115;
        if ((r116 instanceof Collection) == true) goto L71;
    L73:
        Iterator<T> r117 = r116.iterator();
    L75:
        if (r117.hasNext() == false) goto L82;
        if (((Number) r117.next()).floatValue() <= 0) goto L79;
        boolean r118 = true;
    L80:
        if (r118 == false) goto L75;
        boolean r119 = true;
    L83:
        if (r119 != true) goto L125;
        List<Float> r120 = r110.getBorderRadius();
        if (r120 == null) goto L87;
        Integer r121 = Integer.valueOf(r120.size());
    L89:
        if (r121.intValue() < 4) goto L126;
        Float r122 = (Float) CollectionsKt.getOrNull(r110.getBorderRadius(), 0);
        if (r122 == null) goto L93;
        float r123 = r122.floatValue();
    L94:
        Float r124 = (Float) CollectionsKt.getOrNull(r110.getBorderRadius(), 1);
        if (r124 == null) goto L97;
        float r125 = r124.floatValue();
    L98:
        Float r126 = (Float) CollectionsKt.getOrNull(r110.getBorderRadius(), 2);
        if (r126 == null) goto L101;
        float r127 = r126.floatValue();
    L102:
        Float r128 = (Float) CollectionsKt.getOrNull(r110.getBorderRadius(), 3);
        if (r128 == null) goto L105;
        float r129 = r128.floatValue();
    L106:
        Lazy r130 = ExtensionsKt.f49216a;
        Intrinsics.checkNotNullParameter(this, "$this$setRadius");
        float r131 = ExtensionsKt.b(Float.valueOf(r123));
        float r132 = ExtensionsKt.b(Float.valueOf(r125));
        float r133 = ExtensionsKt.b(Float.valueOf(r127));
        float r134 = ExtensionsKt.b(Float.valueOf(r129));
        Float r135 = ArraysKt.maxOrNull(new float[]{r131, r132, r133, r134});
        if (r135 == null) goto L109;
        float r136 = r135.floatValue();
    L111:
        if (r136 <= 0) goto L113;
        setClipToOutline(true);
        setOutlineProvider(new com.bytedance.android.ec.window.base.common.uiext.a(r136, r131, r134, r132, r133));
        return;
    L113:
        setClipToOutline(false);
        setOutlineProvider(null);
        return;
    L109:
        r136 = 0.0f;
        goto L111
    L105:
        r129 = 0.0f;
        goto L106
    L101:
        r127 = 0.0f;
        goto L102
    L97:
        r125 = 0.0f;
        goto L98
    L93:
        r123 = 0.0f;
        goto L94
    L126:
        return;
    L87:
        r121 = null;
        goto L89
    L125:
        return;
    L79:
        r118 = false;
    L82:
        r119 = false;
        goto L83
    L71:
        if (r116.isEmpty() == false) goto L73;
    L124:
        return;
    L123:
        return;
    L63:
        r114 = 0;
        goto L64
    L59:
        r113 = 0;
        goto L60
    L53:
        if (r105.intValue() != r108) goto L55;
        r109 = GravityCompat.END;
        goto L56
    L47:
        if (r105.intValue() != r107) goto L49;
        r109 = 17;
        goto L56
    L41:
        if (r105.intValue() != r106) goto L43;
    L36:
        r105 = null;
        goto L37
    L13:
        if (r110.getHasBorder() != true) goto L33;
        List<Float> r137 = r110.getBorderRadius();
        if (r137.size() < 4) goto L28;
        float[] r138 = new float[8];
        int r139 = 0;
    L17:
        if (r139 >= 4) goto L27;
        int r140 = r139 * 2;
        Float r141 = (Float) CollectionsKt.getOrNull(r137, r139);
        if (r141 == null) goto L21;
        float r142 = ExtensionsKt.b(r141);
    L22:
        r138[r140] = r142;
        int r143 = r140 + 1;
        Float r144 = (Float) CollectionsKt.getOrNull(r137, r139);
        if (r144 == null) goto L25;
        float r145 = ExtensionsKt.b(r144);
    L26:
        r138[r143] = r145;
        r139 = r139 + 1;
        goto L17
    L25:
        r145 = 0.0f;
        goto L26
    L21:
        r142 = 0.0f;
        goto L22
    L27:
        r104.setCornerRadii(r138);
    L28:
        int r146 = s.f45717a;
        Integer r147 = s.b(r110.getBorderColor());
        if (r147 == null) goto L33;
        int r148 = r147.intValue();
        this.f49850b = r148;
        if (this.f49849a == true) goto L33;
        r104.setStroke(ExtensionsKt.a(Double.valueOf(r110.getBorderWidth())), r148);
        goto L33
    L9:
        r103 = 16777215;
        goto L10
    L5:
        r101 = null;
        goto L6
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        super.dispatchDraw(r100);
        ECWindowTagContainerDTO r101 = this.f49862n;
        if (r101 == null) goto L19;
        TagContainerUI r102 = r101.getTagContainerUI();
        if (r102 != null) goto L8;
        return;
    L8:
        if (this.f49849a == true) goto L10;
        return;
    L10:
        if (r102.getHasBorder() == false) goto L21;
        int r103 = 0;
        if (r102.getBorderWidth() <= 0) goto L22;
        float r104 = ExtensionsKt.a(Double.valueOf(r102.getBorderWidth()));
        this.f49851c.setColor(this.f49850b);
        this.f49851c.setStrokeWidth(r104);
        this.f49852d.reset();
        float r105 = r104 * 0.5f;
        RectF r106 = new RectF(r105, r105, getWidth() - r105, getHeight() - r105);
        float[] r107 = com.bytedance.android.ec.window.base.utils.a.a(r102.getBorderRadius());
        int r108 = r107.length;
    L14:
        if (r103 >= r108) goto L16;
        r107[r103] = RangesKt.coerceAtLeast(r107[r103] - r105, 0.0f);
        r103 = r103 + 1;
        goto L14
    L16:
        this.f49852d.addRoundRect(r106, r107, Path.Direction.CW);
        r100.drawPath(this.f49852d, this.f49851c);
        return;
    L22:
        return;
    L21:
        return;
    }

    public final void setBaseEventParams(Map<String, String> r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        this.f49861m.putAll(r100);
    }

    public final void setBtmId(String r100) {
        this.f49858j = r100;
    }

    public final void setClickEventName(String r100) {
        this.f49855g = r100;
    }

    public final void setCurrentBoderCorlor(int r100) {
        this.f49850b = r100;
    }

    public final void setHasReportCommonTagShowEvent(boolean r100) {
        this.f49857i = r100;
    }

    public final void setHasReportSingleTagShowEvent(boolean r100) {
        this.f49856h = r100;
    }

    public final void setNeedClip(boolean r100) {
        this.f49849a = r100;
    }

    public final void setShowEventName(String r100) {
        this.f49854f = r100;
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        if (this.f49864p == OverLengthStrategy.TRUNCATE.getStrategy()) goto L5;
        return;
    L5:
        if (this.f49863o <= 0) goto L11;
        int r102 = getMeasuredWidth();
        int r103 = this.f49863o;
        if (r102 <= r103) goto L12;
        setMeasuredDimension(r103, getMeasuredHeight());
        return;
    L12:
        return;
    }

    public ECWindowTagView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f49865q = new WindowEventActionImplOpt();
        setGravity(16);
        Paint r103 = new Paint(1);
        r103.setStyle(Paint.Style.STROKE);
        Unit r104 = Unit.INSTANCE;
        this.f49851c = r103;
        this.f49852d = new Path();
        this.f49853e = LazyKt.lazy(ECWindowTagView$douyinNumberABCTypeface$2.INSTANCE);
        this.f49861m = new LinkedHashMap();
        this.f49864p = -1;
    }

    public final void update(ECWindowTagContainerDTO r110, int r111, boolean r112) {
        Intrinsics.checkNotNullParameter(r110, "tagVO");
        removeAllViews();
        a(r110, null, null, r111, r112, null, null);
    }

    public /* synthetic */ ECWindowTagView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    public final void a(ECWindowTagContainerDTO r110, String r111, ap.c r210, int r211, boolean r212, Function0<String> r213, String r214) {
        Intrinsics.checkNotNullParameter(r110, "tagVO");
        this.f49862n = r110;
        this.f49860l = r210;
        this.f49864p = r211;
        this.f49858j = r214;
        List<com.bytedance.android.ec.window.base.repository.vo.f> r100 = r110.getSubTagList();
        if (r100 != null) goto L5;
        r100 = CollectionsKt.emptyList();
    L5:
        Iterator<com.bytedance.android.ec.window.base.repository.vo.f> r101 = r100.iterator();
    L6:
        boolean r102 = true;
        int r103 = 0;
        if (r101.hasNext() == false) goto L128;
        com.bytedance.android.ec.window.base.repository.vo.f r104 = r101.next();
        int r105 = r104.getType();
        int r112 = -2;
        if (r105 == WindowSubTagType.TEXT.getType()) goto L10;
        Integer r113 = null;
        if (r105 == WindowSubTagType.ICON.getType()) goto L64;
        if (r105 != WindowSubTagType.DIVIDER.getType()) goto L6;
        ap.c r106 = this.f49860l;
        if (r106 == null) goto L95;
        ECWindowVerticalDashLine r107 = (ECWindowVerticalDashLine) r106.a(ECWindowVerticalDashLine.class, new ECWindowTagView$getDividerLineView$lineView$1(this));
        if (r107 == null) goto L95;
    L96:
        Number r114 = r104.a().d();
        if (r114 != null) goto L100;
        r114 = 1;
    L100:
        r107.setLayoutParams(new ViewGroup.LayoutParams(ExtensionsKt.a(r114), -1));
        com.bytedance.android.ec.window.base.repository.vo.a r108 = r104.a();
        Intrinsics.checkNotNullParameter(r108, "config");
        if (r108.c() != DividerLineType.DASHED_LINE.getType()) goto L120;
        List<Double> r109 = r108.b();
        if (r109 == null) goto L106;
        r113 = Integer.valueOf(r109.size());
    L106:
        if (r113 != null) goto L108;
    L118:
        float r115 = r107.f49870e;
        r107.f49871f = new DashPathEffect(new float[]{r115, r115}, 0.0f);
    L123:
        int r116 = s.f45717a;
        r107.f49868c = s.a(r108.a(), (int) 2164210514L);
        Number r117 = r108.d();
        if (r117 != null) goto L127;
        r117 = 1;
    L127:
        r107.f49869d = q.a(r117);
        r107.invalidate();
        addView(r107);
        goto L6
    L108:
        if (r108.b().size() < 2) goto L118;
        float[] r118 = new float[2];
        Double r119 = (Double) CollectionsKt.getOrNull(r108.b(), 0);
        if (r119 == null) goto L112;
        float r120 = q.a(r119);
    L113:
        r118[0] = r120;
        Double r121 = (Double) CollectionsKt.getOrNull(r108.b(), 1);
        if (r121 == null) goto L116;
        float r122 = q.a(r121);
    L117:
        r118[1] = r122;
        r107.f49871f = new DashPathEffect(r118, 0.0f);
        goto L123
    L116:
        r122 = r107.f49870e;
        goto L117
    L112:
        r120 = r107.f49870e;
        goto L113
    L120:
        if (r108.c() != DividerLineType.SOLID_LINE.getType()) goto L122;
        r107.f49871f = null;
        goto L123
    L122:
        r107.f49871f = null;
    L95:
        r107 = new ECWindowVerticalDashLine(getContext(), null, 6, 0);
        goto L96
    L64:
        if (r104.f() != null) goto L82;
        ap.c r123 = this.f49860l;
        if (r123 == null) goto L69;
        ECDraweeView r124 = (ECDraweeView) r123.a(ECDraweeView.class, new ECWindowTagView$getIconView$iconView$1(this));
        ECDraweeView r125 = r124;
        if (r124 == null) goto L69;
    L70:
        r125.setAdjustMode(1);
        ECUrlModel r126 = r104.b();
        if (r126 == null) goto L73;
        int r127 = r126.getHeight();
    L74:
        Integer r128 = Integer.valueOf(r127);
        Lazy r129 = ExtensionsKt.f49216a;
        Intrinsics.checkNotNullParameter(r128, "$this$sp");
        int r130 = (int) TypedValue.applyDimension(2, r128.floatValue(), (DisplayMetrics) ExtensionsKt.f49216a.getValue());
        if (r126 != null) goto L77;
    L81:
        ViewGroup.MarginLayoutParams r131 = new ViewGroup.MarginLayoutParams(r112, r130);
        r131.setMargins(r125.getDp(Double.valueOf(r104.c())), 0, r125.getDp(Double.valueOf(r104.d())), 0);
        Unit r132 = Unit.INSTANCE;
        r125.setLayoutParams(r131);
        y.a(r125, r126);
        View r133 = r125;
    L88:
        addView(r133);
        goto L6
    L77:
        if (r126.getWidth() <= 0) goto L81;
        if (r126.getHeight() <= 0) goto L81;
        r112 = (int) (((r130 * r126.getWidth()) / r126.getHeight()) + 0.5f);
        goto L81
    L73:
        r127 = 14;
    L69:
        ECDraweeView r134 = new ECDraweeView(getContext(), null, 0, 6, null);
        r134.setAdjustMode(1);
        r125 = r134;
        goto L70
    L82:
        ap.c r135 = this.f49860l;
        if (r135 == null) goto L86;
        ECWindowTagDoubleIconView r136 = (ECWindowTagDoubleIconView) r135.a(ECWindowTagDoubleIconView.class, new ECWindowTagView$getIconView$doubleIconView$1(this));
        if (r136 == null) goto L86;
    L87:
        ECWindowTagDoubleIconView r137 = r136;
        Intrinsics.checkNotNullParameter(r104, "subTag");
        c.a(r137.f49826a, r104.b());
        c.a(r137.f49827b, r104.f());
        ViewGroup.MarginLayoutParams r138 = new ViewGroup.MarginLayoutParams(-2, -2);
        r138.setMargins(ExtensionsKt.a(Double.valueOf(r104.c())), 0, ExtensionsKt.a(Double.valueOf(r104.d())), 0);
        Unit r139 = Unit.INSTANCE;
        r137.setLayoutParams(r138);
        r133 = r137;
    L86:
        r136 = new ECWindowTagDoubleIconView(getContext(), null, 6, 0);
        goto L87
    L10:
        ap.c r140 = this.f49860l;
        if (r140 == null) goto L14;
        TextView r141 = (TextView) r140.a(TextView.class, new ECWindowTagView$getTextView$textView$1(this));
        if (r141 == null) goto L14;
    L15:
        ViewGroup.MarginLayoutParams r142 = new ViewGroup.MarginLayoutParams(-2, -2);
        r142.setMargins(ExtensionsKt.a(Double.valueOf(r104.c())), 0, ExtensionsKt.a(Double.valueOf(r104.d())), 0);
        Unit r143 = Unit.INSTANCE;
        r141.setLayoutParams(r142);
        r141.setText(r104.g().e());
        Integer r144 = r104.g().g();
        int r145 = TextOverLengthStrategy.END_ELLIPSIS.getType();
        if (r144 != null) goto L19;
    L21:
        int r146 = s.f45717a;
        Integer r147 = s.b(r104.g().f());
        if (r147 == null) goto L24;
        r141.setTextColor(r147.intValue());
    L24:
        r141.setTextSize(2, r104.g().b());
        if (r104.g().c() != WindowTextFontType.DOUYIN_NUMBER.getType()) goto L28;
        r141.setTypeface(ECFontHelper.f45592e.b("DouyinNumberABC", 400, false));
    L36:
        com.bytedance.android.shopping.extensions.f.e(r141, Integer.valueOf(RangesKt.coerceAtLeast(r104.g().d(), 400)));
        Integer r148 = s.b(r104.g().a());
        if (r148 == null) goto L39;
        r141.setBackgroundColor(r148.intValue());
    L39:
        com.bytedance.android.ec.window.base.repository.vo.g r149 = r104.e();
        if (r149 == null) goto L42;
        int r150 = (int) r149.b();
    L43:
        int r151 = ExtensionsKt.a(Integer.valueOf(r150));
        com.bytedance.android.ec.window.base.repository.vo.g r152 = r104.e();
        if (r152 == null) goto L46;
        int r153 = (int) r152.c();
    L47:
        int r154 = ExtensionsKt.a(Integer.valueOf(r153));
        com.bytedance.android.ec.window.base.repository.vo.g r155 = r104.e();
        if (r155 == null) goto L50;
        int r156 = (int) r155.d();
    L51:
        int r157 = ExtensionsKt.a(Integer.valueOf(r156));
        com.bytedance.android.ec.window.base.repository.vo.g r158 = r104.e();
        if (r158 == null) goto L54;
        r103 = (int) r158.a();
    L54:
        int r159 = ExtensionsKt.a(Integer.valueOf(r103));
        r141.setPadding(r151, r157, r154, r159);
        if (r157 != 0) goto L58;
        if (r159 != 0) goto L58;
        r141.setGravity(16);
    L58:
        if (r212 == false) goto L60;
        r141.setTypeface(getDouyinNumberABCTypeface());
    L60:
        addView(r141);
        goto L6
    L50:
        r156 = 0;
        goto L51
    L46:
        r153 = 0;
        goto L47
    L42:
        r150 = 0;
        goto L43
    L28:
        if (r104.g().c() != WindowTextFontType.DOUYIN_TEXT.getType()) goto L35;
        boolean r160 = ECServiceManager.f42805a;
        IECHostService r161 = (IECHostService) ECServiceManager.c(IECHostService.class);
        if (r161 == null) goto L33;
        Typeface r162 = IECHostService.a.a(r161, r141.getContext());
        if (r162 == null) goto L33;
    L34:
        r141.setTypeface(r162);
    L33:
        r162 = Typeface.DEFAULT;
        goto L34
    L35:
        r141.setTypeface(Typeface.DEFAULT);
        goto L36
    L19:
        if (r144.intValue() != r145) goto L21;
        r141.setEllipsize(TextUtils.TruncateAt.END);
    L14:
        Context r163 = getContext();
        Intrinsics.checkNotNullParameter(r163, PerfLog.PARAM_KEY_CONTEXT_ID);
        TextView r164 = new TextView(r163);
        r164.setIncludeFontPadding(true);
        r164.setGravity(16);
        r164.setMaxLines(1);
        r164.getLayoutParams();
        r141 = r164;
        goto L15
    L128:
        setTagLayoutParams(r110.getTagContainerUI());
        ClickAction r165 = r110.getClickAction();
        if (r165 == null) goto L146;
        Integer r166 = r165.getActionType();
        int r167 = ActionType.OPEN_SCHEMA.getType();
        if (r166 != null) goto L134;
    L138:
        Integer r168 = r165.getActionType();
        int r169 = ActionType.TOAST.getType();
        if (r168 == null) goto L146;
        if (r168.intValue() != r169) goto L146;
        if (com.bytedance.android.shopping.extensions.k.c(r165.getToastText()) == false) goto L146;
        setOnClickListener(new g(r165, this, r213));
        goto L146
    L134:
        if (r166.intValue() != r167) goto L138;
        if (com.bytedance.android.shopping.extensions.k.c(r165.getJumpUrl()) == false) goto L138;
        setOnClickListener(new f(r165, this, r213));
    L146:
        String r170 = this.f49854f;
        if (r170 != null) goto L149;
    L152:
        boolean r171 = true;
    L153:
        if (r171 == false) goto L155;
        this.f49854f = r110.getShowEventName();
    L155:
        String r172 = this.f49855g;
        if (r172 != null) goto L158;
    L161:
        if (r102 == false) goto L164;
        this.f49855g = r110.getClickEventName();
    L164:
        if (com.bytedance.android.shopping.extensions.k.c(r111) == false) goto L178;
        this.f49859k = r111;
        return;
    L178:
        return;
    L158:
        if (r172.length() == 0) goto L161;
        r102 = false;
        goto L161
    L149:
        if (r170.length() == 0) goto L152;
        r171 = false;
        goto L153
    }
}
