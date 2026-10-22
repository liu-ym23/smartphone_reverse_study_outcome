package com.bytedance.android.livesdk.ktvimpl.base.util;

import androidx.fragment.app.FragmentManager;
import com.bytedance.common.utility.reflect.Reflect;
import java.lang.reflect.Field;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/base/util/FragmentManagerHelper;", "", "()V", "cacheField", "Ljava/lang/reflect/Field;", "isExecutingActions", "", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class FragmentManagerHelper {
    public static final FragmentManagerHelper INSTANCE = null;
    private static volatile Field cacheField;

    private FragmentManagerHelper() {
    }

    static {
        INSTANCE = new FragmentManagerHelper();
    }

    public final boolean isExecutingActions(FragmentManager r100) {
        if (r100 == null) goto L18;
    L13:
        e = move-exception;
        e.printStackTrace();
        return false;
    L6:
        if (cacheField != null) goto L8;
        cacheField = Reflect.on(FragmentManager.class).exactField("mExecutingActions", new Class[]{Boolean.TYPE});     // Catch: IllegalAccessException -> L13
    L8:
        Field r101 = cacheField;     // Catch: IllegalAccessException -> L13
        Intrinsics.checkNotNull(r101);     // Catch: IllegalAccessException -> L13
        Object r102 = r101.get(r100);     // Catch: IllegalAccessException -> L13
        if (r102 == null) goto L12;
        return ((Boolean) r102).booleanValue();
    L12:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");     // Catch: IllegalAccessException -> L13
    L18:
        return false;
    }
}
