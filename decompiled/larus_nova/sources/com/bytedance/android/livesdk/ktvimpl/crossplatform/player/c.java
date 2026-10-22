package com.bytedance.android.livesdk.ktvimpl.crossplatform.player;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.bytedance.android.livesdk.ktvimpl.crossplatform.earmonitor.KtvEarMonitor;
import com.google.gson.JsonObject;
import kotlin.Pair;

/* JADX INFO: loaded from: classes10.dex */
public interface c {
    String b();

    fe2.a c();

    com.bytedance.android.livesdk.ktvimpl.crossplatform.midi.a d();

    void e(LifecycleOwner r100, Observer<jd2.c> r101);

    jd2.c f();

    KtvEarMonitor g();

    void h();

    boolean i();

    void j();

    b k();

    void l(LifecycleOwner r100, Observer<jd2.c> r101);

    void m(JsonObject r100);

    jd2.a o();

    void observeMusicPlayerState(LifecycleOwner r100, com.ss.android.ugc.aweme.compat.nullable.Observer<Boolean> r101);

    Pair<Boolean, Boolean> p(String r100);

    void q(jd2.c r100);

    void r(LifecycleOwner r100, Observer<jd2.a> r101);

    void s();
}
