package com.stepos.ailauncher.foundation.appui.card.provider.lifeservice;

import N5.v;
import android.content.Context;
import com.autonavi.aps.amapapi.config.Const;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\u0012\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0010\u0010\u0011R \u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/lifeservice/LifeServiceCardProvider;", "LN5/v;", "", "", "", "vendorIcons", "<init>", "(Ljava/util/Map;)V", "LN5/i;", "envelope", "LN5/n;", Const.INTENT_KEY_PKGNAME, "(LN5/i;)LN5/n;", "Landroid/content/Context;", "context", "LN5/d;", Const.INTENT_KEY_APIKEY, "(Landroid/content/Context;)LN5/d;", "Ljava/util/Map;", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class LifeServiceCardProvider implements v {
    private final Map<String, Integer> vendorIcons;

    public LifeServiceCardProvider(Map<String, Integer> vendorIcons) {
        p.i(vendorIcons, "vendorIcons");
        this.vendorIcons = vendorIcons;
    }

    @Override // N5.v
    public N5.d a(Context context) {
        p.i(context, "context");
        return new f(context, null, 0, 6, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x0104  */
    @Override // N5.v
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public N5.n b(N5.CardEnvelope r23) {
        /*
            Method dump skipped, instructions count: 479
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.foundation.appui.card.provider.lifeservice.LifeServiceCardProvider.b(N5.i):N5.n");
    }

    public /* synthetic */ LifeServiceCardProvider(Map map, int i10, kotlin.jvm.internal.i iVar) {
        this((i10 & 1) != 0 ? kotlin.collections.a.i() : map);
    }
}
