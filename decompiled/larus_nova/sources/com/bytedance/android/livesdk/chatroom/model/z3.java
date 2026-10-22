package com.bytedance.android.livesdk.chatroom.model;

import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class z3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f106987a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f106988b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f106989c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a f106990d;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f106991a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final PropertyOwner<Boolean> f106992b;

        public a(int r100) {
            PropertyOwner<Boolean> r101 = new PropertyOwner(Boolean.FALSE);
            Intrinsics.checkNotNullParameter(r101, "loaded");
            this.f106991a = false;
            this.f106992b = r101;
        }
    }

    public z3() {
        this.f106987a = new a(0);
        this.f106988b = new a(0);
        this.f106989c = new a(0);
        this.f106990d = new a(0);
    }
}
