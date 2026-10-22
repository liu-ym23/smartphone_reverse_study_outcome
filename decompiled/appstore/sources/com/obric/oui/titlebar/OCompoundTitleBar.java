package com.obric.oui.titlebar;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.obric.common.oui.R$color;
import com.obric.common.oui.R$id;
import com.obric.common.oui.R$layout;
import com.obric.common.oui.R$styleable;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tc.f;

/* JADX INFO: loaded from: classes4.dex */
@Deprecated(message = "请使用 OCTitleBar")
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b&\b\u0007\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\r\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u0017R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0017R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u0017R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u0017R\u0018\u0010!\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R\"\u0010)\u001a\u00020\"8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\"\u0010/\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010\u0015R\"\u00103\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b0\u0010+\u001a\u0004\b1\u0010-\"\u0004\b2\u0010\u0015R\"\u00107\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b4\u0010+\u001a\u0004\b5\u0010-\"\u0004\b6\u0010\u0015R\"\u0010;\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b8\u0010+\u001a\u0004\b9\u0010-\"\u0004\b:\u0010\u0015R\u0013\u0010>\u001a\u0004\u0018\u00010\u00168F¢\u0006\u0006\u001a\u0004\b<\u0010=R\u0013\u0010@\u001a\u0004\u0018\u00010\u00168F¢\u0006\u0006\u001a\u0004\b?\u0010=R\u0013\u0010B\u001a\u0004\u0018\u00010\u00168F¢\u0006\u0006\u001a\u0004\bA\u0010=R\u0013\u0010D\u001a\u0004\u0018\u00010\u00168F¢\u0006\u0006\u001a\u0004\bC\u0010=R\u0013\u0010G\u001a\u0004\u0018\u00010\u001e8F¢\u0006\u0006\u001a\u0004\bE\u0010F¨\u0006H"}, d2 = {"Lcom/obric/oui/titlebar/OCompoundTitleBar;", "Lcom/obric/oui/titlebar/OTitleBar;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "", "a", "(Landroid/content/Context;)V", "b", "(Landroid/util/AttributeSet;)V", "", "show", "c", "(Z)V", "color", "setDividerLineBackground", "(I)V", "Landroid/widget/ImageView;", "Landroid/widget/ImageView;", "mStartButton0", "mStartButton1", "d", "mEndButton0", "e", "mEndButton1", "Landroid/view/View;", "f", "Landroid/view/View;", "mLine", "Landroid/widget/FrameLayout;", "g", "Landroid/widget/FrameLayout;", "getMRightAction", "()Landroid/widget/FrameLayout;", "setMRightAction", "(Landroid/widget/FrameLayout;)V", "mRightAction", "h", "I", "getMStart0Color", "()I", "setMStart0Color", "mStart0Color", "i", "getMStart1Color", "setMStart1Color", "mStart1Color", "j", "getMEnd0Color", "setMEnd0Color", "mEnd0Color", "k", "getMEnd1Color", "setMEnd1Color", "mEnd1Color", "getStartButton0", "()Landroid/widget/ImageView;", "startButton0", "getStartButton1", "startButton1", "getEndButton0", "endButton0", "getEndButton1", "endButton1", "getDivider", "()Landroid/view/View;", "divider", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OCompoundTitleBar extends OTitleBar {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ImageView f17394b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ImageView f17395c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ImageView f17396d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ImageView f17397e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View f17398f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public FrameLayout f17399g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f17400h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f17401i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f17402j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f17403k;

    @JvmOverloads
    public OCompoundTitleBar(@NotNull Context r10) {
        q.g(r10, "context");
        AttributeSet r11 = null;
        int r12 = 0;
        this(r10, r11, r12, 6, null);
    }

    private final void a(Context r10) {
        FrameLayout.inflate(r10, R$layout.o_view_compound_title_bar, this);
        this.f17394b = (ImageView) findViewById(R$id.iv_start_0);
        this.f17395c = (ImageView) findViewById(R$id.iv_start_1);
        this.f17396d = (ImageView) findViewById(R$id.iv_end_0);
        this.f17397e = (ImageView) findViewById(R$id.iv_end_1);
        this.f17452a = (TextView) findViewById(R$id.title);
        View r11 = findViewById(R$id.fl_right_container);
        q.f(r11, "findViewById(R.id.fl_right_container)");
        setMRightAction((FrameLayout) r11);
        this.f17398f = findViewById(R$id.line);
    }

    private final void b(AttributeSet r10) {
        TypedArray r11 = getContext().getTheme().obtainStyledAttributes(r10, R$styleable.OCompoundTitleBar, 0, 0);
        setTitle(r11.getString(R$styleable.OCompoundTitleBar_oui_centerText));     // Catch: Throwable -> L6
        setTitleColor(r11.getColor(R$styleable.OCompoundTitleBar_oui_centerTextColor, ContextCompat.b(getContext(), R$color.oui_basic_text_1)));     // Catch: Throwable -> L6
        setTitleSizePixel(r11.getDimension(R$styleable.OCompoundTitleBar_oui_centerTextSize, f.i(17)));     // Catch: Throwable -> L6
        int r12 = r11.getColor(R$styleable.OCompoundTitleBar_oui_dividerColor, ContextCompat.b(getContext(), R$color.oui_basic_text_4));     // Catch: Throwable -> L6
        c(r11.getBoolean(R$styleable.OCompoundTitleBar_oui_dividerVisible, false));     // Catch: Throwable -> L6
        setDividerLineBackground(r12);     // Catch: Throwable -> L6
        r11.recycle();
        return;
    L6:
        th = move-exception;
        r11.recycle();
        throw th;
    }

    public void c(boolean r10) {
        View r11 = this.f17398f;
        if (r11 == null) goto L10;
        if (r10 == false) goto L7;
        int r12 = 0;
    L8:
        r11.setVisibility(r12);
        return;
    L7:
        r12 = 8;
        goto L8
    }

    @Nullable
    public final View getDivider() {
        return this.f17398f;
    }

    @Nullable
    public final ImageView getEndButton0() {
        return this.f17396d;
    }

    @Nullable
    public final ImageView getEndButton1() {
        return this.f17397e;
    }

    public final int getMEnd0Color() {
        return this.f17402j;
    }

    public final int getMEnd1Color() {
        return this.f17403k;
    }

    @NotNull
    public final FrameLayout getMRightAction() {
        FrameLayout r10 = this.f17399g;
        if (r10 == null) goto L5;
        return r10;
    L5:
        q.y("mRightAction");
        return null;
    }

    public final int getMStart0Color() {
        return this.f17400h;
    }

    public final int getMStart1Color() {
        return this.f17401i;
    }

    @Nullable
    public final ImageView getStartButton0() {
        return this.f17394b;
    }

    @Nullable
    public final ImageView getStartButton1() {
        return this.f17395c;
    }

    @Override // com.obric.oui.titlebar.OTitleBar
    public void setDividerLineBackground(int r10) {
        View r11 = this.f17398f;
        if (r11 == null) goto L7;
        r11.setBackgroundColor(r10);
        return;
    }

    public final void setMEnd0Color(int r10) {
        this.f17402j = r10;
    }

    public final void setMEnd1Color(int r10) {
        this.f17403k = r10;
    }

    public final void setMRightAction(@NotNull FrameLayout r10) {
        q.g(r10, "<set-?>");
        this.f17399g = r10;
    }

    public final void setMStart0Color(int r10) {
        this.f17400h = r10;
    }

    public final void setMStart1Color(int r10) {
        this.f17401i = r10;
    }

    @JvmOverloads
    public OCompoundTitleBar(@NotNull Context r10, @Nullable AttributeSet r11) {
        q.g(r10, "context");
        int r12 = 0;
        this(r10, r11, r12, 4, null);
    }

    public /* synthetic */ OCompoundTitleBar(Context r10, AttributeSet r11, int r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r13 & 4) == 0) goto L8;
        r12 = 0;
    L8:
        this(r10, r11, r12);
    }

    @JvmOverloads
    public OCompoundTitleBar(@NotNull Context r10, @Nullable AttributeSet r11, int r12) {
        q.g(r10, "context");
        super(r10, r11, r12);
        a(r10);
        if (r11 == null) goto L6;
        b(r11);
        return;
    }
}
