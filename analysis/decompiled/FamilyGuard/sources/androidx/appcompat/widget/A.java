package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.DataSetObserver;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.ThemedSpinnerAdapter;
import androidx.appcompat.app.c;
import g.C0728a;
import h.C0744a;
import l.InterfaceC0820e;

/* loaded from: classes.dex */
public class A extends Spinner {

    /* renamed from: i, reason: collision with root package name */
    private static final int[] f7977i = {R.attr.spinnerMode};

    /* renamed from: a, reason: collision with root package name */
    private final C0435e f7978a;

    /* renamed from: b, reason: collision with root package name */
    private final Context f7979b;

    /* renamed from: c, reason: collision with root package name */
    private L f7980c;

    /* renamed from: d, reason: collision with root package name */
    private SpinnerAdapter f7981d;

    /* renamed from: e, reason: collision with root package name */
    private final boolean f7982e;

    /* renamed from: f, reason: collision with root package name */
    private h f7983f;

    /* renamed from: g, reason: collision with root package name */
    int f7984g;

    /* renamed from: h, reason: collision with root package name */
    final Rect f7985h;

    class a extends L {

        /* renamed from: j, reason: collision with root package name */
        final /* synthetic */ f f7986j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(View view, f fVar) {
            super(view);
            this.f7986j = fVar;
        }

        @Override // androidx.appcompat.widget.L
        public InterfaceC0820e b() {
            return this.f7986j;
        }

        @Override // androidx.appcompat.widget.L
        public boolean c() {
            if (A.this.getInternalPopup().h()) {
                return true;
            }
            A.this.b();
            return true;
        }
    }

    class b implements ViewTreeObserver.OnGlobalLayoutListener {
        b() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (!A.this.getInternalPopup().h()) {
                A.this.b();
            }
            ViewTreeObserver viewTreeObserver = A.this.getViewTreeObserver();
            if (viewTreeObserver != null) {
                viewTreeObserver.removeOnGlobalLayoutListener(this);
            }
        }
    }

    private static final class c {
        static void a(ThemedSpinnerAdapter themedSpinnerAdapter, Resources.Theme theme) {
            if (D.c.a(themedSpinnerAdapter.getDropDownViewTheme(), theme)) {
                return;
            }
            themedSpinnerAdapter.setDropDownViewTheme(theme);
        }
    }

    class d implements h, DialogInterface.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        androidx.appcompat.app.c f7989a;

        /* renamed from: b, reason: collision with root package name */
        private ListAdapter f7990b;

        /* renamed from: c, reason: collision with root package name */
        private CharSequence f7991c;

        d() {
        }

        @Override // androidx.appcompat.widget.A.h
        public void dismiss() {
            androidx.appcompat.app.c cVar = this.f7989a;
            if (cVar != null) {
                cVar.dismiss();
                this.f7989a = null;
            }
        }

        @Override // androidx.appcompat.widget.A.h
        public void g(Drawable drawable) {
            Log.e("AppCompatSpinner", "Cannot set popup background for MODE_DIALOG, ignoring");
        }

        @Override // androidx.appcompat.widget.A.h
        public boolean h() {
            androidx.appcompat.app.c cVar = this.f7989a;
            if (cVar != null) {
                return cVar.isShowing();
            }
            return false;
        }

        @Override // androidx.appcompat.widget.A.h
        public int i() {
            return 0;
        }

        @Override // androidx.appcompat.widget.A.h
        public void j(int i5) {
            Log.e("AppCompatSpinner", "Cannot set horizontal offset for MODE_DIALOG, ignoring");
        }

        @Override // androidx.appcompat.widget.A.h
        public CharSequence k() {
            return this.f7991c;
        }

        @Override // androidx.appcompat.widget.A.h
        public Drawable l() {
            return null;
        }

        @Override // androidx.appcompat.widget.A.h
        public void n(CharSequence charSequence) {
            this.f7991c = charSequence;
        }

        @Override // androidx.appcompat.widget.A.h
        public void o(int i5) {
            Log.e("AppCompatSpinner", "Cannot set vertical offset for MODE_DIALOG, ignoring");
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i5) {
            A.this.setSelection(i5);
            if (A.this.getOnItemClickListener() != null) {
                A.this.performItemClick(null, i5, this.f7990b.getItemId(i5));
            }
            dismiss();
        }

        @Override // androidx.appcompat.widget.A.h
        public void p(int i5) {
            Log.e("AppCompatSpinner", "Cannot set horizontal (original) offset for MODE_DIALOG, ignoring");
        }

        @Override // androidx.appcompat.widget.A.h
        public void q(int i5, int i6) {
            if (this.f7990b == null) {
                return;
            }
            c.a aVar = new c.a(A.this.getPopupContext());
            CharSequence charSequence = this.f7991c;
            if (charSequence != null) {
                aVar.m(charSequence);
            }
            androidx.appcompat.app.c cVarA = aVar.k(this.f7990b, A.this.getSelectedItemPosition(), this).a();
            this.f7989a = cVarA;
            ListView listViewM = cVarA.m();
            listViewM.setTextDirection(i5);
            listViewM.setTextAlignment(i6);
            this.f7989a.show();
        }

        @Override // androidx.appcompat.widget.A.h
        public int r() {
            return 0;
        }

        @Override // androidx.appcompat.widget.A.h
        public void s(ListAdapter listAdapter) {
            this.f7990b = listAdapter;
        }
    }

    private static class e implements ListAdapter, SpinnerAdapter {

        /* renamed from: a, reason: collision with root package name */
        private SpinnerAdapter f7993a;

        /* renamed from: b, reason: collision with root package name */
        private ListAdapter f7994b;

        public e(SpinnerAdapter spinnerAdapter, Resources.Theme theme) {
            this.f7993a = spinnerAdapter;
            if (spinnerAdapter instanceof ListAdapter) {
                this.f7994b = (ListAdapter) spinnerAdapter;
            }
            if (theme != null) {
                if (spinnerAdapter instanceof ThemedSpinnerAdapter) {
                    c.a((ThemedSpinnerAdapter) spinnerAdapter, theme);
                } else if (spinnerAdapter instanceof W) {
                    W w5 = (W) spinnerAdapter;
                    if (w5.getDropDownViewTheme() == null) {
                        w5.setDropDownViewTheme(theme);
                    }
                }
            }
        }

        @Override // android.widget.ListAdapter
        public boolean areAllItemsEnabled() {
            ListAdapter listAdapter = this.f7994b;
            if (listAdapter != null) {
                return listAdapter.areAllItemsEnabled();
            }
            return true;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            SpinnerAdapter spinnerAdapter = this.f7993a;
            if (spinnerAdapter == null) {
                return 0;
            }
            return spinnerAdapter.getCount();
        }

        @Override // android.widget.SpinnerAdapter
        public View getDropDownView(int i5, View view, ViewGroup viewGroup) {
            SpinnerAdapter spinnerAdapter = this.f7993a;
            if (spinnerAdapter == null) {
                return null;
            }
            return spinnerAdapter.getDropDownView(i5, view, viewGroup);
        }

        @Override // android.widget.Adapter
        public Object getItem(int i5) {
            SpinnerAdapter spinnerAdapter = this.f7993a;
            if (spinnerAdapter == null) {
                return null;
            }
            return spinnerAdapter.getItem(i5);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i5) {
            SpinnerAdapter spinnerAdapter = this.f7993a;
            if (spinnerAdapter == null) {
                return -1L;
            }
            return spinnerAdapter.getItemId(i5);
        }

        @Override // android.widget.Adapter
        public int getItemViewType(int i5) {
            return 0;
        }

        @Override // android.widget.Adapter
        public View getView(int i5, View view, ViewGroup viewGroup) {
            return getDropDownView(i5, view, viewGroup);
        }

        @Override // android.widget.Adapter
        public int getViewTypeCount() {
            return 1;
        }

        @Override // android.widget.Adapter
        public boolean hasStableIds() {
            SpinnerAdapter spinnerAdapter = this.f7993a;
            return spinnerAdapter != null && spinnerAdapter.hasStableIds();
        }

        @Override // android.widget.Adapter
        public boolean isEmpty() {
            return getCount() == 0;
        }

        @Override // android.widget.ListAdapter
        public boolean isEnabled(int i5) {
            ListAdapter listAdapter = this.f7994b;
            if (listAdapter != null) {
                return listAdapter.isEnabled(i5);
            }
            return true;
        }

        @Override // android.widget.Adapter
        public void registerDataSetObserver(DataSetObserver dataSetObserver) {
            SpinnerAdapter spinnerAdapter = this.f7993a;
            if (spinnerAdapter != null) {
                spinnerAdapter.registerDataSetObserver(dataSetObserver);
            }
        }

        @Override // android.widget.Adapter
        public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
            SpinnerAdapter spinnerAdapter = this.f7993a;
            if (spinnerAdapter != null) {
                spinnerAdapter.unregisterDataSetObserver(dataSetObserver);
            }
        }
    }

    class f extends M implements h {

        /* renamed from: G, reason: collision with root package name */
        private CharSequence f7995G;

        /* renamed from: H, reason: collision with root package name */
        ListAdapter f7996H;

        /* renamed from: I, reason: collision with root package name */
        private final Rect f7997I;

        /* renamed from: J, reason: collision with root package name */
        private int f7998J;

        class a implements AdapterView.OnItemClickListener {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ A f8000a;

            a(A a6) {
                this.f8000a = a6;
            }

            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i5, long j5) {
                A.this.setSelection(i5);
                if (A.this.getOnItemClickListener() != null) {
                    f fVar = f.this;
                    A.this.performItemClick(view, i5, fVar.f7996H.getItemId(i5));
                }
                f.this.dismiss();
            }
        }

        class b implements ViewTreeObserver.OnGlobalLayoutListener {
            b() {
            }

            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                f fVar = f.this;
                if (!fVar.V(A.this)) {
                    f.this.dismiss();
                } else {
                    f.this.T();
                    f.super.a();
                }
            }
        }

        class c implements PopupWindow.OnDismissListener {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ ViewTreeObserver.OnGlobalLayoutListener f8003a;

            c(ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
                this.f8003a = onGlobalLayoutListener;
            }

            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                ViewTreeObserver viewTreeObserver = A.this.getViewTreeObserver();
                if (viewTreeObserver != null) {
                    viewTreeObserver.removeGlobalOnLayoutListener(this.f8003a);
                }
            }
        }

        public f(Context context, AttributeSet attributeSet, int i5) {
            super(context, attributeSet, i5);
            this.f7997I = new Rect();
            D(A.this);
            J(true);
            P(0);
            L(new a(A.this));
        }

        void T() {
            int i5;
            Drawable drawableL = l();
            if (drawableL != null) {
                drawableL.getPadding(A.this.f7985h);
                i5 = h0.b(A.this) ? A.this.f7985h.right : -A.this.f7985h.left;
            } else {
                Rect rect = A.this.f7985h;
                rect.right = 0;
                rect.left = 0;
                i5 = 0;
            }
            int paddingLeft = A.this.getPaddingLeft();
            int paddingRight = A.this.getPaddingRight();
            int width = A.this.getWidth();
            A a6 = A.this;
            int i6 = a6.f7984g;
            if (i6 == -2) {
                int iA = a6.a((SpinnerAdapter) this.f7996H, l());
                int i7 = A.this.getContext().getResources().getDisplayMetrics().widthPixels;
                Rect rect2 = A.this.f7985h;
                int i8 = (i7 - rect2.left) - rect2.right;
                if (iA > i8) {
                    iA = i8;
                }
                F(Math.max(iA, (width - paddingLeft) - paddingRight));
            } else if (i6 == -1) {
                F((width - paddingLeft) - paddingRight);
            } else {
                F(i6);
            }
            j(h0.b(A.this) ? i5 + (((width - paddingRight) - z()) - U()) : i5 + paddingLeft + U());
        }

        public int U() {
            return this.f7998J;
        }

        boolean V(View view) {
            return view.isAttachedToWindow() && view.getGlobalVisibleRect(this.f7997I);
        }

        @Override // androidx.appcompat.widget.A.h
        public CharSequence k() {
            return this.f7995G;
        }

        @Override // androidx.appcompat.widget.A.h
        public void n(CharSequence charSequence) {
            this.f7995G = charSequence;
        }

        @Override // androidx.appcompat.widget.A.h
        public void p(int i5) {
            this.f7998J = i5;
        }

        @Override // androidx.appcompat.widget.A.h
        public void q(int i5, int i6) {
            ViewTreeObserver viewTreeObserver;
            boolean zH = h();
            T();
            I(2);
            super.a();
            ListView listViewM = m();
            listViewM.setChoiceMode(1);
            listViewM.setTextDirection(i5);
            listViewM.setTextAlignment(i6);
            Q(A.this.getSelectedItemPosition());
            if (zH || (viewTreeObserver = A.this.getViewTreeObserver()) == null) {
                return;
            }
            b bVar = new b();
            viewTreeObserver.addOnGlobalLayoutListener(bVar);
            K(new c(bVar));
        }

        @Override // androidx.appcompat.widget.M, androidx.appcompat.widget.A.h
        public void s(ListAdapter listAdapter) {
            super.s(listAdapter);
            this.f7996H = listAdapter;
        }
    }

    static class g extends View.BaseSavedState {
        public static final Parcelable.Creator<g> CREATOR = new a();

        /* renamed from: a, reason: collision with root package name */
        boolean f8005a;

        class a implements Parcelable.Creator<g> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public g createFromParcel(Parcel parcel) {
                return new g(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public g[] newArray(int i5) {
                return new g[i5];
            }
        }

        g(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i5) {
            super.writeToParcel(parcel, i5);
            parcel.writeByte(this.f8005a ? (byte) 1 : (byte) 0);
        }

        g(Parcel parcel) {
            super(parcel);
            this.f8005a = parcel.readByte() != 0;
        }
    }

    interface h {
        void dismiss();

        void g(Drawable drawable);

        boolean h();

        int i();

        void j(int i5);

        CharSequence k();

        Drawable l();

        void n(CharSequence charSequence);

        void o(int i5);

        void p(int i5);

        void q(int i5, int i6);

        int r();

        void s(ListAdapter listAdapter);
    }

    public A(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0728a.f16818O);
    }

    int a(SpinnerAdapter spinnerAdapter, Drawable drawable) {
        int i5 = 0;
        if (spinnerAdapter == null) {
            return 0;
        }
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
        int iMax = Math.max(0, getSelectedItemPosition());
        int iMin = Math.min(spinnerAdapter.getCount(), iMax + 15);
        View view = null;
        int iMax2 = 0;
        for (int iMax3 = Math.max(0, iMax - (15 - (iMin - iMax))); iMax3 < iMin; iMax3++) {
            int itemViewType = spinnerAdapter.getItemViewType(iMax3);
            if (itemViewType != i5) {
                view = null;
                i5 = itemViewType;
            }
            view = spinnerAdapter.getView(iMax3, view, this);
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            }
            view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
            iMax2 = Math.max(iMax2, view.getMeasuredWidth());
        }
        if (drawable == null) {
            return iMax2;
        }
        drawable.getPadding(this.f7985h);
        Rect rect = this.f7985h;
        return iMax2 + rect.left + rect.right;
    }

    void b() {
        this.f7983f.q(getTextDirection(), getTextAlignment());
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        C0435e c0435e = this.f7978a;
        if (c0435e != null) {
            c0435e.b();
        }
    }

    @Override // android.widget.Spinner
    public int getDropDownHorizontalOffset() {
        h hVar = this.f7983f;
        return hVar != null ? hVar.i() : super.getDropDownHorizontalOffset();
    }

    @Override // android.widget.Spinner
    public int getDropDownVerticalOffset() {
        h hVar = this.f7983f;
        return hVar != null ? hVar.r() : super.getDropDownVerticalOffset();
    }

    @Override // android.widget.Spinner
    public int getDropDownWidth() {
        return this.f7983f != null ? this.f7984g : super.getDropDownWidth();
    }

    final h getInternalPopup() {
        return this.f7983f;
    }

    @Override // android.widget.Spinner
    public Drawable getPopupBackground() {
        h hVar = this.f7983f;
        return hVar != null ? hVar.l() : super.getPopupBackground();
    }

    @Override // android.widget.Spinner
    public Context getPopupContext() {
        return this.f7979b;
    }

    @Override // android.widget.Spinner
    public CharSequence getPrompt() {
        h hVar = this.f7983f;
        return hVar != null ? hVar.k() : super.getPrompt();
    }

    public ColorStateList getSupportBackgroundTintList() {
        C0435e c0435e = this.f7978a;
        if (c0435e != null) {
            return c0435e.c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C0435e c0435e = this.f7978a;
        if (c0435e != null) {
            return c0435e.d();
        }
        return null;
    }

    @Override // android.widget.Spinner, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        h hVar = this.f7983f;
        if (hVar == null || !hVar.h()) {
            return;
        }
        this.f7983f.dismiss();
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    protected void onMeasure(int i5, int i6) {
        super.onMeasure(i5, i6);
        if (this.f7983f == null || View.MeasureSpec.getMode(i5) != Integer.MIN_VALUE) {
            return;
        }
        setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), a(getAdapter(), getBackground())), View.MeasureSpec.getSize(i5)), getMeasuredHeight());
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        ViewTreeObserver viewTreeObserver;
        g gVar = (g) parcelable;
        super.onRestoreInstanceState(gVar.getSuperState());
        if (!gVar.f8005a || (viewTreeObserver = getViewTreeObserver()) == null) {
            return;
        }
        viewTreeObserver.addOnGlobalLayoutListener(new b());
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public Parcelable onSaveInstanceState() {
        g gVar = new g(super.onSaveInstanceState());
        h hVar = this.f7983f;
        gVar.f8005a = hVar != null && hVar.h();
        return gVar;
    }

    @Override // android.widget.Spinner, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        L l5 = this.f7980c;
        if (l5 == null || !l5.onTouch(this, motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    @Override // android.widget.Spinner, android.view.View
    public boolean performClick() {
        h hVar = this.f7983f;
        if (hVar == null) {
            return super.performClick();
        }
        if (hVar.h()) {
            return true;
        }
        b();
        return true;
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C0435e c0435e = this.f7978a;
        if (c0435e != null) {
            c0435e.f(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i5) {
        super.setBackgroundResource(i5);
        C0435e c0435e = this.f7978a;
        if (c0435e != null) {
            c0435e.g(i5);
        }
    }

    @Override // android.widget.Spinner
    public void setDropDownHorizontalOffset(int i5) {
        h hVar = this.f7983f;
        if (hVar == null) {
            super.setDropDownHorizontalOffset(i5);
        } else {
            hVar.p(i5);
            this.f7983f.j(i5);
        }
    }

    @Override // android.widget.Spinner
    public void setDropDownVerticalOffset(int i5) {
        h hVar = this.f7983f;
        if (hVar != null) {
            hVar.o(i5);
        } else {
            super.setDropDownVerticalOffset(i5);
        }
    }

    @Override // android.widget.Spinner
    public void setDropDownWidth(int i5) {
        if (this.f7983f != null) {
            this.f7984g = i5;
        } else {
            super.setDropDownWidth(i5);
        }
    }

    @Override // android.widget.Spinner
    public void setPopupBackgroundDrawable(Drawable drawable) {
        h hVar = this.f7983f;
        if (hVar != null) {
            hVar.g(drawable);
        } else {
            super.setPopupBackgroundDrawable(drawable);
        }
    }

    @Override // android.widget.Spinner
    public void setPopupBackgroundResource(int i5) {
        setPopupBackgroundDrawable(C0744a.b(getPopupContext(), i5));
    }

    @Override // android.widget.Spinner
    public void setPrompt(CharSequence charSequence) {
        h hVar = this.f7983f;
        if (hVar != null) {
            hVar.n(charSequence);
        } else {
            super.setPrompt(charSequence);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        C0435e c0435e = this.f7978a;
        if (c0435e != null) {
            c0435e.i(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        C0435e c0435e = this.f7978a;
        if (c0435e != null) {
            c0435e.j(mode);
        }
    }

    public A(Context context, AttributeSet attributeSet, int i5) {
        this(context, attributeSet, i5, -1);
    }

    @Override // android.widget.AdapterView
    public void setAdapter(SpinnerAdapter spinnerAdapter) {
        if (!this.f7982e) {
            this.f7981d = spinnerAdapter;
            return;
        }
        super.setAdapter(spinnerAdapter);
        if (this.f7983f != null) {
            Context context = this.f7979b;
            if (context == null) {
                context = getContext();
            }
            this.f7983f.s(new e(spinnerAdapter, context.getTheme()));
        }
    }

    public A(Context context, AttributeSet attributeSet, int i5, int i6) {
        this(context, attributeSet, i5, i6, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00db  */
    /* JADX WARN: Type inference failed for: r11v10 */
    /* JADX WARN: Type inference failed for: r11v11 */
    /* JADX WARN: Type inference failed for: r11v12 */
    /* JADX WARN: Type inference failed for: r11v3 */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* JADX WARN: Type inference failed for: r11v7, types: [android.content.res.TypedArray] */
    /* JADX WARN: Type inference failed for: r6v0, types: [android.view.View, androidx.appcompat.widget.A] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public A(android.content.Context r7, android.util.AttributeSet r8, int r9, int r10, android.content.res.Resources.Theme r11) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 230
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.A.<init>(android.content.Context, android.util.AttributeSet, int, int, android.content.res.Resources$Theme):void");
    }
}
