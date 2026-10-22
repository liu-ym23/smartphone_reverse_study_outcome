package com.bytedance.android.live.effect.sticker.ui.gestureV3;

import com.bytedance.android.live.effect.sticker.ui.LiveGestureMagicPageAdapter;
import com.bytedance.android.livesdkapi.depend.model.Sticker;

/* JADX INFO: loaded from: classes45.dex */
public final class f implements LiveGestureMagicPageAdapter.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveGestureMagicPageAdapterVCD f68584a;

    public f(LiveGestureMagicPageAdapterVCD r100) {
        this.f68584a = r100;
    }

    @Override // com.bytedance.android.live.effect.sticker.ui.LiveGestureMagicPageAdapter.b
    public final void a(Boolean r100, Sticker r101) {
        boolean r102 = r100.booleanValue();
        LiveGestureMagicPageAdapterVCD r103 = this.f68584a;
        if (r101 != null) goto L5;
        r103.getClass();
        return;
    L5:
        LiveGestureMagicPageAdapter.b r104 = r103.f68566a;
        if (r104 == null) goto L10;
        r104.a(Boolean.valueOf(r102), r101);
        return;
    }
}
