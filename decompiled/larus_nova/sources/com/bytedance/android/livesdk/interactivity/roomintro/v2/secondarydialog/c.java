package com.bytedance.android.livesdk.interactivity.roomintro.v2.secondarydialog;

import android.widget.TextView;
import com.bytedance.android.live.core.utils.s1;
import com.larus.nova.R;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes9.dex */
public final class c<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RoomIntroLabelSelectDialog f140673a;

    public c(RoomIntroLabelSelectDialog r100) {
        this.f140673a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Integer r101 = (Integer) r100;
        if (r101 == null) goto L5;
        int r102 = r101.intValue();
    L6:
        TextView r103 = this.f140673a.f140667g;
        if (r103 == null) goto L10;
        r103.setText(s1.C(R.string.ttlive_live_room_intro_select_label_dialog_title, new Object[]{Integer.valueOf(r102), 3}));
        return;
    L10:
        return;
    L5:
        r102 = 0;
        goto L6
    }
}
