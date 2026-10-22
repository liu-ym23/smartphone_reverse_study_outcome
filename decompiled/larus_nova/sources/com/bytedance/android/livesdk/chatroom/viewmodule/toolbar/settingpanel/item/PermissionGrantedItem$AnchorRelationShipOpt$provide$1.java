package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.settingpanel.item;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import np1.e;
import np1.g;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lnp1/g;", "Lnp1/e;", AbsMethodDelegate.TAG_INVOKE, "(Lnp1/g;)Lnp1/e;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final class PermissionGrantedItem$AnchorRelationShipOpt$provide$1 extends Lambda implements Function1<g, e> {
    final /* synthetic */ PermissionGrantedItem.AnchorRelationShipOpt this$0;

    public PermissionGrantedItem$AnchorRelationShipOpt$provide$1(PermissionGrantedItem.AnchorRelationShipOpt r100) {
        this.this$0 = r100;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final e invoke2(final g r100) {
        Intrinsics.checkNotNullParameter(r100, "$receiver");
        np1.a.C6956a r101 = np1.a.f520005a;
        Function0<e> r102 = new AnonymousClass1(r100);
        Function1<e, Unit> r103 = new AnonymousClass2(this);
        r101.getClass();
        return (e) np1.a.C6956a.a(r102, r103);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ e invoke(g r100) {
        return invoke2(r100);
    }
}
