package com.bytedance.android.livesdk.audiencerecord;

import io.reactivex.functions.Action;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes7.dex */
public final class z implements Action {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ArrayList f104091a;

    public z(ArrayList r100) {
        this.f104091a = r100;
    }

    @Override // io.reactivex.functions.Action
    public final void run() {
        int r100 = ue1.a.f549790a;
        ue1.a.a(this.f104091a);
    }
}
