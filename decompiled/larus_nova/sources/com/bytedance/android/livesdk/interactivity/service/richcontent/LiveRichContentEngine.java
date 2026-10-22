package com.bytedance.android.livesdk.interactivity.service.richcontent;

import ak6.b;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes9.dex */
public final class LiveRichContentEngine {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f140942a = null;

    public static b a() {
        return (b) f140942a.getValue();
    }

    static {
        f140942a = LazyKt.lazy(LiveRichContentEngine$richContentEngine$2.INSTANCE);
    }
}
