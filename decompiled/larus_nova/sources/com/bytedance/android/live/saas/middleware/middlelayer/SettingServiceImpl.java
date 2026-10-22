package com.bytedance.android.live.saas.middleware.middlelayer;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.android.live.core.setting.SettingUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import vm0.a;
import vm0.b;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ%\u0010\u0005\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/bytedance/android/live/saas/middleware/middlelayer/SettingServiceImpl;", "Lvm0/a;", ExifInterface.GPS_DIRECTION_TRUE, "Lvm0/b;", "setting", "getValue", "(Lvm0/b;)Ljava/lang/Object;", "<init>", "()V", "middleware_release"}, k = 1, mv = {1, 4, 3})
public final class SettingServiceImpl implements a {
    public SettingServiceImpl() {
    }

    @Override // vm0.a
    public <T> T getValue(b<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "setting");
        if (SettingUtil.isDebugMode() == false) goto L7;
        return r100.f555734c;
    L7:
        return (T) SettingUtil.getValue("key_ttlive_sdk_setting", r100.f555732a, r100.getType(), r100.f555733b, r100.f555736e);
    }
}
