package com.bumptech.glide;

import com.bumptech.glide.h;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: TransitionOptions.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class h<CHILD extends h<CHILD, TranscodeType>, TranscodeType> implements Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.bumptech.glide.request.a.c<? super TranscodeType> f3347a;

    public h() {
        this.f3347a = com.bumptech.glide.request.a.a.a();
    }

    public /* synthetic */ Object clone() {
        return a();
    }

    public final CHILD a() {
        return (CHILD) ZeusTransformUtils.preCheckCast(super.clone(), h.class, "com.obric.aiagent.plugin");
    L4:
        e = move-exception;
        throw new RuntimeException(e);
    }

    final com.bumptech.glide.request.a.c<? super TranscodeType> b() {
        return this.f3347a;
    }
}
