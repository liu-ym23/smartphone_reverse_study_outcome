package kotlin;

import La.H;
import Z8.C1172u;
import Z8.C1173v;
import Z8.F;
import com.autonavi.aps.amapapi.config.Const;
import java.util.ArrayList;
import java.util.List;
import kotlin.AbstractC0913i;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u001b\u0010\u0003\u001a\u0004\u0018\u00010\u0002*\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a!\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000*\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"", "LK6/i;", "", Const.INTENT_KEY_PKGNAME, "(Ljava/util/List;)Ljava/lang/String;", "LK6/i$d;", "text", Const.INTENT_KEY_APIKEY, "(LK6/i$d;Ljava/lang/String;)Ljava/util/List;", "common_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* renamed from: K6.j, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0914j {
    public static final List<AbstractC0913i> a(AbstractC0913i.Companion companion, String str) {
        p.i(companion, "<this>");
        return (str == null || H.x0(str)) ? C1173v.m() : C1172u.e(new AbstractC0913i.Text(str));
    }

    public static final String b(List<? extends AbstractC0913i> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (obj instanceof AbstractC0913i.Text) {
                arrayList.add(obj);
            }
        }
        AbstractC0913i.Text text = (AbstractC0913i.Text) F.s0(arrayList);
        if (text != null) {
            return text.getText();
        }
        return null;
    }
}
