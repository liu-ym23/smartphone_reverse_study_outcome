package bw;

import android.app.Application;
import android.content.Context;
import com.bytedance.android.gamecp.host_api.service.IBaseHostService;
import java.util.HashMap;

/* JADX INFO: loaded from: classes44.dex */
public interface d extends IBaseHostService {
    void L1();

    String M();

    boolean c();

    Context getAppContext();

    void getAppIcon();

    int getAppId();

    String getAppName();

    Application getApplication();

    String getChannel();

    String getDeviceId();

    String getDevicePlatform();

    String getPackageName();

    int getUpdateVersionCode();

    long getVersionCode();

    String getVersionName();

    int hostAppId();

    boolean isBoe();

    boolean isLocalTest();

    String l();

    HashMap<String, String> o1();
}
