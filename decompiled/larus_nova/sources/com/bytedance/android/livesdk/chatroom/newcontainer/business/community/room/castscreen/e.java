package com.bytedance.android.livesdk.chatroom.newcontainer.business.community.room.castscreen;

import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: classes7.dex */
public final class e implements Observer<String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.livesdk.room.b f107439a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ f f107440b;

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        f r101 = this.f107440b;
        com.bytedance.android.livesdk.room.b r102 = this.f107439a;
        r101.getClass();
        f.B(r102, (String) r100);
    }

    public e(f r100, com.bytedance.android.livesdk.room.b r101) {
        this.f107440b = r100;
        this.f107439a = r101;
    }
}
