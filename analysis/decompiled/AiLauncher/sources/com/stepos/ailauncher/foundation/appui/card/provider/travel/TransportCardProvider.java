package com.stepos.ailauncher.foundation.appui.card.provider.travel;

import La.H;
import android.content.Context;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/travel/TransportCardProvider;", "LN5/v;", "<init>", "()V", "LN5/i;", "envelope", "LN5/n;", Const.INTENT_KEY_PKGNAME, "(LN5/i;)LN5/n;", "Landroid/content/Context;", "context", "LN5/d;", Const.INTENT_KEY_APIKEY, "(Landroid/content/Context;)LN5/d;", "", "templateType", "Lcom/stepos/ailauncher/foundation/appui/card/provider/travel/TransportType;", "c", "(Ljava/lang/String;)Lcom/stepos/ailauncher/foundation/appui/card/provider/travel/TransportType;", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class TransportCardProvider implements N5.v {
    @Override // N5.v
    public N5.d a(Context context) {
        kotlin.jvm.internal.p.i(context, "context");
        return new q(context, null, 0, 6, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:55:0x017d  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0189  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01d3  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x01ea  */
    @Override // N5.v
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public N5.n b(N5.CardEnvelope r18) {
        /*
            Method dump skipped, instructions count: 550
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.foundation.appui.card.provider.travel.TransportCardProvider.b(N5.i):N5.n");
    }

    public final TransportType c(String templateType) {
        return H.e0(templateType, O5.c.TRAIN, true) ? TransportType.TRAIN : TransportType.FLIGHT;
    }
}
