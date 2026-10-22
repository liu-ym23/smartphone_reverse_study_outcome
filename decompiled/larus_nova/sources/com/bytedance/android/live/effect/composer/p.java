package com.bytedance.android.live.effect.composer;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Float f67983a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f67984b;

    public final String toString() {
        return "LiveComposerTagNode(tag='" + this.f67984b + "', value=" + this.f67983a;
    }

    public final Float a() {
        return this.f67983a;
    }

    public p(String r100) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        this.f67984b = r100;
    }
}
