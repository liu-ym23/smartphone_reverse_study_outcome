package com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight;

import com.bytedance.android.livesdk.message.model.b6;
import io.reactivex.disposables.CompositeDisposable;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public abstract class d implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public m.a f133434a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b6.b f133435b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CompositeDisposable f133436c;

    public abstract void d();

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.m
    public void release() {
        this.f133436c.clear();
        this.f133434a = null;
    }

    public d() {
        this.f133436c = new CompositeDisposable();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.m
    public final void a(m.a r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        this.f133434a = r100;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.m
    public final void b(b6.b r100) {
        Intrinsics.checkNotNullParameter(r100, "triggerInfo");
        this.f133435b = r100;
        d();
    }

    public final String c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        b6.b r101 = this.f133435b;
        if (r101 == null) goto L7;
        Map<String, String> r102 = r101.b();
        if (r102 == null) goto L7;
        return r102.get(r100);
    L7:
        return null;
    }
}
