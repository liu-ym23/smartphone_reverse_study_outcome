package com.bytedance.android.livesdk.chatroom.indicator.shortterm;

import android.view.View;
import com.bytedance.android.livesdkapi.sti.framework.ITempShortTouchService;

/* JADX INFO: loaded from: classes7.dex */
public final class a implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f106551a;

    public a(b r100) {
        this.f106551a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        ITempShortTouchService.DefaultImpls.registerShowTempState$default(this.f106551a, 1, 0, 2, null);
    }
}
