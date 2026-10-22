package com.bytedance.android.live.emoji.online;

import bolts.Task;
import com.bytedance.android.live.core.log.ALogger;
import java.util.concurrent.Callable;
import kotlin.Unit;

/* JADX INFO: loaded from: classes45.dex */
public final class h<V> implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OnlineSmallEmojiResManager f68936a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f68937b;

    public h(OnlineSmallEmojiResManager r100, boolean r101) {
        this.f68936a = r100;
        this.f68937b = r101;
    }

    @Override // java.util.concurrent.Callable
    public final void call() {
        OnlineSmallEmojiResManager r100 = this.f68936a;
        boolean r101 = this.f68937b;
        r100.getClass();
        String r102 = com.bytedance.android.live.emoji.utils.a.a().f68949b.getString("key_small_emoji_md5", "");
        if (r102.length() != 0) goto L5;
        boolean r103 = true;
    L7:
        if (r103 == false) goto L10;
        ALogger.d("OnlineEmojiResManager", " preloadResourceInfo lastCacheMd5 empty");
        return;
    L10:
        if (r100.f68921h == false) goto L13;
        if (r101 == true) goto L13;
        ALogger.d("OnlineEmojiResManager", " resource has loaded");
        return;
    L13:
        r100.f68921h = true;
        r100.f68918e = r102;
        r100.f68919f = 1;
        Task.callInBackground(new f(r102)).continueWith(new g(r100, r102));
        return;
    L5:
        r103 = false;
        goto L7
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Object call() {
        call();
        return Unit.INSTANCE;
    }
}
