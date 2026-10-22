package com.bytedance.android.livesdk.saas.impl.utils;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.android.live.base.IService;
import de1.b;
import jc1.k;
import kotlin.Metadata;
import ys2.c;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J-\u0010\u0003\u001a\u00020\u0004\"\b\b\u0000\u0010\u0005*\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00050\b2\u0006\u0010\t\u001a\u0002H\u0005H\u0002¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/saas/impl/utils/ModuleContext;", "", "()V", "registerService", "", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/bytedance/android/live/base/IService;", "serviceClass", "Ljava/lang/Class;", "service", "(Ljava/lang/Class;Lcom/bytedance/android/live/base/IService;)V", "live-impl-saas_release"}, k = 1, mv = {1, 4, 3})
public final class ModuleContext {
    public ModuleContext() {
        registerService(b.class, new c());
    }

    private final <T extends IService> void registerService(Class<T> r100, T r101) {
        k.l(r100, r101);
    }
}
