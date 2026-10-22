package com.bytedanceos.common.ui.utils;

import android.text.TextUtils;
import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.model.AppList;
import com.bytedanceos.common.ui.adapter.TopicListAdapter;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class TopicItemParser {
    private static final int LIST_MIN_SIZE = 5;
    private static final int PAGER_MIN_SIZE = 8;

    public TopicItemParser() {
    }

    private static void addDivLine(List<TopicListAdapter.TopicItem> r10) {
        r10.add(new TopicListAdapter.TopicItem(101));
    }

    private static void addListViewItem(List<TopicListAdapter.TopicItem> r10, List<AppInfo> r11, int r12, int r13) {
    L2:
        if (r12 >= r13) goto L4;
        r10.add(new TopicListAdapter.TopicItem(6, r11.get(r12)));
        r12 = r12 + 1;
        goto L2
    }

    private static void addPagerItem(List<TopicListAdapter.TopicItem> r10, List<AppInfo> r11, int r12, int r13) {
        CopyOnWriteArrayList r14 = new CopyOnWriteArrayList();
    L3:
        if (r12 >= r13) goto L5;
        r14.add(r11.get(r12));
        r12 = r12 + 1;
        goto L3
    L5:
        r10.add(new TopicListAdapter.TopicItem(7, r14));
    }

    public static List<TopicListAdapter.TopicItem> getAutoGroupTopicItems(AppList r10, boolean r11) {
        CopyOnWriteArrayList r12 = new CopyOnWriteArrayList();
        int r13 = 0;
        if (r11 == true) goto L5;
    L11:
        List<AppInfo> r14 = r10.getDataList();
        if (r14 != null) goto L14;
    L25:
        return r12;
    L14:
        if (r14.isEmpty() == true) goto L25;
        int r15 = r14.size();
        if (r15 > 13) goto L19;
        c9.a.e(0, r14);
        addListViewItem(r12, r14, 0, r15);
        goto L25
    L19:
        int r16 = r15 / 13;
        if ((r15 % 13) != 0) goto L22;
        r16 = r16 - 1;
    L22:
        if (r13 >= r16) goto L24;
        int r17 = r13 * 13;
        int r18 = r17 + 5;
        int r19 = r17 + 13;
        c9.a.e(r13, r14.subList(r17, r18));
        addListViewItem(r12, r14, r17, r18);
        addDivLine(r12);
        r13 = r13 + 1;
        c9.a.e(r13, r14.subList(r18, r19));
        addPagerItem(r12, r14, r18, r19);
        goto L22
    L24:
        int r20 = r16 * 13;
        addDivLine(r12);
        c9.a.e(r16 + 1, r14.subList(r20, r15));
        addListViewItem(r12, r14, r20, r15);
        goto L25
    L5:
        if (r10.getBannerUrl() == null) goto L11;
        if (TextUtils.isEmpty(r10.getBannerUrl().get(0)) == true) goto L11;
        r12.add(new TopicListAdapter.TopicItem(r10.getBannerType(), r10.getBannerUrl().get(0)));
        if (TextUtils.isEmpty(r10.getIntroduce()) == true) goto L11;
        r12.add(new TopicListAdapter.TopicItem(117, r10.getIntroduce()));
        goto L11
    }
}
