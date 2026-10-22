package com.bytedance.applet.aibridge;

import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.larus.platform.api.l0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class m implements l0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f3.h<AbsSetMusicPlaybackTimeMethodIDL.b> f191194a;

    public m(f3.h<AbsSetMusicPlaybackTimeMethodIDL.b> r100) {
        this.f191194a = r100;
    }

    @Override // com.larus.platform.api.l0
    public final void onCompletion(boolean r100) {
        f3.h<AbsSetMusicPlaybackTimeMethodIDL.b> r101 = this.f191194a;
        Intrinsics.checkNotNullParameter(AbsSetMusicPlaybackTimeMethodIDL.b.class, "<this>");
        f3.h.a.b(r101, (ResultModel) k3.c.a(AbsSetMusicPlaybackTimeMethodIDL.b.class));
    }
}
