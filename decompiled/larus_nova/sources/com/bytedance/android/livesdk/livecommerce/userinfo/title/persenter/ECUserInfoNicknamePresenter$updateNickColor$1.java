package com.bytedance.android.livesdk.livecommerce.userinfo.title.persenter;

import android.graphics.PointF;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "Lkotlin/Pair;", "Landroid/graphics/PointF;", "width", "", "height", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final class ECUserInfoNicknamePresenter$updateNickColor$1 extends Lambda implements Function2<Integer, Integer, Pair<? extends PointF, ? extends PointF>> {
    public static final ECUserInfoNicknamePresenter$updateNickColor$1 INSTANCE = null;

    static {
        INSTANCE = new ECUserInfoNicknamePresenter$updateNickColor$1();
    }

    public ECUserInfoNicknamePresenter$updateNickColor$1() {
        super(2);
    }

    public final Pair<PointF, PointF> invoke(int r100, int r101) {
        float r102 = r100;
        float r103 = 0.8947f * r102;
        return TuplesKt.to(new PointF(r103, (float) ((Math.tan(Math.toRadians(32.2d)) * ((double) r100)) - ((double) r103))), new PointF(r102, r101));
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Pair<? extends PointF, ? extends PointF> invoke(Integer r100, Integer r101) {
        return invoke(r100.intValue(), r101.intValue());
    }
}
