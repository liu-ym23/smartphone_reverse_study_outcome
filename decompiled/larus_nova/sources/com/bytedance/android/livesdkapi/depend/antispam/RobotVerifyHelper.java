package com.bytedance.android.livesdkapi.depend.antispam;

import androidx.fragment.app.FragmentManager;
import com.bytedance.android.livesdkapi.depend.event.RobotVerifyEvent;
import com.bytedance.android.livesdkapi.depend.follow.OnVerifyResultListener;

/* JADX INFO: loaded from: classes12.dex */
public class RobotVerifyHelper implements IRobotVerifyHelper {
    @Override // com.bytedance.android.livesdkapi.depend.antispam.IRobotVerifyHelper
    public String getVerifySource() {
        return null;
    }

    @Override // com.bytedance.android.livesdkapi.depend.antispam.IRobotVerifyHelper
    public void handleRobotVerifyEvent(RobotVerifyEvent r100, FragmentManager r101) {
    }

    @Override // com.bytedance.android.livesdkapi.depend.antispam.IRobotVerifyHelper
    public void handleRobotVerifyException(Exception r100, FragmentManager r101) {
    }

    @Override // com.bytedance.android.livesdkapi.depend.antispam.IRobotVerifyHelper
    public void handleRobotVerifyException(Exception r100, FragmentManager r101, OnVerifyResultListener r102) {
    }

    @Override // com.bytedance.android.livesdkapi.depend.antispam.IRobotVerifyHelper
    public boolean isRobotVerifyException(Exception r100) {
        return false;
    }

    @Override // com.bytedance.android.livesdkapi.depend.antispam.IRobotVerifyHelper
    public void markSourceFromLive(String r100, String r101) {
    }

    @Override // com.bytedance.android.livesdkapi.depend.antispam.IRobotVerifyHelper
    public void markSourceFromVideo(String r100, String r101) {
    }

    @Override // com.bytedance.android.livesdkapi.depend.antispam.IRobotVerifyHelper
    public void setVerifySource(String r100) {
    }

    @Override // com.bytedance.android.livesdkapi.depend.antispam.IRobotVerifyHelper
    public void showCaptchaDialog(String r100, String r101, FragmentManager r102, OnVerifyResultListener r103) {
    }

    public RobotVerifyHelper() {
    }
}
