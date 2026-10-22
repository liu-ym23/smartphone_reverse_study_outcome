package com.bytedance.android.live.broadcastgame.opengame;

import android.text.TextUtils;
import androidx.collection.LruCache;
import com.bytedance.bdp.live.livecontainer.base.schema.LiveSchemaInfo;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes45.dex */
public final class p {
    public static final boolean a(String r100, String r110) {
        Intrinsics.checkNotNullParameter(r100, "schema");
        Intrinsics.checkNotNullParameter(r110, "appId");
        int r101 = com.bytedance.bdp.live.livecontainer.base.schema.a.f201518a;
        if (TextUtils.isEmpty(r100) == false) goto L5;
        LiveSchemaInfo.BdpsumCheckResult r102 = LiveSchemaInfo.BdpsumCheckResult.NONE;
    L21:
        if (r102 == LiveSchemaInfo.BdpsumCheckResult.NORMAL) goto L30;
        LruCache<String, LiveSchemaInfo> r103 = LiveSchemaInfo.f201489r;
        LiveSchemaInfo r104 = LiveSchemaInfo.c.a(r100);
        if (r104 == null) goto L25;
        String r105 = (String) r104.f201492c.getValue();
    L27:
        if ((!Intrinsics.areEqual(r105, r110)) == false) goto L31;
        return true;
    L31:
        return false;
    L25:
        r105 = null;
        goto L27
    L30:
        return false;
    L5:
        if (r100 != null) goto L7;
        Intrinsics.throwNpe();
    L7:
        List r106 = StringsKt.split$default(r100, new String[]{"&bdpsum="}, false, 0, 6, null);
        if (r106.size() >= 2) goto L10;
        r102 = LiveSchemaInfo.BdpsumCheckResult.NONE;
        goto L21
    L10:
        String r107 = (String) ListProtector.get(r106, 1);
        String r108 = com.bytedance.bdp.live.livecontainer.base.schema.a.a((String) ListProtector.get(r106, 0));
        if (TextUtils.isEmpty(r107) == false) goto L14;
        r102 = LiveSchemaInfo.BdpsumCheckResult.NONE;
        goto L21
    L14:
        if (TextUtils.isEmpty(r108) == false) goto L17;
        r102 = LiveSchemaInfo.BdpsumCheckResult.ERROR;
        goto L21
    L17:
        if (Intrinsics.areEqual(r107, r108) == false) goto L19;
        r102 = LiveSchemaInfo.BdpsumCheckResult.NORMAL;
        goto L21
    L19:
        r102 = LiveSchemaInfo.BdpsumCheckResult.ERROR;
        goto L21
    }
}
