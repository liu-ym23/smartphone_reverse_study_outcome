package com.bytedance.android.shopping.anchorv4.voavhs.base.elements;

import android.content.Context;
import android.graphics.Canvas;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.bytedance.android.shopping.anchorv4.dto.base.Action;
import com.bytedance.android.shopping.anchorv4.dto.base.Background;
import com.bytedance.android.shopping.anchorv4.dto.base.ImageModel;
import com.bytedance.android.shopping.anchorv4.dto.base.Radius;
import com.bytedance.android.shopping.anchorv4.dto.elements.ButtonType;
import com.bytedance.android.shopping.anchorv4.dto.elements.TextElement;
import com.bytedance.android.shopping.anchorv4.dto.elements.TextWithOneIconElement;
import com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor;
import com.bytedance.android.shopping.anchorv4.voavhs.base.extensions.ExtensionsKt;
import com.bytedance.android.shopping.anchorv4.voavhs.base.extensions.ImageExtensionsKt;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u0011J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J&\u0010\f\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\u000b\u001a\u00020\nJ\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\rH\u0016J\n\u0010\u0010\u001a\u0004\u0018\u00010\bH\u0016R$\u0010\u0017\u001a\u0004\u0018\u00010\u00048\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001b\u0010\u001d\u001a\u00020\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR'\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00040\u001e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u001a\u001a\u0004\b \u0010!R\u001b\u0010'\u001a\u00020#8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b$\u0010\u001a\u001a\u0004\b%\u0010&R(\u0010.\u001a\u0004\u0018\u00010(2\b\u0010)\u001a\u0004\u0018\u00010(8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R\u001b\u00103\u001a\u00020/8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b0\u0010\u001a\u001a\u0004\b1\u00102¨\u00064"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/base/elements/TextWithOneIconElementView;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/base/design/ActionHubAccessor;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/base/design/e;", "Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextWithOneIconElement;", "description", "", "setRadius", "", "statusId", "", "shouldIndent", "update", "Lcom/bytedance/android/shopping/anchorv4/voavhs/base/design/a;", "hub", "setActionHub", "getViewTag", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextWithOneIconElement;", "getDescriptionVO", "()Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextWithOneIconElement;", "setDescriptionVO", "(Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextWithOneIconElement;)V", "descriptionVO", "Lcom/bytedance/android/shopping/anchorv4/voavhs/base/extensions/b;", "b", "Lkotlin/Lazy;", "getRadiusHelper", "()Lcom/bytedance/android/shopping/anchorv4/voavhs/base/extensions/b;", "radiusHelper", "", "c", "getStatusMap", "()Ljava/util/Map;", "statusMap", "Lcom/bytedance/android/shopping/anchorv4/voavhs/base/elements/TextElementView;", "d", "getTextElementView", "()Lcom/bytedance/android/shopping/anchorv4/voavhs/base/elements/TextElementView;", "textElementView", "Landroid/view/View;", "<set-?>", "e", "Landroid/view/View;", "getIconView", "()Landroid/view/View;", "iconView", "Landroid/widget/LinearLayout;", "f", "getLinearWrapBox", "()Landroid/widget/LinearLayout;", "linearWrapBox", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class TextWithOneIconElementView extends FrameLayout implements ActionHubAccessor, com.bytedance.android.shopping.anchorv4.voavhs.base.design.e {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ int f167860j = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextWithOneIconElement f167861a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f167862b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f167863c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f167864d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f167865e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f167866f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f167867g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public com.bytedance.android.shopping.anchorv4.voavhs.base.design.a f167868h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f167869i;

    public static final class a {
    }

    static {
    }

    public TextWithOneIconElementView(Context r100) {
        this(r100, null, 0, null, 30);
    }

    public TextWithOneIconElementView(Context r100, AttributeSet r101) {
        this(r100, r101, 0, null, 28);
    }

    public TextWithOneIconElementView(Context r100, AttributeSet r101, int r102) {
        this(r100, r101, r102, null, 24);
    }

    private final LinearLayout getLinearWrapBox() {
        return (LinearLayout) this.f167866f.getValue();
    }

    private final com.bytedance.android.shopping.anchorv4.voavhs.base.extensions.b getRadiusHelper() {
        return (com.bytedance.android.shopping.anchorv4.voavhs.base.extensions.b) this.f167862b.getValue();
    }

    private final Map<String, TextWithOneIconElement> getStatusMap() {
        return (Map) this.f167863c.getValue();
    }

    public final TextElementView getTextElementView() {
        return (TextElementView) this.f167864d.getValue();
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor
    public final Action associatedAction() {
        TextWithOneIconElement r100 = this.f167861a;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getAction();
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.e
    public String getViewTag() {
        TextWithOneIconElement r100 = this.f167861a;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getTag();
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor
    public final com.bytedance.android.shopping.anchorv4.voavhs.base.design.a actionHub() {
        return this.f167868h;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor
    public final Object descriptionVO() {
        return this.f167861a;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor
    public final void dispatchPossibleShow() {
        ActionHubAccessor.DefaultImpls.b(this);
    }

    public final TextWithOneIconElement getDescriptionVO() {
        return this.f167861a;
    }

    public final View getIconView() {
        return this.f167865e;
    }

    private final void setRadius(TextWithOneIconElement r100) {
        com.bytedance.android.shopping.anchorv4.voavhs.base.extensions.b r101 = getRadiusHelper();
        Background r102 = r100.getBackground();
        if (r102 == null) goto L5;
        Radius r103 = r102.getRadius();
    L6:
        r101.f(r103);
        return;
    L5:
        r103 = null;
        goto L6
    }

    public final void c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "status");
        TextWithOneIconElement r101 = this.f167861a;
        if (r101 == null) goto L8;
        TextWithOneIconElement r102 = r101.findStatus(r100);
        if (r102 == null) goto L9;
        b(this, r102, null, false, null, 14);
        return;
    L9:
        return;
    }

    @Override // android.view.View
    public final void draw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        getRadiusHelper().e(r100);
        super.draw(r100);
        getRadiusHelper().d(r100);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor
    public final String getOnLimitClickBindKey(Action r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        return ActionHubAccessor.DefaultImpls.c(r100);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor
    public void setActionHub(com.bytedance.android.shopping.anchorv4.voavhs.base.design.a r100) {
        Intrinsics.checkNotNullParameter(r100, "hub");
        this.f167868h = r100;
    }

    public final void setDescriptionVO(TextWithOneIconElement r100) {
        this.f167861a = r100;
    }

    public final void a(View r100, ViewGroup.MarginLayoutParams r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "layoutParams");
        wg.a.a(r100);
        addView(r100, r101);
    }

    public final void update(TextWithOneIconElement r100, String r101, boolean r102) {
        this.f167861a = r100;
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        getRadiusHelper().c(r100, r101);
    }

    public TextWithOneIconElementView(final Context r100, AttributeSet r101, int r102, com.bytedance.android.shopping.anchorv4.voavhs.base.design.a r103, String r104) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f167868h = r103;
        this.f167869i = r104;
        this.f167862b = LazyKt.lazy(new TextWithOneIconElementView$radiusHelper$2(this));
        this.f167863c = LazyKt.lazy(TextWithOneIconElementView$statusMap$2.INSTANCE);
        this.f167864d = LazyKt.lazy(new TextWithOneIconElementView$textElementView$2(this, r100));
        this.f167866f = LazyKt.lazy(new TextWithOneIconElementView$linearWrapBox$2(r100));
    }

    public /* synthetic */ TextWithOneIconElementView(Context r100, AttributeSet r110, int r111, String r112, int r113) {
        if ((r113 & 2) == 0) goto L5;
        AttributeSet r101 = null;
    L7:
        if ((r113 & 4) == 0) goto L9;
        int r102 = 0;
    L11:
        if ((r113 & 16) == 0) goto L13;
        String r103 = null;
    L14:
        this(r100, r101, r102, null, r103);
        return;
    L13:
        r103 = r112;
        goto L14
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }

    public static void b(TextWithOneIconElementView r100, TextWithOneIconElement r101, String r110, boolean r111, String r112, int r113) {
        Integer r102 = null;
        if ((r113 & 2) == 0) goto L6;
        r110 = null;
    L6:
        if ((r113 & 4) == 0) goto L9;
        r111 = false;
    L9:
        if ((r113 & 8) == 0) goto L11;
        r112 = null;
    L11:
        r100.f167861a = r101;
        r100.f167867g = r112;
        if (r101 != null) goto L14;
        r100.setVisibility(8);
        return;
    L14:
        r100.removeAllViews();
        r100.f167865e = null;
        LinearLayout r114 = r100.getLinearWrapBox();
        FrameLayout.LayoutParams r115 = new FrameLayout.LayoutParams(-2, -2);
        int r103 = r101.getAlignStrategy();
        boolean r104 = true;
        if (r103 == 1) goto L22;
        int r105 = 3;
        if (r103 != 3) goto L19;
    L23:
        r115.gravity = r105;
        Unit r106 = Unit.INSTANCE;
        r100.addView(r114, r115);
        r100.getStatusMap().clear();
        List<TextWithOneIconElement> r116 = r101.getStates();
        if (r116 != null) goto L26;
    L40:
        r100.setContentDescription(r101.getContentDescription());
        TextWithOneIconElement r117 = r100.getStatusMap().get(r110);
        if (r117 == null) goto L44;
        r101 = r117;
    L44:
        r100.setRadius(r101);
        ExtensionsKt.j(r100, r101.getBackground());
        r100.getLinearWrapBox().removeAllViews();
        if (r101.getIcon() == null) goto L126;
        if (r101.getContent() == null) goto L126;
        int r118 = r101.getButtonType();
        TextElement r119 = r101.getContent();
        if (r119 == null) goto L149;
        ImageModel r120 = r101.getIcon();
        if (r120 == null) goto L149;
        ButtonType r107 = ButtonType.LEFT;
        Integer r108 = r107.getType();
        if (r108 != null) goto L58;
    L59:
        Integer r109 = ButtonType.RIGHT.getType();
        if (r109 != null) goto L63;
    L65:
        int r121 = 0;
    L67:
        r100.getLinearWrapBox().setOrientation(r121 ^ 1);
        View r122 = ImageExtensionsKt.f(r120, r100.getContext(), r100.f167867g);
        r100.f167865e = r122;
        View[] r123 = new View[2];
        r123[0] = r122;
        TextElementView r124 = r100.getTextElementView();
        r124.x(r119);
        r124.setEllipsize(TextUtils.TruncateAt.END);
        LinearLayout.LayoutParams r125 = new LinearLayout.LayoutParams(-2, -2);
        Integer r126 = Integer.valueOf(r101.getSpace());
        if (r126.intValue() <= 0) goto L70;
        boolean r127 = true;
    L71:
        if (r127 == false) goto L73;
        r102 = r126;
    L73:
        if (r102 == null) goto L98;
        int r128 = r102.intValue();
        Integer r129 = r107.getType();
        if (r129 != null) goto L78;
    L80:
        Integer r130 = ButtonType.TOP.getType();
        if (r130 != null) goto L84;
    L86:
        Integer r131 = ButtonType.RIGHT.getType();
        if (r131 != null) goto L90;
    L92:
        Integer r132 = ButtonType.BOTTOM.getType();
        if (r132 == null) goto L98;
        if (r118 != r132.intValue()) goto L98;
        r125.bottomMargin = com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r128));
        goto L98
    L90:
        if (r118 != r131.intValue()) goto L92;
        r125.rightMargin = com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r128));
        goto L98
    L84:
        if (r118 != r130.intValue()) goto L86;
        r125.topMargin = com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r128));
        goto L98
    L78:
        if (r118 != r129.intValue()) goto L80;
        r125.leftMargin = com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r128));
    L98:
        r124.setLayoutParams(r125);
        Unit r133 = Unit.INSTANCE;
        r123[1] = r124;
        List r134 = CollectionsKt.listOf(r123);
        Integer r135 = ButtonType.RIGHT.getType();
        if (r135 != null) goto L102;
    L103:
        Integer r136 = ButtonType.BOTTOM.getType();
        if (r136 != null) goto L107;
    L109:
        r104 = false;
    L110:
        if (r104 == false) goto L112;
        r134 = CollectionsKt.reversed(r134);
    L112:
        Iterator r137 = r134.iterator();
    L114:
        if (r137.hasNext() == false) goto L149;
        View r138 = (View) r137.next();
        if (r111 == false) goto L124;
        if ((r138 instanceof TextElementView) == false) goto L124;
        ViewGroup.LayoutParams r139 = ((TextElementView) r138).getLayoutParams();
        if (r139 == null) goto L123;
        LinearLayout.LayoutParams r140 = (LinearLayout.LayoutParams) r139;
        r140.width = 0;
        r140.height = -2;
        r140.weight = 1.0f;
        r100.getLinearWrapBox().addView(r138, r140);
        goto L114
    L123:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
    L124:
        r100.getLinearWrapBox().addView(r138);
        goto L114
    L107:
        if (r118 != r136.intValue()) goto L109;
    L102:
        if (r118 == r135.intValue()) goto L110;
    L70:
        r127 = false;
        goto L71
    L63:
        if (r118 != r109.intValue()) goto L65;
    L66:
        r121 = 1;
        goto L67
    L58:
        if (r118 == r108.intValue()) goto L66;
    L149:
        Action r141 = r101.getAction();
        Intrinsics.checkNotNullParameter(r100, "theView");
        ActionHubAccessor.DefaultImpls.a(r100, r100, r141);
        return;
    L126:
        if (r101.getIcon() == null) goto L132;
        ImageModel r142 = r101.getIcon();
        if (r142 == null) goto L149;
        r100.f167865e = ImageExtensionsKt.f(r142, r100.getContext(), r100.f167867g);
        r100.getLinearWrapBox().addView(r100.f167865e);
        goto L149
    L132:
        if (r101.getContent() == null) goto L138;
        TextElement r143 = r101.getContent();
        if (r143 == null) goto L149;
        LinearLayout r144 = r100.getLinearWrapBox();
        TextElementView r145 = r100.getTextElementView();
        r145.x(r143);
        r144.addView(r145);
        goto L149
    L138:
        if (r101.getContentV2() == null) goto L147;
        List<TextElement> r146 = r101.getContentV2();
        if (r146 == null) goto L149;
        Iterator<T> r147 = r146.iterator();
    L144:
        if (r147.hasNext() == false) goto L149;
        TextElement r148 = (TextElement) r147.next();
        LinearLayout r149 = r100.getLinearWrapBox();
        TextElementView r150 = new TextElementView(r100.getContext(), null, 0, r100.f167869i, 14);
        r150.x(r148);
        r149.addView(r150);
        goto L144
    L147:
        if (r101.getBackground() != null) goto L149;
        r100.setVisibility(8);
        goto L149
    L26:
        if ((!r116.isEmpty()) != true) goto L40;
        String r151 = r101.getStatusId();
        if (r151 == null) goto L30;
        TextWithOneIconElement r152 = r100.getStatusMap().put(r151, r101);
    L30:
        List<TextWithOneIconElement> r153 = r101.getStates();
        if (r153 == null) goto L40;
        Iterator<T> r154 = r153.iterator();
    L34:
        if (r154.hasNext() == false) goto L40;
        TextWithOneIconElement r155 = (TextWithOneIconElement) r154.next();
        if (r155 == null) goto L34;
        String r156 = r155.getStatusId();
        if (r156 == null) goto L34;
        TextWithOneIconElement r157 = r100.getStatusMap().put(r156, r155);
        goto L34
    L19:
        if (r103 != 4) goto L22;
        r105 = 5;
    L22:
        r105 = 17;
        goto L23
    }
}
