package com.bytedance.android.live.browser.jsbridge.upload;

import androidx.fragment.app.Fragment;
import bolts.Task;
import com.bytedance.android.live.browser.jsbridge.base.GetPictureResultModel;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.room.IMiddlewareLiveSDKService;
import com.bytedance.android.livesdk.config.vv0;
import com.bytedance.android.livesdk.config.wv0;
import com.bytedance.android.livesdk.utils.k2;
import com.bytedance.android.livesdkapi.depend.model.live.audio.IThemeShowArea;
import com.bytedance.android.livesdkapi.depend.model.live.audio.ThemeUpLoadListener;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.larus.platform.model.upload.ResourceUploadError;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;
import w20.r1;
import w20.r9;

/* JADX INFO: loaded from: classes45.dex */
public final class x extends r1<r9, GetPictureResultModel> implements com.bytedance.android.live.room.g.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.bytedance.android.live.room.g f64095a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Fragment f64096b;

    @Override // com.bytedance.android.live.room.g.b
    public final /* synthetic */ void c() {
    }

    @Override // com.bytedance.android.live.room.g.b
    public final /* synthetic */ void e(String r100, String r101, String r102) {
    }

    @Override // com.bytedance.android.live.room.g.b
    public final void g(String r100, int r101) {
    }

    @Override // com.bytedance.android.live.room.g.b
    public final /* synthetic */ void h() {
    }

    @Override // com.bytedance.android.live.room.g.b
    public final /* synthetic */ void onError(String r100) {
    }

    @Override // com.bytedance.android.live.room.g.b
    public final void onCanceled() {
        finishWithFailure(new IllegalStateException(ResourceUploadError.CANCELED));
    }

    public x(Fragment r100) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        this.f64096b = r100;
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r110, CallContext r111) {
        r9 r100 = (r9) r110;
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r111, PerfLog.PARAM_KEY_CONTEXT_ID);
        Integer r101 = r100.b();     // Catch: Exception -> L21
        if (r101 == null) goto L6;
        int r102 = r101.intValue();     // Catch: Exception -> L21
    L7:
        wv0 r103 = wv0.f121556a;     // Catch: Exception -> L21
        int r104 = Math.max(r102, r103.getValue().intValue());     // Catch: Exception -> L21
        Integer r105 = r100.a();     // Catch: Exception -> L21
        if (r105 == null) goto L10;
        int r106 = r105.intValue();     // Catch: Exception -> L21
    L11:
        vv0 r107 = vv0.f121481a;     // Catch: Exception -> L21
        int r108 = Math.max(r106, r107.getValue().intValue());     // Catch: Exception -> L21
        Integer r109 = r100.b();     // Catch: Exception -> L21
        if (r109 != null) goto L14;
        r109 = r103.getValue();     // Catch: Exception -> L21
    L14:
        int r112 = Math.max(1, r109.intValue());     // Catch: Exception -> L21
        Integer r113 = r100.a();     // Catch: Exception -> L21
        if (r113 != null) goto L17;
        r113 = r107.getValue();     // Catch: Exception -> L21
    L17:
        int r114 = Math.max(1, r113.intValue());     // Catch: Exception -> L21
        com.bytedance.android.live.room.g r115 = ((IMiddlewareLiveSDKService) jc1.k.n(IMiddlewareLiveSDKService.class)).createImagePicker(null, this.f64096b, "pick_custom_gift_picture", null, r112, r114, r104, r108, this, null);     // Catch: Exception -> L21
        this.f64095a = r115;     // Catch: Exception -> L21
        if (r115 == null) goto L26;
        ((k2) r115).u(false, false, 0);     // Catch: Exception -> L21
        return;
    L26:
        return;
    L10:
        r106 = 1;
        goto L11
    L6:
        r102 = 1;
    L21:
        e = move-exception;
        finishWithFailure(e);
    }

    @Override // com.bytedance.android.live.room.g.b
    public final void b(String r100, String r101, IThemeShowArea r102, ThemeUpLoadListener r103, int r104) {
        ALogger.i("cwz", r100);
        Task.callInBackground(new v(this, r100)).continueWith(new w(this, r100), Task.UI_THREAD_EXECUTOR);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        finishWithFailure(e);
    }
}
