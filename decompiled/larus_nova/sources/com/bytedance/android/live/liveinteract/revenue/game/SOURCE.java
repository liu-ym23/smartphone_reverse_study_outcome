package com.bytedance.android.live.liveinteract.revenue.game;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;

/* JADX INFO: loaded from: classes46.dex */
@Retention(RetentionPolicy.SOURCE)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003B\u0000¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/liveinteract/revenue/game/SOURCE;", "", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
@kotlin.annotation.Retention(AnnotationRetention.SOURCE)
public @interface SOURCE {
    public static final a Companion = null;
    public static final int SOURCE_ENTER_ROOM = 0;
    public static final int SOURCE_LEAVE_ROOM = 3;
    public static final int SOURCE_START_GAME_IN_ROOM = 1;
    public static final int SOURCE_STOP_GAME_IN_ROOM = 2;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f78311a = null;

        public a() {
        }

        static {
            f78311a = new a();
        }
    }

    static {
        Companion = a.f78311a;
    }
}
