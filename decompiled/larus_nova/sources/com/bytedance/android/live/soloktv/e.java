package com.bytedance.android.live.soloktv;

import com.bytedance.android.live.ktv.common.model.KtvMode;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class e implements bb0.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f101075a = null;

    public e() {
    }

    @Override // bb0.a
    public final String a() {
        return null;
    }

    @Override // bb0.a
    public final boolean b() {
        return true;
    }

    @Override // bb0.a
    public final String c() {
        return null;
    }

    @Override // bb0.a
    public final void e(List<Long> r100) {
        Intrinsics.checkNotNullParameter(r100, "newList");
    }

    @Override // bb0.a
    public final boolean f() {
        return false;
    }

    @Override // bb0.a
    public final List<Long> g() {
        return null;
    }

    @Override // bb0.a
    public final void h(long r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "musicTitle");
    }

    @Override // bb0.a
    public final boolean i(long r100) {
        return false;
    }

    @Override // bb0.a
    public final String k() {
        return "SoloKtv";
    }

    @Override // bb0.a
    public final boolean l() {
        return false;
    }

    static {
        f101075a = new e();
    }

    @Override // bb0.a
    public final List<String> j() {
        return CollectionsKt.emptyList();
    }

    @Override // bb0.a
    public final KtvMode d() {
        return KtvMode.SOLO_KTV;
    }
}
