package com.bytedance.android.livesdk.interactivity.common.adjuster.logical;

import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0005"}, d2 = {"px2dp", "", GXTemplateKey.GAIAX_PX, "", "density", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final class CommentLpHelper$handleNewHorizontalVideo$1 extends Lambda implements Function2<Integer, Float, Float> {
    public static final CommentLpHelper$handleNewHorizontalVideo$1 INSTANCE = null;

    static {
        INSTANCE = new CommentLpHelper$handleNewHorizontalVideo$1();
    }

    public CommentLpHelper$handleNewHorizontalVideo$1() {
        super(2);
    }

    public final float invoke(int r100, float r101) {
        return r100 / r101;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Float invoke(Integer r100, Float r101) {
        return Float.valueOf(invoke(r100.intValue(), r101.floatValue()));
    }
}
