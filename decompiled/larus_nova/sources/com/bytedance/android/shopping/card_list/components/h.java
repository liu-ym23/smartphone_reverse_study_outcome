package com.bytedance.android.shopping.card_list.components;

import com.bytedance.android.shopping.card_list.utils.CardListCommonLog;
import com.larksuite.component.card.plugin.ReportCardMonitorPlugin;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes13.dex */
public final class h extends b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f171468d = 0;

    public static final class a {
    }

    static {
    }

    public static void g(com.bytedance.kmp.ec.yata.event.core.a r100) {
        Intrinsics.checkNotNullParameter(r100, "input");
        Object r101 = r100.p(Reflection.getOrCreateKotlinClass(String.class), ReportCardMonitorPlugin.EVENT_NAME);
        if ((r101 instanceof String) == true) goto L5;
        r101 = null;
    L5:
        final String r102 = (String) r101;
        Object r103 = r100.p(Reflection.getOrCreateKotlinClass(String.class), "opportunity");
        if ((r103 instanceof String) == true) goto L8;
        r103 = null;
    L8:
        final String r104 = (String) r103;
        Object r105 = r100.p(Reflection.getOrCreateKotlinClass(Boolean.class), "need_hold");
        if ((r105 instanceof Boolean) == true) goto L11;
        r105 = null;
    L11:
        Boolean r106 = (Boolean) r105;
        boolean r107 = false;
        if (r106 == null) goto L14;
        final boolean r108 = r106.booleanValue();
    L15:
        com.bytedance.kmp.ec.yata.store.node.c r109 = r100.j();
        if (r109 == null) goto L18;
        final String r110 = r109.getKey();
    L19:
        Lazy r111 = CardListCommonLog.f171886a;
        CardListCommonLog.a("CardListEventHandleComponent", new CardListEventHandleComponent$saveEvent$1(r102, r104, r108, r110));
        if (r102 != null) goto L22;
    L25:
        boolean r112 = true;
    L26:
        if (r112 == true) goto L42;
        if (r104 != null) goto L29;
    L32:
        boolean r113 = true;
    L33:
        if (r113 == true) goto L43;
        if (r110 != null) goto L36;
    L37:
        r107 = true;
    L38:
        if (r107 == true) goto L44;
        Intrinsics.checkNotNullParameter(r102, "eventName");
        Intrinsics.checkNotNullParameter(r104, "opportunity");
        Intrinsics.checkNotNullParameter(r110, "renderNodeKey");
        throw null;
    L44:
        throw null;
    L36:
        if (StringsKt.isBlank(r110) == false) goto L38;
    L43:
        throw null;
    L29:
        if (StringsKt.isBlank(r104) == true) goto L32;
        r113 = false;
        goto L33
    L42:
        throw null;
    L22:
        if (StringsKt.isBlank(r102) == true) goto L25;
        r112 = false;
        goto L26
    L18:
        r110 = null;
        goto L19
    L14:
        r108 = false;
        goto L15
    }
}
