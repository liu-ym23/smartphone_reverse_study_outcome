package com.bytedance.android.livesdk.chatroom.replay.toolbar;

import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class ReplayToolbarFilterUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f109966a = 0;

    static {
    }

    public static Function1 a() {
        return ReplayToolbarFilterUtils$getCastScreenSaasFilter$1.INSTANCE;
    }

    public static Function1 e() {
        return ReplayToolbarFilterUtils$getVideoSaasFilter$1.INSTANCE;
    }

    public static Function1 b(final DataCenter r100) {
        Intrinsics.checkNotNullParameter(r100, "dataCenter");
        return new ReplayToolbarFilterUtils$getTicketSaleFilter$1(r100);
    }

    public static Function1 c(final DataCenter r100) {
        Intrinsics.checkNotNullParameter(r100, "dataCenter");
        return new ReplayToolbarFilterUtils$getVSMsgBoardFilter$1(r100);
    }

    @JvmStatic
    public static final Function1<e, Boolean> d(DataCenter r100) {
        Intrinsics.checkNotNullParameter(r100, "dataCenter");
        return ReplayToolbarFilterUtils$getVideoFilter$1.INSTANCE;
    }
}
