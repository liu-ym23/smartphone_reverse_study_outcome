package com.mdisdk.capability.framework;

import android.content.ComponentName;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import androidx.annotation.Nullable;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes3.dex */
public class DefaultFrameworkBridge implements IFrameworkBridge {
    @Override // com.mdisdk.capability.framework.IFrameworkBridge
    public boolean addDisplayControlPackage(String str) {
        return FrameworkUtils.addDisplayControlPackage(str);
    }

    @Override // com.mdisdk.capability.framework.IFrameworkBridge
    public void addEventListener(Handler handler, int i, int i6) throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        FrameworkUtils.addEventListener(handler, i, i6);
    }

    @Override // com.mdisdk.capability.framework.IFrameworkBridge
    public void addOmniDisplayCallback(Handler handler, int i) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        FrameworkUtils.addOmniDisplayCallback(handler, i);
    }

    @Override // com.mdisdk.capability.framework.IFrameworkBridge
    public void apexRequest(Intent intent) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        FrameworkUtils.apexRequest(intent);
    }

    @Override // com.mdisdk.capability.framework.IFrameworkBridge
    @Nullable
    public Intent getActivityIntentByPackage(String str, int i) {
        return FrameworkUtils.getActivityIntentByPackage(str, i);
    }

    @Override // com.mdisdk.capability.framework.IFrameworkBridge
    public int getShowingDisplayId(String str) {
        return FrameworkUtils.getShowingDisplayId(str);
    }

    @Override // com.mdisdk.capability.framework.IFrameworkBridge
    @Nullable
    public Intent getTopActivityIntent(int i) {
        return FrameworkUtils.getTopActivityIntent(i);
    }

    @Override // com.mdisdk.capability.framework.IFrameworkBridge
    public boolean isOmniDisplayId(String str) {
        return FrameworkUtils.isOmniDisplayId(str);
    }

    @Override // com.mdisdk.capability.framework.IFrameworkBridge
    public boolean isOmniDisplayImeEnabled(int i) {
        return FrameworkUtils.isOmniDisplayImeEnabled(i);
    }

    @Override // com.mdisdk.capability.framework.IFrameworkBridge
    public boolean isOmniDisplayTakeover(int i) {
        return FrameworkUtils.isOmniDisplayTakeover(i);
    }

    @Override // com.mdisdk.capability.framework.IFrameworkBridge
    public boolean moveAppToDisplay(String str, int i, boolean z10, int i6) {
        return FrameworkUtils.moveAppToDisplay(str, i, z10, i6);
    }

    @Override // com.mdisdk.capability.framework.IFrameworkBridge
    public void removeEventListener(Handler handler, int i, int i6) throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        FrameworkUtils.removeEventListener(handler, i, i6);
    }

    @Override // com.mdisdk.capability.framework.IFrameworkBridge
    public void removeOmniDisplayCallback(Handler handler, int i) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        FrameworkUtils.removeOmniDisplayCallback(handler, i);
    }

    @Override // com.mdisdk.capability.framework.IFrameworkBridge
    public void setOmniDisplayImeEnabled(int i, boolean z10) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        FrameworkUtils.setOmniDisplayImeEnabled(i, z10);
    }

    @Override // com.mdisdk.capability.framework.IFrameworkBridge
    public void setOmniDisplayTakeover(int i, boolean z10) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        FrameworkUtils.setOmniDisplayTakeover(i, z10);
    }

    @Override // com.mdisdk.capability.framework.IFrameworkBridge
    public void setRedirectActivity(@Nullable ComponentName componentName) {
        FrameworkUtils.setRedirectActivity(componentName);
    }

    @Override // com.mdisdk.capability.framework.IFrameworkBridge
    public Bitmap takeScreenShot(int i, @Nullable String str) {
        return FrameworkUtils.takeScreenShot(i, str);
    }

    @Override // com.mdisdk.capability.framework.IFrameworkBridge
    public Bundle takeScreenshotWithScaleResult(int i, int i6, @Nullable String str, float f) {
        return FrameworkUtils.takeScreenshotWithScaleResult(i, i6, str, f);
    }
}
