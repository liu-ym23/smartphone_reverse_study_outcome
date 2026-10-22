package com.bytedance.android.accessibilityLib_Core.helper;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.InputQueue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

/* JADX INFO: loaded from: classes43.dex */
public class c extends Window {
    @Override // android.view.Window
    public final void addContentView(View r100, ViewGroup.LayoutParams r101) {
    }

    @Override // android.view.Window
    public final void closeAllPanels() {
    }

    @Override // android.view.Window
    public final void closePanel(int r100) {
    }

    @Override // android.view.Window
    public final View getCurrentFocus() {
        return null;
    }

    @Override // android.view.Window
    public final int getNavigationBarColor() {
        return 0;
    }

    @Override // android.view.Window
    public final int getStatusBarColor() {
        return 0;
    }

    @Override // android.view.Window
    public final int getVolumeControlStream() {
        return 0;
    }

    @Override // android.view.Window
    public final void invalidatePanelMenu(int r100) {
    }

    @Override // android.view.Window
    public final boolean isFloating() {
        return false;
    }

    @Override // android.view.Window
    public final boolean isShortcutKey(int r100, KeyEvent r101) {
        return false;
    }

    @Override // android.view.Window
    public final void onActive() {
    }

    @Override // android.view.Window
    public final void onConfigurationChanged(Configuration r100) {
    }

    @Override // android.view.Window
    public final void openPanel(int r100, KeyEvent r101) {
    }

    @Override // android.view.Window
    public final boolean performContextMenuIdentifierAction(int r100, int r101) {
        return true;
    }

    @Override // android.view.Window
    public final boolean performPanelIdentifierAction(int r100, int r101, int r102) {
        return true;
    }

    @Override // android.view.Window
    public final boolean performPanelShortcut(int r100, int r101, KeyEvent r102, int r103) {
        return true;
    }

    @Override // android.view.Window
    public final void restoreHierarchyState(Bundle r100) {
    }

    @Override // android.view.Window
    public final void setBackgroundDrawable(Drawable r100) {
    }

    @Override // android.view.Window
    public final void setChildDrawable(int r100, Drawable r101) {
    }

    @Override // android.view.Window
    public final void setChildInt(int r100, int r101) {
    }

    @Override // android.view.Window
    public final void setContentView(int r100) {
    }

    @Override // android.view.Window
    public final void setContentView(View r100) {
    }

    @Override // android.view.Window
    public final void setContentView(View r100, ViewGroup.LayoutParams r101) {
    }

    @Override // android.view.Window
    public final void setDecorCaptionShade(int r100) {
    }

    @Override // android.view.Window
    public final void setFeatureDrawable(int r100, Drawable r101) {
    }

    @Override // android.view.Window
    public final void setFeatureDrawableAlpha(int r100, int r101) {
    }

    @Override // android.view.Window
    public final void setFeatureDrawableResource(int r100, int r101) {
    }

    @Override // android.view.Window
    public final void setFeatureDrawableUri(int r100, Uri r101) {
    }

    @Override // android.view.Window
    public final void setFeatureInt(int r100, int r101) {
    }

    @Override // android.view.Window
    public final void setNavigationBarColor(int r100) {
    }

    @Override // android.view.Window
    public final void setResizingCaptionDrawable(Drawable r100) {
    }

    @Override // android.view.Window
    public final void setStatusBarColor(int r100) {
    }

    @Override // android.view.Window
    public final void setTitle(CharSequence r100) {
    }

    @Override // android.view.Window
    public final void setTitleColor(int r100) {
    }

    @Override // android.view.Window
    public final void setVolumeControlStream(int r100) {
    }

    @Override // android.view.Window
    public final boolean superDispatchGenericMotionEvent(MotionEvent r100) {
        return false;
    }

    @Override // android.view.Window
    public final boolean superDispatchKeyEvent(KeyEvent r100) {
        return false;
    }

    @Override // android.view.Window
    public final boolean superDispatchKeyShortcutEvent(KeyEvent r100) {
        return false;
    }

    @Override // android.view.Window
    public final boolean superDispatchTouchEvent(MotionEvent r100) {
        return false;
    }

    @Override // android.view.Window
    public final boolean superDispatchTrackballEvent(MotionEvent r100) {
        return false;
    }

    @Override // android.view.Window
    public final void takeInputQueue(InputQueue.Callback r100) {
    }

    @Override // android.view.Window
    public final void takeKeyEvents(boolean r100) {
    }

    @Override // android.view.Window
    public final void takeSurface(SurfaceHolder.Callback2 r100) {
    }

    @Override // android.view.Window
    public final void togglePanel(int r100, KeyEvent r101) {
    }

    @Override // android.view.Window
    public final Bundle saveHierarchyState() {
        return new Bundle();
    }

    @Override // android.view.Window
    public final LayoutInflater getLayoutInflater() {
        return LayoutInflater.from(getContext());
    }

    public c(Context r100) {
        super(r100);
    }
}
