package com.bytedance.android.livesdk.gift.banner;

import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.livesdk.gift.model.l2;
import com.bytedance.android.livesdk.gift.platform.business.dialog.ui.panel.AbsPanel;
import com.bytedance.android.livesdk.rank.model.e;
import io.reactivex.functions.Consumer;
import java.util.List;

/* JADX INFO: loaded from: classes9.dex */
public final class b<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f125842a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AbsPanel f125843b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ l2 f125844c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f125845d;

    public b(d r100, AbsPanel r101, l2 r102, String r103) {
        this.f125842a = r100;
        this.f125843b = r101;
        this.f125844c = r102;
        this.f125845d = r103;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        ExtraResponse r101 = (ExtraResponse) r100;
        if (r101 == null) goto L11;
        e r102 = (e) r101.data;
        if (r102 == null) goto L11;
        List<Long> r103 = r102.options;
        if (r103 == null) goto L11;
        boolean r104 = true;
        if ((!r103.isEmpty()) != true) goto L11;
    L12:
        d.I(this.f125842a, this.f125843b, this.f125844c, this.f125845d, r104);
        this.f125842a.f125850e = false;
        return;
    L11:
        r104 = false;
        goto L12
    }
}
