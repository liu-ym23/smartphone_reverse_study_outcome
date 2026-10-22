package com.bytedance.android.livesdk.ktvimpl.base.lyrics;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class c<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ KtvRoomLyricHolder f143161a;

    public c(KtvRoomLyricHolder r100) {
        this.f143161a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Boolean r101 = (Boolean) r100;
        String r102 = bb0.b.b().concat("-lyric");
        ALogger.i(r102, ("currentUserIsSinger:" + r101) + ", invoke class :KtvRoomLyricHolder");
        this.f143161a.f143131e = Intrinsics.areEqual(r101, Boolean.TRUE);
        KtvRoomLyricHolder r103 = this.f143161a;
        if (r103.f143132f == true) goto L6;
        r103.a();
        return;
    }
}
