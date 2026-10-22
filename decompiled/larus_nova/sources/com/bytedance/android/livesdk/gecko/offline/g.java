package com.bytedance.android.livesdk.gecko.offline;

import android.app.Application;
import android.text.TextUtils;
import com.bytedance.android.live.core.setting.s1;
import com.bytedance.android.live.core.setting.t1;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext;
import com.bytedance.android.livehostapi.platform.IHostWebView;
import com.bytedance.android.livesdk.gecko.LiveGeckoConfig;
import java.io.File;
import jc1.k;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class g {
    public static String a() {
        IMiddleWareHostContext r100 = (IMiddleWareHostContext) k.f(IMiddleWareHostContext.class);
        if (r100 == null) goto L9;
        if (r100.isBoe() == false) goto L9;
        return "68f927652a5370ec9f4ae1dbaf56fd85";
    L9:
        if (v.a() == false) goto L12;
        return "36723dc3e85a23e701d1697d57de07ed";
    L12:
        return "5fb33cde3ebff01c8433ddc22aac0816";
    }

    public static String b() {
        IHostWebView r100 = (IHostWebView) k.f(IHostWebView.class);
        String r101 = null;
        if (r100 == null) goto L5;
        String r102 = r100.getHostGeckoCacheDir();
    L7:
        if (TextUtils.isEmpty(r102) == false) goto L26;
        Lazy r103 = LiveGeckoConfig.f125784a;
        String r104 = s1.f65405a.getValue();
        if (TextUtils.isEmpty(r104) == true) goto L11;
        StringBuilder r105 = new StringBuilder();
        Application r106 = jc1.a.b();
        if (r106 == null) goto L25;
        File r107 = r106.getFilesDir();
        if (r107 == null) goto L25;
        r101 = r107.getAbsolutePath();
    L25:
        r105.append(r101);
        r105.append(File.separator);
        r105.append(r104);
        return r105.toString();
    L11:
        if (t1.f65413a.getValue().booleanValue() == false) goto L13;
        String r108 = "offlineX/5fb33cde3ebff01c8433ddc22aac0816";
    L14:
        StringBuilder r109 = new StringBuilder();
        Application r110 = jc1.a.b();
        if (r110 == null) goto L19;
        File r111 = r110.getFilesDir();
        if (r111 == null) goto L19;
        r101 = r111.getAbsolutePath();
    L19:
        r109.append(r101);
        r109.append(File.separator);
        r109.append(r108);
        return r109.toString();
    L13:
        r108 = "live_sdk_gecko";
        goto L14
    L26:
        Intrinsics.checkNotNull(r102);
        return r102;
    L5:
        r102 = null;
        goto L7
    }

    static {
    }
}
