package com.bytedance.android.livehostapi.business;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.live.base.IService;
import com.bytedance.android.livehostapi.business.base.IBaseHostVerify;
import com.bytedance.android.livehostapi.business.depend.ICaptchaCallback;
import com.bytedance.android.livehostapi.business.depend.ILiveFaceCertCallback;
import com.bytedance.android.livehostapi.business.depend.ILiveTakePageVerifyCallback;
import com.bytedance.android.livehostapi.business.depend.IStartLiveVerifyCallback;
import com.bytedance.android.livehostapi.business.depend.IVerifyTicketCallback;
import com.bytedance.android.livesdkapi.eventbus.LiveRealStartEvent;
import io.reactivex.Single;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public interface IHostVerify extends IService, IMiddlewareHostVerify, IBaseHostVerify, IHostVerifyForSaas {
    public static final int VERIFY_REQUEST_CODE = 23456;

    void dismissCaptcha();

    @Override // com.bytedance.android.livehostapi.business.IMiddlewareHostVerify
    void doFaceLive(Context r100, HashMap<String, String> r101, HashMap<String, String> r102, JSONObject r103, boolean r104, ILiveFaceCertCallback r105);

    int getResultCode();

    String getReturnUrl();

    Intent getVerifyActivityIntent(Context r100);

    HashMap<String, String> getVerifyParams();

    void safeRegisterOnCreate(Object r100, LifecycleOwner r101);

    void showCaptcha(Activity r100, int r101, ICaptchaCallback r102);

    void showCaptchaV2(Activity r100, String r101, ICaptchaCallback r102);

    void startCertOrVerify(Activity r100, int r101, Bundle r102, IVerifyTicketCallback r103);

    Single<String> startTwiceVerify(Activity r100, String r101);

    Single<String> startTwiceVerifyWithDialog(Activity r100, String r101);

    void syncVerifyResult(LiveRealStartEvent r100);

    void verifyForStartLive(Activity r100, int r101, String r102, Bundle r103, IStartLiveVerifyCallback r104);

    void verifyForStartLive(Context r100, int r101, String r102, Bundle r103, IStartLiveVerifyCallback r104);

    void verifyForStartLiveFromTakePage(Activity r100, int r101, String r102, Bundle r103, IStartLiveVerifyCallback r104, ILiveTakePageVerifyCallback r105);
}
