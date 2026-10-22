package com.bytedance.android.livesdk.gift.platform.core.manager;

import com.bytedance.android.live.gift.GiftType;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes9.dex */
public final class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static a f130790b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<GiftType, ca0.b> f130791a;

    public static a b() {
        if (f130790b != null) goto L6;
        f130790b = new a();
    L6:
        return f130790b;
    }

    public a() {
        this.f130791a = new HashMap();
    }

    public final ca0.b a(GiftType r100) {
        return (ca0.b) ((HashMap) this.f130791a).get(r100);
    }
}
