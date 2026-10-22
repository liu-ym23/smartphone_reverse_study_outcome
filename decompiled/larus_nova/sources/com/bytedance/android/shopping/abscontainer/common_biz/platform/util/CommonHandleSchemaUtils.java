package com.bytedance.android.shopping.abscontainer.common_biz.platform.util;

import com.bytedance.android.shopping.extensions.k;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import l33.c;

/* JADX INFO: loaded from: classes12.dex */
public final class CommonHandleSchemaUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f164352a = 0;

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static String a(String r100, String r101, Map r102, c r103) {
        Intrinsics.checkNotNullParameter(r100, "schema");
        Intrinsics.checkNotNullParameter(r103, "platformContainerDelegate");
        boolean r104 = true;
        if (r101 != null) goto L5;
    L8:
        boolean r105 = true;
    L9:
        if (r105 == true) goto L21;
        c43.a r106 = c43.a.f22381a;
        final String r107 = c43.a.a(r103, r101, k.x(r102));
        if (r107 != null) goto L14;
    L17:
        if (r104 == true) goto L22;
        final Ref.ObjectRef r108 = new Ref.ObjectRef();
        r108.element = r100;
        com.bytedance.android.shopping.sku.common.utils.b.a(r100, new CommonHandleSchemaUtils$handleSchemaWithBtm$1(r108, r107), CommonHandleSchemaUtils$handleSchemaWithBtm$2.INSTANCE);
        return (String) r108.element;
    L22:
        return r100;
    L14:
        if (r107.length() == 0) goto L17;
        r104 = false;
        goto L17
    L21:
        return r100;
    L5:
        if (StringsKt.isBlank(r101) == true) goto L8;
        r105 = false;
        goto L9
    }
}
