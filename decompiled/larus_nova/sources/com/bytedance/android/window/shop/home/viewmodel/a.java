package com.bytedance.android.window.shop.home.viewmodel;

import com.bytedance.android.livesdk.end.LiveEndPageData;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicLong f189025a = null;

    public a() {
    }

    static {
        f189025a = new AtomicLong(Long.MIN_VALUE);
    }

    public static String a() {
        Intrinsics.checkNotNullParameter(LiveEndPageData.TAG_WINDOW, "prefix");
        return LiveEndPageData.TAG_WINDOW + '_' + f189025a.getAndIncrement();
    }
}
