package com.bytedance.android.live.liveinteract.voicechat.util;

import android.content.DialogInterface;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes46.dex */
public final class x implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ u f80884a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function0 f80885b;

    public x(VoiceInteractSceneUtil.a r100, Function0 r101) {
        this.f80884a = r100;
        this.f80885b = r101;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        u r102 = this.f80884a;
        if (r102 == null) goto L5;
        r102.b();
    L5:
        int r103 = y.f80886a;
        Function0 r104 = this.f80885b;
        u r105 = this.f80884a;
        r104.invoke();
        if (r105 == null) goto L8;
        r105.c();
    L8:
        r100.dismiss();
    }
}
