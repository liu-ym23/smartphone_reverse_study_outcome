package obric.widget.letters;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.GlobalProxyLancet;
import com.obric.oui.material.MaterialConfigFormatNames;
import com.ttnet.org.chromium.net.NetError;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import obric.util.Utils;
import obric.widget.R;
import obric.widget.SurnameGridView;

/* JADX INFO: loaded from: classes5.dex */
public class QuickBarEx extends LinearLayout {
    private static final int DEFAULTX = -99999;
    public static final int LETTER_CHANGED_CLICK = 1;
    public static final int LETTER_CHANGED_SLIDE = 0;
    public static final int POUND_POSITION_BOTTOM = 2;
    public static final int POUND_POSITION_TOP = 1;
    public static final boolean QuickBarEx_DEBUG = false;
    public static final String QuickBarEx_TAG = "QuickBarEx";
    private static final int STATE_END = 3;
    private static final int STATE_MOVE = 2;
    private static final int STATE_START = 1;
    private static final int SURNAME_NUM_COLUMNS_THRESHOLD = 8;
    private static final int SURNAME_NUM_ROWS_THRESHOLD = 8;
    public static final int VISIBILITY_LIMIT = 30;
    private AlphabetsAdapter mAlphabetsAdapter;
    private int mColumnCount;
    private Context mContext;
    private float mCurrentRawX;
    private int mEndX;
    private GridView mGridView;
    private boolean mHasPerformedLongPress;
    private int mHostX;
    private Bitmap[][] mIconsForSymbols;
    private boolean mIsPerformingHideAnim;
    private boolean mIsPerformingShowAnim;
    private float mLastRawX;
    private int mLetterBarWidth;
    private int mLetterbarShadowWidth;
    private List<LBLetter> mLetters;
    private LettersBar mLettersBar;
    private boolean mLongPressEnabled;
    private int mMeasuredHeight;
    private int mMinXDistance;
    private float mMissX;
    private SurnameFlowLayout mPopupFlowLayout;
    private SurnameGridView mPopupGridView;
    private int mPopupViewMaxHeight;
    private int mPopupViewPendingHorizontal;
    private int mPopupViewPendingVertical;
    private PopupWindow mPopupWindow;
    private int mPopupYOffset;
    private int mPoundPosition;
    private boolean mPoundVisibility;
    private int mPrePosition;
    private QBListener mQBListener;
    private PopupWindow mSecondPopup;
    private TextView mSecondPopupView;
    private View mSecondPopupViewArrow;
    private ViewGroup mSecondPopupViewParent;
    private View mShadowView;
    private int mStartX;
    private int mState;
    private int mSurnameGridViewColumnsThreshold;
    private int mSurnameGridViewItemHeight;
    private int mSurnameGridViewItemWidth;
    private int mSurnameGridViewNumColumns;
    private int mSurnameGridViewNumRows;
    private SurnameListener mSurnameListener;
    private int[] mSymbols;
    private int mWidth;

    class AlphabetsAdapter extends BaseAdapter {
        private String[] mAlphabets;
        private Context mContext;
        private String mCurrentLanguage;
        private float mNumRows;
        private int mTotalVerticalSpacing;
        final /* synthetic */ QuickBarEx this$0;

        @Override // android.widget.Adapter
        public long getItemId(int position) {
            return position;
        }

        @Override // android.widget.Adapter
        public /* bridge */ /* synthetic */ Object getItem(int position) {
            return getItem(position);
        }

        public AlphabetsAdapter(final QuickBarEx this$0, Context context) {
            this.this$0 = this$0;
            this.mContext = context;
            String r4 = Locale.getDefault().getLanguage();
            this.mCurrentLanguage = r4;
            float r5 = AlphabetsConfig.numRowsByLanguage(r4);
            this.mNumRows = r5;
            this.mTotalVerticalSpacing = (((int) Math.ceil(r5)) - 1) * QuickBarEx.access$2000(this$0).getVerticalSpacing();
        }

        public void setAlphabets(String[] alphabets) {
            this.mAlphabets = alphabets;
        }

        @Override // android.widget.BaseAdapter, android.widget.ListAdapter
        public boolean isEnabled(int position) {
            if (AlphabetsConfig.isPlaceholder(this.mAlphabets[position]) == false) goto L5;
        L7:
            return false;
        L5:
            if (AlphabetsConfig.isDisabled(this.mAlphabets[position]) == true) goto L7;
            return true;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            String[] r0 = this.mAlphabets;
            if (r0 != null) goto L7;
            return 0;
        L7:
            return r0.length;
        }

        @Override // android.widget.Adapter
        public String getItem(int position) {
            return this.mAlphabets[position];
        }

        private boolean isNeedIncreaseHeight() {
            if (((int) ((QuickBarEx.access$2100(this.this$0) - this.mTotalVerticalSpacing) % this.mNumRows)) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        private int getSingleCellHeight() {
            return (int) ((QuickBarEx.access$2100(this.this$0) - this.mTotalVerticalSpacing) / this.mNumRows);
        }

        private boolean isNeedInsreaseHeightPosition(int position) {
            if (position != (getCount() - 1)) goto L5;
            return true;
        L5:
            if (position != (getCount() - 2)) goto L7;
            return true;
        L7:
            if (position == (getCount() - 3)) goto L13;
            return false;
        L13:
            return true;
        }

        @Override // android.widget.Adapter
        public View getView(int r4, View r5, ViewGroup r6) {
            String r7 = this.mAlphabets[r4];
            int r8 = getSingleCellHeight();
            float r0 = QuickBarEx.access$2100(this.this$0) - this.mTotalVerticalSpacing;
            float r2 = this.mNumRows;
            int r1 = (int) (r0 - (r8 * r2));
            if (r2 != 9.0f) goto L10;
            if (isNeedIncreaseHeight() == false) goto L10;
            if (isNeedInsreaseHeightPosition(r4) == false) goto L10;
            r8 = r8 + r1;
        L10:
            if (AlphabetsConfig.isSymbol(r7) == false) goto L12;
            ImageView r9 = new ImageView(this.mContext);
            r9.setImageResource(R.drawable.letter_bar_unfold_button);
            r9.setScaleType(ImageView.ScaleType.CENTER);
            r9.setMinimumHeight(r8);
            View r10 = r9;
        L23:
            if (((r4 / 3) % 2) != 0) goto L25;
            Drawable r3 = this.mContext.getResources().getDrawable(R.drawable.quickbar_ex_alphabet_text_light_colorlist);
        L26:
            r10.setBackground(r3);
            return r10;
        L25:
            r3 = this.mContext.getResources().getDrawable(R.drawable.quickbar_ex_alphabet_text_dark_colorlist);
            goto L26
        L12:
            AlphabetView r11 = new AlphabetView(this.mContext);
            r11.setHeight(r8);
            if (AlphabetsConfig.isDisabled(r7) == false) goto L16;
            r11.setTextColor(Color.parseColor("#80000000"));
            r7 = r7.substring(1);
        L16:
            if (AlphabetsConfig.isPlaceholder(r7) == true) goto L19;
            r11.setText(r7);
        L19:
            if (AlphabetsConfig.isRussianAlphabet(r7) == false) goto L21;
            r11.setTypeface(null, 0);
        L21:
            r10 = r11;
            goto L23
        }
    }

    public interface QBListener {
        boolean onLetterChanged(String letter, int type);

        void onLetterGridHidden();

        void onLetterGridShow();
    }

    private final class SurnameAdapter extends BaseAdapter {
        private Context context;
        private List<String> surnames;
        final /* synthetic */ QuickBarEx this$0;

        @Override // android.widget.Adapter
        public long getItemId(int position) {
            return 0;
        }

        public SurnameAdapter(final QuickBarEx this$0, Context context, List<String> surnames) {
            this.this$0 = this$0;
            this.context = context;
            this.surnames = surnames;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            List<String> r0 = this.surnames;
            if (r0 != null) goto L6;
            return 0;
        L6:
            return r0.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int position) {
            List<String> r0 = this.surnames;
            if (r0 != null) goto L6;
            return null;
        L6:
            return r0.get(position);
        }

        @Override // android.widget.Adapter
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView != null) goto L4;
            convertView = LayoutInflater.from(this.context).inflate(R.layout.surname_popup_item_ex, null);
            convertView.setLayoutParams(new AbsListView.LayoutParams(QuickBarEx.access$2200(this.this$0), QuickBarEx.access$2300(this.this$0)));
        L4:
            int r5 = position % QuickBarEx.access$2400(this.this$0);
            if (r5 == 0) goto L7;
        L9:
            if (r5 != 0) goto L12;
            convertView.setBackgroundResource(R.drawable.surname_popup_item_right);
        L18:
            ((TextView) convertView).setText(String.valueOf(this.surnames.get(position)));
            return convertView;
        L12:
            if (r5 != (QuickBarEx.access$2400(this.this$0) - 1)) goto L14;
        L17:
            convertView.setBackgroundResource(R.drawable.surname_popup_item_left);
            goto L18
        L14:
            if (position == (getCount() - 1)) goto L17;
            convertView.setBackgroundResource(R.drawable.surname_popup_item_middle);
            goto L18
        L7:
            if (position != (getCount() - 1)) goto L9;
            convertView.setBackgroundResource(R.drawable.surname_popup_item_special);
            goto L18
        }
    }

    public interface SurnameListener {
        List<String> getMatchedSurnames(String letter);

        void onSurnameClicked(String surname);
    }

    static /* synthetic */ QBListener access$000(QuickBarEx r0) {
        return r0.mQBListener;
    }

    static /* synthetic */ void access$100(QuickBarEx r0, boolean r1) {
        r0.setShadowVisible(r1);
    }

    static /* synthetic */ boolean access$1002(QuickBarEx r0, boolean r1) {
        r0.mIsPerformingShowAnim = r1;
        return r1;
    }

    static /* synthetic */ void access$1100(QuickBarEx r0, boolean r1) {
        r0.setLettersBarBg(r1);
    }

    static /* synthetic */ void access$1200(QuickBarEx r0) {
        r0.onShowLetterGridAnimationEnd();
    }

    static /* synthetic */ boolean access$1302(QuickBarEx r0, boolean r1) {
        r0.mIsPerformingHideAnim = r1;
        return r1;
    }

    static /* synthetic */ void access$1400(QuickBarEx r0) {
        r0.onHideLetterGridAnimationEnd();
    }

    static /* synthetic */ SurnameListener access$1500(QuickBarEx r0) {
        return r0.mSurnameListener;
    }

    static /* synthetic */ PopupWindow access$1600(QuickBarEx r0) {
        return r0.mSecondPopup;
    }

    static /* synthetic */ TextView access$1700(QuickBarEx r0) {
        return r0.mSecondPopupView;
    }

    static /* synthetic */ void access$1800(QuickBarEx r0, View r1) {
        r0.showSecondPopupWindow(r1);
    }

    static /* synthetic */ SurnameGridView access$1900(QuickBarEx r0) {
        return r0.mPopupGridView;
    }

    static /* synthetic */ AlphabetsAdapter access$200(QuickBarEx r0) {
        return r0.mAlphabetsAdapter;
    }

    static /* synthetic */ GridView access$2000(QuickBarEx r0) {
        return r0.mGridView;
    }

    static /* synthetic */ int access$2100(QuickBarEx r0) {
        return r0.mMeasuredHeight;
    }

    static /* synthetic */ int access$2200(QuickBarEx r0) {
        return r0.mSurnameGridViewItemWidth;
    }

    static /* synthetic */ int access$2300(QuickBarEx r0) {
        return r0.mSurnameGridViewItemHeight;
    }

    static /* synthetic */ int access$2400(QuickBarEx r0) {
        return r0.mSurnameGridViewColumnsThreshold;
    }

    static /* synthetic */ void access$300(QuickBarEx r0) {
        r0.hideLetterGridWithAnim();
    }

    static /* synthetic */ int access$400(QuickBarEx r0) {
        return r0.mState;
    }

    static /* synthetic */ PopupWindow access$500(QuickBarEx r0) {
        return r0.mPopupWindow;
    }

    static /* synthetic */ boolean access$600(QuickBarEx r0) {
        return r0.mLongPressEnabled;
    }

    static /* synthetic */ void access$700(QuickBarEx r0, View r1, int r2) {
        r0.showFlowPopupWindow(r1, r2);
    }

    static /* synthetic */ void access$800(QuickBarEx r0, View r1, int r2) {
        r0.showGridPopupWindow(r1, r2);
    }

    static /* synthetic */ boolean access$902(QuickBarEx r0, boolean r1) {
        r0.mHasPerformedLongPress = r1;
        return r1;
    }

    static {
        QuickBarEx_DEBUG = Log.isLoggable(QuickBarEx_TAG, 3);
    }

    public QuickBarEx(Context context) {
        this(context, null);
    }

    public QuickBarEx(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public QuickBarEx(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.mMeasuredHeight = 0;
        this.mState = 1;
        this.mMissX = 0.0f;
        this.mLastRawX = 0.0f;
        this.mCurrentRawX = 0.0f;
        this.mIsPerformingHideAnim = false;
        this.mIsPerformingShowAnim = false;
        this.mLetters = new ArrayList();
        this.mPoundVisibility = true;
        this.mPoundPosition = 2;
        this.mColumnCount = 3;
        this.mHostX = DEFAULTX;
        this.mPrePosition = -1;
        this.mLongPressEnabled = true;
        init(context);
    }

    public void setQBListener(QBListener listener) {
        this.mQBListener = listener;
    }

    public void setSurnameListener(SurnameListener listener) {
        this.mSurnameListener = listener;
    }

    public void initSpecialIcons(int[] symbols, Bitmap[][] bitmaps) {
        if (symbols == null) goto L20;
        if (bitmaps != null) goto L6;
        return;
    L6:
        if (symbols.length != 0) goto L8;
        return;
    L8:
        if (bitmaps.length != 0) goto L11;
        return;
    L11:
        if (symbols.length != bitmaps.length) goto L19;
        if (bitmaps[0].length != 3) goto L17;
        this.mSymbols = symbols;
        this.mIconsForSymbols = bitmaps;
        initLetters();
        return;
    L17:
        throw new IllegalArgumentException("Paramer bitmaps[x][y], y must is 3 !!!");
    L19:
        throw new IllegalArgumentException("The symbols.length must equals bitmaps.length !");
    }

    public void initLetters() {
        this.mLetters.clear();
        int r1 = 0;
        if (this.mSymbols == null) goto L9;
        int r0 = 0;
    L5:
        int[] r2 = this.mSymbols;
        if (r0 >= r2.length) goto L8;
        this.mLetters.add(LBLetter.fromSymbol(String.valueOf(r2[r0]), this.mIconsForSymbols[r0]));
        r0 = r0 + 1;
        goto L5
    L8:
        int r3 = r2.length;
    L10:
        String[] r4 = LettersConfig.lettersByLanguage(Locale.getDefault().getLanguage());
    L12:
        if (r1 >= (r4.length - 1)) goto L19;
        if (LettersConfig.isLocaleLetter(Locale.getDefault().getLanguage(), r1) == false) goto L16;
        this.mLetters.add(LBLetter.fromLocaleLetter(r4[r1]));
    L17:
        r1 = r1 + 1;
        goto L12
    L16:
        this.mLetters.add(LBLetter.fromLetter(r4[r1]));
        goto L17
    L19:
        if (this.mPoundVisibility == true) goto L21;
    L24:
        invalidate();
        return;
    L21:
        if (this.mPoundPosition != 1) goto L23;
        this.mLetters.add(r3, LBLetter.POUND);
        goto L24
    L23:
        this.mLetters.add(LBLetter.POUND);
        goto L24
    L9:
        r3 = 0;
        goto L10
    }

    public void setPoundVisibility(boolean visible) {
        this.mPoundVisibility = visible;
    }

    public void setPoundPosition(int position) {
        this.mPoundPosition = position;
    }

    public boolean isLetterGridShow() {
        if (this.mIsPerformingShowAnim == false) goto L5;
    L8:
        return true;
    L5:
        if (this.mState == 3) goto L8;
        return false;
    }

    public boolean isLetterGridShown() {
        if (this.mState != 3) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isLetterGridHide() {
        if (this.mIsPerformingHideAnim == false) goto L5;
        return true;
    L5:
        if (this.mState == 1) goto L10;
        return false;
    L10:
        return true;
    }

    public boolean isLetterGridHidden() {
        if (this.mState == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public boolean isPerformingAnim() {
        if (this.mIsPerformingShowAnim == false) goto L5;
    L8:
        return true;
    L5:
        if (this.mIsPerformingHideAnim == true) goto L8;
        return false;
    }

    public void hideLetterGrid() {
        hideLetterGrid(true);
    }

    public void hideLetterGrid(boolean withAnim) {
        dismissPopupWindow();
        if (isLetterGridHide() == true) goto L8;
        if (withAnim == false) goto L6;
        hideLetterGridWithAnim();
        return;
    L6:
        onHideLetterGridAnimationEnd();
        return;
    }

    public void setLongPressEnabled(boolean enabled) {
        this.mLongPressEnabled = enabled;
    }

    private void init(Context context) {
        this.mContext = context;
        Resources r4 = context.getResources();
        LayoutInflater.from(this.mContext).inflate(R.layout.quickbar_ex, this, true);
        this.mLetterBarWidth = Utils.getDrawableWidth(this.mContext.getResources().getDrawable(R.drawable.letters_bar_background));
        int r0 = r4.getDimensionPixelOffset(R.dimen.obric_quickbar_grid_item_space);
        int r1 = r4.getDimensionPixelOffset(R.dimen.quickbar_ex_grid_column_width);
        this.mMinXDistance = r4.getDimensionPixelOffset(R.dimen.obric_quickbar_min_distance);
        this.mLetterbarShadowWidth = Utils.getDrawableWidth(this.mContext.getResources().getDrawable(R.drawable.letters_bar_background_shadow));
        this.mWidth = (((r0 * 2) + this.mLetterBarWidth) + (r1 * this.mContext.getResources().getInteger(R.integer.obric_letterbar_gridview_column_num))) + this.mLetterbarShadowWidth;
        initLettersBar();
        initGridView();
        this.mShadowView = findViewById(R.id.iv_letter_bar_shadow);
        setLettersBarBg(false);
    }

    private void initLettersBar() {
        LettersBar r0 = (LettersBar) findViewById(R.id.quickbar_left_letters_bar);
        this.mLettersBar = r0;
        ViewGroup.LayoutParams r1 = r0.getLayoutParams();
        r1.width = this.mLetterBarWidth;
        this.mLettersBar.setLetters(this.mLetters);
        this.mLettersBar.setListener(new AnonymousClass1(this));
        this.mLettersBar.setOnBackgroundVisibleChangedListener(new AnonymousClass2(this));
        initLetters();
    }

    private void initGridView() {
        this.mGridView = (GridView) findViewById(R.id.quickbar_right_grid_view);
        AlphabetsAdapter r0 = new AlphabetsAdapter(this, this.mContext);
        this.mAlphabetsAdapter = r0;
        r0.setAlphabets(AlphabetsConfig.alphabetsByLanguage(Locale.getDefault().getLanguage()));
        this.mGridView.setAdapter(this.mAlphabetsAdapter);
        this.mGridView.setOnItemClickListener(new AnonymousClass3(this));
        this.mGridView.setOnTouchListener(new AnonymousClass4(this));
        this.mGridView.setOnItemLongClickListener(new AnonymousClass5(this));
    }

    private void setHostWidth(int hostWidth) {
        int r0 = (hostWidth - this.mLetterBarWidth) - this.mLetterbarShadowWidth;
        this.mStartX = r0;
        int r4 = hostWidth - this.mWidth;
        this.mEndX = r4;
        int r1 = this.mState;
        if (r1 != 1) goto L6;
        float r5 = r0;
    L9:
        setX(r5);
        if (QuickBarEx_DEBUG == false) goto L12;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(QuickBarEx_TAG, "mStartX = " + this.mStartX);
    L12:
        invalidate();
        return;
    L6:
        if (r1 != 3) goto L8;
        r5 = r4;
        goto L9
    L8:
        r5 = getX();
        goto L9
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        this.mMeasuredHeight = measureHeight(heightMeasureSpec);
        int r2 = View.MeasureSpec.getSize(widthMeasureSpec);
        Object r3 = getParent();
        if (r3 == null) goto L7;
        int r4 = ((View) r3).getMeasuredWidth();
        if (r4 <= 0) goto L9;
        setHostWidth(r4);
    L9:
        if (QuickBarEx_DEBUG == false) goto L12;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(QuickBarEx_TAG, "measure width:" + r2 + "  parentWidth:" + r4);
        return;
    L12:
        return;
    L7:
        r4 = 0;
        goto L9
    }

    private int measureHeight(int measureSpec) {
        return View.MeasureSpec.getSize(measureSpec);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent event) {
        if (AlphabetsConfig.isAlphabetsSupportedByLanguage(Locale.getDefault().getLanguage()) == false) goto L5;
        getParentxPos();
        int r0 = event.getAction();
        event.getX();
        event.getY();
        float r1 = event.getRawX() - this.mHostX;
        if (r0 != 0) goto L9;
        this.mHasPerformedLongPress = false;
        this.mCurrentRawX = r1;
        this.mLastRawX = r1;
        int r2 = this.mState;
        if (r2 != 1) goto L70;
        this.mMissX = 0.0f;
    L70:
        if (r2 != 3) goto L72;
        this.mMissX = r1 - this.mEndX;
    L72:
        if (r2 != 3) goto L78;
        PopupWindow r3 = this.mPopupWindow;
        if (r3 == null) goto L78;
        if (r3.isShowing() == false) goto L78;
        this.mPopupWindow.dismiss();
    L78:
        boolean r4 = false;
    L79:
        if (r4 == true) goto L83;
        if (super.dispatchTouchEvent(event) == true) goto L83;
        return false;
    L83:
        return true;
    L9:
        if (r0 == 1) goto L37;
        if (r0 == 2) goto L14;
        if (r0 == 3) goto L37;
    L14:
        if (this.mHasPerformedLongPress == false) goto L16;
        onMoveInLongPressState(event);
        goto L78
    L16:
        float r5 = this.mCurrentRawX;
        this.mLastRawX = r5;
        this.mCurrentRawX = r1;
        int r6 = this.mState;
        if (r6 == 1) goto L19;
        if (r6 != 2) goto L30;
        moveQuickBar(r1, this.mMissX);
        if (this.mState != 1) goto L29;
        QBListener r7 = this.mQBListener;
        if (r7 == null) goto L29;
        r7.onLetterGridHidden();
    L29:
        r4 = true;
        goto L79
    L30:
        if (r6 != 3) goto L78;
        if ((r1 - r5) <= this.mMinXDistance) goto L78;
        if (r5 <= this.mEndX) goto L78;
        setState(2);
        moveQuickBar(r1, this.mMissX);
        goto L29
    L19:
        if (r1 >= this.mStartX) goto L78;
        setState(2);
        moveQuickBar(r1, this.mMissX);
        QBListener r8 = this.mQBListener;
        if (r8 == null) goto L29;
        r8.onLetterGridShow();
    L37:
        if (this.mHasPerformedLongPress == true) goto L39;
        this.mMissX = 0.0f;
        if (getX() != this.mStartX) goto L60;
        setLettersBarBg(false);
        goto L78
    L60:
        if (this.mState != 2) goto L78;
        if ((this.mCurrentRawX - this.mLastRawX) <= 0.0f) goto L64;
    L66:
        hideLetterGridWithAnim();
        goto L29
    L64:
        if (getX() >= (getScreenWidth() + NetError.ERR_SSL_PINNED_KEY_NOT_IN_CERT_CHAIN)) goto L66;
        showLetterGridWithAnim();
        goto L29
    L39:
        if (AlphabetsConfig.surnameTypeSupportedByLanguage(Locale.getDefault().getLanguage()) != 1) goto L48;
        int r9 = this.mPrePosition;
        if (r9 < 0) goto L47;
        SurnameFlowLayout r10 = this.mPopupFlowLayout;
        if (r10 == null) goto L47;
        View r11 = r10.getChildAt(r9);
        if (r11 == null) goto L47;
        r11.setPressed(false);
        r11.performClick();
    L47:
        this.mPrePosition = -1;
        goto L78
    L48:
        int r12 = this.mPrePosition;
        if (r12 < 0) goto L55;
        SurnameGridView r13 = this.mPopupGridView;
        if (r13 == null) goto L55;
        View r14 = r13.getChildAt(r12);
        if (r14 == null) goto L55;
        r14.setPressed(false);
        this.mPopupGridView.performItemClick(r14, this.mPrePosition, -1);
    L55:
        this.mPrePosition = -1;
        goto L78
    L5:
        return super.dispatchTouchEvent(event);
    }

    private void onMoveInLongPressState(MotionEvent event) {
        PopupWindow r0 = this.mPopupWindow;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isShowing() == false) goto L55;
        int r1 = (int) event.getRawX();
        int r10 = (int) event.getRawY();
        if (AlphabetsConfig.surnameTypeSupportedByLanguage(Locale.getDefault().getLanguage()) != 1) goto L32;
        SurnameFlowLayout r2 = this.mPopupFlowLayout;
        if (r2 == null) goto L52;
        int[] r3 = new int[2];
        r2.getLocationOnScreen(r3);
        int r4 = 0;
    L13:
        if (r4 >= this.mPopupFlowLayout.getChildCount()) goto L18;
        View r6 = this.mPopupFlowLayout.getChildAt(r4);
        Rect r7 = new Rect();
        r6.getHitRect(r7);
        if (r7.contains(r1 - r3[0], r10 - r3[1]) == true) goto L19;
        r4 = r4 + 1;
    L19:
        if (r4 < 0) goto L28;
        int r11 = this.mPrePosition;
        if (r11 == r4) goto L31;
        View r12 = this.mPopupFlowLayout.getChildAt(r11);
        if (r12 == null) goto L25;
        r12.setPressed(false);
        showSecondPopupWindow(null);
    L25:
        View r13 = this.mPopupFlowLayout.getChildAt(r4);
        if (r13 == null) goto L31;
        r13.setPressed(true);
        r13.setTag((String) ((TextView) r13).getText());
        showSecondPopupWindow(r13);
    L31:
        this.mPrePosition = r4;
        return;
    L28:
        View r14 = this.mPopupFlowLayout.getChildAt(this.mPrePosition);
        if (r14 == null) goto L31;
        r14.setPressed(false);
        showSecondPopupWindow(null);
        goto L31
    L18:
        r4 = -1;
        goto L19
    L52:
        return;
    L32:
        SurnameGridView r5 = this.mPopupGridView;
        if (r5 == null) goto L54;
        int[] r8 = new int[2];
        r5.getLocationOnScreen(r8);
        int r15 = this.mPopupGridView.pointToPosition(r1 - r8[0], r10 - r8[1]);
        if (r15 < 0) goto L44;
        int r9 = this.mPrePosition;
        if (r9 == r15) goto L47;
        View r16 = this.mPopupGridView.getChildAt(r9);
        if (r16 == null) goto L41;
        r16.setPressed(false);
        showSecondPopupWindow(null);
    L41:
        View r17 = this.mPopupGridView.getChildAt(r15);
        if (r17 == null) goto L47;
        r17.setPressed(true);
        r17.setTag((String) this.mPopupGridView.getAdapter().getItem(r15));
        showSecondPopupWindow(r17);
    L47:
        this.mPrePosition = r15;
        return;
    L44:
        View r18 = this.mPopupGridView.getChildAt(this.mPrePosition);
        if (r18 == null) goto L47;
        r18.setPressed(false);
        showSecondPopupWindow(null);
        goto L47
    L54:
        return;
    }

    private void setState(int state) {
        this.mState = state;
        LettersBar r1 = this.mLettersBar;
        boolean r0 = true;
        if (state == 1) goto L6;
        r0 = false;
    L6:
        r1.setSettled(r0);
    }

    private void moveQuickBar(float x, float missX) {
        float r2 = x - missX;
        int r3 = this.mStartX;
        if (r2 < r3) goto L5;
        setX(r3);
        setState(1);
        return;
    L5:
        int r4 = this.mEndX;
        if (r2 > r4) goto L9;
        setX(r4);
        setState(3);
        return;
    L9:
        if (r2 <= r4) goto L14;
        setX(r2);
        setState(2);
        return;
    }

    private void showLetterGridWithAnim() {
        QBListener r0 = this.mQBListener;
        if (r0 == null) goto L5;
        r0.onLetterGridShow();
    L5:
        AnimatorSet r1 = new AnimatorSet();
        r1.play(ObjectAnimator.ofPropertyValuesHolder(this, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(MaterialConfigFormatNames.X, new float[]{getX(), this.mEndX})}));
        r1.setDuration(200);
        r1.addListener(new AnonymousClass6(this));
        r1.start();
    }

    private void onShowLetterGridAnimationEnd() {
        setX(this.mEndX);
        setState(3);
        setLettersBarBg(true);
    }

    private void hideLetterGridWithAnim() {
        dismissPopupWindow();
        AnimatorSet r0 = new AnimatorSet();
        r0.play(ObjectAnimator.ofPropertyValuesHolder(this, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(MaterialConfigFormatNames.X, new float[]{getX(), this.mStartX})}));
        r0.setDuration(200);
        r0.addListener(new AnonymousClass7(this));
        r0.start();
    }

    private void onHideLetterGridAnimationEnd() {
        setState(1);
        setX(this.mStartX);
        setLettersBarBg(false);
    }

    private void setLettersBarBg(boolean showBg) {
        this.mLettersBar.setShowBg(showBg);
        setShadowVisible(showBg);
    }

    private void setShadowVisible(boolean visible) {
        View r0 = this.mShadowView;
        if (visible == false) goto L5;
        int r1 = 0;
    L6:
        r0.setVisibility(r1);
        return;
    L5:
        r1 = 4;
        goto L6
    }

    private int getScreenWidth() {
        Point r0 = new Point();
        ((WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay().getSize(r0);
        return r0.x;
    }

    private int dipToPx(double dipValue) {
        return (int) ((dipValue * ((double) this.mContext.getResources().getDisplayMetrics().density)) + 0.5d);
    }

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
    private void showFlowPopupWindow(View alphabetView, int position) {
        if (this.mSurnameListener == null) goto L96;
        if (AlphabetsConfig.isSurnameSupportedByLanguage(Locale.getDefault().getLanguage(), this.mAlphabetsAdapter.getItem(position)) == true) goto L7;
        return;
    L7:
        List<String> r2 = this.mSurnameListener.getMatchedSurnames(this.mAlphabetsAdapter.getItem(position));
        if (r2 != null) goto L10;
        return;
    L10:
        if (r2.size() == 0) goto L101;
        ViewGroup r5 = null;
        View r3 = LayoutInflater.from(this.mContext).inflate(R.layout.surname_flow_popup, null);
        this.mPopupFlowLayout = (SurnameFlowLayout) r3.findViewById(R.id.surname_content);
        this.mPopupYOffset = dipToPx(7.0d);
        this.mPopupViewMaxHeight = dipToPx(283.0d);
        this.mSurnameGridViewItemWidth = dipToPx(40.0d);
        this.mSurnameGridViewItemHeight = dipToPx(33.0d);
        this.mSurnameGridViewColumnsThreshold = 8;
        int r4 = dipToPx(98.0d);
        Drawable r6 = getResources().getDrawable(R.drawable.surname_popup_item_left);
        int r7 = this.mSurnameGridViewColumnsThreshold * this.mSurnameGridViewItemWidth;
        Iterator<String> r8 = r2.iterator();
        int r11 = 1;
        int r12 = 0;
        int r13 = 0;
    L14:
        if (r8.hasNext() == false) goto L38;
        String r14 = r8.next();
        final TextView r9 = (TextView) LayoutInflater.from(this.mContext).inflate(R.layout.surname_popup_item_ex, r5);
        r9.setText(r14);
        ViewGroup.MarginLayoutParams r10 = new ViewGroup.MarginLayoutParams(-2, -2);
        r10.height = this.mSurnameGridViewItemHeight;
        r9.setLayoutParams(r10);
        Drawable r17 = r6;
        r9.setPadding(dipToPx(10.0d), 0, dipToPx(10.0d), 0);
        if (r2.size() != 1) goto L18;
        r9.setBackgroundResource(R.drawable.surname_popup_item_special);
    L19:
        int r15 = (int) Math.ceil(r9.getPaint().measureText(r14));
        if (r17 == null) goto L26;
        int r16 = r17.getIntrinsicWidth();
        if (r16 <= 0) goto L26;
        int r18 = r11;
        double r19 = 20.0d;
        if (r16 <= (dipToPx(20.0d) + r15)) goto L27;
        r15 = r16 - dipToPx(20.0d);
    L27:
        if (r15 <= r4) goto L29;
        r15 = r4;
    L29:
        int r20 = r15 + dipToPx(r19);
        if ((r13 + r20) <= r7) goto L32;
        r11 = r18 + 1;
        r13 = 0;
    L33:
        r13 = r13 + r20;
        if (r12 > r13) goto L37;
        r12 = r13;
    L37:
        r9.setOnClickListener(new AnonymousClass8(this));
        r9.setOnTouchListener(new AnonymousClass9(this, r9));
        this.mPopupFlowLayout.addView(r9);
        r6 = r17;
        r5 = null;
        goto L14
    L32:
        r11 = r18;
    L26:
        r18 = r11;
        r19 = 20.0d;
        goto L27
    L18:
        r9.setBackgroundResource(R.drawable.surname_popup_item_left);
        goto L19
    L38:
        this.mSurnameGridViewNumRows = r11;
        this.mPopupFlowLayout.measure(0, 0);
        boolean r21 = QuickBarEx_DEBUG;
        if (r21 == false) goto L41;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(QuickBarEx_TAG, "surname FlowLayout, width = " + r12);
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(QuickBarEx_TAG, "surname FlowLayout, measuredHeight = " + this.mPopupFlowLayout.getMeasuredHeight());
    L41:
        FrameLayout.LayoutParams r22 = (FrameLayout.LayoutParams) this.mPopupFlowLayout.getLayoutParams();
        r22.width = r12;
        this.mPopupFlowLayout.setLayoutParams(r22);
        if (this.mPopupWindow != null) goto L44;
        PopupWindow r23 = new PopupWindow();
        this.mPopupWindow = r23;
        r23.setWindowLayoutMode(-2, -2);
        this.mPopupWindow.setBackgroundDrawable(getResources().getDrawable(android.R.color.transparent));
        this.mPopupWindow.setClippingEnabled(true);
    L44:
        this.mPopupWindow.setContentView(r3);
        getLocationOnScreen(new int[2]);
        getLocationInWindow(new int[2]);
        int[] r24 = new int[2];
        alphabetView.getLocationOnScreen(r24);
        int r25 = r24[0] + (alphabetView.getWidth() / 2);
        int r110 = r24[1] + (alphabetView.getHeight() / 2);
        if (r21 == false) goto L47;
        int r26 = 0;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(QuickBarEx_TAG, "alphabet anchorX = " + r24[0] + ", anchorY = " + r24[1]);
    L48:
        r3.measure(r26, r26);
        int r27 = r3.getMeasuredWidth();
        int r28 = r3.getMeasuredHeight();
        if (r21 == false) goto L51;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(QuickBarEx_TAG, "popMeasureWidth = " + r27 + ", popMeasureHeight = " + r28);
    L51:
        int r29 = this.mColumnCount;
        if (position >= r29) goto L56;
        boolean r111 = true;
        if (this.mSurnameGridViewNumRows <= 1) goto L57;
    L76:
        if (r111 == false) goto L78;
        ImageView r1 = (ImageView) r3.findViewById(R.id.surname_popup_top_arrow);
        int r112 = r110 + this.mPopupYOffset;
    L79:
        r1.setVisibility(0);
        r1.measure(0, 0);
        int r30 = r1.getMeasuredWidth();
        if (r21 == false) goto L82;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(QuickBarEx_TAG, "arrowWidth = " + r30);
    L82:
        int r31 = r27 / 2;
        int r32 = Math.min(getScreenWidth() - r25, r31);
        int r33 = r25 - r31;
        int r34 = (r27 - r32) - (r30 / 2);
        ImageView r35 = (ImageView) r3.findViewById(R.id.surname_top_mask);
        FrameLayout.LayoutParams r36 = (FrameLayout.LayoutParams) r35.getLayoutParams();
        r36.width = r12;
        ImageView r37 = (ImageView) r3.findViewById(R.id.surname_bottom_mask);
        FrameLayout.LayoutParams r38 = (FrameLayout.LayoutParams) r37.getLayoutParams();
        r38.width = r12;
        LinearLayout r39 = (LinearLayout) r3.findViewById(R.id.surname_container);
        FrameLayout.LayoutParams r113 = (FrameLayout.LayoutParams) r39.getLayoutParams();
        int r114 = this.mPopupFlowLayout.getMeasuredHeight();
        int r115 = this.mPopupViewMaxHeight;
        if (r114 <= r115) goto L85;
        r113.height = r115;
    L85:
        r39.setLayoutParams(r113);
        if (r12 != (this.mSurnameGridViewColumnsThreshold * this.mSurnameGridViewItemWidth)) goto L88;
        r39.setPadding(dipToPx(14.0d), dipToPx(1.5d), dipToPx(17.0d), dipToPx(4.0d));
        r34 = r34 + getResources().getDimensionPixelSize(R.dimen.surname_arrow_offset_x);
        r36.leftMargin = dipToPx(20.0d);
        r38.leftMargin = dipToPx(20.0d);
        r36.width -= dipToPx(10.0d);
        r38.width -= dipToPx(10.0d);
    L89:
        r35.setLayoutParams(r36);
        r37.setLayoutParams(r38);
        r1.setTranslationX(r34);
        if (Math.abs(getX() - this.mEndX) <= dipToPx(1.0d)) goto L93;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(QuickBarEx_TAG, "GridView is hiding now...");
        return;
    L93:
        this.mPopupWindow.showAtLocation(this, 0, r33, r112);
        return;
    L88:
        r33 = r33 - 1;
        goto L89
    L78:
        r1 = (ImageView) r3.findViewById(R.id.surname_popup_bottom_arrow);
        r112 = (r110 - r28) - this.mPopupYOffset;
    L57:
        if (position < r29) goto L63;
        if (position >= (r29 * 2)) goto L63;
        if (this.mSurnameGridViewNumRows > 3) goto L76;
    L63:
        if (position < (r29 * 2)) goto L69;
        if (position >= (r29 * 3)) goto L69;
        if (this.mSurnameGridViewNumRows > 5) goto L76;
    L69:
        if (position >= (r29 * 3)) goto L71;
    L75:
        r111 = false;
        goto L76
    L71:
        if (position >= (r29 * 4)) goto L75;
        if (this.mSurnameGridViewNumRows <= 7) goto L75;
    L56:
        r111 = true;
        goto L57
    L47:
        r26 = 0;
        goto L48
    L101:
        return;
    L96:
        throw new IllegalArgumentException("You must implements SurnameListener");
    }

    private void showGridPopupWindow(View alphabetView, int position) {
        if (this.mSurnameListener == null) goto L80;
        if (AlphabetsConfig.isSurnameSupportedByLanguage(Locale.getDefault().getLanguage(), this.mAlphabetsAdapter.getItem(position)) == true) goto L7;
        return;
    L7:
        List<String> r2 = this.mSurnameListener.getMatchedSurnames(this.mAlphabetsAdapter.getItem(position));
        if (r2 != null) goto L10;
        return;
    L10:
        if (r2.size() == 0) goto L82;
        SurnameAdapter r3 = new SurnameAdapter(this, this.mContext, r2);
        View r4 = LayoutInflater.from(this.mContext).inflate(R.layout.surname_popup, null);
        this.mPopupGridView = (SurnameGridView) r4.findViewById(R.id.surname_content);
        this.mPopupYOffset = dipToPx(7.0d);
        this.mSurnameGridViewItemHeight = dipToPx(33.0d);
        this.mPopupViewMaxHeight = dipToPx(283.0d);
        this.mPopupViewPendingVertical = dipToPx(16.0d);
        this.mPopupViewPendingHorizontal = dipToPx(6.0d);
        this.mSurnameGridViewColumnsThreshold = 8;
        this.mSurnameGridViewItemWidth = dipToPx(40.0d);
        int r8 = r2.size();
        int r9 = this.mSurnameGridViewColumnsThreshold;
        if (r8 >= r9) goto L16;
        r9 = r2.size();
    L16:
        this.mSurnameGridViewNumColumns = r9;
        int r5 = (int) Math.ceil((((double) r2.size()) * 1.0d) / ((double) this.mSurnameGridViewNumColumns));
        this.mSurnameGridViewNumRows = r5;
        int r10 = (this.mSurnameGridViewNumColumns * this.mSurnameGridViewItemWidth) + (this.mPopupViewPendingHorizontal * 2);
        if (r5 <= 8) goto L19;
        int r6 = this.mPopupViewMaxHeight;
    L20:
        int r7 = r6 + (this.mPopupViewPendingVertical * 2);
        boolean r11 = QuickBarEx_DEBUG;
        if (r11 == false) goto L23;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(QuickBarEx_TAG, "surname GridView, width = " + r10 + ", height = " + r7);
    L23:
        this.mPopupGridView.setNumColumns(this.mSurnameGridViewNumColumns);
        this.mPopupGridView.setLayoutParams(new LinearLayout.LayoutParams(r10, r7));
        this.mPopupGridView.setGravity(17);
        this.mPopupGridView.setAdapter(r3);
        this.mPopupGridView.setOnPressChangeListener(new AnonymousClass10(this));
        this.mPopupGridView.setOnItemClickListener(new AnonymousClass11(this));
        if (this.mPopupWindow != null) goto L26;
        PopupWindow r12 = new PopupWindow();
        this.mPopupWindow = r12;
        r12.setWindowLayoutMode(-2, -2);
        this.mPopupWindow.setBackgroundDrawable(getResources().getDrawable(android.R.color.transparent));
        this.mPopupWindow.setClippingEnabled(true);
    L26:
        this.mPopupWindow.setContentView(r4);
        getLocationOnScreen(new int[2]);
        getLocationInWindow(new int[2]);
        int[] r13 = new int[2];
        alphabetView.getLocationOnScreen(r13);
        if (r11 == false) goto L29;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(QuickBarEx_TAG, "alphabetView.getWidth = " + alphabetView.getWidth() + ", alphabetView.getHeight = " + alphabetView.getHeight());
    L29:
        int r15 = r13[0] + (alphabetView.getWidth() / 2);
        int r16 = r13[1] + (alphabetView.getHeight() / 2);
        if (r11 == false) goto L32;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(QuickBarEx_TAG, "alphabet anchorX = " + r13[0] + ", anchorY = " + r13[1]);
    L32:
        r4.measure(0, 0);
        int r14 = r4.getMeasuredWidth();
        int r17 = r4.getMeasuredHeight();
        if (r11 == false) goto L35;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(QuickBarEx_TAG, "popMeasureWidth = " + r14 + ", popMeasureHeight = " + r17);
    L35:
        int r18 = this.mColumnCount;
        if (position < r18) goto L38;
    L39:
        if (position < r18) goto L45;
        if (position >= (r18 * 2)) goto L45;
        if (this.mSurnameGridViewNumRows <= 3) goto L45;
    L56:
        boolean r19 = true;
    L58:
        if (r19 == false) goto L60;
        ImageView r1 = (ImageView) r4.findViewById(R.id.surname_popup_top_arrow);
        int r110 = r16 + this.mPopupYOffset;
    L61:
        int r20 = r110;
        r1.setVisibility(0);
        r1.measure(0, 0);
        int r21 = r1.getMeasuredWidth();
        if (r11 == false) goto L64;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(QuickBarEx_TAG, "arrowWidth = " + r21);
    L64:
        int r111 = r14 / 2;
        int r112 = Math.min(getScreenWidth() - r15, r111);
        int r113 = r15 - r111;
        int r22 = r21 / 2;
        int r23 = (r14 - r112) - r22;
        ImageView r114 = (ImageView) r4.findViewById(R.id.surname_top_mask);
        FrameLayout.LayoutParams r115 = (FrameLayout.LayoutParams) r114.getLayoutParams();
        r115.width = this.mSurnameGridViewNumColumns * this.mSurnameGridViewItemWidth;
        ImageView r24 = (ImageView) r4.findViewById(R.id.surname_bottom_mask);
        FrameLayout.LayoutParams r25 = (FrameLayout.LayoutParams) r24.getLayoutParams();
        r25.width = this.mSurnameGridViewNumColumns * this.mSurnameGridViewItemWidth;
        LinearLayout r26 = (LinearLayout) r4.findViewById(R.id.surname_container);
        int r27 = this.mSurnameGridViewNumColumns;
        int r116 = this.mSurnameGridViewColumnsThreshold;
        if (r27 != r116) goto L70;
        ImageView r117 = r24;
        boolean r118 = r11;
        ImageView r28 = r114;
        if (r116 != 8) goto L69;
        r26.setPadding(dipToPx(14.0d), dipToPx(1.5d), dipToPx(17.0d), dipToPx(4.0d));
        r23 = r23 + getResources().getDimensionPixelSize(R.dimen.surname_arrow_offset_x);
        r115.leftMargin = dipToPx(20.0d);
        r25.leftMargin = dipToPx(20.0d);
    L71:
        if (r118 == false) goto L73;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(QuickBarEx_TAG, "arrowTranslationX = " + r23);
    L73:
        r1.setTranslationX(r23);
        r28.setLayoutParams(r115);
        r117.setLayoutParams(r25);
        if (Math.abs(getX() - this.mEndX) <= dipToPx(1.0d)) goto L77;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(r13, "GridView is hiding now...");
        return;
    L77:
        this.mPopupWindow.showAtLocation(this, 0, r113, r20);
        return;
    L69:
        int r29 = ((dipToPx(40.0d) * 8) - (this.mSurnameGridViewNumColumns * this.mSurnameGridViewItemWidth)) / 2;
        r26.setPadding(dipToPx(14.0d) + r29, dipToPx(1.5d), dipToPx(17.0d) + r29, dipToPx(4.0d));
        r115.leftMargin = dipToPx(20.0d) + r29;
        r25.leftMargin = dipToPx(20.0d) + r29;
        r23 = r15 - r22;
        goto L71
    L70:
        r117 = r24;
        r118 = r11;
        r28 = r114;
        r113 = r113 - 1;
        goto L71
    L60:
        r1 = (ImageView) r4.findViewById(R.id.surname_popup_bottom_arrow);
        r110 = (r16 - r17) - this.mPopupYOffset;
    L45:
        if (position < (r18 * 2)) goto L51;
        if (position >= (r18 * 3)) goto L51;
        if (this.mSurnameGridViewNumRows > 5) goto L56;
    L51:
        if (position >= (r18 * 3)) goto L53;
    L57:
        r19 = false;
        goto L58
    L53:
        if (position >= (r18 * 4)) goto L57;
        if (this.mSurnameGridViewNumRows <= 7) goto L57;
    L38:
        if (this.mSurnameGridViewNumRows > 1) goto L56;
    L19:
        r6 = r5 * this.mSurnameGridViewItemHeight;
        goto L20
    L82:
        return;
    L80:
        throw new IllegalArgumentException("You must implements SurnameListener");
    }

    private void dismissPopupWindow() {
        PopupWindow r0 = this.mPopupWindow;
        if (r0 == null) goto L5;
        r0.dismiss();
        this.mPopupWindow = null;
        this.mPopupGridView = null;
        this.mPopupFlowLayout = null;
    L5:
        PopupWindow r1 = this.mSecondPopup;
        if (r1 == null) goto L9;
        r1.dismiss();
        this.mSecondPopup = null;
        this.mSecondPopupView = null;
        return;
    }

    private void showSecondPopupWindow(View anchorView) {
        if (anchorView != null) goto L8;
        PopupWindow r11 = this.mSecondPopup;
        if (r11 == null) goto L24;
        r11.dismiss();
        return;
    L24:
        return;
    L8:
        if (this.mSecondPopup != null) goto L10;
        PopupWindow r0 = new PopupWindow();
        this.mSecondPopup = r0;
        r0.setWindowLayoutMode(-2, -2);
        this.mSecondPopup.setBackgroundDrawable(getResources().getDrawable(android.R.color.transparent));
        this.mSecondPopup.setClippingEnabled(true);
        ViewGroup r1 = (ViewGroup) LayoutInflater.from(getContext()).inflate(R.layout.surname_second_popup_ex, null);
        this.mSecondPopupViewParent = r1;
        this.mSecondPopupViewArrow = r1.getChildAt(1);
        this.mSecondPopupView = (TextView) this.mSecondPopupViewParent.getChildAt(0);
    L10:
        this.mSecondPopup.setContentView(this.mSecondPopupViewParent);
        int[] r3 = new int[2];
        anchorView.getLocationOnScreen(r3);
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(QuickBarEx_TAG, "original anchorViewLocation[0] = " + r3[0] + ", anchorViewLocation[1] = " + r3[1]);
        int[] r6 = new int[2];
        getRootView().getLocationOnScreen(r6);
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(QuickBarEx_TAG, "rootViewLocation[0] = " + r6[0] + ", rootViewLocation[1] = " + r6[1]);
        String r4 = String.valueOf(anchorView.getTag());
        this.mSecondPopupView.setText(r4);
        this.mSecondPopupView.measure(0, 0);
        int r5 = ((int) this.mSecondPopupView.getPaint().measureText(r4)) + dipToPx(40.0d);
        int r7 = dipToPx(320.0d);
        if (r5 <= r7) goto L13;
        r5 = r7;
    L13:
        int r8 = this.mSecondPopupView.getMeasuredHeight();
        int r9 = anchorView.getWidth();
        int r10 = anchorView.getHeight();
        int r12 = (r3[0] - r6[0]) + (r9 / 2);
        int r2 = (r3[1] - r6[1]) + (r10 / 2);
        int r13 = r5 / 2;
        int r14 = r12 - r13;
        int r15 = (r2 - r8) - 20;
        this.mSecondPopupViewArrow.getLocationOnScreen(new int[2]);
        this.mSecondPopupViewArrow.setTranslationX(0.0f);
        if (r14 >= 0) goto L16;
        this.mSecondPopupViewArrow.setTranslationX(r14);
    L20:
        if (QuickBarEx_DEBUG == false) goto L22;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(QuickBarEx_TAG, "x = " + r14 + ", width = " + r5 + ", anchorView.getWidth() = " + anchorView.getWidth());
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(QuickBarEx_TAG, "y = " + r15 + ", height = " + r8 + ", anchorView.getHeight() = " + anchorView.getHeight());
    L22:
        this.mSecondPopup.showAtLocation(this, 51, r14, r15);
        return;
    L16:
        int r16 = r12 + r13;
        if (r16 <= getScreenWidth()) goto L20;
        this.mSecondPopupViewArrow.setTranslationX(r16 - getScreenWidth());
        goto L20
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View changedView, int visibility) {
        super.onVisibilityChanged(changedView, visibility);
        if (visibility != 8) goto L11;
        if (changedView != this) goto L12;
        PopupWindow r2 = this.mPopupWindow;
        if (r2 != null) goto L8;
        return;
    L8:
        if (r2.isShowing() == false) goto L14;
        this.mPopupWindow.dismiss();
        return;
    L14:
        return;
    L12:
        return;
    }

    private void getParentxPos() {
        if (this.mHostX == DEFAULTX) goto L5;
        return;
    L5:
        Object r0 = getParent();
        if ((r0 instanceof View) == false) goto L9;
        int[] r1 = new int[2];
        ((View) r0).getLocationInWindow(r1);
        this.mHostX = r1[0];
        return;
    }

    public LettersBar getLetterBar() {
        return this.mLettersBar;
    }
}
