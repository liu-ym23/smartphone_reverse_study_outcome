package at6;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
public interface c {

    public static final class a {
        public static void a(String r100, JSONObject r101) {
            Intrinsics.checkNotNullParameter(r100, "eventName");
            Intrinsics.checkNotNullParameter(r101, "params");
        }
    }

    void OZ();

    void Pd(String r100, JSONObject r101);
}
