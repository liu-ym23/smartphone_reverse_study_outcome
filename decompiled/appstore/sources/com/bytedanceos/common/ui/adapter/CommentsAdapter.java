package com.bytedanceos.common.ui.adapter;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedanceos.common.BaseApplication;
import com.bytedanceos.common.R$color;
import com.bytedanceos.common.R$drawable;
import com.bytedanceos.common.R$id;
import com.bytedanceos.common.R$layout;
import com.bytedanceos.common.R$string;
import com.bytedanceos.common.model.CommentInfo;
import com.bytedanceos.common.toolbox.e;
import java.util.ArrayList;
import java.util.List;
import kotlinx.coroutines.channels.Channel;

/* JADX INFO: loaded from: classes2.dex */
public class CommentsAdapter extends BaseAdapter {
    private static final int MIN_LINE_CNT = 3;
    private List<CommentInfo> dataList;
    private LayoutInflater inflater;
    private Context mContext;
    private View.OnClickListener mListener;

    public static class ViewHolder {
        TextView content;
        ImageView rate;
        View support;
        ImageView supportIcon;
        TextView time;
        TextView times;
        TextView user;
        TextView version;

        public ViewHolder() {
        }
    }

    public CommentsAdapter(Context r10, View.OnClickListener r11) {
        this.dataList = null;
        this.mContext = r10;
        this.inflater = (LayoutInflater) r10.getSystemService("layout_inflater");
        this.dataList = new ArrayList();
        this.mListener = r11;
    }

    public void addDataList(List<CommentInfo> r10) {
        this.dataList.addAll(r10);
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.dataList.size();
    }

    public List<CommentInfo> getDataList() {
        return this.dataList;
    }

    @Override // android.widget.Adapter
    public Object getItem(int r10) {
        return this.dataList.get(r10);
    }

    @Override // android.widget.Adapter
    public long getItemId(int r10) {
        return r10;
    }

    @Override // android.widget.Adapter
    public View getView(int r10, View r11, ViewGroup r12) {
        int r13 = 0;
        if (r11 != null) goto L5;
        r11 = this.inflater.inflate(R$layout.appinfo_comment_item_with_line, null);
        ViewHolder r14 = new ViewHolder();
        r11.findViewById(R$id.app_comment_item_view).setVisibility(0);
        r14.content = (TextView) r11.findViewById(R$id.comment_item_content);
        r14.rate = (ImageView) r11.findViewById(R$id.comment_item_rate);
        r14.user = (TextView) r11.findViewById(R$id.comment_item_user);
        r14.time = (TextView) r11.findViewById(R$id.comment_item_time);
        r14.version = (TextView) r11.findViewById(R$id.comment_item_version);
        View r15 = r11.findViewById(R$id.comment_item_support_click);
        r14.support = r15;
        r15.setOnClickListener(this.mListener);
        r14.supportIcon = (ImageView) r11.findViewById(R$id.comment_item_support_icon);
        r14.times = (TextView) r11.findViewById(R$id.comment_item_support_times);
        r11.setTag(r14);
    L6:
        final CommentInfo r16 = this.dataList.get(r10);
        final TextView r17 = r14.content;
        if (r16.isFold == false) goto L9;
        r17.setEllipsize(TextUtils.TruncateAt.END);
        r17.setMaxLines(3);
        r17.setOnClickListener(new AnonymousClass1(this, r16, r17));
    L10:
        r17.setText(r16.content);
        r17.requestLayout();
        if (r16.score > 0) goto L13;
        r14.rate.setVisibility(8);
    L14:
        r14.time.setText(r16.time);
        r14.user.setText(r16.nickname);
        r14.version.setText(r16.version);
        r14.support.setTag(R$id.support_comment_info, r16);
        r14.times.setText(String.valueOf(r16.commentSupportTimes));
        TextView r18 = r14.times;
        if (r16.commentSupportTimes != 0) goto L17;
        r13 = 4;
    L17:
        r18.setVisibility(r13);
        if (r16.isLike == false) goto L20;
        r14.supportIcon.setImageResource(R$drawable.oui_icon_chevron);
        ImageView r19 = r14.supportIcon;
        Resources r20 = this.mContext.getResources();
        int r21 = R$color.oui_red_7;
        r19.setImageTintList(ColorStateList.valueOf(r20.getColor(r21)));
        String r22 = this.mContext.getString(R$string.comment_support_done, new Object[]{String.valueOf(r16.commentSupportTimes)});
        int r23 = BaseApplication.c().getResources().getColor(r21);
    L21:
        r14.support.setContentDescription(r22);
        r14.times.setTextColor(r23);
        return r11;
    L20:
        r14.supportIcon.setImageResource(R$drawable.oui_icon_chevron);
        ImageView r24 = r14.supportIcon;
        Resources r25 = this.mContext.getResources();
        int r26 = R$color.oui_text_3b;
        r24.setImageTintList(ColorStateList.valueOf(r25.getColor(r26)));
        r22 = this.mContext.getString(R$string.comment_support, new Object[]{String.valueOf(r16.commentSupportTimes)});
        r23 = BaseApplication.c().getResources().getColor(r26);
        goto L21
    L13:
        r14.rate.setVisibility(0);
        r14.rate.setImageResource(e.b0(this.mContext, r16.score, true));
        goto L14
    L9:
        r17.setMaxLines(Channel.UNLIMITED);
        goto L10
    L5:
        r14 = (ViewHolder) r11.getTag();
        goto L6
    }

    public void setDataList(List<CommentInfo> r10) {
        this.dataList.clear();
        this.dataList = r10;
        notifyDataSetChanged();
    }
}
