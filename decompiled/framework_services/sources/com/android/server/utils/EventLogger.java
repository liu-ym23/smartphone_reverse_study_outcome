package com.android.server.utils;

import android.util.Log;
import android.util.Slog;
import java.io.PrintWriter;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.text.SimpleDateFormat;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public class EventLogger {
    private static final String DUMP_TITLE_PREFIX = "Events log: ";
    private final ArrayDeque<Event> mEvents;
    private final int mMemSize;
    private final String mTag;

    public interface DumpSink {
        void sink(String r1, List<Event> r2);
    }

    public static abstract class Event {
        public static final int ALOGE = 1;
        public static final int ALOGI = 0;
        public static final int ALOGV = 3;
        public static final int ALOGW = 2;
        private static final SimpleDateFormat sFormat = null;
        private final long mTimestamp;

        @Retention(RetentionPolicy.SOURCE)
        public @interface LogType {
        }

        public abstract String eventToString();

        static {
            sFormat = new SimpleDateFormat("MM-dd HH:mm:ss:SSS", Locale.US);
        }

        public Event() {
            this.mTimestamp = System.currentTimeMillis();
        }

        public String toString() {
            return sFormat.format(new Date(this.mTimestamp)) + " " + eventToString();
        }

        public Event printLog(String tag) {
            return printLog(0, tag);
        }

        public Event printLog(int type, String tag) {
            switch(type) {
                case 0: goto L6;
                case 1: goto L5;
                case 2: goto L4;
                default: goto L3;
            };
        L3:
            Log.v(tag, eventToString());
        L7:
            return this;
        L4:
            Log.w(tag, eventToString());
            goto L7
        L5:
            Log.e(tag, eventToString());
            goto L7
        L6:
            Log.i(tag, eventToString());
            goto L7
        }

        public Event printSlog(int type, String tag) {
            switch(type) {
                case 0: goto L6;
                case 1: goto L5;
                case 2: goto L4;
                default: goto L3;
            };
        L3:
            Slog.v(tag, eventToString());
        L7:
            return this;
        L4:
            Slog.w(tag, eventToString());
            goto L7
        L5:
            Slog.e(tag, eventToString());
            goto L7
        L6:
            Slog.i(tag, eventToString());
            goto L7
        }
    }

    public static class StringEvent extends Event {
        private final String mDescription;
        private final String mSource;

        public static StringEvent from(String source, String description, Object... args) {
            return new StringEvent(source, String.format(Locale.US, description, args));
        }

        public StringEvent(String description) {
            this(null, description);
        }

        public StringEvent(String source, String description) {
            this.mSource = source;
            this.mDescription = description;
        }

        @Override // com.android.server.utils.EventLogger.Event
        public String eventToString() {
            if (this.mSource == null) goto L5;
            String r0 = this.mSource;
            if (this.mDescription != null) goto L9;
            String r1 = "";
        L11:
            return String.format("[%-40s] %s", new Object[]{r0, r1});
        L9:
            r1 = this.mDescription;
            goto L11
        L5:
            return this.mDescription;
        }
    }

    public EventLogger(int size, String tag) {
        this.mEvents = new ArrayDeque(size);
        this.mMemSize = size;
        this.mTag = tag;
    }

    public synchronized void enqueue(Event event) {
        monitor-enter(this);
    L6:
        th = move-exception;
        throw th;
    L4:
        if (this.mEvents.size() < this.mMemSize) goto L8;
        this.mEvents.removeFirst();     // Catch: Throwable -> L6
    L8:
        this.mEvents.addLast(event);     // Catch: Throwable -> L6
        monitor-exit(this);
    }

    public synchronized void enqueueAndLog(String msg, int logType, String tag) {
        monitor-enter(this);
        Event event = new StringEvent(msg);     // Catch: Throwable -> L6
        enqueue(event.printLog(logType, tag));     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void enqueueAndSlog(String msg, int logType, String tag) {
        monitor-enter(this);
        Event event = new StringEvent(msg);     // Catch: Throwable -> L6
        enqueue(event.printSlog(logType, tag));     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void dump(DumpSink dumpSink) {
        monitor-enter(this);
        dumpSink.sink(this.mTag, new ArrayList(this.mEvents));     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void dump(PrintWriter pw) {
        monitor-enter(this);
        dump(pw, "");     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    protected String getDumpTitle() {
        if (this.mTag != null) goto L6;
        return DUMP_TITLE_PREFIX;
    L6:
        return DUMP_TITLE_PREFIX + this.mTag;
    }

    public synchronized void dump(PrintWriter pw, String indent) {
        monitor-enter(this);
        pw.println(getDumpTitle());     // Catch: Throwable -> L8
        Iterator<Event> r0 = this.mEvents.iterator();     // Catch: Throwable -> L8
    L5:
        if (r0.hasNext() == false) goto L10;
        Event evt = r0.next();     // Catch: Throwable -> L8
        pw.println(indent + evt.toString());     // Catch: Throwable -> L8
        goto L5
    L10:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }
}
