package com.bytedance.android.ec.window.base.dynamicview.provider;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.ec.window.base.dynamicview.common.e;
import com.bytedance.android.ec.window.base.dynamicview.common.f;
import com.bytedance.android.ec.window.base.dynamicview.virtualview.UIViewGroup;
import com.bytedance.android.ec.window.base.dynamicview.virtualview.j;
import com.bytedance.android.ec.window.base.dynamicview.virtualview.k;
import com.google.gson.JsonObject;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function4;

/* JADX INFO: loaded from: classes44.dex */
public abstract class DynamicViewFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f49260a;

    public static final class a {
    }

    static {
    }

    public abstract Map<String, Function4<String, String, j, e, k<?, ?>>> a();

    public abstract UIViewGroup<? extends ViewGroup, ?, ?, ?> b(String r100, String r101, String r102, j r103, JsonObject r104, List<? extends k<? extends View, ? extends ViewGroup.LayoutParams>> r105, e r106);

    public abstract f c(String r100);

    public abstract boolean d(String r100);

    public DynamicViewFactory() {
        this.f49260a = LazyKt.lazy(new DynamicViewFactory$creators$2(this));
    }
}
