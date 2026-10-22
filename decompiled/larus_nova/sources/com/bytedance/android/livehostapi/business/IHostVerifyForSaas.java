package com.bytedance.android.livehostapi.business;

import android.app.Activity;
import com.bytedance.android.livehostapi.business.depend.OnZhimaVerifyListener;
import java.util.Map;

/* JADX INFO: loaded from: classes7.dex */
public interface IHostVerifyForSaas {

    /* JADX INFO: renamed from: com.bytedance.android.livehostapi.business.IHostVerifyForSaas$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$zhimaVerify(IHostVerifyForSaas r100, Activity r101, Map r102, OnZhimaVerifyListener r103) {
        }
    }

    void zhimaVerify(Activity r100, Map<String, String> r101, OnZhimaVerifyListener r102);
}
