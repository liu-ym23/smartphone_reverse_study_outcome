package com.bytedance.android.livesdk.chatroom.broadcast.v2.service;

import androidx.lifecycle.Observer;
import com.bytedance.android.live.core.utils.MainThreadPostUtils;
import com.bytedance.ies.sdk.widgets.KVData;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class r<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final r f105529a = null;

    static {
        f105529a = new r();
    }

    public r() {
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        KVData r101 = (KVData) r100;
        if (Intrinsics.areEqual(r101.getKey(), "data_link_state") == false) goto L11;
        Integer r102 = (Integer) r101.getData();
        if (r102 != null) goto L8;
        r102 = 0;
    L8:
        if (r102.intValue() <= 2) goto L12;
        com.bytedance.android.livesdk.sharedpref.e<Boolean> r103 = com.bytedance.android.livesdk.sharedpref.b.M0;
        Boolean r104 = Boolean.FALSE;
        r103.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r103, r104);
        MainThreadPostUtils.b(q.f105528a);
        return;
    L12:
        return;
    }
}
