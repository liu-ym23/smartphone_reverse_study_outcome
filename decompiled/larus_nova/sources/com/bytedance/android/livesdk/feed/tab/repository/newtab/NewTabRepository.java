package com.bytedance.android.livesdk.feed.tab.repository.newtab;

import com.bytedance.android.livesdk.feed.tab.repository.l;
import com.bytedance.android.livesdk.feed.tab.repository.s;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class NewTabRepository extends l {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy f124511d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Lazy f124512e = null;

    public static final class a {
    }

    static {
        f124511d = LazyKt.lazy(NewTabRepository$Companion$drawerRepository$2.INSTANCE);
        f124512e = LazyKt.lazy(NewTabRepository$Companion$multiTabRepository$2.INSTANCE);
    }

    public NewTabRepository(s r100, b r101) {
        Intrinsics.checkNotNullParameter(r100, "local");
        Intrinsics.checkNotNullParameter(r101, "remote");
        super(r100, r101);
    }
}
