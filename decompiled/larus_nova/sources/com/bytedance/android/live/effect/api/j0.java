package com.bytedance.android.live.effect.api;

import com.ss.android.ugc.effectmanager.effect.model.EffectChannelResponse;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class j0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k f66769a;

    public static final class a implements k.i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ q f66770a;

        @Override // com.bytedance.android.live.effect.api.k.i
        public final void b() {
            this.f66770a.b();
        }

        public a(q r100) {
            this.f66770a = r100;
        }

        @Override // com.bytedance.android.live.effect.api.k.i
        public final void a(EffectChannelResponse r100) {
            this.f66770a.a(r100);
        }
    }

    public j0(k r100) {
        Intrinsics.checkNotNullParameter(r100, "effectService");
        this.f66769a = r100;
    }

    public final void a(String r100, q r101) {
        Intrinsics.checkNotNullParameter(r101, "callback");
        this.f66769a.l(r100, new a(r101));
    }
}
