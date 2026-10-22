package com.bytedance.android.live.ui;

import com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme;

/* JADX INFO: loaded from: classes7.dex */
public final class f implements n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f102079a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ IVoiceLiveTheme f102080b;

    @Override // com.bytedance.android.live.ui.n
    public final void a() {
        a r100 = this.f102079a.f102072t;
        if (r100 == null) goto L6;
        r100.W9(true, this.f102080b);
        return;
    }

    @Override // com.bytedance.android.live.ui.n
    public final void b() {
        c.e(this.f102079a);
    }

    public f(c r100, IVoiceLiveTheme r101) {
        this.f102079a = r100;
        this.f102080b = r101;
    }
}
