package b4;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public class b extends a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f5930c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f5931d;

    public b(Context r10) {
        this(r10, 4);
    }

    @Override // b4.a
    public long a() {
        if (this.f5931d >= this.f5930c) goto L5;
        long r10 = super.a();
    L7:
        if (r10 == (-1)) goto L9;
        this.f5931d++;
    L9:
        return r10;
    L5:
        r10 = -1;
        goto L7
    }

    @Override // b4.a, com.bytedance.common.wschannel.channel.impl.ok.policy.RetryPolicy
    public void reset() {
        super.reset();
        this.f5931d = 0;
    }

    public String toString() {
        return "RetryTimesPolicy{mMaxRetryTime=" + this.f5930c + ", mCurrRetryTime=" + this.f5931d + '}';
    }

    public b(Context r10, int r11) {
        super(r10);
        if (r11 >= 0) goto L5;
        r11 = 4;
    L5:
        this.f5930c = r11;
    }
}
