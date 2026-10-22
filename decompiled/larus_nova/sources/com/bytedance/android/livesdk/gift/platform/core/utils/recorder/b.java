package com.bytedance.android.livesdk.gift.platform.core.utils.recorder;

import com.bytedance.speech.speechengine.SpeechEngineDefines;
import com.huawei.hms.push.constant.RemoteMessageConst;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class b implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g[] f132067a;

    @Override // com.bytedance.android.livesdk.gift.platform.core.utils.recorder.g
    public final void c() {
        g[] r100 = this.f132067a;
        int r101 = r100.length;
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L5;
        r100[r102].c();
        r102 = r102 + 1;
        goto L3
    }

    public b(g... r100) {
        Intrinsics.checkNotNullParameter(r100, SpeechEngineDefines.RECORDER_ENGINE);
        this.f132067a = r100;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.utils.recorder.g
    public final void e(String r100) {
        Intrinsics.checkNotNullParameter("GiftTrayMessageManager", RemoteMessageConst.MSGID);
        Intrinsics.checkNotNullParameter(r100, "stage");
        g[] r101 = this.f132067a;
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L5;
        r101[r103].e(r100);
        r103 = r103 + 1;
        goto L3
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.utils.recorder.g
    public final void b(Object r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, RemoteMessageConst.MSGID);
        Intrinsics.checkNotNullParameter(r101, "stage");
        g[] r102 = this.f132067a;
        int r103 = r102.length;
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L5;
        r102[r104].b(r100, r101);
        r104 = r104 + 1;
        goto L3
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.utils.recorder.g
    public final void d(Object r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, RemoteMessageConst.MSGID);
        Intrinsics.checkNotNullParameter(r101, "stage");
        g[] r102 = this.f132067a;
        int r103 = r102.length;
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L5;
        r102[r104].d(r100, r101);
        r104 = r104 + 1;
        goto L3
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.utils.recorder.g
    public final void f(Object r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, RemoteMessageConst.MSGID);
        Intrinsics.checkNotNullParameter(r101, "otherInfo");
        g[] r102 = this.f132067a;
        int r103 = r102.length;
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L5;
        r102[r104].f(r100, r101);
        r104 = r104 + 1;
        goto L3
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.utils.recorder.g
    public final void a(Object r100, String r101, d r102) {
        Intrinsics.checkNotNullParameter(r100, RemoteMessageConst.MSGID);
        Intrinsics.checkNotNullParameter(r101, "stage");
        g[] r103 = this.f132067a;
        int r104 = r103.length;
        int r105 = 0;
    L3:
        if (r105 >= r104) goto L5;
        r103[r105].a(r100, r101, r102);
        r105 = r105 + 1;
        goto L3
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.utils.recorder.g
    public final void g(Object r100, String r101, Function1<? super h, Unit> r102) {
        Intrinsics.checkNotNullParameter(r100, RemoteMessageConst.MSGID);
        Intrinsics.checkNotNullParameter(r101, "stage");
        Intrinsics.checkNotNullParameter(r102, "record");
        g[] r103 = this.f132067a;
        int r104 = r103.length;
        int r105 = 0;
    L3:
        if (r105 >= r104) goto L5;
        r103[r105].g(r100, r101, r102);
        r105 = r105 + 1;
        goto L3
    }
}
