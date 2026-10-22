package ub;

import com.autonavi.aps.amapapi.config.Const;
import java.text.Normalizer;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0004\u001a\u0017\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"", "string", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;)Ljava/lang/String;", "okhttp"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class m {
    public static final String a(String string) {
        kotlin.jvm.internal.p.i(string, "string");
        String strNormalize = Normalizer.normalize(string, Normalizer.Form.NFC);
        kotlin.jvm.internal.p.h(strNormalize, "normalize(...)");
        return strNormalize;
    }
}
