package com.android.server.dispatcher;

import android.content.Context;
import java.util.Collection;

/* JADX INFO: loaded from: classes2.dex */
public class SystemReadyDispatcher extends AbsDispatcher<SystemReadyObserver> {
    private static final AbsDispatcher.Lazy<SystemReadyDispatcher> INSTANCE = null;
    public static final String TAG = "GameAssist.SystemReadyDispatcher";
    private Context mContext;
    private boolean mIsSystemReady;

    public static /* synthetic */ void $r8$lambda$W4HgJskeNmcy03fhne04CNxWpWU(SystemReadyDispatcher r0, Context r1) {
        r0.lambda$notifySystemReady$0(r1);
    }

    public static /* synthetic */ void $r8$lambda$ZCkEe7ItxB2IlIeujMkgF86SVV0(Context r0, SystemReadyObserver r1) {
        lambda$notifySystemReady$1(r0, r1);
    }

    public static /* synthetic */ SystemReadyDispatcher $r8$lambda$bzYbljPu081kYvQZq4K532y6D5c() {
        return new SystemReadyDispatcher();
    }

    @Override // com.android.server.dispatcher.AbsDispatcher
    public /* bridge */ /* synthetic */ void registerObserver(AbsDispatcher.IObserver r1) {
        registerObserver((SystemReadyObserver) r1);
    }

    static {
        INSTANCE = new AbsDispatcher.Lazy(new SystemReadyDispatcher$$ExternalSyntheticLambda2());
    }

    private SystemReadyDispatcher() {
    }

    public static SystemReadyDispatcher getInstance() {
        return (SystemReadyDispatcher) INSTANCE.get();
    }

    public void registerObserver(SystemReadyObserver observer) {
        Collection r0 = this.mObservers;
        monitor-enter(r0);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.mIsSystemReady == false) goto L9;
        observer.onSystemReady(this.mContext);     // Catch: Throwable -> L7
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L9:
        super.registerObserver(observer);     // Catch: Throwable -> L7
        goto L10
    }

    private /* synthetic */ void lambda$notifySystemReady$0(Context context) {
        notifySystemReady(context);
    }

    public void notifySystemReady(final Context context) {
        if (switchThreads(new SystemReadyDispatcher$$ExternalSyntheticLambda0(this, context)) == false) goto L5;
        return;
    L5:
        Collection r0 = this.mObservers;
        monitor-enter(r0);
        this.mIsSystemReady = true;     // Catch: Throwable -> L11
        this.mContext = context;     // Catch: Throwable -> L11
        notifyObserver(new SystemReadyDispatcher$$ExternalSyntheticLambda1(context));     // Catch: Throwable -> L11
        this.mObservers.clear();     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }

    private static /* synthetic */ void lambda$notifySystemReady$1(Context context, SystemReadyObserver o) {
        o.onSystemReady(context);
    }
}
