package com.bytedance.android.gamecp.base.gamedetail;

import android.content.Context;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class NewReverseConfig implements s0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final State f51532a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final s0 f51533b;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/gamecp/base/gamedetail/NewReverseConfig$State;", "", "RESERVE", "CANCELRESERVE", "UNSUPPORT", "GAMEONLINE", "gamecp-base_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum State extends Enum<State> {
        public static final State CANCELRESERVE = null;
        public static final State GAMEONLINE = null;
        public static final State RESERVE = null;
        public static final State UNSUPPORT = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ State[] f51534a = null;

        static {
            State r100 = new State("RESERVE", 0);
            RESERVE = r100;
            State r101 = new State("CANCELRESERVE", 1);
            CANCELRESERVE = r101;
            State r102 = new State("UNSUPPORT", 2);
            UNSUPPORT = r102;
            State r103 = new State("GAMEONLINE", 3);
            GAMEONLINE = r103;
            f51534a = new State[]{r100, r101, r102, r103};
        }

        public static State valueOf(String r100) {
            return (State) r27.a.a(State.class, r100);
        }

        public static State[] values() {
            return (State[]) f51534a.clone();
        }

        public State(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Override // com.bytedance.android.gamecp.base.gamedetail.s0
    public final int a(Context r100) {
        return this.f51533b.a(r100);
    }

    @Override // com.bytedance.android.gamecp.base.gamedetail.s0
    public final int b(Context r100) {
        return this.f51533b.b(r100);
    }

    @Override // com.bytedance.android.gamecp.base.gamedetail.s0
    public final int c(Context r100) {
        return this.f51533b.c(r100);
    }

    @Override // com.bytedance.android.gamecp.base.gamedetail.s0
    public final String d(Context r100) {
        return this.f51533b.d(r100);
    }

    @Override // com.bytedance.android.gamecp.base.gamedetail.s0
    public final String e(Context r100) {
        return this.f51533b.e(r100);
    }

    @Override // com.bytedance.android.gamecp.base.gamedetail.s0
    public final int f(Context r100) {
        return this.f51533b.f(r100);
    }

    public NewReverseConfig(State r100, s0 r101) {
        Intrinsics.checkNotNullParameter(r100, "state");
        Intrinsics.checkNotNullParameter(r101, "uiConfig");
        this.f51532a = r100;
        this.f51533b = r101;
    }
}
