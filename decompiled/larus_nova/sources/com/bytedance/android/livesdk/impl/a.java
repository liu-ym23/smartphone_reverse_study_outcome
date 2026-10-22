package com.bytedance.android.livesdk.impl;

import com.bytedance.android.livesdkapi.depend.model.live.room.RoomBaseSession;
import com.ss.android.downloadlib.constants.DownloadSettingKeys;
import is2.d;
import is2.e;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class a implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Set<Function2<d, RoomBaseSession, Unit>> f132646a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f132647b = null;

    public a() {
    }

    static {
        f132647b = new a();
        f132646a = new LinkedHashSet();
    }

    @Override // is2.e
    public final void E3(Function2<? super d, ? super RoomBaseSession, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, DownloadSettingKeys.KEY_HOOK);
        f132646a.add(r100);
    }
}
