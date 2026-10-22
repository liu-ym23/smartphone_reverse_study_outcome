package com.bytedance.android.live.liveinteract.plantform.datamerge.handler;

import com.bytedance.android.live.base.model.user.IBaseUser;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class p extends eh0.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f76477b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Boolean f76478c;

    @Override // eh0.c
    public final void attach() {
        this.f76477b = true;
    }

    @Override // eh0.c
    public final void detach() {
        this.f76477b = false;
    }

    public p() {
    }

    @Override // eh0.a, eh0.c
    public final h.a a(List<ch0.e> r110) {
        Intrinsics.checkNotNullParameter(r110, "oldMergeDataList");
        List<ch0.e> r111 = r110;
        ArrayList r100 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r111, 10));
        Iterator<T> r112 = r111.iterator();
        ch0.e r101 = null;
    L4:
        if (r112.hasNext() == false) goto L18;
        ch0.e r102 = (ch0.e) r112.next();
        HashMap r103 = new HashMap(r102.f23727d);
        Boolean r104 = this.f76478c;
        if (r104 == null) goto L8;
        r103.put("EXT_KEY_UPDATE_INTERACT_SONG_SHOW_GOLDEN_MIC", Boolean.valueOf(r104.booleanValue()));
    L8:
        ch0.e r105 = ch0.e.a(r102, null, null, null, r103, 7);
        IBaseUser r106 = r105.f23724a.getUser();
        if (r106 == null) goto L11;
        String r107 = r106.getIdString();
    L13:
        if (Intrinsics.areEqual(r107, gh0.a.c()) == false) goto L16;
        if (r105 == r102) goto L16;
        r101 = r105;
    L16:
        r100.add(r105);
        goto L4
    L11:
        r107 = null;
        goto L13
    L18:
        return new h.a(true, r100, r101);
    }
}
