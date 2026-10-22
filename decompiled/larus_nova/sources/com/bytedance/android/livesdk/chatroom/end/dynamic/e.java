package com.bytedance.android.livesdk.chatroom.end.dynamic;

import android.view.ViewGroup;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.chatroom.backtrack.LiveVideoPreviewView;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes7.dex */
public final class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveVideoPreviewView f106048a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ float f106049b;

    public e(LiveVideoPreviewView r100, float r101) {
        this.f106048a = r100;
        this.f106049b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        LiveVideoPreviewView r100 = this.f106048a;     // Catch: Throwable -> L10
        if (r100.getMeasuredWidth() > 0) goto L5;
    L7:
        int r101 = UtilityKotlinExtentionsKt.i(192);     // Catch: Throwable -> L10
    L8:
        ViewGroup.LayoutParams r102 = r100.f105163d.getLayoutParams();     // Catch: Throwable -> L10
        r102.height = r101;     // Catch: Throwable -> L10
        r102.width = -1;     // Catch: Throwable -> L10
        r100.f105163d.setLayoutParams(r102);     // Catch: Throwable -> L10
        return;
    L5:
        if (this.f106049b <= 0.0f) goto L7;
        r101 = (int) (this.f106048a.getMeasuredWidth() * this.f106049b);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L14;
        return;
    L14:
        throw th;
    }
}
