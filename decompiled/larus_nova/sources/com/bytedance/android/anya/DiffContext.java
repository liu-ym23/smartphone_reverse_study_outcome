package com.bytedance.android.anya;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes43.dex */
@AnyaDSL
public abstract class DiffContext {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Function1<? super v<?, ?>, Unit> f41563a;

    public static final class a extends DiffContext {
        public a() {
        }
    }

    public DiffContext() {
        this.f41563a = DiffContext$onConsumePropertyChange$1.INSTANCE;
    }
}
