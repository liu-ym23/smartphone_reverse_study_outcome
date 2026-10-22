package com.bytedance.android.shopping.mall;

import android.view.View;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public class a implements ti.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f176508a;

    @Override // ti.e
    public void onContainerError(View r100, int r101, String r102) {
        throw null;
    }

    @Override // ti.e
    public void onFallback(int r100, String r101) {
        throw null;
    }

    @Override // ti.e
    public void onLoadFail(View r100, String r101, String r102) {
        throw null;
    }

    @Override // ti.e
    public void onLoadStart(View r100, boolean r101) {
        throw null;
    }

    @Override // ti.e
    public void onLoadSuccess(View r100) {
        throw null;
    }

    @Override // ti.e
    public void onBeforeGlobalPropsInitialize() {
        int r100 = e.f176515a;
        e.a(this.f176508a, "onBeforeGlobalPropsInitialize");
    }

    @Override // ti.e
    public void onBeforeInitialPropsInitialize() {
        int r100 = e.f176515a;
        e.a(this.f176508a, "onBeforeInitialPropsInitialize");
    }

    @Override // ti.e
    public void onBeforeJsbRegister() {
        int r100 = e.f176515a;
        e.a(this.f176508a, "onBeforeJsbRegister");
    }

    @Override // ti.e
    public void onBeforeOpenContainer() {
        int r100 = e.f176515a;
        e.a(this.f176508a, "onBeforeOpenContainer");
    }

    @Override // ti.e
    public void onContainerInitEnd() {
        int r100 = e.f176515a;
        e.a(this.f176508a, "onContainerInitEnd");
    }

    @Override // ti.e
    public void onContainerInitStart() {
        int r100 = e.f176515a;
        e.a(this.f176508a, "onContainerInitStart");
    }

    @Override // ti.e
    public void onGlobalPropsInitialized() {
        int r100 = e.f176515a;
        e.a(this.f176508a, "onGlobalPropsInitialized");
    }

    @Override // ti.e
    public void onInitialPropsInitialized() {
        int r100 = e.f176515a;
        e.a(this.f176508a, "onInitialPropsInitialized");
    }

    @Override // ti.e
    public void onJsbRegistered() {
        int r100 = e.f176515a;
        e.a(this.f176508a, "onJsbRegistered");
    }

    @Override // ti.e
    public void onLynxEnvInitialized() {
        int r100 = e.f176515a;
        e.a(this.f176508a, "onLynxEnvInitialized");
    }

    @Override // ti.e
    public void onPrepareComponentEnd() {
        int r100 = e.f176515a;
        e.a(this.f176508a, "onPrepareComponentEnd");
    }

    @Override // ti.e
    public void onPrepareComponentStart() {
        int r100 = e.f176515a;
        e.a(this.f176508a, "onPrepareComponentStart");
    }

    @Override // ti.e
    public void onPrepareInitDataEnd() {
        int r100 = e.f176515a;
        e.a(this.f176508a, "onPrepareInitDataEnd");
    }

    @Override // ti.e
    public void onPrepareTemplateEnd() {
        int r100 = e.f176515a;
        e.a(this.f176508a, "onPrepareTemplateEnd");
    }

    @Override // ti.e
    public void onPrepareTemplateStart() {
        int r100 = e.f176515a;
        e.a(this.f176508a, "onPrepareTemplateStart");
    }

    @Override // ti.e
    public void onRelease() {
        int r100 = e.f176515a;
        e.a(this.f176508a, "onRelease");
    }

    public a() {
        this.f176508a = "AnnieLifecycleAdapter";
    }

    @Override // ti.e
    public void onBeforeCreateRenderData(View r100) {
        Intrinsics.checkNotNullParameter(r100, "hybridView");
        int r101 = e.f176515a;
        e.a(this.f176508a, "onBeforeCreateRenderData");
    }

    @Override // ti.e
    public void onBeforeLynxEnvInitialize(boolean r100) {
        int r101 = e.f176515a;
        e.a(this.f176508a, "onBeforeLynxEnvInitialize");
    }

    @Override // ti.e
    public void onAttachView(View r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "hybridType");
        int r102 = e.f176515a;
        e.a(this.f176508a, "onAttachView");
    }

    @Override // ti.e
    public void onCreateRenderData(View r100, Set<String> r101) {
        Intrinsics.checkNotNullParameter(r100, "hybridView");
        Intrinsics.checkNotNullParameter(r101, "stateKeys");
        int r102 = e.f176515a;
        e.a(this.f176508a, "onCreateRenderData");
    }

    @Override // ti.e
    public void onInnerFallback(int r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "errorMessage");
        int r102 = e.f176515a;
        e.a(this.f176508a, "onInnerFallback errorCode=" + r100 + " errorMessage=" + r101);
    }

    @Override // ti.e
    public void onPrepareInitDataStart(String r100, String r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "scheme");
        Intrinsics.checkNotNullParameter(r101, "fallbackUrl");
        int r103 = e.f176515a;
        e.a(this.f176508a, "onPrepareInitDataStart fallbaclUrl=" + r101 + " isFallback=" + r102);
    }
}
