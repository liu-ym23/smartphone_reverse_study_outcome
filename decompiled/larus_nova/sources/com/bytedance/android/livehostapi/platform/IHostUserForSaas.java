package com.bytedance.android.livehostapi.platform;

import android.app.Activity;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.livehostapi.platform.depend.user.HostFollowParams;
import com.bytedance.android.livehostapi.platform.depend.user.IFollowCallback;
import com.bytedance.android.livehostapi.platform.depend.user.ILoginCallback;
import com.bytedance.android.livehostapi.platform.depend.user.IResultCallback;
import com.bytedance.android.livesdk.user.l;

/* JADX INFO: loaded from: classes7.dex */
public interface IHostUserForSaas {

    /* JADX INFO: renamed from: com.bytedance.android.livehostapi.platform.IHostUserForSaas$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static String $default$hostUserIdentifier(IHostUserForSaas r100) {
            return null;
        }

        public static void $default$hostUserLogin(IHostUserForSaas r100, Activity r101, ILoginCallback r102) {
        }

        public static void $default$login(IHostUserForSaas r100, FragmentActivity r101, ILoginCallback r102, l r103) {
        }

        public static void $default$onFollowStatusChanged(IHostUserForSaas r100, int r101, String r102, boolean r103) {
        }

        public static void $default$unFollowWithConfirm(IHostUserForSaas r100, Activity r101, int r102, String r103, IResultCallback r104) {
        }

        public static void $default$hostUserFollow(IHostUserForSaas r100, Activity r101, HostFollowParams r102, IFollowCallback r103) {
            r103.onCancel(new IllegalStateException("not impl"));
        }
    }

    void hostUserFollow(Activity r100, HostFollowParams r101, IFollowCallback r102);

    String hostUserIdentifier();

    void hostUserLogin(Activity r100, ILoginCallback r101);

    void login(FragmentActivity r100, ILoginCallback r101, l r102);

    void onFollowStatusChanged(int r100, String r101, boolean r102);

    void unFollowWithConfirm(Activity r100, int r101, String r102, IResultCallback r103);
}
