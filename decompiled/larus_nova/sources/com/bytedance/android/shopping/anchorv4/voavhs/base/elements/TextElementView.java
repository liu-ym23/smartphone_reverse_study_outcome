package com.bytedance.android.shopping.anchorv4.voavhs.base.elements;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Typeface;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import com.bytedance.android.ec.core.utils.font.ECFontHelper;
import com.bytedance.android.shopping.anchorv4.dto.base.Action;
import com.bytedance.android.shopping.anchorv4.dto.base.FontStyle;
import com.bytedance.android.shopping.anchorv4.dto.base.Highlight;
import com.bytedance.android.shopping.anchorv4.dto.base.Link;
import com.bytedance.android.shopping.anchorv4.dto.base.LinkAction;
import com.bytedance.android.shopping.anchorv4.dto.elements.TextElement;
import com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u000eJ\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\n\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016R(\u0010\u0012\u001a\u0004\u0018\u00010\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u00048\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/base/elements/TextElementView;", "Landroidx/appcompat/widget/AppCompatTextView;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/base/design/ActionHubAccessor;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/base/design/e;", "Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextElement;", "textElement", "", "setTextWithHighlight", "Lcom/bytedance/android/shopping/anchorv4/voavhs/base/design/a;", "hub", "setActionHub", "", "getViewTag", "<set-?>", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextElement;", "getDescriptionVO", "()Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextElement;", "descriptionVO", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class TextElementView extends AppCompatTextView implements ActionHubAccessor, com.bytedance.android.shopping.anchorv4.voavhs.base.design.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextElement f167857a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.bytedance.android.shopping.anchorv4.voavhs.base.design.a f167858b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f167859c;

    public static final class a {
    }

    static {
    }

    public TextElementView(Context r100) {
        this(r100, null, 0, null, 30);
    }

    public TextElementView(Context r100, AttributeSet r101) {
        this(r100, r101, 0, null, 28);
    }

    public TextElementView(Context r100, AttributeSet r101, int r102) {
        this(r100, r101, r102, null, 24);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor
    public final Action associatedAction() {
        TextElement r100 = this.f167857a;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getAction();
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.e
    public String getViewTag() {
        TextElement r100 = this.f167857a;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getTag();
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor
    public final com.bytedance.android.shopping.anchorv4.voavhs.base.design.a actionHub() {
        return this.f167858b;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor
    public final Object descriptionVO() {
        return this.f167857a;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor
    public final void dispatchPossibleShow() {
        ActionHubAccessor.DefaultImpls.b(this);
    }

    public final TextElement getDescriptionVO() {
        return this.f167857a;
    }

    private final void setTextWithHighlight(TextElement r110) {
        List<Highlight> r100 = r110.getHighlights();
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L41;
        setText(r110.getText());
        return;
    L41:
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L35
        SpannableString r103 = new SpannableString(r110.getText());     // Catch: Throwable -> L35
        Iterator<T> r104 = r110.getHighlights().iterator();     // Catch: Throwable -> L35
    L13:
        if (r104.hasNext() == false) goto L33;
        Highlight r105 = (Highlight) r104.next();     // Catch: Throwable -> L35
        FontStyle r106 = r105.getHighlightStyle();     // Catch: Throwable -> L35
        if (r106 == null) goto L13;
        ForegroundColorSpan r107 = new ForegroundColorSpan(com.bytedance.android.shopping.extensions.a.a(r106.getTextColor(), 0));     // Catch: Throwable -> L35
        Integer r108 = r105.getStart();     // Catch: Throwable -> L35
        if (r108 == null) goto L19;
        int r109 = r108.intValue();     // Catch: Throwable -> L35
    L20:
        Integer r111 = r105.getEnd();     // Catch: Throwable -> L35
        if (r111 == null) goto L23;
        int r112 = r111.intValue();     // Catch: Throwable -> L35
    L24:
        r103.setSpan(r107, r109, r112 + 1, 18);     // Catch: Throwable -> L35
        AbsoluteSizeSpan r113 = new AbsoluteSizeSpan(com.bytedance.android.shopping.extensions.b.b(Float.valueOf(r106.getFontSize())));     // Catch: Throwable -> L35
        Integer r114 = r105.getStart();     // Catch: Throwable -> L35
        if (r114 == null) goto L27;
        int r115 = r114.intValue();     // Catch: Throwable -> L35
    L28:
        Integer r116 = r105.getEnd();     // Catch: Throwable -> L35
        if (r116 == null) goto L31;
        int r117 = r116.intValue();     // Catch: Throwable -> L35
    L32:
        r103.setSpan(r113, r115, r117 + 1, 18);     // Catch: Throwable -> L35
        goto L13
    L31:
        r117 = 0;
        goto L32
    L27:
        r115 = 0;
        goto L28
    L23:
        r112 = 0;
        goto L24
    L19:
        r109 = 0;
        goto L20
    L33:
        setText(r103);     // Catch: Throwable -> L35
        Object r118 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L35
    L38:
        if (Result.m9452exceptionOrNullimpl(r118) == null) goto L49;
        setText(r110.getText());
        return;
    L49:
        return;
    L35:
        th = move-exception;
        Result.Companion r119 = Result.Companion;
        r118 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L38
    L5:
        if (r100.isEmpty() == true) goto L8;
        r101 = false;
        goto L9
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor
    public final String getOnLimitClickBindKey(Action r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        return ActionHubAccessor.DefaultImpls.c(r100);
    }

    @Override // android.widget.TextView, android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        r100.save();
        TextElement r101 = this.f167857a;
        if (r101 == null) goto L9;
        FontStyle r102 = r101.getFontStyle();
        if (r102 == null) goto L9;
        Float r103 = r102.getVerticalOffSet();
        if (r103 == null) goto L9;
        float r104 = r103.floatValue();
    L10:
        r100.translate(0.0f, r104);
        super.onDraw(r100);
        r100.restore();
        return;
    L9:
        r104 = 0.0f;
        goto L10
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor
    public void setActionHub(com.bytedance.android.shopping.anchorv4.voavhs.base.design.a r100) {
        Intrinsics.checkNotNullParameter(r100, "hub");
        this.f167858b = r100;
    }

    public final void x(TextElement r110) {
        this.f167857a = r110;
        if (r110 != null) goto L6;
        setVisibility(8);
        return;
    L6:
        setText(r110.getText());
        int r100 = r110.getTextGravity();
        if (r100 == 0) goto L13;
        if (r100 == 1) goto L12;
        if (r100 != 2) goto L13;
        int r101 = 8388629;
    L14:
        setGravity(r101);
        FontStyle r102 = r110.getFontStyle();
        if (r102 == null) goto L101;
        Integer r103 = r102.getFontUnit();
        if (r103 != null) goto L20;
    L22:
        setTextSize(1, r102.getFontSize());
    L24:
        if (r102.getLine() < 1) goto L26;
        int r104 = r102.getLine();
    L27:
        setMaxLines(r104);
        String r105 = r110.getTruncate();
        int r106 = r105.hashCode();
        if (r106 == (-1074341483)) goto L36;
        if (r106 == 3198432) goto L33;
    L38:
        TextUtils.TruncateAt r107 = TextUtils.TruncateAt.END;
    L39:
        setEllipsize(r107);
        int r108 = 0;
        setTextColor(com.bytedance.android.shopping.extensions.a.a(r102.getTextColor(), 0));
        String r109 = this.f167859c;
        if (r109 != null) goto L42;
    L89:
        if (r108 != 0) goto L101;
        if (r102.getFontWeight() < 500) goto L93;
        setTypeface(getTypeface(), 1);
    L93:
        String r111 = r102.getFontEnum();
        if (r111 == null) goto L101;
        if (r111.hashCode() != 51) goto L101;
        if (r111.equals("3") == false) goto L101;
        setTypeface(getTypeface(), 3);
        goto L101
    L42:
        if (r109.hashCode() == (-1431958525)) goto L45;
    L47:
        Typeface r112 = ECFontHelper.f45592e.b(r109, r102.getFontWeight(), false);
    L48:
        ViewGroup.LayoutParams r113 = null;
        if (r102.getFontWeight() < 500) goto L51;
        Integer r114 = 1;
    L53:
        if (Intrinsics.areEqual(r102.getFontEnum(), "3") == false) goto L55;
        r114 = 3;
    L55:
        if (r112 == null) goto L60;
        if (r114 != null) goto L58;
        setTypeface(r112);
    L59:
        int r115 = 1;
    L61:
        FontStyle r116 = r110.getFontStyle();
        if (r116 == null) goto L88;
        f73.b r117 = r116.getMargin();
        if (r117 == null) goto L88;
        ViewGroup.LayoutParams r118 = getLayoutParams();
        if ((r118 instanceof ViewGroup.MarginLayoutParams) == false) goto L69;
        r113 = r118;
    L69:
        ViewGroup.MarginLayoutParams r119 = (ViewGroup.MarginLayoutParams) r113;
        if (r119 != null) goto L72;
        r119 = new ViewGroup.MarginLayoutParams(-2, -2);
    L72:
        Float r120 = r117.b();
        if (r120 == null) goto L75;
        int r121 = com.bytedance.android.shopping.extensions.b.b(r120);
    L76:
        r119.leftMargin = r121;
        Float r122 = r117.c();
        if (r122 == null) goto L79;
        int r123 = com.bytedance.android.shopping.extensions.b.b(r122);
    L80:
        r119.rightMargin = r123;
        Float r124 = r117.d();
        if (r124 == null) goto L83;
        int r125 = com.bytedance.android.shopping.extensions.b.b(r124);
    L84:
        r119.topMargin = r125;
        Float r126 = r117.a();
        if (r126 == null) goto L87;
        r108 = com.bytedance.android.shopping.extensions.b.b(r126);
    L87:
        r119.bottomMargin = r108;
        Unit r127 = Unit.INSTANCE;
        setLayoutParams(r119);
        goto L88
    L83:
        r125 = 0;
        goto L84
    L79:
        r123 = 0;
        goto L80
    L75:
        r121 = 0;
    L88:
        r108 = r115;
        goto L89
    L58:
        setTypeface(r112, r114.intValue());
        goto L59
    L60:
        r115 = 0;
        goto L61
    L51:
        r114 = null;
        goto L53
    L45:
        if (r109.equals("monospace") == false) goto L47;
        r112 = Typeface.MONOSPACE;
        goto L48
    L33:
        if (r105.equals("head") == false) goto L38;
        r107 = TextUtils.TruncateAt.START;
        goto L39
    L36:
        if (r105.equals("middle") == false) goto L38;
        r107 = TextUtils.TruncateAt.MIDDLE;
        goto L39
    L26:
        r104 = Integer.MAX_VALUE;
        goto L27
    L20:
        if (r103.intValue() != 0) goto L22;
        setTextSize(2, r102.getFontSize());
    L101:
        Link r128 = r110.getLink();
        if (r128 != null) goto L104;
    L106:
        setTextWithHighlight(r110);
        Action r129 = r110.getAction();
        Intrinsics.checkNotNullParameter(this, "theView");
        ActionHubAccessor.DefaultImpls.a(this, this, r129);
        return;
    L104:
        if (Intrinsics.areEqual(r128.getAction(), LinkAction.ACTION_SCHEMA.getAction()) == false) goto L106;
        setOnClickListener(new e(r128, this));
        goto L106
    L12:
        r101 = 17;
    L13:
        r101 = 16;
        goto L14
    }

    public TextElementView(Context r100, AttributeSet r101, int r102, String r103, int r104) {
        if ((r104 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r104 & 4) == 0) goto L9;
        r102 = 0;
    L9:
        if ((r104 & 16) == 0) goto L11;
        r103 = null;
    L11:
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f167858b = null;
        this.f167859c = r103;
        setIncludeFontPadding(false);
        setGravity(16);
    }
}
