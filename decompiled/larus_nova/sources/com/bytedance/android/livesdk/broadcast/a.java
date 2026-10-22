package com.bytedance.android.livesdk.broadcast;

import android.app.Activity;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.livehostapi.foundation.IHostApp;
import com.bytedance.android.livesdk.config.zh;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ArrayList<WeakReference<Activity>> f104368a = null;

    static {
        f104368a = new ArrayList();
    }

    public static void a(FragmentActivity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        if (zh.f121765a.getValue().booleanValue() == true) goto L5;
        return;
    L5:
        Iterator<WeakReference<Activity>> r101 = f104368a.iterator();
    L7:
        if (r101.hasNext() == false) goto L11;
        if (Intrinsics.areEqual(r101.next().get(), r100) == false) goto L7;
        return;
    L11:
        f104368a.add(new WeakReference(r100));
        IHostApp r102 = (IHostApp) k.f(IHostApp.class);
        if (r102 == null) goto L18;
        r102.setStartLivePageSize2Camera(1);
        return;
    }
}
