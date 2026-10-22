package com.android.internal.policy;

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

/* JADX INFO: loaded from: classes.dex */
public class PhoneWindow extends Window {
    @Override // android.view.Window
    public void addContentView(View r100, ViewGroup.LayoutParams r101) {
    }

    @Override // android.view.Window
    public void closeAllPanels() {
    }

    @Override // android.view.Window
    public void closePanel(int r100) {
    }

    @Override // android.view.Window
    public View getCurrentFocus() {
        return null;
    }

    @Override // android.view.Window
    public View getDecorView() {
        return null;
    }

    @Override // android.view.Window
    public LayoutInflater getLayoutInflater() {
        return null;
    }

    @Override // android.view.Window
    public int getNavigationBarColor() {
        return 0;
    }

    @Override // android.view.Window
    public int getStatusBarColor() {
        return 0;
    }

    @Override // android.view.Window
    public int getVolumeControlStream() {
        return 0;
    }

    @Override // android.view.Window
    public void invalidatePanelMenu(int r100) {
    }

    @Override // android.view.Window
    public boolean isFloating() {
        return false;
    }

    @Override // android.view.Window
    public boolean isShortcutKey(int r100, KeyEvent r101) {
        return false;
    }

    @Override // android.view.Window
    public void onActive() {
    }

    @Override // android.view.Window
    public void onConfigurationChanged(Configuration r100) {
    }

    @Override // android.view.Window
    public void openPanel(int r100, KeyEvent r101) {
    }

    @Override // android.view.Window
    public View peekDecorView() {
        return null;
    }

    @Override // android.view.Window
    public boolean performContextMenuIdentifierAction(int r100, int r101) {
        return false;
    }

    @Override // android.view.Window
    public boolean performPanelIdentifierAction(int r100, int r101, int r102) {
        return false;
    }

    @Override // android.view.Window
    public boolean performPanelShortcut(int r100, int r101, KeyEvent r102, int r103) {
        return false;
    }

    @Override // android.view.Window
    public void restoreHierarchyState(Bundle r100) {
    }

    @Override // android.view.Window
    public Bundle saveHierarchyState() {
        return null;
    }

    @Override // android.view.Window
    public void setBackgroundDrawable(Drawable r100) {
    }

    @Override // android.view.Window
    public void setChildDrawable(int r100, Drawable r101) {
    }

    @Override // android.view.Window
    public void setChildInt(int r100, int r101) {
    }

    @Override // android.view.Window
    public void setContentView(int r100) {
    }

    @Override // android.view.Window
    public void setContentView(View r100) {
    }

    @Override // android.view.Window
    public void setContentView(View r100, ViewGroup.LayoutParams r101) {
    }

    @Override // android.view.Window
    public void setDecorCaptionShade(int r100) {
    }

    @Override // android.view.Window
    public void setFeatureDrawable(int r100, Drawable r101) {
    }

    @Override // android.view.Window
    public void setFeatureDrawableAlpha(int r100, int r101) {
    }

    @Override // android.view.Window
    public void setFeatureDrawableResource(int r100, int r101) {
    }

    @Override // android.view.Window
    public void setFeatureDrawableUri(int r100, Uri r101) {
    }

    @Override // android.view.Window
    public void setFeatureInt(int r100, int r101) {
    }

    @Override // android.view.Window
    public void setNavigationBarColor(int r100) {
    }

    @Override // android.view.Window
    public void setResizingCaptionDrawable(Drawable r100) {
    }

    @Override // android.view.Window
    public void setStatusBarColor(int r100) {
    }

    @Override // android.view.Window
    public void setTitle(CharSequence r100) {
    }

    @Override // android.view.Window
    public void setTitleColor(int r100) {
    }

    @Override // android.view.Window
    public void setVolumeControlStream(int r100) {
    }

    @Override // android.view.Window
    public boolean superDispatchGenericMotionEvent(MotionEvent r100) {
        return false;
    }

    @Override // android.view.Window
    public boolean superDispatchKeyEvent(KeyEvent r100) {
        return false;
    }

    @Override // android.view.Window
    public boolean superDispatchKeyShortcutEvent(KeyEvent r100) {
        return false;
    }

    @Override // android.view.Window
    public boolean superDispatchTouchEvent(MotionEvent r100) {
        return false;
    }

    @Override // android.view.Window
    public boolean superDispatchTrackballEvent(MotionEvent r100) {
        return false;
    }

    @Override // android.view.Window
    public void takeInputQueue(InputQueue.Callback r100) {
    }

    @Override // android.view.Window
    public void takeKeyEvents(boolean r100) {
    }

    @Override // android.view.Window
    public void takeSurface(SurfaceHolder.Callback2 r100) {
    }

    @Override // android.view.Window
    public void togglePanel(int r100, KeyEvent r101) {
    }

    public PhoneWindow(Context r100) {
        super(r100);
    }
}
