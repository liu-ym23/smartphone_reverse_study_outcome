package com.bytedance.android.live.emoji.utils;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.android.live.user.IUserService;
import jc1.k;

/* JADX INFO: loaded from: classes45.dex */
public final class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static a f68946c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile String f68947d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SharedPreferences f68948a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SharedPreferences f68949b;

    public static synchronized a a() {
        monitor-enter(a.class);
    L26:
        th = move-exception;
        throw th;
    L5:
        if (((IUserService) k.f(IUserService.class)) == null) goto L7;
        String r100 = ((IUserService) k.f(IUserService.class)).user().n();     // Catch: Throwable -> L26
    L9:
        if (f68946c == null) goto L13;
        if (TextUtils.equals(r100, f68947d) == false) goto L13;
    L20:
        a r101 = f68946c;     // Catch: Throwable -> L26
        monitor-exit(a.class);
        return r101;
    L13:
        monitor-enter(a.class);     // Catch: Throwable -> L26
    L23:
        th = move-exception;
        throw th;     // Catch: Throwable -> L26
    L15:
        if (f68946c != null) goto L17;
    L18:
        f68946c = new a();     // Catch: Throwable -> L23
    L19:
        monitor-exit(a.class);     // Catch: Throwable -> L23
    L17:
        if (TextUtils.equals(r100, f68947d) == true) goto L19;
    L7:
        r100 = "0";
        goto L9
    }

    public a() {
        if (((IUserService) k.f(IUserService.class)) == null) goto L5;
        f68947d = ((IUserService) k.f(IUserService.class)).user().n();
    L6:
        this.f68948a = jc1.a.b().getSharedPreferences("aweme_emoji_" + f68947d, 0);
        this.f68949b = jc1.a.b().getSharedPreferences("aweme_emoji", 0);
        return;
    L5:
        f68947d = "0";
        goto L6
    }
}
