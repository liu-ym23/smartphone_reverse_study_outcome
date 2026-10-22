package com.bytedance.android.livesdk.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import androidx.core.view.LayoutInflaterCompat;
import androidx.core.view.LayoutInflaterFactory;
import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.base.i;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.larus.nova.R;
import java.util.concurrent.ConcurrentHashMap;
import jc1.k;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes11.dex */
public class LivePlaceHolderView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f159255a = null;

    public class a implements LayoutInflaterFactory {
        public a() {
        }

        @Override // androidx.core.view.LayoutInflaterFactory
        public final View onCreateView(View r100, String r101, Context r102, AttributeSet r103) {
            boolean r104 = TextUtils.equals(LivePlaceHolderView.f159255a, r101);
            View r105 = null;
            if (r104 == false) goto L17;
            if (r102 == null) goto L17;
            if (r103 == null) goto L17;
            TypedArray r106 = r102.obtainStyledAttributes(r103, new int[]{R.attr.real_view_name, R.attr.service_name}, 0, 0);
            String r107 = r106.getString(0);
            String r108 = r106.getString(1);
            if (TextUtils.isEmpty(r107) == false) goto L9;
        L16:
            r106.recycle();
            goto L17
        L9:
            if (TextUtils.isEmpty(r108) == true) goto L16;
            IService r109 = k.f(LivePlaceHolderView.a(r108));     // Catch: ClassNotFoundException -> L14
            if ((r109 instanceof i) == false) goto L16;
            r105 = ((i) r109).createView(r107, r102, r103);     // Catch: ClassNotFoundException -> L14
        L14:
            e = move-exception;
            e.printStackTrace();
        L17:
            return r105;
        }
    }

    static {
        f159255a = LivePlaceHolderView.class.getName();
    }

    public LivePlaceHolderView(Context r100) {
        super(r100);
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r103 = Class.forName(r100);     // Catch: Throwable -> L8
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
    L7:
        return r103;
    L8:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r100);
    L12:
        throw th;
    L34:
        Class<?> r104 = Class.forName(r100);     // Catch: Throwable -> L17
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
    L16:
        return r104;
    L17:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r100);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r100);
    }

    public static LayoutInflater b(LayoutInflater r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        LayoutInflater r101 = r100.cloneInContext(r100.getContext());
        if (r101 != null) goto L8;
        return r100;
    L8:
        LayoutInflaterCompat.setFactory(r101, new a());
        return r101;
    }

    public LivePlaceHolderView(Context r100, AttributeSet r101) {
        super(r100, r101);
    }

    public LivePlaceHolderView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
    }
}
