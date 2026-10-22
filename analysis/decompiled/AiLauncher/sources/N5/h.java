package N5;

import N5.y;
import android.content.Context;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u001f2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001 B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000e\u0010\u0005J?\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0013\u001a\u00020\u00122\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0002¢\u0006\u0004\b\u0017\u0010\u0018R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001e¨\u0006!"}, d2 = {"LN5/h;", "Lcom/stepos/agentframework/chatui/appui/a;", "LN5/d;", "LN5/i;", "<init>", "()V", "data", "LY8/t;", "k", "(LN5/i;)V", "Landroid/content/Context;", "context", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Landroid/content/Context;)LN5/d;", Const.INTENT_KEY_BACKGROUND_COMMAND, "view", "LN5/v;", Const.JSON_KEY_PROVIDER, "", "stage", "", "createFailure", "LN5/n;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(LN5/d;LN5/i;LN5/v;Ljava/lang/String;Ljava/lang/Throwable;)LN5/n;", "envelope", "LN5/i;", "cardView", "LN5/d;", "boundTemplateType", "Ljava/lang/String;", "Companion", Const.INTENT_KEY_APIKEY, "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class h extends com.stepos.agentframework.chatui.appui.a<d, CardEnvelope> {
    private static final String TAG = "CardCenterAppUIBridge";
    private String boundTemplateType;
    private d cardView;
    private CardEnvelope envelope;

    @Override // com.stepos.agentframework.chatui.appui.a
    public void g() {
        String taskId;
        CardEnvelope cardEnvelope = this.envelope;
        if (cardEnvelope != null && (taskId = cardEnvelope.getTaskId()) != null) {
            if (taskId.length() <= 0) {
                taskId = null;
            }
            if (taskId != null) {
                z.INSTANCE.c(taskId);
            }
        }
        this.envelope = null;
        this.cardView = null;
        this.boundTemplateType = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x0127  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final N5.n i(N5.d r22, N5.CardEnvelope r23, N5.v r24, java.lang.String r25, java.lang.Throwable r26) {
        /*
            Method dump skipped, instructions count: 317
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: N5.h.i(N5.d, N5.i, N5.v, java.lang.String, java.lang.Throwable):N5.n");
    }

    @Override // com.stepos.agentframework.chatui.appui.a
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public d b(Context context) {
        Object objB;
        Object obj;
        Throwable th;
        kotlin.jvm.internal.p.i(context, "context");
        CardEnvelope cardEnvelope = this.envelope;
        CardEnvelope cardEnvelope2 = cardEnvelope == null ? new CardEnvelope(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 131071, null) : cardEnvelope;
        v vVarB = g.INSTANCE.b(cardEnvelope2.getTemplateType());
        if (vVarB == null) {
            R5.b bVar = R5.b.INSTANCE;
            String taskId = cardEnvelope2.getTaskId();
            bVar.h("bridge.skip.noProvider", Y8.j.a("taskId", taskId.length() != 0 ? taskId : "null"), Y8.j.a("templateType", cardEnvelope2.getTemplateType()), Y8.j.a("stage", "create"));
            d dVar = new d(context, null, 0, 6, null);
            dVar.setVisibility(8);
            return dVar;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(vVarB.a(context));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th2));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            R5.b bVar2 = R5.b.INSTANCE;
            String taskId2 = cardEnvelope2.getTaskId();
            if (taskId2.length() == 0) {
                taskId2 = "null";
            }
            obj = objB;
            bVar2.h("bridge.createView.fail", Y8.j.a("taskId", taskId2), Y8.j.a("templateType", cardEnvelope2.getTemplateType()), Y8.j.a("providerCls", vVarB.getClass().getSimpleName()), Y8.j.a("exception", thE.getClass().getSimpleName()), Y8.j.a("message", thE.getMessage()));
            th = thE;
        } else {
            obj = objB;
            th = null;
        }
        d dVar2 = (d) (Result.g(obj) ? null : obj);
        d dVar3 = dVar2 == null ? new d(context, null, 0, 6, null) : dVar2;
        CardEnvelope cardEnvelope3 = cardEnvelope2;
        i(dVar3, cardEnvelope3, vVarB, "create", th);
        if (cardEnvelope3.getTaskId().length() > 0) {
            z.INSTANCE.b(cardEnvelope3.getTaskId(), dVar3);
        }
        this.cardView = dVar3;
        this.boundTemplateType = cardEnvelope3.getTemplateType();
        R5.b bVar3 = R5.b.INSTANCE;
        String taskId3 = cardEnvelope3.getTaskId();
        bVar3.c("bridge.create", Y8.j.a("taskId", taskId3.length() != 0 ? taskId3 : "null"), Y8.j.a("templateType", cardEnvelope3.getTemplateType()), Y8.j.a("providerCls", vVarB.getClass().getSimpleName()), Y8.j.a("viewCls", dVar3.getClass().getSimpleName()));
        R5.a.INSTANCE.f(cardEnvelope3.getTaskId(), dVar3.getClass().getSimpleName());
        return dVar3;
    }

    @Override // com.stepos.agentframework.chatui.appui.a
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public void f(CardEnvelope data) {
        Object objB;
        Object objB2;
        kotlin.jvm.internal.p.i(data, "data");
        y.Result resultE = y.INSTANCE.e(data);
        CardEnvelope envelope = resultE.getEnvelope();
        this.envelope = envelope;
        if (resultE.a()) {
            R5.b bVar = R5.b.INSTANCE;
            String taskId = envelope.getTaskId();
            if (taskId.length() == 0) {
                taskId = "null";
            }
            bVar.c("bridge.templateCompat", Y8.j.a("taskId", taskId), Y8.j.a("from", resultE.getOriginalTemplateType()), Y8.j.a("to", resultE.getNormalizedTemplateType()), Y8.j.a("vendor", resultE.getVendor()), Y8.j.a("reason", resultE.getReason()));
        }
        R5.b bVar2 = R5.b.INSTANCE;
        String taskId2 = envelope.getTaskId();
        if (taskId2.length() == 0) {
            taskId2 = "null";
        }
        bVar2.c("bridge.onInit", Y8.j.a("taskId", taskId2), Y8.j.a("templateType", envelope.getTemplateType()), Y8.j.a("originalTemplateType", resultE.getOriginalTemplateType()), Y8.j.a("bizChannel", envelope.getBizChannel()), Y8.j.a("hasView", Boolean.valueOf(this.cardView != null)));
        String taskId3 = envelope.getTaskId();
        if (taskId3.length() == 0) {
            taskId3 = "null";
        }
        String str = "envelope.bridge:" + ((Object) taskId3);
        String taskId4 = envelope.getTaskId();
        if (taskId4.length() == 0) {
            taskId4 = "null";
        }
        bVar2.e(str, "envelope.bridge", Y8.j.a("taskId", taskId4), Y8.j.a("templateType", envelope.getTemplateType()), Y8.j.a("originalTemplateType", resultE.getOriginalTemplateType()), Y8.j.a("envelope", envelope));
        d dVar = this.cardView;
        if (dVar == null) {
            return;
        }
        if (this.boundTemplateType != null && !kotlin.jvm.internal.p.d(envelope.getTemplateType(), this.boundTemplateType)) {
            String taskId5 = envelope.getTaskId();
            bVar2.h("bridge.skip.tplChange", Y8.j.a("taskId", taskId5.length() != 0 ? taskId5 : "null"), Y8.j.a("from", this.boundTemplateType), Y8.j.a("to", envelope.getTemplateType()), Y8.j.a("originalTo", resultE.getOriginalTemplateType()));
            M5.e.INSTANCE.f(data, null, "fail", M5.e.FAIL_TEMPLATE);
            return;
        }
        v vVarB = g.INSTANCE.b(envelope.getTemplateType());
        if (vVarB == null) {
            String taskId6 = envelope.getTaskId();
            bVar2.h("bridge.skip.noProvider", Y8.j.a("taskId", taskId6.length() != 0 ? taskId6 : "null"), Y8.j.a("templateType", envelope.getTemplateType()), Y8.j.a("originalTemplateType", resultE.getOriginalTemplateType()), Y8.j.a("stage", "onInit"));
            dVar.setVisibility(8);
            if (data.getTaskId().length() > 0) {
                z.INSTANCE.c(data.getTaskId());
                return;
            }
            return;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(vVarB.b(envelope));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            R5.b bVar3 = R5.b.INSTANCE;
            String taskId7 = envelope.getTaskId();
            if (taskId7.length() == 0) {
                taskId7 = "null";
            }
            bVar3.h("bridge.parse.fail", Y8.j.a("taskId", taskId7), Y8.j.a("templateType", envelope.getTemplateType()), Y8.j.a("originalTemplateType", resultE.getOriginalTemplateType()), Y8.j.a("providerCls", vVarB.getClass().getSimpleName()), Y8.j.a("stage", "onInit"), Y8.j.a("exception", thE.getClass().getSimpleName()), Y8.j.a("message", thE.getMessage()));
        }
        try {
            dVar.h(envelope, (n) (Result.g(objB) ? null : objB));
            objB2 = Result.b(Y8.t.f7040a);
        } catch (Throwable th2) {
            Result.Companion companion3 = Result.INSTANCE;
            objB2 = Result.b(C4849c.a(th2));
        }
        Throwable thE2 = Result.e(objB2);
        if (thE2 != null) {
            R5.b bVar4 = R5.b.INSTANCE;
            String taskId8 = envelope.getTaskId();
            bVar4.h("bridge.bind.fail", Y8.j.a("taskId", taskId8.length() != 0 ? taskId8 : "null"), Y8.j.a("templateType", envelope.getTemplateType()), Y8.j.a("originalTemplateType", resultE.getOriginalTemplateType()), Y8.j.a("viewCls", dVar.getClass().getSimpleName()), Y8.j.a("stage", "onInit"), Y8.j.a("exception", thE2.getClass().getSimpleName()), Y8.j.a("message", thE2.getMessage()));
        }
        if (envelope.getTaskId().length() > 0) {
            z.INSTANCE.b(envelope.getTaskId(), dVar);
        }
    }
}
