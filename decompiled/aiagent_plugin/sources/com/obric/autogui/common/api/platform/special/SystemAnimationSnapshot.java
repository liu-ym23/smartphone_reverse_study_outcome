package com.obric.autogui.common.api.platform.special;

import android.content.ComponentName;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.d.a;
import d.d.b;
import d.h.b.h;
import d.h.b.o;
import java.util.List;

/* JADX INFO: compiled from: ActionSystemAnimationMonitor.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class SystemAnimationSnapshot {
    private final Event event;
    private final List<ComponentName> involvedActivities;
    private final List<Integer> involvedModes;
    private final long receivedAtMillis;
    private final boolean stillAnimating;
    private final ComponentName topActivity;
    private final int transitType;
    private final int transitionId;

    /* JADX INFO: compiled from: ActionSystemAnimationMonitor.kt */
    public static final enum Event extends Enum<Event> {
        private static final /* synthetic */ a $ENTRIES = null;
        private static final /* synthetic */ Event[] $VALUES = null;
        public static final Event Baseline = null;
        public static final Event Cancelled = null;
        public static final Companion Companion = null;
        public static final Event Finished = null;
        public static final Event Launch = null;
        public static final Event Pending = null;
        public static final Event Started = null;
        public static final Event TakeOver = null;
        public static final Event Unknown = null;
        private final int rawValue;

        /* JADX INFO: compiled from: ActionSystemAnimationMonitor.kt */
        public static final class Companion {
            public /* synthetic */ Companion(h r1) {
                this();
            }

            private Companion() {
            }

            public final Event fromRawValue(int r6) {
                Event[] r5 = Event.values();
                int r0 = r5.length;
                int r2 = 0;
            L3:
                if (r2 >= r0) goto L11;
                Event r3 = r5[r2];
                if (r3.getRawValue() != r6) goto L7;
                boolean r4 = true;
            L8:
                if (r4 == true) goto L12;
                r2 = r2 + 1;
            L12:
                if (r3 == null) goto L14;
                return r3;
            L14:
                return Event.Unknown;
            L7:
                r4 = false;
                goto L8
            L11:
                r3 = null;
                goto L12
            }
        }

        private static final /* synthetic */ Event[] $values() {
            return new Event[]{Baseline, Started, Finished, Cancelled, TakeOver, Pending, Launch, Unknown};
        }

        public static a<Event> getEntries() {
            return $ENTRIES;
        }

        private Event(String r1, int r2, int r3) {
            super(r1, r2);
            this.rawValue = r3;
        }

        public final int getRawValue() {
            return this.rawValue;
        }

        static {
            Baseline = new Event("Baseline", 0, 0);
            Started = new Event("Started", 1, 1);
            Finished = new Event("Finished", 2, 2);
            Cancelled = new Event("Cancelled", 3, 3);
            TakeOver = new Event("TakeOver", 4, 4);
            Pending = new Event("Pending", 5, 5);
            Launch = new Event("Launch", 6, 6);
            Unknown = new Event("Unknown", 7, -1);
            Event[] r0 = $values();
            $VALUES = r0;
            $ENTRIES = b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
            Companion = new Companion(null);
        }

        public static Event valueOf(String r2) {
            return (Event) ZeusTransformUtils.preCheckCast(Enum.valueOf(Event.class, r2), Event.class, "com.obric.aiagent.plugin");
        }

        public static Event[] values() {
            return (Event[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), Event[].class, "com.obric.aiagent.plugin");
        }
    }

    public static /* synthetic */ SystemAnimationSnapshot copy$default(SystemAnimationSnapshot r11, Event r12, boolean r13, int r14, int r15, ComponentName r16, List r17, List r18, long r19, int r21, Object r22) {
        List<ComponentName> r2 = (List) ZeusTransformUtils.wrapperContextForParams(r17, List.class, "com.obric.aiagent.plugin");
        List<Integer> r3 = (List) ZeusTransformUtils.wrapperContextForParams(r18, List.class, "com.obric.aiagent.plugin");
        if ((r21 & 1) == 0) goto L5;
        Event r4 = r11.event;
    L7:
        if ((r21 & 2) == 0) goto L9;
        boolean r5 = r11.stillAnimating;
    L11:
        if ((r21 & 4) == 0) goto L13;
        int r6 = r11.transitType;
    L15:
        if ((r21 & 8) == 0) goto L17;
        int r7 = r11.transitionId;
    L19:
        if ((r21 & 16) == 0) goto L21;
        ComponentName r8 = r11.topActivity;
    L23:
        if ((r21 & 32) == 0) goto L26;
        r2 = r11.involvedActivities;
    L26:
        if ((r21 & 64) == 0) goto L29;
        r3 = r11.involvedModes;
    L29:
        if ((r21 & 128) == 0) goto L31;
        long r9 = r11.receivedAtMillis;
    L33:
        return r11.copy(r4, r5, r6, r7, r8, r2, r3, r9);
    L31:
        r9 = r19;
        goto L33
    L21:
        r8 = r16;
        goto L23
    L17:
        r7 = r15;
        goto L19
    L13:
        r6 = r14;
        goto L15
    L9:
        r5 = r13;
        goto L11
    L5:
        r4 = r12;
        goto L7
    }

    public final Event component1() {
        return this.event;
    }

    public final boolean component2() {
        return this.stillAnimating;
    }

    public final int component3() {
        return this.transitType;
    }

    public final int component4() {
        return this.transitionId;
    }

    public final ComponentName component5() {
        return this.topActivity;
    }

    public final List<ComponentName> component6() {
        return this.involvedActivities;
    }

    public final List<Integer> component7() {
        return this.involvedModes;
    }

    public final long component8() {
        return this.receivedAtMillis;
    }

    public final SystemAnimationSnapshot copy(Event r13, boolean r14, int r15, int r16, ComponentName r17, List<ComponentName> r18, List<Integer> r19, long r20) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r18, List.class, "com.obric.aiagent.plugin");
        List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r19, List.class, "com.obric.aiagent.plugin");
        o.e(r13, "event");
        o.e(r8, "involvedActivities");
        o.e(r9, "involvedModes");
        return new SystemAnimationSnapshot(r13, r14, r15, r16, r17, r8, r9, r20);
    }

    public boolean equals(Object r7) {
        if (this != r7) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r7, SystemAnimationSnapshot.class) == true) goto L8;
        return false;
    L8:
        SystemAnimationSnapshot r8 = (SystemAnimationSnapshot) ZeusTransformUtils.preCheckCast(r7, SystemAnimationSnapshot.class, "com.obric.aiagent.plugin");
        if (this.event == r8.event) goto L12;
        return false;
    L12:
        if (this.stillAnimating == r8.stillAnimating) goto L15;
        return false;
    L15:
        if (this.transitType == r8.transitType) goto L18;
        return false;
    L18:
        if (this.transitionId == r8.transitionId) goto L21;
        return false;
    L21:
        if (o.a(this.topActivity, r8.topActivity) == true) goto L24;
        return false;
    L24:
        if (o.a(this.involvedActivities, r8.involvedActivities) == true) goto L27;
        return false;
    L27:
        if (o.a(this.involvedModes, r8.involvedModes) == true) goto L30;
        return false;
    L30:
        if (this.receivedAtMillis == r8.receivedAtMillis) goto L32;
        return false;
    L32:
        return true;
    }

    public int hashCode() {
        int r0 = ((((((this.event.hashCode() * 31) + Boolean.hashCode(this.stillAnimating)) * 31) + Integer.hashCode(this.transitType)) * 31) + Integer.hashCode(this.transitionId)) * 31;
        ComponentName r1 = this.topActivity;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return ((((((r0 + r2) * 31) + this.involvedActivities.hashCode()) * 31) + this.involvedModes.hashCode()) * 31) + Long.hashCode(this.receivedAtMillis);
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public String toString() {
        return "SystemAnimationSnapshot(event=" + this.event + ", stillAnimating=" + this.stillAnimating + ", transitType=" + this.transitType + ", transitionId=" + this.transitionId + ", topActivity=" + this.topActivity + ", involvedActivities=" + this.involvedActivities + ", involvedModes=" + this.involvedModes + ", receivedAtMillis=" + this.receivedAtMillis + ')';
    }

    public SystemAnimationSnapshot(Event r3, boolean r4, int r5, int r6, ComponentName r7, List<ComponentName> r8, List<Integer> r9, long r10) {
        List<ComponentName> r11 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.aiagent.plugin");
        List<Integer> r12 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.aiagent.plugin");
        o.e(r3, "event");
        o.e(r11, "involvedActivities");
        o.e(r12, "involvedModes");
        this.event = r3;
        this.stillAnimating = r4;
        this.transitType = r5;
        this.transitionId = r6;
        this.topActivity = r7;
        this.involvedActivities = r11;
        this.involvedModes = r12;
        this.receivedAtMillis = r10;
    }

    public final Event getEvent() {
        return this.event;
    }

    public final boolean getStillAnimating() {
        return this.stillAnimating;
    }

    public final int getTransitType() {
        return this.transitType;
    }

    public final int getTransitionId() {
        return this.transitionId;
    }

    public final ComponentName getTopActivity() {
        return this.topActivity;
    }

    public final List<ComponentName> getInvolvedActivities() {
        return this.involvedActivities;
    }

    public final List<Integer> getInvolvedModes() {
        return this.involvedModes;
    }

    public final long getReceivedAtMillis() {
        return this.receivedAtMillis;
    }
}
