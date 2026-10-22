package com.bytedance.android.live.profit.taskcenter.panel.model;

import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.profit.taskcenter.b;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.lark.utils.statistics.PerfLog;
import fv0.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class PanelInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PropertyOwner<State> f89042a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PropertyOwner f89043b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f89044c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Uri f89045d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Bundle f89046e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f89047f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final a f89048g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f89049h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final b f89050i;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001J\u000e\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0000R\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/live/profit/taskcenter/panel/model/PanelInfo$State;", "", PickerReporterConstants.KEY.TARGET, "", "isAtLeast", "", "value", "I", "getValue", "()I", "WAITING", "READY", "SHOWING", "DISMISSED", "liveprofit-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum State extends Enum<State> {
        public static final State DISMISSED = null;
        public static final State READY = null;
        public static final State SHOWING = null;
        public static final State WAITING = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ State[] f89051a = null;
        private final int value;

        static {
            State r100 = new State("WAITING", 0, 0);
            WAITING = r100;
            State r101 = new State("READY", 1, 1);
            READY = r101;
            State r102 = new State("SHOWING", 2, 2);
            SHOWING = r102;
            State r103 = new State("DISMISSED", 3, 3);
            DISMISSED = r103;
            f89051a = new State[]{r100, r101, r102, r103};
        }

        public static State valueOf(String r100) {
            return (State) r27.a.a(State.class, r100);
        }

        public static State[] values() {
            return (State[]) f89051a.clone();
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

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof PanelInfo) == false) goto L20;
        PanelInfo r101 = (PanelInfo) r100;
        if (Intrinsics.areEqual(this.f89044c, r101.f89044c) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f89045d, r101.f89045d) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f89046e, r101.f89046e) == true) goto L12;
        return false;
    L12:
        if (this.f89047f == r101.f89047f) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f89048g, r101.f89048g) == true) goto L16;
        return false;
    L16:
        if (this.f89049h == r101.f89049h) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f89050i, r101.f89050i) == true) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v12, types: [int] */
    /* JADX WARN: Type inference failed for: r2v11, types: [int] */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v17 */
    public final int hashCode() {
        Context r100 = this.f89044c;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Uri r104 = this.f89045d;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Bundle r107 = this.f89046e;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (((r106 + r108) * 31) + this.f89047f) * 31;
        a r110 = this.f89048g;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        boolean r113 = this.f89049h;
        ?? r114 = r113;
        if (r113 == false) goto L21;
        r114 = 1;
    L21:
        int r115 = (r112 + r114) * 31;
        b r116 = this.f89050i;
        if (r116 == null) goto L25;
        r101 = r116.hashCode();
    L25:
        return r115 + r101;
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "PanelInfo(context=" + this.f89044c + ", uri=" + this.f89045d + ", bundle=" + this.f89046e + ", priorityLevel=" + this.f89047f + ", frequencyParams=" + this.f89048g + ", needCheckDialogAndTip=" + this.f89049h + ", callback=" + this.f89050i + ")";
    }

    public final Context getContext() {
        return this.f89044c;
    }

    public final void a(State r100, DialogInterface r101) {
        Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
        ALogger.i("TaskPanelManager", "PanelInfo  moveToState  target=" + r100 + "  dialog=" + r101);
        if (this.f89042a.f64752a.isAtLeast(r100) == false) goto L5;
        return;
    L5:
        this.f89042a.a(r100);
        int r102 = fv0.b.f478953a[r100.ordinal()];
        if (r102 != 1) goto L8;
        this.f89050i.waiting();
        return;
    L8:
        if (r102 != 2) goto L10;
        this.f89050i.readyToShow();
        return;
    L10:
        if (r102 != 3) goto L12;
        this.f89050i.showing(r101);
        return;
    L12:
        if (r102 != 4) goto L22;
        this.f89050i.onDismiss(r101);
        return;
    }

    public PanelInfo(Context r100, Uri r101, Bundle r102, int r103, a r104, b r105) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "uri");
        Intrinsics.checkNotNullParameter(r102, "bundle");
        Intrinsics.checkNotNullParameter(r104, "frequencyParams");
        Intrinsics.checkNotNullParameter(r105, "callback");
        this.f89044c = r100;
        this.f89045d = r101;
        this.f89046e = r102;
        this.f89047f = r103;
        this.f89048g = r104;
        this.f89049h = false;
        this.f89050i = r105;
        PropertyOwner<State> r106 = new PropertyOwner(State.WAITING);
        this.f89042a = r106;
        this.f89043b = r106;
    }
}
