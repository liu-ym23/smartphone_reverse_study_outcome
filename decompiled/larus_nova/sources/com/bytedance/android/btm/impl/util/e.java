package com.bytedance.android.btm.impl.util;

import com.bytedance.android.btm.impl.setting.BtmSetting;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.collections.CollectionsKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes43.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicLong f42500a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AtomicLong f42501b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final AtomicLong f42502c = null;

    static {
        f42500a = new AtomicLong();
        f42501b = new AtomicLong();
        f42502c = new AtomicLong();
    }

    public static String b() {
        AtomicLong r100 = f42502c;
        long r101 = r100.incrementAndGet();
        if (r101 <= 10000) goto L6;
        r100.set(0);
    L6:
        return "" + System.currentTimeMillis() + "_" + r101;
    }

    public static String c() {
        AtomicLong r100 = f42500a;
        long r101 = r100.incrementAndGet();
        if (r101 <= 10000) goto L6;
        r100.set(0);
    L6:
        return "" + System.currentTimeMillis() + r101;
    }

    public static String a(String r100, String r101) {
        if (BtmSetting.f42469d.c().c().x() != 1) goto L17;
        if (r101 == null) goto L13;
        List r102 = StringsKt.split$default(r101, new String[]{"#"}, false, 0, 6, null);
        if (r102 == null) goto L13;
        String r103 = (String) CollectionsKt.getOrNull(r102, 1);
        if (r103 == null) goto L13;
        Long r104 = StringsKt.toLongOrNull(r103);
        if (r104 == null) goto L13;
        long r105 = r104.longValue();
    L15:
        return r100 + "#" + (r105 + 1);
    L13:
        r105 = 0;
        goto L15
    L17:
        return UUID.randomUUID().toString();
    }
}
