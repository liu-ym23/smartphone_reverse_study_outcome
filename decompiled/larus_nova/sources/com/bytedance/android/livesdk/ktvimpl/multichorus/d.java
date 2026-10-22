package com.bytedance.android.livesdk.ktvimpl.multichorus;

import com.bytedance.android.livesdk.chatroom.model.IApplyResult;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class d implements rj0.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MultiChorusViewModel.g f145931a;

    public static final class a implements tf0.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f145932a;

        @Override // tf0.b
        public final void a() {
            com.bytedance.android.livesdk.ktvimpl.multichorus.a.a(MultiChorusViewModel.TAG, "joinMultiChorus  apply failed so leave");
            MultiChorusViewModel.g r100 = this.f145932a.f145931a;
            r100.f145888a.leaveMultiChorus(r100.f145889b, MultiChorusViewModel$joinMultiChorus$1$1$1$onSuccess$1$applyFailure$1.INSTANCE, MultiChorusViewModel$joinMultiChorus$1$1$1$onSuccess$1$applyFailure$2.INSTANCE);
            this.f145932a.f145931a.f145890c.invoke(new Throwable("failed"));
        }

        public a(d r100) {
            this.f145932a = r100;
        }

        @Override // tf0.b
        public final void b(IApplyResult r100) {
            Intrinsics.checkNotNullParameter(r100, "applyResult");
            com.bytedance.android.livesdk.ktvimpl.multichorus.a.a(MultiChorusViewModel.TAG, "joinMultiChorus  apply success");
        }
    }

    @Override // rj0.b
    public final void onFailed(Exception r100) {
    }

    @Override // rj0.b
    public final void onSuccess() {
        this.f145931a.f145888a.getCurrentKtvStrategy().a(this.f145931a.f145889b, new a(this));
    }

    public d(MultiChorusViewModel.g r100) {
        this.f145931a = r100;
    }
}
