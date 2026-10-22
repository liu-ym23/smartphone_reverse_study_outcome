package com.bytedance.android.livesdk.chatroom.roommanage.manage.bantalk;

import io.reactivex.functions.Consumer;
import java.util.List;
import kotlin.collections.CollectionsKt;
import me.drakeet.multitype.Items;

/* JADX INFO: loaded from: classes7.dex */
public final class g<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f111440a;

    public g(f r100) {
        this.f111440a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        dd2.a r101 = (dd2.a) r100;
        f r102 = this.f111440a;
        r102.f111430e = false;
        r102.f111436k.setLoadingMore(false);
        List<dd2.e> r103 = ((dd2.b) r101.extra).opStructList;
        if (r103 != null) goto L5;
        r103 = CollectionsKt.emptyList();
    L5:
        Items r104 = new Items();
        r104.addAll(r103);
        dd2.b r105 = (dd2.b) r101.extra;
        if (r105 != null) goto L8;
    L9:
        r104.add(new com.bytedance.android.livesdk.chatroom.roommanage.common.e());
    L10:
        this.f111440a.f111436k.c(r104);
        f r106 = this.f111440a;
        r106.f111431f++;
        R r107 = r101.extra;
        if (r107 != 0) goto L13;
    L15:
        r106.f111436k.e();
        return;
    L13:
        if (r107.hasMore != true) goto L15;
        r106.f111436k.d();
        return;
    L8:
        if (r105.hasMore == true) goto L10;
        goto L9
    }
}
