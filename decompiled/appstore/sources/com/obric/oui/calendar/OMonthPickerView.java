package com.obric.oui.calendar;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.StateListDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import androidx.annotation.AttrRes;
import androidx.annotation.StyleRes;
import androidx.appcompat.widget.AppCompatCheckedTextView;
import com.google.common.primitives.Ints;
import com.obric.common.oui.R$attr;
import com.obric.common.oui.R$integer;
import com.obric.common.oui.R$style;
import com.obric.common.oui.R$styleable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.b0;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0010!\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0002KeB1\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0003\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0003\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ!\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0012\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0013\u0010\u0011J\u000f\u0010\u0014\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0014\u0010\u000fJ\u0015\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0019\u0010\u0011J\u000f\u0010\u001a\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u001a\u0010\u000fJ\u0017\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u001bH\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u001f\u0010!\u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u0006H\u0014¢\u0006\u0004\b!\u0010\"J7\u0010)\u001a\u00020\u000b2\u0006\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020\u00062\u0006\u0010&\u001a\u00020\u00062\u0006\u0010'\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\u0006H\u0014¢\u0006\u0004\b)\u0010*J\u0015\u0010-\u001a\u00020\u000b2\u0006\u0010,\u001a\u00020+¢\u0006\u0004\b-\u0010.J\r\u0010/\u001a\u00020+¢\u0006\u0004\b/\u00100J\u0015\u00102\u001a\u00020\u000b2\u0006\u00101\u001a\u00020\u0006¢\u0006\u0004\b2\u00103J\r\u00104\u001a\u00020\u0006¢\u0006\u0004\b4\u0010\u0011J\u001b\u00106\u001a\u00020\u000b2\f\u00105\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015¢\u0006\u0004\b6\u00107J\u001b\u00106\u001a\u00020\u000b2\f\u00105\u001a\b\u0012\u0004\u0012\u00020\u001608¢\u0006\u0004\b6\u00109J\u0013\u0010:\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015¢\u0006\u0004\b:\u0010\u0018J\u001b\u0010<\u001a\u00020\u000b2\f\u0010;\u001a\b\u0012\u0004\u0012\u00020\u00060\u0015¢\u0006\u0004\b<\u00107J\u0013\u0010=\u001a\b\u0012\u0004\u0012\u00020\u00060\u0015¢\u0006\u0004\b=\u0010\u0018J\u0017\u0010@\u001a\u00020\u000b2\b\u0010?\u001a\u0004\u0018\u00010>¢\u0006\u0004\b@\u0010AJ\u0017\u0010C\u001a\u00020\u000b2\b\b\u0001\u0010B\u001a\u00020\u0006¢\u0006\u0004\bC\u00103J\u0015\u0010E\u001a\u00020\u000b2\u0006\u0010D\u001a\u00020\u0006¢\u0006\u0004\bE\u00103J\u0015\u0010G\u001a\u00020\u000b2\u0006\u0010F\u001a\u00020\u0006¢\u0006\u0004\bG\u00103J\u001d\u0010J\u001a\u00020\u000b2\u0006\u0010H\u001a\u00020\u00062\u0006\u0010I\u001a\u00020\u0006¢\u0006\u0004\bJ\u0010\"R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bK\u0010LR\u0014\u0010\b\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010LR\u0016\u0010N\u001a\u00020+8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010MR\u0016\u0010P\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bO\u0010LR\u001c\u0010R\u001a\b\u0012\u0004\u0012\u00020\u00160\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010QR\u0016\u0010S\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010LR\u0016\u0010T\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010LR\u0016\u0010U\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bJ\u0010LR\u0016\u0010V\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010LR\u0016\u0010X\u001a\u00020\u00068\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bW\u0010LR\u0016\u0010Z\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bY\u0010LR\u0016\u0010\\\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b[\u0010LR\u0016\u0010^\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b]\u0010LR\u0018\u0010a\u001a\u0004\u0018\u00010>8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b_\u0010`R\u001a\u0010d\u001a\b\u0012\u0004\u0012\u00020\u001b0b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bc\u0010Q¨\u0006f"}, d2 = {"Lcom/obric/oui/calendar/OMonthPickerView;", "Landroid/view/ViewGroup;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "", "g", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "c", "()V", "getRowCount", "()I", "getFullRowWidth", "getContentHeight", "e", "", "", "f", "()Ljava/util/List;", "getDayCount", "i", "Lcom/obric/oui/calendar/OMonthPickerView$a;", "chip", "b", "(Lcom/obric/oui/calendar/OMonthPickerView$a;)V", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "(II)V", "", "changed", "left", "top", "right", "bottom", "onLayout", "(ZIIII)V", "Lcom/obric/oui/calendar/PickerSelectionMode;", "mode", "setSelectionMode", "(Lcom/obric/oui/calendar/PickerSelectionMode;)V", "getSelectionMode", "()Lcom/obric/oui/calendar/PickerSelectionMode;", "count", "setColumnCount", "(I)V", "getColumnCount", "newLabels", "setLabels", "(Ljava/util/List;)V", "", "([Ljava/lang/String;)V", "getLabels", "days", "setSelectedDays", "getSelectedDays", "Lcom/obric/oui/calendar/OMonthPickerView$OnDaysChangedListener;", "listener", "setOnDaysChangedListener", "(Lcom/obric/oui/calendar/OMonthPickerView$OnDaysChangedListener;)V", "resourceId", "setDayTextAppearance", "itemDiameterDp", "setItemDiameterDp", "itemPaddingDp", "setItemPaddingDp", "itemHorizontalPaddingDp", "itemVerticalPaddingDp", "h", "a", "I", "Lcom/obric/oui/calendar/PickerSelectionMode;", "selectionMode", "d", "columnCount", "Ljava/util/List;", "labels", "selectedBackgroundColor", "unSelectedBackgroundColor", "selectedTextFontWeight", "unselectedTextFontWeight", "j", "dayTextAppearance", "k", "itemSizePx", "l", "itemHorizontalPaddingPx", "m", "itemVerticalPaddingPx", "n", "Lcom/obric/oui/calendar/OMonthPickerView$OnDaysChangedListener;", "onDaysChangedListener", "", "o", "chips", "OnDaysChangedListener", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OMonthPickerView extends ViewGroup {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f12621a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f12622b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public PickerSelectionMode f12623c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f12624d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public List f12625e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f12626f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f12627g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f12628h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f12629i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f12630j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f12631k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f12632l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f12633m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public OnDaysChangedListener f12634n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final List f12635o;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/obric/oui/calendar/OMonthPickerView$OnDaysChangedListener;", "", "onChanged", "", "selectedDays", "", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface OnDaysChangedListener {
        void onChanged(@NotNull List<Integer> r10);
    }

    public static final class a extends AppCompatCheckedTextView {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f12636e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f12637f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f12638g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f12639h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f12640i;

        public a(Context r10, int r11, int r12) {
            kotlin.jvm.internal.q.g(r10, "context");
            super(r10);
            this.f12636e = r11;
            this.f12637f = r12;
        }

        private final void c() {
            StateListDrawable r10 = new StateListDrawable();
            r10.addState(new int[]{R.attr.state_checked}, b(this.f12638g));
            r10.addState(new int[]{R.attr.state_pressed}, b(this.f12638g));
            r10.addState(new int[0], b(this.f12639h));
            setBackground(r10);
        }

        public final void a() {
            if (isChecked() == false) goto L5;
            int r10 = this.f12636e;
        L6:
            td.f.a(this, r10);
            return;
        L5:
            r10 = this.f12637f;
            goto L6
        }

        public final ShapeDrawable b(int r10) {
            ShapeDrawable r11 = new ShapeDrawable(new OvalShape());
            r11.getPaint().setColor(r10);
            return r11;
        }

        public final void d(int r10, int r11) {
            this.f12638g = r10;
            this.f12639h = r11;
            c();
        }

        public final void e(int r10) {
            this.f12640i = r10;
            requestLayout();
            c();
        }

        @Override // android.widget.TextView, android.view.View
        public void onMeasure(int r10, int r11) {
            super.onMeasure(r10, r11);
            setMeasuredDimension(CheckedTextView.resolveSize(this.f12640i, r10), CheckedTextView.resolveSize(this.f12640i, r11));
        }

        @Override // android.widget.CheckedTextView, android.widget.Checkable
        public void setChecked(boolean r10) {
            if (isChecked() == r10) goto L5;
            boolean r11 = true;
        L6:
            super.setChecked(r10);
            if (r11 == false) goto L10;
            a();
            return;
        L10:
            return;
        L5:
            r11 = false;
            goto L6
        }
    }

    @JvmOverloads
    public OMonthPickerView(@NotNull Context r10) {
        kotlin.jvm.internal.q.g(r10, "context");
        AttributeSet r11 = null;
        int r12 = 0;
        int r13 = 0;
        this(r10, r11, r12, r13, 14, null);
    }

    public static /* synthetic */ void a(OMonthPickerView r10, a r11, View r12) {
        d(r10, r11, r12);
    }

    public static final void d(OMonthPickerView r10, a r11, View r12) {
        kotlin.jvm.internal.q.g(r10, "this$0");
        kotlin.jvm.internal.q.g(r11, "$this_apply");
        if (r10.f12623c != PickerSelectionMode.SINGLE) goto L8;
        Iterator r13 = r10.f12635o.iterator();
    L6:
        if (r13.hasNext() == false) goto L9;
        a r14 = (a) r13.next();
        r14.setChecked(kotlin.jvm.internal.q.b(r14, r11));
    L9:
        r10.e();
        return;
    L8:
        r11.toggle();
        goto L9
    }

    private final int getContentHeight() {
        return (getRowCount() * this.f12631k) + ((getRowCount() - 1) * this.f12633m);
    }

    private final int getDayCount() {
        return this.f12625e.size();
    }

    private final int getFullRowWidth() {
        int r10 = this.f12624d;
        return (this.f12631k * r10) + ((r10 - 1) * this.f12632l);
    }

    private final int getRowCount() {
        int r10 = getDayCount();
        int r11 = this.f12624d;
        return ((r10 + r11) - 1) / r11;
    }

    public final void b(a r10) {
        if (this.f12630j == 0) goto L6;
        r10.setTextAppearance(getContext(), this.f12630j);
        return;
    }

    public final void c() {
        removeAllViews();
        this.f12635o.clear();
        Iterator r10 = this.f12625e.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        String r11 = (String) r10.next();
        Context r12 = getContext();
        kotlin.jvm.internal.q.f(r12, "context");
        final a r13 = new a(r12, this.f12628h, this.f12629i);
        r13.setText(r11);
        r13.setGravity(17);
        b(r13);
        r13.a();
        r13.setIncludeFontPadding(false);
        r13.setSingleLine(true);
        r13.setTextAlignment(4);
        r13.setClickable(true);
        r13.setFocusable(true);
        r13.e(this.f12631k);
        r13.d(this.f12626f, this.f12627g);
        r13.setOnClickListener(new s(this, r13));
        int r14 = this.f12631k;
        addView(r13, new ViewGroup.LayoutParams(r14, r14));
        this.f12635o.add(r13);
        goto L4
    }

    public final void e() {
        OnDaysChangedListener r10 = this.f12634n;
        if (r10 == null) goto L7;
        r10.onChanged(getSelectedDays());
        return;
    }

    public final List f() {
        ArrayList r10 = new ArrayList(31);
        int r11 = 0;
    L3:
        if (r11 >= 31) goto L5;
        r11 = r11 + 1;
        r10.add(String.valueOf(r11));
        goto L3
    L5:
        return r10;
    }

    public final void g(Context r10, AttributeSet r11) {
        TypedArray r12 = r10.obtainStyledAttributes(r11, R$styleable.OMonthPickerView, this.f12621a, this.f12622b);
        kotlin.jvm.internal.q.f(r12, "context.obtainStyledAttr…    defStyleRes\n        )");
        int r13 = R$styleable.OMonthPickerView_o_pv_selectedBackgroundColor;     // Catch: Throwable -> L6
        if (r12.hasValue(r13) == false) goto L8;
        this.f12626f = r12.getColor(r13, this.f12626f);     // Catch: Throwable -> L6
    L8:
        int r14 = R$styleable.OMonthPickerView_o_pv_unSelectedBackgroundColor;     // Catch: Throwable -> L6
        if (r12.hasValue(r14) == false) goto L11;
        this.f12627g = r12.getColor(r14, this.f12627g);     // Catch: Throwable -> L6
    L11:
        int r15 = R$styleable.OMonthPickerView_o_pv_dayTextAppearance;     // Catch: Throwable -> L6
        if (r12.hasValue(r15) == false) goto L14;
        this.f12630j = r12.getResourceId(r15, this.f12630j);     // Catch: Throwable -> L6
    L14:
        int r16 = R$styleable.OMonthPickerView_o_pv_selectionMode;     // Catch: Throwable -> L6
        if (r12.hasValue(r16) == false) goto L21;
        int r17 = r12.getInt(r16, this.f12623c.ordinal());     // Catch: Throwable -> L6
        PickerSelectionMode r18 = PickerSelectionMode.SINGLE;     // Catch: Throwable -> L6
        if (r17 == r18.ordinal()) goto L20;
        r18 = PickerSelectionMode.MULTIPLE;     // Catch: Throwable -> L6
    L20:
        this.f12623c = r18;     // Catch: Throwable -> L6
    L21:
        int r19 = R$styleable.OMonthPickerView_o_mpv_columnCount;     // Catch: Throwable -> L6
        if (r12.hasValue(r19) == false) goto L24;
        this.f12624d = bg.h.d(r12.getInt(r19, this.f12624d), 1);     // Catch: Throwable -> L6
    L24:
        int r20 = R$styleable.OMonthPickerView_o_pv_itemSize;     // Catch: Throwable -> L6
        if (r12.hasValue(r20) == false) goto L27;
        this.f12631k = r12.getDimensionPixelSize(r20, this.f12631k);     // Catch: Throwable -> L6
    L27:
        int r21 = R$styleable.OMonthPickerView_o_pv_itemHPadding;     // Catch: Throwable -> L6
        if (r12.hasValue(r21) == false) goto L30;
        this.f12632l = r12.getDimensionPixelSize(r21, this.f12632l);     // Catch: Throwable -> L6
    L30:
        int r22 = R$styleable.OMonthPickerView_o_pv_itemVPadding;     // Catch: Throwable -> L6
        if (r12.hasValue(r22) == false) goto L33;
        this.f12633m = r12.getDimensionPixelSize(r22, this.f12633m);     // Catch: Throwable -> L6
    L33:
        r12.recycle();
        return;
    L6:
        th = move-exception;
        r12.recycle();
        throw th;
    }

    public final int getColumnCount() {
        return this.f12624d;
    }

    @NotNull
    public final List<String> getLabels() {
        return b0.x0(this.f12625e);
    }

    @NotNull
    public final List<Integer> getSelectedDays() {
        List r10 = this.f12635o;
        ArrayList r11 = new ArrayList();
        Iterator r12 = r10.iterator();
        int r13 = 0;
    L4:
        if (r12.hasNext() == false) goto L15;
        Object r14 = r12.next();
        int r15 = r13 + 1;
        if (r13 >= 0) goto L9;
        kotlin.collections.t.q();
    L9:
        if (((a) r14).isChecked() == false) goto L11;
        Integer r16 = Integer.valueOf(r13);
    L12:
        if (r16 == null) goto L14;
        r11.add(r16);
    L14:
        r13 = r15;
        goto L4
    L11:
        r16 = null;
        goto L12
    L15:
        return r11;
    }

    @NotNull
    public final PickerSelectionMode getSelectionMode() {
        return this.f12623c;
    }

    public final void h(int r10, int r11) {
        this.f12632l = tc.f.r(this, r10);
        this.f12633m = tc.f.r(this, r11);
        requestLayout();
    }

    public final void i() {
        Iterator r10 = this.f12635o.iterator();
        int r11 = 0;
    L4:
        if (r10.hasNext() == false) goto L9;
        Object r12 = r10.next();
        int r13 = r11 + 1;
        if (r11 >= 0) goto L8;
        kotlin.collections.t.q();
    L8:
        ((a) r12).setText((CharSequence) this.f12625e.get(r11));
        r11 = r13;
        goto L4
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
        int r15 = r13 - r11;
        int r16 = (r15 - getPaddingLeft()) - getPaddingRight();
        int r17 = getFullRowWidth();
        int r18 = (r16 - r17) / 2;
        int r19 = 0;
        int r20 = getPaddingLeft() + bg.h.d(r18, 0);
        int r110 = (r15 - getPaddingRight()) - bg.h.d(r18, 0);
        int r21 = getChildCount();
    L3:
        if (r19 >= r21) goto L9;
        int r111 = r19 + 1;
        View r22 = getChildAt(r19);
        int r23 = this.f12624d;
        int r24 = r19 / r23;
        int r25 = r19 % r23;
        int r26 = getPaddingTop() + (r24 * (this.f12631k + this.f12633m));
        if (g.a() == false) goto L7;
        int r27 = this.f12631k;
        int r28 = r110 - (r25 * (this.f12632l + r27));
        int r29 = r28 - r27;
    L8:
        r22.layout(r29, r26, r28, this.f12631k + r26);
        r19 = r111;
        goto L3
    L7:
        int r30 = this.f12631k;
        int r31 = (r25 * (this.f12632l + r30)) + r20;
        int r32 = r30 + r31;
        r29 = r31;
        r28 = r32;
        goto L8
    }

    @Override // android.view.View
    public void onMeasure(int r10, int r11) {
        int r12 = View.MeasureSpec.getSize(r10);
        int r13 = 0;
        if (View.MeasureSpec.getMode(r10) == 0) goto L14;
        if (r12 <= 0) goto L14;
        int r14 = (r12 - getPaddingLeft()) - getPaddingRight();
        int r15 = this.f12624d;
        int r16 = this.f12631k;
        if (((r15 * r16) + ((r15 - 1) * this.f12632l)) <= r14) goto L14;
        int r17 = r14 - (r16 * r15);
        if (r17 > 0) goto L10;
    L12:
        int r18 = 0;
    L13:
        this.f12632l = r18;
        goto L14
    L10:
        if (r15 <= 1) goto L12;
        r18 = r17 / (r15 - 1);
    L14:
        setMeasuredDimension(ViewGroup.resolveSize((getPaddingLeft() + getFullRowWidth()) + getPaddingRight(), r10), ViewGroup.resolveSize((getPaddingTop() + getContentHeight()) + getPaddingBottom(), r11));
        int r19 = View.MeasureSpec.makeMeasureSpec(this.f12631k, Ints.MAX_POWER_OF_TWO);
        int r20 = getChildCount();
    L15:
        if (r13 >= r20) goto L17;
        getChildAt(r13).measure(r19, r19);
        r13 = r13 + 1;
        goto L15
    }

    public final void setColumnCount(int r10) {
        int r11 = bg.h.d(r10, 1);
        if (this.f12624d != r11) goto L5;
        return;
    L5:
        this.f12624d = r11;
        requestLayout();
    }

    public final void setDayTextAppearance(@StyleRes int r10) {
        if (r10 != 0) goto L4;
        return;
    L4:
        this.f12630j = r10;
        Iterator r11 = this.f12635o.iterator();
    L6:
        if (r11.hasNext() == false) goto L8;
        a r12 = (a) r11.next();
        b(r12);
        r12.a();
        r12.setIncludeFontPadding(false);
        goto L6
    }

    public final void setItemDiameterDp(int r10) {
        this.f12631k = tc.f.r(this, r10);
        Iterator r11 = this.f12635o.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        ((a) r11.next()).e(this.f12631k);
        goto L4
    L6:
        requestLayout();
    }

    public final void setItemPaddingDp(int r10) {
        h(r10, r10);
    }

    public final void setLabels(@NotNull List<String> r10) {
        kotlin.jvm.internal.q.g(r10, "newLabels");
        if (r10.isEmpty() == false) goto L5;
        return;
    L5:
        List<Integer> r11 = getSelectedDays();
        if (r10.size() == getChildCount()) goto L8;
        boolean r12 = true;
    L9:
        this.f12625e = b0.x0(r10);
        if (r12 == false) goto L12;
        c();
    L13:
        ArrayList r13 = new ArrayList();
        Iterator<T> r14 = r11.iterator();
    L15:
        if (r14.hasNext() == false) goto L21;
        Object r15 = r14.next();
        int r16 = ((Number) r15).intValue();
        if (r16 < 0) goto L15;
        if (r16 >= this.f12625e.size()) goto L15;
        r13.add(r15);
        goto L15
    L21:
        setSelectedDays(r13);
        requestLayout();
        return;
    L12:
        i();
        goto L13
    L8:
        r12 = false;
        goto L9
    }

    public final void setOnDaysChangedListener(@Nullable OnDaysChangedListener r10) {
        this.f12634n = r10;
    }

    public final void setSelectedDays(@NotNull List<Integer> r10) {
        kotlin.jvm.internal.q.g(r10, "days");
        int r11 = 0;
        if (this.f12623c != PickerSelectionMode.SINGLE) goto L18;
        Integer r12 = (Integer) b0.Z(r10);
        Iterator r13 = this.f12635o.iterator();
        int r14 = 0;
    L6:
        if (r13.hasNext() == false) goto L25;
        Object r15 = r13.next();
        int r16 = r14 + 1;
        if (r14 >= 0) goto L10;
        kotlin.collections.t.q();
    L10:
        a r17 = (a) r15;
        if (r12 != null) goto L14;
    L16:
        boolean r18 = false;
    L17:
        r17.setChecked(r18);
        r14 = r16;
        goto L6
    L14:
        if (r14 != r12.intValue()) goto L16;
        r18 = true;
    L25:
        e();
        return;
    L18:
        Set r19 = b0.B0(r10);
        Iterator r20 = this.f12635o.iterator();
    L20:
        if (r20.hasNext() == false) goto L25;
        Object r21 = r20.next();
        int r22 = r11 + 1;
        if (r11 >= 0) goto L24;
        kotlin.collections.t.q();
    L24:
        ((a) r21).setChecked(r19.contains(Integer.valueOf(r11)));
        r11 = r22;
        goto L20
    }

    public final void setSelectionMode(@NotNull PickerSelectionMode r10) {
        kotlin.jvm.internal.q.g(r10, "mode");
        this.f12623c = r10;
        if (r10 != PickerSelectionMode.SINGLE) goto L31;
        Iterator r11 = this.f12635o.iterator();
        int r12 = 0;
    L6:
        if (r11.hasNext() == false) goto L11;
        if (((a) r11.next()).isChecked() == true) goto L12;
        r12 = r12 + 1;
    L12:
        Iterator r13 = this.f12635o.iterator();
        int r14 = 0;
    L14:
        if (r13.hasNext() == false) goto L24;
        Object r15 = r13.next();
        int r16 = r14 + 1;
        if (r14 >= 0) goto L18;
        kotlin.collections.t.q();
    L18:
        a r17 = (a) r15;
        if (r14 != r12) goto L22;
        if (r12 < 0) goto L22;
        boolean r18 = true;
    L23:
        r17.setChecked(r18);
        r14 = r16;
    L22:
        r18 = false;
        goto L23
    L24:
        e();
        return;
    L11:
        r12 = -1;
        goto L12
    }

    @JvmOverloads
    public OMonthPickerView(@NotNull Context r10, @Nullable AttributeSet r11) {
        kotlin.jvm.internal.q.g(r10, "context");
        int r12 = 0;
        int r13 = 0;
        this(r10, r11, r12, r13, 12, null);
    }

    @JvmOverloads
    public OMonthPickerView(@NotNull Context r10, @Nullable AttributeSet r11, @AttrRes int r12) {
        kotlin.jvm.internal.q.g(r10, "context");
        int r13 = 0;
        this(r10, r11, r12, r13, 8, null);
    }

    public /* synthetic */ OMonthPickerView(Context r10, AttributeSet r11, int r12, int r13, int r14, DefaultConstructorMarker r15) {
        if ((r14 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r14 & 4) == 0) goto L9;
        r12 = R$attr.omonthPickerViewStyle;
    L9:
        if ((r14 & 8) == 0) goto L11;
        r13 = R$style.OStyleV2_OMonthPickerView_DayNight;
    L11:
        this(r10, r11, r12, r13);
    }

    public OMonthPickerView(Context r10, AttributeSet r11, int r12, int r13) {
        kotlin.jvm.internal.q.g(r10, "context");
        super(r10, r11, r12);
        this.f12621a = r12;
        this.f12622b = r13;
        this.f12623c = PickerSelectionMode.MULTIPLE;
        this.f12624d = 1;
        this.f12625e = f();
        this.f12628h = getResources().getInteger(R$integer.oui_font_weight_bold);
        this.f12629i = getResources().getInteger(R$integer.oui_font_weight_regular);
        this.f12635o = new ArrayList();
        g(r10, r11);
        setClipChildren(false);
        setClipToPadding(false);
        c();
    }

    public final void setLabels(@NotNull String[] r10) {
        kotlin.jvm.internal.q.g(r10, "newLabels");
        setLabels(kotlin.collections.n.K(r10));
    }
}
