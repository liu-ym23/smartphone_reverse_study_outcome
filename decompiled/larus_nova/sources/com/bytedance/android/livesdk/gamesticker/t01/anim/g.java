package com.bytedance.android.livesdk.gamesticker.t01.anim;

import com.bytedance.android.livesdk.gamesticker.t01.T01GameStickerView;
import java.util.LinkedList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedList<b> f125766a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f f125767b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final i f125768c;

    public final void a(b r100) {
        Intrinsics.checkNotNullParameter(r100, "task");
        i r101 = this.f125768c;
        Intrinsics.checkNotNullParameter(r101, "viewGetter");
        r100.f125759c = r101;
        f r102 = this.f125767b;
        Intrinsics.checkNotNullParameter(r102, "listener");
        r100.f125758b = r102;
        this.f125766a.add(r100);
    }

    public g(T01GameStickerView.a r100, T01GameStickerView.b r101) {
        Intrinsics.checkNotNullParameter(r100, "taskListener");
        Intrinsics.checkNotNullParameter(r101, "viewGetter");
        this.f125767b = r100;
        this.f125768c = r101;
        this.f125766a = new LinkedList();
    }
}
