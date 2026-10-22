package com.bytedance.android.livesdk.chatroom.ui.framework.base;

import androidx.fragment.app.Fragment;
import com.bytedance.android.livesdk.vscore_impl.component.tabs.t;
import io.reactivex.functions.Action;

/* JADX INFO: loaded from: classes8.dex */
public final class m implements Action {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ru2.b f112920a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Fragment f112921b;

    public m(ru2.b r100, Fragment r101) {
        this.f112920a = r100;
        this.f112921b = r101;
    }

    @Override // io.reactivex.functions.Action
    public final void run() {
        this.f112920a.a();
        t.f160004b.b(this.f112921b);
    }
}
