package com.bytedance.android.livesdk.interactivity.pin.business.qa;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.network.response.RequestError;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.interactivity.api.ICommentService;
import com.bytedance.android.livesdk.interactivity.api.pin.container.PinType;
import com.bytedance.android.livesdk.interactivity.api.settings.config.z;
import com.bytedance.android.livesdk.interactivity.pin.business.qa.api.AnswerHighlightRequest;
import com.bytedance.android.livesdk.interactivity.pin.business.qa.api.AnswerHighlightResponseData;
import com.bytedance.android.livesdk.interactivity.pin.business.qa.api.PinAnswerApi;
import com.bytedance.android.livesdk.wrds.syncdata.highlight.HighlightItem;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.m;
import com.ss.android.lark.utils.statistics.PerfLog;
import g42.j;
import g42.k;
import g42.l;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class PinAnswerProcessor extends g42.a {

    public static final class a<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f138742a = null;

        static {
            f138742a = new a();
        }

        public a() {
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r100) {
            Response r101 = (Response) r100;
            Intrinsics.checkNotNullParameter(r101, "response");
            HighlightItem r102 = ((AnswerHighlightResponseData) r101.data).item;
            String r103 = null;
            if (r102 == null) goto L5;
            HighlightItem.a r104 = r102.getAnswerData();
        L6:
            String r105 = r101.logId;
            if (r104 != null) goto L14;
            int r106 = j.f479954f;
            RequestError r107 = r101.error;
            if (r107 == null) goto L12;
            r103 = r107.prompts;
        L12:
            j r108 = new j(false, r102, r105);
            r108.f479956b = r103;
            return r108;
        L14:
            return new j(true, r102, r105);
        L5:
            r104 = null;
            goto L6
        }
    }

    public static final class b<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f138743a = null;

        static {
            f138743a = new b();
        }

        public b() {
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r100) {
            Response r101 = (Response) r100;
            Intrinsics.checkNotNullParameter(r101, "response");
            HighlightItem r102 = ((AnswerHighlightResponseData) r101.data).item;
            String r103 = null;
            if (r102 == null) goto L5;
            HighlightItem.a r104 = r102.getAnswerData();
        L6:
            String r105 = r101.logId;
            if (r104 == null) goto L9;
            int r106 = k.f479960d;
            return k.a.a(r105);
        L9:
            int r107 = k.f479960d;
            RequestError r108 = r101.error;
            if (r108 == null) goto L12;
            r103 = r108.prompts;
        L12:
            k r109 = new k(false, r105);
            r109.f479961a = r103;
            return r109;
        L5:
            r104 = null;
            goto L6
        }
    }

    public static final class c implements g42.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PinAnswerProcessor f138744a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ g42.c f138745b;

        public c(PinAnswerProcessor r100, g42.c r101) {
            this.f138744a = r100;
            this.f138745b = r101;
        }

        @Override // g42.d
        public final void a(HighlightItem r100, Map<String, String> r101) {
            Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
            Intrinsics.checkNotNullParameter(r101, "map");
            g42.d.a.d(this, r100, r101);
            Map<String, HighlightItem> r102 = this.f138745b.o();
            int r103 = 0;
            if (r102.isEmpty() == true) goto L15;
            Iterator<Map.Entry<String, HighlightItem>> r104 = r102.entrySet().iterator();
            int r105 = 0;
        L7:
            if (r104.hasNext() == false) goto L14;
            if (r104.next().getValue().getDataType() != this.f138744a.f479948c.getDataType()) goto L11;
            boolean r106 = true;
        L12:
            if (r106 == false) goto L7;
            r105 = r105 + 1;
            goto L7
        L11:
            r106 = false;
            goto L12
        L14:
            r103 = r105;
        L15:
            r101.put("reply_num", String.valueOf(r103));
        }

        @Override // g42.d
        public final void b(HighlightItem r100, Map<String, String> r101) {
            Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
            Intrinsics.checkNotNullParameter(r101, "map");
            g42.d.a.g(this, r100, r101);
        }

        @Override // g42.d
        public final void c(HighlightItem r100, Map<String, String> r101) {
            Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
            Intrinsics.checkNotNullParameter(r101, "map");
            Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
            Intrinsics.checkNotNullParameter(r101, "map");
        }

        @Override // g42.d
        public final void d(g42.h<?> r100, Map<String, String> r101) {
            Intrinsics.checkNotNullParameter(r100, "event");
            Intrinsics.checkNotNullParameter(r101, "map");
            g42.d.a.a(r100, r101);
        }

        @Override // g42.d
        public final void e(HighlightItem r100, Map<String, String> r101) {
            Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
            Intrinsics.checkNotNullParameter(r101, "map");
            g42.d.a.b(this, r100, r101);
        }

        @Override // g42.d
        public final void f(HighlightItem r100, Map<String, String> r101) {
            Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
            Intrinsics.checkNotNullParameter(r101, "map");
            g42.d.a.c(this, r100, r101);
        }

        @Override // g42.d
        public final void g(HighlightItem r100, Map<String, String> r101) {
            Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
            Intrinsics.checkNotNullParameter(r101, "map");
            g42.d.a.e(this, r100, r101);
        }

        @Override // g42.d
        public final void h(HighlightItem r100, Map<String, String> r101) {
            Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
            Intrinsics.checkNotNullParameter(r101, "map");
            g42.d.a.f(this, r100, r101);
        }
    }

    @Override // g42.f
    public final Integer k() {
        return 1;
    }

    public PinAnswerProcessor() {
        super("PinAnswerProcessor", PinType.Answer);
    }

    @Override // g42.f
    public final boolean b(HighlightItem r100) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        z.f133764a.getClass();
        if (z.a.b().b() == false) goto L6;
        return false;
    L6:
        if (s(r100) == false) goto L55;
        int r101 = com.bytedance.android.livesdk.interactivity.common.utils.g.f136570a;
        RoomContext.a r102 = RoomContext.Companion;
        Long r103 = null;
        RoomContext r104 = RoomContext.a.c(r102, null, 0, 3);
        if (r104 != null) goto L11;
    L23:
        boolean r105 = false;
    L25:
        if (r105 == false) goto L56;
        g42.c r106 = this.f479947b;
        if (r106 == null) goto L29;
        DataCenter r107 = r106.getDataCenter();
    L31:
        if (com.bytedance.android.livesdk.interactivity.common.utils.h.b(com.bytedance.android.live.core.utils.z.e(r107, false)) == false) goto L53;
        g42.c r108 = this.f479947b;
        if (r108 == null) goto L51;
        Map<String, HighlightItem> r109 = r108.o();
        if (r109 == null) goto L51;
        HighlightItem r110 = r109.get(c(r100));
        if (r110 == null) goto L51;
        HighlightItem.a r111 = r110.getAnswerData();
        if (r111 == null) goto L51;
        if (r111.f162527b != true) goto L51;
        HighlightItem.a r112 = r100.getAnswerData();
        if (r112 == null) goto L46;
        Long r113 = Long.valueOf(r112.c());
    L47:
        HighlightItem.a r114 = r110.getAnswerData();
        if (r114 == null) goto L50;
        r103 = Long.valueOf(r114.c());
    L50:
        boolean r115 = Intrinsics.areEqual(r113, r103);
    L52:
        if (r115 == true) goto L53;
        return false;
    L46:
        r113 = null;
    L51:
        r115 = true;
    L53:
        return true;
    L29:
        r107 = null;
        goto L31
    L56:
        return false;
    L11:
        if (r104.isAnchor().getValue().booleanValue() == true) goto L24;
        RoomContext r116 = RoomContext.a.c(r102, null, 0, 3);
        if (r116 == null) goto L19;
        m<Room> r117 = r116.getRoom();
        if (r117 == null) goto L19;
        Room r118 = r117.getValue();
        if (r118 == null) goto L19;
        String r119 = r118.getAnchorAbValue("live_answer_on_wall");
    L21:
        if (TextUtils.equals("1", r119) == false) goto L23;
    L19:
        r119 = null;
    L24:
        r105 = true;
        goto L25
    L55:
        return false;
    }

    @Override // g42.f
    public final String c(HighlightItem r100) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        HighlightItem.a r101 = r100.getAnswerData();
        if (r101 == null) goto L6;
        String r102 = String.valueOf(r101.b());
        if (r102 == null) goto L6;
        return r102;
    L6:
        return "0";
    }

    @Override // g42.a, g42.f
    public final void e(g42.c r100) {
        Intrinsics.checkNotNullParameter(r100, "pinContainer");
        Intrinsics.checkNotNullParameter(r100, "pinContainer");
        this.f479947b = r100;
        t(j42.b.class, new PinAnswerProcessor$onCreate$1(this));
        t(j42.a.class, new PinAnswerProcessor$onCreate$2(this));
        r100.n(PinType.All, new c(this, r100));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // g42.f
    public final Observable<j> j(g42.h<?> r100) {
        Intrinsics.checkNotNullParameter(r100, "pinEvent");
        RoomContext r101 = r();
        if (r101 != null) goto L6;
        return null;
    L6:
        if ((r100 instanceof j42.d) == false) goto L12;
        j42.c r102 = (j42.c) ((j42.d) r100).f479951b;
        AnswerHighlightRequest r103 = new AnswerHighlightRequest();
        r103.scene = "answer_highlight";
        r103.actionType = 1;
        r103.roomId = r101.getRoom().getValue().getRoomId();
        r103.question = r102.f497347b;
        r103.answer = r102.f497351f;
        r103.nickName = r102.f497349d;
        r103.setCommenterId(r102.f497348c);
        r103.questionMsgId = r102.f497346a;
        r103.answerMsgId = r102.f497350e;
        Long r104 = r102.f497352g;
        if (r104 == null) goto L10;
        r103.answerId = r104.longValue();
    L10:
        PinAnswerApi.f138747a.getClass();
        return ((PinAnswerApi) com.bytedance.android.live.network.c.b().e(PinAnswerApi.class)).pin(r103.toRequestFieldMap()).map(a.f138742a);
    L12:
        return null;
    }

    @Override // g42.a, g42.f
    public final String l(com.bytedance.android.livesdk.interactivity.api.message.model.a r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        return String.valueOf(r100.G());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // g42.f
    public final Observable<k> n(l<?> r100) {
        Intrinsics.checkNotNullParameter(r100, "unpinEvent");
        RoomContext r101 = r();
        if (r101 != null) goto L6;
        return null;
    L6:
        if ((r100 instanceof j42.e) == false) goto L20;
        HighlightItem.a r102 = (HighlightItem.a) ((j42.e) r100).f479965b;
        AnswerHighlightRequest r103 = new AnswerHighlightRequest();
        r103.scene = "answer_highlight";
        r103.actionType = 2;
        r103.roomId = r101.getRoom().getValue().getRoomId();
        String r104 = r102.i();
        String r105 = "";
        if (r104 != null) goto L10;
        r104 = "";
    L10:
        r103.question = r104;
        r103.answer = r102.a();
        String r106 = r102.h();
        if (r106 == null) goto L14;
        r105 = r106;
    L14:
        r103.nickName = r105;
        Long r107 = r102.f();
        if (r107 == null) goto L17;
        long r108 = r107.longValue();
    L18:
        r103.setCommenterId(String.valueOf(r108));
        r103.answerId = r102.b();
        r103.questionMsgId = r102.j();
        r103.answerMsgId = r102.c();
        PinAnswerApi.f138747a.getClass();
        return ((PinAnswerApi) com.bytedance.android.live.network.c.b().e(PinAnswerApi.class)).pin(r103.toRequestFieldMap()).map(b.f138743a);
    L17:
        r108 = 0;
        goto L18
    L20:
        return null;
    }

    @Override // g42.f
    public final g42.e o(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return new PinAnswerHighlightPageItemView(r100, null, 6, 0);
    }

    @Override // g42.f
    public final com.bytedance.android.livesdk.wrds.syncdata.highlight.b q(HighlightItem r100) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        return r100.getAnswerData();
    }

    public static final void u(PinAnswerProcessor r110, String r111, j42.b r112, Long r113) {
        g42.c r100 = r110.f479947b;
        if (r100 == null) goto L5;
        DataCenter r101 = r100.getDataCenter();
    L6:
        if (r101 == null) goto L19;
        Room r102 = com.bytedance.android.live.core.utils.z.o(r101);
        if (r102 == null) goto L20;
        long r103 = System.currentTimeMillis();
        if (r113 == null) goto L13;
        boolean r104 = true;
    L14:
        if (r104 == false) goto L16;
        String r105 = "edit answer";
    L17:
        String r106 = r105;
        RxUtilKt.c(((ICommentService) jc1.k.n(ICommentService.class)).sendCommentChat(r102, r111).subscribeOn(Schedulers.io()).subscribe(new h(r110, r106, r103, r112, r111, r113), new i(r110, r106)), r110.f479946a);
        return;
    L16:
        r105 = "pin answer";
        goto L17
    L13:
        r104 = false;
        goto L14
    L20:
        return;
    L19:
        return;
    L5:
        r101 = null;
        goto L6
    }
}
