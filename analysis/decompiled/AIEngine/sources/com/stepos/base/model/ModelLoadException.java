package com.stepos.base.model;

import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class ModelLoadException extends Exception {

    /* renamed from: a, reason: collision with root package name */
    public final Integer f6319a;

    public /* synthetic */ ModelLoadException(String str, Integer num, int i10) {
        this(str, (Exception) null, (i10 & 4) != 0 ? null : num);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ModelLoadException(String message, Exception exc, Integer num) {
        super(message, exc);
        g.f(message, "message");
        this.f6319a = num;
    }
}
