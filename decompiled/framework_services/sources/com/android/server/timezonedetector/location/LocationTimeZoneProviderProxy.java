package com.android.server.timezonedetector.location;

import android.content.Context;
import android.service.timezone.TimeZoneProviderEvent;
import com.android.server.timezonedetector.Dumpable;

/* JADX INFO: loaded from: classes3.dex */
abstract class LocationTimeZoneProviderProxy implements Dumpable {
    protected final Context mContext;
    protected Listener mListener;
    protected final Object mSharedLock;
    protected final ThreadingDomain mThreadingDomain;

    interface Listener {
        void onProviderBound();

        void onProviderUnbound();

        void onReportTimeZoneProviderEvent(TimeZoneProviderEvent r1);
    }

    public static /* synthetic */ void $r8$lambda$DhhgGbaJUmTh7DF_E6c1fB0VxVg(LocationTimeZoneProviderProxy r0, TimeZoneProviderEvent r1) {
        r0.lambda$handleTimeZoneProviderEvent$0(r1);
    }

    abstract void onDestroy();

    abstract void onInitialize();

    abstract void setRequest(TimeZoneProviderRequest r1);

    LocationTimeZoneProviderProxy(Context context, ThreadingDomain threadingDomain) {
        context.getClass();
        this.mContext = context;
        threadingDomain.getClass();
        this.mThreadingDomain = threadingDomain;
        this.mSharedLock = threadingDomain.getLockObject();
    }

    void initialize(Listener listener) {
        listener.getClass();
        Object r0 = this.mSharedLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mListener != null) goto L12;
        this.mListener = listener;     // Catch: Throwable -> L9
        onInitialize();     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L12:
        throw new IllegalStateException("listener already set");     // Catch: Throwable -> L9
    }

    void destroy() {
        Object r0 = this.mSharedLock;
        monitor-enter(r0);
        onDestroy();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ void lambda$handleTimeZoneProviderEvent$0(TimeZoneProviderEvent timeZoneProviderEvent) {
        this.mListener.onReportTimeZoneProviderEvent(timeZoneProviderEvent);
    }

    final void handleTimeZoneProviderEvent(final TimeZoneProviderEvent timeZoneProviderEvent) {
        this.mThreadingDomain.post(new LocationTimeZoneProviderProxy$$ExternalSyntheticLambda0(this, timeZoneProviderEvent));
    }
}
