package com.obric.autoaction.app.launcherpage.discovery.util;

import android.text.Spannable;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.m;
import java.util.List;

/* JADX INFO: compiled from: PromptSlotParser.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Spannable f23659a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<m<Integer, Integer>> f23660b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f23661c;

    public c(Spannable r3, List<m<Integer, Integer>> r4, boolean r5) {
        Spannable r6 = (Spannable) ZeusTransformUtils.wrapperContextForParams(r3, Spannable.class, "com.obric.aiagent.plugin");
        List<m<Integer, Integer>> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        o.e(r6, "spannedPrompt");
        o.e(r7, "slots");
        this.f23659a = r6;
        this.f23660b = r7;
        this.f23661c = r5;
    }

    public final Spannable a() {
        return this.f23659a;
    }

    public final List<m<Integer, Integer>> b() {
        return this.f23660b;
    }

    public final void a(boolean r1) {
        this.f23661c = r1;
    }

    public final boolean c() {
        return this.f23661c;
    }
}
