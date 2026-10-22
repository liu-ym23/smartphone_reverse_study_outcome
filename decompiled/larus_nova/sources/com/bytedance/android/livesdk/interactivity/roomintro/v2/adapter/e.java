package com.bytedance.android.livesdk.interactivity.roomintro.v2.adapter;

import android.text.Editable;
import android.text.TextWatcher;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes9.dex */
public final class e implements TextWatcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f140612a;

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable r100) {
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence r100, int r101, int r102, int r103) {
    }

    public e(a r100) {
        this.f140612a = r100;
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence r100, int r101, int r102, int r103) {
        int r104 = this.f140612a.b();
        if (r100 != null) goto L5;
    L8:
        boolean r105 = true;
    L9:
        if (r105 == false) goto L11;
        return;
    L11:
        if (r100.length() > r104) goto L13;
        return;
    L13:
        if ((r100 instanceof Editable) == true) goto L15;
        CharSequence r106 = null;
    L16:
        Editable r107 = (Editable) r106;
        if (r107 == null) goto L19;
        r107.delete(r104, r100.length());
    L19:
        f2.c(s1.C(R.string.ttlive_live_room_intro_update_max_v2, new Object[]{Integer.valueOf(r104)}), 0);
        return;
    L15:
        r106 = r100;
        goto L16
    L5:
        if (r100.length() == 0) goto L8;
        r105 = false;
        goto L9
    }
}
