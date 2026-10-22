package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior;

import android.text.TextUtils;
import android.view.View;
import com.bytedance.android.livesdk.schema.interfaces.ILiveActionHandler;
import java.util.Map;

/* JADX INFO: loaded from: classes8.dex */
public final class a1 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ x0 f117076a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f117077b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Map f117078c;

    public a1(x0 r100, String r101, Map r102) {
        this.f117076a = r100;
        this.f117077b = r101;
        this.f117078c = r102;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        if (TextUtils.isEmpty(this.f117077b) == true) goto L5;
        ((ILiveActionHandler) jc1.k.n(ILiveActionHandler.class)).handle(this.f117076a.f117502n, this.f117077b);
    L5:
        x0 r101 = this.f117076a;
        Map r102 = this.f117078c;
        r101.getClass();
        x0.a("livesdk_fan_group_pop_click", r102);
        x0 r103 = this.f117076a;
        yo2.e r104 = r103.f117496h;
        if (r104 == null) goto L8;
        r104.d();
    L8:
        r103.f117496h = null;
    }
}
