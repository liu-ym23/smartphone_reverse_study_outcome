package com.bytedanceos.common.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedanceos.common.R$drawable;
import com.bytedanceos.common.R$id;
import com.bytedanceos.common.R$layout;
import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.network.widget.NetworkImageView;
import com.bytedanceos.common.ui.widget.oui.OUIAppStatusView;
import com.tmall.wireless.tangram.dataparser.concrete.Style;
import tc.f;

/* JADX INFO: loaded from: classes2.dex */
public class RankingAppView extends RelativeLayout {
    private int[] iconWidth;
    private TextView mAppName;
    private OUIAppStatusView mAppStatusView;
    private View.OnClickListener mBtnClickListener;
    private NetworkImageView mIcon;
    private ImageView mOrder;
    private int[] numberRes;
    private int[] orderMargin;

    public RankingAppView(Context r10) {
        this(r10, null);
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R$layout.ranking_header_item_view, this);
        setDescendantFocusability(393216);
        this.mIcon = (NetworkImageView) findViewById(R$id.appIcon);
        this.mAppName = (TextView) findViewById(R$id.appName);
        this.mAppStatusView = (OUIAppStatusView) findViewById(R$id.appStatusLay);
        this.mOrder = (ImageView) findViewById(R$id.app_order);
        setBackgroundColor(0);
    }

    private void showAppNum(int r10) {
        if (r10 > 0) goto L4;
        return;
    L4:
        if (r10 >= 4) goto L18;
        ImageView r11 = this.mOrder;
        if (r11 == null) goto L19;
        int r12 = r10 - 1;
        r11.setImageResource(this.numberRes[r12]);
        ViewGroup.MarginLayoutParams r13 = (ViewGroup.MarginLayoutParams) this.mOrder.getLayoutParams();
        r13.topMargin = Style.dp2px(this.orderMargin[r12]);
        if (r10 != 1) goto L10;
        int r14 = 68;
    L11:
        r13.width = f.i(r14);
        if (r10 != 1) goto L14;
        int r15 = 40;
    L15:
        r13.height = f.i(r15);
        this.mOrder.setLayoutParams(r13);
        return;
    L14:
        r15 = 28;
        goto L15
    L10:
        r14 = 60;
        goto L11
    L19:
        return;
    }

    private void updateIconLayout(int r10) {
        ViewGroup.LayoutParams r11 = this.mIcon.getLayoutParams();
        int r12 = Style.dp2px(this.iconWidth[r10 - 1]);
        r11.width = r12;
        r11.height = r12;
        this.mIcon.setLayoutParams(r11);
    }

    private void updateItemView(AppInfo r10, int r11) {
        setTag(R$id.appinfo, r10);
        this.mAppName.setText(r10.appName);
        this.mIcon.e(r10.appIcon, f.i(30));
        this.mAppStatusView.updateDownloadStatus(r10);
        this.mAppStatusView.setTag(r10);
        this.mAppStatusView.setOnClickListener(this.mBtnClickListener);
        showAppNum(r11);
        updateIconLayout(r11);
    }

    public void bindData(AppInfo r10, int r11) {
        updateItemView(r10, r11);
    }

    public void setBtnClickListener(View.OnClickListener r10) {
        this.mBtnClickListener = r10;
    }

    public RankingAppView(Context r10, AttributeSet r11) {
        this(r10, r11, 0);
    }

    public RankingAppView(Context r10, AttributeSet r11, int r12) {
        super(r10, r11, r12);
        this.numberRes = new int[]{R$drawable.order_1, R$drawable.order_2, R$drawable.order_3};
        this.iconWidth = new int[]{60, 48, 48};
        this.orderMargin = new int[]{24, 48, 48};
        init();
    }
}
