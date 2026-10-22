package com.obric.oui.titlebar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.bytedance.apm.constant.TraceStatsConsts;
import com.obric.common.oui.R;
import com.obric.oui.common.util.OUnitExtensionKt;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OContainerTitleBar.kt */
/* JADX INFO: loaded from: classes4.dex */
@Deprecated(message = "请使用 OCTitleBar")
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010)\u001a\u00020*2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0010\u0010+\u001a\u00020*2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J\u0010\u0010,\u001a\u00020*2\u0006\u0010-\u001a\u00020\u0007H\u0016J$\u0010.\u001a\u00020*2\b\u0010/\u001a\u0004\u0018\u0001002\b\u00101\u001a\u0004\u0018\u0001002\b\u00102\u001a\u0004\u0018\u000100J\u001e\u0010.\u001a\u00020*2\u0006\u0010/\u001a\u00020\u00072\u0006\u00101\u001a\u00020\u00072\u0006\u00102\u001a\u00020\u0007J&\u00103\u001a\u00020*2\u0006\u0010/\u001a\u00020\u00072\u0006\u00101\u001a\u00020\u00072\u0006\u00104\u001a\u00020\u00072\u0006\u00105\u001a\u00020\u0007J\u0010\u00106\u001a\u00020*2\u0006\u00107\u001a\u000208H\u0016R\u0013\u0010\t\u001a\u0004\u0018\u00010\n8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001d\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0013\"\u0004\b\u001f\u0010\u0015R\u001a\u0010 \u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0013\"\u0004\b\"\u0010\u0015R\u0010\u0010#\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0013\u0010%\u001a\u0004\u0018\u00010\n8F¢\u0006\u0006\u001a\u0004\b&\u0010\fR\u0013\u0010'\u001a\u0004\u0018\u00010\n8F¢\u0006\u0006\u001a\u0004\b(\u0010\f¨\u00069"}, d2 = {"Lcom/obric/oui/titlebar/OContainerTitleBar;", "Lcom/obric/oui/titlebar/OTitleBar;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "endButton", "Landroid/widget/ImageView;", "getEndButton", "()Landroid/widget/ImageView;", "endContainer", "Landroid/widget/FrameLayout;", "getEndContainer", "()Landroid/widget/FrameLayout;", "mEnd0Color", "getMEnd0Color", "()I", "setMEnd0Color", "(I)V", "mEnd1Color", "getMEnd1Color", "setMEnd1Color", "mEndButton1", "mEndContainer", "mLine", "Landroid/view/View;", "mStart0Color", "getMStart0Color", "setMStart0Color", "mStart1Color", "getMStart1Color", "setMStart1Color", "mStartButton0", "mStartButton1", "startButton0", "getStartButton0", "startButton1", "getStartButton1", "init", "", "initAttrs", "setDividerLineBackground", "color", "setDrawables", "start0", "Landroid/graphics/drawable/Drawable;", "start1", TraceStatsConsts.STATS_KEY_END, "setTint", "end0", "end1", "showDividerLine", "show", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OContainerTitleBar extends OTitleBar {
    private int mEnd0Color;
    private int mEnd1Color;
    private ImageView mEndButton1;
    private FrameLayout mEndContainer;
    private View mLine;
    private int mStart0Color;
    private int mStart1Color;
    private ImageView mStartButton0;
    private ImageView mStartButton1;

    public OContainerTitleBar(Context r8) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, null, 0, 6, null);
    }

    public OContainerTitleBar(Context r8, AttributeSet r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, r9, 0, 4, null);
    }

    public /* synthetic */ OContainerTitleBar(Context r1, AttributeSet r2, int r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = 0;
    L8:
        this(r1, r2, r3);
    }

    public OContainerTitleBar(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        init(r2);
        if (r3 == null) goto L6;
        initAttrs(r3);
        return;
    }

    public final ImageView getStartButton0() {
        return this.mStartButton0;
    }

    public final ImageView getStartButton1() {
        return this.mStartButton1;
    }

    public final FrameLayout getEndContainer() {
        return this.mEndContainer;
    }

    public final ImageView getEndButton() {
        return this.mEndButton1;
    }

    private final void init(Context r3) {
        OTitleBar.inflate(r3, R.layout.o_view_container_title_bar, this);
        this.mStartButton0 = (ImageView) findViewById(R.id.iv_start_0);
        this.mStartButton1 = (ImageView) findViewById(R.id.iv_start_1);
        this.mEndContainer = (FrameLayout) findViewById(R.id.end_container);
        this.mEndButton1 = (ImageView) findViewById(R.id.iv_end_1);
        this.mTitleView = (TextView) findViewById(R.id.title);
        this.mLine = findViewById(R.id.line);
    }

    private final void initAttrs(AttributeSet r5) {
        TypedArray r6 = getContext().getTheme().obtainStyledAttributes(r5, R.styleable.OCompoundTitleBar, 0, 0);
        setTitle(r6.getString(R.styleable.OCompoundTitleBar_oui_centerText));     // Catch: Throwable -> L6
        setTitleColor(r6.getColor(R.styleable.OCompoundTitleBar_oui_centerTextColor, ContextCompat.getColor(getContext(), R.color.TextPrimary)));     // Catch: Throwable -> L6
        setTitleSizePixel(r6.getDimension(R.styleable.OCompoundTitleBar_oui_centerTextSize, OUnitExtensionKt.dp2px(17)));     // Catch: Throwable -> L6
        int r0 = r6.getColor(R.styleable.OCompoundTitleBar_oui_dividerColor, ContextCompat.getColor(getContext(), R.color.LinePrimary));     // Catch: Throwable -> L6
        showDividerLine(r6.getBoolean(R.styleable.OCompoundTitleBar_oui_dividerVisible, false));     // Catch: Throwable -> L6
        setDividerLineBackground(r0);     // Catch: Throwable -> L6
        r6.recycle();
        return;
    L6:
        th = move-exception;
        r6.recycle();
        throw th;
    }

    public final int getMStart0Color() {
        return this.mStart0Color;
    }

    public final void setMStart0Color(int r1) {
        this.mStart0Color = r1;
    }

    public final int getMStart1Color() {
        return this.mStart1Color;
    }

    public final void setMStart1Color(int r1) {
        this.mStart1Color = r1;
    }

    public final int getMEnd0Color() {
        return this.mEnd0Color;
    }

    public final void setMEnd0Color(int r1) {
        this.mEnd0Color = r1;
    }

    public final int getMEnd1Color() {
        return this.mEnd1Color;
    }

    public final void setMEnd1Color(int r1) {
        this.mEnd1Color = r1;
    }

    public final void setTint(int r1, int r2, int r3, int r4) {
        this.mStart0Color = r1;
        this.mStart1Color = r2;
        this.mEnd0Color = r3;
        this.mEnd1Color = r4;
        ImageView r5 = this.mStartButton0;
        if (r5 == null) goto L6;
        r5.setColorFilter(r1);
    L6:
        ImageView r6 = this.mStartButton1;
        if (r6 == null) goto L10;
        r6.setColorFilter(r2);
    L10:
        ImageView r0 = this.mEndButton1;
        if (r0 == null) goto L15;
        r0.setColorFilter(r4);
        return;
    }

    public final void setDrawables(int r3, int r4, int r5) {
        Drawable r0 = null;
        if (r3 == 0) goto L5;
        Drawable r6 = ContextCompat.getDrawable(getContext(), r3);
    L6:
        if (r4 == 0) goto L8;
        Drawable r7 = ContextCompat.getDrawable(getContext(), r4);
    L9:
        if (r5 == 0) goto L11;
        r0 = ContextCompat.getDrawable(getContext(), r5);
    L11:
        setDrawables(r6, r7, r0);
        return;
    L8:
        r7 = null;
        goto L9
    L5:
        r6 = null;
        goto L6
    }

    public final void setDrawables(Drawable r5, Drawable r6, Drawable r7) {
        if (r5 != null) goto L12;
        ImageView r3 = this.mStartButton0;
        if (r3 == null) goto L8;
        r3.setVisibility(4);
    L8:
        ImageView r4 = this.mStartButton0;
        if (r4 == null) goto L16;
        r4.setOnClickListener(null);
    L16:
        ImageView r8 = this.mStartButton0;
        if (r8 == null) goto L20;
        r8.setImageDrawable(r5);
    L20:
        if (r6 != null) goto L29;
        ImageView r9 = this.mStartButton1;
        if (r9 == null) goto L25;
        r9.setVisibility(4);
    L25:
        ImageView r10 = this.mStartButton1;
        if (r10 == null) goto L33;
        r10.setOnClickListener(null);
    L33:
        ImageView r11 = this.mStartButton1;
        if (r11 == null) goto L37;
        r11.setImageDrawable(r6);
    L37:
        if (r7 != null) goto L46;
        ImageView r12 = this.mEndButton1;
        if (r12 == null) goto L42;
        r12.setVisibility(4);
    L42:
        ImageView r13 = this.mEndButton1;
        if (r13 == null) goto L50;
        r13.setOnClickListener(null);
    L50:
        ImageView r14 = this.mEndButton1;
        if (r14 == null) goto L55;
        r14.setImageDrawable(r7);
        return;
    L55:
        return;
    L46:
        ImageView r15 = this.mEndButton1;
        if (r15 == null) goto L50;
        r15.setVisibility(0);
        goto L50
    L29:
        ImageView r16 = this.mStartButton1;
        if (r16 == null) goto L33;
        r16.setVisibility(0);
        goto L33
    L12:
        ImageView r17 = this.mStartButton0;
        if (r17 == null) goto L16;
        r17.setVisibility(0);
        goto L16
    }

    @Override // com.obric.oui.titlebar.OTitleBar
    public void showDividerLine(boolean r1) {
        View r0 = this.mLine;
        if (r0 == null) goto L10;
        if (r1 == false) goto L7;
        int r2 = 0;
    L8:
        r0.setVisibility(r2);
        return;
    L7:
        r2 = 8;
        goto L8
    }

    @Override // com.obric.oui.titlebar.OTitleBar
    public void setDividerLineBackground(int r1) {
        View r0 = this.mLine;
        if (r0 == null) goto L7;
        r0.setBackgroundColor(r1);
        return;
    }
}
