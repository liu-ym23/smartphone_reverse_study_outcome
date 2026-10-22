package bw;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.gamecp.host_api.model.user.User;
import com.bytedance.android.gamecp.host_api.service.IBaseHostService;

/* JADX INFO: loaded from: classes44.dex */
public interface p extends IBaseHostService {
    User b();

    String getCurUserId();

    String getProtectedName(String r100, String r101);

    void getUidContactPermissionState();

    boolean isLogin();

    void q(String r100);

    hw.b user();

    boolean userNameIsProtected();

    void v1(FragmentActivity r100, hw.a r101, String r102, int r103, String r104);
}
