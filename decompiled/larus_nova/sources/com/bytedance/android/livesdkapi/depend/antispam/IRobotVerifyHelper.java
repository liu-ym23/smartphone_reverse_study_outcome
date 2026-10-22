package com.bytedance.android.livesdkapi.depend.antispam;

import androidx.fragment.app.FragmentManager;
import com.bytedance.android.livesdkapi.depend.event.RobotVerifyEvent;
import com.bytedance.android.livesdkapi.depend.follow.OnVerifyResultListener;

/* JADX INFO: loaded from: classes12.dex */
public interface IRobotVerifyHelper {
    String getVerifySource();

    void handleRobotVerifyEvent(RobotVerifyEvent r100, FragmentManager r101);

    void handleRobotVerifyException(Exception r100, FragmentManager r101);

    void handleRobotVerifyException(Exception r100, FragmentManager r101, OnVerifyResultListener r102);

    boolean isRobotVerifyException(Exception r100);

    void markSourceFromLive(String r100, String r101);

    void markSourceFromVideo(String r100, String r101);

    void setVerifySource(String r100);

    void showCaptchaDialog(String r100, String r101, FragmentManager r102, OnVerifyResultListener r103);
}
