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
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.core.view.TintableBackgroundView;
import androidx.core.view.ViewCompat;
import com.bytedance.crash.d;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;

/* JADX INFO: loaded from: classes2.dex */
public class AppCompatSpinner extends Spinner implements TintableBackgroundView {
    private static final int[] ATTRS_ANDROID_SPINNERMODE = null;
    private static final int MAX_ITEMS_MEASURED = 15;
    private static final int MODE_DIALOG = 0;
    private static final int MODE_DROPDOWN = 1;
    private static final int MODE_THEME = -1;
    private static final String TAG = "AppCompatSpinner";
    private final AppCompatBackgroundHelper mBackgroundTintHelper;
    int mDropDownWidth;
    private ForwardingListener mForwardingListener;
    private SpinnerPopup mPopup;
    private final Context mPopupContext;
    private final boolean mPopupSet;
    private SpinnerAdapter mTempAdapter;
    final Rect mTempRect;

    public class DialogPopup implements SpinnerPopup, DialogInterface.OnClickListener {
        private ListAdapter mListAdapter;
        AlertDialog mPopup;
        private CharSequence mPrompt;
        final /* synthetic */ AppCompatSpinner this$0;

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public Drawable getBackground() {
            return null;
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
        public void setBackgroundDrawable(Drawable r100) {
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public void setHorizontalOffset(int r100) {
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public void setHorizontalOriginalOffset(int r100) {
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public void setVerticalOffset(int r100) {
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public void dismiss() {
            AlertDialog r100 = this.mPopup;
            if (r100 == null) goto L6;
            INVOKEVIRTUAL_androidx_appcompat_widget_AppCompatSpinner$DialogPopup_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_dismiss(r100);
            this.mPopup = null;
            return;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public boolean isShowing() {
            AlertDialog r100 = this.mPopup;
            if (r100 != null) goto L7;
            return false;
        L7:
            return r100.isShowing();
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public CharSequence getHintText() {
            return this.mPrompt;
        }

        public DialogPopup(AppCompatSpinner r100) {
            this.this$0 = r100;
        }

        public static void INVOKEVIRTUAL_androidx_appcompat_widget_AppCompatSpinner$DialogPopup_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_dismiss(AlertDialog r100) {
            Handler r101 = DialogLancet.resolveDialogHandler(r100);
            if (r101 != null) goto L5;
        L8:
            DialogLancet.beforeDialogDismiss(r100);
            r100.dismiss();     // Catch: Throwable -> L11 Exception -> L13
        L10:
            DialogLancet.afterDialogDismiss(r100);
            return;
        L11:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r100);
            throw th;
        L13:
            e = move-exception;
            d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
            Throwable r102 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
            if (r102 == null) goto L10;
            d.d(r102, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
            goto L10
        L5:
            if (Looper.myLooper() == r101.getLooper()) goto L8;
            r101.post(DialogLancet.createDismissRunnable(r100));
        }

        public static void INVOKEVIRTUAL_androidx_appcompat_widget_AppCompatSpinner$DialogPopup_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(AlertDialog r100) {
            if (DialogLancet.shouldBlockDialogShow(r100) == false) goto L10;
            DialogLancet.handleBlockedDialogShow(r100);
            return;
        L10:
            DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L9
        L7:
            DialogLancet.beforeDialogShow(r100);
            r100.show();
            DialogLancet.afterDialogShow(r100);
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public void setAdapter(ListAdapter r100) {
            this.mListAdapter = r100;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public void setPromptText(CharSequence r100) {
            this.mPrompt = r100;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface r100, int r101) {
            this.this$0.setSelection(r101);
            if (this.this$0.getOnItemClickListener() == null) goto L5;
            this.this$0.performItemClick(null, r101, this.mListAdapter.getItemId(r101));
        L5:
            dismiss();
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public void show(int r100, int r101) {
            if (this.mListAdapter != null) goto L5;
            return;
        L5:
            AlertDialog.Builder r102 = new AlertDialog.Builder(this.this$0.getPopupContext());
            CharSequence r103 = this.mPrompt;
            if (r103 == null) goto L8;
            r102.setTitle(r103);
        L8:
            AlertDialog r104 = r102.setSingleChoiceItems(this.mListAdapter, this.this$0.getSelectedItemPosition(), this).create();
            this.mPopup = r104;
            ListView r105 = r104.getListView();
            r105.setTextDirection(r100);
            r105.setTextAlignment(r101);
            INVOKEVIRTUAL_androidx_appcompat_widget_AppCompatSpinner$DialogPopup_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(this.mPopup);
        }
    }

    public static class DropDownAdapter implements ListAdapter, SpinnerAdapter {
        private SpinnerAdapter mAdapter;
        private ListAdapter mListAdapter;

        @Override // android.widget.Adapter
        public int getItemViewType(int r100) {
            return 0;
        }

        @Override // android.widget.Adapter
        public int getViewTypeCount() {
            return 1;
        }

        @Override // android.widget.ListAdapter
        public boolean areAllItemsEnabled() {
            ListAdapter r100 = this.mListAdapter;
            if (r100 != null) goto L5;
            return true;
        L5:
            return r100.areAllItemsEnabled();
        }

        @Override // android.widget.Adapter
        public int getCount() {
            SpinnerAdapter r100 = this.mAdapter;
            if (r100 != null) goto L6;
            return 0;
        L6:
            return r100.getCount();
        }

        @Override // android.widget.Adapter
        public boolean hasStableIds() {
            SpinnerAdapter r100 = this.mAdapter;
            if (r100 != null) goto L5;
        L7:
            return false;
        L5:
            if (r100.hasStableIds() == false) goto L7;
            return true;
        }

        @Override // android.widget.Adapter
        public boolean isEmpty() {
            if (getCount() != 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // android.widget.Adapter
        public Object getItem(int r100) {
            SpinnerAdapter r101 = this.mAdapter;
            if (r101 != null) goto L6;
            return null;
        L6:
            return r101.getItem(r100);
        }

        @Override // android.widget.Adapter
        public long getItemId(int r100) {
            SpinnerAdapter r101 = this.mAdapter;
            if (r101 != null) goto L6;
            return -1;
        L6:
            return r101.getItemId(r100);
        }

        @Override // android.widget.ListAdapter
        public boolean isEnabled(int r100) {
            ListAdapter r101 = this.mListAdapter;
            if (r101 != null) goto L5;
            return true;
        L5:
            return r101.isEnabled(r100);
        }

        @Override // android.widget.Adapter
        public void registerDataSetObserver(DataSetObserver r100) {
            SpinnerAdapter r101 = this.mAdapter;
            if (r101 == null) goto L6;
            r101.registerDataSetObserver(r100);
            return;
        }

        @Override // android.widget.Adapter
        public void unregisterDataSetObserver(DataSetObserver r100) {
            SpinnerAdapter r101 = this.mAdapter;
            if (r101 == null) goto L6;
            r101.unregisterDataSetObserver(r100);
            return;
        }

        public DropDownAdapter(SpinnerAdapter r100, Resources.Theme r101) {
            this.mAdapter = r100;
            if ((r100 instanceof ListAdapter) == false) goto L5;
            this.mListAdapter = (ListAdapter) r100;
        L5:
            if (r101 != null) goto L7;
            return;
        L7:
            if (Build.VERSION.SDK_INT < 23) goto L14;
            if ((r100 instanceof android.widget.ThemedSpinnerAdapter) == false) goto L14;
            android.widget.ThemedSpinnerAdapter r102 = (android.widget.ThemedSpinnerAdapter) r100;
            if (r102.getDropDownViewTheme() == r101) goto L20;
            r102.setDropDownViewTheme(r101);
            return;
        L20:
            return;
        L14:
            if ((r100 instanceof ThemedSpinnerAdapter) == false) goto L22;
            ThemedSpinnerAdapter r103 = (ThemedSpinnerAdapter) r100;
            if (r103.getDropDownViewTheme() != null) goto L23;
            r103.setDropDownViewTheme(r101);
            return;
        L23:
            return;
        }

        @Override // android.widget.SpinnerAdapter
        public View getDropDownView(int r100, View r101, ViewGroup r102) {
            SpinnerAdapter r103 = this.mAdapter;
            if (r103 != null) goto L6;
            return null;
        L6:
            return r103.getDropDownView(r100, r101, r102);
        }

        @Override // android.widget.Adapter
        public View getView(int r100, View r101, ViewGroup r102) {
            return getDropDownView(r100, r101, r102);
        }
    }

    public class DropdownPopup extends ListPopupWindow implements SpinnerPopup {
        ListAdapter mAdapter;
        private CharSequence mHintText;
        private int mOriginalHorizontalOffset;
        private final Rect mVisibleRect;
        final /* synthetic */ AppCompatSpinner this$0;

        public void computeContentWidth() {
            Drawable r100 = getBackground();
            if (r100 == null) goto L8;
            r100.getPadding(this.this$0.mTempRect);
            if (ViewUtils.isLayoutRtl(this.this$0) == false) goto L7;
            int r101 = this.this$0.mTempRect.right;
        L9:
            int r102 = this.this$0.getPaddingLeft();
            int r103 = this.this$0.getPaddingRight();
            int r104 = this.this$0.getWidth();
            AppCompatSpinner r105 = this.this$0;
            int r106 = r105.mDropDownWidth;
            if (r106 != (-2)) goto L16;
            int r107 = r105.compatMeasureContentWidth((SpinnerAdapter) this.mAdapter, getBackground());
            int r108 = INVOKEVIRTUAL_androidx_appcompat_widget_AppCompatSpinner$DropdownPopup_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(this.this$0.getContext().getResources()).widthPixels;
            Rect r109 = this.this$0.mTempRect;
            int r110 = (r108 - r109.left) - r109.right;
            if (r107 <= r110) goto L14;
            r107 = r110;
        L14:
            setContentWidth(Math.max(r107, (r104 - r102) - r103));
        L20:
            if (ViewUtils.isLayoutRtl(this.this$0) == false) goto L22;
            int r111 = r101 + (((r104 - r103) - getWidth()) - getHorizontalOriginalOffset());
        L23:
            setHorizontalOffset(r111);
            return;
        L22:
            r111 = r101 + (r102 + getHorizontalOriginalOffset());
            goto L23
        L16:
            if (r106 != (-1)) goto L18;
            setContentWidth((r104 - r102) - r103);
            goto L20
        L18:
            setContentWidth(r106);
            goto L20
        L7:
            r101 = -this.this$0.mTempRect.left;
            goto L9
        L8:
            Rect r112 = this.this$0.mTempRect;
            r112.right = 0;
            r112.left = 0;
            r101 = 0;
            goto L9
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public CharSequence getHintText() {
            return this.mHintText;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public int getHorizontalOriginalOffset() {
            return this.mOriginalHorizontalOffset;
        }

        public static DisplayMetrics INVOKEVIRTUAL_androidx_appcompat_widget_AppCompatSpinner$DropdownPopup_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r100) {
            return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
        }

        public static /* synthetic */ void access$001(DropdownPopup r100) {
            super.show();
        }

        public boolean isVisibleToUser(View r100) {
            if (ViewCompat.isAttachedToWindow(r100) == true) goto L5;
        L7:
            return false;
        L5:
            if (r100.getGlobalVisibleRect(this.mVisibleRect) == false) goto L7;
            return true;
        }

        @Override // androidx.appcompat.widget.ListPopupWindow, androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public void setAdapter(ListAdapter r100) {
            super.setAdapter(r100);
            this.mAdapter = r100;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public void setHorizontalOriginalOffset(int r100) {
            this.mOriginalHorizontalOffset = r100;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public void setPromptText(CharSequence r100) {
            this.mHintText = r100;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public void show(int r100, int r101) {
            boolean r102 = isShowing();
            computeContentWidth();
            setInputMethodMode(2);
            super.show();
            ListView r103 = getListView();
            r103.setChoiceMode(1);
            r103.setTextDirection(r100);
            r103.setTextAlignment(r101);
            setSelection(this.this$0.getSelectedItemPosition());
            if (r102 == false) goto L5;
            return;
        L5:
            ViewTreeObserver r104 = this.this$0.getViewTreeObserver();
            if (r104 == null) goto L9;
            final ViewTreeObserver.OnGlobalLayoutListener r105 = new AnonymousClass2(this);
            r104.addOnGlobalLayoutListener(r105);
            setOnDismissListener(new AnonymousClass3(this, r105));
            return;
        }

        public DropdownPopup(final AppCompatSpinner r100, Context r101, AttributeSet r102, int r103) {
            this.this$0 = r100;
            super(r101, r102, r103);
            this.mVisibleRect = new Rect();
            setAnchorView(r100);
            setModal(true);
            setPromptPosition(0);
            setOnItemClickListener(new AnonymousClass1(this, r100));
        }
    }

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        boolean mShowDropdown;

        static {
            CREATOR = new AnonymousClass1();
        }

        public SavedState(Parcel r100) {
            super(r100);
            if (r100.readByte() == 0) goto L5;
            boolean r101 = true;
        L6:
            this.mShowDropdown = r101;
            return;
        L5:
            r101 = false;
            goto L6
        }

        public SavedState(Parcelable r100) {
            super(r100);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel r100, int r101) {
            super.writeToParcel(r100, r101);
            r100.writeByte(this.mShowDropdown ? 1 : 0);
        }
    }

    public interface SpinnerPopup {
        void dismiss();

        Drawable getBackground();

        CharSequence getHintText();

        int getHorizontalOffset();

        int getHorizontalOriginalOffset();

        int getVerticalOffset();

        boolean isShowing();

        void setAdapter(ListAdapter r100);

        void setBackgroundDrawable(Drawable r100);

        void setHorizontalOffset(int r100);

        void setHorizontalOriginalOffset(int r100);

        void setPromptText(CharSequence r100);

        void setVerticalOffset(int r100);

        void show(int r100, int r101);
    }

    static {
        ATTRS_ANDROID_SPINNERMODE = new int[]{R.attr.spinnerMode};
    }

    @Override // android.widget.Spinner
    public int getDropDownHorizontalOffset() {
        SpinnerPopup r100 = this.mPopup;
        if (r100 == null) goto L7;
        return r100.getHorizontalOffset();
    L7:
        return super.getDropDownHorizontalOffset();
    }

    @Override // android.widget.Spinner
    public int getDropDownVerticalOffset() {
        SpinnerPopup r100 = this.mPopup;
        if (r100 == null) goto L7;
        return r100.getVerticalOffset();
    L7:
        return super.getDropDownVerticalOffset();
    }

    @Override // android.widget.Spinner
    public int getDropDownWidth() {
        if (this.mPopup == null) goto L7;
        return this.mDropDownWidth;
    L7:
        return super.getDropDownWidth();
    }

    @Override // android.widget.Spinner
    public Drawable getPopupBackground() {
        SpinnerPopup r100 = this.mPopup;
        if (r100 == null) goto L7;
        return r100.getBackground();
    L7:
        return super.getPopupBackground();
    }

    @Override // android.widget.Spinner
    public CharSequence getPrompt() {
        SpinnerPopup r100 = this.mPopup;
        if (r100 == null) goto L6;
        return r100.getHintText();
    L6:
        return super.getPrompt();
    }

    @Override // androidx.core.view.TintableBackgroundView
    public ColorStateList getSupportBackgroundTintList() {
        AppCompatBackgroundHelper r100 = this.mBackgroundTintHelper;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getSupportBackgroundTintList();
    }

    @Override // androidx.core.view.TintableBackgroundView
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        AppCompatBackgroundHelper r100 = this.mBackgroundTintHelper;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getSupportBackgroundTintMode();
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState r100 = new SavedState(super.onSaveInstanceState());
        SpinnerPopup r101 = this.mPopup;
        if (r101 != null) goto L5;
    L7:
        boolean r102 = false;
    L8:
        r100.mShowDropdown = r102;
        return r100;
    L5:
        if (r101.isShowing() == false) goto L7;
        r102 = true;
        goto L8
    }

    @Override // android.widget.Spinner, android.view.View
    public boolean performClick() {
        SpinnerPopup r100 = this.mPopup;
        if (r100 == null) goto L10;
        if (r100.isShowing() == true) goto L11;
        showPopup();
        return true;
    L11:
        return true;
    L10:
        return super.performClick();
    }

    public void showPopup() {
        this.mPopup.show(getTextDirection(), getTextAlignment());
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        AppCompatBackgroundHelper r100 = this.mBackgroundTintHelper;
        if (r100 == null) goto L6;
        r100.applySupportBackgroundTint();
        return;
    }

    @Override // android.widget.Spinner, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        SpinnerPopup r100 = this.mPopup;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.isShowing() == false) goto L9;
        this.mPopup.dismiss();
        return;
    }

    public final SpinnerPopup getInternalPopup() {
        return this.mPopup;
    }

    @Override // android.widget.Spinner
    public Context getPopupContext() {
        return this.mPopupContext;
    }

    public AppCompatSpinner(Context r100) {
        this(r100, null);
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public void onRestoreInstanceState(Parcelable r100) {
        SavedState r101 = (SavedState) r100;
        super.onRestoreInstanceState(r101.getSuperState());
        if (r101.mShowDropdown == false) goto L8;
        ViewTreeObserver r102 = getViewTreeObserver();
        if (r102 == null) goto L9;
        r102.addOnGlobalLayoutListener(new AnonymousClass2(this));
        return;
    L9:
        return;
    }

    @Override // android.widget.Spinner, android.view.View
    public boolean onTouchEvent(MotionEvent r100) {
        ForwardingListener r101 = this.mForwardingListener;
        if (r101 == null) goto L9;
        if (r101.onTouch(this, r100) == false) goto L9;
        return true;
    L9:
        return super.onTouchEvent(r100);
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner
    public void setAdapter(SpinnerAdapter r100) {
        if (this.mPopupSet == true) goto L6;
        this.mTempAdapter = r100;
        return;
    L6:
        super.setAdapter(r100);
        if (this.mPopup == null) goto L13;
        Context r101 = this.mPopupContext;
        if (r101 != null) goto L11;
        r101 = getContext();
    L11:
        this.mPopup.setAdapter(new DropDownAdapter(r100, r101.getTheme()));
        return;
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable r100) {
        super.setBackgroundDrawable(r100);
        AppCompatBackgroundHelper r101 = this.mBackgroundTintHelper;
        if (r101 == null) goto L6;
        r101.onSetBackgroundDrawable(r100);
        return;
    }

    @Override // android.view.View
    public void setBackgroundResource(int r100) {
        super.setBackgroundResource(r100);
        AppCompatBackgroundHelper r101 = this.mBackgroundTintHelper;
        if (r101 == null) goto L6;
        r101.onSetBackgroundResource(r100);
        return;
    }

    @Override // android.widget.Spinner
    public void setDropDownHorizontalOffset(int r100) {
        SpinnerPopup r101 = this.mPopup;
        if (r101 == null) goto L5;
        r101.setHorizontalOriginalOffset(r100);
        this.mPopup.setHorizontalOffset(r100);
        return;
    L5:
        super.setDropDownHorizontalOffset(r100);
    }

    @Override // android.widget.Spinner
    public void setDropDownVerticalOffset(int r100) {
        SpinnerPopup r101 = this.mPopup;
        if (r101 == null) goto L5;
        r101.setVerticalOffset(r100);
        return;
    L5:
        super.setDropDownVerticalOffset(r100);
    }

    @Override // android.widget.Spinner
    public void setDropDownWidth(int r100) {
        if (this.mPopup == null) goto L5;
        this.mDropDownWidth = r100;
        return;
    L5:
        super.setDropDownWidth(r100);
    }

    @Override // android.widget.Spinner
    public void setPopupBackgroundDrawable(Drawable r100) {
        SpinnerPopup r101 = this.mPopup;
        if (r101 == null) goto L5;
        r101.setBackgroundDrawable(r100);
        return;
    L5:
        super.setPopupBackgroundDrawable(r100);
    }

    @Override // android.widget.Spinner
    public void setPopupBackgroundResource(int r100) {
        setPopupBackgroundDrawable(AppCompatResources.getDrawable(getPopupContext(), r100));
    }

    @Override // android.widget.Spinner
    public void setPrompt(CharSequence r100) {
        SpinnerPopup r101 = this.mPopup;
        if (r101 == null) goto L5;
        r101.setPromptText(r100);
        return;
    L5:
        super.setPrompt(r100);
    }

    @Override // androidx.core.view.TintableBackgroundView
    public void setSupportBackgroundTintList(ColorStateList r100) {
        AppCompatBackgroundHelper r101 = this.mBackgroundTintHelper;
        if (r101 == null) goto L6;
        r101.setSupportBackgroundTintList(r100);
        return;
    }

    @Override // androidx.core.view.TintableBackgroundView
    public void setSupportBackgroundTintMode(PorterDuff.Mode r100) {
        AppCompatBackgroundHelper r101 = this.mBackgroundTintHelper;
        if (r101 == null) goto L6;
        r101.setSupportBackgroundTintMode(r100);
        return;
    }

    @Override // android.widget.AdapterView
    public /* bridge */ /* synthetic */ void setAdapter(Adapter r100) {
        setAdapter((SpinnerAdapter) r100);
    }

    public AppCompatSpinner(Context r100, int r101) {
        this(r100, null, com.larus.nova.R.attr.spinnerStyle, r101);
    }

    public int compatMeasureContentWidth(SpinnerAdapter r110, Drawable r111) {
        int r100 = 0;
        if (r110 != null) goto L5;
        return 0;
    L5:
        int r101 = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
        int r102 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
        int r103 = Math.max(0, getSelectedItemPosition());
        int r104 = Math.min(r110.getCount(), r103 + 15);
        int r105 = Math.max(0, r103 - (15 - (r104 - r103)));
        View r106 = null;
        int r107 = 0;
    L6:
        if (r105 >= r104) goto L14;
        int r108 = r110.getItemViewType(r105);
        if (r108 == r100) goto L10;
        r106 = null;
        r100 = r108;
    L10:
        r106 = r110.getView(r105, r106, this);
        if (r106.getLayoutParams() != null) goto L13;
        r106.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
    L13:
        r106.measure(r101, r102);
        r107 = Math.max(r107, r106.getMeasuredWidth());
        r105 = r105 + 1;
        goto L6
    L14:
        if (r111 == null) goto L20;
        r111.getPadding(this.mTempRect);
        Rect r112 = this.mTempRect;
        return r107 + (r112.left + r112.right);
    L20:
        return r107;
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        if (this.mPopup != null) goto L5;
        return;
    L5:
        if (View.MeasureSpec.getMode(r100) != Integer.MIN_VALUE) goto L9;
        setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), compatMeasureContentWidth(getAdapter(), getBackground())), View.MeasureSpec.getSize(r100)), getMeasuredHeight());
        return;
    }

    public AppCompatSpinner(Context r100, AttributeSet r101) {
        this(r100, r101, com.larus.nova.R.attr.spinnerStyle);
    }

    public AppCompatSpinner(Context r100, AttributeSet r101, int r102) {
        this(r100, r101, r102, -1);
    }

    public AppCompatSpinner(Context r100, AttributeSet r101, int r102, int r110) {
        this(r100, r101, r102, r110, null);
    }

    public AppCompatSpinner(Context r100, AttributeSet r101, int r110, int r111, Resources.Theme r112) {
        super(r100, r101, r110);
        this.mTempRect = new Rect();
        ThemeUtils.checkAppCompatTheme(this, getContext());
        TintTypedArray r102 = TintTypedArray.obtainStyledAttributes(r100, r101, new int[]{R.attr.entries, R.attr.popupBackground, R.attr.prompt, R.attr.dropDownWidth, com.larus.nova.R.attr.popupTheme}, r110, 0);
        this.mBackgroundTintHelper = new AppCompatBackgroundHelper(this);
        if (r112 == null) goto L5;
        this.mPopupContext = new ContextThemeWrapper(r100, r112);
    L9:
        TypedArray r103 = null;
        if (r111 != (-1)) goto L26;
        TypedArray r113 = r100.obtainStyledAttributes(r101, ATTRS_ANDROID_SPINNERMODE, r110, 0);     // Catch: Throwable -> L18 Exception -> L22
    L42:
    L16:
        th = th;
        r103 = r113;
    L19:
        if (r103 == null) goto L21;
        r103.recycle();
    L21:
        throw th;
    L13:
        if (r113.hasValue(0) == false) goto L15;
        r111 = r113.getInt(0, 0);     // Catch: Throwable -> L16 Exception -> L39
    L15:
        r113.recycle();
    L23:
        if (r113 == null) goto L26;
    L22:
        r113 = null;
    L18:
        th = th;
    L26:
        if (r111 == 0) goto L30;
        if (r111 != 1) goto L31;
        final DropdownPopup r114 = new DropdownPopup(this, this.mPopupContext, r101, r110);
        TintTypedArray r104 = TintTypedArray.obtainStyledAttributes(this.mPopupContext, r101, new int[]{R.attr.entries, R.attr.popupBackground, R.attr.prompt, R.attr.dropDownWidth, com.larus.nova.R.attr.popupTheme}, r110, 0);
        this.mDropDownWidth = r104.getLayoutDimension(3, -2);
        r114.setBackgroundDrawable(r104.getDrawable(1));
        r114.setPromptText(r102.getString(2));
        r104.recycle();
        this.mPopup = r114;
        this.mForwardingListener = new AnonymousClass1(this, this, r114);
    L31:
        CharSequence[] r115 = r102.getTextArray(0);
        if (r115 == null) goto L34;
        ArrayAdapter r116 = new ArrayAdapter(r100, R.layout.simple_spinner_item, r115);
        r116.setDropDownViewResource(com.larus.nova.R.layout.support_simple_spinner_dropdown_item);
        setAdapter(r116);
    L34:
        r102.recycle();
        this.mPopupSet = true;
        SpinnerAdapter r105 = this.mTempAdapter;
        if (r105 == null) goto L37;
        setAdapter(r105);
        this.mTempAdapter = null;
    L37:
        this.mBackgroundTintHelper.loadFromAttributes(r101, r110);
        return;
    L30:
        DialogPopup r117 = new DialogPopup(this);
        this.mPopup = r117;
        r117.setPromptText(r102.getString(2));
        goto L31
    L5:
        int r118 = r102.getResourceId(4, 0);
        if (r118 == 0) goto L8;
        this.mPopupContext = new ContextThemeWrapper(r100, r118);
        goto L9
    L8:
        this.mPopupContext = r100;
        goto L9
    }
}
