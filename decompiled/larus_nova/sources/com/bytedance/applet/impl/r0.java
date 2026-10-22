package com.bytedance.applet.impl;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.ai.bridge.core.adapter.XBridge3ToAIBridgeAdapter;
import com.bytedance.ai.bridge.service.ActionSheetBuilder;
import com.bytedance.ai.bridge.service.ActionSheetBuilderAction;
import com.bytedance.ai.bridge.service.DialogBuilder;
import com.bytedance.ai.bridge.service.IHostStyleUIDepend;
import com.bytedance.ai.bridge.service.PageTitleBar;
import com.bytedance.ai.bridge.service.ShowActionSheetListener;
import com.bytedance.ai.bridge.service.ToastBuilder;
import com.bytedance.applet.impl.dialog.AppletInputDialog;
import com.bytedance.applet.impl.dialog.AppletInputDialogCallbackStore;
import com.bytedance.sdk.xbridge.cn.runtime.depend.XBaseRuntime;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.dialog.CommonActionSheetDialog;
import com.larus.common_ui.dialog.CommonDialog;
import com.larus.common_ui.dialog.CommonLoadDialogFragment;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class r0 implements IHostStyleUIDepend {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.sdk.xbridge.cn.runtime.depend.IHostStyleUIDepend f192000a;

    public static final class a {
    }

    public static final class b implements com.larus.common_ui.dialog.p0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DialogBuilder f192001a;

        @Override // com.larus.common_ui.dialog.p0
        public final void confirm() {
            DialogInterface.OnClickListener r100 = this.f192001a.getPositiveClickListener();
            if (r100 == null) goto L6;
            r100.onClick(null, 0);
            return;
        }

        public b(DialogBuilder r100) {
            this.f192001a = r100;
        }
    }

    public static final class c implements com.larus.common_ui.dialog.u {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DialogBuilder f192002a;

        @Override // com.larus.common_ui.dialog.u
        public final void cancel() {
            DialogInterface.OnClickListener r100 = this.f192002a.getNegativeClickListener();
            if (r100 == null) goto L6;
            r100.onClick(null, 1);
            return;
        }

        public c(DialogBuilder r100) {
            this.f192002a = r100;
        }
    }

    public static final class d implements com.larus.common_ui.dialog.l1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DialogBuilder f192003a;

        @Override // com.larus.common_ui.dialog.l1
        public final void a() {
            DialogInterface.OnCancelListener r100 = this.f192003a.getCancelOnTouchOutsideListener();
            if (r100 == null) goto L6;
            r100.onCancel(null);
            return;
        }

        public d(DialogBuilder r100) {
            this.f192003a = r100;
        }
    }

    static {
    }

    @Override // com.bytedance.ai.bridge.service.IHostStyleUIDepend
    public final void setPageNaviStyle(e3.a r100, Activity r101, PageTitleBar r102) {
    }

    public r0() {
        XBaseRuntime.f270095a.getClass();
        this.f192000a = XBaseRuntime.f270101g;
    }

    public static boolean a(FragmentActivity r100) {
        if (r100.isFinishing() == false) goto L5;
    L7:
        return false;
    L5:
        if (r100.isDestroyed() == true) goto L7;
        return true;
    }

    @Override // com.bytedance.ai.bridge.service.IHostStyleUIDepend
    public final Boolean hideLoading(e3.a r100) {
        FragmentActivity r101 = null;
        if (r100 == null) goto L5;
        XBridge3ToAIBridgeAdapter.a r102 = new XBridge3ToAIBridgeAdapter.a(r100);
    L6:
        if (r102 == null) goto L8;
        Activity r103 = r102.getOwnerActivity();
    L10:
        if ((r103 instanceof FragmentActivity) == false) goto L12;
        FragmentActivity r104 = (FragmentActivity) r103;
    L13:
        if (r104 != null) goto L30;
        if (r100 == null) goto L16;
        Activity r105 = r100.getOwnerActivity();
    L18:
        if ((r105 instanceof FragmentActivity) == false) goto L20;
        r104 = (FragmentActivity) r105;
    L21:
        if (r104 != null) goto L30;
        Activity r106 = AppHost.f326268a.a().getCurrentActivity();
        if ((r106 instanceof FragmentActivity) == false) goto L25;
        r101 = (FragmentActivity) r106;
    L25:
        if (r101 == null) goto L27;
        r104 = r101;
        goto L30
    L27:
        return Boolean.FALSE;
    L20:
        r104 = null;
        goto L21
    L16:
        r105 = null;
    L30:
        if (a(r104) == false) goto L44;
        if (r104.getSupportFragmentManager().isStateSaved() == true) goto L44;
        Result.Companion r107 = Result.Companion;     // Catch: Throwable -> L39
        Fragment r108 = r104.getSupportFragmentManager().findFragmentByTag("AppletHostLoadingDialog");     // Catch: Throwable -> L39
        if (r108 == null) goto L37;
        r104.getSupportFragmentManager().beginTransaction().remove(r108).commitAllowingStateLoss();     // Catch: Throwable -> L39
    L37:
        Object r109 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L39
    L42:
        return Boolean.valueOf(Result.m9456isSuccessimpl(r109));
    L39:
        th = move-exception;
        Result.Companion r110 = Result.Companion;
        r109 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L44:
        return Boolean.FALSE;
    L12:
        r104 = null;
        goto L13
    L8:
        r103 = null;
        goto L10
    L5:
        r102 = null;
        goto L6
    }

    @Override // com.bytedance.ai.bridge.service.IHostStyleUIDepend
    public final Boolean hideToast(e3.a r100) {
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L4
        t19.s.f544207a.a();     // Catch: Throwable -> L4
        Object r102 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L4
    L7:
        return Boolean.valueOf(Result.m9456isSuccessimpl(r102));
    L4:
        th = move-exception;
        Result.Companion r103 = Result.Companion;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v7, types: [com.bytedance.applet.impl.n0, java.lang.Object] */
    @Override // com.bytedance.ai.bridge.service.IHostStyleUIDepend
    public final Boolean showDialog(DialogBuilder r110) {
        Intrinsics.checkNotNullParameter(r110, "dialogBuilder");
        Context r100 = r110.getContext();
    L3:
        if (r100 == null) goto L10;
        if ((r100 instanceof FragmentActivity) == true) goto L6;
        if ((r100 instanceof ContextWrapper) == false) goto L10;
        r100 = ((ContextWrapper) r100).getBaseContext();
        goto L3
    L6:
        FragmentActivity r101 = (FragmentActivity) r100;
    L11:
        if (r101 != null) goto L20;
        Activity r102 = AppHost.f326268a.a().getCurrentActivity();
        if ((r102 instanceof FragmentActivity) == false) goto L15;
        r101 = (FragmentActivity) r102;
    L16:
        if (r101 != null) goto L20;
        return Boolean.FALSE;
    L15:
        r101 = null;
    L20:
        if (a(r101) == false) goto L80;
        if (r101.getSupportFragmentManager().isStateSaved() == true) goto L80;
        boolean r103 = false;
        if (r110.getEditable() == false) goto L47;
        final Function1<String, Unit> r104 = r110.getPositiveClickListenerWithInput();
        final DialogInterface.OnClickListener r105 = r110.getPositiveClickListener();
        final DialogInterface.OnClickListener r106 = r110.getNegativeClickListener();
        if (com.larus.utils.o0.d(r110.getNegativeBtnText()) == false) goto L30;
        if (r106 == null) goto L30;
        r103 = true;
    L30:
        int r107 = AppletInputDialog.f191899e;
        String r108 = r110.getTitle();
        String r111 = r110.getMessage();
        String r112 = r110.getPlaceholderText();
        String r113 = r110.getPositiveBtnText();
        Integer r114 = r110.getPositiveBtnTextColor();
        String r115 = r110.getNegativeBtnText();
        Integer r116 = r110.getNegativeBtnTextColor();
        boolean r109 = r110.getCancelOnTouchOutside();
        ?? r117 = new n0(r104, r105);
        if (r103 == false) goto L33;
        o0 r118 = new o0(r106);
    L34:
        DialogInterface.OnCancelListener r119 = r110.getCancelOnTouchOutsideListener();
        Intrinsics.checkNotNullParameter(r101, "activity");
        Intrinsics.checkNotNullParameter(r117, "onConfirm");
        String r120 = UUID.randomUUID().toString();
        FragmentActivity r121 = r101;
        ((AppletInputDialogCallbackStore) new ViewModelProvider(r101).get(AppletInputDialogCallbackStore.class)).register(r120, new AppletInputDialogCallbackStore.a(r117, r118, r119));
        AppletInputDialog r122 = new AppletInputDialog();
        Bundle r123 = new Bundle();
        r123.putString("request_id", r120);
        r123.putCharSequence("title", r108);
        r123.putCharSequence("message", r111);
        r123.putCharSequence(GXTemplateKey.GAIAX_PLACEHOLDER, r112);
        r123.putString("confirm_text", r113);
        if (r114 == null) goto L37;
        r123.putInt("confirm_text_color", r114.intValue());
    L37:
        r123.putString("cancel_text", r115);
        if (r116 == null) goto L40;
        r123.putInt("cancel_text_color", r116.intValue());
    L40:
        r123.putBoolean("show_cancel", r103);
        r123.putBoolean("canceled_on_touch_outside", r109);
        r122.setArguments(r123);
        FragmentManager r124 = r121.getSupportFragmentManager();
        LandscapeRestrictionOperation r125 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r122, "AppletHostInputDialog", r125);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r124, r122, r125) == true) goto L46;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L81
    L44:
        r122.show(r124, "AppletHostInputDialog");
    L46:
        return Boolean.TRUE;
    L33:
        r118 = 0;
        goto L34
    L47:
        FragmentActivity r126 = r101;
        CommonDialog.a r127 = new CommonDialog.a();
        String r128 = r110.getTitle();
        String r129 = "";
        if (r128 != null) goto L50;
        r128 = "";
    L50:
        Intrinsics.checkNotNullParameter(r128, "title");
        r127.f327172a = r128;
        String r130 = r110.getMessage();
        if (r130 == null) goto L54;
        r129 = r130;
    L54:
        Intrinsics.checkNotNullParameter(r129, "message");
        r127.f327180i = r129;
        CommonDialog.a.f(r127, new b(r110), r110.getPositiveBtnText(), false, 12);
        Integer r131 = r110.getPositiveBtnTextColor();
        if (r131 == null) goto L58;
        r127.f327188q = r131.intValue();
    L58:
        if (com.larus.utils.o0.d(r110.getNegativeBtnText()) == true) goto L60;
    L64:
        r127.f327197z = r110.getCancelOnTouchOutside();
        d r132 = new d(r110);
        Intrinsics.checkNotNullParameter(r132, "listener");
        r127.f327193v = r132;
        String r133 = r110.getMessage();
        if (r133 != null) goto L67;
    L68:
        r103 = true;
    L69:
        if (r103 == false) goto L71;
        CommonDialog r134 = r127.c();
    L72:
        FragmentManager r135 = r126.getSupportFragmentManager();
        LandscapeRestrictionOperation r136 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r134, null, r136);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r135, r134, r136) == true) goto L78;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L82
    L76:
        r134.show(r135, null);
    L78:
        return Boolean.TRUE;
    L71:
        r134 = r127.a();
        goto L72
    L67:
        if (r133.length() != 0) goto L69;
    L60:
        if (r110.getNegativeClickListener() == null) goto L64;
        CommonDialog.a.e(r127, new c(r110), r110.getNegativeBtnText(), 4);
        Integer r137 = r110.getNegativeBtnTextColor();
        if (r137 == null) goto L64;
        r127.f327189r = r137.intValue();
    L80:
        return Boolean.FALSE;
    L10:
        r101 = null;
        goto L11
    }

    @Override // com.bytedance.ai.bridge.service.IHostStyleUIDepend
    public final Boolean showLoading(e3.a r100) {
        FragmentActivity r101 = null;
        if (r100 == null) goto L5;
        XBridge3ToAIBridgeAdapter.a r102 = new XBridge3ToAIBridgeAdapter.a(r100);
    L6:
        if (r102 == null) goto L8;
        Activity r103 = r102.getOwnerActivity();
    L10:
        if ((r103 instanceof FragmentActivity) == false) goto L12;
        FragmentActivity r104 = (FragmentActivity) r103;
    L13:
        if (r104 != null) goto L30;
        if (r100 == null) goto L16;
        Activity r105 = r100.getOwnerActivity();
    L18:
        if ((r105 instanceof FragmentActivity) == false) goto L20;
        r104 = (FragmentActivity) r105;
    L21:
        if (r104 != null) goto L30;
        Activity r106 = AppHost.f326268a.a().getCurrentActivity();
        if ((r106 instanceof FragmentActivity) == false) goto L25;
        r101 = (FragmentActivity) r106;
    L25:
        if (r101 == null) goto L27;
        r104 = r101;
        goto L30
    L27:
        return Boolean.FALSE;
    L20:
        r104 = null;
        goto L21
    L16:
        r105 = null;
    L30:
        if (a(r104) == false) goto L49;
        if (r104.getSupportFragmentManager().isStateSaved() == true) goto L49;
        Result.Companion r107 = Result.Companion;     // Catch: Throwable -> L44
        Fragment r108 = r104.getSupportFragmentManager().findFragmentByTag("AppletHostLoadingDialog");     // Catch: Throwable -> L44
        if (r108 == null) goto L37;
        r104.getSupportFragmentManager().beginTransaction().remove(r108).commitAllowingStateLoss();     // Catch: Throwable -> L44
    L37:
        int r109 = CommonLoadDialogFragment.f327234e;     // Catch: Throwable -> L44
        Bundle r110 = new Bundle();     // Catch: Throwable -> L44
        r110.putFloat("key_dim", 0.2f);     // Catch: Throwable -> L44
        CommonLoadDialogFragment r111 = new CommonLoadDialogFragment();     // Catch: Throwable -> L44
        r111.setArguments(r110);     // Catch: Throwable -> L44
        FragmentManager r112 = r104.getSupportFragmentManager();     // Catch: Throwable -> L44
        LandscapeRestrictionOperation r113 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;     // Catch: Throwable -> L44
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r111, "AppletHostLoadingDialog", r113);     // Catch: Throwable -> L44
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r112, r111, r113) == false) goto L53;
    L42:
        Object r114 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L44
    L47:
        return Boolean.valueOf(Result.m9456isSuccessimpl(r114));
    L53:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L50 Throwable -> L44
    L41:
        r111.show(r112, "AppletHostLoadingDialog");     // Catch: Throwable -> L44
    L44:
        th = move-exception;
        Result.Companion r115 = Result.Companion;
        r114 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L49:
        return Boolean.FALSE;
    L12:
        r104 = null;
        goto L13
    L8:
        r103 = null;
        goto L10
    L5:
        r102 = null;
        goto L6
    }

    @Override // com.bytedance.ai.bridge.service.IHostStyleUIDepend
    public final Boolean showToast(ToastBuilder r110) {
        Intrinsics.checkNotNullParameter(r110, "toastBuilder");
        com.bytedance.sdk.xbridge.cn.runtime.depend.IHostStyleUIDepend r100 = this.f192000a;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.showToast(new com.bytedance.sdk.xbridge.cn.runtime.depend.ToastBuilder(r110.getContext(), r110.getMessage(), r110.getType(), r110.getDuration(), r110.getIcon(), null, 32, null));
    }

    /* JADX WARN: Type inference failed for: r8v0, types: [com.bytedance.applet.impl.p0] */
    @Override // com.bytedance.ai.bridge.service.IHostStyleUIDepend
    public final Boolean showActionSheet(ActionSheetBuilder r110, final ShowActionSheetListener r111) {
        Intrinsics.checkNotNullParameter(r110, "actionSheetBuilder");
        Intrinsics.checkNotNullParameter(r111, "showActionSheetListener");
        Context r100 = r110.getContext();
    L3:
        FragmentActivity r101 = null;
        if (r100 == null) goto L11;
        if ((r100 instanceof FragmentActivity) == true) goto L7;
        if ((r100 instanceof ContextWrapper) == false) goto L11;
        r100 = ((ContextWrapper) r100).getBaseContext();
        goto L3
    L7:
        FragmentActivity r102 = (FragmentActivity) r100;
    L12:
        if (r102 != null) goto L21;
        Activity r103 = AppHost.f326268a.a().getCurrentActivity();
        if ((r103 instanceof FragmentActivity) == false) goto L16;
        r101 = (FragmentActivity) r103;
    L16:
        if (r101 == null) goto L18;
        r102 = r101;
        goto L21
    L18:
        return Boolean.FALSE;
    L21:
        if (a(r102) == false) goto L45;
        if (r102.getSupportFragmentManager().isStateSaved() == true) goto L45;
        if (r110.getActions().isEmpty() == true) goto L45;
        List<ActionSheetBuilderAction> r104 = r110.getActions();
        ArrayList r105 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r104, 10));
        Iterator<T> r106 = r104.iterator();
        final int r107 = 0;
    L29:
        if (r106.hasNext() == false) goto L37;
        Object r108 = r106.next();
        int r109 = r107 + 1;
        if (r107 >= 0) goto L33;
        CollectionsKt.throwIndexOverflow();
    L33:
        String r112 = ((ActionSheetBuilderAction) r108).getTitle();
        if (r112 != null) goto L36;
        r112 = "";
    L36:
        r105.add(new CommonActionSheetDialog.b(r112, r110.getItemColor(), new p0(r111, r107)));
        r107 = r109;
        goto L29
    L37:
        int r113 = CommonActionSheetDialog.f327132j;
        FragmentManager r114 = r102.getSupportFragmentManager();
        String r115 = r110.getTitle();
        String r116 = r102.getString(R.string.cancel);
        Function0<Unit> r117 = new q0(r111);
        Intrinsics.checkNotNullParameter(r114, "fragmentManager");
        Intrinsics.checkNotNullParameter(r105, "items");
        CommonActionSheetDialog r118 = new CommonActionSheetDialog();
        r118.f327133d = r115;
        r118.f327134e = r105;
        r118.f327135f = r116;
        r118.f327136g = r117;
        LandscapeRestrictionOperation r119 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r118, "CommonActionSheetDialog", r119);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r114, r118, r119) == true) goto L43;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L46
    L41:
        r118.show(r114, "CommonActionSheetDialog");
    L43:
        return Boolean.TRUE;
    L45:
        return Boolean.FALSE;
    L11:
        r102 = null;
        goto L12
    }
}
