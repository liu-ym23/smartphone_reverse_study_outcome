package com.bytedance.ai.applet.login;

import android.app.Activity;
import com.bytedance.ai.applet.granting.GrantingAction;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class d implements r4.f.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f34743a;

    public d(String r100) {
        this.f34743a = r100;
    }

    @Override // r4.f.a
    public final void a(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
    }

    @Override // r4.f.a
    public final void onCreated(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
    }

    @Override // r4.f.a
    public final void onPaused(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
    }

    @Override // r4.f.a
    public final void onResumed(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        CustomLoginNavigator.a r101 = CustomLoginNavigator.f34708b.get(this.f34743a);
        if (r101 == null) goto L5;
        CustomLoginNavigator.LaunchSource r102 = r101.f34717d;
    L7:
        if (r102 == CustomLoginNavigator.LaunchSource.CHAT) goto L9;
        return;
    L9:
        com.bytedance.ai.utils.g.f37637a.i("CustomLoginNavigator", "host main activity resumed before login result, dismiss custom login: appletId=" + this.f34743a);
        LoginProcessor r103 = LoginProcessor.f34725a;
        String r104 = this.f34743a;
        GrantingAction r105 = GrantingAction.DISMISSED;
        OperationType r106 = OperationType.LOGIN;
        r103.getClass();
        LoginProcessor.i(r104, r105, r106);
        return;
    L5:
        r102 = null;
        goto L7
    }

    @Override // r4.f.a
    public final void onStopped(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
    }
}
