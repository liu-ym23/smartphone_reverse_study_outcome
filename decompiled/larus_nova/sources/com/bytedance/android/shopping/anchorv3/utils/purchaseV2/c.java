package com.bytedance.android.shopping.anchorv3.utils.purchaseV2;

import android.text.TextUtils;
import com.bytedance.android.ec.core.utils.x0;
import com.bytedance.android.ec.model.order.IOrderSchema;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f165329a = 0;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f165330a;

        public a(int r100) {
            this.f165330a = r100;
        }

        public final void a() {
        L11:
            e = move-exception;
            dm.a.a("ECVideoPurchaseSchemaReport").b("report multiSKUSchemaReportIfEmpty:", e);
            return;
        L4:
            if (this.f165330a <= 0) goto L6;
            Business r100 = Business.VIDEO_ULTIMATE_BUY;     // Catch: Exception -> L11
        L7:
            String r101 = r100.getValue();     // Catch: Exception -> L11
            if (com.bytedance.android.ec.core.anchorv3.c.c() == false) goto L16;
            int r102 = c.f165329a;     // Catch: Exception -> L11
            rk.c.b(Location.GOOD_FEED_PRODUCT_CARD.getValue(), r101, "", "");     // Catch: Exception -> L11
            return;
        L16:
            return;
        L6:
            r100 = Business.VIDEO_SKU;     // Catch: Exception -> L11
            goto L7
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IOrderSchema f165331a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f165332b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f165333c;

        public b(IOrderSchema r100, String r101, String r102) {
            this.f165331a = r100;
            this.f165332b = r101;
            this.f165333c = r102;
        }

        public final void a() {
            IOrderSchema r100 = this.f165331a;     // Catch: Exception -> L16
            if (r100 == null) goto L6;
            String r101 = r100.formatToUrl();     // Catch: Exception -> L16
            if (r101 == null) goto L6;
        L7:
            String r102 = c.a(r101);     // Catch: Exception -> L16
            if (com.bytedance.android.ec.core.anchorv3.c.c() == false) goto L11;
            rk.c.b(Location.GOOD_FEED_PRODUCT_CARD.getValue(), Business.VIDEO_SUBMIT_ORDER.getValue(), c.a(this.f165332b), r102);     // Catch: Exception -> L16
        L11:
            if (com.bytedance.android.ec.core.anchorv3.c.d() == true) goto L13;
            return;
        L13:
            if (TextUtils.isEmpty(this.f165332b) == true) goto L22;
            rk.c.b(Location.GOOD_FEED_PRODUCT_CARD_REFACTOR.getValue(), Business.VIDEO_SUBMIT_ORDER.getValue(), c.a(this.f165333c), r102);     // Catch: Exception -> L16
            return;
        L22:
            return;
        L6:
            r101 = "";
        L16:
            e = move-exception;
            dm.a.a("ECVideoPurchaseSchemaReport").b("report SingleSKUSchemaReport:", e);
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public c() {
    }

    static {
    }

    public static final String a(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L12;
    L10:
        return "";
    L12:
        String r101 = x0.c(UriProtector.parse(r100)).toString();     // Catch: Exception -> L8
        if (r101 == null) goto L10;
        return r101;
    L8:
        e = move-exception;
        dm.a.a("ECVideoPurchaseSchemaReport").b("ECVideoPurchaseSchemaReport:", e);
        goto L10
    }

    public static void b(int r100) {
        if (com.bytedance.android.ec.core.anchorv3.c.a() == false) goto L5;
        return;
    L5:
        PThreadExecutorsUtils.newCachedThreadPool(new DefaultThreadFactory("ECVideoPurchaseSchemaReport")).execute(new a(r100));
    }

    public static void c(String r100, String r101, IOrderSchema r102) {
        Intrinsics.checkNotNullParameter(r100, "oldOrderUrl");
        Intrinsics.checkNotNullParameter(r101, "newServerOrderUrl");
        if (com.bytedance.android.ec.core.anchorv3.c.a() == false) goto L5;
        return;
    L5:
        PThreadExecutorsUtils.newCachedThreadPool(new DefaultThreadFactory("ECVideoPurchaseSchemaReport")).execute(new b(r102, r101, r100));
    }
}
