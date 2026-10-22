package com.bytedance.android.livesdk.interactivity.pin.container.v2;

import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.livesdk.interactivity.api.pin.container.PinType;
import com.bytedance.android.livesdk.interactivity.pin.business.comment.api.ChatHighlightRequest;
import com.bytedance.android.livesdk.interactivity.pin.business.comment.api.PinCommentApi;
import com.bytedance.android.livesdk.interactivity.pin.ui.PinAndQARemoveDialog;
import com.bytedance.android.livesdk.wrds.syncdata.highlight.HighlightContainerSyncData;
import com.bytedance.android.livesdk.wrds.syncdata.highlight.HighlightItem;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import g42.l;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes9.dex */
public final class g implements PinAndQARemoveDialog.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PinContainerHighlightProcessor f138856a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function0 f138857b;

    @Override // com.bytedance.android.livesdk.interactivity.pin.ui.PinAndQARemoveDialog.a
    public final void a() {
        PinContainerHighlightProcessor r100 = this.f138856a;
        r100.getClass();
        o32.a.a("removeAllPinItems");
        ChatHighlightRequest r101 = new ChatHighlightRequest();
        r101.actionType = 4;
        DataCenter r102 = r100.getDataCenter();
        if (r102 == null) goto L7;
        Room r103 = z.o(r102);
        if (r103 == null) goto L7;
        long r104 = r103.getRoomId();
    L8:
        r101.roomId = r104;
        r101.scene = "comment_highlight";
        dc2.c<HighlightContainerSyncData> r105 = r100.v();
        if (r105 == null) goto L15;
        HighlightContainerSyncData r106 = r105.c();
        if (r106 == null) goto L15;
        List<HighlightItem> r107 = r106.getHighlightItems();
        if (r107 == null) goto L15;
        ArrayList r108 = new ArrayList(r107);
    L16:
        l r109 = new l(PinType.All, new Object(), 0);
        long r110 = System.currentTimeMillis();
        PinCommentApi.f138666a.getClass();
        RxUtilKt.c(((PinCommentApi) com.bytedance.android.live.network.c.b().e(PinCommentApi.class)).pin(r101.toRequestFieldMap()).compose(RxUtil.rxSchedulerHelper()).subscribe(new e(r100, r109, r110, r108), new f(r100, r109, r110)), r100.f527562e);
        return;
    L15:
        r108 = null;
    L7:
        r104 = 0;
        goto L8
    }

    @Override // com.bytedance.android.livesdk.interactivity.pin.ui.PinAndQARemoveDialog.a
    public final void b() {
        this.f138857b.invoke();
    }

    public g(PinContainerHighlightProcessor r100, Function0 r101) {
        this.f138856a = r100;
        this.f138857b = r101;
    }
}
