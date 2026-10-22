package a6c;

import com.larksuite.framework.callback.IGetDataCallback;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes38.dex */
public interface a {
    Map<String, c6c.a> a(String r100, List<String> r101);

    Map<String, c6c.a> getResources(String r100, List<String> r101);

    void getResources(String r100, List<String> r101, IGetDataCallback<Map<String, c6c.a>> r102);
}
