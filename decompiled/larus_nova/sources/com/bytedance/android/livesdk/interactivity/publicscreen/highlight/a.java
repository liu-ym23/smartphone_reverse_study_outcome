package com.bytedance.android.livesdk.interactivity.publicscreen.highlight;

import com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.i;
import com.bytedance.android.livesdk.interactivity.publicscreen.highlight.data.PSHighlightCommonCompLauncher;
import io.reactivex.functions.Action;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class a implements Action {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f138918a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ i f138919b;

    public a(b r100, PSHighlightCommonCompLauncher r101) {
        this.f138918a = r100;
        this.f138919b = r101;
    }

    @Override // io.reactivex.functions.Action
    public final void run() {
        b r100 = this.f138918a;
        i r101 = this.f138919b;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "launcher");
        if (((ArrayList) r100.f138920a).remove(r101) == false) goto L6;
        r101.onUnload();
        return;
    }
}
