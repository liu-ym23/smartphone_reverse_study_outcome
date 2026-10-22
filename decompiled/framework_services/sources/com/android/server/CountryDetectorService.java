package com.android.server;

import android.R;
import android.content.Context;
import android.location.Country;
import android.location.CountryListener;
import android.location.ICountryDetector;
import android.location.ICountryListener;
import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Slog;
import com.android.internal.os.BackgroundThread;
import com.android.internal.util.DumpUtils;
import com.android.server.location.countrydetector.ComprehensiveCountryDetector;
import com.android.server.location.countrydetector.CountryDetectorBase;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class CountryDetectorService extends ICountryDetector.Stub {
    private static final boolean DEBUG = false;
    private static final String TAG = "CountryDetector";
    private final Context mContext;
    private CountryDetectorBase mCountryDetector;
    private Handler mHandler;
    private CountryListener mLocationBasedDetectorListener;
    private final HashMap<IBinder, Receiver> mReceivers;
    private boolean mSystemReady;

    private final class Receiver implements IBinder.DeathRecipient {
        private final IBinder mKey;
        private final ICountryListener mListener;
        final /* synthetic */ CountryDetectorService this$0;

        public Receiver(CountryDetectorService r1, ICountryListener listener) {
            this.this$0 = r1;
            this.mListener = listener;
            this.mKey = listener.asBinder();
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            CountryDetectorService.m148$$Nest$mremoveListener(this.this$0, this.mKey);
        }

        public boolean equals(Object otherObj) {
            if ((otherObj instanceof Receiver) == true) goto L5;
            return false;
        L5:
            return this.mKey.equals(((Receiver) otherObj).mKey);
        }

        public int hashCode() {
            return this.mKey.hashCode();
        }

        public ICountryListener getListener() {
            return this.mListener;
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$EcIcc10ESsW-qB6R7y-UYUq_R_I, reason: not valid java name */
    public static /* synthetic */ void m147$r8$lambda$EcIcc10ESsWqB6R7yUYUq_R_I(CountryDetectorService r0, Country r1) {
        r0.lambda$initialize$1(r1);
    }

    public static /* synthetic */ void $r8$lambda$HYkxybtKcKj3KOzS426QA588kgg(CountryDetectorService r0, CountryListener r1) {
        r0.lambda$setCountryListener$3(r1);
    }

    public static /* synthetic */ void $r8$lambda$w1hnAvR_BRhLPQmveSOw4E6Hh5M(CountryDetectorService r0) {
        r0.lambda$systemRunning$0();
    }

    public static /* synthetic */ void $r8$lambda$wxBk8Zh07pk9hg1fC3XTzbNmAQM(CountryDetectorService r0, Country r1) {
        r0.lambda$initialize$2(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mremoveListener, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m148$$Nest$mremoveListener(CountryDetectorService r0, IBinder r1) {
        r0.removeListener(r1);
    }

    public CountryDetectorService(Context context) {
        this(context, BackgroundThread.getHandler());
    }

    CountryDetectorService(Context context, Handler handler) {
        this.mReceivers = new HashMap();
        this.mContext = context;
        this.mHandler = handler;
    }

    public Country detectCountry() {
        if (this.mSystemReady == true) goto L7;
        return null;
    L7:
        return this.mCountryDetector.detectCountry();
    }

    public void addCountryListener(ICountryListener listener) throws RemoteException {
        if (this.mSystemReady == false) goto L7;
        addListener(listener);
        return;
    L7:
        throw new RemoteException();
    }

    public void removeCountryListener(ICountryListener listener) throws RemoteException {
        if (this.mSystemReady == false) goto L7;
        removeListener(listener.asBinder());
        return;
    L7:
        throw new RemoteException();
    }

    private void addListener(ICountryListener listener) {
        HashMap<IBinder, Receiver> r0 = this.mReceivers;
        monitor-enter(r0);
        Receiver r = new Receiver(this, listener);     // Catch: Throwable -> L8
        listener.asBinder().linkToDeath(r, 0);     // Catch: Throwable -> L8 RemoteException -> L10
        Country country = detectCountry();     // Catch: Throwable -> L8 RemoteException -> L10
        if (country == null) goto L12;
        listener.onCountryDetected(country);     // Catch: Throwable -> L8 RemoteException -> L10
    L12:
        this.mReceivers.put(listener.asBinder(), r);     // Catch: Throwable -> L8 RemoteException -> L10
        if (this.mReceivers.size() != 1) goto L18;
        Slog.d(TAG, "The first listener is added");     // Catch: Throwable -> L8 RemoteException -> L10
        setCountryListener(this.mLocationBasedDetectorListener);     // Catch: Throwable -> L8 RemoteException -> L10
    L18:
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        e = move-exception;
        Slog.e(TAG, "linkToDeath failed:", e);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        throw th;
    }

    private void removeListener(IBinder key) {
        HashMap<IBinder, Receiver> r0 = this.mReceivers;
        monitor-enter(r0);
        this.mReceivers.remove(key);     // Catch: Throwable -> L7
        if (this.mReceivers.isEmpty() == false) goto L9;
        setCountryListener(null);     // Catch: Throwable -> L7
        Slog.d(TAG, "No listener is left");     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    protected void notifyReceivers(Country country) {
        HashMap<IBinder, Receiver> r0 = this.mReceivers;
        monitor-enter(r0);
        Iterator<Receiver> r1 = this.mReceivers.values().iterator();     // Catch: Throwable -> L10
    L6:
        if (r1.hasNext() == false) goto L15;
        Receiver receiver = r1.next();     // Catch: Throwable -> L10
        receiver.getListener().onCountryDetected(country);     // Catch: Throwable -> L10 RemoteException -> L12
    L12:
        e = move-exception;
        Slog.e(TAG, "notifyReceivers failed:", e);     // Catch: Throwable -> L10
        goto L6
    L15:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    void systemRunning() {
        this.mHandler.post(new CountryDetectorService$$ExternalSyntheticLambda0(this));
    }

    private /* synthetic */ void lambda$systemRunning$0() {
        initialize();
        this.mSystemReady = true;
    }

    void initialize() {
        String customCountryClass = this.mContext.getString(R.string.config_defaultSystemCaptionsManagerService);
        if (TextUtils.isEmpty(customCountryClass) == true) goto L6;
        this.mCountryDetector = loadCustomCountryDetectorIfAvailable(customCountryClass);
    L6:
        if (this.mCountryDetector != null) goto L8;
        Slog.d(TAG, "Using default country detector");
        this.mCountryDetector = new ComprehensiveCountryDetector(this.mContext);
    L8:
        this.mLocationBasedDetectorListener = new CountryDetectorService$$ExternalSyntheticLambda2(this);
    }

    private /* synthetic */ void lambda$initialize$1(Country country) {
        notifyReceivers(country);
    }

    private /* synthetic */ void lambda$initialize$2(final Country country) {
        this.mHandler.post(new CountryDetectorService$$ExternalSyntheticLambda1(this, country));
    }

    private /* synthetic */ void lambda$setCountryListener$3(CountryListener listener) {
        this.mCountryDetector.setCountryListener(listener);
    }

    protected void setCountryListener(final CountryListener listener) {
        this.mHandler.post(new CountryDetectorService$$ExternalSyntheticLambda3(this, listener));
    }

    CountryDetectorBase getCountryDetector() {
        return this.mCountryDetector;
    }

    boolean isSystemReady() {
        return this.mSystemReady;
    }

    private CountryDetectorBase loadCustomCountryDetectorIfAvailable(String customCountryClass) {
        Slog.d(TAG, "Using custom country detector class: " + customCountryClass);
        CountryDetectorBase customCountryDetector = (CountryDetectorBase) Class.forName(customCountryClass).asSubclass(CountryDetectorBase.class).getConstructor(new Class[]{Context.class}).newInstance(new Object[]{this.mContext});     // Catch: Throwable -> L5
        return customCountryDetector;
    L6:
        Slog.e(TAG, "Could not instantiate the custom country detector class");
        return null;
    }

    protected void dump(FileDescriptor fd, PrintWriter fout, String[] args) {
        if (DumpUtils.checkDumpPermission(this.mContext, TAG, fout) == true) goto L5;
        return;
    }
}
