package bx7;

import android.app.Activity;
import android.view.View;
import java.util.Map;

/* JADX INFO: loaded from: classes23.dex */
public interface a {
    View getEngineView();

    Activity getOwnerActivity();

    <T> T getService(Class<T> r100);

    void sendEvent(String r100, Map<String, ? extends Object> r101);
}
