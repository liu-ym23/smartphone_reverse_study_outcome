package com.bytedance.android.livesdk.dslservice.util;

import am2.x;
import com.bytedance.android.livesdkapi.depend.log.LogFilterName;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import java.util.HashMap;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes8.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final HashMap<String, Class<?>> f122998a = null;

    static {
        f122998a = MapsKt.hashMapOf(new Pair[]{TuplesKt.to(LogFilterName.PAGE_SOURCE_LOG, x.class), TuplesKt.to(LogFilterName.ROOM, IRoom.class)});
    }
}
