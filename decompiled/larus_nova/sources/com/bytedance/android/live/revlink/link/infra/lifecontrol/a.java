package com.bytedance.android.live.revlink.link.infra.lifecontrol;

import com.bytedance.android.livesdk.revenue.service.message.d;
import com.bytedance.android.livesdk.revenue.service.room.c;
import com.bytedance.android.scope.o;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.jvm.internal.Intrinsics;
import u51.b;
import yz0.f;

/* JADX INFO: loaded from: classes47.dex */
public final class a implements o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PKLongBizHandler f98616a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f98617b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final f f98618c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final d f98619d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final b f98620e;

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.link.infra.lifecontrol.a$a, reason: collision with other inner class name */
    public static final class C1517a {
    }

    static {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
        PKLongBizHandler r100 = this.f98616a;
        if (r100 == null) goto L6;
        r100.a();
        return;
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
        PKLongBizHandler r100 = this.f98616a;
        if (r100 == null) goto L6;
        r100.f98610a.clear();
        return;
    }

    public a(c r100, f r101, d r102, b r103) {
        Intrinsics.checkNotNullParameter(r100, "revRoomService");
        Intrinsics.checkNotNullParameter(r101, "messageService");
        Intrinsics.checkNotNullParameter(r103, "infraScope");
        this.f98617b = r100;
        this.f98618c = r101;
        this.f98619d = r102;
        this.f98620e = r103;
        new CompositeDisposable();
        this.f98616a = new PKLongBizHandler(true, r101, r102, r100);
    }
}
