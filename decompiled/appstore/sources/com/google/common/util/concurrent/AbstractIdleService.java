package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Supplier;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes3.dex */
@Beta
@GwtIncompatible
public abstract class AbstractIdleService implements Service {
    private final Service delegate;
    private final Supplier<String> threadNameSupplier;

    public final class DelegateService extends AbstractService {
        final /* synthetic */ AbstractIdleService this$0;

        private DelegateService(AbstractIdleService r10) {
            this.this$0 = r10;
        }

        @Override // com.google.common.util.concurrent.AbstractService
        public final void doStart() {
            MoreExecutors.renamingDecorator(this.this$0.executor(), AbstractIdleService.access$200(this.this$0)).execute(new AnonymousClass1(this));
        }

        @Override // com.google.common.util.concurrent.AbstractService
        public final void doStop() {
            MoreExecutors.renamingDecorator(this.this$0.executor(), AbstractIdleService.access$200(this.this$0)).execute(new AnonymousClass2(this));
        }

        @Override // com.google.common.util.concurrent.AbstractService
        public String toString() {
            return this.this$0.toString();
        }

        public /* synthetic */ DelegateService(AbstractIdleService r10, AnonymousClass1 r11) {
            this(r10);
        }
    }

    public final class ThreadNameSupplier implements Supplier<String> {
        final /* synthetic */ AbstractIdleService this$0;

        private ThreadNameSupplier(AbstractIdleService r10) {
            this.this$0 = r10;
        }

        @Override // com.google.common.base.Supplier
        public /* bridge */ /* synthetic */ String get() {
            return get2();
        }

        public /* synthetic */ ThreadNameSupplier(AbstractIdleService r10, AnonymousClass1 r11) {
            this(r10);
        }

        @Override // com.google.common.base.Supplier
        /* JADX INFO: renamed from: get, reason: avoid collision after fix types in other method */
        public String get2() {
            return this.this$0.serviceName() + " " + this.this$0.state();
        }
    }

    public AbstractIdleService() {
        AnonymousClass1 r10 = null;
        this.threadNameSupplier = new ThreadNameSupplier(this, r10);
        this.delegate = new DelegateService(this, r10);
    }

    public static /* synthetic */ Supplier access$200(AbstractIdleService r10) {
        return r10.threadNameSupplier;
    }

    @Override // com.google.common.util.concurrent.Service
    public final void addListener(Service.Listener r10, Executor r11) {
        this.delegate.addListener(r10, r11);
    }

    @Override // com.google.common.util.concurrent.Service
    public final void awaitRunning() {
        this.delegate.awaitRunning();
    }

    @Override // com.google.common.util.concurrent.Service
    public final void awaitTerminated() {
        this.delegate.awaitTerminated();
    }

    public Executor executor() {
        return new AnonymousClass1(this);
    }

    @Override // com.google.common.util.concurrent.Service
    public final Throwable failureCause() {
        return this.delegate.failureCause();
    }

    @Override // com.google.common.util.concurrent.Service
    public final boolean isRunning() {
        return this.delegate.isRunning();
    }

    public String serviceName() {
        return getClass().getSimpleName();
    }

    public abstract void shutDown() throws Exception;

    @Override // com.google.common.util.concurrent.Service
    @CanIgnoreReturnValue
    public final Service startAsync() {
        this.delegate.startAsync();
        return this;
    }

    public abstract void startUp() throws Exception;

    @Override // com.google.common.util.concurrent.Service
    public final Service.State state() {
        return this.delegate.state();
    }

    @Override // com.google.common.util.concurrent.Service
    @CanIgnoreReturnValue
    public final Service stopAsync() {
        this.delegate.stopAsync();
        return this;
    }

    public String toString() {
        return serviceName() + " [" + state() + "]";
    }

    @Override // com.google.common.util.concurrent.Service
    public final void awaitRunning(long r10, TimeUnit r11) throws TimeoutException {
        this.delegate.awaitRunning(r10, r11);
    }

    @Override // com.google.common.util.concurrent.Service
    public final void awaitTerminated(long r10, TimeUnit r11) throws TimeoutException {
        this.delegate.awaitTerminated(r10, r11);
    }
}
