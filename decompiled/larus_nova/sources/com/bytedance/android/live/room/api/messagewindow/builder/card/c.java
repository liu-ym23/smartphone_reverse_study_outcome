package com.bytedance.android.live.room.api.messagewindow.builder.card;

import com.bytedance.android.live.room.api.messagewindow.state.CardAction;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f98972a;

    public final void a() {
        b r100 = this.f98972a;
        r100.getClass();
        xs2.b.a().post(new z61.a(CardAction.DESTROY, r100));
    }

    public final void b() {
        b r100 = this.f98972a;
        r100.getClass();
        xs2.b.a().post(new z61.a(CardAction.DESTROY_WITHOUT_DESTROY, r100));
    }

    public c(b r100) {
        Intrinsics.checkNotNullParameter(r100, "commonCard");
        this.f98972a = r100;
    }

    public final void c(String r100) {
        b r101 = this.f98972a;
        r101.f98971g = r100;
        xs2.b.a().post(new z61.a(CardAction.REFRESH, r101));
    }
}
