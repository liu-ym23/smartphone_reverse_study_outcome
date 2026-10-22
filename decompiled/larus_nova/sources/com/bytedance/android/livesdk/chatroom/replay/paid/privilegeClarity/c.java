package com.bytedance.android.livesdk.chatroom.replay.paid.privilegeClarity;

import com.bytedance.android.livesdkapi.depend.model.live.episode.VideoResolutionItem;
import com.bytedance.ies.sdk.widgets.KVData;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class c<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f109426a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ b f109427b;

    public c(e r100, o r101) {
        this.f109426a = r100;
        this.f109427b = r101;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        KVData r101 = (KVData) r100;
        if (r101 == null) goto L5;
        VideoResolutionItem r102 = (VideoResolutionItem) r101.getData();
    L6:
        if (r102 != null) goto L8;
    L12:
        e r103 = this.f109426a;
        r103.f109435f.removeObserver(r103.f109433d);
        e r104 = this.f109426a;
        r104.f109435f.removeObserver(r104.f109434e);
        return;
    L8:
        if (Intrinsics.areEqual(r102, this.f109426a.f109431b) == false) goto L12;
        b r105 = this.f109427b;
        if (r105 == null) goto L12;
        r105.b();
        goto L12
    L5:
        r102 = null;
        goto L6
    }
}
