package ac5;

import android.content.Context;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.bear.route.RouteBean;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes16.dex */
public final class a extends com.bytedance.ee.bear.route.a {

    /* JADX INFO: renamed from: ac5.a$a, reason: collision with other inner class name */
    public static final class C0049a {
    }

    static {
    }

    @Override // com.bytedance.ee.bear.route.a
    public final String e(BearUrl r100, RouteBean r101) {
        return "";
    }

    public a() {
    }

    @Override // com.bytedance.ee.bear.route.d
    public final boolean b(Context r100, BearUrl r101, RouteBean r102) {
        Intrinsics.checkNotNullParameter(r101, "bearUrl");
        com.bytedance.ee.bear.lark.dependency.i r103 = (com.bytedance.ee.bear.lark.dependency.i) org.koin.java.a.c(com.bytedance.ee.bear.lark.dependency.i.class, null, null, 6);
        if (StringsKt.startsWith$default(r101.f222564e, "http://", false, 2, null) == false) goto L6;
        r101.f222564e.substring(7);
    L8:
        r103.a();
        return false;
    L6:
        if (StringsKt.startsWith$default(r101.f222564e, "https://", false, 2, null) == false) goto L8;
        r101.f222564e.substring(8);
        goto L8
    }
}
