package com.android.contacts.recommend;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.telephony.SubscriptionManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import bytedanceos.util.MultiSimAdapter;
import com.android.contacts.ContactPhotoManager;
import com.android.contacts.ContactsUtils;
import com.android.contacts.DSUtils;
import com.android.contacts.R;
import com.android.contacts.calllog.IntentProvider;
import com.android.contacts.dialpad.NewDialpadFragment;
import com.android.contacts.list.ContactDetailCacheManager;
import com.android.contacts.util.AnimationUtil;
import com.android.contacts.util.Constants;
import com.android.contacts.util.ContactsIntentUtils;
import com.android.contacts.util.ContactsTracker;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class FlowAdapter extends BaseFlowAdapter {
    public static final int HEAD_FAVORITE = 2;
    public static final int HEAD_FREQUENT = 1;
    public static final int HEAD_RECENT = 0;
    private Activity mContext;
    private List<BaseFlowAdapter.FlowEntry> mData;
    private NewDialpadFragment mDialpadFragment;
    private boolean mLoading;
    private ContactPhotoManager mPhotoLoader;

    private class ItemClickListener implements View.OnClickListener {
        private int header;
        private Uri lookupUri;
        private String name;
        private String number;
        final /* synthetic */ FlowAdapter this$0;

        public ItemClickListener(FlowAdapter r1, int r2, String r3, String r4, Uri r5) {
            this.this$0 = r1;
            this.header = r2;
            this.name = r3;
            this.number = r4;
            this.lookupUri = r5;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View r10) {
            if (ContactsUtils.isJustClicked() == false) goto L6;
            return;
        L6:
            if (FlowAdapter.access$000(this.this$0) != null) goto L8;
            int r0 = 0;
        L9:
            ContactsTracker.Recommend.onEvent(r0, this.header);
            if (FlowAdapter.access$000(this.this$0) != null) goto L13;
            FlowAdapter.access$100(this.this$0, this.lookupUri);
            return;
        L13:
            IntentProvider r11 = (IntentProvider) r10.getTag();
            if (r11 == null) goto L27;
            Intent r12 = r11.getIntent(FlowAdapter.access$200(this.this$0));
            if (FlowAdapter.access$000(this.this$0) == null) goto L19;
            FlowAdapter.access$000(this.this$0).setLastNumberDialed(this.number);
        L19:
            if (DSUtils.isSimManualSelectMode() == true) goto L21;
            FlowAdapter.access$200(this.this$0).startActivity(r12);
            return;
        L21:
            if (r12.getIntExtra(Constants.EXTRA_START_CALL_WITH_VIDEO_STATE, -1) != 3) goto L23;
            boolean r8 = true;
        L24:
            ContactsUtils.showSelectSimDialog(FlowAdapter.access$200(this.this$0), this.name, this.number, 1, false, r8);
            return;
        L23:
            r8 = false;
            goto L24
        L27:
            return;
        L8:
            r0 = 1;
            goto L9
        }
    }

    @Override // android.widget.Adapter
    public long getItemId(int r1) {
        return r1;
    }

    static /* synthetic */ NewDialpadFragment access$000(FlowAdapter r0) {
        return r0.mDialpadFragment;
    }

    static /* synthetic */ void access$100(FlowAdapter r0, Uri r1) {
        r0.startDetailActivity(r1);
    }

    static /* synthetic */ Activity access$200(FlowAdapter r0) {
        return r0.mContext;
    }

    public FlowAdapter(Activity r2, NewDialpadFragment r3) {
        super(r2);
        this.mLoading = true;
        this.mContext = r2;
        this.mDialpadFragment = r3;
        this.mPhotoLoader = ContactPhotoManager.getInstance(r2);
    }

    public void setData(List<BaseFlowAdapter.FlowEntry> r1) {
        this.mData = r1;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<BaseFlowAdapter.FlowEntry> r0 = this.mData;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int r1) {
        return this.mData.get(r1);
    }

    public void setLoading(boolean r1) {
        this.mLoading = r1;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean isEmpty() {
        if (this.mLoading == false) goto L7;
        return false;
    L7:
        return super.isEmpty();
    }

    @Override // com.android.contacts.recommend.BaseFlowAdapter
    View newHeadView(LayoutInflater r2, ViewGroup r3) {
        return r2.inflate(R.layout.recommend_header, r3, false);
    }

    @Override // com.android.contacts.recommend.BaseFlowAdapter
    View newItemView(LayoutInflater r2, ViewGroup r3) {
        return r2.inflate(R.layout.recommend_chip, r3, false);
    }

    @Override // com.android.contacts.recommend.BaseFlowAdapter
    void bindHeadView(View r2, int r3) {
        ((TextView) r2.findViewById(R.id.text)).setText(((RecommendHead) this.mData.get(r3)).itemText);
        if (r3 != 0) goto L6;
        r2.findViewById(R.id.space_holder).setVisibility(0);
        return;
    }

    @Override // com.android.contacts.recommend.BaseFlowAdapter
    void bindItemView(View r4, int r5, int r6) {
        TextView r0 = (TextView) r4.findViewById(R.id.name);
        RecommendContact r7 = (RecommendContact) this.mData.get(r6);
        r0.setText(r7.name);
        r4.setBackgroundResource(R.drawable.chip_white_selector);
        r0.setTextColor(this.mContext.getColor(R.color.oui_text_1));
        setItemOnClickListener(r4, r5, r7);
    }

    private void setItemOnClickListener(View r8, int r9, RecommendContact r10) {
        boolean r0 = true;
        if (r9 == 0) goto L9;
        if (r9 == 1) goto L9;
        if (r9 == 2) goto L28;
        return;
    L28:
        r8.setOnClickListener(new ItemClickListener(this, r9, r10.name, r10.number, r10.lookupUri));
        return;
    L9:
        if (this.mDialpadFragment == null) goto L28;
        if (r10.features == 1) goto L15;
        r0 = false;
    L15:
        if (DSUtils.useDSFeature() == true) goto L17;
        if (r0 == false) goto L27;
        r8.setTag(IntentProvider.getReturnVideoCallIntentProvider(r10.number));
        goto L28
    L27:
        r8.setTag(IntentProvider.getReturnCallIntentProvider(r10.number, false));
        goto L28
    L17:
        if (r10.isCallLog() == false) goto L19;
        String r1 = r10.lastContactSlotId;
    L21:
        if (r10.isCallLog() == false) goto L23;
        int r3 = r10.lastContactSubId;
    L24:
        r8.setTag(IntentProvider.getReturnCallIntentProvider(r10.number, r3, r1, false, r0));
        goto L28
    L23:
        r3 = SubscriptionManager.getDefaultSubscriptionId();
        goto L24
    L19:
        r1 = String.valueOf(MultiSimAdapter.getDefaultSlot());
        goto L21
    }

    private void startDetailActivity(Uri r4) {
        ContactDetailCacheManager.getInstance().loadResultData(r4);
        Intent r5 = ContactsIntentUtils.launchContactDetailIntent(this.mContext, r4, true, "recommend");
        if (this.mDialpadFragment != null) goto L5;
        String r0 = "_FROM_DIALPAD_RECOMMEND";
    L7:
        if (TextUtils.isEmpty(r0) == true) goto L9;
        r5.putExtra(Constants.ContactsTracker.EXTRA_SOURCE_FOR_TRACKER, r0);
    L9:
        this.mContext.startActivity(r5);
        AnimationUtil.switchActivityAnimation(this.mContext, 5);
        return;
    L5:
        r0 = "_FROM_LIST_RECOMMEND";
        goto L7
    }
}
