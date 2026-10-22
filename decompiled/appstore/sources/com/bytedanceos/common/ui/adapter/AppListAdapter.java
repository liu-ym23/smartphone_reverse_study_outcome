package com.bytedanceos.common.ui.adapter;

import android.content.Context;
import android.text.Html;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c9.a;
import com.bytedanceos.common.BaseApplication;
import com.bytedanceos.common.CommonCache;
import com.bytedanceos.common.R$dimen;
import com.bytedanceos.common.R$drawable;
import com.bytedanceos.common.R$id;
import com.bytedanceos.common.R$layout;
import com.bytedanceos.common.R$string;
import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.model.BaseAppInfo;
import com.bytedanceos.common.model.IAppExtra;
import com.bytedanceos.common.model.SupposeAppInfo;
import com.bytedanceos.common.model.gameReservation.MyReserveApp;
import com.bytedanceos.common.network.ads.AdsReportManager;
import com.bytedanceos.common.network.widget.NetworkImageView;
import com.bytedanceos.common.toolbox.SizeConverter;
import com.bytedanceos.common.toolbox.c;
import com.bytedanceos.common.toolbox.e;
import com.bytedanceos.common.toolbox.glide.b;
import com.bytedanceos.common.toolbox.j;
import com.bytedanceos.common.ui.listener.ISupposeListener;
import com.bytedanceos.common.ui.widget.AppStatusView;
import com.bytedanceos.common.ui.widget.MyAppSwipeItemView;
import com.bytedanceos.common.ui.widget.SubButton;
import com.bytedanceos.common.ui.widget.oui.OUIAppItemView;
import com.bytedanceos.common.ui.widget.oui.OUIAppStatusView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import tc.f;

/* JADX INFO: loaded from: classes2.dex */
public class AppListAdapter extends BaseAdapter {
    public static final int PAGE_SIZE = 10;
    protected HashMap<Integer, Integer> mAppNoMap;
    protected Context mContext;
    protected List<AppInfo> mDataList;
    public int mHeaderViewCount;
    private RelativeLayout.LayoutParams mIconLayoutParams;
    protected LayoutInflater mInflater;
    protected boolean mIsBigFont;
    private boolean mIsCanUpdate;
    protected boolean mIsEditMode;
    private boolean mIsNeedSuppose;
    private int mLimitSize;
    protected ListView mListView;
    protected float mOffset;
    protected View.OnClickListener mOnBtnClickListener;
    protected View.OnClickListener mOnItemClickListener;
    protected View.OnLongClickListener mOnLongClickListener;
    protected MyAppSwipeItemView.OnSwipeItemActionListener mOnSwipeItemActionListener;
    protected int mOpenedSupPos;
    protected HashMap<String, AppInfo> mSelectedApps;
    protected int mShowItemType;
    private SubButton.OnSubListener mSubListener;
    protected ISupposeListener mSupposeListener;
    protected int mSwipeItemType;
    protected List<AppInfo> mTempData;
    private boolean mUpdateBtnEnable;
    AbsListView.OnScrollListener onScrollListener;

    public interface BaseHolder {
        int getConvertViewRid();

        void initConvertView(View r10);

        void invalidateConvertView(int r10, View r11);
    }

    public static class NormalHolder implements BaseHolder {
        private static final int SUPPOSE_ITEM_MAX_SIZE = 3;
        public TextView appBriefIntro;
        public TextView appCategory;
        public NetworkImageView appIcon;
        private List<BaseAppInfo> appInfoList;
        public TextView appLabelFirst;
        public TextView appLabelSecond;
        public TextView appName;
        public TextView appNo;
        public ImageView appRate;
        private int appSize;
        public TextView appSource;
        public OUIAppStatusView appStatusContainer;
        public TextView appVersionName;
        public ImageView deleteBtn;
        private HashMap<Integer, Integer> mAppNoMap;
        public CheckBox mCheckBox;
        public FrameLayout mCheckBoxFrame;
        private List<AppInfo> mDataList;
        public RelativeLayout mForgroundLayout;
        private int mHeaderViewCount;
        private boolean mIsEditMode;
        private boolean mIsNeedSuppose;
        private float mOffset;
        private View.OnClickListener mOnBtnClickListener;
        private View.OnClickListener mOnItemClickListener;
        private View.OnLongClickListener mOnLongClickListener;
        private HashMap<String, AppInfo> mSelectedApps;
        private int mShowItemType;
        private ISupposeListener mSupposeListener;
        protected int mSwipeItemType;
        private ViewGroup normalLayout;
        private LinearLayout supposeContainer;
        private ViewGroup supposeLayout;
        private TextView tvLayoutTitle;

        public NormalHolder() {
            this.appSize = 0;
            this.mIsNeedSuppose = true;
        }

        public static /* synthetic */ ViewGroup access$000(NormalHolder r10) {
            return r10.normalLayout;
        }

        public static /* synthetic */ ViewGroup access$002(NormalHolder r10, ViewGroup r11) {
            r10.normalLayout = r11;
            return r11;
        }

        public static /* synthetic */ int access$100(NormalHolder r10, boolean r11) {
            return r10.getLabelWidth(r11);
        }

        private int getLabelWidth(boolean r10) {
            int r11 = BaseApplication.c().getResources().getDimensionPixelSize(R$dimen.max_category_width);
            int r12 = BaseApplication.c().getResources().getDimensionPixelSize(R$dimen.label_interval);
            TextView r13 = this.appLabelFirst;
            if (r13 != null) goto L5;
        L9:
            TextView r14 = this.appLabelSecond;
            if (r14 != null) goto L12;
        L16:
            if (r10 == true) goto L18;
            return r11;
        L18:
            return (r11 - BaseApplication.c().getResources().getDimensionPixelSize(R$dimen.appnum_margin_left)) - BaseApplication.c().getResources().getDimensionPixelSize(R$dimen.appnum_width);
        L12:
            if (r14.getVisibility() != 0) goto L16;
            String r15 = this.appLabelSecond.getText().toString();
            if (TextUtils.isEmpty(r15) == true) goto L16;
            r11 = (r11 - ((int) (((double) this.appLabelSecond.getPaint().measureText(r15)) + 0.5d))) - r12;
            goto L16
        L5:
            if (r13.getVisibility() != 0) goto L9;
            String r16 = this.appLabelFirst.getText().toString();
            if (TextUtils.isEmpty(r16) == true) goto L9;
            r11 = (r11 - ((int) (((double) this.appLabelFirst.getPaint().measureText(r16)) + 0.5d))) - r12;
            goto L9
        }

        private int getLastNumber(int r10) {
            if (this.mAppNoMap.isEmpty() == true) goto L5;
            int r11 = r10 - 1;
        L7:
            if (r11 < 0) goto L14;
            if (this.mAppNoMap.get(Integer.valueOf(r11)) != null) goto L11;
            r11 = r11 - 1;
            goto L7
        L11:
            return this.mAppNoMap.get(Integer.valueOf(r11)).intValue();
        L14:
            return this.mHeaderViewCount;
        L5:
            return this.mHeaderViewCount;
        }

        private void initSupposeItem(View r10, BaseAppInfo r11, int r12, int r13) {
            int r14 = R$id.iv_item_icon;
            NetworkImageView r15 = (NetworkImageView) r10.findViewById(r14);
            TextView r16 = (TextView) r10.findViewById(R$id.tv_item_title);
            TextView r17 = (TextView) r10.findViewById(R$id.tv_item_desc);
            AppStatusView r18 = (AppStatusView) r10.findViewById(R$id.asv_item);
            View r19 = r10.findViewById(R$id.div_item);
            r15.setDefaultImageResId(R$drawable.oui_default_app_icon);
            if (r10.getTag(r14) != null) goto L5;
        L7:
            r15.f(r11.getLogo(), f.i(32), true);
            r10.setTag(r14, r11.getLogo());
            r16.setText(r11.getName());
            if (TextUtils.isEmpty(r11.getRecmd_brief()) == true) goto L10;
        L12:
            r17.setVisibility(0);
            if (TextUtils.isEmpty(r11.getRecmd_brief()) == false) goto L15;
            String r20 = r11.getCategory();
        L16:
            r17.setText(r20);
        L18:
            if (r12 != (r13 - 1)) goto L20;
            r19.setVisibility(8);
        L21:
            AppInfo r110 = a.a(r11, "&position=" + (r12 + 1));
            r18.updateDownloadStatus(r110);
            int r111 = R$id.appinfo;
            r18.setTag(r111, r110);
            int r112 = R$id.click_event;
            r18.setTag(r112, 1);
            r10.setTag(r111, r110);
            r10.setTag(r112, 2);
            View.OnClickListener r113 = this.mOnBtnClickListener;
            if (r113 == null) goto L24;
            r18.setOnClickListener(r113);
        L24:
            View.OnClickListener r21 = this.mOnItemClickListener;
            if (r21 == null) goto L27;
            r10.setOnClickListener(r21);
        L27:
            AdsReportManager.h().k(r110);
            return;
        L20:
            r19.setVisibility(0);
            goto L21
        L15:
            r20 = r11.getRecmd_brief();
            goto L16
        L10:
            if (TextUtils.isEmpty(r11.getCategory()) == false) goto L12;
            r17.setVisibility(8);
            goto L18
        L5:
            if (r11.getLogo().equals(String.valueOf(r10.getTag(r14))) == true) goto L7;
            r15.d();
            goto L7
        }

        private void initSupposeLayout(View r10, NormalHolder r11, IAppExtra r12) {
            if (r11.supposeLayout != null) goto L15;
            ViewStub r13 = (ViewStub) r10.findViewById(R$id.suppose_layout_stub);
            if (r13 == null) goto L7;
            r11.supposeLayout = (ViewGroup) r13.inflate();
        L7:
            r11.tvLayoutTitle = (TextView) r10.findViewById(R$id.tv_layout_title);
            r11.supposeContainer = (LinearLayout) r10.findViewById(R$id.container_suppose);
            if (this.mOnBtnClickListener == null) goto L13;
            ViewGroup r14 = r11.normalLayout;
            if (r14 == null) goto L13;
            r14.setOnClickListener(this.mOnItemClickListener);
        L13:
            if (r11.appInfoList != null) goto L15;
            r11.appInfoList = new ArrayList();
        L15:
            SupposeAppInfo r15 = (SupposeAppInfo) r12;
            if (r15.isAvailable() == false) goto L45;
            r11.tvLayoutTitle.setText(Html.fromHtml(String.format(r10.getContext().getString(R$string.suppose_app_user_likes), new Object[]{r15.getSuperName()})));
            SupposeAppInfo.Body r16 = r15.getBody();
            List<BaseAppInfo> r17 = r16.getAd_apps();
            List<BaseAppInfo> r18 = r16.getPromote_apps();
            r11.appInfoList.clear();
            if (c.a(r17) == true) goto L21;
            r11.appInfoList.add(r17.get(0));
        L21:
            if (r18 == null) goto L30;
            Iterator<BaseAppInfo> r19 = r18.iterator();
        L24:
            if (r19.hasNext() == false) goto L30;
            BaseAppInfo r20 = r19.next();
            if (r20 == null) goto L24;
            if (r11.appInfoList.size() >= 3) goto L30;
            r11.appInfoList.add(r20);
        L30:
            int r21 = Math.min(r11.appInfoList.size(), 3);
            r11.appSize = r21;
            if (r21 > 0) goto L33;
            return;
        L33:
            int r22 = r11.supposeContainer.getChildCount() - r11.appSize;
            if (r22 >= 0) goto L38;
            int r23 = Math.abs(r22);
            int r24 = 0;
        L36:
            if (r24 >= r23) goto L40;
            r11.supposeContainer.addView(View.inflate(r10.getContext(), R$layout.suppose_app_item, null));
            r24 = r24 + 1;
        L40:
            int r25 = 0;
        L42:
            if (r25 >= r11.supposeContainer.getChildCount()) goto L44;
            initSupposeItem(r11.supposeContainer.getChildAt(r25), r11.appInfoList.get(r25), r25, r11.appSize);
            r25 = r25 + 1;
            goto L42
        L44:
            r11.supposeLayout.setVisibility(0);
            return;
        L38:
            if (r22 <= 0) goto L40;
            r11.supposeContainer.removeViews(0, r22);
            goto L40
        L45:
            r11.supposeLayout.setVisibility(8);
        }

        public void bindData(int r10, List<AppInfo> r11, HashMap<Integer, Integer> r12, boolean r13, HashMap<String, AppInfo> r14, float r15) {
            this.mHeaderViewCount = r10;
            this.mDataList = r11;
            this.mAppNoMap = r12;
            this.mIsEditMode = r13;
            this.mSelectedApps = r14;
            this.mOffset = r15;
        }

        @Override // com.bytedanceos.common.ui.adapter.AppListAdapter.BaseHolder
        public int getConvertViewRid() {
            return R$layout.app_normal_suppose_item;
        }

        public boolean hasSourceView(int r10, AppInfo r11) {
            int r12 = r10 + 1;
            if (this.mDataList.size() <= r12) goto L13;
            AppInfo r13 = this.mDataList.get(r12);
            if (AppInfo.SEARCH_LIST_SHOW_WORDS.equals(r13.listShowType) == false) goto L9;
            return TextUtils.equals(r11.appSource, AppInfo.SEARCH_SOURCE_EXTENAL);
        L9:
            if (TextUtils.equals(r11.appSource, AppInfo.SEARCH_SOURCE_EXTENAL) == true) goto L11;
            return false;
        L11:
            if (TextUtils.equals(r13.appSource, "local") == false) goto L16;
            return true;
        L16:
            return false;
        L13:
            return false;
        }

        @Override // com.bytedanceos.common.ui.adapter.AppListAdapter.BaseHolder
        public void initConvertView(View r10) {
            r10.setPadding(f.i(8), 0, f.i(8), 0);
            if (this.mShowItemType != 2) goto L6;
            this.deleteBtn = (ImageView) r10.findViewById(R$id.delete_btn);
        L6:
            AppListAdapter.initCommonItemDataByInner(r10, this, this.mSwipeItemType, this.mOnBtnClickListener, this.mOnItemClickListener, this.mOnLongClickListener, this.mSupposeListener);
        }

        public void initData(int r10, int r11, View.OnClickListener r12, View.OnClickListener r13, View.OnLongClickListener r14, ISupposeListener r15) {
            this.mShowItemType = r10;
            this.mSwipeItemType = r11;
            this.mOnBtnClickListener = r12;
            this.mOnItemClickListener = r13;
            this.mSupposeListener = r15;
        }

        @Override // com.bytedanceos.common.ui.adapter.AppListAdapter.BaseHolder
        public void invalidateConvertView(int r10, View r11) {
            AppInfo r12 = this.mDataList.get(r10);
            OUIAppStatusView r13 = this.appStatusContainer;
            if (r13 == null) goto L5;
            r13.setAppSize(SizeConverter.BTrim.convert(r12.appBytes));
        L5:
            IAppExtra r14 = r12.getAppExtraInfo();
            if (r14 != null) goto L8;
        L14:
            ViewGroup r15 = this.supposeLayout;
            if (r15 == null) goto L17;
            r15.setVisibility(8);
        L17:
            int r16 = this.mShowItemType;
            if (r16 != 1) goto L20;
            int r17 = r12.mItemShowType;
            TextView r18 = this.appNo;
            Object r19 = "AD";
            if (r18 == null) goto L57;
            if (r17 == 0) goto L41;
            if (r17 == 3) goto L41;
            r18.setVisibility(8);
        L70:
            r12.mHasSourceView = hasSourceView(r10, r12);
        L72:
            if (r11.findViewById(R$id.myapp_lay) == null) goto L74;
            r11.setTag(R$id.appinfo, r12);
            r11.setTag(R$id.app_row_index, Integer.valueOf(r10));
        L75:
            int r20 = this.mShowItemType;
            if (r20 == 1) goto L79;
            if (r20 == 0) goto L79;
            if (r20 == 3) goto L79;
        L82:
            AppListAdapter.updateCommonItemDataByInner(r10, r11, this, r12, this.mSwipeItemType);
        L83:
            AdsReportManager.h().k(r12);
            return;
        L79:
            ViewGroup r21 = this.normalLayout;
            if ((r21 instanceof OUIAppItemView) == false) goto L82;
            ((OUIAppItemView) r21).updateItemView(r12, r10);
            goto L83
        L74:
            this.normalLayout.setTag(R$id.appinfo, r12);
            this.normalLayout.setTag(R$id.app_row_index, Integer.valueOf(r10));
        L41:
            Integer r22 = this.mAppNoMap.get(Integer.valueOf(r10));
            if (r22 != null) goto L45;
            r22 = Integer.valueOf(this.mHeaderViewCount);
        L45:
            if (r22.intValue() <= 100) goto L47;
            this.appNo.setMinWidth(BaseApplication.c().getResources().getDimensionPixelOffset(R$dimen.app_no_max_width));
        L49:
            if (r12.isAD() == false) goto L51;
            e.X0(0, this.appNo);
            this.appNo.setText("AD");
            this.appNo.setVisibility(0);
            goto L70
        L51:
            if (r22.intValue() <= this.mHeaderViewCount) goto L53;
            this.appNo.setText(String.valueOf(r22));
        L54:
            this.appNo.setVisibility(0);
            goto L70
        L53:
            int r23 = getLastNumber(r10) + 1;
            this.mAppNoMap.put(Integer.valueOf(r10), Integer.valueOf(r23));
            this.appNo.setText(String.valueOf(r23));
            goto L54
        L47:
            this.appNo.setMinWidth(BaseApplication.c().getResources().getDimensionPixelOffset(R$dimen.app_no_min_width));
            goto L49
        L57:
            if ((this.normalLayout instanceof OUIAppItemView) == false) goto L70;
            if (r17 == 0) goto L60;
            if (r17 != 3) goto L70;
        L60:
            Integer r24 = this.mAppNoMap.get(Integer.valueOf(r10));
            if (r24 != null) goto L64;
            r24 = Integer.valueOf(this.mHeaderViewCount);
        L64:
            if (r12.isAD() == false) goto L66;
        L69:
            ((OUIAppItemView) this.normalLayout).setNumber(r19);
            goto L70
        L66:
            if (r24.intValue() <= this.mHeaderViewCount) goto L68;
            r19 = r24;
            goto L69
        L68:
            int r25 = getLastNumber(r10) + 1;
            this.mAppNoMap.put(Integer.valueOf(r10), Integer.valueOf(r25));
            r19 = Integer.valueOf(r25);
            goto L69
        L20:
            if (r16 == 2) goto L24;
            if (r16 == 3) goto L70;
        L24:
            if (this.mSwipeItemType != 4) goto L33;
            this.mCheckBoxFrame.setVisibility(0);
            if (this.mIsEditMode == false) goto L30;
            this.mCheckBox.setChecked(this.mSelectedApps.containsKey(r12.appPackageName));
            this.mCheckBoxFrame.setTranslationX(0.0f);
            this.mForgroundLayout.setTranslationX(this.mOffset);
            OUIAppStatusView r26 = this.appStatusContainer;
            if (r26 == null) goto L34;
            r26.setTranslationX(r26.getWidth());
            this.appStatusContainer.updateBtnEnable(false);
        L34:
            this.deleteBtn.setTag(r12);
            goto L72
        L30:
            this.mCheckBox.setChecked(false);
            this.mCheckBoxFrame.setTranslationX(-this.mOffset);
            this.mForgroundLayout.setTranslationX(0.0f);
            OUIAppStatusView r27 = this.appStatusContainer;
            if (r27 == null) goto L34;
            r27.setTranslationX(0.0f);
            this.appStatusContainer.updateBtnEnable(true);
            goto L34
        L33:
            this.mCheckBoxFrame.setVisibility(8);
            goto L34
        L8:
            if (r14.getItemType() != 1) goto L14;
            if ((r14 instanceof SupposeAppInfo) == false) goto L14;
            if (this.mIsNeedSuppose == false) goto L17;
            initSupposeLayout(r11, this, r14);
            goto L17
        }

        public void showOrGoneAppSourceView(int r10, AppInfo r11) {
            int r12 = r10 + 1;
            if (this.mDataList.size() <= r12) goto L14;
            AppInfo r13 = this.mDataList.get(r12);
            if (TextUtils.equals(r11.appSource, AppInfo.SEARCH_SOURCE_EXTENAL) == true) goto L7;
        L11:
            TextView r14 = this.appSource;
            if (r14 == null) goto L20;
            r14.setVisibility(8);
            return;
        L20:
            return;
        L7:
            if (TextUtils.equals(r13.appSource, "local") == false) goto L11;
            TextView r15 = this.appSource;
            if (r15 == null) goto L18;
            r15.setVisibility(0);
            return;
        L18:
            return;
        L14:
            TextView r16 = this.appSource;
            if (r16 == null) goto L22;
            r16.setVisibility(8);
            return;
        }

        public void showOrGoneLabels(AppInfo r10) {
            if (this.appLabelFirst == null) goto L9;
            if (r10.mLabels.size() <= 0) goto L7;
            e.A1(this.appLabelFirst, r10.mLabels.get(0).intValue());
            this.appLabelFirst.setVisibility(0);
            goto L9
        L7:
            this.appLabelFirst.setVisibility(8);
        L9:
            if (this.appLabelSecond != null) goto L11;
            return;
        L11:
            if (r10.mLabels.size() <= 1) goto L13;
            e.A1(this.appLabelSecond, r10.mLabels.get(1).intValue());
            this.appLabelSecond.setVisibility(0);
            return;
        L13:
            this.appLabelSecond.setVisibility(8);
        }

        public NormalHolder(boolean r10) {
            this.appSize = 0;
            this.mIsNeedSuppose = r10;
        }
    }

    public class ReservationHolder implements BaseHolder {
        public ImageView mAppIcon;
        public TextView mAppName;
        public TextView mAppOnLineTime;
        public TextView mAppappCategory;
        public SubButton mReserveBtn;
        final /* synthetic */ AppListAdapter this$0;

        public ReservationHolder(AppListAdapter r10) {
            this.this$0 = r10;
        }

        @Override // com.bytedanceos.common.ui.adapter.AppListAdapter.BaseHolder
        public int getConvertViewRid() {
            return R$layout.item_search_sub_app;
        }

        @Override // com.bytedanceos.common.ui.adapter.AppListAdapter.BaseHolder
        public void initConvertView(View r10) {
            this.mAppIcon = (ImageView) r10.findViewById(R$id.iv_icon);
            this.mAppName = (TextView) r10.findViewById(R$id.tv_name);
            this.mAppOnLineTime = (TextView) r10.findViewById(R$id.tv_category);
            this.mAppappCategory = (TextView) r10.findViewById(R$id.tv_desc);
            SubButton r11 = (SubButton) r10.findViewById(R$id.btn_sub);
            this.mReserveBtn = r11;
            r11.setOnSubListener(AppListAdapter.access$200(this.this$0));
            View.OnClickListener r12 = this.this$0.mOnItemClickListener;
            if (r12 == null) goto L6;
            r10.setOnClickListener(r12);
            return;
        }

        @Override // com.bytedanceos.common.ui.adapter.AppListAdapter.BaseHolder
        public void invalidateConvertView(int r10, View r11) {
            AppInfo r12 = this.this$0.mDataList.get(r10);
            this.mAppIcon.setScaleType(ImageView.ScaleType.FIT_XY);
            b.l(this.this$0.mContext, R$drawable.default_app_icon_banner, r12.appIcon, this.mAppIcon, 15, 38);
            this.mAppName.setText(r12.appName);
            this.mAppappCategory.setText(r12.appCategoryName);
            this.mAppOnLineTime.setText(e.T(r12.mOnlineTime));
            SubButton r13 = this.mReserveBtn;
            boolean r14 = true;
            if (r12.mStatus == 1) goto L6;
            r14 = false;
        L6:
            r13.setSubcirbe(r14);
            this.mReserveBtn.setId(r12.appId);
            MyReserveApp r15 = new MyReserveApp();
            r15.mGameName = r12.appName;
            r15.mGameOnlineTime = r12.mOnlineTime;
            r15.mGameCategory = r12.appCategoryName;
            this.mReserveBtn.setTrackInfo(r15);
            SubButton r16 = this.mReserveBtn;
            int r17 = R$id.appinfo;
            r16.setTag(r17, r12);
            r11.setTag(r17, r12);
        }
    }

    public class SupposeListener implements ISupposeListener {
        final /* synthetic */ AppListAdapter this$0;

        public SupposeListener(AppListAdapter r10) {
            this.this$0 = r10;
        }

        @Override // com.bytedanceos.common.ui.listener.ISupposeListener
        public void onOpen(int r10) {
            this.this$0.mOpenedSupPos = r10;
        }
    }

    public AppListAdapter() {
        this.mOnBtnClickListener = null;
        this.mOnItemClickListener = null;
        this.mOnLongClickListener = null;
        this.mOnSwipeItemActionListener = null;
        this.mShowItemType = 0;
        this.mSwipeItemType = 0;
        this.mDataList = new CopyOnWriteArrayList();
        this.mTempData = null;
        this.mIsCanUpdate = true;
        this.mUpdateBtnEnable = true;
        this.mIsBigFont = false;
        this.mIsEditMode = false;
        this.mSelectedApps = new HashMap();
        this.mOffset = 0.0f;
        this.mLimitSize = 0;
        this.mIconLayoutParams = null;
        this.mAppNoMap = new HashMap();
        this.mOpenedSupPos = -1;
        this.mIsNeedSuppose = true;
        this.onScrollListener = new AnonymousClass1(this);
    }

    public static /* synthetic */ SubButton.OnSubListener access$200(AppListAdapter r10) {
        return r10.mSubListener;
    }

    public static /* synthetic */ boolean access$302(AppListAdapter r10, boolean r11) {
        r10.mIsCanUpdate = r11;
        return r11;
    }

    private List<AppInfo> filterData(List<AppInfo> r10) {
        ArrayList r11 = new ArrayList();
        List<AppInfo> r12 = this.mDataList;
        if (r12 != null) goto L5;
    L28:
        return r10;
    L5:
        if (r12.isEmpty() == true) goto L28;
        if (this.mDataList.size() <= 20) goto L10;
        int r13 = 19;
    L11:
        Iterator<AppInfo> r14 = r10.iterator();
    L13:
        if (r14.hasNext() == false) goto L27;
        AppInfo r15 = r14.next();
        if (r15.mItemShowType == 4) goto L26;
        if (TextUtils.isEmpty(r15.appPackageName) == true) goto L26;
        int r16 = r13;
    L20:
        if (r16 < 0) goto L25;
        if (TextUtils.equals(r15.appPackageName, getItem(r16).appPackageName) == true) goto L13;
        r16 = r16 - 1;
        goto L20
    L25:
        r11.add(r15);
    L26:
        r11.add(r15);
        j.a("appName:" + r15.appName + " | appPackageName:" + r15.appPackageName);
        goto L13
    L27:
        return r11;
    L10:
        r13 = this.mDataList.size() - 1;
        goto L11
    }

    private CommonCache getStoreCache() {
        return BaseApplication.c().b();
    }

    public static void initCommonItemDataByInner(View r10, NormalHolder r11, int r12, View.OnClickListener r13, View.OnClickListener r14, View.OnLongClickListener r15, ISupposeListener r16) {
        NormalHolder.access$002(r11, (ViewGroup) r10.findViewById(R$id.app_list_item));
        r11.appIcon = (NetworkImageView) r10.findViewById(R$id.appIcon);
        r11.appName = (TextView) r10.findViewById(R$id.appName);
        r11.appCategory = (TextView) r10.findViewById(R$id.appCategory);
        r11.appBriefIntro = (TextView) r10.findViewById(R$id.appBrief);
        r11.appVersionName = (TextView) r10.findViewById(R$id.appVersionName);
        r11.appRate = (ImageView) r10.findViewById(R$id.appRate);
        OUIAppStatusView r17 = (OUIAppStatusView) r10.findViewById(R$id.appStatusLay);
        r11.appStatusContainer = r17;
        r17.setOnClickListener(r13);
        r11.appStatusContainer.setTag(R$id.suppose_listener, r16);
        r11.appStatusContainer.showAppSize();
        if (r12 == 0) goto L5;
        r11.mCheckBoxFrame = (FrameLayout) r10.findViewById(R$id.checkBoxFrame);
        r11.mCheckBox = (CheckBox) r10.findViewById(R$id.checkBox);
        r11.mForgroundLayout = (RelativeLayout) r10.findViewById(R$id.forground_layout);
    L5:
        if (r14 != null) goto L7;
    L10:
        if (r15 == null) goto L16;
        int r18 = R$id.myapp_lay;
        if (r10.findViewById(r18) == null) goto L14;
        r10.findViewById(r18).setOnLongClickListener(r15);
        return;
    L14:
        NormalHolder.access$000(r11).setOnLongClickListener(r15);
        return;
    L16:
        return;
    L7:
        if (r10.findViewById(R$id.myapp_lay) == null) goto L9;
        r10.setOnClickListener(r14);
        goto L10
    L9:
        NormalHolder.access$000(r11).setOnClickListener(r14);
        goto L10
    }

    public static void updateCommonItemDataByInner(int r10, View r11, NormalHolder r12, AppInfo r13, int r14) {
        r12.appStatusContainer.updateDownloadStatus(r13);
        if (r14 != 2) goto L5;
    L30:
        TextView r15 = r12.appBriefIntro;
        if (r15 == null) goto L33;
        r15.setVisibility(8);
    L33:
        ImageView r16 = r12.appRate;
        if (r16 == null) goto L36;
        r16.setVisibility(8);
    L36:
        r12.appVersionName.setText(r13.appVersionName);
        r12.appVersionName.setVisibility(0);
    L37:
        r12.appIcon.setTag(r13);
        r12.appName.setText(r13.appName);
        TextView r17 = r12.appNo;
        if (r17 != null) goto L40;
    L42:
        boolean r18 = false;
    L43:
        r12.appCategory.setMaxWidth(NormalHolder.access$100(r12, r18));
        r12.appCategory.setText(r13.appCategoryName);
        if (TextUtils.isEmpty(r13.appCategoryName) == false) goto L46;
        r12.appCategory.setVisibility(8);
    L47:
        r12.appStatusContainer.setTag(r13);
        r12.appStatusContainer.setTag(R$id.page_button_pos, Integer.valueOf(r10));
        r12.appStatusContainer.setTag(R$id.appinfo, r13);
        r12.appStatusContainer.setTag(R$id.app_row_index, Integer.valueOf(r10));
        NetworkImageView r19 = r12.appIcon;
        int r20 = R$drawable.oui_default_app_icon;
        r19.setErrorImageResId(r20);
        r12.appIcon.setDefaultImageResId(r20);
        r12.appIcon.f(r13.appIcon, 12.0f, !r13.isSystemApp());
        return;
    L46:
        r12.appCategory.setVisibility(0);
        goto L47
    L40:
        if (r17.getVisibility() != 0) goto L42;
        r18 = true;
        goto L43
    L5:
        if (r14 == 3) goto L30;
        if (TextUtils.isEmpty(r13.recmd_brief) == true) goto L10;
        r12.appRate.setVisibility(8);
        TextView r21 = r12.appVersionName;
        if (r21 == null) goto L27;
        r21.setVisibility(8);
    L27:
        TextView r22 = r12.appBriefIntro;
        if (r22 == null) goto L37;
        r22.setText(r13.recmd_brief);
        r12.appBriefIntro.setVisibility(0);
        goto L37
    L10:
        if (r13.appScores <= 0.0f) goto L18;
        r12.appRate.setImageResource(e.b0(BaseApplication.c(), r13.appScores, false));
        TextView r23 = r12.appBriefIntro;
        if (r23 == null) goto L14;
        r23.setVisibility(8);
    L14:
        TextView r24 = r12.appVersionName;
        if (r24 == null) goto L17;
        r24.setVisibility(8);
    L17:
        r12.appRate.setVisibility(0);
        goto L37
    L18:
        r12.appRate.setVisibility(8);
        TextView r25 = r12.appVersionName;
        if (r25 == null) goto L21;
        r25.setVisibility(8);
    L21:
        TextView r26 = r12.appBriefIntro;
        if (r26 == null) goto L37;
        r26.setText(R$string.no_comment);
        r12.appBriefIntro.setVisibility(0);
        goto L37
    }

    public void addData(AppInfo r10, int r11) {
        this.mDataList.add(r11, r10);
        notifyDataSetChanged();
    }

    public synchronized void addDataList(List<AppInfo> r10) {
        monitor-enter(this);
        List<AppInfo> r11 = filterData(r10);     // Catch: Throwable -> L6
        this.mTempData = r11;     // Catch: Throwable -> L6
        this.mDataList.addAll(r11);     // Catch: Throwable -> L6
        this.mTempData = null;     // Catch: Throwable -> L6
        notifyDataSetChanged();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public View getConvertView(int r10, BaseHolder r11) {
        int r12 = this.mShowItemType;
        if (r12 == 0) goto L18;
        if (r12 == 1) goto L18;
        if (r12 != 2) goto L9;
        MyAppSwipeItemView.setItemSwipeType(this.mSwipeItemType);
        if (this.mIsBigFont == false) goto L15;
        View r13 = this.mInflater.inflate(R$layout.myapp_swipe_list_item_1x4, null);
    L14:
        View r14 = r13;
        ((MyAppSwipeItemView) r14).setSwipeItemActionListener(this.mOnSwipeItemActionListener);
        return r14;
    L15:
        r13 = this.mInflater.inflate(R$layout.myapp_swipe_list_item, null);
        goto L14
    L9:
        if (r12 == 3) goto L18;
        return null;
    L18:
        return this.mInflater.inflate(R$layout.app_item_view_imp, null);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        int r10 = this.mLimitSize;
        if (r10 <= 0) goto L6;
        return r10;
    L6:
        return this.mDataList.size();
    }

    public List<AppInfo> getDataList() {
        return this.mDataList;
    }

    @Override // android.widget.Adapter
    public /* bridge */ /* synthetic */ Object getItem(int r10) {
        return getItem(r10);
    }

    @Override // android.widget.Adapter
    public long getItemId(int r10) {
        return r10;
    }

    public MyAppSwipeItemView.OnSwipeItemActionListener getOnSwipeItemActionListener() {
        return this.mOnSwipeItemActionListener;
    }

    public ArrayList<AppInfo> getSelectedAppsForDelete() {
        ArrayList<AppInfo> r10 = new ArrayList();
        Iterator<AppInfo> r11 = this.mSelectedApps.values().iterator();
    L4:
        if (r11.hasNext() == false) goto L9;
        AppInfo r12 = r11.next();
        if (getStoreCache().b0(r12.appPackageName) == true) goto L4;
        r10.add(r12);
        goto L4
    L9:
        return r10;
    }

    public ArrayList<AppInfo> getSelectedAppsForInstall() {
        ArrayList<AppInfo> r10 = new ArrayList();
        Iterator<AppInfo> r11 = this.mSelectedApps.values().iterator();
    L4:
        if (r11.hasNext() == false) goto L11;
        AppInfo r12 = r11.next();
        if (getStoreCache().X(r12.appPackageName) == true) goto L4;
        if (getStoreCache().b0(r12.appPackageName) == true) goto L4;
        r10.add(r12);
        goto L4
    L11:
        return r10;
    }

    public int getSelectedCount() {
        return this.mSelectedApps.size();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v1 */
    /* JADX WARN: Type inference failed for: r11v2, types: [com.bytedanceos.common.ui.adapter.AppListAdapter$BaseHolder] */
    /* JADX WARN: Type inference failed for: r11v3, types: [com.bytedanceos.common.ui.adapter.AppListAdapter$BaseHolder, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* JADX WARN: Type inference failed for: r12v3 */
    /* JADX WARN: Type inference failed for: r12v4, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r12v5, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r12v6 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r9v0, types: [com.bytedanceos.common.ui.adapter.AppListAdapter] */
    @Override // android.widget.Adapter
    public View getView(int r10, View r11, ViewGroup r12) {
        if (r11 != null) goto L7;
        ?? r13 = getViewHolder(r10);
        ?? r14 = getConvertView(r10, r13);
        if ((r13 instanceof NormalHolder) == false) goto L6;
        ((NormalHolder) r13).initData(this.mShowItemType, this.mSwipeItemType, this.mOnBtnClickListener, this.mOnItemClickListener, this.mOnLongClickListener, this.mSupposeListener);
    L6:
        r13.initConvertView(r14);
        r14.setTag(r13);
        ?? r15 = r13;
        ?? r16 = r14;
    L9:
        if ((r15 instanceof NormalHolder) == false) goto L11;
        ((NormalHolder) r15).bindData(this.mHeaderViewCount, this.mDataList, this.mAppNoMap, this.mIsEditMode, this.mSelectedApps, this.mOffset);
    L11:
        r15.invalidateConvertView(r10, r16);
        return r16;
    L7:
        BaseHolder r17 = (BaseHolder) r11.getTag();
        r16 = r11;
        r15 = r17;
        goto L9
    }

    public BaseHolder getViewHolder(int r10) {
        return new NormalHolder(this.mIsNeedSuppose);
    }

    public boolean isChecked(int r10) {
        AppInfo r11 = getItem(r10);
        if (r11 != null) goto L7;
        return false;
    L7:
        return this.mSelectedApps.containsKey(r11.appPackageName);
    }

    public boolean isEditMode() {
        return this.mIsEditMode;
    }

    public boolean isNeedSuppose() {
        return this.mIsNeedSuppose;
    }

    public void onUpdate() {
        if (this.mIsCanUpdate == false) goto L9;
        List<AppInfo> r10 = this.mTempData;
        if (r10 == null) goto L7;
        this.mDataList = r10;
        this.mTempData = null;
    L7:
        notifyDataSetChanged();
        return;
    }

    public synchronized void removeItem(int r10) {
        monitor-enter(this);
        if (r10 >= 0) goto L12;
    L10:
        monitor-exit(this);
        return;
    L12:
    L7:
        th = move-exception;
        throw th;
    L5:
        if (r10 >= this.mDataList.size()) goto L10;
        this.mDataList.remove(r10);     // Catch: Throwable -> L7
        notifyDataSetChanged();     // Catch: Throwable -> L7
        goto L10
    }

    public void setCanUpdate(boolean r10) {
        this.mIsCanUpdate = r10;
    }

    public boolean setChecked(int r10, boolean r11) {
        AppInfo r12 = getItem(r10);
        if (r12 != null) goto L6;
        return false;
    L6:
        if (r11 == false) goto L8;
        this.mSelectedApps.put(r12.appPackageName, r12);
        return true;
    L8:
        this.mSelectedApps.remove(r12.appPackageName);
        return true;
    }

    public synchronized void setDataList(List<AppInfo> r10) {
        monitor-enter(this);
    L6:
        th = move-exception;
        throw th;
    L4:
        if ((r10 instanceof CopyOnWriteArrayList) == false) goto L8;
        this.mTempData = r10;     // Catch: Throwable -> L6
    L12:
        if (this.mShowItemType != 1) goto L17;
        HashMap<Integer, Integer> r11 = this.mAppNoMap;     // Catch: Throwable -> L6
        if (r11 == null) goto L17;
        r11.clear();     // Catch: Throwable -> L6
    L17:
        if (this.mIsCanUpdate == false) goto L32;
        this.mDataList = this.mTempData;     // Catch: Throwable -> L6
        this.mTempData = null;     // Catch: Throwable -> L6
        notifyDataSetChanged();     // Catch: Throwable -> L6
        if (isEditMode() == false) goto L32;
        if (r10 == null) goto L32;
        if (r10.size() <= 0) goto L32;
        if (getSelectedCount() <= 0) goto L32;
        Iterator r12 = ((HashMap) this.mSelectedApps.clone()).values().iterator();     // Catch: Throwable -> L6
    L26:
        if (r12.hasNext() == false) goto L32;
        AppInfo r13 = (AppInfo) r12.next();     // Catch: Throwable -> L6
        if (r10.contains(r13) == true) goto L26;
        this.mSelectedApps.remove(r13.appPackageName);     // Catch: Throwable -> L6
    L32:
        monitor-exit(this);
        return;
    L8:
        if (r10 != null) goto L10;
        this.mTempData = Collections.synchronizedList(new ArrayList());     // Catch: Throwable -> L6
        goto L12
    L10:
        this.mTempData = Collections.synchronizedList(r10);     // Catch: Throwable -> L6
        goto L12
    }

    public void setIsEditMode(boolean r10) {
        this.mIsEditMode = r10;
        if (r10 == true) goto L6;
        this.mSelectedApps.clear();
        return;
    }

    public void setIsNeedSuppose(boolean r10) {
        this.mIsNeedSuppose = r10;
    }

    public void setLimitSize(int r10) {
        this.mLimitSize = r10;
        notifyDataSetChanged();
    }

    public void setMyAppSwipeType(int r10) {
        this.mSwipeItemType = r10;
    }

    public void setSelectedAll(boolean r10) {
        this.mIsEditMode = true;
        this.mSelectedApps.clear();
        if (r10 == false) goto L8;
        Iterator<AppInfo> r11 = this.mDataList.iterator();
    L6:
        if (r11.hasNext() == false) goto L8;
        AppInfo r12 = r11.next();
        this.mSelectedApps.put(r12.appPackageName, r12);
    L8:
        notifyDataSetChanged();
    }

    public void setShowAppItemType(int r10) {
        this.mShowItemType = r10;
    }

    public void setSubButtonListener(SubButton.OnSubListener r10) {
        this.mSubListener = r10;
    }

    public void setUpdateBtnEnable(boolean r10) {
        this.mUpdateBtnEnable = r10;
    }

    @Override // android.widget.Adapter
    public AppInfo getItem(int r10) {
        return this.mDataList.get(r10);
    }

    public synchronized void removeItem(AppInfo r10) {
        monitor-enter(this);
    L7:
        th = move-exception;
        throw th;
    L4:
        if (this.mDataList.remove(r10) == false) goto L9;
        notifyDataSetChanged();     // Catch: Throwable -> L7
    L9:
        monitor-exit(this);
    }

    public synchronized void removeItem(ArrayList<AppInfo> r10) {
        monitor-enter(this);
    L7:
        th = move-exception;
        throw th;
    L4:
        if (this.mDataList.removeAll(r10) == false) goto L9;
        notifyDataSetChanged();     // Catch: Throwable -> L7
    L9:
        monitor-exit(this);
    }

    public AppListAdapter(Context r10, ListView r11, View.OnClickListener r12, View.OnClickListener r13, MyAppSwipeItemView.OnSwipeItemActionListener r14) {
        this.mOnBtnClickListener = null;
        this.mOnItemClickListener = null;
        this.mOnLongClickListener = null;
        this.mOnSwipeItemActionListener = null;
        this.mShowItemType = 0;
        this.mSwipeItemType = 0;
        this.mDataList = new CopyOnWriteArrayList();
        this.mTempData = null;
        this.mIsCanUpdate = true;
        this.mUpdateBtnEnable = true;
        this.mIsBigFont = false;
        this.mIsEditMode = false;
        this.mSelectedApps = new HashMap();
        this.mOffset = 0.0f;
        this.mLimitSize = 0;
        this.mIconLayoutParams = null;
        this.mAppNoMap = new HashMap();
        this.mOpenedSupPos = -1;
        this.mIsNeedSuppose = true;
        AbsListView.OnScrollListener r15 = new AnonymousClass1(this);
        this.onScrollListener = r15;
        this.mContext = r10;
        this.mListView = r11;
        r11.setOnScrollListener(r15);
        this.mInflater = (LayoutInflater) this.mContext.getSystemService("layout_inflater");
        this.mOnBtnClickListener = r12;
        this.mOnItemClickListener = r13;
        this.mOnSwipeItemActionListener = r14;
        this.mIsBigFont = e.n0();
        this.mOffset = this.mContext.getResources().getDimension(R$dimen.swipe_item_checkbox_width);
        this.mSupposeListener = new SupposeListener(this);
    }

    public AppListAdapter(Context r10, ListView r11, View.OnClickListener r12, View.OnClickListener r13, MyAppSwipeItemView.OnSwipeItemActionListener r14, View.OnLongClickListener r15) {
        this(r10, r11, r12, r13, r14);
        this.mOnLongClickListener = r15;
    }
}
