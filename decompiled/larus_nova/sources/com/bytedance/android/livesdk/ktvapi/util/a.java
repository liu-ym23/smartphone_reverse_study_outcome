package com.bytedance.android.livesdk.ktvapi.util;

import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes9.dex */
public interface a {
    void Gd(LifecycleOwner r100, Observer<e> r101);

    List<jd2.e> Sh();

    void Vi(MusicPanel r100, Function1<Object, Unit> r101, Function1<? super Throwable, Unit> r102);

    jd2.d Ze();

    e bj();

    void cancelApply(h80.a<Boolean> r100);

    void gj(MusicPanel r100, Function1<? super com.bytedance.android.live.network.response.e<Object>, Unit> r101, Function1<? super Throwable, Unit> r102);

    int i0();

    void i5(IBaseUser r100, h80.a<Boolean> r101, String r102);

    void r9(LifecycleOwner r100, Observer<List<jd2.e>> r101);

    void z9(h80.a<Boolean> r100);
}
