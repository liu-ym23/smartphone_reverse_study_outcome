package com.bytedance.android.live.core.tetris.layout;

import android.content.Context;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import d80.d;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import x70.b;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0003\u001a\u00020\u0002H\u0007¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/core/tetris/layout/ViewPools;", "Landroidx/lifecycle/LifecycleObserver;", "", LiveCommonConstants.REASON_ON_DEDTROY, "<init>", "()V", "tetris_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ViewPools implements LifecycleObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<AppCompatActivity, b> f65895a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static x70.a f65896b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ViewPools f65897c = null;

    public static final class a implements ViewPool.a {
        public a() {
        }

        @Override // com.bytedance.android.live.core.tetris.layout.ViewPool.a
        public final void a(AppCompatActivity r100) {
            Intrinsics.checkNotNullParameter(r100, "activity");
            Map<AppCompatActivity, b> r101 = ViewPools.f65895a;
            Map<AppCompatActivity, b> r102 = ViewPools.f65895a;
            if (r102.containsKey(r100) == false) goto L6;
            r102.remove(r100);
            return;
        }
    }

    private ViewPools() {
    }

    static {
        f65897c = new ViewPools();
        f65895a = new LinkedHashMap();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onDestroy() {
        x70.a r100 = f65896b;
        if ((r100 instanceof x70.a) == true) goto L5;
        r100 = null;
    L5:
        if (r100 != null) goto L7;
        return;
    L7:
        Context r101 = r100.getContext();
        if ((r101 instanceof AppCompatActivity) == true) goto L10;
        r101 = null;
    L10:
        AppCompatActivity r102 = (AppCompatActivity) r101;
        if (r102 == null) goto L15;
        Lifecycle r103 = r102.getLifecycle();
        if (r103 == null) goto L15;
        r103.removeObserver(this);
    L15:
        x70.a r104 = f65896b;
        if (r104 == null) goto L19;
        f65896b = null;
        r104.g();
        return;
    }

    @JvmStatic
    public static final b a(AppCompatActivity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        if ((d.f467385a & 8) <= 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L12;
        x70.a r102 = f65896b;
        if (r102 == null) goto L10;
        return r102;
    L10:
        x70.a r103 = new x70.a(r100);
        f65896b = r103;
        r100.getLifecycle().addObserver(f65897c);
        return r103;
    L12:
        Map<AppCompatActivity, b> r104 = f65895a;
        if (r104.containsKey(r100) == false) goto L15;
        Object r105 = ((LinkedHashMap) r104).get(r100);
        Intrinsics.checkNotNull(r105);
        return (b) r105;
    L15:
        ViewPool r106 = new ViewPool(r100);
        r104.put(r100, r106);
        a r107 = new a();
        Intrinsics.checkNotNullParameter(r107, "destroyCallback");
        if (r106.f65889d == true) goto L20;
        r106.f65891f = r107;
        r106.f65889d = true;
        r106.f65893h.getLifecycle().addObserver(r106);
    L20:
        return r106;
    L5:
        r101 = false;
        goto L6
    }
}
