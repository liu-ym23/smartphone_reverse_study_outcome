package com.obric.memorydata.sdk.screencapture.event;

import android.os.Parcel;
import android.os.Parcelable;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: ScreenTouchEvent.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class ScreenTouchEvent extends ScreenEvent {
    private final b action;
    private final TouchInfo endTouchInfo;
    private final ScreenEvent.a eventType;
    private final a scrollDirection;
    private final TouchInfo touchInfo;

    /* JADX INFO: compiled from: ScreenTouchEvent.kt */
    public static final enum a extends Enum<a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f33867a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f33868b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final a f33869c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final a f33870d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final /* synthetic */ a[] f33871e = null;
        private static final /* synthetic */ d.d.a f = null;

        private static final /* synthetic */ a[] a() {
            return new a[]{f33867a, f33868b, f33869c, f33870d};
        }

        static {
            f33867a = new a("UP", 0);
            f33868b = new a("DOWN", 1);
            f33869c = new a("LEFT", 2);
            f33870d = new a("RIGHT", 3);
            a[] r0 = a();
            f33871e = r0;
            f = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
        }

        private a(String r1, int r2) {
            super(r1, r2);
        }

        public static a valueOf(String r2) {
            return (a) ZeusTransformUtils.preCheckCast(Enum.valueOf(a.class, r2), a.class, "com.obric.aiagent.plugin");
        }

        public static a[] values() {
            return (a[]) ZeusTransformUtils.preCheckCast(f33871e.clone(), a[].class, "com.obric.aiagent.plugin");
        }
    }

    /* JADX INFO: compiled from: ScreenTouchEvent.kt */
    public static final enum b extends Enum<b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f33872a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final b f33873b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final b f33874c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final b f33875d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final b f33876e = null;
        public static final b f = null;
        private static final /* synthetic */ b[] g = null;
        private static final /* synthetic */ d.d.a h = null;

        private static final /* synthetic */ b[] a() {
            return new b[]{f33872a, f33873b, f33874c, f33875d, f33876e, f};
        }

        static {
            f33872a = new b("TAP", 0);
            f33873b = new b("DOUBLE_TAP", 1);
            f33874c = new b("LONG_PRESS", 2);
            f33875d = new b("SCROLL_START", 3);
            f33876e = new b("SCROLLED", 4);
            f = new b("BACK_KEY", 5);
            b[] r0 = a();
            g = r0;
            h = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
        }

        private b(String r1, int r2) {
            super(r1, r2);
        }

        public static b valueOf(String r2) {
            return (b) ZeusTransformUtils.preCheckCast(Enum.valueOf(b.class, r2), b.class, "com.obric.aiagent.plugin");
        }

        public static b[] values() {
            return (b[]) ZeusTransformUtils.preCheckCast(g.clone(), b[].class, "com.obric.aiagent.plugin");
        }
    }

    public static /* synthetic */ ScreenTouchEvent copy$default(ScreenTouchEvent r0, b r1, TouchInfo r2, TouchInfo r3, a r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.action;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.touchInfo;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.endTouchInfo;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.scrollDirection;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final b component1() {
        return this.action;
    }

    public final TouchInfo component2() {
        return this.touchInfo;
    }

    public final TouchInfo component3() {
        return this.endTouchInfo;
    }

    public final a component4() {
        return this.scrollDirection;
    }

    public final ScreenTouchEvent copy(b r1, TouchInfo r2, TouchInfo r3, a r4) {
        o.e(r1, "action");
        o.e(r2, "touchInfo");
        return new ScreenTouchEvent(r1, r2, r3, r4);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, ScreenTouchEvent.class) == true) goto L8;
        return false;
    L8:
        ScreenTouchEvent r6 = (ScreenTouchEvent) ZeusTransformUtils.preCheckCast(r5, ScreenTouchEvent.class, "com.obric.aiagent.plugin");
        if (this.action == r6.action) goto L12;
        return false;
    L12:
        if (o.a(this.touchInfo, r6.touchInfo) == true) goto L15;
        return false;
    L15:
        if (o.a(this.endTouchInfo, r6.endTouchInfo) == true) goto L18;
        return false;
    L18:
        if (this.scrollDirection == r6.scrollDirection) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        int r0 = ((this.action.hashCode() * 31) + this.touchInfo.hashCode()) * 31;
        TouchInfo r1 = this.endTouchInfo;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        a r5 = this.scrollDirection;
        if (r5 == null) goto L11;
        r2 = r5.hashCode();
    L11:
        return r4 + r2;
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        return "ScreenTouchEvent(action=" + this.action + ", touchInfo=" + this.touchInfo + ", endTouchInfo=" + this.endTouchInfo + ", scrollDirection=" + this.scrollDirection + ')';
    }

    public /* synthetic */ ScreenTouchEvent(b r2, TouchInfo r3, TouchInfo r4, a r5, int r6, h r7) {
        if ((r6 & 4) == 0) goto L6;
        r4 = null;
    L6:
        if ((r6 & 8) == 0) goto L8;
        r5 = null;
    L8:
        this(r2, r3, r4, r5);
    }

    public final b getAction() {
        return this.action;
    }

    public final TouchInfo getTouchInfo() {
        return this.touchInfo;
    }

    public final TouchInfo getEndTouchInfo() {
        return this.endTouchInfo;
    }

    public final a getScrollDirection() {
        return this.scrollDirection;
    }

    public ScreenTouchEvent(b r2, TouchInfo r3, TouchInfo r4, a r5) {
        o.e(r2, "action");
        o.e(r3, "touchInfo");
        super(null);
        this.action = r2;
        this.touchInfo = r3;
        this.endTouchInfo = r4;
        this.scrollDirection = r5;
        this.eventType = ScreenEvent.a.f33862a;
    }

    @Override // com.obric.memorydata.sdk.screencapture.event.ScreenEvent
    public ScreenEvent.a getEventType() {
        return this.eventType;
    }

    public ScreenTouchEvent(Parcel r6) {
        o.e(r6, "parcel");
        String r0 = r6.readString();
        o.a(r0);
        b r1 = b.valueOf(r0);
        Parcelable r2 = r6.readParcelable(ScreenEvent.class.getClassLoader());
        o.a(r2);
        TouchInfo r3 = (TouchInfo) ZeusTransformUtils.preCheckCast(r2, TouchInfo.class, "com.obric.aiagent.plugin");
        TouchInfo r4 = (TouchInfo) ZeusTransformUtils.preCheckCast(r6.readParcelable(ScreenEvent.class.getClassLoader()), TouchInfo.class, "com.obric.aiagent.plugin");
        String r7 = r6.readString();
        if (r7 == null) goto L5;
        a r8 = a.valueOf(r7);
    L6:
        this(r1, r3, r4, r8);
        return;
    L5:
        r8 = null;
        goto L6
    }

    @Override // com.obric.memorydata.sdk.screencapture.event.ScreenEvent, android.os.Parcelable
    public void writeToParcel(Parcel r4, int r5) {
        o.e(r4, "parcel");
        super.writeToParcel(r4, r5);
        r4.writeString(this.action.name());
        r4.writeParcelable((Parcelable) ZeusTransformUtils.preCheckCast(this.touchInfo, Parcelable.class, "com.obric.aiagent.plugin"), r5);
        r4.writeParcelable((Parcelable) ZeusTransformUtils.preCheckCast(this.endTouchInfo, Parcelable.class, "com.obric.aiagent.plugin"), r5);
        a r3 = this.scrollDirection;
        if (r3 == null) goto L5;
        String r6 = r3.name();
    L6:
        r4.writeString(r6);
        return;
    L5:
        r6 = null;
        goto L6
    }
}
