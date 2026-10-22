package com.bytedance.android.shopping.router;

import android.app.Activity;
import android.text.TextUtils;
import com.bytedance.android.ec.model.response.anchorv3.SourceType;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class CommerceRouter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f182403a = 0;

    static {
    }

    public static void a(long r100, final Activity r101, final String r102, Function1 r103) {
        Intrinsics.checkNotNullParameter(r103, "jumpAppSuccess");
        if (TextUtils.isEmpty(r102) == true) goto L24;
        if (r101 == null) goto L24;
        SourceType.Companion.getClass();
        boolean r104 = true;
        if (r100 != SourceType.JINGDONG.getType()) goto L9;
        boolean r105 = true;
    L10:
        if (r105 == false) goto L13;
        String r106 = "com.jingdong.app.mall";
    L19:
        Function0<Boolean> r107 = new CommerceRouter$openApp$1(r101, r102);
        if (ita.k.h(r101, r106) == false) goto L22;
        r103.invoke(Boolean.valueOf(r107.invoke().booleanValue()));
        return;
    L22:
        r103.invoke(Boolean.FALSE);
        return;
    L13:
        if (r100 == SourceType.KAOLA.getType()) goto L16;
        r104 = false;
    L16:
        if (r104 == false) goto L18;
        r106 = "com.kaola";
        goto L19
    L18:
        r106 = "";
        goto L19
    L9:
        r105 = false;
    L24:
        r103.invoke(Boolean.FALSE);
    }
}
