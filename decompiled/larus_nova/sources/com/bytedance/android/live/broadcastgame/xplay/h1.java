package com.bytedance.android.live.broadcastgame.xplay;

import com.byted.cast.linkcommon.cybergarage.upnp.RootDescription;
import io.reactivex.Completable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class h1 extends k {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f62171c;

    @Override // com.bytedance.android.live.broadcastgame.xplay.j1
    public final String getName() {
        return this.f62171c;
    }

    @Override // com.bytedance.android.live.broadcastgame.xplay.k
    public final Completable b(Collection<? extends l1> r100) {
        Intrinsics.checkNotNullParameter(r100, "components");
        ArrayList r101 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r100, 10));
        Iterator<T> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L7;
        r101.add(((l1) r102.next()).a());
        goto L4
    L7:
        return Completable.concat(r101);
    }

    public h1(List r100, Function2 r101) {
        Intrinsics.checkNotNullParameter(r100, "tasks");
        Intrinsics.checkNotNullParameter(RootDescription.ROOT_ELEMENT, "name");
        super(r100, r101);
        this.f62171c = RootDescription.ROOT_ELEMENT;
    }
}
