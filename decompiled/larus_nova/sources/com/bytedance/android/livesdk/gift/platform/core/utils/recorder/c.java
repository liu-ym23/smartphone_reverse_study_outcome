package com.bytedance.android.livesdk.gift.platform.core.utils.recorder;

import com.huawei.hms.push.constant.RemoteMessageConst;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class c implements g {
    public c() {
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.utils.recorder.g
    public final void a(Object r100, String r101, d r102) {
        Intrinsics.checkNotNullParameter(r100, RemoteMessageConst.MSGID);
        Intrinsics.checkNotNullParameter(r101, "stage");
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.utils.recorder.g
    public final void b(Object r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, RemoteMessageConst.MSGID);
        Intrinsics.checkNotNullParameter(r101, "stage");
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.utils.recorder.g
    public final void c() {
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.utils.recorder.g
    public final void d(Object r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, RemoteMessageConst.MSGID);
        Intrinsics.checkNotNullParameter(r101, "stage");
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.utils.recorder.g
    public final void e(String r100) {
        Intrinsics.checkNotNullParameter("GiftTrayMessageManager", RemoteMessageConst.MSGID);
        Intrinsics.checkNotNullParameter(r100, "stage");
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.utils.recorder.g
    public final void f(Object r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, RemoteMessageConst.MSGID);
        Intrinsics.checkNotNullParameter(r101, "otherInfo");
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.utils.recorder.g
    public final void g(Object r100, String r101, Function1<? super h, Unit> r102) {
        Intrinsics.checkNotNullParameter(r100, RemoteMessageConst.MSGID);
        Intrinsics.checkNotNullParameter(r101, "stage");
        Intrinsics.checkNotNullParameter(r102, "record");
    }
}
