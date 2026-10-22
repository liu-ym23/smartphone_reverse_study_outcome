package com.bytedance.android.livesdk.chatroom.ui.setting;

import com.bytedance.android.live.adapter.binding.SwitchSettingViewHolder;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.network.response.Response;
import com.larus.nova.R;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes8.dex */
public final class b<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f114095a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f114096b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ SwitchSettingViewHolder f114097c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ long f114098d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ String f114099e;

    public b(a r100, boolean r101, SwitchSettingViewHolder r102, long r103, String r104) {
        this.f114095a = r100;
        this.f114096b = r101;
        this.f114097c = r102;
        this.f114098d = r103;
        this.f114099e = r104;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        if (((Response) r100) == null) goto L15;
        com.bytedance.android.livesdk.sharedpref.e<Long> r101 = com.bytedance.android.livesdk.sharedpref.b.f158136d3;
        a r102 = this.f114095a;
        boolean r103 = this.f114096b;
        r102.getClass();
        if (r103 == false) goto L8;
        long r104 = 1;
    L9:
        Long r105 = Long.valueOf(r104);
        r101.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r101, r105);
        if (this.f114096b == false) goto L12;
        this.f114097c.f58543b.setText(s1.B(R.string.ttlive_setting_audience_receive_gift_close_tips));
    L13:
        this.f114095a.f114094q.refreshSettingItems();
        a.g(this.f114095a, this.f114098d, this.f114099e, this.f114096b, true);
        return;
    L12:
        this.f114097c.f58543b.setText(s1.B(R.string.ttlive_setting_audience_receive_gift_open_tips));
        goto L13
    L8:
        r104 = 2;
        goto L9
    }
}
