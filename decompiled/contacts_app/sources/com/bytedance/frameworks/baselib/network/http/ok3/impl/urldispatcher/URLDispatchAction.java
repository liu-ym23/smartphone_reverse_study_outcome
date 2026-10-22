package com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class URLDispatchAction extends BaseDispatchAction {
    private static final String TAG = "URLDispatchAction";
    private boolean mNeedRequestResultFeedBack;

    static {
    }

    public abstract BaseDispatchAction.DispatchResultEnum dispatch(URLRequest r1, String r2, List<String> r3);

    public abstract int getDispatchStrategyType();

    public int getTcTypedDropCode() {
        return -555;
    }

    protected abstract boolean loadActionParam(JSONObject r1, List<Boolean> r2, String r3, long r4);

    protected abstract void onRequestCompleted(String r1, boolean r2, int r3);

    public URLDispatchAction() {
        this.mNeedRequestResultFeedBack = false;
    }

    public BaseDispatchAction.DispatchResultEnum takeAction(URLRequest r5, String r6, List<String> r7, List<DispatchActionInfo> r8) {
        if (isActionEffective(r5) == true) goto L5;
    L15:
        r7.set(0, r6);
        return BaseDispatchAction.DispatchResultEnum.DISPATCH_NONE;
    L5:
        if (TextUtils.isEmpty(r6) == true) goto L15;
        BaseDispatchAction.DispatchResultEnum r9 = dispatch(r5, r6, r7);
        DispatchActionInfo r0 = new DispatchActionInfo();
        if (r9 == BaseDispatchAction.DispatchResultEnum.DISPATCH_NONE) goto L13;
        r0.mActionHit = true;
        r0.mRuleid = getRuleId();
        r0.mPriority = getPriority();
        r0.mStrategyType = getDispatchStrategyType();
        r0.mServiceName = getServiceName();
        if (r9 != BaseDispatchAction.DispatchResultEnum.DISPATCH_HIT) goto L12;
        r0.mDispatchedUrl = r7.get(0);
        r0.mNeedFeedBack = needRequestResultFeedBack();
    L12:
        r5.setDispatchPriority(this.mSetReqPriority);
    L13:
        r8.add(r0);
        return r9;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.BaseDispatchAction
    public boolean initWithActionParam(JSONObject r9, String r10, long r11) {
        ArrayList r6 = new ArrayList();
        r6.add(0, false);
        boolean r12 = loadActionParam(r9, r6, r10, r11);
        this.mNeedRequestResultFeedBack = r6.get(0).booleanValue();
        return r12;
    }

    public void notifyRequestCompleted(String r2, boolean r3, int r4) {
        if (this.mNeedRequestResultFeedBack == true) goto L5;
        return;
    L5:
        onRequestCompleted(r2, r3, r4);
    }

    public boolean needRequestResultFeedBack() {
        return this.mNeedRequestResultFeedBack;
    }
}
