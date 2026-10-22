package com.bytedanceos.common.ui.adapter;

import android.text.SpannableString;
import android.text.style.TextAppearanceSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedanceos.common.BaseApplication;
import com.bytedanceos.common.R$drawable;
import com.bytedanceos.common.R$id;
import com.bytedanceos.common.R$layout;
import com.bytedanceos.common.R$string;
import com.bytedanceos.common.R$style;
import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.model.GameInfo;
import com.bytedanceos.common.model.GameModel;
import com.bytedanceos.common.model.GiftPackInfo;
import com.bytedanceos.common.network.widget.NetworkImageView;
import com.bytedanceos.common.toolbox.e;
import java.util.ArrayList;
import java.util.List;
import tc.f;

/* JADX INFO: loaded from: classes2.dex */
public class GameGiftAdapter extends BaseAdapter {
    public static final int GAME_TYPE_ALL = 1;
    public static final int GAME_TYPE_DETAIL = 3;
    public static final int GAME_TYPE_MY = 2;
    private ArrayList<GameModel> mData;
    protected boolean mIsBigFont;
    private View.OnClickListener mListener;
    private int mMaxLines;
    private int mType;

    /* JADX INFO: renamed from: com.bytedanceos.common.ui.adapter.GameGiftAdapter$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class ViewHolder {
        public ImageView mAppRate;
        public TextView mBtn;
        public TextView mCategory;
        public TextView mDescription;
        public NetworkImageView mGameIcon;
        public View mLine;
        public TextView mName;

        private ViewHolder() {
        }

        public /* synthetic */ ViewHolder(AnonymousClass1 r10) {
            this();
        }
    }

    public GameGiftAdapter(View.OnClickListener r10, int r11) {
        this.mData = new ArrayList();
        this.mMaxLines = 0;
        this.mIsBigFont = false;
        this.mListener = r10;
        this.mType = r11;
        this.mIsBigFont = e.n0();
    }

    private void setAppInfoClickListener(View r10, GameModel r11, int r12) {
        AppInfo r13 = new AppInfo();
        r13.appName = r11.mName;
        r13.appPackageName = r11.mPackageName;
        r13.mApiUrl = r11.mApiurl;
        r13.mAppType = 1;
        r10.setOnClickListener(this.mListener);
        r10.setTag(R$id.appinfo, r13);
        r10.setTag(R$id.app_row_index, Integer.valueOf(r12));
    }

    private void setGameInfoClickListener(View r10, GameModel r11) {
        r10.setOnClickListener(this.mListener);
        r10.setTag(R$id.appinfo, r11);
    }

    private void setGiftPackCount(TextView r10, String r11) {
        String r12 = e.r(r11);
        if (this.mType != 3) goto L5;
        String r13 = BaseApplication.c().getString(R$string.gift_remain, new Object[]{r12});
        TextAppearanceSpan r14 = new TextAppearanceSpan(BaseApplication.c(), R$style.gift_detail_light_style);
    L6:
        int r15 = r13.indexOf(r12);
        int r16 = r12.length() + r15;
        SpannableString r17 = new SpannableString(r13);
        r17.setSpan(r14, r15, r16, 33);
        r10.setText(r17, TextView.BufferType.SPANNABLE);
        return;
    L5:
        r13 = BaseApplication.c().getString(R$string.gift_btn_check, new Object[]{r12});
        r14 = new TextAppearanceSpan(BaseApplication.c(), R$style.gift_light_style);
        goto L6
    }

    private void updateAllGameGiftPacks(ViewHolder r10, GameModel r11) {
        r10.mDescription.setVisibility(8);
        GameInfo r12 = (GameInfo) r11;
        r10.mName.setText(r11.mName);
        NetworkImageView r13 = r10.mGameIcon;
        int r14 = R$drawable.oui_default_app_icon;
        r13.setErrorImageResId(r14);
        r10.mGameIcon.setDefaultImageResId(r14);
        r10.mGameIcon.e(r11.mLogo, f.i(20));
        r10.mCategory.setText(r12.mCategory);
        r10.mAppRate.setImageResource(e.b0(BaseApplication.c(), r12.mGameScores, false));
        setGiftPackCount(r10.mBtn, r12.mCount);
        r10.mBtn.setBackground(null);
        r10.mBtn.setClickable(false);
    }

    private void updateGiftPickItem(ViewHolder r10, GameModel r11) {
        GiftPackInfo r12 = (GiftPackInfo) r11;
        r10.mName.setText(r11.mName);
        r10.mCategory.setText(r12.mContent);
        setGiftPackCount(r10.mDescription, String.valueOf(r12.mCount));
        if (r12.isReceived == false) goto L6;
        r10.mBtn.setText(R$string.gift_btn_use);
        setGameInfoClickListener(r10.mBtn, r11);
        r10.mBtn.setEnabled(true);
        r10.mBtn.setAlpha(1.0f);
        return;
    L6:
        if (r12.mCount != 0) goto L8;
        r10.mBtn.setText(R$string.gift_btn_over);
        r10.mBtn.setEnabled(false);
        r10.mBtn.setAlpha(0.3f);
        return;
    L8:
        r10.mBtn.setText(R$string.gift_btn_get);
        setGameInfoClickListener(r10.mBtn, r11);
        r10.mBtn.setEnabled(true);
        r10.mBtn.setAlpha(1.0f);
    }

    private void updateMyGameGiftPicks(ViewHolder r10, GameModel r11) {
        r10.mAppRate.setVisibility(8);
        GiftPackInfo r12 = (GiftPackInfo) r11;
        r10.mName.setText(r11.mName);
        NetworkImageView r13 = r10.mGameIcon;
        int r14 = R$drawable.oui_default_app_icon;
        r13.setErrorImageResId(r14);
        r10.mGameIcon.setDefaultImageResId(r14);
        r10.mGameIcon.e(r11.mLogo, f.i(20));
        r10.mCategory.setText(r12.mGiftPackCode);
        r10.mDescription.setText(e.J(r12.mStartTime, r12.mEndTime));
        if (r12.mEndTime >= System.currentTimeMillis()) goto L5;
        r10.mBtn.setText(R$string.gift_btn_forbid);
        r10.mBtn.setEnabled(false);
        return;
    L5:
        r10.mBtn.setText(R$string.gift_btn_use);
        r10.mBtn.setEnabled(true);
        setGameInfoClickListener(r10.mBtn, r11);
    }

    public void addData(GiftPackInfo r10) {
        this.mData.add(0, r10);
        notifyDataSetChanged();
    }

    public void addGiftPack(GiftPackInfo r10) {
        int r11 = this.mData.indexOf(r10);
        if (r11 == (-1)) goto L5;
        GiftPackInfo r12 = (GiftPackInfo) this.mData.get(r11);
        r12.isReceived = r10.isReceived;
        r12.mCount = r10.mCount;
    L6:
        notifyDataSetChanged();
        return;
    L5:
        this.mData.add(0, r10);
        goto L6
    }

    public void clear() {
        this.mData.clear();
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        int r10 = this.mMaxLines;
        if (r10 <= 0) goto L6;
        return r10;
    L6:
        return this.mData.size();
    }

    @Override // android.widget.Adapter
    public /* bridge */ /* synthetic */ Object getItem(int r10) {
        return getItem(r10);
    }

    @Override // android.widget.Adapter
    public long getItemId(int r10) {
        return r10;
    }

    @Override // android.widget.Adapter
    public View getView(int r10, View r11, ViewGroup r12) {
        if (r11 != null) goto L13;
        ViewHolder r13 = new ViewHolder(null);
        if (this.mType != 3) goto L7;
        View r14 = View.inflate(BaseApplication.c(), R$layout.game_gift_item_detail, null);
    L12:
        r13.mName = (TextView) r14.findViewById(R$id.game_name);
        r13.mCategory = (TextView) r14.findViewById(R$id.game_category);
        r13.mDescription = (TextView) r14.findViewById(R$id.game_des);
        r13.mBtn = (TextView) r14.findViewById(R$id.game_btn);
        r14.setTag(r13);
    L14:
        GameModel r15 = getItem(r10);
        int r16 = this.mType;
        if (r16 != 1) goto L18;
        updateAllGameGiftPacks(r13, r15);
        setAppInfoClickListener(r14, r15, r10);
    L22:
        return r14;
    L18:
        if (r16 != 2) goto L20;
        updateMyGameGiftPicks(r13, r15);
        setGameInfoClickListener(r14, r15);
        goto L22
    L20:
        if (r16 != 3) goto L22;
        updateGiftPickItem(r13, r15);
        setGameInfoClickListener(r14, r15);
        goto L22
    L7:
        BaseApplication r17 = BaseApplication.c();
        if (this.mIsBigFont == false) goto L10;
        int r18 = R$layout.game_gift_item_1x4;
    L11:
        r14 = View.inflate(r17, r18, null);
        r13.mGameIcon = (NetworkImageView) r14.findViewById(R$id.game_icon);
        r13.mAppRate = (ImageView) r14.findViewById(R$id.appRate);
        r13.mLine = r14.findViewById(R$id.game_item_line);
        goto L12
    L10:
        r18 = R$layout.game_gift_item;
        goto L11
    L13:
        ViewHolder r19 = (ViewHolder) r11.getTag();
        r14 = r11;
        r13 = r19;
        goto L14
    }

    public void setData(List<GameModel> r10) {
        this.mData.addAll(r10);
        notifyDataSetChanged();
    }

    public void setMaxLines(int r10) {
        this.mMaxLines = r10;
    }

    @Override // android.widget.Adapter
    public GameModel getItem(int r10) {
        return this.mData.get(r10);
    }
}
