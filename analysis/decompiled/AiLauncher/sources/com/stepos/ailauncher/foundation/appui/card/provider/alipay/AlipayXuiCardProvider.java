package com.stepos.ailauncher.foundation.appui.card.provider.alipay;

import N5.CardEnvelope;
import android.content.Context;
import com.autonavi.aps.amapapi.AMapLocationStaticsEntity;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.common.utils.C3197a;
import com.stepos.ailauncher.foundation.R$color;
import com.stepos.ailauncher.foundation.R$drawable;
import com.stepos.ailauncher.foundation.appui.card.provider.alipay.AlipayXuiCardModel;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 D2\u00020\u0001:\u0001\fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J+\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJW\u0010\"\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u00112\b\u0010\u001d\u001a\u0004\u0018\u00010\u00162\b\u0010\u001e\u001a\u0004\u0018\u00010\u00162\b\u0010\u0019\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u001f\u001a\u00020\u00142\b\u0010 \u001a\u0004\u0018\u00010\u00142\u0006\u0010!\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\"\u0010#JE\u0010%\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u00112\b\u0010\u001d\u001a\u0004\u0018\u00010\u00162\b\u0010\u0019\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u001f\u001a\u00020\u00142\b\u0010$\u001a\u0004\u0018\u00010\u0014H\u0002¢\u0006\u0004\b%\u0010&J3\u0010*\u001a\u0004\u0018\u00010\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0016\u0010)\u001a\u0012\u0012\u0004\u0012\u00020\u0014\u0012\u0006\u0012\u0004\u0018\u00010(\u0018\u00010'H\u0002¢\u0006\u0004\b*\u0010+J}\u0010:\u001a\u0002092\b\u0010-\u001a\u0004\u0018\u00010,2\u0006\u0010.\u001a\u00020\u00142\u0006\u0010/\u001a\u00020\u00112\u0006\u00100\u001a\u00020\u00112\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u00103\u001a\u0002022\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u00105\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u00106\u001a\u0002022\b\b\u0002\u00107\u001a\u0002022\b\b\u0002\u00108\u001a\u000202H\u0002¢\u0006\u0004\b:\u0010;J\u001b\u0010<\u001a\u0004\u0018\u00010\u00142\b\u0010-\u001a\u0004\u0018\u00010,H\u0002¢\u0006\u0004\b<\u0010=J\u001b\u0010>\u001a\u0004\u0018\u00010\u00142\b\u0010-\u001a\u0004\u0018\u00010,H\u0002¢\u0006\u0004\b>\u0010=J\u0019\u0010@\u001a\u00020\u00142\b\u0010?\u001a\u0004\u0018\u00010\u0014H\u0002¢\u0006\u0004\b@\u0010AJ\u0011\u0010B\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0004\bB\u0010C¨\u0006E"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/alipay/AlipayXuiCardProvider;", "LN5/v;", "<init>", "()V", "LN5/i;", "envelope", "LN5/n;", Const.INTENT_KEY_PKGNAME, "(LN5/i;)LN5/n;", "Landroid/content/Context;", "context", "LN5/d;", Const.INTENT_KEY_APIKEY, "(Landroid/content/Context;)LN5/d;", "Lcom/stepos/ailauncher/foundation/appui/card/provider/alipay/w;", "k", "(LN5/i;)Lcom/stepos/ailauncher/foundation/appui/card/provider/alipay/w;", "", "l", "(LN5/i;)I", "", "taskId", "Lcom/stepos/ailauncher/foundation/appui/card/provider/alipay/L;", "item", "Lcom/stepos/ailauncher/foundation/appui/card/provider/alipay/p;", "order", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Ljava/lang/String;Lcom/stepos/ailauncher/foundation/appui/card/provider/alipay/L;Lcom/stepos/ailauncher/foundation/appui/card/provider/alipay/p;)Lcom/stepos/ailauncher/foundation/appui/card/provider/alipay/w;", "status", AMapLocationStaticsEntity.FIRST_LOCATE, "second", "title", "subtitle", "primaryLabel", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Ljava/lang/String;ILcom/stepos/ailauncher/foundation/appui/card/provider/alipay/L;Lcom/stepos/ailauncher/foundation/appui/card/provider/alipay/L;Lcom/stepos/ailauncher/foundation/appui/card/provider/alipay/p;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/stepos/ailauncher/foundation/appui/card/provider/alipay/w;", "ctaLabel", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Ljava/lang/String;ILcom/stepos/ailauncher/foundation/appui/card/provider/alipay/L;Lcom/stepos/ailauncher/foundation/appui/card/provider/alipay/p;Ljava/lang/String;Ljava/lang/String;)Lcom/stepos/ailauncher/foundation/appui/card/provider/alipay/w;", "", "", "businessData", "f", "(Lcom/stepos/ailauncher/foundation/appui/card/provider/alipay/L;Ljava/util/Map;)Ljava/lang/String;", "Lcom/stepos/ailauncher/foundation/appui/card/provider/alipay/k;", "action", "fallbackLabel", "background", "textColor", "launchPackage", "", "showLoading", "fallbackAppLink", "intentPackage", "localDim", "forceFallbackLabel", "armAuthResume", "Lcom/stepos/ailauncher/foundation/appui/card/provider/alipay/w$a;", "c", "(Lcom/stepos/ailauncher/foundation/appui/card/provider/alipay/k;Ljava/lang/String;IILjava/lang/String;ZLjava/lang/String;Ljava/lang/String;ZZZ)Lcom/stepos/ailauncher/foundation/appui/card/provider/alipay/w$a;", "m", "(Lcom/stepos/ailauncher/foundation/appui/card/provider/alipay/k;)Ljava/lang/String;", "n", "appId", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Ljava/lang/String;)Ljava/lang/String;", "e", "()Landroid/content/Context;", "Companion", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AlipayXuiCardProvider implements N5.v {
    private static final String DEFAULT_APP_NAME = "支付宝";
    private static final String DEFAULT_STORE_NAME = "应用商店";
    private static final String KEY_ITEMS = "items";
    private static final String KEY_ORDER = "order";
    private static final String KEY_PRIMARY_INFO = "primaryInfo";
    private static final String LABEL_ABORT = "终止";
    private static final String LABEL_CONFIRM = "去确认";
    private static final String LABEL_REPLY = "去回复";
    private static final String LABEL_VIEW_RESULT = "查看结果";
    private static final String LABEL_VIEW_TASK = "查看任务";
    private static final String TITLE_CANCELLED = "支付宝阿宝执行任务已取消";
    private static final String TITLE_COMPLETED = "支付宝阿宝已完成";
    private static final String TITLE_CONFIRMATION = "支付宝阿宝正在等待确认";
    private static final String TITLE_EXECUTING = "支付宝阿宝正在执行中";
    private static final String TITLE_FAILED = "支付宝阿宝任务执行已结束";
    private static final String TITLE_WAITING_REPLY = "支付宝阿宝正在等待回复";

    public static /* synthetic */ AlipayXuiCardModel.ActionItem d(AlipayXuiCardProvider alipayXuiCardProvider, AlipayXuiAction alipayXuiAction, String str, int i10, int i11, String str2, boolean z10, String str3, String str4, boolean z11, boolean z12, boolean z13, int i12, Object obj) {
        if ((i12 & 16) != 0) {
            str2 = null;
        }
        if ((i12 & 32) != 0) {
            z10 = false;
        }
        if ((i12 & 64) != 0) {
            str3 = null;
        }
        if ((i12 & 128) != 0) {
            str4 = null;
        }
        if ((i12 & 256) != 0) {
            z11 = false;
        }
        if ((i12 & 512) != 0) {
            z12 = false;
        }
        if ((i12 & 1024) != 0) {
            z13 = false;
        }
        return alipayXuiCardProvider.c(alipayXuiAction, str, i10, i11, str2, z10, str3, str4, z11, z12, z13);
    }

    @Override // N5.v
    public N5.d a(Context context) {
        kotlin.jvm.internal.p.i(context, "context");
        return new AlipayXuiCardView(context, null, 0, 6, null);
    }

    @Override // N5.v
    public N5.n b(CardEnvelope envelope) {
        Object objB;
        kotlin.jvm.internal.p.i(envelope, "envelope");
        CardEnvelope cardEnvelopeE = O.INSTANCE.e(envelope);
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(k(cardEnvelopeE));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            R5.b bVar = R5.b.INSTANCE;
            String taskId = cardEnvelopeE.getTaskId();
            if (taskId.length() == 0) {
                taskId = "null";
            }
            bVar.h("provider.alipay.parse.fail", Y8.j.a("taskId", taskId), Y8.j.a("exception", thE.getClass().getSimpleName()), Y8.j.a("message", thE.getMessage()));
            objB = new AlipayXuiCardModel(cardEnvelopeE.getTaskId(), 0, null, null, null, null, null, null, null, null, false, 2046, null);
        }
        return (N5.n) objB;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0030  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.stepos.ailauncher.foundation.appui.card.provider.alipay.AlipayXuiCardModel.ActionItem c(com.stepos.ailauncher.foundation.appui.card.provider.alipay.AlipayXuiAction r3, java.lang.String r4, int r5, int r6, java.lang.String r7, boolean r8, java.lang.String r9, java.lang.String r10, boolean r11, boolean r12, boolean r13) {
        /*
            r2 = this;
            N5.j r0 = N5.j.INSTANCE
            java.lang.String r1 = r2.m(r3)
            java.lang.String r1 = r0.d(r1)
            if (r1 != 0) goto L10
            java.lang.String r1 = r0.d(r9)
        L10:
            java.lang.String r2 = r2.n(r3)
            java.lang.String r2 = r0.d(r2)
            r9 = r8
            r8 = r7
            r7 = r6
            r6 = r5
            r5 = r2
            com.stepos.ailauncher.foundation.appui.card.provider.alipay.w$a r2 = new com.stepos.ailauncher.foundation.appui.card.provider.alipay.w$a
            if (r12 == 0) goto L22
            goto L30
        L22:
            if (r3 == 0) goto L29
            java.lang.String r3 = r3.getLabel()
            goto L2a
        L29:
            r3 = 0
        L2a:
            java.lang.String r3 = r0.d(r3)
            if (r3 != 0) goto L31
        L30:
            r3 = r4
        L31:
            r12 = r13
            r4 = r1
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.foundation.appui.card.provider.alipay.AlipayXuiCardProvider.c(com.stepos.ailauncher.foundation.appui.card.provider.alipay.k, java.lang.String, int, int, java.lang.String, boolean, java.lang.String, java.lang.String, boolean, boolean, boolean):com.stepos.ailauncher.foundation.appui.card.provider.alipay.w$a");
    }

    public final Context e() {
        Object objB;
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(C3197a.INSTANCE.a());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        if (Result.g(objB)) {
            objB = null;
        }
        return (Context) objB;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0020  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String f(com.stepos.ailauncher.foundation.appui.card.provider.alipay.AlipayXuiItem r2, java.util.Map<java.lang.String, ? extends java.lang.Object> r3) {
        /*
            r1 = this;
            N5.j r1 = N5.j.INSTANCE
            r0 = 0
            if (r2 == 0) goto L10
            com.stepos.ailauncher.foundation.appui.card.provider.alipay.N r2 = r2.getPrimaryInfo()
            if (r2 == 0) goto L10
            java.lang.String r2 = r2.getTitle()
            goto L11
        L10:
            r2 = r0
        L11:
            java.lang.String r1 = r1.d(r2)
            if (r1 == 0) goto L18
            return r1
        L18:
            N5.k r1 = N5.k.INSTANCE
            com.google.gson.JsonObject r2 = r1.c(r3)
            if (r2 != 0) goto L22
        L20:
            r1 = r0
            goto L4f
        L22:
            java.lang.String r3 = "primaryInfo"
            com.google.gson.JsonElement r2 = r2.get(r3)
            if (r2 != 0) goto L2c
            goto L20
        L2c:
            kotlin.Result$a r3 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L3d
            com.google.gson.Gson r1 = r1.b()     // Catch: java.lang.Throwable -> L3d
            java.lang.Class<com.stepos.ailauncher.foundation.appui.card.provider.alipay.N> r3 = com.stepos.ailauncher.foundation.appui.card.provider.alipay.AlipayXuiPrimaryInfo.class
            java.lang.Object r1 = r1.fromJson(r2, r3)     // Catch: java.lang.Throwable -> L3d
            java.lang.Object r1 = kotlin.Result.b(r1)     // Catch: java.lang.Throwable -> L3d
            goto L48
        L3d:
            r1 = move-exception
            kotlin.Result$a r2 = kotlin.Result.INSTANCE
            java.lang.Object r1 = kotlin.C4849c.a(r1)
            java.lang.Object r1 = kotlin.Result.b(r1)
        L48:
            boolean r2 = kotlin.Result.g(r1)
            if (r2 == 0) goto L4f
            goto L20
        L4f:
            com.stepos.ailauncher.foundation.appui.card.provider.alipay.N r1 = (com.stepos.ailauncher.foundation.appui.card.provider.alipay.AlipayXuiPrimaryInfo) r1
            N5.j r2 = N5.j.INSTANCE
            if (r1 == 0) goto L59
            java.lang.String r0 = r1.getTitle()
        L59:
            java.lang.String r1 = r2.d(r0)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.foundation.appui.card.provider.alipay.AlipayXuiCardProvider.f(com.stepos.ailauncher.foundation.appui.card.provider.alipay.L, java.util.Map):java.lang.String");
    }

    public final AlipayXuiCardModel g(String taskId, int status, AlipayXuiItem first, AlipayXuiItem second, AlipayXuiBusinessData order, String title, String subtitle, String primaryLabel) {
        AlipayXuiAction action;
        AlipayXuiAction alipayXuiAction;
        String str = null;
        if (first == null || (action = first.getAction()) == null) {
            action = order != null ? order.getAction() : null;
        }
        if (second != null && (secondaryAction = second.getAction()) != null) {
            alipayXuiAction = secondaryAction;
        } else if (order != null) {
            AlipayXuiAction secondaryAction = order.getSecondaryAction();
            alipayXuiAction = secondaryAction;
        } else {
            alipayXuiAction = null;
        }
        N5.j jVar = N5.j.INSTANCE;
        String strD = jVar.d(m(action));
        String strD2 = jVar.d(n(action));
        int i10 = R$drawable.bg_card_alipay_cta;
        int i11 = R$color.card_alipay_cta_text;
        if (strD == null && strD2 == null) {
            str = C3236a.PKG_ALIPAY;
        }
        return new AlipayXuiCardModel(taskId, status, null, null, null, title, subtitle, null, d(this, action, primaryLabel, i10, i11, str, false, null, null, false, true, false, 1504, null), d(this, alipayXuiAction, LABEL_ABORT, R$drawable.bg_card_alipay_cta_secondary, R$color.card_alipay_button_secondary_text, null, false, null, null, alipayXuiAction == null || (jVar.d(m(alipayXuiAction)) == null && jVar.d(n(alipayXuiAction)) == null), true, false, 1264, null), false, 1180, null);
    }

    public final AlipayXuiCardModel h(String taskId, AlipayXuiItem item, AlipayXuiBusinessData order) {
        AlipayXuiAction alipayXuiAction;
        AlipayXuiPrimaryInfo primaryInfo;
        AlipayXuiMedia media;
        AlipayXuiPrimaryInfo primaryInfo2;
        AlipayXuiAppInfo app = order != null ? order.getApp() : null;
        N5.j jVar = N5.j.INSTANCE;
        String strD = jVar.d(app != null ? app.getInstallState() : null);
        if (strD == null) {
            strD = jVar.d(order != null ? order.getInstallState() : null);
        }
        String str = strD;
        C3245j c3245j = C3245j.INSTANCE;
        String strJ = c3245j.j(e(), str);
        if (item != null && (action = item.getAction()) != null) {
            alipayXuiAction = action;
        } else if (order != null) {
            AlipayXuiAction action = order.getAction();
            alipayXuiAction = action;
        } else {
            alipayXuiAction = null;
        }
        String strD2 = jVar.d(app != null ? app.getStoreName() : null);
        if (strD2 == null) {
            strD2 = "应用商店";
        }
        String str2 = strD2;
        String strD3 = jVar.d(app != null ? app.getAppName() : null);
        if (strD3 == null) {
            strD3 = jVar.d((item == null || (primaryInfo2 = item.getPrimaryInfo()) == null) ? null : primaryInfo2.getTitle());
            if (strD3 == null) {
                strD3 = DEFAULT_APP_NAME;
            }
        }
        String strD4 = jVar.d(app != null ? app.getIconUrl() : null);
        if (strD4 == null) {
            strD4 = jVar.d((item == null || (media = item.getMedia()) == null) ? null : media.getIcon());
            if (strD4 == null) {
                strD4 = jVar.d(order != null ? order.getIconUrl() : null);
            }
        }
        String strD5 = jVar.d(app != null ? app.getSizeText() : null);
        String strD6 = jVar.d(app != null ? app.getExtraText() : null);
        if (strD6 == null) {
            strD6 = jVar.d((item == null || (primaryInfo = item.getPrimaryInfo()) == null) ? null : primaryInfo.getSubtitle());
        }
        return new AlipayXuiCardModel(taskId, 1, str2, str, new AlipayXuiCardModel.AppItem(strD3, strD4, strD5, strD6), null, null, null, d(this, alipayXuiAction, c3245j.c(strJ), R$drawable.bg_card_alipay_cta, R$color.card_cta_text, c3245j.d(strJ), kotlin.jvm.internal.p.d(strJ, "installing"), j(app != null ? app.getAppId() : null), "com.stepos.appstore", false, false, false, 1792, null), null, false, 1760, null);
    }

    public final AlipayXuiCardModel i(String taskId, int status, AlipayXuiItem first, AlipayXuiBusinessData order, String title, String ctaLabel) {
        AlipayXuiAction alipayXuiAction;
        if (first != null && (action = first.getAction()) != null) {
            alipayXuiAction = action;
        } else if (order != null) {
            AlipayXuiAction action = order.getAction();
            alipayXuiAction = action;
        } else {
            alipayXuiAction = null;
        }
        return new AlipayXuiCardModel(taskId, status, null, null, null, title, null, null, ctaLabel != null ? d(this, alipayXuiAction, ctaLabel, R$drawable.bg_card_alipay_cta, R$color.card_alipay_cta_text, null, false, null, null, false, true, false, 1520, null) : null, null, false, 1756, null);
    }

    public final String j(String appId) {
        String strD = N5.j.INSTANCE.d(appId);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("market://details?id=");
        sb2.append(C3236a.PKG_ALIPAY);
        sb2.append("&package_name=");
        sb2.append(C3236a.PKG_ALIPAY);
        if (strD != null) {
            sb2.append("&app_id=");
            sb2.append(strD);
        }
        sb2.append("&source=amoo");
        return sb2.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x01b2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.stepos.ailauncher.foundation.appui.card.provider.alipay.AlipayXuiCardModel k(N5.CardEnvelope r13) {
        /*
            Method dump skipped, instructions count: 607
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.foundation.appui.card.provider.alipay.AlipayXuiCardProvider.k(N5.i):com.stepos.ailauncher.foundation.appui.card.provider.alipay.w");
    }

    public final int l(CardEnvelope envelope) {
        Integer taskStatus = envelope.getTaskStatus();
        if ((taskStatus != null && taskStatus.intValue() == 1) || ((taskStatus != null && taskStatus.intValue() == 2) || ((taskStatus != null && taskStatus.intValue() == 3) || ((taskStatus != null && taskStatus.intValue() == 4) || ((taskStatus != null && taskStatus.intValue() == 5) || ((taskStatus != null && taskStatus.intValue() == 6) || (taskStatus != null && taskStatus.intValue() == 7))))))) {
            return taskStatus.intValue();
        }
        return 6;
    }

    public final String m(AlipayXuiAction action) {
        AlipayXuiActionDetail detail;
        N5.j jVar = N5.j.INSTANCE;
        String strD = jVar.d((action == null || (detail = action.getDetail()) == null) ? null : detail.getAppLink());
        if (strD == null) {
            return jVar.d(action != null ? action.getAppLink() : null);
        }
        return strD;
    }

    public final String n(AlipayXuiAction action) {
        AlipayXuiActionDetail detail;
        N5.j jVar = N5.j.INSTANCE;
        String strD = jVar.d((action == null || (detail = action.getDetail()) == null) ? null : detail.getWebLink());
        if (strD == null) {
            return jVar.d(action != null ? action.getWebLink() : null);
        }
        return strD;
    }
}
