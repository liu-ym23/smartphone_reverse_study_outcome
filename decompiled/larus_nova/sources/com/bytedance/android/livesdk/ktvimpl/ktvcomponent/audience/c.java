package com.bytedance.android.livesdk.ktvimpl.ktvcomponent.audience;

import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.core.KtvComponentContext;
import com.bytedance.live.datacontext.n;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: classes10.dex */
public final class c<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f144047a = null;

    static {
        f144047a = new c();
    }

    public c() {
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        Boolean r101 = (Boolean) r100;
        if (r101 == null) goto L10;
        KtvComponentContext r102 = KtvComponentContext.Companion.getContext();
        if (r102 == null) goto L11;
        n<Boolean> r103 = r102.isAudienceEnableSing();
        if (r103 == null) goto L12;
        r103.setValue(r101);
        return;
    L12:
        return;
    L11:
        return;
    }
}
