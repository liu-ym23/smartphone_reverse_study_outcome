package com.bytedance.android.livesdkapi.wallet;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes12.dex */
public class TaskGiftWallet {

    @SerializedName("balance")
    private long balance;

    @SerializedName("consume")
    private long consume;

    @SerializedName("receive")
    private long receive;

    public TaskGiftWallet() {
    }

    public long getBalance() {
        return this.balance;
    }

    public long getConsume() {
        return this.consume;
    }

    public long getReceive() {
        return this.receive;
    }

    public void setBalance(long r100) {
        this.balance = r100;
    }

    public void setConsume(long r100) {
        this.consume = r100;
    }

    public void setReceive(long r100) {
        this.receive = r100;
    }
}
