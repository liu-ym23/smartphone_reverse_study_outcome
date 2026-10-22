package com.bytedance.android.livesdk.interactivity.api.anchorsetting;

import android.widget.RadioGroup;
import com.bytedance.android.live.broadcast.api.model.ScreenChatSettingGetResponse;
import com.bytedance.android.live.network.response.Response;
import com.larus.nova.R;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class q<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PrivilegeSettingDetailDialog f132868a;

    public q(PrivilegeSettingDetailDialog r100) {
        this.f132868a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        PrivilegeSettingDetailDialog r101 = this.f132868a;
        com.bytedance.android.live.broadcast.api.model.c0 r102 = ((ScreenChatSettingGetResponse) ((Response) r100).data).getData();
        int r103 = PrivilegeSettingDetailDialog.f132828l;
        if (r102 == null) goto L5;
        RadioGroup r104 = (RadioGroup) r101.S90(R.id.group_follow);
        Integer r105 = r101.f132833h.get(r102.c());
        Intrinsics.checkNotNull(r105);
        r104.check(r105.intValue());
        RadioGroup r106 = (RadioGroup) r101.S90(R.id.group_fans);
        Integer r107 = r101.f132835j.get(r102.b());
        Intrinsics.checkNotNull(r107);
        r106.check(r107.intValue());
        RadioGroup r108 = (RadioGroup) r101.S90(R.id.group_live);
        Integer r109 = r101.f132834i.get(r102.a());
        Intrinsics.checkNotNull(r109);
        r108.check(r109.intValue());
        com.bytedance.android.livesdk.sharedpref.e<Integer> r110 = com.bytedance.android.livesdk.sharedpref.b.f158144f1;
        Integer r111 = r102.c();
        r110.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r110, r111);
        com.bytedance.android.livesdk.sharedpref.e<Integer> r112 = com.bytedance.android.livesdk.sharedpref.b.f158154h1;
        Integer r113 = r102.b();
        r112.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r112, r113);
        com.bytedance.android.livesdk.sharedpref.e<Integer> r114 = com.bytedance.android.livesdk.sharedpref.b.f158149g1;
        Integer r115 = r102.a();
        r114.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r114, r115);
        return;
    L5:
        r101.getClass();
    }
}
