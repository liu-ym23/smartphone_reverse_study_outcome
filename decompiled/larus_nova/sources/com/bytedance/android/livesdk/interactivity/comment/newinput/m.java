package com.bytedance.android.livesdk.interactivity.comment.newinput;

import android.graphics.Outline;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewOutlineProvider;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes9.dex */
public final class m implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OGCFixedInputDialog f135531a;

    public static final class a extends ViewOutlineProvider {
        public a() {
        }

        @Override // android.view.ViewOutlineProvider
        public final void getOutline(View r100, Outline r101) {
            if (r100 == null) goto L5;
            int r102 = r100.getWidth();
        L6:
            if (r100 == null) goto L8;
            int r103 = r100.getHeight();
        L9:
            Rect r104 = new Rect(0, 0, r102, r103);
            if (r101 == null) goto L13;
            r101.setRoundRect(r104, UtilityKotlinExtentionsKt.h(12));
            return;
        L13:
            return;
        L8:
            r103 = 0;
            goto L9
        L5:
            r102 = 0;
            goto L6
        }
    }

    public m(OGCFixedInputDialog r100) {
        this.f135531a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        View r100 = this.f135531a.f135359v;     // Catch: Throwable -> L9
        if (r100 == null) goto L5;
        r100.setOutlineProvider(new a());     // Catch: Throwable -> L9
    L5:
        View r101 = this.f135531a.f135359v;     // Catch: Throwable -> L9
        if (r101 == null) goto L12;
        r101.setClipToOutline(true);     // Catch: Throwable -> L9
        return;
    L12:
        return;
    L9:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L16;
        throw th;
    }
}
