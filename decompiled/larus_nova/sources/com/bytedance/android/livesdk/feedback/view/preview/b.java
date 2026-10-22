package com.bytedance.android.livesdk.feedback.view.preview;

import android.view.View;
import com.bytedance.android.live.base.model.feedback.RoomCardStruct;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes8.dex */
public interface b {
    void a(Function0<Unit> r100);

    void b(Function0<Unit> r100);

    void c(RoomCardStruct r100);

    RoomCardStruct getRoomInfo();

    View getView();

    void startPreview();

    void stopPreview();
}
