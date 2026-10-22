package com.android.server.broadcastradio.aidl;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.hardware.broadcastradio.AmFmRegionConfig;
import android.hardware.broadcastradio.DabTableEntry;
import android.hardware.broadcastradio.IBroadcastRadio;
import android.hardware.broadcastradio.ITunerCallback;
import android.hardware.broadcastradio.ProgramInfo;
import android.hardware.broadcastradio.ProgramListChunk;
import android.hardware.broadcastradio.ProgramSelector;
import android.hardware.broadcastradio.VendorKeyValue;
import android.hardware.radio.IAnnouncementListener;
import android.hardware.radio.ICloseHandle;
import android.hardware.radio.ProgramList;
import android.hardware.radio.RadioManager;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.util.ArraySet;
import android.util.IndentingPrintWriter;
import com.android.server.broadcastradio.RadioEventLogger;
import com.android.server.broadcastradio.RadioServiceUserController;
import com.android.server.utils.Slogf;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
final class RadioModule {
    private static final int RADIO_EVENT_LOGGER_QUEUE_SIZE = 25;
    private static final String TAG = "BcRadioAidlSrv.module";
    private final ArraySet<TunerSession> mAidlTunerSessions;
    private Boolean mAntennaConnected;
    private RadioManager.ProgramInfo mCurrentProgramInfo;
    private final ITunerCallback mHalTunerCallback;
    private final Handler mHandler;
    private final Object mLock;
    private final RadioEventLogger mLogger;
    private final ProgramInfoCache mProgramInfoCache;
    private final RadioManager.ModuleProperties mProperties;
    private final IBroadcastRadio mService;
    private ProgramList.Filter mUnionOfAidlProgramFilters;
    private final RadioServiceUserController mUserController;

    /* JADX INFO: renamed from: com.android.server.broadcastradio.aidl.RadioModule$1, reason: invalid class name */
    class AnonymousClass1 extends ITunerCallback.Stub {
        final /* synthetic */ RadioModule this$0;

        public static /* synthetic */ void $r8$lambda$7RELtFJglwstbiUxxl3hPwqoA9A(AnonymousClass1 r0, ProgramSelector r1, int r2) {
            r0.lambda$onTuneFailed$1(r1, r2);
        }

        public static /* synthetic */ void $r8$lambda$9R5x20ubf0eCe9T_dVGeyPcbJUU(AnonymousClass1 r0, ProgramListChunk r1) {
            r0.lambda$onProgramListUpdated$4(r1);
        }

        public static /* synthetic */ void $r8$lambda$FzzqYaADpnVW8v1FniaiOpCZ_JY(Map r0, android.hardware.radio.ITunerCallback r1, int r2) {
            lambda$onParametersUpdated$9(r0, r1, r2);
        }

        public static /* synthetic */ void $r8$lambda$P3t5bJtLoHU0J7vcynoqBNb8_II(AnonymousClass1 r0, ProgramInfo r1) {
            r0.lambda$onCurrentProgramInfoChanged$3(r1);
        }

        public static /* synthetic */ void $r8$lambda$PaGTY88Axw1EUgxH8pDxxAKPeJc(int r0, boolean r1, android.hardware.radio.ITunerCallback r2, int r3) {
            lambda$onConfigFlagUpdated$7(r0, r1, r2, r3);
        }

        /* JADX INFO: renamed from: $r8$lambda$TKHvSQubi8edVDWyHr-wtooLDug, reason: not valid java name */
        public static /* synthetic */ void m2814$r8$lambda$TKHvSQubi8edVDWyHrwtooLDug(AnonymousClass1 r0, boolean r1) {
            r0.lambda$onAntennaStateChange$6(r1);
        }

        public static /* synthetic */ void $r8$lambda$Vk9s3hnpShoTw8QTOphQ7QJdqLw(AnonymousClass1 r0, VendorKeyValue[] r1) {
            r0.lambda$onParametersUpdated$10(r1);
        }

        public static /* synthetic */ void $r8$lambda$WVpmBb6zCHX_VPgxJaLHeop2bIY(RadioManager.ProgramInfo r0, android.hardware.radio.ITunerCallback r1, int r2) {
            lambda$onCurrentProgramInfoChanged$2(r0, r1, r2);
        }

        public static /* synthetic */ void $r8$lambda$feO4FmI9qq8_KMzXvebMwTsCqRQ(android.hardware.radio.ProgramSelector r0, int r1, android.hardware.radio.ITunerCallback r2, int r3) {
            lambda$onTuneFailed$0(r0, r1, r2, r3);
        }

        public static /* synthetic */ void $r8$lambda$oTrj5xdTipmZEqqaAsrzCPlQKg0(AnonymousClass1 r0, int r1, boolean r2) {
            r0.lambda$onConfigFlagUpdated$8(r1, r2);
        }

        public static /* synthetic */ void $r8$lambda$z68n5ssnxuMrnMKSv5iqzNSfjq8(boolean r0, android.hardware.radio.ITunerCallback r1, int r2) {
            lambda$onAntennaStateChange$5(r0, r1, r2);
        }

        AnonymousClass1(RadioModule this$0) {
            this.this$0 = this$0;
        }

        @Override // android.hardware.broadcastradio.ITunerCallback
        public int getInterfaceVersion() {
            return 3;
        }

        @Override // android.hardware.broadcastradio.ITunerCallback
        public String getInterfaceHash() {
            return "be432e9a5bdd211bdac48d6d03607fa71436f75c";
        }

        @Override // android.hardware.broadcastradio.ITunerCallback
        public void onTuneFailed(final int result, final ProgramSelector programSelector) {
            RadioModule.m2813$$Nest$mfireLater(this.this$0, new RadioModule$1$$ExternalSyntheticLambda5(this, programSelector, result));
        }

        private /* synthetic */ void lambda$onTuneFailed$1(ProgramSelector programSelector, int result) {
            final android.hardware.radio.ProgramSelector csel = ConversionUtils.programSelectorFromHalProgramSelector(programSelector);
            final int tunerResult = ConversionUtils.halResultToTunerResult(result);
            Object r2 = RadioModule.m2808$$Nest$fgetmLock(this.this$0);
            monitor-enter(r2);
            RadioModule.m2812$$Nest$mfanoutAidlCallbackLocked(this.this$0, new RadioModule$1$$ExternalSyntheticLambda8(csel, tunerResult));     // Catch: Throwable -> L7
            monitor-exit(r2);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        private static /* synthetic */ void lambda$onTuneFailed$0(android.hardware.radio.ProgramSelector csel, int tunerResult, android.hardware.radio.ITunerCallback cb, int uid) throws RemoteException {
            if (csel != null) goto L4;
        L7:
            cb.onTuneFailed(tunerResult, csel);
            return;
        L4:
            if (ConversionUtils.programSelectorMeetsSdkVersionRequirement(csel, uid) == true) goto L7;
            Slogf.e(RadioModule.TAG, "onTuneFailed: cannot send program selector requiring higher target SDK version");
        }

        @Override // android.hardware.broadcastradio.ITunerCallback
        public void onCurrentProgramInfoChanged(final ProgramInfo halProgramInfo) {
            RadioModule.m2813$$Nest$mfireLater(this.this$0, new RadioModule$1$$ExternalSyntheticLambda4(this, halProgramInfo));
        }

        private /* synthetic */ void lambda$onCurrentProgramInfoChanged$3(ProgramInfo halProgramInfo) {
            final RadioManager.ProgramInfo currentProgramInfo = ConversionUtils.tunedProgramInfoFromHalProgramInfo(halProgramInfo);
            currentProgramInfo.getClass();
            Object r1 = RadioModule.m2808$$Nest$fgetmLock(this.this$0);
            monitor-enter(r1);
            RadioModule.m2811$$Nest$fputmCurrentProgramInfo(this.this$0, currentProgramInfo);     // Catch: Throwable -> L7
            RadioModule.m2812$$Nest$mfanoutAidlCallbackLocked(this.this$0, new RadioModule$1$$ExternalSyntheticLambda1(currentProgramInfo));     // Catch: Throwable -> L7
            monitor-exit(r1);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        private static /* synthetic */ void lambda$onCurrentProgramInfoChanged$2(RadioManager.ProgramInfo currentProgramInfo, android.hardware.radio.ITunerCallback cb, int uid) throws RemoteException {
            if (ConversionUtils.programInfoMeetsSdkVersionRequirement(currentProgramInfo, uid) == true) goto L6;
            Slogf.e(RadioModule.TAG, "onCurrentProgramInfoChanged: cannot send program info requiring higher target SDK version");
            return;
        L6:
            cb.onCurrentProgramInfoChanged(currentProgramInfo);
        }

        @Override // android.hardware.broadcastradio.ITunerCallback
        public void onProgramListUpdated(final ProgramListChunk programListChunk) {
            RadioModule.m2813$$Nest$mfireLater(this.this$0, new RadioModule$1$$ExternalSyntheticLambda3(this, programListChunk));
        }

        private /* synthetic */ void lambda$onProgramListUpdated$4(ProgramListChunk programListChunk) {
            Object r0 = RadioModule.m2808$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
            RadioModule.m2809$$Nest$fgetmProgramInfoCache(this.this$0).filterAndApplyChunk(programListChunk);     // Catch: Throwable -> L8
            int i = 0;
        L6:
            if (i >= RadioModule.m2807$$Nest$fgetmAidlTunerSessions(this.this$0).size()) goto L11;
            ((TunerSession) RadioModule.m2807$$Nest$fgetmAidlTunerSessions(this.this$0).valueAt(i)).onMergedProgramListUpdateFromHal(programListChunk);     // Catch: Throwable -> L8
            i = i + 1;     // Catch: Throwable -> L8
            goto L6
        L11:
            monitor-exit(r0);     // Catch: Throwable -> L8
            return;
        L8:
            th = move-exception;
            throw th;
        }

        @Override // android.hardware.broadcastradio.ITunerCallback
        public void onAntennaStateChange(final boolean connected) {
            RadioModule.m2813$$Nest$mfireLater(this.this$0, new RadioModule$1$$ExternalSyntheticLambda9(this, connected));
        }

        private /* synthetic */ void lambda$onAntennaStateChange$6(final boolean connected) {
            Object r0 = RadioModule.m2808$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
            RadioModule.m2810$$Nest$fputmAntennaConnected(this.this$0, Boolean.valueOf(connected));     // Catch: Throwable -> L7
            RadioModule.m2812$$Nest$mfanoutAidlCallbackLocked(this.this$0, new RadioModule$1$$ExternalSyntheticLambda0(connected));     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        private static /* synthetic */ void lambda$onAntennaStateChange$5(boolean connected, android.hardware.radio.ITunerCallback cb, int uid) throws RemoteException {
            cb.onAntennaState(connected);
        }

        @Override // android.hardware.broadcastradio.ITunerCallback
        public void onConfigFlagUpdated(final int flag, final boolean value) {
            RadioModule.m2813$$Nest$mfireLater(this.this$0, new RadioModule$1$$ExternalSyntheticLambda10(this, flag, value));
        }

        private /* synthetic */ void lambda$onConfigFlagUpdated$8(final int flag, final boolean value) {
            Object r0 = RadioModule.m2808$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
            RadioModule.m2812$$Nest$mfanoutAidlCallbackLocked(this.this$0, new RadioModule$1$$ExternalSyntheticLambda2(flag, value));     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        private static /* synthetic */ void lambda$onConfigFlagUpdated$7(int flag, boolean value, android.hardware.radio.ITunerCallback cb, int uid) throws RemoteException {
            if (ConversionUtils.configFlagMeetsSdkVersionRequirement(flag, uid) == true) goto L6;
            Slogf.e(RadioModule.TAG, "onConfigFlagUpdated: cannot send program info requiring higher target SDK version");
            return;
        L6:
            cb.onConfigFlagUpdated(flag, value);
        }

        @Override // android.hardware.broadcastradio.ITunerCallback
        public void onParametersUpdated(final VendorKeyValue[] parameters) {
            RadioModule.m2813$$Nest$mfireLater(this.this$0, new RadioModule$1$$ExternalSyntheticLambda7(this, parameters));
        }

        private /* synthetic */ void lambda$onParametersUpdated$10(VendorKeyValue[] parameters) {
            Object r0 = RadioModule.m2808$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
            final Map<String, String> cparam = ConversionUtils.vendorInfoFromHalVendorKeyValues(parameters);     // Catch: Throwable -> L7
            RadioModule.m2812$$Nest$mfanoutAidlCallbackLocked(this.this$0, new RadioModule$1$$ExternalSyntheticLambda6(cparam));     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        private static /* synthetic */ void lambda$onParametersUpdated$9(Map cparam, android.hardware.radio.ITunerCallback cb, int uid) throws RemoteException {
            cb.onParametersUpdated(cparam);
        }
    }

    interface AidlCallbackRunnable {
        void run(android.hardware.radio.ITunerCallback r1, int r2) throws RemoteException;
    }

    public static /* synthetic */ void $r8$lambda$1VITZWIX_pnvwnRQ6IBjlCOvy4s(Runnable r0) {
        lambda$fireLater$0(r0);
    }

    /* JADX INFO: renamed from: $r8$lambda$EBwNGRV-8whiUGHsQ1QTsZmntw0, reason: not valid java name */
    public static /* synthetic */ void m2806$r8$lambda$EBwNGRV8whiUGHsQ1QTsZmntw0(RadioModule r0, AidlCallbackRunnable r1) {
        r0.lambda$fanoutAidlCallback$1(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmAidlTunerSessions, reason: not valid java name */
    static /* bridge */ /* synthetic */ ArraySet m2807$$Nest$fgetmAidlTunerSessions(RadioModule r0) {
        return r0.mAidlTunerSessions;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m2808$$Nest$fgetmLock(RadioModule r0) {
        return r0.mLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmProgramInfoCache, reason: not valid java name */
    static /* bridge */ /* synthetic */ ProgramInfoCache m2809$$Nest$fgetmProgramInfoCache(RadioModule r0) {
        return r0.mProgramInfoCache;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmAntennaConnected, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2810$$Nest$fputmAntennaConnected(RadioModule r0, Boolean r1) {
        r0.mAntennaConnected = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmCurrentProgramInfo, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2811$$Nest$fputmCurrentProgramInfo(RadioModule r0, RadioManager.ProgramInfo r1) {
        r0.mCurrentProgramInfo = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$mfanoutAidlCallbackLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2812$$Nest$mfanoutAidlCallbackLocked(RadioModule r0, AidlCallbackRunnable r1) {
        r0.fanoutAidlCallbackLocked(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mfireLater, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2813$$Nest$mfireLater(RadioModule r0, Runnable r1) {
        r0.fireLater(r1);
    }

    RadioModule(IBroadcastRadio service, RadioManager.ModuleProperties properties, RadioServiceUserController userController) {
        this.mLock = new Object();
        this.mProgramInfoCache = new ProgramInfoCache(null);
        this.mAidlTunerSessions = new ArraySet();
        this.mHalTunerCallback = new AnonymousClass1(this);
        properties.getClass();
        this.mProperties = properties;
        service.getClass();
        this.mService = service;
        this.mHandler = new Handler(Looper.getMainLooper());
        userController.getClass();
        this.mUserController = userController;
        this.mLogger = new RadioEventLogger(TAG, 25);
    }

    static RadioModule tryLoadingModule(int moduleId, String moduleName, IBinder serviceBinder, RadioServiceUserController userController) {
        Slogf.i(TAG, "Try loading module for module id = %d, module name = %s", new Object[]{Integer.valueOf(moduleId), moduleName});     // Catch: RemoteException -> L7
        IBroadcastRadio service = IBroadcastRadio.Stub.asInterface(serviceBinder);     // Catch: RemoteException -> L7
        if (service != null) goto L26;
        Slogf.w(TAG, "Module %s is null", new Object[]{moduleName});     // Catch: RemoteException -> L7
        return null;
    L26:
        AmFmRegionConfig amfmConfig = service.getAmFmRegionConfig(false);     // Catch: RemoteException -> L7 RuntimeException -> L12
    L24:
        DabTableEntry[] dabConfig = service.getDabRegionConfig();     // Catch: RemoteException -> L7 RuntimeException -> L17
    L19:
        RadioManager.ModuleProperties prop = ConversionUtils.propertiesFromHalProperties(moduleId, moduleName, service.getProperties(), amfmConfig, dabConfig);     // Catch: RemoteException -> L7
        return new RadioModule(service, prop, userController);
    L18:
        Slogf.i(TAG, "Module %s does not has DAB config", new Object[]{moduleName});     // Catch: RemoteException -> L7
        dabConfig = null;
        goto L19
    L13:
        Slogf.i(TAG, "Module %s does not has AMFM config", new Object[]{moduleName});     // Catch: RemoteException -> L7
        amfmConfig = null;
    L7:
        ex = move-exception;
        Slogf.e(TAG, ex, "Failed to load module %s", new Object[]{moduleName});
        return null;
    }

    IBroadcastRadio getService() {
        return this.mService;
    }

    RadioManager.ModuleProperties getProperties() {
        return this.mProperties;
    }

    TunerSession openSession(android.hardware.radio.ITunerCallback userCb) throws RemoteException {
        this.mLogger.logRadioEvent("Open TunerSession", new Object[0]);
        Object r0 = this.mLock;
        monitor-enter(r0);
        boolean isFirstTunerSession = this.mAidlTunerSessions.isEmpty();     // Catch: Throwable -> L8
        TunerSession tunerSession = new TunerSession(this, this.mService, userCb, this.mUserController);     // Catch: Throwable -> L8
        this.mAidlTunerSessions.add(tunerSession);     // Catch: Throwable -> L8
        Boolean antennaConnected = this.mAntennaConnected;     // Catch: Throwable -> L8
        RadioManager.ProgramInfo currentProgramInfo = this.mCurrentProgramInfo;     // Catch: Throwable -> L8
        if (isFirstTunerSession == true) goto L23;
    L15:
        monitor-exit(r0);     // Catch: Throwable -> L8
        if (antennaConnected == null) goto L18;
        userCb.onAntennaState(antennaConnected.booleanValue());
    L18:
        if (currentProgramInfo == null) goto L20;
        userCb.onCurrentProgramInfoChanged(currentProgramInfo);
    L20:
        return tunerSession;
    L23:
        this.mService.setTunerCallback(this.mHalTunerCallback);     // Catch: Throwable -> L8 RemoteException -> L10
    L10:
        ex = move-exception;
        Slogf.wtf(TAG, ex, "Failed to register HAL callback for module %d", new Object[]{Integer.valueOf(this.mProperties.getId())});     // Catch: Throwable -> L8
        return null;
    L8:
        th = move-exception;
        throw th;
    }

    void closeSessions(int error) {
        this.mLogger.logRadioEvent("Close TunerSessions %d", new Object[]{Integer.valueOf(error)});
        Object r0 = this.mLock;
        monitor-enter(r0);
        TunerSession[] tunerSessions = new TunerSession[this.mAidlTunerSessions.size()];     // Catch: Throwable -> L15
        this.mAidlTunerSessions.toArray(tunerSessions);     // Catch: Throwable -> L15
        monitor-exit(r0);     // Catch: Throwable -> L15
        int r1 = tunerSessions.length;
        int r2 = 0;
    L7:
        if (r2 >= r1) goto L14;
        TunerSession tunerSession = tunerSessions[r2];
        tunerSession.close(Integer.valueOf(error));     // Catch: Exception -> L11
    L13:
        r2 = r2 + 1;
    L11:
        e = move-exception;
        Slogf.e(TAG, "Failed to close TunerSession %s: %s", new Object[]{tunerSession, e});
        goto L13
    L14:
        return;
    L15:
        th = move-exception;
        throw th;
    }

    private ProgramList.Filter buildUnionOfTunerSessionFiltersLocked() {
        Set<Integer> idTypes = null;
        Set<android.hardware.radio.ProgramSelector.Identifier> ids = null;
        boolean excludeModifications = false;
        boolean excludeModifications2 = true;
        int i = 0;
    L4:
        if (i >= this.mAidlTunerSessions.size()) goto L25;
        ProgramList.Filter filter = this.mAidlTunerSessions.valueAt(i).getProgramListFilter();
        if (filter == null) goto L23;
        if (idTypes != null) goto L11;
        Set<Integer> idTypes2 = new ArraySet(filter.getIdentifierTypes());
        Set<android.hardware.radio.ProgramSelector.Identifier> ids2 = new ArraySet(filter.getIdentifiers());
        boolean includeCategories = filter.areCategoriesIncluded();
        boolean excludeModifications3 = filter.areModificationsExcluded();
        excludeModifications2 = excludeModifications3;
        excludeModifications = includeCategories;
        ids = ids2;
        idTypes = idTypes2;
        goto L23
    L11:
        if (idTypes.isEmpty() == true) goto L17;
        if (filter.getIdentifierTypes().isEmpty() == false) goto L15;
        idTypes.clear();
        goto L17
    L15:
        idTypes.addAll(filter.getIdentifierTypes());
    L17:
        if (ids.isEmpty() == false) goto L19;
    L22:
        excludeModifications = excludeModifications | filter.areCategoriesIncluded();
        excludeModifications2 = excludeModifications2 & filter.areModificationsExcluded();
        goto L23
    L19:
        if (filter.getIdentifiers().isEmpty() == false) goto L21;
        ids.clear();
        goto L22
    L21:
        ids.addAll(filter.getIdentifiers());
    L23:
        i = i + 1;
        goto L4
    L25:
        if (idTypes != null) goto L28;
        return null;
    L28:
        return new ProgramList.Filter(idTypes, ids, excludeModifications, excludeModifications2);
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
        if (newFilter == null) goto L5;
        Object r2 = this.mLock;
        monitor-enter(r2);
    L19:
        th = move-exception;
        throw th;
    L16:
        if (newFilter.equals(this.mUnionOfAidlProgramFilters) == false) goto L23;
        if (session == null) goto L21;
        session.updateProgramInfoFromHalCache(this.mProgramInfoCache);     // Catch: Throwable -> L19
    L21:
        monitor-exit(r2);     // Catch: Throwable -> L19
        return;
    L23:
        this.mUnionOfAidlProgramFilters = newFilter;     // Catch: Throwable -> L19
        monitor-exit(r2);     // Catch: Throwable -> L19
        this.mService.startProgramListUpdates(ConversionUtils.filterToHalProgramFilter(newFilter));     // Catch: RemoteException -> L27 RuntimeException -> L29
    L43:
        return;
    L27:
        ex = move-exception;
        Slogf.e(TAG, ex, "mHalTunerSession.startProgramListUpdates() failed", new Object[0]);
        return;
    L29:
        ex = move-exception;
        throw ConversionUtils.throwOnError(ex, "Start Program ListUpdates");
    L5:
        if (this.mUnionOfAidlProgramFilters != null) goto L7;
        return;
    L7:
        this.mUnionOfAidlProgramFilters = null;
        this.mService.stopProgramListUpdates();     // Catch: RemoteException -> L10
        return;
    L10:
        ex = move-exception;
        Slogf.e(TAG, ex, "mHalTunerSession.stopProgramListUpdates() failed", new Object[0]);
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
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        TunerSession tunerSession = tunerSessions[r1];
        this.mAidlTunerSessions.remove(tunerSession);
        r1 = r1 + 1;
        goto L3
    L5:
        onTunerSessionProgramListFilterChanged(null);
        if (this.mAidlTunerSessions.isEmpty() == false) goto L15;
        this.mService.unsetTunerCallback();     // Catch: RemoteException -> L9
        return;
    L9:
        ex = move-exception;
        Slogf.wtf(TAG, ex, "Failed to unregister HAL callback for module %d", new Object[]{Integer.valueOf(this.mProperties.getId())});
        return;
    }

    private void fireLater(final Runnable r) {
        this.mHandler.post(new RadioModule$$ExternalSyntheticLambda1(r));
    }

    private static /* synthetic */ void lambda$fireLater$0(Runnable r) {
        r.run();
    }

    void fanoutAidlCallback(final AidlCallbackRunnable runnable) {
        fireLater(new RadioModule$$ExternalSyntheticLambda0(this, runnable));
    }

    private /* synthetic */ void lambda$fanoutAidlCallback$1(AidlCallbackRunnable runnable) {
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
        int i = 0;
    L4:
        if (i >= this.mAidlTunerSessions.size()) goto L24;
        if (this.mAidlTunerSessions.valueAt(i).mUserId != currentUserId) goto L8;
    L27:
        runnable.run(this.mAidlTunerSessions.valueAt(i).mCallback, this.mAidlTunerSessions.valueAt(i).getUid());     // Catch: RemoteException -> L12 DeadObjectException -> L14
    L22:
        i = i + 1;
    L12:
        ex = move-exception;
        Slogf.e(TAG, ex, "Failed to invoke ITunerCallback", new Object[0]);
    L17:
        Slogf.e(TAG, "Removing dead TunerSession");
        if (deadSessions != null) goto L20;
        deadSessions = new ArrayList();
    L20:
        deadSessions.add(this.mAidlTunerSessions.valueAt(i));
        goto L22
    L8:
        if (this.mAidlTunerSessions.valueAt(i).mUserId == 0) goto L27;
    L24:
        if (deadSessions == null) goto L34;
        onTunerSessionsClosedLocked((TunerSession[]) deadSessions.toArray(new TunerSession[deadSessions.size()]));
        return;
    }

    ICloseHandle addAnnouncementListener(final IAnnouncementListener listener, int[] enabledTypes) throws RemoteException {
        this.mLogger.logRadioEvent("Add AnnouncementListener", new Object[0]);
        byte[] enabledList = new byte[enabledTypes.length];
        int index = 0;
    L4:
        if (index >= enabledList.length) goto L6;
        enabledList[index] = (byte) enabledTypes[index];
        index = index + 1;
        goto L4
    L6:
        final android.hardware.broadcastradio.ICloseHandle[] hwCloseHandle = {null};
        android.hardware.broadcastradio.IAnnouncementListener hwListener = new AnonymousClass2(this, listener);
        hwCloseHandle[0] = this.mService.registerAnnouncementListener(hwListener, enabledList);     // Catch: RuntimeException -> L10
        return new AnonymousClass3(this, hwCloseHandle);
    L10:
        ex = move-exception;
        throw ConversionUtils.throwOnError(ex, "AnnouncementListener");
    }

    Bitmap getImage(int id) {
        this.mLogger.logRadioEvent("Get image for id = %d", new Object[]{Integer.valueOf(id)});
        if (id == 0) goto L17;
        byte[] rawImage = this.mService.getImage(id);     // Catch: RemoteException -> L13
        if (rawImage != null) goto L7;
        return null;
    L7:
        if (rawImage.length != 0) goto L10;
        return null;
    L10:
        return BitmapFactory.decodeByteArray(rawImage, 0, rawImage.length);
    L13:
        ex = move-exception;
        throw ex.rethrowFromSystemServer();
    L17:
        throw new IllegalArgumentException("Image ID is missing");
    }

    void dumpInfo(IndentingPrintWriter pw) {
        pw.printf("RadioModule\n", new Object[0]);
        pw.increaseIndent();
        Object r0 = this.mLock;
        monitor-enter(r0);
        pw.printf("BroadcastRadioServiceImpl: %s\n", new Object[]{this.mService});     // Catch: Throwable -> L7
        pw.printf("Properties: %s\n", new Object[]{this.mProperties});     // Catch: Throwable -> L7
        pw.printf("Antenna state: ", new Object[0]);     // Catch: Throwable -> L7
        if (this.mAntennaConnected != null) goto L10;
        pw.printf("undetermined\n", new Object[0]);     // Catch: Throwable -> L7
    L14:
        pw.printf("current ProgramInfo: %s\n", new Object[]{this.mCurrentProgramInfo});     // Catch: Throwable -> L7
        pw.printf("ProgramInfoCache: %s\n", new Object[]{this.mProgramInfoCache});     // Catch: Throwable -> L7
        pw.printf("Union of AIDL ProgramFilters: %s\n", new Object[]{this.mUnionOfAidlProgramFilters});     // Catch: Throwable -> L7
        pw.printf("AIDL TunerSessions [%d]:\n", new Object[]{Integer.valueOf(this.mAidlTunerSessions.size())});     // Catch: Throwable -> L7
        pw.increaseIndent();     // Catch: Throwable -> L7
        int i = 0;
    L16:
        if (i >= this.mAidlTunerSessions.size()) goto L18;
        this.mAidlTunerSessions.valueAt(i).dumpInfo(pw);     // Catch: Throwable -> L7
        i = i + 1;     // Catch: Throwable -> L7
        goto L16
    L18:
        pw.decreaseIndent();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        pw.printf("Radio module events:\n", new Object[0]);
        pw.increaseIndent();
        this.mLogger.dump(pw);
        pw.decreaseIndent();
        pw.decreaseIndent();
        return;
    L10:
        if (this.mAntennaConnected.booleanValue() == false) goto L12;
        String r3 = "connected";
    L13:
        pw.printf("%s\n", new Object[]{r3});     // Catch: Throwable -> L7
        goto L14
    L12:
        r3 = "not connected";
    L7:
        th = move-exception;
        throw th;
    }
}
