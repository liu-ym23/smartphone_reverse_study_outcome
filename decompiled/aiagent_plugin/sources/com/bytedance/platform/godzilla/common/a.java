package com.bytedance.platform.godzilla.common;

import android.app.Activity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: ActivityLifecycleUtil.java */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Map<Integer, WeakReference<Activity>> f9071a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static WeakReference<Activity> f9072b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static WeakReference<Activity> f9073c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static WeakReference<Activity> f9074d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static WeakReference<Activity> f9075e;

    static /* synthetic */ Map a() {
        return f9071a;
    }

    static {
        f9071a = new HashMap();
        f9072b = null;
        f9073c = null;
        f9074d = null;
        f9075e = null;
    }

    public static Activity getActivity(int r2) {
        if (f9071a.get(Integer.valueOf(r2)) != null) goto L5;
        return null;
    L5:
        return (Activity) ZeusTransformUtils.preCheckCast(((WeakReference) ZeusTransformUtils.preCheckCast(f9071a.get(Integer.valueOf(r2)), WeakReference.class, "com.obric.aiagent.plugin")).get(), Activity.class, "com.obric.aiagent.plugin");
    }
}
