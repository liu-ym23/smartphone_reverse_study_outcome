package com.android.server.input.debug;

import android.R;
import android.content.Context;
import android.hardware.input.InputManager;
import android.view.InputDevice;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.TextView;
import java.util.function.Consumer;

/* JADX INFO: loaded from: classes2.dex */
public class TouchpadSelectionView extends LinearLayout {
    private static final float TEXT_SIZE_SP = 16.0f;
    int mCurrentTouchpadId;

    /* JADX INFO: renamed from: $r8$lambda$Cgj4SGPa5QUH5PwFh27-vhrjlfM, reason: not valid java name */
    public static /* synthetic */ void m4622$r8$lambda$Cgj4SGPa5QUH5PwFh27vhrjlfM(TouchpadSelectionView r0, Context r1, Consumer r2, View r3) {
        r0.lambda$init$0(r1, r2, r3);
    }

    /* JADX INFO: renamed from: $r8$lambda$Fte8vHin7tFS_3M8Z0-6JIkWlsk, reason: not valid java name */
    public static /* synthetic */ boolean m4623$r8$lambda$Fte8vHin7tFS_3M8Z06JIkWlsk(TouchpadSelectionView r0, Consumer r1, MenuItem r2) {
        return r0.lambda$showPopupMenu$1(r1, r2);
    }

    public TouchpadSelectionView(Context context, int touchpadId, Consumer<Integer> touchpadSwitchHandler) {
        super(context);
        this.mCurrentTouchpadId = touchpadId;
        init(context, touchpadSwitchHandler);
    }

    private void init(final Context context, final Consumer<Integer> touchpadSwitchHandler) {
        setOrientation(0);
        setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        setBackgroundColor(0);
        TextView nameView = new TextView(context);
        nameView.setTextSize(TEXT_SIZE_SP);
        nameView.setText(getTouchpadName(this.mCurrentTouchpadId));
        nameView.setGravity(3);
        nameView.setTextColor(-1);
        LinearLayout.LayoutParams textParams = new LinearLayout.LayoutParams(-2, -2);
        textParams.rightMargin = 16;
        nameView.setLayoutParams(textParams);
        ImageButton arrowButton = new ImageButton(context);
        arrowButton.setImageDrawable(context.getDrawable(R.drawable.arrow_down_float));
        arrowButton.setForegroundGravity(5);
        arrowButton.setBackgroundColor(0);
        arrowButton.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        arrowButton.setOnClickListener(new TouchpadSelectionView$$ExternalSyntheticLambda0(this, context, touchpadSwitchHandler));
        addView(nameView);
        addView(arrowButton);
    }

    private /* synthetic */ void lambda$init$0(Context context, Consumer touchpadSwitchHandler, View v) {
        showPopupMenu(v, context, touchpadSwitchHandler);
    }

    private void showPopupMenu(View anchorView, Context context, final Consumer<Integer> touchpadSwitchHandler) {
        int i = 0;
        PopupMenu popupMenu = new PopupMenu(context, anchorView);
        InputManager inputManager = (InputManager) ((LinearLayout) this).mContext.getSystemService(InputManager.class);
        inputManager.getClass();
        int[] r3 = inputManager.getInputDeviceIds();
        int r4 = r3.length;
        int r6 = 0;
    L3:
        if (r6 >= r4) goto L8;
        int deviceId = r3[r6];
        InputDevice inputDevice = inputManager.getInputDevice(deviceId);
        inputDevice.getClass();
        if (inputDevice.supportsSource(1056778) == false) goto L7;
        popupMenu.getMenu().add(0, deviceId, i, getTouchpadName(deviceId));
        i = i + 1;
    L7:
        r6 = r6 + 1;
        goto L3
    L8:
        popupMenu.setOnMenuItemClickListener(new TouchpadSelectionView$$ExternalSyntheticLambda1(this, touchpadSwitchHandler));
        popupMenu.show();
    }

    private /* synthetic */ boolean lambda$showPopupMenu$1(Consumer touchpadSwitchHandler, MenuItem item) {
        if (item.getItemId() != this.mCurrentTouchpadId) goto L6;
        return false;
    L6:
        touchpadSwitchHandler.accept(Integer.valueOf(item.getItemId()));
        return true;
    }

    private String getTouchpadName(int touchpadId) {
        InputManager r0 = (InputManager) ((LinearLayout) this).mContext.getSystemService(InputManager.class);
        r0.getClass();
        InputDevice r1 = r0.getInputDevice(touchpadId);
        r1.getClass();
        return r1.getName();
    }
}
