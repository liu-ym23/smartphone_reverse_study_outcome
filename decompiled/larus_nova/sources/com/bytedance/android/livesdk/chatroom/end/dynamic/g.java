package com.bytedance.android.livesdk.chatroom.end.dynamic;

import android.view.View;
import java.util.Map;

/* JADX INFO: loaded from: classes7.dex */
public final class g implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i f106051a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Map f106052b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f106053c;

    public g(i r100, Map r101, String r102) {
        this.f106051a = r100;
        this.f106052b = r101;
        this.f106053c = r102;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        i.c(this.f106051a, this.f106052b, this.f106053c, "video_pause");
    }
}
