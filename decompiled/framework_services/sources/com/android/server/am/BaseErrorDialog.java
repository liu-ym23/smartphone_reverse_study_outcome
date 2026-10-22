package com.android.server.am;

import android.R;
import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.util.Slog;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.view.WindowManager;
import android.widget.Button;
import com.obric.oui.framework.material.MaterialConfigCore;
import com.obric.oui.framework.material.MaterialTokenCore;
import com.obric.oui.framework.material.OMaterialHelperCore;

/* JADX INFO: loaded from: classes.dex */
public class BaseErrorDialog extends AlertDialog {
    private static final int DISABLE_BUTTONS = 1;
    private static final int ENABLE_BUTTONS = 0;
    private static final float MODAL_CORNER_RADIUS_DP = 36.0f;
    private static final String TAG = "BaseErrorDialog";
    private boolean mConsuming;
    private Handler mHandler;
    private BroadcastReceiver mReceiver;

    /* JADX INFO: renamed from: -$$Nest$fputmConsuming, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1389$$Nest$fputmConsuming(BaseErrorDialog r0, boolean r1) {
        r0.mConsuming = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$msetEnabled, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1390$$Nest$msetEnabled(BaseErrorDialog r0, boolean r1) {
        r0.setEnabled(r1);
    }

    public BaseErrorDialog(Context context) {
        super(context, R.style.Widget.Holo.GestureOverlayView);
        this.mConsuming = true;
        this.mHandler = new AnonymousClass2(this);
        context.assertRuntimeOverlayThemable();
        getWindow().setType(2003);
        getWindow().setFlags(131072, 131072);
        WindowManager.LayoutParams attrs = getWindow().getAttributes();
        attrs.setTitle("Error Dialog");
        getWindow().setAttributes(attrs);
    }

    @Override // android.app.Dialog
    public void onStart() {
        super.onStart();
        this.mHandler.sendEmptyMessage(1);
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(0), 1000);
        if (this.mReceiver != null) goto L6;
        this.mReceiver = new AnonymousClass1(this);
        getContext().registerReceiver(this.mReceiver, new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS"), 2);
        return;
    }

    @Override // android.app.Dialog
    protected void onStop() {
        super.onStop();
        if (this.mReceiver == null) goto L12;
        getContext().unregisterReceiver(this.mReceiver);     // Catch: IllegalArgumentException -> L6
    L8:
        this.mReceiver = null;
        return;
    L6:
        e = move-exception;
        Slog.e(TAG, "unregisterReceiver threw exception: " + e.getMessage());
        goto L8
    }

    protected final void applyObricModalMaterial(View customView, String dialogName) {
        Slog.i(TAG, "applyObricModalMaterial: start, dialog=" + dialogName);
        if (customView != null) goto L6;
        Slog.e(TAG, "applyObricModalMaterial: missing customView, dialog=" + dialogName);
        return;
    L6:
        View surfaceView = findMaterialSurface(customView);
        if (surfaceView != null) goto L11;
        Slog.e(TAG, "applyObricModalMaterial: missing surface, dialog=" + dialogName);
        return;
    L11:
        if (OMaterialHelperCore.isObricMaterialEnabled(getContext(), dialogName) == true) goto L25;
        return;
    L25:
        boolean isLight = OMaterialHelperCore.isLightMode(getContext());     // Catch: RuntimeException -> L19
        MaterialConfigCore[] materials = copyModalMaterials(isLight);     // Catch: RuntimeException -> L19
        if (materials == null) goto L21;
        if (materials.length == 0) goto L21;
        configureModalMaterialSurface(surfaceView);     // Catch: RuntimeException -> L19
        OMaterialHelperCore.setMaterials(surfaceView, 3, materials);     // Catch: RuntimeException -> L19
        surfaceView.invalidate();     // Catch: RuntimeException -> L19
        Slog.i(TAG, "applyObricModalMaterial: applied OUI_Bg_Modal material, dialog=" + dialogName + ", isLight=" + isLight);     // Catch: RuntimeException -> L19
        return;
    L21:
        Slog.w(TAG, "applyObricModalMaterial: missing OUI_Bg_Modal token, dialog=" + dialogName);     // Catch: RuntimeException -> L19
        return;
    L19:
        e = move-exception;
        Slog.w(TAG, "applyObricModalMaterial: material setup failed, dialog=" + dialogName, e);
    }

    private static View findMaterialSurface(View customView) {
        View parentPanel = customView.findViewById(R.id.scroll_exit_layout);
        if (parentPanel == null) goto L6;
        return parentPanel;
    L6:
        return customView;
    }

    private void configureModalMaterialSurface(View surfaceView) {
        GradientDrawable background = new GradientDrawable();
        background.setShape(0);
        background.setColor(0);
        background.setCornerRadius(OMaterialHelperCore.dpToPx(getContext(), MODAL_CORNER_RADIUS_DP));
        surfaceView.setBackground(background);
        surfaceView.setOutlineProvider(ViewOutlineProvider.BACKGROUND);
        surfaceView.setClipToOutline(true);
    }

    private static MaterialConfigCore[] copyModalMaterials(boolean isLight) {
        return OMaterialHelperCore.copyMaterials((MaterialConfigCore[]) MaterialTokenCore.OUI_Bg_Modal.invoke(Boolean.valueOf(isLight)));
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent event) {
        if (this.mConsuming == false) goto L7;
        return true;
    L7:
        return super.dispatchKeyEvent(event);
    }

    private void setEnabled(boolean enabled) {
        Button b = (Button) findViewById(R.id.button1);
        if (b == null) goto L5;
        b.setEnabled(enabled);
    L5:
        Button b2 = (Button) findViewById(R.id.button2);
        if (b2 == null) goto L8;
        b2.setEnabled(enabled);
    L8:
        Button b3 = (Button) findViewById(R.id.button3);
        if (b3 == null) goto L12;
        b3.setEnabled(enabled);
        return;
    }

    protected void closeDialog() {
        if (((AlertDialog) this).mCancelable == false) goto L5;
        cancel();
        return;
    L5:
        dismiss();
    }
}
