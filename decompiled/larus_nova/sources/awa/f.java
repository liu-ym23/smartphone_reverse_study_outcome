package awa;

import androidx.camera.video.AudioStats;
import com.bytedance.android.ec.slice.SliceInitService;
import com.larksuite.framework.callback.IGetDataCallback;
import io.reactivex.Scheduler;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class f implements c {
    @Inject
    public f() {
    }

    @Override // awa.c
    public final int T1(String r100, Class<?> r101) {
        Intrinsics.checkNotNullParameter(r101, "clazz");
        return 0;
    }

    @Override // awa.c
    public final String V5(String r100, Class<?> r101) {
        Intrinsics.checkNotNullParameter(r101, "clazz");
        return "";
    }

    @Override // awa.c
    public final long b4(String r100, Class<?> r101) {
        Intrinsics.checkNotNullParameter(r101, "clazz");
        return 0;
    }

    @Override // awa.c
    public final double m6(String r100, Class<?> r101) {
        Intrinsics.checkNotNullParameter(r101, "clazz");
        return AudioStats.AUDIO_AMPLITUDE_NONE;
    }

    @Override // awa.c
    public final String q0(String r100, String r101, boolean r102) {
        return SliceInitService.DEFAULT_SWITCH;
    }

    @Override // awa.c
    public final boolean s3(String r100, Class<?> r101) {
        Intrinsics.checkNotNullParameter(r101, "clazz");
        return false;
    }

    @Override // awa.c
    public final <T> T y0(String r100, Class<T> r101) {
        Intrinsics.checkNotNullParameter(r101, "clazz");
        return r101.newInstance();
    }

    @Override // awa.c
    public final void Bd(String r100, Class<?> r101, IGetDataCallback<Double> r102) {
        Intrinsics.checkNotNullParameter(r101, "clazz");
        if (r102 == null) goto L6;
        r102.onSuccess(Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE));
        return;
    }

    @Override // awa.c
    public final void C9(String r100, Class<?> r101, IGetDataCallback<String> r102) {
        Intrinsics.checkNotNullParameter(r101, "clazz");
        if (r102 == null) goto L6;
        r102.onSuccess("");
        return;
    }

    @Override // awa.c
    public final <T> void M5(String r100, Class<T> r101, IGetDataCallback<T> r102) {
        Intrinsics.checkNotNullParameter(r101, "clazz");
        if (r102 == null) goto L6;
        r102.onSuccess(r101.newInstance());
        return;
    }

    @Override // awa.c
    public final void k9(String r100, Class<?> r101, IGetDataCallback<Integer> r102) {
        Intrinsics.checkNotNullParameter(r101, "clazz");
        if (r102 == null) goto L6;
        r102.onSuccess(0);
        return;
    }

    @Override // awa.c
    public final void sc(String r100, Class<?> r101, IGetDataCallback<Boolean> r102) {
        Intrinsics.checkNotNullParameter(r101, "clazz");
        if (r102 == null) goto L6;
        r102.onSuccess(Boolean.FALSE);
        return;
    }

    @Override // awa.c
    public final void D7(String r100, Class<?> r101, Scheduler r102, Scheduler r103, IGetDataCallback<Double> r104) {
        Intrinsics.checkNotNullParameter(r101, "clazz");
        if (r104 == null) goto L6;
        r104.onSuccess(Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE));
        return;
    }

    @Override // awa.c
    public final void f7(String r100, Class<?> r101, Scheduler r102, Scheduler r103, IGetDataCallback<Integer> r104) {
        Intrinsics.checkNotNullParameter(r101, "clazz");
        if (r104 == null) goto L6;
        r104.onSuccess(0);
        return;
    }

    @Override // awa.c
    public final void m2(String r100, Class<?> r101, Scheduler r102, Scheduler r103, IGetDataCallback<Boolean> r104) {
        Intrinsics.checkNotNullParameter(r101, "clazz");
        if (r104 == null) goto L6;
        r104.onSuccess(Boolean.FALSE);
        return;
    }

    @Override // awa.c
    public final void p5(String r100, Class<?> r101, Scheduler r102, Scheduler r103, IGetDataCallback<String> r104) {
        Intrinsics.checkNotNullParameter(r101, "clazz");
        if (r104 == null) goto L6;
        r104.onSuccess("");
        return;
    }

    @Override // awa.c
    public final <T> void x3(String r100, Class<T> r101, Scheduler r102, Scheduler r103, IGetDataCallback<T> r104) {
        Intrinsics.checkNotNullParameter(r101, "clazz");
        if (r104 == null) goto L6;
        r104.onSuccess(r101.newInstance());
        return;
    }
}
