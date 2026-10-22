package com.bytedance.android.shopping.store.viewmodel;

import android.view.KeyCharacterMap;
import com.vivo.push.PushClientConstants;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes14.dex */
public final class h implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<KClass<?>, i> f187022a;

    public h() {
        this.f187022a = new ConcurrentHashMap();
    }

    public final <T extends i> void d(KClass<?> r100, T r101) {
        Intrinsics.checkNotNullParameter(r100, PushClientConstants.TAG_CLASS_NAME);
        Intrinsics.checkNotNullParameter(r101, "instance");
        if (this.f187022a.containsKey(Reflection.getOrCreateKotlinClass(r100.getClass())) == true) goto L7;
        this.f187022a.put(r100, r101);
        return;
    L7:
        throw new KeyCharacterMap.UnavailableException("重复设置function");
    }
}
