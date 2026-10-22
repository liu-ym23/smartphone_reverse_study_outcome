package com.obric.oui.indexscrollbar;

import android.animation.Animator;
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
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowManager;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.obric.aiagent.plugin.R;
import com.obric.oui.common.util.g;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: OIndexScrollbar.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class OIndexScrollbar extends LinearLayout {
    public static final a Companion = null;
    public static final int LETTER_CHANGED_CLICK = 1;
    public static final int LETTER_CHANGED_SLIDE = 0;
    private final int DEFAULTX;
    private final boolean OIndexScrollbar_DEBUG;
    private final String OIndexScrollbar_TAG;
    private final int POUND_POSITION_BOTTOM;
    private final int POUND_POSITION_TOP;
    private final int STATE_END;
    private final int STATE_MOVE;
    private final int STATE_START;
    private final int SURNAME_NUM_COLUMNS_THRESHOLD;
    private final int SURNAME_NUM_ROWS_THRESHOLD;
    private final int VISIBILITY_LIMIT;
    private String lastVibratedLetter;
    private AlphabetsAdapter mAlphabetsAdapter;
    private final int mColumnCount;
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
    private int mLetterbarShadowWidth;
    private final List<com.obric.oui.indexscrollbar.b> mLetters;
    private LettersBar mLettersBar;
    private int mLettersBarOccupiedWidth;
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
    private b mQBListener;
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
    private c mSurnameListener;
    private int[] mSymbols;
    private int mWidth;

    /* JADX INFO: compiled from: OIndexScrollbar.kt */
    public final class AlphabetsAdapter extends BaseAdapter {
        private String[] mAlphabets;
        private final Context mContext;
        private final String mCurrentLanguage;
        private final float mNumRows;
        private final int mTotalVerticalSpacing;
        final /* synthetic */ OIndexScrollbar this$0;

        @Override // android.widget.Adapter
        public long getItemId(int r1) {
            return r1;
        }

        public AlphabetsAdapter(OIndexScrollbar r3, Context r4) {
            Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
            o.e(r3, "this$0");
            this.this$0 = r3;
            this.mContext = ZeusTransformUtils.wrapperContext(r5, "com.obric.aiagent.plugin");
            String r6 = Locale.getDefault().getLanguage();
            o.c(r6, "getDefault().language");
            this.mCurrentLanguage = r6;
            float r7 = com.obric.oui.indexscrollbar.a.f35302a.a(r6);
            this.mNumRows = r7;
            int r8 = ((int) Math.ceil(r7)) - 1;
            GridView r9 = OIndexScrollbar.access$getMGridView$p(r3);
            o.a(r9);
            this.mTotalVerticalSpacing = r8 * r9.getVerticalSpacing();
        }

        @Override // android.widget.Adapter
        public /* bridge */ /* synthetic */ Object getItem(int r1) {
            return getItem(r1);
        }

        public final void setAlphabets(String[] r1) {
            if (r1 == null) goto L5;
            this.mAlphabets = r1;
            return;
        }

        @Override // android.widget.BaseAdapter, android.widget.ListAdapter
        public boolean isEnabled(int r5) {
            com.obric.oui.indexscrollbar.a r0 = com.obric.oui.indexscrollbar.a.f35302a;
            String[] r1 = this.mAlphabets;
            String[] r2 = null;
            if (r1 != null) goto L6;
            o.c("mAlphabets");
            r1 = null;
        L6:
            if (r0.f(r1[r5]) == true) goto L14;
            com.obric.oui.indexscrollbar.a r3 = com.obric.oui.indexscrollbar.a.f35302a;
            String[] r4 = this.mAlphabets;
            if (r4 != null) goto L10;
            o.c("mAlphabets");
        L12:
            if (r3.g(r2[r5]) == true) goto L14;
            return true;
        L10:
            r2 = r4;
        L14:
            return false;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.mAlphabets != null) goto L5;
            o.c("mAlphabets");
        L5:
            String[] r2 = this.mAlphabets;
            if (r2 != null) goto L9;
            o.c("mAlphabets");
            r2 = null;
        L9:
            return r2.length;
        }

        @Override // android.widget.Adapter
        public String getItem(int r1) {
            String[] r0 = this.mAlphabets;
            if (r0 != null) goto L6;
            o.c("mAlphabets");
            r0 = null;
        L6:
            return r0[r1];
        }

        private final boolean isNeedIncreaseHeight() {
            if (((int) ((OIndexScrollbar.access$getMMeasuredHeight$p(this.this$0) - this.mTotalVerticalSpacing) % this.mNumRows)) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        private final int getSingleCellHeight() {
            return (int) ((OIndexScrollbar.access$getMMeasuredHeight$p(this.this$0) - this.mTotalVerticalSpacing) / this.mNumRows);
        }

        private final boolean isNeedInsreaseHeightPosition(int r3) {
            if (r3 != (getCount() - 1)) goto L5;
            return true;
        L5:
            if (r3 != (getCount() - 2)) goto L7;
            return true;
        L7:
            if (r3 == (getCount() - 3)) goto L13;
            return false;
        L13:
            return true;
        }

        @Override // android.widget.Adapter
        public View getView(int r13, View r14, ViewGroup r15) {
            o.e(r15, "parent");
            String[] r16 = this.mAlphabets;
            if (r16 != null) goto L5;
            o.c("mAlphabets");
            r16 = null;
        L5:
            String r17 = r16[r13];
            int r1 = getSingleCellHeight();
            float r2 = OIndexScrollbar.access$getMMeasuredHeight$p(this.this$0) - this.mTotalVerticalSpacing;
            float r4 = this.mNumRows;
            int r3 = (int) (r2 - (r1 * r4));
            if (r4 != 9.0f) goto L8;
            boolean r5 = true;
        L9:
            if (r5 == false) goto L16;
            if (isNeedIncreaseHeight() == false) goto L16;
            if (isNeedInsreaseHeightPosition(r13) == false) goto L16;
            r1 = r1 + r3;
        L16:
            if (r14 != null) goto L31;
            if (com.obric.oui.indexscrollbar.a.f35302a.e(r17) == false) goto L20;
            ImageView r18 = new ImageView(this.mContext);
            r18.setImageResource(ZeusTransformUtils.mapRes(R.drawable.letter_bar_unfold_button, "drawable", "letter_bar_unfold_button"));
            r18.setScaleType(ImageView.ScaleType.CENTER);
            r18.setMinimumHeight(r1);
            r14 = (View) ZeusTransformUtils.preCheckCast(r18, View.class, "com.obric.aiagent.plugin");
            goto L31
        L20:
            TextView r19 = (TextView) ZeusTransformUtils.preCheckCast(new AlphabetView(this.mContext, null, 0, 6, null), TextView.class, "com.obric.aiagent.plugin");
            r19.setHeight(r1);
            if (com.obric.oui.indexscrollbar.a.f35302a.g(r17) == false) goto L24;
            r19.setTextColor(Color.parseColor("#80000000"));
            r17 = r17.substring(1);
            o.c(r17, "this as java.lang.String).substring(startIndex)");
        L24:
            if (com.obric.oui.indexscrollbar.a.f35302a.f(r17) == true) goto L27;
            r19.setText((CharSequence) ZeusTransformUtils.preCheckCast(r17, CharSequence.class, "com.obric.aiagent.plugin"));
        L27:
            if (com.obric.oui.indexscrollbar.a.f35302a.h(r17) == false) goto L29;
            r19.setTypeface(null, 0);
        L29:
            r14 = (View) ZeusTransformUtils.preCheckCast(r19, View.class, "com.obric.aiagent.plugin");
        L31:
            if (((r13 / 3) % 2) != 0) goto L33;
            Context r12 = this.mContext;
            o.a(r12);
            Drawable r110 = ZeusTransformUtils.getResources(r12, "com.obric.aiagent.plugin").getDrawable(ZeusTransformUtils.mapRes(R.drawable.quickbar_ex_alphabet_text_light_colorlist, "drawable", "quickbar_ex_alphabet_text_light_colorlist"));
        L34:
            r14.setBackground(r110);
            return r14;
        L33:
            Context r111 = this.mContext;
            o.a(r111);
            r110 = ZeusTransformUtils.getResources(r111, "com.obric.aiagent.plugin").getDrawable(ZeusTransformUtils.mapRes(R.drawable.quickbar_ex_alphabet_text_dark_colorlist, "drawable", "quickbar_ex_alphabet_text_dark_colorlist"));
            goto L34
        L8:
            r5 = false;
            goto L9
        }
    }

    /* JADX INFO: compiled from: OIndexScrollbar.kt */
    private final class SurnameAdapter extends BaseAdapter {
        private final Context context;
        private final List<String> surnames;
        final /* synthetic */ OIndexScrollbar this$0;

        @Override // android.widget.Adapter
        public long getItemId(int r1) {
            return 0;
        }

        public SurnameAdapter(OIndexScrollbar r3, Context r4, List<String> r5) {
            Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
            List<String> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
            o.e(r3, "this$0");
            this.this$0 = r3;
            this.context = ZeusTransformUtils.wrapperContext(r6, "com.obric.aiagent.plugin");
            this.surnames = r7;
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
        public Object getItem(int r2) {
            List<String> r1 = this.surnames;
            if (r1 != null) goto L5;
            String r3 = null;
        L6:
            o.a(r3);
            return r3;
        L5:
            r3 = (String) ZeusTransformUtils.preCheckCast(r1.get(r2), String.class, "com.obric.aiagent.plugin");
            goto L6
        }

        @Override // android.widget.Adapter
        public View getView(int r4, View r5, ViewGroup r6) {
            o.e(r6, "parent");
            if (r5 != null) goto L5;
            r5 = ZeusTransformUtils.inflate(LayoutInflater.from(this.context), ZeusTransformUtils.mapRes(R.layout.o_surname_popup_item_ex, "layout", "o_surname_popup_item_ex"), null, "com.obric.aiagent.plugin");
            r5.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new AbsListView.LayoutParams(OIndexScrollbar.access$getMSurnameGridViewItemWidth$p(this.this$0), OIndexScrollbar.access$getMSurnameGridViewItemHeight$p(this.this$0)), ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
        L5:
            int r0 = r4 % OIndexScrollbar.access$getMSurnameGridViewColumnsThreshold$p(this.this$0);
            if (r0 == 0) goto L8;
        L12:
            if (r0 != 0) goto L17;
            if (r5 == null) goto L27;
            r5.setBackgroundResource(ZeusTransformUtils.mapRes(R.drawable.surname_popup_item_right, "drawable", "surname_popup_item_right"));
        L27:
            Objects.requireNonNull(r5, "null cannot be cast to non-null type android.widget.TextView");
            TextView r1 = (TextView) ZeusTransformUtils.preCheckCast(r5, TextView.class, "com.obric.aiagent.plugin");
            List<String> r3 = this.surnames;
            o.a(r3);
            r1.setText((CharSequence) ZeusTransformUtils.preCheckCast(((String) ZeusTransformUtils.preCheckCast(r3.get(r4), String.class, "com.obric.aiagent.plugin")).toString(), CharSequence.class, "com.obric.aiagent.plugin"));
            return r5;
        L17:
            if (r0 != (OIndexScrollbar.access$getMSurnameGridViewColumnsThreshold$p(this.this$0) - 1)) goto L19;
        L24:
            if (r5 == null) goto L27;
            r5.setBackgroundResource(ZeusTransformUtils.mapRes(R.drawable.surname_popup_item_left, "drawable", "surname_popup_item_left"));
            goto L27
        L19:
            if (r4 == (getCount() - 1)) goto L24;
            if (r5 == null) goto L27;
            r5.setBackgroundResource(ZeusTransformUtils.mapRes(R.drawable.surname_popup_item_middle, "drawable", "surname_popup_item_middle"));
            goto L27
        L8:
            if (r4 != (getCount() - 1)) goto L12;
            if (r5 == null) goto L27;
            r5.setBackgroundResource(ZeusTransformUtils.mapRes(R.drawable.surname_popup_item_special, "drawable", "surname_popup_item_special"));
            goto L27
        }
    }

    /* JADX INFO: compiled from: OIndexScrollbar.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: OIndexScrollbar.kt */
    public interface b {
        void a();

        boolean a(String r1, int r2);

        void b();
    }

    /* JADX INFO: compiled from: OIndexScrollbar.kt */
    public interface c {
        List<String> a(String r1);

        void b(String r1);
    }

    /* JADX INFO: compiled from: OIndexScrollbar.kt */
    public static final class d implements LettersBar.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OIndexScrollbar f35299a;

        d(OIndexScrollbar r1) {
            this.f35299a = r1;
        }

        @Override // com.obric.oui.indexscrollbar.LettersBar.b
        public boolean a(String r2, int r3) {
            OIndexScrollbar.access$setLastVibratedLetter$p(this.f35299a, r2);
            if (OIndexScrollbar.access$getMQBListener$p(this.f35299a) == null) goto L7;
            b r1 = OIndexScrollbar.access$getMQBListener$p(this.f35299a);
            o.a(r1);
            if (r1.a(r2, r3) == false) goto L7;
            return true;
        L7:
            return false;
        }
    }

    /* JADX INFO: compiled from: OIndexScrollbar.kt */
    public static final class e implements LettersBar.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OIndexScrollbar f35300a;

        e(OIndexScrollbar r1) {
            this.f35300a = r1;
        }

        @Override // com.obric.oui.indexscrollbar.LettersBar.c
        public void a(boolean r1) {
            OIndexScrollbar.access$setShadowVisible(this.f35300a, r1);
        }
    }

    /* JADX INFO: compiled from: OIndexScrollbar.kt */
    public static final class f implements SurnameGridView.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OIndexScrollbar f35301a;

        public static /* synthetic */ void lambda$u_cpZA2OQB8lwYAGw0OoVodEvWE(OIndexScrollbar r0) {
            a(r0);
        }

        f(OIndexScrollbar r1) {
            this.f35301a = r1;
        }

        @Override // com.obric.oui.indexscrollbar.SurnameGridView.a
        public void a(int r4) {
            if (r4 != (-1)) goto L5;
            Handler r5 = new Handler(Looper.getMainLooper());
            final OIndexScrollbar r3 = this.f35301a;
            r5.postDelayed(new $$Lambda$OIndexScrollbar$f$u_cpZA2OQB8lwYAGw0OoVodEvWE(r3), 100);
            return;
        L5:
            SurnameGridView r0 = OIndexScrollbar.access$getMPopupGridView$p(this.f35301a);
            o.a(r0);
            SurnameGridView r1 = OIndexScrollbar.access$getMPopupGridView$p(this.f35301a);
            o.a(r1);
            View r2 = r0.getChildAt(r4 - r1.getFirstVisiblePosition());
            o.c(r2, "mPopupGridView!!.getChil…etFirstVisiblePosition())");
            SurnameGridView r6 = OIndexScrollbar.access$getMPopupGridView$p(this.f35301a);
            o.a(r6);
            Object r7 = r6.getAdapter().getItem(r4);
            Objects.requireNonNull(r7, "null cannot be cast to non-null type kotlin.String");
            r2.setTag((String) ZeusTransformUtils.preCheckCast(r7, String.class, "com.obric.aiagent.plugin"));
            OIndexScrollbar.access$showSecondPopupWindow(this.f35301a, r2);
        }

        private static final void a(OIndexScrollbar r1) {
            o.e(r1, "this$0");
            OIndexScrollbar.access$showSecondPopupWindow(r1, null);
        }
    }

    static {
        Companion = new a(null);
    }

    public static /* synthetic */ boolean access$000(String r0, int r1) {
        return Log.isLoggable(r0, r1);
    }

    public static /* synthetic */ int access$001(String r0, String r1) {
        return Log.e(r0, r1);
    }

    public static /* synthetic */ int access$002(String r0, String r1) {
        return Log.d(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$GQ8NdoATk-d1fv1bwVtpK4MutQo, reason: not valid java name */
    public static /* synthetic */ void m1090lambda$GQ8NdoATkd1fv1bwVtpK4MutQo(OIndexScrollbar r0, AdapterView r1, View r2, int r3, long r4) {
        m1087initGridView$lambda2(r0, r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: lambda$HdsU6sFLUJSmA6H1ocPY-Fo67-g, reason: not valid java name */
    public static /* synthetic */ boolean m1091lambda$HdsU6sFLUJSmA6H1ocPYFo67g(OIndexScrollbar r0, View r1, MotionEvent r2) {
        return m1088initGridView$lambda3(r0, r1, r2);
    }

    public static /* synthetic */ void lambda$Jphieuf6Qd8inCKs5D9CwZELcJs(OIndexScrollbar r0, AdapterView r1, View r2, int r3, long r4) {
        m1094showGridPopupWindow$lambda10(r0, r1, r2, r3, r4);
    }

    public static /* synthetic */ boolean lambda$VNcMtYMUsAeFbwmoHzZoNp21JUc(OIndexScrollbar r0, AdapterView r1, View r2, int r3, long r4) {
        return m1089initGridView$lambda4(r0, r1, r2, r3, r4);
    }

    public static /* synthetic */ void lambda$oWTs8i3tcMMMHMNLbHw_Zsl7zcs(OIndexScrollbar r0, View r1) {
        m1092showFlowPopupWindow$lambda7(r0, r1);
    }

    public static /* synthetic */ boolean lambda$pD_j6uGb4vziMVkotCX0WWNCTpQ(OIndexScrollbar r0, TextView r1, View r2, MotionEvent r3) {
        return m1093showFlowPopupWindow$lambda8(r0, r1, r2, r3);
    }

    public /* synthetic */ OIndexScrollbar(Context r2, AttributeSet r3, int r4, h r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.aiagent.plugin");
        if ((r4 & 2) == 0) goto L5;
        r7 = null;
    L5:
        this(r6, r7);
    }

    public static final /* synthetic */ GridView access$getMGridView$p(OIndexScrollbar r0) {
        return r0.mGridView;
    }

    public static final /* synthetic */ int access$getMMeasuredHeight$p(OIndexScrollbar r0) {
        return r0.mMeasuredHeight;
    }

    public static final /* synthetic */ SurnameGridView access$getMPopupGridView$p(OIndexScrollbar r0) {
        return r0.mPopupGridView;
    }

    public static final /* synthetic */ b access$getMQBListener$p(OIndexScrollbar r0) {
        return r0.mQBListener;
    }

    public static final /* synthetic */ int access$getMSurnameGridViewColumnsThreshold$p(OIndexScrollbar r0) {
        return r0.mSurnameGridViewColumnsThreshold;
    }

    public static final /* synthetic */ int access$getMSurnameGridViewItemHeight$p(OIndexScrollbar r0) {
        return r0.mSurnameGridViewItemHeight;
    }

    public static final /* synthetic */ int access$getMSurnameGridViewItemWidth$p(OIndexScrollbar r0) {
        return r0.mSurnameGridViewItemWidth;
    }

    public static final /* synthetic */ void access$onHideLetterGridAnimationEnd(OIndexScrollbar r0) {
        r0.onHideLetterGridAnimationEnd();
    }

    public static final /* synthetic */ void access$onShowLetterGridAnimationEnd(OIndexScrollbar r0) {
        r0.onShowLetterGridAnimationEnd();
    }

    public static final /* synthetic */ void access$setLastVibratedLetter$p(OIndexScrollbar r0, String r1) {
        r0.lastVibratedLetter = r1;
    }

    public static final /* synthetic */ void access$setLettersBarBg(OIndexScrollbar r0, boolean r1) {
        r0.setLettersBarBg(r1);
    }

    public static final /* synthetic */ void access$setMIsPerformingHideAnim$p(OIndexScrollbar r0, boolean r1) {
        r0.mIsPerformingHideAnim = r1;
    }

    public static final /* synthetic */ void access$setMIsPerformingShowAnim$p(OIndexScrollbar r0, boolean r1) {
        r0.mIsPerformingShowAnim = r1;
    }

    public static final /* synthetic */ void access$setShadowVisible(OIndexScrollbar r0, boolean r1) {
        r0.setShadowVisible(r1);
    }

    public static final /* synthetic */ void access$showSecondPopupWindow(OIndexScrollbar r0, View r1) {
        r0.showSecondPopupWindow(r1);
    }

    public OIndexScrollbar(Context r6, AttributeSet r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r9 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r7, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r8, "context");
        super(r8, r9);
        this.OIndexScrollbar_TAG = "OIndexScrollbar";
        this.OIndexScrollbar_DEBUG = INVOKESTATIC_com_obric_oui_indexscrollbar_OIndexScrollbar_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_isLoggable("OIndexScrollbar", 3);
        this.STATE_START = 1;
        this.STATE_MOVE = 2;
        this.STATE_END = 3;
        this.mState = 1;
        this.mLetters = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        this.mPoundVisibility = true;
        this.POUND_POSITION_TOP = 1;
        this.POUND_POSITION_BOTTOM = 2;
        this.mPoundPosition = 2;
        this.SURNAME_NUM_COLUMNS_THRESHOLD = 8;
        this.SURNAME_NUM_ROWS_THRESHOLD = 8;
        this.mColumnCount = 3;
        this.DEFAULTX = -99999;
        this.mHostX = -99999;
        init(r8);
        this.VISIBILITY_LIMIT = 30;
        this.mPrePosition = -1;
        this.mLongPressEnabled = true;
    }

    public final String getOIndexScrollbar_TAG() {
        return this.OIndexScrollbar_TAG;
    }

    public final boolean getOIndexScrollbar_DEBUG() {
        return this.OIndexScrollbar_DEBUG;
    }

    public final int getPOUND_POSITION_TOP() {
        return this.POUND_POSITION_TOP;
    }

    public final int getPOUND_POSITION_BOTTOM() {
        return this.POUND_POSITION_BOTTOM;
    }

    public final int getVISIBILITY_LIMIT() {
        return this.VISIBILITY_LIMIT;
    }

    public final void setQBListener(b r3) {
        this.mQBListener = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.aiagent.plugin");
    }

    public final void setSurnameListener(c r3) {
        this.mSurnameListener = (c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.aiagent.plugin");
    }

    public final void initSpecialIcons(int[] r5, Bitmap[][] r6) {
        if (r5 == null) goto L26;
        if (r6 != null) goto L6;
        return;
    L6:
        if (r5.length != 0) goto L8;
        return;
    L8:
        if (((Object[]) ZeusTransformUtils.preCheckCast(r6, Object[].class, "com.obric.aiagent.plugin")).length == 0) goto L29;
        boolean r2 = true;
        if (r5.length != ((Object[]) ZeusTransformUtils.preCheckCast(r6, Object[].class, "com.obric.aiagent.plugin")).length) goto L13;
        boolean r0 = true;
    L14:
        if (r0 == false) goto L25;
        if (r6[0].length == 3) goto L19;
        r2 = false;
    L19:
        if (r2 == false) goto L23;
        this.mSymbols = r5;
        this.mIconsForSymbols = r6;
        initLetters();
        return;
    L23:
        throw new IllegalArgumentException("Paramer bitmaps[x][y], y must is 3 !!!".toString());
    L25:
        throw new IllegalArgumentException("The symbols.length must equals bitmaps.length !".toString());
    L13:
        r0 = false;
        goto L14
    L29:
        return;
    }

    public final void initSpecialSelectedIcons(Bitmap[] r3) {
        if (r3 == null) goto L21;
        int[] r0 = this.mSymbols;
        boolean r1 = false;
        if (r0 != null) goto L7;
    L9:
        if (r1 == true) goto L22;
        Integer r2 = Integer.valueOf(r3.length);
        int[] r4 = this.mSymbols;
        if (r4 != null) goto L14;
        Integer r5 = null;
    L16:
        if (o.a(r2, r5) == true) goto L19;
        INVOKESTATIC_com_obric_oui_indexscrollbar_OIndexScrollbar_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(this.OIndexScrollbar_TAG, "Selected icon bitmaps' size is not equal to symbols' size. They should be equal.");
        return;
    L19:
        LettersBar r6 = this.mLettersBar;
        o.a(r6);
        r6.setBitmapsSelected(r3);
        return;
    L14:
        r5 = Integer.valueOf(r4.length);
        goto L16
    L22:
        return;
    L7:
        if (r0.length != 0) goto L9;
        r1 = true;
        goto L9
    }

    public final void initLetters() {
        this.mLetters.clear();
        int[] r0 = this.mSymbols;
        int r1 = 0;
        if (r0 == null) goto L11;
        o.a(r0);
        int r2 = r0.length;
        int r3 = 0;
    L5:
        if (r3 >= r2) goto L10;
        int r4 = r3 + 1;
        List<com.obric.oui.indexscrollbar.b> r5 = this.mLetters;
        com.obric.oui.indexscrollbar.b.a r6 = com.obric.oui.indexscrollbar.b.f35307a;
        int[] r7 = this.mSymbols;
        o.a(r7);
        String r8 = String.valueOf(r7[r3]);
        Bitmap[][] r9 = this.mIconsForSymbols;
        if (r9 != null) goto L9;
        o.c("mIconsForSymbols");
        r9 = null;
    L9:
        r5.add(r6.a(r8, r9[r3]));
        r3 = r4;
        goto L5
    L10:
        int[] r10 = this.mSymbols;
        o.a(r10);
        int r11 = r10.length;
    L12:
        com.obric.oui.indexscrollbar.c r12 = com.obric.oui.indexscrollbar.c.f35312a;
        String r13 = Locale.getDefault().getLanguage();
        o.c(r13, "getDefault().language");
        String[] r14 = r12.a(r13);
        int r15 = r14.length - 1;
    L13:
        if (r1 >= r15) goto L20;
        int r16 = r1 + 1;
        com.obric.oui.indexscrollbar.c r17 = com.obric.oui.indexscrollbar.c.f35312a;
        String r18 = Locale.getDefault().getLanguage();
        o.c(r18, "getDefault().language");
        if (r17.a(r18, r1) == false) goto L17;
        this.mLetters.add(com.obric.oui.indexscrollbar.b.f35307a.b(r14[r1]));
    L18:
        r1 = r16;
        goto L13
    L17:
        this.mLetters.add(com.obric.oui.indexscrollbar.b.f35307a.a(r14[r1]));
        goto L18
    L20:
        if (this.mPoundVisibility == true) goto L22;
    L25:
        invalidate();
        return;
    L22:
        if (this.mPoundPosition != this.POUND_POSITION_TOP) goto L24;
        this.mLetters.add(r11, com.obric.oui.indexscrollbar.b.f35307a.a());
        goto L25
    L24:
        this.mLetters.add(com.obric.oui.indexscrollbar.b.f35307a.a());
        goto L25
    L11:
        r11 = 0;
        goto L12
    }

    public final void setPoundVisibility(boolean r1) {
        this.mPoundVisibility = r1;
    }

    public final void setPoundPosition(int r1) {
        this.mPoundPosition = r1;
    }

    public final boolean isLetterGridShow() {
        if (this.mIsPerformingShowAnim == false) goto L5;
    L8:
        return true;
    L5:
        if (this.mState == this.STATE_END) goto L8;
        return false;
    }

    public final boolean isLetterGridShown() {
        if (this.mState != this.STATE_END) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isLetterGridHide() {
        if (this.mIsPerformingHideAnim == false) goto L5;
    L8:
        return true;
    L5:
        if (this.mState == this.STATE_START) goto L8;
        return false;
    }

    public final boolean isLetterGridHidden() {
        if (this.mState != this.STATE_START) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isPerformingAnim() {
        if (this.mIsPerformingShowAnim == false) goto L5;
    L8:
        return true;
    L5:
        if (this.mIsPerformingHideAnim == true) goto L8;
        return false;
    }

    public final void hideLetterGrid() {
        hideLetterGrid(true);
    }

    public final void hideLetterGrid(boolean r2) {
        dismissPopupWindow();
        if (isLetterGridHide() == true) goto L8;
        if (r2 == false) goto L6;
        hideLetterGridWithAnim();
        return;
    L6:
        onHideLetterGridAnimationEnd();
        return;
    }

    public final void setLongPressEnabled(boolean r1) {
        this.mLongPressEnabled = r1;
    }

    public final void init(Context r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        o.e(r8, "context");
        Context r9 = ZeusTransformUtils.wrapperContext(r8, "com.obric.aiagent.plugin");
        this.mContext = r9;
        o.a(r9);
        Resources r10 = ZeusTransformUtils.getResources(r9, "com.obric.aiagent.plugin");
        ZeusTransformUtils.inflate(LayoutInflater.from(this.mContext), ZeusTransformUtils.mapRes(R.layout.o_index_scrollbar, "layout", "o_index_scrollbar"), (ViewGroup) ZeusTransformUtils.preCheckCast(this, ViewGroup.class, "com.obric.aiagent.plugin"), true, "com.obric.aiagent.plugin");
        this.mLettersBarOccupiedWidth = g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 22);
        int r0 = r10.getDimensionPixelOffset(ZeusTransformUtils.mapRes(R.dimen.bytedance_quickbar_grid_item_space, "dimen", "bytedance_quickbar_grid_item_space"));
        int r3 = r10.getDimensionPixelOffset(ZeusTransformUtils.mapRes(R.dimen.quickbar_ex_grid_column_width, "dimen", "quickbar_ex_grid_column_width"));
        this.mMinXDistance = r10.getDimensionPixelOffset(ZeusTransformUtils.mapRes(R.dimen.bytedance_quickbar_min_distance, "dimen", "bytedance_quickbar_min_distance"));
        this.mLetterbarShadowWidth = r10.getDrawable(ZeusTransformUtils.mapRes(R.drawable.letters_bar_background_shadow, "drawable", "letters_bar_background_shadow")).getIntrinsicWidth();
        int r1 = (r0 * 2) + this.mLettersBarOccupiedWidth;
        Context r11 = this.mContext;
        o.a(r11);
        this.mWidth = (r1 + (r3 * ZeusTransformUtils.getResources(r11, "com.obric.aiagent.plugin").getInteger(ZeusTransformUtils.mapRes(R.integer.bytedance_letterbar_gridview_column_num, WsChannelMultiProcessSharedProvider.INT_TYPE, "bytedance_letterbar_gridview_column_num")))) + this.mLetterbarShadowWidth;
        initLettersBar();
        initGridView();
        this.mShadowView = findViewById(ZeusTransformUtils.mapRes(R.id.iv_letter_bar_shadow, DbHelper.COL_ID, "iv_letter_bar_shadow"));
        setLettersBarBg(false);
    }

    private final void initLettersBar() {
        View r0 = findViewById(ZeusTransformUtils.mapRes(R.id.quickbar_left_letters_bar, DbHelper.COL_ID, "quickbar_left_letters_bar"));
        Objects.requireNonNull(r0, "null cannot be cast to non-null type com.obric.oui.indexscrollbar.LettersBar");
        LettersBar r1 = (LettersBar) ZeusTransformUtils.preCheckCast(r0, LettersBar.class, "com.obric.aiagent.plugin");
        this.mLettersBar = r1;
        o.a(r1);
        r1.setLetters(this.mLetters);
        LettersBar r2 = this.mLettersBar;
        o.a(r2);
        r2.setListener((LettersBar.b) ZeusTransformUtils.preCheckCast(new d(this), LettersBar.b.class, "com.obric.aiagent.plugin"));
        LettersBar r3 = this.mLettersBar;
        o.a(r3);
        r3.setOnBackgroundVisibleChangedListener((LettersBar.c) ZeusTransformUtils.preCheckCast(new e(this), LettersBar.c.class, "com.obric.aiagent.plugin"));
        initLetters();
    }

    private final void initGridView() {
        View r0 = findViewById(ZeusTransformUtils.mapRes(R.id.quickbar_right_grid_view, DbHelper.COL_ID, "quickbar_right_grid_view"));
        Objects.requireNonNull(r0, "null cannot be cast to non-null type android.widget.GridView");
        this.mGridView = (GridView) ZeusTransformUtils.preCheckCast(r0, GridView.class, "com.obric.aiagent.plugin");
        AlphabetsAdapter r1 = new AlphabetsAdapter(this, this.mContext);
        this.mAlphabetsAdapter = r1;
        o.a(r1);
        com.obric.oui.indexscrollbar.a r2 = com.obric.oui.indexscrollbar.a.f35302a;
        String r3 = Locale.getDefault().getLanguage();
        o.c(r3, "getDefault().language");
        r1.setAlphabets(r2.b(r3));
        GridView r4 = this.mGridView;
        o.a(r4);
        r4.setAdapter((ListAdapter) ZeusTransformUtils.preCheckCast(this.mAlphabetsAdapter, ListAdapter.class, "com.obric.aiagent.plugin"));
        GridView r5 = this.mGridView;
        o.a(r5);
        r5.setOnItemClickListener(new $$Lambda$OIndexScrollbar$GQ8NdoATkd1fv1bwVtpK4MutQo(this));
        GridView r6 = this.mGridView;
        o.a(r6);
        r6.setOnTouchListener(new $$Lambda$OIndexScrollbar$HdsU6sFLUJSmA6H1ocPYFo67g(this));
        GridView r7 = this.mGridView;
        o.a(r7);
        r7.setOnItemLongClickListener(new $$Lambda$OIndexScrollbar$VNcMtYMUsAeFbwmoHzZoNp21JUc(this));
    }

    /* JADX INFO: renamed from: initGridView$lambda-2, reason: not valid java name */
    private static final void m1087initGridView$lambda2(OIndexScrollbar r0, AdapterView r1, View r2, int r3, long r4) {
        o.e(r0, "this$0");
        com.obric.oui.indexscrollbar.a r5 = com.obric.oui.indexscrollbar.a.f35302a;
        AlphabetsAdapter r6 = r0.mAlphabetsAdapter;
        o.a(r6);
        if (r5.e(r6.getItem(r3)) == true) goto L7;
        b r7 = r0.mQBListener;
        o.a(r7);
        AlphabetsAdapter r8 = r0.mAlphabetsAdapter;
        o.a(r8);
        if (r7.a(r8.getItem(r3), 1) == false) goto L7;
        r0.invalidate();
    L7:
        r0.hideLetterGridWithAnim();
    }

    /* JADX INFO: renamed from: initGridView$lambda-3, reason: not valid java name */
    private static final boolean m1088initGridView$lambda3(OIndexScrollbar r1, View r2, MotionEvent r3) {
        o.e(r1, "this$0");
        if (r1.mState == r1.STATE_END) goto L5;
        return false;
    L5:
        if (r3.getAction() != 0) goto L14;
        PopupWindow r4 = r1.mPopupWindow;
        if (r4 == null) goto L15;
        o.a(r4);
        if (r4.isShowing() == false) goto L16;
        PopupWindow r5 = r1.mPopupWindow;
        o.a(r5);
        r5.dismiss();
        return true;
    L16:
        return false;
    L15:
        return false;
    L14:
        return false;
    }

    /* JADX INFO: renamed from: initGridView$lambda-4, reason: not valid java name */
    private static final boolean m1089initGridView$lambda4(OIndexScrollbar r0, AdapterView r1, View r2, int r3, long r4) {
        o.e(r0, "this$0");
        if (r0.mLongPressEnabled == true) goto L5;
        return false;
    L5:
        com.obric.oui.indexscrollbar.a r5 = com.obric.oui.indexscrollbar.a.f35302a;
        AlphabetsAdapter r6 = r0.mAlphabetsAdapter;
        o.a(r6);
        if (r5.e(r6.getItem(r3)) == true) goto L13;
        com.obric.oui.indexscrollbar.a r7 = com.obric.oui.indexscrollbar.a.f35302a;
        String r8 = Locale.getDefault().getLanguage();
        o.c(r8, "getDefault().language");
        if (r7.d(r8) != 1) goto L10;
        o.c(r2, "view");
        r0.showFlowPopupWindow(r2, r3);
    L11:
        r0.mHasPerformedLongPress = true;
        return true;
    L10:
        o.c(r2, "view");
        r0.showGridPopupWindow(r2, r3);
        goto L11
    L13:
        return false;
    }

    private final void setHostWidth(int r4) {
        int r0 = (r4 - this.mLettersBarOccupiedWidth) - this.mLetterbarShadowWidth;
        this.mStartX = r0;
        int r5 = r4 - this.mWidth;
        this.mEndX = r5;
        int r1 = this.mState;
        if (r1 != this.STATE_START) goto L6;
        float r6 = r0;
    L9:
        setX(r6);
        if (this.OIndexScrollbar_DEBUG == false) goto L12;
        INVOKESTATIC_com_obric_oui_indexscrollbar_OIndexScrollbar_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d(this.OIndexScrollbar_TAG, o.a("mStartX = ", Integer.valueOf(this.mStartX)));
    L12:
        invalidate();
        return;
    L6:
        if (r1 != this.STATE_END) goto L8;
        r6 = r5;
        goto L9
    L8:
        r6 = getX();
        goto L9
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int r3, int r4) {
        super.onMeasure(r3, r4);
        this.mMeasuredHeight = measureHeight(r4);
        int r5 = View.MeasureSpec.getSize(r3);
        ViewParent r6 = getParent();
        if (r6 == null) goto L7;
        int r7 = ((View) ZeusTransformUtils.preCheckCast(r6, View.class, "com.obric.aiagent.plugin")).getMeasuredWidth();
        if (r7 <= 0) goto L9;
        setHostWidth(r7);
    L9:
        if (this.OIndexScrollbar_DEBUG == false) goto L12;
        INVOKESTATIC_com_obric_oui_indexscrollbar_OIndexScrollbar_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d(this.OIndexScrollbar_TAG, "measure width:" + r5 + "  parentWidth:" + r7);
        return;
    L12:
        return;
    L7:
        r7 = 0;
        goto L9
    }

    private final int measureHeight(int r1) {
        return View.MeasureSpec.getSize(r1);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent r9) {
        o.e(r9, "event");
        com.obric.oui.indexscrollbar.a r0 = com.obric.oui.indexscrollbar.a.f35302a;
        String r1 = Locale.getDefault().getLanguage();
        o.c(r1, "getDefault().language");
        if (r0.c(r1) == false) goto L5;
        getParentxPos();
        int r2 = r9.getAction();
        r9.getX();
        r9.getY();
        float r3 = r9.getRawX() - this.mHostX;
        if (r2 == 0) goto L59;
        if (r2 == 1) goto L31;
        if (r2 == 2) goto L15;
        if (r2 == 3) goto L31;
    L71:
        boolean r4 = false;
    L72:
        if (r4 == false) goto L74;
        return true;
    L74:
        if (super.dispatchTouchEvent(r9) == false) goto L77;
        return true;
    L77:
        return false;
    L15:
        if (this.mHasPerformedLongPress == false) goto L17;
        onMoveInLongPressState(r9);
        goto L71
    L17:
        float r5 = this.mCurrentRawX;
        this.mLastRawX = r5;
        this.mCurrentRawX = r3;
        int r6 = this.mState;
        if (r6 != this.STATE_START) goto L21;
        int r7 = (r3 > this.mStartX ? 1 : (r3 == this.mStartX ? 0 : -1));
        goto L71
    L21:
        if (r6 == this.STATE_MOVE) goto L71;
        if (r6 != this.STATE_END) goto L71;
        if ((r3 - r5) <= this.mMinXDistance) goto L71;
        if (r5 <= this.mEndX) goto L71;
    L29:
        r4 = true;
    L31:
        if (this.mHasPerformedLongPress == false) goto L45;
        com.obric.oui.indexscrollbar.a r8 = com.obric.oui.indexscrollbar.a.f35302a;
        String r10 = Locale.getDefault().getLanguage();
        o.c(r10, "getDefault().language");
        if (r8.d(r10) != 1) goto L40;
        if (this.mPrePosition < 0) goto L44;
        SurnameFlowLayout r11 = this.mPopupFlowLayout;
        if (r11 == null) goto L44;
        o.a(r11);
        View r12 = r11.getChildAt(this.mPrePosition);
        o.c(r12, "mPopupFlowLayout!!.getChildAt(mPrePosition)");
        r12.setPressed(false);
        r12.performClick();
    L44:
        this.mPrePosition = -1;
        goto L71
    L40:
        if (this.mPrePosition < 0) goto L44;
        SurnameGridView r13 = this.mPopupGridView;
        if (r13 == null) goto L44;
        o.a(r13);
        View r14 = r13.getChildAt(this.mPrePosition);
        o.c(r14, "mPopupGridView!!.getChildAt(mPrePosition)");
        r14.setPressed(false);
        SurnameGridView r15 = this.mPopupGridView;
        o.a(r15);
        r15.performItemClick(r14, this.mPrePosition, -1);
        goto L44
    L45:
        this.mMissX = 0.0f;
        if (getX() != this.mStartX) goto L48;
        boolean r16 = true;
    L49:
        if (r16 == false) goto L52;
        setLettersBarBg(false);
        goto L71
    L52:
        if (this.mState != this.STATE_MOVE) goto L71;
        if ((this.mCurrentRawX - this.mLastRawX) <= 0.0f) goto L56;
    L58:
        hideLetterGridWithAnim();
        goto L29
    L56:
        if (getX() >= (getScreenWidth() - 150)) goto L58;
        showLetterGridWithAnim();
        goto L29
    L48:
        r16 = false;
        goto L49
    L59:
        this.mHasPerformedLongPress = false;
        OIndexScrollbar r17 = (OIndexScrollbar) ZeusTransformUtils.preCheckCast(this, OIndexScrollbar.class, "com.obric.aiagent.plugin");
        r17.mCurrentRawX = r3;
        r17.mLastRawX = r3;
        int r18 = this.mState;
        if (r18 != this.STATE_START) goto L62;
        this.mMissX = 0.0f;
    L62:
        int r19 = this.STATE_END;
        if (r18 != r19) goto L65;
        this.mMissX = r3 - this.mEndX;
    L65:
        if (r18 != r19) goto L71;
        PopupWindow r20 = this.mPopupWindow;
        if (r20 == null) goto L71;
        o.a(r20);
        if (r20.isShowing() == false) goto L71;
        PopupWindow r21 = this.mPopupWindow;
        o.a(r21);
        r21.dismiss();
        goto L71
    L5:
        return super.dispatchTouchEvent(r9);
    }

    private final void onMoveInLongPressState(MotionEvent r15) {
        PopupWindow r0 = this.mPopupWindow;
        if (r0 == null) goto L36;
        o.a(r0);
        if (r0.isShowing() == false) goto L40;
        int r1 = (int) r15.getRawX();
        int r16 = (int) r15.getRawY();
        com.obric.oui.indexscrollbar.a r2 = com.obric.oui.indexscrollbar.a.f35302a;
        String r3 = Locale.getDefault().getLanguage();
        o.c(r3, "getDefault().language");
        if (r2.d(r3) != 1) goto L24;
        SurnameFlowLayout r4 = this.mPopupFlowLayout;
        if (r4 == null) goto L37;
        int[] r5 = new int[2];
        o.a(r4);
        r4.getLocationOnScreen(r5);
        int r6 = -1;
        SurnameFlowLayout r8 = this.mPopupFlowLayout;
        o.a(r8);
        int r9 = r8.getChildCount();
        int r10 = 0;
    L12:
        if (r10 >= r9) goto L18;
        int r11 = r10 + 1;
        SurnameFlowLayout r12 = this.mPopupFlowLayout;
        o.a(r12);
        View r13 = r12.getChildAt(r10);
        o.c(r13, "mPopupFlowLayout!!.getChildAt(i)");
        Rect r14 = new Rect();
        r13.getHitRect(r14);
        if (r14.contains(r1 - r5[0], r16 - r5[1]) == true) goto L15;
        r10 = r11;
        goto L12
    L15:
        r6 = r10;
    L18:
        if (r6 >= 0) goto L20;
        SurnameFlowLayout r7 = this.mPopupFlowLayout;
        o.a(r7);
        View r17 = r7.getChildAt(this.mPrePosition);
        o.c(r17, "mPopupFlowLayout!!.getChildAt(mPrePosition)");
        r17.setPressed(false);
        showSecondPopupWindow(null);
    L23:
        this.mPrePosition = r6;
        return;
    L20:
        if (this.mPrePosition == r6) goto L23;
        SurnameFlowLayout r18 = this.mPopupFlowLayout;
        o.a(r18);
        View r19 = r18.getChildAt(this.mPrePosition);
        o.c(r19, "mPopupFlowLayout!!.getChildAt(mPrePosition)");
        r19.setPressed(false);
        showSecondPopupWindow(null);
        SurnameFlowLayout r110 = this.mPopupFlowLayout;
        o.a(r110);
        View r111 = r110.getChildAt(r6);
        o.c(r111, "mPopupFlowLayout!!.getChildAt(position)");
        r111.setPressed(true);
        CharSequence r20 = ((TextView) ZeusTransformUtils.preCheckCast(r111, TextView.class, "com.obric.aiagent.plugin")).getText();
        Objects.requireNonNull(r20, "null cannot be cast to non-null type kotlin.String");
        r111.setTag((String) ZeusTransformUtils.preCheckCast(r20, String.class, "com.obric.aiagent.plugin"));
        showSecondPopupWindow(r111);
        goto L23
    L37:
        return;
    L24:
        SurnameGridView r21 = this.mPopupGridView;
        if (r21 == null) goto L39;
        int[] r22 = new int[2];
        o.a(r21);
        r21.getLocationOnScreen(r22);
        int r23 = r1 - r22[0];
        int r112 = r16 - r22[1];
        SurnameGridView r24 = this.mPopupGridView;
        o.a(r24);
        int r113 = r24.pointToPosition(r23, r112);
        if (r113 >= 0) goto L29;
        SurnameGridView r25 = this.mPopupGridView;
        o.a(r25);
        View r26 = r25.getChildAt(this.mPrePosition);
        o.c(r26, "mPopupGridView!!.getChildAt(mPrePosition)");
        r26.setPressed(false);
        showSecondPopupWindow(null);
    L32:
        this.mPrePosition = r113;
        return;
    L29:
        if (this.mPrePosition == r113) goto L32;
        SurnameGridView r27 = this.mPopupGridView;
        o.a(r27);
        View r28 = r27.getChildAt(this.mPrePosition);
        o.c(r28, "mPopupGridView!!.getChildAt(mPrePosition)");
        r28.setPressed(false);
        showSecondPopupWindow(null);
        SurnameGridView r29 = this.mPopupGridView;
        o.a(r29);
        View r30 = r29.getChildAt(r113);
        o.c(r30, "mPopupGridView!!.getChildAt(position)");
        r30.setPressed(true);
        SurnameGridView r31 = this.mPopupGridView;
        o.a(r31);
        Object r32 = r31.getAdapter().getItem(r113);
        Objects.requireNonNull(r32, "null cannot be cast to non-null type kotlin.String");
        r30.setTag((String) ZeusTransformUtils.preCheckCast(r32, String.class, "com.obric.aiagent.plugin"));
        showSecondPopupWindow(r30);
        goto L32
    L39:
        return;
    L40:
        return;
    }

    private final void setState(int r2) {
        this.mState = r2;
        LettersBar r0 = this.mLettersBar;
        o.a(r0);
        if (r2 != this.STATE_START) goto L5;
        boolean r1 = true;
    L6:
        r0.setSettled(r1);
        return;
    L5:
        r1 = false;
        goto L6
    }

    private final void moveQuickBar(float r2, float r3) {
        float r4 = r2 - r3;
        int r5 = this.mStartX;
        if (r4 < r5) goto L5;
        setX(r5);
        setState(this.STATE_START);
        return;
    L5:
        int r6 = this.mEndX;
        if (r4 > r6) goto L9;
        setX(r6);
        setState(this.STATE_END);
        return;
    L9:
        if (r4 <= r6) goto L14;
        setX(r4);
        setState(this.STATE_MOVE);
        return;
    }

    private final void showLetterGridWithAnim() {
        b r0 = this.mQBListener;
        if (r0 == null) goto L5;
        o.a(r0);
        r0.a();
    L5:
        AnimatorSet r1 = new AnimatorSet();
        ObjectAnimator r2 = ObjectAnimator.ofPropertyValuesHolder(this, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat("x", new float[]{getX(), this.mEndX})});
        o.c(r2, "ofPropertyValuesHolder(this, pvhX)");
        r1.play((Animator) ZeusTransformUtils.preCheckCast(r2, Animator.class, "com.obric.aiagent.plugin"));
        r1.setDuration(200);
        r1.addListener((Animator.AnimatorListener) ZeusTransformUtils.preCheckCast(new C11971(this), Animator.AnimatorListener.class, "com.obric.aiagent.plugin"));
        r1.start();
    }

    private final void onShowLetterGridAnimationEnd() {
        setX(this.mEndX);
        setState(this.STATE_END);
        setLettersBarBg(true);
    }

    private final void hideLetterGridWithAnim() {
        dismissPopupWindow();
        AnimatorSet r0 = new AnimatorSet();
        ObjectAnimator r1 = ObjectAnimator.ofPropertyValuesHolder(this, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat("x", new float[]{getX(), this.mStartX})});
        o.c(r1, "ofPropertyValuesHolder(this, pvhX)");
        r0.play((Animator) ZeusTransformUtils.preCheckCast(r1, Animator.class, "com.obric.aiagent.plugin"));
        r0.setDuration(200);
        r0.addListener((Animator.AnimatorListener) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this), Animator.AnimatorListener.class, "com.obric.aiagent.plugin"));
        r0.start();
    }

    private final void onHideLetterGridAnimationEnd() {
        setState(this.STATE_START);
        setX(this.mStartX);
        setLettersBarBg(false);
    }

    private final void setLettersBarBg(boolean r2) {
        LettersBar r0 = this.mLettersBar;
        o.a(r0);
        r0.setShowBg(r2);
        setShadowVisible(r2);
    }

    private final void setShadowVisible(boolean r1) {
        View r0 = this.mShadowView;
        o.a(r0);
        if (r1 == false) goto L5;
        int r2 = 0;
    L6:
        r0.setVisibility(r2);
        return;
    L5:
        r2 = 4;
        goto L6
    }

    private final int getScreenWidth() {
        Point r0 = new Point();
        Context r3 = this.mContext;
        o.a(r3);
        Object r4 = r3.getSystemService("window");
        Objects.requireNonNull(r4, "null cannot be cast to non-null type android.view.WindowManager");
        ((WindowManager) ZeusTransformUtils.preCheckCast(r4, WindowManager.class, "com.obric.aiagent.plugin")).getDefaultDisplay().getSize(r0);
        return r0.x;
    }

    private final int dipToPx(double r3) {
        Context r2 = this.mContext;
        o.a(r2);
        return (int) ((r3 * ((double) ZeusTransformUtils.getResources(r2, "com.obric.aiagent.plugin").getDisplayMetrics().density)) + ((double) 0.5f));
    }

    private final void showFlowPopupWindow(View r25, int r26) {
        if (this.mSurnameListener == null) goto L97;
        com.obric.oui.indexscrollbar.a r2 = com.obric.oui.indexscrollbar.a.f35302a;
        String r3 = Locale.getDefault().getLanguage();
        o.c(r3, "getDefault().language");
        AlphabetsAdapter r4 = this.mAlphabetsAdapter;
        o.a(r4);
        if (r2.a(r3, r4.getItem(r26)) == true) goto L7;
        return;
    L7:
        c r5 = this.mSurnameListener;
        o.a(r5);
        AlphabetsAdapter r6 = this.mAlphabetsAdapter;
        o.a(r6);
        List<String> r7 = r5.a(r6.getItem(r26));
        if (r7 != null) goto L10;
        return;
    L10:
        if (r7.size() == 0) goto L102;
        String r8 = "layout";
        String r9 = "com.obric.aiagent.plugin";
        View r10 = ZeusTransformUtils.inflate(LayoutInflater.from(this.mContext), ZeusTransformUtils.mapRes(R.layout.o_surname_flow_popup, "layout", "o_surname_flow_popup"), null, "com.obric.aiagent.plugin");
        o.c(r10, "from(mContext).inflate(R…surname_flow_popup, null)");
        int r11 = R.id.surname_content;
        String r12 = DbHelper.COL_ID;
        View r13 = r10.findViewById(ZeusTransformUtils.mapRes(r11, DbHelper.COL_ID, "surname_content"));
        Objects.requireNonNull(r13, "null cannot be cast to non-null type com.obric.oui.indexscrollbar.SurnameFlowLayout");
        this.mPopupFlowLayout = (SurnameFlowLayout) ZeusTransformUtils.preCheckCast(r13, SurnameFlowLayout.class, "com.obric.aiagent.plugin");
        this.mPopupYOffset = dipToPx(7.0d);
        this.mPopupViewMaxHeight = dipToPx((this.SURNAME_NUM_ROWS_THRESHOLD * 33) + 19);
        this.mSurnameGridViewItemWidth = dipToPx(40.0d);
        this.mSurnameGridViewItemHeight = dipToPx(33.0d);
        this.mSurnameGridViewColumnsThreshold = this.SURNAME_NUM_COLUMNS_THRESHOLD;
        int r14 = dipToPx(98.0d);
        Drawable r15 = ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getDrawable(ZeusTransformUtils.mapRes(R.drawable.surname_popup_item_left, "drawable", "surname_popup_item_left"));
        int r16 = this.mSurnameGridViewColumnsThreshold * this.mSurnameGridViewItemWidth;
        Iterator<String> r17 = r7.iterator();
        int r18 = 1;
        int r19 = 0;
        int r110 = 0;
    L14:
        if (r17.hasNext() == false) goto L38;
        String r111 = (String) ZeusTransformUtils.preCheckCast(r17.next(), String.class, r9);
        Iterator<String> r21 = r17;
        View r20 = ZeusTransformUtils.inflate(LayoutInflater.from(this.mContext), ZeusTransformUtils.mapRes(R.layout.o_surname_popup_item_ex, r8, "o_surname_popup_item_ex"), null, r9);
        Objects.requireNonNull(r20, "null cannot be cast to non-null type android.widget.TextView");
        final TextView r22 = (TextView) ZeusTransformUtils.preCheckCast(r20, TextView.class, r9);
        r22.setText((CharSequence) ZeusTransformUtils.preCheckCast(r111, CharSequence.class, r9));
        ViewGroup.MarginLayoutParams r112 = new ViewGroup.MarginLayoutParams(-2, -2);
        r112.height = this.mSurnameGridViewItemHeight;
        r22.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r112, ViewGroup.LayoutParams.class, r9));
        String r23 = r8;
        String r113 = r9;
        String r114 = r12;
        r22.setPadding(dipToPx(10.0d), 0, dipToPx(10.0d), 0);
        if (r7.size() != 1) goto L18;
        r22.setBackgroundResource(ZeusTransformUtils.mapRes(R.drawable.surname_popup_item_special, "drawable", "surname_popup_item_special"));
    L19:
        int r24 = (int) Math.ceil(r22.getPaint().measureText(r111));
        if (r15 == null) goto L26;
        int r27 = r15.getIntrinsicWidth();
        if (r27 <= 0) goto L26;
        Drawable r115 = r15;
        double r28 = 20.0d;
        List<String> r29 = r7;
        if (r27 <= (r24 + dipToPx(20.0d))) goto L27;
        r24 = r27 - dipToPx(20.0d);
    L27:
        if (r24 <= r14) goto L29;
        r24 = r14;
    L29:
        int r30 = r24 + dipToPx(r28);
        if ((r110 + r30) <= r16) goto L33;
        r18 = r18 + 1;
        r110 = 0;
    L33:
        int r31 = r110 + r30;
        int r32 = r19;
        if (r32 <= r31) goto L36;
        r19 = r32;
    L37:
        r22.setOnClickListener(new $$Lambda$OIndexScrollbar$oWTs8i3tcMMMHMNLbHw_Zsl7zcs(this));
        r22.setOnTouchListener(new $$Lambda$OIndexScrollbar$pD_j6uGb4vziMVkotCX0WWNCTpQ(this, r22));
        SurnameFlowLayout r33 = this.mPopupFlowLayout;
        o.a(r33);
        r33.addView((View) ZeusTransformUtils.preCheckCast(r22, View.class, r113));
        r110 = r31;
        r9 = r113;
        r15 = r115;
        r12 = r114;
        r17 = r21;
        r8 = r23;
        r7 = r29;
        goto L14
    L36:
        r19 = r31;
    L26:
        r29 = r7;
        r115 = r15;
        r28 = 20.0d;
        goto L27
    L18:
        r22.setBackgroundResource(ZeusTransformUtils.mapRes(R.drawable.surname_popup_item_left, "drawable", "surname_popup_item_left"));
        goto L19
    L38:
        String r116 = r12;
        int r34 = r19;
        String r35 = r9;
        this.mSurnameGridViewNumRows = r18;
        SurnameFlowLayout r36 = this.mPopupFlowLayout;
        o.a(r36);
        r36.measure(0, 0);
        if (this.OIndexScrollbar_DEBUG == false) goto L41;
        INVOKESTATIC_com_obric_oui_indexscrollbar_OIndexScrollbar_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d(this.OIndexScrollbar_TAG, o.a("surname FlowLayout, width = ", Integer.valueOf(r34)));
        String r37 = this.OIndexScrollbar_TAG;
        SurnameFlowLayout r38 = this.mPopupFlowLayout;
        o.a(r38);
        INVOKESTATIC_com_obric_oui_indexscrollbar_OIndexScrollbar_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d(r37, o.a("surname FlowLayout, measuredHeight = ", Integer.valueOf(r38.getMeasuredHeight())));
    L41:
        SurnameFlowLayout r39 = this.mPopupFlowLayout;
        o.a(r39);
        ViewGroup.LayoutParams r40 = r39.getLayoutParams();
        Objects.requireNonNull(r40, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams r41 = (FrameLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r40, FrameLayout.LayoutParams.class, r35);
        r41.width = r34;
        SurnameFlowLayout r42 = this.mPopupFlowLayout;
        o.a(r42);
        r42.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r41, ViewGroup.LayoutParams.class, r35));
        if (this.mPopupWindow != null) goto L44;
        PopupWindow r43 = new PopupWindow();
        this.mPopupWindow = r43;
        o.a(r43);
        r43.setWindowLayoutMode(-2, -2);
        PopupWindow r44 = this.mPopupWindow;
        o.a(r44);
        r44.setBackgroundDrawable(ZeusTransformUtils.getResources(this, r35).getDrawable(ZeusTransformUtils.mapRes(R.color.Transparent, "color", "Transparent")));
        PopupWindow r45 = this.mPopupWindow;
        o.a(r45);
        r45.setClippingEnabled(true);
    L44:
        PopupWindow r46 = this.mPopupWindow;
        o.a(r46);
        r46.setContentView(r10);
        getLocationOnScreen(new int[2]);
        getLocationInWindow(new int[2]);
        int[] r47 = new int[2];
        r25.getLocationOnScreen(r47);
        int r117 = r47[0] + (r25.getWidth() / 2);
        int r118 = r47[1] + (r25.getHeight() / 2);
        if (this.OIndexScrollbar_DEBUG == false) goto L47;
        int r119 = 0;
        INVOKESTATIC_com_obric_oui_indexscrollbar_OIndexScrollbar_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d(this.OIndexScrollbar_TAG, "alphabet anchorX = " + r47[0] + ", anchorY = " + r47[1]);
    L48:
        r10.measure(r119, r119);
        int r48 = r10.getMeasuredWidth();
        int r49 = r10.getMeasuredHeight();
        if (this.OIndexScrollbar_DEBUG == false) goto L51;
        INVOKESTATIC_com_obric_oui_indexscrollbar_OIndexScrollbar_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d(this.OIndexScrollbar_TAG, "popMeasureWidth = " + r48 + ", popMeasureHeight = " + r49);
    L51:
        int r50 = this.mColumnCount;
        if (r26 >= r50) goto L56;
        boolean r120 = true;
        if (this.mSurnameGridViewNumRows <= 1) goto L57;
    L74:
        boolean r121 = r120;
    L77:
        if (r121 == false) goto L79;
        String r122 = r116;
        View r51 = r10.findViewById(ZeusTransformUtils.mapRes(R.id.surname_popup_top_arrow, r122, "surname_popup_top_arrow"));
        Objects.requireNonNull(r51, "null cannot be cast to non-null type android.widget.ImageView");
        ImageView r52 = (ImageView) ZeusTransformUtils.preCheckCast(r51, ImageView.class, r35);
        int r123 = r118 + this.mPopupYOffset;
    L80:
        r52.setVisibility(0);
        r52.measure(0, 0);
        int r53 = r52.getMeasuredWidth();
        if (this.OIndexScrollbar_DEBUG == false) goto L83;
        INVOKESTATIC_com_obric_oui_indexscrollbar_OIndexScrollbar_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d(this.OIndexScrollbar_TAG, o.a("arrowWidth = ", Integer.valueOf(r53)));
    L83:
        int r124 = r48 / 2;
        int r54 = (int) Math.min(getScreenWidth() - r117, r124);
        int r125 = r117 - r124;
        int r55 = (r48 - r54) - (r53 / 2);
        View r56 = r10.findViewById(ZeusTransformUtils.mapRes(R.id.surname_top_mask, r122, "surname_top_mask"));
        Objects.requireNonNull(r56, "null cannot be cast to non-null type android.widget.ImageView");
        ImageView r57 = (ImageView) ZeusTransformUtils.preCheckCast(r56, ImageView.class, r35);
        ViewGroup.LayoutParams r58 = r57.getLayoutParams();
        Objects.requireNonNull(r58, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams r59 = (FrameLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r58, FrameLayout.LayoutParams.class, r35);
        r59.width = r34;
        View r126 = r10.findViewById(ZeusTransformUtils.mapRes(R.id.surname_bottom_mask, r122, "surname_bottom_mask"));
        Objects.requireNonNull(r126, "null cannot be cast to non-null type android.widget.ImageView");
        ImageView r1 = (ImageView) ZeusTransformUtils.preCheckCast(r126, ImageView.class, r35);
        ViewGroup.LayoutParams r127 = r1.getLayoutParams();
        Objects.requireNonNull(r127, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams r128 = (FrameLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r127, FrameLayout.LayoutParams.class, r35);
        r128.width = r34;
        View r60 = r10.findViewById(ZeusTransformUtils.mapRes(R.id.surname_container, r122, "surname_container"));
        Objects.requireNonNull(r60, "null cannot be cast to non-null type android.widget.LinearLayout");
        LinearLayout r61 = (LinearLayout) ZeusTransformUtils.preCheckCast(r60, LinearLayout.class, r35);
        ViewGroup.LayoutParams r129 = r61.getLayoutParams();
        Objects.requireNonNull(r129, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams r62 = (FrameLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r129, FrameLayout.LayoutParams.class, r35);
        SurnameFlowLayout r130 = this.mPopupFlowLayout;
        o.a(r130);
        int r131 = r130.getMeasuredHeight();
        int r132 = this.mPopupViewMaxHeight;
        if (r131 <= r132) goto L86;
        r62.height = r132;
    L86:
        r61.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r62, ViewGroup.LayoutParams.class, r35));
        if (r34 != (this.mSurnameGridViewColumnsThreshold * this.mSurnameGridViewItemWidth)) goto L89;
        r61.setPadding(dipToPx(14.0d), dipToPx(1.5d), dipToPx(17.0d), dipToPx(4.0d));
        r55 = r55 + ZeusTransformUtils.getResources(this, r35).getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.surname_arrow_offset_x, "dimen", "surname_arrow_offset_x"));
        r59.leftMargin = dipToPx(20.0d);
        r128.leftMargin = dipToPx(20.0d);
        r59.width -= dipToPx(10.0d);
        r128.width -= dipToPx(10.0d);
    L90:
        r57.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r59, ViewGroup.LayoutParams.class, r35));
        r1.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r128, ViewGroup.LayoutParams.class, r35));
        r52.setTranslationX(r55);
        if (Math.abs(getX() - this.mEndX) <= dipToPx(1.0d)) goto L94;
        INVOKESTATIC_com_obric_oui_indexscrollbar_OIndexScrollbar_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d(this.OIndexScrollbar_TAG, "GridView is hiding now...");
        return;
    L94:
        PopupWindow r63 = this.mPopupWindow;
        o.a(r63);
        r63.showAtLocation((View) ZeusTransformUtils.preCheckCast(this, View.class, r35), 0, r125, r123);
        return;
    L89:
        r125 = r125 - 1;
        goto L90
    L79:
        r122 = r116;
        View r64 = r10.findViewById(ZeusTransformUtils.mapRes(R.id.surname_popup_bottom_arrow, r122, "surname_popup_bottom_arrow"));
        Objects.requireNonNull(r64, "null cannot be cast to non-null type android.widget.ImageView");
        ImageView r65 = (ImageView) ZeusTransformUtils.preCheckCast(r64, ImageView.class, r35);
        r123 = (r118 - r49) - this.mPopupYOffset;
        r52 = r65;
    L57:
        if (r26 < r50) goto L63;
        if (r26 >= (r50 * 2)) goto L63;
        if (this.mSurnameGridViewNumRows > 3) goto L74;
    L63:
        if (r26 < (r50 * 2)) goto L69;
        if (r26 >= (r50 * 3)) goto L69;
        if (this.mSurnameGridViewNumRows > 5) goto L74;
    L69:
        if (r26 >= (r50 * 3)) goto L71;
    L75:
        r121 = false;
        goto L77
    L71:
        if (r26 >= (r50 * 4)) goto L75;
        if (this.mSurnameGridViewNumRows <= 7) goto L75;
    L56:
        r120 = true;
        goto L57
    L47:
        r119 = 0;
        goto L48
    L102:
        return;
    L97:
        throw new IllegalArgumentException("You must implements SurnameListener".toString());
    }

    /* JADX INFO: renamed from: showFlowPopupWindow$lambda-7, reason: not valid java name */
    private static final void m1092showFlowPopupWindow$lambda7(OIndexScrollbar r2, View r3) {
        o.e(r2, "this$0");
        Objects.requireNonNull(r3, "null cannot be cast to non-null type android.widget.TextView");
        String r4 = ((TextView) ZeusTransformUtils.preCheckCast(r3, TextView.class, "com.obric.aiagent.plugin")).getText().toString();
        c r0 = r2.mSurnameListener;
        o.a(r0);
        r0.b(r4);
        r2.hideLetterGrid();
    }

    /* JADX INFO: renamed from: showFlowPopupWindow$lambda-8, reason: not valid java name */
    private static final boolean m1093showFlowPopupWindow$lambda8(OIndexScrollbar r1, TextView r2, View r3, MotionEvent r4) {
        o.e(r1, "this$0");
        o.e(r2, "$surnameView");
        if (r4.getAction() == 0) goto L9;
        if (r4.getAction() == 2) goto L9;
        r1.showSecondPopupWindow(null);
        return false;
    L9:
        if (r1.mSecondPopup != null) goto L11;
    L15:
        r3.setTag(r2.getText());
        r1.showSecondPopupWindow(r3);
        return false;
    L11:
        if (r1.mSecondPopupView == null) goto L15;
        CharSequence r5 = r2.getText();
        TextView r0 = r1.mSecondPopupView;
        o.a(r0);
        if (o.a(r5, r0.getText()) == true) goto L15;
        PopupWindow r6 = r1.mSecondPopup;
        o.a(r6);
        r6.dismiss();
        goto L15
    }

    private final void showGridPopupWindow(View r19, int r20) {
        if (this.mSurnameListener == null) goto L83;
        com.obric.oui.indexscrollbar.a r2 = com.obric.oui.indexscrollbar.a.f35302a;
        String r3 = Locale.getDefault().getLanguage();
        o.c(r3, "getDefault().language");
        AlphabetsAdapter r4 = this.mAlphabetsAdapter;
        o.a(r4);
        if (r2.a(r3, r4.getItem(r20)) == true) goto L7;
        return;
    L7:
        c r5 = this.mSurnameListener;
        o.a(r5);
        AlphabetsAdapter r6 = this.mAlphabetsAdapter;
        o.a(r6);
        List<String> r7 = r5.a(r6.getItem(r20));
        if (r7 != null) goto L10;
        return;
    L10:
        if (r7.size() == 0) goto L85;
        SurnameAdapter r8 = new SurnameAdapter(this, this.mContext, r7);
        View r9 = ZeusTransformUtils.inflate(LayoutInflater.from(this.mContext), ZeusTransformUtils.mapRes(R.layout.o_surname_popup, "layout", "o_surname_popup"), null, "com.obric.aiagent.plugin");
        o.c(r9, "from(mContext).inflate(R…ut.o_surname_popup, null)");
        View r10 = r9.findViewById(ZeusTransformUtils.mapRes(R.id.surname_content, DbHelper.COL_ID, "surname_content"));
        Objects.requireNonNull(r10, "null cannot be cast to non-null type com.obric.oui.indexscrollbar.SurnameGridView");
        this.mPopupGridView = (SurnameGridView) ZeusTransformUtils.preCheckCast(r10, SurnameGridView.class, "com.obric.aiagent.plugin");
        this.mPopupYOffset = dipToPx(7.0d);
        this.mSurnameGridViewItemHeight = dipToPx(33.0d);
        this.mPopupViewMaxHeight = dipToPx((this.SURNAME_NUM_ROWS_THRESHOLD * 33) + 19);
        this.mPopupViewPendingVertical = dipToPx(16.0d);
        this.mPopupViewPendingHorizontal = dipToPx(6.0d);
        this.mSurnameGridViewColumnsThreshold = this.SURNAME_NUM_COLUMNS_THRESHOLD;
        this.mSurnameGridViewItemWidth = dipToPx(40.0d);
        int r11 = r7.size();
        int r12 = this.mSurnameGridViewColumnsThreshold;
        if (r11 >= r12) goto L16;
        r12 = r7.size();
    L16:
        this.mSurnameGridViewNumColumns = r12;
        int r13 = (int) Math.ceil((((double) r7.size()) * 1.0d) / ((double) this.mSurnameGridViewNumColumns));
        this.mSurnameGridViewNumRows = r13;
        int r14 = (this.mSurnameGridViewNumColumns * this.mSurnameGridViewItemWidth) + (this.mPopupViewPendingHorizontal * 2);
        if (r13 <= this.SURNAME_NUM_ROWS_THRESHOLD) goto L19;
        int r15 = this.mPopupViewMaxHeight;
    L20:
        int r16 = r15 + (this.mPopupViewPendingVertical * 2);
        if (this.OIndexScrollbar_DEBUG == false) goto L23;
        INVOKESTATIC_com_obric_oui_indexscrollbar_OIndexScrollbar_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d(this.OIndexScrollbar_TAG, "surname GridView, width = " + r14 + ", height = " + r16);
    L23:
        SurnameGridView r17 = this.mPopupGridView;
        o.a(r17);
        r17.setNumColumns(this.mSurnameGridViewNumColumns);
        SurnameGridView r18 = this.mPopupGridView;
        o.a(r18);
        r18.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new LinearLayout.LayoutParams(r14, r16), ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
        SurnameGridView r21 = this.mPopupGridView;
        o.a(r21);
        r21.setGravity(17);
        SurnameGridView r22 = this.mPopupGridView;
        o.a(r22);
        r22.setAdapter((ListAdapter) ZeusTransformUtils.preCheckCast(r8, ListAdapter.class, "com.obric.aiagent.plugin"));
        SurnameGridView r23 = this.mPopupGridView;
        o.a(r23);
        r23.setOnPressChangeListener((SurnameGridView.a) ZeusTransformUtils.preCheckCast(new f(this), SurnameGridView.a.class, "com.obric.aiagent.plugin"));
        SurnameGridView r24 = this.mPopupGridView;
        o.a(r24);
        r24.setOnItemClickListener(new $$Lambda$OIndexScrollbar$Jphieuf6Qd8inCKs5D9CwZELcJs(this));
        boolean r25 = true;
        if (this.mPopupWindow != null) goto L26;
        PopupWindow r26 = new PopupWindow();
        this.mPopupWindow = r26;
        o.a(r26);
        r26.setWindowLayoutMode(-2, -2);
        PopupWindow r27 = this.mPopupWindow;
        o.a(r27);
        r27.setBackgroundDrawable(ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getDrawable(ZeusTransformUtils.mapRes(R.color.Transparent, "color", "Transparent")));
        PopupWindow r28 = this.mPopupWindow;
        o.a(r28);
        r28.setClippingEnabled(true);
    L26:
        PopupWindow r29 = this.mPopupWindow;
        o.a(r29);
        r29.setContentView(r9);
        getLocationOnScreen(new int[2]);
        getLocationInWindow(new int[2]);
        int[] r30 = new int[2];
        r19.getLocationOnScreen(r30);
        if (this.OIndexScrollbar_DEBUG == false) goto L29;
        INVOKESTATIC_com_obric_oui_indexscrollbar_OIndexScrollbar_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d(this.OIndexScrollbar_TAG, "alphabetView.getWidth = " + r19.getWidth() + ", alphabetView.getHeight = " + r19.getHeight());
    L29:
        int r110 = r30[0] + (r19.getWidth() / 2);
        int r111 = r30[1] + (r19.getHeight() / 2);
        if (this.OIndexScrollbar_DEBUG == false) goto L32;
        INVOKESTATIC_com_obric_oui_indexscrollbar_OIndexScrollbar_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d(this.OIndexScrollbar_TAG, "alphabet anchorX = " + r30[0] + ", anchorY = " + r30[1]);
    L32:
        r9.measure(0, 0);
        int r31 = r9.getMeasuredWidth();
        int r32 = r9.getMeasuredHeight();
        if (this.OIndexScrollbar_DEBUG == false) goto L35;
        INVOKESTATIC_com_obric_oui_indexscrollbar_OIndexScrollbar_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d(this.OIndexScrollbar_TAG, "popMeasureWidth = " + r31 + ", popMeasureHeight = " + r32);
    L35:
        int r33 = this.mColumnCount;
        if (r20 < r33) goto L38;
    L39:
        if (r20 < r33) goto L45;
        if (r20 >= (r33 * 2)) goto L45;
        if (this.mSurnameGridViewNumRows <= 3) goto L45;
    L59:
        if (r25 == false) goto L61;
        View r34 = r9.findViewById(ZeusTransformUtils.mapRes(R.id.surname_popup_top_arrow, DbHelper.COL_ID, "surname_popup_top_arrow"));
        Objects.requireNonNull(r34, "null cannot be cast to non-null type android.widget.ImageView");
        ImageView r35 = (ImageView) ZeusTransformUtils.preCheckCast(r34, ImageView.class, "com.obric.aiagent.plugin");
        int r112 = r111 + this.mPopupYOffset;
    L62:
        r35.setVisibility(0);
        r35.measure(0, 0);
        int r36 = r35.getMeasuredWidth();
        if (this.OIndexScrollbar_DEBUG == false) goto L65;
        INVOKESTATIC_com_obric_oui_indexscrollbar_OIndexScrollbar_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d(this.OIndexScrollbar_TAG, o.a("arrowWidth = ", Integer.valueOf(r36)));
    L65:
        int r113 = r31 / 2;
        int r37 = r110 - r113;
        int r38 = r36 / 2;
        int r39 = (r31 - ((int) Math.min(getScreenWidth() - r110, r113))) - r38;
        View r40 = r9.findViewById(ZeusTransformUtils.mapRes(R.id.surname_top_mask, DbHelper.COL_ID, "surname_top_mask"));
        Objects.requireNonNull(r40, "null cannot be cast to non-null type android.widget.ImageView");
        ImageView r41 = (ImageView) ZeusTransformUtils.preCheckCast(r40, ImageView.class, "com.obric.aiagent.plugin");
        ViewGroup.LayoutParams r114 = r41.getLayoutParams();
        Objects.requireNonNull(r114, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams r115 = (FrameLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r114, FrameLayout.LayoutParams.class, "com.obric.aiagent.plugin");
        r115.width = this.mSurnameGridViewNumColumns * this.mSurnameGridViewItemWidth;
        View r116 = r9.findViewById(ZeusTransformUtils.mapRes(R.id.surname_bottom_mask, DbHelper.COL_ID, "surname_bottom_mask"));
        Objects.requireNonNull(r116, "null cannot be cast to non-null type android.widget.ImageView");
        ImageView r1 = (ImageView) ZeusTransformUtils.preCheckCast(r116, ImageView.class, "com.obric.aiagent.plugin");
        ViewGroup.LayoutParams r117 = r1.getLayoutParams();
        Objects.requireNonNull(r117, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams r118 = (FrameLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r117, FrameLayout.LayoutParams.class, "com.obric.aiagent.plugin");
        r118.width = this.mSurnameGridViewNumColumns * this.mSurnameGridViewItemWidth;
        View r42 = r9.findViewById(ZeusTransformUtils.mapRes(R.id.surname_container, DbHelper.COL_ID, "surname_container"));
        Objects.requireNonNull(r42, "null cannot be cast to non-null type android.widget.LinearLayout");
        LinearLayout r43 = (LinearLayout) ZeusTransformUtils.preCheckCast(r42, LinearLayout.class, "com.obric.aiagent.plugin");
        int r44 = this.mSurnameGridViewNumColumns;
        int r119 = this.mSurnameGridViewColumnsThreshold;
        if (r44 != r119) goto L72;
        int r45 = this.SURNAME_NUM_COLUMNS_THRESHOLD;
        ImageView r120 = r41;
        if (r119 != r45) goto L70;
        r43.setPadding(dipToPx(14.0d), dipToPx(1.5d), dipToPx(17.0d), dipToPx(4.0d));
        r39 = r39 + ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.surname_arrow_offset_x, "dimen", "surname_arrow_offset_x"));
        r115.leftMargin = dipToPx(20.0d);
        r118.leftMargin = dipToPx(20.0d);
    L71:
        int r46 = r37;
    L74:
        if (this.OIndexScrollbar_DEBUG == false) goto L76;
        INVOKESTATIC_com_obric_oui_indexscrollbar_OIndexScrollbar_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d(this.OIndexScrollbar_TAG, o.a("arrowTranslationX = ", Integer.valueOf(r39)));
    L76:
        r35.setTranslationX(r39);
        r120.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r115, ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
        r1.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r118, ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
        if (Math.abs(getX() - this.mEndX) <= dipToPx(1.0d)) goto L80;
        INVOKESTATIC_com_obric_oui_indexscrollbar_OIndexScrollbar_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d(this.OIndexScrollbar_TAG, "GridView is hiding now...");
        return;
    L80:
        PopupWindow r47 = this.mPopupWindow;
        o.a(r47);
        r47.showAtLocation((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 0, r46, r112);
        return;
    L70:
        int r48 = ((r45 * dipToPx(40.0d)) - (this.mSurnameGridViewNumColumns * this.mSurnameGridViewItemWidth)) / 2;
        r43.setPadding(dipToPx(14.0d) + r48, dipToPx(1.5d), dipToPx(17.0d) + r48, dipToPx(4.0d));
        r39 = r110 - r38;
        r115.leftMargin = dipToPx(20.0d) + r48;
        r118.leftMargin = dipToPx(20.0d) + r48;
        goto L71
    L72:
        r120 = r41;
        r46 = r37 - 1;
        goto L74
    L61:
        View r49 = r9.findViewById(ZeusTransformUtils.mapRes(R.id.surname_popup_bottom_arrow, DbHelper.COL_ID, "surname_popup_bottom_arrow"));
        Objects.requireNonNull(r49, "null cannot be cast to non-null type android.widget.ImageView");
        r35 = (ImageView) ZeusTransformUtils.preCheckCast(r49, ImageView.class, "com.obric.aiagent.plugin");
        r112 = (r111 - r32) - this.mPopupYOffset;
    L45:
        if (r20 < (r33 * 2)) goto L51;
        if (r20 >= (r33 * 3)) goto L51;
        if (this.mSurnameGridViewNumRows > 5) goto L59;
    L51:
        if (r20 >= (r33 * 3)) goto L53;
    L57:
        r25 = false;
        goto L59
    L53:
        if (r20 >= (r33 * 4)) goto L57;
        if (this.mSurnameGridViewNumRows <= 7) goto L57;
    L38:
        if (this.mSurnameGridViewNumRows > 1) goto L59;
    L19:
        r15 = r13 * this.mSurnameGridViewItemHeight;
        goto L20
    L85:
        return;
    L83:
        throw new IllegalArgumentException("You must implements SurnameListener".toString());
    }

    /* JADX INFO: renamed from: showGridPopupWindow$lambda-10, reason: not valid java name */
    private static final void m1094showGridPopupWindow$lambda10(OIndexScrollbar r0, AdapterView r1, View r2, int r3, long r4) {
        o.e(r0, "this$0");
        Object r5 = r1.getItemAtPosition(r3);
        Objects.requireNonNull(r5, "null cannot be cast to non-null type kotlin.String");
        String r6 = (String) ZeusTransformUtils.preCheckCast(r5, String.class, "com.obric.aiagent.plugin");
        c r7 = r0.mSurnameListener;
        o.a(r7);
        r7.b(r6);
        r0.hideLetterGrid();
    }

    private final void dismissPopupWindow() {
        PopupWindow r0 = this.mPopupWindow;
        if (r0 == null) goto L5;
        o.a(r0);
        r0.dismiss();
        this.mPopupWindow = null;
        this.mPopupGridView = null;
        this.mPopupFlowLayout = null;
    L5:
        PopupWindow r1 = this.mSecondPopup;
        if (r1 == null) goto L9;
        o.a(r1);
        r1.dismiss();
        this.mSecondPopup = null;
        this.mSecondPopupView = null;
        return;
    }

    private final void showSecondPopupWindow(View r12) {
        if (r12 != null) goto L8;
        PopupWindow r11 = this.mSecondPopup;
        if (r11 == null) goto L24;
        o.a(r11);
        r11.dismiss();
        return;
    L24:
        return;
    L8:
        if (this.mSecondPopup != null) goto L10;
        PopupWindow r0 = new PopupWindow();
        this.mSecondPopup = r0;
        o.a(r0);
        r0.setWindowLayoutMode(-2, -2);
        PopupWindow r1 = this.mSecondPopup;
        o.a(r1);
        r1.setBackgroundDrawable(ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getDrawable(ZeusTransformUtils.mapRes(R.color.Transparent, "color", "Transparent")));
        PopupWindow r2 = this.mSecondPopup;
        o.a(r2);
        r2.setClippingEnabled(true);
        ViewGroup r3 = (ViewGroup) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.inflate(LayoutInflater.from((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")), ZeusTransformUtils.mapRes(R.layout.o_surname_second_popup_ex, "layout", "o_surname_second_popup_ex"), null, "com.obric.aiagent.plugin"), ViewGroup.class, "com.obric.aiagent.plugin");
        this.mSecondPopupViewParent = r3;
        o.a(r3);
        this.mSecondPopupViewArrow = r3.getChildAt(1);
        ViewGroup r4 = this.mSecondPopupViewParent;
        o.a(r4);
        View r5 = r4.getChildAt(0);
        Objects.requireNonNull(r5, "null cannot be cast to non-null type android.widget.TextView");
        this.mSecondPopupView = (TextView) ZeusTransformUtils.preCheckCast(r5, TextView.class, "com.obric.aiagent.plugin");
    L10:
        PopupWindow r6 = this.mSecondPopup;
        o.a(r6);
        r6.setContentView((View) ZeusTransformUtils.preCheckCast(this.mSecondPopupViewParent, View.class, "com.obric.aiagent.plugin"));
        int[] r7 = new int[2];
        r12.getLocationOnScreen(r7);
        INVOKESTATIC_com_obric_oui_indexscrollbar_OIndexScrollbar_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d(this.OIndexScrollbar_TAG, "original anchorViewLocation[0] = " + r7[0] + ", anchorViewLocation[1] = " + r7[1]);
        int[] r8 = new int[2];
        getRootView().getLocationOnScreen(r8);
        INVOKESTATIC_com_obric_oui_indexscrollbar_OIndexScrollbar_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d(this.OIndexScrollbar_TAG, "rootViewLocation[0] = " + r8[0] + ", rootViewLocation[1] = " + r8[1]);
        String r9 = r12.getTag().toString();
        TextView r10 = this.mSecondPopupView;
        o.a(r10);
        r10.setText((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.aiagent.plugin"));
        TextView r13 = this.mSecondPopupView;
        o.a(r13);
        r13.measure(0, 0);
        TextView r14 = this.mSecondPopupView;
        o.a(r14);
        int r15 = ((int) r14.getPaint().measureText(r9)) + dipToPx(40.0d);
        int r16 = dipToPx(320.0d);
        if (r15 <= r16) goto L13;
        r15 = r16;
    L13:
        TextView r17 = this.mSecondPopupView;
        o.a(r17);
        int r18 = r17.getMeasuredHeight();
        int r19 = r12.getWidth();
        int r20 = r12.getHeight();
        int r110 = (r7[0] - r8[0]) + (r19 / 2);
        int r21 = (r7[1] - r8[1]) + (r20 / 2);
        int r22 = r15 / 2;
        int r23 = r110 - r22;
        int r24 = (r21 - r18) - 20;
        View r25 = this.mSecondPopupViewArrow;
        o.a(r25);
        r25.getLocationOnScreen(new int[2]);
        View r26 = this.mSecondPopupViewArrow;
        o.a(r26);
        r26.setTranslationX(0.0f);
        if (r23 >= 0) goto L16;
        View r27 = this.mSecondPopupViewArrow;
        o.a(r27);
        r27.setTranslationX(r23);
    L20:
        if (this.OIndexScrollbar_DEBUG == false) goto L22;
        INVOKESTATIC_com_obric_oui_indexscrollbar_OIndexScrollbar_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d(this.OIndexScrollbar_TAG, "x = " + r23 + ", width = " + r15 + ", anchorView.getWidth() = " + r12.getWidth());
        INVOKESTATIC_com_obric_oui_indexscrollbar_OIndexScrollbar_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d(this.OIndexScrollbar_TAG, "y = " + r24 + ", height = " + r18 + ", anchorView.getHeight() = " + r12.getHeight());
    L22:
        PopupWindow r111 = this.mSecondPopup;
        o.a(r111);
        r111.showAtLocation((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 51, r23, r24);
        return;
    L16:
        int r112 = r110 + r22;
        if (r112 <= getScreenWidth()) goto L20;
        View r28 = this.mSecondPopupViewArrow;
        o.a(r28);
        r28.setTranslationX(r112 - getScreenWidth());
        goto L20
    }

    @Override // android.view.View
    public void onVisibilityChanged(View r2, int r3) {
        o.e(r2, "changedView");
        super.onVisibilityChanged(r2, r3);
        if (r3 != 8) goto L11;
        if (r2 != this) goto L12;
        PopupWindow r4 = this.mPopupWindow;
        if (r4 == null) goto L13;
        o.a(r4);
        if (r4.isShowing() == false) goto L14;
        PopupWindow r1 = this.mPopupWindow;
        o.a(r1);
        r1.dismiss();
        return;
    L14:
        return;
    L13:
        return;
    L12:
        return;
    }

    private final void getParentxPos() {
        if (this.mHostX == this.DEFAULTX) goto L5;
        return;
    L5:
        ViewParent r0 = getParent();
        o.c(r0, "this@OIndexScrollbar.getParent()");
        if (ZeusTransformUtils.instanceOf(r0, View.class) == false) goto L9;
        int[] r1 = new int[2];
        ((View) ZeusTransformUtils.preCheckCast(r0, View.class, "com.obric.aiagent.plugin")).getLocationInWindow(r1);
        this.mHostX = r1[0];
        return;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
    }

    public final LettersBar getLetterBar() {
        return this.mLettersBar;
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static boolean INVOKESTATIC_com_obric_oui_indexscrollbar_OIndexScrollbar_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_isLoggable(String r1, int r2) {
        if (com.obric.aiagent.apm.impl.a.a() == true) goto L7;
        return Log.isLoggable(r1, r2);
    L7:
        if (r2 == 6) goto L9;
    L11:
        return false;
    L9:
        if (Log.isLoggable(r1, r2) == false) goto L11;
        return true;
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_obric_oui_indexscrollbar_OIndexScrollbar_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.d(r1, r2);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_obric_oui_indexscrollbar_OIndexScrollbar_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(String r0, String r1) {
        return Log.e(r0, r1);
    }
}
