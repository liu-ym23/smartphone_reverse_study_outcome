package com.mdisdk.capability.framework;

import android.content.ComponentName;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import androidx.annotation.Nullable;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes3.dex */
public class StepOsFrameworkBridge implements IFrameworkBridge {
    @Override // com.mdisdk.capability.framework.IFrameworkBridge
    public boolean addDisplayControlPackage(String str) {
        return StepOsFrameworkUtils.addDisplayControlPackage(str);
    }

    @Override // com.mdisdk.capability.framework.IFrameworkBridge
    public void addEventListener(Handler handler, int i, int i6) throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        StepOsFrameworkUtils.addEventListener(handler, i, i6);
    }

    @Override // com.mdisdk.capability.framework.IFrameworkBridge
    public void addOmniDisplayCallback(Handler handler, int i) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        StepOsFrameworkUtils.addOmniDisplayCallback(handler, i);
    }

    @Override // com.mdisdk.capability.framework.IFrameworkBridge
    public void apexRequest(Intent intent) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        StepOsFrameworkUtils.apexRequest(intent);
    }

    @Override // com.mdisdk.capability.framework.IFrameworkBridge
    @Nullable
    public Intent getActivityIntentByPackage(String str, int i) {
        return StepOsFrameworkUtils.getActivityIntentByPackage(str, i);
    }

    @Override // com.mdisdk.capability.framework.IFrameworkBridge
    public int getShowingDisplayId(String str) {
        return StepOsFrameworkUtils.getShowingDisplayId(str);
    }

    @Override // com.mdisdk.capability.framework.IFrameworkBridge
    @Nullable
    public Intent getTopActivityIntent(int i) {
        return StepOsFrameworkUtils.getTopActivityIntent(i);
    }

    @Override // com.mdisdk.capability.framework.IFrameworkBridge
    public boolean isOmniDisplayId(String str) {
        return StepOsFrameworkUtils.isOmniDisplayId(str);
    }

    @Override // com.mdisdk.capability.framework.IFrameworkBridge
    public boolean isOmniDisplayImeEnabled(int i) {
        return StepOsFrameworkUtils.isOmniDisplayImeEnabled(i);
    }

    @Override // com.mdisdk.capability.framework.IFrameworkBridge
    public boolean isOmniDisplayTakeover(int i) {
        return StepOsFrameworkUtils.isOmniDisplayTakeover(i);
    }

    @Override // com.mdisdk.capability.framework.IFrameworkBridge
    public boolean moveAppToDisplay(String str, int i, boolean z10, int i6) {
        return StepOsFrameworkUtils.moveAppToDisplay(str, i, z10, i6);
    }

    @Override // com.mdisdk.capability.framework.IFrameworkBridge
    public void removeEventListener(Handler handler, int i, int i6) throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        StepOsFrameworkUtils.removeEventListener(handler, i, i6);
    }

    @Override // com.mdisdk.capability.framework.IFrameworkBridge
    public void removeOmniDisplayCallback(Handler handler, int i) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        StepOsFrameworkUtils.removeOmniDisplayCallback(handler, i);
    }

    @Override // com.mdisdk.capability.framework.IFrameworkBridge
    public void setOmniDisplayImeEnabled(int i, boolean z10) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        StepOsFrameworkUtils.setOmniDisplayImeEnabled(i, z10);
    }

    @Override // com.mdisdk.capability.framework.IFrameworkBridge
    public void setOmniDisplayTakeover(int i, boolean z10) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        StepOsFrameworkUtils.setOmniDisplayTakeover(i, z10);
    }

    @Override // com.mdisdk.capability.framework.IFrameworkBridge
    public void setRedirectActivity(@Nullable ComponentName componentName) {
        StepOsFrameworkUtils.setRedirectActivity(componentName);
    }

    @Override // com.mdisdk.capability.framework.IFrameworkBridge
    public Bitmap takeScreenShot(int i, @Nullable String str) {
        return StepOsFrameworkUtils.takeScreenShot(i, str);
    }

    @Override // com.mdisdk.capability.framework.IFrameworkBridge
    public Bundle takeScreenshotWithScaleResult(int i, int i6, @Nullable String str, float f) {
        return StepOsFrameworkUtils.takeScreenshotWithScaleResult(i, i6, str, f);
    }
}
