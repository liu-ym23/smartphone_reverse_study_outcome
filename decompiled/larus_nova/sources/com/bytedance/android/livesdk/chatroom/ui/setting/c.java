package com.bytedance.android.livesdk.chatroom.ui.setting;

import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.core.utils.f2;
import io.reactivex.functions.Consumer;
import me.drakeet.multitype.MultiTypeAdapter;

/* JADX INFO: loaded from: classes8.dex */
public final class c<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f114100a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f114101b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f114102c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f114103d;

    public c(a r100, boolean r101, long r102, String r103) {
        this.f114100a = r100;
        this.f114101b = r101;
        this.f114102c = r102;
        this.f114103d = r103;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        if ((r101 instanceof ApiServerException) == false) goto L5;
        f2.c(((ApiServerException) r101).getPrompt(), 0);
    L5:
        MultiTypeAdapter r102 = this.f114100a.f114094q.listAdapter();
        if (r102 == null) goto L10;
        int r103 = mx.l.f516147o;
        mx.l.a.b(r102, this.f114100a, !this.f114101b);
        a.g(this.f114100a, this.f114102c, this.f114103d, this.f114101b, false);
        return;
    }
}
