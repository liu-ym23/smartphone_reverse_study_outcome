package com.bytedance.android.livesdk.vscore_impl.component.multicamera.linkedroom.ui;

import android.view.View;

/* JADX INFO: loaded from: classes11.dex */
public final class d implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LinkedRoomHolder f159759a;

    public d(LinkedRoomHolder r100) {
        this.f159759a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        LinkedRoomHolder.T3(this.f159759a, "head_photo");
    }
}
