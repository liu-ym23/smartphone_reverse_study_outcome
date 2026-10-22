package cj6;

import com.bytedance.android.livesdk.live.extension.plugin.api.livepusher.ILiveWrappedLivePusher;
import java.nio.ByteBuffer;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f23982b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ByteBuffer f23983a;

    /* JADX INFO: renamed from: cj6.a$a, reason: collision with other inner class name */
    public static final class C0452a {
        public static a a(byte[] r100) {
            Intrinsics.checkNotNullParameter(r100, "source");
            ByteBuffer r101 = ByteBuffer.allocateDirect(r100.length);
            r101.put(r100);
            return new a(r101);
        }
    }

    static {
    }

    public final void a() {
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L12
        ByteBuffer r101 = this.f23983a;     // Catch: Throwable -> L12
        if (r101 != null) goto L5;
        return;
    L5:
        r101.rewind();     // Catch: Throwable -> L12
        if (r101.remaining() > 0) goto L8;
        return;
    L8:
        ILiveWrappedLivePusher.Companion.getClass();     // Catch: Throwable -> L12
        ILiveWrappedLivePusher r102 = ILiveWrappedLivePusher.a.b();     // Catch: Throwable -> L12
        if (r102 == null) goto L17;
        r102.getEffectWrapperAlgorithmResult();     // Catch: Throwable -> L12
        return;
    L17:
        return;
    L12:
        th = move-exception;
        Result.Companion r103 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }

    public a(Object r100) {
        if ((r100 instanceof ByteBuffer) == true) goto L5;
        r100 = null;
    L5:
        this.f23983a = (ByteBuffer) r100;
    }
}
