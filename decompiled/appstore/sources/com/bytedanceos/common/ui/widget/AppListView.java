package com.bytedanceos.common.ui.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.bytedanceos.common.R$id;
import com.bytedanceos.common.R$layout;
import com.bytedanceos.common.model.AppList;
import com.bytedanceos.common.toolbox.f0;
import com.bytedanceos.common.ui.adapter.AppListAdapter;
import com.bytedanceos.common.ui.adapter.GameGiftAdapter;
import com.bytedanceos.common.ui.adapter.MyAppListAdapter;
import com.bytedanceos.common.ui.adapter.PromoteListAdapt;
import com.bytedanceos.common.ui.adapter.SectionListAdapter;
import com.bytedanceos.common.ui.listener.IRelatedClickListener;

/* JADX INFO: loaded from: classes2.dex */
public class AppListView {
    public static final int ADAPT_NORMAL = 0;
    public static final int ADAPT_PROMOTE = 1;
    public static final int STATE_EMPTY = 3;
    public static final int STATE_IDLE = 0;
    public static final int STATE_INIT = 1;
    public static final int STATE_LOAD_NEXT = 2;
    public static final int STATE_LOAD_OVER = 6;
    public static final int STATE_REFRESH = 4;
    public static final int STATE_UNLOGIN = 5;

    public AppListView() {
    }

    public static MyAppSwipeListView createMyAppListView(ViewGroup r10, MyAppSwipeListView r11, View r12, View.OnClickListener r13, View.OnClickListener r14, MyAppSwipeItemView.OnSwipeItemActionListener r15, View.OnLongClickListener r16) {
        if (r11 != null) goto L7;
        Context r17 = r10.getContext();
        r11 = (MyAppSwipeListView) View.inflate(r17, R$layout.app_swipe_list, null);
        r11.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        if (r12 == null) goto L6;
        r11.addHeaderView(r12);
    L6:
        r10.addView(r11);
        r11.setAdapter(new MyAppListAdapter(r17, r11, r14, r13, r15, r16));
    L7:
        resetListView(new ListView[]{r11});
        return r11;
    }

    public static ListView createNormalListView(ViewGroup r10, ListView r11, View r12, View r13, View.OnClickListener r14, View.OnClickListener r15, View.OnLongClickListener r16) {
        if (r11 != null) goto L9;
        Context r17 = r10.getContext();
        r11 = (ListView) View.inflate(r17, R$layout.app_normal_list, null);
        r11.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        if (r12 == null) goto L6;
        r11.addHeaderView(r12);
    L6:
        if (r13 == null) goto L8;
        r11.addFooterView(r13);
    L8:
        r10.addView(r11);
        r11.setAdapter(new AppListAdapter(r17, r11, r15, r14, null, r16));
    L9:
        resetListView(new ListView[]{r11});
        return r11;
    }

    public static RefreshLoadListView createRefreshLoadListView(ViewGroup r10, RefreshLoadListView r11, View.OnClickListener r12, View.OnClickListener r13, Object r14, View r15, View r16, View.OnLongClickListener r17) {
        return createRefreshLoadListView(r10, r11, r12, r13, r14, r15, r16, r17, 1);
    }

    public static RefreshLoadListView createSearchAppListView(ViewGroup r10, RefreshLoadListView r11, View.OnClickListener r12, View.OnClickListener r13, Object r14, View.OnLongClickListener r15) {
        return createSearchAppListView(r10, r11, r12, r13, r14, r15, null, null);
    }

    public static MyAppSwipeListView createSwipeListView(ViewGroup r10, MyAppSwipeListView r11, int r12, int r13, View r14, View.OnClickListener r15, MyAppSwipeItemView.OnSwipeItemActionListener r16, View.OnLongClickListener r17) {
        if (r11 != null) goto L7;
        Context r18 = r10.getContext();
        r11 = (MyAppSwipeListView) View.inflate(r18, R$layout.app_swipe_list, null);
        r11.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        if (r14 == null) goto L6;
        r11.addHeaderView(r14);
    L6:
        r10.addView(r11);
        AppListAdapter r19 = new AppListAdapter(r18, r11, r15, null, r16, r17);
        r19.setShowAppItemType(r12);
        r19.setMyAppSwipeType(r13);
        r11.setAdapter(r19);
    L7:
        resetListView(new ListView[]{r11});
        return r11;
    }

    public static Object getKey(ListView r10) {
        if (r10 != null) goto L6;
        return null;
    L6:
        return r10.getTag(R$id.app_list_key);
    }

    public static int getLastId(ListView r10) {
        if (r10 != null) goto L8;
        return 0;
    L8:
        return Integer.parseInt(String.valueOf(r10.getTag(R$id.last_app_id)));
    L7:
        return 0;
    }

    public static int getPage(ListView r10) {
        if (r10 != null) goto L8;
        return -1;
    L8:
        return Integer.parseInt(String.valueOf(r10.getTag(R$id.app_list_page)));
    L7:
        return -1;
    }

    public static int getState(ListView r10) {
        if (r10 != null) goto L6;
        return 0;
    L6:
        return Integer.parseInt(String.valueOf(r10.getTag(R$id.app_list_state)));
    }

    public static String getTraceId(ListView r10) {
        if (r10 != null) goto L8;
        return null;
    L8:
        return String.valueOf(r10.getTag(R$id.trace_id));
    L7:
        return null;
    }

    public static boolean isFirstPage(ListView r10) {
        if (getPage(r10) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public static void onLoad(RefreshLoadListView r10) {
        if (r10 == null) goto L5;
        r10.stopRefresh();
        r10.stopLoadMore();
        setState(r10, 6);
        return;
    }

    public static void resetListView(ListView... r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (r10.length == 0) goto L24;
        int r11 = r10.length;
        int r12 = 0;
    L7:
        if (r12 >= r11) goto L25;
        ListView r13 = r10[r12];
        if (r13 == null) goto L19;
        if ((r13.getAdapter() instanceof HeaderViewListAdapter) == false) goto L14;
        AppListAdapter r14 = (AppListAdapter) ((HeaderViewListAdapter) r13.getAdapter()).getWrappedAdapter();
    L15:
        r14.getDataList().clear();
        r14.notifyDataSetChanged();
        r13.setVisibility(8);
        if ((r13 instanceof RefreshLoadListView) == false) goto L18;
        resetListViewPage((RefreshLoadListView) r13);
    L18:
        setState(r13, 0);
        setKey(r13, null);
        goto L19
    L14:
        r14 = (AppListAdapter) r13.getAdapter();
    L19:
        r12 = r12 + 1;
        goto L7
    L25:
        return;
    }

    public static void resetListViewPage(RefreshLoadListView r10) {
        if (r10 == null) goto L5;
        r10.setTag(R$id.app_list_page, 1);
        return;
    }

    public static void setKey(ListView r10, Object r11) {
        if (r10 == null) goto L5;
        r10.setTag(R$id.app_list_key, r11);
        return;
    }

    public static void setState(View r10, int r11) {
        if (r10 != null) goto L4;
        return;
    L4:
        r10.setTag(R$id.app_list_state, Integer.valueOf(r11));
    }

    public static void updateListView(RefreshLoadListView r10, AppList r11, boolean r12) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (r10.getAdapter() == null) goto L16;
        AppListAdapter r13 = (AppListAdapter) ((HeaderViewListAdapter) r10.getAdapter()).getWrappedAdapter();
        if (r12 == false) goto L9;
        f0.b(r11.getDataList(), r13.getDataList().size());
    L9:
        int r14 = getPage(r10);
        if (r14 != 1) goto L12;
        r13.setCanUpdate(true);
        r13.setDataList(r11.getDataList());
    L13:
        r10.setPullLoadEnable(r11.hasMore());
        r10.setTag(R$id.app_list_page, Integer.valueOf(r14 + 1));
        r10.setTag(R$id.last_app_id, Integer.valueOf(r11.getLastId()));
        r10.setTag(R$id.trace_id, r11.getTraceId());
        return;
    L12:
        r13.addDataList(r11.getDataList());
        goto L13
    }

    public static void updateListViewWithPage(RefreshLoadListView r10, AppList r11) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (r10.getAdapter() == null) goto L13;
        AppListAdapter r12 = (AppListAdapter) ((HeaderViewListAdapter) r10.getAdapter()).getWrappedAdapter();
        int r13 = getPage(r10);
        if (r13 != 1) goto L9;
        r12.setCanUpdate(true);
        r12.setDataList(r11.getDataList());
    L10:
        f0.a(r11.getDataList(), r13);
        r10.setPullLoadEnable(r11.hasMore());
        r10.setTag(R$id.app_list_page, Integer.valueOf(r13 + 1));
        r10.setTag(R$id.last_app_id, Integer.valueOf(r11.getLastId()));
        r10.setTag(R$id.trace_id, r11.getTraceId());
        return;
    L9:
        r12.addDataList(r11.getDataList());
        goto L10
    }

    public static RefreshLoadListView createRefreshLoadListView(ViewGroup r13, RefreshLoadListView r14, View.OnClickListener r15, View.OnClickListener r16, Object r17, View r18, View r19, View.OnLongClickListener r20, int r21) {
        if (r14 != null) goto L14;
        Context r10 = r13.getContext();
        RefreshLoadListView r12 = (RefreshLoadListView) View.inflate(r10, R$layout.app_refresh_list, null);
        if (r18 == null) goto L7;
        r12.addHeaderView(r18, null, false);
    L7:
        if (r19 == null) goto L9;
        r12.addFooterView(r19, null, false);
    L9:
        r12.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        r13.addView(r12);
        if (r21 == 1) goto L12;
        ListAdapter r11 = new AppListAdapter(r10, r12, r16, r15, null, r20);
    L13:
        r12.setAdapter(r11);
        r12.setPullRefreshEnable(false);
    L15:
        r12.setTag(R$id.app_list_page, 1);
        r12.setPullLoadEnable(true);
        resetListView(new ListView[]{r12});
        setKey(r12, r17);
        return r12;
    L12:
        r11 = new PromoteListAdapt(r10, r12, r16, r15, null, r20, 0);
        goto L13
    L14:
        r12 = r14;
        goto L15
    }

    public static RefreshLoadListView createSearchAppListView(ViewGroup r12, RefreshLoadListView r13, View.OnClickListener r14, View.OnClickListener r15, Object r16, View.OnLongClickListener r17, IRelatedClickListener r18, SubButton.OnSubListener r19) {
        if (r13 != null) goto L8;
        Context r10 = r12.getContext();
        PinnedHeaderListView r11 = (PinnedHeaderListView) View.inflate(r10, R$layout.app_search_list, null);
        r11.setPinnedHeaderView(LayoutInflater.from(r10).inflate(R$layout.app_list_split_item, r11, false));
        SectionListAdapter r110 = new SectionListAdapter(r10, r11, r15, r14, null, r17);
        if (r18 == null) goto L7;
        r110.setiRelatedClickListener(r18);
        r110.setSubButtonListener(r19);
    L7:
        r11.setOnScrollListener(r110);
        r11.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        r12.addView(r11);
        r11.setAdapter(r110);
        r11.setPullRefreshEnable(false);
        RefreshLoadListView r111 = r11;
    L9:
        r111.setTag(R$id.app_list_page, 1);
        r111.setPullLoadEnable(true);
        resetListView(new ListView[]{r111});
        setKey(r111, r16);
        return r111;
    L8:
        r111 = r13;
        goto L9
    }

    public static void updateListView(RefreshLoadListView r10, AppList r11) {
        updateListView(r10, r11, false);
    }

    public static void updateListView(RefreshLoadListView r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (r10.getAdapter() == null) goto L8;
        ((AppListAdapter) ((HeaderViewListAdapter) r10.getAdapter()).getWrappedAdapter()).notifyDataSetChanged();
        return;
    }

    public static RefreshLoadListView createRefreshLoadListView(ViewGroup r10, View.OnClickListener r11, View.OnClickListener r12, Object r13) {
        Context r14 = r10.getContext();
        RefreshLoadListView r15 = (RefreshLoadListView) View.inflate(r14, R$layout.app_refresh_list, null);
        r15.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        r15.setAdapter(new PromoteListAdapt(r14, r15, r12, r11, null, null, 0));
        r15.setPullRefreshEnable(false);
        r15.setTag(R$id.app_list_page, 1);
        r15.setPullLoadEnable(true);
        resetListView(new ListView[]{r15});
        setKey(r15, r13);
        return r15;
    }

    public static RefreshLoadListView createRefreshLoadListView(Context r14, RefreshLoadListView r15, View.OnClickListener r16, View.OnClickListener r17, Object r18, View r19, View r20, View.OnLongClickListener r21, int r22, int r23) {
        if (r15 != null) goto L14;
        RefreshLoadListView r10 = (RefreshLoadListView) View.inflate(r14, R$layout.app_refresh_list, null);
        if (r19 == null) goto L7;
        r10.addHeaderView(r19, null, false);
    L7:
        if (r20 == null) goto L9;
        r10.addFooterView(r20, null, false);
    L9:
        r10.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        if (r22 == 1) goto L12;
        ListAdapter r11 = new AppListAdapter(r14, r10, r17, r16, null, r21);
    L13:
        r10.setAdapter(r11);
        r10.setPullRefreshEnable(false);
    L15:
        r10.setTag(R$id.app_list_page, 1);
        r10.setPullLoadEnable(true);
        resetListView(new ListView[]{r10});
        setKey(r10, r18);
        return r10;
    L12:
        r11 = new PromoteListAdapt(r14, r10, r17, r16, null, r21, r23);
        goto L13
    L14:
        r10 = r15;
        goto L15
    }

    public static RefreshLoadListView createRefreshLoadListView(ViewGroup r10, RefreshLoadListView r11, View.OnClickListener r12, int r13) {
        if (r11 != null) goto L5;
        r11 = (RefreshLoadListView) View.inflate(r10.getContext(), R$layout.app_refresh_list, null);
        r11.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        r10.addView(r11);
        r11.setAdapter(new GameGiftAdapter(r12, r13));
    L7:
        r11.setPullRefreshEnable(false);
        r11.setTag(R$id.app_list_page, 1);
        r11.setPullLoadEnable(true);
        r11.setVisibility(8);
        setState(r11, 0);
        return r11;
    L5:
        if (r11.getAdapter() == null) goto L7;
        ((GameGiftAdapter) ((HeaderViewListAdapter) r11.getAdapter()).getWrappedAdapter()).clear();
        goto L7
    }
}
