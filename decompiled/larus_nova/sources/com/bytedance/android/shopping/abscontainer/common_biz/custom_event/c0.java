package com.bytedance.android.shopping.abscontainer.common_biz.custom_event;

import com.bytedance.android.shopping.abscontainer.common_biz.custom_event.common.RegexCheck;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import u33.a;
import w33.g;

/* JADX INFO: loaded from: classes12.dex */
public final class c0<STATE extends w33.g, PROPS extends u33.a> extends m33.a<STATE, PROPS> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f164237b;

    @Override // m33.a
    public final String d() {
        return this.f164237b;
    }

    public c0(l33.b<STATE, PROPS> r100) {
        Intrinsics.checkNotNullParameter(r100, "containerContext");
        super(r100);
        this.f164237b = "selfRegexCheck";
    }

    @Override // m33.a
    public final void e(e43.a r110) {
        Intrinsics.checkNotNullParameter(r110, "eventData");
        Map<String, Object> r100 = r110.a();
        Object r101 = null;
        if (r100 == null) goto L5;
        Object r102 = r100.get("regex_rules");
    L7:
        if ((r102 instanceof List) == false) goto L10;
        r101 = r102;
    L10:
        List r103 = (List) r101;
        if (r103 != null) goto L13;
        r103 = CollectionsKt.emptyList();
    L13:
        List r104 = r103;
        Map<String, Object> r105 = r110.e();
        String r106 = r110.f();
        if (r106 != null) goto L16;
        r106 = "";
    L16:
        String r107 = r106;
        int r108 = RegexCheck.f164238a;
        if (RegexCheck.a(this.f164237b, this.f511708a.f507250d, r104, r105, r110, r107) == false) goto L19;
        r110.d(new m33.c(true, null, false, null, 30));
        return;
    L19:
        r110.d(new m33.c(false, "no match", true, null, 20));
        return;
    L5:
        r102 = null;
        goto L7
    }
}
