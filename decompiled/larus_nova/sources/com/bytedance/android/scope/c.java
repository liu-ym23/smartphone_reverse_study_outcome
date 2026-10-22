package com.bytedance.android.scope;

import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes12.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f163436a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List<? extends b> f163437b;

    public static final class a implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f163438a;

        public a() {
        }

        @Override // com.bytedance.android.scope.d
        public final void suppress() {
            this.f163438a = true;
        }
    }

    public c() {
        this.f163436a = new Object();
        this.f163437b = CollectionsKt.emptyList();
    }
}
