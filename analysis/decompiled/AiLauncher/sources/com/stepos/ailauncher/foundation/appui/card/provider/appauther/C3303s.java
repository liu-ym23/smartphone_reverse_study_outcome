package com.stepos.ailauncher.foundation.appui.card.provider.appauther;

import android.content.Context;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.foundation.appui.card.provider.appauther.AbstractC3297l;
import com.stepos.ailauncher.foundation.appui.card.provider.appauther.z;
import io.ktor.sse.ServerSentEventKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ#\u0010\f\u001a\b\u0012\u0004\u0012\u00020\n0\t2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0014¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000eH\u0014¢\u0006\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0014\u001a\u00020\u00138\u0014X\u0094D¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/appauther/s;", "Lcom/stepos/ailauncher/foundation/appui/card/provider/appauther/v;", "<init>", "()V", "Landroid/content/Context;", "context", "LN5/d;", Const.INTENT_KEY_APIKEY, "(Landroid/content/Context;)LN5/d;", "", "Lcom/stepos/ailauncher/foundation/appui/card/provider/appauther/r;", "raw", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Ljava/util/List;)Ljava/util/List;", "Lcom/stepos/ailauncher/foundation/appui/card/provider/appauther/l$c;", "input", "Lcom/stepos/ailauncher/foundation/appui/card/provider/appauther/l$b;", Const.INTENT_KEY_UMID, "(Lcom/stepos/ailauncher/foundation/appui/card/provider/appauther/l$c;)Lcom/stepos/ailauncher/foundation/appui/card/provider/appauther/l$b;", "", "mode", "Ljava/lang/String;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "()Ljava/lang/String;", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.foundation.appui.card.provider.appauther.s, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C3303s extends v {
    private final String mode = "guide";

    @Override // N5.v
    public N5.d a(Context context) {
        kotlin.jvm.internal.p.i(context, "context");
        return new t(context, null, 0, 6, null);
    }

    @Override // com.stepos.ailauncher.foundation.appui.card.provider.appauther.AbstractC3297l
    public AbstractC3297l.Body d(AbstractC3297l.BodyInput input) {
        kotlin.jvm.internal.p.i(input, "input");
        z zVar = z.INSTANCE;
        String authText = input.getAuthText();
        List<AppAutherField> listC = input.c();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = listC.iterator();
        while (it.hasNext()) {
            String strD = N5.j.INSTANCE.d(((AppAutherField) it.next()).getHelpText());
            if (strD != null) {
                arrayList.add(strD);
            }
        }
        z.GuideSteps guideStepsE = zVar.e(authText, arrayList);
        R5.b.INSTANCE.e("auther.guide.steps:" + input.getDisplayName() + ServerSentEventKt.COLON + guideStepsE.getSource(), "auther.guide.steps", Y8.j.a("source", guideStepsE.getSource()), Y8.j.a("count", Integer.valueOf(guideStepsE.b().size())), Y8.j.a("truncated", Boolean.valueOf(guideStepsE.getTruncated())));
        return guideStepsE.b().isEmpty() ? new AbstractC3297l.Body(z.INSTANCE.d(input.getAuthText(), input.getDisplayName()), null, 2, null) : new AbstractC3297l.Body("", guideStepsE.b());
    }

    @Override // com.stepos.ailauncher.foundation.appui.card.provider.appauther.AbstractC3297l
    /* renamed from: h, reason: from getter */
    public String getMode() {
        return this.mode;
    }

    @Override // com.stepos.ailauncher.foundation.appui.card.provider.appauther.v, com.stepos.ailauncher.foundation.appui.card.provider.appauther.AbstractC3297l
    public List<AppAutherField> i(List<AppAutherField> raw) {
        kotlin.jvm.internal.p.i(raw, "raw");
        ArrayList arrayList = new ArrayList();
        for (Object obj : raw) {
            if (((AppAutherField) obj).getSecret()) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : arrayList) {
            AppAutherField appAutherField = (AppAutherField) obj2;
            String name = appAutherField.getName();
            if (name == null) {
                name = "";
            }
            String label = appAutherField.getLabel();
            String str = name + " " + (label != null ? label : "");
            if (La.H.e0(str, "secret", true) || La.H.g0(str, "密钥", false, 2, null) || La.H.g0(str, "密匙", false, 2, null)) {
                arrayList2.add(obj2);
            }
        }
        if (!arrayList2.isEmpty()) {
            arrayList = arrayList2;
        }
        return super.i(arrayList);
    }
}
