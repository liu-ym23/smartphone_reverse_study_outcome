package com.bytedance.android.live.liveinteract.linkpanel.fragment;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes46.dex */
public final class e<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ApplyPermissionSwitchFragment f74697a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef f74698b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f74699c;

    public e(ApplyPermissionSwitchFragment r100, Ref.ObjectRef r101, boolean r102) {
        this.f74697a = r100;
        this.f74698b = r101;
        this.f74699c = r102;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        com.bytedance.android.live.network.response.a r101 = (com.bytedance.android.live.network.response.a) r100;
        int r102 = this.f74697a.f74460k;
        if (r102 != 1) goto L5;
        ALogger.i("ttlive_link", "videoTalk update_setting " + ((HashMap) this.f74698b.element));
        com.bytedance.android.livesdk.sharedpref.e<Boolean> r103 = com.bytedance.android.livesdk.sharedpref.c.f158307t1;
        Boolean r104 = Boolean.valueOf(this.f74699c);
        r103.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r103, r104);
        xs2.b.a().post(new jd0.m(this.f74699c));
    L9:
        ApplyPermissionSwitchFragment r105 = this.f74697a;
        r105.f74463n = this.f74699c;
        r105.ea0();
        return;
    L5:
        if (r102 != 3) goto L9;
        ALogger.i("ttlive_link", "audioTalk update_setting " + ((HashMap) this.f74698b.element));
        com.bytedance.android.livesdk.sharedpref.e<Boolean> r106 = com.bytedance.android.livesdk.sharedpref.c.L0;
        Boolean r107 = Boolean.valueOf(this.f74699c);
        r106.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r106, r107);
        xs2.b.a().post(new jd0.n(this.f74699c));
        goto L9
    }
}
