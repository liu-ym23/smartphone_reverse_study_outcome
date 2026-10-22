package cd4;

import android.content.Context;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public interface m {
    boolean canRunInBackground();

    String getName();

    void handle(Context r100, JSONObject r101, k r102);

    <T> void putDependency(Class<T> r100, T r101);

    void release();
}
