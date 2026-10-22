package com.bytedance.android.shopping.anchorv4.helper.shot;

import android.app.Activity;
import android.os.Build;
import androidx.core.content.ContextCompat;
import com.bytedance.android.shopping.anchorv4.components.ScreenCaptureManager;
import com.ss.android.download.api.constant.BaseConstants;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c f166987a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f166988b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Activity f166989c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final e f166990d;

    public final boolean a() {
        int r100 = Build.VERSION.SDK_INT;
        if (r100 < 33) goto L14;
        if (r100 >= 33) goto L6;
    L8:
        boolean r101 = false;
    L9:
        if (r101 == false) goto L14;
        if (ContextCompat.checkSelfPermission(this.f166989c, BaseConstants.PERMISSION_READ_MEDIA_IMAGES) == 0) goto L18;
    L16:
        return false;
    L18:
        return true;
    L6:
        if (this.f166989c.getApplicationContext().getApplicationInfo().targetSdkVersion < 33) goto L8;
        r101 = true;
    L14:
        if (ContextCompat.checkSelfPermission(this.f166989c, "android.permission.READ_EXTERNAL_STORAGE") != 0) goto L16;
        return true;
    }

    public d(Activity r100, ScreenCaptureManager.d r101) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        this.f166989c = r100;
        this.f166990d = r101;
        this.f166988b = LazyKt.lazy(new ECScreenshotWatcherCompact$screenshotWatch$2(this));
    }
}
