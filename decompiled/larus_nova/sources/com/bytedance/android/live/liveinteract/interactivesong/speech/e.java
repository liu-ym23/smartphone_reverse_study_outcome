package com.bytedance.android.live.liveinteract.interactivesong.speech;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.interactivesong.impl.InteractiveSongContext;
import com.bytedance.android.livesdk.chatroom.viewmodel.i;
import com.bytedance.live.datacontext.n;
import fd2.v;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes46.dex */
public final class e<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f74183a;

    public e(boolean r100) {
        this.f74183a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        i r101 = (i) r100;
        InteractiveSongContext r102 = InteractiveSongContext.Companion.getContext();
        if (r102 == null) goto L7;
        n<v> r103 = r102.getLyricsRecognizer();
        if (r103 == null) goto L7;
        v r104 = r103.getValue();
    L8:
        int r105 = r101.f114793b;
        if (r105 != 27) goto L11;
        return;
    L11:
        if (r105 != 30) goto L13;
        return;
    L13:
        if (r105 == 26) goto L15;
    L16:
        ALogger.i("SpeechRecognitionProxy", "uiLayout Changed, uiLayout: " + r101.f114793b + ", stop recognize");
        if (r104 == null) goto L23;
        r104.i();
        return;
    L23:
        return;
    L15:
        if (this.f74183a == false) goto L16;
        return;
    L7:
        r104 = null;
        goto L8
    }
}
