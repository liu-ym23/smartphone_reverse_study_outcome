package com.bytedance.android.livesdk.chatroom.end.dynamic;

import android.content.Context;
import android.view.View;
import com.bytedance.android.livesdk.chatroom.backtrack.LiveVideoPreviewView;
import com.bytedance.android.livesdk.chatroom.end.LandscapeFullPlayVideoActivity;
import java.util.Map;

/* JADX INFO: loaded from: classes7.dex */
public final class h implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i f106054a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Map f106055b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f106056c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ LiveVideoPreviewView f106057d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ String f106058e;

    public h(i r100, Map r101, String r102, LiveVideoPreviewView r103, String r104) {
        this.f106054a = r100;
        this.f106055b = r101;
        this.f106056c = r102;
        this.f106057d = r103;
        this.f106058e = r104;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        i.c(this.f106054a, this.f106055b, this.f106056c, "video_enlarge");
        int r101 = LandscapeFullPlayVideoActivity.f105890a;
        Context r102 = this.f106057d.getContext();
        String r103 = this.f106058e;
        if (r103 != null) goto L5;
        r103 = "";
    L5:
        LandscapeFullPlayVideoActivity.a.a(r102, r103, this.f106057d.getPosition(), null, null);
    }
}
