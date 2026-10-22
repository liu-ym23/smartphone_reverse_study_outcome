package com.google.android.material.textfield;

import android.content.Context;
import com.google.android.material.internal.CheckableImageButton;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: EndIconDelegate.java */
/* JADX INFO: loaded from: classes2.dex */
abstract class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    TextInputLayout f13645a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Context f13646b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    CheckableImageButton f13647c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final int f13648d;

    abstract void a();

    void a(boolean r1) {
    }

    boolean a(int r1) {
        return true;
    }

    boolean b() {
        return false;
    }

    d(TextInputLayout r4, int r5) {
        this.f13645a = r4;
        this.f13646b = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");
        this.f13647c = r4.getEndIconView();
        this.f13648d = r5;
    }
}
