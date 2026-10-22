package com.bytedance.android.livesdk.gift.platform.core.scope.service;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes9.dex */
public final class o0 extends com.bytedance.android.livesdk.user.h<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ m0 f131659a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ArrayList f131660b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef f131661c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ long f131662d;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.livesdk.user.h, io.reactivex.SingleObserver
    public final void onSuccess(Object r100) {
        ((Boolean) r100).booleanValue();
        ArrayList r101 = this.f131660b;
        if (r101 == null) goto L5;
        r101.remove((sz1.a) this.f131661c.element);
    L5:
        com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore.f r102 = this.f131659a.f131636d;
        long r103 = this.f131662d;
        sz1.a r104 = (sz1.a) this.f131661c.element;
        r102.getClass();
        Intrinsics.checkNotNullParameter(r104, "targetCard");
        if (r102.f127288a.get(String.valueOf(r103)) == null) goto L35;
        ArrayList<sz1.a> r105 = r102.f127288a.get(String.valueOf(r103));
        if (r105 == null) goto L10;
        int r106 = r105.size();
    L11:
        int r107 = 0;
    L13:
        if (r107 >= r106) goto L22;
        if (r105 == null) goto L16;
        sz1.a r108 = (sz1.a) ListProtector.get(r105, r107);
    L17:
        if (r108 == null) goto L21;
        if (gz1.b.c(r108, r104) != true) goto L21;
    L23:
        if (r107 == (-1)) goto L28;
        if (r105 == null) goto L26;
        sz1.a r109 = (sz1.a) ListProtector.remove(r105, r107);
    L26:
        if (r105 == null) goto L36;
        ListProtector.add(r105, 0, r104);
        return;
    L36:
        return;
    L28:
        if (r105 == null) goto L38;
        r105.add(r104);
        return;
    L38:
        return;
    L21:
        r107 = r107 + 1;
        goto L13
    L16:
        r108 = null;
        goto L17
    L22:
        r107 = -1;
        goto L23
    L10:
        r106 = 0;
        goto L11
    }

    public o0(m0 r100, ArrayList r101, Ref.ObjectRef r102, long r103) {
        this.f131659a = r100;
        this.f131660b = r101;
        this.f131661c = r102;
        this.f131662d = r103;
    }
}
