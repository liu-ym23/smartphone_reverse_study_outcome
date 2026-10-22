package com.bytedance.android.livesdk.widget;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext;
import com.bytedance.common.utility.UIUtils;

/* JADX INFO: loaded from: classes11.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f161945a = 0;

    public static boolean b() {
        IMiddleWareHostContext r100 = (IMiddleWareHostContext) jc1.k.f(IMiddleWareHostContext.class);
        if (r100 == null) goto L7;
        Boolean r101 = (Boolean) r100.getHostABValue("douyin_enterprise_verify_setting", "enterprise_verify_tag", Boolean.TRUE, Boolean.FALSE);
        if (r101 == null) goto L7;
        return r101.booleanValue();
    L7:
        return false;
    }

    static {
    }

    public static boolean a(HSImageView r100, IBaseUser r101) {
        if (b() == true) goto L5;
        return false;
    L5:
        if (r101 != null) goto L7;
    L18:
        UIUtils.setViewVisibility(r100, 8);
        return false;
    L7:
        if (r101.isEnterpriseVerify() != true) goto L18;
        py.c r102 = r101.getMAuthenticationInfo();
        py.k r103 = null;
        if (r102 == null) goto L11;
        py.k r104 = r102.getAuthenticationBadge();
    L12:
        if (r104 == null) goto L18;
        UIUtils.setViewVisibility(r100, 0);
        py.c r105 = r101.getMAuthenticationInfo();
        if (r105 == null) goto L16;
        r103 = r105.getAuthenticationBadge();
    L16:
        ImageUtil.loadImage(r100, r103, 0);
        return true;
    L11:
        r104 = null;
        goto L12
    }
}
