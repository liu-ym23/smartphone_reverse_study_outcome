package com.bytedance.android.live.emoji.utils;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.emoji.online.OnlineSmallEmojiResManager;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class EmojiResHelper implements r90.c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static EmojiResHelper f68943c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public r90.c f68944a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f68945b;

    public static final class a {
        @JvmStatic
        public static EmojiResHelper a(Context r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            if (EmojiResHelper.f68943c == null) goto L5;
        L15:
            EmojiResHelper r101 = EmojiResHelper.f68943c;
            Intrinsics.checkNotNull(r101);
            return r101;
        L5:
            monitor-enter(EmojiResHelper.class);
        L12:
            th = move-exception;
            throw th;
        L7:
            if (EmojiResHelper.f68943c != null) goto L9;
            EmojiResHelper.f68943c = new EmojiResHelper();     // Catch: Throwable -> L12
        L9:
            Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L12
            monitor-exit(EmojiResHelper.class);
            goto L15
        }
    }

    static {
    }

    public final r90.c e() {
        if (((Boolean) this.f68945b.getValue()).booleanValue() == false) goto L18;
        int r100 = com.bytedance.android.live.emoji.online.b.f68925a;
        if (OnlineSmallEmojiResManager.f68913i.d() == false) goto L18;
        r90.c r101 = this.f68944a;
        if (r101 != null) goto L10;
    L11:
        monitor-enter(this);
        this.f68944a = new com.bytedance.android.live.emoji.online.b();     // Catch: Throwable -> L15
        ALogger.d("EmojiResHelper", " init online adapter");     // Catch: Throwable -> L15
        Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L15
        monitor-exit(this);
    L25:
        r90.c r103 = this.f68944a;
        Intrinsics.checkNotNull(r103);
        return r103;
    L15:
        th = move-exception;
        throw th;
    L10:
        if ((r101 instanceof r90.d) == false) goto L25;
    L18:
        r90.c r104 = this.f68944a;
        if (r104 != null) goto L21;
    L22:
        monitor-enter(this);
        this.f68944a = new r90.d(jc1.a.b());     // Catch: Throwable -> L27
        ALogger.d("EmojiResHelper", " init local adapter");     // Catch: Throwable -> L27
        Unit r105 = Unit.INSTANCE;     // Catch: Throwable -> L27
        monitor-exit(this);
    L27:
        th = move-exception;
        throw th;
    L21:
        if ((r104 instanceof com.bytedance.android.live.emoji.online.b) == false) goto L25;
        goto L22
    }

    public EmojiResHelper() {
        this.f68945b = LazyKt.lazy(EmojiResHelper$disableOnline$2.INSTANCE);
    }

    @Override // r90.c
    public final int c() {
        return e().c();
    }

    @Override // r90.c
    public final List b(List r100) {
        return e().b(r100);
    }

    @Override // r90.c
    public final List d(int r100) {
        return e().d(r100);
    }

    @Override // r90.c
    public final Drawable a(Context r100, String r101) {
        return e().a(r100, r101);
    }
}
