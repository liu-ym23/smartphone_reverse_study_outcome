package com.android.ttcjpaysdk.std.asset.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.LinearLayout;
import com.android.ttcjpaysdk.base.ktextension.CJPayBasicExtensionKt;
import com.android.ttcjpaysdk.std.asset.bean.StdAssetGroupBean;
import com.android.ttcjpaysdk.std.asset.bean.StdAssetItemBean;
import com.android.ttcjpaysdk.std.asset.bean.StdAssetListBean;
import com.android.ttcjpaysdk.std.asset.view.base.IAssetGroupView;
import com.android.ttcjpaysdk.std.asset.view.base.IAssetItemView;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.tencent.open.SocialConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u0001:\u0001DB\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ \u0010$\u001a\u00020\u001f2\b\u0010%\u001a\u0004\u0018\u00010\r2\u0006\u0010&\u001a\u00020\u00122\u0006\u0010'\u001a\u00020\u0012J\u0010\u0010(\u001a\u00020\u001b2\u0006\u0010)\u001a\u00020*H\u0016J\"\u0010+\u001a\u00020\r2\b\u0010%\u001a\u0004\u0018\u00010\r2\u0006\u0010&\u001a\u00020\u00122\u0006\u0010'\u001a\u00020\u0012H\u0002J\b\u0010,\u001a\u00020-H\u0016J\b\u0010.\u001a\u00020/H\u0016J(\u00100\u001a\u00020\u001f2\u0006\u00101\u001a\u00020\u001b2\u0006\u00102\u001a\u00020*2\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u000206H\u0002J\u0006\u00107\u001a\u00020\u001fJ\b\u00108\u001a\u00020\u001fH\u0002J\b\u00109\u001a\u00020\u0012H\u0002J\u0010\u0010:\u001a\u00020\u001f2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005J*\u0010:\u001a\u00020\u001f2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010;\u001a\u0004\u0018\u00010\r2\u0006\u0010&\u001a\u00020\u00122\u0006\u0010'\u001a\u00020\u0012J\u0012\u0010<\u001a\u00020\u00122\b\u0010=\u001a\u0004\u0018\u00010>H\u0016J\b\u0010?\u001a\u00020\u001fH\u0002J\u0006\u0010@\u001a\u00020\u001fJ\u000e\u0010A\u001a\u00020\u001f2\u0006\u0010B\u001a\u00020\u0018J\u0012\u0010C\u001a\u00020\u001f2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0002R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R&\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00120\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\u001b0\u001aj\b\u0012\u0004\u0012\u00020\u001b`\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#¨\u0006E"}, d2 = {"Lcom/android/ttcjpaysdk/std/asset/view/StdAssetListView;", "Landroid/widget/LinearLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "data", "Lcom/android/ttcjpaysdk/std/asset/bean/StdAssetListBean;", "(Landroid/content/Context;Lcom/android/ttcjpaysdk/std/asset/bean/StdAssetListBean;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "getAttrs", "()Landroid/util/AttributeSet;", "businessDesc", "", "businessFooterView", "Lcom/android/ttcjpaysdk/std/asset/view/CJBusinessFooterView;", "collapseMap", "", "", "getCollapseMap", "()Ljava/util/Map;", "setCollapseMap", "(Ljava/util/Map;)V", "mClickListener", "Lcom/android/ttcjpaysdk/std/asset/view/StdAssetListView$ClickListener;", "mGroupViewList", "Ljava/util/ArrayList;", "Lcom/android/ttcjpaysdk/std/asset/view/base/IAssetGroupView;", "Lkotlin/collections/ArrayList;", "onCollapseStateChange", "Lkotlin/Function0;", "", "getOnCollapseStateChange", "()Lkotlin/jvm/functions/Function0;", "setOnCollapseStateChange", "(Lkotlin/jvm/functions/Function0;)V", "applyBusinessFooter", SocialConstants.PARAM_APP_DESC, "isIndependentShow", "isExpand", "genGroupView", "bean", "Lcom/android/ttcjpaysdk/std/asset/bean/StdAssetGroupBean;", "getBusinessFooterDesc", "getBusinessFooterTopPadding", "", "getGroupLayoutParams", "Landroid/widget/LinearLayout$LayoutParams;", "handleCheckedStatus", "groupView", "groupData", "itemView", "Lcom/android/ttcjpaysdk/std/asset/view/base/IAssetItemView;", "itemData", "Lcom/android/ttcjpaysdk/std/asset/bean/StdAssetItemBean;", "hideLoading", "initView", "isLoading", "notifyDataChanged", "businessFooterDesc", "onInterceptTouchEvent", "ev", "Landroid/view/MotionEvent;", "refreshBusinessFooter", "requestItemsRelayout", "setOnAssetListClickListener", "listener", "updateData", "ClickListener", "bdpay-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class StdAssetListView extends LinearLayout {
    private final AttributeSet attrs;
    private String businessDesc;
    private CJBusinessFooterView businessFooterView;
    private Map<String, Boolean> collapseMap;
    private StdAssetListBean data;
    private ClickListener mClickListener;
    private final ArrayList<IAssetGroupView> mGroupViewList;
    private Function0<Unit> onCollapseStateChange;

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&J0\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&J(\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\u0010"}, d2 = {"Lcom/android/ttcjpaysdk/std/asset/view/StdAssetListView$ClickListener;", "", SendEventContainerMethodParamModel.EventKinds.onClick, "", "groupView", "Lcom/android/ttcjpaysdk/std/asset/view/base/IAssetGroupView;", "itemView", "Lcom/android/ttcjpaysdk/std/asset/view/base/IAssetItemView;", "groupData", "Lcom/android/ttcjpaysdk/std/asset/bean/StdAssetGroupBean;", "itemData", "Lcom/android/ttcjpaysdk/std/asset/bean/StdAssetItemBean;", "onOptionVoucherStateChanged", "checked", "", "shouldHandleCheckedStatusOnClick", "bdpay-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface ClickListener {

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        public static final class DefaultImpls {
            public static boolean shouldHandleCheckedStatusOnClick(ClickListener r100, IAssetGroupView r101, IAssetItemView r102, StdAssetGroupBean r103, StdAssetItemBean r104) {
                Intrinsics.checkNotNullParameter(r101, "groupView");
                Intrinsics.checkNotNullParameter(r102, "itemView");
                Intrinsics.checkNotNullParameter(r103, "groupData");
                Intrinsics.checkNotNullParameter(r104, "itemData");
                return true;
            }
        }

        void onClick(IAssetGroupView r100, IAssetItemView r101, StdAssetGroupBean r102, StdAssetItemBean r103);

        void onOptionVoucherStateChanged(boolean r100, IAssetGroupView r101, IAssetItemView r102, StdAssetGroupBean r103, StdAssetItemBean r104);

        boolean shouldHandleCheckedStatusOnClick(IAssetGroupView r100, IAssetItemView r101, StdAssetGroupBean r102, StdAssetItemBean r103);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initView() {
        StdAssetListBean r100 = this.data;
        if (r100 == null) goto L14;
        ArrayList<StdAssetGroupBean> r101 = r100.getGroupList();
        if (r101 == null) goto L22;
        Iterator<T> r102 = r101.iterator();
    L8:
        if (r102.hasNext() == false) goto L23;
        StdAssetGroupBean r103 = (StdAssetGroupBean) r102.next();
        ArrayList<StdAssetItemBean> r104 = r103.getAssetItemList();
        if (r104 == null) goto L8;
        if ((!r104.isEmpty()) == false) goto L8;
        IAssetGroupView r105 = genGroupView(r103);
        r105.setOnClickListener(new StdAssetListView$initView$1$1$1(this));
        Intrinsics.checkNotNull(r105, "null cannot be cast to non-null type android.view.View");
        addView((View) r105, getGroupLayoutParams());
        this.mGroupViewList.add(r105);
        goto L8
    L23:
        return;
    L22:
        return;
    }

    private final boolean isLoading() {
        Iterator<T> r100 = this.mGroupViewList.iterator();
    L4:
        if (r100.hasNext() == false) goto L9;
        if (((IAssetGroupView) r100.next()).isLoading() == false) goto L4;
        return true;
    L9:
        return false;
    }

    private final void refreshBusinessFooter() {
        CJBusinessFooterView r100 = this.businessFooterView;
        if (this.businessDesc.length() != 0) goto L5;
        boolean r101 = true;
    L6:
        ViewGroup r102 = null;
        if (r101 == false) goto L17;
        if (r100 == null) goto L10;
        ViewParent r103 = r100.getParent();
    L12:
        if ((r103 instanceof ViewGroup) == false) goto L14;
        r102 = (ViewGroup) r103;
    L14:
        if (r102 == null) goto L26;
        r102.removeView(r100);
        return;
    L26:
        return;
    L10:
        r103 = null;
        goto L12
    L17:
        if (r100 != null) goto L19;
        r100 = new CJBusinessFooterView(getContext(), null, 0, 6, null);
        this.businessFooterView = r100;
    L19:
        ViewParent r104 = r100.getParent();
        if ((r104 instanceof ViewGroup) == false) goto L22;
        r102 = (ViewGroup) r104;
    L22:
        if (r102 == null) goto L24;
        r102.removeView(r100);
    L24:
        r100.setContentTopPadding(getBusinessFooterTopPadding());
        r100.bindData(this.businessDesc);
        addView(r100, new LinearLayout.LayoutParams(-1, -2));
        return;
    L5:
        r101 = false;
        goto L6
    }

    public int getBusinessFooterTopPadding() {
        return CJPayBasicExtensionKt.dp(4.0f);
    }

    public LinearLayout.LayoutParams getGroupLayoutParams() {
        LinearLayout.LayoutParams r100 = new LinearLayout.LayoutParams(-1, -2);
        r100.bottomMargin = CJPayBasicExtensionKt.dp(12.0f);
        return r100;
    }

    public final void hideLoading() {
        Iterator<T> r100 = this.mGroupViewList.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((IAssetGroupView) r100.next()).hideLoading();
        goto L4
    }

    public final void requestItemsRelayout() {
        Iterator<T> r100 = this.mGroupViewList.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((IAssetGroupView) r100.next()).requestItemsRelayout();
        goto L4
    }

    public final AttributeSet getAttrs() {
        return this.attrs;
    }

    public final Map<String, Boolean> getCollapseMap() {
        return this.collapseMap;
    }

    public final Function0<Unit> getOnCollapseStateChange() {
        return this.onCollapseStateChange;
    }

    public static final /* synthetic */ StdAssetListBean access$getData$p(StdAssetListView r100) {
        return r100.data;
    }

    public static final /* synthetic */ ClickListener access$getMClickListener$p(StdAssetListView r100) {
        return r100.mClickListener;
    }

    private final void updateData(StdAssetListBean r100) {
        if (this.data != null) goto L5;
        this.data = r100;
        initView();
        return;
    L5:
        this.data = r100;
        Iterator<T> r101 = this.mGroupViewList.iterator();
    L7:
        if (r101.hasNext() == false) goto L35;
        IAssetGroupView r102 = (IAssetGroupView) r101.next();
        StdAssetListBean r103 = this.data;
        if (r103 == null) goto L7;
        ArrayList<StdAssetGroupBean> r104 = r103.getGroupList();
        if (r104 == null) goto L7;
        Iterator<T> r105 = r104.iterator();
    L14:
        if (r105.hasNext() == false) goto L18;
        Object r106 = r105.next();
        if (Intrinsics.areEqual(((StdAssetGroupBean) r106).getGroupType(), r102.groupViewType()) == false) goto L14;
    L19:
        StdAssetGroupBean r107 = (StdAssetGroupBean) r106;
        if (r107 == null) goto L7;
        r102.notifyDataChanged(r107);
        goto L7
    L18:
        r106 = null;
        goto L19
    }

    public IAssetGroupView genGroupView(StdAssetGroupBean r100) {
        Intrinsics.checkNotNullParameter(r100, "bean");
        return new StdAssetGroupView(getContext(), r100);
    }

    public final void notifyDataChanged(StdAssetListBean r100) {
        updateData(r100);
        refreshBusinessFooter();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r100) {
        if (r100 == null) goto L15;
        if (r100.getAction() != 1) goto L6;
        boolean r101 = true;
    L7:
        if (r101 == false) goto L9;
        MotionEvent r102 = r100;
    L10:
        if (r102 == null) goto L15;
        if (isLoading() == false) goto L15;
        return true;
    L9:
        r102 = null;
        goto L10
    L6:
        r101 = false;
    L15:
        return super.onInterceptTouchEvent(r100);
    }

    public final void setCollapseMap(Map<String, Boolean> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.collapseMap = r100;
    }

    public final void setOnAssetListClickListener(ClickListener r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.mClickListener = r100;
    }

    public final void setOnCollapseStateChange(Function0<Unit> r100) {
        this.onCollapseStateChange = r100;
    }

    public StdAssetListView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.attrs = r101;
        this.mGroupViewList = new ArrayList();
        this.collapseMap = new HashMap();
        this.businessDesc = "";
        setOrientation(1);
    }

    public static final /* synthetic */ void access$setData$p(StdAssetListView r100, StdAssetListBean r101) {
        r100.data = r101;
    }

    public StdAssetListView(Context r100, StdAssetListBean r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "data");
        this(r100, null);
        this.data = r101;
        initView();
    }

    private final String getBusinessFooterDesc(String r100, boolean r101, boolean r102) {
        if (CJBusinessFooterView.Companion.shouldShow(r100, r101, r102) == false) goto L6;
        if (r100 == null) goto L6;
        return r100;
    L6:
        return "";
    }

    public final void applyBusinessFooter(String r100, boolean r101, boolean r102) {
        this.businessDesc = getBusinessFooterDesc(r100, r101, r102);
        refreshBusinessFooter();
    }

    public /* synthetic */ StdAssetListView(Context r100, AttributeSet r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101);
    }

    private final void handleCheckedStatus(IAssetGroupView r100, StdAssetGroupBean r101, IAssetItemView r102, StdAssetItemBean r103) {
        if (r103.isArrowStyle() == true) goto L23;
        Iterator<T> r104 = this.mGroupViewList.iterator();
    L6:
        if (r104.hasNext() == false) goto L8;
        ((IAssetGroupView) r104.next()).clearItemCheckedStatus();
        goto L6
    L8:
        Iterator<T> r105 = this.mGroupViewList.iterator();
    L10:
        if (r105.hasNext() == false) goto L14;
        Object r106 = r105.next();
        if (Intrinsics.areEqual((IAssetGroupView) r106, r100) == false) goto L10;
    L15:
        IAssetGroupView r107 = (IAssetGroupView) r106;
        if (r107 == null) goto L24;
        r107.setItemChecked(r103);
        return;
    L24:
        return;
    L14:
        r106 = null;
        goto L15
    }

    public final void notifyDataChanged(StdAssetListBean r100, String r101, boolean r102, boolean r103) {
        this.businessDesc = getBusinessFooterDesc(r101, r102, r103);
        updateData(r100);
        refreshBusinessFooter();
    }

    public static final /* synthetic */ void access$handleCheckedStatus(StdAssetListView r100, IAssetGroupView r101, StdAssetGroupBean r102, IAssetItemView r103, StdAssetItemBean r104) {
        r100.handleCheckedStatus(r101, r102, r103, r104);
    }
}
