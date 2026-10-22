package com.bytedance.android.livesdk.announcement;

import com.bytedance.android.live.network.response.BaseResponse;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes7.dex */
public final class n0<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AnnouncementSettingVideoDialog f103532a;

    public n0(AnnouncementSettingVideoDialog r100) {
        this.f103532a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        AnnouncementSettingVideoDialog r101 = this.f103532a;
        r101.U90((BaseResponse) r100);
    }
}
