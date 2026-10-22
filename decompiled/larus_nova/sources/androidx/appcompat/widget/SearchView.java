package androidx.appcompat.widget;

import android.app.PendingIntent;
import android.app.SearchableInfo;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.view.CollapsibleActionView;
import androidx.core.view.ViewCompat;
import androidx.cursoradapter.widget.CursorAdapter;
import androidx.customview.view.AbsSavedState;
import com.alipay.sdk.m.u.i;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.lang.reflect.Method;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes2.dex */
public class SearchView extends LinearLayoutCompat implements CollapsibleActionView {
    static final boolean DBG = false;
    private static final String IME_OPTION_NO_MICROPHONE = "nm";
    static final String LOG_TAG = "SearchView";
    static final PreQAutoCompleteTextViewReflector PRE_API_29_HIDDEN_METHOD_INVOKER = null;
    private Bundle mAppSearchData;
    private boolean mClearingFocus;
    final ImageView mCloseButton;
    private final ImageView mCollapsedIcon;
    private int mCollapsedImeOptions;
    private final CharSequence mDefaultQueryHint;
    private final View mDropDownAnchor;
    private boolean mExpandedInActionView;
    final ImageView mGoButton;
    private boolean mIconified;
    private boolean mIconifiedByDefault;
    private int mMaxWidth;
    private CharSequence mOldQueryText;
    private final View.OnClickListener mOnClickListener;
    private OnCloseListener mOnCloseListener;
    private final TextView.OnEditorActionListener mOnEditorActionListener;
    private final AdapterView.OnItemClickListener mOnItemClickListener;
    private final AdapterView.OnItemSelectedListener mOnItemSelectedListener;
    private OnQueryTextListener mOnQueryChangeListener;
    View.OnFocusChangeListener mOnQueryTextFocusChangeListener;
    private View.OnClickListener mOnSearchClickListener;
    private OnSuggestionListener mOnSuggestionListener;
    private final WeakHashMap<String, Drawable.ConstantState> mOutsideDrawablesCache;
    private CharSequence mQueryHint;
    private boolean mQueryRefinement;
    private Runnable mReleaseCursorRunnable;
    final ImageView mSearchButton;
    private final View mSearchEditFrame;
    private final Drawable mSearchHintIcon;
    private final View mSearchPlate;
    final SearchAutoComplete mSearchSrcTextView;
    private Rect mSearchSrcTextViewBounds;
    private Rect mSearchSrtTextViewBoundsExpanded;
    SearchableInfo mSearchable;
    private final View mSubmitArea;
    private boolean mSubmitButtonEnabled;
    private final int mSuggestionCommitIconResId;
    private final int mSuggestionRowLayout;
    CursorAdapter mSuggestionsAdapter;
    private int[] mTemp;
    private int[] mTemp2;
    View.OnKeyListener mTextKeyListener;
    private TextWatcher mTextWatcher;
    private UpdatableTouchDelegate mTouchDelegate;
    private final Runnable mUpdateDrawableStateRunnable;
    private CharSequence mUserQuery;
    private final Intent mVoiceAppSearchIntent;
    final ImageView mVoiceButton;
    private boolean mVoiceButtonEnabled;
    private final Intent mVoiceWebSearchIntent;

    public interface OnCloseListener {
        boolean onClose();
    }

    public interface OnQueryTextListener {
        boolean onQueryTextChange(String r100);

        boolean onQueryTextSubmit(String r100);
    }

    public interface OnSuggestionListener {
        boolean onSuggestionClick(int r100);

        boolean onSuggestionSelect(int r100);
    }

    public static class PreQAutoCompleteTextViewReflector {
        private Method mDoAfterTextChanged;
        private Method mDoBeforeTextChanged;
        private Method mEnsureImeVisible;

        private static void preApi29Check() {
            if (Build.VERSION.SDK_INT >= 29) goto L6;
            return;
        L6:
            throw new UnsupportedClassVersionError("This function can only be used for API Level < 29.");
        }

        public PreQAutoCompleteTextViewReflector() {
            this.mDoBeforeTextChanged = null;
            this.mDoAfterTextChanged = null;
            this.mEnsureImeVisible = null;
            preApi29Check();
            Method r100 = AutoCompleteTextView.class.getDeclaredMethod("doBeforeTextChanged", new Class[0]);     // Catch: NoSuchMethodException -> L7
            this.mDoBeforeTextChanged = r100;     // Catch: NoSuchMethodException -> L7
            r100.setAccessible(true);     // Catch: NoSuchMethodException -> L7
        L10:
            Method r101 = AutoCompleteTextView.class.getDeclaredMethod("doAfterTextChanged", new Class[0]);     // Catch: NoSuchMethodException -> L8
            this.mDoAfterTextChanged = r101;     // Catch: NoSuchMethodException -> L8
            r101.setAccessible(true);     // Catch: NoSuchMethodException -> L8
        L14:
            Method r102 = AutoCompleteTextView.class.getMethod("ensureImeVisible", new Class[]{Boolean.TYPE});     // Catch: NoSuchMethodException -> L9
            this.mEnsureImeVisible = r102;     // Catch: NoSuchMethodException -> L9
            r102.setAccessible(true);     // Catch: NoSuchMethodException -> L9
            return;
        }

        public void doAfterTextChanged(AutoCompleteTextView r100) {
            preApi29Check();
            Method r101 = this.mDoAfterTextChanged;
            if (r101 != null) goto L8;
            return;
        L8:
            r101.invoke(r100, new Object[0]);     // Catch: Exception -> L7
            return;
        }

        public void doBeforeTextChanged(AutoCompleteTextView r100) {
            preApi29Check();
            Method r101 = this.mDoBeforeTextChanged;
            if (r101 != null) goto L8;
            return;
        L8:
            r101.invoke(r100, new Object[0]);     // Catch: Exception -> L7
            return;
        }

        public void ensureImeVisible(AutoCompleteTextView r100) {
            preApi29Check();
            Method r101 = this.mEnsureImeVisible;
            if (r101 != null) goto L8;
            return;
        L8:
            r101.invoke(r100, new Object[]{Boolean.TRUE});     // Catch: Exception -> L7
            return;
        }
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        boolean isIconified;

        static {
            CREATOR = new AnonymousClass1();
        }

        public String toString() {
            return "SearchView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " isIconified=" + this.isIconified + i.f25855d;
        }

        public SavedState(Parcelable r100) {
            super(r100);
        }

        public SavedState(Parcel r100, ClassLoader r101) {
            super(r100, r101);
            this.isIconified = ((Boolean) r100.readValue(null)).booleanValue();
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel r100, int r101) {
            super.writeToParcel(r100, r101);
            r100.writeValue(Boolean.valueOf(this.isIconified));
        }
    }

    public static class SearchAutoComplete extends AppCompatAutoCompleteTextView {
        private boolean mHasPendingShowSoftInputRequest;
        final Runnable mRunShowSoftInputIfNecessary;
        private SearchView mSearchView;
        private int mThreshold;

        @Override // android.widget.AutoCompleteTextView
        public void performCompletion() {
        }

        @Override // android.widget.AutoCompleteTextView
        public void replaceText(CharSequence r100) {
        }

        @Override // android.widget.AutoCompleteTextView
        public boolean enoughToFilter() {
            if (this.mThreshold > 0) goto L5;
        L8:
            return true;
        L5:
            if (super.enoughToFilter() == true) goto L8;
            return false;
        }

        public void ensureImeVisible() {
            if (Build.VERSION.SDK_INT < 29) goto L7;
            setInputMethodMode(1);
            if (enoughToFilter() == false) goto L9;
            showDropDown();
            return;
        L9:
            return;
        L7:
            SearchView.PRE_API_29_HIDDEN_METHOD_INVOKER.ensureImeVisible(this);
        }

        public void showSoftInputIfNecessary() {
            if (this.mHasPendingShowSoftInputRequest == false) goto L6;
            ((InputMethodManager) getContext().getSystemService("input_method")).showSoftInput(this, 0);
            this.mHasPendingShowSoftInputRequest = false;
            return;
        }

        private int getSearchViewTextMinWidthDp() {
            Configuration r100 = getResources().getConfiguration();
            int r101 = r100.screenWidthDp;
            int r102 = r100.screenHeightDp;
            if (r101 < 960) goto L11;
            if (r102 < 720) goto L11;
            if (r100.orientation != 2) goto L11;
            return 256;
        L11:
            if (r101 < 600) goto L13;
            return 192;
        L13:
            if (r101 >= 640) goto L15;
            return 160;
        L15:
            if (r102 >= 480) goto L22;
            return 160;
        L22:
            return 192;
        }

        public boolean isEmpty() {
            if (TextUtils.getTrimmedLength(getText()) != 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // android.view.View
        public void onFinishInflate() {
            super.onFinishInflate();
            setMinWidth((int) TypedValue.applyDimension(1, getSearchViewTextMinWidthDp(), INVOKEVIRTUAL_androidx_appcompat_widget_SearchView$SearchAutoComplete_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(getResources())));
        }

        public SearchAutoComplete(Context r100) {
            this(r100, null);
        }

        public static DisplayMetrics INVOKEVIRTUAL_androidx_appcompat_widget_SearchView$SearchAutoComplete_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r100) {
            return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
        }

        @Override // androidx.appcompat.widget.AppCompatAutoCompleteTextView, android.widget.TextView, android.view.View
        public InputConnection onCreateInputConnection(EditorInfo r100) {
            InputConnection r101 = super.onCreateInputConnection(r100);
            if (this.mHasPendingShowSoftInputRequest == false) goto L5;
            removeCallbacks(this.mRunShowSoftInputIfNecessary);
            post(this.mRunShowSoftInputIfNecessary);
        L5:
            return r101;
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public void onWindowFocusChanged(boolean r100) {
            super.onWindowFocusChanged(r100);
            if (r100 == true) goto L5;
            return;
        L5:
            if (this.mSearchView.hasFocus() == true) goto L7;
            return;
        L7:
            if (getVisibility() != 0) goto L14;
            this.mHasPendingShowSoftInputRequest = true;
            if (SearchView.isLandscapeMode(getContext()) == false) goto L15;
            ensureImeVisible();
            return;
        L15:
            return;
        }

        public void setImeVisibility(boolean r100) {
            InputMethodManager r101 = (InputMethodManager) getContext().getSystemService("input_method");
            if (r100 == true) goto L7;
            this.mHasPendingShowSoftInputRequest = false;
            removeCallbacks(this.mRunShowSoftInputIfNecessary);
            r101.hideSoftInputFromWindow(getWindowToken(), 0);
            return;
        L7:
            if (r101.isActive(this) == false) goto L10;
            this.mHasPendingShowSoftInputRequest = false;
            removeCallbacks(this.mRunShowSoftInputIfNecessary);
            r101.showSoftInput(this, 0);
            return;
        L10:
            this.mHasPendingShowSoftInputRequest = true;
        }

        public void setSearchView(SearchView r100) {
            this.mSearchView = r100;
        }

        @Override // android.widget.AutoCompleteTextView
        public void setThreshold(int r100) {
            super.setThreshold(r100);
            this.mThreshold = r100;
        }

        public SearchAutoComplete(Context r100, AttributeSet r101) {
            this(r100, r101, R.attr.autoCompleteTextViewStyle);
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public boolean onKeyPreIme(int r100, KeyEvent r101) {
            if (r100 != 4) goto L24;
            if (r101.getAction() != 0) goto L13;
            if (r101.getRepeatCount() != 0) goto L13;
            KeyEvent.DispatcherState r102 = getKeyDispatcherState();
            if (r102 == null) goto L11;
            r102.startTracking(r101, this);
        L11:
            return true;
        L13:
            if (r101.getAction() != 1) goto L24;
            KeyEvent.DispatcherState r103 = getKeyDispatcherState();
            if (r103 == null) goto L18;
            r103.handleUpEvent(r101);
        L18:
            if (r101.isTracking() == false) goto L24;
            if (r101.isCanceled() == true) goto L24;
            this.mSearchView.clearFocus();
            setImeVisibility(false);
            return true;
        L24:
            return super.onKeyPreIme(r100, r101);
        }

        public SearchAutoComplete(Context r100, AttributeSet r101, int r102) {
            super(r100, r101, r102);
            this.mRunShowSoftInputIfNecessary = new AnonymousClass1(this);
            this.mThreshold = getThreshold();
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public void onFocusChanged(boolean r100, int r101, Rect r102) {
            super.onFocusChanged(r100, r101, r102);
            this.mSearchView.onTextFocusChanged();
        }
    }

    public static class UpdatableTouchDelegate extends TouchDelegate {
        private final Rect mActualBounds;
        private boolean mDelegateTargeted;
        private final View mDelegateView;
        private final int mSlop;
        private final Rect mSlopBounds;
        private final Rect mTargetBounds;

        @Override // android.view.TouchDelegate
        public boolean onTouchEvent(MotionEvent r100) {
            int r101 = (int) r100.getX();
            int r102 = (int) r100.getY();
            int r103 = r100.getAction();
            boolean r104 = true;
            if (r103 == 0) goto L18;
            if (r103 == 1) goto L10;
            if (r103 == 2) goto L10;
            if (r103 != 3) goto L20;
            boolean r105 = this.mDelegateTargeted;
            this.mDelegateTargeted = false;
        L15:
            r104 = r105;
        L16:
            boolean r106 = true;
        L21:
            if (r104 == false) goto L29;
            if (r106 == true) goto L24;
        L26:
            Rect r107 = this.mActualBounds;
            r100.setLocation(r101 - r107.left, r102 - r107.top);
        L28:
            return this.mDelegateView.dispatchTouchEvent(r100);
        L24:
            if (this.mActualBounds.contains(r101, r102) == true) goto L26;
            r100.setLocation(this.mDelegateView.getWidth() / 2, this.mDelegateView.getHeight() / 2);
            goto L28
        L29:
            return false;
        L20:
            r106 = true;
            r104 = false;
        L10:
            r105 = this.mDelegateTargeted;
            if (r105 == false) goto L15;
            if (this.mSlopBounds.contains(r101, r102) == true) goto L15;
            r104 = r105;
            r106 = false;
            goto L21
        L18:
            if (this.mTargetBounds.contains(r101, r102) == false) goto L20;
            this.mDelegateTargeted = true;
            goto L16
        }

        public void setBounds(Rect r100, Rect r101) {
            this.mTargetBounds.set(r100);
            this.mSlopBounds.set(r100);
            Rect r102 = this.mSlopBounds;
            int r103 = this.mSlop;
            r102.inset(-r103, -r103);
            this.mActualBounds.set(r101);
        }

        public UpdatableTouchDelegate(Rect r100, Rect r101, View r102) {
            super(r100, r102);
            this.mSlop = ViewConfiguration.get(r102.getContext()).getScaledTouchSlop();
            this.mTargetBounds = new Rect();
            this.mSlopBounds = new Rect();
            this.mActualBounds = new Rect();
            setBounds(r100, r101);
            this.mDelegateView = r102;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void clearFocus() {
        this.mClearingFocus = true;
        super.clearFocus();
        this.mSearchSrcTextView.clearFocus();
        this.mSearchSrcTextView.setImeVisibility(false);
        this.mClearingFocus = false;
    }

    public void onSearchClicked() {
        updateViewsVisibility(false);
        this.mSearchSrcTextView.requestFocus();
        this.mSearchSrcTextView.setImeVisibility(true);
        View.OnClickListener r100 = this.mOnSearchClickListener;
        if (r100 == null) goto L6;
        r100.onClick(this);
        return;
    }

    static {
        if (Build.VERSION.SDK_INT >= 29) goto L5;
        PreQAutoCompleteTextViewReflector r100 = new PreQAutoCompleteTextViewReflector();
    L6:
        PRE_API_29_HIDDEN_METHOD_INVOKER = r100;
        return;
    L5:
        r100 = null;
        goto L6
    }

    private void dismissSuggestions() {
        this.mSearchSrcTextView.dismissDropDown();
    }

    private boolean hasVoiceSearch() {
        SearchableInfo r100 = this.mSearchable;
        if (r100 != null) goto L5;
        return false;
    L5:
        if (r100.getVoiceSearchEnabled() == true) goto L7;
        return false;
    L7:
        if (this.mSearchable.getVoiceSearchLaunchWebSearch() == false) goto L10;
        Intent r101 = this.mVoiceWebSearchIntent;
    L13:
        if (r101 != null) goto L15;
        return false;
    L15:
        if (getContext().getPackageManager().resolveActivity(r101, 65536) == null) goto L21;
        return true;
    L21:
        return false;
    L10:
        if (this.mSearchable.getVoiceSearchLaunchRecognizer() == false) goto L12;
        r101 = this.mVoiceAppSearchIntent;
        goto L13
    L12:
        r101 = null;
        goto L13
    }

    private boolean isSubmitAreaEnabled() {
        if (this.mSubmitButtonEnabled == true) goto L7;
        if (this.mVoiceButtonEnabled == true) goto L7;
    L9:
        return false;
    L7:
        if (isIconified() == true) goto L9;
        return true;
    }

    private void postUpdateFocusedState() {
        post(this.mUpdateDrawableStateRunnable);
    }

    private void updateCloseButton() {
        boolean r100 = true;
        boolean r101 = !TextUtils.isEmpty(this.mSearchSrcTextView.getText());
        int r102 = 0;
        if (r101 == false) goto L5;
    L10:
        ImageView r103 = this.mCloseButton;
        if (r100 == true) goto L14;
        r102 = 8;
    L14:
        r103.setVisibility(r102);
        Drawable r104 = this.mCloseButton.getDrawable();
        if (r104 == null) goto L21;
        if (r101 == false) goto L18;
        int[] r105 = ViewGroup.ENABLED_STATE_SET;
    L19:
        r104.setState(r105);
        return;
    L18:
        r105 = ViewGroup.EMPTY_STATE_SET;
        goto L19
    L21:
        return;
    L5:
        if (this.mIconifiedByDefault == true) goto L7;
    L9:
        r100 = false;
        goto L10
    L7:
        if (this.mExpandedInActionView == true) goto L9;
        goto L9
    }

    private void updateSearchAutoComplete() {
        this.mSearchSrcTextView.setThreshold(this.mSearchable.getSuggestThreshold());
        this.mSearchSrcTextView.setImeOptions(this.mSearchable.getImeOptions());
        int r100 = this.mSearchable.getInputType();
        int r101 = 1;
        if ((r100 & 15) != 1) goto L7;
        r100 = r100 & (-65537);
        if (this.mSearchable.getSuggestAuthority() == null) goto L7;
        r100 = (r100 | 65536) | 524288;
    L7:
        this.mSearchSrcTextView.setInputType(r100);
        CursorAdapter r102 = this.mSuggestionsAdapter;
        if (r102 == null) goto L11;
        r102.changeCursor(null);
    L11:
        if (this.mSearchable.getSuggestAuthority() == null) goto L17;
        SuggestionsAdapter r103 = new SuggestionsAdapter(getContext(), this, this.mSearchable, this.mOutsideDrawablesCache);
        this.mSuggestionsAdapter = r103;
        this.mSearchSrcTextView.setAdapter(r103);
        SuggestionsAdapter r104 = (SuggestionsAdapter) this.mSuggestionsAdapter;
        if (this.mQueryRefinement == false) goto L15;
        r101 = 2;
    L15:
        r104.setQueryRefinement(r101);
        return;
    }

    public void adjustDropDownSizeAndPosition() {
        if (this.mDropDownAnchor.getWidth() <= 1) goto L14;
        Resources r100 = getContext().getResources();
        int r101 = this.mSearchPlate.getPaddingLeft();
        Rect r102 = new Rect();
        boolean r103 = ViewUtils.isLayoutRtl(this);
        if (this.mIconifiedByDefault == false) goto L7;
        int r104 = r100.getDimensionPixelSize(R.dimen.abc_dropdownitem_icon_width) + r100.getDimensionPixelSize(R.dimen.abc_dropdownitem_text_padding_left);
    L8:
        this.mSearchSrcTextView.getDropDownBackground().getPadding(r102);
        if (r103 == false) goto L11;
        int r105 = -r102.left;
    L12:
        this.mSearchSrcTextView.setDropDownHorizontalOffset(r105);
        int r106 = (((this.mDropDownAnchor.getWidth() + r102.left) + r102.right) + r104) - r101;
        this.mSearchSrcTextView.setDropDownWidth(r106);
        return;
    L11:
        r105 = r101 - (r102.left + r104);
        goto L12
    L7:
        r104 = 0;
        goto L8
    }

    public void forceSuggestionQuery() {
        if (Build.VERSION.SDK_INT < 29) goto L5;
        this.mSearchSrcTextView.refreshAutoCompleteResults();
        return;
    L5:
        PreQAutoCompleteTextViewReflector r100 = PRE_API_29_HIDDEN_METHOD_INVOKER;
        r100.doBeforeTextChanged(this.mSearchSrcTextView);
        r100.doAfterTextChanged(this.mSearchSrcTextView);
    }

    public int getImeOptions() {
        return this.mSearchSrcTextView.getImeOptions();
    }

    public int getInputType() {
        return this.mSearchSrcTextView.getInputType();
    }

    public CharSequence getQuery() {
        return this.mSearchSrcTextView.getText();
    }

    public CharSequence getQueryHint() {
        CharSequence r100 = this.mQueryHint;
        if (r100 != null) goto L13;
        SearchableInfo r101 = this.mSearchable;
        if (r101 == null) goto L11;
        if (r101.getHintId() == 0) goto L11;
        return getContext().getText(this.mSearchable.getHintId());
    L11:
        return this.mDefaultQueryHint;
    L13:
        return r100;
    }

    @Override // androidx.appcompat.view.CollapsibleActionView
    public void onActionViewCollapsed() {
        setQuery("", false);
        clearFocus();
        updateViewsVisibility(true);
        this.mSearchSrcTextView.setImeOptions(this.mCollapsedImeOptions);
        this.mExpandedInActionView = false;
    }

    @Override // androidx.appcompat.view.CollapsibleActionView
    public void onActionViewExpanded() {
        if (this.mExpandedInActionView == false) goto L5;
        return;
    L5:
        this.mExpandedInActionView = true;
        int r100 = this.mSearchSrcTextView.getImeOptions();
        this.mCollapsedImeOptions = r100;
        this.mSearchSrcTextView.setImeOptions(r100 | 33554432);
        this.mSearchSrcTextView.setText("");
        setIconified(false);
    }

    public void onCloseClicked() {
        if (TextUtils.isEmpty(this.mSearchSrcTextView.getText()) == true) goto L5;
        this.mSearchSrcTextView.setText("");
        this.mSearchSrcTextView.requestFocus();
        this.mSearchSrcTextView.setImeVisibility(true);
        return;
    L5:
        if (this.mIconifiedByDefault == false) goto L13;
        OnCloseListener r100 = this.mOnCloseListener;
        if (r100 != null) goto L9;
    L10:
        clearFocus();
        updateViewsVisibility(true);
        return;
    L9:
        if (r100.onClose() == false) goto L10;
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        removeCallbacks(this.mUpdateDrawableStateRunnable);
        post(this.mReleaseCursorRunnable);
        super.onDetachedFromWindow();
    }

    public void onSubmitQuery() {
        Editable r100 = this.mSearchSrcTextView.getText();
        if (r100 != null) goto L5;
        return;
    L5:
        if (TextUtils.getTrimmedLength(r100) <= 0) goto L16;
        OnQueryTextListener r101 = this.mOnQueryChangeListener;
        if (r101 == null) goto L11;
        if (r101.onQueryTextSubmit(r100.toString()) == false) goto L11;
        return;
    L11:
        if (this.mSearchable == null) goto L13;
        launchQuerySearch(0, null, r100.toString());
    L13:
        this.mSearchSrcTextView.setImeVisibility(false);
        dismissSuggestions();
        return;
    }

    public void onVoiceClicked() {
        SearchableInfo r100 = this.mSearchable;
        if (r100 != null) goto L14;
        return;
    L14:
        if (r100.getVoiceSearchLaunchWebSearch() == false) goto L9;
        Intent r101 = createVoiceWebSearchIntent(this.mVoiceWebSearchIntent, r100);     // Catch: ActivityNotFoundException -> L12
        getContext().startActivity(r101);     // Catch: ActivityNotFoundException -> L12
    L13:
        return;
    L9:
        if (r100.getVoiceSearchLaunchRecognizer() == false) goto L13;
        Intent r102 = createVoiceAppSearchIntent(this.mVoiceAppSearchIntent, r100);     // Catch: ActivityNotFoundException -> L12
        getContext().startActivity(r102);     // Catch: ActivityNotFoundException -> L12
    }

    public void updateFocusedState() {
        if (this.mSearchSrcTextView.hasFocus() == false) goto L5;
        int[] r100 = ViewGroup.FOCUSED_STATE_SET;
    L6:
        Drawable r101 = this.mSearchPlate.getBackground();
        if (r101 == null) goto L9;
        r101.setState(r100);
    L9:
        Drawable r102 = this.mSubmitArea.getBackground();
        if (r102 == null) goto L12;
        r102.setState(r100);
    L12:
        invalidate();
        return;
    L5:
        r100 = ViewGroup.EMPTY_STATE_SET;
        goto L6
    }

    private int getPreferredHeight() {
        return getContext().getResources().getDimensionPixelSize(R.dimen.abc_search_view_preferred_height);
    }

    private int getPreferredWidth() {
        return getContext().getResources().getDimensionPixelSize(R.dimen.abc_search_view_preferred_width);
    }

    private void updateQueryHint() {
        CharSequence r100 = getQueryHint();
        SearchAutoComplete r101 = this.mSearchSrcTextView;
        if (r100 != null) goto L5;
        r100 = "";
    L5:
        r101.setHint(getDecoratedHint(r100));
    }

    private void updateSubmitArea() {
        if (isSubmitAreaEnabled() == true) goto L5;
    L9:
        int r100 = 8;
    L10:
        this.mSubmitArea.setVisibility(r100);
        return;
    L5:
        if (this.mGoButton.getVisibility() != 0) goto L7;
    L8:
        r100 = 0;
        goto L10
    L7:
        if (this.mVoiceButton.getVisibility() != 0) goto L9;
        goto L8
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState r100 = new SavedState(super.onSaveInstanceState());
        r100.isIconified = isIconified();
        return r100;
    }

    public void onTextFocusChanged() {
        updateViewsVisibility(isIconified());
        postUpdateFocusedState();
        if (this.mSearchSrcTextView.hasFocus() == false) goto L6;
        forceSuggestionQuery();
        return;
    }

    public int getMaxWidth() {
        return this.mMaxWidth;
    }

    public int getSuggestionCommitIconResId() {
        return this.mSuggestionCommitIconResId;
    }

    public int getSuggestionRowLayout() {
        return this.mSuggestionRowLayout;
    }

    public CursorAdapter getSuggestionsAdapter() {
        return this.mSuggestionsAdapter;
    }

    public boolean isIconfiedByDefault() {
        return this.mIconifiedByDefault;
    }

    public boolean isIconified() {
        return this.mIconified;
    }

    public boolean isQueryRefinementEnabled() {
        return this.mQueryRefinement;
    }

    public boolean isSubmitButtonEnabled() {
        return this.mSubmitButtonEnabled;
    }

    public SearchView(Context r100) {
        this(r100, null);
    }

    private CharSequence getDecoratedHint(CharSequence r100) {
        if (this.mIconifiedByDefault == true) goto L5;
    L9:
        return r100;
    L5:
        if (this.mSearchHintIcon == null) goto L9;
        int r101 = (int) (((double) this.mSearchSrcTextView.getTextSize()) * 1.25d);
        this.mSearchHintIcon.setBounds(0, 0, r101, r101);
        SpannableStringBuilder r102 = new SpannableStringBuilder("   ");
        r102.setSpan(new ImageSpan(this.mSearchHintIcon), 1, 2, 33);
        r102.append(r100);
        return r102;
    }

    public static boolean isLandscapeMode(Context r100) {
        if (r100.getResources().getConfiguration().orientation != 2) goto L5;
        return true;
    L5:
        return false;
    }

    private void launchIntent(Intent r100) {
        if (r100 != null) goto L8;
        return;
    L8:
        getContext().startActivity(r100);     // Catch: RuntimeException -> L6
        return;
    L6:
        r100.toString();
    }

    private void rewriteQueryFromSuggestion(int r100) {
        Editable r101 = this.mSearchSrcTextView.getText();
        Cursor r102 = this.mSuggestionsAdapter.getCursor();
        if (r102 != null) goto L6;
        return;
    L6:
        if (r102.moveToPosition(r100) == false) goto L11;
        CharSequence r103 = this.mSuggestionsAdapter.convertToString(r102);
        if (r103 == null) goto L10;
        setQuery(r103);
        return;
    L10:
        setQuery(r101);
        return;
    L11:
        setQuery(r101);
    }

    private void setQuery(CharSequence r100) {
        this.mSearchSrcTextView.setText(r100);
        SearchAutoComplete r101 = this.mSearchSrcTextView;
        if (TextUtils.isEmpty(r100) == false) goto L5;
        int r102 = 0;
    L6:
        r101.setSelection(r102);
        return;
    L5:
        r102 = r100.length();
        goto L6
    }

    private void updateSubmitButton(boolean r100) {
        if (this.mSubmitButtonEnabled == true) goto L5;
    L12:
        int r101 = 8;
    L13:
        this.mGoButton.setVisibility(r101);
        return;
    L5:
        if (isSubmitAreaEnabled() == false) goto L12;
        if (hasFocus() == false) goto L12;
        if (r100 == false) goto L10;
    L11:
        r101 = 0;
        goto L13
    L10:
        if (this.mVoiceButtonEnabled == true) goto L12;
        goto L11
    }

    private void updateViewsVisibility(boolean r100) {
        this.mIconified = r100;
        int r101 = 0;
        if (r100 == false) goto L5;
        int r102 = 0;
    L6:
        boolean r103 = !TextUtils.isEmpty(this.mSearchSrcTextView.getText());
        this.mSearchButton.setVisibility(r102);
        updateSubmitButton(r103);
        View r104 = this.mSearchEditFrame;
        if (r100 == false) goto L9;
        int r105 = 8;
    L10:
        r104.setVisibility(r105);
        if (this.mCollapsedIcon.getDrawable() != null) goto L13;
    L14:
        r101 = 8;
    L15:
        this.mCollapsedIcon.setVisibility(r101);
        updateCloseButton();
        updateVoiceButton(!r103);
        updateSubmitArea();
        return;
    L13:
        if (this.mIconifiedByDefault == false) goto L15;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 8;
        goto L6
    }

    private void updateVoiceButton(boolean r100) {
        int r101 = 8;
        if (this.mVoiceButtonEnabled == true) goto L5;
    L8:
        this.mVoiceButton.setVisibility(r101);
        return;
    L5:
        if (isIconified() == true) goto L8;
        if (r100 == false) goto L8;
        this.mGoButton.setVisibility(8);
        r101 = 0;
        goto L8
    }

    public boolean onItemSelected(int r100) {
        OnSuggestionListener r101 = this.mOnSuggestionListener;
        if (r101 != null) goto L5;
    L9:
        rewriteQueryFromSuggestion(r100);
        return true;
    L5:
        if (r101.onSuggestionSelect(r100) == false) goto L9;
        return false;
    }

    public void onQueryRefine(CharSequence r100) {
        setQuery(r100);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable r100) {
        if ((r100 instanceof SavedState) == true) goto L6;
        super.onRestoreInstanceState(r100);
        return;
    L6:
        SavedState r101 = (SavedState) r100;
        super.onRestoreInstanceState(r101.getSuperState());
        updateViewsVisibility(r101.isIconified);
        requestLayout();
    }

    public void onTextChanged(CharSequence r100) {
        Editable r101 = this.mSearchSrcTextView.getText();
        this.mUserQuery = r101;
        boolean r102 = !TextUtils.isEmpty(r101);
        updateSubmitButton(r102);
        updateVoiceButton(!r102);
        updateCloseButton();
        updateSubmitArea();
        if (this.mOnQueryChangeListener != null) goto L5;
    L7:
        this.mOldQueryText = r100.toString();
        return;
    L5:
        if (TextUtils.equals(r100, this.mOldQueryText) == true) goto L7;
        this.mOnQueryChangeListener.onQueryTextChange(r100.toString());
        goto L7
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean r100) {
        super.onWindowFocusChanged(r100);
        postUpdateFocusedState();
    }

    public void setAppSearchData(Bundle r100) {
        this.mAppSearchData = r100;
    }

    public void setIconified(boolean r100) {
        if (r100 == false) goto L4;
        onCloseClicked();
        return;
    L4:
        onSearchClicked();
    }

    public void setIconifiedByDefault(boolean r100) {
        if (this.mIconifiedByDefault != r100) goto L5;
        return;
    L5:
        this.mIconifiedByDefault = r100;
        updateViewsVisibility(r100);
        updateQueryHint();
    }

    public void setImeOptions(int r100) {
        this.mSearchSrcTextView.setImeOptions(r100);
    }

    public void setInputType(int r100) {
        this.mSearchSrcTextView.setInputType(r100);
    }

    public void setMaxWidth(int r100) {
        this.mMaxWidth = r100;
        requestLayout();
    }

    public void setOnCloseListener(OnCloseListener r100) {
        this.mOnCloseListener = r100;
    }

    public void setOnQueryTextFocusChangeListener(View.OnFocusChangeListener r100) {
        this.mOnQueryTextFocusChangeListener = r100;
    }

    public void setOnQueryTextListener(OnQueryTextListener r100) {
        this.mOnQueryChangeListener = r100;
    }

    public void setOnSearchClickListener(View.OnClickListener r100) {
        this.mOnSearchClickListener = r100;
    }

    public void setOnSuggestionListener(OnSuggestionListener r100) {
        this.mOnSuggestionListener = r100;
    }

    public void setQueryHint(CharSequence r100) {
        this.mQueryHint = r100;
        updateQueryHint();
    }

    public void setQueryRefinementEnabled(boolean r100) {
        this.mQueryRefinement = r100;
        CursorAdapter r101 = this.mSuggestionsAdapter;
        if ((r101 instanceof SuggestionsAdapter) == false) goto L10;
        SuggestionsAdapter r102 = (SuggestionsAdapter) r101;
        if (r100 == false) goto L7;
        int r103 = 2;
    L8:
        r102.setQueryRefinement(r103);
        return;
    L7:
        r103 = 1;
        goto L8
    }

    public void setSearchableInfo(SearchableInfo r100) {
        this.mSearchable = r100;
        if (r100 == null) goto L5;
        updateSearchAutoComplete();
        updateQueryHint();
    L5:
        boolean r101 = hasVoiceSearch();
        this.mVoiceButtonEnabled = r101;
        if (r101 == false) goto L8;
        this.mSearchSrcTextView.setPrivateImeOptions(IME_OPTION_NO_MICROPHONE);
    L8:
        updateViewsVisibility(isIconified());
    }

    public void setSubmitButtonEnabled(boolean r100) {
        this.mSubmitButtonEnabled = r100;
        updateViewsVisibility(isIconified());
    }

    public void setSuggestionsAdapter(CursorAdapter r100) {
        this.mSuggestionsAdapter = r100;
        this.mSearchSrcTextView.setAdapter(r100);
    }

    public SearchView(Context r100, AttributeSet r101) {
        this(r100, r101, R.attr.searchViewStyle);
    }

    private Intent createVoiceAppSearchIntent(Intent r100, SearchableInfo r110) {
        ComponentName r101 = r110.getSearchActivity();
        Intent r102 = new Intent("android.intent.action.SEARCH");
        r102.setComponent(r101);
        PendingIntent r103 = PendingIntent.getActivity(getContext(), 0, r102, 1073741824);
        Bundle r104 = new Bundle();
        Bundle r105 = this.mAppSearchData;
        if (r105 == null) goto L5;
        r104.putParcelable("app_data", r105);
    L5:
        Intent r106 = new Intent(r100);
        Resources r107 = getResources();
        if (r110.getVoiceLanguageModeId() == 0) goto L8;
        String r108 = r107.getString(r110.getVoiceLanguageModeId());
    L9:
        String r109 = null;
        if (r110.getVoicePromptTextId() == 0) goto L12;
        String r111 = r107.getString(r110.getVoicePromptTextId());
    L14:
        if (r110.getVoiceLanguageId() == 0) goto L16;
        String r112 = r107.getString(r110.getVoiceLanguageId());
    L18:
        if (r110.getVoiceMaxResults() == 0) goto L20;
        int r113 = r110.getVoiceMaxResults();
    L21:
        r106.putExtra("android.speech.extra.LANGUAGE_MODEL", r108);
        r106.putExtra("android.speech.extra.PROMPT", r111);
        r106.putExtra("android.speech.extra.LANGUAGE", r112);
        r106.putExtra("android.speech.extra.MAX_RESULTS", r113);
        if (r101 == null) goto L25;
        r109 = r101.flattenToShortString();
    L25:
        r106.putExtra("calling_package", r109);
        r106.putExtra("android.speech.extra.RESULTS_PENDINGINTENT", r103);
        r106.putExtra("android.speech.extra.RESULTS_PENDINGINTENT_BUNDLE", r104);
        return r106;
    L20:
        r113 = 1;
        goto L21
    L16:
        r112 = null;
        goto L18
    L12:
        r111 = null;
        goto L14
    L8:
        r108 = "free_form";
        goto L9
    }

    private Intent createVoiceWebSearchIntent(Intent r100, SearchableInfo r101) {
        Intent r102 = new Intent(r100);
        ComponentName r103 = r101.getSearchActivity();
        if (r103 != null) goto L5;
        String r104 = null;
    L6:
        r102.putExtra("calling_package", r104);
        return r102;
    L5:
        r104 = r103.flattenToShortString();
        goto L6
    }

    private void getChildBoundsWithinSearchView(View r100, Rect r101) {
        r100.getLocationInWindow(this.mTemp);
        getLocationInWindow(this.mTemp2);
        int[] r102 = this.mTemp;
        int r103 = r102[1];
        int[] r104 = this.mTemp2;
        int r105 = r103 - r104[1];
        int r106 = r102[0] - r104[0];
        r101.set(r106, r105, r100.getWidth() + r106, r100.getHeight() + r105);
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.View
    public void onMeasure(int r100, int r101) {
        if (isIconified() == false) goto L6;
        super.onMeasure(r100, r101);
        return;
    L6:
        int r102 = View.MeasureSpec.getMode(r100);
        int r103 = View.MeasureSpec.getSize(r100);
        if (r102 == Integer.MIN_VALUE) goto L18;
        if (r102 == 0) goto L14;
        if (r102 != 1073741824) goto L22;
        int r104 = this.mMaxWidth;
        if (r104 <= 0) goto L22;
        r103 = Math.min(r104, r103);
    L22:
        int r105 = View.MeasureSpec.getMode(r101);
        int r106 = View.MeasureSpec.getSize(r101);
        if (r105 == Integer.MIN_VALUE) goto L27;
        if (r105 != 0) goto L28;
        r106 = getPreferredHeight();
    L28:
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(r103, 1073741824), View.MeasureSpec.makeMeasureSpec(r106, 1073741824));
        return;
    L27:
        r106 = Math.min(getPreferredHeight(), r106);
        goto L28
    L14:
        r103 = this.mMaxWidth;
        if (r103 > 0) goto L22;
        r103 = getPreferredWidth();
        goto L22
    L18:
        int r107 = this.mMaxWidth;
        if (r107 <= 0) goto L21;
        r103 = Math.min(r107, r103);
        goto L22
    L21:
        r103 = Math.min(getPreferredWidth(), r103);
        goto L22
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean requestFocus(int r100, Rect r101) {
        if (this.mClearingFocus == false) goto L6;
        return false;
    L6:
        if (isFocusable() == true) goto L9;
        return false;
    L9:
        if (isIconified() == true) goto L15;
        boolean r102 = this.mSearchSrcTextView.requestFocus(r100, r101);
        if (r102 == false) goto L13;
        updateViewsVisibility(false);
    L13:
        return r102;
    L15:
        return super.requestFocus(r100, r101);
    }

    public void setQuery(CharSequence r100, boolean r101) {
        this.mSearchSrcTextView.setText(r100);
        if (r100 == null) goto L5;
        SearchAutoComplete r102 = this.mSearchSrcTextView;
        r102.setSelection(r102.length());
        this.mUserQuery = r100;
    L5:
        if (r101 == true) goto L7;
        return;
    L7:
        if (TextUtils.isEmpty(r100) == true) goto L11;
        onSubmitQuery();
        return;
    }

    public SearchView(Context r110, AttributeSet r111, int r112) {
        super(r110, r111, r112);
        this.mSearchSrcTextViewBounds = new Rect();
        this.mSearchSrtTextViewBoundsExpanded = new Rect();
        this.mTemp = new int[2];
        this.mTemp2 = new int[2];
        this.mUpdateDrawableStateRunnable = new AnonymousClass1(this);
        this.mReleaseCursorRunnable = new AnonymousClass2(this);
        this.mOutsideDrawablesCache = new WeakHashMap();
        View.OnClickListener r100 = new AnonymousClass5(this);
        this.mOnClickListener = r100;
        this.mTextKeyListener = new AnonymousClass6(this);
        TextView.OnEditorActionListener r101 = new AnonymousClass7(this);
        this.mOnEditorActionListener = r101;
        AdapterView.OnItemClickListener r102 = new AnonymousClass8(this);
        this.mOnItemClickListener = r102;
        AdapterView.OnItemSelectedListener r103 = new AnonymousClass9(this);
        this.mOnItemSelectedListener = r103;
        this.mTextWatcher = new AnonymousClass10(this);
        TintTypedArray r104 = TintTypedArray.obtainStyledAttributes(r110, r111, new int[]{android.R.attr.focusable, android.R.attr.maxWidth, android.R.attr.inputType, android.R.attr.imeOptions, R.attr.closeIcon, R.attr.commitIcon, R.attr.defaultQueryHint, R.attr.goIcon, R.attr.iconifiedByDefault, R.attr.layout, R.attr.queryBackground, R.attr.queryHint, R.attr.searchHintIcon, R.attr.searchIcon, R.attr.showCancelBtn, R.attr.submitBackground, R.attr.suggestionRowLayout, R.attr.voiceIcon}, r112, 0);
        LayoutInflater.from(r110).inflate(r104.getResourceId(9, R.layout.abc_search_view), this, true);
        SearchAutoComplete r105 = (SearchAutoComplete) findViewById(R.id.search_src_text);
        this.mSearchSrcTextView = r105;
        r105.setSearchView(this);
        this.mSearchEditFrame = findViewById(R.id.search_edit_frame);
        View r106 = findViewById(R.id.search_plate);
        this.mSearchPlate = r106;
        View r113 = findViewById(R.id.submit_area);
        this.mSubmitArea = r113;
        ImageView r114 = (ImageView) findViewById(R.id.search_button);
        this.mSearchButton = r114;
        ImageView r115 = (ImageView) findViewById(R.id.search_go_btn);
        this.mGoButton = r115;
        ImageView r116 = (ImageView) findViewById(R.id.search_close_btn);
        this.mCloseButton = r116;
        ImageView r117 = (ImageView) findViewById(R.id.search_voice_btn);
        this.mVoiceButton = r117;
        ImageView r107 = (ImageView) findViewById(R.id.search_mag_icon);
        this.mCollapsedIcon = r107;
        ViewCompat.setBackground(r106, r104.getDrawable(10));
        ViewCompat.setBackground(r113, r104.getDrawable(15));
        r114.setImageDrawable(r104.getDrawable(13));
        r115.setImageDrawable(r104.getDrawable(7));
        r116.setImageDrawable(r104.getDrawable(4));
        r117.setImageDrawable(r104.getDrawable(17));
        r107.setImageDrawable(r104.getDrawable(13));
        this.mSearchHintIcon = r104.getDrawable(12);
        TooltipCompat.setTooltipText(r114, getResources().getString(R.string.abc_searchview_description_search));
        this.mSuggestionRowLayout = r104.getResourceId(16, R.layout.abc_search_dropdown_item_icons_2line);
        this.mSuggestionCommitIconResId = r104.getResourceId(5, 0);
        r114.setOnClickListener(r100);
        r116.setOnClickListener(r100);
        r115.setOnClickListener(r100);
        r117.setOnClickListener(r100);
        r105.setOnClickListener(r100);
        r105.addTextChangedListener(this.mTextWatcher);
        r105.setOnEditorActionListener(r101);
        r105.setOnItemClickListener(r102);
        r105.setOnItemSelectedListener(r103);
        r105.setOnKeyListener(this.mTextKeyListener);
        r105.setOnFocusChangeListener(new AnonymousClass3(this));
        setIconifiedByDefault(r104.getBoolean(8, true));
        int r108 = r104.getDimensionPixelSize(1, -1);
        if (r108 == (-1)) goto L5;
        setMaxWidth(r108);
    L5:
        this.mDefaultQueryHint = r104.getText(6);
        this.mQueryHint = r104.getText(11);
        int r109 = r104.getInt(3, -1);
        if (r109 == (-1)) goto L8;
        setImeOptions(r109);
    L8:
        int r118 = r104.getInt(2, -1);
        if (r118 == (-1)) goto L11;
        setInputType(r118);
    L11:
        setFocusable(r104.getBoolean(0, true));
        r104.recycle();
        Intent r119 = new Intent("android.speech.action.WEB_SEARCH");
        this.mVoiceWebSearchIntent = r119;
        r119.addFlags(268435456);
        r119.putExtra("android.speech.extra.LANGUAGE_MODEL", "web_search");
        Intent r120 = new Intent("android.speech.action.RECOGNIZE_SPEECH");
        this.mVoiceAppSearchIntent = r120;
        r120.addFlags(268435456);
        View r121 = findViewById(r105.getDropDownAnchor());
        this.mDropDownAnchor = r121;
        if (r121 == null) goto L14;
        r121.addOnLayoutChangeListener(new AnonymousClass4(this));
    L14:
        updateViewsVisibility(this.mIconifiedByDefault);
        updateQueryHint();
    }

    private Intent createIntentFromSuggestion(Cursor r110, int r111, String r112) {
        String r100 = SuggestionsAdapter.getColumnString(r110, "suggest_intent_action");     // Catch: RuntimeException -> L20
        if (r100 != null) goto L6;
        r100 = this.mSearchable.getSuggestIntentAction();     // Catch: RuntimeException -> L20
    L6:
        if (r100 != null) goto L8;
        r100 = "android.intent.action.SEARCH";
    L8:
        String r101 = r100;
        String r102 = SuggestionsAdapter.getColumnString(r110, "suggest_intent_data");     // Catch: RuntimeException -> L20
        if (r102 != null) goto L11;
        r102 = this.mSearchable.getSuggestIntentData();     // Catch: RuntimeException -> L20
    L11:
        if (r102 == null) goto L15;
        String r103 = SuggestionsAdapter.getColumnString(r110, "suggest_intent_data_id");     // Catch: RuntimeException -> L20
        if (r103 == null) goto L15;
        r102 = r102 + HTTP.URL_DEFAULT + Uri.encode(r103);     // Catch: RuntimeException -> L20
    L15:
        if (r102 != null) goto L17;
        Uri r104 = null;
    L18:
        return createIntent(r101, r104, SuggestionsAdapter.getColumnString(r110, "suggest_intent_extra_data"), SuggestionsAdapter.getColumnString(r110, "suggest_intent_query"), r111, r112);
    L17:
        r104 = UriProtector.parse(r102);     // Catch: RuntimeException -> L20
    L20:
        r110.getPosition();     // Catch: RuntimeException -> L23
    L22:
        return null;
    }

    private boolean launchSuggestion(int r100, int r101, String r102) {
        Cursor r103 = this.mSuggestionsAdapter.getCursor();
        if (r103 != null) goto L5;
        return false;
    L5:
        if (r103.moveToPosition(r100) == false) goto L10;
        launchIntent(createIntentFromSuggestion(r103, r101, r102));
        return true;
    L10:
        return false;
    }

    public void launchQuerySearch(int r100, String r101, String r110) {
        Intent r102 = createIntent("android.intent.action.SEARCH", null, null, r110, r100, r101);
        getContext().startActivity(r102);
    }

    public boolean onItemClicked(int r100, int r101, String r102) {
        OnSuggestionListener r103 = this.mOnSuggestionListener;
        if (r103 != null) goto L5;
    L8:
        launchSuggestion(r100, 0, null);
        this.mSearchSrcTextView.setImeVisibility(false);
        dismissSuggestions();
        return true;
    L5:
        if (r103.onSuggestionClick(r100) == false) goto L8;
        return false;
    }

    public boolean onSuggestionsKey(View r100, int r101, KeyEvent r102) {
        if (this.mSearchable != null) goto L6;
        return false;
    L6:
        if (this.mSuggestionsAdapter != null) goto L9;
        return false;
    L9:
        if (r102.getAction() == 0) goto L11;
    L35:
        return false;
    L11:
        if (r102.hasNoModifiers() == false) goto L35;
        if (r101 == 66) goto L34;
        if (r101 == 84) goto L34;
        if (r101 == 61) goto L34;
        if (r101 != 21) goto L22;
    L28:
        if (r101 != 21) goto L30;
        int r103 = 0;
    L31:
        this.mSearchSrcTextView.setSelection(r103);
        this.mSearchSrcTextView.setListSelection(0);
        this.mSearchSrcTextView.clearListSelection();
        this.mSearchSrcTextView.ensureImeVisible();
        return true;
    L30:
        r103 = this.mSearchSrcTextView.length();
        goto L31
    L22:
        if (r101 == 22) goto L28;
        if (r101 != 19) goto L35;
        this.mSearchSrcTextView.getListSelection();
        return false;
    L34:
        return onItemClicked(this.mSearchSrcTextView.getListSelection(), 0, null);
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup, android.view.View
    public void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        super.onLayout(r100, r101, r102, r103, r104);
        if (r100 == false) goto L9;
        getChildBoundsWithinSearchView(this.mSearchSrcTextView, this.mSearchSrcTextViewBounds);
        Rect r105 = this.mSearchSrtTextViewBoundsExpanded;
        Rect r106 = this.mSearchSrcTextViewBounds;
        r105.set(r106.left, 0, r106.right, r104 - r102);
        UpdatableTouchDelegate r107 = this.mTouchDelegate;
        if (r107 != null) goto L7;
        UpdatableTouchDelegate r108 = new UpdatableTouchDelegate(this.mSearchSrtTextViewBoundsExpanded, this.mSearchSrcTextViewBounds, this.mSearchSrcTextView);
        this.mTouchDelegate = r108;
        setTouchDelegate(r108);
        return;
    L7:
        r107.setBounds(this.mSearchSrtTextViewBoundsExpanded, this.mSearchSrcTextViewBounds);
        return;
    }

    private Intent createIntent(String r100, Uri r101, String r102, String r103, int r104, String r105) {
        Intent r106 = new Intent(r100);
        r106.addFlags(268435456);
        if (r101 == null) goto L5;
        r106.setData(r101);
    L5:
        r106.putExtra("user_query", this.mUserQuery);
        if (r103 == null) goto L8;
        r106.putExtra("query", r103);
    L8:
        if (r102 == null) goto L10;
        r106.putExtra("intent_extra_data_key", r102);
    L10:
        Bundle r107 = this.mAppSearchData;
        if (r107 == null) goto L13;
        r106.putExtra("app_data", r107);
    L13:
        if (r104 == 0) goto L15;
        r106.putExtra("action_key", r104);
        r106.putExtra("action_msg", r105);
    L15:
        r106.setComponent(this.mSearchable.getSearchActivity());
        return r106;
    }
}
