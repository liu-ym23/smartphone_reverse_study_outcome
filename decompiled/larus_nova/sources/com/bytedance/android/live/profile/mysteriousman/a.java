package com.bytedance.android.live.profile.mysteriousman;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes47.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f86119a = 0;

    static {
    }

    @JvmStatic
    public static final int a(UserProfileEvent r100) {
        if (r100 != null) goto L6;
        return 0;
    L6:
        if (r100.mysteryMan != 2) goto L8;
    L7:
        return 2;
    L8:
        IBaseUser r101 = r100.user;
        if (r101 != null) goto L11;
    L13:
        IBaseUser r102 = r100.user;
        if (r102 == null) goto L19;
        if (r102.isAnonymous() == true) goto L7;
    L19:
        if (r100.mysteryMan != 1) goto L21;
    L20:
        return 1;
    L21:
        IBaseUser r103 = r100.user;
        if (r103 != null) goto L24;
        return 0;
    L24:
        if (r103.getMysteryMan() == 1) goto L20;
        return 0;
    L11:
        if (r101.getMysteryMan() != 2) goto L13;
        goto L13
    }
}
