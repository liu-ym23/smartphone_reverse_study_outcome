package com.bytedance.android.livesdk.dslservice.util.jsb;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import com.bytedance.mt.protector.impl.UriProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class a implements ue7.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f122982a;

    @Override // ue7.c
    public final String b() {
        return "webcast";
    }

    @Override // ue7.c
    public final Uri a() {
        return UriProtector.parse("");
    }

    @Override // ue7.c
    public final Context context() {
        return this.f122982a.getContext();
    }

    @Override // ue7.c
    public final View i() {
        return this.f122982a;
    }

    public a(View r100) {
        this.f122982a = r100;
    }

    @Override // ue7.c
    public final void sendEvent(String r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r100, "eventName");
    }
}
