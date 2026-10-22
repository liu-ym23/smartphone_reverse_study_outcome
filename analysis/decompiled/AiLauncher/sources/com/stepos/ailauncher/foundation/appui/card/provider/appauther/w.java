package com.stepos.ailauncher.foundation.appui.card.provider.appauther;

import android.content.Context;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.foundation.appui.card.provider.appauther.AbstractC3297l;
import com.stepos.ailauncher.foundation.appui.card.provider.appauther.AppAutherCardModel;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0014¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\n\u001a\u00020\u000eH\u0014¢\u0006\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0013\u001a\u00020\u00128\u0014X\u0094D¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/appauther/w;", "Lcom/stepos/ailauncher/foundation/appui/card/provider/appauther/l;", "<init>", "()V", "Landroid/content/Context;", "context", "LN5/d;", Const.INTENT_KEY_APIKEY, "(Landroid/content/Context;)LN5/d;", "Lcom/stepos/ailauncher/foundation/appui/card/provider/appauther/l$c;", "input", "Lcom/stepos/ailauncher/foundation/appui/card/provider/appauther/l$b;", Const.INTENT_KEY_UMID, "(Lcom/stepos/ailauncher/foundation/appui/card/provider/appauther/l$c;)Lcom/stepos/ailauncher/foundation/appui/card/provider/appauther/l$b;", "Lcom/stepos/ailauncher/foundation/appui/card/provider/appauther/l$a;", "Lcom/stepos/ailauncher/foundation/appui/card/provider/appauther/k$a;", "c", "(Lcom/stepos/ailauncher/foundation/appui/card/provider/appauther/l$a;)Lcom/stepos/ailauncher/foundation/appui/card/provider/appauther/k$a;", "", "mode", "Ljava/lang/String;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "()Ljava/lang/String;", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class w extends AbstractC3297l {
    private final String mode = "oauth";

    @Override // N5.v
    public N5.d a(Context context) {
        kotlin.jvm.internal.p.i(context, "context");
        return new x(context, null, 0, 6, null);
    }

    @Override // com.stepos.ailauncher.foundation.appui.card.provider.appauther.AbstractC3297l
    public AppAutherCardModel.ActionItem c(AbstractC3297l.ActionInput input) {
        kotlin.jvm.internal.p.i(input, "input");
        return AbstractC3297l.g(this, input.getVendorId(), "去授权", AppAutherCardModel.ActionItem.ACTION_START_AUTH, 0, 0, 24, null);
    }

    @Override // com.stepos.ailauncher.foundation.appui.card.provider.appauther.AbstractC3297l
    public AbstractC3297l.Body d(AbstractC3297l.BodyInput input) {
        kotlin.jvm.internal.p.i(input, "input");
        return new AbstractC3297l.Body(z.INSTANCE.g(input.getAuthText(), input.getDisplayName()), null, 2, null);
    }

    @Override // com.stepos.ailauncher.foundation.appui.card.provider.appauther.AbstractC3297l
    /* renamed from: h, reason: from getter */
    public String getMode() {
        return this.mode;
    }
}
