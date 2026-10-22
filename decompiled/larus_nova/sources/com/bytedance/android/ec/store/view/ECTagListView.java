package com.bytedance.android.ec.store.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.graphics.ColorUtils;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.store.common.uiext.ExtensionsKt;
import com.bytedance.android.ec.store.product.EventActionImplOpt;
import com.bytedance.android.ec.store.repository.vo.ActionType;
import com.bytedance.android.ec.store.repository.vo.ClickAction;
import com.bytedance.android.ec.store.repository.vo.ECTagContainerDTO;
import com.bytedance.android.ec.store.repository.vo.ECTagListDTO;
import com.bytedance.android.ec.store.repository.vo.OverLengthStrategy;
import com.bytedance.android.ec.store.repository.vo.TagContainerUI;
import com.bytedance.android.ec.store.repository.vo.TagListUI;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
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
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0018B'\b\u0007\u0012\u0006\u0010+\u001a\u00020*\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010,\u0012\b\b\u0002\u0010.\u001a\u00020\b¢\u0006\u0004\b/\u00100J\u001e\u0010\u0007\u001a\u00020\u00062\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\u0002J\b\u0010\t\u001a\u00020\bH\u0002J\b\u0010\n\u001a\u00020\u0004H\u0002J\u0012\u0010\r\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002J\u000e\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000eJ\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011J\u0017\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0014H\u0096\u0001J\t\u0010\u0016\u001a\u00020\u0004H\u0096\u0001R\"\u0010\u001e\u001a\u00020\u00178\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR$\u0010%\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R$\u0010)\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b&\u0010 \u001a\u0004\b'\u0010\"\"\u0004\b(\u0010$¨\u00061"}, d2 = {"Lcom/bytedance/android/ec/store/view/ECTagListView;", "Landroid/widget/LinearLayout;", "Lcom/bytedance/android/ec/core/event/c;", "", "", "params", "", "setBaseEventParams", "", "getLowestPriority", "getTags", "Lcom/bytedance/android/ec/store/repository/vo/TagListUI;", "tagListUI", "setTagListLayoutParams", "Lcom/bytedance/android/ec/store/view/s;", "processor", "setSchemaProcessor", "", "Lcom/bytedance/android/ec/store/repository/vo/ECTagContainerDTO;", "getVisibleTagList", "", "getBaseParams", "getBaseParamsJson", "", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Z", "getSubTagNeedClip", "()Z", "setSubTagNeedClip", "(Z)V", "subTagNeedClip", "c", "Ljava/lang/String;", "getTagShowEventName", "()Ljava/lang/String;", "setTagShowEventName", "(Ljava/lang/String;)V", "tagShowEventName", "d", "getTagClickEventName", "setTagClickEventName", "tagClickEventName", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECTagListView extends LinearLayout implements com.bytedance.android.ec.core.event.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f48868a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinkedHashSet<com.bytedance.android.ec.store.view.a> f48869b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f48870c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f48871d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public xm.c f48872e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ECTagListDTO f48873f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Function0<String> f48874g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f48875h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Map<String, String> f48876i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Integer f48877j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f48878k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final /* synthetic */ EventActionImplOpt f48879l;

    public static final class a {
    }

    static {
    }

    public ECTagListView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ECTagListView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // com.bytedance.android.ec.core.event.c
    public final void appendEventParams(Map<String, String> r100) {
        Intrinsics.checkNotNullParameter(r100, "paramsMap");
        this.f48879l.appendEventParams(r100);
    }

    @Override // com.bytedance.android.ec.core.event.c
    public final void appendEventParams(Pair<String, String>... r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        this.f48879l.appendEventParams(r100);
    }

    @Override // com.bytedance.android.ec.core.event.c
    public final void bindMonitorId(Long r100) {
        this.f48879l.getClass();
    }

    @Override // com.bytedance.android.ec.core.event.c
    public final void clearEventParams() {
        this.f48879l.clearEventParams();
    }

    @Override // com.bytedance.android.ec.core.event.c
    public final void doAnyEventAction(String r100, Map<String, ? extends Object> r101, Pair<String, ? extends Object>... r102) {
        Intrinsics.checkNotNullParameter(r100, "actionName");
        Intrinsics.checkNotNullParameter(r102, "params");
        this.f48879l.doAnyEventAction(r100, r101, r102);
    }

    @Override // com.bytedance.android.ec.core.event.c
    public final void doAnyEventActionWithBtm(String r100, PageFinder r101, String r110, Map<String, ? extends Object> r111, Pair<String, ? extends Object>... r112) {
        Intrinsics.checkNotNullParameter(r100, "btm");
        Intrinsics.checkNotNullParameter(r101, "pageFinder");
        Intrinsics.checkNotNullParameter(r110, "actionName");
        Intrinsics.checkNotNullParameter(r112, "params");
        this.f48879l.doAnyEventActionWithBtm(r100, r101, r110, r111, r112);
    }

    @Override // com.bytedance.android.ec.core.event.c
    public final void doEventAction(String r100, String r101, PageFinder r102, Map<String, String> r103) {
        Intrinsics.checkNotNullParameter(r100, "actionName");
        Intrinsics.checkNotNullParameter(r103, "paramMap");
        this.f48879l.doEventAction(r100, r101, r102, r103);
    }

    @Override // com.bytedance.android.ec.core.event.c
    public final void doEventAction(String r100, String r101, PageFinder r102, Pair<String, String>... r103) {
        Intrinsics.checkNotNullParameter(r100, "actionName");
        Intrinsics.checkNotNullParameter(r103, "params");
        this.f48879l.doEventAction(r100, r101, r102, r103);
    }

    @Override // com.bytedance.android.ec.core.event.c
    public final void doEventAction(String r100, Map<String, String> r101, Pair<String, String>... r102) {
        Intrinsics.checkNotNullParameter(r100, "actionName");
        Intrinsics.checkNotNullParameter(r102, "params");
        this.f48879l.doEventAction(r100, r101, r102);
    }

    @Override // com.bytedance.android.ec.core.event.c
    public final void doEventAction(String r100, Pair<String, String>... r101) {
        Intrinsics.checkNotNullParameter(r100, "actionName");
        Intrinsics.checkNotNullParameter(r101, "params");
        this.f48879l.doEventAction(r100, r101);
    }

    @Override // com.bytedance.android.ec.core.event.c
    public String getBaseParamsJson() {
        return this.f48879l.getBaseParamsJson();
    }

    @Override // com.bytedance.android.ec.core.event.c
    public final void initEventContext(Map<String, String> r100) {
        Intrinsics.checkNotNullParameter(r100, "paramsMap");
        this.f48879l.initEventContext(r100);
    }

    @Override // com.bytedance.android.ec.core.event.c
    public final void initEventContext(Pair<String, String>... r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        this.f48879l.initEventContext(r100);
    }

    public final void setSchemaProcessor(s r100) {
        Intrinsics.checkNotNullParameter(r100, "processor");
    }

    private final int getLowestPriority() {
        ECTagListDTO r100 = this.f48873f;
        int r101 = Integer.MIN_VALUE;
        if (r100 == null) goto L12;
        List<ECTagContainerDTO> r102 = r100.getTagContainers();
        if (r102 == null) goto L12;
        Iterator<T> r103 = r102.iterator();
    L8:
        if (r103.hasNext() == false) goto L12;
        ECTagContainerDTO r104 = (ECTagContainerDTO) r103.next();
        if (r104.getPriority() <= r101) goto L8;
        r101 = r104.getPriority();
    L12:
        return r101;
    }

    private final String getTags() {
        ECTagListDTO r100 = this.f48873f;
        if (r100 == null) goto L19;
        List<ECTagContainerDTO> r101 = r100.getTagContainers();
        if (r101 == null) goto L19;
        List<ECTagContainerDTO> r102 = r101;
        ArrayList r103 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r102, 10));
        Iterator<T> r104 = r102.iterator();
    L8:
        if (r104.hasNext() == false) goto L17;
        List<com.bytedance.android.ec.store.repository.vo.s> r105 = ((ECTagContainerDTO) r104.next()).getSubTagList();
        if (r105 == null) goto L15;
        List<com.bytedance.android.ec.store.repository.vo.s> r106 = r105;
        ArrayList r107 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r106, 10));
        Iterator<T> r108 = r106.iterator();
    L13:
        if (r108.hasNext() == false) goto L16;
        r107.add(((com.bytedance.android.ec.store.repository.vo.s) r108.next()).n().g());
    L16:
        r103.add(r107);
        goto L8
    L15:
        r107 = null;
        goto L16
    L17:
        String r109 = CollectionsKt.joinToString$default(r103, ",", null, null, 0, null, null, 62, null);
        if (r109 == null) goto L19;
        return r109;
    L19:
        return "";
    }

    @Override // com.bytedance.android.ec.core.event.c
    public Map<String, String> getBaseParams() {
        return this.f48879l.b();
    }

    public final List<ECTagContainerDTO> getVisibleTagList() {
        List<View> r100 = com.bytedance.commerce.base.view.b.a(this);
        ArrayList r101 = new ArrayList();
        Iterator<T> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L15;
        View r103 = (View) r102.next();
        ECTagContainerDTO r104 = null;
        if (r103.getVisibility() == 0) goto L8;
    L13:
        if (r104 == null) goto L4;
        r101.add(r104);
        goto L4
    L8:
        if ((r103 instanceof ECTagView) == true) goto L10;
        r103 = null;
    L10:
        ECTagView r105 = (ECTagView) r103;
        if (r105 == null) goto L13;
        r104 = r105.getTagData();
        goto L13
    L15:
        return r101;
    }

    public final void h() {
        int r100 = getChildCount();
        int r101 = 0;
    L3:
        if (r101 >= r100) goto L13;
        View r102 = getChildAt(r101);
        if ((r102 instanceof ECTagView) == true) goto L7;
        r102 = null;
    L7:
        ECTagView r103 = (ECTagView) r102;
        if (r103 == null) goto L12;
        if (r103.getVisibility() != 0) goto L12;
        r103.f();
    L12:
        r101 = r101 + 1;
        goto L3
    }

    public final boolean getSubTagNeedClip() {
        return this.f48868a;
    }

    public final String getTagClickEventName() {
        return this.f48871d;
    }

    public final String getTagShowEventName() {
        return this.f48870c;
    }

    public static LinearLayout.LayoutParams e(ECTagContainerDTO r100) {
        TagContainerUI r101 = r100.getTagContainerUI();
        if (r101 != null) goto L5;
    L7:
        TagContainerUI r102 = r100.getTagContainerUI();
        if (r102 == null) goto L10;
        int r103 = com.bytedance.android.shopping.store.utils.o.a(Integer.valueOf(r102.getHeight()));
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
        this.f48876i.putAll(r100);
        return;
    }

    private final void setTagListLayoutParams(TagListUI r110) {
        if (r110 != null) goto L4;
        return;
    L4:
        int r100 = com.bytedance.android.ec.core.utils.s.f45717a;
        Integer r101 = com.bytedance.android.ec.core.utils.s.b(r110.getBgColor());
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
        if (r104.size() < 4) goto L15;
        float[] r107 = {((Number) ListProtector.get(r104, 0)).floatValue(), ((Number) ListProtector.get(r104, 0)).floatValue(), ((Number) ListProtector.get(r104, 1)).floatValue(), ((Number) ListProtector.get(r104, 1)).floatValue(), ((Number) ListProtector.get(r104, 2)).floatValue(), ((Number) ListProtector.get(r104, 2)).floatValue(), ((Number) ListProtector.get(r104, 3)).floatValue(), ((Number) ListProtector.get(r104, 3)).floatValue()};
    L16:
        r106.setCornerRadii(r107);
        int r108 = com.bytedance.android.ec.core.utils.s.f45717a;
        Integer r109 = com.bytedance.android.ec.core.utils.s.b(r110.getBorderColor());
        if (r109 == null) goto L19;
        r106.setStroke(ExtensionsKt.a(Double.valueOf(r110.getBorderWidth())), r109.intValue());
    L19:
        r106.setColor(r102);
        int r111 = qc3.a.f532459a;
        Intrinsics.checkNotNullParameter(this, "$this$setBackgroundCompat");
        setBackground(r106);
        if (r110.getHeight() <= 0) goto L24;
        getLayoutParams().height = com.bytedance.android.shopping.store.utils.o.a(Double.valueOf(r110.getHeight()));
        return;
    L24:
        return;
    L15:
        r107 = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
        goto L16
    L7:
        r102 = 16777215;
        goto L8
    }

    public final void i(ECTagView r100) {
        xm.c r101 = this.f48872e;
        if (r101 == null) goto L5;
        r101.b(ECTagView.class, r100);
    L5:
        List<View> r102 = com.bytedance.commerce.base.view.b.a(r100);
        r100.removeAllViews();
        Iterator<T> r103 = r102.iterator();
    L7:
        if (r103.hasNext() == false) goto L16;
        View r104 = (View) r103.next();
        if ((r104 instanceof TextView) == true) goto L10;
        xm.c r105 = this.f48872e;
        if (r105 == null) goto L7;
        r105.b(r104.getClass(), r104);
        goto L7
    L10:
        xm.c r106 = this.f48872e;
        if (r106 == null) goto L7;
        r106.c((TextView) r104);
        goto L7
    }

    public final void k(float r110) {
        ECTagListDTO r100 = this.f48873f;
        if (r100 != null) goto L5;
        return;
    L5:
        int r101 = com.bytedance.android.ec.core.utils.s.f45717a;
        TagListUI r102 = r100.getTagListUI();
        if (r102 == null) goto L8;
        String r103 = r102.getBgColor();
    L9:
        Integer r104 = com.bytedance.android.ec.core.utils.s.b(r103);
        if (r104 == null) goto L12;
        int r105 = r104.intValue();
    L13:
        TagListUI r106 = r100.getTagListUI();
        if (r106 == null) goto L16;
        String r107 = r106.getSpecialBgColor();
    L17:
        Integer r108 = com.bytedance.android.ec.core.utils.s.b(r107);
        if (r108 == null) goto L20;
        int r109 = r108.intValue();
    L21:
        int r111 = ColorUtils.blendARGB(r105, r109, r110);
        TagListUI r112 = r100.getTagListUI();
        if (r112 == null) goto L24;
        String r113 = r112.getBorderColor();
    L25:
        Integer r114 = com.bytedance.android.ec.core.utils.s.b(r113);
        if (r114 == null) goto L28;
        int r115 = r114.intValue();
    L29:
        TagListUI r116 = r100.getTagListUI();
        if (r116 == null) goto L32;
        String r117 = r116.getSpecialBorderColor();
    L33:
        Integer r118 = com.bytedance.android.ec.core.utils.s.b(r117);
        if (r118 == null) goto L36;
        int r119 = r118.intValue();
    L37:
        int r120 = ColorUtils.blendARGB(r115, r119, r110);
        Drawable r121 = getBackground();
        if ((r121 instanceof GradientDrawable) == true) goto L40;
        r121 = null;
    L40:
        GradientDrawable r122 = (GradientDrawable) r121;
        if (r122 == null) goto L47;
        r122.setColor(r111);
        TagListUI r123 = r100.getTagListUI();
        if (r123 == null) goto L45;
        int r124 = ExtensionsKt.a(Double.valueOf(r123.getBorderWidth()));
    L46:
        r122.setStroke(r124, r120);
        int r125 = qc3.a.f532459a;
        Intrinsics.checkNotNullParameter(this, "$this$setBackgroundCompat");
        setBackground(r122);
        goto L47
    L45:
        r124 = 0;
    L47:
        Iterator<View> r126 = com.bytedance.commerce.base.view.b.a(this).iterator();
        int r127 = 0;
    L49:
        if (r126.hasNext() == false) goto L137;
        View r128 = r126.next();
        if ((r128 instanceof ECTagView) == false) goto L49;
        List<ECTagContainerDTO> r129 = r100.getTagContainers();
        if (r129 == null) goto L55;
        int r130 = r129.size();
    L56:
        if (r127 >= r130) goto L151;
        ECTagView r131 = (ECTagView) r128;
        List<ECTagContainerDTO> r132 = r100.getTagContainers();
        if (r132 == null) goto L60;
        ECTagContainerDTO r133 = (ECTagContainerDTO) CollectionsKt.getOrNull(r132, r127);
    L61:
        r131.getClass();
        if (r133 == null) goto L136;
        TagContainerUI r134 = r133.getTagContainerUI();
        if (r134 == null) goto L89;
        int r135 = com.bytedance.android.ec.core.utils.s.f45717a;
        Integer r136 = com.bytedance.android.ec.core.utils.s.b(r134.getBgColor());
        if (r136 == null) goto L70;
        int r137 = r136.intValue();
    L71:
        Integer r138 = com.bytedance.android.ec.core.utils.s.b(r134.getSpecialBgColor());
        if (r138 == null) goto L74;
        int r139 = r138.intValue();
    L75:
        int r140 = ColorUtils.blendARGB(r137, r139, r110);
        Integer r141 = com.bytedance.android.ec.core.utils.s.b(r134.getBorderColor());
        if (r141 == null) goto L78;
        int r142 = r141.intValue();
    L79:
        Integer r143 = com.bytedance.android.ec.core.utils.s.b(r134.getSpecialBorderColor());
        if (r143 == null) goto L82;
        int r144 = r143.intValue();
    L83:
        int r145 = ColorUtils.blendARGB(r142, r144, r110);
        r131.f48882b = r145;
        Drawable r146 = r131.getBackground();
        if ((r146 instanceof GradientDrawable) == true) goto L86;
        r146 = null;
    L86:
        GradientDrawable r147 = (GradientDrawable) r146;
        if (r147 == null) goto L89;
        r147.setColor(r140);
        r147.setStroke(ExtensionsKt.a(Double.valueOf(r134.getBorderWidth())), r145);
        int r148 = qc3.a.f532459a;
        Intrinsics.checkNotNullParameter(r131, "$this$setBackgroundCompat");
        r131.setBackground(r147);
        goto L89
    L82:
        r144 = r142;
        goto L83
    L78:
        r142 = 16777215;
        goto L79
    L74:
        r139 = r137;
        goto L75
    L70:
        r137 = 16777215;
    L89:
        int r149 = r131.getChildCount();
        int r150 = 0;
    L90:
        if (r150 >= r149) goto L136;
        View r151 = (View) ListProtector.get(com.bytedance.commerce.base.view.b.a(r131), r150);
        List<com.bytedance.android.ec.store.repository.vo.s> r152 = r133.getSubTagList();
        if (r152 == null) goto L94;
        int r153 = r152.size();
    L95:
        if (r150 >= r153) goto L136;
        if ((r151 instanceof TextView) == false) goto L122;
        TextView r154 = (TextView) r151;
        List<com.bytedance.android.ec.store.repository.vo.s> r155 = r133.getSubTagList();
        if (r155 == null) goto L101;
        com.bytedance.android.ec.store.repository.vo.s r156 = (com.bytedance.android.ec.store.repository.vo.s) CollectionsKt.getOrNull(r155, r150);
    L102:
        if (r156 == null) goto L135;
        int r157 = com.bytedance.android.ec.core.utils.s.f45717a;
        Integer r158 = com.bytedance.android.ec.core.utils.s.b(r156.n().h());
        if (r158 == null) goto L107;
        int r159 = r158.intValue();
    L108:
        Integer r160 = com.bytedance.android.ec.core.utils.s.b(r156.n().f());
        if (r160 == null) goto L111;
        int r161 = r160.intValue();
    L112:
        int r162 = ColorUtils.blendARGB(r159, r161, r110);
        Integer r163 = com.bytedance.android.ec.core.utils.s.b(r156.n().a());
        if (r163 == null) goto L115;
        int r164 = r163.intValue();
    L116:
        Integer r165 = com.bytedance.android.ec.core.utils.s.b(r156.n().e());
        if (r165 == null) goto L119;
        int r166 = r165.intValue();
    L120:
        int r167 = ColorUtils.blendARGB(r164, r166, r110);
        r154.setTextColor(r162);
        r154.setBackgroundColor(r167);
        goto L135
    L119:
        r166 = r164;
        goto L120
    L115:
        r164 = 16777215;
        goto L116
    L111:
        r161 = r159;
        goto L112
    L107:
        r159 = 16777215;
    L135:
        r150 = r150 + 1;
        goto L90
    L101:
        r156 = null;
        goto L102
    L122:
        if ((r151 instanceof ECTagDoubleIconView) == false) goto L125;
        ECTagDoubleIconView r168 = (ECTagDoubleIconView) r151;
        r168.f48867b.setAlpha(r110);
        r168.f48866a.setAlpha(1 - r110);
        goto L135
    L125:
        if ((r151 instanceof ECStoreVerticalDashLine) == false) goto L135;
        ECStoreVerticalDashLine r169 = (ECStoreVerticalDashLine) r151;
        r169.getClass();
        int r170 = com.bytedance.android.ec.core.utils.s.f45717a;
        Integer r171 = com.bytedance.android.ec.core.utils.s.b(r169.f48840c.a());
        if (r171 == null) goto L129;
        int r172 = r171.intValue();
    L130:
        Integer r173 = com.bytedance.android.ec.core.utils.s.b(r169.f48840c.e());
        if (r173 == null) goto L133;
        int r174 = r173.intValue();
    L134:
        r169.f48841d = ColorUtils.blendARGB(r172, r174, r110);
        r169.invalidate();
        goto L135
    L133:
        r174 = r172;
        goto L134
    L129:
        r172 = 16777215;
        goto L130
    L94:
        r153 = 0;
    L136:
        r127 = r127 + 1;
        goto L49
    L60:
        r133 = null;
        goto L61
    L151:
        return;
    L55:
        r130 = 0;
        goto L56
    L137:
        return;
    L36:
        r119 = r115;
        goto L37
    L32:
        r117 = null;
        goto L33
    L28:
        r115 = 16777215;
        goto L29
    L24:
        r113 = null;
        goto L25
    L20:
        r109 = r105;
        goto L21
    L16:
        r107 = null;
        goto L17
    L12:
        r105 = 16777215;
        goto L13
    L8:
        r103 = null;
        goto L9
    }

    public final void l(ECTagListDTO r100) {
        Intrinsics.checkNotNullParameter(r100, "tagListVO");
        List<ECTagContainerDTO> r101 = r100.getTagContainers();
        if (r101 == null) goto L17;
        Iterator<T> r102 = r101.iterator();
        int r103 = 0;
    L6:
        if (r102.hasNext() == false) goto L17;
        Object r104 = r102.next();
        int r105 = r103 + 1;
        if (r103 >= 0) goto L10;
        CollectionsKt.throwIndexOverflow();
    L10:
        ECTagContainerDTO r106 = (ECTagContainerDTO) r104;
        Object r107 = CollectionsKt.getOrNull(com.bytedance.commerce.base.view.b.a(this), r103);
        if ((r107 instanceof ECTagView) == true) goto L13;
        r107 = null;
    L13:
        ECTagView r108 = (ECTagView) r107;
        if (r108 == null) goto L16;
        r108.update(r106, r100.getOverLengthStrategy());
        r108.setLayoutParams(e(r106));
    L16:
        r103 = r105;
    L17:
        setTagListLayoutParams(r100.getTagListUI());
    }

    public final void setSubTagNeedClip(boolean r100) {
        this.f48868a = r100;
    }

    public final void setTagClickEventName(String r100) {
        this.f48871d = r100;
    }

    public final void setTagShowEventName(String r100) {
        this.f48870c = r100;
    }

    public static final void a(ECTagListView r100, ECTagListDTO r101) {
        r100.getClass();
        String r102 = r101.getClickEventName();
        if (r102 == null) goto L9;
        String r103 = r100.f48875h;
        PageFinder r104 = PageFinder.via(r100);
        Map<String, String> r105 = r100.f48876i;
        Map<String, String> r106 = r101.getShowEventParams();
        if (r106 != null) goto L7;
        r106 = MapsKt.emptyMap();
    L7:
        r100.doEventAction(r102, r103, r104, MapsKt.plus(r105, r106));
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final ECTagView d(ECTagContainerDTO r110, int r111) {
        xm.c r100 = this.f48872e;
        String r101 = null;
        Object[] r102 = 0;
        if (r100 == null) goto L6;
        ECTagView r103 = (ECTagView) r100.a(ECTagView.class, new ECTagListView$createTagView$tagView$1(this));
        if (r103 == null) goto L6;
    L7:
        r103.setBaseEventParams(this.f48876i);
        r103.setNeedClip(this.f48868a);
        r103.setShowEventName(this.f48870c);
        r103.setClickEventName(this.f48871d);
        ECTagListDTO r104 = this.f48873f;
        if (r104 == null) goto L10;
        r101 = r104.getScene();
    L10:
        ECTagView r105 = r103;
        r105.a(r110, r101, this.f48872e, r111, this.f48874g, this.f48875h);
        return r103;
    L6:
        Object[] r106 = r102 == true ? 1 : 0;
        r103 = new ECTagView(getContext(), r106, 6, 0);
        goto L7
    }

    public final ECTagView f(ECTagContainerDTO r100, int r101) {
        ECTagView r102 = d(r100, r101);
        if (r102.getLayoutParams() != null) goto L5;
        r102.setLayoutParams(e(r100));
    L29:
        return r102;
    L5:
        ViewGroup.LayoutParams r103 = r102.getLayoutParams();
        if ((r103 instanceof ViewGroup.MarginLayoutParams) == true) goto L8;
        r103 = null;
    L8:
        ViewGroup.MarginLayoutParams r104 = (ViewGroup.MarginLayoutParams) r103;
        if (r104 == null) goto L19;
        TagContainerUI r105 = r100.getTagContainerUI();
        if (r105 == null) goto L13;
        int r106 = ExtensionsKt.a(Integer.valueOf(r105.getMarginLeft()));
    L14:
        TagContainerUI r107 = r100.getTagContainerUI();
        if (r107 == null) goto L17;
        int r108 = ExtensionsKt.a(Integer.valueOf(r107.getMarginRight()));
    L18:
        r104.setMargins(r106, 0, r108, 0);
        goto L19
    L17:
        r108 = 0;
        goto L18
    L13:
        r106 = 0;
    L19:
        TagContainerUI r109 = r100.getTagContainerUI();
        if (r109 != null) goto L22;
    L24:
        ViewGroup.LayoutParams r110 = r102.getLayoutParams();
        TagContainerUI r111 = r100.getTagContainerUI();
        if (r111 == null) goto L27;
        int r112 = com.bytedance.android.shopping.store.utils.o.a(Integer.valueOf(r111.getHeight()));
    L28:
        r110.height = r112;
        r102.getLayoutParams().width = -2;
        goto L29
    L27:
        r112 = -2;
        goto L28
    L22:
        if (r109.getFillContainer() != true) goto L24;
        r102.getLayoutParams().height = -1;
        r102.getLayoutParams().width = -1;
        goto L29
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11, types: [android.view.View, com.bytedance.android.ec.store.view.ECTagView] */
    /* JADX WARN: Type inference failed for: r11v0 */
    /* JADX WARN: Type inference failed for: r11v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r11v6 */
    /* JADX WARN: Type inference failed for: r1v25, types: [com.bytedance.android.ec.store.repository.vo.ECTagContainerDTO] */
    /* JADX WARN: Type inference failed for: r21v0, types: [android.widget.LinearLayout, com.bytedance.android.ec.store.view.ECTagListView] */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1, types: [android.view.View, android.widget.LinearLayout] */
    /* JADX WARN: Type inference failed for: r4v4 */
    public final void g(int r210, int r211) {
        int r100 = View.MeasureSpec.getSize(r210);
        int r101 = View.MeasureSpec.getMode(r210);
        int r102 = View.MeasureSpec.getSize(r211);
        int r110 = View.MeasureSpec.getMode(r211);
        ECTagListDTO r103 = this.f48873f;
        ?? r111 = 0;
        if (r103 == null) goto L7;
        List<ECTagContainerDTO> r104 = r103.getTagContainers();
        if (r104 == null) goto L7;
        int r112 = r104.size();
    L8:
        int r105 = Integer.MAX_VALUE;
        int r106 = 0;
        int r113 = 0;
        int r114 = 0;
        int r115 = 0;
    L9:
        if (r113 >= r112) goto L66;
        ECTagListDTO r107 = this.f48873f;
        if (r107 == null) goto L13;
        int r108 = r107.getContainerShowMax();
    L14:
        if (r114 >= r108) goto L66;
        if (this.f48878k == false) goto L35;
        int r109 = r100 - r115;
        if (r109 < r105) goto L21;
    L23:
        ECTagListDTO r116 = this.f48873f;
        if (r116 == null) goto L66;
        List<ECTagContainerDTO> r117 = r116.getTagContainers();
        if (r117 == null) goto L66;
        ?? r118 = (ECTagContainerDTO) CollectionsKt.getOrNull(r117, r113);
        if (r118 == 0) goto L66;
        r118.setShouldDropOverflowSubTags(r111);
        ECTagListDTO r119 = this.f48873f;
        if (r119 == null) goto L33;
        int r120 = r119.getOverLengthStrategy();
    L34:
        ?? r121 = f(r118, r120);
        boolean r122 = true;
    L42:
        r121.setVisibility(r111);
        measureChild(r121, r210, r211);
        ViewGroup.LayoutParams r123 = r121.getLayoutParams();
        if (r123 == null) goto L65;
        ViewGroup.MarginLayoutParams r124 = (ViewGroup.MarginLayoutParams) r123;
        int r125 = (r121.getMeasuredWidth() + r124.leftMargin) + r124.rightMargin;
        int r126 = (r121.getMeasuredHeight() + r124.topMargin) + r124.bottomMargin;
        int r127 = Math.min(r105, r125);
        int r128 = r115 + r125;
        if (r128 <= ((r100 - getPaddingLeft()) - getPaddingRight())) goto L59;
        if (r122 == false) goto L54;
        int r212 = r100;
        int r129 = r106;
        ECTagView r130 = j(r113, r100, r115, r210, r211);
        if (r130 == null) goto L55;
        addView(r130);
        ViewGroup.LayoutParams r131 = r130.getLayoutParams();
        if (r131 == null) goto L53;
        ViewGroup.MarginLayoutParams r132 = (ViewGroup.MarginLayoutParams) r131;
        r115 = r115 + ((r130.getMeasuredWidth() + r132.leftMargin) + r132.rightMargin);
        r106 = RangesKt.coerceAtLeast(r129, (r130.getMeasuredHeight() + r132.topMargin) + r132.bottomMargin);
        r114 = r114 + 1;
        r130.f();
    L63:
        r113 = r113 + 1;
        r105 = r127;
        r100 = r212;
        r111 = 0;
        goto L9
    L53:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L55:
        if (r122 == false) goto L57;
        i(r121);
    L58:
        r106 = r129;
        goto L63
    L57:
        r121.setVisibility(8);
        goto L58
    L54:
        r212 = r100;
        r129 = r106;
        goto L55
    L59:
        ?? r133 = r121;
        r212 = r100;
        int r134 = r106;
        if (r122 == false) goto L62;
        addView(r133);
    L62:
        r106 = RangesKt.coerceAtLeast(r134, r126);
        r114 = r114 + 1;
        r133.f();
        r115 = r128;
        goto L63
    L65:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L33:
        r120 = OverLengthStrategy.DEFAULT.getStrategy();
        goto L34
    L21:
        if (r109 >= (((double) r100) * 0.2d)) goto L23;
    L35:
        View r135 = getChildAt(r113);
        if ((r135 instanceof ECTagView) == true) goto L38;
        r135 = null;
    L38:
        ECTagView r136 = (ECTagView) r135;
        if (r136 == null) goto L66;
        r121 = r136;
        r122 = false;
        goto L42
    L13:
        r108 = Integer.MAX_VALUE;
    L66:
        int r213 = r100;
        int r137 = r106;
        if (r101 != 1073741824) goto L69;
        int r138 = r213;
    L70:
        if (r110 == 1073741824) goto L73;
        r102 = (r137 + getPaddingTop()) + getPaddingBottom();
    L73:
        setMeasuredDimension(r138, r102);
        this.f48878k = false;
        return;
    L69:
        r138 = (r115 + getPaddingLeft()) + getPaddingRight();
    L7:
        r112 = 0;
        goto L8
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int r210, int r211) {
        ECTagListDTO r100 = this.f48873f;
        if (r100 == null) goto L5;
        Integer r101 = Integer.valueOf(r100.getOverLengthStrategy());
    L6:
        int r102 = OverLengthStrategy.HIDE.getStrategy();
        if (r101 != null) goto L10;
    L12:
        int r103 = OverLengthStrategy.HIDE_SORT_BY_PRIORITY.getStrategy();
        if (r101 != null) goto L16;
    L114:
        int r104 = OverLengthStrategy.SCALE_LOWEST_PRIORITY.getStrategy();
        String r105 = "fillView";
        if (r101 != null) goto L118;
    L220:
        int r106 = OverLengthStrategy.TRUNCATE.getStrategy();
        if (r101 != null) goto L224;
    L226:
        int r107 = OverLengthStrategy.ALLHIDE.getStrategy();
        if (r101 != null) goto L230;
    L257:
        int r108 = OverLengthStrategy.ALL_SHOW.getStrategy();
        if (r101 != null) goto L261;
    L271:
        int r109 = OverLengthStrategy.FIXED_WIDTH_ALL_SHOW.getStrategy();
        if (r101 != null) goto L275;
    L342:
        g(r210, r211);
        return;
    L275:
        if (r101.intValue() != r109) goto L342;
        int r110 = View.MeasureSpec.getSize(r210);
        View.MeasureSpec.getMode(r210);
        int r111 = View.MeasureSpec.getSize(r211);
        View.MeasureSpec.getMode(r211);
        int r112 = getLowestPriority();
        int r113 = getChildCount();
        int r114 = 0;
    L277:
        if (r114 >= r113) goto L296;
        View r115 = getChildAt(r114);
        if ((r115 instanceof ECTagView) == true) goto L281;
        r115 = null;
    L281:
        ECTagView r116 = (ECTagView) r115;
        if (r116 == null) goto L295;
        ECTagContainerDTO r117 = r116.f48893m;
        if (r117 == null) goto L286;
        int r118 = r117.getPriority();
    L287:
        if (r118 < r112) goto L295;
        int r119 = r116.getChildCount();
        int r120 = 0;
    L290:
        if (r120 >= r119) goto L295;
        View r121 = r116.getChildAt(r120);
        if ((r121 instanceof TextView) == false) goto L294;
        TextView r122 = (TextView) r121;
        ViewGroup.LayoutParams r123 = r122.getLayoutParams();
        r123.width = -2;
        Unit r124 = Unit.INSTANCE;
        r122.setLayoutParams(r123);
    L294:
        r120 = r120 + 1;
        goto L290
    L286:
        r118 = Integer.MIN_VALUE;
    L295:
        r114 = r114 + 1;
        goto L277
    L296:
        int r125 = getChildCount();
        int r126 = 0;
        int r127 = 0;
        int r128 = 0;
        int r129 = 0;
        ECTagView r130 = null;
        View r131 = null;
    L297:
        if (r126 >= r125) goto L323;
        View r132 = getChildAt(r126);
        int r133 = r125;
        if (Intrinsics.areEqual(r132.getTag(), r105) == false) goto L302;
        r131 = r132;
    L302:
        if ((r132 instanceof ECTagView) == true) goto L304;
        r132 = null;
    L304:
        ECTagView r134 = (ECTagView) r132;
        if (r134 == null) goto L320;
        String r135 = r105;
        if (r134.getVisibility() == 8) goto L322;
        measureChild(r134, r210, r211);
        ViewGroup.LayoutParams r136 = r134.getLayoutParams();
        if (r136 == null) goto L319;
        ViewGroup.MarginLayoutParams r137 = (ViewGroup.MarginLayoutParams) r136;
        int r138 = (r134.getMeasuredWidth() + r137.leftMargin) + r137.rightMargin;
        int r139 = (r134.getMeasuredHeight() + r137.topMargin) + r137.bottomMargin;
        r127 = r127 + r138;
        ECTagContainerDTO r140 = r134.getTagData();
        if (r140 != null) goto L314;
    L316:
        r128 = r128 + r138;
    L317:
        r129 = RangesKt.coerceAtLeast(r129, r139);
        goto L322
    L314:
        if (r140.getPriority() != r112) goto L316;
        r130 = r134;
        goto L317
    L319:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L322:
        r126 = r126 + 1;
        r125 = r133;
        r105 = r135;
        r131 = r131;
        goto L297
    L320:
        r135 = r105;
        goto L322
    L323:
        if (r130 == null) goto L325;
        ViewGroup.LayoutParams r141 = r130.getLayoutParams();
    L327:
        if ((r141 instanceof ViewGroup.MarginLayoutParams) == true) goto L329;
        r141 = null;
    L329:
        ViewGroup.MarginLayoutParams r142 = (ViewGroup.MarginLayoutParams) r141;
        if (r142 == null) goto L332;
        int r143 = r142.leftMargin;
    L333:
        if (r142 == null) goto L335;
        int r144 = r142.rightMargin;
    L336:
        int r145 = RangesKt.coerceAtLeast((r110 - r128) - (r143 + r144), 0);
        if (r130 == null) goto L339;
        r130.g(r145);
        measureChild(r130, r210, r211);
    L339:
        if (r131 == null) goto L341;
        r131.getLayoutParams().width = RangesKt.coerceAtLeast(r110 - r127, 0);
        measureChild(r131, r210, r211);
    L341:
        h();
        setMeasuredDimension(r110, r111);
        return;
    L335:
        r144 = 0;
        goto L336
    L332:
        r143 = 0;
        goto L333
    L325:
        r141 = null;
        goto L327
    L261:
        if (r101.intValue() != r108) goto L271;
        super.onMeasure(r210, r211);
        int r146 = getChildCount();
        int r147 = 0;
    L263:
        if (r147 >= r146) goto L408;
        View r148 = getChildAt(r147);
        if ((r148 instanceof ECTagView) == true) goto L267;
        r148 = null;
    L267:
        ECTagView r149 = (ECTagView) r148;
        if (r149 == null) goto L270;
        r149.f();
    L270:
        r147 = r147 + 1;
        goto L263
    L408:
        return;
    L230:
        if (r101.intValue() != r107) goto L257;
        int r150 = View.MeasureSpec.getSize(r210);
        int r151 = View.MeasureSpec.getMode(r210);
        int r152 = View.MeasureSpec.getSize(r211);
        int r153 = View.MeasureSpec.getMode(r211);
        int r154 = getChildCount();
        int r155 = 0;
        int r156 = 0;
        int r157 = 0;
    L232:
        if (r157 >= r154) goto L248;
        View r158 = getChildAt(r157);
        if ((r158 instanceof ECTagView) == true) goto L236;
        r158 = null;
    L236:
        ECTagView r159 = (ECTagView) r158;
        if (r159 == null) goto L246;
        if (r159.getVisibility() == 8) goto L246;
        measureChild(r159, r210, r211);
        ViewGroup.LayoutParams r160 = r159.getLayoutParams();
        if (r160 == null) goto L245;
        ViewGroup.MarginLayoutParams r161 = (ViewGroup.MarginLayoutParams) r160;
        r155 = r155 + ((r159.getMeasuredWidth() + r161.leftMargin) + r161.rightMargin);
        r156 = RangesKt.coerceAtLeast(r156, (r159.getMeasuredHeight() + r161.topMargin) + r161.bottomMargin);
        goto L246
    L245:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L246:
        r157 = r157 + 1;
        goto L232
    L248:
        if (r151 != 1073741824) goto L250;
        int r162 = r150;
    L251:
        if (r153 == 1073741824) goto L254;
        r152 = getPaddingBottom() + (r156 + getPaddingTop());
    L254:
        setMeasuredDimension(r162, r152);
        if (r155 <= r150) goto L404;
        setVisibility(8);
        return;
    L404:
        return;
    L250:
        r162 = (getPaddingLeft() + r155) + getPaddingRight();
        goto L251
    L224:
        if (r101.intValue() != r106) goto L226;
        super.onMeasure(r210, r211);
        return;
    L118:
        if (r101.intValue() != r104) goto L220;
        int r163 = View.MeasureSpec.getSize(r210);
        int r164 = View.MeasureSpec.getMode(r210);
        int r165 = View.MeasureSpec.getSize(r211);
        int r166 = View.MeasureSpec.getMode(r211);
        int r167 = getLowestPriority();
        int r168 = getChildCount();
        int r169 = 0;
    L120:
        if (r169 >= r168) goto L154;
        View r170 = getChildAt(r169);
        if ((r170 instanceof ECTagView) == true) goto L124;
        r170 = null;
    L124:
        ECTagView r171 = (ECTagView) r170;
        if (r171 == null) goto L153;
        ECTagContainerDTO r172 = r171.f48893m;
        if (r172 == null) goto L129;
        int r173 = r172.getPriority();
    L130:
        if (r173 < r167) goto L153;
        int r174 = r171.getChildCount();
        int r175 = 0;
    L133:
        if (r175 >= r174) goto L153;
        View r176 = r171.getChildAt(r175);
        int r177 = r165;
        ECTagContainerDTO r178 = r171.f48893m;
        if (r178 == null) goto L139;
        List<com.bytedance.android.ec.store.repository.vo.s> r179 = r178.getSubTagList();
        if (r179 == null) goto L139;
        com.bytedance.android.ec.store.repository.vo.s r180 = (com.bytedance.android.ec.store.repository.vo.s) CollectionsKt.getOrNull(r179, r175);
    L141:
        if ((r176 instanceof TextView) == false) goto L146;
        TextView r181 = (TextView) r176;
        if (r180 == null) goto L152;
        r181.setTextSize(2, r180.n().b());
    L152:
        r175 = r175 + 1;
        r165 = r177;
        r167 = r167;
        goto L133
    L146:
        if ((r176 instanceof ECDraweeView) == false) goto L152;
        ECDraweeView r182 = (ECDraweeView) r176;
        if (r180 == null) goto L152;
        ECUrlModel r183 = r180.f();
        if (r183 == null) goto L152;
        r182.getLayoutParams().height = com.bytedance.android.shopping.store.utils.o.a(Integer.valueOf(r183.getHeight()));
    L139:
        r180 = null;
        goto L141
    L129:
        r173 = Integer.MIN_VALUE;
    L153:
        r169 = r169 + 1;
        r165 = r165;
        r167 = r167;
        goto L120
    L154:
        int r184 = r165;
        int r185 = 6;
    L155:
        r185 = r185 - 1;
        int r186 = getChildCount();
        int r187 = 0;
        int r188 = 0;
        int r189 = 0;
        View r190 = null;
    L156:
        if (r189 >= r186) goto L176;
        View r191 = getChildAt(r189);
        if (Intrinsics.areEqual(r191.getTag(), "fillView") == false) goto L161;
        r190 = r191;
    L161:
        if ((r191 instanceof ECTagView) == true) goto L163;
        r191 = null;
    L163:
        ECTagView r192 = (ECTagView) r191;
        if (r192 == null) goto L173;
        int r212 = r186;
        if (r192.getVisibility() == 8) goto L175;
        measureChild(r192, r210, r211);
        ViewGroup.LayoutParams r193 = r192.getLayoutParams();
        if (r193 == null) goto L172;
        ViewGroup.MarginLayoutParams r194 = (ViewGroup.MarginLayoutParams) r193;
        r187 = r187 + ((r192.getMeasuredWidth() + r194.leftMargin) + r194.rightMargin);
        r188 = RangesKt.coerceAtLeast(r188, (r192.getMeasuredHeight() + r194.topMargin) + r194.bottomMargin);
        goto L175
    L172:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L175:
        r189 = r189 + 1;
        r186 = r212;
        r190 = r190;
        goto L156
    L173:
        r212 = r186;
        goto L175
    L176:
        if (r187 <= r163) goto L208;
        if (r185 <= 0) goto L208;
        int r195 = getLowestPriority();
        int r196 = getChildCount();
        int r197 = 0;
    L179:
        if (r197 >= r196) goto L155;
        View r198 = getChildAt(r197);
        if ((r198 instanceof ECTagView) == true) goto L183;
        r198 = null;
    L183:
        ECTagView r199 = (ECTagView) r198;
        if (r199 == null) goto L206;
        ECTagContainerDTO r1100 = r199.f48893m;
        if (r1100 == null) goto L188;
        int r1101 = r1100.getPriority();
    L189:
        if (r1101 < r195) goto L206;
        int r1102 = r199.getChildCount();
        int r1103 = 0;
    L192:
        if (r1103 >= r1102) goto L206;
        View r1104 = r199.getChildAt(r1103);
        int r213 = r185;
        if ((r1104 instanceof TextView) == false) goto L199;
        TextView r1105 = (TextView) r1104;
        int r214 = r195;
        int r215 = r196;
        if (r1105.getTextSize() > 0) goto L198;
        r1105.setVisibility(8);
        ECTagView r1106 = r199;
    L205:
        r1103 = r1103 + 1;
        r199 = r1106;
        r185 = r213;
        r195 = r214;
        r196 = r215;
        goto L192
    L198:
        r1106 = r199;
        r1105.setTextSize(0, r1105.getTextSize() - 2);
        goto L205
    L199:
        r214 = r195;
        r215 = r196;
        r1106 = r199;
        if ((r1104 instanceof ECDraweeView) == false) goto L205;
        ECDraweeView r1107 = (ECDraweeView) r1104;
        if (r1107.getLayoutParams().height > 0) goto L204;
        r1107.setVisibility(8);
        goto L205
    L204:
        r1107.getLayoutParams().height = (int) (r1107.getLayoutParams().height * 0.8f);
        goto L205
    L188:
        r1101 = Integer.MIN_VALUE;
    L206:
        r197 = r197 + 1;
        r185 = r185;
        r195 = r195;
        r196 = r196;
    L208:
        if (r190 == null) goto L210;
        r190.getLayoutParams().width = r163 - r187;
        measureChild(r190, r210, r211);
    L210:
        h();
        if (r164 == 1073741824) goto L214;
        r163 = getPaddingRight() + (r187 + getPaddingLeft());
    L214:
        if (r166 != 1073741824) goto L216;
        int r200 = r184;
    L217:
        setMeasuredDimension(r163, r200);
        int r201 = getChildCount();
        int r1108 = 0;
    L218:
        if (r1108 >= r201) goto L407;
        dm.a.a("zhaojian").i(r1108 + "----->+" + getChildAt(r1108).getMeasuredWidth());
        r1108 = r1108 + 1;
        goto L218
    L407:
        return;
    L216:
        r200 = (r188 + getPaddingTop()) + getPaddingBottom();
        goto L217
    L16:
        if (r101.intValue() != r103) goto L114;
        int r1109 = View.MeasureSpec.getSize(r210);
        int r1110 = View.MeasureSpec.getMode(r210);
        int r1111 = View.MeasureSpec.getSize(r211);
        int r202 = View.MeasureSpec.getMode(r211);
        ArrayList r203 = new ArrayList();
        ECTagListDTO r204 = this.f48873f;
        if (r204 == null) goto L22;
        List<ECTagContainerDTO> r205 = r204.getTagContainers();
        if (r205 == null) goto L22;
        int r206 = r205.size();
    L23:
        int r207 = Integer.MAX_VALUE;
        int r208 = 0;
        int r209 = 0;
        int r216 = 0;
        int r1112 = 0;
    L24:
        if (r209 >= r206) goto L98;
        ECTagListDTO r1113 = this.f48873f;
        if (r1113 == null) goto L28;
        int r1114 = r1113.getContainerShowMax();
    L29:
        if (r208 >= r1114) goto L98;
        if (this.f48878k == false) goto L51;
        int r1115 = r1109 - r1112;
        if (r1115 >= r207) goto L38;
        double r1116 = r1115;
        ArrayList r1117 = r203;
        if (r1116 < (((double) r1109) * 0.2d)) goto L56;
    L39:
        ECTagListDTO r217 = this.f48873f;
        if (r217 == null) goto L56;
        List<ECTagContainerDTO> r218 = r217.getTagContainers();
        if (r218 == null) goto L56;
        ECTagContainerDTO r219 = (ECTagContainerDTO) CollectionsKt.getOrNull(r218, r209);
        if (r219 == null) goto L56;
        r219.setShouldDropOverflowSubTags(false);
        ECTagListDTO r220 = this.f48873f;
        if (r220 == null) goto L49;
        int r221 = r220.getOverLengthStrategy();
    L50:
        ECTagView r1118 = f(r219, r221);
        boolean r222 = true;
    L58:
        ECTagListDTO r223 = this.f48873f;
        if (r223 == null) goto L65;
        List<ECTagContainerDTO> r224 = r223.getTagContainers();
        if (r224 == null) goto L65;
        ECTagContainerDTO r225 = (ECTagContainerDTO) CollectionsKt.getOrNull(r224, r209);
        if (r225 == null) goto L65;
        int r226 = r225.getPriority();
    L66:
        r1118.setTag(R.id.tag_view_priority, Integer.valueOf(r226));
        r1118.setVisibility(0);
        measureChild(r1118, r210, r211);
        ViewGroup.LayoutParams r227 = r1118.getLayoutParams();
        if (r227 == null) goto L97;
        ViewGroup.MarginLayoutParams r228 = (ViewGroup.MarginLayoutParams) r227;
        int r229 = (r1118.getMeasuredWidth() + r228.leftMargin) + r228.rightMargin;
        int r230 = r208;
        int r1119 = (r1118.getMeasuredHeight() + r228.topMargin) + r228.bottomMargin;
        int r231 = Math.min(r207, r229);
        int r232 = r1112 + r229;
        if (r232 <= ((r1109 - getPaddingLeft()) - getPaddingRight())) goto L91;
        if (r222 == false) goto L86;
        int r1120 = r209;
        int r233 = r1109;
        int r1121 = r202;
        ECTagView r234 = j(r209, r1109, r1112, r210, r211);
        if (r234 == null) goto L87;
        ECTagListDTO r235 = this.f48873f;
        if (r235 == null) goto L80;
        List<ECTagContainerDTO> r236 = r235.getTagContainers();
        if (r236 == null) goto L80;
        ECTagContainerDTO r237 = (ECTagContainerDTO) CollectionsKt.getOrNull(r236, r1120);
        if (r237 == null) goto L80;
        int r238 = r237.getPriority();
    L81:
        r234.setTag(R.id.tag_view_priority, Integer.valueOf(r238));
        r1117.add(r234);
        ViewGroup.LayoutParams r239 = r234.getLayoutParams();
        if (r239 == null) goto L85;
        ViewGroup.MarginLayoutParams r240 = (ViewGroup.MarginLayoutParams) r239;
        r1112 = r1112 + ((r234.getMeasuredWidth() + r240.leftMargin) + r240.rightMargin);
        r216 = RangesKt.coerceAtLeast(r216, (r234.getMeasuredHeight() + r240.topMargin) + r240.bottomMargin);
        r208 = r230 + 1;
        r234.f();
        int r241 = r1120;
    L95:
        r209 = r241 + 1;
        r203 = r1117;
        r202 = r1121;
        r206 = r206;
        r207 = r231;
        r1109 = r233;
        goto L24
    L85:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L80:
        r238 = 0;
    L87:
        if (r222 == false) goto L89;
        i(r1118);
    L90:
        r241 = r1120;
        r208 = r230;
        goto L95
    L89:
        r1118.setVisibility(8);
        goto L90
    L86:
        r1120 = r209;
        r233 = r1109;
        r1121 = r202;
        goto L87
    L91:
        r241 = r209;
        r233 = r1109;
        r1121 = r202;
        if (r222 == false) goto L94;
        r1117.add(r1118);
    L94:
        r216 = RangesKt.coerceAtLeast(r216, r1119);
        r208 = r230 + 1;
        r1118.f();
        r1112 = r232;
        goto L95
    L97:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L65:
        r226 = 0;
        goto L66
    L49:
        r221 = OverLengthStrategy.DEFAULT.getStrategy();
    L56:
        int r242 = r1109;
        int r1122 = r202;
        if (r1117.size() <= 1) goto L102;
        CollectionsKt.sortWith(r1117, new m());
    L102:
        Iterator r243 = r1117.iterator();
    L104:
        if (r243.hasNext() == false) goto L107;
        addView((View) r243.next());
        goto L104
    L107:
        if (r1110 != 1073741824) goto L109;
        int r244 = r242;
    L110:
        if (r1122 == 1073741824) goto L113;
        r1111 = (r216 + getPaddingTop()) + getPaddingBottom();
    L113:
        setMeasuredDimension(r244, r1111);
        this.f48878k = false;
        return;
    L109:
        r244 = (r1112 + getPaddingLeft()) + getPaddingRight();
        goto L110
    L38:
        r1117 = r203;
        goto L39
    L51:
        r206 = r206;
        r1117 = r203;
        View r245 = getChildAt(r209);
        if ((r245 instanceof ECTagView) == true) goto L54;
        r245 = null;
    L54:
        ECTagView r246 = (ECTagView) r245;
        if (r246 == null) goto L56;
        r1118 = r246;
        r222 = false;
        goto L58
    L28:
        r1114 = Integer.MAX_VALUE;
    L98:
        r1117 = r203;
    L22:
        r206 = 0;
        goto L23
    L10:
        if (r101.intValue() != r102) goto L12;
        g(r210, r211);
        return;
    L5:
        r101 = null;
        goto L6
    }

    public ECTagListView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f48879l = new EventActionImplOpt();
        this.f48869b = new LinkedHashSet();
        this.f48876i = new LinkedHashMap();
        setGravity(16);
    }

    public /* synthetic */ ECTagListView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    public final ECTagView j(int r100, int r101, int r102, int r103, int r104) {
        ECTagListDTO r105 = this.f48873f;
        if (r105 == null) goto L25;
        List<ECTagContainerDTO> r106 = r105.getTagContainers();
        if (r106 == null) goto L25;
        ECTagContainerDTO r107 = (ECTagContainerDTO) CollectionsKt.getOrNull(r106, r100);
        if (r107 == null) goto L25;
        if (r107.hasDroppableSubTag() == true) goto L12;
        return null;
    L12:
        r107.setShouldDropOverflowSubTags(true);
        ECTagListDTO r108 = this.f48873f;
        if (r108 == null) goto L15;
        int r109 = r108.getOverLengthStrategy();
    L16:
        ECTagView r110 = f(r107, r109);
        r110.setVisibility(0);
        measureChild(r110, r103, r104);
        ViewGroup.LayoutParams r111 = r110.getLayoutParams();
        if (r111 == null) goto L24;
        ViewGroup.MarginLayoutParams r112 = (ViewGroup.MarginLayoutParams) r111;
        if ((r102 + ((r110.getMeasuredWidth() + r112.leftMargin) + r112.rightMargin)) <= ((r101 - getPaddingLeft()) - getPaddingRight())) goto L22;
        r107.setShouldDropOverflowSubTags(false);
        i(r110);
        return null;
    L22:
        return r110;
    L24:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L15:
        r109 = OverLengthStrategy.DEFAULT.getStrategy();
    L25:
        return null;
    }

    public final void b(ECTagListDTO r100, Integer r101, Map<String, String> r102, Function0<String> r110, xm.c r111, String r112) {
        Intrinsics.checkNotNullParameter(r100, "tagListVO");
        xm.c r103 = this.f48872e;
        if (r103 == null) goto L21;
        List<View> r104 = com.bytedance.commerce.base.view.b.a(this);
        removeAllViews();
        Iterator<T> r105 = r104.iterator();
    L6:
        if (r105.hasNext() == false) goto L22;
        View r106 = (View) r105.next();
        if ((r106 instanceof ViewGroup) == true) goto L10;
        View r107 = null;
    L11:
        ViewGroup r108 = (ViewGroup) r107;
        if (r108 == null) goto L20;
        List<View> r109 = com.bytedance.commerce.base.view.b.a(r108);
        r108.removeAllViews();
        Iterator<T> r113 = r109.iterator();
    L15:
        if (r113.hasNext() == false) goto L20;
        View r114 = (View) r113.next();
        if ((r114 instanceof TextView) == true) goto L18;
        r103.b(r114.getClass(), r114);
        goto L15
    L18:
        r103.c((TextView) r114);
    L20:
        r103.b(r106.getClass(), r106);
        goto L6
    L10:
        r107 = r106;
    L22:
        ((LinkedHashMap) this.f48876i).clear();
        this.f48869b.clear();
        setBaseEventParams(r102);
        if (this.f48877j != null) goto L25;
        this.f48877j = Integer.valueOf(getLayoutParams().width);
    L25:
        this.f48872e = r111;
        if (r101 != null) goto L28;
    L30:
        ViewGroup.LayoutParams r115 = getLayoutParams();
        Integer r116 = this.f48877j;
        if (r116 == null) goto L33;
        int r117 = r116.intValue();
    L34:
        r115.width = r117;
    L35:
        this.f48873f = r100;
        List<ECTagContainerDTO> r118 = r100.getTagContainers();
        boolean r119 = false;
        if (r118 == null) goto L41;
        Iterator<T> r120 = r118.iterator();
    L39:
        if (r120.hasNext() == false) goto L41;
        ((ECTagContainerDTO) r120.next()).setShouldDropOverflowSubTags(false);
    L41:
        this.f48874g = r110;
        this.f48875h = r112;
        ECTagListDTO r121 = this.f48873f;
        if (r121 != null) goto L44;
    L45:
        ECTagListDTO r122 = this.f48873f;
        if (r122 != null) goto L48;
    L49:
        ECTagListDTO r123 = this.f48873f;
        if (r123 != null) goto L52;
    L53:
        ECTagListDTO r124 = this.f48873f;
        if (r124 != null) goto L56;
    L58:
        boolean r125 = false;
    L59:
        if (r125 == true) goto L73;
        List<ECTagContainerDTO> r126 = r100.getTagContainers();
        if (r126 != null) goto L63;
        r126 = CollectionsKt.emptyList();
    L63:
        Iterator<ECTagContainerDTO> r127 = r126.iterator();
    L65:
        if (r127.hasNext() == false) goto L73;
        ECTagContainerDTO r128 = r127.next();
        TagContainerUI r129 = r128.getTagContainerUI();
        if (r129 == null) goto L72;
        if (r129.getRightAlignment() != true) goto L72;
        if (r119 == true) goto L72;
        FrameLayout r130 = new FrameLayout(getContext());
        r130.setTag("fillView");
        Unit r131 = Unit.INSTANCE;
        addView(r130, new LinearLayout.LayoutParams(-2, -2));
        r119 = true;
    L72:
        addView(d(r128, r100.getOverLengthStrategy()), e(r128));
    L73:
        setTagListLayoutParams(r100.getTagListUI());
        String r132 = r100.getShowEventName();
        if (r132 != null) goto L76;
    L81:
        ClickAction r133 = r100.getClickAction();
        Integer r134 = r133.getActionType();
        int r135 = ActionType.OPEN_SCHEMA.getType();
        if (r134 != null) goto L85;
    L89:
        Integer r136 = r133.getActionType();
        int r137 = ActionType.TOAST.getType();
        if (r136 != null) goto L93;
    L97:
        this.f48878k = true;
        return;
    L93:
        if (r136.intValue() != r137) goto L97;
        if (com.bytedance.android.shopping.extensions.k.c(r133.getToastText()) == false) goto L97;
        setOnClickListener(new l(r133, this, r110, r100));
        goto L97
    L85:
        if (r134.intValue() != r135) goto L89;
        if (com.bytedance.android.shopping.extensions.k.c(r133.getJumpUrl()) == false) goto L89;
        setOnClickListener(new k(r133, this, r110, r100));
        goto L97
    L76:
        if (r100.getHasReportShow() == true) goto L81;
        r100.setHasReportShow(true);
        String r138 = this.f48875h;
        PageFinder r139 = PageFinder.via(this);
        Map<String, String> r140 = this.f48876i;
        Map<String, String> r141 = r100.getShowEventParams();
        if (r141 != null) goto L80;
        r141 = MapsKt.emptyMap();
    L80:
        doEventAction(r132, r138, r139, MapsKt.plus(r140, r141));
        goto L81
    L56:
        if (r124.getOverLengthStrategy() != OverLengthStrategy.DEFAULT.getStrategy()) goto L58;
    L57:
        r125 = true;
        goto L59
    L52:
        if (r123.getOverLengthStrategy() == OverLengthStrategy.SCALE.getStrategy()) goto L57;
    L48:
        if (r122.getOverLengthStrategy() == OverLengthStrategy.HIDE_SORT_BY_PRIORITY.getStrategy()) goto L57;
    L44:
        if (r121.getOverLengthStrategy() == OverLengthStrategy.HIDE.getStrategy()) goto L57;
    L33:
        r117 = -2;
        goto L34
    L28:
        if (r101.intValue() <= 0) goto L30;
        ViewGroup.LayoutParams r142 = getLayoutParams();
        r142.width = r101.intValue();
        goto L35
    L21:
        removeAllViews();
        goto L22
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void c(ECTagListView r100, ECTagListDTO r110, Integer r111, Map r112, Function0 r113, xm.c r114, String r115, int r116) {
        if ((r116 & 2) == 0) goto L5;
        Integer r101 = null;
    L7:
        if ((r116 & 4) == 0) goto L9;
        Map r102 = null;
    L11:
        if ((r116 & 8) == 0) goto L13;
        Function0 r103 = null;
    L15:
        if ((r116 & 16) == 0) goto L17;
        xm.c r104 = null;
    L19:
        if ((r116 & 32) == 0) goto L21;
        String r105 = null;
    L22:
        r100.b(r110, r101, r102, r103, r104, r105);
        return;
    L21:
        r105 = r115;
        goto L22
    L17:
        r104 = r114;
        goto L19
    L13:
        r103 = r113;
        goto L15
    L9:
        r102 = r112;
        goto L11
    L5:
        r101 = r111;
        goto L7
    }
}
