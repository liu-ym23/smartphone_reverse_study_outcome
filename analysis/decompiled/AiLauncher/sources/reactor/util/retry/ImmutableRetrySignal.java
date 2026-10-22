package reactor.util.retry;

import reactor.util.context.Context;
import reactor.util.context.ContextView;
import reactor.util.retry.Retry;

/* loaded from: classes5.dex */
final class ImmutableRetrySignal implements Retry.RetrySignal {
    final Throwable failure;
    final long failureSubsequentIndex;
    final long failureTotalIndex;
    final ContextView retryContext;

    public ImmutableRetrySignal(long j10, long j11, Throwable th) {
        this(j10, j11, th, Context.empty());
    }

    @Override // reactor.util.retry.Retry.RetrySignal
    public Retry.RetrySignal copy() {
        return this;
    }

    @Override // reactor.util.retry.Retry.RetrySignal
    public Throwable failure() {
        return this.failure;
    }

    @Override // reactor.util.retry.Retry.RetrySignal
    public ContextView retryContextView() {
        return this.retryContext;
    }

    public String toString() {
        return "attempt #" + (this.failureTotalIndex + 1) + " (" + (this.failureSubsequentIndex + 1) + " in a row), last failure={" + this.failure + '}';
    }

    @Override // reactor.util.retry.Retry.RetrySignal
    public long totalRetries() {
        return this.failureTotalIndex;
    }

    @Override // reactor.util.retry.Retry.RetrySignal
    public long totalRetriesInARow() {
        return this.failureSubsequentIndex;
    }

    public ImmutableRetrySignal(long j10, long j11, Throwable th, ContextView contextView) {
        this.failureTotalIndex = j10;
        this.failureSubsequentIndex = j11;
        this.failure = th;
        this.retryContext = contextView;
    }
}
