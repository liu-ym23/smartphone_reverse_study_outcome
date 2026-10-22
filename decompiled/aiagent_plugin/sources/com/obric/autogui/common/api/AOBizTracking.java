package com.obric.autogui.common.api;

import android.content.Context;
import com.obric.aiagent.product.ObricProductSdk;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.platform.AOPlatform;
import com.obric.autogui.common.api.platform.AOPlatformTools;
import com.obric.autogui.common.api.platform.tracking.IAutoActionTrackingApi;
import com.obric.autogui.common.api.platform.tracking.TrackingReportTarget;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.o;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: AOBizTracking.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class AOBizTracking implements IAutoActionTrackingApi {
    public static final AOBizTracking INSTANCE = null;
    private static final String TAG = "AOBizTracking";
    private static final LinkedList<Event> mPendingEvents = null;

    /* JADX INFO: compiled from: AOBizTracking.kt */
    private static final class Event {
        private final String event;
        private final boolean eventAppendObricPrefix;
        private final JSONObject keyValue;
        private final boolean paramAppendObricPrefix;
        private final TrackingReportTarget target;

        public static /* synthetic */ Event copy$default(Event r3, String r4, JSONObject r5, boolean r6, boolean r7, TrackingReportTarget r8, int r9, Object r10) {
            if ((r9 & 1) == 0) goto L6;
            r4 = r3.event;
        L6:
            if ((r9 & 2) == 0) goto L8;
            r5 = r3.keyValue;
        L8:
            JSONObject r11 = r5;
            if ((r9 & 4) == 0) goto L11;
            r6 = r3.eventAppendObricPrefix;
        L11:
            boolean r0 = r6;
            if ((r9 & 8) == 0) goto L14;
            r7 = r3.paramAppendObricPrefix;
        L14:
            boolean r1 = r7;
            if ((r9 & 16) == 0) goto L17;
            r8 = r3.target;
        L17:
            String r12 = r4;
            return r3.copy(r12, r11, r0, r1, r8);
        }

        public final String component1() {
            return this.event;
        }

        public final JSONObject component2() {
            return this.keyValue;
        }

        public final boolean component3() {
            return this.eventAppendObricPrefix;
        }

        public final boolean component4() {
            return this.paramAppendObricPrefix;
        }

        public final TrackingReportTarget component5() {
            return this.target;
        }

        public final Event copy(String r7, JSONObject r8, boolean r9, boolean r10, TrackingReportTarget r11) {
            o.e(r7, "event");
            o.e(r8, "keyValue");
            o.e(r11, "target");
            return new Event(r7, r8, r9, r10, r11);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, Event.class) == true) goto L8;
            return false;
        L8:
            Event r6 = (Event) ZeusTransformUtils.preCheckCast(r5, Event.class, "com.obric.aiagent.plugin");
            if (o.a(this.event, r6.event) == true) goto L12;
            return false;
        L12:
            if (o.a(this.keyValue, r6.keyValue) == true) goto L15;
            return false;
        L15:
            if (this.eventAppendObricPrefix == r6.eventAppendObricPrefix) goto L18;
            return false;
        L18:
            if (this.paramAppendObricPrefix == r6.paramAppendObricPrefix) goto L21;
            return false;
        L21:
            if (this.target == r6.target) goto L23;
            return false;
        L23:
            return true;
        }

        public int hashCode() {
            return (((((((this.event.hashCode() * 31) + this.keyValue.hashCode()) * 31) + Boolean.hashCode(this.eventAppendObricPrefix)) * 31) + Boolean.hashCode(this.paramAppendObricPrefix)) * 31) + this.target.hashCode();
        }

        public String toString() {
            return "Event(event=" + this.event + ", keyValue=" + this.keyValue + ", eventAppendObricPrefix=" + this.eventAppendObricPrefix + ", paramAppendObricPrefix=" + this.paramAppendObricPrefix + ", target=" + this.target + ')';
        }

        public Event(String r2, JSONObject r3, boolean r4, boolean r5, TrackingReportTarget r6) {
            o.e(r2, "event");
            o.e(r3, "keyValue");
            o.e(r6, "target");
            this.event = r2;
            this.keyValue = r3;
            this.eventAppendObricPrefix = r4;
            this.paramAppendObricPrefix = r5;
            this.target = r6;
        }

        public final String getEvent() {
            return this.event;
        }

        public final JSONObject getKeyValue() {
            return this.keyValue;
        }

        public final boolean getEventAppendObricPrefix() {
            return this.eventAppendObricPrefix;
        }

        public final boolean getParamAppendObricPrefix() {
            return this.paramAppendObricPrefix;
        }

        public final TrackingReportTarget getTarget() {
            return this.target;
        }
    }

    private AOBizTracking() {
    }

    static {
        INSTANCE = new AOBizTracking();
        mPendingEvents = new LinkedList();
    }

    private final boolean checkPlatformInitialized() {
        return AOPlatform.INSTANCE.isInitialized();
    }

    @Override // com.obric.autogui.common.api.platform.tracking.IAutoActionTrackingApi
    public void init(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        o.e(r4, "context");
        if (checkPlatformInitialized() == true) goto L7;
        Loog.INSTANCE.e(TAG, "The Platform interface isn't initialized.");
        return;
    L7:
        if (ObricProductSdk.INSTANCE.featureService().isEmulatorOs() == false) goto L10;
        Loog.INSTANCE.e(TAG, "The Platform is EmulatorOs.");
        return;
    L10:
        AOPlatformTools.INSTANCE.tracking().init(r4);
        flushPendingEvents();
    }

    private final void addPendingEvent(Event r5) {
        LinkedList<Event> r4 = mPendingEvents;
        monitor-enter(r4);
        Loog.INSTANCE.d(TAG, " --> [ReportEvent](" + r5.getEvent() + ") Pending");     // Catch: Throwable -> L7
        r4.offer(r5);     // Catch: Throwable -> L7
        monitor-exit(r4);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private final void flushPendingEvents() {
        LinkedList<Event> r0 = mPendingEvents;
        monitor-enter(r0);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (r0.isEmpty() == false) goto L8;
        monitor-exit(r0);
        return;
    L8:
        List r1 = p.o((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L15
        r0.clear();     // Catch: Throwable -> L15
        monitor-exit(r0);
        Iterator r2 = ((Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L12:
        if (r2.hasNext() == false) goto L14;
        reportEventToPlatform((Event) ZeusTransformUtils.preCheckCast(r2.next(), Event.class, "com.obric.aiagent.plugin"));
        goto L12
    }

    @Override // com.obric.autogui.common.api.platform.tracking.IAutoActionTrackingApi
    public void reportEvent(String r10, JSONObject r11, boolean r12, boolean r13, TrackingReportTarget r14) {
        o.e(r10, "event");
        o.e(r11, "keyValue");
        o.e(r14, "reportTarget");
        Event r0 = new Event(r10, r11, r12, r13, r14);
        if (checkPlatformInitialized() == true) goto L6;
        Loog.INSTANCE.w(TAG, "[ReportEvent](" + r10 + ") The Platform interface isn't initialized.");
        addPendingEvent(Event.copy$default(r0, null, new JSONObject(r11.toString()), false, false, null, 29, null));
        return;
    L6:
        flushPendingEvents();
        reportEventToPlatform(r0);
    }

    private final void reportEventToPlatform(Event r7) {
        if (ObricProductSdk.INSTANCE.featureService().isEmulatorOs() == false) goto L6;
        Loog.INSTANCE.e(TAG, "not reportEventToPlatform on EmulatorOs");
        return;
    L6:
        AOPlatformTools.INSTANCE.tracking().reportEvent(r7.getEvent(), r7.getKeyValue(), r7.getEventAppendObricPrefix(), r7.getParamAppendObricPrefix(), r7.getTarget());
    }
}
