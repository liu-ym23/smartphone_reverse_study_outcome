package com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.callback;

import com.bytedance.android.live.ktv.common.tuningpanel.view.TuningPanelDialog;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.functions.Consumer;
import java.util.List;

/* JADX INFO: loaded from: classes10.dex */
public final class l<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Observer f143495a;

    public l(TuningPanelDialog.c r100) {
        this.f143495a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        List r101 = (List) r100;
        Observer r102 = this.f143495a;
        boolean r103 = false;
        if (r101 == null) goto L5;
        int r104 = r101.size();
    L6:
        if (r104 > 0) goto L8;
        r103 = true;
    L8:
        r102.onChanged(Boolean.valueOf(r103));
        return;
    L5:
        r104 = 0;
        goto L6
    }
}
