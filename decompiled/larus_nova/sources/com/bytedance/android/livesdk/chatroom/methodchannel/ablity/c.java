package com.bytedance.android.livesdk.chatroom.methodchannel.ablity;

import com.bytedance.android.live.network.response.ListResponse;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes7.dex */
public final class c<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Disposable f106840a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ sy.a f106841b;

    public c(Disposable r100, sy.a r101) {
        this.f106840a = r100;
        this.f106841b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        this.f106840a.dispose();
        sy.a r101 = this.f106841b;
        List<T> r102 = ((ListResponse) r100).data;
        if (r102 == null) goto L9;
        ng2.f r103 = (ng2.f) CollectionsKt.firstOrNull(r102);
        if (r103 == null) goto L9;
        boolean r104 = true;
        if (r103.alive != true) goto L9;
    L10:
        r101.invoke(Boolean.valueOf(r104));
        return;
    L9:
        r104 = false;
        goto L10
    }
}
