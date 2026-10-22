package com.stepos.ailauncher.task.detail;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.view.R5;
import com.stepos.ailauncher.task.R$id;
import com.stepos.ailauncher.task.R$layout;
import io.ktor.http.LinkHeader;
import kotlin.Metadata;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00182\u00020\u0001:\u0001\u0019B1\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\t\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u000f\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0011R\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0011R\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0011R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0017\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u001a"}, d2 = {"Lcom/stepos/ailauncher/task/detail/r;", "", "Lkotlin/Function0;", "LY8/t;", "onPreview", "onCode", "onDownload", "<init>", "(Lp9/a;Lp9/a;Lp9/a;)V", Const.INTENT_KEY_UMID, "()V", "Landroid/view/View;", LinkHeader.Parameters.Anchor, "", "codeSelected", "f", "(Landroid/view/View;Z)V", "Lp9/a;", "Landroid/widget/PopupWindow;", "popup", "Landroid/widget/PopupWindow;", "e", "()Z", "isShowing", "Companion", Const.INTENT_KEY_APIKEY, "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class r {
    private static final float MENU_CORNER_DP = 24.0f;
    private final InterfaceC5063a<Y8.t> onCode;
    private final InterfaceC5063a<Y8.t> onDownload;
    private final InterfaceC5063a<Y8.t> onPreview;
    private PopupWindow popup;

    public r(InterfaceC5063a<Y8.t> onPreview, InterfaceC5063a<Y8.t> onCode, InterfaceC5063a<Y8.t> onDownload) {
        kotlin.jvm.internal.p.i(onPreview, "onPreview");
        kotlin.jvm.internal.p.i(onCode, "onCode");
        kotlin.jvm.internal.p.i(onDownload, "onDownload");
        this.onPreview = onPreview;
        this.onCode = onCode;
        this.onDownload = onDownload;
    }

    public static final void g(r rVar, View view) {
        rVar.d();
        rVar.onPreview.invoke();
    }

    public static final void h(r rVar, View view) {
        rVar.d();
        rVar.onCode.invoke();
    }

    public static final void i(r rVar, View view) {
        rVar.d();
        rVar.onDownload.invoke();
    }

    public final void d() {
        PopupWindow popupWindow = this.popup;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
    }

    public final boolean e() {
        PopupWindow popupWindow = this.popup;
        return popupWindow != null && popupWindow.isShowing();
    }

    public final void f(View anchor, boolean codeSelected) {
        kotlin.jvm.internal.p.i(anchor, "anchor");
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(anchor.getContext());
        int i10 = R$layout.popup_artifact_more_menu;
        View rootView = anchor.getRootView();
        View viewInflate = layoutInflaterFrom.inflate(i10, rootView instanceof ViewGroup ? (ViewGroup) rootView : null, false);
        View viewFindViewById = viewInflate.findViewById(R$id.iv_menu_preview_check);
        kotlin.jvm.internal.p.h(viewFindViewById, "findViewById(...)");
        viewFindViewById.setVisibility(!codeSelected ? 0 : 8);
        View viewFindViewById2 = viewInflate.findViewById(R$id.iv_menu_code_check);
        kotlin.jvm.internal.p.h(viewFindViewById2, "findViewById(...)");
        viewFindViewById2.setVisibility(codeSelected ? 0 : 8);
        viewInflate.findViewById(R$id.item_menu_preview).setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.task.detail.o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                r.g(this.f28660a, view);
            }
        });
        viewInflate.findViewById(R$id.item_menu_code).setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.task.detail.p
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                r.h(this.f28662a, view);
            }
        });
        viewInflate.findViewById(R$id.item_menu_download).setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.task.detail.q
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                r.i(this.f28664a, view);
            }
        });
        float f10 = (-anchor.getHeight()) / anchor.getResources().getDisplayMetrics().density;
        kotlin.jvm.internal.p.f(viewInflate);
        this.popup = R5.i(anchor, viewInflate, 24.0f, f10, false, false, false, null, 240, null);
    }
}
