package am0;

import com.bytedance.android.live.room.api.messagewindow.identity.CardTypeAndPriority;
import com.bytedance.android.live.room.api.messagewindow.model.CommonCardConstant$Position;
import com.bytedance.android.live.room.api.messagewindow.monitor.i;
import com.bytedance.android.livesdk.message.model.w1;
import com.bytedance.android.livesdk.message.model.x1;
import com.ss.android.lark.passport.signinsdk_api.entity.EnvConst$GEO;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import s71.d;
import s71.e;
import s71.g;
import v61.c;

/* JADX INFO: loaded from: classes46.dex */
public final class b implements g<v61.a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final w1 f4223a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final x1 f4224b;

    public b(w1 r100, x1 r101) {
        this.f4223a = r100;
        this.f4224b = r101;
    }

    @Override // s71.g
    public final d a(v61.a r100, c r101) {
        v61.a r102 = (v61.a) r101;
        Intrinsics.checkNotNullParameter(r100, EnvConst$GEO.US);
        Intrinsics.checkNotNullParameter(r102, "others");
        if (r100.f553380k < r102.f553380k) goto L6;
        return d.c.f540906a;
    L6:
        if (Intrinsics.areEqual(r102.f553379j, CardTypeAndPriority.AudienceLink.getType()) == true) goto L25;
        if (Intrinsics.areEqual(r102.f553379j, CardTypeAndPriority.VideoTalk.getType()) == true) goto L25;
        if (Intrinsics.areEqual(r102.f553379j, CardTypeAndPriority.DrawAndGuess.getType()) == true) goto L25;
        if (Intrinsics.areEqual(r102.f553379j, CardTypeAndPriority.WatchVideo.getType()) == true) goto L25;
        w1 r103 = this.f4223a;
        if (r103 == null) goto L30;
        int r104 = r103.type;
        if (r104 == 1) goto L29;
        if (r104 == 2) goto L28;
        return d.a.f540904a;
    L28:
        return d.a.f540904a;
    L29:
        return new d.b(0);
    L30:
        return new d.b(0);
    L25:
        return d.C7580d.f540907a;
    }

    @Override // s71.g
    public final e b(c r100, v61.a r101) {
        v61.a r102 = (v61.a) r100;
        Intrinsics.checkNotNullParameter(r102, EnvConst$GEO.US);
        Intrinsics.checkNotNullParameter(r101, "winner");
        i r103 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
        if (r103 == null) goto L7;
        com.bytedance.android.live.room.api.messagewindow.monitor.c r104 = new com.bytedance.android.live.room.api.messagewindow.monitor.c("livesdk_common_card_fail_show");
        r104.b("type", r102.f553379j.toString());
        r104.b("reason", "2");
        r104.b("extra", "winner card: " + r101.f553379j.toString() + ", winner card priority: " + r101.f553380k + ", us priority: " + r102.f553380k);
        Unit r105 = Unit.INSTANCE;
        r103.b(r104.a());
    L7:
        if (r102.isShowing() == false) goto L13;
        i r106 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
        if (r106 == null) goto L13;
        com.bytedance.android.live.room.api.messagewindow.monitor.c r107 = new com.bytedance.android.live.room.api.messagewindow.monitor.c("livesdk_common_card_destroy");
        r107.b("position", Integer.valueOf(CommonCardConstant$Position.BOTTOM_RIGHT.getValue()));
        r107.b("type", r102.f553379j.toString());
        r107.b("reason", "3");
        Unit r108 = Unit.INSTANCE;
        r106.b(r107.a());
    L13:
        if (Intrinsics.areEqual(r101.f553379j, CardTypeAndPriority.AudienceLink.getType()) == true) goto L32;
        if (Intrinsics.areEqual(r101.f553379j, CardTypeAndPriority.VideoTalk.getType()) == true) goto L32;
        if (Intrinsics.areEqual(r101.f553379j, CardTypeAndPriority.DrawAndGuess.getType()) == true) goto L32;
        if (Intrinsics.areEqual(r101.f553379j, CardTypeAndPriority.WatchVideo.getType()) == true) goto L32;
        x1 r109 = this.f4224b;
        if (r109 == null) goto L36;
        int r110 = r109.type;
        if (r110 == 1) goto L35;
        if (r110 == 2) goto L34;
        return s71.a.f540900a;
    L34:
        return s71.a.f540900a;
    L35:
        return new s71.c(0);
    L36:
        return s71.a.f540900a;
    L32:
        return s71.b.f540901a;
    }
}
