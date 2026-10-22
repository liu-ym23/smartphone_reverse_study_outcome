package com.bytedance.android.livesdk.utils;

import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.android.live.core.setting.SettingUtil;
import com.larus.nova.R;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class b1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f158888a = 0;

    static {
    }

    public static void a(TextView r100) {
        int r101 = com.bytedance.android.live.core.utils.s1.j(R.dimen.ttlive_dialog_title_height);
        if (r100 == null) goto L7;
        ViewGroup.LayoutParams r102 = r100.getLayoutParams();
        if (r102 == null) goto L7;
        r102.height = r101;
        r100.setLayoutParams(r102);
    L7:
        int r103 = com.bytedance.android.live.core.utils.s1.j(R.dimen.ttlive_dialog_title_text_size);
        if (r100 == null) goto L10;
        r100.setTextSize(0, r103);
    L10:
        int r104 = com.bytedance.android.live.core.utils.s1.h(R.color.ttlive_dialog_main_text);
        if (r100 == null) goto L14;
        r100.setTextColor(r104);
        return;
    }

    public static void b(boolean r100, Function0 r101) {
        Intrinsics.checkNotNullParameter(r101, "operate");
        if (((Boolean) SettingUtil.getValue("key_ttlive_sdk_setting", "live_panel_standardized", Boolean.TYPE, Boolean.FALSE)).booleanValue() == false) goto L7;
        if (r100 == false) goto L8;
        r101.invoke();
        return;
    L8:
        return;
    }
}
