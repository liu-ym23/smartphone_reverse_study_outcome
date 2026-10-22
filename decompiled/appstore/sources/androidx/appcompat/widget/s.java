package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.annotation.DoNotInline;
import androidx.appcompat.R$attr;
import androidx.core.os.BuildCompat;
import com.google.common.primitives.Ints;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public class s extends ListView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Rect f1088a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f1089b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f1090c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f1091d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f1092e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f1093f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public d f1094g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f1095h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f1096i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f1097j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public androidx.core.view.r f1098k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public androidx.core.widget.h f1099l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public f f1100m;

    public static class a {
        @DoNotInline
        public static void a(View r10, float r11, float r12) {
            r10.drawableHotspotChanged(r11, r12);
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static Method f1101a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static Method f1102b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static Method f1103c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static boolean f1104d;

        static {
            Class r10 = Integer.TYPE;     // Catch: NoSuchMethodException -> L5
            Class r11 = Boolean.TYPE;     // Catch: NoSuchMethodException -> L5
            Class r12 = Float.TYPE;     // Catch: NoSuchMethodException -> L5
            Method r13 = AbsListView.class.getDeclaredMethod("positionSelector", new Class[]{r10, View.class, r11, r12, r12});     // Catch: NoSuchMethodException -> L5
            f1101a = r13;     // Catch: NoSuchMethodException -> L5
            r13.setAccessible(true);     // Catch: NoSuchMethodException -> L5
            Method r14 = AdapterView.class.getDeclaredMethod("setSelectedPositionInt", new Class[]{r10});     // Catch: NoSuchMethodException -> L5
            f1102b = r14;     // Catch: NoSuchMethodException -> L5
            r14.setAccessible(true);     // Catch: NoSuchMethodException -> L5
            Method r15 = AdapterView.class.getDeclaredMethod("setNextSelectedPositionInt", new Class[]{r10});     // Catch: NoSuchMethodException -> L5
            f1103c = r15;     // Catch: NoSuchMethodException -> L5
            r15.setAccessible(true);     // Catch: NoSuchMethodException -> L5
            f1104d = true;     // Catch: NoSuchMethodException -> L5
            return;
        L5:
            e = move-exception;
            e.printStackTrace();
        }

        public static boolean a() {
            return f1104d;
        }

        public static void b(s r10, int r11, View r12) {
            f1101a.invoke(r10, new Object[]{Integer.valueOf(r11), r12, Boolean.FALSE, -1, -1});     // Catch: InvocationTargetException -> L4 IllegalAccessException -> L6
            f1102b.invoke(r10, new Object[]{Integer.valueOf(r11)});     // Catch: InvocationTargetException -> L4 IllegalAccessException -> L6
            f1103c.invoke(r10, new Object[]{Integer.valueOf(r11)});     // Catch: InvocationTargetException -> L4 IllegalAccessException -> L6
        L14:
            return;
        L6:
            e = move-exception;
            e.printStackTrace();
            return;
        L4:
            e = move-exception;
            e.printStackTrace();
        }
    }

    public static class c {
        @DoNotInline
        public static boolean a(AbsListView r10) {
            return r10.isSelectedChildViewEnabled();
        }

        @DoNotInline
        public static void b(AbsListView r10, boolean r11) {
            r10.setSelectedChildViewEnabled(r11);
        }
    }

    public static class d extends d.a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f1105b;

        public d(Drawable r10) {
            super(r10);
            this.f1105b = true;
        }

        public void b(boolean r10) {
            this.f1105b = r10;
        }

        @Override // d.a, android.graphics.drawable.Drawable
        public void draw(Canvas r10) {
            if (this.f1105b == false) goto L6;
            super.draw(r10);
            return;
        }

        @Override // d.a, android.graphics.drawable.Drawable
        public void setHotspot(float r10, float r11) {
            if (this.f1105b == false) goto L6;
            super.setHotspot(r10, r11);
            return;
        }

        @Override // d.a, android.graphics.drawable.Drawable
        public void setHotspotBounds(int r10, int r11, int r12, int r13) {
            if (this.f1105b == false) goto L6;
            super.setHotspotBounds(r10, r11, r12, r13);
            return;
        }

        @Override // d.a, android.graphics.drawable.Drawable
        public boolean setState(int[] r10) {
            if (this.f1105b == true) goto L5;
            return false;
        L5:
            return super.setState(r10);
        }

        @Override // d.a, android.graphics.drawable.Drawable
        public boolean setVisible(boolean r10, boolean r11) {
            if (this.f1105b == true) goto L5;
            return false;
        L5:
            return super.setVisible(r10, r11);
        }
    }

    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Field f1106a = null;

        static {
            Field r10 = null;
            r10 = AbsListView.class.getDeclaredField("mIsChildViewEnabled");     // Catch: NoSuchFieldException -> L5
            r10.setAccessible(true);     // Catch: NoSuchFieldException -> L5
        L7:
            f1106a = r10;
            return;
        L5:
            e = move-exception;
            e.printStackTrace();
            goto L7
        }

        public static boolean a(AbsListView r10) {
            Field r11 = f1106a;
            if (r11 == null) goto L12;
            return r11.getBoolean(r10);
        L6:
            e = move-exception;
            e.printStackTrace();
            return false;
        L12:
            return false;
        }

        public static void b(AbsListView r10, boolean r11) {
            Field r12 = f1106a;
            if (r12 == null) goto L11;
            r12.set(r10, Boolean.valueOf(r11));     // Catch: IllegalAccessException -> L6
            return;
        L6:
            e = move-exception;
            e.printStackTrace();
            return;
        }
    }

    public class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ s f1107a;

        public f(s r10) {
            this.f1107a = r10;
        }

        public void a() {
            s r10 = this.f1107a;
            r10.f1100m = null;
            r10.removeCallbacks(this);
        }

        public void b() {
            this.f1107a.post(this);
        }

        @Override // java.lang.Runnable
        public void run() {
            s r10 = this.f1107a;
            r10.f1100m = null;
            r10.drawableStateChanged();
        }
    }

    public s(Context r10, boolean r11) {
        super(r10, null, R$attr.dropDownListViewStyle);
        this.f1088a = new Rect();
        this.f1089b = 0;
        this.f1090c = 0;
        this.f1091d = 0;
        this.f1092e = 0;
        this.f1096i = r11;
        setCacheColorHint(0);
    }

    public final void a() {
        this.f1097j = false;
        setPressed(false);
        drawableStateChanged();
        View r10 = getChildAt(this.f1093f - getFirstVisiblePosition());
        if (r10 == null) goto L5;
        r10.setPressed(false);
    L5:
        androidx.core.view.r r11 = this.f1098k;
        if (r11 == null) goto L9;
        r11.c();
        this.f1098k = null;
        return;
    }

    public final void b(View r10, int r11) {
        performItemClick(r10, r11, getItemIdAtPosition(r11));
    }

    public final void c(Canvas r10) {
        if (this.f1088a.isEmpty() == true) goto L8;
        Drawable r11 = getSelector();
        if (r11 == null) goto L9;
        r11.setBounds(this.f1088a);
        r11.draw(r10);
        return;
    L9:
        return;
    }

    public int d(int r11, int r12, int r13, int r14, int r15) {
        int r16 = getListPaddingTop();
        int r17 = getListPaddingBottom();
        int r10 = getDividerHeight();
        Drawable r18 = getDivider();
        ListAdapter r19 = getAdapter();
        if (r19 == null) goto L5;
        int r110 = r16 + r17;
        if (r10 <= 0) goto L10;
        if (r18 == null) goto L10;
    L11:
        int r20 = r19.getCount();
        int r21 = 0;
        int r22 = 0;
        int r23 = 0;
        View r24 = null;
    L12:
        if (r21 >= r20) goto L38;
        int r25 = r19.getItemViewType(r21);
        if (r25 == r22) goto L16;
        r24 = null;
        r22 = r25;
    L16:
        r24 = r19.getView(r21, r24, this);
        ViewGroup.LayoutParams r26 = r24.getLayoutParams();
        if (r26 != null) goto L19;
        r26 = generateDefaultLayoutParams();
        r24.setLayoutParams(r26);
    L19:
        int r27 = r26.height;
        if (r27 <= 0) goto L22;
        int r28 = View.MeasureSpec.makeMeasureSpec(r27, Ints.MAX_POWER_OF_TWO);
    L23:
        r24.measure(r11, r28);
        r24.forceLayout();
        if (r21 <= 0) goto L26;
        r110 = r110 + r10;
    L26:
        r110 = r110 + r24.getMeasuredHeight();
        if (r110 >= r14) goto L28;
        if (r15 < 0) goto L37;
        if (r21 < r15) goto L37;
        r23 = r110;
    L37:
        r21 = r21 + 1;
        goto L12
    L28:
        if (r15 < 0) goto L44;
        if (r21 <= r15) goto L45;
        if (r23 <= 0) goto L46;
        if (r110 != r14) goto L33;
        return r14;
    L33:
        return r23;
    L46:
        return r14;
    L45:
        return r14;
    L44:
        return r14;
    L22:
        r28 = View.MeasureSpec.makeMeasureSpec(0, 0);
        goto L23
    L38:
        return r110;
    L10:
        r10 = 0;
        goto L11
    L5:
        return r16 + r17;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas r10) {
        c(r10);
        super.dispatchDraw(r10);
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        if (this.f1100m == null) goto L5;
        return;
    L5:
        super.drawableStateChanged();
        j(true);
        n();
    }

    public boolean e(MotionEvent r10, int r11) {
        int r12 = r10.getActionMasked();
        if (r12 != 1) goto L5;
        boolean r13 = false;
    L12:
        int r14 = r10.findPointerIndex(r11);
        if (r14 < 0) goto L9;
        int r15 = (int) r10.getX(r14);
        int r16 = (int) r10.getY(r14);
        int r17 = pointToPosition(r15, r16);
        if (r17 != (-1)) goto L18;
        boolean r18 = true;
    L21:
        if (r13 == false) goto L23;
        if (r18 == true) goto L23;
    L24:
        if (r13 == true) goto L26;
        androidx.core.widget.h r19 = this.f1099l;
        if (r19 == null) goto L32;
        r19.m(false);
    L32:
        return r13;
    L26:
        if (this.f1099l != null) goto L28;
        this.f1099l = new androidx.core.widget.h(this);
    L28:
        this.f1099l.m(true);
        this.f1099l.onTouch(this, r10);
    L23:
        a();
        goto L24
    L18:
        View r20 = getChildAt(r17 - getFirstVisiblePosition());
        i(r20, r17, r15, r16);
        if (r12 == 1) goto L20;
    L8:
        r13 = true;
        r18 = false;
        goto L21
    L20:
        b(r20, r17);
    L9:
        r18 = false;
        r13 = false;
        goto L21
    L5:
        if (r12 != 2) goto L7;
        r13 = true;
        goto L12
    L7:
        if (r12 == 3) goto L9;
        goto L8
    }

    public final void f(int r10, View r11) {
        Rect r12 = this.f1088a;
        r12.set(r11.getLeft(), r11.getTop(), r11.getRight(), r11.getBottom());
        r12.left -= this.f1089b;
        r12.top -= this.f1090c;
        r12.right += this.f1091d;
        r12.bottom += this.f1092e;
        boolean r13 = k();
        if (r11.isEnabled() == r13) goto L8;
        l(!r13);
        if (r10 == (-1)) goto L9;
        refreshDrawableState();
        return;
    L9:
        return;
    }

    public final void g(int r10, View r11) {
        Drawable r12 = getSelector();
        boolean r13 = true;
        if (r12 != null) goto L5;
    L7:
        boolean r14 = false;
    L8:
        if (r14 == false) goto L10;
        r12.setVisible(false, false);
    L10:
        f(r10, r11);
        if (r14 == false) goto L18;
        Rect r15 = this.f1088a;
        float r16 = r15.exactCenterX();
        float r17 = r15.exactCenterY();
        if (getVisibility() == 0) goto L16;
        r13 = false;
    L16:
        r12.setVisible(r13, false);
        o.a.e(r12, r16, r17);
        return;
    L18:
        return;
    L5:
        if (r10 == (-1)) goto L7;
        r14 = true;
        goto L8
    }

    public final void h(int r10, View r11, float r12, float r13) {
        g(r10, r11);
        Drawable r14 = getSelector();
        if (r14 != null) goto L5;
        return;
    L5:
        if (r10 == (-1)) goto L9;
        o.a.e(r14, r12, r13);
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean hasFocus() {
        if (this.f1096i == false) goto L5;
    L8:
        return true;
    L5:
        if (super.hasFocus() == true) goto L8;
        return false;
    }

    @Override // android.view.View
    public boolean hasWindowFocus() {
        if (this.f1096i == false) goto L5;
    L8:
        return true;
    L5:
        if (super.hasWindowFocus() == true) goto L8;
        return false;
    }

    public final void i(View r10, int r11, float r12, float r13) {
        this.f1097j = true;
        a.a(this, r12, r13);
        if (isPressed() == true) goto L5;
        setPressed(true);
    L5:
        layoutChildren();
        int r14 = this.f1093f;
        if (r14 == (-1)) goto L13;
        View r15 = getChildAt(r14 - getFirstVisiblePosition());
        if (r15 == null) goto L13;
        if (r15 == r10) goto L13;
        if (r15.isPressed() == false) goto L13;
        r15.setPressed(false);
    L13:
        this.f1093f = r11;
        a.a(r10, r12 - r10.getLeft(), r13 - r10.getTop());
        if (r10.isPressed() == true) goto L16;
        r10.setPressed(true);
    L16:
        h(r11, r10, r12, r13);
        j(false);
        refreshDrawableState();
    }

    @Override // android.view.View
    public boolean isFocused() {
        if (this.f1096i == false) goto L5;
    L8:
        return true;
    L5:
        if (super.isFocused() == true) goto L8;
        return false;
    }

    @Override // android.view.View
    public boolean isInTouchMode() {
        if (this.f1096i == false) goto L7;
        if (this.f1095h == false) goto L7;
    L8:
        return true;
    L7:
        if (super.isInTouchMode() == true) goto L8;
        return false;
    }

    public final void j(boolean r10) {
        d r11 = this.f1094g;
        if (r11 == null) goto L6;
        r11.b(r10);
        return;
    }

    public final boolean k() {
        if (BuildCompat.c() == false) goto L7;
        return c.a(this);
    L7:
        return e.a(this);
    }

    public final void l(boolean r10) {
        if (BuildCompat.c() == false) goto L5;
        c.b(this, r10);
        return;
    L5:
        e.b(this, r10);
    }

    public final boolean m() {
        return this.f1097j;
    }

    public final void n() {
        Drawable r10 = getSelector();
        if (r10 != null) goto L5;
        return;
    L5:
        if (m() == true) goto L7;
        return;
    L7:
        if (isPressed() == false) goto L12;
        r10.setState(getDrawableState());
        return;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        this.f1100m = null;
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent r10) {
        int r11 = r10.getActionMasked();
        if (r11 == 10) goto L5;
    L7:
        boolean r12 = super.onHoverEvent(r10);
        if (r11 != 9) goto L10;
    L13:
        int r13 = pointToPosition((int) r10.getX(), (int) r10.getY());
        if (r13 != (-1)) goto L16;
    L24:
        return r12;
    L16:
        if (r13 == getSelectedItemPosition()) goto L24;
        View r14 = getChildAt(r13 - getFirstVisiblePosition());
        if (r14.isEnabled() == false) goto L23;
        requestFocus();
        if (b.a() == false) goto L22;
        b.b(this, r13, r14);
        goto L23
    L22:
        setSelectionFromTop(r13, r14.getTop() - getTop());
    L23:
        n();
        goto L24
    L10:
        if (r11 == 7) goto L13;
        setSelection(-1);
        goto L24
    L5:
        if (this.f1100m != null) goto L7;
        f r15 = new f(this);
        this.f1100m = r15;
        r15.b();
        goto L7
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent r10) {
        if (r10.getAction() != 0) goto L6;
        this.f1093f = pointToPosition((int) r10.getX(), (int) r10.getY());
    L6:
        f r11 = this.f1100m;
        if (r11 == null) goto L10;
        r11.a();
    L10:
        return super.onTouchEvent(r10);
    }

    public void setListSelectionHidden(boolean r10) {
        this.f1095h = r10;
    }

    @Override // android.widget.AbsListView
    public void setSelector(Drawable r10) {
        if (r10 == null) goto L4;
        d r11 = new d(r10);
    L5:
        this.f1094g = r11;
        super.setSelector(r11);
        Rect r12 = new Rect();
        if (r10 == null) goto L8;
        r10.getPadding(r12);
    L8:
        this.f1089b = r12.left;
        this.f1090c = r12.top;
        this.f1091d = r12.right;
        this.f1092e = r12.bottom;
        return;
    L4:
        r11 = null;
        goto L5
    }
}
