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
import android.widget.PopupWindow;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.ThemedSpinnerAdapter;
import androidx.appcompat.app.AlertController;
import androidx.appcompat.app.f;
import java.util.Objects;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class AppCompatSpinner extends Spinner {

    /* renamed from: l, reason: collision with root package name */
    @SuppressLint({"ResourceType"})
    public static final int[] f632l = {R.attr.spinnerMode};

    /* renamed from: a, reason: collision with root package name */
    public final androidx.appcompat.widget.d f633a;

    /* renamed from: b, reason: collision with root package name */
    public final Context f634b;

    /* renamed from: c, reason: collision with root package name */
    public final y f635c;

    /* renamed from: d, reason: collision with root package name */
    public SpinnerAdapter f636d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f637e;
    public final f h;

    /* renamed from: j, reason: collision with root package name */
    public int f638j;

    /* renamed from: k, reason: collision with root package name */
    public final Rect f639k;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        boolean mShowDropdown;

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        public class a implements Parcelable.Creator<SavedState> {
            @Override // android.os.Parcelable.Creator
            public final SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final SavedState[] newArray(int i10) {
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

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            AppCompatSpinner appCompatSpinner = AppCompatSpinner.this;
            if (!appCompatSpinner.getInternalPopup().isShowing()) {
                appCompatSpinner.h.show(appCompatSpinner.getTextDirection(), appCompatSpinner.getTextAlignment());
            }
            ViewTreeObserver viewTreeObserver = appCompatSpinner.getViewTreeObserver();
            if (viewTreeObserver != null) {
                viewTreeObserver.removeOnGlobalLayoutListener(this);
            }
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class b {
        public static void a(ThemedSpinnerAdapter themedSpinnerAdapter, Resources.Theme theme) {
            if (Objects.equals(themedSpinnerAdapter.getDropDownViewTheme(), theme)) {
                return;
            }
            themedSpinnerAdapter.setDropDownViewTheme(theme);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class c implements f, DialogInterface.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public androidx.appcompat.app.f f641a;

        /* renamed from: b, reason: collision with root package name */
        public d f642b;

        /* renamed from: c, reason: collision with root package name */
        public CharSequence f643c;

        public c() {
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.f
        public final void b(int i10) {
            Log.e("AppCompatSpinner", "Cannot set horizontal (original) offset for MODE_DIALOG, ignoring");
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.f
        public final void dismiss() {
            androidx.appcompat.app.f fVar = this.f641a;
            if (fVar != null) {
                fVar.dismiss();
                this.f641a = null;
            }
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.f
        public final Drawable getBackground() {
            return null;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.f
        public final CharSequence getHintText() {
            return this.f643c;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.f
        public final int getHorizontalOffset() {
            return 0;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.f
        public final int getVerticalOffset() {
            return 0;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.f
        public final boolean isShowing() {
            androidx.appcompat.app.f fVar = this.f641a;
            if (fVar != null) {
                return fVar.isShowing();
            }
            return false;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface dialogInterface, int i10) {
            AppCompatSpinner appCompatSpinner = AppCompatSpinner.this;
            appCompatSpinner.setSelection(i10);
            if (appCompatSpinner.getOnItemClickListener() != null) {
                appCompatSpinner.performItemClick(null, i10, this.f642b.getItemId(i10));
            }
            dismiss();
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.f
        public final void setAdapter(ListAdapter listAdapter) {
            this.f642b = (d) listAdapter;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.f
        public final void setBackgroundDrawable(Drawable drawable) {
            Log.e("AppCompatSpinner", "Cannot set popup background for MODE_DIALOG, ignoring");
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.f
        public final void setHorizontalOffset(int i10) {
            Log.e("AppCompatSpinner", "Cannot set horizontal offset for MODE_DIALOG, ignoring");
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.f
        public final void setPromptText(CharSequence charSequence) {
            this.f643c = charSequence;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.f
        public final void setVerticalOffset(int i10) {
            Log.e("AppCompatSpinner", "Cannot set vertical offset for MODE_DIALOG, ignoring");
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.f
        public final void show(int i10, int i11) {
            if (this.f642b == null) {
                return;
            }
            AppCompatSpinner appCompatSpinner = AppCompatSpinner.this;
            f.a aVar = new f.a(appCompatSpinner.getPopupContext());
            CharSequence charSequence = this.f643c;
            AlertController.b bVar = aVar.f323a;
            if (charSequence != null) {
                bVar.f242d = charSequence;
            }
            d dVar = this.f642b;
            int selectedItemPosition = appCompatSpinner.getSelectedItemPosition();
            bVar.f250m = dVar;
            bVar.f251n = this;
            bVar.f255s = selectedItemPosition;
            bVar.r = true;
            androidx.appcompat.app.f fVarA = aVar.a();
            this.f641a = fVarA;
            AlertController.RecycleListView recycleListView = fVarA.h.f218f;
            recycleListView.setTextDirection(i10);
            recycleListView.setTextAlignment(i11);
            this.f641a.show();
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class d implements ListAdapter, SpinnerAdapter {

        /* renamed from: a, reason: collision with root package name */
        public SpinnerAdapter f645a;

        /* renamed from: b, reason: collision with root package name */
        public ListAdapter f646b;

        @Override // android.widget.ListAdapter
        public final boolean areAllItemsEnabled() {
            ListAdapter listAdapter = this.f646b;
            if (listAdapter != null) {
                return listAdapter.areAllItemsEnabled();
            }
            return true;
        }

        @Override // android.widget.Adapter
        public final int getCount() {
            SpinnerAdapter spinnerAdapter = this.f645a;
            if (spinnerAdapter == null) {
                return 0;
            }
            return spinnerAdapter.getCount();
        }

        @Override // android.widget.SpinnerAdapter
        public final View getDropDownView(int i10, View view, ViewGroup viewGroup) {
            SpinnerAdapter spinnerAdapter = this.f645a;
            if (spinnerAdapter == null) {
                return null;
            }
            return spinnerAdapter.getDropDownView(i10, view, viewGroup);
        }

        @Override // android.widget.Adapter
        public final Object getItem(int i10) {
            SpinnerAdapter spinnerAdapter = this.f645a;
            if (spinnerAdapter == null) {
                return null;
            }
            return spinnerAdapter.getItem(i10);
        }

        @Override // android.widget.Adapter
        public final long getItemId(int i10) {
            SpinnerAdapter spinnerAdapter = this.f645a;
            if (spinnerAdapter == null) {
                return -1L;
            }
            return spinnerAdapter.getItemId(i10);
        }

        @Override // android.widget.Adapter
        public final int getItemViewType(int i10) {
            return 0;
        }

        @Override // android.widget.Adapter
        public final View getView(int i10, View view, ViewGroup viewGroup) {
            return getDropDownView(i10, view, viewGroup);
        }

        @Override // android.widget.Adapter
        public final int getViewTypeCount() {
            return 1;
        }

        @Override // android.widget.Adapter
        public final boolean hasStableIds() {
            SpinnerAdapter spinnerAdapter = this.f645a;
            return spinnerAdapter != null && spinnerAdapter.hasStableIds();
        }

        @Override // android.widget.Adapter
        public final boolean isEmpty() {
            return getCount() == 0;
        }

        @Override // android.widget.ListAdapter
        public final boolean isEnabled(int i10) {
            ListAdapter listAdapter = this.f646b;
            if (listAdapter != null) {
                return listAdapter.isEnabled(i10);
            }
            return true;
        }

        @Override // android.widget.Adapter
        public final void registerDataSetObserver(DataSetObserver dataSetObserver) {
            SpinnerAdapter spinnerAdapter = this.f645a;
            if (spinnerAdapter != null) {
                spinnerAdapter.registerDataSetObserver(dataSetObserver);
            }
        }

        @Override // android.widget.Adapter
        public final void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
            SpinnerAdapter spinnerAdapter = this.f645a;
            if (spinnerAdapter != null) {
                spinnerAdapter.unregisterDataSetObserver(dataSetObserver);
            }
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class e extends k0 implements f {
        public CharSequence D;
        public d E;
        public final Rect F;
        public int G;

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        public class a implements AdapterView.OnItemClickListener {
            public a() {
            }

            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView<?> adapterView, View view, int i10, long j10) {
                e eVar = e.this;
                AppCompatSpinner appCompatSpinner = AppCompatSpinner.this;
                appCompatSpinner.setSelection(i10);
                if (appCompatSpinner.getOnItemClickListener() != null) {
                    appCompatSpinner.performItemClick(view, i10, eVar.E.getItemId(i10));
                }
                eVar.dismiss();
            }
        }

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        public class b implements ViewTreeObserver.OnGlobalLayoutListener {
            public b() {
            }

            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                e eVar = e.this;
                AppCompatSpinner appCompatSpinner = AppCompatSpinner.this;
                eVar.getClass();
                if (!appCompatSpinner.isAttachedToWindow() || !appCompatSpinner.getGlobalVisibleRect(eVar.F)) {
                    eVar.dismiss();
                } else {
                    eVar.f();
                    eVar.show();
                }
            }
        }

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        public class c implements PopupWindow.OnDismissListener {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b f649a;

            public c(b bVar) {
                this.f649a = bVar;
            }

            @Override // android.widget.PopupWindow.OnDismissListener
            public final void onDismiss() {
                ViewTreeObserver viewTreeObserver = AppCompatSpinner.this.getViewTreeObserver();
                if (viewTreeObserver != null) {
                    viewTreeObserver.removeGlobalOnLayoutListener(this.f649a);
                }
            }
        }

        public e(Context context, AttributeSet attributeSet, int i10) {
            super(context, attributeSet, i10, 0);
            this.F = new Rect();
            this.r = AppCompatSpinner.this;
            this.B = true;
            this.C.setFocusable(true);
            this.f875s = new a();
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.f
        public final void b(int i10) {
            this.G = i10;
        }

        public final void f() {
            int i10;
            AppCompatSpinner appCompatSpinner = AppCompatSpinner.this;
            Rect rect = appCompatSpinner.f639k;
            Drawable background = this.C.getBackground();
            if (background != null) {
                background.getPadding(rect);
                i10 = appCompatSpinner.getLayoutDirection() == 1 ? rect.right : -rect.left;
            } else {
                i10 = 0;
                rect.right = 0;
                rect.left = 0;
            }
            int paddingLeft = appCompatSpinner.getPaddingLeft();
            int paddingRight = appCompatSpinner.getPaddingRight();
            int width = appCompatSpinner.getWidth();
            int i11 = appCompatSpinner.f638j;
            if (i11 == -2) {
                int iA = appCompatSpinner.a(this.E, this.C.getBackground());
                int i12 = (appCompatSpinner.getContext().getResources().getDisplayMetrics().widthPixels - rect.left) - rect.right;
                if (iA > i12) {
                    iA = i12;
                }
                e(Math.max(iA, (width - paddingLeft) - paddingRight));
            } else if (i11 == -1) {
                e((width - paddingLeft) - paddingRight);
            } else {
                e(i11);
            }
            this.h = appCompatSpinner.getLayoutDirection() == 1 ? (((width - paddingRight) - this.f866e) - this.G) + i10 : paddingLeft + this.G + i10;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.f
        public final CharSequence getHintText() {
            return this.D;
        }

        @Override // androidx.appcompat.widget.k0, androidx.appcompat.widget.AppCompatSpinner.f
        public final void setAdapter(ListAdapter listAdapter) {
            super.setAdapter(listAdapter);
            this.E = (d) listAdapter;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.f
        public final void setPromptText(CharSequence charSequence) {
            this.D = charSequence;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.f
        public final void show(int i10, int i11) {
            ViewTreeObserver viewTreeObserver;
            boolean zIsShowing = this.C.isShowing();
            f();
            this.C.setInputMethodMode(2);
            show();
            g0 g0Var = this.f864c;
            g0Var.setChoiceMode(1);
            g0Var.setTextDirection(i10);
            g0Var.setTextAlignment(i11);
            AppCompatSpinner appCompatSpinner = AppCompatSpinner.this;
            int selectedItemPosition = appCompatSpinner.getSelectedItemPosition();
            g0 g0Var2 = this.f864c;
            if (this.C.isShowing() && g0Var2 != null) {
                g0Var2.setListSelectionHidden(false);
                g0Var2.setSelection(selectedItemPosition);
                if (g0Var2.getChoiceMode() != 0) {
                    g0Var2.setItemChecked(selectedItemPosition, true);
                }
            }
            if (zIsShowing || (viewTreeObserver = appCompatSpinner.getViewTreeObserver()) == null) {
                return;
            }
            b bVar = new b();
            viewTreeObserver.addOnGlobalLayoutListener(bVar);
            this.C.setOnDismissListener(new c(bVar));
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public interface f {
        void b(int i10);

        void dismiss();

        Drawable getBackground();

        CharSequence getHintText();

        int getHorizontalOffset();

        int getVerticalOffset();

        boolean isShowing();

        void setAdapter(ListAdapter listAdapter);

        void setBackgroundDrawable(Drawable drawable);

        void setHorizontalOffset(int i10);

        void setPromptText(CharSequence charSequence);

        void setVerticalOffset(int i10);

        void show(int i10, int i11);
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00d0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public AppCompatSpinner(android.content.Context r12, android.util.AttributeSet r13, int r14) throws java.lang.Throwable {
        /*
            r11 = this;
            r11.<init>(r12, r13, r14)
            android.graphics.Rect r0 = new android.graphics.Rect
            r0.<init>()
            r11.f639k = r0
            android.content.Context r0 = r11.getContext()
            androidx.appcompat.widget.s0.a(r11, r0)
            int[] r0 = g.a.f8939u
            androidx.appcompat.widget.x0 r1 = androidx.appcompat.widget.x0.e(r12, r13, r0, r14)
            android.content.res.TypedArray r2 = r1.f948b
            androidx.appcompat.widget.d r3 = new androidx.appcompat.widget.d
            r3.<init>(r11)
            r11.f633a = r3
            r3 = 4
            r4 = 0
            int r3 = r2.getResourceId(r3, r4)
            if (r3 == 0) goto L30
            k.c r5 = new k.c
            r5.<init>(r12, r3)
            r11.f634b = r5
            goto L32
        L30:
            r11.f634b = r12
        L32:
            r3 = -1
            r5 = 0
            int[] r6 = androidx.appcompat.widget.AppCompatSpinner.f632l     // Catch: java.lang.Throwable -> L4f java.lang.Exception -> L52
            android.content.res.TypedArray r6 = r12.obtainStyledAttributes(r13, r6, r14, r4)     // Catch: java.lang.Throwable -> L4f java.lang.Exception -> L52
            boolean r7 = r6.hasValue(r4)     // Catch: java.lang.Throwable -> L45 java.lang.Exception -> L49
            if (r7 == 0) goto L4b
            int r3 = r6.getInt(r4, r4)     // Catch: java.lang.Throwable -> L45 java.lang.Exception -> L49
            goto L4b
        L45:
            r11 = move-exception
            r5 = r6
            goto Lce
        L49:
            r7 = move-exception
            goto L54
        L4b:
            r6.recycle()
            goto L5e
        L4f:
            r11 = move-exception
            goto Lce
        L52:
            r7 = move-exception
            r6 = r5
        L54:
            java.lang.String r8 = "AppCompatSpinner"
            java.lang.String r9 = "Could not read android:spinnerMode"
            android.util.Log.i(r8, r9, r7)     // Catch: java.lang.Throwable -> L45
            if (r6 == 0) goto L5e
            goto L4b
        L5e:
            r6 = 2
            r7 = 1
            if (r3 == 0) goto L96
            if (r3 == r7) goto L65
            goto La3
        L65:
            androidx.appcompat.widget.AppCompatSpinner$e r3 = new androidx.appcompat.widget.AppCompatSpinner$e
            android.content.Context r8 = r11.f634b
            r3.<init>(r8, r13, r14)
            android.content.Context r8 = r11.f634b
            androidx.appcompat.widget.x0 r0 = androidx.appcompat.widget.x0.e(r8, r13, r0, r14)
            r8 = -2
            android.content.res.TypedArray r9 = r0.f948b
            r10 = 3
            int r8 = r9.getLayoutDimension(r10, r8)
            r11.f638j = r8
            android.graphics.drawable.Drawable r8 = r0.b(r7)
            r3.setBackgroundDrawable(r8)
            java.lang.String r6 = r2.getString(r6)
            r3.D = r6
            r0.f()
            r11.h = r3
            androidx.appcompat.widget.y r0 = new androidx.appcompat.widget.y
            r0.<init>(r11, r11, r3)
            r11.f635c = r0
            goto La3
        L96:
            androidx.appcompat.widget.AppCompatSpinner$c r0 = new androidx.appcompat.widget.AppCompatSpinner$c
            r0.<init>()
            r11.h = r0
            java.lang.String r3 = r2.getString(r6)
            r0.f643c = r3
        La3:
            java.lang.CharSequence[] r0 = r2.getTextArray(r4)
            if (r0 == 0) goto Lba
            android.widget.ArrayAdapter r2 = new android.widget.ArrayAdapter
            r3 = 17367048(0x1090008, float:2.5162948E-38)
            r2.<init>(r12, r3, r0)
            r12 = 2131493218(0x7f0c0162, float:1.860991E38)
            r2.setDropDownViewResource(r12)
            r11.setAdapter(r2)
        Lba:
            r1.f()
            r11.f637e = r7
            android.widget.SpinnerAdapter r12 = r11.f636d
            if (r12 == 0) goto Lc8
            r11.setAdapter(r12)
            r11.f636d = r5
        Lc8:
            androidx.appcompat.widget.d r11 = r11.f633a
            r11.d(r13, r14)
            return
        Lce:
            if (r5 == 0) goto Ld3
            r5.recycle()
        Ld3:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.AppCompatSpinner.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    public final int a(SpinnerAdapter spinnerAdapter, Drawable drawable) {
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
        Rect rect = this.f639k;
        drawable.getPadding(rect);
        return rect.left + rect.right + iMax2;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        androidx.appcompat.widget.d dVar = this.f633a;
        if (dVar != null) {
            dVar.a();
        }
    }

    @Override // android.widget.Spinner
    public int getDropDownHorizontalOffset() {
        f fVar = this.h;
        return fVar != null ? fVar.getHorizontalOffset() : super.getDropDownHorizontalOffset();
    }

    @Override // android.widget.Spinner
    public int getDropDownVerticalOffset() {
        f fVar = this.h;
        return fVar != null ? fVar.getVerticalOffset() : super.getDropDownVerticalOffset();
    }

    @Override // android.widget.Spinner
    public int getDropDownWidth() {
        return this.h != null ? this.f638j : super.getDropDownWidth();
    }

    public final f getInternalPopup() {
        return this.h;
    }

    @Override // android.widget.Spinner
    public Drawable getPopupBackground() {
        f fVar = this.h;
        return fVar != null ? fVar.getBackground() : super.getPopupBackground();
    }

    @Override // android.widget.Spinner
    public Context getPopupContext() {
        return this.f634b;
    }

    @Override // android.widget.Spinner
    public CharSequence getPrompt() {
        f fVar = this.h;
        return fVar != null ? fVar.getHintText() : super.getPrompt();
    }

    public ColorStateList getSupportBackgroundTintList() {
        androidx.appcompat.widget.d dVar = this.f633a;
        if (dVar != null) {
            return dVar.b();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        androidx.appcompat.widget.d dVar = this.f633a;
        if (dVar != null) {
            return dVar.c();
        }
        return null;
    }

    @Override // android.widget.Spinner, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        f fVar = this.h;
        if (fVar == null || !fVar.isShowing()) {
            return;
        }
        fVar.dismiss();
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public final void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        if (this.h == null || View.MeasureSpec.getMode(i10) != Integer.MIN_VALUE) {
            return;
        }
        setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), a(getAdapter(), getBackground())), View.MeasureSpec.getSize(i10)), getMeasuredHeight());
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        ViewTreeObserver viewTreeObserver;
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (!savedState.mShowDropdown || (viewTreeObserver = getViewTreeObserver()) == null) {
            return;
        }
        viewTreeObserver.addOnGlobalLayoutListener(new a());
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public final Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        f fVar = this.h;
        savedState.mShowDropdown = fVar != null && fVar.isShowing();
        return savedState;
    }

    @Override // android.widget.Spinner, android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        y yVar = this.f635c;
        if (yVar == null || !yVar.onTouch(this, motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    @Override // android.widget.Spinner, android.view.View
    public final boolean performClick() {
        f fVar = this.h;
        if (fVar == null) {
            return super.performClick();
        }
        if (fVar.isShowing()) {
            return true;
        }
        fVar.show(getTextDirection(), getTextAlignment());
        return true;
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        androidx.appcompat.widget.d dVar = this.f633a;
        if (dVar != null) {
            dVar.e();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i10) {
        super.setBackgroundResource(i10);
        androidx.appcompat.widget.d dVar = this.f633a;
        if (dVar != null) {
            dVar.f(i10);
        }
    }

    @Override // android.widget.Spinner
    public void setDropDownHorizontalOffset(int i10) {
        f fVar = this.h;
        if (fVar == null) {
            super.setDropDownHorizontalOffset(i10);
        } else {
            fVar.b(i10);
            fVar.setHorizontalOffset(i10);
        }
    }

    @Override // android.widget.Spinner
    public void setDropDownVerticalOffset(int i10) {
        f fVar = this.h;
        if (fVar != null) {
            fVar.setVerticalOffset(i10);
        } else {
            super.setDropDownVerticalOffset(i10);
        }
    }

    @Override // android.widget.Spinner
    public void setDropDownWidth(int i10) {
        if (this.h != null) {
            this.f638j = i10;
        } else {
            super.setDropDownWidth(i10);
        }
    }

    @Override // android.widget.Spinner
    public void setPopupBackgroundDrawable(Drawable drawable) {
        f fVar = this.h;
        if (fVar != null) {
            fVar.setBackgroundDrawable(drawable);
        } else {
            super.setPopupBackgroundDrawable(drawable);
        }
    }

    @Override // android.widget.Spinner
    public void setPopupBackgroundResource(int i10) {
        setPopupBackgroundDrawable(androidx.datastore.preferences.protobuf.b1.L(i10, getPopupContext()));
    }

    @Override // android.widget.Spinner
    public void setPrompt(CharSequence charSequence) {
        f fVar = this.h;
        if (fVar != null) {
            fVar.setPromptText(charSequence);
        } else {
            super.setPrompt(charSequence);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        androidx.appcompat.widget.d dVar = this.f633a;
        if (dVar != null) {
            dVar.h(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        androidx.appcompat.widget.d dVar = this.f633a;
        if (dVar != null) {
            dVar.i(mode);
        }
    }

    @Override // android.widget.AdapterView
    public void setAdapter(SpinnerAdapter spinnerAdapter) {
        if (!this.f637e) {
            this.f636d = spinnerAdapter;
            return;
        }
        super.setAdapter(spinnerAdapter);
        f fVar = this.h;
        if (fVar != null) {
            Context context = this.f634b;
            if (context == null) {
                context = getContext();
            }
            Resources.Theme theme = context.getTheme();
            d dVar = new d();
            dVar.f645a = spinnerAdapter;
            if (spinnerAdapter instanceof ListAdapter) {
                dVar.f646b = (ListAdapter) spinnerAdapter;
            }
            if (theme != null) {
                if (spinnerAdapter instanceof ThemedSpinnerAdapter) {
                    b.a((ThemedSpinnerAdapter) spinnerAdapter, theme);
                } else if (spinnerAdapter instanceof t0) {
                    t0 t0Var = (t0) spinnerAdapter;
                    if (t0Var.getDropDownViewTheme() == null) {
                        t0Var.a();
                    }
                }
            }
            fVar.setAdapter(dVar);
        }
    }
}
