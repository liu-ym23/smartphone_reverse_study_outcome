package com.bytedance.android.livesdk.microom.enhance;

import android.view.View;
import com.larus.nova.R;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes11.dex */
public final class c<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i f153842a;

    public c(i r100) {
        this.f153842a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        l r101 = (l) r100;
        if (r101 == null) goto L22;
        boolean r102 = r101.f153871b;
        if ((!r102) == true) goto L7;
        return;
    L7:
        if (r101.f153872c == false) goto L9;
    L13:
        boolean r103 = true;
    L14:
        if (r103 != true) goto L18;
        View r104 = this.f153842a.f153852a;
        if (r104 == null) goto L24;
        r104.setBackgroundResource(R.drawable.ttlive_bg_mic_room_anchor_follow_new);
        return;
    L24:
        return;
    L18:
        View r105 = this.f153842a.f153852a;
        if (r105 == null) goto L26;
        r105.setBackgroundResource(R.drawable.ttlive_mic_room_follow_bg_retangle);
        return;
    L26:
        return;
    L9:
        if (r101.f153870a == false) goto L12;
        if (r102 == false) goto L13;
    L12:
        r103 = false;
        goto L14
    }
}
