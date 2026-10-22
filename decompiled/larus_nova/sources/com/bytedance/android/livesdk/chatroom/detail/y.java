package com.bytedance.android.livesdk.chatroom.detail;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.keva.Keva;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import java.util.concurrent.Callable;
import kotlin.Unit;

/* JADX INFO: loaded from: classes7.dex */
public final class y<V> implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Keva f105735a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f105736b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f105737c;

    public y(Keva r100, Object r101) {
        this.f105735a = r100;
        this.f105736b = r101;
        this.f105737c = "live_room_duration_retrieve_logger_key";
    }

    @Override // java.util.concurrent.Callable
    public final void call() {
        if (this.f105736b != null) goto L5;
        this.f105735a.erase(this.f105737c);
        return;
    L5:
        this.f105735a.storeString(this.f105737c, GsonProtectorUtils.toJson(GsonHelper.get(), this.f105736b));
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Object call() {
        call();
        return Unit.INSTANCE;
    }
}
