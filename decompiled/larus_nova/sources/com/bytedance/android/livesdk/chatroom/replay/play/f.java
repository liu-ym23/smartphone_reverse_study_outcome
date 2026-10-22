package com.bytedance.android.livesdk.chatroom.replay.play;

import android.os.Bundle;
import com.bytedance.android.livesdkapi.depend.model.live.episode.Episode;
import kotlin.jvm.internal.Intrinsics;
import mq1.o;
import yr1.g;

/* JADX INFO: loaded from: classes7.dex */
public final class f implements o, com.bytedance.android.scope.o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final hq1.a f109512a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g f109513b;

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
    }

    @Override // mq1.o
    public final void T5(long r100) {
        this.f109512a.T5(r100);
    }

    @Override // mq1.o
    public final void onInputStateChange(boolean r100) {
        this.f109513b.J(r100);
    }

    public f(hq1.a r100, g r101) {
        Intrinsics.checkNotNullParameter(r100, "playFragment");
        Intrinsics.checkNotNullParameter(r101, "injectEventService");
        this.f109512a = r100;
        this.f109513b = r101;
    }

    @Override // mq1.o
    public final void a(long r100, String r110, Bundle r111) {
        this.f109512a.PD(r100, r110, r111, null, false, false);
    }

    @Override // mq1.o
    public final void h3(int r100, int r101, int r110, String r111, Object r112) {
        Intrinsics.checkNotNullParameter(r111, "source");
        this.f109512a.h3(r100, r101, r110, r111, r112);
    }

    @Override // mq1.o
    public final void Sa(Episode r110, String r111, String r112, String r113, String r114, String r115, String r116, boolean r117) {
        this.f109512a.Sa(r110, r111, r112, r113, r114, r115, r116, r117);
    }
}
