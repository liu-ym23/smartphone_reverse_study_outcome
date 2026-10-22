package com.bytedance.android.shopping.commentv3.event_chain;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.android.ui.ec.widget.toast.ECToast;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class d implements v96.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f172800a;

    public d(Context r100) {
        this.f172800a = r100;
    }

    @Override // v96.g
    public final void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "content");
        if (this.f172800a != null) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r100) == false) goto L8;
        return;
    L8:
        ECToast.showToast$default(ECToast.INSTANCE, this.f172800a, r100, null, 4, null);
    }
}
