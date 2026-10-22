package com.bytedance.android.livesdk.room.utils;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.android.livesdk.log.filter.o;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0003\"\u0004\b\u0000\u0010\u00002\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Ljava/lang/Class;", "clz", "Lcom/bytedance/android/livesdk/log/filter/o;", AbsMethodDelegate.TAG_INVOKE, "(Ljava/lang/Class;)Lcom/bytedance/android/livesdk/log/filter/o;", "getLiveLogFilter"}, k = 3, mv = {1, 4, 3})
public final class RoomEnterInfoExtKt$makeEnterRoomSource$1 extends Lambda implements Function1 {
    public static final RoomEnterInfoExtKt$makeEnterRoomSource$1 INSTANCE = null;

    static {
        INSTANCE = new RoomEnterInfoExtKt$makeEnterRoomSource$1();
    }

    public RoomEnterInfoExtKt$makeEnterRoomSource$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Object r100) {
        return invoke((Class) r100);
    }

    public final <T> o<?> invoke(Class<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "clz");
        return j0.l().c(r100);
    }
}
