package com.bytedance.android.livesdk.jsbridge.methods;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import bolts.Task;
import com.baidu.platform.comapi.bmsdk.BmLocated;
import com.bytedance.android.live.browser.jsbridge.base.OpenMultiSelectPhotoLibraryResultModel;
import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.livesdkapi.ILiveActivityResultListener;
import com.bytedance.android.livesdkapi.model.LinkMediaModel;
import com.bytedance.bpea.cert.token.TokenCert;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;
import w20.nc;

/* JADX INFO: loaded from: classes9.dex */
public final class w2 extends w20.o4<nc, OpenMultiSelectPhotoLibraryResultModel> implements ILiveActivityResultListener.OnLiveActivityResultListener {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final TokenCert f142233c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f142234a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final WeakReference<Context> f142235b;

    public interface a {
        void a();

        void b();
    }

    public static final class b {
    }

    static {
        f142233c = TokenCert.Companion.with("bpea-livescreenshotsharedialog_request_permission");
    }

    public w2(WeakReference<Context> r100) {
        Intrinsics.checkNotNullParameter(r100, "contextRef");
        this.f142235b = r100;
        this.f142234a = BmLocated.HALF_LEFT_BOTTOM;
    }

    private final Activity getContext(Context r100) {
        if ((r100 instanceof Activity) == true) goto L5;
    L7:
        return null;
    L5:
        if ((r100 instanceof ILiveActivityResultListener) == false) goto L7;
        return (Activity) r100;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        nc r102 = (nc) r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Activity r103 = getContext(r101.getContext());
        if ((r103 instanceof ILiveActivityResultListener) == false) goto L15;
        ((ILiveActivityResultListener) r103).setOnLiveActivityResultListener(this);
        TokenCert r104 = f142233c;
        a3 r105 = new a3(this, r102, r103);
        int r106 = Build.VERSION.SDK_INT;
        if (r106 < 34) goto L8;
        String[] r107 = {BaseConstants.PERMISSION_READ_MEDIA_IMAGES, "android.permission.READ_MEDIA_VISUAL_USER_SELECTED"};
    L11:
        Context r108 = this.f142235b.get();
        if (m60.c.d(r108, (String[]) Arrays.copyOf(r107, r107.length)) == false) goto L14;
        r105.b();
        return;
    L14:
        Activity r109 = ContextUtil.contextToActivity(r108);
        SettingKey<Boolean> r110 = m60.i.f512260a;
        new m60.i.b(r109).b(new x2(r105, r108), null, r104, (String[]) Arrays.copyOf(r107, r107.length));
        return;
    L8:
        if (r106 < 33) goto L10;
        r107 = new String[]{BaseConstants.PERMISSION_READ_MEDIA_IMAGES};
        goto L11
    L10:
        r107 = new String[]{"android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE"};
        goto L11
    L15:
        finishWithFailure(new Throwable("Context is not support ILiveActivityResultListener, ctx = ".concat(String.valueOf(r103))));
    }

    @Override // com.bytedance.android.livesdkapi.ILiveActivityResultListener.OnLiveActivityResultListener
    public final void onActivityResult(int r100, int r101, Intent r102) {
        if (r100 == 100200) goto L5;
        return;
    L5:
        if (r101 != (-1)) goto L12;
        if (r102 == null) goto L12;
        Task.callInBackground(new y2(this, r102.getParcelableArrayListExtra(LinkMediaModel.KEY_CHOOSE_MEDIA_LIVE_LINK_DATA))).continueWith(new z2(this), Task.UI_THREAD_EXECUTOR);     // Catch: Exception -> L10
        return;
    L10:
        e = move-exception;
        finishWithFailure(e);
        return;
    L12:
        finishWithFailure();
    }
}
