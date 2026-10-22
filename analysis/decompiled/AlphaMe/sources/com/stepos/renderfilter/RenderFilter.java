package com.stepos.renderfilter;

import android.content.Context;
import androidx.fragment.app.A;
import com.stepos.renderfilter.annotation.Keep;
import com.stepos.renderfilter.functor.FunctorApi31Impl;
import java.util.HashMap;
import q2.ComponentCallbacks2C0826a;

/* loaded from: classes.dex */
public class RenderFilter {

    /* renamed from: e, reason: collision with root package name */
    public static boolean f12294e = false;

    /* renamed from: f, reason: collision with root package name */
    public static boolean f12295f = false;

    /* renamed from: g, reason: collision with root package name */
    public static boolean f12296g = false;

    /* renamed from: h, reason: collision with root package name */
    public static volatile RenderFilter f12297h;

    /* renamed from: a, reason: collision with root package name */
    public Context f12298a;

    /* renamed from: b, reason: collision with root package name */
    public final HashMap f12299b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    public boolean f12300c = false;

    /* renamed from: d, reason: collision with root package name */
    public final ComponentCallbacks2C0826a f12301d = new ComponentCallbacks2C0826a(this);

    public static RenderFilter b() {
        if (f12297h == null) {
            synchronized (RenderFilter.class) {
                try {
                    if (f12297h == null) {
                        f12297h = new RenderFilter();
                    }
                } finally {
                }
            }
        }
        return f12297h;
    }

    @Keep
    public static boolean isFunctorAvailable() {
        return !FunctorApi31Impl.isVulkanMode();
    }

    public final void a() {
        if (this.f12298a == null) {
            throw new A("mAppContext = null, pls call RenderFilter.getInstance().init(context) first", 6);
        }
    }
}
