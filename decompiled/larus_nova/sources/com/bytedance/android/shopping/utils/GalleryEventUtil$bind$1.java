package com.bytedance.android.shopping.utils;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "position", "", "type", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final class GalleryEventUtil$bind$1 extends Lambda implements Function2<Integer, String, Unit> {
    final /* synthetic */ Function1 $ability;

    public GalleryEventUtil$bind$1(Function1 r100) {
        this.$ability = r100;
        super(2);
    }

    public final void invoke(int r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "type");
        JSONObject r102 = new JSONObject();
        r102.put("action", r101);
        r102.put("position", r100);
        this.$ability.invoke(r102);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Integer r100, String r101) {
        invoke(r100.intValue(), r101);
        return Unit.INSTANCE;
    }
}
