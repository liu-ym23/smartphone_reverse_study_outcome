package com.bytedance.android.livesdk.chatroom.end.dynamic;

import android.graphics.Bitmap;
import com.bytedance.android.livesdk.chatroom.backtrack.LiveVideoPreviewView;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes7.dex */
public final class f<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveVideoPreviewView f106050a;

    public f(LiveVideoPreviewView r100) {
        this.f106050a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Bitmap r101 = (Bitmap) r100;
        if (r101 == null) goto L6;
        this.f106050a.setFirstFrameBitmap(r101);
        return;
    }
}
