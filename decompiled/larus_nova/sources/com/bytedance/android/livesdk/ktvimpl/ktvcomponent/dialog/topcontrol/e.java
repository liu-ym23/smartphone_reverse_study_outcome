package com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.topcontrol;

import android.widget.ImageView;
import com.bytedance.android.live.ktv.common.util.KtvUtilsKt;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomLyricsStateMachineConfig;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: classes10.dex */
public final class e<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f144256a;

    public e(f r100) {
        this.f144256a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        Boolean r101 = (Boolean) r100;
        if (r101 == null) goto L5;
        boolean r102 = r101.booleanValue();
    L6:
        com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c r103 = this.f144256a.f144261e;
        if (r103 == null) goto L11;
        KtvRoomLyricsStateMachineConfig.d r104 = r103.getCurState();
        if (r104 == null) goto L11;
        MusicPanel r105 = r104.b();
    L12:
        if (r105 != null) goto L14;
    L21:
        ImageView r106 = this.f144256a.f144257a;
        if (r106 == null) goto L24;
        r106.setAlpha(0.5f);
    L24:
        ImageView r107 = this.f144256a.f144257a;
        if (r107 == null) goto L27;
        r107.setTag(Boolean.FALSE);
    L27:
        this.f144256a.a(r102);
        return;
    L14:
        if (KtvUtilsKt.D(r105) != true) goto L21;
        ImageView r108 = this.f144256a.f144257a;
        if (r108 == null) goto L18;
        r108.setAlpha(1.0f);
    L18:
        ImageView r109 = this.f144256a.f144257a;
        if (r109 == null) goto L27;
        r109.setTag(Boolean.TRUE);
    L11:
        r105 = null;
        goto L12
    L5:
        r102 = false;
        goto L6
    }
}
