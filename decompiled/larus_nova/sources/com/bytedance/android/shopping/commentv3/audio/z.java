package com.bytedance.android.shopping.commentv3.audio;

import android.content.Context;
import android.media.AudioManager;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class z implements r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f172655a;

    public static final class a {
    }

    public static final class b implements s {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f172656a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final AudioManager f172657b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final AudioManager.OnAudioFocusChangeListener f172658c;

        public b(AudioManager r100) {
            a0 r101 = a0.f172607a;
            Intrinsics.checkNotNullParameter(r100, "audioManager");
            Intrinsics.checkNotNullParameter(r101, "listener");
            this.f172657b = r100;
            this.f172658c = r101;
        }

        @Override // com.bytedance.android.shopping.commentv3.audio.s
        public final void a(StopReason r100) {
            Intrinsics.checkNotNullParameter(r100, "reason");
            if (this.f172656a == false) goto L5;
            return;
        L5:
            this.f172656a = true;
            this.f172657b.abandonAudioFocus(this.f172658c);     // Catch: Exception -> L8
            dm.a.a("CommentExternalAudio").i("restore external audio, reason: " + r100);     // Catch: Exception -> L8
            return;
        L8:
            e = move-exception;
            dm.a.a("CommentExternalAudio").b("restore external audio failed, reason: " + r100, e);
        }
    }

    static {
    }

    public z(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f172655a = r100.getApplicationContext();
    }

    @Override // com.bytedance.android.shopping.commentv3.audio.r
    public final b a(t r100) {
        Intrinsics.checkNotNullParameter(r100, "request");
        if (r100.f172637e != ExternalAudioTargetScope.NONE) goto L18;
        return null;
    L18:
        Object r101 = this.f172655a.getSystemService("audio");     // Catch: Exception -> L15
        if ((r101 instanceof AudioManager) == true) goto L8;
        r101 = null;
    L8:
        AudioManager r102 = (AudioManager) r101;     // Catch: Exception -> L15
        if (r102 != null) goto L11;
        return null;
    L11:
        int r103 = r102.requestAudioFocus(a0.f172607a, 3, 2);     // Catch: Exception -> L15
        dm.a.a("CommentExternalAudio").i("interrupt external audio, result: " + r103 + ", sliceId: " + r100.f172634b);     // Catch: Exception -> L15
        if (r103 != 1) goto L20;
        return new b(r102);
    L20:
        return null;
    L15:
        e = move-exception;
        dm.a.a("CommentExternalAudio").b("interrupt external audio failed, sliceId: " + r100.f172634b, e);
        return null;
    }
}
