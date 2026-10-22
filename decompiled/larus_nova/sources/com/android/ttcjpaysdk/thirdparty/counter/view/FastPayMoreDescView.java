package com.android.ttcjpaysdk.thirdparty.counter.view;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.android.ttcjpaysdk.base.utils.CJPayBasicUtils;
import com.android.ttcjpaysdk.thirdparty.counter.data.FastPayGuideInfo;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import java.util.List;

/* JADX INFO: loaded from: classes39.dex */
public class FastPayMoreDescView extends LinearLayout {
    private List<FastPayGuideInfo.MoreBean.DescriptionBean.ContentBean> mContentData;
    private Context mContext;
    private int mFirstColor;
    private int mFirstSize;
    private int mSecondColor;
    private int mSecondSize;

    private void init() {
        this.mFirstColor = ColorProtector.parseColor("#161823");
        this.mSecondColor = ColorProtector.parseColor("#BF161823");
        this.mFirstSize = 13;
        this.mSecondSize = 13;
    }

    public FastPayMoreDescView(Context r100) {
        this(r100, null);
    }

    public void setData(List<FastPayGuideInfo.MoreBean.DescriptionBean.ContentBean> r110) {
        if (r110 != null) goto L4;
        return;
    L4:
        if (r110.size() == 0) goto L12;
        this.mContentData = r110;
        int r100 = 0;
    L8:
        if (r100 >= this.mContentData.size()) goto L13;
        TextView r101 = new TextView(this.mContext);
        LinearLayout.LayoutParams r102 = new LinearLayout.LayoutParams(-1, -2);
        r102.topMargin = CJPayBasicUtils.dipToPX(this.mContext, 8.0f);
        r101.setLayoutParams(r102);
        FastPayGuideInfo.MoreBean.DescriptionBean.ContentBean r103 = (FastPayGuideInfo.MoreBean.DescriptionBean.ContentBean) ListProtector.get(this.mContentData, r100);
        String r104 = r103.summary;
        SpannableStringBuilder r105 = new SpannableStringBuilder(r104 + r103.description);
        r105.setSpan(new ForegroundColorSpan(this.mFirstColor), 0, r104.length(), 34);
        r105.setSpan(new AbsoluteSizeSpan(this.mFirstSize, true), 0, r104.length(), 17);
        r105.setSpan(new ForegroundColorSpan(this.mSecondColor), r104.length(), r105.length(), 34);
        r105.setSpan(new AbsoluteSizeSpan(this.mSecondSize, true), r104.length(), r105.length(), 17);
        r101.setText(r105);
        addView(r101);
        r100 = r100 + 1;
        goto L8
    L13:
        return;
    }

    public FastPayMoreDescView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public FastPayMoreDescView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.mContext = r100;
        init();
    }
}
