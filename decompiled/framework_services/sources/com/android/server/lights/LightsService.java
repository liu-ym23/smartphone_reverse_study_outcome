package com.android.server.lights;

import android.app.ActivityManager;
import android.content.Context;
import android.hardware.audio.common.V2_0.AudioFormat;
import android.hardware.light.HwLight;
import android.hardware.light.HwLightState;
import android.hardware.light.ILights;
import android.hardware.lights.ILightsManager;
import android.hardware.lights.Light;
import android.hardware.lights.LightState;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.PermissionEnforcer;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.Trace;
import android.provider.Settings;
import android.util.Slog;
import android.util.SparseArray;
import com.android.internal.display.BrightnessSynchronizer;
import com.android.internal.util.DumpUtils;
import com.android.internal.util.Preconditions;
import com.android.server.SystemService;
import com.android.server.am.SysMonitorSvcBridge;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes2.dex */
public class LightsService extends SystemService {
    static final boolean DEBUG = false;
    static final String TAG = "LightsService";
    private Handler mH;
    private final SparseArray<LightImpl> mLightsById;
    private final LightImpl[] mLightsByType;
    final LightsManagerBinderService mManagerService;
    private final LightsManager mService;
    private final Supplier<ILights> mVintfLights;

    private final class LightImpl extends LogicalLight {
        private int mBrightnessMode;
        private int mColor;
        private boolean mFlashing;
        private HwLight mHwLight;
        private boolean mInitialized;
        private int mLastBrightnessMode;
        private int mLastColor;
        private int mMode;
        private int mOffMS;
        private int mOnMS;
        private boolean mUseLowPersistenceForVR;
        private boolean mVrModeEnabled;
        final /* synthetic */ LightsService this$0;

        public static /* synthetic */ void $r8$lambda$Z3uqkXxEDZLexB4LNlzNFDxneWo(LightImpl r0) {
            r0.stopFlashing();
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmHwLight, reason: not valid java name */
        static /* bridge */ /* synthetic */ HwLight m5102$$Nest$fgetmHwLight(LightImpl r0) {
            return r0.mHwLight;
        }

        /* JADX INFO: renamed from: -$$Nest$mgetColor, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m5103$$Nest$mgetColor(LightImpl r0) {
            return r0.getColor();
        }

        /* JADX INFO: renamed from: -$$Nest$misSystemLight, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m5104$$Nest$misSystemLight(LightImpl r0) {
            return r0.isSystemLight();
        }

        /* synthetic */ LightImpl(LightsService r1, Context r2, HwLight r3, LightsServiceIA r4) {
            this(r1, r2, r3);
        }

        private LightImpl(LightsService r1, Context context, HwLight hwLight) {
            this.this$0 = r1;
            this.mHwLight = hwLight;
        }

        @Override // com.android.server.lights.LogicalLight
        public void setBrightness(float brightness) {
            setBrightness(brightness, 0);
        }

        @Override // com.android.server.lights.LogicalLight
        public void setBrightness(float brightness, int brightnessMode) {
            if (Float.isNaN(brightness) == false) goto L6;
            Slog.w(LightsService.TAG, "Brightness is not valid: " + brightness);
            return;
        L6:
            monitor-enter(this);
            if (brightnessMode == 2) goto L28;
            int brightnessInt = BrightnessSynchronizer.brightnessFloatToInt(brightness);     // Catch: Throwable -> L21
            int color = brightnessInt & 255;
            setLightLocked((((color << 16) | AudioFormat.MAIN_MASK) | (color << 8)) | color, 0, 0, 0, brightnessMode);     // Catch: Throwable -> L19
            monitor-exit(this);     // Catch: Throwable -> L19
            return;
        L21:
            th = th;
        L23:
            monitor-exit(this);     // Catch: Throwable -> L19
            throw th;
        L28:
            Slog.w(LightsService.TAG, "setBrightness with LOW_PERSISTENCE unexpected #" + this.mHwLight.id + ": brightness=" + brightness);     // Catch: Throwable -> L12
            monitor-exit(this);     // Catch: Throwable -> L12
            return;
        L12:
            th = th;
        L19:
            th = th;
            goto L23
        }

        @Override // com.android.server.lights.LogicalLight
        public void setColor(int color) {
            monitor-enter(this);
            setLightLocked(color, 0, 0, 0, 0);     // Catch: Throwable -> L7
            monitor-exit(this);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.android.server.lights.LogicalLight
        public void setFlashing(int color, int mode, int onMS, int offMS) {
            monitor-enter(this);
            setLightLocked(color, mode, onMS, offMS, 0);     // Catch: Throwable -> L7
            monitor-exit(this);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.android.server.lights.LogicalLight
        public void pulse() {
            pulse(AudioFormat.SUB_MASK, 7);
        }

        @Override // com.android.server.lights.LogicalLight
        public void pulse(int color, int onMS) {
            monitor-enter(this);
        L9:
            th = move-exception;
            Throwable r8 = th;
        L16:
            monitor-exit(this);     // Catch: Throwable -> L9
            throw r8;
        L12:
            th = move-exception;
            r8 = th;
            goto L16
        L4:
            if (this.mColor != 0) goto L14;
            if (this.mFlashing == true) goto L14;
            setLightLocked(color, 2, onMS, 1000, 0);     // Catch: Throwable -> L9
            this.mColor = 0;     // Catch: Throwable -> L9
            LightsService.m5097$$Nest$fgetmH(this.this$0).postDelayed(new LightsService$LightImpl$$ExternalSyntheticLambda0(this), onMS);     // Catch: Throwable -> L9
        L14:
            monitor-exit(this);     // Catch: Throwable -> L9
        }

        @Override // com.android.server.lights.LogicalLight
        public void turnOff() {
            monitor-enter(this);
            setLightLocked(0, 0, 0, 0, 0);     // Catch: Throwable -> L7
            monitor-exit(this);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.android.server.lights.LogicalLight
        public void setVrMode(boolean enabled) {
            monitor-enter(this);
        L12:
            th = move-exception;
            throw th;
        L4:
            if (this.mVrModeEnabled == enabled) goto L14;
            this.mVrModeEnabled = enabled;     // Catch: Throwable -> L12
            if (LightsService.m5101$$Nest$mgetVrDisplayMode(this.this$0) != 0) goto L8;
            boolean r0 = true;
        L9:
            this.mUseLowPersistenceForVR = r0;     // Catch: Throwable -> L12
            if (shouldBeInLowPersistenceMode() == false) goto L14;
            this.mLastBrightnessMode = this.mBrightnessMode;     // Catch: Throwable -> L12
            goto L14
        L8:
            r0 = false;
        L14:
            monitor-exit(this);     // Catch: Throwable -> L12
        }

        private void stopFlashing() {
            monitor-enter(this);
            setLightLocked(this.mColor, 0, 0, 0, 0);     // Catch: Throwable -> L8
            monitor-exit(this);     // Catch: Throwable -> L8
            return;
        L8:
            th = th;
        L12:
            monitor-exit(this);     // Catch: Throwable -> L8
            throw th;
        L10:
            th = th;
            goto L12
        }

        private void setLightLocked(int color, int mode, int onMS, int offMS, int brightnessMode) {
            if (shouldBeInLowPersistenceMode() == false) goto L6;
            int brightnessMode2 = 2;
        L10:
            if (this.mInitialized == true) goto L12;
        L23:
            this.mInitialized = true;
            this.mLastColor = this.mColor;
            this.mColor = color;
            this.mMode = mode;
            this.mOnMS = onMS;
            this.mOffMS = offMS;
            this.mBrightnessMode = brightnessMode2;
            LightImpl r0 = this;
            r0.setLightUnchecked(color, mode, onMS, offMS, brightnessMode2);
        L24:
            SysMonitorSvcBridge.getFactory().getSmartPowerDataInstance().setLightsState(r0.mHwLight.id, r0.mColor);
            return;
        L12:
            if (color != this.mColor) goto L23;
            if (mode != this.mMode) goto L23;
            if (onMS != this.mOnMS) goto L23;
            if (offMS != this.mOffMS) goto L23;
            if (this.mBrightnessMode != brightnessMode2) goto L23;
            r0 = this;
            goto L24
        L6:
            if (brightnessMode != 2) goto L8;
            brightnessMode2 = this.mLastBrightnessMode;
            goto L10
        L8:
            brightnessMode2 = brightnessMode;
            goto L10
        }

        private void setLightUnchecked(int color, int mode, int onMS, int offMS, int brightnessMode) {
            Trace.traceBegin(131072, "setLightState(" + this.mHwLight.id + ", 0x" + Integer.toHexString(color) + ")");
        L22:
            ex = e;
        L25:
            Slog.e(LightsService.TAG, "Failed issuing setLightState", ex);     // Catch: Throwable -> L16
        L15:
            Trace.traceEnd(131072);
            SysMonitorSvcBridge.getFactory().getSmartPowerDataInstance().setLightsState(this.mHwLight.id, this.mColor);
            return;
        L16:
            th = th;
        L29:
            Trace.traceEnd(131072);
            throw th;
        L20:
            th = th;
            goto L29
        L4:
            if (LightsService.m5100$$Nest$fgetmVintfLights(this.this$0) != null) goto L36;
        L33:
            LightsService.setLight_native(this.mHwLight.id, color, mode, onMS, offMS, brightnessMode);     // Catch: Throwable -> L16 Throwable -> L18
        L18:
            ex = e;
            goto L25
        L36:
            HwLightState lightState = new HwLightState();     // Catch: Throwable -> L7 Throwable -> L9
            lightState.color = color;     // Catch: Throwable -> L7 Throwable -> L9
            lightState.flashMode = (byte) mode;     // Catch: Throwable -> L7 Throwable -> L9
            lightState.flashOnMs = onMS;     // Catch: Throwable -> L7 Throwable -> L9
            lightState.flashOffMs = offMS;     // Catch: Throwable -> L7 Throwable -> L9
            lightState.brightnessMode = (byte) brightnessMode;     // Catch: Throwable -> L7 Throwable -> L9
            ((ILights) LightsService.m5100$$Nest$fgetmVintfLights(this.this$0).get()).setLightState(this.mHwLight.id, lightState);     // Catch: Throwable -> L7 Throwable -> L9
        L9:
            ex = e;
        L7:
            th = th;
            goto L29
        }

        private boolean shouldBeInLowPersistenceMode() {
            if (this.mVrModeEnabled == true) goto L5;
        L7:
            return false;
        L5:
            if (this.mUseLowPersistenceForVR == false) goto L7;
            return true;
        }

        private boolean isSystemLight() {
            if (this.mHwLight.type >= 0) goto L5;
        L7:
            return false;
        L5:
            if (this.mHwLight.type >= 8) goto L7;
            return true;
        }

        private int getColor() {
            return this.mColor;
        }
    }

    private final class LightsManagerBinderService extends ILightsManager.Stub {
        private final List<Session> mSessions;
        final /* synthetic */ LightsService this$0;

        private final class Session implements Comparable<Session> {
            final int mPriority;
            final SparseArray<LightState> mRequests;
            final IBinder mToken;

            @Override // java.lang.Comparable
            public /* bridge */ /* synthetic */ int compareTo(Session r1) {
                return compareTo2(r1);
            }

            Session(LightsManagerBinderService r1, IBinder token, int priority) {
                this.mRequests = new SparseArray();
                this.mToken = token;
                this.mPriority = priority;
            }

            void setRequest(int lightId, LightState state) {
                if (state == null) goto L4;
                this.mRequests.put(lightId, state);
                return;
            L4:
                this.mRequests.remove(lightId);
            }

            /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
            public int compareTo2(Session otherSession) {
                return Integer.compare(otherSession.mPriority, this.mPriority);
            }
        }

        public static /* synthetic */ void $r8$lambda$OXwpx5GdH6qMgzX_zjr7AI6j3Cs(LightsManagerBinderService r0, IBinder r1) {
            r0.lambda$openSession$0(r1);
        }

        LightsManagerBinderService(LightsService r1) {
            this.this$0 = r1;
            super(PermissionEnforcer.fromContext(r1.getContext()));
            this.mSessions = new ArrayList();
        }

        public List<Light> getLights() {
            getLights_enforcePermission();
            LightsService r0 = this.this$0;
            monitor-enter(r0);
            List<Light> lights = new ArrayList();     // Catch: Throwable -> L10
            int i = 0;
        L6:
            if (i >= LightsService.m5098$$Nest$fgetmLightsById(this.this$0).size()) goto L14;
            if (LightImpl.m5104$$Nest$misSystemLight((LightImpl) LightsService.m5098$$Nest$fgetmLightsById(this.this$0).valueAt(i)) == true) goto L12;
            HwLight hwLight = LightImpl.m5102$$Nest$fgetmHwLight((LightImpl) LightsService.m5098$$Nest$fgetmLightsById(this.this$0).valueAt(i));     // Catch: Throwable -> L10
            lights.add(new Light(hwLight.id, hwLight.ordinal, hwLight.type));     // Catch: Throwable -> L10
        L12:
            i = i + 1;     // Catch: Throwable -> L10
            goto L6
        L14:
            monitor-exit(r0);     // Catch: Throwable -> L10
            return lights;
        L10:
            th = move-exception;
            throw th;
        }

        public void setLightStates(IBinder token, int[] lightIds, LightState[] lightStates) {
            setLightStates_enforcePermission();
            boolean r2 = false;
            if (lightIds.length != lightStates.length) goto L5;
            boolean r0 = true;
        L6:
            Preconditions.checkState(r0);
            LightsService r1 = this.this$0;
            monitor-enter(r1);
            Session session = getSessionLocked((IBinder) Preconditions.checkNotNull(token));     // Catch: Throwable -> L15
            if (session == null) goto L11;
            r2 = true;
        L11:
            Preconditions.checkState(r2, "not registered");     // Catch: Throwable -> L15
            checkRequestIsValid(lightIds);     // Catch: Throwable -> L15
            int i = 0;
        L13:
            if (i >= lightIds.length) goto L17;
            session.setRequest(lightIds[i], lightStates[i]);     // Catch: Throwable -> L15
            i = i + 1;     // Catch: Throwable -> L15
            goto L13
        L17:
            invalidateLightStatesLocked();     // Catch: Throwable -> L15
            monitor-exit(r1);     // Catch: Throwable -> L15
            return;
        L15:
            th = move-exception;
            throw th;
        L5:
            r0 = false;
            goto L6
        }

        public LightState getLightState(int lightId) {
            getLightState_enforcePermission();
            LightsService r0 = this.this$0;
            monitor-enter(r0);
            LightImpl light = (LightImpl) LightsService.m5098$$Nest$fgetmLightsById(this.this$0).get(lightId);     // Catch: Throwable -> L11
            if (light == null) goto L14;
            if (LightImpl.m5104$$Nest$misSystemLight(light) == true) goto L14;
            LightState r2 = new LightState(LightImpl.m5103$$Nest$mgetColor(light));     // Catch: Throwable -> L11
            monitor-exit(r0);     // Catch: Throwable -> L11
            return r2;
        L14:
            throw new IllegalArgumentException("Invalid light: " + lightId);     // Catch: Throwable -> L11
        L11:
            th = move-exception;
            throw th;
        }

        public void openSession(final IBinder token, int priority) {
            openSession_enforcePermission();
            Preconditions.checkNotNull(token);
            LightsService r0 = this.this$0;
            monitor-enter(r0);
        L12:
            th = move-exception;
            throw th;
        L5:
            if (getSessionLocked(token) != null) goto L7;
            boolean r1 = true;
        L8:
            Preconditions.checkState(r1, "already registered");     // Catch: Throwable -> L12
            token.linkToDeath(new LightsService$LightsManagerBinderService$$ExternalSyntheticLambda0(this, token), 0);     // Catch: Throwable -> L12 RemoteException -> L14
            this.mSessions.add(new Session(this, token, priority));     // Catch: Throwable -> L12 RemoteException -> L14
            Collections.sort(this.mSessions);     // Catch: Throwable -> L12 RemoteException -> L14
            monitor-exit(r0);     // Catch: Throwable -> L12
            return;
        L14:
            e = move-exception;
            Slog.e(LightsService.TAG, "Couldn't open session, client already died", e);     // Catch: Throwable -> L12
            throw new IllegalArgumentException("Client is already dead.");     // Catch: Throwable -> L12
        L7:
            r1 = false;
            goto L8
        }

        private /* synthetic */ void lambda$openSession$0(IBinder token) {
            closeSessionInternal(token);
        }

        public void closeSession(IBinder token) {
            closeSession_enforcePermission();
            Preconditions.checkNotNull(token);
            closeSessionInternal(token);
        }

        protected void dump(FileDescriptor fd, PrintWriter pw, String[] args) {
            if (DumpUtils.checkDumpPermission(this.this$0.getContext(), LightsService.TAG, pw) == true) goto L5;
            return;
        L5:
            LightsService r0 = this.this$0;
            monitor-enter(r0);
        L10:
            th = move-exception;
            throw th;
        L8:
            if (LightsService.m5100$$Nest$fgetmVintfLights(this.this$0) == null) goto L12;
            pw.println("Service: aidl (" + LightsService.m5100$$Nest$fgetmVintfLights(this.this$0).get() + ")");     // Catch: Throwable -> L10
        L13:
            pw.println("Lights:");     // Catch: Throwable -> L10
            int i = 0;
        L15:
            if (i >= LightsService.m5098$$Nest$fgetmLightsById(this.this$0).size()) goto L17;
            LightImpl light = (LightImpl) LightsService.m5098$$Nest$fgetmLightsById(this.this$0).valueAt(i);     // Catch: Throwable -> L10
            pw.println(String.format("  Light id=%d ordinal=%d color=%08x", new Object[]{Integer.valueOf(LightImpl.m5102$$Nest$fgetmHwLight(light).id), Integer.valueOf(LightImpl.m5102$$Nest$fgetmHwLight(light).ordinal), Integer.valueOf(LightImpl.m5103$$Nest$mgetColor(light))}));     // Catch: Throwable -> L10
            i = i + 1;     // Catch: Throwable -> L10
            goto L15
        L17:
            pw.println("Session clients:");     // Catch: Throwable -> L10
            Iterator<Session> r1 = this.mSessions.iterator();     // Catch: Throwable -> L10
        L19:
            if (r1.hasNext() == false) goto L25;
            Session session = r1.next();     // Catch: Throwable -> L10
            pw.println("  Session token=" + session.mToken);     // Catch: Throwable -> L10
            int i2 = 0;
        L22:
            if (i2 >= session.mRequests.size()) goto L19;
            pw.println(String.format("    Request id=%d color=%08x", new Object[]{Integer.valueOf(session.mRequests.keyAt(i2)), Integer.valueOf(session.mRequests.valueAt(i2).getColor())}));     // Catch: Throwable -> L10
            i2 = i2 + 1;     // Catch: Throwable -> L10
            goto L22
        L25:
            monitor-exit(r0);     // Catch: Throwable -> L10
            return;
        L12:
            pw.println("Service: hidl");     // Catch: Throwable -> L10
            goto L13
        }

        private void closeSessionInternal(IBinder token) {
            LightsService r0 = this.this$0;
            monitor-enter(r0);
            Session session = getSessionLocked(token);     // Catch: Throwable -> L7
            if (session == null) goto L9;
            this.mSessions.remove(session);     // Catch: Throwable -> L7
            invalidateLightStatesLocked();     // Catch: Throwable -> L7
        L9:
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        private void checkRequestIsValid(int[] lightIds) {
            int r0 = lightIds.length;
            int r2 = 0;
        L3:
            if (r2 >= r0) goto L11;
            int lightId = lightIds[r2];
            LightImpl light = (LightImpl) LightsService.m5098$$Nest$fgetmLightsById(this.this$0).get(lightId);
            if (light != null) goto L7;
        L9:
            boolean r5 = false;
        L10:
            Preconditions.checkState(r5, "Invalid lightId " + lightId);
            r2 = r2 + 1;
            goto L3
        L7:
            if (LightImpl.m5104$$Nest$misSystemLight(light) == true) goto L9;
            r5 = true;
            goto L10
        }

        private void invalidateLightStatesLocked() {
            Map<Integer, LightState> states = new HashMap();
            int i = this.mSessions.size() - 1;
        L3:
            if (i < 0) goto L9;
            SparseArray<LightState> requests = this.mSessions.get(i).mRequests;
            int j = 0;
        L6:
            if (j >= requests.size()) goto L8;
            states.put(Integer.valueOf(requests.keyAt(j)), requests.valueAt(j));
            j = j + 1;
            goto L6
        L8:
            i = i - 1;
            goto L3
        L9:
            int i2 = 0;
        L11:
            if (i2 >= LightsService.m5098$$Nest$fgetmLightsById(this.this$0).size()) goto L20;
            LightImpl light = (LightImpl) LightsService.m5098$$Nest$fgetmLightsById(this.this$0).valueAt(i2);
            if (LightImpl.m5104$$Nest$misSystemLight(light) == true) goto L18;
            LightState state = states.get(Integer.valueOf(LightImpl.m5102$$Nest$fgetmHwLight(light).id));
            if (state == null) goto L17;
            light.setColor(state.getColor());
            goto L18
        L17:
            light.turnOff();
        L18:
            i2 = i2 + 1;
            goto L11
        }

        private Session getSessionLocked(IBinder token) {
            int i = 0;
        L4:
            if (i >= this.mSessions.size()) goto L10;
            if (token.equals(this.mSessions.get(i).mToken) == true) goto L8;
            i = i + 1;
            goto L4
        L8:
            return this.mSessions.get(i);
        L10:
            return null;
        }
    }

    private static class VintfHalCache implements Supplier<ILights>, IBinder.DeathRecipient {
        private ILights mInstance;

        /* synthetic */ VintfHalCache(LightsServiceIA r1) {
            this();
        }

        private VintfHalCache() {
            this.mInstance = null;
        }

        @Override // java.util.function.Supplier
        public /* bridge */ /* synthetic */ ILights get() {
            return get();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.function.Supplier
        public synchronized ILights get() {
            monitor-enter(this);
        L11:
            th = move-exception;
            throw th;
        L4:
            if (this.mInstance != null) goto L15;
            IBinder binder = Binder.allowBlocking(ServiceManager.waitForDeclaredService(ILights.DESCRIPTOR + "/default"));     // Catch: Throwable -> L11
            if (binder == null) goto L15;
            this.mInstance = ILights.Stub.asInterface(binder);     // Catch: Throwable -> L11
            binder.linkToDeath(this, 0);     // Catch: Throwable -> L11 RemoteException -> L13
        L14:
            Slog.e(LightsService.TAG, "Unable to register DeathRecipient for " + this.mInstance);     // Catch: Throwable -> L11
        L15:
            ILights r0 = this.mInstance;     // Catch: Throwable -> L11
            monitor-exit(this);
            return r0;
        }

        @Override // android.os.IBinder.DeathRecipient
        public synchronized void binderDied() {
            monitor-enter(this);
            this.mInstance = null;     // Catch: Throwable -> L7
            monitor-exit(this);
            return;
        L7:
            th = move-exception;
            throw th;
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmH, reason: not valid java name */
    static /* bridge */ /* synthetic */ Handler m5097$$Nest$fgetmH(LightsService r0) {
        return r0.mH;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLightsById, reason: not valid java name */
    static /* bridge */ /* synthetic */ SparseArray m5098$$Nest$fgetmLightsById(LightsService r0) {
        return r0.mLightsById;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLightsByType, reason: not valid java name */
    static /* bridge */ /* synthetic */ LightImpl[] m5099$$Nest$fgetmLightsByType(LightsService r0) {
        return r0.mLightsByType;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmVintfLights, reason: not valid java name */
    static /* bridge */ /* synthetic */ Supplier m5100$$Nest$fgetmVintfLights(LightsService r0) {
        return r0.mVintfLights;
    }

    /* JADX INFO: renamed from: -$$Nest$mgetVrDisplayMode, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m5101$$Nest$mgetVrDisplayMode(LightsService r0) {
        return r0.getVrDisplayMode();
    }

    static native void setLight_native(int r0, int r1, int r2, int r3, int r4, int r5);

    public LightsService(Context context) {
        this(context, new VintfHalCache(null), Looper.myLooper());
    }

    LightsService(Context context, Supplier<ILights> service, Looper looper) {
        super(context);
        this.mLightsByType = new LightImpl[8];
        this.mLightsById = new SparseArray();
        this.mService = new AnonymousClass1(this);
        this.mH = new Handler(looper);
        if (service.get() == null) goto L5;
        Supplier<ILights> r0 = service;
    L6:
        this.mVintfLights = r0;
        populateAvailableLights(context);
        this.mManagerService = new LightsManagerBinderService(this);
        return;
    L5:
        r0 = null;
        goto L6
    }

    private void populateAvailableLights(Context context) {
        if (this.mVintfLights == null) goto L5;
        populateAvailableLightsFromAidl(context);
    L6:
        int i = this.mLightsById.size() - 1;
    L7:
        if (i < 0) goto L15;
        LightImpl light = this.mLightsById.valueAt(i);
        int type = LightImpl.m5102$$Nest$fgetmHwLight(light).type;
        if (type < 0) goto L13;
        if (type >= this.mLightsByType.length) goto L13;
        this.mLightsByType[type] = light;
    L13:
        i = i - 1;
        goto L7
    L15:
        return;
    L5:
        populateAvailableLightsFromHidl(context);
        goto L6
    }

    private void populateAvailableLightsFromAidl(Context context) {
        HwLight[] r0 = this.mVintfLights.get().getLights();     // Catch: RemoteException -> L6
        int r1 = r0.length;     // Catch: RemoteException -> L6
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L14;
        HwLight hwLight = r0[r2];     // Catch: RemoteException -> L6
        this.mLightsById.put(hwLight.id, new LightImpl(this, context, hwLight, null));     // Catch: RemoteException -> L6
        r2 = r2 + 1;
        goto L3
    L14:
        return;
    L6:
        ex = move-exception;
        Slog.e(TAG, "Unable to get lights from HAL", ex);
    }

    private void populateAvailableLightsFromHidl(Context context) {
        int i = 0;
    L4:
        if (i >= this.mLightsByType.length) goto L7;
        HwLight hwLight = new HwLight();
        hwLight.id = (byte) i;
        hwLight.ordinal = 1;
        hwLight.type = (byte) i;
        this.mLightsById.put(hwLight.id, new LightImpl(this, context, hwLight, null));
        i = i + 1;
        goto L4
    }

    @Override // com.android.server.SystemService
    public void onStart() {
        publishLocalService(LightsManager.class, this.mService);
        publishBinderService("lights", this.mManagerService);
    }

    @Override // com.android.server.SystemService
    public void onBootPhase(int phase) {
    }

    private int getVrDisplayMode() {
        int currentUser = ActivityManager.getCurrentUser();
        return Settings.Secure.getIntForUser(getContext().getContentResolver(), "vr_display_mode", 0, currentUser);
    }
}
