package com.bytedanceos.common.ui.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.bytedanceos.common.R$string;
import com.bytedanceos.common.ad.param.AdReportParam;
import com.bytedanceos.common.eventbus.OnSubEvent;
import com.bytedanceos.common.networkv2.entity.BaseEntity;
import com.bytedanceos.common.networkv2.entity.BaseInfo;
import com.bytedanceos.common.networkv2.entity.Head;
import com.bytedanceos.common.networkv2.rest.AppStoreV15Rest;
import com.bytedanceos.common.networkv2.subscriber.ISubscriberManager;
import com.bytedanceos.common.networkv2.subscriber.NSubscriber;
import com.bytedanceos.common.toolbox.cache.AccountDataCache;
import com.bytedanceos.common.toolbox.e;
import com.bytedanceos.common.toolbox.p;
import com.bytedanceos.common.tracker.TrackerElement;
import java.util.HashMap;
import org.greenrobot.eventbus.EventBus;

/* JADX INFO: loaded from: classes2.dex */
public class SubButton extends TextView {
    private Context mContext;
    private String mId;
    private boolean mIsSubed;
    private OnSubListener mOnSubListener;
    private BaseInfo mSubInfo;
    private InnerSubscriber mSubscriber;
    private ISubscriberManager mSubscriberManager;
    private String mTextSub;
    private String mTextSubed;

    public class InnerSubscriber extends NSubscriber<BaseEntity> {
        private boolean isSub;
        final /* synthetic */ SubButton this$0;

        private InnerSubscriber(SubButton r10) {
            this.this$0 = r10;
            this.isSub = false;
        }

        @Override // rx.Observer
        public void onError(Throwable r10) {
            if (SubButton.access$100(this.this$0) == null) goto L6;
            Head r11 = new Head();
            r11.setMessage(r10.getMessage());
            SubButton.access$100(this.this$0).onSubFail(this.this$0, r11);
            return;
        }

        @Override // com.bytedanceos.common.networkv2.subscriber.NSubscriber, rx.Observer
        public /* bridge */ /* synthetic */ void onNext(Object r10) {
            onNext((BaseEntity) r10);
        }

        public void setSub(boolean r10) {
            this.isSub = r10;
        }

        public void onNext(BaseEntity r10) {
            if (r10 == null) goto L10;
            if (r10.isOk() == false) goto L10;
            this.this$0.setSubcirbe(this.isSub);
            EventBus.getDefault().post(new OnSubEvent());
            if (SubButton.access$100(this.this$0) == null) goto L8;
            SubButton.access$100(this.this$0).onSubSuccess(this.this$0, this.isSub);
        L8:
            SubButton.access$200(this.this$0, this.isSub);
            return;
        L10:
            if (SubButton.access$100(this.this$0) == null) goto L14;
            SubButton.access$100(this.this$0).onSubFail(this.this$0, r10.getHead());
            return;
        }

        public /* synthetic */ InnerSubscriber(SubButton r10, AnonymousClass1 r11) {
            this(r10);
        }
    }

    public interface OnSubListener {
        boolean onSubClick(SubButton r10, boolean r11);

        void onSubFail(SubButton r10, Head r11);

        void onSubSuccess(SubButton r10, boolean r11);
    }

    public SubButton(Context r10) {
        this(r10, null);
    }

    public static /* synthetic */ OnSubListener access$100(SubButton r10) {
        return r10.mOnSubListener;
    }

    public static /* synthetic */ void access$200(SubButton r10, boolean r11) {
        r10.reportSubSuccess(r11);
    }

    private void onSubcirbe(boolean r10) {
        e.z1(this.mSubscriber);
        InnerSubscriber r11 = new InnerSubscriber(this, null);
        this.mSubscriber = r11;
        r11.setSub(r10);
        AppStoreV15Rest r12 = AppStoreV15Rest.instance();
        String r13 = this.mId;
        if (r10 == false) goto L5;
        String r14 = "1";
    L6:
        r12.doSubscribe(r13, r14, this.mSubscriber);
        return;
    L5:
        r14 = AdReportParam.ClickPosType.SKIP;
        goto L6
    }

    private void reportSubSuccess(boolean r10) {
        if (this.mSubInfo != null) goto L5;
        return;
    L5:
        if (r10 == false) goto L7;
        String r11 = "0093";
    L8:
        HashMap r12 = new HashMap();
        r12.put(TrackerElement.GAME_NAME, this.mSubInfo.getName());
        r12.put("category", this.mSubInfo.getCategory());
        r12.put("online_time", this.mSubInfo.getOnline_time());
        r12.put("source", "from_my_subscribe");
        if (r10 == true) goto L11;
    L15:
        d9.a.e().R(r11, r12);
        return;
    L11:
        if (AccountDataCache.b().n() == false) goto L13;
        String r13 = "1";
    L14:
        r12.put("login_state", r13);
        goto L15
    L13:
        r13 = AdReportParam.ClickPosType.SKIP;
        goto L14
    L7:
        r11 = "0095";
        goto L8
    }

    private void setSubcirbeInner(boolean r10) {
        if (TextUtils.isEmpty(this.mTextSub) == false) goto L6;
        this.mTextSub = this.mContext.getResources().getString(R$string.subcribe);
    L6:
        if (TextUtils.isEmpty(this.mTextSubed) == false) goto L8;
        this.mTextSubed = this.mContext.getResources().getString(R$string.subcribed);
    L8:
        if (r10 == false) goto L10;
        setSelected(true);
        setText(this.mTextSubed);
    L11:
        this.mIsSubed = r10;
        return;
    L10:
        setSelected(false);
        setText(this.mTextSub);
        goto L11
    }

    public BaseInfo getBaseInfo() {
        return this.mSubInfo;
    }

    public OnSubListener getOnSubListener() {
        return this.mOnSubListener;
    }

    public int getStatus() {
        return this.mIsSubed ? 1 : 0;
    }

    public boolean isSubed() {
        return this.mIsSubed;
    }

    public void onSubClick() {
        OnSubListener r10 = this.mOnSubListener;
        if (r10 != null) goto L6;
        onSubcirbe(!this.mIsSubed);
        return;
    L6:
        if (r10.onSubClick(this, !this.mIsSubed) == false) goto L10;
        onSubcirbe(!this.mIsSubed);
        return;
    }

    public void setId(String r10) {
        this.mId = r10;
    }

    public void setOnSubListener(OnSubListener r10) {
        this.mOnSubListener = r10;
    }

    public void setSubText(String r10, String r11) {
        if (r10 == null) goto L4;
        this.mTextSub = r10;
    L4:
        if (r11 == null) goto L7;
        this.mTextSubed = r11;
        return;
    }

    public void setSubcirbe(boolean r10) {
        if (r10 == this.mIsSubed) goto L6;
        setSubcirbeInner(r10);
        return;
    }

    public void setSubscriberManager(ISubscriberManager r10) {
        this.mSubscriberManager = r10;
        if (r10 == null) goto L8;
        InnerSubscriber r11 = this.mSubscriber;
        if (r11 == null) goto L9;
        r10.addNSubscriber(r11);
        return;
    L9:
        return;
    }

    public void setTrackInfo(BaseInfo r10) {
        this.mSubInfo = r10;
    }

    public void toggleSub() {
        onSubcirbe(!this.mIsSubed);
    }

    public SubButton(Context r10, @Nullable AttributeSet r11) {
        this(r10, r11, 0);
    }

    public SubButton(Context r10, @Nullable AttributeSet r11, int r12) {
        this(r10, r11, r12, 0);
    }

    public SubButton(Context r10, @Nullable AttributeSet r11, int r12, int r13) {
        super(r10, r11, r12, r13);
        this.mId = "";
        this.mIsSubed = false;
        this.mTextSub = "";
        this.mTextSubed = "";
        this.mContext = r10;
        this.mSubscriber = new InnerSubscriber(this, null);
        p.b(this, new AnonymousClass1(this));
        setSubcirbeInner(false);
    }
}
