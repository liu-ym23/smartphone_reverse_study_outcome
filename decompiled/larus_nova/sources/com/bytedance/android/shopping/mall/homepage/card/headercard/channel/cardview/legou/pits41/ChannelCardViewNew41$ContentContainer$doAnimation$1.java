package com.bytedance.android.shopping.mall.homepage.card.headercard.channel.cardview.legou.pits41;

import android.os.Handler;
import android.widget.LinearLayout;
import com.alipay.sdk.m.p.e;
import com.bytedance.android.shopping.api.mall.common.homepage.card.headercard.model.ECCommonCard;
import com.bytedance.android.shopping.api.mall.common.tools.a0;
import com.bytedance.android.shopping.api.mall.common.tools.z;
import com.bytedance.android.shopping.mall.homepage.card.headercard.channel.cardview.legou.pits31.ChannelItemActivity;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final class ChannelCardViewNew41$ContentContainer$doAnimation$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ ChannelCardViewNew41.a this$0;

    /* JADX INFO: renamed from: com.bytedance.android.shopping.mall.homepage.card.headercard.channel.cardview.legou.pits41.ChannelCardViewNew41$ContentContainer$doAnimation$1$1, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        final /* synthetic */ ChannelCardViewNew41$ContentContainer$doAnimation$1 this$0;

        /* JADX INFO: renamed from: com.bytedance.android.shopping.mall.homepage.card.headercard.channel.cardview.legou.pits41.ChannelCardViewNew41$ContentContainer$doAnimation$1$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
        public static final class C26321 extends Lambda implements Function0<Unit> {
            final /* synthetic */ AnonymousClass1 this$0;

            public C26321(AnonymousClass1 r100) {
                this.this$0 = r100;
                super(0);
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                Handler r100 = a0.f170419a;
                Function0<Unit> r101 = new C26331(this);
                Intrinsics.checkNotNullParameter(r101, e.f25671s);
                a0.f170419a.postDelayed(new z(r101), 1500);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }
        }

        public AnonymousClass1(ChannelCardViewNew41$ContentContainer$doAnimation$1 r100) {
            this.this$0 = r100;
            super(0);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            this.this$0.this$0.f177653d.setVisibility(8);
            int r100 = hf3.a.f484919a;
            ChannelItemActivity r101 = this.this$0.this$0.f177652c;
            C26321 r102 = new C26321(this);
            Intrinsics.checkNotNullParameter(r101, "view");
            r101.setVisibility(0);
            hf3.a.a(r101, 0.1f, 1.0f, r102);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }
    }

    public ChannelCardViewNew41$ContentContainer$doAnimation$1(ChannelCardViewNew41.a r100) {
        this.this$0 = r100;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        ECCommonCard r100 = this.this$0.getItem();
        if (r100 == null) goto L11;
        Map<Integer, ECCommonCard.AnimItem> r101 = r100.getAnimItems();
        if (r101 == null) goto L11;
        ECCommonCard.AnimItem r102 = r101.get(0);
        if (r102 == null) goto L11;
        Long r103 = r102.getTimes();
        if (r103 == null) goto L11;
        long r104 = r103.longValue();
    L12:
        this.this$0.getItemLoopTimes();
        if (this.this$0.getItemLoopTimes() < r104) goto L16;
        this.this$0.a();
        return;
    L16:
        ChannelCardViewNew41.a r105 = this.this$0;
        r105.setItemLoopTimes(r105.getItemLoopTimes() + 1);
        int r106 = hf3.a.f484919a;
        LinearLayout r107 = this.this$0.f177653d;
        AnonymousClass1 r108 = new AnonymousClass1(this);
        Intrinsics.checkNotNullParameter(r107, "view");
        hf3.a.a(r107, 1.0f, 0.2f, r108);
        return;
    L11:
        r104 = 0;
        goto L12
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
