package com.android.server.trust;

import android.content.ComponentName;
import android.os.SystemClock;
import android.util.TimeUtils;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public class TrustArchive {
    private static final int HISTORY_LIMIT = 200;
    private static final int TYPE_AGENT_CONNECTED = 4;
    private static final int TYPE_AGENT_DIED = 3;
    private static final int TYPE_AGENT_STOPPED = 5;
    private static final int TYPE_GRANT_TRUST = 0;
    private static final int TYPE_MANAGING_TRUST = 6;
    private static final int TYPE_POLICY_CHANGED = 7;
    private static final int TYPE_REVOKE_TRUST = 1;
    private static final int TYPE_TRUST_TIMEOUT = 2;
    ArrayDeque<Event> mEvents;

    private static class Event {
        final ComponentName agent;
        final long duration;
        final long elapsedTimestamp;
        final int flags;
        final boolean managingTrust;
        final String message;
        final int type;
        final int userId;

        /* synthetic */ Event(int r1, int r2, ComponentName r3, String r4, long r5, int r7, boolean r8, TrustArchiveIA r9) {
            this(r1, r2, r3, r4, r5, r7, r8);
        }

        private Event(int type, int userId, ComponentName agent, String message, long duration, int flags, boolean managingTrust) {
            this.type = type;
            this.userId = userId;
            this.agent = agent;
            this.elapsedTimestamp = SystemClock.elapsedRealtime();
            this.message = message;
            this.duration = duration;
            this.flags = flags;
            this.managingTrust = managingTrust;
        }
    }

    public TrustArchive() {
        this.mEvents = new ArrayDeque();
    }

    public void logGrantTrust(int userId, ComponentName agent, String message, long duration, int flags) {
        int r1 = 0;
        addEvent(new Event(r1, userId, agent, message, duration, flags, false, null));
    }

    public void logRevokeTrust(int userId, ComponentName agent) {
        int r1 = 1;
        String r4 = null;
        long r5 = 0;
        int r7 = 0;
        addEvent(new Event(r1, userId, agent, r4, r5, r7, false, null));
    }

    public void logTrustTimeout(int userId, ComponentName agent) {
        int r1 = 2;
        String r4 = null;
        long r5 = 0;
        int r7 = 0;
        addEvent(new Event(r1, userId, agent, r4, r5, r7, false, null));
    }

    public void logAgentDied(int userId, ComponentName agent) {
        int r1 = 3;
        String r4 = null;
        long r5 = 0;
        int r7 = 0;
        addEvent(new Event(r1, userId, agent, r4, r5, r7, false, null));
    }

    public void logAgentConnected(int userId, ComponentName agent) {
        int r1 = 4;
        String r4 = null;
        long r5 = 0;
        int r7 = 0;
        addEvent(new Event(r1, userId, agent, r4, r5, r7, false, null));
    }

    public void logAgentStopped(int userId, ComponentName agent) {
        int r1 = 5;
        String r4 = null;
        long r5 = 0;
        int r7 = 0;
        addEvent(new Event(r1, userId, agent, r4, r5, r7, false, null));
    }

    public void logManagingTrust(int userId, ComponentName agent, boolean managing) {
        int r1 = 6;
        String r4 = null;
        long r5 = 0;
        addEvent(new Event(r1, userId, agent, r4, r5, 0, managing, null));
    }

    public void logDevicePolicyChanged() {
        int r1 = 7;
        int r2 = -1;
        ComponentName r3 = null;
        String r4 = null;
        long r5 = 0;
        int r7 = 0;
        addEvent(new Event(r1, r2, r3, r4, r5, r7, false, null));
    }

    private void addEvent(Event e) {
        if (this.mEvents.size() < 200) goto L5;
        this.mEvents.removeFirst();
    L5:
        this.mEvents.addLast(e);
    }

    public void dump(PrintWriter writer, int limit, int userId, String linePrefix, boolean duplicateSimpleNames) {
        int count = 0;
        Iterator<Event> iter = this.mEvents.descendingIterator();
    L4:
        if (iter.hasNext() == false) goto L28;
        if (count >= limit) goto L37;
        Event ev = iter.next();
        if (userId == (-1)) goto L13;
        if (userId == ev.userId) goto L13;
        if (ev.userId != (-1)) goto L4;
    L13:
        writer.print(linePrefix);
        writer.printf("#%-2d %s %s: ", new Object[]{Integer.valueOf(count), formatElapsed(ev.elapsedTimestamp), dumpType(ev.type)});
        if (userId != (-1)) goto L17;
        writer.print("user=");
        writer.print(ev.userId);
        writer.print(", ");
    L17:
        if (ev.agent == null) goto L23;
        writer.print("agent=");
        if (duplicateSimpleNames == false) goto L21;
        writer.print(ev.agent.flattenToShortString());
        goto L23
    L21:
        writer.print(getSimpleName(ev.agent));
    L23:
        switch(ev.type) {
            case 0: goto L26;
            case 6: goto L25;
            default: goto L27;
        };
    L25:
        writer.printf(", managingTrust=" + ev.managingTrust, new Object[0]);
        goto L27
    L26:
        writer.printf(", message=\"%s\", duration=%s, flags=%s", new Object[]{ev.message, formatDuration(ev.duration), dumpGrantFlags(ev.flags)});
    L27:
        writer.println();
        count = count + 1;
        goto L4
    L37:
        return;
    }

    public static String formatDuration(long duration) {
        StringBuilder sb = new StringBuilder();
        TimeUtils.formatDuration(duration, sb);
        return sb.toString();
    }

    private static String formatElapsed(long elapsed) {
        long delta = elapsed - SystemClock.elapsedRealtime();
        long wallTime = System.currentTimeMillis() + delta;
        return TimeUtils.logTimeOfDay(wallTime);
    }

    static String getSimpleName(ComponentName cn) {
        String name = cn.getClassName();
        int idx = name.lastIndexOf(46);
        if (idx >= name.length()) goto L7;
        if (idx < 0) goto L7;
        return name.substring(idx + 1);
    L7:
        return name;
    }

    private String dumpType(int type) {
        switch(type) {
            case 0: goto L19;
            case 1: goto L17;
            case 2: goto L15;
            case 3: goto L13;
            case 4: goto L11;
            case 5: goto L9;
            case 6: goto L7;
            case 7: goto L5;
            default: goto L4;
        };
    L5:
        return "DevicePolicyChanged";
    L7:
        return "ManagingTrust";
    L9:
        return "AgentStopped";
    L11:
        return "AgentConnected";
    L13:
        return "AgentDied";
    L15:
        return "TrustTimeout";
    L17:
        return "RevokeTrust";
    L19:
        return "GrantTrust";
    L4:
        return "Unknown(" + type + ")";
    }

    private String dumpGrantFlags(int flags) {
        StringBuilder sb = new StringBuilder();
        if ((flags & 1) == 0) goto L9;
        if (sb.length() == 0) goto L7;
        sb.append('|');
    L7:
        sb.append("INITIATED_BY_USER");
    L9:
        if ((flags & 2) == 0) goto L15;
        if (sb.length() == 0) goto L13;
        sb.append('|');
    L13:
        sb.append("DISMISS_KEYGUARD");
    L15:
        if (sb.length() != 0) goto L18;
        sb.append('0');
    L18:
        return sb.toString();
    }
}
