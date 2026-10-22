package bj;

import android.content.Context;
import com.bytedance.retrofit2.Converter;
import com.google.gson.Gson;
import java.util.Map;

/* JADX INFO: loaded from: classes44.dex */
public interface a {
    Object a(String r100, Class r101, Converter.Factory r102, Gson r103);

    <T> T create(String r100, Class<T> r101);

    <T> T create(String r100, Class<T> r101, Converter.Factory r102, Map<String, Object> r103);

    String getNetworkAccessType(Context r100);
}
