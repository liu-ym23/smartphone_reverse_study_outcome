package com.bytedance.android.live.liveinteract.linkpanel.list;

import android.graphics.drawable.NinePatchDrawable;
import android.widget.TextView;
import com.bytedance.android.livesdk.chatroom.utils.a3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class g implements a3.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TextView f74949a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ py.k f74950b;

    @Override // com.bytedance.android.livesdk.chatroom.utils.a3.b
    public final void onFail() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.utils.a3.b
    public final void a(NinePatchDrawable r100) {
        Intrinsics.checkNotNullParameter(r100, "ninePatchDrawable");
        TextView r101 = this.f74949a;
        py.k r102 = this.f74950b;
        if (r102 == null) goto L7;
        py.k.b r103 = r102.getImageContent();
        if (r103 == null) goto L7;
        String r104 = r103.getName();
    L8:
        r101.setText(r104);
        return;
    L7:
        r104 = null;
        goto L8
    }

    public g(TextView r100, py.k r101) {
        this.f74949a = r100;
        this.f74950b = r101;
    }
}
