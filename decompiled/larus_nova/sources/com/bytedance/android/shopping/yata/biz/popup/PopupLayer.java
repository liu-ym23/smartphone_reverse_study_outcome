package com.bytedance.android.shopping.yata.biz.popup;

import android.text.TextUtils;
import android.widget.FrameLayout;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.larus.nova.R;
import com.ss.android.lark.chat.core.dependency.BrowserDependency;
import hl3.e;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class PopupLayer implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicBoolean f187500a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public FrameLayout f187501b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public e.a f187502c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public b f187503d;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0005¢\u0006\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/shopping/yata/biz/popup/PopupLayer$UnInitializeExceptions;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "()V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class UnInitializeExceptions extends RuntimeException {
        public UnInitializeExceptions() {
            super("must call popup layer init first");
        }
    }

    @Override // hl3.b
    public final void a(a r100) {
        Intrinsics.checkNotNullParameter(r100, BrowserDependency.UrlClickType.CARD);
    }

    @Override // hl3.b
    public final void b(a r100) {
        Intrinsics.checkNotNullParameter(r100, BrowserDependency.UrlClickType.CARD);
    }

    @Override // hl3.b
    public final void c(hl3.a r100) {
        Intrinsics.checkNotNullParameter(r100, BrowserDependency.UrlClickType.CARD);
    }

    @Override // hl3.b
    public final void e(il3.a r100) {
        Intrinsics.checkNotNullParameter(r100, "config");
    }

    public final hl3.a k() {
        b r100 = this.f187503d;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("queue");
    L6:
        return r100.c();
    }

    public PopupLayer() {
        this.f187500a = new AtomicBoolean(false);
    }

    @Override // hl3.b
    public final void d(a r100) {
        Intrinsics.checkNotNullParameter(r100, BrowserDependency.UrlClickType.CARD);
        FrameLayout r101 = this.f187501b;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException(KtvSubElement.CONTAINER);
    L5:
        r101.removeView(r100.b());
        FrameLayout r102 = this.f187501b;
        if (r102 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException(KtvSubElement.CONTAINER);
    L9:
        if (r102.getChildCount() != 0) goto L23;
        e.a r103 = this.f187502c;
        if (r103 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("host");
    L14:
        if (r103.getHost().findViewById(R.id.biz_popup_container_id) == null) goto L24;
        e.a r104 = this.f187502c;
        if (r104 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("host");
    L18:
        FrameLayout r105 = r104.getHost();
        FrameLayout r106 = this.f187501b;
        if (r106 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException(KtvSubElement.CONTAINER);
    L21:
        r105.removeView(r106);
        return;
    L24:
        return;
    }

    @Override // hl3.b
    public final void f(a r100) {
        Intrinsics.checkNotNullParameter(r100, BrowserDependency.UrlClickType.CARD);
        e.a r101 = this.f187502c;
        if (r101 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("host");
    L6:
        if (r101.getHost().findViewById(R.id.biz_popup_container_id) != null) goto L14;
        e.a r102 = this.f187502c;
        if (r102 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("host");
    L10:
        FrameLayout r103 = r102.getHost();
        FrameLayout r104 = this.f187501b;
        if (r104 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException(KtvSubElement.CONTAINER);
    L13:
        r103.addView(r104);
    L14:
        FrameLayout r105 = this.f187501b;
        if (r105 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException(KtvSubElement.CONTAINER);
    L17:
        r105.addView(r100.b());
    }

    public final boolean h(String r100) {
        if (TextUtils.isEmpty(r100) == true) goto L11;
        Intrinsics.checkNotNull(r100);
        hl3.a r101 = i(r100);
        if (r101 == null) goto L8;
        r101.dismiss();
    L8:
        if (i(r100) == null) goto L24;
        return true;
    L24:
        return false;
    L11:
        b r102 = this.f187503d;
        if (r102 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("queue");
    L14:
        hl3.a r103 = r102.c();
        if (r103 == null) goto L17;
        r103.dismiss();
    L17:
        b r104 = this.f187503d;
        if (r104 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("queue");
    L21:
        if (r104.c() == null) goto L25;
        return true;
    L25:
        return false;
    }

    public final hl3.a i(String r100) {
        Intrinsics.checkNotNullParameter(r100, "id");
        b r101 = this.f187503d;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("queue");
    L5:
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "id");
        Iterator<hl3.a> r102 = r101.f187514a.iterator();
    L6:
        hl3.a r103 = null;
        if (r102.hasNext() == false) goto L11;
        hl3.a r104 = r102.next();
        if (Intrinsics.areEqual(r104.getId(), r100) == false) goto L6;
    L12:
        hl3.a r105 = r104;
        if (r105 != null) goto L28;
        Iterator<hl3.a> r106 = r101.f187515b.iterator();
    L16:
        if (r106.hasNext() == false) goto L21;
        hl3.a r107 = r106.next();
        if (Intrinsics.areEqual(r107.getId(), r100) == false) goto L16;
        r103 = r107;
    L21:
        return r103;
    L28:
        return r105;
    L11:
        r104 = null;
        goto L12
    }

    public final void j(e.a r100) {
        Intrinsics.checkNotNullParameter(r100, "host");
        if (this.f187500a.compareAndSet(false, true) == false) goto L6;
        this.f187502c = r100;
        FrameLayout r101 = new FrameLayout(r100.getContext());
        r101.setId(R.id.biz_popup_container_id);
        r101.setTag(R.id.biz_popup_container_tag, "popup_container_tag." + r101.getId());
        r101.setLayoutParams(r100.getLayoutParams());
        Unit r102 = Unit.INSTANCE;
        this.f187501b = r101;
        this.f187503d = new b();
        return;
    }

    public final void g(il3.a r100, Function1 r101) {
        Intrinsics.checkNotNullParameter(r100, "config");
        if (this.f187502c == null) goto L13;
        e.a r102 = this.f187502c;
        if (r102 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("host");
    L7:
        a r103 = new a(new WeakReference(r102.getContext()), r100);
        r103.f187512g = r101;
        Intrinsics.checkNotNullParameter(this, GXTemplateKey.GAIAX_LAYER);
        r103.f187507b = this;
        b r104 = this.f187503d;
        if (r104 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("queue");
    L10:
        r104.getClass();
        Intrinsics.checkNotNullParameter(r103, BrowserDependency.UrlClickType.CARD);
        r104.f187515b.offer(r103);
        r104.b();
        return;
    L13:
        throw new UnInitializeExceptions();
    }
}
