package com.bytedance.android.live.recharge.panel;

import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.live.recharge.RechargeDialogContext;
import com.facebook.keyframes.model.KFAnimation;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes47.dex */
public final class h extends com.bytedance.android.live.recharge.panel.context.a {
    public static final /* synthetic */ KProperty[] B = null;
    public final RechargeDialogContext A;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final b f90217y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final b f90218z;

    public static final class a {
    }

    public final class b<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.bytedance.android.live.core.arch.mvvm.c<T> f90219a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ h f90220b;

        public b(h r100, PropertyOwner r101) {
            Intrinsics.checkNotNullParameter(r101, PickerReporterConstants.KEY.TARGET);
            this.f90220b = r100;
            this.f90219a = r101;
            com.bytedance.android.live.recharge.panel.context.b.a(r101.subscribe(new i(this)), r100.A.getCd());
        }
    }

    static {
        B = new KProperty[]{Reflection.mutableProperty1(new MutablePropertyReference1Impl(h.class, "isRechargeAgreementAccepted", "isRechargeAgreementAccepted()Ljava/lang/Boolean;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(h.class, "customPrice", "getCustomPrice()Ljava/lang/Long;", 0))};
    }

    @Override // com.bytedance.android.live.recharge.panel.context.a, vw0.d
    public final Long getCustomPrice() {
        b r100 = this.f90218z;
        KProperty r101 = B[1];
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        return (Long) r100.f90219a.getValue();
    }

    @Override // com.bytedance.android.live.recharge.panel.context.a, vw0.d
    public final Boolean isRechargeAgreementAccepted() {
        b r100 = this.f90217y;
        KProperty r101 = B[0];
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        return (Boolean) r100.f90219a.getValue();
    }

    public h(RechargeDialogContext r100) {
        Intrinsics.checkNotNullParameter(r100, "dialogContext");
        super(r100.getDialogContextProxy());
        this.A = r100;
        PropertyOwner<Boolean> r101 = r100.isAcceptAgreement();
        KProperty[] r102 = B;
        KProperty r103 = r102[0];
        Intrinsics.checkNotNullParameter(r101, "$this$provideDelegate");
        this.f90217y = new b(this, r101);
        PropertyOwner<Long> r104 = r100.getCustomPrice();
        KProperty r105 = r102[1];
        Intrinsics.checkNotNullParameter(r104, "$this$provideDelegate");
        this.f90218z = new b(this, r104);
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // com.bytedance.android.live.recharge.panel.context.a, vw0.d
    public final void setCustomPrice(Long r100) {
        b r101 = this.f90218z;
        KProperty r102 = B[1];
        r101.getClass();
        Intrinsics.checkNotNullParameter(r102, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        if (r100 == null) goto L7;
        r101.f90219a.a((T) r100);
        return;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // com.bytedance.android.live.recharge.panel.context.a, vw0.d
    public final void setRechargeAgreementAccepted(Boolean r100) {
        b r101 = this.f90217y;
        KProperty r102 = B[0];
        r101.getClass();
        Intrinsics.checkNotNullParameter(r102, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        if (r100 == null) goto L7;
        r101.f90219a.a((T) r100);
        return;
    }
}
