package com.bytedanceos.common.ui.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import com.bytedanceos.common.R$id;
import com.bytedanceos.common.R$layout;
import com.bytedanceos.common.model.AppInfo;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class RankingHeaderView extends RelativeLayout {
    private RankingAppView itemView1;
    private RankingAppView itemView2;
    private RankingAppView itemView3;
    private CopyOnWriteArrayList<AppInfo> mDataList;
    private RelativeLayout mHeaderContainer;
    private CircleLightAnimationView mLightBeam;
    private View.OnClickListener mOnBtnClickListener;
    private View.OnClickListener mOnClickItemListener;

    public RankingHeaderView(Context r10, View.OnClickListener r11, View.OnClickListener r12) {
        super(r10);
        this.mOnClickItemListener = r11;
        this.mOnBtnClickListener = r12;
        RelativeLayout r13 = (RelativeLayout) LayoutInflater.from(r10).inflate(R$layout.game_ranking_header_view, this);
        this.mHeaderContainer = r13;
        this.mLightBeam = (CircleLightAnimationView) r13.findViewById(R$id.light_beam);
        this.itemView1 = (RankingAppView) this.mHeaderContainer.findViewById(R$id.app1);
        this.itemView2 = (RankingAppView) this.mHeaderContainer.findViewById(R$id.app2);
        this.itemView3 = (RankingAppView) this.mHeaderContainer.findViewById(R$id.app3);
        this.itemView1.setOnClickListener(this.mOnClickItemListener);
        this.itemView2.setOnClickListener(this.mOnClickItemListener);
        this.itemView3.setOnClickListener(this.mOnClickItemListener);
        this.itemView1.setBtnClickListener(this.mOnBtnClickListener);
        this.itemView2.setBtnClickListener(this.mOnBtnClickListener);
        this.itemView3.setBtnClickListener(this.mOnBtnClickListener);
    }

    @Override // android.view.View
    public void onAnimationEnd() {
        super.onAnimationEnd();
        this.mLightBeam.releaseAnimator();
    }

    @Override // android.view.View
    public void onAnimationStart() {
        super.onAnimationStart();
        this.mLightBeam.startAnimator();
    }

    public void refreshHeaderView() {
        CopyOnWriteArrayList<AppInfo> r10 = this.mDataList;
        if (r10 != null) goto L5;
        return;
    L5:
        if (r10.isEmpty() == true) goto L10;
        this.itemView1.bindData(this.mDataList.get(0), 1);
        this.itemView2.bindData(this.mDataList.get(1), 2);
        this.itemView3.bindData(this.mDataList.get(2), 3);
        return;
    }

    public void setHeaderDataLists(CopyOnWriteArrayList<AppInfo> r10) {
        this.mDataList = r10;
        refreshHeaderView();
    }
}
