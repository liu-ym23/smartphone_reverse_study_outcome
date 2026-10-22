package com.bytedanceos.common.ui.fragment;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.HeaderViewListAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedanceos.common.BaseApplication;
import com.bytedanceos.common.R$drawable;
import com.bytedanceos.common.R$id;
import com.bytedanceos.common.R$layout;
import com.bytedanceos.common.R$string;
import com.bytedanceos.common.ad.param.AdReportParam;
import com.bytedanceos.common.model.AppComments;
import com.bytedanceos.common.model.CommentInfo;
import com.bytedanceos.common.toolbox.e;
import com.bytedanceos.common.ui.adapter.CommentsAdapter;
import com.bytedanceos.common.ui.widget.RefreshLoadListView;
import com.obric.oui.progress.OProgressView;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class AppCommentsView {
    public static final int COMMENT_MAX_ROWS = 4;

    public AppCommentsView() {
    }

    public static ViewGroup createAppCommentsView(ViewGroup r10, ViewGroup r11, Context r12, AdapterView.OnItemClickListener r13, View.OnClickListener r14, Object r15) {
        RefreshLoadListView r16 = null;
        if (r11 != null) goto L5;
    L6:
        r11 = (ViewGroup) View.inflate(r12, R$layout.appinfo_comment_list, null);
        r11.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        r10.addView(r11);
        RefreshLoadListView r17 = (RefreshLoadListView) r11.findViewById(R$id.appComments_lv);
        r17.addHeaderView(View.inflate(r12, R$layout.appinfo_comment_header, null));
        r17.setPullRefreshEnable(false);
        r17.setAdapter(new CommentsAdapter(r12, r14));
        r16 = r17;
    L7:
        r11.setVisibility(8);
        r11.setTag(r15);
        r11.setTag(R$id.app_comments_page, 1);
        r16.setPullLoadEnable(true);
        return r11;
    L5:
        if (r11.getChildCount() != 0) goto L7;
        goto L6
    }

    public static int getPage(ViewGroup r10) {
        if (r10 != null) goto L6;
        return -1;
    L6:
        return Integer.parseInt(String.valueOf(r10.getTag(R$id.app_comments_page)));
    }

    public static void onLoad(ViewGroup r10) {
        RefreshLoadListView r11 = (RefreshLoadListView) r10.findViewById(R$id.appComments_lv);
        if (r11 == null) goto L6;
        r11.stopRefresh();
        r11.stopLoadMore();
        return;
    }

    public static void updateAppCommentsView(ViewGroup r12, AppComments r13) {
        RefreshLoadListView r10 = (RefreshLoadListView) r12.findViewById(R$id.appComments_lv);
        int r11 = getPage(r12);
        if (r13 != null) goto L5;
    L18:
        if (r11 != 1) goto L20;
        updateCommentHeader(r12, 0.0f, 0, R$drawable.rate_none, null, AdReportParam.ClickPosType.SKIP);
        r10.setVisibility(8);
    L20:
        r10.setPullLoadEnable(false);
        return;
    L5:
        if (r13.isEmpty() == true) goto L18;
        if (r11 != 1) goto L9;
        int r14 = e.b0(r12.getContext(), r13.getAverageScore(), false);
        updateCommentHeader(r12, r13.getAverageScore(), r13.getScoresCnt(), r14, r13.getScoreMap(), String.valueOf(r13.getCommentsCnt()));
    L9:
        r10.setVisibility(0);
        CommentsAdapter r15 = (CommentsAdapter) ((HeaderViewListAdapter) r10.getAdapter()).getWrappedAdapter();
        if (r11 != 1) goto L12;
        r15.setDataList(r13.getComments());
        r10.smoothScrollToPosition(0);
    L14:
        if (r13.hasMore() == false) goto L16;
        r10.setPullLoadEnable(true);
        r12.setTag(R$id.app_comments_page, Integer.valueOf(r11 + 1));
        return;
    L16:
        r10.setPullLoadEnable(false);
        return;
    L12:
        r15.addDataList(r13.getComments());
        goto L14
    }

    public static void updateCommentBottomBtn(Activity r10, AppComments r11, View.OnClickListener r12) {
        TextView r13 = (TextView) r10.findViewById(R$id.addComment);
        if (r11.isOnlyScore() == false) goto L5;
        r13.setClickable(false);
        r13.setBackgroundResource(R$drawable.widebottom_disable);
        r13.setTextColor(e.k(1295069489, 1295069489, 1295069489, 1295069489));
    L6:
        TextView r14 = (TextView) r10.findViewById(R$id.loadComment);
        if (r11.getCommentsCnt() <= 4) goto L9;
        r14.setClickable(true);
        r14.setOnClickListener(r12);
        r14.setBackgroundResource(R$drawable.btn_widebottom_selector);
        r14.setTextColor(e.k(-13553359, -13553359, -13553359, -13553359));
        return;
    L9:
        r14.setClickable(false);
        r14.setBackgroundResource(R$drawable.widebottom_disable);
        r14.setTextColor(e.k(1295069489, 1295069489, 1295069489, 1295069489));
        return;
    L5:
        r13.setClickable(true);
        r13.setOnClickListener(r12);
        r13.setBackgroundResource(R$drawable.btn_widebottom_selector);
        r13.setTextColor(e.k(-13553359, -13553359, -13553359, -13553359));
        goto L6
    }

    public static void updateCommentHeader(View r10, AppComments r11) {
        int r12 = e.b0(BaseApplication.c(), r11.getAverageScore(), false);
        updateCommentHeader(r10, r11.getAverageScore(), r11.getScoresCnt(), r12, r11.getScoreMap(), String.valueOf(r11.getCommentsCnt()));
    }

    public static void updateCommentInfos(ViewGroup r10, List<CommentInfo> r11, View.OnClickListener r12) {
        if (r11 != null) goto L4;
        return;
    L4:
        if (r11.size() == 0) goto L20;
        r10.setVisibility(0);
        int r13 = 4;
        if (r11.size() > 4) goto L10;
        r13 = r11.size();
    L10:
        LayoutInflater r14 = (LayoutInflater) r10.getContext().getSystemService("layout_inflater");
        ViewGroup r15 = (ViewGroup) r10.findViewById(R$id.appinfo_comment_container);
        r15.removeAllViews();
        int r16 = 0;
    L11:
        if (r16 >= r13) goto L21;
        View r17 = r14.inflate(R$layout.appinfo_comment_item_with_line, null);
        View r18 = r17.findViewById(R$id.app_comment_item_view);
        CommentInfo r19 = r11.get(r16);
        if (r12 == null) goto L15;
        int r20 = R$id.comment_item_support_click;
        r18.findViewById(r20).setOnClickListener(r12);
        r18.findViewById(r20).setTag(R$id.support_comment_info, r19);
    L15:
        updateCommentItemView(r18, r19);
        r18.setVisibility(0);
        r17.setVisibility(0);
        r15.addView(r17);
        r16 = r16 + 1;
        goto L11
    L21:
        return;
    }

    private static void updateCommentItemView(View r10, CommentInfo r11) {
        final TextView r12 = (TextView) r10.findViewById(R$id.comment_item_content);
        r12.setText(r11.content);
        r12.setEllipsize(TextUtils.TruncateAt.END);
        r12.setMaxLines(3);
        r12.requestLayout();
        r12.getViewTreeObserver().addOnGlobalLayoutListener(new AnonymousClass1(r12));
        int r13 = 0;
        if (r11.score > 0) goto L5;
        r10.findViewById(R$id.comment_item_rate).setVisibility(8);
    L6:
        ((TextView) r10.findViewById(R$id.comment_item_user)).setText(r11.nickname);
        ((TextView) r10.findViewById(R$id.comment_item_time)).setText(r11.time);
        ((TextView) r10.findViewById(R$id.comment_item_version)).setText(r11.version);
        int r14 = R$id.comment_item_support_times;
        ((TextView) r10.findViewById(r14)).setText(String.valueOf(r11.commentSupportTimes));
        TextView r15 = (TextView) r10.findViewById(r14);
        if (r11.commentSupportTimes != 0) goto L9;
        r13 = 4;
    L9:
        r15.setVisibility(r13);
        ImageView r16 = (ImageView) r10.findViewById(R$id.comment_item_support_icon);
        if (r11.isLike == false) goto L12;
        int r17 = R$drawable.comment_support_done;
    L13:
        r16.setImageResource(r17);
        Context r18 = r10.getContext();
        if (r11.isLike == false) goto L16;
        int r19 = R$string.comment_support_done;
    L17:
        ((LinearLayout) r10.findViewById(R$id.comment_item_support_click)).setContentDescription(r18.getString(r19, new Object[]{String.valueOf(r11.commentSupportTimes)}));
        return;
    L16:
        r19 = R$string.comment_support;
        goto L17
    L12:
        r17 = R$drawable.comment_support;
        goto L13
    L5:
        int r20 = R$id.comment_item_rate;
        r10.findViewById(r20).setVisibility(0);
        ((ImageView) r10.findViewById(r20)).setImageResource(e.b0(r10.getContext(), r11.score, true));
        goto L6
    }

    public static void updateCommentHeader(View r10, float r11, int r12, int r13, HashMap<Integer, Integer> r14, String r15) {
        if (r12 != 0) goto L6;
        r10.findViewById(R$id.no_comment_tip).setVisibility(0);
        r10.findViewById(R$id.app_comment_layout).setVisibility(8);
        return;
    L6:
        r10.findViewById(R$id.no_comment_tip).setVisibility(8);
        r10.findViewById(R$id.app_comment_layout).setVisibility(0);
        ((TextView) r10.findViewById(R$id.appScore)).setText(String.valueOf(r11));
        if (TextUtils.isEmpty(r15) == false) goto L10;
        String r16 = "";
    L13:
        ((TextView) r10.findViewById(R$id.appCommentsNum)).setText(r16);
        if (r14 != null) goto L20;
        int r17 = 0;
    L16:
        int[] r18 = CommentInfo.rate_progress_ids;
        if (r17 >= r18.length) goto L19;
        ((OProgressView) r10.findViewById(r18[r17])).setProgress(0);
        r17 = r17 + 1;
        goto L16
    L19:
        return;
    L20:
        Iterator<Integer> r19 = r14.keySet().iterator();
    L22:
        if (r19.hasNext() == false) goto L29;
        Integer r20 = r19.next();
        int r21 = r20.intValue();
        if (r21 <= 0) goto L22;
        if (r21 > 5) goto L22;
        ((OProgressView) r10.findViewById(CommentInfo.rate_progress_ids[r21 - 1])).setProgress((r14.get(r20).intValue() * 100) / r12);
        goto L22
    L29:
        return;
    L10:
        if (r12 != 1) goto L12;
        r16 = r10.getContext().getString(R$string.comment_1);
        goto L13
    L12:
        r16 = r10.getContext().getString(R$string.comment_num, new Object[]{e.r(r15)});
        goto L13
    }
}
