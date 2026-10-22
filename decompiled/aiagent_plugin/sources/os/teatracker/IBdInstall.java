package os.teatracker;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;

/* JADX INFO: loaded from: classes5.dex */
public interface IBdInstall {
    public static final String PARAM_APP_CHANNEL = "app_channel";
    public static final String PARAM_APP_ID = "app_id";
    public static final String PARAM_APP_NAME = "app_name";
    public static final String PARAM_META_DATA = "meta_data";

    public interface a {
    }

    void register(Context r1, Handler r2, Bundle r3, a r4);
}
