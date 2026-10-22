package com.bytedance.android.shopping.anchorv4.event_chain;

import android.view.View;
import com.bytedance.android.ecom.arch.slice.SlcContext;
import com.bytedance.android.ecom.arch.slice.action.IAction;
import com.bytedance.kmp.ec.yata.chain.core.EventChain;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f166550a = 0;

    public c() {
    }

    static {
    }

    public static /* synthetic */ void b(EventChain r100, com.bytedance.android.ecom.arch.slice.g r101, SlcContext r110, IAction r111, View r112, Map r113) {
        a(r100, r101, r110, r111, r112, r113, null, null);
    }

    public static void a(EventChain r110, com.bytedance.android.ecom.arch.slice.g r111, SlcContext r112, IAction r113, View r114, Map r115, Map r116, com.bytedance.android.ecom.arch.slice.action.c r117) {
        Intrinsics.checkNotNullParameter(r113, "action");
        int r100 = com.bytedance.android.ecom.arch.slice.action.f.f49989a;
        com.bytedance.android.ecom.arch.slice.action.f.a(r110, r111, r112, r113, r114, r115, r116, r117, "product_detail_page");
    }
}
