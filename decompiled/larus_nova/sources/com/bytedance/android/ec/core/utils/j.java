package com.bytedance.android.ec.core.utils;

import android.view.View;
import android.view.ViewGroup;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f45614a = 0;

    public static final class a {
        @JvmStatic
        public static void a(View r100) {
            Intrinsics.checkNotNullParameter(r100, "view");
            ViewGroup.LayoutParams r101 = r100.getLayoutParams();
            r101.height = eh.b.b(r100.getContext());
        }
    }

    static {
    }
}
