package com.bytedanceos.appstore.buss.entity.item;

import android.text.TextUtils;
import com.bytedanceos.appstore.buss.entity.CommonAppEntity;
import com.bytedanceos.common.BaseApplication;
import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.toolbox.SizeConverter;
import com.bytedanceos.common.toolbox.e;

/* JADX INFO: loaded from: classes2.dex */
public class CommonAppItem {
    private AppInfo mAppInfo;
    public int mStarResId;

    public CommonAppItem(CommonAppEntity r10) {
        this.mStarResId = e.b0(BaseApplication.c(), r10.getScores(), false);
        AppInfo r11 = r10.convertAppInfo();
        this.mAppInfo = r11;
        r11.setAppSize(SizeConverter.BTrim.convert(r11.appBytes));
    }

    public boolean areContentsTheSame(CommonAppItem r10) {
        if (r10 != null) goto L5;
        return false;
    L5:
        if (this.mStarResId == r10.mStarResId) goto L7;
        return false;
    L7:
        if (TextUtils.equals(r10.getAppInfo().toString(), this.mAppInfo.toString()) == false) goto L12;
        return true;
    L12:
        return false;
    }

    public AppInfo getAppInfo() {
        return this.mAppInfo;
    }

    public CommonAppItem(CommonAppEntity r10, AppInfo r11) {
        this.mStarResId = e.b0(BaseApplication.c(), r10.getScores(), false);
        this.mAppInfo = r11;
        r11.setAppSize(SizeConverter.BTrim.convert(r11.appBytes));
    }
}
