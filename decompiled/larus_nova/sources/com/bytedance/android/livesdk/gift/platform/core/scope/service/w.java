package com.bytedance.android.livesdk.gift.platform.core.scope.service;

import com.bytedance.android.livesdkapi.depend.model.live.RoomIntroLabel;
import com.bytedance.common.utility.DigestUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import io.reactivex.disposables.Disposable;
import java.io.File;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class w implements com.bytedance.android.scope.o, dy0.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<String, Integer> f131817a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Disposable f131818b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f131819c;

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
    }

    public w() {
        this.f131817a = new ConcurrentHashMap();
        this.f131819c = true;
    }

    public final void a(String r100, z3.a r101) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r101, "callback");
        String r102 = DigestUtils.md5Hex(UriProtector.parse(r100).getPath()) + RoomIntroLabel.ICON_URL_SUFFIX_DEFAULT;
        this.f131819c = true;
        Downloader.with(com.bytedance.android.live.core.utils.s1.getContext()).url(r100).name(r102).savePath(com.bytedance.android.live.core.utils.s1.getContext().getDir("activity_image", 0).getAbsolutePath() + File.separator).monitorScene("activity_image").mainThreadListener(new v(r101, r100)).asyncDownload(new u(this, r100));
    }
}
