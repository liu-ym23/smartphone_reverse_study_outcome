package com.bytedance.android.livesdk.chatroom.end.dynamic;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.livesdk.schema.interfaces.IBaseLiveActionHandler;
import java.util.HashMap;
import jc1.k;

/* JADX INFO: loaded from: classes7.dex */
public final class c implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i f106043a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ HashMap f106044b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ViewGroup f106045c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f106046d;

    public c(i r100, HashMap r101, ViewGroup r102, String r103) {
        this.f106043a = r100;
        this.f106044b = r101;
        this.f106045c = r102;
        this.f106046d = r103;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        i.d(this.f106043a, this.f106044b);
        IBaseLiveActionHandler r101 = (IBaseLiveActionHandler) k.f(IBaseLiveActionHandler.class);
        if (r101 == null) goto L6;
        r101.handle(this.f106045c.getContext(), this.f106046d);
        return;
    }
}
