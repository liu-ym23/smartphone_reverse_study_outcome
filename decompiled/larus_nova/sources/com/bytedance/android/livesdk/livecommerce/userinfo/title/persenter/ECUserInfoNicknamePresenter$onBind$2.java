package com.bytedance.android.livesdk.livecommerce.userinfo.title.persenter;

import com.bytedance.android.livesdk.livecommerce.userinfo.title.state.ECUserInfoState;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/userinfo/title/state/ECUserInfoState$e;", "state", "", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/android/livesdk/livecommerce/userinfo/title/state/ECUserInfoState$e;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final class ECUserInfoNicknamePresenter$onBind$2 extends Lambda implements Function1<ECUserInfoState.e, Unit> {
    final /* synthetic */ d this$0;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.livecommerce.userinfo.title.persenter.ECUserInfoNicknamePresenter$onBind$2$2, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
    public static final class AnonymousClass2 extends Lambda implements Function0<Unit> {
        final /* synthetic */ List $nickColor;

        public AnonymousClass2(List r100) {
            this.$nickColor = r100;
            super(0);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            dm.a.a("ECUserInfoNicknamePresenter").w("nickColor is empty nickColor: " + this.$nickColor, null);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }
    }

    public ECUserInfoNicknamePresenter$onBind$2(d r100) {
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ECUserInfoState.e r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        String r101 = r100.f153008a;
        int r102 = d.f152992e;
        throw null;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ECUserInfoState.e r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
