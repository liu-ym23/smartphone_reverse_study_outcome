package bw3;

import com.ss.bytertc.engine.type.WarningCode;
import com.ss.ttvideoengine.log.VideoEventOnePlay;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class x {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final x f21127c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final x f21128d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final x f21129e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final x f21130f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final x f21131g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final x f21132h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final x f21133i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final x f21134j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final x f21135k = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f21136a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f21137b;

    public static final class a {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof x) == true) goto L8;
        return false;
    L8:
        x r101 = (x) r100;
        if (this.f21136a == r101.f21136a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f21137b, r101.f21137b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f21136a * 31) + this.f21137b.hashCode();
    }

    public final String toString() {
        return "InnerAudioError(errCode=" + this.f21136a + ", errMsg=" + this.f21137b + ')';
    }

    static {
        f21127c = new x(-2001, "inner audio appletId is empty");
        f21128d = new x(-2002, "inner audio instance not found");
        f21129e = new x(-2003, "inner audio src is empty");
        f21130f = new x(-2004, "inner audio src is invalid");
        f21131g = new x(-2005, "inner audio player unavailable");
        f21132h = new x(-2006, "inner audio seek failed");
        f21133i = new x(VideoEventOnePlay.EXIT_CODE_AFTER_NO_AUDIO_RENDER, "inner audio audioId is empty");
        new x(-2009, "inner audio playback is interrupted");
        new x(WarningCode.WARNING_CODE_SUBSCRIBE_STREAM_FORBIDEN, "inner audio runtime is unavailable");
        f21134j = new x(WarningCode.WARNING_CODE_SEND_CUSTOM_MESSAGE, "inner audio action is invalid");
        f21135k = new x(-2012, "inner audio params are invalid");
    }

    public x(int r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "errMsg");
        this.f21136a = r100;
        this.f21137b = r101;
    }
}
