package android.ss.com.vboost;

import android.os.Bundle;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class VboostListener {

    public interface SystemListener {
        void onSystemEvent(int r100, int r101, Bundle r102);
    }

    public interface VboostApplogListener {
        void onInternalEventV3(String r100, JSONObject r101, String r102, String r103, String r104);
    }

    public VboostListener() {
    }
}
