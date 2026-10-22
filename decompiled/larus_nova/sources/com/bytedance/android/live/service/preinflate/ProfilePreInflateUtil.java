package com.bytedance.android.live.service.preinflate;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ContextUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import rs0.m0;

/* JADX INFO: loaded from: classes47.dex */
public final class ProfilePreInflateUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f100873a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f100874b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static int f100875c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static int f100876d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static int f100877e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final List<String> f100878f = null;

    static {
        f100873a = LazyKt.lazy(ProfilePreInflateUtil$DELAY_TIME$2.INSTANCE);
        f100878f = new ArrayList();
    }

    public static boolean a() {
        if (m0.f539067a.getValue().intValue() <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static void b(a r100, ProfilePreInflateViewInfo r101) {
        int r102 = r101.getCount() - r100.c(r101.getResId());
        ALogger.i("NewUserProfile_PreLayout", "fullWannaCache, tag = " + r101.getTag() + ", repeatCount = " + r102);
        if (r102 <= 0) goto L7;
        int r103 = 0;
    L5:
        if (r103 >= r102) goto L9;
        r100.d(r101.getResId(), r101.getContainerViewClass());
        r103 = r103 + 1;
        goto L5
    L9:
        return;
    }

    public static void d(FragmentActivity r100, List r101) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "preViewInfos");
        a r102 = ViewPools.a(r100);
        Iterator r103 = r101.iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        b(r102, (ProfilePreInflateViewInfo) r103.next());
        goto L4
    }

    public static View c(ProfilePreInflateViewInfo r100, Context r101, LayoutInflater r102, ViewGroup r103, boolean r104) {
        Intrinsics.checkNotNullParameter(r100, "viewInfo");
        Intrinsics.checkNotNullParameter(r102, "fallbackInflater");
        r100.setUsed(true);
        FragmentActivity r105 = ContextUtil.contextToFragmentActivity(r101);
        if (r105 != null) goto L5;
        boolean r106 = false;
    L6:
        ALogger.i("NewUserProfile_PreLayout", "check hasCachedView, tag = " + r100.getTag() + ", layoutId = " + r100.getResId() + " has cache view: " + r106);
        f100877e = f100877e + 1;
        if (r106 == false) goto L9;
        f100876d++;
    L9:
        FragmentActivity r107 = ContextUtil.contextToFragmentActivity(r101);
        if (r107 != null) goto L13;
        ALogger.e("NewUserProfile_PreLayout", "inflate error, activity is null, tag = " + r100.getTag());
        return r102.inflate(r100.getResId(), r103, r104);
    L13:
        ALogger.i("NewUserProfile_PreLayout", "get cache view from view pool");
        View r108 = ViewPools.a(r107).b(r100.getResId(), r103, r104);
        a r109 = ViewPools.a(r107);
        ArrayList r110 = (ArrayList) f100878f;
        if (r110.contains(r100.getTag()) == false) goto L16;
        ALogger.i("NewUserProfile_PreLayout", "commit delay task fail, tag = " + r100.getTag() + " is in delay list");
    L17:
        return r108;
    L16:
        ALogger.i("NewUserProfile_PreLayout", "commit delay task success, tag = " + r100.getTag());
        r110.add(r100.getTag());
        r109.e(((Number) f100873a.getValue()).longValue(), new b(r109, r100));
        goto L17
    L5:
        r106 = ViewPools.a(r105).a(r100.getResId());
        goto L6
    }
}
