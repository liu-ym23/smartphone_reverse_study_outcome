package com.bytedance.android.livesdk.chatroom.ui.framework.widget;

import com.bytedance.android.live.base.model.user.IBaseUser;
import io.reactivex.functions.Consumer;
import java.util.List;

/* JADX INFO: loaded from: classes8.dex */
public final class e0<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LongPressPanelFollowWidget f113333a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ mt1.a f113334b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f113335c;

    public e0(LongPressPanelFollowWidget r100, mt1.a r101, boolean r102) {
        this.f113333a = r100;
        this.f113334b = r101;
        this.f113335c = r102;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        IBaseUser r101 = (IBaseUser) r100;
        LongPressPanelFollowWidget r102 = this.f113333a;
        mt1.a r103 = this.f113334b;
        boolean r104 = this.f113335c;
        List<String> r105 = LongPressPanelFollowWidget.f113155b;
        r102.zq(r103, r104);
    }
}
