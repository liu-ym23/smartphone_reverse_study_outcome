package androidx.appcompat.widget;

import android.R;
import android.annotation.SuppressLint;
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
import androidx.appcompat.R$attr;
import androidx.appcompat.app.c;
import f.C4027a;
import j.InterfaceC4741f;

/* loaded from: classes.dex */
public class AppCompatSpinner extends Spinner {

    /* renamed from: i, reason: collision with root package name */
    @SuppressLint({"ResourceType"})
    public static final int[] f8832i = {R.attr.spinnerMode};

    /* renamed from: a, reason: collision with root package name */
    public final C1291d f8833a;

    /* renamed from: b, reason: collision with root package name */
    public final Context f8834b;

    /* renamed from: c, reason: collision with root package name */
    public E f8835c;

    /* renamed from: d, reason: collision with root package name */
    public SpinnerAdapter f8836d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f8837e;

    /* renamed from: f, reason: collision with root package name */
    public g f8838f;

    /* renamed from: g, reason: collision with root package name */
    public int f8839g;

    /* renamed from: h, reason: collision with root package name */
    public final Rect f8840h;

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        boolean mShowDropdown;

        public class a implements Parcelable.Creator<SavedState> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i10) {
                return new SavedState[i10];
            }
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeByte(this.mShowDropdown ? (byte) 1 : (byte) 0);
        }

        public SavedState(Parcel parcel) {
            super(parcel);
            this.mShowDropdown = parcel.readByte() != 0;
        }
    }

    public class a extends E {

        /* renamed from: j, reason: collision with root package name */
        public final /* synthetic */ f f8841j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(View view, f fVar) {
            super(view);
            this.f8841j = fVar;
        }

        @Override // androidx.appcompat.widget.E
        public InterfaceC4741f b() {
            return this.f8841j;
        }

        @Override // androidx.appcompat.widget.E
        public boolean c() {
            if (AppCompatSpinner.this.getInternalPopup().isShowing()) {
                return true;
            }
            AppCompatSpinner.this.b();
            return true;
        }
    }

    public class b implements ViewTreeObserver.OnGlobalLayoutListener {
        public b() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (!AppCompatSpinner.this.getInternalPopup().isShowing()) {
                AppCompatSpinner.this.b();
            }
            ViewTreeObserver viewTreeObserver = AppCompatSpinner.this.getViewTreeObserver();
            if (viewTreeObserver != null) {
                viewTreeObserver.removeOnGlobalLayoutListener(this);
            }
        }
    }

    public static final class c {
        public static void a(ThemedSpinnerAdapter themedSpinnerAdapter, Resources.Theme theme) {
            if (B0.c.a(themedSpinnerAdapter.getDropDownViewTheme(), theme)) {
                return;
            }
            themedSpinnerAdapter.setDropDownViewTheme(theme);
        }
    }

    public class d implements g, DialogInterface.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public androidx.appcompat.app.c f8844a;

        /* renamed from: b, reason: collision with root package name */
        public ListAdapter f8845b;

        /* renamed from: c, reason: collision with root package name */
        public CharSequence f8846c;

        public d() {
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.g
        public int a() {
            return 0;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.g
        public void b(Drawable drawable) {
            Log.e("AppCompatSpinner", "Cannot set popup background for MODE_DIALOG, ignoring");
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.g
        public void d(int i10) {
            Log.e("AppCompatSpinner", "Cannot set horizontal offset for MODE_DIALOG, ignoring");
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.g
        public void dismiss() {
            androidx.appcompat.app.c cVar = this.f8844a;
            if (cVar != null) {
                cVar.dismiss();
                this.f8844a = null;
            }
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.g
        public CharSequence e() {
            return this.f8846c;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.g
        public Drawable f() {
            return null;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.g
        public void g(CharSequence charSequence) {
            this.f8846c = charSequence;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.g
        public void h(int i10) {
            Log.e("AppCompatSpinner", "Cannot set vertical offset for MODE_DIALOG, ignoring");
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.g
        public void i(int i10) {
            Log.e("AppCompatSpinner", "Cannot set horizontal (original) offset for MODE_DIALOG, ignoring");
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.g
        public boolean isShowing() {
            androidx.appcompat.app.c cVar = this.f8844a;
            if (cVar != null) {
                return cVar.isShowing();
            }
            return false;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.g
        public void j(int i10, int i11) {
            if (this.f8845b == null) {
                return;
            }
            c.a aVar = new c.a(AppCompatSpinner.this.getPopupContext());
            CharSequence charSequence = this.f8846c;
            if (charSequence != null) {
                aVar.q(charSequence);
            }
            androidx.appcompat.app.c cVarA = aVar.n(this.f8845b, AppCompatSpinner.this.getSelectedItemPosition(), this).a();
            this.f8844a = cVarA;
            ListView listViewI = cVarA.i();
            listViewI.setTextDirection(i10);
            listViewI.setTextAlignment(i11);
            this.f8844a.show();
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.g
        public int k() {
            return 0;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.g
        public void l(ListAdapter listAdapter) {
            this.f8845b = listAdapter;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            AppCompatSpinner.this.setSelection(i10);
            if (AppCompatSpinner.this.getOnItemClickListener() != null) {
                AppCompatSpinner.this.performItemClick(null, i10, this.f8845b.getItemId(i10));
            }
            dismiss();
        }
    }

    public static class e implements ListAdapter, SpinnerAdapter {

        /* renamed from: a, reason: collision with root package name */
        public SpinnerAdapter f8848a;

        /* renamed from: b, reason: collision with root package name */
        public ListAdapter f8849b;

        public e(SpinnerAdapter spinnerAdapter, Resources.Theme theme) {
            this.f8848a = spinnerAdapter;
            if (spinnerAdapter instanceof ListAdapter) {
                this.f8849b = (ListAdapter) spinnerAdapter;
            }
            if (theme != null) {
                if (spinnerAdapter instanceof ThemedSpinnerAdapter) {
                    c.a((ThemedSpinnerAdapter) spinnerAdapter, theme);
                } else if (spinnerAdapter instanceof P) {
                    P p10 = (P) spinnerAdapter;
                    if (p10.getDropDownViewTheme() == null) {
                        p10.setDropDownViewTheme(theme);
                    }
                }
            }
        }

        @Override // android.widget.ListAdapter
        public boolean areAllItemsEnabled() {
            ListAdapter listAdapter = this.f8849b;
            if (listAdapter != null) {
                return listAdapter.areAllItemsEnabled();
            }
            return true;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            SpinnerAdapter spinnerAdapter = this.f8848a;
            if (spinnerAdapter == null) {
                return 0;
            }
            return spinnerAdapter.getCount();
        }

        @Override // android.widget.SpinnerAdapter
        public View getDropDownView(int i10, View view, ViewGroup viewGroup) {
            SpinnerAdapter spinnerAdapter = this.f8848a;
            if (spinnerAdapter == null) {
                return null;
            }
            return spinnerAdapter.getDropDownView(i10, view, viewGroup);
        }

        @Override // android.widget.Adapter
        public Object getItem(int i10) {
            SpinnerAdapter spinnerAdapter = this.f8848a;
            if (spinnerAdapter == null) {
                return null;
            }
            return spinnerAdapter.getItem(i10);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i10) {
            SpinnerAdapter spinnerAdapter = this.f8848a;
            if (spinnerAdapter == null) {
                return -1L;
            }
            return spinnerAdapter.getItemId(i10);
        }

        @Override // android.widget.Adapter
        public int getItemViewType(int i10) {
            return 0;
        }

        @Override // android.widget.Adapter
        public View getView(int i10, View view, ViewGroup viewGroup) {
            return getDropDownView(i10, view, viewGroup);
        }

        @Override // android.widget.Adapter
        public int getViewTypeCount() {
            return 1;
        }

        @Override // android.widget.Adapter
        public boolean hasStableIds() {
            SpinnerAdapter spinnerAdapter = this.f8848a;
            return spinnerAdapter != null && spinnerAdapter.hasStableIds();
        }

        @Override // android.widget.Adapter
        public boolean isEmpty() {
            return getCount() == 0;
        }

        @Override // android.widget.ListAdapter
        public boolean isEnabled(int i10) {
            ListAdapter listAdapter = this.f8849b;
            if (listAdapter != null) {
                return listAdapter.isEnabled(i10);
            }
            return true;
        }

        @Override // android.widget.Adapter
        public void registerDataSetObserver(DataSetObserver dataSetObserver) {
            SpinnerAdapter spinnerAdapter = this.f8848a;
            if (spinnerAdapter != null) {
                spinnerAdapter.registerDataSetObserver(dataSetObserver);
            }
        }

        @Override // android.widget.Adapter
        public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
            SpinnerAdapter spinnerAdapter = this.f8848a;
            if (spinnerAdapter != null) {
                spinnerAdapter.unregisterDataSetObserver(dataSetObserver);
            }
        }
    }

    public class f extends F implements g {

        /* renamed from: G, reason: collision with root package name */
        public CharSequence f8850G;

        /* renamed from: H, reason: collision with root package name */
        public ListAdapter f8851H;

        /* renamed from: I, reason: collision with root package name */
        public final Rect f8852I;

        /* renamed from: J, reason: collision with root package name */
        public int f8853J;

        public class a implements AdapterView.OnItemClickListener {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ AppCompatSpinner f8855a;

            public a(AppCompatSpinner appCompatSpinner) {
                this.f8855a = appCompatSpinner;
            }

            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i10, long j10) {
                AppCompatSpinner.this.setSelection(i10);
                if (AppCompatSpinner.this.getOnItemClickListener() != null) {
                    f fVar = f.this;
                    AppCompatSpinner.this.performItemClick(view, i10, fVar.f8851H.getItemId(i10));
                }
                f.this.dismiss();
            }
        }

        public class b implements ViewTreeObserver.OnGlobalLayoutListener {
            public b() {
            }

            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                f fVar = f.this;
                if (!fVar.T(AppCompatSpinner.this)) {
                    f.this.dismiss();
                } else {
                    f.this.R();
                    f.super.show();
                }
            }
        }

        public class c implements PopupWindow.OnDismissListener {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ViewTreeObserver.OnGlobalLayoutListener f8858a;

            public c(ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
                this.f8858a = onGlobalLayoutListener;
            }

            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                ViewTreeObserver viewTreeObserver = AppCompatSpinner.this.getViewTreeObserver();
                if (viewTreeObserver != null) {
                    viewTreeObserver.removeGlobalOnLayoutListener(this.f8858a);
                }
            }
        }

        public f(Context context, AttributeSet attributeSet, int i10) {
            super(context, attributeSet, i10);
            this.f8852I = new Rect();
            B(AppCompatSpinner.this);
            H(true);
            N(0);
            J(new a(AppCompatSpinner.this));
        }

        public void R() {
            int i10;
            Drawable drawableF = f();
            if (drawableF != null) {
                drawableF.getPadding(AppCompatSpinner.this.f8840h);
                i10 = b0.b(AppCompatSpinner.this) ? AppCompatSpinner.this.f8840h.right : -AppCompatSpinner.this.f8840h.left;
            } else {
                Rect rect = AppCompatSpinner.this.f8840h;
                rect.right = 0;
                rect.left = 0;
                i10 = 0;
            }
            int paddingLeft = AppCompatSpinner.this.getPaddingLeft();
            int paddingRight = AppCompatSpinner.this.getPaddingRight();
            int width = AppCompatSpinner.this.getWidth();
            AppCompatSpinner appCompatSpinner = AppCompatSpinner.this;
            int i11 = appCompatSpinner.f8839g;
            if (i11 == -2) {
                int iA = appCompatSpinner.a((SpinnerAdapter) this.f8851H, f());
                int i12 = AppCompatSpinner.this.getContext().getResources().getDisplayMetrics().widthPixels;
                Rect rect2 = AppCompatSpinner.this.f8840h;
                int i13 = (i12 - rect2.left) - rect2.right;
                if (iA > i13) {
                    iA = i13;
                }
                D(Math.max(iA, (width - paddingLeft) - paddingRight));
            } else if (i11 == -1) {
                D((width - paddingLeft) - paddingRight);
            } else {
                D(i11);
            }
            d(b0.b(AppCompatSpinner.this) ? i10 + (((width - paddingRight) - x()) - S()) : i10 + paddingLeft + S());
        }

        public int S() {
            return this.f8853J;
        }

        public boolean T(View view) {
            return view.isAttachedToWindow() && view.getGlobalVisibleRect(this.f8852I);
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.g
        public CharSequence e() {
            return this.f8850G;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.g
        public void g(CharSequence charSequence) {
            this.f8850G = charSequence;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.g
        public void i(int i10) {
            this.f8853J = i10;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.g
        public void j(int i10, int i11) {
            ViewTreeObserver viewTreeObserver;
            boolean zIsShowing = isShowing();
            R();
            G(2);
            super.show();
            ListView listViewN = n();
            listViewN.setChoiceMode(1);
            listViewN.setTextDirection(i10);
            listViewN.setTextAlignment(i11);
            O(AppCompatSpinner.this.getSelectedItemPosition());
            if (zIsShowing || (viewTreeObserver = AppCompatSpinner.this.getViewTreeObserver()) == null) {
                return;
            }
            b bVar = new b();
            viewTreeObserver.addOnGlobalLayoutListener(bVar);
            I(new c(bVar));
        }

        @Override // androidx.appcompat.widget.F, androidx.appcompat.widget.AppCompatSpinner.g
        public void l(ListAdapter listAdapter) {
            super.l(listAdapter);
            this.f8851H = listAdapter;
        }
    }

    public interface g {
        int a();

        void b(Drawable drawable);

        void d(int i10);

        void dismiss();

        CharSequence e();

        Drawable f();

        void g(CharSequence charSequence);

        void h(int i10);

        void i(int i10);

        boolean isShowing();

        void j(int i10, int i11);

        int k();

        void l(ListAdapter listAdapter);
    }

    public AppCompatSpinner(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.spinnerStyle);
    }

    public int a(SpinnerAdapter spinnerAdapter, Drawable drawable) {
        int i10 = 0;
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
            if (itemViewType != i10) {
                view = null;
                i10 = itemViewType;
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
        drawable.getPadding(this.f8840h);
        Rect rect = this.f8840h;
        return iMax2 + rect.left + rect.right;
    }

    public void b() {
        this.f8838f.j(getTextDirection(), getTextAlignment());
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        C1291d c1291d = this.f8833a;
        if (c1291d != null) {
            c1291d.b();
        }
    }

    @Override // android.widget.Spinner
    public int getDropDownHorizontalOffset() {
        g gVar = this.f8838f;
        return gVar != null ? gVar.a() : super.getDropDownHorizontalOffset();
    }

    @Override // android.widget.Spinner
    public int getDropDownVerticalOffset() {
        g gVar = this.f8838f;
        return gVar != null ? gVar.k() : super.getDropDownVerticalOffset();
    }

    @Override // android.widget.Spinner
    public int getDropDownWidth() {
        return this.f8838f != null ? this.f8839g : super.getDropDownWidth();
    }

    public final g getInternalPopup() {
        return this.f8838f;
    }

    @Override // android.widget.Spinner
    public Drawable getPopupBackground() {
        g gVar = this.f8838f;
        return gVar != null ? gVar.f() : super.getPopupBackground();
    }

    @Override // android.widget.Spinner
    public Context getPopupContext() {
        return this.f8834b;
    }

    @Override // android.widget.Spinner
    public CharSequence getPrompt() {
        g gVar = this.f8838f;
        return gVar != null ? gVar.e() : super.getPrompt();
    }

    public ColorStateList getSupportBackgroundTintList() {
        C1291d c1291d = this.f8833a;
        if (c1291d != null) {
            return c1291d.c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C1291d c1291d = this.f8833a;
        if (c1291d != null) {
            return c1291d.d();
        }
        return null;
    }

    @Override // android.widget.Spinner, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        g gVar = this.f8838f;
        if (gVar == null || !gVar.isShowing()) {
            return;
        }
        this.f8838f.dismiss();
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        if (this.f8838f == null || View.MeasureSpec.getMode(i10) != Integer.MIN_VALUE) {
            return;
        }
        setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), a(getAdapter(), getBackground())), View.MeasureSpec.getSize(i10)), getMeasuredHeight());
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        ViewTreeObserver viewTreeObserver;
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (!savedState.mShowDropdown || (viewTreeObserver = getViewTreeObserver()) == null) {
            return;
        }
        viewTreeObserver.addOnGlobalLayoutListener(new b());
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        g gVar = this.f8838f;
        savedState.mShowDropdown = gVar != null && gVar.isShowing();
        return savedState;
    }

    @Override // android.widget.Spinner, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        E e10 = this.f8835c;
        if (e10 == null || !e10.onTouch(this, motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    @Override // android.widget.Spinner, android.view.View
    public boolean performClick() {
        g gVar = this.f8838f;
        if (gVar == null) {
            return super.performClick();
        }
        if (gVar.isShowing()) {
            return true;
        }
        b();
        return true;
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C1291d c1291d = this.f8833a;
        if (c1291d != null) {
            c1291d.f(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i10) {
        super.setBackgroundResource(i10);
        C1291d c1291d = this.f8833a;
        if (c1291d != null) {
            c1291d.g(i10);
        }
    }

    @Override // android.widget.Spinner
    public void setDropDownHorizontalOffset(int i10) {
        g gVar = this.f8838f;
        if (gVar == null) {
            super.setDropDownHorizontalOffset(i10);
        } else {
            gVar.i(i10);
            this.f8838f.d(i10);
        }
    }

    @Override // android.widget.Spinner
    public void setDropDownVerticalOffset(int i10) {
        g gVar = this.f8838f;
        if (gVar != null) {
            gVar.h(i10);
        } else {
            super.setDropDownVerticalOffset(i10);
        }
    }

    @Override // android.widget.Spinner
    public void setDropDownWidth(int i10) {
        if (this.f8838f != null) {
            this.f8839g = i10;
        } else {
            super.setDropDownWidth(i10);
        }
    }

    @Override // android.widget.Spinner
    public void setPopupBackgroundDrawable(Drawable drawable) {
        g gVar = this.f8838f;
        if (gVar != null) {
            gVar.b(drawable);
        } else {
            super.setPopupBackgroundDrawable(drawable);
        }
    }

    @Override // android.widget.Spinner
    public void setPopupBackgroundResource(int i10) {
        setPopupBackgroundDrawable(C4027a.b(getPopupContext(), i10));
    }

    @Override // android.widget.Spinner
    public void setPrompt(CharSequence charSequence) {
        g gVar = this.f8838f;
        if (gVar != null) {
            gVar.g(charSequence);
        } else {
            super.setPrompt(charSequence);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        C1291d c1291d = this.f8833a;
        if (c1291d != null) {
            c1291d.i(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        C1291d c1291d = this.f8833a;
        if (c1291d != null) {
            c1291d.j(mode);
        }
    }

    public AppCompatSpinner(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, -1);
    }

    @Override // android.widget.AdapterView
    public void setAdapter(SpinnerAdapter spinnerAdapter) {
        if (!this.f8837e) {
            this.f8836d = spinnerAdapter;
            return;
        }
        super.setAdapter(spinnerAdapter);
        if (this.f8838f != null) {
            Context context = this.f8834b;
            if (context == null) {
                context = getContext();
            }
            this.f8838f.l(new e(spinnerAdapter, context.getTheme()));
        }
    }

    public AppCompatSpinner(Context context, AttributeSet attributeSet, int i10, int i11) {
        this(context, attributeSet, i10, i11, null);
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
    /* JADX WARN: Type inference failed for: r6v0, types: [android.view.View, androidx.appcompat.widget.AppCompatSpinner] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public AppCompatSpinner(android.content.Context r7, android.util.AttributeSet r8, int r9, int r10, android.content.res.Resources.Theme r11) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 230
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.AppCompatSpinner.<init>(android.content.Context, android.util.AttributeSet, int, int, android.content.res.Resources$Theme):void");
    }
}
