package com.bytedance.android.livesdk.chatroom.gamestickerv2.componentv2;

import android.webkit.WebView;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class e implements ib.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function2 f106341a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function2 f106342b;

    @Override // ib.f
    public final void onLoadStart(String r100, WebView r101) {
    }

    public e(Function2 r100, Function2 r101) {
        this.f106341a = r100;
        this.f106342b = r101;
    }

    @Override // ib.f
    public final void onLoadUriSuccess(String r100, WebView r101) {
        Function2 r102 = this.f106342b;
        if (r102 == null) goto L6;
        Unit r103 = (Unit) r102.invoke(r100, r101);
        return;
    }

    @Override // ib.f
    public final void onLoadFail(String r100, WebView r101, Throwable r102) {
        Intrinsics.checkNotNullParameter(r102, "e");
        Function2 r103 = this.f106341a;
        if (r103 == null) goto L6;
        Unit r104 = (Unit) r103.invoke(r100, r102);
        return;
    }
}
