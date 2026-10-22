package com.bytedance.android.livesdk.interactivity.service.richcontent.resourceloader;

import android.graphics.drawable.NinePatchDrawable;
import com.bytedance.android.livesdk.chatroom.utils.a3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class k implements a3.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ hk6.b.a f140986a;

    @Override // com.bytedance.android.livesdk.chatroom.utils.a3.b
    public final void onFail() {
        hk6.b.a.C6158a.a(this.f140986a, "ResizableImageLoader load failed", null, 2);
    }

    public k(hk6.d r100) {
        this.f140986a = r100;
    }

    @Override // com.bytedance.android.livesdk.chatroom.utils.a3.b
    public final void a(NinePatchDrawable r100) {
        Intrinsics.checkNotNullParameter(r100, "ninePatchDrawable");
        this.f140986a.b(r100);
    }
}
