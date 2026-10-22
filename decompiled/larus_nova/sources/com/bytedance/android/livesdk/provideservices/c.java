package com.bytedance.android.livesdk.provideservices;

import android.view.View;
import com.bytedance.android.livesdkapi.service.IExternalLiveLynxCallback;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public final class c extends b7.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IExternalLiveLynxCallback f156775a;

    @Override // b7.a
    public final boolean enableInvoke(String r100, JSONObject r101, String r102) {
        return true;
    }

    @Override // b7.a, b7.b
    public final void onInnerFallback(int r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "errorMessage");
    }

    @Override // b7.a, b7.b
    public final void onPrepareTemplateEnd(boolean r100) {
    }

    public c(IExternalLiveLynxCallback r100) {
        this.f156775a = r100;
    }

    @Override // b7.a, b7.b
    public final void onLoadSuccess(View r100) {
        if (r100 == null) goto L10;
        IExternalLiveLynxCallback r101 = this.f156775a;
        if (r101 == null) goto L6;
        r101.onLoadSuccess(r100);
    L6:
        IExternalLiveLynxCallback r102 = this.f156775a;
        if (r102 == null) goto L11;
        r102.onRuntimeReady(r100);
        return;
    L11:
        return;
    }

    @Override // b7.a, b7.b
    public final boolean onFallback(int r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "errorMessage");
        IExternalLiveLynxCallback r102 = this.f156775a;
        if (r102 == null) goto L5;
        r102.onFallback();
        return true;
    L5:
        return false;
    }

    @Override // b7.a, b7.b
    public final void onLoadStart(View r100, boolean r101) {
        if (r100 == null) goto L7;
        IExternalLiveLynxCallback r102 = this.f156775a;
        if (r102 == null) goto L8;
        r102.onPageStart(r100, null);
        return;
    L8:
        return;
    }

    @Override // b7.a, b7.b
    public final void onContainerError(View r100, int r101, String r102) {
        Intrinsics.checkNotNullParameter(r102, "errorMessage");
        if (r100 == null) goto L8;
        IExternalLiveLynxCallback r103 = this.f156775a;
        if (r103 == null) goto L9;
        r103.onReceivedError(r100, r102);
        return;
    L9:
        return;
    }

    @Override // b7.a, b7.b
    public final void onLoadFail(View r100, String r101, String r102) {
        if (r100 == null) goto L7;
        IExternalLiveLynxCallback r103 = this.f156775a;
        if (r103 == null) goto L8;
        r103.onLoadFailed(r100, r102);
        return;
    L8:
        return;
    }
}
