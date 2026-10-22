package com.bytedance.android.shopping.widget.buybutton;

import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.ec.core.utils.l1;
import com.bytedance.android.ec.model.promotion.ECResultDialogContentVO;
import com.larus.nova.R;
import java.util.ArrayList;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class g implements d, l1.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public e f187296a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b f187297b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public l1 f187298c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f187299d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final c f187300e;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.ec.core.utils.l1.a
    public final void onStart() {
    }

    @Override // com.bytedance.android.ec.core.utils.l1.a
    public final void onFinish() {
        l1 r100 = this.f187298c;
        if (r100 == null) goto L5;
        ((ArrayList) r100.f45640j).remove(this);
    L5:
        b r101 = this.f187297b;
        if (r101 == null) goto L9;
        r101.a();
        return;
    }

    public g(c r210) {
        Intrinsics.checkNotNullParameter(r210, "view");
        this.f187300e = r210;
        int r100 = e.f187274u;
        Intrinsics.checkNotNullParameter(this, "presenter");
        this.f187296a = new e(this, null, null, "", "", "", "", "", null, "", null, null, null, null, null, null, null, null, null, CollectionsKt.emptyList());
        this.f187299d = -1;
    }

    @Override // com.bytedance.android.shopping.widget.buybutton.d
    public final void b(boolean r100) {
        if (r100 == false) goto L8;
        ECResultDialogContentVO r101 = ECSettingKeys.b();
        b r102 = this.f187297b;
        if (r102 == null) goto L6;
        r102.a();
    L6:
        if (r101 == null) goto L10;
        this.f187300e.d(r101);
        return;
    L10:
        return;
    L8:
        c.a.a(this.f187300e, null, Integer.valueOf(R.string.deposit_presale_appoint_fail), 1);
    }

    @Override // com.bytedance.android.ec.core.utils.l1.a
    public final void onTick(long r100) {
        this.f187300e.e(this.f187299d, r100);
    }

    @Override // com.bytedance.android.shopping.widget.buybutton.d
    public final void a(boolean r100, String r101) {
        if (r100 == false) goto L6;
        b r102 = this.f187297b;
        if (r102 == null) goto L6;
        r102.a();
    L6:
        c r103 = this.f187300e;
        if (r101 != null) goto L9;
        r101 = "";
    L9:
        c.a.a(r103, r101, null, 2);
    }
}
