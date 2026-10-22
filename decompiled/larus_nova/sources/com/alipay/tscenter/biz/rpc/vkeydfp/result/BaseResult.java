package com.alipay.tscenter.biz.rpc.vkeydfp.result;

import java.io.Serializable;

/* JADX INFO: loaded from: classes28.dex */
public class BaseResult implements Serializable {
    public String resultCode;
    public boolean success;

    public BaseResult() {
        this.success = false;
    }
}
