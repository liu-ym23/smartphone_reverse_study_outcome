package com.android.ttcjpaysdk.base.service;

/* JADX INFO: loaded from: classes28.dex */
public interface ICJPayVerifyQueryService extends ICJPayService {
    void initVerifyQuery(ICJPayVerifyQueryParams r100, ICJPayVerifyQueryCallBack r101);

    void release();

    void start();
}
