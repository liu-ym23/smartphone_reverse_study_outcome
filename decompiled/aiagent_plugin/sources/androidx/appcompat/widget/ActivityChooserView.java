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
import androidx.core.view.ViewCompat;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.plugin.R;
import com.obric.capabilitykit.common.UiType;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class ActivityChooserView extends ViewGroup {
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
    androidx.core.view.a mProvider;

    private class ActivityChooserViewAdapter extends BaseAdapter {
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
        public long getItemId(int r1) {
            return r1;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getViewTypeCount() {
            return 3;
        }

        ActivityChooserViewAdapter(ActivityChooserView r1) {
            this.this$0 = r1;
            this.mMaxActivityCount = 4;
        }

        public void setDataModel(ActivityChooserModel r3) {
            ActivityChooserModel r0 = this.this$0.mAdapter.getDataModel();
            if (r0 != null) goto L5;
        L7:
            this.mDataModel = r3;
            if (r3 != null) goto L10;
        L12:
            notifyDataSetChanged();
            return;
        L10:
            if (this.this$0.isShown() == false) goto L12;
            r3.registerObserver(this.this$0.mModelDataSetObserver);
            goto L12
        L5:
            if (this.this$0.isShown() == false) goto L7;
            r0.unregisterObserver(this.this$0.mModelDataSetObserver);
            goto L7
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getItemViewType(int r2) {
            if (this.mShowFooterView == true) goto L5;
            return 0;
        L5:
            if (r2 != (getCount() - 1)) goto L9;
            return 1;
        L9:
            return 0;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            int r0 = this.mDataModel.getActivityCount();
            if (this.mShowDefaultActivity == false) goto L5;
        L7:
            int r1 = Math.min(r0, this.mMaxActivityCount);
            if (this.mShowFooterView == true) goto L10;
            return r1;
        L10:
            return r1 + 1;
        L5:
            if (this.mDataModel.getDefaultActivity() == null) goto L7;
            r0 = r0 - 1;
            goto L7
        }

        @Override // android.widget.Adapter
        public Object getItem(int r2) {
            int r0 = getItemViewType(r2);
            if (r0 == 0) goto L11;
            if (r0 != 1) goto L9;
            return null;
        L9:
            throw new IllegalArgumentException();
        L11:
            if (this.mShowDefaultActivity == true) goto L16;
            if (this.mDataModel.getDefaultActivity() == null) goto L16;
            r2 = r2 + 1;
        L16:
            return this.mDataModel.getActivity(r2);
        }

        @Override // android.widget.Adapter
        public View getView(int r11, View r12, ViewGroup r13) {
            int r0 = getItemViewType(r11);
            if (r0 == 0) goto L12;
            if (r0 != 1) goto L11;
            if (r12 != null) goto L7;
        L8:
            View r14 = ZeusTransformUtils.inflate(LayoutInflater.from((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.this$0.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")), ZeusTransformUtils.mapRes(R.layout.abc_activity_chooser_view_list_item, "layout", "abc_activity_chooser_view_list_item"), r13, false, "com.obric.aiagent.plugin");
            r14.setId(1);
            ((TextView) ZeusTransformUtils.preCheckCast(r14.findViewById(ZeusTransformUtils.mapRes(R.id.title, DbHelper.COL_ID, DBDefinition.TITLE)), TextView.class, "com.obric.aiagent.plugin")).setText(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.this$0.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.abc_activity_chooser_view_see_all, WsChannelMultiProcessSharedProvider.STRING_TYPE, "abc_activity_chooser_view_see_all")));
            return r14;
        L7:
            if (r12.getId() != 1) goto L8;
            return r12;
        L11:
            throw new IllegalArgumentException();
        L12:
            if (r12 != null) goto L14;
        L15:
            r12 = ZeusTransformUtils.inflate(LayoutInflater.from((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.this$0.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")), ZeusTransformUtils.mapRes(R.layout.abc_activity_chooser_view_list_item, "layout", "abc_activity_chooser_view_list_item"), r13, false, "com.obric.aiagent.plugin");
        L16:
            PackageManager r15 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.this$0.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getPackageManager();
            ImageView r1 = (ImageView) ZeusTransformUtils.preCheckCast(r12.findViewById(ZeusTransformUtils.mapRes(R.id.icon, DbHelper.COL_ID, "icon")), ImageView.class, "com.obric.aiagent.plugin");
            ResolveInfo r2 = (ResolveInfo) ZeusTransformUtils.preCheckCast(getItem(r11), ResolveInfo.class, "com.obric.aiagent.plugin");
            r1.setImageDrawable(r2.loadIcon(r15));
            ((TextView) ZeusTransformUtils.preCheckCast(r12.findViewById(ZeusTransformUtils.mapRes(R.id.title, DbHelper.COL_ID, DBDefinition.TITLE)), TextView.class, "com.obric.aiagent.plugin")).setText(r2.loadLabel(r15));
            if (this.mShowDefaultActivity == false) goto L22;
            if (r11 != 0) goto L22;
            if (this.mHighlightDefaultActivity == false) goto L22;
            r12.setActivated(true);
        L23:
            return r12;
        L22:
            r12.setActivated(false);
            goto L23
        L14:
            if (r12.getId() == ZeusTransformUtils.mapRes(R.id.list_item, DbHelper.COL_ID, "list_item")) goto L16;
            goto L15
        }

        public int measureContentWidth() {
            int r0 = this.mMaxActivityCount;
            this.mMaxActivityCount = Integer.MAX_VALUE;
            int r1 = 0;
            int r2 = View.MeasureSpec.makeMeasureSpec(0, 0);
            int r3 = View.MeasureSpec.makeMeasureSpec(0, 0);
            int r4 = getCount();
            int r6 = 0;
            View r7 = null;
        L3:
            if (r1 >= r4) goto L5;
            r7 = getView(r1, r7, null);
            r7.measure(r2, r3);
            r6 = Math.max(r6, r7.getMeasuredWidth());
            r1 = r1 + 1;
            goto L3
        L5:
            this.mMaxActivityCount = r0;
            return r6;
        }

        public void setMaxActivityCount(int r2) {
            if (this.mMaxActivityCount == r2) goto L6;
            this.mMaxActivityCount = r2;
            notifyDataSetChanged();
            return;
        }

        public ResolveInfo getDefaultActivity() {
            return this.mDataModel.getDefaultActivity();
        }

        public void setShowFooterView(boolean r2) {
            if (this.mShowFooterView == r2) goto L6;
            this.mShowFooterView = r2;
            notifyDataSetChanged();
            return;
        }

        public int getActivityCount() {
            return this.mDataModel.getActivityCount();
        }

        public int getHistorySize() {
            return this.mDataModel.getHistorySize();
        }

        public ActivityChooserModel getDataModel() {
            return this.mDataModel;
        }

        public void setShowDefaultActivity(boolean r2, boolean r3) {
            if (this.mShowDefaultActivity == r2) goto L5;
        L6:
            this.mShowDefaultActivity = r2;
            this.mHighlightDefaultActivity = r3;
            notifyDataSetChanged();
            return;
        L5:
            if (this.mHighlightDefaultActivity != r3) goto L6;
        }

        public boolean getShowDefaultActivity() {
            return this.mShowDefaultActivity;
        }
    }

    private class Callbacks implements View.OnClickListener, View.OnLongClickListener, AdapterView.OnItemClickListener, PopupWindow.OnDismissListener {
        final /* synthetic */ ActivityChooserView this$0;

        Callbacks(ActivityChooserView r1) {
            this.this$0 = r1;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> r1, View r2, int r3, long r4) {
            int r5 = ((ActivityChooserViewAdapter) ZeusTransformUtils.preCheckCast(r1.getAdapter(), ActivityChooserViewAdapter.class, "com.obric.aiagent.plugin")).getItemViewType(r3);
            if (r5 != 0) goto L5;
            this.this$0.dismissPopup();
            if (this.this$0.mIsSelectingDefaultActivity == false) goto L14;
            if (r3 <= 0) goto L22;
            this.this$0.mAdapter.getDataModel().setDefaultActivity(r3);
            return;
        L22:
            return;
        L14:
            if (this.this$0.mAdapter.getShowDefaultActivity() == true) goto L17;
            r3 = r3 + 1;
        L17:
            Intent r6 = this.this$0.mAdapter.getDataModel().chooseActivity(r3);
            if (r6 == null) goto L24;
            r6.addFlags(UiType.FLAG_WIFI_QRCODE_CARD);
            ZeusTransformUtils.startActivity((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.this$0.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r6, "com.obric.aiagent.plugin");
            return;
        L24:
            return;
        L5:
            if (r5 != 1) goto L8;
            this.this$0.showPopupUnchecked(Integer.MAX_VALUE);
            return;
        L8:
            throw new IllegalArgumentException();
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View r3) {
            if (r3 != this.this$0.mDefaultActivityButton) goto L8;
            this.this$0.dismissPopup();
            ResolveInfo r4 = this.this$0.mAdapter.getDefaultActivity();
            int r5 = this.this$0.mAdapter.getDataModel().getActivityIndex(r4);
            Intent r6 = this.this$0.mAdapter.getDataModel().chooseActivity(r5);
            if (r6 == null) goto L13;
            r6.addFlags(UiType.FLAG_WIFI_QRCODE_CARD);
            ZeusTransformUtils.startActivity((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.this$0.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r6, "com.obric.aiagent.plugin");
            return;
        L13:
            return;
        L8:
            if (r3 != this.this$0.mExpandActivityOverflowButton) goto L12;
            this.this$0.mIsSelectingDefaultActivity = false;
            ActivityChooserView r2 = this.this$0;
            r2.showPopupUnchecked(r2.mInitialActivityCount);
            return;
        L12:
            throw new IllegalArgumentException();
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View r2) {
            if (r2 != this.this$0.mDefaultActivityButton) goto L9;
            if (this.this$0.mAdapter.getCount() <= 0) goto L7;
            this.this$0.mIsSelectingDefaultActivity = true;
            ActivityChooserView r1 = this.this$0;
            r1.showPopupUnchecked(r1.mInitialActivityCount);
        L7:
            return true;
        L9:
            throw new IllegalArgumentException();
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            notifyOnDismissListener();
            if (this.this$0.mProvider == null) goto L6;
            this.this$0.mProvider.subUiVisibilityChanged(false);
            return;
        }

        private void notifyOnDismissListener() {
            if (this.this$0.mOnDismissListener == null) goto L6;
            this.this$0.mOnDismissListener.onDismiss();
            return;
        }
    }

    public static class InnerLayout extends LinearLayout {
        private static final int[] TINT_ATTRS = null;

        static {
            TINT_ATTRS = new int[]{android.R.attr.background};
        }

        public InnerLayout(Context r3, AttributeSet r4) {
            Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
            AttributeSet r6 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin");
            super(r5, r6);
            y r7 = y.a(r5, r6, TINT_ATTRS);
            setBackgroundDrawable(r7.a(0));
            r7.b();
        }
    }

    public ActivityChooserView(Context r3) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), null);
    }

    public ActivityChooserView(Context r3, AttributeSet r4) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin"), 0);
    }

    public ActivityChooserView(Context r10, AttributeSet r11, int r12) {
        Context r13 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r5 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r11, AttributeSet.class, "com.obric.aiagent.plugin");
        super(r13, r5, r12);
        this.mModelDataSetObserver = new AnonymousClass1(this);
        this.mOnGlobalLayoutListener = new AnonymousClass2(this);
        this.mInitialActivityCount = 4;
        TypedArray r0 = r13.obtainStyledAttributes(r5, R.styleable.ActivityChooserView, r12, 0);
        ViewCompat.a(this, r13, R.styleable.ActivityChooserView, r5, r0, r12, 0);
        this.mInitialActivityCount = r0.getInt(ZeusTransformUtils.mapRes(R.styleable.ActivityChooserView_initialActivityCount, "styleable", "ActivityChooserView_initialActivityCount"), 4);
        Drawable r14 = r0.getDrawable(ZeusTransformUtils.mapRes(R.styleable.ActivityChooserView_expandActivityOverflowButtonDrawable, "styleable", "ActivityChooserView_expandActivityOverflowButtonDrawable"));
        r0.recycle();
        ZeusTransformUtils.inflate(LayoutInflater.from((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")), ZeusTransformUtils.mapRes(R.layout.abc_activity_chooser_view, "layout", "abc_activity_chooser_view"), this, true, "com.obric.aiagent.plugin");
        Callbacks r15 = new Callbacks(this);
        this.mCallbacks = r15;
        View r1 = findViewById(ZeusTransformUtils.mapRes(R.id.activity_chooser_view_content, DbHelper.COL_ID, "activity_chooser_view_content"));
        this.mActivityChooserContent = r1;
        this.mActivityChooserContentBackground = r1.getBackground();
        FrameLayout r2 = (FrameLayout) ZeusTransformUtils.preCheckCast(findViewById(ZeusTransformUtils.mapRes(R.id.default_activity_button, DbHelper.COL_ID, "default_activity_button")), FrameLayout.class, "com.obric.aiagent.plugin");
        this.mDefaultActivityButton = r2;
        r2.setOnClickListener(r15);
        r2.setOnLongClickListener(r15);
        this.mDefaultActivityButtonImage = (ImageView) ZeusTransformUtils.preCheckCast(r2.findViewById(ZeusTransformUtils.mapRes(R.id.image, DbHelper.COL_ID, "image")), ImageView.class, "com.obric.aiagent.plugin");
        final FrameLayout r3 = (FrameLayout) ZeusTransformUtils.preCheckCast(findViewById(ZeusTransformUtils.mapRes(R.id.expand_activities_button, DbHelper.COL_ID, "expand_activities_button")), FrameLayout.class, "com.obric.aiagent.plugin");
        r3.setOnClickListener(r15);
        r3.setAccessibilityDelegate(new AnonymousClass3(this));
        r3.setOnTouchListener(new AnonymousClass4(this, r3));
        this.mExpandActivityOverflowButton = r3;
        ImageView r16 = (ImageView) ZeusTransformUtils.preCheckCast(r3.findViewById(ZeusTransformUtils.mapRes(R.id.image, DbHelper.COL_ID, "image")), ImageView.class, "com.obric.aiagent.plugin");
        this.mExpandActivityOverflowButtonImage = r16;
        r16.setImageDrawable(r14);
        ActivityChooserViewAdapter r17 = new ActivityChooserViewAdapter(this);
        this.mAdapter = r17;
        r17.registerDataSetObserver(new AnonymousClass5(this));
        Resources r18 = ZeusTransformUtils.getResources(r13, "com.obric.aiagent.plugin");
        this.mListPopupMaxWidth = Math.max(r18.getDisplayMetrics().widthPixels / 2, r18.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.abc_config_prefDialogWidth, "dimen", "abc_config_prefDialogWidth")));
    }

    public void setActivityChooserModel(ActivityChooserModel r2) {
        this.mAdapter.setDataModel(r2);
        if (isShowingPopup() == false) goto L6;
        dismissPopup();
        showPopup();
        return;
    }

    public void setExpandActivityOverflowButtonDrawable(Drawable r1) {
        this.mExpandActivityOverflowButtonImage.setImageDrawable(r1);
    }

    public void setExpandActivityOverflowButtonContentDescription(int r4) {
        String r5 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(r4);
        this.mExpandActivityOverflowButtonImage.setContentDescription(r5);
    }

    public void setProvider(androidx.core.view.a r1) {
        this.mProvider = r1;
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

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6, types: [boolean, int] */
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
    void showPopupUnchecked(int r6) {
        if (this.mAdapter.getDataModel() == null) goto L28;
        getViewTreeObserver().addOnGlobalLayoutListener(this.mOnGlobalLayoutListener);
        if (this.mDefaultActivityButton.getVisibility() != 0) goto L7;
        ?? r0 = 1;
    L8:
        int r3 = this.mAdapter.getActivityCount();
        if (r6 != Integer.MAX_VALUE) goto L11;
    L13:
        this.mAdapter.setShowFooterView(false);
        this.mAdapter.setMaxActivityCount(r6);
    L14:
        ListPopupWindow r7 = getListPopupWindow();
        if (r7.isShowing() == false) goto L17;
        return;
    L17:
        if (this.mIsSelectingDefaultActivity == true) goto L21;
        if (r0 == 0) goto L21;
        this.mAdapter.setShowDefaultActivity(false, false);
    L22:
        r7.e(Math.min(this.mAdapter.measureContentWidth(), this.mListPopupMaxWidth));
        r7.show();
        androidx.core.view.a r1 = this.mProvider;
        if (r1 == null) goto L25;
        r1.subUiVisibilityChanged(true);
    L25:
        r7.getListView().setContentDescription(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.abc_activitychooserview_choose_application, WsChannelMultiProcessSharedProvider.STRING_TYPE, "abc_activitychooserview_choose_application")));
        r7.getListView().setSelector(new ColorDrawable(0));
        return;
    L21:
        this.mAdapter.setShowDefaultActivity(true, r0);
        goto L22
    L11:
        if (r3 <= (r6 + r0)) goto L13;
        this.mAdapter.setShowFooterView(true);
        this.mAdapter.setMaxActivityCount(r6 - 1);
        goto L14
    L7:
        r0 = 0;
        goto L8
    L28:
        throw new IllegalStateException("No data model. Did you call #setDataModel?");
    }

    public boolean dismissPopup() {
        if (isShowingPopup() == false) goto L9;
        getListPopupWindow().dismiss();
        ViewTreeObserver r0 = getViewTreeObserver();
        if (r0.isAlive() == false) goto L10;
        r0.removeGlobalOnLayoutListener(this.mOnGlobalLayoutListener);
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
        ActivityChooserModel r0 = this.mAdapter.getDataModel();
        if (r0 == null) goto L5;
        r0.registerObserver(this.mModelDataSetObserver);
    L5:
        this.mIsAttachedToWindow = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ActivityChooserModel r0 = this.mAdapter.getDataModel();
        if (r0 == null) goto L5;
        r0.unregisterObserver(this.mModelDataSetObserver);
    L5:
        ViewTreeObserver r1 = getViewTreeObserver();
        if (r1.isAlive() == false) goto L9;
        r1.removeGlobalOnLayoutListener(this.mOnGlobalLayoutListener);
    L9:
        if (isShowingPopup() == false) goto L11;
        dismissPopup();
    L11:
        this.mIsAttachedToWindow = false;
    }

    @Override // android.view.View
    public void onMeasure(int r3, int r4) {
        View r0 = this.mActivityChooserContent;
        if (this.mDefaultActivityButton.getVisibility() == 0) goto L5;
        r4 = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(r4), 1073741824);
    L5:
        measureChild(r0, r3, r4);
        setMeasuredDimension(r0.getMeasuredWidth(), r0.getMeasuredHeight());
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        this.mActivityChooserContent.layout(0, 0, r4 - r2, r5 - r3);
        if (isShowingPopup() == true) goto L6;
        dismissPopup();
        return;
    }

    public ActivityChooserModel getDataModel() {
        return this.mAdapter.getDataModel();
    }

    public void setOnDismissListener(PopupWindow.OnDismissListener r3) {
        this.mOnDismissListener = (PopupWindow.OnDismissListener) ZeusTransformUtils.wrapperContextForParams(r3, PopupWindow.OnDismissListener.class, "com.obric.aiagent.plugin");
    }

    public void setInitialActivityCount(int r1) {
        this.mInitialActivityCount = r1;
    }

    public void setDefaultActionButtonContentDescription(int r1) {
        this.mDefaultActionButtonContentDescription = r1;
    }

    ListPopupWindow getListPopupWindow() {
        if (this.mListPopupWindow != null) goto L6;
        ListPopupWindow r0 = new ListPopupWindow((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
        this.mListPopupWindow = r0;
        r0.setAdapter(this.mAdapter);
        this.mListPopupWindow.b(this);
        this.mListPopupWindow.a(true);
        this.mListPopupWindow.a(this.mCallbacks);
        this.mListPopupWindow.a(this.mCallbacks);
    L6:
        return this.mListPopupWindow;
    }

    void updateAppearance() {
        if (this.mAdapter.getCount() <= 0) goto L5;
        this.mExpandActivityOverflowButton.setEnabled(true);
    L6:
        int r0 = this.mAdapter.getActivityCount();
        int r3 = this.mAdapter.getHistorySize();
        if (r0 == 1) goto L12;
        if (r0 <= 1) goto L11;
        if (r3 > 0) goto L12;
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
        ResolveInfo r1 = this.mAdapter.getDefaultActivity();
        PackageManager r4 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getPackageManager();
        this.mDefaultActivityButtonImage.setImageDrawable(r1.loadIcon(r4));
        if (this.mDefaultActionButtonContentDescription == 0) goto L16;
        CharSequence r2 = r1.loadLabel(r4);
        this.mDefaultActivityButton.setContentDescription(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(this.mDefaultActionButtonContentDescription, new Object[]{r2}));
        goto L16
    L5:
        this.mExpandActivityOverflowButton.setEnabled(false);
        goto L6
    }
}
