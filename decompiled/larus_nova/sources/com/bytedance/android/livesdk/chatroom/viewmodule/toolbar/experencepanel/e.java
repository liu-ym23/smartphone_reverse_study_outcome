package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.experencepanel;

import am2.x;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class e<T> implements SingleOnSubscribe {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f116283a;

    public e(boolean r100) {
        this.f116283a = r100;
    }

    @Override // io.reactivex.SingleOnSubscribe
    public final void subscribe(SingleEmitter<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        Pair[] r101 = new Pair[2];
        r101[0] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_BUTTON_TYPE, "extremely_smooth");
        if (this.f116283a == false) goto L5;
        String r102 = "on";
    L6:
        r101[1] = TuplesKt.to("click_type", r102);
        Map<String, String> r103 = MapsKt.mapOf(r101);
        j0.l().sendLog("livesdk_image_quality_button_click", r103, new Object[]{IRoom.class, x.class});
        return;
    L5:
        r102 = "off";
        goto L6
    }
}
