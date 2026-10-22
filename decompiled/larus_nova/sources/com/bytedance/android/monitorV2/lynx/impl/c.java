package com.bytedance.android.monitorV2.lynx.impl;

import com.bytedance.android.monitorV2.event.HybridEvent;
import com.lynx.tasm.LynxView;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes12.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference<LynxView> f163214a;

    public abstract void onEventPost(HybridEvent r100);

    public c(LynxView r100) {
        this.f163214a = new WeakReference(r100);
    }
}
