package com.obric.autoaction.app.launcherpage.utils;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.SystemClock;
import android.text.method.LinkMovementMethod;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowInsets;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import androidx.core.view.ai;
import androidx.core.view.al;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.plugin.R;
import com.obric.autogui.common.api.app.AOHostAppTools;
import com.obric.oui.button.OButtonGroup;
import com.obric.oui.dialog.v2.alert.OAlertDialog;
import com.obric.oui.forms.OInputLayout;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.popover.menu.OPopoverEntranceMenuView;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.x;
import java.util.Arrays;
import java.util.Iterator;

/* JADX INFO: compiled from: ViewExt.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class p {

    /* JADX INFO: compiled from: ViewExt.kt */
    public static final class a implements OInputLayout.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ d.h.a.b<Boolean, x> f24532a;

        a(d.h.a.b<? super Boolean, x> r3) {
            this.f24532a = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.b.class, "com.obric.aiagent.plugin");
        }

        @Override // com.obric.oui.forms.OInputLayout.b
        public void onLimitStateChange(boolean r1) {
            this.f24532a.invoke(Boolean.valueOf(r1));
        }
    }

    /* JADX INFO: compiled from: ViewExt.kt */
    public static final class b extends com.obric.oui.popover.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ d.h.a.m<View, int[], Boolean> f24533a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f24534b;

        b(d.h.a.m<? super View, ? super int[], Boolean> r3, View r4) {
            this.f24533a = (d.h.a.m) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.m.class, "com.obric.aiagent.plugin");
            this.f24534b = r4;
        }

        @Override // com.obric.oui.popover.d
        public boolean a(View r2, int[] r3) {
            d.h.b.o.e(r2, "view");
            d.h.b.o.e(r3, "rawPos");
            boolean r4 = ((Boolean) ZeusTransformUtils.preCheckCast(this.f24533a.invoke(r2, r3), Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
            if (r4 == false) goto L5;
            this.f24534b.getParent().requestDisallowInterceptTouchEvent(true);
        L5:
            return r4;
        }
    }

    public static /* synthetic */ void lambda$1NzXIVfsKsXUy6P3_pdhKQ0pVVg(View r0, View r1, boolean r2) {
        a(r0, r1, r2);
    }

    /* JADX INFO: renamed from: lambda$9RwT9694T6W9KP-7mcVjAlltmUg, reason: not valid java name */
    public static /* synthetic */ void m570lambda$9RwT9694T6W9KP7mcVjAlltmUg(View r0, OFloatingTitleBar r1, boolean r2, int r3) {
        a(r0, r1, r2, r3);
    }

    public static /* synthetic */ x lambda$DkDLPHAFKlbHquNs9SI24Jgv6dc(DialogInterface r0, int r1) {
        return b(r0, r1);
    }

    public static /* synthetic */ al lambda$KeHgxUDTm9_x9iDrLgmrkrYYle8(int r0, int r1, int r2, int r3, int r4, View r5, al r6) {
        return a(r0, r1, r2, r3, r4, r5, r6);
    }

    public static /* synthetic */ void lambda$KhAFdfVie8Qhn_G79Pq0nBmafMo(long r0, d.h.a.b r2, View r3) {
        a(r0, r2, r3);
    }

    /* JADX INFO: renamed from: lambda$UkiGr0Eca4PHQ-UhRnwlhzGwYtM, reason: not valid java name */
    public static /* synthetic */ void m571lambda$UkiGr0Eca4PHQUhRnwlhzGwYtM(d.h.a.b r0, View r1) {
        a(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$a9yKM1WFanpiledfN-Fy3tRrW3U, reason: not valid java name */
    public static /* synthetic */ void m572lambda$a9yKM1WFanpiledfNFy3tRrW3U(OButtonGroup r0, d.h.a.b r1, View r2) {
        a(r0, r1, r2);
    }

    public static /* synthetic */ x lambda$bkpmQHs1aHDhm7WL9JlOhR4YRa4(d.h.a.m r0, j r1, i r2, d.h.a.a r3, View r4, int r5) {
        return a(r0, r1, r2, r3, r4, r5);
    }

    public static /* synthetic */ void lambda$dNcb_hKg0_Hz9w0axetIVOFsXHg(d.h.a.b r0, View r1) {
        b(r0, r1);
    }

    public static /* synthetic */ void lambda$eaSFA9FOELvtnVVrQWfSptiSWUI(View r0, OFloatingTitleBar r1, boolean r2) {
        b(r0, r1, r2);
    }

    /* JADX INFO: renamed from: lambda$g-2UjO5llBexXNcgbJ31eQI9Whw, reason: not valid java name */
    public static /* synthetic */ WindowInsets m573lambda$g2UjO5llBexXNcgbJ31eQI9Whw(View r0, OFloatingTitleBar r1, boolean r2, View r3, WindowInsets r4) {
        return a(r0, r1, r2, r3, r4);
    }

    public static /* synthetic */ x lambda$m3oaYtcwQCaCj0pXR2WcuvxDr4g(DialogInterface r0, int r1) {
        return a(r0, r1);
    }

    public static /* synthetic */ void lambda$nqjG1i8j46T7KuVitcaeYGuUHDo(d.h.a.b r0, OFloatingTitleBar r1) {
        a(r0, r1);
    }

    public static /* synthetic */ WindowInsets lambda$rxm7pesnhVve2PAU7oySDhEk6D4(View r0, d.h.a.b r1, OFloatingTitleBar r2, View r3, WindowInsets r4) {
        return a(r0, r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: lambda$vcqrnh3TY-CVjpZPBx7CNzBYPx0, reason: not valid java name */
    public static /* synthetic */ x m574lambda$vcqrnh3TYCVjpZPBx7CNzBYPx0(i r0, j r1, d.h.a.m r2, OPopoverEntranceMenuView.a r3, d.h.a.a r4) {
        return a(r0, r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: lambda$wtbhH2MEe81wFSElWkqj-7LjipM, reason: not valid java name */
    public static /* synthetic */ void m575lambda$wtbhH2MEe81wFSElWkqj7LjipM(d.h.a.b r0, View r1) {
        c(r0, r1);
    }

    public static /* synthetic */ WindowInsets lambda$z46FTe8i_FAAsUDt_MraMb9slBo(View r0, OFloatingTitleBar r1, boolean r2, int r3, View r4, WindowInsets r5) {
        return a(r0, r1, r2, r3, r4, r5);
    }

    public static /* synthetic */ void a(Context r1, OFloatingTitleBar r2, Integer r3, Integer r4, boolean r5, d.h.a.b r6, d.h.a.b r7, int r8, Object r9) {
        Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r1, Context.class, "com.obric.aiagent.plugin");
        d.h.a.b r11 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r6, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.a.b r0 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r7, d.h.a.b.class, "com.obric.aiagent.plugin");
        Integer r12 = null;
        if ((r8 & 4) == 0) goto L5;
        Integer r13 = null;
    L7:
        if ((r8 & 8) != 0) goto L11;
        r12 = r4;
    L11:
        if ((r8 & 16) == 0) goto L13;
        r5 = false;
    L13:
        a(r10, r2, r13, r12, r5, r11, r0);
        return;
    L5:
        r13 = r3;
        goto L7
    }

    public static final void a(Context r8, OFloatingTitleBar r9, Integer r10, Integer r11, boolean r12, d.h.a.b<? super View, x> r13, d.h.a.b<? super View, x> r14) {
        Context r15 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.aiagent.plugin");
        final d.h.a.b r16 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r13, d.h.a.b.class, "com.obric.aiagent.plugin");
        final d.h.a.b r17 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r14, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r15, "context");
        d.h.b.o.e(r9, "titleBar");
        d.h.b.o.e(r16, "clickConfirmButton");
        d.h.b.o.e(r17, "clickCancelButton");
        final OButtonGroup r18 = (OButtonGroup) ZeusTransformUtils.preCheckCast(r9.findViewById(ZeusTransformUtils.mapRes(R.id.end_button_group, DbHelper.COL_ID, "end_button_group")), OButtonGroup.class, "com.obric.aiagent.plugin");
        r9.setEndButtonGroupStyle(ZeusTransformUtils.mapRes(R.style.AutoActionConfirmButtonFloating, "style", "AutoActionConfirmButtonFloating"));
        View r0 = r9.addEndAction(ZeusTransformUtils.mapRes(R.drawable.oic_check, "drawable", "oic_check"), -1, new $$Lambda$p$a9yKM1WFanpiledfNFy3tRrW3U(r18, r16));
        com.obric.oui.common.style.a r5 = null;
        if (r18 == null) goto L5;
        View r6 = r18.getChildAt(0);
    L7:
        if (ZeusTransformUtils.instanceOf(r6, com.obric.oui.common.style.a.class) == false) goto L9;
        com.obric.oui.common.style.a r7 = (com.obric.oui.common.style.a) ZeusTransformUtils.preCheckCast(r6, com.obric.oui.common.style.a.class, "com.obric.aiagent.plugin");
    L10:
        if (r7 == null) goto L13;
        r7.setChangeAlphaWhenDisable(false);
    L13:
        if (ZeusTransformUtils.instanceOf(r0, com.obric.oui.common.style.a.class) == false) goto L15;
        r5 = (com.obric.oui.common.style.a) ZeusTransformUtils.preCheckCast(r0, com.obric.oui.common.style.a.class, "com.obric.aiagent.plugin");
    L15:
        if (r5 == null) goto L17;
        r5.setChangeAlphaWhenDisable(true);
    L17:
        if (r18 == null) goto L19;
        r18.setEnabled(r12);
    L19:
        r9.setStartButtonGroupStyle(ZeusTransformUtils.mapRes(R.style.OStyleV2_OButtonFloating_S_Standard_Icon, "style", "OStyleV2_OButtonFloating_S_Standard_Icon"));
        if (r11 == null) goto L22;
        int r19 = r11.intValue();
    L23:
        r9.addStartAction(r19, -1, new $$Lambda$p$UkiGr0Eca4PHQUhRnwlhzGwYtM(r17));
        if (r10 == null) goto L27;
        r9.setCenterTitle(((Number) ZeusTransformUtils.preCheckCast(r10, Number.class, "com.obric.aiagent.plugin")).intValue());
        return;
    L27:
        return;
    L22:
        r19 = ZeusTransformUtils.mapRes(R.drawable.o_floating_title_bar_icon_back, "drawable", "o_floating_title_bar_icon_back");
        goto L23
    L9:
        r7 = null;
        goto L10
    L5:
        r6 = null;
        goto L7
    }

    private static final void a(OButtonGroup r2, d.h.a.b r3, View r4) {
        d.h.a.b r5 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.b.class, "com.obric.aiagent.plugin");
        boolean r0 = true;
        if (r2 != null) goto L5;
    L7:
        r0 = false;
    L8:
        if (r0 == true) goto L10;
        return;
    L10:
        d.h.b.o.a(r4);
        r5.invoke(r4);
        return;
    L5:
        if (r2.isEnabled() != true) goto L7;
        goto L7
    }

    private static final void a(d.h.a.b r2, View r3) {
        d.h.a.b r4 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r2, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.b.o.a(r3);
        r4.invoke(r3);
    }

    public static final void a(Context r8, OFloatingTitleBar r9, Integer r10, d.h.a.b<? super View, x> r11, d.h.a.b<? super View, x> r12) {
        Context r13 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.aiagent.plugin");
        final d.h.a.b r14 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r11, d.h.a.b.class, "com.obric.aiagent.plugin");
        final d.h.a.b r15 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r12, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r13, "context");
        d.h.b.o.e(r9, "titleBar");
        d.h.b.o.e(r14, "clickCancelButton");
        d.h.b.o.e(r15, "clickEditButton");
        if (r10 == null) goto L5;
        r9.setCenterTitle(((Number) ZeusTransformUtils.preCheckCast(r10, Number.class, "com.obric.aiagent.plugin")).intValue());
    L5:
        r9.setStartButtonGroupStyle(ZeusTransformUtils.mapRes(R.style.OStyleV2_OButtonFloating_S_Standard_Icon, "style", "OStyleV2_OButtonFloating_S_Standard_Icon"));
        r9.setEndButtonGroupStyle(ZeusTransformUtils.mapRes(R.style.OStyleV2_OButtonFloating_S_Standard_Text, "style", "OStyleV2_OButtonFloating_S_Standard_Text"));
        OFloatingTitleBar.addStartAction$default(r9, ZeusTransformUtils.mapRes(R.drawable.o_floating_title_bar_icon_back, "drawable", "o_floating_title_bar_icon_back"), 0, new $$Lambda$p$dNcb_hKg0_Hz9w0axetIVOFsXHg(r14), 2, null);
        OFloatingTitleBar.removeAllEndAction$default(r9, false, 1, null);
        String r1 = r13.getString(ZeusTransformUtils.mapRes(R.string.detail_shortcut_edit, WsChannelMultiProcessSharedProvider.STRING_TYPE, "detail_shortcut_edit"));
        d.h.b.o.c(r1, "getString(...)");
        OFloatingTitleBar.addEndAction$default(r9, r1, 0, new $$Lambda$p$wtbhH2MEe81wFSElWkqj7LjipM(r15), 2, null);
    }

    private static final void b(d.h.a.b r2, View r3) {
        d.h.a.b r4 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r2, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.b.o.a(r3);
        r4.invoke(r3);
    }

    private static final void c(d.h.a.b r2, View r3) {
        d.h.a.b r4 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r2, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.b.o.a(r3);
        r4.invoke(r3);
    }

    public static /* synthetic */ void a(View r1, long r2, d.h.a.b r4, int r5, Object r6) {
        d.h.a.b r7 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.b.class, "com.obric.aiagent.plugin");
        if ((r5 & 1) == 0) goto L5;
        r2 = 600;
    L5:
        a(r1, r2, r7);
    }

    public static final void a(View r2, final long r3, d.h.a.b<? super View, x> r5) {
        final d.h.a.b r6 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r5, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r2, "<this>");
        d.h.b.o.e(r6, "onClick");
        r2.setOnClickListener(new $$Lambda$p$KhAFdfVie8Qhn_G79Pq0nBmafMo(r3, r6));
    }

    private static final void a(long r5, d.h.a.b r7, View r8) {
        d.h.a.b r9 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r7, d.h.a.b.class, "com.obric.aiagent.plugin");
        Object r2 = r8.getTag(-10001);
        if (ZeusTransformUtils.instanceOf(r2, Long.class) == false) goto L5;
        Long r1 = (Long) ZeusTransformUtils.preCheckCast(r2, Long.class, "com.obric.aiagent.plugin");
    L6:
        if (r1 == null) goto L8;
        long r3 = r1.longValue();
    L9:
        long r4 = SystemClock.elapsedRealtime();
        if ((r4 - r3) < r5) goto L13;
        r8.setTag(-10001, Long.valueOf(r4));
        d.h.b.o.a(r8);
        r9.invoke(r8);
        return;
    L13:
        return;
    L8:
        r3 = 0;
        goto L9
    L5:
        r1 = null;
        goto L6
    }

    public static /* synthetic */ Dialog a(Context r3, String r4, CharSequence r5, String r6, String r7, boolean r8, boolean r9, DialogInterface.OnClickListener r10, int r11, Object r12) {
        Context r13 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        CharSequence r14 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r5, CharSequence.class, "com.obric.aiagent.plugin");
        DialogInterface.OnClickListener r0 = (DialogInterface.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r10, DialogInterface.OnClickListener.class, "com.obric.aiagent.plugin");
        String r15 = null;
        if ((r11 & 8) == 0) goto L5;
        String r1 = null;
    L7:
        if ((r11 & 16) != 0) goto L11;
        r15 = r7;
    L11:
        if ((r11 & 32) == 0) goto L13;
        r8 = true;
    L13:
        boolean r2 = r8;
        if ((r11 & 64) == 0) goto L17;
        r9 = false;
    L17:
        return a(r13, r4, r14, r1, r15, r2, r9, r0);
    L5:
        r1 = r6;
        goto L7
    }

    public static final Dialog a(Context r8, String r9, CharSequence r10, String r11, String r12, boolean r13, boolean r14, DialogInterface.OnClickListener r15) {
        Context r16 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.aiagent.plugin");
        CharSequence r17 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r10, CharSequence.class, "com.obric.aiagent.plugin");
        DialogInterface.OnClickListener r4 = (DialogInterface.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r15, DialogInterface.OnClickListener.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r16, "context");
        d.h.b.o.e(r9, "shortTitle");
        d.h.b.o.e(r17, "mediumMessage");
        d.h.b.o.e(r4, "positiveListener");
        if (r11 != null) goto L5;
        r11 = r16.getString(ZeusTransformUtils.mapRes(R.string.common_go_enable, WsChannelMultiProcessSharedProvider.STRING_TYPE, "common_go_enable"));
        d.h.b.o.c(r11, "getString(...)");
    L5:
        if (r12 != null) goto L7;
        r12 = r16.getString(ZeusTransformUtils.mapRes(R.string.common_cancel, WsChannelMultiProcessSharedProvider.STRING_TYPE, "common_cancel"));
        d.h.b.o.c(r12, "getString(...)");
    L7:
        OAlertDialog r18 = (OAlertDialog) ZeusTransformUtils.preCheckCast(com.obric.oui.dialog.v2.alert.a.a(com.obric.oui.dialog.v2.alert.a.a(new com.obric.oui.dialog.v2.alert.a(r16).b(false), (CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.aiagent.plugin"), false, 2, null).a(r17).a(r13), (CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.aiagent.plugin"), r4, null, 4, null).b((CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.aiagent.plugin"), $$Lambda$p$m3oaYtcwQCaCj0pXR2WcuvxDr4g.INSTANCE).g(), OAlertDialog.class, "com.obric.aiagent.plugin");
        r18.show();
        if (r14 == false) goto L13;
        TextView r19 = r18.getMessageView();
        if (r19 == null) goto L13;
        r19.setMovementMethod(LinkMovementMethod.getInstance());
    L13:
        return (Dialog) ZeusTransformUtils.preCheckCast(r18, Dialog.class, "com.obric.aiagent.plugin");
    }

    private static final x a(DialogInterface r1, int r2) {
        DialogInterface r3 = (DialogInterface) ZeusTransformUtils.wrapperContextForParams(r1, DialogInterface.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "dialog");
        r3.dismiss();
        return x.f38692a;
    }

    public static final Dialog a(Context r9, String r10, String r11, String r12, String r13, int r14, DialogInterface.OnClickListener r15) {
        Context r16 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        DialogInterface.OnClickListener r4 = (DialogInterface.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r15, DialogInterface.OnClickListener.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r16, "context");
        d.h.b.o.e(r10, "shortTitle");
        d.h.b.o.e(r11, "mediumMessage");
        d.h.b.o.e(r12, "positionString");
        d.h.b.o.e(r13, "negativeString");
        d.h.b.o.e(r4, "positiveListener");
        com.obric.oui.dialog.v2.alert.a r17 = new com.obric.oui.dialog.v2.alert.a(r16);
        r17.b(false);
        TextView r8 = null;
        com.obric.oui.dialog.v2.alert.a.a(r17, (CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.aiagent.plugin"), false, 2, null);
        r17.a((CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.aiagent.plugin"));
        r17.a(false);
        com.obric.oui.dialog.v2.alert.a.a(r17, (CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.aiagent.plugin"), r4, null, 4, null);
        r17.b((CharSequence) ZeusTransformUtils.preCheckCast(r13, CharSequence.class, "com.obric.aiagent.plugin"), $$Lambda$p$DkDLPHAFKlbHquNs9SI24Jgv6dc.INSTANCE);
        OAlertDialog r18 = (OAlertDialog) ZeusTransformUtils.preCheckCast(r17.g(), OAlertDialog.class, "com.obric.aiagent.plugin");
        r18.show();
        View r19 = r18.getPositiveButton();
        if (ZeusTransformUtils.instanceOf(r19, TextView.class) == false) goto L5;
        r8 = (TextView) ZeusTransformUtils.preCheckCast(r19, TextView.class, "com.obric.aiagent.plugin");
    L5:
        if (r8 == null) goto L8;
        r8.setTextColor(r14);
    L8:
        return (Dialog) ZeusTransformUtils.preCheckCast(r18, Dialog.class, "com.obric.aiagent.plugin");
    }

    private static final x b(DialogInterface r1, int r2) {
        DialogInterface r3 = (DialogInterface) ZeusTransformUtils.wrapperContextForParams(r1, DialogInterface.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "dialog");
        r3.dismiss();
        return x.f38692a;
    }

    public static final int[] a(View r8) {
        d.h.b.o.e(r8, "anchorView");
        int[] r1 = new int[2];
        r8.getLocationInWindow(r1);
        r1[0] = r1[0] + (r8.getWidth() - d.i.a.a(TypedValue.applyDimension(1, 8, Resources.getSystem().getDisplayMetrics())));
        r1[1] = r1[1] + (r8.getHeight() / 2);
        return r1;
    }

    public static final <T> void a(Activity r2, Dialog r3, View r4, final i<T> r5, final j<T> r6, d.h.a.m<? super j<T>, ? super Integer, x> r7) {
        Activity r8 = (Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.aiagent.plugin");
        final d.h.a.m r9 = (d.h.a.m) ZeusTransformUtils.wrapperContextForParams(r7, d.h.a.m.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "anchorView");
        d.h.b.o.e(r5, "config");
        d.h.b.o.e(r9, "onItemSelected");
        if (r8 != null) goto L5;
        return;
    L5:
        com.obric.autoaction.app.launcherpage.module.a.h.f24077a.a(r8, r3, a(r4), new $$Lambda$p$vcqrnh3TYCVjpZPBx7CNzBYPx0(r5, r6, r9));
    }

    private static final x a(final i r18, j r19, d.h.a.m r20, OPopoverEntranceMenuView.a r21, d.h.a.a r22) {
        final d.h.a.m r0 = (d.h.a.m) ZeusTransformUtils.wrapperContextForParams(r20, d.h.a.m.class, "com.obric.aiagent.plugin");
        final d.h.a.a r2 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r22, d.h.a.a.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r21, "$this$showPopup");
        d.h.b.o.e(r2, "dismiss");
        r21.b();
        Iterator r3 = ((Iterable) ZeusTransformUtils.preCheckCast(r18.a(), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L4:
        if (r3.hasNext() == false) goto L11;
        final j r4 = (j) ZeusTransformUtils.preCheckCast(r3.next(), j.class, "com.obric.aiagent.plugin");
        CharSequence r8 = (CharSequence) ZeusTransformUtils.preCheckCast(r4.a(), CharSequence.class, "com.obric.aiagent.plugin");
        CharSequence r9 = (CharSequence) ZeusTransformUtils.preCheckCast(r4.d(), CharSequence.class, "com.obric.aiagent.plugin");
        if (r19 == null) goto L8;
        Object r12 = r19.c();
    L9:
        OPopoverEntranceMenuView.a.a(r21, null, null, null, r8, r9, false, false, d.h.b.o.a(r12, r4.c()), new $$Lambda$p$bkpmQHs1aHDhm7WL9JlOhR4YRa4(r0, r4, r18, r2), 103, null);
        goto L4
    L8:
        r12 = null;
        goto L9
    L11:
        return x.f38692a;
    }

    private static final x a(d.h.a.m r1, j r2, i r3, d.h.a.a r4, View r5, int r6) {
        d.h.a.m r7 = (d.h.a.m) ZeusTransformUtils.wrapperContextForParams(r1, d.h.a.m.class, "com.obric.aiagent.plugin");
        d.h.a.a r8 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.a.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "<unused var>");
        r7.invoke(r2, Integer.valueOf(r3.a().indexOf(r2)));
        r8.invoke();
        return x.f38692a;
    }

    public static /* synthetic */ Drawable a(int r1, Context r2, Resources.Theme r3, int r4, Object r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        if ((r4 & 2) == 0) goto L6;
        r3 = null;
    L6:
        return a(r1, r6, r3);
    }

    public static final Drawable a(int r2, Context r3, Resources.Theme r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "context");
        return androidx.core.content.b.h.a(ZeusTransformUtils.getResources(r5, "com.obric.aiagent.plugin"), r2, r4);
    }

    public static /* synthetic */ String a(int r0, Resources.Theme r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = null;
    L6:
        return a(r0, r1);
    }

    public static final String a(int r3, Resources.Theme r4) {
        String r5 = ZeusTransformUtils.getResources((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin").getString(r3, new Object[]{r4});
        d.h.b.o.c(r5, "getString(...)");
        return r5;
    }

    public static final String a(int r3, Object... r4) {
        d.h.b.o.e(r4, "formatArgs");
        String r5 = ZeusTransformUtils.getResources((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin").getString(r3, Arrays.copyOf(r4, r4.length));
        d.h.b.o.c(r5, "getString(...)");
        return r5;
    }

    public static /* synthetic */ int b(int r1, Context r2, Resources.Theme r3, int r4, Object r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        if ((r4 & 2) == 0) goto L6;
        r3 = null;
    L6:
        return b(r1, r6, r3);
    }

    public static final int b(int r2, Context r3, Resources.Theme r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "context");
        return androidx.core.content.b.h.b(ZeusTransformUtils.getResources(r5, "com.obric.aiagent.plugin"), r2, r4);
    }

    public static /* synthetic */ void a(View r1, int r2, int r3, int r4, int r5, int r6, Object r7) {
        if ((r6 & 1) == 0) goto L6;
        r2 = -1;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = -1;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r4 = -1;
    L12:
        if ((r6 & 8) == 0) goto L14;
        r5 = -1;
    L14:
        a(r1, r2, r3, r4, r5);
    }

    public static final void a(View r3, int r4, int r5, int r6, int r7) {
        if (r3 != null) goto L4;
        return;
    L4:
        ViewGroup.LayoutParams r0 = r3.getLayoutParams();
        if (ZeusTransformUtils.instanceOf(r0, ViewGroup.MarginLayoutParams.class) == false) goto L7;
        ViewGroup.MarginLayoutParams r1 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r0, ViewGroup.MarginLayoutParams.class, "com.obric.aiagent.plugin");
    L8:
        if (r1 != null) goto L10;
        return;
    L10:
        if (r4 < 0) goto L12;
        r1.leftMargin = r4;
    L12:
        if (r5 < 0) goto L14;
        r1.topMargin = r5;
    L14:
        if (r6 < 0) goto L16;
        r1.rightMargin = r6;
    L16:
        if (r7 < 0) goto L18;
        r1.bottomMargin = r7;
    L18:
        r3.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r1, ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
        return;
    L7:
        r1 = null;
        goto L8
    }

    public static final void a(View r3, d.h.a.m<? super View, ? super int[], Boolean> r4) {
        d.h.a.m r5 = (d.h.a.m) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.m.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "<this>");
        d.h.b.o.e(r5, "onLongClickListener");
        com.obric.oui.popover.a.f35994a.a(r3, (com.obric.oui.popover.d) ZeusTransformUtils.preCheckCast(new b(r5, r3), com.obric.oui.popover.d.class, "com.obric.aiagent.plugin"));
    }

    public static final void b(final View r1) {
        d.h.b.o.e(r1, "<this>");
        r1.setOnFocusChangeListener(new $$Lambda$p$1NzXIVfsKsXUy6P3_pdhKQ0pVVg(r1));
    }

    private static final void a(View r2, View r3, boolean r4) {
        if (r4 == false) goto L5;
        d.h.b.o.a(r3);
        Context r5 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r2.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.c(r5, "getContext(...)");
        a(r3, r5);
        return;
    L5:
        d.h.b.o.a(r3);
        Context r6 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r2.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.c(r6, "getContext(...)");
        b(r3, r6);
    }

    private static final void a(View r2, Context r3) {
        Object r4 = ((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin")).getSystemService("input_method");
        if (ZeusTransformUtils.instanceOf(r4, InputMethodManager.class) == false) goto L5;
        InputMethodManager r5 = (InputMethodManager) ZeusTransformUtils.preCheckCast(r4, InputMethodManager.class, "com.obric.aiagent.plugin");
    L6:
        if (r5 == null) goto L9;
        r5.showSoftInput(r2, 0);
        return;
    L9:
        return;
    L5:
        r5 = null;
        goto L6
    }

    private static final void b(View r2, Context r3) {
        Object r4 = ((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin")).getSystemService("input_method");
        if (ZeusTransformUtils.instanceOf(r4, InputMethodManager.class) == false) goto L5;
        InputMethodManager r5 = (InputMethodManager) ZeusTransformUtils.preCheckCast(r4, InputMethodManager.class, "com.obric.aiagent.plugin");
    L6:
        if (r5 == null) goto L9;
        r5.hideSoftInputFromWindow(r2.getWindowToken(), 0);
        return;
    L9:
        return;
    L5:
        r5 = null;
        goto L6
    }

    public static /* synthetic */ int a(OFloatingTitleBar r0, boolean r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = false;
    L6:
        return a(r0, r1);
    }

    public static final int a(OFloatingTitleBar r4, boolean r5) {
        d.h.b.o.e(r4, "<this>");
        View r0 = r4.findViewById(ZeusTransformUtils.mapRes(R.id.title_bar_container, DbHelper.COL_ID, "title_bar_container"));
        ViewGroup.LayoutParams r1 = r0.getLayoutParams();
        if (ZeusTransformUtils.instanceOf(r1, ViewGroup.MarginLayoutParams.class) == false) goto L5;
        ViewGroup.MarginLayoutParams r2 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r1, ViewGroup.MarginLayoutParams.class, "com.obric.aiagent.plugin");
    L6:
        int r3 = 0;
        if (r2 == null) goto L9;
        int r6 = r2.topMargin;
    L10:
        if (r6 <= 0) goto L12;
        r3 = r6;
    L23:
        return r0.getMinimumHeight() + r3;
    L12:
        if (r5 == true) goto L23;
        al r7 = ViewCompat.w((View) ZeusTransformUtils.preCheckCast(r4, View.class, "com.obric.aiagent.plugin"));
        if (r7 == null) goto L19;
        androidx.core.graphics.g r8 = r7.a(al.m.a());
        if (r8 == null) goto L19;
        r3 = r8.f1211c;
    L19:
        if (r3 > 0) goto L23;
        r3 = d((View) ZeusTransformUtils.preCheckCast(r4, View.class, "com.obric.aiagent.plugin"));
        goto L23
    L9:
        r6 = 0;
        goto L10
    L5:
        r2 = null;
        goto L6
    }

    private static final int d(View r6) {
        int r2 = ZeusTransformUtils.getIdentifier(ZeusTransformUtils.getResources(r6, "com.obric.aiagent.plugin"), "status_bar_height", "dimen", "android", "com.obric.aiagent.plugin");     // Catch: Exception -> L8
        if (r2 <= 0) goto L11;
        return ZeusTransformUtils.getResources(r6, "com.obric.aiagent.plugin").getDimensionPixelSize(r2);
    L11:
        return 0;
    L12:
        return 0;
    }

    public static final void a(final View r3, final OFloatingTitleBar r4, d.h.a.b<? super Integer, x> r5) {
        final d.h.a.b r6 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r5, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "<this>");
        d.h.b.o.e(r4, "titleBar");
        d.h.b.o.e(r6, "onUpdate");
        r6.invoke(Integer.valueOf(a(r4, false, 1, null)));
        r3.setOnApplyWindowInsetsListener(new $$Lambda$p$rxm7pesnhVve2PAU7oySDhEk6D4(r3, r6, r4));
    }

    private static final WindowInsets a(View r2, d.h.a.b r3, final OFloatingTitleBar r4, View r5, WindowInsets r6) {
        final d.h.a.b r7 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "<unused var>");
        d.h.b.o.e(r6, "insets");
        r2.post(new $$Lambda$p$nqjG1i8j46T7KuVitcaeYGuUHDo(r7, r4));
        return r6;
    }

    private static final void a(d.h.a.b r3, OFloatingTitleBar r4) {
        ((d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.b.class, "com.obric.aiagent.plugin")).invoke(Integer.valueOf(a(r4, false, 1, null)));
    }

    public static /* synthetic */ void a(View r0, OFloatingTitleBar r1, boolean r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = false;
    L5:
        a(r0, r1, r2);
    }

    public static final void a(final View r4, final OFloatingTitleBar r5, final boolean r6) {
        d.h.b.o.e(r4, "<this>");
        d.h.b.o.e(r5, "titleBar");
        int r0 = a(r5, r6);
        r4.setPadding(r4.getPaddingLeft(), r0, r4.getPaddingRight(), r4.getPaddingBottom());
        r4.setOnApplyWindowInsetsListener(new $$Lambda$p$g2UjO5llBexXNcgbJ31eQI9Whw(r4, r5, r6));
    }

    private static final WindowInsets a(final View r1, final OFloatingTitleBar r2, final boolean r3, View r4, WindowInsets r5) {
        d.h.b.o.e(r4, "<unused var>");
        d.h.b.o.e(r5, "insets");
        r1.post(new $$Lambda$p$eaSFA9FOELvtnVVrQWfSptiSWUI(r1, r2, r3));
        return r5;
    }

    private static final void b(View r2, OFloatingTitleBar r3, boolean r4) {
        int r5 = a(r3, r4);
        r2.setPadding(r2.getPaddingLeft(), r5, r2.getPaddingRight(), r2.getPaddingBottom());
    }

    public static /* synthetic */ void a(View r1, OFloatingTitleBar r2, int r3, boolean r4, int r5, Object r6) {
        if ((r5 & 2) == 0) goto L6;
        r3 = 0;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = false;
    L8:
        a(r1, r2, r3, r4);
    }

    public static final void a(final View r8, final OFloatingTitleBar r9, final int r10, final boolean r11) {
        d.h.b.o.e(r8, "<this>");
        d.h.b.o.e(r9, "titleBar");
        a(r8, 0, a(r9, r11) + r10, 0, 0, 13, null);
        r8.setOnApplyWindowInsetsListener(new $$Lambda$p$z46FTe8i_FAAsUDt_MraMb9slBo(r8, r9, r11, r10));
    }

    private static final WindowInsets a(final View r1, final OFloatingTitleBar r2, final boolean r3, final int r4, View r5, WindowInsets r6) {
        d.h.b.o.e(r5, "<unused var>");
        d.h.b.o.e(r6, "insets");
        r1.post(new $$Lambda$p$9RwT9694T6W9KP7mcVjAlltmUg(r1, r2, r3, r4));
        return r6;
    }

    private static final void a(View r7, OFloatingTitleBar r8, boolean r9, int r10) {
        a(r7, 0, a(r8, r9) + r10, 0, 0, 13, null);
    }

    public static final void c(final View r3) {
        d.h.b.o.e(r3, "<this>");
        if (r3.hasWindowFocus() == false) goto L5;
        r3.requestFocus();
        return;
    L5:
        r3.getViewTreeObserver().addOnWindowFocusChangeListener((ViewTreeObserver.OnWindowFocusChangeListener) ZeusTransformUtils.preCheckCast(new ViewExtKt$requestFocusOpt$1(r3), ViewTreeObserver.OnWindowFocusChangeListener.class, "com.obric.aiagent.plugin"));
    }

    public static final void a(com.obric.oui.sheet.v2.a r2, View r3) {
        com.obric.oui.sheet.v2.a r4 = (com.obric.oui.sheet.v2.a) ZeusTransformUtils.wrapperContextForParams(r2, com.obric.oui.sheet.v2.a.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "<this>");
        r4.setBodyView(r3);
        if (r3 == null) goto L8;
        ViewGroup.LayoutParams r5 = r3.getLayoutParams();
        if (r5 == null) goto L9;
        r5.width = -1;
        return;
    L9:
        return;
    }

    public static final void a(OInputLayout r2, int r3, d.h.a.b<? super Boolean, x> r4) {
        d.h.a.b r5 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r2, "<this>");
        r2.setLimitCount(r3);
        r2.showLimit(true);
        r2.setAutoChangeWithLimit(true);
        if (r5 == null) goto L6;
        r2.setLimitStateChangeListener((OInputLayout.b) ZeusTransformUtils.preCheckCast(new a(r5), OInputLayout.b.class, "com.obric.aiagent.plugin"));
        return;
    }

    public static /* synthetic */ void a(OCardListItem r0, int r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = 48;
    L5:
        a(r0, r1);
    }

    public static final void a(OCardListItem r2, int r3) {
        d.h.b.o.e(r2, "<this>");
        r2.getContentContainer().setMinimumHeight(d.i.a.a(TypedValue.applyDimension(1, r3, Resources.getSystem().getDisplayMetrics())));
    }

    public static /* synthetic */ void a(Activity r1, boolean r2, int r3, Object r4) {
        Activity r5 = (Activity) ZeusTransformUtils.wrapperContextForParams(r1, Activity.class, "com.obric.aiagent.plugin");
        if ((r3 & 1) == 0) goto L5;
        r2 = !a((Context) ZeusTransformUtils.preCheckCast(r5, Context.class, "com.obric.aiagent.plugin"));
    L5:
        a(r5, r2);
    }

    public static final void a(Activity r3, boolean r4) {
        Activity r5 = (Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "<this>");
        ai.a(ZeusTransformUtils.getWindow(r5, "com.obric.aiagent.plugin"), false);
        if (Build.VERSION.SDK_INT < 29) goto L5;
        ZeusTransformUtils.getWindow(r5, "com.obric.aiagent.plugin").setNavigationBarContrastEnforced(true);
    L5:
        ai.a(ZeusTransformUtils.getWindow(r5, "com.obric.aiagent.plugin"), ZeusTransformUtils.getWindow(r5, "com.obric.aiagent.plugin").getDecorView()).b(r4);
    }

    private static final boolean a(Context r2) {
        if ((ZeusTransformUtils.getResources((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin").getConfiguration().uiMode & 48) != 32) goto L5;
        return true;
    L5:
        return false;
    }

    public static /* synthetic */ void a(View r0, int r1, boolean r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = 16;
    L6:
        if ((r3 & 2) == 0) goto L8;
        r2 = false;
    L8:
        a(r0, r1, r2);
    }

    public static final void a(View r7, int r8, boolean r9) {
        d.h.b.o.e(r7, "<this>");
        final int r2 = r7.getPaddingLeft();
        final int r3 = r7.getPaddingTop();
        final int r4 = r7.getPaddingRight();
        if (r9 == false) goto L5;
        int r10 = 0;
    L6:
        final int r5 = r10;
        final int r6 = d.i.a.a(TypedValue.applyDimension(1, r8, Resources.getSystem().getDisplayMetrics()));
        ViewCompat.a(r7, new $$Lambda$p$KeHgxUDTm9_x9iDrLgmrkrYYle8(r2, r3, r4, r5, r6));
        ViewCompat.u(r7);
        return;
    L5:
        r10 = r7.getPaddingBottom();
        goto L6
    }

    private static final al a(int r3, int r4, int r5, int r6, int r7, View r8, al r9) {
        d.h.b.o.e(r8, "view");
        d.h.b.o.e(r9, "insets");
        androidx.core.graphics.g r0 = r9.a(al.m.b());
        d.h.b.o.c(r0, "getInsets(...)");
        androidx.core.graphics.g r2 = r9.a(al.m.e());
        d.h.b.o.c(r2, "getInsets(...)");
        r8.setPadding(r3, r4, r5, (r6 + Math.max(r0.f1213e, r2.f1213e)) + r7);
        return r9;
    }
}
