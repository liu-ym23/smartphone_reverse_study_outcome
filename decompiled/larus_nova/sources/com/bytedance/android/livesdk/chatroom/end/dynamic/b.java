package com.bytedance.android.livesdk.chatroom.end.dynamic;

import android.view.View;
import com.bytedance.android.livesdk.schema.interfaces.IBaseLiveActionHandler;
import java.util.HashMap;
import jc1.k;

/* JADX INFO: loaded from: classes7.dex */
public final class b implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i f106039a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ HashMap f106040b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ View f106041c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f106042d;

    public b(i r100, HashMap r101, View r102, String r103) {
        this.f106039a = r100;
        this.f106040b = r101;
        this.f106041c = r102;
        this.f106042d = r103;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        i.d(this.f106039a, this.f106040b);
        IBaseLiveActionHandler r101 = (IBaseLiveActionHandler) k.f(IBaseLiveActionHandler.class);
        if (r101 == null) goto L6;
        r101.handle(this.f106041c.getContext(), this.f106042d);
        return;
    }
}
