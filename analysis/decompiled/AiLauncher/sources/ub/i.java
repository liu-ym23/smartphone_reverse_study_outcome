package ub;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import tb.C5530C;

@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0011\u0010\u0001\u001a\u00020\u0000*\u00020\u0000¢\u0006\u0004\b\u0001\u0010\u0002¨\u0006\u0003"}, d2 = {"Ltb/C;", Const.INTENT_KEY_APIKEY, "(Ltb/C;)Ltb/C;", "okhttp"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class i {
    public static final C5530C a(C5530C c5530c) {
        kotlin.jvm.internal.p.i(c5530c, "<this>");
        return c5530c.e0().b(new h(c5530c.getBody().getMediaType(), c5530c.getBody().getContentLength())).c();
    }
}
