package com.bytedance.android.live.room.navi.userinfo.viewmodel;

import android.os.Looper;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.live.datacontext.MutableMemberConfig;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "", "Lcom/bytedance/live/datacontext/MutableMemberConfig;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final class UserInfoContextExtKt$directMutable$1 extends Lambda implements Function1<MutableMemberConfig<Object>, Unit> {
    public static final UserInfoContextExtKt$directMutable$1 INSTANCE = null;

    static {
        INSTANCE = new UserInfoContextExtKt$directMutable$1();
    }

    public UserInfoContextExtKt$directMutable$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(MutableMemberConfig<Object> r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(MutableMemberConfig<Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "$receiver");
        if ((!Intrinsics.areEqual(ThreadMethodProxy.currentThread(), ThreadMethodProxy.getLooperThread(Looper.getMainLooper()))) == false) goto L5;
        Scheduler r101 = AndroidSchedulers.mainThread();
    L6:
        r100.f255087c = r101;
        return;
    L5:
        r101 = null;
        goto L6
    }
}
