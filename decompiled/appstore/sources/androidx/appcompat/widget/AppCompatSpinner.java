package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
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
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import androidx.annotation.DoNotInline;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$layout;
import androidx.appcompat.R$styleable;
import androidx.appcompat.view.menu.ShowableListMenu;
import androidx.core.view.TintableBackgroundView;
import androidx.core.view.ViewCompat;

/* JADX INFO: loaded from: classes.dex */
public class AppCompatSpinner extends Spinner implements TintableBackgroundView {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int[] f784i = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final androidx.appcompat.widget.c f785a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f786b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public t f787c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public SpinnerAdapter f788d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f789e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public SpinnerPopup f790f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f791g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Rect f792h;

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        boolean mShowDropdown;

        public class a implements Parcelable.Creator {
            public a() {
            }

            public SavedState a(Parcel r10) {
                return new SavedState(r10);
            }

            public SavedState[] b(int r10) {
                return new SavedState[r10];
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ Object createFromParcel(Parcel r10) {
                return a(r10);
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ Object[] newArray(int r10) {
                return b(r10);
            }
        }

        static {
            CREATOR = new a();
        }

        public SavedState(Parcelable r10) {
            super(r10);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel r10, int r11) {
            super.writeToParcel(r10, r11);
            r10.writeByte(this.mShowDropdown ? 1 : 0);
        }

        public SavedState(Parcel r10) {
            super(r10);
            if (r10.readByte() == 0) goto L5;
            boolean r11 = true;
        L6:
            this.mShowDropdown = r11;
            return;
        L5:
            r11 = false;
            goto L6
        }
    }

    @VisibleForTesting
    public interface SpinnerPopup {
        void dismiss();

        Drawable getBackground();

        CharSequence getHintText();

        int getHorizontalOffset();

        int getHorizontalOriginalOffset();

        int getVerticalOffset();

        boolean isShowing();

        void setAdapter(ListAdapter r10);

        void setBackgroundDrawable(Drawable r10);

        void setHorizontalOffset(int r10);

        void setHorizontalOriginalOffset(int r10);

        void setPromptText(CharSequence r10);

        void setVerticalOffset(int r10);

        void show(int r10, int r11);
    }

    public class a extends t {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final /* synthetic */ h f793j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final /* synthetic */ AppCompatSpinner f794k;

        public a(AppCompatSpinner r10, View r11, h r12) {
            this.f794k = r10;
            this.f793j = r12;
            super(r11);
        }

        @Override // androidx.appcompat.widget.t
        public ShowableListMenu b() {
            return this.f793j;
        }

        @Override // androidx.appcompat.widget.t
        public boolean c() {
            if (this.f794k.getInternalPopup().isShowing() == true) goto L7;
            this.f794k.b();
            return true;
        L7:
            return true;
        }
    }

    public class b implements ViewTreeObserver.OnGlobalLayoutListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AppCompatSpinner f795a;

        public b(AppCompatSpinner r10) {
            this.f795a = r10;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (this.f795a.getInternalPopup().isShowing() == true) goto L5;
            this.f795a.b();
        L5:
            ViewTreeObserver r10 = this.f795a.getViewTreeObserver();
            if (r10 == null) goto L9;
            c.a(r10, this);
            return;
        }
    }

    public static final class c {
        @DoNotInline
        public static void a(@NonNull ViewTreeObserver r10, @Nullable ViewTreeObserver.OnGlobalLayoutListener r11) {
            r10.removeOnGlobalLayoutListener(r11);
        }
    }

    public static final class d {
        @DoNotInline
        public static int a(@NonNull View r10) {
            return r10.getTextAlignment();
        }

        @DoNotInline
        public static int b(@NonNull View r10) {
            return r10.getTextDirection();
        }

        @DoNotInline
        public static void c(@NonNull View r10, int r11) {
            r10.setTextAlignment(r11);
        }

        @DoNotInline
        public static void d(@NonNull View r10, int r11) {
            r10.setTextDirection(r11);
        }
    }

    public static final class e {
        @DoNotInline
        public static void a(@NonNull android.widget.ThemedSpinnerAdapter r10, @Nullable Resources.Theme r11) {
            if (androidx.core.util.b.a(r10.getDropDownViewTheme(), r11) == true) goto L6;
            r10.setDropDownViewTheme(r11);
            return;
        }
    }

    public class f implements SpinnerPopup, DialogInterface.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public androidx.appcompat.app.a f796a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ListAdapter f797b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public CharSequence f798c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ AppCompatSpinner f799d;

        public f(AppCompatSpinner r10) {
            this.f799d = r10;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public void dismiss() {
            androidx.appcompat.app.a r10 = this.f796a;
            if (r10 == null) goto L6;
            r10.dismiss();
            this.f796a = null;
            return;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public Drawable getBackground() {
            return null;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public CharSequence getHintText() {
            return this.f798c;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public int getHorizontalOffset() {
            return 0;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public int getHorizontalOriginalOffset() {
            return 0;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public int getVerticalOffset() {
            return 0;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public boolean isShowing() {
            androidx.appcompat.app.a r10 = this.f796a;
            if (r10 != null) goto L7;
            return false;
        L7:
            return r10.isShowing();
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface r10, int r11) {
            this.f799d.setSelection(r11);
            if (this.f799d.getOnItemClickListener() == null) goto L5;
            this.f799d.performItemClick(null, r11, this.f797b.getItemId(r11));
        L5:
            dismiss();
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public void setAdapter(ListAdapter r10) {
            this.f797b = r10;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public void setBackgroundDrawable(Drawable r10) {
            Log.e("AppCompatSpinner", "Cannot set popup background for MODE_DIALOG, ignoring");
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public void setHorizontalOffset(int r10) {
            Log.e("AppCompatSpinner", "Cannot set horizontal offset for MODE_DIALOG, ignoring");
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public void setHorizontalOriginalOffset(int r10) {
            Log.e("AppCompatSpinner", "Cannot set horizontal (original) offset for MODE_DIALOG, ignoring");
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public void setPromptText(CharSequence r10) {
            this.f798c = r10;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public void setVerticalOffset(int r10) {
            Log.e("AppCompatSpinner", "Cannot set vertical offset for MODE_DIALOG, ignoring");
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public void show(int r10, int r11) {
            if (this.f797b != null) goto L5;
            return;
        L5:
            androidx.appcompat.app.a.C0006a r12 = new androidx.appcompat.app.a.C0006a(this.f799d.getPopupContext());
            CharSequence r13 = this.f798c;
            if (r13 == null) goto L8;
            r12.setTitle(r13);
        L8:
            androidx.appcompat.app.a r14 = r12.setSingleChoiceItems(this.f797b, this.f799d.getSelectedItemPosition(), this).create();
            this.f796a = r14;
            ListView r15 = r14.d();
            d.d(r15, r10);
            d.c(r15, r11);
            this.f796a.show();
        }
    }

    public static class g implements ListAdapter, SpinnerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public SpinnerAdapter f800a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ListAdapter f801b;

        public g(SpinnerAdapter r10, Resources.Theme r11) {
            this.f800a = r10;
            if ((r10 instanceof ListAdapter) == false) goto L5;
            this.f801b = (ListAdapter) r10;
        L5:
            if (r11 != null) goto L7;
            return;
        L7:
            if ((r10 instanceof android.widget.ThemedSpinnerAdapter) == false) goto L10;
            e.a((android.widget.ThemedSpinnerAdapter) r10, r11);
            return;
        L10:
            if ((r10 instanceof ThemedSpinnerAdapter) == false) goto L17;
            ThemedSpinnerAdapter r12 = (ThemedSpinnerAdapter) r10;
            if (r12.getDropDownViewTheme() != null) goto L18;
            r12.setDropDownViewTheme(r11);
            return;
        L18:
            return;
        }

        @Override // android.widget.ListAdapter
        public boolean areAllItemsEnabled() {
            ListAdapter r10 = this.f801b;
            if (r10 != null) goto L5;
            return true;
        L5:
            return r10.areAllItemsEnabled();
        }

        @Override // android.widget.Adapter
        public int getCount() {
            SpinnerAdapter r10 = this.f800a;
            if (r10 != null) goto L6;
            return 0;
        L6:
            return r10.getCount();
        }

        @Override // android.widget.SpinnerAdapter
        public View getDropDownView(int r10, View r11, ViewGroup r12) {
            SpinnerAdapter r13 = this.f800a;
            if (r13 != null) goto L6;
            return null;
        L6:
            return r13.getDropDownView(r10, r11, r12);
        }

        @Override // android.widget.Adapter
        public Object getItem(int r10) {
            SpinnerAdapter r11 = this.f800a;
            if (r11 != null) goto L6;
            return null;
        L6:
            return r11.getItem(r10);
        }

        @Override // android.widget.Adapter
        public long getItemId(int r10) {
            SpinnerAdapter r11 = this.f800a;
            if (r11 != null) goto L6;
            return -1;
        L6:
            return r11.getItemId(r10);
        }

        @Override // android.widget.Adapter
        public int getItemViewType(int r10) {
            return 0;
        }

        @Override // android.widget.Adapter
        public View getView(int r10, View r11, ViewGroup r12) {
            return getDropDownView(r10, r11, r12);
        }

        @Override // android.widget.Adapter
        public int getViewTypeCount() {
            return 1;
        }

        @Override // android.widget.Adapter
        public boolean hasStableIds() {
            SpinnerAdapter r10 = this.f800a;
            if (r10 != null) goto L5;
        L7:
            return false;
        L5:
            if (r10.hasStableIds() == false) goto L7;
            return true;
        }

        @Override // android.widget.Adapter
        public boolean isEmpty() {
            if (getCount() != 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // android.widget.ListAdapter
        public boolean isEnabled(int r10) {
            ListAdapter r11 = this.f801b;
            if (r11 != null) goto L5;
            return true;
        L5:
            return r11.isEnabled(r10);
        }

        @Override // android.widget.Adapter
        public void registerDataSetObserver(DataSetObserver r10) {
            SpinnerAdapter r11 = this.f800a;
            if (r11 == null) goto L6;
            r11.registerDataSetObserver(r10);
            return;
        }

        @Override // android.widget.Adapter
        public void unregisterDataSetObserver(DataSetObserver r10) {
            SpinnerAdapter r11 = this.f800a;
            if (r11 == null) goto L6;
            r11.unregisterDataSetObserver(r10);
            return;
        }
    }

    public class h extends ListPopupWindow implements SpinnerPopup {
        public CharSequence G;
        public ListAdapter H;
        public final Rect I;

        /* JADX INFO: renamed from: J, reason: collision with root package name */
        public int f802J;
        public final /* synthetic */ AppCompatSpinner K;

        public class a implements AdapterView.OnItemClickListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ AppCompatSpinner f803a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ h f804b;

            public a(h r10, AppCompatSpinner r11) {
                this.f804b = r10;
                this.f803a = r11;
            }

            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView r10, View r11, int r12, long r13) {
                this.f804b.K.setSelection(r12);
                if (this.f804b.K.getOnItemClickListener() == null) goto L5;
                h r14 = this.f804b;
                r14.K.performItemClick(r11, r12, r14.H.getItemId(r12));
            L5:
                this.f804b.dismiss();
            }
        }

        public class b implements ViewTreeObserver.OnGlobalLayoutListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ h f805a;

            public b(h r10) {
                this.f805a = r10;
            }

            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                h r10 = this.f805a;
                if (r10.B(r10.K) == true) goto L5;
                this.f805a.dismiss();
                return;
            L5:
                this.f805a.A();
                h.z(this.f805a);
            }
        }

        public class c implements PopupWindow.OnDismissListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ViewTreeObserver.OnGlobalLayoutListener f806a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ h f807b;

            public c(h r10, ViewTreeObserver.OnGlobalLayoutListener r11) {
                this.f807b = r10;
                this.f806a = r11;
            }

            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                ViewTreeObserver r10 = this.f807b.K.getViewTreeObserver();
                if (r10 == null) goto L6;
                r10.removeGlobalOnLayoutListener(this.f806a);
                return;
            }
        }

        public h(AppCompatSpinner r10, Context r11, AttributeSet r12, int r13) {
            this.K = r10;
            super(r11, r12, r13);
            this.I = new Rect();
            n(r10);
            t(true);
            w(0);
            setOnItemClickListener(new a(this, r10));
        }

        public static /* synthetic */ void z(h r10) {
            super.show();
        }

        public void A() {
            Drawable r10 = getBackground();
            if (r10 == null) goto L8;
            r10.getPadding(this.K.f792h);
            if (i0.b(this.K) == false) goto L7;
            int r11 = this.K.f792h.right;
        L9:
            int r12 = this.K.getPaddingLeft();
            int r13 = this.K.getPaddingRight();
            int r14 = this.K.getWidth();
            AppCompatSpinner r15 = this.K;
            int r16 = r15.f791g;
            if (r16 != (-2)) goto L16;
            int r17 = r15.a((SpinnerAdapter) this.H, getBackground());
            int r18 = this.K.getContext().getResources().getDisplayMetrics().widthPixels;
            Rect r19 = this.K.f792h;
            int r20 = (r18 - r19.left) - r19.right;
            if (r17 <= r20) goto L14;
            r17 = r20;
        L14:
            p(Math.max(r17, (r14 - r12) - r13));
        L20:
            if (i0.b(this.K) == false) goto L22;
            int r21 = r11 + (((r14 - r13) - j()) - getHorizontalOriginalOffset());
        L23:
            setHorizontalOffset(r21);
            return;
        L22:
            r21 = r11 + (r12 + getHorizontalOriginalOffset());
            goto L23
        L16:
            if (r16 != (-1)) goto L18;
            p((r14 - r12) - r13);
            goto L20
        L18:
            p(r16);
            goto L20
        L7:
            r11 = -this.K.f792h.left;
            goto L9
        L8:
            Rect r22 = this.K.f792h;
            r22.right = 0;
            r22.left = 0;
            r11 = 0;
            goto L9
        }

        public boolean B(View r10) {
            if (ViewCompat.S(r10) == true) goto L5;
        L7:
            return false;
        L5:
            if (r10.getGlobalVisibleRect(this.I) == false) goto L7;
            return true;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public CharSequence getHintText() {
            return this.G;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public int getHorizontalOriginalOffset() {
            return this.f802J;
        }

        @Override // androidx.appcompat.widget.ListPopupWindow, androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public void setAdapter(ListAdapter r10) {
            super.setAdapter(r10);
            this.H = r10;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public void setHorizontalOriginalOffset(int r10) {
            this.f802J = r10;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public void setPromptText(CharSequence r10) {
            this.G = r10;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public void show(int r10, int r11) {
            boolean r12 = isShowing();
            A();
            s(2);
            super.show();
            ListView r13 = getListView();
            r13.setChoiceMode(1);
            d.d(r13, r10);
            d.c(r13, r11);
            x(this.K.getSelectedItemPosition());
            if (r12 == false) goto L5;
            return;
        L5:
            ViewTreeObserver r14 = this.K.getViewTreeObserver();
            if (r14 == null) goto L9;
            b r15 = new b(this);
            r14.addOnGlobalLayoutListener(r15);
            setOnDismissListener(new c(this, r15));
            return;
        }
    }

    static {
        f784i = new int[]{R.attr.spinnerMode};
    }

    public AppCompatSpinner(@NonNull Context r10) {
        this(r10, null);
    }

    public int a(SpinnerAdapter r11, Drawable r12) {
        int r10 = 0;
        if (r11 != null) goto L5;
        return 0;
    L5:
        int r13 = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
        int r14 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
        int r15 = Math.max(0, getSelectedItemPosition());
        int r16 = Math.min(r11.getCount(), r15 + 15);
        int r17 = Math.max(0, r15 - (15 - (r16 - r15)));
        View r18 = null;
        int r19 = 0;
    L6:
        if (r17 >= r16) goto L14;
        int r20 = r11.getItemViewType(r17);
        if (r20 == r10) goto L10;
        r18 = null;
        r10 = r20;
    L10:
        r18 = r11.getView(r17, r18, this);
        if (r18.getLayoutParams() != null) goto L13;
        r18.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
    L13:
        r18.measure(r13, r14);
        r19 = Math.max(r19, r18.getMeasuredWidth());
        r17 = r17 + 1;
        goto L6
    L14:
        if (r12 == null) goto L20;
        r12.getPadding(this.f792h);
        Rect r110 = this.f792h;
        return r19 + (r110.left + r110.right);
    L20:
        return r19;
    }

    public void b() {
        this.f790f.show(d.b(this), d.a(this));
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        androidx.appcompat.widget.c r10 = this.f785a;
        if (r10 == null) goto L6;
        r10.b();
        return;
    }

    @Override // android.widget.Spinner
    public int getDropDownHorizontalOffset() {
        SpinnerPopup r10 = this.f790f;
        if (r10 == null) goto L7;
        return r10.getHorizontalOffset();
    L7:
        return super.getDropDownHorizontalOffset();
    }

    @Override // android.widget.Spinner
    public int getDropDownVerticalOffset() {
        SpinnerPopup r10 = this.f790f;
        if (r10 == null) goto L7;
        return r10.getVerticalOffset();
    L7:
        return super.getDropDownVerticalOffset();
    }

    @Override // android.widget.Spinner
    public int getDropDownWidth() {
        if (this.f790f == null) goto L7;
        return this.f791g;
    L7:
        return super.getDropDownWidth();
    }

    @VisibleForTesting
    public final SpinnerPopup getInternalPopup() {
        return this.f790f;
    }

    @Override // android.widget.Spinner
    public Drawable getPopupBackground() {
        SpinnerPopup r10 = this.f790f;
        if (r10 == null) goto L7;
        return r10.getBackground();
    L7:
        return super.getPopupBackground();
    }

    @Override // android.widget.Spinner
    public Context getPopupContext() {
        return this.f786b;
    }

    @Override // android.widget.Spinner
    public CharSequence getPrompt() {
        SpinnerPopup r10 = this.f790f;
        if (r10 == null) goto L6;
        return r10.getHintText();
    L6:
        return super.getPrompt();
    }

    @Override // androidx.core.view.TintableBackgroundView
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public ColorStateList getSupportBackgroundTintList() {
        androidx.appcompat.widget.c r10 = this.f785a;
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10.c();
    }

    @Override // androidx.core.view.TintableBackgroundView
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        androidx.appcompat.widget.c r10 = this.f785a;
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10.d();
    }

    @Override // android.widget.Spinner, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        SpinnerPopup r10 = this.f790f;
        if (r10 != null) goto L5;
        return;
    L5:
        if (r10.isShowing() == false) goto L9;
        this.f790f.dismiss();
        return;
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public void onMeasure(int r10, int r11) {
        super.onMeasure(r10, r11);
        if (this.f790f != null) goto L5;
        return;
    L5:
        if (View.MeasureSpec.getMode(r10) != Integer.MIN_VALUE) goto L9;
        setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), a(getAdapter(), getBackground())), View.MeasureSpec.getSize(r10)), getMeasuredHeight());
        return;
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public void onRestoreInstanceState(Parcelable r10) {
        SavedState r11 = (SavedState) r10;
        super.onRestoreInstanceState(r11.getSuperState());
        if (r11.mShowDropdown == false) goto L8;
        ViewTreeObserver r12 = getViewTreeObserver();
        if (r12 == null) goto L9;
        r12.addOnGlobalLayoutListener(new b(this));
        return;
    L9:
        return;
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState r10 = new SavedState(super.onSaveInstanceState());
        SpinnerPopup r11 = this.f790f;
        if (r11 != null) goto L5;
    L7:
        boolean r12 = false;
    L8:
        r10.mShowDropdown = r12;
        return r10;
    L5:
        if (r11.isShowing() == false) goto L7;
        r12 = true;
        goto L8
    }

    @Override // android.widget.Spinner, android.view.View
    public boolean onTouchEvent(MotionEvent r10) {
        t r11 = this.f787c;
        if (r11 == null) goto L9;
        if (r11.onTouch(this, r10) == false) goto L9;
        return true;
    L9:
        return super.onTouchEvent(r10);
    }

    @Override // android.widget.Spinner, android.view.View
    public boolean performClick() {
        SpinnerPopup r10 = this.f790f;
        if (r10 == null) goto L10;
        if (r10.isShowing() == true) goto L11;
        b();
        return true;
    L11:
        return true;
    L10:
        return super.performClick();
    }

    @Override // android.widget.AdapterView
    public /* bridge */ /* synthetic */ void setAdapter(Adapter r10) {
        setAdapter((SpinnerAdapter) r10);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(@Nullable Drawable r10) {
        super.setBackgroundDrawable(r10);
        androidx.appcompat.widget.c r11 = this.f785a;
        if (r11 == null) goto L6;
        r11.f(r10);
        return;
    }

    @Override // android.view.View
    public void setBackgroundResource(@DrawableRes int r10) {
        super.setBackgroundResource(r10);
        androidx.appcompat.widget.c r11 = this.f785a;
        if (r11 == null) goto L6;
        r11.g(r10);
        return;
    }

    @Override // android.widget.Spinner
    public void setDropDownHorizontalOffset(int r10) {
        SpinnerPopup r11 = this.f790f;
        if (r11 == null) goto L5;
        r11.setHorizontalOriginalOffset(r10);
        this.f790f.setHorizontalOffset(r10);
        return;
    L5:
        super.setDropDownHorizontalOffset(r10);
    }

    @Override // android.widget.Spinner
    public void setDropDownVerticalOffset(int r10) {
        SpinnerPopup r11 = this.f790f;
        if (r11 == null) goto L5;
        r11.setVerticalOffset(r10);
        return;
    L5:
        super.setDropDownVerticalOffset(r10);
    }

    @Override // android.widget.Spinner
    public void setDropDownWidth(int r10) {
        if (this.f790f == null) goto L5;
        this.f791g = r10;
        return;
    L5:
        super.setDropDownWidth(r10);
    }

    @Override // android.widget.Spinner
    public void setPopupBackgroundDrawable(Drawable r10) {
        SpinnerPopup r11 = this.f790f;
        if (r11 == null) goto L5;
        r11.setBackgroundDrawable(r10);
        return;
    L5:
        super.setPopupBackgroundDrawable(r10);
    }

    @Override // android.widget.Spinner
    public void setPopupBackgroundResource(@DrawableRes int r10) {
        setPopupBackgroundDrawable(c.a.b(getPopupContext(), r10));
    }

    @Override // android.widget.Spinner
    public void setPrompt(CharSequence r10) {
        SpinnerPopup r11 = this.f790f;
        if (r11 == null) goto L5;
        r11.setPromptText(r10);
        return;
    L5:
        super.setPrompt(r10);
    }

    @Override // androidx.core.view.TintableBackgroundView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setSupportBackgroundTintList(@Nullable ColorStateList r10) {
        androidx.appcompat.widget.c r11 = this.f785a;
        if (r11 == null) goto L6;
        r11.i(r10);
        return;
    }

    @Override // androidx.core.view.TintableBackgroundView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setSupportBackgroundTintMode(@Nullable PorterDuff.Mode r10) {
        androidx.appcompat.widget.c r11 = this.f785a;
        if (r11 == null) goto L6;
        r11.j(r10);
        return;
    }

    public AppCompatSpinner(@NonNull Context r10, @Nullable AttributeSet r11) {
        this(r10, r11, R$attr.spinnerStyle);
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner
    public void setAdapter(SpinnerAdapter r10) {
        if (this.f789e == true) goto L6;
        this.f788d = r10;
        return;
    L6:
        super.setAdapter(r10);
        if (this.f790f == null) goto L13;
        Context r11 = this.f786b;
        if (r11 != null) goto L11;
        r11 = getContext();
    L11:
        this.f790f.setAdapter(new g(r10, r11.getTheme()));
        return;
    }

    public AppCompatSpinner(@NonNull Context r10, @Nullable AttributeSet r11, int r12) {
        this(r10, r11, r12, -1);
    }

    public AppCompatSpinner(Context r10, AttributeSet r11, int r12, int r13) {
        this(r10, r11, r12, r13, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v10 */
    /* JADX WARN: Type inference failed for: r11v11 */
    /* JADX WARN: Type inference failed for: r11v12 */
    /* JADX WARN: Type inference failed for: r11v3 */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* JADX WARN: Type inference failed for: r11v7, types: [android.content.res.TypedArray] */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4, types: [android.content.res.TypedArray] */
    /* JADX WARN: Type inference failed for: r6v0, types: [android.view.View, android.widget.Spinner, androidx.appcompat.widget.AppCompatSpinner] */
    public AppCompatSpinner(Context r10, AttributeSet r11, int r12, int r13, Resources.Theme r14) {
        super(r10, r11, r12);
        this.f792h = new Rect();
        x.a(this, getContext());
        b0 r15 = b0.v(r10, r11, R$styleable.Spinner, r12, 0);
        this.f785a = new androidx.appcompat.widget.c(this);
        if (r14 == null) goto L5;
        this.f786b = new g.b(r10, r14);
    L9:
        ?? r16 = -1;
        ?? r17 = 0;
        if (r13 != (-1)) goto L32;
        TypedArray r18 = r10.obtainStyledAttributes(r11, f784i, r12, 0);     // Catch: Throwable -> L21 Exception -> L23
        boolean r19 = r18.hasValue(0);     // Catch: Throwable -> L16 Exception -> L18
        r16 = r18;
        if (r19 == false) goto L20;
        r13 = r18.getInt(0, 0);     // Catch: Throwable -> L16 Exception -> L18
        r16 = r18;
    L20:
        r16.recycle();
    L18:
        e = e;
    L25:
        Log.i("AppCompatSpinner", "Could not read android:spinnerMode", e);     // Catch: Throwable -> L16
        r16 = r18;
        if (r18 == null) goto L32;
    L23:
        e = e;
        r18 = null;
    L21:
        th = th;
    L28:
        if (r17 == 0) goto L30;
        r17.recycle();
    L30:
        throw th;
    L32:
        if (r13 == 0) goto L36;
        if (r13 != 1) goto L37;
        h r110 = new h(this, this.f786b, r11, r12);
        b0 r20 = b0.v(this.f786b, r11, R$styleable.Spinner, r12, 0);
        this.f791g = r20.m(R$styleable.Spinner_android_dropDownWidth, -2);
        r110.setBackgroundDrawable(r20.g(R$styleable.Spinner_android_popupBackground));
        r110.setPromptText(r15.o(R$styleable.Spinner_android_prompt));
        r20.w();
        this.f790f = r110;
        this.f787c = new a(this, this, r110);
    L37:
        CharSequence[] r111 = r15.q(R$styleable.Spinner_android_entries);
        if (r111 == null) goto L40;
        ArrayAdapter r21 = new ArrayAdapter(r10, R.layout.simple_spinner_item, r111);
        r21.setDropDownViewResource(R$layout.support_simple_spinner_dropdown_item);
        setAdapter(r21);
    L40:
        r15.w();
        this.f789e = true;
        SpinnerAdapter r22 = this.f788d;
        if (r22 == null) goto L43;
        setAdapter(r22);
        this.f788d = null;
    L43:
        this.f785a.e(r11, r12);
        return;
    L36:
        f r112 = new f(this);
        this.f790f = r112;
        r112.setPromptText(r15.o(R$styleable.Spinner_android_prompt));
    L16:
        th = th;
        r17 = r16;
        goto L28
    L5:
        int r113 = r15.n(R$styleable.Spinner_popupTheme, 0);
        if (r113 == 0) goto L8;
        this.f786b = new g.b(r10, r113);
        goto L9
    L8:
        this.f786b = r10;
        goto L9
    }
}
