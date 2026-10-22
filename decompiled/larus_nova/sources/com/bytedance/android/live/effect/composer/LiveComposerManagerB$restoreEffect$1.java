package com.bytedance.android.live.effect.composer;

import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/bytedance/android/live/effect/composer/n;", "node", "Lcom/bytedance/android/livesdkapi/depend/model/Sticker;", "sticker", "", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/android/live/effect/composer/n;Lcom/bytedance/android/livesdkapi/depend/model/Sticker;)V", "restoreSticker"}, k = 3, mv = {1, 4, 3})
final class LiveComposerManagerB$restoreEffect$1 extends Lambda implements Function2<n, Sticker, Unit> {
    final /* synthetic */ String $panel;
    final /* synthetic */ String $parentResId;
    final /* synthetic */ LiveComposerManagerB this$0;

    public LiveComposerManagerB$restoreEffect$1(LiveComposerManagerB r100, String r101, String r102) {
        this.this$0 = r100;
        this.$parentResId = r101;
        this.$panel = r102;
        super(2);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(n r110, Sticker r111) {
        Intrinsics.checkNotNullParameter(r110, "node");
        Intrinsics.checkNotNullParameter(r111, "sticker");
        r111.setParentResId(this.$parentResId);
        Iterator r100 = ((ArrayList) r110.f67979i).iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        r111.getUpdateKeys().add(((p) r100.next()).f67984b);
        goto L4
    L6:
        Iterator r101 = ((ArrayList) r110.f67979i).iterator();
    L8:
        if (r101.hasNext() == false) goto L15;
        Object r102 = r101.next();
        if (((p) r102).f67983a == null) goto L12;
        boolean r103 = true;
    L13:
        if (r103 == false) goto L8;
    L17:
        if (r102 == null) goto L35;
        LiveComposerManagerB.c0(this.this$0, this.$panel, r111, false, r110.f67980j, Long.valueOf(r110.f67977g), "_restoreEffect", r110.f67982l, MapsKt.hashMapOf(new Pair[]{TuplesKt.to("is_restore", "")}), 256);
        List<p> r104 = r110.f67979i;
        ArrayList r105 = new ArrayList();
        Iterator r106 = ((ArrayList) r104).iterator();
    L20:
        if (r106.hasNext() == false) goto L27;
        Object r107 = r106.next();
        if (((p) r107).f67983a == null) goto L24;
        boolean r108 = true;
    L25:
        if (r108 == false) goto L20;
        r105.add(r107);
        goto L20
    L24:
        r108 = false;
        goto L25
    L27:
        Iterator r112 = r105.iterator();
    L29:
        if (r112.hasNext() == false) goto L51;
        p r109 = (p) r112.next();
        LiveComposerManagerB r113 = this.this$0;
        String r114 = this.$panel;
        String r115 = r109.f67984b;
        Float r116 = r109.f67983a;
        if (r116 == null) goto L33;
        float r117 = r116.floatValue();
    L34:
        LiveComposerManagerB.m0(r113, r114, r111, r115, r117, r110.f67982l, Long.valueOf(r110.f67977g), MapsKt.hashMapOf(new Pair[]{TuplesKt.to("is_restore", "")}), 64);
        goto L29
    L33:
        r117 = 0.0f;
        goto L34
    L51:
        return;
    L35:
        LiveComposerManagerB r118 = this.this$0;
        String r119 = this.$panel;
        boolean r120 = r110.f67980j;
        LiveComposerManagerB.c0(r118, r119, r111, r120, r120, Long.valueOf(r110.f67977g), "_restoreEffect", r110.f67982l, MapsKt.hashMapOf(new Pair[]{TuplesKt.to("is_restore", "")}), 256);
        return;
    L12:
        r103 = false;
        goto L13
    L15:
        r102 = null;
        goto L17
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(n r100, Sticker r101) {
        invoke2(r100, r101);
        return Unit.INSTANCE;
    }
}
