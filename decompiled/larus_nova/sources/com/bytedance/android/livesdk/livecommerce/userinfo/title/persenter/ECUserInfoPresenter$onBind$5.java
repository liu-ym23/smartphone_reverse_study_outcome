package com.bytedance.android.livesdk.livecommerce.userinfo.title.persenter;

import android.graphics.drawable.Drawable;
import android.view.View;
import com.bytedance.android.livesdk.livecommerce.userinfo.title.state.ECUserInfoState;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/userinfo/title/state/ECUserInfoState$c;", "state", "", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/android/livesdk/livecommerce/userinfo/title/state/ECUserInfoState$c;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final class ECUserInfoPresenter$onBind$5 extends Lambda implements Function1<ECUserInfoState.c, Unit> {
    final /* synthetic */ e this$0;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.livecommerce.userinfo.title.persenter.ECUserInfoPresenter$onBind$5$1, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "isEnd", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
    public static final class AnonymousClass1 extends Lambda implements Function1<Boolean, Unit> {
        final /* synthetic */ Drawable $backgroundDrawable;
        final /* synthetic */ View $bgView;
        final /* synthetic */ ECUserInfoPresenter$onBind$5 this$0;

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.livecommerce.userinfo.title.persenter.ECUserInfoPresenter$onBind$5$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
        public static final class C23621 extends Lambda implements Function1<Boolean, Unit> {
            final /* synthetic */ AnonymousClass1 this$0;

            public C23621(AnonymousClass1 r100) {
                this.this$0 = r100;
                super(1);
            }

            public final void invoke(boolean r100) {
                this.this$0.$bgView.setAlpha(1.0f);
                this.this$0.this$0.getClass();
                throw null;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean r100) {
                invoke(r100.booleanValue());
                return Unit.INSTANCE;
            }
        }

        public AnonymousClass1(ECUserInfoPresenter$onBind$5 r100, View r101, Drawable r102) {
            this.this$0 = r100;
            this.$bgView = r101;
            this.$backgroundDrawable = r102;
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean r100) {
            invoke(r100.booleanValue());
            return Unit.INSTANCE;
        }

        public final void invoke(boolean r100) {
            this.this$0.getClass();
            throw null;
        }
    }

    public ECUserInfoPresenter$onBind$5(e r100) {
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ECUserInfoState.c r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        Integer r101 = r100.f153006a;
        throw null;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ECUserInfoState.c r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
