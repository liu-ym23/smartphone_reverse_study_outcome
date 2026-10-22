package com.bytedance.android.ec.window.base.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.core.utils.s;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.window.base.common.uiext.ExtensionsKt;
import com.bytedance.android.ec.window.base.product.WindowEventActionImplOpt;
import com.bytedance.android.ec.window.base.repository.vo.ActionType;
import com.bytedance.android.ec.window.base.repository.vo.ClickAction;
import com.bytedance.android.ec.window.base.repository.vo.ECWindowTagContainerDTO;
import com.bytedance.android.ec.window.base.repository.vo.ECWindowTagListDTO;
import com.bytedance.android.ec.window.base.repository.vo.OverLengthStrategy;
import com.bytedance.android.ec.window.base.repository.vo.TagContainerUI;
import com.bytedance.android.ec.window.base.repository.vo.TagListUI;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0018B'\b\u0007\u0012\u0006\u00103\u001a\u000202\u0012\n\b\u0002\u00105\u001a\u0004\u0018\u000104\u0012\b\b\u0002\u00106\u001a\u00020\b¢\u0006\u0004\b7\u00108J\u001e\u0010\u0007\u001a\u00020\u00062\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\u0002J\b\u0010\t\u001a\u00020\bH\u0002J\b\u0010\n\u001a\u00020\u0004H\u0002J\u0012\u0010\r\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002J\u000e\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000eJ\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011J\u0017\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0014H\u0096\u0001J\t\u0010\u0016\u001a\u00020\u0004H\u0096\u0001R\"\u0010\u001e\u001a\u00020\u00178\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010\"\u001a\u00020\u00178\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010\u0019\u001a\u0004\b \u0010\u001b\"\u0004\b!\u0010\u001dR$\u0010)\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R$\u0010-\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b*\u0010$\u001a\u0004\b+\u0010&\"\u0004\b,\u0010(R\"\u00101\u001a\u00020\u00178\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b.\u0010\u0019\u001a\u0004\b/\u0010\u001b\"\u0004\b0\u0010\u001d¨\u00069"}, d2 = {"Lcom/bytedance/android/ec/window/base/view/ECWindowTagListView;", "Landroid/widget/LinearLayout;", "Lcom/bytedance/android/ec/core/event/c;", "", "", "params", "", "setBaseEventParams", "", "getLowestPriority", "getTags", "Lcom/bytedance/android/ec/window/base/repository/vo/TagListUI;", "tagListUI", "setTagListLayoutParams", "Lcom/bytedance/android/ec/window/base/view/k;", "processor", "setSchemaProcessor", "", "Lcom/bytedance/android/ec/window/base/repository/vo/ECWindowTagContainerDTO;", "getVisibleTagList", "", "getBaseParams", "getBaseParamsJson", "", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Z", "getSubTagNeedClip", "()Z", "setSubTagNeedClip", "(Z)V", "subTagNeedClip", "b", "getBorderNeedClip", "setBorderNeedClip", "borderNeedClip", "h", "Ljava/lang/String;", "getTagShowEventName", "()Ljava/lang/String;", "setTagShowEventName", "(Ljava/lang/String;)V", "tagShowEventName", RXScreenCaptureService.KEY_INDEX, "getTagClickEventName", "setTagClickEventName", "tagClickEventName", "s", "getUseDouyinNumberABCTypeface", "setUseDouyinNumberABCTypeface", "useDouyinNumberABCTypeface", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECWindowTagListView extends LinearLayout implements com.bytedance.android.ec.core.event.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f49828a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f49829b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f49830c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Paint f49831d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Path f49832e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public k f49833f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final LinkedHashSet<com.bytedance.android.ec.window.base.view.a> f49834g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f49835h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f49836i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ap.c f49837j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ECWindowTagListDTO f49838k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Function0<String> f49839l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f49840m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Map<String, String> f49841n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Integer f49842o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f49843p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f49844q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f49845r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f49846s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final /* synthetic */ WindowEventActionImplOpt f49847t;

    public static final class a {
    }

    static {
    }

    public ECWindowTagListView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ECWindowTagListView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // com.bytedance.android.ec.core.event.c
    public final void appendEventParams(Map<String, String> r100) {
        Intrinsics.checkNotNullParameter(r100, "paramsMap");
        this.f49847t.appendEventParams(r100);
    }

    @Override // com.bytedance.android.ec.core.event.c
    public final void appendEventParams(Pair<String, String>... r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        this.f49847t.appendEventParams(r100);
    }

    @Override // com.bytedance.android.ec.core.event.c
    public final void bindMonitorId(Long r100) {
        this.f49847t.getClass();
    }

    @Override // com.bytedance.android.ec.core.event.c
    public final void clearEventParams() {
        this.f49847t.clearEventParams();
    }

    @Override // com.bytedance.android.ec.core.event.c
    public final void doAnyEventAction(String r100, Map<String, ? extends Object> r101, Pair<String, ? extends Object>... r102) {
        Intrinsics.checkNotNullParameter(r100, "actionName");
        Intrinsics.checkNotNullParameter(r102, "params");
        this.f49847t.doAnyEventAction(r100, r101, r102);
    }

    @Override // com.bytedance.android.ec.core.event.c
    public final void doAnyEventActionWithBtm(String r100, PageFinder r101, String r110, Map<String, ? extends Object> r111, Pair<String, ? extends Object>... r112) {
        Intrinsics.checkNotNullParameter(r100, "btm");
        Intrinsics.checkNotNullParameter(r101, "pageFinder");
        Intrinsics.checkNotNullParameter(r110, "actionName");
        Intrinsics.checkNotNullParameter(r112, "params");
        this.f49847t.doAnyEventActionWithBtm(r100, r101, r110, r111, r112);
    }

    @Override // com.bytedance.android.ec.core.event.c
    public final void doEventAction(String r100, String r101, PageFinder r102, Map<String, String> r103) {
        Intrinsics.checkNotNullParameter(r100, "actionName");
        Intrinsics.checkNotNullParameter(r103, "paramMap");
        this.f49847t.doEventAction(r100, r101, r102, r103);
    }

    @Override // com.bytedance.android.ec.core.event.c
    public final void doEventAction(String r100, String r101, PageFinder r102, Pair<String, String>... r103) {
        Intrinsics.checkNotNullParameter(r100, "actionName");
        Intrinsics.checkNotNullParameter(r103, "params");
        this.f49847t.doEventAction(r100, r101, r102, r103);
    }

    @Override // com.bytedance.android.ec.core.event.c
    public final void doEventAction(String r100, Map<String, String> r101, Pair<String, String>... r102) {
        Intrinsics.checkNotNullParameter(r100, "actionName");
        Intrinsics.checkNotNullParameter(r102, "params");
        this.f49847t.doEventAction(r100, r101, r102);
    }

    @Override // com.bytedance.android.ec.core.event.c
    public final void doEventAction(String r100, Pair<String, String>... r101) {
        Intrinsics.checkNotNullParameter(r100, "actionName");
        Intrinsics.checkNotNullParameter(r101, "params");
        this.f49847t.doEventAction(r100, r101);
    }

    @Override // com.bytedance.android.ec.core.event.c
    public String getBaseParamsJson() {
        return this.f49847t.getBaseParamsJson();
    }

    @Override // com.bytedance.android.ec.core.event.c
    public final void initEventContext(Map<String, String> r100) {
        Intrinsics.checkNotNullParameter(r100, "paramsMap");
        this.f49847t.initEventContext(r100);
    }

    @Override // com.bytedance.android.ec.core.event.c
    public final void initEventContext(Pair<String, String>... r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        this.f49847t.initEventContext(r100);
    }

    private final int getLowestPriority() {
        ECWindowTagListDTO r100 = this.f49838k;
        int r101 = Integer.MIN_VALUE;
        if (r100 == null) goto L12;
        List<ECWindowTagContainerDTO> r102 = r100.getTagContainers();
        if (r102 == null) goto L12;
        Iterator<T> r103 = r102.iterator();
    L8:
        if (r103.hasNext() == false) goto L12;
        ECWindowTagContainerDTO r104 = (ECWindowTagContainerDTO) r103.next();
        if (r104.getPriority() <= r101) goto L8;
        r101 = r104.getPriority();
    L12:
        return r101;
    }

    private final String getTags() {
        ECWindowTagListDTO r100 = this.f49838k;
        if (r100 == null) goto L21;
        List<ECWindowTagContainerDTO> r101 = r100.getTagContainers();
        if (r101 == null) goto L21;
        List<ECWindowTagContainerDTO> r102 = r101;
        ArrayList r103 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r102, 10));
        Iterator<T> r104 = r102.iterator();
    L8:
        if (r104.hasNext() == false) goto L19;
        List<com.bytedance.android.ec.window.base.repository.vo.f> r105 = ((ECWindowTagContainerDTO) r104.next()).getSubTagList();
        if (r105 == null) goto L17;
        com.bytedance.android.ec.window.base.repository.vo.f r106 = (com.bytedance.android.ec.window.base.repository.vo.f) CollectionsKt.firstOrNull(r105);
        if (r106 == null) goto L17;
        com.bytedance.android.ec.window.base.repository.vo.h r107 = r106.g();
        if (r107 == null) goto L17;
        String r108 = r107.e();
        if (r108 == null) goto L17;
    L18:
        r103.add(r108);
    L17:
        r108 = "none";
        goto L18
    L19:
        String r109 = CollectionsKt.joinToString$default(r103, ",", null, null, 0, null, null, 62, null);
        if (r109 == null) goto L21;
        return r109;
    L21:
        return "";
    }

    @Override // com.bytedance.android.ec.core.event.c
    public Map<String, String> getBaseParams() {
        return this.f49847t.b();
    }

    public final boolean h() {
        ECWindowTagListDTO r100 = this.f49838k;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.getOverLengthStrategy() != OverLengthStrategy.HIDE.getStrategy()) goto L7;
        return true;
    }

    public final void g() {
        int r100 = getChildCount();
        int r101 = 0;
    L3:
        if (r101 >= r100) goto L13;
        View r102 = getChildAt(r101);
        if ((r102 instanceof ECWindowTagView) == true) goto L7;
        r102 = null;
    L7:
        ECWindowTagView r103 = (ECWindowTagView) r102;
        if (r103 == null) goto L12;
        if (r103.getVisibility() != 0) goto L12;
        r103.c();
    L12:
        r101 = r101 + 1;
        goto L3
    }

    public final List<ECWindowTagContainerDTO> getVisibleTagList() {
        if (h() == false) goto L19;
        List<View> r100 = com.bytedance.commerce.base.view.b.a(this);
        ArrayList r101 = new ArrayList();
        Iterator<T> r102 = r100.iterator();
    L6:
        if (r102.hasNext() == false) goto L18;
        View r103 = (View) r102.next();
        if (r103.getMeasuredWidth() > 0) goto L10;
    L15:
        ECWindowTagContainerDTO r104 = null;
    L16:
        if (r104 == null) goto L6;
        r101.add(r104);
        goto L6
    L10:
        if ((r103 instanceof ECWindowTagView) == true) goto L12;
        r103 = null;
    L12:
        ECWindowTagView r105 = (ECWindowTagView) r103;
        if (r105 == null) goto L15;
        r104 = r105.getTagData();
        goto L16
    L18:
        return r101;
    L19:
        List<View> r106 = com.bytedance.commerce.base.view.b.a(this);
        ArrayList r107 = new ArrayList();
        Iterator<T> r108 = r106.iterator();
    L21:
        if (r108.hasNext() == false) goto L33;
        View r109 = (View) r108.next();
        if (r109.getVisibility() == 0) goto L25;
    L30:
        ECWindowTagContainerDTO r110 = null;
    L31:
        if (r110 == null) goto L21;
        r107.add(r110);
        goto L21
    L25:
        if ((r109 instanceof ECWindowTagView) == true) goto L27;
        r109 = null;
    L27:
        ECWindowTagView r111 = (ECWindowTagView) r109;
        if (r111 == null) goto L30;
        r110 = r111.getTagData();
        goto L31
    L33:
        return r107;
    }

    @Override // android.view.View, android.view.ViewParent
    public final void requestLayout() {
        if (h() == false) goto L9;
        int r100 = this.f49845r;
        if (r100 != 0) goto L7;
        super.requestLayout();
        return;
    L7:
        this.f49845r = r100 - 1;
        return;
    L9:
        if (this.f49844q == true) goto L14;
        super.requestLayout();
        return;
    }

    public final boolean getBorderNeedClip() {
        return this.f49829b;
    }

    public final boolean getSubTagNeedClip() {
        return this.f49828a;
    }

    public final String getTagClickEventName() {
        return this.f49836i;
    }

    public final String getTagShowEventName() {
        return this.f49835h;
    }

    public final boolean getUseDouyinNumberABCTypeface() {
        return this.f49846s;
    }

    public static LinearLayout.LayoutParams d(ECWindowTagContainerDTO r100) {
        TagContainerUI r101 = r100.getTagContainerUI();
        if (r101 != null) goto L5;
    L7:
        TagContainerUI r102 = r100.getTagContainerUI();
        if (r102 == null) goto L10;
        int r103 = ExtensionsKt.a(Integer.valueOf(r102.getHeight()));
    L11:
        LinearLayout.LayoutParams r104 = new LinearLayout.LayoutParams(-2, r103);
    L12:
        TagContainerUI r105 = r100.getTagContainerUI();
        if (r105 == null) goto L15;
        int r106 = ExtensionsKt.a(Integer.valueOf(r105.getMarginLeft()));
    L16:
        TagContainerUI r107 = r100.getTagContainerUI();
        if (r107 == null) goto L19;
        int r108 = ExtensionsKt.a(Integer.valueOf(r107.getMarginRight()));
    L20:
        r104.setMargins(r106, 0, r108, 0);
        return r104;
    L19:
        r108 = 0;
        goto L20
    L15:
        r106 = 0;
        goto L16
    L10:
        r103 = -2;
        goto L11
    L5:
        if (r101.getFillContainer() != true) goto L7;
        r104 = new LinearLayout.LayoutParams(-1, -1);
        goto L12
    }

    private final void setBaseEventParams(Map<String, String> r100) {
        if (r100 == null) goto L5;
        this.f49841n.putAll(r100);
        return;
    }

    private final void setTagListLayoutParams(TagListUI r110) {
        if (r110 != null) goto L4;
        return;
    L4:
        int r100 = s.f45717a;
        Integer r101 = s.b(r110.getBgColor());
        if (r101 == null) goto L7;
        int r102 = r101.intValue();
    L8:
        List<Float> r103 = r110.getRadius();
        ArrayList r104 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r103, 10));
        Iterator<T> r105 = r103.iterator();
    L10:
        if (r105.hasNext() == false) goto L12;
        r104.add(Float.valueOf(ExtensionsKt.b(Float.valueOf(((Number) r105.next()).floatValue()))));
        goto L10
    L12:
        GradientDrawable r106 = new GradientDrawable();
        if (r104.size() < 4) goto L46;
        float[] r107 = new float[8];
        Float r108 = (Float) CollectionsKt.getOrNull(r104, 0);
        float r109 = 0.0f;
        if (r108 == null) goto L17;
        float r111 = r108.floatValue();
    L18:
        r107[0] = r111;
        Float r112 = (Float) CollectionsKt.getOrNull(r104, 0);
        if (r112 == null) goto L21;
        float r113 = r112.floatValue();
    L22:
        r107[1] = r113;
        Float r114 = (Float) CollectionsKt.getOrNull(r104, 1);
        if (r114 == null) goto L25;
        float r115 = r114.floatValue();
    L26:
        r107[2] = r115;
        Float r116 = (Float) CollectionsKt.getOrNull(r104, 1);
        if (r116 == null) goto L29;
        float r117 = r116.floatValue();
    L30:
        r107[3] = r117;
        Float r118 = (Float) CollectionsKt.getOrNull(r104, 2);
        if (r118 == null) goto L33;
        float r119 = r118.floatValue();
    L34:
        r107[4] = r119;
        Float r120 = (Float) CollectionsKt.getOrNull(r104, 2);
        if (r120 == null) goto L37;
        float r121 = r120.floatValue();
    L38:
        r107[5] = r121;
        Float r122 = (Float) CollectionsKt.getOrNull(r104, 3);
        if (r122 == null) goto L41;
        float r123 = r122.floatValue();
    L42:
        r107[6] = r123;
        Float r124 = (Float) CollectionsKt.getOrNull(r104, 3);
        if (r124 == null) goto L45;
        r109 = r124.floatValue();
    L45:
        r107[7] = r109;
    L47:
        r106.setCornerRadii(r107);
        int r125 = s.f45717a;
        Integer r126 = s.b(r110.getBorderColor());
        if (r126 == null) goto L52;
        int r127 = r126.intValue();
        this.f49830c = r127;
        if (this.f49829b == true) goto L52;
        r106.setStroke(ExtensionsKt.a(Double.valueOf(r110.getBorderWidth())), r127);
    L52:
        r106.setColor(r102);
        int r128 = com.bytedance.android.ec.window.base.utils.c.f49722a;
        Intrinsics.checkNotNullParameter(this, "$this$setBackgroundCompat");
        setBackground(r106);
        if (r110.getHeight() <= 0) goto L57;
        getLayoutParams().height = ExtensionsKt.a(Double.valueOf(r110.getHeight()));
        return;
    L57:
        return;
    L41:
        r123 = 0.0f;
        goto L42
    L37:
        r121 = 0.0f;
        goto L38
    L33:
        r119 = 0.0f;
        goto L34
    L29:
        r117 = 0.0f;
        goto L30
    L25:
        r115 = 0.0f;
        goto L26
    L21:
        r113 = 0.0f;
        goto L22
    L17:
        r111 = 0.0f;
        goto L18
    L46:
        r107 = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
        goto L47
    L7:
        r102 = 16777215;
        goto L8
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        super.dispatchDraw(r100);
        ECWindowTagListDTO r101 = this.f49838k;
        if (r101 == null) goto L19;
        TagListUI r102 = r101.getTagListUI();
        if (r102 != null) goto L8;
        return;
    L8:
        if (this.f49829b == true) goto L10;
        return;
    L10:
        if (r102.getHasBorder() == false) goto L21;
        int r103 = 0;
        if (r102.getBorderWidth() <= 0) goto L22;
        float r104 = ExtensionsKt.a(Double.valueOf(r102.getBorderWidth()));
        this.f49831d.setColor(this.f49830c);
        this.f49831d.setStrokeWidth(r104);
        this.f49832e.reset();
        float r105 = r104 * 0.5f;
        RectF r106 = new RectF(r105, r105, getWidth() - r105, getHeight() - r105);
        float[] r107 = com.bytedance.android.ec.window.base.utils.a.a(r102.getRadius());
        int r108 = r107.length;
    L14:
        if (r103 >= r108) goto L16;
        r107[r103] = RangesKt.coerceAtLeast(r107[r103] - r105, 0.0f);
        r103 = r103 + 1;
        goto L14
    L16:
        this.f49832e.addRoundRect(r106, r107, Path.Direction.CW);
        r100.drawPath(this.f49832e, this.f49831d);
        return;
    L22:
        return;
    L21:
        return;
    }

    public final void setBorderNeedClip(boolean r100) {
        this.f49829b = r100;
    }

    public final void setSchemaProcessor(k r100) {
        Intrinsics.checkNotNullParameter(r100, "processor");
        this.f49833f = r100;
    }

    public final void setSubTagNeedClip(boolean r100) {
        this.f49828a = r100;
    }

    public final void setTagClickEventName(String r100) {
        this.f49836i = r100;
    }

    public final void setTagShowEventName(String r100) {
        this.f49835h = r100;
    }

    public final void setUseDouyinNumberABCTypeface(boolean r100) {
        this.f49846s = r100;
    }

    public static final void a(ECWindowTagListView r100, ECWindowTagListDTO r101) {
        r100.getClass();
        String r102 = r101.getClickEventName();
        if (r102 == null) goto L9;
        String r103 = r100.f49840m;
        PageFinder r104 = PageFinder.via(r100);
        Map<String, String> r105 = r100.f49841n;
        Map<String, String> r106 = r101.getShowEventParams();
        if (r106 != null) goto L7;
        r106 = MapsKt.emptyMap();
    L7:
        r100.doEventAction(r102, r103, r104, MapsKt.plus(r105, r106));
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final ECWindowTagView c(ECWindowTagContainerDTO r110, int r111) {
        ap.c r100 = this.f49837j;
        String r101 = null;
        Object[] r102 = 0;
        if (r100 == null) goto L6;
        ECWindowTagView r103 = (ECWindowTagView) r100.a(ECWindowTagView.class, new ECWindowTagListView$createTagView$tagView$1(this));
        if (r103 == null) goto L6;
    L7:
        r103.setBaseEventParams(this.f49841n);
        r103.setNeedClip(this.f49828a);
        r103.setShowEventName(this.f49835h);
        r103.setClickEventName(this.f49836i);
        ECWindowTagListDTO r104 = this.f49838k;
        if (r104 == null) goto L10;
        r101 = r104.getScene();
    L10:
        ECWindowTagView r105 = r103;
        r105.a(r110, r101, this.f49837j, r111, this.f49846s, this.f49839l, this.f49840m);
        return r103;
    L6:
        Object[] r106 = r102 == true ? 1 : 0;
        r103 = new ECWindowTagView(getContext(), r106, 6, 0);
        goto L7
    }

    public final void e(int r110, int r111) {
        this.f49844q = true;
        int r100 = View.MeasureSpec.getSize(r110);
        int r101 = View.MeasureSpec.getMode(r110);
        int r102 = View.MeasureSpec.getSize(r111);
        int r103 = View.MeasureSpec.getMode(r111);
        int r104 = getChildCount();
        int r105 = 0;
        int r106 = 0;
        int r107 = 0;
        int r108 = 0;
        int r112 = 0;
    L3:
        if (r106 >= r104) goto L28;
        View r113 = getChildAt(r106);
        if ((r113 instanceof ECWindowTagView) == true) goto L7;
        r113 = null;
    L7:
        ECWindowTagView r114 = (ECWindowTagView) r113;
        if (r114 == null) goto L24;
        r114.setVisibility(r105);
        ECWindowTagListDTO r115 = this.f49838k;
        if (r115 == null) goto L13;
        int r116 = r115.getContainerShowMax();
    L15:
        if (r112 < r116) goto L18;
        r114.setVisibility(8);
        goto L24
    L18:
        measureChild(r114, r110, r111);
        ViewGroup.LayoutParams r117 = r114.getLayoutParams();
        if (r117 == null) goto L26;
        ViewGroup.MarginLayoutParams r118 = (ViewGroup.MarginLayoutParams) r117;
        int r119 = (r114.getMeasuredWidth() + r118.leftMargin) + r118.rightMargin;
        int r109 = (r114.getMeasuredHeight() + r118.topMargin) + r118.bottomMargin;
        int r120 = r107 + r119;
        if (r120 <= ((r100 - getPaddingLeft()) - getPaddingRight())) goto L23;
        r114.setVisibility(8);
        goto L24
    L23:
        r108 = RangesKt.coerceAtLeast(r108, r109);
        r112 = r112 + 1;
        r114.c();
        r107 = r120;
        goto L24
    L26:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L13:
        r116 = Integer.MAX_VALUE;
    L24:
        r106 = r106 + 1;
        r105 = 0;
        goto L3
    L28:
        if (r101 == 1073741824) goto L31;
        int r121 = r107 + getPaddingLeft();
        r100 = getPaddingRight() + r121;
    L31:
        if (r103 == 1073741824) goto L34;
        r102 = (r108 + getPaddingTop()) + getPaddingBottom();
    L34:
        setMeasuredDimension(r100, r102);
        this.f49844q = false;
    }

    public final void f(int r210, int r211) {
        int r100 = View.MeasureSpec.getSize(r210);
        int r101 = View.MeasureSpec.getMode(r210);
        int r102 = View.MeasureSpec.getSize(r211);
        int r103 = View.MeasureSpec.getMode(r211);
        ECWindowTagListDTO r104 = this.f49838k;
        int r105 = 0;
        if (r104 == null) goto L7;
        List<ECWindowTagContainerDTO> r106 = r104.getTagContainers();
        if (r106 == null) goto L7;
        int r107 = r106.size();
    L8:
        int r108 = 0;
        int r109 = 0;
        int r110 = 0;
        int r111 = 0;
    L9:
        if (r108 >= r107) goto L93;
        ECWindowTagListDTO r112 = this.f49838k;
        if (r112 == null) goto L13;
        int r113 = r112.getContainerShowMax();
    L14:
        if (r109 >= r113) goto L93;
        if (this.f49843p == false) goto L64;
        ECWindowTagListDTO r114 = this.f49838k;
        if (r114 == null) goto L23;
        List<ECWindowTagContainerDTO> r115 = r114.getTagContainers();
        if (r115 == null) goto L23;
        ECWindowTagContainerDTO r116 = (ECWindowTagContainerDTO) CollectionsKt.getOrNull(r115, r108);
    L24:
        ECWindowTagListDTO r117 = this.f49838k;
        if (r117 == null) goto L27;
        Integer r118 = Integer.valueOf(r117.getOverLengthStrategy());
    L28:
        if (r116 != null) goto L30;
    L29:
        r102 = r102;
        ECWindowTagView r119 = null;
    L61:
        if (r119 == null) goto L95;
        boolean r120 = true;
    L72:
        measureChild(r119, r210, r211);
        ViewGroup.LayoutParams r121 = r119.getLayoutParams();
        if (r121 == null) goto L92;
        ViewGroup.MarginLayoutParams r122 = (ViewGroup.MarginLayoutParams) r121;
        int r123 = (r119.getMeasuredWidth() + r122.leftMargin) + r122.rightMargin;
        int r124 = (r119.getMeasuredHeight() + r122.topMargin) + r122.bottomMargin;
        int r125 = r123 + r110;
        if (r125 <= ((r100 - getPaddingLeft()) - getPaddingRight())) goto L87;
        if (r120 == false) goto L86;
        ap.c r126 = this.f49837j;
        if (r126 == null) goto L80;
        r126.c(ECWindowTagView.class, r119);
    L80:
        List<View> r127 = com.bytedance.commerce.base.view.b.a(r119);
        r119.removeAllViews();
        Iterator<T> r128 = r127.iterator();
    L82:
        if (r128.hasNext() == false) goto L90;
        View r129 = (View) r128.next();
        ap.c r130 = this.f49837j;
        if (r130 == null) goto L82;
        r130.c(r129.getClass(), r129);
    L90:
        r108 = r108 + 1;
        r102 = r102;
        r105 = 0;
        goto L9
    L86:
        measureChild(r119, View.MeasureSpec.makeMeasureSpec(0, 1073741824), r211);
        goto L90
    L87:
        if (r120 == false) goto L89;
        this.f49845r++;
        addView(r119);
    L89:
        r111 = RangesKt.coerceAtLeast(r111, r124);
        r109 = r109 + 1;
        r119.c();
        r110 = r125;
        goto L90
    L92:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L95:
        if (r101 == 1073741824) goto L98;
        r100 = getPaddingRight() + (r110 + getPaddingLeft());
    L98:
        if (r103 != 1073741824) goto L100;
        int r131 = r102;
    L101:
        setMeasuredDimension(r100, r131);
        this.f49843p = false;
        return;
    L100:
        r131 = (r111 + getPaddingTop()) + getPaddingBottom();
        goto L101
    L30:
        if (r118 == null) goto L29;
        r118.intValue();
        r119 = c(r116, r118.intValue());
        if (r119.getLayoutParams() != null) goto L34;
        r119.setLayoutParams(d(r116));
        r102 = r102;
        goto L61
    L34:
        ViewGroup.LayoutParams r132 = r119.getLayoutParams();
        if ((r132 instanceof ViewGroup.MarginLayoutParams) == true) goto L37;
        ViewGroup.LayoutParams r133 = null;
    L38:
        ViewGroup.MarginLayoutParams r134 = (ViewGroup.MarginLayoutParams) r133;
        if (r134 == null) goto L49;
        TagContainerUI r135 = r116.getTagContainerUI();
        if (r135 == null) goto L43;
        int r136 = ExtensionsKt.a(Integer.valueOf(r135.getMarginLeft()));
    L44:
        TagContainerUI r137 = r116.getTagContainerUI();
        if (r137 == null) goto L47;
        int r138 = ExtensionsKt.a(Integer.valueOf(r137.getMarginRight()));
    L48:
        r134.setMargins(r136, r105, r138, r105);
    L50:
        TagContainerUI r139 = r116.getTagContainerUI();
        if (r139 != null) goto L53;
    L55:
        ViewGroup.LayoutParams r140 = r119.getLayoutParams();
        TagContainerUI r141 = r116.getTagContainerUI();
        if (r141 == null) goto L58;
        int r142 = ExtensionsKt.a(Integer.valueOf(r141.getHeight()));
    L59:
        r140.height = r142;
        r119.getLayoutParams().width = -2;
        goto L61
    L58:
        r142 = -2;
        goto L59
    L53:
        if (r139.getFillContainer() != true) goto L55;
        r119.getLayoutParams().height = -1;
        r119.getLayoutParams().width = -1;
        goto L61
    L47:
        r138 = 0;
        goto L48
    L43:
        r136 = 0;
        goto L44
    L49:
        r102 = r102;
        goto L50
    L37:
        r133 = r132;
        goto L38
    L27:
        r118 = null;
    L23:
        r116 = null;
        goto L24
    L64:
        r102 = r102;
        View r143 = getChildAt(r108);
        if ((r143 instanceof ECWindowTagView) == true) goto L67;
        View r144 = null;
    L68:
        r119 = (ECWindowTagView) r144;
        if (r119 == null) goto L95;
        r120 = false;
        goto L72
    L67:
        r144 = r143;
        goto L68
    L13:
        r113 = Integer.MAX_VALUE;
    L93:
        r102 = r102;
    L7:
        r107 = 0;
        goto L8
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int r210, int r211) {
        ECWindowTagListDTO r100 = this.f49838k;
        if (r100 == null) goto L5;
        Integer r101 = Integer.valueOf(r100.getOverLengthStrategy());
    L6:
        int r102 = OverLengthStrategy.HIDE.getStrategy();
        if (r101 != null) goto L10;
    L15:
        int r103 = OverLengthStrategy.SCALE_LOWEST_PRIORITY.getStrategy();
        String r110 = "fillView";
        if (r101 != null) goto L19;
    L122:
        int r104 = OverLengthStrategy.TRUNCATE.getStrategy();
        if (r101 != null) goto L126;
    L128:
        int r105 = OverLengthStrategy.ALLHIDE.getStrategy();
        if (r101 != null) goto L132;
    L159:
        int r106 = OverLengthStrategy.ALL_SHOW.getStrategy();
        if (r101 != null) goto L163;
    L173:
        int r107 = OverLengthStrategy.FIXED_WIDTH_ALL_SHOW.getStrategy();
        if (r101 == null) goto L253;
        if (r101.intValue() != r107) goto L253;
        int r108 = View.MeasureSpec.getSize(r210);
        View.MeasureSpec.getMode(r210);
        int r109 = View.MeasureSpec.getSize(r211);
        View.MeasureSpec.getMode(r211);
        int r111 = getLowestPriority();
        int r112 = getChildCount();
        int r113 = 0;
    L179:
        if (r113 >= r112) goto L198;
        View r114 = getChildAt(r113);
        if ((r114 instanceof ECWindowTagView) == true) goto L183;
        r114 = null;
    L183:
        ECWindowTagView r115 = (ECWindowTagView) r114;
        if (r115 == null) goto L197;
        ECWindowTagContainerDTO r116 = r115.f49862n;
        if (r116 == null) goto L188;
        int r117 = r116.getPriority();
    L189:
        if (r117 < r111) goto L197;
        int r118 = r115.getChildCount();
        int r119 = 0;
    L192:
        if (r119 >= r118) goto L197;
        View r120 = r115.getChildAt(r119);
        if ((r120 instanceof TextView) == false) goto L196;
        TextView r121 = (TextView) r120;
        ViewGroup.LayoutParams r122 = r121.getLayoutParams();
        r122.width = -2;
        Unit r123 = Unit.INSTANCE;
        r121.setLayoutParams(r122);
    L196:
        r119 = r119 + 1;
        goto L192
    L188:
        r117 = Integer.MIN_VALUE;
    L197:
        r113 = r113 + 1;
        goto L179
    L198:
        int r124 = getChildCount();
        int r125 = 0;
        int r126 = 0;
        int r127 = 0;
        int r128 = 0;
        ECWindowTagView r129 = null;
        View r130 = null;
    L199:
        if (r126 >= r124) goto L225;
        View r131 = getChildAt(r126);
        int r132 = r124;
        if (Intrinsics.areEqual(r131.getTag(), r110) == false) goto L204;
        r130 = r131;
    L204:
        if ((r131 instanceof ECWindowTagView) == true) goto L206;
        r131 = null;
    L206:
        ECWindowTagView r133 = (ECWindowTagView) r131;
        if (r133 == null) goto L222;
        String r134 = r110;
        if (r133.getVisibility() == 8) goto L224;
        measureChild(r133, r210, r211);
        ViewGroup.LayoutParams r135 = r133.getLayoutParams();
        if (r135 == null) goto L221;
        ViewGroup.MarginLayoutParams r136 = (ViewGroup.MarginLayoutParams) r135;
        int r137 = (r133.getMeasuredWidth() + r136.leftMargin) + r136.rightMargin;
        int r138 = (r133.getMeasuredHeight() + r136.topMargin) + r136.bottomMargin;
        r125 = r125 + r137;
        ECWindowTagContainerDTO r139 = r133.getTagData();
        if (r139 != null) goto L216;
    L218:
        r127 = r127 + r137;
    L219:
        r128 = RangesKt.coerceAtLeast(r128, r138);
        goto L224
    L216:
        if (r139.getPriority() != r111) goto L218;
        r129 = r133;
        goto L219
    L221:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L224:
        r126 = r126 + 1;
        r124 = r132;
        r110 = r134;
        r130 = r130;
        goto L199
    L222:
        r134 = r110;
        goto L224
    L225:
        if (r125 <= r108) goto L249;
        if (r129 == null) goto L228;
        ViewGroup.LayoutParams r140 = r129.getLayoutParams();
    L230:
        if ((r140 instanceof ViewGroup.MarginLayoutParams) == true) goto L232;
        ViewGroup.LayoutParams r141 = null;
    L233:
        ViewGroup.MarginLayoutParams r142 = (ViewGroup.MarginLayoutParams) r141;
        if (r142 == null) goto L236;
        int r143 = r142.leftMargin;
    L237:
        if (r142 == null) goto L239;
        int r144 = r142.rightMargin;
    L240:
        int r145 = RangesKt.coerceAtLeast((r108 - r127) - (r143 + r144), 0);
        if (r129 == null) goto L249;
        int r146 = r129.getChildCount();
        int r147 = 0;
    L243:
        if (r147 >= r146) goto L248;
        View r148 = r129.getChildAt(r147);
        if ((r148 instanceof TextView) == false) goto L247;
        TextView r149 = (TextView) r148;
        ViewGroup.LayoutParams r150 = r149.getLayoutParams();
        r150.width = r145;
        Unit r151 = Unit.INSTANCE;
        r149.setLayoutParams(r150);
    L247:
        r147 = r147 + 1;
        goto L243
    L248:
        measureChild(r129, r210, r211);
        goto L249
    L239:
        r144 = 0;
        goto L240
    L236:
        r143 = 0;
        goto L237
    L232:
        r141 = r140;
        goto L233
    L228:
        r140 = null;
    L249:
        if (r130 == null) goto L251;
        r130.getLayoutParams().width = RangesKt.coerceAtLeast(r108 - r125, 0);
        measureChild(r130, r210, r211);
    L251:
        g();
        setMeasuredDimension(r108, r109);
        return;
    L253:
        if (h() == false) goto L255;
        f(r210, r211);
        return;
    L255:
        e(r210, r211);
        return;
    L163:
        if (r101.intValue() != r106) goto L173;
        super.onMeasure(r210, r211);
        int r152 = getChildCount();
        int r153 = 0;
    L165:
        if (r153 >= r152) goto L312;
        View r154 = getChildAt(r153);
        if ((r154 instanceof ECWindowTagView) == true) goto L169;
        r154 = null;
    L169:
        ECWindowTagView r155 = (ECWindowTagView) r154;
        if (r155 == null) goto L172;
        r155.c();
    L172:
        r153 = r153 + 1;
        goto L165
    L312:
        return;
    L132:
        if (r101.intValue() != r105) goto L159;
        int r156 = View.MeasureSpec.getSize(r210);
        int r157 = View.MeasureSpec.getMode(r210);
        int r158 = View.MeasureSpec.getSize(r211);
        int r159 = View.MeasureSpec.getMode(r211);
        int r160 = getChildCount();
        int r161 = 0;
        int r162 = 0;
        int r163 = 0;
    L134:
        if (r162 >= r160) goto L150;
        View r164 = getChildAt(r162);
        if ((r164 instanceof ECWindowTagView) == true) goto L138;
        r164 = null;
    L138:
        ECWindowTagView r165 = (ECWindowTagView) r164;
        if (r165 == null) goto L148;
        if (r165.getVisibility() == 8) goto L148;
        measureChild(r165, r210, r211);
        ViewGroup.LayoutParams r166 = r165.getLayoutParams();
        if (r166 == null) goto L147;
        ViewGroup.MarginLayoutParams r167 = (ViewGroup.MarginLayoutParams) r166;
        r161 = r161 + ((r165.getMeasuredWidth() + r167.leftMargin) + r167.rightMargin);
        r163 = RangesKt.coerceAtLeast(r163, (r165.getMeasuredHeight() + r167.topMargin) + r167.bottomMargin);
        goto L148
    L147:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L148:
        r162 = r162 + 1;
        goto L134
    L150:
        if (r157 != 1073741824) goto L152;
        int r168 = r156;
    L153:
        if (r159 == 1073741824) goto L156;
        r158 = (r163 + getPaddingTop()) + getPaddingBottom();
    L156:
        setMeasuredDimension(r168, r158);
        if (r161 <= r156) goto L307;
        setVisibility(8);
        return;
    L307:
        return;
    L152:
        r168 = (getPaddingLeft() + r161) + getPaddingRight();
        goto L153
    L126:
        if (r101.intValue() != r104) goto L128;
        super.onMeasure(r210, r211);
        return;
    L19:
        if (r101.intValue() != r103) goto L122;
        int r169 = View.MeasureSpec.getSize(r210);
        int r170 = View.MeasureSpec.getMode(r210);
        int r171 = View.MeasureSpec.getSize(r211);
        int r172 = View.MeasureSpec.getMode(r211);
        int r173 = getLowestPriority();
        int r174 = getChildCount();
        int r175 = 0;
    L21:
        if (r175 >= r174) goto L55;
        View r176 = getChildAt(r175);
        if ((r176 instanceof ECWindowTagView) == true) goto L25;
        r176 = null;
    L25:
        ECWindowTagView r177 = (ECWindowTagView) r176;
        if (r177 == null) goto L54;
        ECWindowTagContainerDTO r178 = r177.f49862n;
        if (r178 == null) goto L30;
        int r179 = r178.getPriority();
    L31:
        if (r179 < r173) goto L54;
        int r180 = r177.getChildCount();
        int r181 = 0;
    L34:
        if (r181 >= r180) goto L54;
        View r182 = r177.getChildAt(r181);
        int r212 = r180;
        ECWindowTagContainerDTO r183 = r177.f49862n;
        if (r183 == null) goto L40;
        List<com.bytedance.android.ec.window.base.repository.vo.f> r184 = r183.getSubTagList();
        if (r184 == null) goto L40;
        com.bytedance.android.ec.window.base.repository.vo.f r185 = (com.bytedance.android.ec.window.base.repository.vo.f) CollectionsKt.getOrNull(r184, r181);
    L42:
        if ((r182 instanceof TextView) == false) goto L47;
        TextView r186 = (TextView) r182;
        if (r185 == null) goto L53;
        r186.setTextSize(2, r185.g().b());
    L53:
        r181 = r181 + 1;
        r180 = r212;
        r177 = r177;
        goto L34
    L47:
        if ((r182 instanceof ECDraweeView) == false) goto L53;
        ECDraweeView r187 = (ECDraweeView) r182;
        if (r185 == null) goto L53;
        ECUrlModel r188 = r185.b();
        if (r188 == null) goto L53;
        r187.getLayoutParams().height = ExtensionsKt.a(Integer.valueOf(r188.getHeight()));
    L40:
        r185 = null;
        goto L42
    L30:
        r179 = Integer.MIN_VALUE;
    L54:
        r175 = r175 + 1;
        goto L21
    L55:
        int r189 = 6;
    L56:
        r189 = r189 - 1;
        int r190 = getChildCount();
        int r191 = 0;
        int r192 = 0;
        int r193 = 0;
        View r194 = null;
    L57:
        if (r191 >= r190) goto L77;
        View r195 = getChildAt(r191);
        int r213 = r190;
        if (Intrinsics.areEqual(r195.getTag(), "fillView") == false) goto L62;
        r194 = r195;
    L62:
        if ((r195 instanceof ECWindowTagView) == true) goto L64;
        r195 = null;
    L64:
        ECWindowTagView r196 = (ECWindowTagView) r195;
        if (r196 == null) goto L74;
        int r214 = r171;
        if (r196.getVisibility() == 8) goto L76;
        measureChild(r196, r210, r211);
        ViewGroup.LayoutParams r197 = r196.getLayoutParams();
        if (r197 == null) goto L73;
        ViewGroup.MarginLayoutParams r198 = (ViewGroup.MarginLayoutParams) r197;
        r192 = r192 + ((r196.getMeasuredWidth() + r198.leftMargin) + r198.rightMargin);
        r193 = RangesKt.coerceAtLeast(r193, (r196.getMeasuredHeight() + r198.topMargin) + r198.bottomMargin);
        goto L76
    L73:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L76:
        r191 = r191 + 1;
        r190 = r213;
        r171 = r214;
        r194 = r194;
        goto L57
    L74:
        r214 = r171;
        goto L76
    L77:
        int r215 = r171;
        if (r192 <= r169) goto L110;
        if (r189 <= 0) goto L110;
        int r199 = getLowestPriority();
        int r200 = getChildCount();
        int r201 = 0;
    L81:
        if (r201 >= r200) goto L109;
        View r202 = getChildAt(r201);
        if ((r202 instanceof ECWindowTagView) == true) goto L85;
        r202 = null;
    L85:
        ECWindowTagView r203 = (ECWindowTagView) r202;
        if (r203 == null) goto L108;
        ECWindowTagContainerDTO r1100 = r203.f49862n;
        if (r1100 == null) goto L90;
        int r1101 = r1100.getPriority();
    L91:
        if (r1101 < r199) goto L108;
        int r1102 = r203.getChildCount();
        int r1103 = 0;
    L94:
        if (r1103 >= r1102) goto L108;
        View r1104 = r203.getChildAt(r1103);
        int r216 = r189;
        if ((r1104 instanceof TextView) == false) goto L101;
        TextView r1105 = (TextView) r1104;
        int r217 = r199;
        int r218 = r200;
        if (r1105.getTextSize() > 0) goto L100;
        r1105.setVisibility(8);
        ECWindowTagView r219 = r203;
    L107:
        r1103 = r1103 + 1;
        r203 = r219;
        r189 = r216;
        r199 = r217;
        r200 = r218;
        goto L94
    L100:
        r219 = r203;
        r1105.setTextSize(0, r1105.getTextSize() - 2);
        goto L107
    L101:
        r217 = r199;
        r218 = r200;
        r219 = r203;
        if ((r1104 instanceof ECDraweeView) == false) goto L107;
        ECDraweeView r1106 = (ECDraweeView) r1104;
        if (r1106.getLayoutParams().height > 0) goto L106;
        r1106.setVisibility(8);
        goto L107
    L106:
        r1106.getLayoutParams().height = (int) (r1106.getLayoutParams().height * 0.8f);
        goto L107
    L90:
        r1101 = Integer.MIN_VALUE;
    L108:
        r201 = r201 + 1;
        r189 = r189;
        r199 = r199;
        r200 = r200;
        goto L81
    L109:
        r171 = r215;
    L110:
        if (r194 == null) goto L112;
        r194.getLayoutParams().width = r169 - r192;
        measureChild(r194, r210, r211);
    L112:
        g();
        if (r170 == 1073741824) goto L116;
        r169 = (r192 + getPaddingLeft()) + getPaddingRight();
    L116:
        if (r172 != 1073741824) goto L118;
        int r1107 = r215;
    L119:
        setMeasuredDimension(r169, r1107);
        int r204 = getChildCount();
        int r205 = 0;
    L120:
        if (r205 >= r204) goto L311;
        dm.a.a("zhaojian").i(r205 + "----->+" + getChildAt(r205).getMeasuredWidth());
        r205 = r205 + 1;
        goto L120
    L311:
        return;
    L118:
        r1107 = (r193 + getPaddingTop()) + getPaddingBottom();
        goto L119
    L10:
        if (r101.intValue() != r102) goto L15;
        if (h() == false) goto L14;
        f(r210, r211);
        return;
    L14:
        e(r210, r211);
        return;
    L5:
        r101 = null;
        goto L6
    }

    public ECWindowTagListView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f49847t = new WindowEventActionImplOpt();
        this.f49828a = true;
        this.f49829b = true;
        Paint r103 = new Paint(1);
        r103.setStyle(Paint.Style.STROKE);
        Unit r104 = Unit.INSTANCE;
        this.f49831d = r103;
        this.f49832e = new Path();
        this.f49834g = new LinkedHashSet();
        this.f49841n = new LinkedHashMap();
    }

    public /* synthetic */ ECWindowTagListView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    public static void b(ECWindowTagListView r100, ECWindowTagListDTO r101, Integer r102, int r103) {
        if ((r103 & 2) == 0) goto L5;
        r102 = null;
    L5:
        Intrinsics.checkNotNullParameter(r101, "tagListVO");
        ap.c r104 = r100.f49837j;
        if (r104 == null) goto L21;
        List<View> r105 = com.bytedance.commerce.base.view.b.a(r100);
        r100.removeAllViews();
        Iterator<T> r106 = r105.iterator();
    L9:
        if (r106.hasNext() == false) goto L22;
        View r107 = (View) r106.next();
        if ((r107 instanceof ViewGroup) == true) goto L13;
        View r108 = null;
    L14:
        ViewGroup r109 = (ViewGroup) r108;
        if (r109 == null) goto L20;
        List<View> r110 = com.bytedance.commerce.base.view.b.a(r109);
        r109.removeAllViews();
        Iterator<T> r111 = r110.iterator();
    L18:
        if (r111.hasNext() == false) goto L20;
        View r112 = (View) r111.next();
        r104.c(r112.getClass(), r112);
    L20:
        r104.c(r107.getClass(), r107);
        goto L9
    L13:
        r108 = r107;
    L22:
        ((LinkedHashMap) r100.f49841n).clear();
        r100.f49834g.clear();
        r100.f49833f = null;
        r100.setBaseEventParams(null);
        if (r100.f49842o != null) goto L25;
        r100.f49842o = Integer.valueOf(r100.getLayoutParams().width);
    L25:
        r100.f49837j = null;
        if (r102 != null) goto L28;
    L30:
        ViewGroup.LayoutParams r113 = r100.getLayoutParams();
        Integer r114 = r100.f49842o;
        if (r114 == null) goto L33;
        int r115 = r114.intValue();
    L34:
        r113.width = r115;
    L35:
        r100.f49838k = r101;
        r100.f49839l = null;
        r100.f49840m = null;
        if (r100.h() == true) goto L50;
        List<ECWindowTagContainerDTO> r116 = r101.getTagContainers();
        if (r116 != null) goto L40;
        r116 = CollectionsKt.emptyList();
    L40:
        Iterator<ECWindowTagContainerDTO> r117 = r116.iterator();
        boolean r118 = false;
    L42:
        if (r117.hasNext() == false) goto L50;
        ECWindowTagContainerDTO r119 = r117.next();
        TagContainerUI r120 = r119.getTagContainerUI();
        if (r120 == null) goto L49;
        if (r120.getRightAlignment() != true) goto L49;
        if (r118 == true) goto L49;
        FrameLayout r121 = new FrameLayout(r100.getContext());
        r121.setTag("fillView");
        Unit r122 = Unit.INSTANCE;
        r100.addView(r121, new LinearLayout.LayoutParams(-2, -2));
        r118 = true;
    L49:
        r100.addView(r100.c(r119, r101.getOverLengthStrategy()), d(r119));
    L50:
        r100.setTagListLayoutParams(r101.getTagListUI());
        String r123 = r101.getShowEventName();
        if (r123 != null) goto L53;
    L58:
        ClickAction r124 = r101.getClickAction();
        Integer r125 = r124.getActionType();
        int r126 = ActionType.OPEN_SCHEMA.getType();
        if (r125 != null) goto L62;
    L66:
        Integer r127 = r124.getActionType();
        int r128 = ActionType.TOAST.getType();
        if (r127 != null) goto L70;
    L74:
        r100.f49843p = true;
        return;
    L70:
        if (r127.intValue() != r128) goto L74;
        if (com.bytedance.android.shopping.extensions.k.c(r124.getToastText()) == false) goto L74;
        r100.setOnClickListener(new e(r124, r100, null, r101));
        goto L74
    L62:
        if (r125.intValue() != r126) goto L66;
        if (com.bytedance.android.shopping.extensions.k.c(r124.getJumpUrl()) == false) goto L66;
        r100.setOnClickListener(new d(r124, r100, null, r101));
        goto L74
    L53:
        if (r101.getHasReportShow() == true) goto L58;
        r101.setHasReportShow(true);
        String r129 = r100.f49840m;
        PageFinder r130 = PageFinder.via(r100);
        Map<String, String> r131 = r100.f49841n;
        Map<String, String> r132 = r101.getShowEventParams();
        if (r132 != null) goto L57;
        r132 = MapsKt.emptyMap();
    L57:
        r100.doEventAction(r123, r129, r130, MapsKt.plus(r131, r132));
        goto L58
    L33:
        r115 = -2;
        goto L34
    L28:
        if (r102.intValue() <= 0) goto L30;
        r100.getLayoutParams().width = r102.intValue();
        goto L35
    L21:
        r100.removeAllViews();
        goto L22
    }
}
