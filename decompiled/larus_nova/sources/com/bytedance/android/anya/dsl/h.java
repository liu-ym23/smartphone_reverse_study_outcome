package com.bytedance.android.anya.dsl;

import com.bytedance.android.anya.AnyaDSL;
import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.p;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.sequences.Sequence;

/* JADX INFO: loaded from: classes43.dex */
@AnyaDSL
public final class h<STATE extends MVIState<?>, ACTION extends p> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<i<STATE, ?, ?>> f41596a;

    public final Sequence<i<STATE, ?, ?>> a() {
        return CollectionsKt.asSequence(this.f41596a);
    }

    public h() {
        this.f41596a = new ArrayList();
    }
}
