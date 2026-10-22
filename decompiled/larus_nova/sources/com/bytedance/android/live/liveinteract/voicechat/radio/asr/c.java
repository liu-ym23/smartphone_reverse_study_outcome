package com.bytedance.android.live.liveinteract.voicechat.radio.asr;

import com.bytedance.android.live.liveinteract.voicechat.radio.asr.g;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.speech.speechengine.SpeechEngine;
import com.bytedance.speech.speechengine.SpeechEngineGenerator;
import java.io.File;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public abstract class c<T extends g> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicInteger f80498a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SpeechEngine f80499b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile boolean f80500c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public T f80501d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f80502e;

    public static final class a {
    }

    static {
    }

    public c() {
        Intrinsics.checkNotNullParameter("AsrEngine", "name");
        this.f80502e = "AsrEngine";
        this.f80498a = new AtomicInteger(0);
        this.f80499b = SpeechEngineGenerator.getInstance();
    }

    public final boolean b() {
        int r100 = this.f80498a.get();
        if (r100 != 2) goto L5;
    L8:
        return true;
    L5:
        if (r100 == 3) goto L8;
        return false;
    }

    public static PolarisFileWrapper a(String r100) {
        if (r100 != null) goto L4;
    L7:
        boolean r101 = true;
    L8:
        PolarisFileWrapper r102 = null;
        if (r101 == false) goto L11;
        return null;
    L11:
        File r103 = jc1.a.b().getFilesDir();
        if (r103 != null) goto L14;
        return null;
    L14:
        PolarisFileWrapper r104 = new PolarisFileWrapper(r103, r100);
        if (r104.exists() == true) goto L24;
        r104.mkdir();     // Catch: Exception -> L21
        r102 = r104;
    L20:
        return r102;
    L24:
        return r104;
    L4:
        if (r100.length() == 0) goto L7;
        r101 = false;
        goto L8
    }

    public final void c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "info");
        int r101 = x8.a.f562881a;
        x8.a.d("MultiLinkAsrEngine", this.f80502e + ": " + r100, false);
    }

    public final void d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "info");
        int r101 = x8.a.f562881a;
        x8.a.b("MultiLinkAsrEngine", this.f80502e + ": " + r100, false);
    }
}
