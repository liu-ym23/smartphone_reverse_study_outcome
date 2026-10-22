package com.bytedance.android.livesdk.livecommerce.iron.ui;

import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes10.dex */
public interface j {
    RoomContextController b();

    boolean c();

    void d(LifecycleOwner r100, Function1<? super xi2.j, Unit> r101);

    String e();

    xi2.j f();

    List<String> g();

    String getRoomId();

    void h(boolean r100);

    gi2.a j();
}
