package com.bytedance.android.livesdk.revenue.service.toolbar;

import com.bytedance.android.livesdk.chatroom.utils.SkinLoader;
import com.bytedance.android.livesdk.chatroom.utils.y2;
import com.bytedance.android.livesdk.revenue.toolbar.RevResKeyEnum;
import com.bytedance.android.livesdkapi.room.handler.toolbar.ResKeyEnum;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i f157465a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ SkinLoader f157466b;

    public final String a(RevResKeyEnum r100) {
        Intrinsics.checkNotNullParameter(r100, "resKey");
        SkinLoader r101 = this.f157466b;
        this.f157465a.getClass();
        Intrinsics.checkNotNullParameter(r100, "$this$toLiveKey");
        int r102 = g.f157463a[r100.ordinal()];
        if (r102 != 1) goto L5;
        ResKeyEnum r103 = ResKeyEnum.STATIC_ICON;
    L17:
        return r101.b(y2.b(r103));
    L5:
        if (r102 != 2) goto L7;
        r103 = ResKeyEnum.GUIDE_ANIM_ICON;
        goto L17
    L7:
        if (r102 != 3) goto L9;
        r103 = ResKeyEnum.INTRO_CARD_SHOW_ANIM;
        goto L17
    L9:
        if (r102 != 4) goto L12;
        r103 = ResKeyEnum.INTRO_CARD_SHOW_ANIM;
        goto L17
    L12:
        throw new NoWhenBranchMatchedException();
    }

    public h(i r100, SkinLoader r101) {
        this.f157465a = r100;
        this.f157466b = r101;
    }
}
