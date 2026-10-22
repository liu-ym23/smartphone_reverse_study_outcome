package com.bytedance.android.livesdk.vscore_impl.component.multicamera.linkedroom.ui;

import android.view.View;
import com.bytedance.android.livesdkapi.depend.model.live.episode.VSCameraInfo;

/* JADX INFO: loaded from: classes11.dex */
public final class l implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MultiCameraListHolder f159768a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ VSCameraInfo f159769b;

    public l(MultiCameraListHolder r100, VSCameraInfo r101) {
        this.f159768a = r100;
        this.f159769b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        MultiCameraListHolder r101 = this.f159768a;
        r101.f159714p.K(this.f159769b, r101.getAdapterPosition());
    }
}
