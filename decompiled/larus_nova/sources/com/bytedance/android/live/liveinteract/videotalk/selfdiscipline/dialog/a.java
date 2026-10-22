package com.bytedance.android.live.liveinteract.videotalk.selfdiscipline.dialog;

import com.bytedance.android.live.core.utils.s1;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes46.dex */
public final class a {
    public static final String a(int r100) {
        int r101 = r100 / 60;
        int r102 = r101 % 60;
        int r103 = r101 / 60;
        if (r103 <= 0) goto L10;
        if (r102 <= 0) goto L8;
        return s1.C(R.string.ttlive_self_discipline_duration_hours_and_minutes, new Object[]{Integer.valueOf(r103), Integer.valueOf(r102)});
    L8:
        return s1.C(R.string.ttlive_self_discipline_duration_hours, new Object[]{Integer.valueOf(r103)});
    L10:
        return s1.C(R.string.ttlive_self_discipline_duration_minutes, new Object[]{Integer.valueOf(r102)});
    }
}
