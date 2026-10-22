package bia;

import android.view.View;
import com.obric.assistant.window.materials.MaterialSceneType;
import com.obric.assistant.window.materials.services.IWindowMaterialService;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f19194a = null;

    static {
        f19194a = LazyKt.lazy(new f());
    }

    public static boolean a(View r100, boolean r101, MaterialSceneType r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r102, "materialSceneType");
        if (r101 == false) goto L6;
        ((IWindowMaterialService) f19194a.getValue()).a(r100, r102);
        return true;
    L6:
        return false;
    }
}
