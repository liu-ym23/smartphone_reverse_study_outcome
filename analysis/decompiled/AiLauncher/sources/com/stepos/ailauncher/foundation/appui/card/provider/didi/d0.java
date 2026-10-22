package com.stepos.ailauncher.foundation.appui.card.provider.didi;

import Z8.C1173v;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.aiengine.update.AlgorithmUpdateBundle;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardModel;
import com.stepos.ailauncher.foundation.appui.card.state.CardStateIdentity;
import com.stepos.ailauncher.foundation.appui.card.state.CardUiStateRecord;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import io.ktor.sse.ServerSentEventKt;
import java.util.Locale;
import java.util.Set;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0006¢\u0006\u0004\b\u0015\u0010\u0016J\u001b\u0010\u0018\u001a\u0004\u0018\u00010\u00102\b\u0010\u0017\u001a\u0004\u0018\u00010\u0010H\u0002¢\u0006\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00100\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/d0;", "", "Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/y;", "<init>", "()V", AlgorithmUpdateBundle.KEY_SUFFIX_MODEL, "Lcom/stepos/ailauncher/foundation/appui/card/state/c;", Const.INTENT_KEY_PKGNAME, "(Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/y;)Lcom/stepos/ailauncher/foundation/appui/card/state/c;", "Lcom/stepos/ailauncher/foundation/appui/card/state/j;", "stored", "", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/y;Lcom/stepos/ailauncher/foundation/appui/card/state/j;)Z", Const.INTENT_KEY_UMID, "(Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/y;)Z", "", "f", "(Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/y;)Ljava/lang/String;", com.stepos.statsapp.v3.lib.plugin.net.multipart.e.f30860s, "LY8/t;", "c", "(Lcom/stepos/ailauncher/foundation/appui/card/state/c;)V", UxipConstants.f30680s, "e", "(Ljava/lang/String;)Ljava/lang/String;", "", "SUPPORTED_VENDORS", "Ljava/util/Set;", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class d0 {
    public static final d0 INSTANCE = new d0();
    private static final Set<String> SUPPORTED_VENDORS = Z8.Y.j(q0.DIDI, q0.CAOCAO);

    public static final CharSequence g(DidiCardModel.CarTypeItem it) {
        kotlin.jvm.internal.p.i(it, "it");
        String id = it.getId();
        String name = it.getName();
        if (name == null) {
            name = "";
        }
        String priceText = it.getPriceText();
        if (priceText == null) {
            priceText = "";
        }
        String originPriceText = it.getOriginPriceText();
        return Z8.F.A0(C1173v.p(id, name, priceText, originPriceText != null ? originPriceText : ""), ServerSentEventKt.COLON, null, null, 0, null, null, 62, null);
    }

    public CardStateIdentity b(DidiCardModel model) {
        Object objB;
        kotlin.jvm.internal.p.i(model, "model");
        String strE = e(model.getBizChannel());
        if (strE == null) {
            return null;
        }
        String cardId = model.getCardId();
        String str = !La.H.x0(cardId) ? cardId : null;
        if (str == null) {
            return null;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(com.stepos.ailauncher.foundation.account.f.INSTANCE.k());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        if (Result.g(objB)) {
            objB = null;
        }
        String str2 = (String) objB;
        if (str2 == null) {
            return null;
        }
        if (La.H.x0(str2)) {
            str2 = null;
        }
        if (str2 != null) {
            return new CardStateIdentity(O5.c.DIDI, strE, CardStateIdentity.INSTANCE.f(str2), str, f(model), model.getMessageId(), model.getToolCallId());
        }
        return null;
    }

    public final void c(CardStateIdentity identity) {
        kotlin.jvm.internal.p.i(identity, "identity");
        com.stepos.ailauncher.foundation.appui.card.state.k.INSTANCE.a(identity, "new_revision");
    }

    public final boolean d(DidiCardModel model) {
        kotlin.jvm.internal.p.i(model, "model");
        return Z8.F.f0(SUPPORTED_VENDORS, e(model.getBizChannel()));
    }

    public final String e(String value) {
        String lowerCase;
        String strD = N5.j.INSTANCE.d(value);
        if (strD != null) {
            lowerCase = strD.toLowerCase(Locale.ROOT);
            kotlin.jvm.internal.p.h(lowerCase, "toLowerCase(...)");
        } else {
            lowerCase = null;
        }
        if (lowerCase == null) {
            lowerCase = q0.DIDI;
        }
        if (SUPPORTED_VENDORS.contains(lowerCase)) {
            return lowerCase;
        }
        return null;
    }

    public final String f(DidiCardModel model) {
        kotlin.jvm.internal.p.i(model, "model");
        return CardStateIdentity.INSTANCE.d(C1173v.p(model.getRequestTraceId(), model.getRouteText(), Z8.F.A0(model.k(), "|", null, null, 0, null, new InterfaceC5074l() { // from class: com.stepos.ailauncher.foundation.appui.card.provider.didi.c0
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return d0.g((DidiCardModel.CarTypeItem) obj);
            }
        }, 30, null)));
    }

    public boolean h(DidiCardModel model, CardUiStateRecord stored) {
        kotlin.jvm.internal.p.i(model, "model");
        kotlin.jvm.internal.p.i(stored, "stored");
        if (model.getStatus() != 1 || !kotlin.jvm.internal.p.d(stored.getStateType(), "DIMMED")) {
            return false;
        }
        CardStateIdentity cardStateIdentityB = b(model);
        return kotlin.jvm.internal.p.d(cardStateIdentityB != null ? cardStateIdentityB.c() : null, stored.getRecordId());
    }
}
