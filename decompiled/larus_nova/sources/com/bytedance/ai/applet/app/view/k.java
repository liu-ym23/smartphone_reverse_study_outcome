package com.bytedance.ai.applet.app.view;

import android.content.Context;
import android.view.ContextThemeWrapper;
import com.larus.nova.R;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class k {

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f34494a = null;

        static {
            int[] r100 = new int[AppletThemeMode.values().length];
            r100[AppletThemeMode.FOLLOW_SYSTEM.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[AppletThemeMode.LIGHT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[AppletThemeMode.DARK.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f34494a = r100;
        }
    }

    public static final int a(AppletThemeMode r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        int r101 = a.f34494a[r100.ordinal()];
        if (r101 != 1) goto L5;
        return R.style.AISDKAppletTokens;
    L5:
        if (r101 != 2) goto L7;
        return R.style.AISDKAppletTokens_Light;
    L7:
        if (r101 != 3) goto L10;
        return R.style.AISDKAppletTokens_Dark;
    L10:
        throw new NoWhenBranchMatchedException();
    }

    public static final Context b(Context r100, AppletThemeMode r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "mode");
        return new ContextThemeWrapper(r100, a(r101));
    }
}
