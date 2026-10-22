package com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.layer;

import com.bytedance.android.ec.core.utils.UIUtils;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.x;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Lazy;

/* JADX INFO: loaded from: classes13.dex */
public final class f implements x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ItemMediaLayer f169688a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f169689b;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f f169690a;

        public a(f r100) {
            this.f169690a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f169690a.f169688a.C(false);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.x
    public final void onStartPlay() {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.x
    public final void a() {
        if (com.bytedance.android.shopping.anchorv4.voavhs.headv2.e.f169210d == false) goto L14;
        ItemMediaLayer r100 = this.f169688a;
        int r101 = this.f169689b;
        Integer r102 = r100.f169659a;
        if (r102 != null) goto L8;
    L10:
        boolean r103 = false;
    L11:
        if (r103 == false) goto L15;
        Lazy r104 = UIUtils.f45548a;
        UIUtils.c().postDelayed(new a(this), 100);
        return;
    L15:
        return;
    L8:
        if (r101 != r102.intValue()) goto L10;
        r103 = true;
        goto L11
    }

    public f(ItemMediaLayer r100, int r101) {
        this.f169688a = r100;
        this.f169689b = r101;
    }
}
