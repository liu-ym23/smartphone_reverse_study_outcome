package com.bytedance.android.live.v3;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.android.live.impl.strategy.Strategy;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\b\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "p1", "", "", "p2", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class StrategyManagerV3$getFactor$6 extends FunctionReferenceImpl implements Function2<List<? extends String>, Boolean, Unit> {
    public StrategyManagerV3$getFactor$6(StrategyManagerV3 r100) {
        super(2, r100, StrategyManagerV3.class, "updateCharacter", "updateCharacter(Ljava/util/List;Z)V", 0);
    }

    public final void invoke(List<String> r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "p1");
        StrategyManagerV3 r102 = (StrategyManagerV3) this.receiver;
        Strategy r103 = StrategyManagerV3.f102561a;
        r102.getClass();
        StrategyManagerV3.i(r100);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(List<? extends String> r100, Boolean r101) {
        invoke(r100, r101.booleanValue());
        return Unit.INSTANCE;
    }
}
