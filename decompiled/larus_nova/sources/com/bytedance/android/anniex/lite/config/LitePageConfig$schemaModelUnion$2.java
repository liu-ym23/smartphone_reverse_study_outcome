package com.bytedance.android.anniex.lite.config;

import android.net.Uri;
import android.util.LruCache;
import com.bytedance.android.anniex.lite.c;
import com.bytedance.android.anniex.web.model.AnnieXWebModel;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import q26.k;
import t36.j;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lt36/j;", AbsMethodDelegate.TAG_INVOKE, "()Lt36/j;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final class LitePageConfig$schemaModelUnion$2 extends Lambda implements Function0<j> {
    final /* synthetic */ String $bid;
    final /* synthetic */ k $uiShowConfig;
    final /* synthetic */ Uri $uri;

    public LitePageConfig$schemaModelUnion$2(String r100, Uri r101, k r102) {
        this.$bid = r100;
        this.$uri = r101;
        this.$uiShowConfig = r102;
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final j invoke2() {
        LruCache<String, AnnieXWebModel> r100 = c.f40797a;
        return c.a(this.$bid, this.$uri, this.$uiShowConfig.f531446b);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ j invoke() {
        return invoke2();
    }
}
