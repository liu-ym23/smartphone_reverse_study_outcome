package com.android.volley;

/* JADX INFO: loaded from: classes.dex */
public class DefaultRetryPolicy implements RetryPolicy {
    public static final float DEFAULT_BACKOFF_MULT = 1.0f;
    public static final int DEFAULT_MAX_RETRIES = 1;
    public static final int DEFAULT_TIMEOUT_MS = 2500;
    private final float mBackoffMultiplier;
    private int mCurrentRetryCount;
    private int mCurrentTimeoutMs;
    private final int mMaxNumRetries;

    public DefaultRetryPolicy() {
        this(DEFAULT_TIMEOUT_MS, 1, 1.0f);
    }

    public float getBackoffMultiplier() {
        return this.mBackoffMultiplier;
    }

    @Override // com.android.volley.RetryPolicy
    public int getCurrentRetryCount() {
        return this.mCurrentRetryCount;
    }

    @Override // com.android.volley.RetryPolicy
    public int getCurrentTimeout() {
        return this.mCurrentTimeoutMs;
    }

    public boolean hasAttemptRemaining() {
        if (this.mCurrentRetryCount > this.mMaxNumRetries) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.android.volley.RetryPolicy
    public void retry(VolleyError r10) throws VolleyError {
        this.mCurrentRetryCount++;
        int r11 = this.mCurrentTimeoutMs;
        this.mCurrentTimeoutMs = (int) (r11 + (r11 * this.mBackoffMultiplier));
        if (hasAttemptRemaining() == false) goto L5;
        return;
    L5:
        throw r10;
    }

    public DefaultRetryPolicy(int r10, int r11, float r12) {
        this.mCurrentTimeoutMs = r10;
        this.mMaxNumRetries = r11;
        this.mBackoffMultiplier = r12;
    }
}
