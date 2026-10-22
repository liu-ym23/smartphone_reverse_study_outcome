package com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.topcontrolbar.view;

import com.bytedance.android.livesdk.ktvimpl.realtimechorus.video.VideoChorusDataContext;
import io.reactivex.functions.Consumer;
import java.util.List;

/* JADX INFO: loaded from: classes10.dex */
public final class n<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ VideoChorusTopBarControlContainer f144203a;

    public n(VideoChorusTopBarControlContainer r100) {
        this.f144203a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        List r101 = (List) r100;
        VideoChorusTopBarControlContainer r102 = this.f144203a;
        com.bytedance.android.livesdk.ktvimpl.crossplatform.player.c r103 = VideoChorusDataContext.Companion.a();
        if (r103 == null) goto L5;
        jd2.c r104 = r103.f();
    L6:
        int r105 = VideoChorusTopBarControlContainer.f144187s;
        r102.j(r104);
        return;
    L5:
        r104 = null;
        goto L6
    }
}
