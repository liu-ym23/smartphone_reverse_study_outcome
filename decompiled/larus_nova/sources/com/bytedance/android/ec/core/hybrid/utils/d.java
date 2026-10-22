package com.bytedance.android.ec.core.hybrid.utils;

import android.view.View;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class d implements pd.c {
    public d() {
    }

    @Override // pd.c
    public final void onAttachView(View r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "hybridType");
    }

    @Override // pd.c
    public final void onBeforeCreateRenderData(View r100) {
        Intrinsics.checkNotNullParameter(r100, "hybridView");
    }

    @Override // pd.c
    public final void onBeforeGlobalPropsInitialize() {
    }

    @Override // pd.c
    public final void onBeforeInitialPropsInitialize() {
    }

    @Override // pd.c
    public final void onBeforeJsbRegister() {
    }

    @Override // pd.c
    public final void onBeforeLynxEnvInitialize(boolean r100) {
    }

    @Override // pd.c
    public final void onBeforeOpenContainer() {
    }

    @Override // pd.c
    public final void onContainerError(View r100, int r101, String r102) {
        Intrinsics.checkNotNullParameter(r102, "errorMessage");
    }

    @Override // pd.c
    public final void onContainerInitEnd() {
    }

    @Override // pd.c
    public final void onContainerInitStart() {
    }

    @Override // pd.c
    public final void onCreateRenderData(View r100, Set<String> r101) {
        Intrinsics.checkNotNullParameter(r100, "hybridView");
        Intrinsics.checkNotNullParameter(r101, "stateKeys");
    }

    @Override // pd.c
    public final boolean onFallback(int r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "errorMessage");
        return true;
    }

    @Override // pd.c
    public final void onGlobalPropsInitialized() {
    }

    @Override // pd.c
    public final void onInitialPropsInitialized() {
    }

    @Override // pd.c
    public final void onInnerFallback(int r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "errorMessage");
    }

    @Override // pd.c
    public final void onJsbRegistered() {
    }

    @Override // pd.c
    public final void onLoadFail(View r100, String r101, String r102) {
    }

    @Override // pd.c
    public final void onLoadStart(View r100, boolean r101) {
    }

    @Override // pd.c
    public final void onLoadSuccess(View r100) {
    }

    @Override // pd.c
    public final void onLynxEnvInitialized() {
    }

    @Override // pd.c
    public final void onPrepareComponentEnd() {
    }

    @Override // pd.c
    public final void onPrepareComponentStart() {
    }

    @Override // pd.c
    public final void onPrepareInitDataEnd() {
    }

    @Override // pd.c
    public final void onPrepareInitDataStart(String r100, String r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "scheme");
        Intrinsics.checkNotNullParameter(r101, "fallbackUrl");
    }

    @Override // pd.c
    public final void onPrepareTemplateEnd() {
    }

    @Override // pd.c
    public final void onPrepareTemplateStart() {
    }

    @Override // pd.c
    public final void onRelease() {
    }
}
