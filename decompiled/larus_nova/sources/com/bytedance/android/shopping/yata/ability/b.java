package com.bytedance.android.shopping.yata.ability;

import android.content.Context;
import android.net.Uri;
import com.bytedance.android.bcm.api.model.BcmParams;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.adapter.api.IAdapterService;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.search.vision.model.data.PhotoEnterModel;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import v96.e;

/* JADX INFO: loaded from: classes14.dex */
public class b implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f187498a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<PageFinder> f187499b;

    public final Context getContext() {
        return this.f187498a;
    }

    @Override // v96.e
    public void openSchema(String r100) {
        Intrinsics.checkNotNullParameter(r100, "schema");
        Context r101 = this.f187498a;
        Uri r102 = UriProtector.parse(r100);
        int r103 = ECSdk.f48106a;
        IAdapterService r104 = (IAdapterService) ECSdk.a(IAdapterService.class);
        if (r104 == null) goto L6;
        IAdapterService.a.a(r104, r101, r102, true, 8);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(Context r100, Function0<? extends PageFinder> r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "btmPageFinderMethod");
        this.f187498a = r100;
        this.f187499b = r101;
    }

    @Override // v96.e
    public void a(String r100, String r101, Map<String, ? extends Object> r102) {
        Intrinsics.checkNotNullParameter(r100, "schema");
        Intrinsics.checkNotNullParameter(r101, "btm");
        String r103 = b(this.f187498a, r101, r102);
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L15
        if (r103 != null) goto L6;
    L9:
        boolean r105 = true;
    L10:
        if (r105 == false) goto L12;
        Uri r106 = UriProtector.parse(r100);     // Catch: Throwable -> L15
    L13:
        Object r107 = Result.m9449constructorimpl(r106);     // Catch: Throwable -> L15
    L18:
        if (Result.m9455isFailureimpl(r107) == false) goto L20;
        r107 = null;
    L20:
        Uri r108 = (Uri) r107;
        if (r108 == null) goto L28;
        Context r109 = this.f187498a;
        int r110 = ECSdk.f48106a;
        IAdapterService r111 = (IAdapterService) ECSdk.a(IAdapterService.class);
        if (r111 == null) goto L29;
        IAdapterService.a.a(r111, r109, r108, true, 8);
        return;
    L29:
        return;
    L28:
        return;
    L12:
        r106 = UriProtector.parse(r100).buildUpon().appendQueryParameter(PhotoEnterModel.SOURCE_BTM_TOKEN, r103).build();     // Catch: Throwable -> L15
        goto L13
    L6:
        if (r103.length() == 0) goto L9;
        r105 = false;
    L15:
        th = move-exception;
        Result.Companion r112 = Result.Companion;
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L18
    }

    public String b(Context r100, String r101, Map<String, ? extends Object> r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "btm");
        PageFinder r103 = this.f187499b.invoke();
        if (r103 != null) goto L7;
        return null;
    L7:
        return BtmSDK.INSTANCE.createJumpSourceBtmToken(r101, r103, new BcmParams().merge(r102));
    }
}
