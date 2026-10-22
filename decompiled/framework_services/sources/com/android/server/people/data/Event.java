package com.android.server.people.data;

import android.text.format.DateFormat;
import android.util.ArraySet;
import android.util.Slog;
import android.util.proto.ProtoInputStream;
import android.util.proto.ProtoOutputStream;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class Event {
    public static final Set<Integer> ALL_EVENT_TYPES = null;
    public static final Set<Integer> CALL_EVENT_TYPES = null;
    public static final Set<Integer> NOTIFICATION_EVENT_TYPES = null;
    public static final Set<Integer> SHARE_EVENT_TYPES = null;
    public static final Set<Integer> SMS_EVENT_TYPES = null;
    private static final String TAG = null;
    public static final int TYPE_CALL_INCOMING = 11;
    public static final int TYPE_CALL_MISSED = 12;
    public static final int TYPE_CALL_OUTGOING = 10;
    public static final int TYPE_IN_APP_CONVERSATION = 13;
    public static final int TYPE_NOTIFICATION_OPENED = 3;
    public static final int TYPE_NOTIFICATION_POSTED = 2;
    public static final int TYPE_SHARE_IMAGE = 5;
    public static final int TYPE_SHARE_OTHER = 7;
    public static final int TYPE_SHARE_TEXT = 4;
    public static final int TYPE_SHARE_VIDEO = 6;
    public static final int TYPE_SHORTCUT_INVOCATION = 1;
    public static final int TYPE_SMS_INCOMING = 9;
    public static final int TYPE_SMS_OUTGOING = 8;
    private final int mDurationSeconds;
    private final long mTimestamp;
    private final int mType;

    static class Builder {
        private int mDurationSeconds;
        private long mTimestamp;
        private int mType;

        /* JADX INFO: renamed from: -$$Nest$fgetmDurationSeconds, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m6550$$Nest$fgetmDurationSeconds(Builder r0) {
            return r0.mDurationSeconds;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmTimestamp, reason: not valid java name */
        static /* bridge */ /* synthetic */ long m6551$$Nest$fgetmTimestamp(Builder r2) {
            return r2.mTimestamp;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmType, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m6552$$Nest$fgetmType(Builder r0) {
            return r0.mType;
        }

        /* JADX INFO: renamed from: -$$Nest$msetTimestamp, reason: not valid java name */
        static /* bridge */ /* synthetic */ Builder m6553$$Nest$msetTimestamp(Builder r0, long r1) {
            return r0.setTimestamp(r1);
        }

        /* JADX INFO: renamed from: -$$Nest$msetType, reason: not valid java name */
        static /* bridge */ /* synthetic */ Builder m6554$$Nest$msetType(Builder r0, int r1) {
            return r0.setType(r1);
        }

        /* synthetic */ Builder(EventIA r1) {
            this();
        }

        private Builder() {
        }

        Builder(long timestamp, int type) {
            this.mTimestamp = timestamp;
            this.mType = type;
        }

        Builder setDurationSeconds(int durationSeconds) {
            this.mDurationSeconds = durationSeconds;
            return this;
        }

        private Builder setTimestamp(long timestamp) {
            this.mTimestamp = timestamp;
            return this;
        }

        private Builder setType(int type) {
            this.mType = type;
            return this;
        }

        Event build() {
            return new Event(this, null);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface EventType {
    }

    /* synthetic */ Event(Builder r1, EventIA r2) {
        this(r1);
    }

    static {
        TAG = Event.class.getSimpleName();
        NOTIFICATION_EVENT_TYPES = new ArraySet();
        SHARE_EVENT_TYPES = new ArraySet();
        SMS_EVENT_TYPES = new ArraySet();
        CALL_EVENT_TYPES = new ArraySet();
        ALL_EVENT_TYPES = new ArraySet();
        NOTIFICATION_EVENT_TYPES.add(2);
        NOTIFICATION_EVENT_TYPES.add(3);
        SHARE_EVENT_TYPES.add(4);
        SHARE_EVENT_TYPES.add(5);
        SHARE_EVENT_TYPES.add(6);
        SHARE_EVENT_TYPES.add(7);
        SMS_EVENT_TYPES.add(9);
        SMS_EVENT_TYPES.add(8);
        CALL_EVENT_TYPES.add(11);
        CALL_EVENT_TYPES.add(10);
        CALL_EVENT_TYPES.add(12);
        ALL_EVENT_TYPES.add(1);
        ALL_EVENT_TYPES.add(13);
        ALL_EVENT_TYPES.addAll(NOTIFICATION_EVENT_TYPES);
        ALL_EVENT_TYPES.addAll(SHARE_EVENT_TYPES);
        ALL_EVENT_TYPES.addAll(SMS_EVENT_TYPES);
        ALL_EVENT_TYPES.addAll(CALL_EVENT_TYPES);
    }

    Event(long timestamp, int type) {
        this.mTimestamp = timestamp;
        this.mType = type;
        this.mDurationSeconds = 0;
    }

    private Event(Builder builder) {
        this.mTimestamp = Builder.m6551$$Nest$fgetmTimestamp(builder);
        this.mType = Builder.m6552$$Nest$fgetmType(builder);
        this.mDurationSeconds = Builder.m6550$$Nest$fgetmDurationSeconds(builder);
    }

    public long getTimestamp() {
        return this.mTimestamp;
    }

    public int getType() {
        return this.mType;
    }

    public int getDurationSeconds() {
        return this.mDurationSeconds;
    }

    void writeToProto(ProtoOutputStream protoOutputStream) {
        protoOutputStream.write(1120986464257L, this.mType);
        protoOutputStream.write(1112396529666L, this.mTimestamp);
        protoOutputStream.write(1120986464259L, this.mDurationSeconds);
    }

    static Event readFromProto(ProtoInputStream protoInputStream) throws IOException {
        Builder builder = new Builder(null);
    L4:
        if (protoInputStream.nextField() == (-1)) goto L12;
        switch(protoInputStream.getFieldNumber()) {
            case 1: goto L10;
            case 2: goto L9;
            case 3: goto L8;
            default: goto L7;
        };
    L8:
        builder.setDurationSeconds(protoInputStream.readInt(1120986464259L));
        goto L4
    L9:
        Builder.m6553$$Nest$msetTimestamp(builder, protoInputStream.readLong(1112396529666L));
        goto L4
    L10:
        Builder.m6554$$Nest$msetType(builder, protoInputStream.readInt(1120986464257L));
        goto L4
    L7:
        Slog.w(TAG, "Could not read undefined field: " + protoInputStream.getFieldNumber());
        goto L4
    L12:
        return builder.build();
    }

    public boolean equals(Object obj) {
        if (this != obj) goto L6;
        return true;
    L6:
        if ((obj instanceof Event) == true) goto L8;
        return false;
    L8:
        Event other = (Event) obj;
        if (this.mTimestamp != other.mTimestamp) goto L16;
        if (this.mType != other.mType) goto L16;
        if (this.mDurationSeconds != other.mDurationSeconds) goto L16;
        return true;
    L16:
        return false;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{Long.valueOf(this.mTimestamp), Integer.valueOf(this.mType), Integer.valueOf(this.mDurationSeconds)});
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Event {");
        sb.append("timestamp=");
        sb.append(DateFormat.format("yyyy-MM-dd HH:mm:ss", this.mTimestamp));
        sb.append(", type=");
        sb.append(this.mType);
        if (this.mDurationSeconds <= 0) goto L5;
        sb.append(", durationSeconds=");
        sb.append(this.mDurationSeconds);
    L5:
        sb.append("}");
        return sb.toString();
    }
}
