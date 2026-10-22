package com.bytedance.android.livesdk.chatroom.distribution;

import android.widget.FrameLayout;
import com.bytedance.ies.sdk.widgets.KVData;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: classes7.dex */
public final class a<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FrameLayout f105739a;

    public a(FrameLayout r100) {
        this.f105739a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        KVData r101 = (KVData) r100;
        if (r101 == null) goto L6;
        Boolean r102 = (Boolean) r101.getData();
        if (r102 == null) goto L6;
    L8:
        if (r102.booleanValue() == false) goto L12;
        FrameLayout r103 = this.f105739a;
        if (r103 == null) goto L16;
        r103.setVisibility(0);
        return;
    L16:
        return;
    L12:
        FrameLayout r104 = this.f105739a;
        if (r104 == null) goto L18;
        r104.setVisibility(8);
        return;
    L18:
        return;
    L6:
        r102 = Boolean.TRUE;
        goto L8
    }
}
