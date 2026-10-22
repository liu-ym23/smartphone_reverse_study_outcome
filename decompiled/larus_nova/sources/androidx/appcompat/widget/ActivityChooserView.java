package androidx.appcompat.widget;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.core.view.ActionProvider;
import androidx.core.view.ViewCompat;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;

/* JADX INFO: loaded from: classes2.dex */
public class ActivityChooserView extends ViewGroup implements ActivityChooserModel.ActivityChooserModelClient {
    private final View mActivityChooserContent;
    private final Drawable mActivityChooserContentBackground;
    final ActivityChooserViewAdapter mAdapter;
    private final Callbacks mCallbacks;
    private int mDefaultActionButtonContentDescription;
    final FrameLayout mDefaultActivityButton;
    private final ImageView mDefaultActivityButtonImage;
    final FrameLayout mExpandActivityOverflowButton;
    private final ImageView mExpandActivityOverflowButtonImage;
    int mInitialActivityCount;
    private boolean mIsAttachedToWindow;
    boolean mIsSelectingDefaultActivity;
    private final int mListPopupMaxWidth;
    private ListPopupWindow mListPopupWindow;
    final DataSetObserver mModelDataSetObserver;
    PopupWindow.OnDismissListener mOnDismissListener;
    private final ViewTreeObserver.OnGlobalLayoutListener mOnGlobalLayoutListener;
    ActionProvider mProvider;

    public class ActivityChooserViewAdapter extends BaseAdapter {
        private static final int ITEM_VIEW_TYPE_ACTIVITY = 0;
        private static final int ITEM_VIEW_TYPE_COUNT = 3;
        private static final int ITEM_VIEW_TYPE_FOOTER = 1;
        public static final int MAX_ACTIVITY_COUNT_DEFAULT = 4;
        public static final int MAX_ACTIVITY_COUNT_UNLIMITED = Integer.MAX_VALUE;
        private ActivityChooserModel mDataModel;
        private boolean mHighlightDefaultActivity;
        private int mMaxActivityCount;
        private boolean mShowDefaultActivity;
        private boolean mShowFooterView;
        final /* synthetic */ ActivityChooserView this$0;

        @Override // android.widget.Adapter
        public long getItemId(int r100) {
            return r100;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getViewTypeCount() {
            return 3;
        }

        public int getActivityCount() {
            return this.mDataModel.getActivityCount();
        }

        @Override // android.widget.Adapter
        public int getCount() {
            int r100 = this.mDataModel.getActivityCount();
            if (this.mShowDefaultActivity == false) goto L5;
        L7:
            int r101 = Math.min(r100, this.mMaxActivityCount);
            if (this.mShowFooterView == true) goto L10;
            return r101;
        L10:
            return r101 + 1;
        L5:
            if (this.mDataModel.getDefaultActivity() == null) goto L7;
            r100 = r100 - 1;
            goto L7
        }

        public ResolveInfo getDefaultActivity() {
            return this.mDataModel.getDefaultActivity();
        }

        public int getHistorySize() {
            return this.mDataModel.getHistorySize();
        }

        public int measureContentWidth() {
            int r100 = this.mMaxActivityCount;
            this.mMaxActivityCount = Integer.MAX_VALUE;
            int r101 = 0;
            int r102 = View.MeasureSpec.makeMeasureSpec(0, 0);
            int r103 = View.MeasureSpec.makeMeasureSpec(0, 0);
            int r104 = getCount();
            View r105 = null;
            int r106 = 0;
        L3:
            if (r101 >= r104) goto L5;
            r105 = getView(r101, r105, null);
            r105.measure(r102, r103);
            r106 = Math.max(r106, r105.getMeasuredWidth());
            r101 = r101 + 1;
            goto L3
        L5:
            this.mMaxActivityCount = r100;
            return r106;
        }

        public ActivityChooserModel getDataModel() {
            return this.mDataModel;
        }

        public boolean getShowDefaultActivity() {
            return this.mShowDefaultActivity;
        }

        public ActivityChooserViewAdapter(ActivityChooserView r100) {
            this.this$0 = r100;
            this.mMaxActivityCount = 4;
        }

        @Override // android.widget.Adapter
        public Object getItem(int r100) {
            int r101 = getItemViewType(r100);
            if (r101 == 0) goto L11;
            if (r101 != 1) goto L9;
            return null;
        L9:
            throw new IllegalArgumentException();
        L11:
            if (this.mShowDefaultActivity == true) goto L16;
            if (this.mDataModel.getDefaultActivity() == null) goto L16;
            r100 = r100 + 1;
        L16:
            return this.mDataModel.getActivity(r100);
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getItemViewType(int r100) {
            if (this.mShowFooterView == true) goto L5;
            return 0;
        L5:
            if (r100 != (getCount() - 1)) goto L9;
            return 1;
        L9:
            return 0;
        }

        public void setDataModel(ActivityChooserModel r100) {
            ActivityChooserModel r101 = this.this$0.mAdapter.getDataModel();
            if (r101 != null) goto L5;
        L7:
            this.mDataModel = r100;
            if (r100 != null) goto L10;
        L12:
            notifyDataSetChanged();
            return;
        L10:
            if (this.this$0.isShown() == false) goto L12;
            r100.registerObserver(this.this$0.mModelDataSetObserver);
            goto L12
        L5:
            if (this.this$0.isShown() == false) goto L7;
            r101.unregisterObserver(this.this$0.mModelDataSetObserver);
            goto L7
        }

        public void setMaxActivityCount(int r100) {
            if (this.mMaxActivityCount == r100) goto L6;
            this.mMaxActivityCount = r100;
            notifyDataSetChanged();
            return;
        }

        public void setShowFooterView(boolean r100) {
            if (this.mShowFooterView == r100) goto L6;
            this.mShowFooterView = r100;
            notifyDataSetChanged();
            return;
        }

        public void setShowDefaultActivity(boolean r100, boolean r101) {
            if (this.mShowDefaultActivity == r100) goto L5;
        L6:
            this.mShowDefaultActivity = r100;
            this.mHighlightDefaultActivity = r101;
            notifyDataSetChanged();
            return;
        L5:
            if (this.mHighlightDefaultActivity != r101) goto L6;
        }

        @Override // android.widget.Adapter
        public View getView(int r100, View r101, ViewGroup r102) {
            int r103 = getItemViewType(r100);
            if (r103 == 0) goto L12;
            if (r103 != 1) goto L11;
            if (r101 != null) goto L7;
        L8:
            View r104 = LayoutInflater.from(this.this$0.getContext()).inflate(R.layout.abc_activity_chooser_view_list_item, r102, false);
            r104.setId(1);
            ((TextView) r104.findViewById(R.id.title)).setText(this.this$0.getContext().getString(R.string.abc_activity_chooser_view_see_all));
            return r104;
        L7:
            if (r101.getId() != 1) goto L8;
            return r101;
        L11:
            throw new IllegalArgumentException();
        L12:
            if (r101 != null) goto L14;
        L15:
            r101 = LayoutInflater.from(this.this$0.getContext()).inflate(R.layout.abc_activity_chooser_view_list_item, r102, false);
        L16:
            PackageManager r105 = this.this$0.getContext().getPackageManager();
            ImageView r106 = (ImageView) r101.findViewById(R.id.icon);
            ResolveInfo r107 = (ResolveInfo) getItem(r100);
            r106.setImageDrawable(r107.loadIcon(r105));
            ((TextView) r101.findViewById(R.id.title)).setText(r107.loadLabel(r105));
            if (this.mShowDefaultActivity == false) goto L22;
            if (r100 != 0) goto L22;
            if (this.mHighlightDefaultActivity == false) goto L22;
            r101.setActivated(true);
        L23:
            return r101;
        L22:
            r101.setActivated(false);
            goto L23
        L14:
            if (r101.getId() == R.id.list_item) goto L16;
            goto L15
        }
    }

    public class Callbacks implements AdapterView.OnItemClickListener, View.OnClickListener, View.OnLongClickListener, PopupWindow.OnDismissListener {
        final /* synthetic */ ActivityChooserView this$0;

        private void notifyOnDismissListener() {
            PopupWindow.OnDismissListener r100 = this.this$0.mOnDismissListener;
            if (r100 == null) goto L6;
            r100.onDismiss();
            return;
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            notifyOnDismissListener();
            ActionProvider r100 = this.this$0.mProvider;
            if (r100 == null) goto L6;
            r100.subUiVisibilityChanged(false);
            return;
        }

        public Callbacks(ActivityChooserView r100) {
            this.this$0 = r100;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View r100) {
            ActivityChooserView r101 = this.this$0;
            if (r100 != r101.mDefaultActivityButton) goto L8;
            r101.dismissPopup();
            ResolveInfo r102 = this.this$0.mAdapter.getDefaultActivity();
            int r103 = this.this$0.mAdapter.getDataModel().getActivityIndex(r102);
            Intent r104 = this.this$0.mAdapter.getDataModel().chooseActivity(r103);
            if (r104 == null) goto L13;
            r104.addFlags(524288);
            this.this$0.getContext().startActivity(r104);
            return;
        L13:
            return;
        L8:
            if (r100 != r101.mExpandActivityOverflowButton) goto L12;
            r101.mIsSelectingDefaultActivity = false;
            r101.showPopupUnchecked(r101.mInitialActivityCount);
            return;
        L12:
            throw new IllegalArgumentException();
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View r100) {
            ActivityChooserView r101 = this.this$0;
            if (r100 != r101.mDefaultActivityButton) goto L9;
            if (r101.mAdapter.getCount() <= 0) goto L7;
            ActivityChooserView r102 = this.this$0;
            r102.mIsSelectingDefaultActivity = true;
            r102.showPopupUnchecked(r102.mInitialActivityCount);
        L7:
            return true;
        L9:
            throw new IllegalArgumentException();
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> r100, View r101, int r102, long r103) {
            int r104 = ((ActivityChooserViewAdapter) r100.getAdapter()).getItemViewType(r102);
            if (r104 != 0) goto L5;
            this.this$0.dismissPopup();
            ActivityChooserView r105 = this.this$0;
            if (r105.mIsSelectingDefaultActivity == false) goto L14;
            if (r102 <= 0) goto L22;
            r105.mAdapter.getDataModel().setDefaultActivity(r102);
            return;
        L22:
            return;
        L14:
            if (r105.mAdapter.getShowDefaultActivity() == true) goto L17;
            r102 = r102 + 1;
        L17:
            Intent r106 = this.this$0.mAdapter.getDataModel().chooseActivity(r102);
            if (r106 == null) goto L24;
            r106.addFlags(524288);
            this.this$0.getContext().startActivity(r106);
            return;
        L24:
            return;
        L5:
            if (r104 != 1) goto L8;
            this.this$0.showPopupUnchecked(Integer.MAX_VALUE);
            return;
        L8:
            throw new IllegalArgumentException();
        }
    }

    public static class InnerLayout extends LinearLayout {
        private static final int[] TINT_ATTRS = null;

        static {
            TINT_ATTRS = new int[]{android.R.attr.background};
        }

        public InnerLayout(Context r100, AttributeSet r101) {
            super(r100, r101);
            TintTypedArray r102 = TintTypedArray.obtainStyledAttributes(r100, r101, TINT_ATTRS);
            setBackgroundDrawable(r102.getDrawable(0));
            r102.recycle();
        }
    }

    public ActivityChooserModel getDataModel() {
        return this.mAdapter.getDataModel();
    }

    public ListPopupWindow getListPopupWindow() {
        if (this.mListPopupWindow != null) goto L6;
        ListPopupWindow r100 = new ListPopupWindow(getContext());
        this.mListPopupWindow = r100;
        r100.setAdapter(this.mAdapter);
        this.mListPopupWindow.setAnchorView(this);
        this.mListPopupWindow.setModal(true);
        this.mListPopupWindow.setOnItemClickListener(this.mCallbacks);
        this.mListPopupWindow.setOnDismissListener(this.mCallbacks);
    L6:
        return this.mListPopupWindow;
    }

    public void updateAppearance() {
        if (this.mAdapter.getCount() <= 0) goto L5;
        this.mExpandActivityOverflowButton.setEnabled(true);
    L6:
        int r100 = this.mAdapter.getActivityCount();
        int r101 = this.mAdapter.getHistorySize();
        if (r100 == 1) goto L12;
        if (r100 <= 1) goto L11;
        if (r101 > 0) goto L12;
    L11:
        this.mDefaultActivityButton.setVisibility(8);
    L16:
        if (this.mDefaultActivityButton.getVisibility() != 0) goto L18;
        this.mActivityChooserContent.setBackgroundDrawable(this.mActivityChooserContentBackground);
        return;
    L18:
        this.mActivityChooserContent.setBackgroundDrawable(null);
        return;
    L12:
        this.mDefaultActivityButton.setVisibility(0);
        ResolveInfo r102 = this.mAdapter.getDefaultActivity();
        PackageManager r103 = getContext().getPackageManager();
        this.mDefaultActivityButtonImage.setImageDrawable(r102.loadIcon(r103));
        if (this.mDefaultActionButtonContentDescription == 0) goto L16;
        CharSequence r104 = r102.loadLabel(r103);
        this.mDefaultActivityButton.setContentDescription(getContext().getString(this.mDefaultActionButtonContentDescription, new Object[]{r104}));
        goto L16
    L5:
        this.mExpandActivityOverflowButton.setEnabled(false);
        goto L6
    }

    public boolean dismissPopup() {
        if (isShowingPopup() == false) goto L9;
        getListPopupWindow().dismiss();
        ViewTreeObserver r100 = getViewTreeObserver();
        if (r100.isAlive() == false) goto L10;
        r100.removeGlobalOnLayoutListener(this.mOnGlobalLayoutListener);
        return true;
    L10:
        return true;
    L9:
        return true;
    }

    public boolean isShowingPopup() {
        return getListPopupWindow().isShowing();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        ActivityChooserModel r100 = this.mAdapter.getDataModel();
        if (r100 == null) goto L5;
        r100.registerObserver(this.mModelDataSetObserver);
    L5:
        this.mIsAttachedToWindow = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ActivityChooserModel r100 = this.mAdapter.getDataModel();
        if (r100 == null) goto L5;
        r100.unregisterObserver(this.mModelDataSetObserver);
    L5:
        ViewTreeObserver r101 = getViewTreeObserver();
        if (r101.isAlive() == false) goto L9;
        r101.removeGlobalOnLayoutListener(this.mOnGlobalLayoutListener);
    L9:
        if (isShowingPopup() == false) goto L11;
        dismissPopup();
    L11:
        this.mIsAttachedToWindow = false;
    }

    public boolean showPopup() {
        if (isShowingPopup() == false) goto L5;
    L9:
        return false;
    L5:
        if (this.mIsAttachedToWindow == false) goto L9;
        this.mIsSelectingDefaultActivity = false;
        showPopupUnchecked(this.mInitialActivityCount);
        return true;
    }

    public ActivityChooserView(Context r100) {
        this(r100, null);
    }

    public static DisplayMetrics INVOKEVIRTUAL_androidx_appcompat_widget_ActivityChooserView_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    @Override // androidx.appcompat.widget.ActivityChooserModel.ActivityChooserModelClient
    public void setActivityChooserModel(ActivityChooserModel r100) {
        this.mAdapter.setDataModel(r100);
        if (isShowingPopup() == false) goto L6;
        dismissPopup();
        showPopup();
        return;
    }

    public void setDefaultActionButtonContentDescription(int r100) {
        this.mDefaultActionButtonContentDescription = r100;
    }

    public void setExpandActivityOverflowButtonContentDescription(int r100) {
        String r101 = getContext().getString(r100);
        this.mExpandActivityOverflowButtonImage.setContentDescription(r101);
    }

    public void setExpandActivityOverflowButtonDrawable(Drawable r100) {
        this.mExpandActivityOverflowButtonImage.setImageDrawable(r100);
    }

    public void setInitialActivityCount(int r100) {
        this.mInitialActivityCount = r100;
    }

    public void setOnDismissListener(PopupWindow.OnDismissListener r100) {
        this.mOnDismissListener = r100;
    }

    public void setProvider(ActionProvider r100) {
        this.mProvider = r100;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7, types: [boolean, int] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public void showPopupUnchecked(int r100) {
        if (this.mAdapter.getDataModel() == null) goto L28;
        getViewTreeObserver().addOnGlobalLayoutListener(this.mOnGlobalLayoutListener);
        if (this.mDefaultActivityButton.getVisibility() != 0) goto L7;
        ?? r101 = 1;
    L8:
        int r102 = this.mAdapter.getActivityCount();
        if (r100 != Integer.MAX_VALUE) goto L11;
    L13:
        this.mAdapter.setShowFooterView(false);
        this.mAdapter.setMaxActivityCount(r100);
    L14:
        ListPopupWindow r103 = getListPopupWindow();
        if (r103.isShowing() == false) goto L17;
        return;
    L17:
        if (this.mIsSelectingDefaultActivity == true) goto L21;
        if (r101 == 0) goto L21;
        this.mAdapter.setShowDefaultActivity(false, false);
    L22:
        r103.setContentWidth(Math.min(this.mAdapter.measureContentWidth(), this.mListPopupMaxWidth));
        r103.show();
        ActionProvider r104 = this.mProvider;
        if (r104 == null) goto L25;
        r104.subUiVisibilityChanged(true);
    L25:
        r103.getListView().setContentDescription(getContext().getString(R.string.abc_activitychooserview_choose_application));
        r103.getListView().setSelector(new ColorDrawable(0));
        return;
    L21:
        this.mAdapter.setShowDefaultActivity(true, r101);
        goto L22
    L11:
        if (r102 <= (r100 + r101)) goto L13;
        this.mAdapter.setShowFooterView(true);
        this.mAdapter.setMaxActivityCount(r100 - 1);
        goto L14
    L7:
        r101 = 0;
        goto L8
    L28:
        throw new IllegalStateException("No data model. Did you call #setDataModel?");
    }

    public ActivityChooserView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    @Override // android.view.View
    public void onMeasure(int r100, int r101) {
        View r102 = this.mActivityChooserContent;
        if (this.mDefaultActivityButton.getVisibility() == 0) goto L5;
        r101 = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(r101), 1073741824);
    L5:
        measureChild(r102, r100, r101);
        setMeasuredDimension(r102.getMeasuredWidth(), r102.getMeasuredHeight());
    }

    public ActivityChooserView(Context r110, AttributeSet r111, int r112) {
        super(r110, r111, r112);
        this.mModelDataSetObserver = new AnonymousClass1(this);
        this.mOnGlobalLayoutListener = new AnonymousClass2(this);
        this.mInitialActivityCount = 4;
        TypedArray r100 = r110.obtainStyledAttributes(r111, new int[]{R.attr.expandActivityOverflowButtonDrawable, R.attr.initialActivityCount}, r112, 0);
        ViewCompat.saveAttributeDataForStyleable(this, r110, new int[]{R.attr.expandActivityOverflowButtonDrawable, R.attr.initialActivityCount}, r111, r100, r112, 0);
        this.mInitialActivityCount = r100.getInt(1, 4);
        Drawable r113 = r100.getDrawable(0);
        r100.recycle();
        LayoutInflater.from(getContext()).inflate(R.layout.abc_activity_chooser_view, this, true);
        Callbacks r114 = new Callbacks(this);
        this.mCallbacks = r114;
        View r101 = findViewById(R.id.activity_chooser_view_content);
        this.mActivityChooserContent = r101;
        this.mActivityChooserContentBackground = r101.getBackground();
        FrameLayout r102 = (FrameLayout) findViewById(R.id.default_activity_button);
        this.mDefaultActivityButton = r102;
        r102.setOnClickListener(r114);
        r102.setOnLongClickListener(r114);
        this.mDefaultActivityButtonImage = (ImageView) r102.findViewById(R.id.image);
        final FrameLayout r103 = (FrameLayout) findViewById(R.id.expand_activities_button);
        r103.setOnClickListener(r114);
        r103.setAccessibilityDelegate(new AnonymousClass3(this));
        r103.setOnTouchListener(new AnonymousClass4(this, r103));
        this.mExpandActivityOverflowButton = r103;
        ImageView r115 = (ImageView) r103.findViewById(R.id.image);
        this.mExpandActivityOverflowButtonImage = r115;
        r115.setImageDrawable(r113);
        ActivityChooserViewAdapter r116 = new ActivityChooserViewAdapter(this);
        this.mAdapter = r116;
        r116.registerDataSetObserver(new AnonymousClass5(this));
        Resources r117 = r110.getResources();
        this.mListPopupMaxWidth = Math.max(INVOKEVIRTUAL_androidx_appcompat_widget_ActivityChooserView_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(r117).widthPixels / 2, r117.getDimensionPixelSize(R.dimen.abc_config_prefDialogWidth));
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        this.mActivityChooserContent.layout(0, 0, r103 - r101, r104 - r102);
        if (isShowingPopup() == true) goto L6;
        dismissPopup();
        return;
    }
}
