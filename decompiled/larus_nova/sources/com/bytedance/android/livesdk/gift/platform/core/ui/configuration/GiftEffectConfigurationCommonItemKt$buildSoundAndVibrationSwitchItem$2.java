package com.bytedance.android.livesdk.gift.platform.core.ui.configuration;

import android.content.Context;
import android.content.DialogInterface;
import com.bytedance.android.livesdk.widget.x0;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"showCloseEffectConfirmDialog", "", "onResult", "Lkotlin/Function1;", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
public final class GiftEffectConfigurationCommonItemKt$buildSoundAndVibrationSwitchItem$2 extends Lambda implements Function1<Function1<? super Boolean, ? extends Unit>, Unit> {
    final /* synthetic */ Context $context;
    final /* synthetic */ boolean $isAnchor;

    public static final class a implements DialogInterface.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f131928a;

        public a(Function1 r100) {
            this.f131928a = r100;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r100, int r101) {
            this.f131928a.invoke(Boolean.TRUE);
            r100.dismiss();
        }
    }

    public static final class b implements DialogInterface.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f131929a;

        public b(Function1 r100) {
            this.f131929a = r100;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r100, int r101) {
            this.f131929a.invoke(Boolean.FALSE);
            r100.dismiss();
        }
    }

    public static final class c implements DialogInterface.OnCancelListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f131930a;

        public c(Function1 r100) {
            this.f131930a = r100;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public final void onCancel(DialogInterface r100) {
            this.f131930a.invoke(Boolean.FALSE);
        }
    }

    public GiftEffectConfigurationCommonItemKt$buildSoundAndVibrationSwitchItem$2(Context r100, boolean r101) {
        this.$context = r100;
        this.$isAnchor = r101;
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Function1<? super Boolean, ? extends Unit> r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Function1<? super Boolean, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "onResult");
        Context r101 = this.$context;
        x0.d r102 = new x0.d();
        r102.f162243b = r101;
        r102.f162242a = 0;
        r102.f162242a = 4;
        if (this.$isAnchor == false) goto L5;
        String r103 = com.bytedance.android.livesdk.gift.platform.core.h.j().b();
    L6:
        r102.f162245d = r103;
        a r104 = new a(r100);
        x0.c[] r105 = r102.f162248g;
        x0.c r106 = r105[0];
        if (r106 != null) goto L9;
        r106 = new x0.c();
        r105[0] = r106;
    L9:
        r106.f162239a = "确认关闭";
        r106.f162240b = r104;
        b r107 = new b(r100);
        x0.c[] r108 = r102.f162248g;
        x0.c r109 = r108[1];
        if (r109 != null) goto L12;
        r109 = new x0.c();
        r108[1] = r109;
    L12:
        r109.f162239a = "取消";
        r109.f162240b = r107;
        r102.f162249h = new c(r100);
        if (this.$isAnchor == true) goto L15;
        r102.f162244c = com.bytedance.android.livesdk.gift.platform.core.h.j().c();
    L15:
        x0.b.g(new x0(r102.f162243b, r102));
        return;
    L5:
        r103 = com.bytedance.android.livesdk.gift.platform.core.h.j().a();
        goto L6
    }
}
