package com.bytedance.android.livesdk.toolbarservice;

import android.content.Context;
import android.view.ViewGroup;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.live.room.api.base.alog.SimpleAlogArgsBuilder;
import com.bytedance.android.livesdk.arch.comp.b;
import com.bytedance.android.livesdk.arch.comp.h;
import com.bytedance.android.livesdk.arch.comp.i;
import com.bytedance.android.livesdk.arch.context.TbContext;
import com.bytedance.android.livesdk.arch.data.TbDataProcessService;
import com.bytedance.android.livesdk.arch.data.g;
import com.bytedance.android.livesdk.arch.data.q;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.p005new.BottomToolbarViewModel;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.utils.j;
import com.bytedance.android.livesdk.toolbarservice.api.IToolbarService;
import com.bytedance.android.livesdkapi.room.handler.toolbar.ToolbarMatchInterface;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.DataContext;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.Map;
import jc1.k;
import ke1.a;
import ke1.d;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import ot2.c;
import ot2.f;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0017\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b!\u0010\"J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J \u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\u001c\u0010\u0013\u001a\u00020\u00122\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J.\u0010\u0017\u001a\u00020\u00162\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J0\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00160\u001f2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u000e2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001e\u001a\u00020\u001dH\u0016¨\u0006#"}, d2 = {"Lcom/bytedance/android/livesdk/toolbarservice/ToolbarServiceImpl;", "Lcom/bytedance/android/livesdk/toolbarservice/api/IToolbarService;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", "Lot2/c;", "createBottomToolbarViewModelImpl", "Lot2/f;", "toolbarUtil", "Lcom/bytedance/android/livesdk/chatroom/MiddlewareRoomContext;", "roomContext", "Lcom/bytedance/live/datacontext/DataContext;", "initTbContext", "Lcom/bytedance/android/livesdk/arch/context/a;", "getTbContext", "Lke1/a;", "tbMonitor", "Lcom/bytedance/android/livesdk/arch/data/g;", "createDataProcessService", "Lcom/bytedance/android/livesdk/arch/data/q;", "tbDataSource", "Lcom/bytedance/android/livesdk/arch/comp/b;", "createTbComp", "Lcom/bytedance/android/livesdk/arch/container/d;", "type", "tbContext", "Lot2/d;", "compContainer", "Landroid/view/ViewGroup;", KtvSubElement.CONTAINER, "Lcom/bytedance/android/livesdk/arch/container/a;", "createTbContainer", "<init>", "()V", "toolbarservice-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class ToolbarServiceImpl implements IToolbarService {
    public ToolbarServiceImpl() {
        k.l(IToolbarService.class, this);
    }

    @Override // com.bytedance.android.livesdk.toolbarservice.api.IToolbarService
    public a tbMonitor() {
        return d.f503005h;
    }

    @Override // com.bytedance.android.livesdk.toolbarservice.api.IToolbarService
    public f toolbarUtil() {
        return j.f116811a;
    }

    @Override // com.bytedance.android.livesdk.toolbarservice.api.IToolbarService
    public c createBottomToolbarViewModelImpl(Context r100, DataCenter r101) {
        Intrinsics.checkNotNullParameter(r101, "dataCenter");
        return new BottomToolbarViewModel(r101);
    }

    @Override // com.bytedance.android.livesdk.toolbarservice.api.IToolbarService
    public g createDataProcessService(MiddlewareRoomContext r100, DataCenter r101) {
        return new TbDataProcessService(r100, r101);
    }

    @Override // com.bytedance.android.livesdk.toolbarservice.api.IToolbarService
    public com.bytedance.android.livesdk.arch.context.a getTbContext(MiddlewareRoomContext r100, DataCenter r101) {
        TbContext.Companion.getClass();
        TbContext r102 = TbContext.b.a(r100);
        if (r102 == null) goto L5;
        return r102;
    L5:
        return TbContext.b.b(r101);
    }

    @Override // com.bytedance.android.livesdk.toolbarservice.api.IToolbarService
    public DataContext initTbContext(Context r100, MiddlewareRoomContext r101, DataCenter r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "roomContext");
        Intrinsics.checkNotNullParameter(r102, "dataCenter");
        return new TbContext(r100, r101, r102);
    }

    @Override // com.bytedance.android.livesdk.toolbarservice.api.IToolbarService
    public b createTbComp(Context r100, MiddlewareRoomContext r101, DataCenter r102, q r110) {
        Intrinsics.checkNotNullParameter(r110, "tbDataSource");
        int r103 = com.bytedance.android.livesdk.arch.comp.j.f103743a;
        com.bytedance.android.livesdk.arch.comp.f r104 = new com.bytedance.android.livesdk.arch.comp.f(r100, r101, r102, r110);
        Intrinsics.checkNotNullParameter(r104, "params");
        Map r105 = null;
        if (r104.getContext() != null) goto L5;
    L8:
        a.f502996a.getClass();
        a r106 = a.C6543a.a();
        if (r106 == null) goto L33;
        Map r111 = MapsKt.mapOf(new Pair[]{TuplesKt.to(PerfLog.PARAM_KEY_CONTEXT_ID, String.valueOf(r104.getContext())), TuplesKt.to("roomContext", String.valueOf(r104.f103734b)), TuplesKt.to("dataCenter", String.valueOf(r104.f103735c))});
        SimpleAlogArgsBuilder r107 = new SimpleAlogArgsBuilder();
        r107.c("RoomTbCompFactory create comp");
        if (r111 != null) goto L13;
    L21:
        Unit r108 = Unit.INSTANCE;
        r106.c(r107.b());
        ke1.f.a r109 = new ke1.f.a("RoomTbCompFactory create comp");
        if (r111 != null) goto L24;
    L32:
        Unit r112 = Unit.INSTANCE;
        r106.a(new ke1.f(r109));
        goto L33
    L24:
        if ((!r111.isEmpty()) == true) goto L27;
        r111 = null;
    L27:
        if (r111 == null) goto L32;
        Iterator r113 = r111.entrySet().iterator();
    L30:
        if (r113.hasNext() == false) goto L32;
        Map.Entry r114 = (Map.Entry) r113.next();
        r109.a((String) r114.getKey(), String.valueOf(r114.getValue()));
        goto L30
    L13:
        if ((!r111.isEmpty()) == false) goto L15;
        Map r115 = r111;
    L16:
        if (r115 == null) goto L21;
        Iterator r116 = r115.entrySet().iterator();
    L19:
        if (r116.hasNext() == false) goto L21;
        Map.Entry r117 = (Map.Entry) r116.next();
        r107.a((String) r117.getKey(), String.valueOf(r117.getValue()));
        goto L19
    L15:
        r115 = null;
    L33:
        h r118 = new h(new i(r104.getContext(), r104.f103734b, r104.f103735c), r104.f103736d.f103803a);
        if (r118.c() != null) goto L63;
        a.f502996a.getClass();
        a r119 = a.C6543a.a();
        if (r119 == null) goto L63;
        ToolbarMatchInterface r120 = r118.f103739i;
        if (r120 == null) goto L40;
        String r121 = r120.compInfo();
    L41:
        Map r122 = MapsKt.mapOf(TuplesKt.to("comp", r121.toString()));
        SimpleAlogArgsBuilder r123 = new SimpleAlogArgsBuilder();
        r123.c("RoomTbCompFactory create comp, config is null,biz has not register");
        if (r122 != null) goto L44;
    L52:
        Unit r124 = Unit.INSTANCE;
        r119.c(r123.b());
        ke1.f.a r125 = new ke1.f.a("RoomTbCompFactory create comp, config is null,biz has not register");
        if (r122 != null) goto L55;
    L62:
        Unit r126 = Unit.INSTANCE;
        r119.a(new ke1.f(r125));
        goto L63
    L55:
        if ((true ^ r122.isEmpty()) == false) goto L57;
        r105 = r122;
    L57:
        if (r105 == null) goto L62;
        Iterator r127 = r105.entrySet().iterator();
    L60:
        if (r127.hasNext() == false) goto L62;
        Map.Entry r128 = (Map.Entry) r127.next();
        r125.a((String) r128.getKey(), String.valueOf(r128.getValue()));
        goto L60
    L44:
        if ((!r122.isEmpty()) == false) goto L46;
        Map r129 = r122;
    L47:
        if (r129 == null) goto L52;
        Iterator r130 = r129.entrySet().iterator();
    L50:
        if (r130.hasNext() == false) goto L52;
        Map.Entry r131 = (Map.Entry) r130.next();
        r123.a((String) r131.getKey(), String.valueOf(r131.getValue()));
        goto L50
    L46:
        r129 = null;
        goto L47
    L40:
        r121 = null;
    L63:
        return r118;
    L5:
        if (r104.f103734b == null) goto L8;
        if (r104.f103735c != null) goto L33;
        goto L8
    }

    @Override // com.bytedance.android.livesdk.toolbarservice.api.IToolbarService
    public com.bytedance.android.livesdk.arch.container.a<b> createTbContainer(com.bytedance.android.livesdk.arch.container.d r100, com.bytedance.android.livesdk.arch.context.a r101, ot2.d r102, ViewGroup r103) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r101, "tbContext");
        Intrinsics.checkNotNullParameter(r103, KtvSubElement.CONTAINER);
        if (Intrinsics.areEqual(r100, com.bytedance.android.livesdk.arch.container.d.c.f103757c) == false) goto L6;
        return new com.bytedance.android.livesdk.arch.container.c(r102);
    L6:
        if (Intrinsics.areEqual(r100, com.bytedance.android.livesdk.arch.container.d.a.f103756c) == false) goto L10;
        return new com.bytedance.android.livesdk.arch.container.b(r102, r103);
    L10:
        throw new IllegalArgumentException("type unknown");
    }
}
