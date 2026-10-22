package com.bytedance.android.gamecp.common.ui.popup.manager;

import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class LivePopupInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.android.gamecp.common.utils.mvvm.c<State> f57026a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.android.gamecp.common.utils.mvvm.c f57027b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f57028c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f57029d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final LivePopupWindow f57030e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final b f57031f;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001J\u000e\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0000R\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/gamecp/common/ui/popup/manager/LivePopupInfo$State;", "", PickerReporterConstants.KEY.TARGET, "", "isAtLeast", "", "value", "I", "getValue", "()I", "WAITING", "SHOWING", "DISMISSED", "gamecp-common_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum State extends Enum<State> {
        public static final State DISMISSED = null;
        public static final State SHOWING = null;
        public static final State WAITING = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ State[] f57032a = null;
        private final int value;

        static {
            State r100 = new State("WAITING", 0, 0);
            WAITING = r100;
            State r101 = new State("SHOWING", 1, 1);
            SHOWING = r101;
            State r102 = new State("DISMISSED", 2, 2);
            DISMISSED = r102;
            f57032a = new State[]{r100, r101, r102};
        }

        public static State valueOf(String r100) {
            return (State) r27.a.a(State.class, r100);
        }

        public static State[] values() {
            return (State[]) f57032a.clone();
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

    /* JADX WARN: Type inference failed for: r1v2, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void a(State r100) {
        Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
        if (this.f57026a.f57242a.isAtLeast(r100) == false) goto L5;
        return;
    L5:
        com.bytedance.android.gamecp.common.utils.mvvm.c<State> r101 = this.f57026a;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "input");
        ?? r102 = r101.f57243b.invoke(r101.f57242a, r100);
        if (r102 == 0) goto L8;
        r101.f57242a = r102;
        r101.f57244c.onNext(r102);
    L8:
        int r103 = d.f57045a[r100.ordinal()];
        if (r103 != 1) goto L11;
        this.f57030e.b(this.f57031f);
        return;
    L11:
        if (r103 != 2) goto L13;
        return;
    L13:
        if (r103 == 3) goto L16;
        return;
    L16:
        if (this.f57030e.isShowing() == false) goto L21;
        this.f57030e.a();
        return;
    }

    public LivePopupInfo(LivePopupWindow r100, b r101) {
        Intrinsics.checkNotNullParameter(r100, "popup");
        Intrinsics.checkNotNullParameter(r101, "params");
        this.f57030e = r100;
        this.f57031f = r101;
        com.bytedance.android.gamecp.common.utils.mvvm.c<State> r102 = new com.bytedance.android.gamecp.common.utils.mvvm.c(State.WAITING);
        this.f57026a = r102;
        this.f57027b = r102;
        long r103 = r100.f57035c;
        if (r103 > 0) goto L6;
        r103 = 0;
    L6:
        this.f57028c = r103;
        this.f57029d = r100.f57034b;
    }
}
