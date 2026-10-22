package com.bytedance.android.livesdk.interactivity.publicscreen.pin;

import com.bytedance.android.livesdk.interactivity.api.entity.f;
import com.bytedance.android.livesdk.interactivity.textmessage.model.z;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class d<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f139010a;

    public d(f r100) {
        this.f139010a = r100;
    }

    public final boolean a(f r100) {
        if ((r100 instanceof z) == true) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual(((z) r100).H, ((z) this.f139010a).H) == false) goto L7;
        return true;
    }
}
