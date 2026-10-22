package com.bytedance.android.livesdk.gamesticker.hok;

import android.graphics.drawable.Animatable;
import android.net.Uri;
import android.view.View;
import com.bytedance.android.live.core.log.ALogger;
import df6.o;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class f implements hf6.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f125605a;

    @Override // hf6.f
    public final void onComplete(Uri r100, View r101, o r102, Animatable r103) {
    }

    @Override // hf6.f
    public final void onIntermediateImageSet(Uri r100, o r101) {
    }

    @Override // hf6.f
    public final void onRelease(Uri r100) {
    }

    @Override // hf6.f
    public final void onStart(Uri r100, View r101) {
    }

    public f(String r100) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        this.f125605a = r100;
    }

    @Override // hf6.f
    public final void onIntermediateImageFailed(Uri r100, Throwable r101) {
        StringBuilder r102 = new StringBuilder("l");
        r102.append(this.f125605a);
        r102.append(" load icon ");
        r102.append(r100);
        r102.append(" onIntermediateImageFailed ");
        if (r101 == null) goto L5;
        String r103 = r101.getMessage();
    L6:
        r102.append(r103);
        ALogger.e("GameStickerService", r102.toString());
        return;
    L5:
        r103 = null;
        goto L6
    }

    @Override // hf6.f
    public final void onFailed(Uri r100, View r101, Throwable r102) {
        StringBuilder r103 = new StringBuilder();
        r103.append(this.f125605a);
        r103.append(" load icon ");
        r103.append(r100);
        r103.append(" onFailed ");
        if (r102 == null) goto L5;
        String r104 = r102.getMessage();
    L6:
        r103.append(r104);
        ALogger.e("GameStickerService", r103.toString());
        return;
    L5:
        r104 = null;
        goto L6
    }
}
