package com.bytedance.android.livesdk.wrds.syncdata.highlight;

/* JADX INFO: loaded from: classes11.dex */
public abstract class a implements b {
    private transient boolean isReviewing;
    private transient long reviewingTime;

    public a() {
    }

    @Override // com.bytedance.android.livesdk.wrds.syncdata.highlight.b
    public long getReviewingTime() {
        return this.reviewingTime;
    }

    @Override // com.bytedance.android.livesdk.wrds.syncdata.highlight.b
    public boolean isReviewing() {
        return this.isReviewing;
    }

    public void setReviewing(boolean r100) {
        this.isReviewing = r100;
    }

    public void setReviewingTime(long r100) {
        this.reviewingTime = r100;
    }
}
