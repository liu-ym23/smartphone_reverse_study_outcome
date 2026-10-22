package com.bytedance.android.livesdk.chatroom.widget;

import com.bytedance.android.live.effect.api.LiveEffectContext;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate$Type;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.ss.android.ugc.aweme.shortvideo.ShortVideoSegments;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"onConfirmChangeSticker", "", ShortVideoSegments.KEY_CURRENT_STICKER, "Lcom/bytedance/android/livesdkapi/depend/model/Sticker;", "newSticker", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final class AudienceStickerServiceWidget$onLoad$1$1 extends Lambda implements Function2<Sticker, Sticker, Unit> {
    final /* synthetic */ zg1.o $it;
    final /* synthetic */ Ref.ObjectRef $panel;

    public AudienceStickerServiceWidget$onLoad$1$1(Ref.ObjectRef r100, zg1.o r101) {
        this.$panel = r100;
        this.$it = r101;
        super(2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Sticker r100, Sticker r101) {
        Intrinsics.checkNotNullParameter(r101, "newSticker");
        List<String> r102 = LiveEffectContext.f66734h;
        LiveEffectContext.a.a(LiveEffectContextFactoryDelegate$Type.LINK).a().S((String) this.$panel.element, r100, r101);
        zg1.q r103 = this.$it.f571893d;
        if (r103 == null) goto L6;
        zg1.q.a.a(r103, true);
        return;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Sticker r100, Sticker r101) {
        invoke2(r100, r101);
        return Unit.INSTANCE;
    }
}
