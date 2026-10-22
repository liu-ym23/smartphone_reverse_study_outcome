package com.obric.memorydata.sdk.screencapture.event;

import android.os.Parcel;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.d.b;
import d.h.b.o;

/* JADX INFO: compiled from: AppStateEvent.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class AppStateEvent extends ScreenEvent {
    private final ScreenEvent.a eventType;
    private final a state;

    /* JADX INFO: compiled from: AppStateEvent.kt */
    public static final enum a extends Enum<a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f33857a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f33858b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final /* synthetic */ a[] f33859c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final /* synthetic */ d.d.a f33860d = null;

        private static final /* synthetic */ a[] a() {
            return new a[]{f33857a, f33858b};
        }

        static {
            f33857a = new a("OPEN", 0);
            f33858b = new a("CLOSE", 1);
            a[] r0 = a();
            f33859c = r0;
            f33860d = b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
        }

        private a(String r1, int r2) {
            super(r1, r2);
        }

        public static a valueOf(String r2) {
            return (a) ZeusTransformUtils.preCheckCast(Enum.valueOf(a.class, r2), a.class, "com.obric.aiagent.plugin");
        }

        public static a[] values() {
            return (a[]) ZeusTransformUtils.preCheckCast(f33859c.clone(), a[].class, "com.obric.aiagent.plugin");
        }
    }

    public static /* synthetic */ AppStateEvent copy$default(AppStateEvent r0, a r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = r0.state;
    L6:
        return r0.copy(r1);
    }

    public final a component1() {
        return this.state;
    }

    public final AppStateEvent copy(a r1) {
        o.e(r1, "state");
        return new AppStateEvent(r1);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, AppStateEvent.class) == true) goto L8;
        return false;
    L8:
        AppStateEvent r6 = (AppStateEvent) ZeusTransformUtils.preCheckCast(r5, AppStateEvent.class, "com.obric.aiagent.plugin");
        if (this.state == r6.state) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        return this.state.hashCode();
    }

    public final a getState() {
        return this.state;
    }

    public AppStateEvent(a r2) {
        o.e(r2, "state");
        super(null);
        this.state = r2;
        this.eventType = ScreenEvent.a.f33864c;
    }

    @Override // com.obric.memorydata.sdk.screencapture.event.ScreenEvent
    public ScreenEvent.a getEventType() {
        return this.eventType;
    }

    public AppStateEvent(Parcel r2) {
        o.e(r2, "parcel");
        this(a.values()[r2.readInt()]);
    }

    @Override // com.obric.memorydata.sdk.screencapture.event.ScreenEvent, android.os.Parcelable
    public void writeToParcel(Parcel r2, int r3) {
        o.e(r2, "parcel");
        super.writeToParcel(r2, r3);
        r2.writeInt(this.state.ordinal());
    }

    public String toString() {
        return "AppStateEvent(state=" + this.state.name() + ", appName=" + getAppName() + ", pkgName=" + getPackageName() + ')';
    }
}
