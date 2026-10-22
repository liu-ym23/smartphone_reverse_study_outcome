package com.bytedance.android.live.ktv.common.tuningpanel.tuningeffect.ability;

import com.bytedance.android.live.ktv.common.model.bean.h;
import com.bytedance.android.livesdk.sharedpref.c;
import com.bytedance.android.livesdk.sharedpref.e;
import com.bytedance.android.livesdk.sharedpref.f;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class a<T> implements SingleOnSubscribe {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ List f70524a;

    public a(List r100) {
        this.f70524a = r100;
    }

    @Override // io.reactivex.SingleOnSubscribe
    public final void subscribe(SingleEmitter<Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        Gson r101 = new Gson();
        ArrayList r102 = new ArrayList(this.f70524a.size());
        Iterator<T> r103 = this.f70524a.iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        r102.add(GsonProtectorUtils.toJson(r101, (h) r103.next()));
        goto L4
    L6:
        e<List<String>> r104 = c.f158284m;
        r104.getClass();
        f.d(r104, r102);
    }
}
