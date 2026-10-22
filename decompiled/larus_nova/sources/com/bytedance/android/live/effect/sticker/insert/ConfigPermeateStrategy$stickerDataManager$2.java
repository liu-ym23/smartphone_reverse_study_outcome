package com.bytedance.android.live.effect.sticker.insert;

import com.bytedance.android.live.effect.api.LiveEffectContext;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate$Type;
import com.bytedance.android.live.effect.sticker.presenter.o;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0004\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/bytedance/android/live/effect/sticker/presenter/o;", "kotlin.jvm.PlatformType", AbsMethodDelegate.TAG_INVOKE, "()Lcom/bytedance/android/live/effect/sticker/presenter/o;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final class ConfigPermeateStrategy$stickerDataManager$2 extends Lambda implements Function0<o> {
    public static final ConfigPermeateStrategy$stickerDataManager$2 INSTANCE = null;

    static {
        INSTANCE = new ConfigPermeateStrategy$stickerDataManager$2();
    }

    public ConfigPermeateStrategy$stickerDataManager$2() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final o invoke() {
        List<String> r100 = LiveEffectContext.f66734h;
        return LiveEffectContext.a.a(LiveEffectContextFactoryDelegate$Type.DEFAULT).b().d();
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ o invoke() {
        return invoke();
    }
}
