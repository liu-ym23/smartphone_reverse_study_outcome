package com.bytedance.android.livehostapi.business.depend.floatwindow;

import android.os.Bundle;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.tencent.connect.share.QzonePublish;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0002\u0010\fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001d\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/livehostapi/business/depend/floatwindow/FloatWindowContext;", "", "room", "Lcom/bytedance/android/livesdkapi/depend/model/live/Room;", QzonePublish.PUBLISH_TO_QZONE_VIDEO_SIZE, "Lkotlin/Pair;", "", "arguments", "Landroid/os/Bundle;", "param", "", "", "(Lcom/bytedance/android/livesdkapi/depend/model/live/Room;Lkotlin/Pair;Landroid/os/Bundle;Ljava/util/Map;)V", "getArguments", "()Landroid/os/Bundle;", "getParam", "()Ljava/util/Map;", "getRoom", "()Lcom/bytedance/android/livesdkapi/depend/model/live/Room;", "getVideoSize", "()Lkotlin/Pair;", "hostapp-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class FloatWindowContext {
    private final Bundle arguments;
    private final Map<String, String> param;
    private final Room room;
    private final Pair<Integer, Integer> videoSize;

    public final Bundle getArguments() {
        return this.arguments;
    }

    public final Map<String, String> getParam() {
        return this.param;
    }

    public final Room getRoom() {
        return this.room;
    }

    public final Pair<Integer, Integer> getVideoSize() {
        return this.videoSize;
    }

    public FloatWindowContext(Room r100, Pair<Integer, Integer> r101, Bundle r102, Map<String, String> r103) {
        Intrinsics.checkNotNullParameter(r100, "room");
        Intrinsics.checkNotNullParameter(r101, QzonePublish.PUBLISH_TO_QZONE_VIDEO_SIZE);
        Intrinsics.checkNotNullParameter(r102, "arguments");
        Intrinsics.checkNotNullParameter(r103, "param");
        this.room = r100;
        this.videoSize = r101;
        this.arguments = r102;
        this.param = r103;
    }
}
