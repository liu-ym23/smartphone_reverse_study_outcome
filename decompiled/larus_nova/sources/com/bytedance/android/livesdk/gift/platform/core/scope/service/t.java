package com.bytedance.android.livesdk.gift.platform.core.scope.service;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import java.io.File;
import java.util.Iterator;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class t<T> implements SingleOnSubscribe {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ w f131742a;

    public t(w r100) {
        this.f131742a = r100;
    }

    @Override // io.reactivex.SingleOnSubscribe
    public final void subscribe(SingleEmitter<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        Iterator<Map.Entry<String, Integer>> r101 = this.f131742a.f131817a.entrySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        Map.Entry<String, Integer> r102 = r101.next();
        String r103 = r102.getKey();
        int r104 = r102.getValue().intValue();
        Downloader.getInstance(com.bytedance.android.live.core.utils.s1.getContext()).cancel(r104);
        goto L4
    L6:
        this.f131742a.getClass();
        int r105 = 0;
        PolarisFileWrapper r106 = new PolarisFileWrapper(com.bytedance.android.live.core.utils.s1.getContext().getDir("activity_image", 0).getAbsolutePath());
        if (r106.exists() == true) goto L9;
        return;
    L9:
        if (r106.isDirectory() == false) goto L25;
        File[] r107 = r106.listFiles();
        if (r107 == null) goto L18;
        int r108 = r107.length;
    L13:
        if (r105 >= r108) goto L18;
        File r109 = r107[r105];
        if (r109.exists() == false) goto L17;
        com.bytedance.android.live.revenue.common.c0.b(r109);
    L17:
        r105 = r105 + 1;
    L18:
        r100.onSuccess(Unit.INSTANCE);
        return;
    }
}
