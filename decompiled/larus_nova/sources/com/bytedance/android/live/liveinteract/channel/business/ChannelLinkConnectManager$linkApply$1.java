package com.bytedance.android.live.liveinteract.channel.business;

import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 5, 1})
final class ChannelLinkConnectManager$linkApply$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ long $channelId;
    final /* synthetic */ long $roomId;
    final /* synthetic */ b this$0;

    public static final class a<T> implements Consumer {
    }

    public ChannelLinkConnectManager$linkApply$1(b r100, long r101, long r102) {
        this.$roomId = r101;
        this.$channelId = r102;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        int r100 = nd0.a.f518744a;
        long r101 = this.$roomId;
        long r102 = this.$channelId;
        LinkMonitorData r103 = LinkMonitorData.ChannelApiStartLinkApply;
        Intrinsics.checkNotNullParameter("normal", "reason");
        Intrinsics.checkNotNullParameter(r103, "linkMonitorData");
        JSONObject r104 = new JSONObject();
        r104.put("target_room_id", r101);
        r104.put("target_channel_id", r102);
        r104.put("reason", "normal");
        nd0.c.o(nd0.c.f518746a, r103, r104, 0, null, false, 28);
        System.currentTimeMillis();
        throw null;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
