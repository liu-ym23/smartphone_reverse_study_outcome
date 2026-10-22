package com.bytedance.android.livesdk.livecommerce.broadcast.bindcoupon.ui;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.livesdk.livecommerce.base.ECBaseViewModel;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import si2.p;

/* JADX INFO: loaded from: classes10.dex */
public class ECBindCouponViewModel extends ECBaseViewModel {
    private MutableLiveData<Void> mAdapterChangeData;
    private String mCouponExplain;
    private List<p> mCouponList;
    private MutableLiveData<String> mDistributeCouponData;
    private String mRoomId;

    private void requestData() {
    }

    public MutableLiveData<Void> getAdapterChangeData() {
        if (this.mAdapterChangeData != null) goto L6;
        this.mAdapterChangeData = new MutableLiveData();
    L6:
        return this.mAdapterChangeData;
    }

    public MutableLiveData<String> getDistributeCouponData() {
        if (this.mDistributeCouponData != null) goto L6;
        this.mDistributeCouponData = new MutableLiveData();
    L6:
        return this.mDistributeCouponData;
    }

    public ECBindCouponViewModel() {
        this.mCouponList = new ArrayList();
        this.mAdapterChangeData = null;
        this.mDistributeCouponData = null;
    }

    public List<p> getBindCouponList() {
        return this.mCouponList;
    }

    public void start() {
        requestData();
    }

    public void init(String r100) {
        this.mRoomId = r100;
    }

    public void onBindCouponSuccess(p r100) {
        if (r100 == null) goto L5;
        ListProtector.add(this.mCouponList, 0, r100);
        return;
    }
}
