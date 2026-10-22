package com.bytedance.android.live.soloktv.tuningpanel.callback;

import android.content.Context;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.ktv.common.tuningpanel.model.TuningVolumeType;
import com.bytedance.android.live.ktv.common.tuningpanel.tuningvolume.view.TuningVolumeContentArea;
import com.bytedance.android.live.ktv.common.tuningpanel.tuningvolume.view.j;
import com.bytedance.android.livesdk.widget.SeekBarWithProgress;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class f implements gc0.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.android.live.ktv.common.tuningpanel.ability.a f101575a;

    public static final class a<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f f101576a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ TuningVolumeContentArea f101577b;

        public a(f r100, TuningVolumeContentArea r101) {
            this.f101576a = r100;
            this.f101577b = r101;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            Boolean r101 = (Boolean) r100;
            View r102 = this.f101577b.b(TuningVolumeType.EAR_BACK_VOLUME);
            if (r102 == null) goto L21;
            com.bytedance.android.live.ktv.common.tuningpanel.ability.a r103 = this.f101576a.f101575a;
            if (r103 != null) goto L7;
        L19:
            r102.setVisibility(8);
            return;
        L7:
            if (r103.h() == true) goto L19;
            Boolean r104 = Boolean.TRUE;
            if (Intrinsics.areEqual(r101, r104) == false) goto L19;
            com.bytedance.android.live.ktv.common.tuningpanel.ability.a r105 = this.f101576a.f101575a;
            if (r105 == null) goto L13;
            Boolean r106 = r105.I();
        L15:
            if (Intrinsics.areEqual(r106, r104) == false) goto L19;
            com.bytedance.android.live.ktv.common.tuningpanel.ability.a r107 = this.f101576a.f101575a;
            if (r107 == null) goto L19;
            r107.i();
            goto L19
        L13:
            r106 = null;
            goto L15
        }
    }

    public static final class b implements gc0.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f f101578a;

        @Override // gc0.c
        public final int c() {
            return 100;
        }

        @Override // gc0.c
        public final SeekBarWithProgress.b b() {
            return new gc0.b();
        }

        @Override // gc0.c
        public final int d() {
            com.bytedance.android.live.ktv.common.tuningpanel.ability.a r100 = this.f101578a.f101575a;
            if (r100 != null) goto L7;
            return 50;
        L7:
            return (int) r100.f();
        }

        @Override // gc0.c
        public final String a() {
            return s1.B(R.string.ttlive_ktv_voice_volume);
        }

        public b(f r100) {
            this.f101578a = r100;
        }

        @Override // gc0.c
        public final void onProgressChanged(int r100) {
            com.bytedance.android.live.ktv.common.tuningpanel.ability.a r101 = this.f101578a.f101575a;
            if (r101 == null) goto L6;
            r101.g(r100);
            return;
        }
    }

    public static final class c implements gc0.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f f101579a;

        public static final class a implements SeekBarWithProgress.b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ c f101580a;

            @Override // com.bytedance.android.livesdk.widget.SeekBarWithProgress.b
            public final boolean a() {
                com.bytedance.android.live.ktv.common.tuningpanel.ability.a r100 = this.f101580a.f101579a.f101575a;
                if (r100 != null) goto L5;
                return true;
            L5:
                if (r100.d(TuningVolumeType.ACCOMPANIMENT_VOLUME) != true) goto L10;
                return false;
            L10:
                return true;
            }

            public a(c r100) {
                this.f101580a = r100;
            }
        }

        @Override // gc0.c
        public final int c() {
            return 100;
        }

        @Override // gc0.c
        public final SeekBarWithProgress.b b() {
            return new a(this);
        }

        @Override // gc0.c
        public final int d() {
            com.bytedance.android.live.ktv.common.tuningpanel.ability.a r100 = this.f101579a.f101575a;
            if (r100 != null) goto L7;
            return 50;
        L7:
            return (int) r100.A();
        }

        @Override // gc0.c
        public final String a() {
            return s1.B(R.string.ttlive_ktv_music_volume);
        }

        public c(f r100) {
            this.f101579a = r100;
        }

        @Override // gc0.c
        public final void onProgressChanged(int r100) {
            com.bytedance.android.live.ktv.common.tuningpanel.ability.a r101 = this.f101579a.f101575a;
            if (r101 == null) goto L6;
            r101.G(r100);
            return;
        }
    }

    public f(com.bytedance.android.live.ktv.common.tuningpanel.ability.a r100) {
        this.f101575a = r100;
    }

    @Override // gc0.d
    public final void a(TuningVolumeContentArea r100) {
        Intrinsics.checkNotNullParameter(r100, "tuningVolumeContentArea");
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r101 = this.f101575a;
        if (r101 == null) goto L8;
        MutableLiveData<Boolean> r102 = r101.F();
        if (r102 == null) goto L9;
        r102.observe(r100, new a(this, r100));
        return;
    L9:
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
        r100.a(TuningVolumeType.EAR_BACK_VOLUME, new j(new b(this), r102, false, 28));
        r100.a(TuningVolumeType.ACCOMPANIMENT_VOLUME, new j(new c(this), r102, false, 28));
        return;
    }
}
