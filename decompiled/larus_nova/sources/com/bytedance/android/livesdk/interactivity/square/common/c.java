package com.bytedance.android.livesdk.interactivity.square.common;

import android.view.View;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.MainThreadPostUtils;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.interactivity.service.messagelist.m;
import com.larus.nova.R;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes9.dex */
public final class c<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BaseModelListScrollManager f141131a;

    public c(BaseModelListScrollManager r100) {
        this.f141131a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        BaseModelListScrollManager r101 = this.f141131a;
        int r102 = ((Integer) r100).intValue();
        if (r102 < 200) goto L6;
        r101.getClass();
        r101.d(BaseModelListScrollManager.ScrollState.AutoScroll);
    L6:
        if (r102 > 0) goto L8;
    L11:
        boolean r103 = true;
    L12:
        if (r103 == false) goto L14;
    L37:
        r101.f141123k.setVisibility(8);
        r101.f141124l.setText("");
        return;
    L14:
        if (r101.f141116d == false) goto L16;
        boolean r104 = true;
    L28:
        if ((!r104) == true) goto L37;
        TextView r105 = r101.f141124l;
        Object[] r106 = new Object[1];
        if (r102 > 99) goto L33;
        String r107 = String.valueOf(r102);
    L34:
        r106[0] = r107;
        r105.setText(s1.C(R.string.ttlive_auto_scroll_message_list_hint, r106));
        if (r101.f141123k.getVisibility() == 0) goto L42;
        MainThreadPostUtils.b(new e(r101));
        return;
    L42:
        return;
    L33:
        r107 = "99+";
        goto L34
    L16:
        int r108 = r101.f141117e.getItemCount();
        int r109 = 0;
        int r110 = 0;
    L17:
        if (r109 >= r108) goto L23;
        View r111 = r101.f141117e.findViewByPosition(r109);
        if (r111 == null) goto L21;
        r110 = (r110 + r111.getHeight()) + m.f140902g;
    L21:
        r109 = r109 + 1;
        goto L17
    L23:
        if (r110 < r101.f141122j.getHeight()) goto L25;
        r104 = true;
    L26:
        r101.f141116d = r104;
        goto L28
    L25:
        r104 = false;
        goto L26
    L8:
        if (r101.f141113a == BaseModelListScrollManager.ScrollState.AutoScroll) goto L11;
        r103 = false;
        goto L12
    }
}
