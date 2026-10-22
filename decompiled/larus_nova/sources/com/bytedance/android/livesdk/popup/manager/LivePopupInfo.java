package com.bytedance.android.livesdk.popup.manager;

import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class LivePopupInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PropertyOwner<State> f156277a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PropertyOwner f156278b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f156279c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f156280d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f156281e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final LivePopupWindow f156282f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final d f156283g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final c f156284h;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001J\u000e\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0000R\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdk/popup/manager/LivePopupInfo$State;", "", PickerReporterConstants.KEY.TARGET, "", "isAtLeast", "", "value", "I", "getValue", "()I", "WAITING", "SHOWING", "DISMISSED", "livecommonui_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum State extends Enum<State> {
        public static final State DISMISSED = null;
        public static final State SHOWING = null;
        public static final State WAITING = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ State[] f156285a = null;
        private final int value;

        static {
            State r100 = new State("WAITING", 0, 0);
            WAITING = r100;
            State r101 = new State("SHOWING", 1, 1);
            SHOWING = r101;
            State r102 = new State("DISMISSED", 2, 2);
            DISMISSED = r102;
            f156285a = new State[]{r100, r101, r102};
        }

        public static State valueOf(String r100) {
            return (State) r27.a.a(State.class, r100);
        }

        public static State[] values() {
            return (State[]) f156285a.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public final boolean isAtLeast(State r100) {
            Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
            if (this.value < r100.value) goto L5;
            return true;
        L5:
            return false;
        }

        public State(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public final void a(State r100) {
        Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
        if (this.f156277a.f64752a.isAtLeast(r100) == false) goto L5;
        return;
    L5:
        this.f156277a.a(r100);
        int r101 = f.f156304a[r100.ordinal()];
        if (r101 != 1) goto L8;
        this.f156282f.b(this.f156283g);
        c r102 = this.f156284h;
        if (r102 == null) goto L29;
        r102.b();
        return;
    L29:
        return;
    L8:
        if (r101 != 2) goto L10;
        c r103 = this.f156284h;
        if (r103 == null) goto L27;
        r103.waiting();
        return;
    L27:
        return;
    L10:
        if (r101 != 3) goto L30;
        c r104 = this.f156284h;
        if (r104 == null) goto L16;
        r104.a();
    L16:
        if (this.f156282f.isShowing() == false) goto L25;
        this.f156282f.a();
        return;
    L25:
        return;
    }

    public LivePopupInfo(LivePopupWindow r100, d r101, c r102) {
        Intrinsics.checkNotNullParameter(r100, "popup");
        Intrinsics.checkNotNullParameter(r101, "params");
        this.f156282f = r100;
        this.f156283g = r101;
        this.f156284h = r102;
        PropertyOwner<State> r103 = new PropertyOwner(State.WAITING);
        this.f156277a = r103;
        this.f156278b = r103;
        long r104 = r100.f156289d;
        if (r104 > 0) goto L6;
        r104 = 0;
    L6:
        this.f156279c = r104;
        this.f156280d = r100.f156288c;
        this.f156281e = r100.f156287b;
    }
}
