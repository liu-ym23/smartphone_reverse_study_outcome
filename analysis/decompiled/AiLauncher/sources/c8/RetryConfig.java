package c8;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import kotlin.jvm.internal.i;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0014\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0013\u001a\u00020\t2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0011R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0018\u0010\u001aR\u0017\u0010\u0006\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u0019\u001a\u0004\b\u001b\u0010\u001aR\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u001c\u001a\u0004\b\u0015\u0010\u001dR\u0017\u0010\n\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u001e\u0010 ¨\u0006!"}, d2 = {"Lc8/d;", "", "", "maxRetryCount", "", "initialDelayMs", "maxDelayMs", "", "backoffMultiplier", "", "retryOnDisconnect", "<init>", "(IJJFZ)V", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", Const.INTENT_KEY_APIKEY, "I", Const.INTENT_KEY_UMID, Const.INTENT_KEY_PKGNAME, "J", "()J", "c", "F", "()F", "e", "Z", "()Z", "sdk_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: c8.d, reason: case insensitive filesystem and from toString */
/* loaded from: classes4.dex */
public final /* data */ class RetryConfig {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final int maxRetryCount;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    public final long initialDelayMs;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    public final long maxDelayMs;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    public final float backoffMultiplier;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    public final boolean retryOnDisconnect;

    public RetryConfig() {
        this(0, 0L, 0L, 0.0f, false, 31, null);
    }

    /* renamed from: a, reason: from getter */
    public final float getBackoffMultiplier() {
        return this.backoffMultiplier;
    }

    /* renamed from: b, reason: from getter */
    public final long getInitialDelayMs() {
        return this.initialDelayMs;
    }

    /* renamed from: c, reason: from getter */
    public final long getMaxDelayMs() {
        return this.maxDelayMs;
    }

    /* renamed from: d, reason: from getter */
    public final int getMaxRetryCount() {
        return this.maxRetryCount;
    }

    /* renamed from: e, reason: from getter */
    public final boolean getRetryOnDisconnect() {
        return this.retryOnDisconnect;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RetryConfig)) {
            return false;
        }
        RetryConfig retryConfig = (RetryConfig) other;
        return this.maxRetryCount == retryConfig.maxRetryCount && this.initialDelayMs == retryConfig.initialDelayMs && this.maxDelayMs == retryConfig.maxDelayMs && Float.compare(this.backoffMultiplier, retryConfig.backoffMultiplier) == 0 && this.retryOnDisconnect == retryConfig.retryOnDisconnect;
    }

    public int hashCode() {
        return (((((((Integer.hashCode(this.maxRetryCount) * 31) + Long.hashCode(this.initialDelayMs)) * 31) + Long.hashCode(this.maxDelayMs)) * 31) + Float.hashCode(this.backoffMultiplier)) * 31) + Boolean.hashCode(this.retryOnDisconnect);
    }

    public String toString() {
        return "RetryConfig(maxRetryCount=" + this.maxRetryCount + ", initialDelayMs=" + this.initialDelayMs + ", maxDelayMs=" + this.maxDelayMs + ", backoffMultiplier=" + this.backoffMultiplier + ", retryOnDisconnect=" + this.retryOnDisconnect + ")";
    }

    public RetryConfig(int i10, long j10, long j11, float f10, boolean z10) {
        this.maxRetryCount = i10;
        this.initialDelayMs = j10;
        this.maxDelayMs = j11;
        this.backoffMultiplier = f10;
        this.retryOnDisconnect = z10;
    }

    public /* synthetic */ RetryConfig(int i10, long j10, long j11, float f10, boolean z10, int i11, i iVar) {
        this((i11 & 1) != 0 ? 3 : i10, (i11 & 2) != 0 ? 1000L : j10, (i11 & 4) != 0 ? 10000L : j11, (i11 & 8) != 0 ? 1.5f : f10, (i11 & 16) != 0 ? true : z10);
    }
}
