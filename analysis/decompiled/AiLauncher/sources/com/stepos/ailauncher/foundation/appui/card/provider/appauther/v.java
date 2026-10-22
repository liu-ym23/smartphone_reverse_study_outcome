package com.stepos.ailauncher.foundation.appui.card.provider.appauther;

import Z8.C1172u;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.foundation.appui.card.provider.appauther.AbstractC3297l;
import com.stepos.ailauncher.foundation.appui.card.provider.appauther.AppAutherCardModel;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b \u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J#\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0014¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\n\u001a\u00020\tH\u0004¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/appauther/v;", "Lcom/stepos/ailauncher/foundation/appui/card/provider/appauther/l;", "<init>", "()V", "", "Lcom/stepos/ailauncher/foundation/appui/card/provider/appauther/r;", "raw", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Ljava/util/List;)Ljava/util/List;", "Lcom/stepos/ailauncher/foundation/appui/card/provider/appauther/l$a;", "input", "Lcom/stepos/ailauncher/foundation/appui/card/provider/appauther/k$a;", "c", "(Lcom/stepos/ailauncher/foundation/appui/card/provider/appauther/l$a;)Lcom/stepos/ailauncher/foundation/appui/card/provider/appauther/k$a;", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class v extends AbstractC3297l {
    @Override // com.stepos.ailauncher.foundation.appui.card.provider.appauther.AbstractC3297l
    public final AppAutherCardModel.ActionItem c(AbstractC3297l.ActionInput input) {
        kotlin.jvm.internal.p.i(input, "input");
        return AbstractC3297l.g(this, input.getVendorId(), AbstractC3297l.LABEL_SUBMIT, AppAutherCardModel.ActionItem.ACTION_SUBMIT_KEY, 0, 0, 24, null);
    }

    @Override // com.stepos.ailauncher.foundation.appui.card.provider.appauther.AbstractC3297l
    public List<AppAutherField> i(List<AppAutherField> raw) {
        kotlin.jvm.internal.p.i(raw, "raw");
        ArrayList arrayList = new ArrayList();
        for (Object obj : raw) {
            String name = ((AppAutherField) obj).getName();
            if (!(name == null || La.H.x0(name))) {
                arrayList.add(obj);
            }
        }
        if (arrayList.size() != raw.size()) {
            R5.b.INSTANCE.h("provider.auther.fields.drop", Y8.j.a("reason", "blank_name"), Y8.j.a("got", Integer.valueOf(raw.size())), Y8.j.a("kept", Integer.valueOf(arrayList.size())));
        }
        return !arrayList.isEmpty() ? arrayList : C1172u.e(new AppAutherField("api_key", AbstractC3297l.LABEL_KEY_SECTION, null, null, false, 28, null));
    }
}
