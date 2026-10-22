package com.bytedance.android.live.effect.sticker.ui;

import com.bytedance.android.live.effect.api.LiveEffectContext;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate$Type;
import com.bytedance.android.live.effect.api.LiveEffectScene;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import zg1.d2;

/* JADX INFO: loaded from: classes45.dex */
public final class LiveStickerSelectDialogFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f68451a = 0;

    static {
    }

    public static void a(final LiveEffectScene r100, final d2 r101, final Function1 r102) {
        Intrinsics.checkNotNullParameter(r100, "liveEffectScene");
        Intrinsics.checkNotNullParameter(r101, "event");
        Intrinsics.checkNotNullParameter(r102, "callback");
        String r103 = r101.f571815c;
        Function1<Sticker, Unit> r104 = new LiveStickerSelectDialogFactory$createLiveStickerSelectDialog$1(r102, r100, r101);
        if (r103.length() != 0) goto L5;
        boolean r105 = true;
    L6:
        if (r105 == false) goto L8;
        r104.invoke(null);
        return;
    L8:
        List<String> r106 = LiveEffectContext.f66734h;
        LiveEffectContext.a.a(LiveEffectContextFactoryDelegate$Type.DEFAULT).d().fetchEffect(r103, new h(r104));
        return;
    L5:
        r105 = false;
        goto L6
    }
}
