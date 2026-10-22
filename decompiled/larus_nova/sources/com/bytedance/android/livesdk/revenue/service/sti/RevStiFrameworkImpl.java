package com.bytedance.android.livesdk.revenue.service.sti;

import com.bytedance.android.livesdk.revenue.sti.IRevIconModel;
import com.bytedance.android.livesdkapi.sti.framework.IShortTermIconFramework;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes11.dex */
public final class RevStiFrameworkImpl implements xr2.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IShortTermIconFramework f157445a;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.revenue.service.sti.RevStiFrameworkImpl$load$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002\"\f\b\u0000\u0010\u0001*\u0006\u0012\u0002\b\u00030\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/revenue/sti/IRevIconModel;", "M", "Lcom/bytedance/android/livesdk/revenue/service/sti/c;", "", AbsMethodDelegate.TAG_INVOKE, "()Lcom/bytedance/android/livesdk/revenue/service/sti/c;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
    final class AnonymousClass1 extends Lambda implements Function0<c<? extends Object>> {
        final /* synthetic */ Class $modelClass;

        public AnonymousClass1(Class r100) {
            this.$modelClass = r100;
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final c<? extends Object> invoke() {
            return new c((IRevIconModel) this.$modelClass.newInstance());
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ c<? extends Object> invoke() {
            return invoke();
        }
    }

    public RevStiFrameworkImpl(IShortTermIconFramework r100) {
        Intrinsics.checkNotNullParameter(r100, "original");
        this.f157445a = r100;
    }

    @Override // xr2.d
    public final <M extends IRevIconModel<?>> void load(Object r100, final Function0<? extends M> r101) {
        Intrinsics.checkNotNullParameter(r100, "uniqueKey");
        Intrinsics.checkNotNullParameter(r101, "factory");
        this.f157445a.load(r100, new AnonymousClass2(r101));
    }
}
