package com.bytedance.android.live.effect;

import java.util.Arrays;

/* JADX INFO: loaded from: classes45.dex */
public final class s implements com.bytedance.android.live.core.log.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String[] f68062a;

    public s(String[] r100) {
        this.f68062a = r100;
    }

    @Override // com.bytedance.android.live.core.log.c
    public final String generate() {
        return "effect extra list:" + Arrays.toString(this.f68062a);
    }
}
