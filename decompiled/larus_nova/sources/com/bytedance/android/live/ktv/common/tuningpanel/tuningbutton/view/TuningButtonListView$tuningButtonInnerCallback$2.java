package com.bytedance.android.live.ktv.common.tuningpanel.tuningbutton.view;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\t\n\u0000\n\u0002\b\u0003*\u0001\u0001\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "com/bytedance/android/live/ktv/common/tuningpanel/tuningbutton/view/TuningButtonListView$tuningButtonInnerCallback$2$1", AbsMethodDelegate.TAG_INVOKE, "()Lcom/bytedance/android/live/ktv/common/tuningpanel/tuningbutton/view/TuningButtonListView$tuningButtonInnerCallback$2$1;"}, k = 3, mv = {1, 5, 1})
public final class TuningButtonListView$tuningButtonInnerCallback$2 extends Lambda implements Function0<AnonymousClass1> {
    final /* synthetic */ TuningButtonListView this$0;

    /* JADX INFO: renamed from: com.bytedance.android.live.ktv.common.tuningpanel.tuningbutton.view.TuningButtonListView$tuningButtonInnerCallback$2$1, reason: invalid class name */
    public static final class AnonymousClass1 implements bc0.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TuningButtonListView$tuningButtonInnerCallback$2 f70493a;

        @Override // bc0.a
        public final boolean a() {
            bc0.b r100 = this.f70493a.this$0.f70491g.f2539f;
            if (r100 == null) goto L5;
            int r101 = r100.c();
        L7:
            if (r101 > 1) goto L11;
            return false;
        L11:
            return true;
        L5:
            r101 = 2;
            goto L7
        }

        public AnonymousClass1(TuningButtonListView$tuningButtonInnerCallback$2 r100) {
            this.f70493a = r100;
        }

        @Override // bc0.a
        public final void b(final ac0.a r100, final boolean r101) {
            if (r100 != null) goto L4;
            return;
        L4:
            TuningButtonListView r102 = this.f70493a.this$0;
            bc0.b r103 = r102.f70491g.f2539f;
            if (r103 == null) goto L7;
            r103.e(TuningButtonListView.t(r102), r100, r101);
            return;
        L7:
            TuningButtonListView.t(r102).m2(new TuningButtonListView$tuningButtonInnerCallback$2$1$onButtonChecked$$inlined$run$lambda$1(this, r101, r100), r100.getType(), false);
            zb0.a r104 = this.f70493a.this$0.f70491g.f2538e;
            if (r104 == null) goto L12;
            r104.d(r100, r101);
            return;
        }
    }

    public TuningButtonListView$tuningButtonInnerCallback$2(TuningButtonListView r100) {
        this.this$0 = r100;
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final AnonymousClass1 invoke() {
        return new AnonymousClass1(this);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ AnonymousClass1 invoke() {
        return invoke();
    }
}
