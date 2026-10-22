package com.bytedance.android.livesdk.chatroom.bl;

import androidx.fragment.app.Fragment;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes7.dex */
public final class a implements PlatformMessageHelper.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference<Fragment> f105241a;

    @Override // com.bytedance.android.livesdk.chatroom.bl.PlatformMessageHelper.b
    public final boolean a() {
        Fragment r100 = this.f105241a.get();
        if (r100 != null) goto L6;
        return true;
    L6:
        return !r100.isVisible();
    }

    public a(Fragment r100) {
        this.f105241a = new WeakReference(r100);
    }
}
