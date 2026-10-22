package com.bytedance.android.livesdk.chatroom.replay.paid;

import androidx.lifecycle.MutableLiveData;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class f0 implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MutableLiveData<Integer> f109372a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public xl1.b f109373b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<Integer, List<c.a>> f109374c;

    public f0() {
        MutableLiveData<Integer> r100 = new MutableLiveData();
        r100.setValue(-1);
        Unit r101 = Unit.INSTANCE;
        this.f109372a = r100;
        this.f109374c = new LinkedHashMap();
    }

    @Override // com.bytedance.android.livesdk.chatroom.replay.paid.c
    public final List<c.a> a(int r100) {
        return b(this.f109374c, r100);
    }

    public final void c(int r100) {
        Integer r101 = this.f109372a.getValue();
        if (r101 != null) goto L6;
    L8:
        xl1.b r102 = this.f109373b;
        if (r102 == null) goto L11;
        r102.b();
    L11:
        xl1.a.f564433a.getClass();
        Intrinsics.checkNotNullParameter(this, "replayPaidStateHolder");
        xl1.b r103 = new xl1.b(r100, this);
        this.f109373b = r103;
        r103.a();
        this.f109372a.setValue(Integer.valueOf(r100));
        return;
    L6:
        if (r100 != r101.intValue()) goto L8;
    }

    public static List b(Map r100, int r101) {
        LinkedHashMap r102 = (LinkedHashMap) r100;
        List r103 = (List) r102.get(Integer.valueOf(r101));
        if (r103 != null) goto L6;
        r102.put(Integer.valueOf(r101), new ArrayList());
        return b(r102, r101);
    L6:
        return r103;
    }
}
