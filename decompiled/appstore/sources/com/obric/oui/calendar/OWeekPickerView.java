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
import android.widget.LinearLayout;
import androidx.annotation.AttrRes;
import androidx.annotation.StyleRes;
import androidx.appcompat.widget.AppCompatCheckedTextView;
import com.obric.common.oui.R$attr;
import com.obric.common.oui.R$integer;
import com.obric.common.oui.R$string;
import com.obric.common.oui.R$style;
import com.obric.common.oui.R$styleable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.b0;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0002=VB1\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0003\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0003\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0011\u001a\u00020\r2\b\b\u0001\u0010\u0010\u001a\u00020\u0006¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0006¢\u0006\u0004\b\u0014\u0010\u0012J\u0015\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u0006¢\u0006\u0004\b\u0016\u0010\u0012J\u0017\u0010\u0019\u001a\u00020\r2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017¢\u0006\u0004\b\u0019\u0010\u001aJ\u0015\u0010\u001c\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u0006¢\u0006\u0004\b\u001c\u0010\u0012J\u001b\u0010\u001f\u001a\u00020\r2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00060\u001d¢\u0006\u0004\b\u001f\u0010 J\u001b\u0010#\u001a\u00020\r2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020!0\u001d¢\u0006\u0004\b#\u0010 J\u001b\u0010#\u001a\u00020\r2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020!0$¢\u0006\u0004\b#\u0010%J\u001f\u0010(\u001a\u00020\r2\u0006\u0010&\u001a\u00020\u00062\u0006\u0010'\u001a\u00020\u0006H\u0014¢\u0006\u0004\b(\u0010)J!\u0010*\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b*\u0010+J%\u0010-\u001a\b\u0012\u0004\u0012\u00020!0$2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010,\u001a\u00020\u0006H\u0002¢\u0006\u0004\b-\u0010.J\u000f\u0010/\u001a\u00020\rH\u0002¢\u0006\u0004\b/\u00100J\u0017\u00102\u001a\u00020\r2\u0006\u00101\u001a\u00020\u0006H\u0002¢\u0006\u0004\b2\u0010\u0012J\u0017\u00103\u001a\u00020\r2\u0006\u00101\u001a\u00020\u0006H\u0002¢\u0006\u0004\b3\u0010\u0012J\u001d\u00104\u001a\u00020\r2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020!0$H\u0002¢\u0006\u0004\b4\u0010%J\u000f\u00105\u001a\u00020\rH\u0002¢\u0006\u0004\b5\u00100J\u000f\u00106\u001a\u00020\rH\u0002¢\u0006\u0004\b6\u00100J\u0017\u00108\u001a\u00020\r2\u0006\u00107\u001a\u00020\u0006H\u0002¢\u0006\u0004\b8\u0010\u0012J\u0017\u0010;\u001a\u00020\r2\u0006\u0010:\u001a\u000209H\u0002¢\u0006\u0004\b;\u0010<R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b=\u0010>R\u0014\u0010\b\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b;\u0010>R\u0016\u0010@\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u0010?R\u0016\u0010B\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bA\u0010>R\u0016\u0010C\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u0010>R\u0016\u0010D\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010>R\u0016\u0010F\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bE\u0010>R\u0016\u0010G\u001a\u00020\u00068\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b*\u0010>R\u0016\u0010H\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u0010>R\u0016\u0010I\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u0010>R\u0018\u0010K\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u0010JR\u0016\u0010L\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u0010>R\u001c\u0010N\u001a\b\u0012\u0004\u0012\u00020!0$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u0010MR\u001a\u0010R\u001a\b\u0012\u0004\u0012\u0002090O8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bP\u0010QR\u001a\u0010U\u001a\b\u0012\u0004\u0012\u00020S0O8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bT\u0010Q¨\u0006W"}, d2 = {"Lcom/obric/oui/calendar/OWeekPickerView;", "Landroid/widget/LinearLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "Lcom/obric/oui/calendar/PickerSelectionMode;", "mode", "", "setSelectionMode", "(Lcom/obric/oui/calendar/PickerSelectionMode;)V", "resourceId", "setDayTextAppearance", "(I)V", "itemDiameterDp", "setItemSizeDp", "itemPaddingDp", "setItemHorizontalPaddingDp", "Lcom/obric/oui/calendar/OWeekPickerView$OnDaysChangedListener;", "listener", "setOnDaysChangedListener", "(Lcom/obric/oui/calendar/OWeekPickerView$OnDaysChangedListener;)V", "first", "setFirstDayOfWeek", "", "days", "setSelectedDays", "(Ljava/util/List;)V", "", "newLabels", "setLabels", "", "([Ljava/lang/String;)V", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "(II)V", "h", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "startValue", "f", "(Landroid/content/Context;I)[Ljava/lang/String;", "c", "()V", "size", "i", "j", "m", "l", "e", "spacingPx", "k", "Lcom/obric/oui/calendar/OWeekPickerView$a;", "chip", "b", "(Lcom/obric/oui/calendar/OWeekPickerView$a;)V", "a", "I", "Lcom/obric/oui/calendar/PickerSelectionMode;", "selectionMode", "d", "selectedBackgroundColor", "unSelectedBackgroundColor", "selectedTextFontWeight", "g", "unselectedTextFontWeight", "dayTextAppearance", "itemSizePx", "itemHorizontalPaddingPx", "Lcom/obric/oui/calendar/OWeekPickerView$OnDaysChangedListener;", "onDaysChangedListener", "firstDayOfWeek", "[Ljava/lang/String;", "labels", "", "n", "Ljava/util/List;", "chips", "", "o", "selectable", "OnDaysChangedListener", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OWeekPickerView extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f12641a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f12642b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public PickerSelectionMode f12643c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f12644d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f12645e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f12646f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f12647g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f12648h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f12649i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f12650j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public OnDaysChangedListener f12651k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f12652l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String[] f12653m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final List f12654n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final List f12655o;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/obric/oui/calendar/OWeekPickerView$OnDaysChangedListener;", "", "onChanged", "", "selectedDays", "", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface OnDaysChangedListener {
        void onChanged(@NotNull List<Integer> r10);
    }

    public static final class a extends AppCompatCheckedTextView {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f12656e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f12657f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f12658g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f12659h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f12660i;

        public a(Context r10, int r11, int r12) {
            kotlin.jvm.internal.q.g(r10, "context");
            super(r10);
            this.f12656e = r11;
            this.f12657f = r12;
        }

        private final ShapeDrawable b(int r10) {
            ShapeDrawable r11 = new ShapeDrawable(new OvalShape());
            r11.getPaint().setColor(r10);
            return r11;
        }

        private final void c() {
            StateListDrawable r10 = new StateListDrawable();
            r10.addState(new int[]{R.attr.state_checked}, b(this.f12658g));
            r10.addState(new int[]{R.attr.state_pressed}, b(this.f12658g));
            r10.addState(new int[0], b(this.f12659h));
            setBackground(r10);
        }

        public final void a() {
            if (isChecked() == false) goto L5;
            int r10 = this.f12656e;
        L6:
            td.f.a(this, r10);
            return;
        L5:
            r10 = this.f12657f;
            goto L6
        }

        public final void d(int r10, int r11) {
            this.f12658g = r10;
            this.f12659h = r11;
            c();
        }

        public final void e(int r10) {
            this.f12660i = r10;
            requestLayout();
            c();
        }

        @Override // android.widget.TextView, android.view.View
        public void onMeasure(int r10, int r11) {
            super.onMeasure(r10, r11);
            int r12 = this.f12660i;
            setMeasuredDimension(CheckedTextView.resolveSize(r12, r10), CheckedTextView.resolveSize(r12, r11));
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
    public OWeekPickerView(@NotNull Context r10) {
        kotlin.jvm.internal.q.g(r10, "context");
        AttributeSet r11 = null;
        int r12 = 0;
        int r13 = 0;
        this(r10, r11, r12, r13, 14, null);
    }

    public static /* synthetic */ void a(OWeekPickerView r10, int r11, a r12, View r13) {
        d(r10, r11, r12, r13);
    }

    public static final void d(OWeekPickerView r10, int r11, a r12, View r13) {
        kotlin.jvm.internal.q.g(r10, "this$0");
        kotlin.jvm.internal.q.g(r12, "$this_apply");
        if (((Boolean) r10.f12655o.get(r11)).booleanValue() == true) goto L6;
        return;
    L6:
        if (r10.f12643c != PickerSelectionMode.SINGLE) goto L11;
        Iterator r14 = r10.f12654n.iterator();
    L9:
        if (r14.hasNext() == false) goto L12;
        a r15 = (a) r14.next();
        r15.setChecked(kotlin.jvm.internal.q.b(r15, r12));
    L12:
        r10.e();
        return;
    L11:
        r12.toggle();
        goto L12
    }

    public static final String g(Context r10, int r11) {
        switch(r11) {
            case 1: goto L10;
            case 2: goto L9;
            case 3: goto L8;
            case 4: goto L7;
            case 5: goto L6;
            case 6: goto L5;
            case 7: goto L4;
            default: goto L3;
        };
    L3:
        return "";
    L4:
        String r12 = r10.getString(R$string.oui_calendar_day_of_week_sat);
        kotlin.jvm.internal.q.f(r12, "context.getString(R.stri…calendar_day_of_week_sat)");
        return r12;
    L5:
        String r13 = r10.getString(R$string.oui_calendar_day_of_week_fri);
        kotlin.jvm.internal.q.f(r13, "context.getString(R.stri…calendar_day_of_week_fri)");
        return r13;
    L6:
        String r14 = r10.getString(R$string.oui_calendar_day_of_week_thu);
        kotlin.jvm.internal.q.f(r14, "context.getString(R.stri…calendar_day_of_week_thu)");
        return r14;
    L7:
        String r15 = r10.getString(R$string.oui_calendar_day_of_week_wed);
        kotlin.jvm.internal.q.f(r15, "context.getString(R.stri…calendar_day_of_week_wed)");
        return r15;
    L8:
        String r16 = r10.getString(R$string.oui_calendar_day_of_week_tue);
        kotlin.jvm.internal.q.f(r16, "context.getString(R.stri…calendar_day_of_week_tue)");
        return r16;
    L9:
        String r17 = r10.getString(R$string.oui_calendar_day_of_week_mon);
        kotlin.jvm.internal.q.f(r17, "context.getString(R.stri…calendar_day_of_week_mon)");
        return r17;
    L10:
        String r18 = r10.getString(R$string.oui_calendar_day_of_week_sun);
        kotlin.jvm.internal.q.f(r18, "context.getString(R.stri…calendar_day_of_week_sun)");
        return r18;
    }

    public final void b(a r10) {
        if (this.f12648h == 0) goto L6;
        r10.setTextAppearance(getContext(), this.f12648h);
        return;
    }

    public final void c() {
        removeAllViews();
        this.f12654n.clear();
        int r10 = this.f12653m.length;
        final int r11 = 0;
    L3:
        if (r11 >= r10) goto L16;
        int r12 = r11 + 1;
        Context r13 = getContext();
        kotlin.jvm.internal.q.f(r13, "context");
        final a r14 = new a(r13, this.f12646f, this.f12647g);
        r14.setText(this.f12653m[r11]);
        r14.setGravity(17);
        b(r14);
        r14.a();
        r14.setSingleLine(true);
        r14.setTextAlignment(4);
        r14.setClickable(true);
        r14.setFocusable(true);
        if (((Boolean) this.f12655o.get(r11)).booleanValue() == false) goto L7;
        float r15 = 1.0f;
    L8:
        r14.setAlpha(r15);
        r14.e(this.f12649i);
        r14.d(this.f12644d, this.f12645e);
        r14.setChecked(false);
        r14.setOnClickListener(new t(this, r11, r14));
        LinearLayout.LayoutParams r16 = new LinearLayout.LayoutParams(-2, -2);
        int r17 = this.f12650j / 2;
        if (r11 != 0) goto L11;
        int r18 = 0;
    L13:
        if (r11 != kotlin.collections.n.t(this.f12653m)) goto L15;
        r17 = 0;
    L15:
        r16.setMargins(r18, 0, r17, 0);
        r16.gravity = 17;
        addView(r14, r16);
        this.f12654n.add(r14);
        r11 = r12;
        goto L3
    L11:
        r18 = r17;
        goto L13
    L7:
        r15 = 0.45f;
        goto L8
    }

    public final void e() {
        ArrayList r10 = new ArrayList();
        Iterator r11 = this.f12654n.iterator();
        int r12 = 0;
    L4:
        if (r11.hasNext() == false) goto L12;
        Object r13 = r11.next();
        int r14 = r12 + 1;
        if (r12 >= 0) goto L9;
        kotlin.collections.t.q();
    L9:
        if (((a) r13).isChecked() == false) goto L11;
        r10.add(Integer.valueOf(r12));
    L11:
        r12 = r14;
        goto L4
    L12:
        OnDaysChangedListener r15 = this.f12651k;
        if (r15 == null) goto L20;
        r15.onChanged(r10);
        return;
    }

    public final String[] f(Context r10, int r11) {
        String[] r12 = new String[7];
        int r13 = 0;
        int r14 = 0;
    L3:
        if (r14 >= 7) goto L5;
        r12[r14] = "";
        r14 = r14 + 1;
    L5:
        if (r13 >= 7) goto L7;
        r12[r13] = g(r10, r11);
        r11 = (r11 % 7) + 1;
        r13 = r13 + 1;
        goto L5
    L7:
        return r12;
    }

    public final void h(Context r10, AttributeSet r11) {
        TypedArray r12 = r10.obtainStyledAttributes(r11, R$styleable.OWeekPickerView, this.f12641a, this.f12642b);
        kotlin.jvm.internal.q.f(r12, "context.obtainStyledAttr…    defStyleRes\n        )");
        int r13 = R$styleable.OWeekPickerView_o_pv_selectedBackgroundColor;     // Catch: Throwable -> L6
        if (r12.hasValue(r13) == false) goto L8;
        this.f12644d = r12.getColor(r13, this.f12644d);     // Catch: Throwable -> L6
    L8:
        int r14 = R$styleable.OWeekPickerView_o_pv_unSelectedBackgroundColor;     // Catch: Throwable -> L6
        if (r12.hasValue(r14) == false) goto L11;
        this.f12645e = r12.getColor(r14, this.f12645e);     // Catch: Throwable -> L6
    L11:
        int r15 = R$styleable.OWeekPickerView_o_pv_dayTextAppearance;     // Catch: Throwable -> L6
        if (r12.hasValue(r15) == false) goto L14;
        this.f12648h = r12.getResourceId(r15, this.f12648h);     // Catch: Throwable -> L6
    L14:
        int r16 = R$styleable.OWeekPickerView_o_pv_selectionMode;     // Catch: Throwable -> L6
        if (r12.hasValue(r16) == false) goto L21;
        int r17 = r12.getInt(r16, this.f12643c.ordinal());     // Catch: Throwable -> L6
        PickerSelectionMode r18 = PickerSelectionMode.SINGLE;     // Catch: Throwable -> L6
        if (r17 == r18.ordinal()) goto L20;
        r18 = PickerSelectionMode.MULTIPLE;     // Catch: Throwable -> L6
    L20:
        this.f12643c = r18;     // Catch: Throwable -> L6
    L21:
        int r19 = R$styleable.OWeekPickerView_o_pv_itemSize;     // Catch: Throwable -> L6
        if (r12.hasValue(r19) == false) goto L24;
        this.f12649i = r12.getDimensionPixelSize(r19, this.f12649i);     // Catch: Throwable -> L6
    L24:
        int r20 = R$styleable.OWeekPickerView_o_pv_itemHPadding;     // Catch: Throwable -> L6
        if (r12.hasValue(r20) == false) goto L27;
        this.f12650j = r12.getDimensionPixelSize(r20, this.f12650j);     // Catch: Throwable -> L6
    L27:
        int r21 = R$styleable.OWeekPickerView_o_wpv_firstDayOfWeek;     // Catch: Throwable -> L6
        if (r12.hasValue(r21) == false) goto L30;
        this.f12652l = r12.getInt(r21, this.f12652l);     // Catch: Throwable -> L6
    L30:
        r12.recycle();
        return;
    L6:
        th = move-exception;
        r12.recycle();
        throw th;
    }

    public final void i(int r10) {
        this.f12655o.clear();
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L5;
        this.f12655o.add(Boolean.TRUE);
        r11 = r11 + 1;
        goto L3
    }

    public final void j(int r10) {
        List r11 = b0.x0(this.f12655o);
        this.f12655o.clear();
        int r12 = 0;
    L3:
        if (r12 >= r10) goto L9;
        List r13 = this.f12655o;
        Boolean r14 = (Boolean) b0.a0(r11, r12);
        if (r14 != null) goto L7;
        boolean r15 = true;
    L8:
        r13.add(Boolean.valueOf(r15));
        r12 = r12 + 1;
        goto L3
    L7:
        r15 = r14.booleanValue();
        goto L8
    }

    public final void k(int r10) {
        int r11 = r10 / 2;
        int r12 = getChildCount();
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L21;
        int r14 = r13 + 1;
        View r15 = getChildAt(r13);
        if (r15 == null) goto L18;
        ViewGroup.LayoutParams r16 = r15.getLayoutParams();
        if (r16 == null) goto L20;
        LinearLayout.LayoutParams r17 = (LinearLayout.LayoutParams) r16;
        if (r13 != 0) goto L12;
        int r18 = 0;
    L14:
        if (r13 != (getChildCount() - 1)) goto L16;
        int r19 = 0;
    L17:
        r17.setMargins(r18, 0, r19, 0);
        r15.setLayoutParams(r17);
        goto L18
    L16:
        r19 = r11;
        goto L17
    L12:
        r18 = r11;
        goto L14
    L20:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
    L18:
        r13 = r14;
        goto L3
    }

    public final void l() {
        Iterator r10 = this.f12654n.iterator();
        int r11 = 0;
    L4:
        if (r10.hasNext() == false) goto L9;
        Object r12 = r10.next();
        int r13 = r11 + 1;
        if (r11 >= 0) goto L8;
        kotlin.collections.t.q();
    L8:
        ((a) r12).setText(this.f12653m[r11]);
        r11 = r13;
        goto L4
    }

    public final void m(String[] r10) {
        List r11 = this.f12654n;
        ArrayList r12 = new ArrayList();
        Iterator r13 = r11.iterator();
        boolean r14 = false;
        int r15 = 0;
    L4:
        if (r13.hasNext() == false) goto L16;
        Object r16 = r13.next();
        int r17 = r15 + 1;
        if (r15 >= 0) goto L9;
        kotlin.collections.t.q();
    L9:
        if (((a) r16).isChecked() == false) goto L11;
        Integer r18 = Integer.valueOf(r15);
    L12:
        if (r18 == null) goto L14;
        r12.add(r18);
    L14:
        r15 = r17;
        goto L4
    L11:
        r18 = null;
        goto L12
    L16:
        if (r10.length == getChildCount()) goto L18;
        r14 = true;
    L18:
        Object[] r19 = Arrays.copyOf(r10, r10.length);
        kotlin.jvm.internal.q.f(r19, "copyOf(this, size)");
        String[] r20 = (String[]) r19;
        this.f12653m = r20;
        if (r14 == false) goto L21;
        j(r20.length);
        c();
    L22:
        ArrayList r21 = new ArrayList();
        Iterator r22 = r12.iterator();
    L24:
        if (r22.hasNext() == false) goto L30;
        Object r23 = r22.next();
        int r24 = ((Number) r23).intValue();
        if (r24 < 0) goto L24;
        if (r24 >= this.f12653m.length) goto L24;
        r21.add(r23);
        goto L24
    L30:
        setSelectedDays(r21);
        requestLayout();
        return;
    L21:
        l();
        goto L22
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int r10, int r11) {
        int r12 = View.MeasureSpec.getSize(r10);
        int r13 = View.MeasureSpec.getMode(r10);
        int r14 = this.f12650j;
        if (r13 == 0) goto L12;
        if (r12 <= 0) goto L12;
        int r15 = (r12 - getPaddingLeft()) - getPaddingRight();
        int r16 = getChildCount();
        int r17 = bg.h.d(r16 - 1, 0);
        int r18 = this.f12649i;
        if (((r16 * r18) + (this.f12650j * r17)) <= r15) goto L12;
        int r19 = r15 - (r16 * r18);
        if (r19 <= 0) goto L11;
        if (r17 <= 0) goto L11;
        r14 = r19 / r17;
    L11:
        r14 = 0;
    L12:
        k(r14);
        super.onMeasure(r10, r11);
    }

    public final void setDayTextAppearance(@StyleRes int r10) {
        if (r10 != 0) goto L4;
        return;
    L4:
        this.f12648h = r10;
        Iterator r11 = this.f12654n.iterator();
    L6:
        if (r11.hasNext() == false) goto L8;
        a r12 = (a) r11.next();
        b(r12);
        r12.a();
        goto L6
    }

    public final void setFirstDayOfWeek(int r10) {
        this.f12652l = r10;
        Context r11 = getContext();
        kotlin.jvm.internal.q.f(r11, "context");
        m(f(r11, this.f12652l));
    }

    public final void setItemHorizontalPaddingDp(int r10) {
        int r11 = tc.f.r(this, r10);
        this.f12650j = r11;
        k(r11);
    }

    public final void setItemSizeDp(int r10) {
        this.f12649i = tc.f.r(this, r10);
        Iterator r11 = this.f12654n.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        ((a) r11.next()).e(this.f12649i);
        goto L4
    L6:
        requestLayout();
    }

    public final void setLabels(@NotNull List<String> r10) {
        kotlin.jvm.internal.q.g(r10, "newLabels");
        if (r10.isEmpty() == false) goto L5;
        return;
    L5:
        Object[] r11 = r10.toArray(new String[0]);
        if (r11 == null) goto L10;
        m((String[]) r11);
        return;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    }

    public final void setOnDaysChangedListener(@Nullable OnDaysChangedListener r10) {
        this.f12651k = r10;
    }

    public final void setSelectedDays(@NotNull List<Integer> r10) {
        kotlin.jvm.internal.q.g(r10, "days");
        int r11 = 0;
        if (this.f12643c != PickerSelectionMode.SINGLE) goto L18;
        Integer r12 = (Integer) b0.Z(r10);
        Iterator r13 = this.f12654n.iterator();
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
        Iterator r19 = this.f12654n.iterator();
    L20:
        if (r19.hasNext() == false) goto L25;
        Object r20 = r19.next();
        int r21 = r11 + 1;
        if (r11 >= 0) goto L24;
        kotlin.collections.t.q();
    L24:
        ((a) r20).setChecked(r10.contains(Integer.valueOf(r11)));
        r11 = r21;
        goto L20
    }

    public final void setSelectionMode(@NotNull PickerSelectionMode r10) {
        kotlin.jvm.internal.q.g(r10, "mode");
        this.f12643c = r10;
        if (r10 != PickerSelectionMode.SINGLE) goto L31;
        Iterator r11 = this.f12654n.iterator();
        int r12 = 0;
    L6:
        if (r11.hasNext() == false) goto L11;
        if (((a) r11.next()).isChecked() == true) goto L12;
        r12 = r12 + 1;
    L12:
        Iterator r13 = this.f12654n.iterator();
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
    public OWeekPickerView(@NotNull Context r10, @Nullable AttributeSet r11) {
        kotlin.jvm.internal.q.g(r10, "context");
        int r12 = 0;
        int r13 = 0;
        this(r10, r11, r12, r13, 12, null);
    }

    @JvmOverloads
    public OWeekPickerView(@NotNull Context r10, @Nullable AttributeSet r11, @AttrRes int r12) {
        kotlin.jvm.internal.q.g(r10, "context");
        int r13 = 0;
        this(r10, r11, r12, r13, 8, null);
    }

    public /* synthetic */ OWeekPickerView(Context r10, AttributeSet r11, int r12, int r13, int r14, DefaultConstructorMarker r15) {
        if ((r14 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r14 & 4) == 0) goto L9;
        r12 = R$attr.oweekPickerViewStyle;
    L9:
        if ((r14 & 8) == 0) goto L11;
        r13 = R$style.OStyleV2_OWeekPickerView_DayNight;
    L11:
        this(r10, r11, r12, r13);
    }

    public final void setLabels(@NotNull String[] r10) {
        kotlin.jvm.internal.q.g(r10, "newLabels");
        setLabels(kotlin.collections.n.K(r10));
    }

    public OWeekPickerView(Context r10, AttributeSet r11, int r12, int r13) {
        kotlin.jvm.internal.q.g(r10, "context");
        super(r10, r11, r12);
        this.f12641a = r12;
        this.f12642b = r13;
        this.f12643c = PickerSelectionMode.MULTIPLE;
        this.f12646f = getResources().getInteger(R$integer.oui_font_weight_bold);
        this.f12647g = getResources().getInteger(R$integer.oui_font_weight_regular);
        this.f12652l = 2;
        this.f12653m = f(r10, 2);
        this.f12654n = new ArrayList();
        this.f12655o = new ArrayList();
        h(r10, r11);
        String[] r14 = f(r10, this.f12652l);
        this.f12653m = r14;
        i(r14.length);
        setOrientation(0);
        setGravity(17);
        c();
    }
}
