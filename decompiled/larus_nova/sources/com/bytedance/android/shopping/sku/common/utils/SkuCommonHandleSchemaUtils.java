package com.bytedance.android.shopping.sku.common.utils;

import android.content.Context;
import com.bytedance.android.bcm.api.model.BcmParams;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.core.utils.l0;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes13.dex */
public final class SkuCommonHandleSchemaUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f182770a = 0;

    public SkuCommonHandleSchemaUtils() {
    }

    static {
    }

    public static void b(final Context r100, String r101, boolean r102, final Function0 r103, int r104) {
        if ((r104 & 4) == 0) goto L5;
        final boolean r105 = false;
    L7:
        if ((r104 & 8) == 0) goto L10;
        r102 = false;
    L10:
        if ((r104 & 64) == 0) goto L12;
        r103 = null;
    L12:
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "url");
        final Ref.BooleanRef r106 = new Ref.BooleanRef();
        r106.element = false;
        if (r102 == false) goto L21;
        if (l0.b(r100) == null) goto L21;
        nj.d r107 = com.bytedance.android.ec.sdk.helper.d.f48119b.getPadSplitService();
        if (r107 == null) goto L19;
        r107.i();
    L19:
        r106.element = false;
    L21:
        if (r106.element == true) goto L24;
        b.a(r101, new SkuCommonHandleSchemaUtils$handleSchemaWithLive$2(r106, r100, r105), new SkuCommonHandleSchemaUtils$handleSchemaWithLive$3(r103));
        return;
    L24:
        return;
    L5:
        r105 = true;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static String a(final String r100, String r101, Map r102, final mh3.a r103, final String r104, PageFinder r105) {
        Intrinsics.checkNotNullParameter(r100, "schema");
        Intrinsics.checkNotNullParameter(r104, "tag");
        Intrinsics.checkNotNullParameter(r105, "btmPageFinder");
        boolean r106 = true;
        if (r101 != null) goto L5;
    L8:
        boolean r107 = true;
    L9:
        if (r107 == true) goto L21;
        final String r108 = BtmSDK.INSTANCE.createJumpSourceBtmToken(r101, r105, new BcmParams().merge(r102));
        if (r108 != null) goto L14;
    L17:
        if (r106 == true) goto L22;
        final Ref.ObjectRef r109 = new Ref.ObjectRef();
        r109.element = r100;
        b.a(r100, new SkuCommonHandleSchemaUtils$handleSchemaWithBtm$1(r109, r108), new SkuCommonHandleSchemaUtils$handleSchemaWithBtm$2(r103, r104, r100));
        return (String) r109.element;
    L22:
        return r100;
    L14:
        if (r108.length() == 0) goto L17;
        r106 = false;
        goto L17
    L21:
        return r100;
    L5:
        if (StringsKt.isBlank(r101) == true) goto L8;
        r107 = false;
        goto L9
    }
}
