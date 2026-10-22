package com.android.ttcjpaysdk.base.framework;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.fragment.app.Fragment;
import com.android.ttcjpaysdk.base.CJPayCallBackCenter;
import com.android.ttcjpaysdk.base.CJPayPerformance;
import com.android.ttcjpaysdk.base.SourceManager;
import com.android.ttcjpaysdk.base.service.api.CJPayDataKeepAPI;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import com.android.ttcjpaysdk.base.utils.CJPayAnimationUtils;
import com.bytedance.caijing.sdk.infra.base.event.CJReporter;
import com.bytedance.caijing.sdk.infra.base.event.DynamicEventTracker;
import com.bytedance.caijing.sdk.infra.base.logger.CJLogger;
import com.bytedance.caijing.sdk.infra.base.logger.a;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.larus.nova.R;
import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Lazy;

/* JADX INFO: loaded from: classes3.dex */
public abstract class BaseFragment extends Fragment implements AnimUtil.IOldAnimView {
    private static final String TAG = "BaseFragment";
    private CJPayAnimRootView animRootView;
    private boolean isFirst;
    protected boolean isViewInit;
    protected boolean isVisibleToUser;
    private View mAnimBackground;
    private View mAnimLayoutRootView;
    protected Context mContext;
    private BaseFragmentListener mFragmentListener;
    protected volatile boolean mIsQueryConnecting;
    protected View mLayoutRootView;
    private View panelLayerView;

    private int getAnimLayout() {
        return R.layout.cj_pay_anim_root_layout;
    }

    public abstract void bindViews(View r100);

    public AnimUtil.IAnimationCallback getAnimCallback() {
        return null;
    }

    @Override // com.android.ttcjpaysdk.base.framework.AnimUtil.IAnimView
    public int getAnimViewHeight() {
        return 0;
    }

    public abstract int getContentViewLayoutId();

    public String getFragmentName() {
        return "";
    }

    public int getInAnim() {
        return -1;
    }

    public int getOutAnim() {
        return -1;
    }

    public int getPanelHeight() {
        return 470;
    }

    public View getPanelView() {
        return null;
    }

    public View getPreloadContentView() {
        return null;
    }

    public String getSource() {
        return null;
    }

    public View hookRootView(View r100) {
        return r100;
    }

    public void inOrOutWithAnimation(boolean r100, boolean r101) {
    }

    public abstract void initActions(View r100);

    public abstract void initData();

    public abstract void initViews(View r100, Bundle r101);

    public boolean isAddPanelLayer() {
        return false;
    }

    @Override // com.android.ttcjpaysdk.base.framework.AnimUtil.IOldAnimView
    public boolean isUseNewAnim() {
        return false;
    }

    public boolean shouldSkipAnim() {
        return false;
    }

    public boolean shouldSkipDelay() {
        return false;
    }

    public BaseFragment() {
        this.mIsQueryConnecting = false;
        this.isVisibleToUser = false;
        this.isViewInit = false;
        this.isFirst = true;
    }

    public void addPanelLayer() {
        if (isAddPanelLayer() == true) goto L5;
        return;
    L5:
        if (getPanelView() != null) goto L7;
        return;
    L7:
        if (this.mContext == null) goto L15;
        View r100 = new View(this.mContext);
        this.panelLayerView = r100;
        r100.setVisibility(8);
        if ((getPanelView() instanceof ViewGroup) == false) goto L11;
        ViewGroup.LayoutParams r101 = new ViewGroup.LayoutParams(-1, -1);
        ((ViewGroup) getPanelView()).addView(this.panelLayerView, r101);
        return;
    L11:
        this.panelLayerView = null;
        return;
    }

    public void doStandardAnim() {
        if (isUseNewAnim() == true) goto L5;
        return;
    L5:
        if (getOldRootView() != null) goto L9;
        if (getNewAnimView() != null) goto L9;
        return;
    L9:
        if (shouldSkipDelay() == false) goto L14;
        CJLogger.e(TAG, "跳过延迟");
        if (shouldSkipAnim() == false) goto L13;
        CJLogger.e(TAG, "跳过动画");
        AnimUtil.pushPageWithoutDelayWithoutAnim(this, getAnimCallback());
        return;
    L13:
        AnimUtil.pushPageWithoutDelayWithAnim(this, getAnimCallback());
        return;
    L14:
        AnimUtil.pushPage(this, getAnimCallback());
    }

    @Override // com.android.ttcjpaysdk.base.framework.AnimUtil.IAnimView
    public final Activity getAnimViewContext() {
        return getActivity();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        AnimUtil.onDestroy(this);
        FragmentTrackManager.remove(getClass().toString());
        int r100 = a.f202761a;
        a.j("dealloc", getFragmentName(), toString());
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        onVisibilityChange(false);
        int r100 = a.f202761a;
        a.j("viewWillDisappear", getFragmentName(), toString());
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (getUserVisibleHint() == false) goto L6;
        onVisibilityChange(true);
    L6:
        if (this.isFirst == false) goto L9;
        FragmentTrackManager.add(getClass().toString(), this);
    L9:
        if (FragmentTrackManager.isTop(getClass().toString(), this) == false) goto L11;
        reportPageShow(this);
    L11:
        this.isFirst = false;
        if (isUseNewAnim() == false) goto L14;
        AnimUtil.onResume(this, null);
    L14:
        int r100 = a.f202761a;
        a.j("viewDidAppear", getFragmentName(), toString());
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        int r100 = a.f202761a;
        a.j("viewWillAppear", getFragmentName(), toString());
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        int r100 = a.f202761a;
        a.j("viewDidDisappear", getFragmentName(), toString());
    }

    @Override // com.android.ttcjpaysdk.base.framework.AnimUtil.IAnimView
    public AnimUtil.AnimGroup getAnimGroup() {
        return AnimUtil.AnimGroup.DEFAULT;
    }

    public boolean getIsQueryConnecting() {
        return this.mIsQueryConnecting;
    }

    @Override // com.android.ttcjpaysdk.base.framework.AnimUtil.IAnimView
    public CJPayAnimRootView getNewAnimView() {
        return this.animRootView;
    }

    @Override // com.android.ttcjpaysdk.base.framework.AnimUtil.IAnimView
    public final View getOldRootView() {
        return this.mAnimLayoutRootView;
    }

    public static /* synthetic */ View access$000(BaseFragment r100) {
        return r100.panelLayerView;
    }

    private void reportPageShow(BaseFragment r100) {
        String r101 = r100.getFragmentName();
        if (TextUtils.isEmpty(r101) == false) goto L5;
        r101 = getClass().getSimpleName();
    L5:
        Lazy<DynamicEventTracker> r102 = DynamicEventTracker.f202325b;
        DynamicEventTracker.c.b("wallet_rd_common_page_show", "f_" + r101);
    }

    public <T> T getFragmentListener(Class<T> r100) {
        BaseFragmentListener r101 = this.mFragmentListener;
        if (r101 != null) goto L10;
        return null;
    L10:
        return r100.cast(r101);
    L7:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("BaseFragment#setFragmentListener", e);
        CJBasicCommonUtils.logCatch("CJCatch", "BaseFragment#setFragmentListener", e);
        return null;
    }

    public <T extends Parcelable> ArrayList<T> getParcelableArrayListParam(String r100) {
        if (getActivity() != null) goto L5;
        return null;
    L5:
        if (getActivity().getIntent() != null) goto L8;
        return null;
    L8:
        if (getActivity().getIntent().hasExtra(r100) == true) goto L13;
        getActivity().getIntent().getData();
        return null;
    L13:
        return getActivity().getIntent().getParcelableArrayListExtra(r100);
    }

    public Serializable getSerializableParam(String r100) {
        if (getActivity() != null) goto L5;
    L13:
        Serializable r101 = "";
    L14:
        if (r101 != null) goto L17;
        return "";
    L17:
        return r101;
    L5:
        if (getActivity().getIntent() == null) goto L13;
        if (getActivity().getIntent().hasExtra(r100) == false) goto L11;
        r101 = getActivity().getIntent().getSerializableExtra(r100);
        goto L14
    L11:
        if (getActivity().getIntent().getData() == null) goto L13;
        r101 = UriProtector.getQueryParameter(getActivity().getIntent().getData(), r100);
        goto L14
    }

    public Serializable getSerializableParamOrNull(String r100) {
        Serializable r101 = getSerializableParam(r100);
        if ((r101 instanceof String) == false) goto L6;
        return null;
    L6:
        return r101;
    }

    public String getStringParam(String r100) {
        if (getActivity() != null) goto L6;
        return "";
    L6:
        if (getActivity().getIntent() != null) goto L9;
    L7:
        String r101 = "";
    L14:
        if (r101 != null) goto L17;
        return "";
    L17:
        return r101;
    L9:
        if (getActivity().getIntent().hasExtra(r100) == false) goto L12;
        r101 = getActivity().getIntent().getStringExtra(r100);
        goto L14
    L12:
        if (getActivity().getIntent().getData() == null) goto L7;
        r101 = UriProtector.getQueryParameter(getActivity().getIntent().getData(), r100);
        goto L14
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle r100) {
        this.isFirst = true;
        super.onCreate(r100);
    }

    public void onHide(boolean r100) {
        FragmentTrackManager.remove(getClass().toString());
        if (r100 == false) goto L8;
        BaseFragment r101 = FragmentTrackManager.getTop();
        if (r101 == null) goto L9;
        reportPageShow(r101);
        return;
    L9:
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle r100) {
        CJPayDataKeepAPI.saveData(r100, this);
        super.onSaveInstanceState(r100);
    }

    public void onVisibilityChange(boolean r100) {
        if (r100 == false) goto L4;
        SourceManager.setSource(getSource());
        CJPayPerformance.getInstance().startKeepPage(getClass().toString());
        this.isVisibleToUser = true;
        return;
    L4:
        CJPayPerformance.getInstance().endKeepPage(getClass().toString());
        this.isVisibleToUser = false;
    }

    public void performPanelLayerViewVisible(boolean r100) {
        if (isAddPanelLayer() == false) goto L8;
        View r101 = this.panelLayerView;
        if (r101 == null) goto L9;
        CJPayAnimationUtils.viewPanelLayerAnimation(r101, r100, R.drawable.cj_pay_bg_fragment_container, new AnonymousClass3(this));
        return;
    L9:
        return;
    }

    public void setFragmentListener(BaseFragmentListener r100) {
        this.mFragmentListener = r100;
    }

    public void setIsQueryConnecting(boolean r100) {
        this.mIsQueryConnecting = r100;
    }

    @Override // androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean r100) {
        super.setUserVisibleHint(r100);
        getUserVisibleHint();
        if (isResumed() == false) goto L6;
        onVisibilityChange(r100);
        return;
    }

    public View createContentView(LayoutInflater r100, ViewGroup r101) {
        View r102 = getPreloadContentView();
        if (r102 == null) goto L9;
        ViewParent r103 = r102.getParent();
        if ((r103 instanceof ViewGroup) == false) goto L7;
        ((ViewGroup) r103).removeView(r102);
    L7:
        return r102;
    L9:
        return r100.inflate(getContentViewLayoutId(), r101, false);
    }

    public Boolean getBooleanParam(String r100, Boolean r101) {
        if (getActivity() != null) goto L5;
    L17:
        return r101;
    L5:
        if (getActivity().getIntent() == null) goto L17;
        if (getActivity().getIntent().hasExtra(r100) == false) goto L12;
        return Boolean.valueOf(getActivity().getIntent().getBooleanExtra(r100, r101.booleanValue()));
    L12:
        if (getActivity().getIntent().getData() == null) goto L17;
        return Boolean.valueOf(getActivity().getIntent().getData().getBooleanQueryParameter(r100, r101.booleanValue()));
    L15:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("BaseFragment#getActivity", e);
        CJBasicCommonUtils.logCatch("CJCatch", "BaseFragment#getActivity", e);
        goto L17
    }

    public int getIntParam(String r100, int r101) {
        if (getActivity() != null) goto L5;
    L18:
        return r101;
    L5:
        if (getActivity().getIntent() == null) goto L18;
        if (getActivity().getIntent().hasExtra(r100) == false) goto L12;
        return getActivity().getIntent().getIntExtra(r100, r101);
    L12:
        if (getActivity().getIntent().getData() == null) goto L18;
        return CastIntegerProtector.valueOf(UriProtector.getQueryParameter(getActivity().getIntent().getData(), r100)).intValue();
    L16:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("BaseFragment#getActivity", e);
        CJBasicCommonUtils.logCatch("CJCatch", "BaseFragment#getActivity", e);
        goto L18
    }

    public long getLongParam(String r100, long r101) {
        if (getActivity() != null) goto L5;
    L18:
        return r101;
    L5:
        if (getActivity().getIntent() == null) goto L18;
        if (getActivity().getIntent().hasExtra(r100) == false) goto L12;
        return getActivity().getIntent().getLongExtra(r100, r101);
    L12:
        if (getActivity().getIntent().getData() == null) goto L18;
        return CastLongProtector.valueOf(UriProtector.getQueryParameter(getActivity().getIntent().getData(), r100)).longValue();
    L16:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("BaseFragment#getActivity", e);
        CJBasicCommonUtils.logCatch("CJCatch", "BaseFragment#getActivity", e);
        goto L18
    }

    public String getStringRes(Context r100, int r101) {
        if (r100 != null) goto L4;
        return "";
    L4:
        return r100.getString(r101);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View r100, Bundle r101) {
        super.onViewCreated(r100, r101);
        initData();
        initViews(r100, r101);
        initActions(r100);
        this.isViewInit = true;
        doStandardAnim();
        int r102 = a.f202761a;
        a.j("viewDidLoad", getFragmentName(), toString());
    }

    public String getStringRes(Context r100, int r101, Object... r102) {
        if (r100 != null) goto L4;
        return "";
    L4:
        return r100.getString(r101, r102);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        CJLogger.d(TAG, "onCreateView".concat(getClass().getName()));
        if (r102 == null) goto L5;
        CJPayDataKeepAPI.restoreData(r102, this);
    L6:
        SourceManager.setSource(getSource());
        super.onCreateView(r100, r101, r102);     // Catch: Exception -> L9
    L11:
        this.mContext = getActivity();
        if (isUseNewAnim() == true) goto L14;
    L23:
        View r103 = hookRootView(createContentView(r100, r101));
        r103.setOnClickListener(new AnonymousClass2(this));
        bindViews(r103);
        CJLogger.d(TAG, "bindViews " + r103);
        addPanelLayer();
        this.mLayoutRootView = r103;
        return r103;
    L14:
        if (this.mContext == null) goto L23;
        CJPayAnimRootView r104 = new CJPayAnimRootView(this.mContext);
        this.animRootView = r104;
        View r105 = createContentView(r100, r104);
        if (r105 == null) goto L23;
        View r106 = hookRootView(this.animRootView);
        if (r106 == null) goto L23;
        r106.setOnClickListener(new AnonymousClass1(this));
        if (this.animRootView.addContainerView(r105) == false) goto L23;
        bindViews(r105);
        CJLogger.d(TAG, "bindViews " + r105);
        this.mLayoutRootView = r106;
        return r106;
    L9:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("BaseFragment#onCreateView", e);
        CJBasicCommonUtils.logCatch("CJCatch", "BaseFragment#onCreateView", e);
        CJReporter r107 = CJReporter.f202294a;
        CJReporter.l(CJPayCallBackCenter.getInstance().getCjContext(), "BaseFragment_createview", 1, getClass().getName(), e);
        goto L11
    L5:
        CJPayDataKeepAPI.autoWiredData(r102, this);
        goto L6
    }
}
