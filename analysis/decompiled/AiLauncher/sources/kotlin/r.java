package kotlin;

import La.H;
import com.autonavi.aps.amapapi.config.Const;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u001a\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\"\u0014\u0010\u0004\u001a\u00020\u00018\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"LK6/m;", "", Const.INTENT_KEY_APIKEY, "(LK6/m;)Ljava/lang/String;", "EXTRA_EXTERNAL_APPROVAL_REQUEST_ID", "Ljava/lang/String;", "common_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class r {
    public static final String EXTRA_EXTERNAL_APPROVAL_REQUEST_ID = "approval_request_id";

    public static final String a(C0917m c0917m) {
        String str;
        String string;
        p.i(c0917m, "<this>");
        Map<String, String> mapS = c0917m.s();
        if (mapS == null || (str = mapS.get(EXTRA_EXTERNAL_APPROVAL_REQUEST_ID)) == null || (string = H.D1(str).toString()) == null || string.length() <= 0) {
            return null;
        }
        return string;
    }
}
