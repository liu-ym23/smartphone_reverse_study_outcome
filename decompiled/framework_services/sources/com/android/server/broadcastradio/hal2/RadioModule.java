package com.android.server.broadcastradio.hal2;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.hardware.broadcastradio.V2_0.AmFmRegionConfig;
import android.hardware.broadcastradio.V2_0.DabTableEntry;
import android.hardware.broadcastradio.V2_0.IAnnouncementListener;
import android.hardware.broadcastradio.V2_0.IBroadcastRadio;
import android.hardware.broadcastradio.V2_0.ICloseHandle;
import android.hardware.broadcastradio.V2_0.ITunerCallback;
import android.hardware.broadcastradio.V2_0.ITunerSession;
import android.hardware.broadcastradio.V2_0.ProgramInfo;
import android.hardware.broadcastradio.V2_0.ProgramListChunk;
import android.hardware.broadcastradio.V2_0.ProgramSelector;
import android.hardware.broadcastradio.V2_0.VendorKeyValue;
import android.hardware.radio.Announcement;
import android.hardware.radio.ProgramList;
import android.hardware.radio.RadioManager;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import android.util.ArraySet;
import android.util.IndentingPrintWriter;
import android.util.MutableInt;
import com.android.server.broadcastradio.RadioEventLogger;
import com.android.server.broadcastradio.RadioServiceUserController;
import com.android.server.utils.Slogf;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/* JADX INFO: loaded from: classes.dex */
final class RadioModule {
    private static final int RADIO_EVENT_LOGGER_QUEUE_SIZE = 25;
    private static final String TAG = "BcRadio2Srv.module";
    private final Set<TunerSession> mAidlTunerSessions;
    private Boolean mAntennaConnected;
    private RadioManager.ProgramInfo mCurrentProgramInfo;
    private final RadioEventLogger mEventLogger;
    private final ITunerCallback mHalTunerCallback;
    private ITunerSession mHalTunerSession;
    private final Handler mHandler;
    private final Object mLock;
    private final ProgramInfoCache mProgramInfoCache;
    private final RadioManager.ModuleProperties mProperties;
    private final IBroadcastRadio mService;
    private ProgramList.Filter mUnionOfAidlProgramFilters;
    private final RadioServiceUserController mUserController;

    /* JADX INFO: renamed from: com.android.server.broadcastradio.hal2.RadioModule$1, reason: invalid class name */
    class AnonymousClass1 extends ITunerCallback.Stub {
        final /* synthetic */ RadioModule this$0;

        public static /* synthetic */ void $r8$lambda$Ar22CUefBKX8cdyFGpLCevq3mro(AnonymousClass1 r0, boolean r1) {
            r0.lambda$onAntennaStateChange$6(r1);
        }

        /* JADX INFO: renamed from: $r8$lambda$ESrJ-DyD8sPMs92DWc5nIkPC2jQ, reason: not valid java name */
        public static /* synthetic */ void m2843$r8$lambda$ESrJDyD8sPMs92DWc5nIkPC2jQ(AnonymousClass1 r0, ProgramListChunk r1) {
            r0.lambda$onProgramListUpdated$4(r1);
        }

        public static /* synthetic */ void $r8$lambda$K_B6OFgK6R3ZquDWE4PFp0RpZyo(boolean r0, android.hardware.radio.ITunerCallback r1) {
            lambda$onAntennaStateChange$5(r0, r1);
        }

        /* JADX INFO: renamed from: $r8$lambda$PNAnE43Xjd7YJS7OA-c3ZB9F3Ak, reason: not valid java name */
        public static /* synthetic */ void m2844$r8$lambda$PNAnE43Xjd7YJS7OAc3ZB9F3Ak(Map r0, android.hardware.radio.ITunerCallback r1) {
            lambda$onParametersUpdated$7(r0, r1);
        }

        /* JADX INFO: renamed from: $r8$lambda$kIxo-_RiJLS8Af8BEcAnydNQE5A, reason: not valid java name */
        public static /* synthetic */ void m2845$r8$lambda$kIxo_RiJLS8Af8BEcAnydNQE5A(AnonymousClass1 r0, ArrayList r1) {
            r0.lambda$onParametersUpdated$8(r1);
        }

        public static /* synthetic */ void $r8$lambda$ljE7mxVvLlXwrX7mGfYnQQgQ4EE(AnonymousClass1 r0, ProgramSelector r1, int r2) {
            r0.lambda$onTuneFailed$1(r1, r2);
        }

        public static /* synthetic */ void $r8$lambda$mFxwqZpg8naHgZukbZ5Hk8AZR2A(AnonymousClass1 r0, ProgramInfo r1) {
            r0.lambda$onCurrentProgramInfoChanged$3(r1);
        }

        /* JADX INFO: renamed from: $r8$lambda$q-y-OGxzGFtDxxn-5X1LNRosygE, reason: not valid java name */
        public static /* synthetic */ void m2846$r8$lambda$qyOGxzGFtDxxn5X1LNRosygE(RadioManager.ProgramInfo r0, android.hardware.radio.ITunerCallback r1) {
            lambda$onCurrentProgramInfoChanged$2(r0, r1);
        }

        public static /* synthetic */ void $r8$lambda$sph2oMRTsNabax6Crq3Q6IAEUdk(int r0, android.hardware.radio.ProgramSelector r1, android.hardware.radio.ITunerCallback r2) {
            lambda$onTuneFailed$0(r0, r1, r2);
        }

        AnonymousClass1(RadioModule this$0) {
            this.this$0 = this$0;
        }

        @Override // android.hardware.broadcastradio.V2_0.ITunerCallback
        public void onTuneFailed(final int result, final ProgramSelector programSelector) {
            RadioModule.m2842$$Nest$mfireLater(this.this$0, new RadioModule$1$$ExternalSyntheticLambda6(this, programSelector, result));
        }

        private /* synthetic */ void lambda$onTuneFailed$1(ProgramSelector programSelector, int result) {
            final android.hardware.radio.ProgramSelector csel = Convert.programSelectorFromHal(programSelector);
            final int tunerResult = Convert.halResultToTunerResult(result);
            Object r2 = RadioModule.m2837$$Nest$fgetmLock(this.this$0);
            monitor-enter(r2);
            RadioModule.m2841$$Nest$mfanoutAidlCallbackLocked(this.this$0, new RadioModule$1$$ExternalSyntheticLambda0(tunerResult, csel));     // Catch: Throwable -> L7
            monitor-exit(r2);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        private static /* synthetic */ void lambda$onTuneFailed$0(int tunerResult, android.hardware.radio.ProgramSelector csel, android.hardware.radio.ITunerCallback cb) throws RemoteException {
            cb.onTuneFailed(tunerResult, csel);
        }

        @Override // android.hardware.broadcastradio.V2_0.ITunerCallback
        public void onCurrentProgramInfoChanged(final ProgramInfo halProgramInfo) {
            RadioModule.m2842$$Nest$mfireLater(this.this$0, new RadioModule$1$$ExternalSyntheticLambda2(this, halProgramInfo));
        }

        private /* synthetic */ void lambda$onCurrentProgramInfoChanged$3(ProgramInfo halProgramInfo) {
            Object r0 = RadioModule.m2837$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
            RadioModule.m2840$$Nest$fputmCurrentProgramInfo(this.this$0, Convert.programInfoFromHal(halProgramInfo));     // Catch: Throwable -> L7
            final RadioManager.ProgramInfo currentProgramInfo = RadioModule.m2836$$Nest$fgetmCurrentProgramInfo(this.this$0);     // Catch: Throwable -> L7
            RadioModule.m2841$$Nest$mfanoutAidlCallbackLocked(this.this$0, new RadioModule$1$$ExternalSyntheticLambda7(currentProgramInfo));     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        private static /* synthetic */ void lambda$onCurrentProgramInfoChanged$2(RadioManager.ProgramInfo currentProgramInfo, android.hardware.radio.ITunerCallback cb) throws RemoteException {
            cb.onCurrentProgramInfoChanged(currentProgramInfo);
        }

        @Override // android.hardware.broadcastradio.V2_0.ITunerCallback
        public void onProgramListUpdated(final ProgramListChunk programListChunk) {
            RadioModule.m2842$$Nest$mfireLater(this.this$0, new RadioModule$1$$ExternalSyntheticLambda8(this, programListChunk));
        }

        private /* synthetic */ void lambda$onProgramListUpdated$4(ProgramListChunk programListChunk) {
            Object r0 = RadioModule.m2837$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
            RadioModule.m2838$$Nest$fgetmProgramInfoCache(this.this$0).filterAndApplyChunk(programListChunk);     // Catch: Throwable -> L8
            Iterator r1 = RadioModule.m2835$$Nest$fgetmAidlTunerSessions(this.this$0).iterator();     // Catch: Throwable -> L8
        L6:
            if (r1.hasNext() == false) goto L10;
            TunerSession tunerSession = (TunerSession) r1.next();     // Catch: Throwable -> L8
            tunerSession.onMergedProgramListUpdateFromHal(programListChunk);     // Catch: Throwable -> L8
            goto L6
        L10:
            monitor-exit(r0);     // Catch: Throwable -> L8
            return;
        L8:
            th = move-exception;
            throw th;
        }

        @Override // android.hardware.broadcastradio.V2_0.ITunerCallback
        public void onAntennaStateChange(final boolean connected) {
            RadioModule.m2842$$Nest$mfireLater(this.this$0, new RadioModule$1$$ExternalSyntheticLambda3(this, connected));
        }

        private /* synthetic */ void lambda$onAntennaStateChange$6(final boolean connected) {
            Object r0 = RadioModule.m2837$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
            RadioModule.m2839$$Nest$fputmAntennaConnected(this.this$0, Boolean.valueOf(connected));     // Catch: Throwable -> L7
            RadioModule.m2841$$Nest$mfanoutAidlCallbackLocked(this.this$0, new RadioModule$1$$ExternalSyntheticLambda5(connected));     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        private static /* synthetic */ void lambda$onAntennaStateChange$5(boolean connected, android.hardware.radio.ITunerCallback cb) throws RemoteException {
            cb.onAntennaState(connected);
        }

        @Override // android.hardware.broadcastradio.V2_0.ITunerCallback
        public void onParametersUpdated(final ArrayList<VendorKeyValue> parameters) {
            RadioModule.m2842$$Nest$mfireLater(this.this$0, new RadioModule$1$$ExternalSyntheticLambda4(this, parameters));
        }

        private /* synthetic */ void lambda$onParametersUpdated$8(ArrayList parameters) {
            final Map<String, String> cparam = Convert.vendorInfoFromHal(parameters);
            Object r1 = RadioModule.m2837$$Nest$fgetmLock(this.this$0);
            monitor-enter(r1);
            RadioModule.m2841$$Nest$mfanoutAidlCallbackLocked(this.this$0, new RadioModule$1$$ExternalSyntheticLambda1(cparam));     // Catch: Throwable -> L7
            monitor-exit(r1);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        private static /* synthetic */ void lambda$onParametersUpdated$7(Map cparam, android.hardware.radio.ITunerCallback cb) throws RemoteException {
            cb.onParametersUpdated(cparam);
        }
    }

    /* JADX INFO: renamed from: com.android.server.broadcastradio.hal2.RadioModule$2, reason: invalid class name */
    class AnonymousClass2 extends IAnnouncementListener.Stub {
        final /* synthetic */ android.hardware.radio.IAnnouncementListener val$listener;

        public static /* synthetic */ Announcement $r8$lambda$woTpjYEETpgvCD0ZnRH3XwfmX38(android.hardware.broadcastradio.V2_0.Announcement r0) {
            return lambda$onListUpdated$0(r0);
        }

        AnonymousClass2(RadioModule this$0, android.hardware.radio.IAnnouncementListener r2) {
            this.val$listener = r2;
        }

        @Override // android.hardware.broadcastradio.V2_0.IAnnouncementListener
        public void onListUpdated(ArrayList<android.hardware.broadcastradio.V2_0.Announcement> hwAnnouncements) throws RemoteException {
            this.val$listener.onListUpdated((List) hwAnnouncements.stream().map(new RadioModule$2$$ExternalSyntheticLambda0()).collect(Collectors.toList()));
        }

        private static /* synthetic */ Announcement lambda$onListUpdated$0(android.hardware.broadcastradio.V2_0.Announcement a) {
            return Convert.announcementFromHal(a);
        }
    }

    interface AidlCallbackRunnable {
        void run(android.hardware.radio.ITunerCallback r1) throws RemoteException;
    }

    public static /* synthetic */ void $r8$lambda$3rDNTzqwvg5pqbasgZfTWIp0aRU(MutableInt r0, Mutable r1, int r2, ICloseHandle r3) {
        lambda$addAnnouncementListener$5(r0, r1, r2, r3);
    }

    public static /* synthetic */ void $r8$lambda$F11ZMO9Swehvv4LY5Bve1y1uqss(Mutable r0, int r1, ArrayList r2) {
        lambda$tryLoadingModule$1(r0, r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$Mc6gkDn6U-6r6aOhlyxW2WqfeVI, reason: not valid java name */
    public static /* synthetic */ void m2832$r8$lambda$Mc6gkDn6U6r6aOhlyxW2WqfeVI(Runnable r0) {
        lambda$fireLater$3(r0);
    }

    /* JADX INFO: renamed from: $r8$lambda$hsPGfMTSosBjt-ibv2YG5sNMvy8, reason: not valid java name */
    public static /* synthetic */ void m2833$r8$lambda$hsPGfMTSosBjtibv2YG5sNMvy8(Mutable r0, int r1, AmFmRegionConfig r2) {
        lambda$tryLoadingModule$0(r0, r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$iXXvp5qET-iFifR9Pyko90gfm80, reason: not valid java name */
    public static /* synthetic */ ArrayList m2834$r8$lambda$iXXvp5qETiFifR9Pyko90gfm80(RadioModule r0, int r1) {
        return r0.lambda$getImage$6(r1);
    }

    public static /* synthetic */ void $r8$lambda$qpSpnBk0a9tywybXm685yjtLJl8(RadioModule r0, AidlCallbackRunnable r1) {
        r0.lambda$fanoutAidlCallback$4(r1);
    }

    public static /* synthetic */ void $r8$lambda$rD8OOmJHtYynuqLF5nPFbVa9eZQ(RadioModule r0, Mutable r1, int r2, ITunerSession r3) {
        r0.lambda$openSession$2(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmAidlTunerSessions, reason: not valid java name */
    static /* bridge */ /* synthetic */ Set m2835$$Nest$fgetmAidlTunerSessions(RadioModule r0) {
        return r0.mAidlTunerSessions;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmCurrentProgramInfo, reason: not valid java name */
    static /* bridge */ /* synthetic */ RadioManager.ProgramInfo m2836$$Nest$fgetmCurrentProgramInfo(RadioModule r0) {
        return r0.mCurrentProgramInfo;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m2837$$Nest$fgetmLock(RadioModule r0) {
        return r0.mLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmProgramInfoCache, reason: not valid java name */
    static /* bridge */ /* synthetic */ ProgramInfoCache m2838$$Nest$fgetmProgramInfoCache(RadioModule r0) {
        return r0.mProgramInfoCache;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmAntennaConnected, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2839$$Nest$fputmAntennaConnected(RadioModule r0, Boolean r1) {
        r0.mAntennaConnected = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmCurrentProgramInfo, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2840$$Nest$fputmCurrentProgramInfo(RadioModule r0, RadioManager.ProgramInfo r1) {
        r0.mCurrentProgramInfo = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$mfanoutAidlCallbackLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2841$$Nest$mfanoutAidlCallbackLocked(RadioModule r0, AidlCallbackRunnable r1) {
        r0.fanoutAidlCallbackLocked(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mfireLater, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2842$$Nest$mfireLater(RadioModule r0, Runnable r1) {
        r0.fireLater(r1);
    }

    RadioModule(IBroadcastRadio service, RadioManager.ModuleProperties properties, RadioServiceUserController userController) {
        this.mLock = new Object();
        this.mAntennaConnected = null;
        this.mCurrentProgramInfo = null;
        this.mProgramInfoCache = new ProgramInfoCache(null);
        this.mUnionOfAidlProgramFilters = null;
        this.mHalTunerCallback = new AnonymousClass1(this);
        this.mAidlTunerSessions = new ArraySet();
        properties.getClass();
        this.mProperties = properties;
        service.getClass();
        this.mService = service;
        this.mHandler = new Handler(Looper.getMainLooper());
        userController.getClass();
        this.mUserController = userController;
        this.mEventLogger = new RadioEventLogger(TAG, 25);
    }

    static RadioModule tryLoadingModule(int idx, String fqName, RadioServiceUserController controller) {
        Slogf.i(TAG, "Try loading module for idx " + idx + ", fqName " + fqName);     // Catch: RemoteException -> L7
        IBroadcastRadio service = IBroadcastRadio.getService(fqName);     // Catch: RemoteException -> L7
        if (service != null) goto L9;
        Slogf.w(TAG, "No service found for fqName " + fqName);     // Catch: RemoteException -> L7
        return null;
    L9:
        final Mutable<AmFmRegionConfig> amfmConfig = new Mutable();     // Catch: RemoteException -> L7
        service.getAmFmRegionConfig(false, new RadioModule$$ExternalSyntheticLambda3(amfmConfig));     // Catch: RemoteException -> L7
        final Mutable<List<DabTableEntry>> dabConfig = new Mutable();     // Catch: RemoteException -> L7
        service.getDabRegionConfig(new RadioModule$$ExternalSyntheticLambda4(dabConfig));     // Catch: RemoteException -> L7
        RadioManager.ModuleProperties prop = Convert.propertiesFromHal(idx, fqName, service.getProperties(), amfmConfig.value, dabConfig.value);     // Catch: RemoteException -> L7
        return new RadioModule(service, prop, controller);
    L7:
        ex = move-exception;
        Slogf.e(TAG, "Failed to load module " + fqName, ex);
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static /* synthetic */ void lambda$tryLoadingModule$0(Mutable amfmConfig, int result, AmFmRegionConfig r2) {
        if (result != 0) goto L5;
        amfmConfig.value = r2;
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static /* synthetic */ void lambda$tryLoadingModule$1(Mutable dabConfig, int result, ArrayList r2) {
        if (result != 0) goto L5;
        dabConfig.value = r2;
        return;
    }

    IBroadcastRadio getService() {
        return this.mService;
    }

    public RadioManager.ModuleProperties getProperties() {
        return this.mProperties;
    }

    TunerSession openSession(android.hardware.radio.ITunerCallback userCb) throws RemoteException {
        this.mEventLogger.logRadioEvent("Open TunerSession", new Object[0]);
        Object r0 = this.mLock;
        monitor-enter(r0);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.mHalTunerSession != null) goto L9;
        final Mutable<ITunerSession> hwSession = new Mutable();     // Catch: Throwable -> L7
        this.mService.openSession(this.mHalTunerCallback, new RadioModule$$ExternalSyntheticLambda6(this, hwSession));     // Catch: Throwable -> L7
        ITunerSession r2 = hwSession.value;     // Catch: Throwable -> L7
        r2.getClass();     // Catch: Throwable -> L7
        this.mHalTunerSession = r2;     // Catch: Throwable -> L7
    L9:
        TunerSession tunerSession = new TunerSession(this, this.mHalTunerSession, userCb, this.mUserController);     // Catch: Throwable -> L7
        this.mAidlTunerSessions.add(tunerSession);     // Catch: Throwable -> L7
        if (this.mAntennaConnected == null) goto L13;
        userCb.onAntennaState(this.mAntennaConnected.booleanValue());     // Catch: Throwable -> L7
    L13:
        if (this.mCurrentProgramInfo == null) goto L15;
        userCb.onCurrentProgramInfoChanged(this.mCurrentProgramInfo);     // Catch: Throwable -> L7
    L15:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return tunerSession;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private /* synthetic */ void lambda$openSession$2(Mutable hwSession, int result, ITunerSession r6) {
        Convert.throwOnError("openSession", result);
        hwSession.value = r6;
        this.mEventLogger.logRadioEvent("New HIDL 2.0 tuner session is opened", new Object[0]);
    }

    void closeSessions(Integer error) {
        int r2 = 0;
        this.mEventLogger.logRadioEvent("Close TunerSessions", new Object[0]);
        Object r0 = this.mLock;
        monitor-enter(r0);
        TunerSession[] tunerSessions = new TunerSession[this.mAidlTunerSessions.size()];     // Catch: Throwable -> L10
        this.mAidlTunerSessions.toArray(tunerSessions);     // Catch: Throwable -> L10
        this.mAidlTunerSessions.clear();     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        int r1 = tunerSessions.length;
    L7:
        if (r2 >= r1) goto L9;
        TunerSession tunerSession = tunerSessions[r2];
        tunerSession.close(error);
        r2 = r2 + 1;
        goto L7
    L9:
        return;
    L10:
        th = move-exception;
        throw th;
    }

    private ProgramList.Filter buildUnionOfTunerSessionFiltersLocked() {
        Set<Integer> idTypes = null;
        Set<android.hardware.radio.ProgramSelector.Identifier> ids = null;
        boolean includeCategories = false;
        boolean excludeModifications = true;
        Iterator<TunerSession> r4 = this.mAidlTunerSessions.iterator();
    L4:
        if (r4.hasNext() == false) goto L23;
        TunerSession tunerSession = r4.next();
        ProgramList.Filter filter = tunerSession.getProgramListFilter();
        if (filter == null) goto L4;
        if (idTypes == null) goto L9;
        if (idTypes.isEmpty() == true) goto L17;
        if (filter.getIdentifierTypes().isEmpty() == false) goto L15;
        idTypes.clear();
        goto L17
    L15:
        idTypes.addAll(filter.getIdentifierTypes());
    L17:
        if (ids.isEmpty() == false) goto L19;
    L22:
        includeCategories = includeCategories | filter.areCategoriesIncluded();
        excludeModifications = excludeModifications & filter.areModificationsExcluded();
        goto L4
    L19:
        if (filter.getIdentifiers().isEmpty() == false) goto L21;
        ids.clear();
        goto L22
    L21:
        ids.addAll(filter.getIdentifiers());
        goto L22
    L9:
        idTypes = new ArraySet(filter.getIdentifierTypes());
        ids = new ArraySet(filter.getIdentifiers());
        includeCategories = filter.areCategoriesIncluded();
        excludeModifications = filter.areModificationsExcluded();
        goto L4
    L23:
        if (idTypes != null) goto L26;
        return null;
    L26:
        return new ProgramList.Filter(idTypes, ids, includeCategories, excludeModifications);
    }

    void onTunerSessionProgramListFilterChanged(TunerSession session) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        onTunerSessionProgramListFilterChangedLocked(session);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void onTunerSessionProgramListFilterChangedLocked(TunerSession session) {
        ProgramList.Filter newFilter = buildUnionOfTunerSessionFiltersLocked();
        if (newFilter != null) goto L14;
        if (this.mUnionOfAidlProgramFilters != null) goto L7;
        return;
    L7:
        this.mUnionOfAidlProgramFilters = null;
        this.mHalTunerSession.stopProgramListUpdates();     // Catch: RemoteException -> L10
        return;
    L10:
        ex = move-exception;
        Slogf.e(TAG, "mHalTunerSession.stopProgramListUpdates() failed: ", ex);
        return;
    L14:
        if (newFilter.equals(this.mUnionOfAidlProgramFilters) == false) goto L18;
        if (session == null) goto L29;
        session.updateProgramInfoFromHalCache(this.mProgramInfoCache);
        return;
    L29:
        return;
    L18:
        this.mUnionOfAidlProgramFilters = newFilter;
        int halResult = this.mHalTunerSession.startProgramListUpdates(Convert.programFilterToHal(newFilter));     // Catch: RemoteException -> L21
        Convert.throwOnError("startProgramListUpdates", halResult);     // Catch: RemoteException -> L21
        return;
    L21:
        ex = move-exception;
        Slogf.e(TAG, "mHalTunerSession.startProgramListUpdates() failed: ", ex);
    }

    void onTunerSessionClosed(TunerSession tunerSession) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        onTunerSessionsClosedLocked(new TunerSession[]{tunerSession});     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void onTunerSessionsClosedLocked(TunerSession... tunerSessions) {
        int r0 = tunerSessions.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L5;
        TunerSession tunerSession = tunerSessions[r2];
        this.mAidlTunerSessions.remove(tunerSession);
        r2 = r2 + 1;
        goto L3
    L5:
        onTunerSessionProgramListFilterChanged(null);
        if (this.mAidlTunerSessions.isEmpty() == true) goto L8;
        return;
    L8:
        if (this.mHalTunerSession == null) goto L20;
        this.mEventLogger.logRadioEvent("Closing HAL tuner session", new Object[0]);
        this.mHalTunerSession.close();     // Catch: RemoteException -> L12
    L14:
        this.mHalTunerSession = null;
        return;
    L12:
        ex = move-exception;
        Slogf.e(TAG, "mHalTunerSession.close() failed: ", ex);
        goto L14
    }

    private void fireLater(final Runnable r) {
        this.mHandler.post(new RadioModule$$ExternalSyntheticLambda1(r));
    }

    private static /* synthetic */ void lambda$fireLater$3(Runnable r) {
        r.run();
    }

    void fanoutAidlCallback(final AidlCallbackRunnable runnable) {
        fireLater(new RadioModule$$ExternalSyntheticLambda2(this, runnable));
    }

    private /* synthetic */ void lambda$fanoutAidlCallback$4(AidlCallbackRunnable runnable) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        fanoutAidlCallbackLocked(runnable);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void fanoutAidlCallbackLocked(AidlCallbackRunnable runnable) {
        int currentUserId = this.mUserController.getCurrentUser();
        List<TunerSession> deadSessions = null;
        Iterator<TunerSession> r3 = this.mAidlTunerSessions.iterator();
    L4:
        if (r3.hasNext() == false) goto L23;
        TunerSession tunerSession = r3.next();
        if (tunerSession.mUserId != currentUserId) goto L8;
    L26:
        runnable.run(tunerSession.mCallback);     // Catch: RemoteException -> L12 DeadObjectException -> L14
    L12:
        ex = move-exception;
        Slogf.e(TAG, "Failed to invoke ITunerCallback: ", ex);
    L17:
        Slogf.e(TAG, "Removing dead TunerSession");
        if (deadSessions != null) goto L20;
        deadSessions = new ArrayList();
    L20:
        deadSessions.add(tunerSession);
        goto L4
    L8:
        if (tunerSession.mUserId == 0) goto L26;
    L23:
        if (deadSessions == null) goto L34;
        onTunerSessionsClosedLocked((TunerSession[]) deadSessions.toArray(new TunerSession[0]));
        return;
    }

    android.hardware.radio.ICloseHandle addAnnouncementListener(int[] enabledTypes, android.hardware.radio.IAnnouncementListener listener) throws RemoteException {
        int r1 = 0;
        this.mEventLogger.logRadioEvent("Add AnnouncementListener", new Object[0]);
        ArrayList<Byte> enabledList = new ArrayList();
        int r2 = enabledTypes.length;
    L3:
        if (r1 >= r2) goto L5;
        int type = enabledTypes[r1];
        enabledList.add(Byte.valueOf((byte) type));
        r1 = r1 + 1;
        goto L3
    L5:
        final MutableInt halResult = new MutableInt(1);
        final Mutable<ICloseHandle> hwCloseHandle = new Mutable();
        IAnnouncementListener hwListener = new AnonymousClass2(this, listener);
        this.mService.registerAnnouncementListener(enabledList, hwListener, new RadioModule$$ExternalSyntheticLambda5(halResult, hwCloseHandle));
        Convert.throwOnError("addAnnouncementListener", halResult.value);
        return new AnonymousClass3(this, hwCloseHandle);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static /* synthetic */ void lambda$addAnnouncementListener$5(MutableInt halResult, Mutable hwCloseHandle, int result, ICloseHandle r3) {
        halResult.value = result;
        hwCloseHandle.value = r3;
    }

    Bitmap getImage(final int id) {
        this.mEventLogger.logRadioEvent("Get image for id %d", new Object[]{Integer.valueOf(id)});
        if (id == 0) goto L15;
        List<Byte> rawList = (List) Utils.maybeRethrow(new RadioModule$$ExternalSyntheticLambda0(this, id));
        byte[] rawImage = new byte[rawList.size()];
        int i = 0;
    L6:
        if (i >= rawList.size()) goto L8;
        rawImage[i] = rawList.get(i).byteValue();
        i = i + 1;
        goto L6
    L8:
        int i2 = rawImage.length;
        if (i2 != 0) goto L13;
        return null;
    L13:
        return BitmapFactory.decodeByteArray(rawImage, 0, rawImage.length);
    L15:
        throw new IllegalArgumentException("Image ID is missing");
    }

    private /* synthetic */ ArrayList lambda$getImage$6(int id) throws RemoteException {
        return this.mService.getImage(id);
    }

    void dumpInfo(IndentingPrintWriter pw) {
        pw.printf("RadioModule\n", new Object[0]);
        pw.increaseIndent();
        pw.printf("BroadcastRadioService: %s\n", new Object[]{this.mService});
        pw.printf("Properties: %s\n", new Object[]{this.mProperties});
        Object r0 = this.mLock;
        monitor-enter(r0);
        pw.printf("HIDL 2.0 HAL TunerSession: %s\n", new Object[]{this.mHalTunerSession});     // Catch: Throwable -> L7
        pw.printf("Is antenna connected? ", new Object[0]);     // Catch: Throwable -> L7
        if (this.mAntennaConnected != null) goto L10;
        pw.printf("null\n", new Object[0]);     // Catch: Throwable -> L7
    L14:
        pw.printf("Current ProgramInfo: %s\n", new Object[]{this.mCurrentProgramInfo});     // Catch: Throwable -> L7
        pw.printf("ProgramInfoCache: %s\n", new Object[]{this.mProgramInfoCache});     // Catch: Throwable -> L7
        pw.printf("Union of AIDL ProgramFilters: %s\n", new Object[]{this.mUnionOfAidlProgramFilters});     // Catch: Throwable -> L7
        pw.printf("AIDL TunerSessions:\n", new Object[0]);     // Catch: Throwable -> L7
        pw.increaseIndent();     // Catch: Throwable -> L7
        Iterator<TunerSession> r2 = this.mAidlTunerSessions.iterator();     // Catch: Throwable -> L7
    L16:
        if (r2.hasNext() == false) goto L18;
        TunerSession aidlTunerSession = r2.next();     // Catch: Throwable -> L7
        aidlTunerSession.dumpInfo(pw);     // Catch: Throwable -> L7
        goto L16
    L18:
        pw.decreaseIndent();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        pw.printf("Radio module events:\n", new Object[0]);
        pw.increaseIndent();
        this.mEventLogger.dump(pw);
        pw.decreaseIndent();
        pw.decreaseIndent();
        return;
    L10:
        if (this.mAntennaConnected.booleanValue() == false) goto L12;
        String r3 = "Yes";
    L13:
        pw.printf("%s\n", new Object[]{r3});     // Catch: Throwable -> L7
        goto L14
    L12:
        r3 = "No";
    L7:
        th = move-exception;
        throw th;
    }
}
