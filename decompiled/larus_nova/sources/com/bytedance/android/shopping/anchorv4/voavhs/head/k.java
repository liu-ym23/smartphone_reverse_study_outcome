package com.bytedance.android.shopping.anchorv4.voavhs.head;

import android.graphics.Rect;
import android.view.View;
import androidx.core.view.ViewCompat;
import com.bytedance.android.ec.model.ECUrlModel;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public class k implements d83.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d83.b f168783a;

    public static final class a implements View.OnLayoutChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f168784a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function1 f168785b;

        public a(View r100, Function1 r101) {
            this.f168784a = r100;
            this.f168785b = r101;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107, int r108) {
            r100.removeOnLayoutChangeListener(this);
            int[] r109 = new int[2];
            this.f168784a.getLocationOnScreen(r109);
            int r110 = r109[0];
            Rect r111 = new Rect(r110, r109[1], this.f168784a.getWidth() + r110, r109[1] + this.f168784a.getHeight());
            this.f168785b.invoke(Result.m9448boximpl(Result.m9449constructorimpl(r111)));
        }
    }

    @Override // d83.c
    public final boolean J() {
        return ViewCompat.isAttachedToWindow(this.f168783a.e());
    }

    @Override // d83.c
    public final boolean a() {
        return this.f168783a.a();
    }

    @Override // d83.c
    public final List<ECUrlModel> c() {
        return this.f168783a.c();
    }

    @Override // d83.c
    public final void d() {
        this.f168783a.d();
    }

    @Override // d83.c
    public View e() {
        return this.f168783a.e();
    }

    @Override // d83.c
    public final String f() {
        return this.f168783a.f();
    }

    @Override // d83.c
    public final void onResume() {
        this.f168783a.onResume();
    }

    public k(d83.b r100) {
        Intrinsics.checkNotNullParameter(r100, "headerAbility");
        this.f168783a = r100;
    }

    @Override // d83.c
    public final void D(Function1<? super Result<Rect>, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        View r101 = this.f168783a.h();
        if (r101 != null) goto L7;
        Result.Companion r102 = Result.Companion;
        r100.invoke(Result.m9448boximpl(Result.m9449constructorimpl(ResultKt.createFailure(new Exception()))));
        return;
    L7:
        if (ViewCompat.isLaidOut(r101) == true) goto L9;
    L11:
        r101.addOnLayoutChangeListener(new a(r101, r100));
        return;
    L9:
        if (r101.isLayoutRequested() == true) goto L11;
        int[] r103 = new int[2];
        r101.getLocationOnScreen(r103);
        int r104 = r103[0];
        r100.invoke(Result.m9448boximpl(Result.m9449constructorimpl(new Rect(r104, r103[1], r101.getWidth() + r104, r103[1] + r101.getHeight()))));
    }

    @Override // d83.c
    public final void b(boolean r100) {
        this.f168783a.b(r100);
    }
}
