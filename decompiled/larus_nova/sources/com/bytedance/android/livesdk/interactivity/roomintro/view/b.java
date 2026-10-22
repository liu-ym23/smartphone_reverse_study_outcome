package com.bytedance.android.livesdk.interactivity.roomintro.view;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.core.log.ALogger;
import com.larus.nova.R;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes9.dex */
public final class b<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FragmentActivity f140720a;

    public b(FragmentActivity r100) {
        this.f140720a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        String r101 = rm3.c.f538539a;
        rm3.c.f(this.f140720a, R.string.ttlive_user_rank_no_network_tip, false, 28);
        ALogger.stacktrace(6, "com.bytedance.android.livesdk.interactivity.roomintro.view.RoomIntroDialog", ((Throwable) r100).getStackTrace());
    }
}
