package com.android.contacts.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.android.contacts.DSUtils;
import com.android.contacts.R;
import com.google.common.collect.Lists;
import com.obric.oui.common.util.OUnitExtensionKt;
import java.util.ArrayList;
import kotlin.Unit;

/* JADX INFO: loaded from: classes2.dex */
public class SimSwitchView extends ImageView {
    private int mCurrentSim;
    private int mLastSystemSim;
    private OnCurrentSimChangedListener mOnCurrentSimChangedListener;
    PopupWindow mPopupWindow;
    private Drawable mSim1Bak;
    private Drawable mSim2Bak;
    private PopMenu mSimSelectPopMenu;

    public interface OnCurrentSimChangedListener {
        void onCurrentSimChanged(int r1);
    }

    private final class SimListAdapter extends BaseAdapter {
        final /* synthetic */ SimSwitchView this$0;

        @Override // android.widget.Adapter
        public int getCount() {
            return 2;
        }

        @Override // android.widget.Adapter
        public long getItemId(int r1) {
            return r1;
        }

        private SimListAdapter(SimSwitchView r1) {
            this.this$0 = r1;
        }

        @Override // android.widget.Adapter
        public Object getItem(int r1) {
            return Integer.valueOf(r1);
        }

        @Override // android.widget.Adapter
        public View getView(int r5, View r6, ViewGroup r7) {
            if (r6 != null) goto L4;
            r6 = LayoutInflater.from(SimSwitchView.access$100(this.this$0)).inflate(R.layout.sim_select_popup_window_list_item, null);
        L4:
            ImageView r8 = (ImageView) r6.findViewById(R.id.sim_icon);
            TextView r0 = (TextView) r6.findViewById(R.id.sim_name);
            ImageView r1 = (ImageView) r6.findViewById(R.id.sim_selected);
            TextView r2 = (TextView) r6.findViewById(R.id.operatore_name);
            r8.setImageResource(DSUtils.getMenuSimIconResource(r5));
            r0.setText(DSUtils.getSimName(SimSwitchView.access$200(this.this$0), r5));
            String r9 = DSUtils.getOperatorNameBySimSlotId(r5);
            if (TextUtils.isEmpty(r9) == true) goto L7;
            r2.setText(r9);
            r2.setVisibility(0);
        L9:
            if (SimSwitchView.access$300(this.this$0) != r5) goto L11;
            r1.setVisibility(0);
        L12:
            return r6;
        L11:
            r1.setVisibility(4);
            goto L12
        L7:
            r2.setVisibility(8);
            goto L9
        }
    }

    static /* synthetic */ void access$000(SimSwitchView r0) {
        r0.showSimSelectPopupWindow();
    }

    static /* synthetic */ Context access$100(SimSwitchView r0) {
        return r0.mContext;
    }

    static /* synthetic */ Context access$200(SimSwitchView r0) {
        return r0.mContext;
    }

    static /* synthetic */ int access$300(SimSwitchView r0) {
        return r0.mCurrentSim;
    }

    public SimSwitchView(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.mLastSystemSim = -2;
        this.mSimSelectPopMenu = new PopMenu();
        init();
    }

    private void init() {
        setOnClickListener(new AnonymousClass1(this));
    }

    private void showSimSelectPopupWindow() {
        ArrayList r0 = Lists.newArrayList(new PopMenuItem[]{new PopMenuItem(0, R.drawable.sim_1_icon, DSUtils.getOperatorNameBySimSlotId(0), DSUtils.getSimNumber(this.mContext, 0)), new PopMenuItem(1, R.drawable.sim_2_icon, DSUtils.getOperatorNameBySimSlotId(1), DSUtils.getSimNumber(this.mContext, 1))});
        this.mSimSelectPopMenu.setWidth(OUnitExtensionKt.dp2px(180));
        this.mSimSelectPopMenu.setGravity(80);
        this.mSimSelectPopMenu.setOffsetX(-OUnitExtensionKt.dp2px(80));
        this.mSimSelectPopMenu.show(this, r0, new SimSwitchView$$ExternalSyntheticLambda0(this));
    }

    /* JADX INFO: renamed from: lambda$showSimSelectPopupWindow$0$com-android-contacts-widget-SimSwitchView, reason: not valid java name */
    /* synthetic */ Unit m231xd438daa2(Integer r2) {
        setCurrentSim(r2.intValue());
        OnCurrentSimChangedListener r0 = this.mOnCurrentSimChangedListener;
        if (r0 == null) goto L5;
        r0.onCurrentSimChanged(r2.intValue());
    L5:
        this.mSimSelectPopMenu.dismiss();
        return null;
    }

    public void dismissPopupWindow() {
        PopupWindow r0 = this.mPopupWindow;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isShowing() == false) goto L9;
        this.mPopupWindow.dismiss();
        return;
    }

    public void setOnCurrentSimChangedListener(OnCurrentSimChangedListener r1) {
        this.mOnCurrentSimChangedListener = r1;
    }

    public int getLastSystemSim() {
        return this.mLastSystemSim;
    }

    public void setLastSystemSim(int r1) {
        this.mLastSystemSim = r1;
    }

    public int getCurrentSim() {
        return this.mCurrentSim;
    }

    public void setCurrentSim(int r1) {
        this.mCurrentSim = r1;
        setBackground(getSimIcon(r1));
    }

    private Drawable getSimIcon(int r2) {
        if (r2 != 0) goto L9;
        if (this.mSim1Bak != null) goto L7;
        this.mSim1Bak = getContext().getResources().getDrawable(R.drawable.sim_1_icon);
    L7:
        return this.mSim1Bak;
    L9:
        if (1 == r2) goto L11;
        return null;
    L11:
        if (this.mSim2Bak != null) goto L14;
        this.mSim2Bak = getContext().getResources().getDrawable(R.drawable.sim_2_icon);
    L14:
        return this.mSim2Bak;
    }
}
