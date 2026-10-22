package com.bytedance.android.live.effect.composer;

import com.bytedance.android.livesdkapi.depend.model.Sticker;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, List<Sticker>> f67931a;

    public b(final String r100) {
        Intrinsics.checkNotNullParameter(r100, "dbName");
        Intrinsics.checkNotNullParameter(r100, "dbName");
        LazyKt.lazy(new LiveComposerNodeListCache$composerSQLiteHelper$2(r100));
        new ArrayList();
        new ArrayList();
        this.f67931a = new HashMap();
    }
}
