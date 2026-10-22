package com.bytedance.android.livesdk.gamesticker.hok.anim;

import com.bytedance.android.livesdk.gamesticker.hok.HokGameStickerView;
import java.util.LinkedList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedList<a> f125582a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d f125583b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final g f125584c;

    public final void a(a r100) {
        Intrinsics.checkNotNullParameter(r100, "task");
        g r101 = this.f125584c;
        Intrinsics.checkNotNullParameter(r101, "viewGetter");
        r100.f125577c = r101;
        d r102 = this.f125583b;
        Intrinsics.checkNotNullParameter(r102, "listener");
        r100.f125576b = r102;
        this.f125582a.add(r100);
    }

    public e(HokGameStickerView.a r100, HokGameStickerView.b r101) {
        Intrinsics.checkNotNullParameter(r100, "taskListener");
        Intrinsics.checkNotNullParameter(r101, "viewGetter");
        this.f125583b = r100;
        this.f125584c = r101;
        this.f125582a = new LinkedList();
    }
}
