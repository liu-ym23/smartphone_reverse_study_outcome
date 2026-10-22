package com.bytedance.android.live.liveinteract.chatroom.chatroom.interact.viewholder;

import android.graphics.drawable.NinePatchDrawable;
import android.widget.TextView;
import com.bytedance.android.livesdk.chatroom.utils.a3;
import kotlin.jvm.internal.Intrinsics;
import py.k;

/* JADX INFO: loaded from: classes46.dex */
public final class a implements a3.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TextView f72114a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ k f72115b;

    @Override // com.bytedance.android.livesdk.chatroom.utils.a3.b
    public final void onFail() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.utils.a3.b
    public final void a(NinePatchDrawable r100) {
        Intrinsics.checkNotNullParameter(r100, "ninePatchDrawable");
        TextView r101 = this.f72114a;
        k r102 = this.f72115b;
        if (r102 == null) goto L7;
        k.b r103 = r102.getImageContent();
        if (r103 == null) goto L7;
        String r104 = r103.getName();
    L8:
        r101.setText(r104);
        return;
    L7:
        r104 = null;
        goto L8
    }

    public a(TextView r100, k r101) {
        this.f72114a = r100;
        this.f72115b = r101;
    }
}
