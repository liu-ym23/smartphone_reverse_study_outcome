package com.obric.aiagent.skill.manager.impl;

import android.content.Context;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;

/* JADX INFO: compiled from: SkillFileStore.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class dv {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final dv f19775a = null;

    static {
        f19775a = new dv();
    }

    private dv() {
    }

    public final File a(Context r2) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r1, "context");
        return new File(r1.getFilesDir(), "skill_manager_store");
    }

    public final File b(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "context");
        return new File(a(r4), "covers");
    }
}
