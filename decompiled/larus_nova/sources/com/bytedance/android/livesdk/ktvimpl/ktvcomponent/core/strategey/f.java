package com.bytedance.android.livesdk.ktvimpl.ktvcomponent.core.strategey;

import com.bytedance.android.live.multilink.ktv.SongUniqueInfo;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class f<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ KtvComponentSingleBroadcastStrategy f144089a;

    public f(KtvComponentSingleBroadcastStrategy r100) {
        this.f144089a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        List r101 = (List) r100;
        boolean r102 = true;
        Object r103 = null;
        if (r101 == null) goto L18;
        ArrayList r104 = new ArrayList();
        Iterator<T> r105 = r101.iterator();
    L6:
        if (r105.hasNext() == false) goto L10;
        T r106 = r105.next();
        if ((!((SongUniqueInfo) r106).isPublic()) == false) goto L6;
        r104.add(r106);
        goto L6
    L10:
        Iterator r107 = r104.iterator();
    L12:
        if (r107.hasNext() == false) goto L16;
        Object r108 = r107.next();
        if (Intrinsics.areEqual(((SongUniqueInfo) r108).getUserId().toString(), gh0.a.c()) == false) goto L12;
        r103 = r108;
    L16:
        r103 = (SongUniqueInfo) r103;
    L18:
        if (r103 != null) goto L21;
        r102 = false;
    L21:
        if (r102 == true) goto L32;
        this.f144089a.f144058b = false;
        return;
    }
}
