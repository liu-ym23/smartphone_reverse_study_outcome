package com.bytedance.android.btm.impl.util;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.ContextWrapper;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.bytedance.android.btm.impl.setting.BtmSetting;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f42499a = null;

    public d() {
    }

    static {
        f42499a = new d();
    }

    public static Map.Entry a(Map r100) {
        Iterator r101 = r100.entrySet().iterator();
        Map.Entry r102 = null;
    L4:
        if (r101.hasNext() == false) goto L6;
        r102 = (Map.Entry) r101.next();
        goto L4
    L6:
        return r102;
    }

    public final Activity getActivity(View r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        if (BtmSetting.f42469d.c().b().t() == 1) goto L8;
    L11:
        Context r101 = r100.getContext();
    L12:
        if (r101 == null) goto L20;
        if ((r101 instanceof Activity) == true) goto L16;
        if ((r101 instanceof ContextWrapper) == false) goto L20;
        r101 = ((ContextWrapper) r101).getBaseContext();
        goto L12
    L16:
        return (Activity) r101;
    L20:
        return null;
    L8:
        if (Intrinsics.areEqual(r100.getClass().getName(), "com.android.internal.policy.DecorView") == false) goto L11;
        return getActivity(r100.findViewById(R.id.content));
    }

    public final Activity getActivity(Object r100) {
        if ((r100 instanceof Activity) == false) goto L7;
        return (Activity) r100;
    L7:
        if ((r100 instanceof Fragment) == false) goto L11;
        return ((Fragment) r100).getActivity();
    L11:
        if ((r100 instanceof Dialog) == false) goto L15;
        return getActivity((Dialog) r100);
    L15:
        if ((r100 instanceof View) == true) goto L17;
        return null;
    L17:
        return getActivity((View) r100);
    }

    public final Activity getActivity(Dialog r100) {
        if (r100 == null) goto L5;
        Context r101 = r100.getContext();
    L6:
        if (r101 == null) goto L14;
        if ((r101 instanceof Activity) == true) goto L10;
        if ((r101 instanceof ContextWrapper) == false) goto L14;
        r101 = ((ContextWrapper) r101).getBaseContext();
        goto L6
    L10:
        return (Activity) r101;
    L14:
        return null;
    L5:
        r101 = null;
        goto L6
    }
}
