package com.android.server.location.gnss;

import android.location.IGnssNmeaListener;
import android.location.util.identity.CallerIdentity;
import android.os.IInterface;
import android.util.Log;
import com.android.internal.listeners.ListenerExecutor;
import com.android.server.location.gnss.hal.GnssNative;
import com.android.server.location.injector.AppOpsHelper;
import com.android.server.location.injector.Injector;
import java.util.Collection;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
class GnssNmeaProvider extends GnssListenerMultiplexer<Void, IGnssNmeaListener, Void> implements GnssNative.BaseCallbacks, GnssNative.NmeaCallbacks {
    private final AppOpsHelper mAppOpsHelper;
    private final GnssNative mGnssNative;
    private final byte[] mNmeaBuffer;

    /* JADX INFO: renamed from: com.android.server.location.gnss.GnssNmeaProvider$1, reason: invalid class name */
    class AnonymousClass1 implements Function<GnssListenerMultiplexer<Void, IGnssNmeaListener, Void>.GnssListenerRegistration, ListenerExecutor.ListenerOperation<IGnssNmeaListener>> {
        private String mNmea;
        final /* synthetic */ GnssNmeaProvider this$0;
        final /* synthetic */ long val$timestamp;

        public static /* synthetic */ void $r8$lambda$RW4x00Pt5uAQTzTKsC9Iup5H5RE(AnonymousClass1 r0, long r1, IGnssNmeaListener r3) {
            r0.lambda$apply$0(r1, r3);
        }

        AnonymousClass1(GnssNmeaProvider this$0, long r2) {
            this.this$0 = this$0;
            this.val$timestamp = r2;
        }

        @Override // java.util.function.Function
        public /* bridge */ /* synthetic */ ListenerExecutor.ListenerOperation<IGnssNmeaListener> apply(GnssListenerMultiplexer<Void, IGnssNmeaListener, Void>.GnssListenerRegistration r1) {
            return apply2(r1);
        }

        /* JADX INFO: renamed from: apply, reason: avoid collision after fix types in other method */
        public ListenerExecutor.ListenerOperation<IGnssNmeaListener> apply2(GnssListenerMultiplexer<Void, IGnssNmeaListener, Void>.GnssListenerRegistration registration) {
            if (GnssNmeaProvider.m5284$$Nest$fgetmAppOpsHelper(this.this$0).noteOpNoThrow(1, registration.getIdentity()) == true) goto L5;
            return null;
        L5:
            if (this.mNmea != null) goto L7;
            int length = GnssNmeaProvider.m5285$$Nest$fgetmGnssNative(this.this$0).readNmea(GnssNmeaProvider.m5286$$Nest$fgetmNmeaBuffer(this.this$0), GnssNmeaProvider.m5286$$Nest$fgetmNmeaBuffer(this.this$0).length);
            this.mNmea = new String(GnssNmeaProvider.m5286$$Nest$fgetmNmeaBuffer(this.this$0), 0, length);
        L7:
            final long r0 = this.val$timestamp;
            return new GnssNmeaProvider$1$$ExternalSyntheticLambda0(this, r0);
        }

        private /* synthetic */ void lambda$apply$0(long timestamp, IGnssNmeaListener listener) throws Exception {
            listener.onNmeaReceived(timestamp, this.mNmea);
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmAppOpsHelper, reason: not valid java name */
    static /* bridge */ /* synthetic */ AppOpsHelper m5284$$Nest$fgetmAppOpsHelper(GnssNmeaProvider r0) {
        return r0.mAppOpsHelper;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmGnssNative, reason: not valid java name */
    static /* bridge */ /* synthetic */ GnssNative m5285$$Nest$fgetmGnssNative(GnssNmeaProvider r0) {
        return r0.mGnssNative;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmNmeaBuffer, reason: not valid java name */
    static /* bridge */ /* synthetic */ byte[] m5286$$Nest$fgetmNmeaBuffer(GnssNmeaProvider r0) {
        return r0.mNmeaBuffer;
    }

    @Override // com.android.server.location.gnss.GnssListenerMultiplexer
    public /* bridge */ /* synthetic */ void addListener(CallerIdentity r1, IInterface r2) {
        addListener(r1, (IGnssNmeaListener) r2);
    }

    @Override // com.android.server.location.listeners.ListenerMultiplexer
    protected /* bridge */ /* synthetic */ boolean registerWithService(Object r1, Collection r2) {
        return registerWithService((Void) r1, r2);
    }

    GnssNmeaProvider(Injector injector, GnssNative gnssNative) {
        super(injector);
        this.mNmeaBuffer = new byte[120];
        this.mAppOpsHelper = injector.getAppOpsHelper();
        this.mGnssNative = gnssNative;
        this.mGnssNative.addBaseCallbacks(this);
        this.mGnssNative.addNmeaCallbacks(this);
    }

    public void addListener(CallerIdentity identity, IGnssNmeaListener listener) {
        super.addListener(identity, listener);
    }

    protected boolean registerWithService(Void ignored, Collection<GnssListenerMultiplexer<Void, IGnssNmeaListener, Void>.GnssListenerRegistration> registrations) {
        if (this.mGnssNative.startNmeaMessageCollection() == true) goto L5;
        Log.e(GnssManagerService.TAG, "error starting gnss nmea messages collection");
        return false;
    L5:
        if (GnssManagerService.D == false) goto L11;
        Log.d(GnssManagerService.TAG, "starting gnss nmea messages collection");
        return true;
    L11:
        return true;
    }

    @Override // com.android.server.location.listeners.ListenerMultiplexer
    protected void unregisterWithService() {
        if (this.mGnssNative.stopNmeaMessageCollection() == true) goto L5;
        Log.e(GnssManagerService.TAG, "error stopping gnss nmea messages collection");
        return;
    L5:
        if (GnssManagerService.D == false) goto L9;
        Log.d(GnssManagerService.TAG, "stopping gnss nmea messages collection");
        return;
    }

    @Override // com.android.server.location.gnss.hal.GnssNative.BaseCallbacks
    public void onHalRestarted() {
        resetService();
    }

    @Override // com.android.server.location.gnss.hal.GnssNative.NmeaCallbacks
    public void onReportNmea(long timestamp) {
        deliverToListeners(new AnonymousClass1(this, timestamp));
    }
}
