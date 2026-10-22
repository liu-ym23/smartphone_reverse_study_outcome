package com.bytedance.android.live.effect.sticker.presenter;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.effect.sticker.api.AigcBackgroundImageGenerateTask;
import com.bytedance.android.live.effect.sticker.api.LiveEffectApi;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<Long, AigcBackgroundImageGenerateTask> f68318a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<Long> f68319b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<Long> f68320c;

    public static final class a {
    }

    static {
    }

    public g(Map<Long, AigcBackgroundImageGenerateTask> r100) {
        Intrinsics.checkNotNullParameter(r100, "initTaskMap");
        LinkedHashMap r101 = new LinkedHashMap();
        this.f68318a = r101;
        ArrayList r102 = new ArrayList();
        this.f68319b = r102;
        ArrayList r103 = new ArrayList();
        this.f68320c = r103;
        r101.clear();
        r102.clear();
        r103.clear();
        Iterator<Map.Entry<Long, AigcBackgroundImageGenerateTask>> r104 = r100.entrySet().iterator();
    L4:
        if (r104.hasNext() == false) goto L6;
        Map.Entry<Long, AigcBackgroundImageGenerateTask> r105 = r104.next();
        a(r105.getKey().longValue(), r105.getValue());
        goto L4
    }

    public final void a(long r100, AigcBackgroundImageGenerateTask r101) {
        Intrinsics.checkNotNullParameter(r101, "task");
        this.f68318a.put(Long.valueOf(r100), r101);
        int r102 = r101.getStatus();
        if (r102 != LiveEffectApi.AigcTaskStatus.RUNNING.getValue()) goto L6;
        this.f68319b.add(Long.valueOf(r100));
        return;
    L6:
        if (r102 != LiveEffectApi.AigcTaskStatus.FINISH.getValue()) goto L8;
        this.f68320c.add(Long.valueOf(r100));
        return;
    L8:
        ALogger.e("ttlive_anchor_effect_LiveEffectAigcTaskManager", "illegal task status: " + r101.getStatus());
    }
}
