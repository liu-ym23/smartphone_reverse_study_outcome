package com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.callback;

import android.content.Context;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.ktv.common.tuningpanel.model.TuningVolumeType;
import com.bytedance.android.live.ktv.common.tuningpanel.tuningvolume.view.TuningVolumeContentArea;
import com.bytedance.android.livesdk.widget.SeekBarWithProgress;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.lang.ref.WeakReference;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class s implements gc0.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.android.live.ktv.common.tuningpanel.ability.a f143514a;

    public static final class a<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ s f143515a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ TuningVolumeContentArea f143516b;

        public a(s r100, TuningVolumeContentArea r101) {
            this.f143515a = r100;
            this.f143516b = r101;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            Boolean r101 = (Boolean) r100;
            View r102 = this.f143516b.b(TuningVolumeType.EAR_BACK_VOLUME);
            if (r102 == null) goto L9;
            com.bytedance.android.live.ktv.common.tuningpanel.ability.a r103 = this.f143515a.f143514a;
            if (r103 == null) goto L7;
            r103.i();
        L7:
            r102.setVisibility(8);
            return;
        }
    }

    public static final class b implements gc0.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ s f143517a;

        @Override // gc0.c
        public final SeekBarWithProgress.b b() {
            return new gc0.b();
        }

        @Override // gc0.c
        public final int c() {
            com.bytedance.android.live.ktv.common.tuningpanel.ability.a r100 = this.f143517a.f143514a;
            if (r100 != null) goto L7;
            return 100;
        L7:
            return r100.U();
        }

        @Override // gc0.c
        public final int d() {
            com.bytedance.android.live.ktv.common.tuningpanel.ability.a r100 = this.f143517a.f143514a;
            if (r100 != null) goto L7;
            return 50;
        L7:
            return (int) r100.f();
        }

        @Override // gc0.c
        public final String a() {
            return s1.B(R.string.ttlive_ktv_echo_volume);
        }

        public b(s r100) {
            this.f143517a = r100;
        }

        @Override // gc0.c
        public final void onProgressChanged(int r100) {
            com.bytedance.android.live.ktv.common.tuningpanel.ability.a r101 = this.f143517a.f143514a;
            if (r101 == null) goto L6;
            r101.g(r100);
            return;
        }
    }

    public static final class c implements gc0.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ s f143518a;

        @Override // gc0.c
        public final SeekBarWithProgress.b b() {
            return new gc0.b();
        }

        @Override // gc0.c
        public final int c() {
            com.bytedance.android.live.ktv.common.tuningpanel.ability.a r100 = this.f143518a.f143514a;
            if (r100 != null) goto L7;
            return 100;
        L7:
            return r100.w();
        }

        @Override // gc0.c
        public final int d() {
            com.bytedance.android.live.ktv.common.tuningpanel.ability.a r100 = this.f143518a.f143514a;
            if (r100 != null) goto L7;
            return 50;
        L7:
            return (int) r100.e();
        }

        @Override // gc0.c
        public final String a() {
            return s1.B(R.string.ttlive_ktv_voice_volume);
        }

        public c(s r100) {
            this.f143518a = r100;
        }

        @Override // gc0.c
        public final void onProgressChanged(int r100) {
            com.bytedance.android.live.ktv.common.tuningpanel.ability.a r101 = this.f143518a.f143514a;
            if (r101 == null) goto L6;
            com.bytedance.android.live.ktv.common.tuningpanel.ability.a.C1143a.b(r101, r100, 6);
            return;
        }
    }

    public s(com.bytedance.android.live.ktv.common.tuningpanel.ability.a r100) {
        this.f143514a = r100;
    }

    @Override // gc0.d
    public final void a(TuningVolumeContentArea r100) {
        Intrinsics.checkNotNullParameter(r100, "tuningVolumeContentArea");
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r101 = this.f143514a;
        if (r101 == null) goto L7;
        MutableLiveData<Boolean> r102 = r101.F();
        if (r102 == null) goto L7;
        r102.observe(r100, new a(this, r100));
    L7:
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r103 = this.f143514a;
        if (r103 == null) goto L11;
        r103.L();
        return;
    }

    @Override // gc0.d
    public final void b(LifecycleOwner r100) {
        Intrinsics.checkNotNullParameter(r100, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r100, "lifecycleOwner");
    }

    @Override // gc0.d
    public final void c(TuningVolumeContentArea r100, WeakReference<Context> r101) {
        Intrinsics.checkNotNullParameter(r100, "tuningVolumeContentArea");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        r100.removeAllViews();
        Context r102 = r101.get();
        if (r102 == null) goto L6;
        r100.a(TuningVolumeType.EAR_BACK_VOLUME, new com.bytedance.android.live.ktv.common.tuningpanel.tuningvolume.view.j(new b(this), r102, false, 28));
        TuningVolumeType r103 = TuningVolumeType.VOCAL_VOLUME;
        com.bytedance.android.live.ktv.common.tuningpanel.tuningvolume.view.j r104 = new com.bytedance.android.live.ktv.common.tuningpanel.tuningvolume.view.j(new c(this), r102, false, 28);
        r104.setPadding(s1.f(16.0f), s1.f(25.0f), s1.f(16.0f), s1.f(25.0f));
        Unit r105 = Unit.INSTANCE;
        r100.a(r103, r104);
        return;
    }
}
