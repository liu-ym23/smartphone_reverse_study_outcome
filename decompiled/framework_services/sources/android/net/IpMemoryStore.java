package android.net;

import android.content.Context;
import android.net.networkstack.ModuleNetworkStackClient;
import android.util.Log;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Consumer;

/* JADX INFO: loaded from: classes.dex */
public class IpMemoryStore extends IpMemoryStoreClient {
    private static final String TAG = null;
    private final CompletableFuture<IIpMemoryStore> mService;
    private final AtomicReference<CompletableFuture<IIpMemoryStore>> mTailNode;

    /* JADX INFO: renamed from: $r8$lambda$_y2cX-Xlq_pqq30pduKRh7dpuR8, reason: not valid java name */
    public static /* synthetic */ IIpMemoryStore m3$r8$lambda$_y2cXXlq_pqq30pduKRh7dpuR8(Consumer r0, IIpMemoryStore r1, Throwable r2) {
        return lambda$runWhenServiceReady$0(r0, r1, r2);
    }

    public static /* synthetic */ CompletableFuture $r8$lambda$sLhwK6AqadCj9D89Up2tTYl8kJk(Consumer r0, CompletableFuture r1) {
        return lambda$runWhenServiceReady$1(r0, r1);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmService, reason: not valid java name */
    static /* bridge */ /* synthetic */ CompletableFuture m4$$Nest$fgetmService(IpMemoryStore r0) {
        return r0.mService;
    }

    static {
        TAG = IpMemoryStore.class.getSimpleName();
    }

    public IpMemoryStore(Context context) {
        super(context);
        this.mService = new CompletableFuture();
        this.mTailNode = new AtomicReference(this.mService);
        getModuleNetworkStackClient(context).fetchIpMemoryStore(new AnonymousClass1(this));
    }

    private static /* synthetic */ CompletableFuture lambda$runWhenServiceReady$1(final Consumer cb, CompletableFuture future) {
        return future.handle(new IpMemoryStore$$ExternalSyntheticLambda1(cb));
    }

    @Override // android.net.IpMemoryStoreClient
    protected void runWhenServiceReady(final Consumer<IIpMemoryStore> cb) throws ExecutionException {
        this.mTailNode.getAndUpdate(new IpMemoryStore$$ExternalSyntheticLambda0(cb));
    }

    private static /* synthetic */ IIpMemoryStore lambda$runWhenServiceReady$0(Consumer cb, IIpMemoryStore store, Throwable exception) {
        if (exception == null) goto L10;
        Log.wtf(TAG, "Error fetching IpMemoryStore", exception);
        return store;
    L10:
        cb.accept(store);     // Catch: Exception -> L7
    L9:
        return store;
    L7:
        e = move-exception;
        Log.wtf(TAG, "Exception occurred: " + e.getMessage());
        goto L9
    }

    protected ModuleNetworkStackClient getModuleNetworkStackClient(Context context) {
        return ModuleNetworkStackClient.getInstance(context);
    }

    public static IpMemoryStore getMemoryStore(Context context) {
        return new IpMemoryStore(context);
    }
}
