package com.obric.memorydata.sdk.screencapture.event;

import android.os.Parcel;
import android.os.Parcelable;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.d.b;
import d.h.b.h;
import d.h.b.o;
import d.k;

/* JADX INFO: compiled from: ScreenEvent.kt */
/* JADX INFO: loaded from: classes4.dex */
public abstract class ScreenEvent implements Parcelable {
    public static final CREATOR CREATOR = null;
    private String appName;
    private long eventTime;
    private String packageName;

    /* JADX INFO: compiled from: ScreenEvent.kt */
    public static final class CREATOR implements Parcelable.Creator<ScreenEvent> {

        /* JADX INFO: compiled from: ScreenEvent.kt */
        public /* synthetic */ class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f33861a = null;

            static {
                int[] r0 = new int[a.values().length];
                r0[a.f33862a.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
            L13:
                r0[a.f33863b.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
            L19:
                r0[a.f33864c.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
            L15:
                r0[a.f33865d.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
            L7:
                f33861a = r0;
            }
        }

        public /* synthetic */ CREATOR(h r1) {
            this();
        }

        private CREATOR() {
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ScreenEvent createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ScreenEvent[] newArray(int r1) {
            return newArray(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ScreenEvent createFromParcel(Parcel r7) {
            o.e(r7, "parcel");
            String r6 = r7.readString();
            o.a(r6);
            a r8 = a.valueOf(r6);
            long r0 = r7.readLong();
            String r2 = r7.readString();
            o.a(r2);
            String r3 = r7.readString();
            o.a(r3);
            int r9 = a.f33861a[r8.ordinal()];
            if (r9 != 1) goto L5;
            ScreenEvent r10 = (ScreenEvent) ZeusTransformUtils.preCheckCast(new ScreenTouchEvent(r7), ScreenEvent.class, "com.obric.aiagent.plugin");
        L16:
            r10.setEventTime(r0);
            r10.setPackageName(r2);
            r10.setAppName(r3);
            return r10;
        L5:
            if (r9 != 2) goto L7;
            r10 = (ScreenEvent) ZeusTransformUtils.preCheckCast(new InputMethodEvent(r7), ScreenEvent.class, "com.obric.aiagent.plugin");
            goto L16
        L7:
            if (r9 != 3) goto L9;
            r10 = (ScreenEvent) ZeusTransformUtils.preCheckCast(new AppStateEvent(r7), ScreenEvent.class, "com.obric.aiagent.plugin");
            goto L16
        L9:
            if (r9 != 4) goto L12;
            r10 = (ScreenEvent) ZeusTransformUtils.preCheckCast(new AppAccessibilityEvent(r7), ScreenEvent.class, "com.obric.aiagent.plugin");
            goto L16
        L12:
            throw new k();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ScreenEvent[] newArray(int r1) {
            return new ScreenEvent[r1];
        }
    }

    /* JADX INFO: compiled from: ScreenEvent.kt */
    public static final enum a extends Enum<a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f33862a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f33863b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final a f33864c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final a f33865d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final /* synthetic */ a[] f33866e = null;
        private static final /* synthetic */ d.d.a f = null;

        private static final /* synthetic */ a[] a() {
            return new a[]{f33862a, f33863b, f33864c, f33865d};
        }

        static {
            f33862a = new a("TOUCH", 0);
            f33863b = new a("INPUT_METHOD", 1);
            f33864c = new a("APP_STATE", 2);
            f33865d = new a("ACCESSIBILITY", 3);
            a[] r0 = a();
            f33866e = r0;
            f = b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
        }

        private a(String r1, int r2) {
            super(r1, r2);
        }

        public static a valueOf(String r2) {
            return (a) ZeusTransformUtils.preCheckCast(Enum.valueOf(a.class, r2), a.class, "com.obric.aiagent.plugin");
        }

        public static a[] values() {
            return (a[]) ZeusTransformUtils.preCheckCast(f33866e.clone(), a[].class, "com.obric.aiagent.plugin");
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public /* synthetic */ ScreenEvent(h r1) {
        this();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public abstract a getEventType();

    private ScreenEvent() {
        this.eventTime = System.currentTimeMillis();
        this.packageName = "";
        this.appName = "";
    }

    public final long getEventTime() {
        return this.eventTime;
    }

    public final void setEventTime(long r1) {
        this.eventTime = r1;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public final void setPackageName(String r2) {
        o.e(r2, "<set-?>");
        this.packageName = r2;
    }

    public final String getAppName() {
        return this.appName;
    }

    public final void setAppName(String r2) {
        o.e(r2, "<set-?>");
        this.appName = r2;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r3, int r4) {
        o.e(r3, "parcel");
        r3.writeString(getEventType().name());
        r3.writeLong(this.eventTime);
        r3.writeString(this.packageName);
        r3.writeString(this.appName);
    }
}
