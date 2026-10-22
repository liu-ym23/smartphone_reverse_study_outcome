package M5;

import La.D;
import La.H;
import N5.CardEnvelope;
import N5.n;
import Y8.j;
import Y8.t;
import Z8.Q;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.aiengine.update.AlgorithmUpdateBundle;
import com.stepos.ailauncher.chat.voicewakeup.VoiceWakeupReceiver;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardModel;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.q0;
import com.stepos.ailauncher.foundation.appui.card.provider.travel.C3330b;
import com.stepos.ailauncher.foundation.appui.card.provider.travel.l;
import com.stepos.ailauncher.foundation.appui.card.provider.travel.w;
import h8.C4148a;
import io.ktor.sse.ServerSentEventKt;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.N;
import kotlin.Result;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010$\n\u0002\b\u0017\n\u0002\u0010#\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001:\u0001\u0012B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J3\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u000f\u0010\u0010J)\u0010\u0012\u001a\u00020\u000b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0011\u001a\u00020\b¢\u0006\u0004\b\u0012\u0010\u0013J!\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\bH\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ!\u0010\u001c\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ!\u0010\u001e\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\u001e\u0010\u001dJA\u0010$\u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020\b2\u0006\u0010 \u001a\u00020\u00142\u0016\b\u0002\u0010\"\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\b0!2\b\b\u0002\u0010#\u001a\u00020\u000eH\u0002¢\u0006\u0004\b$\u0010%R\u0014\u0010&\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b&\u0010'R\u0014\u0010(\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b(\u0010'R\u0014\u0010)\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b)\u0010'R\u0014\u0010*\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b*\u0010'R\u0014\u0010+\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b+\u0010'R\u0014\u0010,\u001a\u00020\b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b,\u0010'R\u0014\u0010-\u001a\u00020\b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b-\u0010'R\u0014\u0010.\u001a\u00020\b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b.\u0010'R\u0014\u0010/\u001a\u00020\b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b/\u0010'R\u0014\u00100\u001a\u00020\b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b0\u0010'R\u0014\u00101\u001a\u00020\b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b1\u0010'R\u0014\u00102\u001a\u00020\b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b2\u0010'R\u0014\u00103\u001a\u00020\b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b3\u0010'R\u0014\u00104\u001a\u00020\b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b4\u0010'R\u0014\u00105\u001a\u00020\b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b5\u0010'R\u0014\u00106\u001a\u00020\b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b6\u0010'R\u0014\u00107\u001a\u00020\b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b7\u0010'R\u0014\u00108\u001a\u00020\b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b8\u0010'R\u001a\u0010:\u001a\b\u0012\u0004\u0012\u00020\b098\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b:\u0010;¨\u0006<"}, d2 = {"LM5/e;", "", "<init>", "()V", "LN5/i;", "envelope", "LN5/n;", AlgorithmUpdateBundle.KEY_SUFFIX_MODEL, "", "result", "failReason", "LY8/t;", "f", "(LN5/i;LN5/n;Ljava/lang/String;Ljava/lang/String;)V", "", Const.INTENT_KEY_UMID, "(LN5/i;LN5/n;)Z", "action", Const.INTENT_KEY_APIKEY, "(LN5/i;LN5/n;Ljava/lang/String;)V", "LM5/e$a;", "c", "(LN5/i;LN5/n;)LM5/e$a;", "e", "(LN5/i;)Ljava/lang/String;", "templateType", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Ljava/lang/String;)Ljava/lang/String;", Const.INTENT_KEY_PKGNAME, "(LN5/i;LN5/n;)Ljava/lang/String;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "event", "context", "", "extra", "includeState", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Ljava/lang/String;LM5/e$a;Ljava/util/Map;Z)V", "TAG", "Ljava/lang/String;", "PAGE_NAME", "EVENT_RENDER", "EVENT_EXPOSE", "EVENT_ACTION", "RESULT_RENDERED", "RESULT_BASE", "RESULT_FAIL", "FAIL_TEMPLATE", "FAIL_PARSE", "FAIL_RESOURCE", "ACTION_VIEW_DETAIL", "ACTION_SELECT_CANDIDATE", "ACTION_CONFIRM", "ACTION_CANCEL", "ACTION_BACK", "ACTION_RETRY", "ACTION_JUMP_APP", "", "exposedCards", "Ljava/util/Set;", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class e {
    public static final String ACTION_BACK = "back";
    public static final String ACTION_CANCEL = "cancel";
    public static final String ACTION_CONFIRM = "confirm";
    public static final String ACTION_JUMP_APP = "jump_app";
    public static final String ACTION_RETRY = "retry";
    public static final String ACTION_SELECT_CANDIDATE = "select_candidate";
    public static final String ACTION_VIEW_DETAIL = "view_detail";
    private static final String EVENT_ACTION = "thirdcard_action";
    private static final String EVENT_EXPOSE = "thirdcard_expose";
    private static final String EVENT_RENDER = "thirdcard_render";
    public static final String FAIL_PARSE = "parse";
    public static final String FAIL_RESOURCE = "resource";
    public static final String FAIL_TEMPLATE = "template";
    public static final e INSTANCE = new e();
    private static final String PAGE_NAME = "chatview";
    public static final String RESULT_BASE = "base";
    public static final String RESULT_FAIL = "fail";
    public static final String RESULT_RENDERED = "rendered";
    private static final String TAG = "ThirdCardTracker";
    private static final Set<String> exposedCards;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\b\u0080\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0014\u001a\u0004\b\u0015\u0010\fR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0014\u001a\u0004\b\u0016\u0010\fR\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0014\u001a\u0004\b\u0017\u0010\fR\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0014\u001a\u0004\b\u0018\u0010\fR\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0014\u001a\u0004\b\u0019\u0010\fR\u0017\u0010\b\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010\u0014\u001a\u0004\b\u001a\u0010\f¨\u0006\u001b"}, d2 = {"LM5/e$a;", "", "", "cardId", "taskId", "partnerAppId", "categoryId", "variant", VoiceWakeupReceiver.EXTRA_STATE, "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", Const.INTENT_KEY_APIKEY, "e", "c", Const.INTENT_KEY_PKGNAME, "f", Const.INTENT_KEY_UMID, "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: M5.e$a, reason: from toString */
    public static final /* data */ class Context {
        private final String cardId;
        private final String categoryId;
        private final String partnerAppId;
        private final String state;
        private final String taskId;
        private final String variant;

        public Context(String cardId, String taskId, String partnerAppId, String categoryId, String variant, String state) {
            p.i(cardId, "cardId");
            p.i(taskId, "taskId");
            p.i(partnerAppId, "partnerAppId");
            p.i(categoryId, "categoryId");
            p.i(variant, "variant");
            p.i(state, "state");
            this.cardId = cardId;
            this.taskId = taskId;
            this.partnerAppId = partnerAppId;
            this.categoryId = categoryId;
            this.variant = variant;
            this.state = state;
        }

        /* renamed from: a, reason: from getter */
        public final String getCardId() {
            return this.cardId;
        }

        /* renamed from: b, reason: from getter */
        public final String getCategoryId() {
            return this.categoryId;
        }

        /* renamed from: c, reason: from getter */
        public final String getPartnerAppId() {
            return this.partnerAppId;
        }

        /* renamed from: d, reason: from getter */
        public final String getState() {
            return this.state;
        }

        /* renamed from: e, reason: from getter */
        public final String getTaskId() {
            return this.taskId;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Context)) {
                return false;
            }
            Context context = (Context) other;
            return p.d(this.cardId, context.cardId) && p.d(this.taskId, context.taskId) && p.d(this.partnerAppId, context.partnerAppId) && p.d(this.categoryId, context.categoryId) && p.d(this.variant, context.variant) && p.d(this.state, context.state);
        }

        /* renamed from: f, reason: from getter */
        public final String getVariant() {
            return this.variant;
        }

        public int hashCode() {
            return (((((((((this.cardId.hashCode() * 31) + this.taskId.hashCode()) * 31) + this.partnerAppId.hashCode()) * 31) + this.categoryId.hashCode()) * 31) + this.variant.hashCode()) * 31) + this.state.hashCode();
        }

        public String toString() {
            return "Context(cardId=" + this.cardId + ", taskId=" + this.taskId + ", partnerAppId=" + this.partnerAppId + ", categoryId=" + this.categoryId + ", variant=" + this.variant + ", state=" + this.state + ")";
        }
    }

    static {
        ConcurrentHashMap.KeySetView keySetViewNewKeySet = ConcurrentHashMap.newKeySet();
        p.h(keySetViewNewKeySet, "newKeySet(...)");
        exposedCards = keySetViewNewKeySet;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void h(e eVar, String str, Context context, Map map, boolean z10, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            map = kotlin.collections.a.i();
        }
        if ((i10 & 8) != 0) {
            z10 = false;
        }
        eVar.g(str, context, map, z10);
    }

    public final void a(CardEnvelope envelope, n model, String action) {
        p.i(action, "action");
        if (envelope == null) {
            return;
        }
        h(this, EVENT_ACTION, c(envelope, model), Q.f(j.a("action", action)), false, 8, null);
    }

    public final String b(CardEnvelope envelope, n model) {
        if (!(model instanceof DidiCardModel)) {
            return ((model instanceof P5.b) || (model instanceof com.stepos.ailauncher.foundation.appui.card.provider.lifeservice.c)) ? "confirmation" : ((model instanceof C3330b) || (model instanceof l) || (model instanceof w) || H.e0(envelope.getTemplateType(), O5.c.HOTEL, true) || H.e0(envelope.getTemplateType(), O5.c.FLIGHT, true) || H.e0(envelope.getTemplateType(), O5.c.TRAIN, true)) ? "candidate" : "unknown";
        }
        int status = ((DidiCardModel) model).getStatus();
        if (status == 27) {
            return "result";
        }
        if (status == 90 || status == 91) {
            return "confirmation";
        }
        switch (status) {
            case 0:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
                return "result";
            case 1:
                return "candidate";
            case 2:
            case 3:
            case 4:
            case 5:
                return "progress";
            default:
                return "unknown";
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final M5.e.Context c(N5.CardEnvelope r9, N5.n r10) {
        /*
            r8 = this;
            if (r10 == 0) goto L15
            java.lang.String r0 = r10.getCardId()
            if (r0 == 0) goto L15
            boolean r1 = La.H.x0(r0)
            if (r1 != 0) goto Lf
            goto L10
        Lf:
            r0 = 0
        L10:
            if (r0 != 0) goto L13
            goto L15
        L13:
            r2 = r0
            goto L1a
        L15:
            java.lang.String r0 = r9.getTaskId()
            goto L13
        L1a:
            java.lang.String r3 = r9.getTaskId()
            java.lang.String r4 = r8.e(r9)
            M5.e$a r1 = new M5.e$a
            java.lang.String r5 = r8.b(r9, r10)
            java.lang.String r0 = r9.getTemplateType()
            java.lang.String r6 = r8.j(r0)
            java.lang.String r7 = r8.i(r9, r10)
            r1.<init>(r2, r3, r4, r5, r6, r7)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: M5.e.c(N5.i, N5.n):M5.e$a");
    }

    public final boolean d(CardEnvelope envelope, n model) {
        p.i(envelope, "envelope");
        Context contextC = c(envelope, model);
        if (!exposedCards.add(contextC.getCardId() + ServerSentEventKt.COLON + contextC.getTaskId())) {
            return false;
        }
        h(this, EVENT_EXPOSE, contextC, null, true, 4, null);
        return true;
    }

    public final String e(CardEnvelope envelope) {
        String string;
        String bizChannel = envelope.getBizChannel();
        if (bizChannel != null && (string = H.D1(bizChannel).toString()) != null) {
            String lowerCase = string.toLowerCase(Locale.ROOT);
            p.h(lowerCase, "toLowerCase(...)");
            if (lowerCase != null) {
                if (lowerCase.length() <= 0) {
                    lowerCase = null;
                }
                if (lowerCase != null) {
                    return lowerCase;
                }
            }
        }
        return D.L(envelope.getTemplateType(), O5.c.DIDI, true) ? q0.DIDI : "unknown";
    }

    public final void f(CardEnvelope envelope, n model, String result, String failReason) {
        p.i(envelope, "envelope");
        p.i(result, "result");
        h(this, EVENT_RENDER, c(envelope, model), kotlin.collections.a.m(j.a("result", result), j.a("fail_reason", failReason)), false, 8, null);
    }

    public final void g(String event, Context context, Map<String, String> extra, boolean includeState) {
        Object objB;
        LinkedHashMap linkedHashMapL = kotlin.collections.a.l(j.a("card_id", context.getCardId()), j.a("task_id", context.getTaskId()), j.a("partner_app_id", context.getPartnerAppId()), j.a("category_id", context.getCategoryId()), j.a("variant", context.getVariant()), j.a("page_name", "chatview"));
        if (includeState) {
            linkedHashMapL.put(VoiceWakeupReceiver.EXTRA_STATE, context.getState());
        }
        for (Map.Entry<String, String> entry : extra.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (value != null) {
                linkedHashMapL.put(key, value);
            }
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(Q.e(linkedHashMapL.size()));
        for (Map.Entry entry2 : linkedHashMapL.entrySet()) {
            Object key2 = entry2.getKey();
            String str = (String) entry2.getValue();
            if (str == null) {
                str = "";
            }
            linkedHashMap.put(key2, str);
        }
        C4148a.k("Track", event + " page=chatview " + linkedHashMap, false, 4, null);
        try {
            Result.Companion companion = Result.INSTANCE;
            N.a(event, "chatview", linkedHashMap);
            objB = Result.b(t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            C4148a.u(TAG, event + " skipped: " + thE.getMessage(), false, 4, null);
        }
    }

    public final String i(CardEnvelope envelope, n model) {
        if (!(model instanceof DidiCardModel)) {
            if (!(model instanceof P5.b)) {
                return model instanceof com.stepos.ailauncher.foundation.appui.card.provider.lifeservice.c ? "confirm" : envelope.getTaskStatus() != null ? "running" : "result";
            }
            Integer taskStatus = ((P5.b) model).getTaskStatus();
            return (taskStatus != null && taskStatus.intValue() == 10) ? "confirm" : (taskStatus != null && taskStatus.intValue() == 20) ? "running" : "result";
        }
        int status = ((DidiCardModel) model).getStatus();
        if (status != 90 && status != 91) {
            switch (status) {
                case 1:
                    break;
                case 2:
                case 3:
                case 4:
                case 5:
                    return "running";
                case 6:
                    return "success";
                default:
                    return "result";
            }
        }
        return "confirm";
    }

    public final String j(String templateType) {
        return D.L(templateType, O5.c.DIDI, true) ? "transport" : H.e0(templateType, O5.c.HOTEL, true) ? O5.c.HOTEL : H.e0(templateType, O5.c.FLIGHT, true) ? O5.c.FLIGHT : H.e0(templateType, O5.c.TRAIN, true) ? "transport" : (H.e0(templateType, a.CARD_TYPE_ROUTE, true) || H.e0(templateType, "trip", true)) ? a.CARD_TYPE_ROUTE : "unknown";
    }
}
