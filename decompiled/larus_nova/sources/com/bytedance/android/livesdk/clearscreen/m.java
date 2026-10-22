package com.bytedance.android.livesdk.clearscreen;

import com.bytedance.android.livesdk.chatroom.clearscreen.ClearScreenConst$GuideType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ClearScreenConst$GuideType f119467a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f119468b;

    public m(ClearScreenConst$GuideType r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "guideType");
        Intrinsics.checkNotNullParameter(r101, "triggerBy");
        this.f119467a = r100;
        this.f119468b = r101;
    }
}
