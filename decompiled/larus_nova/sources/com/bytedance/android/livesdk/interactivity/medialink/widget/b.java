package com.bytedance.android.livesdk.interactivity.medialink.widget;

import com.bytedance.android.live.liveinteract.multianchor.model.AnchorLinkUser;
import com.bytedance.android.live.network.response.Response;
import io.reactivex.functions.Consumer;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class b<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MediaLinkControlPresenter f138527a;

    public b(MediaLinkControlPresenter r100) {
        this.f138527a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Response r101 = (Response) r100;
        Intrinsics.checkNotNullParameter(r101, "response");
        com.bytedance.android.livesdk.message.linker.a r102 = (com.bytedance.android.livesdk.message.linker.a) r101.data;
        if (r102 == null) goto L16;
        List<AnchorLinkUser> r103 = r102.b();
        if (r103 != null) goto L7;
        return;
    L7:
        if (r103.size() < 2) goto L9;
        boolean r104 = true;
    L10:
        if (r104 == true) goto L13;
        r103 = null;
    L13:
        if (r103 == null) goto L18;
        ((MediaLinkControlPresenter.IView) this.f138527a.f531633a).OF();
        return;
    L18:
        return;
    L9:
        r104 = false;
        goto L10
    }
}
