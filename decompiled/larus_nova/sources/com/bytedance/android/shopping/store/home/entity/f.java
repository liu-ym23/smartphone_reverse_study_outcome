package com.bytedance.android.shopping.store.home.entity;

import com.bytedance.android.ec.model.ECShopShareQrCodeInfo;
import com.google.gson.Gson;
import java.util.Iterator;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class f {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f183704c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ECShopShareQrCodeInfo f183705a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ECShopToolsInfo f183706b;

    public static final class a {
        public static f a(ECShopBlockInfoDTO r100) {
            Intrinsics.checkNotNullParameter(r100, "response");
            Gson r101 = new Gson();
            f r102 = new f();
            Blcok r103 = r100.getBlock();
            if (r103 == null) goto L20;
            List<Module> r104 = r103.getModuleList();
            if (r104 == null) goto L20;
            Iterator<T> r105 = r104.iterator();
        L8:
            if (r105.hasNext() == false) goto L20;
            Module r106 = (Module) r105.next();
            Result.Companion r107 = Result.Companion;     // Catch: Throwable -> L18
            String r108 = r106.getName();     // Catch: Throwable -> L18
            if (Intrinsics.areEqual(r108, ECShopModuleType.SHOP_SHARE_CARD_INFO.getType()) == false) goto L14;
            r102.f183705a = (ECShopShareQrCodeInfo) r101.fromJson(r106.getData(), ECShopShareQrCodeInfo.class);     // Catch: Throwable -> L18
        L16:
            Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L18
            goto L8
        L14:
            if (Intrinsics.areEqual(r108, ECShopModuleType.SHOP_TOOLS_INFO.getType()) == false) goto L16;
            r102.f183706b = (ECShopToolsInfo) r101.fromJson(r106.getData(), ECShopToolsInfo.class);     // Catch: Throwable -> L18
        L18:
            th = move-exception;
            Result.Companion r109 = Result.Companion;
            Result.m9449constructorimpl(ResultKt.createFailure(th));
        L20:
            return r102;
        }
    }

    static {
    }

    public f() {
    }
}
