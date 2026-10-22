package androidx.appcompat.app;

import android.R;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.NestedScrollView;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
class AlertController {
    ListAdapter mAdapter;
    private int mAlertDialogLayout;
    private final View.OnClickListener mButtonHandler;
    private final int mButtonIconDimen;
    Button mButtonNegative;
    private Drawable mButtonNegativeIcon;
    Message mButtonNegativeMessage;
    private CharSequence mButtonNegativeText;
    Button mButtonNeutral;
    private Drawable mButtonNeutralIcon;
    Message mButtonNeutralMessage;
    private CharSequence mButtonNeutralText;
    private int mButtonPanelLayoutHint;
    private int mButtonPanelSideLayout;
    Button mButtonPositive;
    private Drawable mButtonPositiveIcon;
    Message mButtonPositiveMessage;
    private CharSequence mButtonPositiveText;
    int mCheckedItem;
    private final Context mContext;
    private View mCustomTitleView;
    final AppCompatDialog mDialog;
    Handler mHandler;
    private Drawable mIcon;
    private int mIconId;
    private ImageView mIconView;
    int mListItemLayout;
    int mListLayout;
    ListView mListView;
    private CharSequence mMessage;
    private TextView mMessageView;
    int mMultiChoiceItemLayout;
    NestedScrollView mScrollView;
    private boolean mShowTitle;
    int mSingleChoiceItemLayout;
    private CharSequence mTitle;
    private TextView mTitleView;
    private View mView;
    private int mViewLayoutResId;
    private int mViewSpacingBottom;
    private int mViewSpacingLeft;
    private int mViewSpacingRight;
    private boolean mViewSpacingSpecified;
    private int mViewSpacingTop;
    private final Window mWindow;

    public static class AlertParams {
        public ListAdapter mAdapter;
        public boolean mCancelable;
        public int mCheckedItem;
        public boolean[] mCheckedItems;
        public final Context mContext;
        public Cursor mCursor;
        public View mCustomTitleView;
        public boolean mForceInverseBackground;
        public Drawable mIcon;
        public int mIconAttrId;
        public int mIconId;
        public final LayoutInflater mInflater;
        public String mIsCheckedColumn;
        public boolean mIsMultiChoice;
        public boolean mIsSingleChoice;
        public CharSequence[] mItems;
        public String mLabelColumn;
        public CharSequence mMessage;
        public Drawable mNegativeButtonIcon;
        public DialogInterface.OnClickListener mNegativeButtonListener;
        public CharSequence mNegativeButtonText;
        public Drawable mNeutralButtonIcon;
        public DialogInterface.OnClickListener mNeutralButtonListener;
        public CharSequence mNeutralButtonText;
        public DialogInterface.OnCancelListener mOnCancelListener;
        public DialogInterface.OnMultiChoiceClickListener mOnCheckboxClickListener;
        public DialogInterface.OnClickListener mOnClickListener;
        public DialogInterface.OnDismissListener mOnDismissListener;
        public AdapterView.OnItemSelectedListener mOnItemSelectedListener;
        public DialogInterface.OnKeyListener mOnKeyListener;
        public OnPrepareListViewListener mOnPrepareListViewListener;
        public Drawable mPositiveButtonIcon;
        public DialogInterface.OnClickListener mPositiveButtonListener;
        public CharSequence mPositiveButtonText;
        public boolean mRecycleOnMeasure;
        public CharSequence mTitle;
        public View mView;
        public int mViewLayoutResId;
        public int mViewSpacingBottom;
        public int mViewSpacingLeft;
        public int mViewSpacingRight;
        public boolean mViewSpacingSpecified;
        public int mViewSpacingTop;

        public interface OnPrepareListViewListener {
            void onPrepareListView(ListView r100);
        }

        public AlertParams(Context r100) {
            this.mIconId = 0;
            this.mIconAttrId = 0;
            this.mViewSpacingSpecified = false;
            this.mCheckedItem = -1;
            this.mRecycleOnMeasure = true;
            this.mContext = r100;
            this.mCancelable = true;
            this.mInflater = (LayoutInflater) r100.getSystemService("layout_inflater");
        }

        private void createListView(final AlertController r110) {
            final RecycleListView r100 = (RecycleListView) this.mInflater.inflate(r110.mListLayout, null);
            if (this.mIsMultiChoice == false) goto L9;
            if (this.mCursor != null) goto L7;
            final Context r101 = this.mContext;
            final int r102 = r110.mMultiChoiceItemLayout;
            final int r103 = R.id.text1;
            final CharSequence[] r104 = this.mItems;
            ListAdapter r105 = new AnonymousClass1(this, r101, r102, r103, r104, r100);
        L19:
            OnPrepareListViewListener r106 = this.mOnPrepareListViewListener;
            if (r106 == null) goto L22;
            r106.onPrepareListView(r100);
        L22:
            r110.mAdapter = r105;
            r110.mCheckedItem = this.mCheckedItem;
            if (this.mOnClickListener == null) goto L26;
            r100.setOnItemClickListener(new AnonymousClass3(this, r110));
        L28:
            AdapterView.OnItemSelectedListener r107 = this.mOnItemSelectedListener;
            if (r107 == null) goto L32;
            r100.setOnItemSelectedListener(r107);
        L32:
            if (this.mIsSingleChoice == false) goto L35;
            r100.setChoiceMode(1);
        L37:
            r110.mListView = r100;
            return;
        L35:
            if (this.mIsMultiChoice == false) goto L37;
            r100.setChoiceMode(2);
            goto L37
        L26:
            if (this.mOnCheckboxClickListener == null) goto L28;
            r100.setOnItemClickListener(new AnonymousClass4(this, r100, r110));
            goto L28
        L7:
            final Context r108 = this.mContext;
            final Cursor r109 = this.mCursor;
            final boolean r111 = false;
            r105 = new AnonymousClass2(this, r108, r109, r111, r100, r110);
            goto L19
        L9:
            if (this.mIsSingleChoice == false) goto L11;
            int r112 = r110.mSingleChoiceItemLayout;
        L12:
            int r113 = r112;
            if (this.mCursor == null) goto L15;
            r105 = new SimpleCursorAdapter(this.mContext, r113, this.mCursor, new String[]{this.mLabelColumn}, new int[]{R.id.text1});
            goto L19
        L15:
            r105 = this.mAdapter;
            if (r105 != null) goto L19;
            r105 = new CheckedItemAdapter(this.mContext, r113, R.id.text1, this.mItems);
            goto L19
        L11:
            r112 = r110.mListItemLayout;
            goto L12
        }

        public void apply(AlertController r110) {
            View r100 = this.mCustomTitleView;
            if (r100 == null) goto L5;
            r110.setCustomTitle(r100);
        L17:
            CharSequence r101 = this.mMessage;
            if (r101 == null) goto L20;
            r110.setMessage(r101);
        L20:
            CharSequence r102 = this.mPositiveButtonText;
            if (r102 == null) goto L23;
        L24:
            r110.setButton(-1, r102, this.mPositiveButtonListener, null, this.mPositiveButtonIcon);
        L25:
            CharSequence r103 = this.mNegativeButtonText;
            if (r103 == null) goto L28;
        L29:
            r110.setButton(-2, r103, this.mNegativeButtonListener, null, this.mNegativeButtonIcon);
        L30:
            CharSequence r104 = this.mNeutralButtonText;
            if (r104 == null) goto L33;
        L34:
            r110.setButton(-3, r104, this.mNeutralButtonListener, null, this.mNeutralButtonIcon);
        L36:
            if (this.mItems == null) goto L38;
        L41:
            createListView(r110);
        L42:
            View r105 = this.mView;
            if (r105 != null) goto L45;
            int r106 = this.mViewLayoutResId;
            if (r106 == 0) goto L54;
            r110.setView(r106);
            return;
        L54:
            return;
        L45:
            if (this.mViewSpacingSpecified == false) goto L47;
            r110.setView(r105, this.mViewSpacingLeft, this.mViewSpacingTop, this.mViewSpacingRight, this.mViewSpacingBottom);
            return;
        L47:
            r110.setView(r105);
            return;
        L38:
            if (this.mCursor != null) goto L41;
            if (this.mAdapter == null) goto L42;
        L33:
            if (this.mNeutralButtonIcon == null) goto L36;
        L28:
            if (this.mNegativeButtonIcon == null) goto L30;
        L23:
            if (this.mPositiveButtonIcon == null) goto L25;
        L5:
            CharSequence r107 = this.mTitle;
            if (r107 == null) goto L8;
            r110.setTitle(r107);
        L8:
            Drawable r108 = this.mIcon;
            if (r108 == null) goto L11;
            r110.setIcon(r108);
        L11:
            int r109 = this.mIconId;
            if (r109 == 0) goto L14;
            r110.setIcon(r109);
        L14:
            int r111 = this.mIconAttrId;
            if (r111 == 0) goto L17;
            r110.setIcon(r110.getIconAttributeResId(r111));
            goto L17
        }
    }

    public static final class ButtonHandler extends Handler {
        private static final int MSG_DISMISS_DIALOG = 1;
        private WeakReference<DialogInterface> mDialog;

        public ButtonHandler(DialogInterface r100) {
            this.mDialog = new WeakReference(r100);
        }

        @Override // android.os.Handler
        public void handleMessage(Message r100) {
            int r101 = r100.what;
            if (r101 != (-3)) goto L5;
        L12:
            ((DialogInterface.OnClickListener) r100.obj).onClick(this.mDialog.get(), r100.what);
            return;
        L5:
            if (r101 == (-2)) goto L12;
            if (r101 == (-1)) goto L12;
            if (r101 != 1) goto L15;
            ((DialogInterface) r100.obj).dismiss();
            return;
        }
    }

    public static class CheckedItemAdapter extends ArrayAdapter<CharSequence> {
        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public long getItemId(int r100) {
            return r100;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public boolean hasStableIds() {
            return true;
        }

        public CheckedItemAdapter(Context r100, int r101, int r102, CharSequence[] r103) {
            super(r100, r101, r102, r103);
        }
    }

    public static class RecycleListView extends ListView {
        private final int mPaddingBottomNoButtons;
        private final int mPaddingTopNoTitle;

        public RecycleListView(Context r100) {
            this(r100, null);
        }

        public RecycleListView(Context r100, AttributeSet r101) {
            super(r100, r101);
            TypedArray r102 = r100.obtainStyledAttributes(r101, new int[]{com.larus.nova.R.attr.paddingBottomNoButtons, com.larus.nova.R.attr.paddingTopNoTitle});
            this.mPaddingBottomNoButtons = r102.getDimensionPixelOffset(0, -1);
            this.mPaddingTopNoTitle = r102.getDimensionPixelOffset(1, -1);
        }

        public void setHasDecor(boolean r100, boolean r101) {
            if (r101 == false) goto L4;
            if (r100 == false) goto L4;
            return;
        L4:
            int r102 = getPaddingLeft();
            if (r100 == false) goto L7;
            int r103 = getPaddingTop();
        L8:
            int r104 = getPaddingRight();
            if (r101 == false) goto L11;
            int r105 = getPaddingBottom();
        L12:
            setPadding(r102, r103, r104, r105);
            return;
        L11:
            r105 = this.mPaddingBottomNoButtons;
            goto L12
        L7:
            r103 = this.mPaddingTopNoTitle;
            goto L8
        }
    }

    private int selectContentView() {
        int r100 = this.mButtonPanelSideLayout;
        if (r100 != 0) goto L7;
        return this.mAlertDialogLayout;
    L7:
        if (this.mButtonPanelLayoutHint != 1) goto L10;
        return r100;
    L10:
        return this.mAlertDialogLayout;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void setupView() {
        View r100 = this.mWindow.findViewById(com.larus.nova.R.id.parentPanel);
        View r101 = r100.findViewById(com.larus.nova.R.id.topPanel);
        View r102 = r100.findViewById(com.larus.nova.R.id.contentPanel);
        View r103 = r100.findViewById(com.larus.nova.R.id.buttonPanel);
        ViewGroup r104 = (ViewGroup) r100.findViewById(com.larus.nova.R.id.customPanel);
        setupCustomContent(r104);
        View r105 = r104.findViewById(com.larus.nova.R.id.topPanel);
        View r106 = r104.findViewById(com.larus.nova.R.id.contentPanel);
        View r107 = r104.findViewById(com.larus.nova.R.id.buttonPanel);
        ViewGroup r108 = resolvePanel(r105, r101);
        ViewGroup r109 = resolvePanel(r106, r102);
        ViewGroup r110 = resolvePanel(r107, r103);
        setupContent(r109);
        setupButtons(r110);
        setupTitle(r108);
        int r111 = 0;
        if (r104.getVisibility() == 8) goto L5;
        boolean r112 = true;
    L6:
        if (r108 != null) goto L8;
    L10:
        boolean r113 = 0;
    L11:
        if (r110 != null) goto L13;
    L15:
        boolean r114 = false;
    L16:
        if (r114 == true) goto L21;
        if (r109 == null) goto L21;
        View r115 = r109.findViewById(com.larus.nova.R.id.textSpacerNoButtons);
        if (r115 == null) goto L21;
        r115.setVisibility(0);
    L21:
        if (r113 == 0) goto L34;
        NestedScrollView r116 = this.mScrollView;
        if (r116 == null) goto L26;
        r116.setClipToPadding(true);
    L26:
        if (this.mMessage == null) goto L28;
    L31:
        View r117 = r108.findViewById(com.larus.nova.R.id.titleDividerNoCustom);
    L32:
        if (r117 == null) goto L38;
        r117.setVisibility(0);
    L38:
        ListView r118 = this.mListView;
        if ((r118 instanceof RecycleListView) == false) goto L41;
        ((RecycleListView) r118).setHasDecor(r113, r114);
    L41:
        if (r112 == true) goto L50;
        View r119 = this.mListView;
        if (r119 != null) goto L46;
        r119 = this.mScrollView;
    L46:
        if (r119 == null) goto L50;
        if (r114 == false) goto L49;
        r111 = 2;
    L49:
        setScrollIndicators(r109, r119, r113 | r111, 3);
    L50:
        ListView r120 = this.mListView;
        if (r120 == null) goto L58;
        ListAdapter r121 = this.mAdapter;
        if (r121 == null) goto L59;
        r120.setAdapter(r121);
        int r122 = this.mCheckedItem;
        if (r122 <= (-1)) goto L60;
        r120.setItemChecked(r122, true);
        r120.setSelection(r122);
        return;
    L60:
        return;
    L59:
        return;
    L58:
        return;
    L28:
        if (this.mListView != null) goto L31;
        r117 = null;
        goto L32
    L34:
        if (r109 == null) goto L38;
        View r123 = r109.findViewById(com.larus.nova.R.id.textSpacerNoTitle);
        if (r123 == null) goto L38;
        r123.setVisibility(0);
        goto L38
    L13:
        if (r110.getVisibility() == 8) goto L15;
        r114 = true;
        goto L16
    L8:
        if (r108.getVisibility() == 8) goto L10;
        r113 = 1;
        goto L11
    L5:
        r112 = false;
        goto L6
    }

    public void installContent() {
        int r100 = selectContentView();
        this.mDialog.setContentView(r100);
        setupView();
    }

    public ListView getListView() {
        return this.mListView;
    }

    public static boolean canTextInput(View r100) {
        if (r100.onCheckIsTextEditor() == false) goto L6;
        return true;
    L6:
        if ((r100 instanceof ViewGroup) == true) goto L8;
        return false;
    L8:
        ViewGroup r101 = (ViewGroup) r100;
        int r102 = r101.getChildCount();
    L9:
        if (r102 <= 0) goto L13;
        r102 = r102 - 1;
        if (canTextInput(r101.getChildAt(r102)) == false) goto L9;
        return true;
    L13:
        return false;
    }

    private void centerButton(Button r100) {
        LinearLayout.LayoutParams r101 = (LinearLayout.LayoutParams) r100.getLayoutParams();
        r101.gravity = 1;
        r101.weight = 0.5f;
        r100.setLayoutParams(r101);
    }

    private void setupButtons(ViewGroup r100) {
        Button r101 = (Button) r100.findViewById(R.id.button1);
        this.mButtonPositive = r101;
        r101.setOnClickListener(this.mButtonHandler);
        boolean r102 = true;
        if (TextUtils.isEmpty(this.mButtonPositiveText) == true) goto L5;
    L7:
        this.mButtonPositive.setText(this.mButtonPositiveText);
        Drawable r103 = this.mButtonPositiveIcon;
        if (r103 == null) goto L10;
        int r104 = this.mButtonIconDimen;
        r103.setBounds(0, 0, r104, r104);
        this.mButtonPositive.setCompoundDrawables(this.mButtonPositiveIcon, null, null, null);
    L10:
        this.mButtonPositive.setVisibility(0);
        int r105 = 1;
    L11:
        Button r106 = (Button) r100.findViewById(R.id.button2);
        this.mButtonNegative = r106;
        r106.setOnClickListener(this.mButtonHandler);
        if (TextUtils.isEmpty(this.mButtonNegativeText) == true) goto L14;
    L16:
        this.mButtonNegative.setText(this.mButtonNegativeText);
        Drawable r107 = this.mButtonNegativeIcon;
        if (r107 == null) goto L19;
        int r108 = this.mButtonIconDimen;
        r107.setBounds(0, 0, r108, r108);
        this.mButtonNegative.setCompoundDrawables(this.mButtonNegativeIcon, null, null, null);
    L19:
        this.mButtonNegative.setVisibility(0);
        r105 = r105 | 2;
    L20:
        Button r109 = (Button) r100.findViewById(R.id.button3);
        this.mButtonNeutral = r109;
        r109.setOnClickListener(this.mButtonHandler);
        if (TextUtils.isEmpty(this.mButtonNeutralText) == true) goto L23;
    L25:
        this.mButtonNeutral.setText(this.mButtonNeutralText);
        Drawable r110 = this.mButtonNeutralIcon;
        if (r110 == null) goto L28;
        int r111 = this.mButtonIconDimen;
        r110.setBounds(0, 0, r111, r111);
        this.mButtonNeutral.setCompoundDrawables(this.mButtonNeutralIcon, null, null, null);
    L28:
        this.mButtonNeutral.setVisibility(0);
        r105 = r105 | 4;
    L30:
        if (shouldCenterSingleButton(this.mContext) == false) goto L39;
        if (r105 != 1) goto L34;
        centerButton(this.mButtonPositive);
        goto L39
    L34:
        if (r105 != 2) goto L37;
        centerButton(this.mButtonNegative);
        goto L39
    L37:
        if (r105 != 4) goto L39;
        centerButton(this.mButtonNeutral);
    L39:
        if (r105 != 0) goto L42;
        r102 = false;
    L42:
        if (r102 == true) goto L45;
        r100.setVisibility(8);
        return;
    L45:
        return;
    L23:
        if (this.mButtonNeutralIcon != null) goto L25;
        this.mButtonNeutral.setVisibility(8);
        goto L30
    L14:
        if (this.mButtonNegativeIcon != null) goto L16;
        this.mButtonNegative.setVisibility(8);
        goto L20
    L5:
        if (this.mButtonPositiveIcon != null) goto L7;
        this.mButtonPositive.setVisibility(8);
        r105 = 0;
        goto L11
    }

    private void setupContent(ViewGroup r100) {
        NestedScrollView r101 = (NestedScrollView) this.mWindow.findViewById(com.larus.nova.R.id.scrollView);
        this.mScrollView = r101;
        r101.setFocusable(false);
        this.mScrollView.setNestedScrollingEnabled(false);
        TextView r102 = (TextView) r100.findViewById(R.id.message);
        this.mMessageView = r102;
        if (r102 != null) goto L5;
        return;
    L5:
        CharSequence r103 = this.mMessage;
        if (r103 == null) goto L8;
        r102.setText(r103);
        return;
    L8:
        r102.setVisibility(8);
        this.mScrollView.removeView(this.mMessageView);
        if (this.mListView == null) goto L11;
        ViewGroup r104 = (ViewGroup) this.mScrollView.getParent();
        int r105 = r104.indexOfChild(this.mScrollView);
        r104.removeViewAt(r105);
        r104.addView(this.mListView, r105, new ViewGroup.LayoutParams(-1, -1));
        return;
    L11:
        r100.setVisibility(8);
    }

    private void setupCustomContent(ViewGroup r100) {
        View r101 = this.mView;
        boolean r102 = false;
        if (r101 == null) goto L6;
    L9:
        if (r101 == null) goto L11;
        r102 = true;
    L11:
        if (r102 == true) goto L13;
    L14:
        this.mWindow.setFlags(131072, 131072);
    L15:
        if (r102 == false) goto L22;
        FrameLayout r103 = (FrameLayout) this.mWindow.findViewById(com.larus.nova.R.id.custom);
        r103.addView(r101, new ViewGroup.LayoutParams(-1, -1));
        if (this.mViewSpacingSpecified == false) goto L20;
        r103.setPadding(this.mViewSpacingLeft, this.mViewSpacingTop, this.mViewSpacingRight, this.mViewSpacingBottom);
    L20:
        if (this.mListView == null) goto L24;
        ((LinearLayout.LayoutParams) ((LinearLayoutCompat.LayoutParams) r100.getLayoutParams())).weight = 0.0f;
        return;
    L24:
        return;
    L22:
        r100.setVisibility(8);
        return;
    L13:
        if (canTextInput(r101) == true) goto L15;
    L6:
        if (this.mViewLayoutResId == 0) goto L8;
        r101 = LayoutInflater.from(this.mContext).inflate(this.mViewLayoutResId, r100, false);
        goto L9
    L8:
        r101 = null;
        goto L9
    }

    private void setupTitle(ViewGroup r100) {
        if (this.mCustomTitleView == null) goto L5;
        r100.addView(this.mCustomTitleView, 0, new ViewGroup.LayoutParams(-1, -2));
        this.mWindow.findViewById(com.larus.nova.R.id.title_template).setVisibility(8);
        return;
    L5:
        this.mIconView = (ImageView) this.mWindow.findViewById(R.id.icon);
        if ((!TextUtils.isEmpty(this.mTitle)) == true) goto L8;
    L16:
        this.mWindow.findViewById(com.larus.nova.R.id.title_template).setVisibility(8);
        this.mIconView.setVisibility(8);
        r100.setVisibility(8);
        return;
    L8:
        if (this.mShowTitle == false) goto L16;
        TextView r101 = (TextView) this.mWindow.findViewById(com.larus.nova.R.id.alertTitle);
        this.mTitleView = r101;
        r101.setText(this.mTitle);
        int r102 = this.mIconId;
        if (r102 == 0) goto L12;
        this.mIconView.setImageResource(r102);
        return;
    L12:
        Drawable r103 = this.mIcon;
        if (r103 == null) goto L15;
        this.mIconView.setImageDrawable(r103);
        return;
    L15:
        this.mTitleView.setPadding(this.mIconView.getPaddingLeft(), this.mIconView.getPaddingTop(), this.mIconView.getPaddingRight(), this.mIconView.getPaddingBottom());
        this.mIconView.setVisibility(8);
    }

    private static boolean shouldCenterSingleButton(Context r100) {
        TypedValue r101 = new TypedValue();
        r100.getTheme().resolveAttribute(com.larus.nova.R.attr.alertDialogCenterButtons, r101, true);
        if (r101.data != 0) goto L7;
        return false;
    L7:
        return true;
    }

    public Button getButton(int r100) {
        if (r100 == (-3)) goto L15;
        if (r100 == (-2)) goto L13;
        if (r100 == (-1)) goto L11;
        return null;
    L11:
        return this.mButtonPositive;
    L13:
        return this.mButtonNegative;
    L15:
        return this.mButtonNeutral;
    }

    public int getIconAttributeResId(int r100) {
        TypedValue r101 = new TypedValue();
        this.mContext.getTheme().resolveAttribute(r100, r101, true);
        return r101.resourceId;
    }

    public void setButtonPanelLayoutHint(int r100) {
        this.mButtonPanelLayoutHint = r100;
    }

    public void setCustomTitle(View r100) {
        this.mCustomTitleView = r100;
    }

    public void setIcon(int r100) {
        this.mIcon = null;
        this.mIconId = r100;
        ImageView r101 = this.mIconView;
        if (r101 == null) goto L8;
        if (r100 == 0) goto L6;
        r101.setVisibility(0);
        this.mIconView.setImageResource(this.mIconId);
        return;
    L6:
        r101.setVisibility(8);
        return;
    }

    public void setMessage(CharSequence r100) {
        this.mMessage = r100;
        TextView r101 = this.mMessageView;
        if (r101 == null) goto L6;
        r101.setText(r100);
        return;
    }

    public void setTitle(CharSequence r100) {
        this.mTitle = r100;
        TextView r101 = this.mTitleView;
        if (r101 == null) goto L6;
        r101.setText(r100);
        return;
    }

    public void setView(int r100) {
        this.mView = null;
        this.mViewLayoutResId = r100;
        this.mViewSpacingSpecified = false;
    }

    public void setIcon(Drawable r100) {
        this.mIcon = r100;
        this.mIconId = 0;
        ImageView r101 = this.mIconView;
        if (r101 == null) goto L8;
        if (r100 == null) goto L6;
        r101.setVisibility(0);
        this.mIconView.setImageDrawable(r100);
        return;
    L6:
        r101.setVisibility(8);
        return;
    }

    public void setView(View r100) {
        this.mView = r100;
        this.mViewLayoutResId = 0;
        this.mViewSpacingSpecified = false;
    }

    private ViewGroup resolvePanel(View r100, View r101) {
        if (r100 == null) goto L4;
        if (r101 == null) goto L13;
        ViewParent r102 = r101.getParent();
        if ((r102 instanceof ViewGroup) == false) goto L13;
        ((ViewGroup) r102).removeView(r101);
    L13:
        if ((r100 instanceof ViewStub) == false) goto L16;
        r100 = ((ViewStub) r100).inflate();
    L16:
        return (ViewGroup) r100;
    L4:
        if ((r101 instanceof ViewStub) == false) goto L7;
        r101 = ((ViewStub) r101).inflate();
    L7:
        return (ViewGroup) r101;
    }

    public boolean onKeyDown(int r100, KeyEvent r101) {
        NestedScrollView r102 = this.mScrollView;
        if (r102 != null) goto L5;
    L7:
        return false;
    L5:
        if (r102.executeKeyEvent(r101) == false) goto L7;
        return true;
    }

    public boolean onKeyUp(int r100, KeyEvent r101) {
        NestedScrollView r102 = this.mScrollView;
        if (r102 != null) goto L5;
    L7:
        return false;
    L5:
        if (r102.executeKeyEvent(r101) == false) goto L7;
        return true;
    }

    public AlertController(Context r100, AppCompatDialog r101, Window r102) {
        this.mViewSpacingSpecified = false;
        this.mIconId = 0;
        this.mCheckedItem = -1;
        this.mButtonPanelLayoutHint = 0;
        this.mButtonHandler = new AnonymousClass1(this);
        this.mContext = r100;
        this.mDialog = r101;
        this.mWindow = r102;
        this.mHandler = new ButtonHandler(r101);
        TypedArray r103 = r100.obtainStyledAttributes(null, new int[]{R.attr.layout, com.larus.nova.R.attr.buttonIconDimen, com.larus.nova.R.attr.buttonPanelSideLayout, com.larus.nova.R.attr.listItemLayout, com.larus.nova.R.attr.listLayout, com.larus.nova.R.attr.multiChoiceItemLayout, com.larus.nova.R.attr.showTitle, com.larus.nova.R.attr.singleChoiceItemLayout}, com.larus.nova.R.attr.alertDialogStyle, 0);
        this.mAlertDialogLayout = r103.getResourceId(0, 0);
        this.mButtonPanelSideLayout = r103.getResourceId(2, 0);
        this.mListLayout = r103.getResourceId(4, 0);
        this.mMultiChoiceItemLayout = r103.getResourceId(5, 0);
        this.mSingleChoiceItemLayout = r103.getResourceId(7, 0);
        this.mListItemLayout = r103.getResourceId(3, 0);
        this.mShowTitle = r103.getBoolean(6, true);
        this.mButtonIconDimen = r103.getDimensionPixelSize(1, 0);
        r103.recycle();
        r101.supportRequestWindowFeature(1);
    }

    public static void manageScrollIndicators(View r100, View r101, View r102) {
        int r103 = 0;
        if (r101 != null) goto L5;
    L9:
        if (r102 != null) goto L11;
        return;
    L11:
        if (r100.canScrollVertically(1) == true) goto L14;
        r103 = 4;
    L14:
        r102.setVisibility(r103);
        return;
    L5:
        if (r100.canScrollVertically(-1) == false) goto L7;
        int r104 = 0;
    L8:
        r101.setVisibility(r104);
        goto L9
    L7:
        r104 = 4;
        goto L8
    }

    private void setScrollIndicators(ViewGroup r100, View r101, int r102, int r103) {
        final View r104 = this.mWindow.findViewById(com.larus.nova.R.id.scrollIndicatorUp);
        final View r105 = this.mWindow.findViewById(com.larus.nova.R.id.scrollIndicatorDown);
        if (Build.VERSION.SDK_INT < 23) goto L10;
        ViewCompat.setScrollIndicators(r101, r102, r103);
        if (r104 == null) goto L7;
        r100.removeView(r104);
    L7:
        if (r105 == null) goto L31;
        r100.removeView(r105);
        return;
    L31:
        return;
    L10:
        if (r104 != null) goto L12;
    L14:
        if (r105 != null) goto L16;
    L18:
        if (r104 != null) goto L21;
        if (r105 != null) goto L21;
        return;
    L21:
        if (this.mMessage == null) goto L23;
        this.mScrollView.setOnScrollChangeListener(new AnonymousClass2(this, r104, r105));
        this.mScrollView.post(new AnonymousClass3(this, r104, r105));
        return;
    L23:
        ListView r106 = this.mListView;
        if (r106 == null) goto L26;
        r106.setOnScrollListener(new AnonymousClass4(this, r104, r105));
        this.mListView.post(new AnonymousClass5(this, r104, r105));
        return;
    L26:
        if (r104 == null) goto L28;
        r100.removeView(r104);
    L28:
        if (r105 == null) goto L36;
        r100.removeView(r105);
        return;
    L36:
        return;
    L16:
        if ((r102 & 2) != 0) goto L18;
        r100.removeView(r105);
        r105 = null;
        goto L18
    L12:
        if ((r102 & 1) != 0) goto L14;
        r100.removeView(r104);
        r104 = null;
        goto L14
    }

    public void setButton(int r100, CharSequence r101, DialogInterface.OnClickListener r102, Message r103, Drawable r104) {
        if (r103 != null) goto L6;
        if (r102 == null) goto L6;
        r103 = this.mHandler.obtainMessage(r100, r102);
    L6:
        if (r100 != (-3)) goto L8;
        this.mButtonNeutralText = r101;
        this.mButtonNeutralMessage = r103;
        this.mButtonNeutralIcon = r104;
        return;
    L8:
        if (r100 != (-2)) goto L10;
        this.mButtonNegativeText = r101;
        this.mButtonNegativeMessage = r103;
        this.mButtonNegativeIcon = r104;
        return;
    L10:
        if (r100 != (-1)) goto L13;
        this.mButtonPositiveText = r101;
        this.mButtonPositiveMessage = r103;
        this.mButtonPositiveIcon = r104;
        return;
    L13:
        throw new IllegalArgumentException("Button does not exist");
    }

    public void setView(View r100, int r101, int r102, int r103, int r104) {
        this.mView = r100;
        this.mViewLayoutResId = 0;
        this.mViewSpacingSpecified = true;
        this.mViewSpacingLeft = r101;
        this.mViewSpacingTop = r102;
        this.mViewSpacingRight = r103;
        this.mViewSpacingBottom = r104;
    }
}
