package bn7;

import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public interface e {
    String a(String r100, JSONObject r101) throws Exception;

    String addCommonParams(String r100);

    void b();

    void c();

    void d();

    Set<String> e();

    String executeGet(String r100) throws Exception;

    void getHost();

    void getSafeHostList();

    void putCommonParams(Map r100);
}
