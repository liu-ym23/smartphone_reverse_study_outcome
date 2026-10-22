package com.android.server.wm;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.ArrayMap;
import android.util.IntArray;
import android.util.Pair;
import android.util.Size;
import android.util.SparseArray;
import android.view.InputWindowHandle;
import android.window.ITrustedPresentationListener;
import android.window.TrustedPresentationThresholds;
import android.window.WindowInfosListener;
import com.android.internal.protolog.ProtoLogImpl_798997914;
import com.android.internal.protolog.WmProtoLogGroups;
import com.android.server.wm.utils.RegionUtils;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Optional;

/* JADX INFO: loaded from: classes3.dex */
public class TrustedPresentationListenerController {
    private Handler mHandler;
    private HandlerThread mHandlerThread;
    private final Object mHandlerThreadLock;
    private Pair<InputWindowHandle[], WindowInfosListener.DisplayInfo[]> mLastWindowHandles;
    Listeners mRegisteredListeners;
    private WindowInfosListener mWindowInfosListener;

    /* JADX INFO: renamed from: com.android.server.wm.TrustedPresentationListenerController$1, reason: invalid class name */
    class AnonymousClass1 extends WindowInfosListener {
        final /* synthetic */ TrustedPresentationListenerController this$0;

        /* JADX INFO: renamed from: $r8$lambda$9nARJT0bg00DduzIhSIQVBF-zts, reason: not valid java name */
        public static /* synthetic */ void m10363$r8$lambda$9nARJT0bg00DduzIhSIQVBFzts(AnonymousClass1 r0, InputWindowHandle[] r1, WindowInfosListener.DisplayInfo[] r2) {
            r0.lambda$onWindowInfosChanged$0(r1, r2);
        }

        AnonymousClass1(TrustedPresentationListenerController this$0) {
            this.this$0 = this$0;
        }

        private /* synthetic */ void lambda$onWindowInfosChanged$0(InputWindowHandle[] windowHandles, WindowInfosListener.DisplayInfo[] displayInfos) {
            TrustedPresentationListenerController.m10362$$Nest$mcomputeTpl(this.this$0, new Pair(windowHandles, displayInfos));
        }

        public void onWindowInfosChanged(final InputWindowHandle[] windowHandles, final WindowInfosListener.DisplayInfo[] displayInfos) {
            TrustedPresentationListenerController.m10361$$Nest$fgetmHandler(this.this$0).post(new TrustedPresentationListenerController$1$$ExternalSyntheticLambda0(this, windowHandles, displayInfos));
        }
    }

    private class Listeners {
        ArrayMap<IBinder, ListenerDeathRecipient> mUniqueListeners;
        ArrayMap<IBinder, ArrayList<TrustedPresentationInfo>> mWindowToListeners;
        final /* synthetic */ TrustedPresentationListenerController this$0;

        private final class ListenerDeathRecipient implements IBinder.DeathRecipient {
            int mInstances;
            IBinder mListenerBinder;
            final /* synthetic */ Listeners this$1;

            /* JADX INFO: renamed from: $r8$lambda$AgCHtHro5VOLyJdFaA21DDkT8-I, reason: not valid java name */
            public static /* synthetic */ void m10367$r8$lambda$AgCHtHro5VOLyJdFaA21DDkT8I(ListenerDeathRecipient r0) {
                r0.lambda$binderDied$0();
            }

            ListenerDeathRecipient(Listeners r2, IBinder listenerBinder) {
                this.this$1 = r2;
                this.mListenerBinder = listenerBinder;
                this.mInstances = 0;
                this.mListenerBinder.linkToDeath(this, 0);     // Catch: RemoteException -> L5
                return;
            }

            void addInstance() {
                this.mInstances++;
            }

            boolean removeInstance() {
                this.mInstances--;
                if (this.mInstances <= 0) goto L5;
                return false;
            L5:
                this.mListenerBinder.unlinkToDeath(this, 0);
                return true;
            }

            @Override // android.os.IBinder.DeathRecipient
            public void binderDied() {
                TrustedPresentationListenerController.m10361$$Nest$fgetmHandler(this.this$1.this$0).post(new TrustedPresentationListenerController$Listeners$ListenerDeathRecipient$$ExternalSyntheticLambda0(this));
            }

            private /* synthetic */ void lambda$binderDied$0() {
                this.this$1.mUniqueListeners.remove(this.mListenerBinder);
                Listeners.m10366$$Nest$mremoveListeners(this.this$1, this.mListenerBinder, Optional.empty());
            }
        }

        /* JADX INFO: renamed from: $r8$lambda$7tbqYYaR-2rHaNj46Xl6w5AjKrQ, reason: not valid java name */
        public static /* synthetic */ ListenerDeathRecipient m10364$r8$lambda$7tbqYYaR2rHaNj46Xl6w5AjKrQ(Listeners r0, IBinder r1) {
            return r0.lambda$register$1(r1);
        }

        /* JADX INFO: renamed from: $r8$lambda$om3LfNFW5-owznqNVHwRRJkAbXc, reason: not valid java name */
        public static /* synthetic */ ArrayList m10365$r8$lambda$om3LfNFW5owznqNVHwRRJkAbXc(IBinder r0) {
            return lambda$register$0(r0);
        }

        /* JADX INFO: renamed from: -$$Nest$mremoveListeners, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m10366$$Nest$mremoveListeners(Listeners r0, IBinder r1, Optional r2) {
            r0.removeListeners(r1, r2);
        }

        /* synthetic */ Listeners(TrustedPresentationListenerController r1, TrustedPresentationListenerControllerIA r2) {
            this(r1);
        }

        private Listeners(TrustedPresentationListenerController r1) {
            this.this$0 = r1;
            this.mUniqueListeners = new ArrayMap();
            this.mWindowToListeners = new ArrayMap();
        }

        void register(IBinder window, ITrustedPresentationListener listener, TrustedPresentationThresholds thresholds, int id) {
            ArrayList<TrustedPresentationInfo> listenersForWindow = this.mWindowToListeners.computeIfAbsent(window, new TrustedPresentationListenerController$Listeners$$ExternalSyntheticLambda0());
            listenersForWindow.add(new TrustedPresentationInfo(thresholds, id, listener, null));
            IBinder listenerBinder = listener.asBinder();
            ListenerDeathRecipient deathRecipient = this.mUniqueListeners.computeIfAbsent(listenerBinder, new TrustedPresentationListenerController$Listeners$$ExternalSyntheticLambda1(this));
            deathRecipient.addInstance();
        }

        private static /* synthetic */ ArrayList lambda$register$0(IBinder iBinder) {
            return new ArrayList();
        }

        private /* synthetic */ ListenerDeathRecipient lambda$register$1(IBinder x$0) {
            return new ListenerDeathRecipient(this, x$0);
        }

        void unregister(ITrustedPresentationListener trustedPresentationListener, int id) {
            IBinder listenerBinder = trustedPresentationListener.asBinder();
            ListenerDeathRecipient deathRecipient = this.mUniqueListeners.get(listenerBinder);
            if (deathRecipient != null) goto L9;
            if (ProtoLogImpl_798997914.Cache.WM_DEBUG_TPL_enabled[4] == false) goto L13;
            String protoLogParam0 = String.valueOf(trustedPresentationListener);
            long protoLogParam1 = id;
            ProtoLogImpl_798997914.e(WmProtoLogGroups.WM_DEBUG_TPL, 3445530300764535903L, 4, new Object[]{protoLogParam0, Long.valueOf(protoLogParam1)});
            return;
        L13:
            return;
        L9:
            if (deathRecipient.removeInstance() == false) goto L11;
            this.mUniqueListeners.remove(listenerBinder);
        L11:
            removeListeners(listenerBinder, Optional.of(Integer.valueOf(id)));
        }

        boolean isEmpty() {
            return this.mWindowToListeners.isEmpty();
        }

        ArrayList<TrustedPresentationInfo> get(IBinder windowToken) {
            return this.mWindowToListeners.get(windowToken);
        }

        private void removeListeners(IBinder listenerBinder, Optional<Integer> id) {
            int i = this.mWindowToListeners.size() - 1;
        L3:
            if (i < 0) goto L19;
            ArrayList<TrustedPresentationInfo> listeners = this.mWindowToListeners.valueAt(i);
            int j = listeners.size() - 1;
        L5:
            if (j < 0) goto L15;
            TrustedPresentationInfo listener = listeners.get(j);
            if (listener.mListener.asBinder() != listenerBinder) goto L13;
            if (id.isEmpty() == false) goto L11;
        L12:
            listeners.remove(j);
            goto L13
        L11:
            if (listener.mId == id.get().intValue()) goto L12;
        L13:
            j = j - 1;
            goto L5
        L15:
            if (listeners.isEmpty() == false) goto L17;
            this.mWindowToListeners.removeAt(i);
        L17:
            i = i - 1;
            goto L3
        }
    }

    private static class TrustedPresentationInfo {
        long mEnteredTrustedPresentationStateTime;
        final int mId;
        boolean mLastComputedTrustedPresentationState;
        boolean mLastReportedTrustedPresentationState;
        final ITrustedPresentationListener mListener;
        final TrustedPresentationThresholds mThresholds;

        /* synthetic */ TrustedPresentationInfo(TrustedPresentationThresholds r1, int r2, ITrustedPresentationListener r3, TrustedPresentationListenerControllerIA r4) {
            this(r1, r2, r3);
        }

        private TrustedPresentationInfo(TrustedPresentationThresholds thresholds, int id, ITrustedPresentationListener listener) {
            this.mLastComputedTrustedPresentationState = false;
            this.mLastReportedTrustedPresentationState = false;
            this.mEnteredTrustedPresentationStateTime = -1;
            this.mThresholds = thresholds;
            this.mId = id;
            this.mListener = listener;
        }
    }

    public static /* synthetic */ void $r8$lambda$3ELYbuMk2vwGwjmkKe4Qm4BtcDg(float[] r0, Rect r1) {
        lambda$computeFractionRendered$3(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$Ps1sZOZ5gxyiF9hXAxVJv1jdPGY(TrustedPresentationListenerController r0, ITrustedPresentationListener r1, int r2) {
        r0.lambda$unregisterListener$1(r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$a20wCSIXWRHSUVxhdL2bS0npIMA(TrustedPresentationListenerController r0) {
        r0.lambda$checkIfInThreshold$2();
    }

    public static /* synthetic */ void $r8$lambda$wQvFMVTI3xuRVODQ9Y9ejpVjqzg(TrustedPresentationListenerController r0, ITrustedPresentationListener r1, int r2, IBinder r3, TrustedPresentationThresholds r4) {
        r0.lambda$registerListener$0(r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmHandler, reason: not valid java name */
    static /* bridge */ /* synthetic */ Handler m10361$$Nest$fgetmHandler(TrustedPresentationListenerController r0) {
        return r0.mHandler;
    }

    /* JADX INFO: renamed from: -$$Nest$mcomputeTpl, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m10362$$Nest$mcomputeTpl(TrustedPresentationListenerController r0, Pair r1) {
        r0.computeTpl(r1);
    }

    public TrustedPresentationListenerController() {
        this.mHandlerThreadLock = new Object();
        this.mRegisteredListeners = new Listeners(this, null);
    }

    private void startHandlerThreadIfNeeded() {
        Object r0 = this.mHandlerThreadLock;
        monitor-enter(r0);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.mHandler != null) goto L9;
        this.mHandlerThread = new HandlerThread("WindowInfosListenerForTpl");     // Catch: Throwable -> L7
        this.mHandlerThread.start();     // Catch: Throwable -> L7
        this.mHandler = new Handler(this.mHandlerThread.getLooper());     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
    }

    void registerListener(final IBinder window, final ITrustedPresentationListener listener, final TrustedPresentationThresholds thresholds, final int id) {
        startHandlerThreadIfNeeded();
        this.mHandler.post(new TrustedPresentationListenerController$$ExternalSyntheticLambda1(this, listener, id, window, thresholds));
    }

    private /* synthetic */ void lambda$registerListener$0(ITrustedPresentationListener listener, int id, IBinder window, TrustedPresentationThresholds thresholds) {
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_TPL_enabled[0] == false) goto L5;
        String protoLogParam0 = String.valueOf(listener);
        long protoLogParam1 = id;
        String protoLogParam2 = String.valueOf(window);
        String protoLogParam3 = String.valueOf(thresholds);
        ProtoLogImpl_798997914.d(WmProtoLogGroups.WM_DEBUG_TPL, -6140852484700685564L, 4, new Object[]{protoLogParam0, Long.valueOf(protoLogParam1), protoLogParam2, protoLogParam3});
    L5:
        this.mRegisteredListeners.register(window, listener, thresholds, id);
        registerWindowInfosListener();
        computeTpl(this.mLastWindowHandles);
    }

    void unregisterListener(final ITrustedPresentationListener listener, final int id) {
        startHandlerThreadIfNeeded();
        this.mHandler.post(new TrustedPresentationListenerController$$ExternalSyntheticLambda3(this, listener, id));
    }

    private /* synthetic */ void lambda$unregisterListener$1(ITrustedPresentationListener listener, int id) {
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_TPL_enabled[0] == false) goto L5;
        String protoLogParam0 = String.valueOf(listener);
        long protoLogParam1 = id;
        ProtoLogImpl_798997914.d(WmProtoLogGroups.WM_DEBUG_TPL, 3691097873058247482L, 4, new Object[]{protoLogParam0, Long.valueOf(protoLogParam1)});
    L5:
        this.mRegisteredListeners.unregister(listener, id);
        if (this.mRegisteredListeners.isEmpty() == false) goto L9;
        unregisterWindowInfosListener();
        return;
    }

    void dump(PrintWriter pw) {
        pw.println("TrustedPresentationListenerController:");
        pw.println("  Active unique listeners (" + this.mRegisteredListeners.mUniqueListeners.size() + "):");
        int i = 0;
    L4:
        if (i >= this.mRegisteredListeners.mWindowToListeners.size()) goto L11;
        pw.println("    window=" + this.mRegisteredListeners.mWindowToListeners.keyAt(i));
        ArrayList<TrustedPresentationInfo> listeners = this.mRegisteredListeners.mWindowToListeners.valueAt(i);
        int j = 0;
    L7:
        if (j >= listeners.size()) goto L9;
        TrustedPresentationInfo listener = listeners.get(j);
        pw.println("      listener=" + listener.mListener.asBinder() + " id=" + listener.mId + " thresholds=" + listener.mThresholds);
        j = j + 1;
        goto L7
    L9:
        i = i + 1;
        goto L4
    }

    private void registerWindowInfosListener() {
        if (this.mWindowInfosListener == null) goto L5;
        return;
    L5:
        this.mWindowInfosListener = new AnonymousClass1(this);
        this.mLastWindowHandles = this.mWindowInfosListener.register();
    }

    private void unregisterWindowInfosListener() {
        if (this.mWindowInfosListener != null) goto L5;
        return;
    L5:
        this.mWindowInfosListener.unregister();
        this.mWindowInfosListener = null;
        this.mLastWindowHandles = null;
    }

    private void computeTpl(Pair<InputWindowHandle[], WindowInfosListener.DisplayInfo[]> windowHandles) {
        TrustedPresentationListenerController r1 = this;
        r1.mLastWindowHandles = windowHandles;
        if (r1.mLastWindowHandles != null) goto L5;
        return;
    L5:
        if (((InputWindowHandle[]) r1.mLastWindowHandles.first).length != 0) goto L7;
        return;
    L7:
        if (r1.mRegisteredListeners.isEmpty() == true) goto L71;
        Rect tmpRect = new Rect();
        RectF tmpRectF = new RectF();
        Rect tmpLogicalDisplaySize = new Rect();
        Matrix tmpInverseMatrix = new Matrix();
        float[] tmpMatrix = new float[9];
        SparseArray<Region> coveredRegionsAboveByDisplay = new SparseArray();
        long currTimeMs = System.currentTimeMillis();
        char r7 = 1;
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_TPL_enabled[1] == false) goto L12;
        long protoLogParam0 = ((InputWindowHandle[]) r1.mLastWindowHandles.first).length;
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_TPL, 6408851516381868623L, 1, new Object[]{Long.valueOf(protoLogParam0)});
    L12:
        ArrayMap<ITrustedPresentationListener, Pair<IntArray, IntArray>> listenerUpdates = new ArrayMap();
        InputWindowHandle[] r0 = (InputWindowHandle[]) r1.mLastWindowHandles.first;
        int r2 = r0.length;
        int r4 = 0;
    L13:
        if (r4 >= r2) goto L45;
        InputWindowHandle windowHandle = r0[r4];
        char r18 = r7;
        if ((windowHandle.inputConfig & 2) != 2) goto L17;
        char r6 = r18;
    L18:
        char r19 = r6;
        if (windowHandle.canOccludePresentation == false) goto L43;
        if (r19 == 0) goto L22;
        InputWindowHandle[] r21 = r0;
        int r23 = r2;
        int r24 = r4;
        long currTimeMs2 = currTimeMs;
        ArrayMap<ITrustedPresentationListener, Pair<IntArray, IntArray>> listenerUpdates2 = listenerUpdates;
    L44:
        r4 = r24 + 1;
        r1 = this;
        listenerUpdates = listenerUpdates2;
        r7 = r18;
        r0 = r21;
        r2 = r23;
        currTimeMs = currTimeMs2;
        goto L13
    L22:
        tmpRectF.set(windowHandle.frame);
        WindowInfosListener.DisplayInfo[] r8 = (WindowInfosListener.DisplayInfo[]) r1.mLastWindowHandles.second;
        int r3 = r8.length;
        r21 = r0;
        int r5 = 0;
    L23:
        if (r5 >= r3) goto L28;
        int r22 = r5;
        WindowInfosListener.DisplayInfo displayHandle = r8[r22];
        r23 = r2;
        int r25 = r3;
        if (displayHandle.mDisplayId == windowHandle.displayId) goto L26;
        r5 = r22 + 1;
        r2 = r23;
        r3 = r25;
        goto L23
    L26:
        displayHandle.mTransform.mapRect(tmpRectF);
        tmpRectF.round(tmpRect);
        tmpLogicalDisplaySize.set(0, 0, displayHandle.mLogicalSize.getWidth(), displayHandle.mLogicalSize.getHeight());
        tmpRect.intersect(tmpLogicalDisplaySize);
        int displayId = displayHandle.mDisplayId;
        int displayId2 = displayId;
    L30:
        if (displayId2 == (-1)) goto L32;
        r24 = r4;
        Region coveredRegionsAbove = coveredRegionsAboveByDisplay.get(displayId2, new Region());
        ArrayList<TrustedPresentationInfo> listeners = r1.mRegisteredListeners.get(windowHandle.getWindowToken());
        if (listeners == null) goto L38;
        Region region = new Region();
        region.op(tmpRect, coveredRegionsAbove, Region.Op.DIFFERENCE);
        windowHandle.transform.invert(tmpInverseMatrix);
        tmpInverseMatrix.getValues(tmpMatrix);
        float scaleX = (float) Math.sqrt((tmpMatrix[0] * tmpMatrix[0]) + (tmpMatrix[r18] * tmpMatrix[r18]));
        float scaleY = (float) Math.sqrt((tmpMatrix[4] * tmpMatrix[4]) + (tmpMatrix[3] * tmpMatrix[3]));
        InputWindowHandle windowHandle2 = windowHandle;
        float fractionRendered = computeFractionRendered(region, new RectF(tmpRect), windowHandle.contentSize, scaleX, scaleY);
        float scaleX2 = windowHandle2.alpha;
        long currTimeMs3 = currTimeMs;
        listenerUpdates2 = listenerUpdates;
        ArrayList<TrustedPresentationInfo> listeners2 = listeners;
        checkIfInThreshold(listeners2, listenerUpdates2, fractionRendered, scaleX2, currTimeMs3);
    L39:
        coveredRegionsAbove.op(tmpRect, Region.Op.UNION);
        coveredRegionsAboveByDisplay.put(displayId2, coveredRegionsAbove);
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_TPL_enabled[r18] == false) goto L42;
        String protoLogParam1 = String.valueOf(windowHandle2.name);
        String protoLogParam2 = String.valueOf(tmpRect.toShortString());
        String protoLogParam3 = String.valueOf(coveredRegionsAbove);
        currTimeMs2 = currTimeMs3;
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_TPL, -1135667737459933313L, 0, new Object[]{protoLogParam1, protoLogParam2, protoLogParam3});
        goto L44
    L42:
        currTimeMs2 = currTimeMs3;
        goto L44
    L38:
        currTimeMs3 = currTimeMs;
        windowHandle2 = windowHandle;
        listenerUpdates2 = listenerUpdates;
        listeners2 = listeners;
        goto L39
    L32:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_TPL_enabled[r18] == false) goto L34;
        String protoLogParam4 = String.valueOf(windowHandle.name);
        long protoLogParam5 = windowHandle.displayId;
        r24 = r4;
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_TPL, -368354168540676819L, 4, new Object[]{protoLogParam4, Long.valueOf(protoLogParam5)});
        currTimeMs2 = currTimeMs;
        listenerUpdates2 = listenerUpdates;
        goto L44
    L34:
        r24 = r4;
        currTimeMs2 = currTimeMs;
        listenerUpdates2 = listenerUpdates;
        goto L44
    L28:
        r23 = r2;
        displayId2 = -1;
        goto L30
    L43:
        r21 = r0;
        r23 = r2;
        r24 = r4;
        currTimeMs2 = currTimeMs;
        listenerUpdates2 = listenerUpdates;
        goto L44
    L17:
        r6 = 0;
        goto L18
    L45:
        ArrayMap<ITrustedPresentationListener, Pair<IntArray, IntArray>> listenerUpdates3 = listenerUpdates;
        int i = 0;
    L47:
        if (i >= listenerUpdates3.size()) goto L54;
        Pair<IntArray, IntArray> updates = listenerUpdates3.valueAt(i);
        ITrustedPresentationListener listener = listenerUpdates3.keyAt(i);
        listener.onTrustedPresentationChanged(((IntArray) updates.first).toArray(), ((IntArray) updates.second).toArray());     // Catch: RemoteException -> L51
    L52:
        i = i + 1;
        goto L47
    L54:
        return;
    }

    private void addListenerUpdate(ArrayMap<ITrustedPresentationListener, Pair<IntArray, IntArray>> listenerUpdates, ITrustedPresentationListener listener, int id, boolean presentationState) {
        Pair<IntArray, IntArray> updates = listenerUpdates.get(listener);
        if (updates != null) goto L5;
        updates = new Pair(new IntArray(), new IntArray());
        listenerUpdates.put(listener, updates);
    L5:
        if (presentationState == false) goto L7;
        ((IntArray) updates.first).add(id);
        return;
    L7:
        ((IntArray) updates.second).add(id);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v3 */
    /* JADX WARN: Type inference failed for: r11v4, types: [boolean] */
    /* JADX WARN: Type inference failed for: r11v8 */
    /* JADX WARN: Type inference failed for: r16v2 */
    /* JADX WARN: Type inference failed for: r16v3 */
    /* JADX WARN: Type inference failed for: r28v0, types: [com.android.server.wm.TrustedPresentationListenerController] */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v11, types: [boolean] */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r7v0 */
    private void checkIfInThreshold(ArrayList<TrustedPresentationInfo> listeners, ArrayMap<ITrustedPresentationListener, Pair<IntArray, IntArray>> listenerUpdates, float fractionRendered, float alpha, long currTimeMs) {
        float r2 = fractionRendered;
        float r3 = alpha;
        ?? r7 = 1;
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_TPL_enabled[1] == false) goto L6;
        double protoLogParam0 = r2;
        double protoLogParam1 = r3;
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_TPL, 854487339271667012L, 26, new Object[]{Double.valueOf(protoLogParam0), Double.valueOf(protoLogParam1), Long.valueOf(currTimeMs)});
    L6:
        int i = 0;
    L8:
        if (i >= listeners.size()) goto L43;
        TrustedPresentationInfo trustedPresentationInfo = listeners.get(i);
        ITrustedPresentationListener listener = trustedPresentationInfo.mListener;
        boolean lastState = trustedPresentationInfo.mLastComputedTrustedPresentationState;
        if (r3 >= trustedPresentationInfo.mThresholds.getMinAlpha()) goto L12;
    L14:
        ?? r11 = 0;
    L15:
        trustedPresentationInfo.mLastComputedTrustedPresentationState = r11;
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_TPL_enabled[r7] == false) goto L20;
        String protoLogParam2 = String.valueOf(lastState);
        String protoLogParam3 = String.valueOf(r11);
        double protoLogParam4 = r3;
        double protoLogParam5 = trustedPresentationInfo.mThresholds.getMinAlpha();
        double protoLogParam6 = r2;
        double protoLogParam7 = trustedPresentationInfo.mThresholds.getMinFractionRendered();
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_TPL, -2248576188205088843L, 2720, new Object[]{protoLogParam2, protoLogParam3, Double.valueOf(protoLogParam4), Double.valueOf(protoLogParam5), Double.valueOf(protoLogParam6), Double.valueOf(protoLogParam7)});
    L20:
        if (lastState == 0) goto L28;
        if (r11 != 0) goto L28;
        if (trustedPresentationInfo.mLastReportedTrustedPresentationState == false) goto L27;
        trustedPresentationInfo.mLastReportedTrustedPresentationState = false;
        addListenerUpdate(listenerUpdates, listener, trustedPresentationInfo.mId, false);
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_TPL_enabled[0] == false) goto L27;
        String protoLogParam8 = String.valueOf(listener);
        long protoLogParam9 = trustedPresentationInfo.mId;
        ProtoLogImpl_798997914.d(WmProtoLogGroups.WM_DEBUG_TPL, 6236170793308011579L, 4, new Object[]{protoLogParam8, Long.valueOf(protoLogParam9)});
    L27:
        trustedPresentationInfo.mEnteredTrustedPresentationStateTime = -1;
    L32:
        if (trustedPresentationInfo.mLastReportedTrustedPresentationState == true) goto L40;
        if (r11 == 0) goto L40;
        if ((currTimeMs - trustedPresentationInfo.mEnteredTrustedPresentationStateTime) <= trustedPresentationInfo.mThresholds.getStabilityRequirementMillis()) goto L39;
        ?? r4 = r7;
        trustedPresentationInfo.mLastReportedTrustedPresentationState = r4;
        addListenerUpdate(listenerUpdates, listener, trustedPresentationInfo.mId, r4);
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_TPL_enabled[0] == false) goto L41;
        String protoLogParam10 = String.valueOf(listener);
        long protoLogParam11 = trustedPresentationInfo.mId;
        ProtoLogImpl_798997914.d(WmProtoLogGroups.WM_DEBUG_TPL, 5405816744363636527L, 4, new Object[]{protoLogParam10, Long.valueOf(protoLogParam11)});
    L41:
        i = i + 1;
        r2 = fractionRendered;
        r7 = r4;
        r3 = alpha;
        goto L8
    L39:
        r4 = r7;
    L40:
        r4 = r7;
    L28:
        if (lastState == true) goto L32;
        if (r11 == 0) goto L32;
        trustedPresentationInfo.mEnteredTrustedPresentationStateTime = currTimeMs;
        this.mHandler.postDelayed(new TrustedPresentationListenerController$$ExternalSyntheticLambda0(this), (long) (((double) trustedPresentationInfo.mThresholds.getStabilityRequirementMillis()) * 1.5d));
        goto L32
    L12:
        if (r2 < trustedPresentationInfo.mThresholds.getMinFractionRendered()) goto L14;
        r11 = r7;
        goto L15
    }

    private /* synthetic */ void lambda$checkIfInThreshold$2() {
        computeTpl(this.mLastWindowHandles);
    }

    private float computeFractionRendered(Region visibleRegion, RectF screenBounds, Size contentSize, float sx, float sy) {
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_TPL_enabled[1] == false) goto L6;
        String protoLogParam0 = String.valueOf(visibleRegion);
        String protoLogParam1 = String.valueOf(screenBounds);
        String protoLogParam2 = String.valueOf(contentSize);
        double protoLogParam3 = sx;
        double protoLogParam4 = sy;
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_TPL, -5162728346383863020L, 640, new Object[]{protoLogParam0, protoLogParam1, protoLogParam2, Double.valueOf(protoLogParam3), Double.valueOf(protoLogParam4)});
    L6:
        if (contentSize.getWidth() == 0) goto L26;
        if (contentSize.getHeight() == 0) goto L26;
        if (screenBounds.width() == 0.0f) goto L24;
        if (screenBounds.height() == 0.0f) goto L24;
        float fractionRendered = Math.min(sx * sy, 1.0f);
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_TPL_enabled[1] == false) goto L18;
        double protoLogParam5 = fractionRendered;
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_TPL, 898769258643799441L, 2, new Object[]{Double.valueOf(protoLogParam5)});
    L18:
        float boundsOverSourceW = screenBounds.width() / contentSize.getWidth();
        float boundsOverSourceH = screenBounds.height() / contentSize.getHeight();
        float fractionRendered2 = fractionRendered * (boundsOverSourceW * boundsOverSourceH);
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_TPL_enabled[1] == false) goto L21;
        double protoLogParam6 = fractionRendered2;
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_TPL, -455501334697331596L, 2, new Object[]{Double.valueOf(protoLogParam6)});
    L21:
        final float[] visibleSize = new float[1];
        RegionUtils.forEachRect(visibleRegion, new TrustedPresentationListenerController$$ExternalSyntheticLambda2(visibleSize));
        return fractionRendered2 * (visibleSize[0] / (screenBounds.width() * screenBounds.height()));
    L24:
        return -1.0f;
    L26:
        return -1.0f;
    }

    private static /* synthetic */ void lambda$computeFractionRendered$3(float[] visibleSize, Rect rect) {
        float size = rect.width() * rect.height();
        visibleSize[0] = visibleSize[0] + size;
    }
}
