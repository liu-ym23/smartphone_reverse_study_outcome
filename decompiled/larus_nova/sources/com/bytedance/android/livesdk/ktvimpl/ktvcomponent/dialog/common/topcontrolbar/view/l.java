package com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.topcontrolbar.view;

import com.bytedance.android.livesdk.message.model.MusicPanel;
import io.reactivex.functions.Consumer;
import java.util.List;

/* JADX INFO: loaded from: classes10.dex */
public final class l<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ KtvComponentTopBarControlContainer f144201a;

    public l(KtvComponentTopBarControlContainer r100) {
        this.f144201a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        KtvComponentTopBarControlContainer r101 = this.f144201a;
        List<MusicPanel> r102 = (List) sh6.c.b((sh6.b) r100);
        int r103 = KtvComponentTopBarControlContainer.f144162u;
        r101.h(r102);
    }
}
