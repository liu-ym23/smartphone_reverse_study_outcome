package com.bytedance.android.livesdk.message.interceptor;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.config.qy0;
import com.bytedance.android.livesdk.message.model.l3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class c implements vlc.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f153530a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f153531b;

    @Override // vlc.b
    public final boolean onMessage(tlc.d r100) {
        String r101 = null;
        if ((r100 instanceof l3) == true) goto L5;
        tlc.d r102 = null;
    L6:
        l3 r103 = (l3) r102;
        if (r103 != null) goto L9;
        return false;
    L9:
        IBaseUser r104 = ((l3) r100).getUser();
        if (r104 == null) goto L12;
        r101 = r104.getIdString();
    L12:
        boolean r105 = Intrinsics.areEqual(r101, this.f153531b);
        if (this.f153530a == true) goto L22;
        if (r105 == true) goto L22;
        if (Intrinsics.areEqual("donation", r103.E()) == false) goto L22;
        if (qy0.f121092a.getValue().i() == false) goto L22;
        return true;
    L22:
        return false;
    L5:
        r102 = r100;
        goto L6
    }

    public c(boolean r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "currentUserId");
        this.f153530a = r100;
        this.f153531b = r101;
    }
}
