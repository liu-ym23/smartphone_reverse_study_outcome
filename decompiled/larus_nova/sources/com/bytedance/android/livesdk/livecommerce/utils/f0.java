package com.bytedance.android.livesdk.livecommerce.utils;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import java.io.File;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes10.dex */
public final class f0 implements ak2.f<String, String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f153079a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function2 f153080b;

    @Override // ud.a, com.bytedance.android.livesdkapi.room.handler.observe.ConfigObserver
    public final Object getConfig() {
        File r100 = this.f153079a.getExternalCacheDir();
        if (r100 == null) goto L10;
        PolarisFileWrapper r101 = new PolarisFileWrapper(r100, "/live/ecscreenshot");
        if (r101.exists() == false) goto L7;
    L9:
        dm.a.a("ECScreenshotUtils").i("return " + r101.getAbsolutePath());
        return r101.getAbsolutePath();
    L7:
        if (r101.mkdirs() == true) goto L9;
        dm.a.a("ECScreenshotUtils").i("return " + r100.getAbsolutePath());
        return r100.getAbsolutePath();
    L10:
        dm.a.a("ECScreenshotUtils").i("return no path");
        return "";
    }

    @Override // ud.a, com.bytedance.android.livesdkapi.room.handler.observe.ConfigObserver
    public final void onChanged(Object r100) {
        String r101 = (String) r100;
        if (TextUtils.isEmpty(r101) == false) goto L5;
        this.f153080b.invoke(null, "no path");
        return;
    L5:
        nl2.b.b(Observable.create(new d0(this, r101)).observeOn(AndroidSchedulers.mainThread()).subscribe(new e0(this)));
    }

    public f0(Context r100, Function2 r101) {
        this.f153079a = r100;
        this.f153080b = r101;
    }
}
