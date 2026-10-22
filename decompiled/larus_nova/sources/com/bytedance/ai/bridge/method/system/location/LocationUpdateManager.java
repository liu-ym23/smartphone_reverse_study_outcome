package com.bytedance.ai.bridge.method.system.location;

import java.lang.ref.WeakReference;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import r4.l;

/* JADX INFO: loaded from: classes43.dex */
public final class LocationUpdateManager implements e3.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference<e3.d> f35986a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f35987b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f35988c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public UpdateState f35989d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f35990e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f35991f;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ai/bridge/method/system/location/LocationUpdateManager$UpdateState;", "", "<init>", "(Ljava/lang/String;I)V", "IDLE", "STARTING", "STARTED", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum UpdateState extends Enum<UpdateState> {
        public static final UpdateState IDLE = null;
        public static final UpdateState STARTED = null;
        public static final UpdateState STARTING = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ UpdateState[] f35992a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f35993b = null;

        public static EnumEntries<UpdateState> getEntries() {
            return f35993b;
        }

        static {
            UpdateState r100 = new UpdateState("IDLE", 0);
            IDLE = r100;
            UpdateState r101 = new UpdateState("STARTING", 1);
            STARTING = r101;
            UpdateState r102 = new UpdateState("STARTED", 2);
            STARTED = r102;
            UpdateState[] r103 = {r100, r101, r102};
            f35992a = r103;
            f35993b = EnumEntriesKt.enumEntries(r103);
        }

        public static UpdateState[] values() {
            return (UpdateState[]) f35992a.clone();
        }

        public static UpdateState valueOf(String r100) {
            return (UpdateState) r27.a.a(UpdateState.class, r100);
        }

        public UpdateState(String r100, int r101) {
            super(r100, r101);
        }
    }

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f35994a = null;

        static {
            int[] r100 = new int[UpdateState.values().length];
            r100[UpdateState.IDLE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[UpdateState.STARTING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[UpdateState.STARTED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f35994a = r100;
        }
    }

    @Override // e3.b
    public final void a() {
        e3.d r100 = this.f35986a.get();
        Object r101 = this.f35988c;
        monitor-enter(r101);
        boolean r102 = true;
        this.f35991f = true;     // Catch: Throwable -> L45
        if (this.f35989d != UpdateState.STARTED) goto L9;
        boolean r103 = true;
    L10:
        monitor-exit(r101);
        if (r100 == null) goto L44;
        if (r103 == false) goto L54;
        Object r104 = null;
        Result.Companion r105 = Result.Companion;     // Catch: Throwable -> L20
        r4.e r106 = r4.a.f535981h;     // Catch: Throwable -> L20
        if (r106 == null) goto L17;
        l r107 = r106.c(r100, "doubao.stopLocationUpdate", this.f35987b);     // Catch: Throwable -> L20
    L18:
        Object r108 = Result.m9449constructorimpl(r107);     // Catch: Throwable -> L20
    L23:
        if (Result.m9455isFailureimpl(r108) == true) goto L26;
        r104 = r108;
    L26:
        l r109 = (l) r104;
        if (r109 != null) goto L29;
    L34:
        r102 = false;
    L35:
        if (r102 == false) goto L55;
        Object r110 = this.f35988c;
        monitor-enter(r110);
        this.f35989d = UpdateState.IDLE;     // Catch: Throwable -> L41
        Unit r111 = Unit.INSTANCE;     // Catch: Throwable -> L41
        monitor-exit(r110);
        return;
    L41:
        th = move-exception;
        throw th;
    L55:
        return;
    L29:
        if (r109.f536000a != null) goto L31;
        boolean r112 = true;
    L32:
        if (r112 != true) goto L34;
    L31:
        r112 = false;
        goto L32
    L17:
        r107 = null;
    L20:
        th = move-exception;
        Result.Companion r113 = Result.Companion;
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L23
    L54:
        return;
    L44:
        return;
    L9:
        r103 = false;
    L45:
        th = move-exception;
        throw th;
    }

    public final boolean b() {
        Object r100 = this.f35988c;
        monitor-enter(r100);
        boolean r101 = this.f35991f;     // Catch: Throwable -> L7
        monitor-exit(r100);
        return r101;
    L7:
        th = move-exception;
        throw th;
    }

    public LocationUpdateManager(e3.d r100) {
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        this.f35986a = new WeakReference(r100);
        this.f35987b = UUID.randomUUID().toString();
        this.f35988c = new Object();
        this.f35989d = UpdateState.IDLE;
    }

    public final boolean c(int r100) {
        Object r101 = this.f35988c;
        monitor-enter(r101);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (this.f35989d == UpdateState.STARTING) goto L7;
    L11:
        boolean r102 = false;
    L12:
        monitor-exit(r101);
        return r102;
    L7:
        if (this.f35990e != r100) goto L11;
        if (this.f35991f == true) goto L11;
        r102 = true;
        goto L12
    }

    public final void d(int r100) {
        Object r101 = this.f35988c;
        monitor-enter(r101);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (this.f35989d == UpdateState.STARTING) goto L7;
    L9:
        Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L12
        monitor-exit(r101);
        return;
    L7:
        if (this.f35990e != r100) goto L9;
        this.f35989d = UpdateState.IDLE;     // Catch: Throwable -> L12
        goto L9
    }
}
