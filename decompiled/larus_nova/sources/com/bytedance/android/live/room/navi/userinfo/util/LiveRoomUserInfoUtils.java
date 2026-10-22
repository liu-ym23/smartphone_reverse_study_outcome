package com.bytedance.android.live.room.navi.userinfo.util;

import android.view.View;
import com.bytedance.android.livesdk.utils.q4;
import com.bytedance.android.livesdk.utils.u4;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.functions.Action;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class LiveRoomUserInfoUtils {

    public static final class a implements Action {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ q4.b f99809a;

        public a(q4.b r100) {
            this.f99809a = r100;
        }

        @Override // io.reactivex.functions.Action
        public final void run() {
            this.f99809a.a();
        }
    }

    static {
    }

    @JvmStatic
    public static final <T extends View, R extends View> Disposable a(T r100, R r101, long r102, Function2<? super T, ? super R, Unit> r110) {
        Intrinsics.checkNotNullParameter(r100, "showView");
        Intrinsics.checkNotNullParameter(r101, "hideView");
        Intrinsics.checkNotNullParameter(r110, "onEndOrCancel");
        q4.b r103 = u4.c(new LiveRoomUserInfoUtils$getAndStartReplaceAnim$controller$1(r100, r101, r110, r102));
        r103.c();
        return Disposables.fromAction(new a(r103));
    }
}
