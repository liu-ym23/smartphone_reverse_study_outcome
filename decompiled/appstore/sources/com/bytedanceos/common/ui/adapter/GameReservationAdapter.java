package com.bytedanceos.common.ui.adapter;

import android.app.Activity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedanceos.common.R$drawable;
import com.bytedanceos.common.R$id;
import com.bytedanceos.common.R$layout;
import com.bytedanceos.common.model.gameReservation.CategoryReservation;
import com.bytedanceos.common.model.gameReservation.GameReservationData;
import com.bytedanceos.common.model.gameReservation.MyReserveApp;
import com.bytedanceos.common.toolbox.glide.b;
import com.bytedanceos.common.ui.widget.SubButton;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class GameReservationAdapter extends BaseAdapter {
    private Activity mActivity;
    ArrayList<GameReservationData> mDataList;
    private LayoutInflater mLayoutInflater;
    private SubButton.OnSubListener mSubListener;

    public static class CategoryHeaderHolder extends ViewHolder {
        TextView mTitle;

        public CategoryHeaderHolder(View r10) {
            super(r10, 2);
            this.mTitle = (TextView) r10.findViewById(R$id.category_title);
            r10.setTag(this);
        }

        @Override // com.bytedanceos.common.ui.adapter.GameReservationAdapter.ViewHolder
        public void bindData(GameReservationData r10, int r11) {
            this.mTitle.setText(((CategoryReservation) r10).mCategory);
        }
    }

    public static class NormalHeaderHolder extends ViewHolder {
        public NormalHeaderHolder(View r10) {
            super(r10, 0);
            r10.setTag(this);
        }

        @Override // com.bytedanceos.common.ui.adapter.GameReservationAdapter.ViewHolder
        public void bindData(GameReservationData r10, int r11) {
        }
    }

    public class RecommendGameReservationHolder extends ViewHolder {
        TextView mGameCategory;
        ImageView mGameIcon;
        TextView mGameName;
        TextView mGameOnLineTime;
        SubButton mGameState;
        final /* synthetic */ GameReservationAdapter this$0;

        public RecommendGameReservationHolder(GameReservationAdapter r10, View r11) {
            this.this$0 = r10;
            super(r11, 3);
            this.mGameIcon = (ImageView) r11.findViewById(R$id.iv_icon);
            this.mGameName = (TextView) r11.findViewById(R$id.tv_name);
            this.mGameOnLineTime = (TextView) r11.findViewById(R$id.tv_desc);
            this.mGameCategory = (TextView) r11.findViewById(R$id.tv_category);
            this.mGameState = (SubButton) r11.findViewById(R$id.btn_sub);
            r11.setTag(this);
        }

        @Override // com.bytedanceos.common.ui.adapter.GameReservationAdapter.ViewHolder
        public void bindData(GameReservationData r10, int r11) {
            if ((r10 instanceof MyReserveApp) == false) goto L17;
            final MyReserveApp r12 = (MyReserveApp) r10;
            b.g(this.mGameIcon.getContext(), R$drawable.default_app_icon_banner, r12.mUrl, this.mGameIcon);
            this.mGameName.setText(r12.mGameName);
            TextView r13 = this.mGameOnLineTime;
            int r14 = 8;
            boolean r15 = false;
            if (TextUtils.isEmpty(r12.mGameOnlineTime) == false) goto L7;
            int r16 = 8;
        L8:
            r13.setVisibility(r16);
            this.mGameOnLineTime.setText(r12.mGameOnlineTime);
            TextView r17 = this.mGameCategory;
            if (TextUtils.isEmpty(r12.mGameCategory) == true) goto L12;
            r14 = 0;
        L12:
            r17.setVisibility(r14);
            this.mGameCategory.setText(r12.mGameCategory);
            SubButton r18 = this.mGameState;
            if (r12.mGameState != 1) goto L15;
            r15 = true;
        L15:
            r18.setSubcirbe(r15);
            this.mGameState.setId(r12.mAppId);
            this.mGameState.setTrackInfo(r12);
            this.mGameState.setOnSubListener(GameReservationAdapter.access$100(this.this$0));
            this.root.setOnClickListener(new AnonymousClass1(this, r12));
            return;
        L7:
            r16 = 0;
            goto L8
        }
    }

    public class ReservedGameHolder extends ViewHolder {
        TextView mAppCategory;
        ImageView mAppIcon;
        TextView mAppName;
        TextView mAppOnLineTime;
        SubButton mReserveBtn;
        final /* synthetic */ GameReservationAdapter this$0;

        public ReservedGameHolder(GameReservationAdapter r10, View r11) {
            this.this$0 = r10;
            super(r11, 1);
            this.mAppIcon = (ImageView) r11.findViewById(R$id.iv_icon);
            this.mAppName = (TextView) r11.findViewById(R$id.tv_name);
            this.mAppOnLineTime = (TextView) r11.findViewById(R$id.tv_desc);
            this.mReserveBtn = (SubButton) r11.findViewById(R$id.btn_sub);
            this.mAppCategory = (TextView) r11.findViewById(R$id.tv_category);
            r11.setTag(this);
        }

        @Override // com.bytedanceos.common.ui.adapter.GameReservationAdapter.ViewHolder
        public void bindData(GameReservationData r10, int r11) {
            if ((r10 instanceof MyReserveApp) == false) goto L10;
            final MyReserveApp r12 = (MyReserveApp) r10;
            b.l(this.mAppIcon.getContext(), R$drawable.default_app_icon_normal, r12.mUrl, this.mAppIcon, 15, 38);
            this.mAppName.setText(r12.mGameName);
            this.mAppOnLineTime.setText(r12.mGameOnlineTime);
            this.mAppCategory.setVisibility(8);
            SubButton r13 = this.mReserveBtn;
            boolean r14 = true;
            if (r12.mGameState == 1) goto L8;
            r14 = false;
        L8:
            r13.setSubcirbe(r14);
            this.mReserveBtn.setId(r12.mAppId);
            this.mReserveBtn.setTrackInfo(r12);
            this.mReserveBtn.setOnSubListener(GameReservationAdapter.access$100(this.this$0));
            this.root.setOnClickListener(new AnonymousClass1(this, r12));
            return;
        }
    }

    public static abstract class ViewHolder {
        View root;
        int type;

        public ViewHolder(View r10, int r11) {
            this.root = r10;
            this.type = r11;
        }

        public abstract void bindData(GameReservationData r10, int r11);
    }

    public GameReservationAdapter(Activity r10) {
        this.mDataList = new ArrayList();
        this.mSubListener = new AnonymousClass1(this);
        this.mActivity = r10;
        this.mLayoutInflater = LayoutInflater.from(r10.getApplicationContext());
    }

    public static /* synthetic */ Activity access$000(GameReservationAdapter r10) {
        return r10.mActivity;
    }

    public static /* synthetic */ SubButton.OnSubListener access$100(GameReservationAdapter r10) {
        return r10.mSubListener;
    }

    private ViewHolder createViewHolder(int r10, ViewGroup r11) {
        if (r10 == 0) goto L19;
        if (r10 == 1) goto L17;
        if (r10 == 2) goto L15;
        if (r10 == 3) goto L13;
        return new NormalHeaderHolder(this.mLayoutInflater.inflate(R$layout.game_reservation_normal_header, r11, false));
    L13:
        return new RecommendGameReservationHolder(this, this.mLayoutInflater.inflate(R$layout.item_sub_group_app, r11, false));
    L15:
        return new CategoryHeaderHolder(this.mLayoutInflater.inflate(R$layout.game_reservation_category, r11, false));
    L17:
        return new ReservedGameHolder(this, this.mLayoutInflater.inflate(R$layout.item_sub_app, r11, false));
    L19:
        return new NormalHeaderHolder(this.mLayoutInflater.inflate(R$layout.game_reservation_normal_header, r11, false));
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.mDataList.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int r10) {
        return this.mDataList.get(r10);
    }

    @Override // android.widget.Adapter
    public long getItemId(int r10) {
        return r10;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int r10) {
        return this.mDataList.get(r10).mDataType;
    }

    @Override // android.widget.Adapter
    public View getView(int r10, View r11, ViewGroup r12) {
        int r13 = getItemViewType(r10);
        if (r11 == null) goto L5;
        ViewHolder r14 = (ViewHolder) r11.getTag();
    L6:
        if (r14 != null) goto L8;
    L9:
        r14 = createViewHolder(r13, r12);
    L10:
        r14.bindData(this.mDataList.get(r10), r10);
        return r14.root;
    L8:
        if (r14.type == r13) goto L10;
    L5:
        r14 = null;
        goto L6
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 4;
    }

    public void setData(List<GameReservationData> r10) {
        this.mDataList.clear();
        this.mDataList.addAll(r10);
        notifyDataSetChanged();
    }
}
