package com.bytedance.android.livesdk.room.Task.base;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\b\u001a\u00020\u0005\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0002*\u00020\u00002\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0003H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lls2/c;", ExifInterface.GPS_DIRECTION_TRUE, "R", "Lcom/bytedance/android/livesdk/room/Task/base/a;", "it", "", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/android/livesdk/room/Task/base/a;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final class LiveBizTask$withContexts$1 extends Lambda implements Function1<a<ls2.c, ls2.c>, Unit> {
    public static final LiveBizTask$withContexts$1 INSTANCE = null;

    static {
        INSTANCE = new LiveBizTask$withContexts$1();
    }

    public LiveBizTask$withContexts$1() {
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(a<ls2.c, ls2.c> r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(a<ls2.c, ls2.c> r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
