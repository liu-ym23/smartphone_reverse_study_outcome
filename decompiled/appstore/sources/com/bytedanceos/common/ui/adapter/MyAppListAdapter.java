package com.bytedanceos.common.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.widget.ListView;
import android.widget.TextView;
import com.bytedanceos.common.R$dimen;
import com.bytedanceos.common.R$id;
import com.bytedanceos.common.R$layout;
import com.bytedanceos.common.R$string;
import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.ui.animation.AlphaInAnimation;
import com.bytedanceos.common.ui.animation.AlphaOutAnimation;
import com.bytedanceos.common.ui.animation.SlideDownAnimation;
import com.bytedanceos.common.ui.animation.SqueezeAnimation;
import com.bytedanceos.common.ui.myapplist.MyAppListInteraction;
import com.bytedanceos.common.ui.widget.MyAppSwipeItemView;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public class MyAppListAdapter extends AppListAdapter implements MyAppListInteraction.InteractionAdapter {
    public static final String CATEGORY_SECTION_HEADER = "section_header";
    public static final String SECTION_HEADER_DOWNLOAD_QUEUE = "section_header_download_queue";
    public static final String SECTION_HEADER_LOCAL_APP = "section_header_local_app";
    private static final String SECTION_HEADER_VERSION_NAME = "section_header_version_name";
    public final AppInfo HEADER_DOWNLOAD_QUEUE;
    public final AppInfo HEADER_LOCAL_APP;
    private HashMap<Integer, Animation.AnimationListener> mAddAnimListeners;
    private ArrayList<Integer> mAddAnimPositions;
    private HashMap<Integer, Animation.AnimationListener> mDelAnimListeners;
    private ArrayList<Integer> mDelAnimPositions;

    /* JADX INFO: renamed from: com.bytedanceos.common.ui.adapter.MyAppListAdapter$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public class HeaderViewHolder implements AppListAdapter.BaseHolder {
        TextView header;
        final /* synthetic */ MyAppListAdapter this$0;

        private HeaderViewHolder(MyAppListAdapter r10) {
            this.this$0 = r10;
        }

        @Override // com.bytedanceos.common.ui.adapter.AppListAdapter.BaseHolder
        public int getConvertViewRid() {
            return R$layout.myapplist_section_header;
        }

        @Override // com.bytedanceos.common.ui.adapter.AppListAdapter.BaseHolder
        public void initConvertView(View r10) {
            this.header = (TextView) r10.findViewById(R$id.tv_header);
        }

        @Override // com.bytedanceos.common.ui.adapter.AppListAdapter.BaseHolder
        public void invalidateConvertView(int r10, View r11) {
            this.header.setText(this.this$0.mDataList.get(r10).appName);
        }

        public /* synthetic */ HeaderViewHolder(MyAppListAdapter r10, AnonymousClass1 r11) {
            this(r10);
        }
    }

    public MyAppListAdapter(Context r10, ListView r11, View.OnClickListener r12, View.OnClickListener r13, MyAppSwipeItemView.OnSwipeItemActionListener r14, View.OnLongClickListener r15) {
        super(r10, r11, r12, r13, r14, r15);
        this.mAddAnimPositions = new ArrayList();
        this.mDelAnimPositions = new ArrayList();
        this.mAddAnimListeners = new HashMap();
        this.mDelAnimListeners = new HashMap();
        this.HEADER_LOCAL_APP = newHeader("section_header_local_app", r10.getString(R$string.myapp_installed_apps));
        this.HEADER_DOWNLOAD_QUEUE = newHeader("section_header_download_queue", r10.getString(R$string.downloading));
    }

    private void doAnimateAdd(View r10, int r11) {
        AnimationSet r12 = new AnimationSet(false);
        r12.addAnimation(new SlideDownAnimation(r10, r10.getMinimumHeight()));
        r12.addAnimation(new AlphaInAnimation());
        r12.setAnimationListener(this.mAddAnimListeners.get(Integer.valueOf(r11)));
        r10.startAnimation(r12);
        this.mAddAnimPositions.remove(Integer.valueOf(r11));
    }

    private void doAnimateDel(View r10, int r11) {
        AnimationSet r12 = new AnimationSet(true);
        r12.setDuration(300);
        r12.addAnimation(new SqueezeAnimation(r10, r10.getMinimumHeight()));
        r12.addAnimation(new AlphaOutAnimation());
        r12.setAnimationListener(this.mDelAnimListeners.get(Integer.valueOf(r11)));
        r10.startAnimation(r12);
        this.mDelAnimPositions.remove(Integer.valueOf(r11));
    }

    private void handleAnimation(View r10, int r11) {
        if (this.mAddAnimPositions.contains(Integer.valueOf(r11)) == false) goto L6;
        doAnimateAdd(r10, r11);
        return;
    L6:
        if (this.mDelAnimPositions.contains(Integer.valueOf(r11)) == false) goto L10;
        doAnimateDel(r10, r11);
        return;
    }

    private static AppInfo newHeader(String r10, String r11) {
        AppInfo r12 = new AppInfo();
        r12.appCategoryName = "section_header";
        r12.appPackageName = r10;
        r12.appName = r11;
        r12.appVersionName = SECTION_HEADER_VERSION_NAME;
        return r12;
    }

    @Override // com.bytedanceos.common.ui.myapplist.MyAppListInteraction.InteractionAdapter
    public void animateAdd(int r10, Animation.AnimationListener r11) {
        this.mAddAnimPositions.add(Integer.valueOf(r10));
        this.mAddAnimListeners.put(Integer.valueOf(r10), r11);
    }

    @Override // com.bytedanceos.common.ui.myapplist.MyAppListInteraction.InteractionAdapter
    public void animateDelete(int r10, Animation.AnimationListener r11) {
        this.mDelAnimPositions.add(Integer.valueOf(r10));
        this.mDelAnimListeners.put(Integer.valueOf(r10), r11);
    }

    @Override // com.bytedanceos.common.ui.myapplist.MyAppListInteraction.InteractionAdapter
    public void clearAnimation() {
        this.mAddAnimPositions.clear();
        this.mDelAnimPositions.clear();
    }

    @Override // com.bytedanceos.common.ui.adapter.AppListAdapter
    public View getConvertView(int r10, AppListAdapter.BaseHolder r11) {
        int r12 = getItemViewType(r10);
        if (r12 != 0) goto L5;
        LayoutInflater r13 = this.mInflater;
        if (this.mIsBigFont == false) goto L15;
        int r14 = R$layout.myapp_swipe_list_item_1x4;
    L16:
        View r15 = r13.inflate(r14, null);
        ((MyAppSwipeItemView) r15).setSwipeItemActionListener(getOnSwipeItemActionListener());
        return r15;
    L15:
        r14 = R$layout.myapp_swipe_list_item;
        goto L16
    L5:
        if (r12 == 1) goto L19;
        if (r12 != 2) goto L10;
        return this.mInflater.inflate(r11.getConvertViewRid(), null);
    L10:
        throw new IllegalStateException("unknown item view type at position: " + r10);
    L19:
        return this.mInflater.inflate(R$layout.app_item_view_imp, null);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter, com.bytedanceos.common.ui.myapplist.MyAppListInteraction.InteractionAdapter
    public int getItemViewType(int r10) {
        int r11 = this.mDataList.indexOf(this.HEADER_DOWNLOAD_QUEUE);
        int r12 = this.mDataList.indexOf(this.HEADER_LOCAL_APP);
        if (r10 == r11) goto L14;
        if (r10 != r12) goto L7;
        return 2;
    L7:
        if (r12 != (-1)) goto L9;
        r12 = this.mDataList.size();
    L9:
        if (r10 <= r12) goto L12;
        return 1;
    L12:
        return 0;
    L14:
        return 2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r10v0, types: [com.bytedanceos.common.ui.adapter.AppListAdapter, com.bytedanceos.common.ui.adapter.MyAppListAdapter] */
    /* JADX WARN: Type inference failed for: r12v2, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r12v3, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r12v5 */
    /* JADX WARN: Type inference failed for: r12v6 */
    /* JADX WARN: Type inference failed for: r13v10 */
    /* JADX WARN: Type inference failed for: r13v3, types: [com.bytedanceos.common.ui.adapter.AppListAdapter$BaseHolder, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r13v4, types: [com.bytedanceos.common.ui.adapter.AppListAdapter$BaseHolder] */
    /* JADX WARN: Type inference failed for: r13v9 */
    /* JADX WARN: Type inference failed for: r1v3 */
    @Override // com.bytedanceos.common.ui.adapter.AppListAdapter, android.widget.Adapter
    public View getView(int r11, View r12, ViewGroup r13) {
        int r14 = getItemViewType(r11);
        boolean r10 = true;
        if (r14 == 0) goto L10;
        if (r14 == 1) goto L9;
        if (r14 == 2) goto L9;
        throw new IllegalStateException("unknown item view type at position: " + r11);
    L9:
        setShowAppItemType(0);
        setMyAppSwipeType(0);
    L11:
        if (r12 != null) goto L13;
    L15:
        r10 = false;
    L16:
        if (r12 == null) goto L20;
        if (r10 == true) goto L20;
        AppListAdapter.BaseHolder r15 = (AppListAdapter.BaseHolder) r12.getTag();
        ?? r16 = r12;
        ?? r17 = r15;
    L24:
        if (r17 == 0) goto L32;
        if ((r17 instanceof AppListAdapter.NormalHolder) == false) goto L32;
        if (r10 == false) goto L32;
        AppListAdapter.NormalHolder r18 = (AppListAdapter.NormalHolder) r17;
        if (r18.appIcon == null) goto L32;
        int r19 = this.mContext.getResources().getDimensionPixelSize(R$dimen.app_icon_size);
        r18.appIcon.setTop(0);
        r18.appIcon.setBottom(r19);
        r18.appIcon.setLeft(0);
        r18.appIcon.setRight(r19);
    L32:
        if ((r17 instanceof AppListAdapter.NormalHolder) == false) goto L34;
        ((AppListAdapter.NormalHolder) r17).bindData(this.mHeaderViewCount, this.mDataList, this.mAppNoMap, this.mIsEditMode, this.mSelectedApps, this.mOffset);
    L34:
        r17.invalidateConvertView(r11, r16);
        handleAnimation(r16, r11);
        return r16;
    L20:
        ?? r110 = getViewHolder(r11);
        if ((r110 instanceof AppListAdapter.NormalHolder) == false) goto L23;
        ((AppListAdapter.NormalHolder) r110).initData(this.mShowItemType, this.mSwipeItemType, this.mOnBtnClickListener, this.mOnItemClickListener, this.mOnLongClickListener, this.mSupposeListener);
    L23:
        ?? r111 = getConvertView(r11, r110);
        r110.initConvertView(r111);
        r111.setTag(r110);
        r16 = r111;
        r17 = r110;
        goto L24
    L13:
        if (r12.getTag(R$id.convert_view_discarded) != Boolean.TRUE) goto L15;
    L10:
        setShowAppItemType(2);
        setMyAppSwipeType(5);
        MyAppSwipeItemView.setItemSwipeType(5);
        goto L11
    }

    @Override // com.bytedanceos.common.ui.adapter.AppListAdapter
    public AppListAdapter.BaseHolder getViewHolder(int r10) {
        if (2 != getItemViewType(r10)) goto L6;
        return new HeaderViewHolder(this, null);
    L6:
        return new AppListAdapter.NormalHolder(isNeedSuppose());
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 3;
    }
}
