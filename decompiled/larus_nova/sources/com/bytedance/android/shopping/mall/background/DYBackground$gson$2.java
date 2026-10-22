package com.bytedance.android.shopping.mall.background;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.google.gson.Gson;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/google/gson/Gson;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final class DYBackground$gson$2 extends Lambda implements Function0<Gson> {
    public static final DYBackground$gson$2 INSTANCE = null;

    static {
        INSTANCE = new DYBackground$gson$2();
    }

    public DYBackground$gson$2() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final Gson invoke() {
        return new Gson();
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Gson invoke() {
        return invoke();
    }
}
