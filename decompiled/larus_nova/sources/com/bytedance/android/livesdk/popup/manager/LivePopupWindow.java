package com.bytedance.android.livesdk.popup.manager;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.PopupWindow;
import com.obric.assistant.interaction.impl.window.helpers.OverlaySource;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildPopupWindowBoundsAdapter;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001:\u0001\u000bB\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003B#\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u0002\u0010\n¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/popup/manager/LivePopupWindow;", "Landroid/widget/PopupWindow;", "<init>", "()V", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livecommonui_saasRelease"}, k = 1, mv = {1, 4, 3})
public class LivePopupWindow extends PopupWindow {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LivePopupWindowManager f156286a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f156287b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f156288c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f156289d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public c f156290e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public LivePopupInfo f156291f;

    public static final class a {
    }

    static {
    }

    public LivePopupWindow() {
        this(null, 0, 0, false);
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        LivePopupInfo r100 = this.f156291f;
        if (r100 == null) goto L6;
        r100.a(LivePopupInfo.State.DISMISSED);
        return;
    }

    public final void a() {
        PopupWindowLancet.handleDismissBeforeOrigin(this);
        super.dismiss();
    }

    public final void b(d r110) {
        if (r110 != null) goto L5;
        return;
    L5:
        if ((r110 instanceof b) == false) goto L11;
        b r111 = (b) r110;
        View r100 = r111.f156300a;
        int r101 = r111.f156301b;
        int r102 = r111.f156302c;
        int r112 = r111.f156303d;
        OverlaySource r103 = PopupWindowLancet.resolveSource(r100);
        if (PopupWindowLancet.rewriteShowAsDropDownIfNeeded(this, r100, r103) == true) goto L26;
        super.showAsDropDown(r100, r101, r102, r112);
        PopupWindowLancet.trackAfterShow(this, r103, r100);
        return;
    L26:
        return;
    L11:
        if ((r110 instanceof l) == false) goto L24;
        l r113 = (l) r110;
        View r104 = r113.f156311a;
        int r105 = r113.f156312b;
        int r106 = r113.f156313c;
        int r114 = r113.f156314d;
        if (PopupWindowLancet.hasSubWindowToken(r104) == false) goto L16;
        return;
    L16:
        if (LandscapeChildPopupWindowBoundsAdapter.isShowAtLocationBypassTarget(this) == false) goto L18;
        super.showAtLocation(r104, r105, r106, r114);
        return;
    L18:
        OverlaySource r107 = PopupWindowLancet.resolveSource(r104);
        if (PopupWindowLancet.rewriteDirectShowAtLocationIfNeeded(this, r104, r107, r105, r106, r114) == true) goto L28;
        super.showAtLocation(r104, r105, r106, r114);
        PopupWindowLancet.trackAfterShow(this, r107, r104);
        return;
    L28:
        return;
    }

    @Override // android.widget.PopupWindow
    public final void showAsDropDown(View r100) {
        Intrinsics.checkNotNullParameter(r100, "anchor");
        OverlaySource r101 = PopupWindowLancet.resolveSource(r100);
        if (PopupWindowLancet.rewriteShowAsDropDownIfNeeded(this, r100, r101) == true) goto L7;
        showAsDropDown(r100, 0, 0);
        PopupWindowLancet.trackAfterShow(this, r101, r100);
        return;
    }

    public LivePopupWindow(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102, 0);
        this.f156286a = (LivePopupWindowManager) LivePopupWindowManager.f156292d.getValue();
        this.f156287b = 1;
    }

    @Override // android.widget.PopupWindow
    public final void showAsDropDown(View r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "anchor");
        OverlaySource r103 = PopupWindowLancet.resolveSource(r100);
        if (PopupWindowLancet.rewriteShowAsDropDownIfNeeded(this, r100, r103) == true) goto L7;
        showAsDropDown(r100, r101, r102, 8388659);
        PopupWindowLancet.trackAfterShow(this, r103, r100);
        return;
    }

    public LivePopupWindow(View r100, int r101, int r102, boolean r103) {
        super(r100, r101, r102, r103);
        this.f156286a = (LivePopupWindowManager) LivePopupWindowManager.f156292d.getValue();
        this.f156287b = 1;
    }

    @Override // android.widget.PopupWindow
    public final void showAsDropDown(View r100, int r101, int r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, "anchor");
        b r104 = new b(r100, r101, r102, r103);
        this.f156291f = this.f156286a.a(this, r104, this.f156290e);
    }

    @Override // android.widget.PopupWindow
    public void showAtLocation(View r100, int r101, int r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        l r104 = new l(r100, r101, r102, r103);
        this.f156291f = this.f156286a.a(this, r104, this.f156290e);
    }
}
