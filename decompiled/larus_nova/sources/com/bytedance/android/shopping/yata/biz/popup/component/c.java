package com.bytedance.android.shopping.yata.biz.popup.component;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.View;
import com.bytedance.android.shopping.yata.biz.popup.behavior.SheetBaseBehavior;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.ss.android.lark.utils.statistics.PerfLog;
import hl3.f;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class c extends a implements SheetBaseBehavior.b, View.OnClickListener {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f187560e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View f187561f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public SheetBaseBehavior<?> f187562g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ObjectAnimator f187563h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f187564i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f187565j;

    @Override // com.bytedance.android.shopping.yata.biz.popup.behavior.SheetBaseBehavior.b
    public final void b(View r100) {
        Intrinsics.checkNotNullParameter(r100, DocumentType.SHEET_NAME);
    }

    public final void d() {
        e(false);
        SheetBaseBehavior<?> r100 = this.f187562g;
        if (r100 == null) goto L5;
        r100.setState(5);
    L5:
        com.bytedance.android.shopping.yata.biz.popup.a r101 = this.f187554a;
        if (r101 == null) goto L19;
        hl3.e r102 = r101.f187507b;
        if (r102 == null) goto L10;
        r102.a(r101);
    L10:
        Iterator<hl3.b> r103 = r101.f187508c.iterator();
    L12:
        if (r103.hasNext() == false) goto L14;
        r103.next().a(r101);
        goto L12
    L14:
        f r104 = r101.f187506a;
        if (r104 == null) goto L20;
        r104.a(r101);
        return;
    L20:
        return;
    }

    public final void e(boolean r100) {
        if (this.f187564i == true) goto L5;
        return;
    L5:
        ObjectAnimator r101 = this.f187563h;
        if (r101 == null) goto L9;
        r101.cancel();
    L9:
        if (r100 == false) goto L11;
        ObjectAnimator r102 = ObjectAnimator.ofFloat(this.f187561f, View.ALPHA, new float[]{0.0f, 1.0f});
    L12:
        this.f187563h = r102;
        if (r102 == null) goto L15;
        r102.setDuration(200);
    L15:
        ObjectAnimator r103 = this.f187563h;
        if (r103 == null) goto L19;
        r103.start();
        return;
    L19:
        return;
    L11:
        r102 = ObjectAnimator.ofFloat(this.f187561f, View.ALPHA, new float[]{1.0f, 0.0f});
        goto L12
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        if (Intrinsics.areEqual(r100, this.f187561f) == false) goto L18;
        com.bytedance.android.shopping.yata.biz.popup.a r101 = this.f187554a;
        if (r101 == null) goto L14;
        hl3.e r102 = r101.f187507b;
        if (r102 == null) goto L9;
        r102.b(r101);
    L9:
        Iterator<hl3.b> r103 = r101.f187508c.iterator();
    L11:
        if (r103.hasNext() == false) goto L14;
        r103.next().b(r101);
    L14:
        if (this.f187565j == false) goto L19;
        d();
        return;
    L19:
        return;
    }

    public c(Context r100, il3.a r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "config");
        super(r100, r101);
    }

    @Override // com.bytedance.android.shopping.yata.biz.popup.behavior.SheetBaseBehavior.b
    public final void a(View r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, DocumentType.SHEET_NAME);
        if (r101 != 5) goto L19;
        hl3.c r102 = this.f187555b;
        if (r102 == null) goto L8;
        r102.release();
    L8:
        com.bytedance.android.shopping.yata.biz.popup.a r103 = this.f187554a;
        if (r103 == null) goto L17;
        hl3.e r104 = r103.f187507b;
        if (r104 == null) goto L13;
        r104.d(r103);
    L13:
        Iterator<hl3.b> r105 = r103.f187508c.iterator();
    L15:
        if (r105.hasNext() == false) goto L20;
        r105.next().d(r103);
        goto L15
    L20:
        return;
    L17:
        return;
    }
}
