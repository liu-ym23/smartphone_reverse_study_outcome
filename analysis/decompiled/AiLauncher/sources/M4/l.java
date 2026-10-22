package M4;

import La.B;
import La.C;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import kotlin.Metadata;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0003\u001a!\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0007\u0010\b\u001a\u0019\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0001\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lorg/json/JSONObject;", "raw", "", "default", Const.INTENT_KEY_PKGNAME, "(Lorg/json/JSONObject;I)I", UxipConstants.f30680s, Const.INTENT_KEY_APIKEY, "(I)I", "", Const.INTENT_KEY_UMID, "(Lorg/json/JSONObject;)Ljava/lang/Float;", "agentsprite_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class l {
    public static final int a(int i10) {
        if (i10 < 0) {
            return -1;
        }
        if (i10 == 0) {
            return 1;
        }
        return i10;
    }

    public static final int b(JSONObject raw, int i10) throws JSONException {
        Integer numW;
        kotlin.jvm.internal.p.i(raw, "raw");
        if (raw.has("loop")) {
            Object obj = raw.get("loop");
            if (obj instanceof Boolean) {
                return ((Boolean) obj).booleanValue() ? -1 : 1;
            }
            if (obj instanceof Integer) {
                return a(((Number) obj).intValue());
            }
            if (obj instanceof Long) {
                return a((int) ((Number) obj).longValue());
            }
            if (obj instanceof Double) {
                return a((int) ((Number) obj).doubleValue());
            }
            if (obj instanceof Number) {
                return a(((Number) obj).intValue());
            }
            if ((obj instanceof String) && (numW = C.w((String) obj)) != null) {
                return a(numW.intValue());
            }
        }
        return i10;
    }

    public static /* synthetic */ int c(JSONObject jSONObject, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = -1;
        }
        return b(jSONObject, i10);
    }

    public static final Float d(JSONObject raw) {
        kotlin.jvm.internal.p.i(raw, "raw");
        if (!raw.has("fps")) {
            return null;
        }
        Object objOpt = raw.opt("fps");
        if (objOpt instanceof Number) {
            return Float.valueOf(((Number) objOpt).floatValue());
        }
        if (objOpt instanceof String) {
            return B.u((String) objOpt);
        }
        return null;
    }
}
