package com.bytedance.android.livesdk.gamecp.utils;

import com.bytedance.android.live.room.api.panel.PanelName;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f125478a = 0;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.gamecp.utils.a$a, reason: collision with other inner class name */
    public static final class C2014a implements com.bytedance.android.live.room.api.panel.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f125479a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f125480b;

        @Override // com.bytedance.android.live.room.api.panel.b
        public final PanelName getPanelName() {
            return PanelName.GameCp;
        }

        @Override // com.bytedance.android.live.room.api.panel.b
        public final int getUnionId() {
            return this.f125480b;
        }

        public C2014a(int r100, int r101) {
            this.f125479a = r100;
            this.f125480b = r101;
        }

        @Override // com.bytedance.android.live.room.api.panel.b
        public final void a(Function1<? super Integer, Unit> r100, Function1<? super String, Unit> r101) {
            Intrinsics.checkNotNullParameter(r100, "continueAction");
            Intrinsics.checkNotNullParameter(r101, "stopAction");
            r100.invoke(Integer.valueOf(this.f125479a));
        }
    }

    static {
    }
}
