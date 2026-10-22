package com.bytedance.android.livesdk.chatroom.tetris.portrait;

import android.view.View;
import com.bytedance.android.livesdkapi.imagerecognition.ImageRecognitionButton;

/* JADX INFO: loaded from: classes7.dex */
public final class b implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ImageRecognitionButton f111783a;

    public b(ImageRecognitionButton r100) {
        this.f111783a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        this.f111783a.onClick(r100);
    }
}
