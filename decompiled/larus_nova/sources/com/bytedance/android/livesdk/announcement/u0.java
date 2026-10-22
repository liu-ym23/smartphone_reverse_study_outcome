package com.bytedance.android.livesdk.announcement;

import android.content.Context;
import com.bytedance.ies.utility.SharedPrefHelper;

/* JADX INFO: loaded from: classes7.dex */
public final class u0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f103594a = 0;

    public static final class a {
        public static void a(Context r100) {
            SharedPrefHelper r101 = SharedPrefHelper.b(r100);
            r101.l("live.pref.PREF_ANNOUNCEMENT_ID_SHOW_IN_HIGHLIGHT", 0L);
            r101.a();
        }
    }

    static {
    }
}
