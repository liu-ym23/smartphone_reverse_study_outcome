package com.bytedance.android.live.effect.sticker.presenter;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.ss.android.ugc.effectmanager.effect.model.Effect;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"handleEffects", "Lcom/ss/android/ugc/effectmanager/effect/model/Effect;", "effect", "childs", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final class LiveStickerDataManager$fetchManagerEffectByCategory$2 extends Lambda implements Function2<Effect, List<? extends Effect>, Effect> {
    public static final LiveStickerDataManager$fetchManagerEffectByCategory$2 INSTANCE = null;

    static {
        INSTANCE = new LiveStickerDataManager$fetchManagerEffectByCategory$2();
    }

    public LiveStickerDataManager$fetchManagerEffectByCategory$2() {
        super(2);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Effect invoke2(Effect r100, List<? extends Effect> r101) {
        Intrinsics.checkNotNullParameter(r100, "effect");
        Intrinsics.checkNotNullParameter(r101, "childs");
        if (r101.isEmpty() == false) goto L5;
        return r100;
    L5:
        ArrayList r102 = new ArrayList();
        List<String> r103 = r100.getChildren();
        if (r103 == null) goto L20;
        Iterator<T> r104 = r103.iterator();
    L9:
        if (r104.hasNext() == false) goto L20;
        String r105 = (String) r104.next();
        Iterator<T> r106 = r101.iterator();
    L12:
        if (r106.hasNext() == false) goto L16;
        Object r107 = r106.next();
        if (Intrinsics.areEqual(((Effect) r107).getEffectId(), r105) == false) goto L12;
    L17:
        Effect r108 = (Effect) r107;
        if (r108 == null) goto L9;
        r102.add(r108);
        goto L9
    L16:
        r107 = null;
    L20:
        r100.setChildEffects(r102);
        return r100;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Effect invoke(Effect r100, List<? extends Effect> r101) {
        return invoke2(r100, r101);
    }
}
