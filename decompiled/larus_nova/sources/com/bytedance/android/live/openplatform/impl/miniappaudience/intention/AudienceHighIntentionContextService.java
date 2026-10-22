package com.bytedance.android.live.openplatform.impl.miniappaudience.intention;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.openplatform.api.model.datacontext.AudienceMiniAppDataContext;
import com.bytedance.android.live.openplatform.api.model.datacontext.MiniAppDataContext;
import com.bytedance.android.live.openplatform.api.model.shelf.ShelfCardInfo;
import com.bytedance.android.live.openplatform.api.model.shelf.ShelfInfo;
import com.bytedance.android.live.openplatform.api.model.shelf.g;
import com.bytedance.android.live.openplatform.impl.base.constant.OpenPlatformConstants$ExplainCardTriggerType;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContextService;
import com.bytedance.android.live.openplatform.impl.miniappaudience.explaincard.AudienceExplainCardContextService;
import com.bytedance.android.live.openplatform.impl.miniappaudience.explaincard.AudienceLynxExplainCardContextService;
import com.bytedance.android.live.openplatform.impl.miniappaudience.intention.action.CommentCountAction;
import com.bytedance.android.live.openplatform.impl.miniappaudience.intention.action.DiggCountAction;
import com.bytedance.android.live.openplatform.impl.miniappaudience.intention.action.HighValueCommentAction;
import com.bytedance.android.livesdk.config.ce0;
import com.bytedance.android.livesdk.config.qc1;
import com.bytedance.android.livesdk.config.rc1;
import com.bytedance.android.livesdk.config.sc1;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.bytedance.live.datacontext.n;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kq0.c;
import m71.e;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0007B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappaudience/intention/AudienceHighIntentionContextService;", "Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContextService;", "Lcom/bytedance/android/live/openplatform/impl/miniappaudience/intention/a;", "Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContext;", "openPlatformContext", "<init>", "(Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContext;)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AudienceHighIntentionContextService extends OpenPlatformContextService implements com.bytedance.android.live.openplatform.impl.miniappaudience.intention.a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f84893g = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final rc1 f84894a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final oq0.a f84895b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<kq0.b> f84896c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final mq0.a f84897d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f84898e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final b f84899f;

    public static final class a {
    }

    public static final class b extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AudienceHighIntentionContextService f84900a;

        @Override // android.os.Handler
        public final void handleMessage(Message r100) {
            Intrinsics.checkNotNullParameter(r100, "msg");
            if (r100.what != 2) goto L25;
            Object r101 = r100.obj;
            ShelfCardInfo r102 = null;
            if ((r101 instanceof ShelfInfo) == true) goto L8;
            r101 = null;
        L8:
            AudienceHighIntentionContextService r103 = this.f84900a;
            ShelfCardInfo r104 = g.a((ShelfInfo) r101);
            int r105 = AudienceHighIntentionContextService.f84893g;
            r103.getClass();
            MiniAppDataContext.Companion.getClass();
            MiniAppDataContext r106 = MiniAppDataContext.a.a();
            if (r106 == null) goto L16;
            n<ShelfInfo> r107 = r106.m8183getShelfInfo();
            if (r107 == null) goto L16;
            ShelfInfo r108 = r107.getValue();
            if (r108 == null) goto L16;
            r102 = g.a(r108);
        L16:
            if ((!Intrinsics.areEqual(r104, r102)) == false) goto L19;
            qo0.a.c("AudienceHighIntentionContextService", "delayHideCardAction:shelfInfo was changed!");
            return;
        L19:
            if (((AudienceExplainCardContextService) r103.getOpenPlatformContext().getService(AudienceExplainCardContextService.class)).f84818b == true) goto L21;
            qo0.a.c("AudienceHighIntentionContextService", "delayHideCardAction:explain card has been hided!");
            return;
        L21:
            ((AudienceExplainCardContextService) r103.getOpenPlatformContext().getService(AudienceExplainCardContextService.class)).f(false);
            return;
        }

        public b(AudienceHighIntentionContextService r100, Looper r101) {
            this.f84900a = r100;
            super(r101);
        }
    }

    static {
    }

    public final void f() {
        qo0.a.c("AudienceHighIntentionContextService", "onHideExplainCardByUser");
        mq0.a r100 = this.f84897d;
        long r101 = this.f84898e;
        r100.f514783d.put(Long.valueOf(r101), Long.valueOf(System.currentTimeMillis()));
        long r102 = r100.f514782c;
        mq0.a.b r103 = r100.f514784e;
        r103.sendMessageDelayed(r103.obtainMessage(1, Long.valueOf(r101)), r102);
    }

    public final void g() {
        qo0.a.c("AudienceHighIntentionContextService", WidgetCostModule.TYPE_ON_START);
        qo0.a.c("AudienceHighIntentionContextService", "initActions");
        List<qc1> r100 = this.f84894a.a();
        if (r100 == null) goto L22;
        Iterator<T> r101 = r100.iterator();
    L6:
        if (r101.hasNext() == false) goto L22;
        qc1 r102 = (qc1) r101.next();
        String r103 = r102.getType();
        switch(r103.hashCode()) {
            case -1120985297: goto L20;
            case -121614219: goto L17;
            case 291671226: goto L14;
            case 1657558895: goto L11;
            default: goto L6;
        };
    L11:
        if (r103.equals("comment_high_intention") == false) goto L6;
        ((ArrayList) this.f84896c).add(new HighValueCommentAction(getOpenPlatformContext(), r102, this, this.f84895b));
        goto L6
    L14:
        if (r103.equals("stay_duration") == false) goto L6;
        ((ArrayList) this.f84896c).add(new c(getOpenPlatformContext(), r102, this, this.f84895b));
        goto L6
    L17:
        if (r103.equals("digg_count") == false) goto L6;
        ((ArrayList) this.f84896c).add(new DiggCountAction(getOpenPlatformContext(), r102, this, this.f84895b));
        goto L6
    L20:
        if (r103.equals("comment_count") == false) goto L6;
        ((ArrayList) this.f84896c).add(new CommentCountAction(getOpenPlatformContext(), r102, this, this.f84895b));
    L22:
        Iterator r104 = ((ArrayList) this.f84896c).iterator();
    L24:
        if (r104.hasNext() == false) goto L26;
        kq0.b r105 = (kq0.b) r104.next();
        int r106 = qo0.a.f534145a;
        qo0.a.c("AudienceHighIntentionContextService", "init action: " + r105.type());
        r105.init();
        goto L24
    L26:
        qo0.a.c("AudienceHighIntentionContextService", "clearExpiredPrefRecord");
        sc1 r107 = this.f84894a.b();
        if (r107 == null) goto L29;
        long r108 = r107.b();
    L30:
        final long r109 = r108 * 1000;
        final long r110 = System.currentTimeMillis();
        Function1<oq0.c, Boolean> r111 = new AudienceHighIntentionContextService$clearExpiredFreqRecord$expirePredicate$1(r109, r110);
        oq0.a r112 = this.f84895b;
        List r113 = CollectionsKt.listOf(new String[]{"comment_count_records", "comment_high_intention_records", "digg_count_records", "auto_trigger_count_records", "clue_complete_records"});
        r112.getClass();
        Intrinsics.checkNotNullParameter(r113, "recordKeys");
        Intrinsics.checkNotNullParameter(r111, "predicate");
        Iterator r114 = r113.iterator();
    L32:
        if (r114.hasNext() == false) goto L44;
        String r115 = (String) r114.next();
        oq0.b r116 = r112.a(r115);
        Map<String, oq0.c> r117 = r116.a();
        LinkedHashMap r118 = new LinkedHashMap();
        Iterator<Map.Entry<String, oq0.c>> r119 = r117.entrySet().iterator();
    L35:
        if (r119.hasNext() == false) goto L39;
        Map.Entry<String, oq0.c> r120 = r119.next();
        if (r111.invoke(r120.getValue()).booleanValue() == false) goto L35;
        r118.put(r120.getKey(), r120.getValue());
        goto L35
    L39:
        r116.b(MapsKt.toMutableMap(r118));
        String r121 = GsonHelper.get().toJson(r116);     // Catch: Exception -> L42
    L43:
        r112.f524839a.m(r115, r121);
    L42:
        r121 = "";
        goto L43
    L44:
        qo0.a.c("AudienceHighIntentionContextService", "observeShelfInfoChanged");
        MiniAppDataContext.Companion.getClass();
        MiniAppDataContext r122 = MiniAppDataContext.a.a();
        if (r122 == null) goto L80;
        n<ShelfInfo> r123 = r122.m8183getShelfInfo();
        if (r123 == null) goto L81;
        i80.a.b(r123, new AudienceHighIntentionContextService$observeShelfInfoChanged$1(this));
        return;
    L81:
        return;
    L80:
        return;
    L29:
        r108 = 86400;
        goto L30
    }

    @Override // com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContextService
    public final void onDestroy() {
        qo0.a.c("AudienceHighIntentionContextService", LiveCommonConstants.REASON_ON_DEDTROY);
        this.f84899f.removeMessages(2);
        Iterator r100 = ((ArrayList) this.f84896c).iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((kq0.b) r100.next()).onDestroy();
        goto L4
    L6:
        this.f84897d.f514784e.removeMessages(1);
        super.onDestroy();
    }

    public AudienceHighIntentionContextService(OpenPlatformContext r100) {
        Intrinsics.checkNotNullParameter(r100, "openPlatformContext");
        super(r100);
        this.f84894a = ce0.f119941a.getValue();
        oq0.a r101 = new oq0.a(r100.getContext());
        this.f84895b = r101;
        this.f84896c = new ArrayList();
        this.f84897d = new mq0.a(r101, this);
        this.f84899f = new b(this, Looper.getMainLooper());
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappaudience.intention.a
    public final void a(String r110) {
        Intrinsics.checkNotNullParameter(r110, ReportConstant.COMMON_ACTION_TYPE);
        qo0.a.c("AudienceHighIntentionContextService", "onConditionStatusChanged");
        qo0.a.c("AudienceHighIntentionContextService", "tryActiveExplainCard: action=".concat(r110));
        MiniAppDataContext.Companion.getClass();
        ShelfInfo r100 = MiniAppDataContext.a.b();
        if (r100 == null) goto L9;
        ShelfCardInfo r101 = g.a(r100);
        if (r101 == null) goto L9;
        if (r101.C0() != true) goto L9;
        boolean r102 = true;
    L10:
        if (r102 == true) goto L12;
        qo0.a.c("AudienceHighIntentionContextService", "tryActiveExplainCard: clue component not access!");
        return;
    L12:
        oq0.c r103 = this.f84895b.b("clue_complete_records", String.valueOf(this.f84898e));
        if (r103 != null) goto L15;
    L17:
        boolean r104 = false;
    L18:
        if (r104 == false) goto L20;
        qo0.a.c("AudienceHighIntentionContextService", "tryActiveExplainCard: clue complete!");
        return;
    L20:
        List<kq0.b> r105 = this.f84896c;
        if ((r105 instanceof Collection) == true) goto L23;
    L25:
        Iterator r106 = ((ArrayList) r105).iterator();
    L27:
        if (r106.hasNext() == false) goto L33;
        kq0.b r107 = (kq0.b) r106.next();
        boolean r108 = r107.a();
        if (r108 == false) goto L31;
        int r109 = qo0.a.f534145a;
        qo0.a.c("AudienceHighIntentionContextService", "match condition: " + r107.type());
    L31:
        if (r108 == false) goto L27;
        boolean r111 = true;
    L34:
        if (r111 == true) goto L36;
        qo0.a.c("AudienceHighIntentionContextService", "tryActiveExplainCard: conditions not matched!");
        return;
    L36:
        mq0.a r112 = this.f84897d;
        long r113 = this.f84898e;
        oq0.c r114 = r112.f514785f.b("auto_trigger_count_records", String.valueOf(r113));
        if (r114 == null) goto L39;
        long r115 = r114.a();
    L41:
        if (r115 >= r112.f514780a) goto L55;
        if (r114 == null) goto L45;
        long r116 = r114.b();
    L47:
        if ((System.currentTimeMillis() - r116) < r112.f514781b) goto L55;
        Long r117 = (Long) ((LinkedHashMap) r112.f514783d).get(Long.valueOf(r113));
        if (r117 == null) goto L52;
        long r118 = r117.longValue();
    L54:
        if ((System.currentTimeMillis() - r118) < r112.f514782c) goto L55;
        boolean r119 = true;
    L57:
        if (r119 == true) goto L60;
        qo0.a.c("AudienceHighIntentionContextService", "tryActiveExplainCard: frequency control not matched!");
        return;
    L60:
        if (e.c(10) == false) goto L65;
        if (((AudienceLynxExplainCardContextService) getOpenPlatformContext().getService(AudienceLynxExplainCardContextService.class)).f84847b == false) goto L67;
        qo0.a.c("AudienceHighIntentionContextService", "tryActiveExplainCard: explain card is showing!");
        return;
    L67:
        AudienceMiniAppDataContext.Companion.getClass();
        AudienceMiniAppDataContext r120 = AudienceMiniAppDataContext.a.a();
        if (r120 == null) goto L72;
        n<ShelfInfo> r121 = r120.m8183getShelfInfo();
        if (r121 == null) goto L72;
        ShelfInfo r122 = r121.getValue();
    L73:
        if (r122 != null) goto L75;
        qo0.a.c("AudienceHighIntentionContextService", "tryActiveExplainCard: shelfInfo is null!");
        return;
    L75:
        long r123 = 30;
        if (e.c(10) == false) goto L81;
        JSONObject r124 = new JSONObject();
        r124.put("triggerType", OpenPlatformConstants$ExplainCardTriggerType.HighIntention.getValue());
        sc1 r125 = this.f84894a.b();
        if (r125 == null) goto L80;
        r123 = r125.d();
    L80:
        r124.put("showDuration", r123);
        AudienceLynxExplainCardContextService.f((AudienceLynxExplainCardContextService) getOpenPlatformContext().getService(AudienceLynxExplainCardContextService.class), false, r124, 1);
    L85:
        mq0.a r126 = this.f84897d;
        long r127 = this.f84898e;
        r126.f514785f.c("auto_trigger_count_records", 1, String.valueOf(r127));
        long r128 = r126.f514781b;
        mq0.a.b r129 = r126.f514784e;
        r129.sendMessageDelayed(r129.obtainMessage(1, Long.valueOf(r127)), r128);
        return;
    L81:
        AudienceExplainCardContextService.i((AudienceExplainCardContextService) getOpenPlatformContext().getService(AudienceExplainCardContextService.class), r122, false, true, 2);
        sc1 r130 = this.f84894a.b();
        if (r130 == null) goto L84;
        r123 = r130.d();
    L84:
        this.f84899f.removeMessages(2);
        b r131 = this.f84899f;
        r131.sendMessageDelayed(r131.obtainMessage(2, r122), r123 * 1000);
    L72:
        r122 = null;
        goto L73
    L65:
        if (((AudienceExplainCardContextService) getOpenPlatformContext().getService(AudienceExplainCardContextService.class)).f84818b == false) goto L67;
        qo0.a.c("AudienceHighIntentionContextService", "tryActiveExplainCard: explain card is showing!");
        return;
    L52:
        r118 = 0;
        goto L54
    L45:
        r116 = 0;
    L55:
        r119 = false;
        goto L57
    L39:
        r115 = 0;
    L33:
        r111 = false;
        goto L34
    L23:
        if (((ArrayList) r105).isEmpty() == false) goto L25;
    L15:
        if (r103.a() != 1) goto L17;
        r104 = true;
    L9:
        r102 = false;
        goto L10
    }
}
