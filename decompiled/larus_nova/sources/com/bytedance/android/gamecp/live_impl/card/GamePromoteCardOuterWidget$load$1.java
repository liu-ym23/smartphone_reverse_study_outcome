package com.bytedance.android.gamecp.live_impl.card;

import android.content.Context;
import android.view.View;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import xr.s;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/bytedance/android/gamecp/host_api/model/introducecard/g;", "cardItem", "", "isIntroduce", "", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/android/gamecp/host_api/model/introducecard/g;Z)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final class GamePromoteCardOuterWidget$load$1 extends Lambda implements Function2<com.bytedance.android.gamecp.host_api.model.introducecard.g, Boolean, Unit> {
    final /* synthetic */ xr.a $cardData;
    final /* synthetic */ Context $context;
    final /* synthetic */ xr.l $lifecycle;
    final /* synthetic */ c this$0;

    public static final class a implements com.bytedance.android.gamecp.host_api.model.introducecard.o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GamePromoteCardOuterWidget$load$1 f57828a;

        public a(GamePromoteCardOuterWidget$load$1 r100) {
            this.f57828a = r100;
        }

        @Override // com.bytedance.android.gamecp.host_api.model.introducecard.o
        public final void a(String r100, String r101, int r102) {
            this.f57828a.getClass();
            throw null;
        }
    }

    public static final class b implements com.bytedance.android.gamecp.host_api.model.introducecard.p {
        public b() {
        }

        @Override // com.bytedance.android.gamecp.host_api.model.introducecard.p
        public final void onLoadFinish(boolean r100, long r101, long r102) {
        }
    }

    public GamePromoteCardOuterWidget$load$1(c r100, xr.l r101, Context r102, xr.a r103) {
        this.this$0 = r100;
        this.$context = r102;
        super(2);
    }

    public final void invoke(com.bytedance.android.gamecp.host_api.model.introducecard.g r100, boolean r101) {
        r100.getClass();
        c r102 = this.this$0;
        com.bytedance.android.gamecp.host_api.model.introducecard.q r103 = r102.f57875a;
        if (r103 == null) goto L6;
    L8:
        r102.f57875a = r103;
        com.bytedance.android.gamecp.host_api.model.introducecard.q r104 = this.this$0.f57875a;
        if (r104 == null) goto L11;
        View r105 = r104.getView();
        Intrinsics.checkNotNull(r100);
        r104.i(r105, r100, new a(this), new b());
    L11:
        com.bytedance.android.gamecp.host_api.model.introducecard.q r106 = this.this$0.f57875a;
        if (r106 == null) goto L14;
        View r107 = r106.getView();
    L15:
        Intrinsics.checkNotNull(r107);
        throw null;
    L14:
        r107 = null;
        goto L15
    L6:
        if (((xr.f) s.a(xr.f.class)) != null) goto L17;
        r102.f57875a = null;
        r103 = null;
        goto L8
    L17:
        throw null;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(com.bytedance.android.gamecp.host_api.model.introducecard.g r100, Boolean r101) {
        invoke(r100, r101.booleanValue());
        return Unit.INSTANCE;
    }
}
