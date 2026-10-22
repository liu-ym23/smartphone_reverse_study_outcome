package com.bytedance.android.livesdk.livecommerce.eventcenter.ability;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import com.bytedance.android.ec.local.api.atomic.LiveAtomicAbilityDescriptor;
import com.bytedance.android.livesdk.livecommerce.dynamiccontext.LiveDynamicContext;
import com.bytedance.android.ui.ec.widget.dialog.ECAlertDialog;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@LiveAtomicAbilityDescriptor(action = "show_dialog", description = "展示弹窗", service = {"LiveBase"})
public final class e0 extends com.bytedance.android.livesdk.livecommerce.ability.d<sl.k> {
    public e0() {
    }

    public static final void c(e0 r110, Context r111, sl.h r112, Object r113) {
        r110.getClass();
        if (r112 == null) goto L17;
        Intrinsics.checkNotNullParameter(r112, "$this$convert2Standard");
        int r114 = r112.a();
        com.bytedance.android.livesdk.livecommerce.ability.f r100 = null;
        if (r114 != 1) goto L7;
        sl.a r115 = r112.b();
        if (r115 != null) goto L13;
    L12:
        com.bytedance.android.livesdk.livecommerce.ability.f r101 = r100;
        if (r101 == null) goto L18;
        Lazy r116 = LiveDynamicContext.f147714c;
        com.bytedance.android.livesdk.livecommerce.ability.b.a.a(LiveDynamicContext.a.a().a(), r111, r101, r113, null, null, 16);
        return;
    L18:
        return;
    L13:
        String r117 = com.bytedance.android.livesdk.livecommerce.eventcenter.a.c(r112.a(), r115.a());
        r100 = new com.bytedance.android.livesdk.livecommerce.ability.f("LiveList", r117, com.bytedance.android.livesdk.livecommerce.eventcenter.a.b(r117, r112));
        goto L12
    L7:
        if (r114 != 4) goto L12;
        String r118 = com.bytedance.android.livesdk.livecommerce.eventcenter.a.c(r112.a(), null);
        r100 = new com.bytedance.android.livesdk.livecommerce.ability.f("LiveList", r118, com.bytedance.android.livesdk.livecommerce.eventcenter.a.b(r118, r112));
        goto L12
    }

    @Override // com.bytedance.android.livesdk.livecommerce.ability.d
    public final void a(Context r110, sl.k r111, Object r112, il2.a r113, com.bytedance.android.livesdk.livecommerce.ability.e r114) {
        sl.k r115 = r111;
        CharSequence r100 = null;
        if (r110 == null) goto L62;
        if (r115 == null) goto L62;
        ECAlertDialog r101 = new ECAlertDialog(r110);
        String r102 = r115.f();
        if (r102 != null) goto L9;
    L17:
        sl.j r103 = r115.c();
        if (r103 == null) goto L20;
        List<sl.l> r104 = r103.a();
    L21:
        if (r104 == null) goto L38;
        SpannableStringBuilder r105 = new SpannableStringBuilder();
        Iterator<T> r106 = r104.iterator();
        int r107 = 0;
        int r108 = 0;
    L25:
        if (r106.hasNext() == false) goto L37;
        sl.l r109 = (sl.l) r106.next();
        String r116 = r109.b();
        if (r116 == null) goto L25;
        if (r116.length() <= 0) goto L31;
        boolean r117 = true;
    L32:
        if (r117 == true) goto L35;
        r116 = null;
    L35:
        if (r116 == null) goto L25;
        r105.append(r116);
        r107 = r107 + r116.length();
        int r118 = com.bytedance.android.ec.core.utils.s.f45717a;
        r105.setSpan(new ForegroundColorSpan(com.bytedance.android.ec.core.utils.s.a(r109.a(), 0)), r108, r107, 17);
        r108 = r107;
        goto L25
    L31:
        r117 = false;
        goto L32
    L37:
        r100 = r105;
    L38:
        if (r100 == null) goto L40;
        r101.setMessage(r100);
    L40:
        sl.i r119 = r115.b();
        CharSequence r120 = "";
        if (r119 == null) goto L47;
        CharSequence r121 = r119.b();
        if (r121 != null) goto L45;
        CharSequence r122 = "";
    L46:
        r101.setPositiveButton(r122, new z(r119, this, r115, r110, r112));
        goto L47
    L45:
        r122 = r121;
    L47:
        sl.i r123 = r115.a();
        if (r123 == null) goto L55;
        CharSequence r124 = r123.b();
        if (r124 == null) goto L53;
        r120 = r124;
    L53:
        r101.setNegativeButton(r120, new a0(r123, this, r115, r110, r112));
    L55:
        if (DialogLancet.shouldBlockDialogShow(r101) == false) goto L66;
        DialogLancet.handleBlockedDialogShow(r101);
    L59:
        oh.a.c("ECAlertDialogShowEvent", new d0(r115.d(), r115.e()));
        if (r114 == null) goto L75;
        r114.onSuccess();
        return;
    L75:
        return;
    L66:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L65
    L58:
        DialogLancet.beforeDialogShow(r101);
        r101.show();
        DialogLancet.afterDialogShow(r101);
        goto L59
    L20:
        r104 = null;
        goto L21
    L9:
        if (r102.length() <= 0) goto L11;
        boolean r125 = true;
    L12:
        if (r125 == true) goto L15;
        r102 = null;
    L15:
        if (r102 == null) goto L17;
        r101.setTitle(r102);
        goto L17
    L11:
        r125 = false;
    L62:
        if (r114 == null) goto L77;
        com.bytedance.android.livesdk.livecommerce.ability.e.a.a(r114, 0, null, 3);
        return;
    }
}
