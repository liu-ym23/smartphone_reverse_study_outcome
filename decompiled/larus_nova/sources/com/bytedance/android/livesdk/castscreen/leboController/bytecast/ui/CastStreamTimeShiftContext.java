package com.bytedance.android.livesdk.castscreen.leboController.bytecast.ui;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.episode.EpisodeExtraInfo;
import com.bytedance.android.livesdkapi.depend.model.live.episode.IVSCameraInfo;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.m;
import com.bytedance.live.datacontext.p;
import com.bytedance.live.datacontext.q;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.aweme.shortvideo.ShortVideoSegments;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b>\u0010?J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\"\u0010\f\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0012\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R\"\u0010\u0016\u001a\u00020\u00158\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0017\u0010\u001d\u001a\u00020\u001c8\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\"\u0010\"\u001a\u00020!8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b\"\u0010$\"\u0004\b%\u0010&R\"\u0010'\u001a\u00020!8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b'\u0010#\u001a\u0004\b(\u0010$\"\u0004\b)\u0010&R!\u0010/\u001a\b\u0012\u0004\u0012\u00020\u000b0*8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.R!\u00102\u001a\b\u0012\u0004\u0012\u00020\u000b0*8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b0\u0010,\u001a\u0004\b1\u0010.R!\u00105\u001a\b\u0012\u0004\u0012\u00020\u000b0*8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b3\u0010,\u001a\u0004\b4\u0010.R!\u00109\u001a\b\u0012\u0004\u0012\u0002060*8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b7\u0010,\u001a\u0004\b8\u0010.R!\u0010;\u001a\b\u0012\u0004\u0012\u00020!0*8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b:\u0010,\u001a\u0004\b;\u0010.R!\u0010=\u001a\b\u0012\u0004\u0012\u00020!0*8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b<\u0010,\u001a\u0004\b=\u0010.¨\u0006@"}, d2 = {"Lcom/bytedance/android/livesdk/castscreen/leboController/bytecast/ui/CastStreamTimeShiftContext;", "Lcom/bytedance/live/datacontext/DataContext;", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", "", "initRoomData", "Landroid/os/Handler;", "handler", "Landroid/os/Handler;", "getHandler", "()Landroid/os/Handler;", "", "roomId", "J", "getRoomId", "()J", "setRoomId", "(J)V", ShortVideoSegments.KEY_CAMERA_ID, "getCameraId", "setCameraId", "", "cameraIdFrom", "Ljava/lang/String;", "getCameraIdFrom", "()Ljava/lang/String;", "setCameraIdFrom", "(Ljava/lang/String;)V", "Ljava/lang/Runnable;", "runnable", "Ljava/lang/Runnable;", "getRunnable", "()Ljava/lang/Runnable;", "", "isSwitchLivePosition", "Z", "()Z", "setSwitchLivePosition", "(Z)V", "reRequestData", "getReRequestData", "setReRequestData", "Lcom/bytedance/live/datacontext/m;", "currentTime$delegate", "Lcom/bytedance/live/datacontext/p;", "getCurrentTime", "()Lcom/bytedance/live/datacontext/m;", "currentTime", "totalTime$delegate", "getTotalTime", "totalTime", "currentDisplayTime$delegate", "getCurrentDisplayTime", "currentDisplayTime", "Lmf1/b;", "atLatest$delegate", "getAtLatest", "atLatest", "isCastPlaying$delegate", "isCastPlaying", "isSupportStreamTimeShift$delegate", "isSupportStreamTimeShift", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CastStreamTimeShiftContext extends DataContext {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    private final p atLatest$delegate;
    private long cameraId;
    private String cameraIdFrom;
    private final p currentDisplayTime$delegate;
    private final p currentTime$delegate;
    private final Handler handler;
    private final p isCastPlaying$delegate;
    private final p isSupportStreamTimeShift$delegate;
    private boolean isSwitchLivePosition;
    private boolean reRequestData;
    private long roomId;
    private final Runnable runnable;
    private final p totalTime$delegate;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CastStreamTimeShiftContext f104520a;

        @Override // java.lang.Runnable
        public final void run() {
            m<Long> r100 = this.f104520a.getCurrentTime();     // Catch: Throwable -> L4
            r100.setValue(Long.valueOf(r100.getValue().longValue() + ((long) 1000)));     // Catch: Throwable -> L4
            this.f104520a.getHandler().postDelayed(this, 1000);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(CastStreamTimeShiftContext r100) {
            this.f104520a = r100;
        }
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(CastStreamTimeShiftContext.class, "currentTime", "getCurrentTime()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(CastStreamTimeShiftContext.class, "totalTime", "getTotalTime()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(CastStreamTimeShiftContext.class, "currentDisplayTime", "getCurrentDisplayTime()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(CastStreamTimeShiftContext.class, "atLatest", "getAtLatest()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(CastStreamTimeShiftContext.class, "isCastPlaying", "isCastPlaying()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(CastStreamTimeShiftContext.class, "isSupportStreamTimeShift", "isSupportStreamTimeShift()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0))};
    }

    public final m<mf1.b> getAtLatest() {
        return (m) this.atLatest$delegate.a(this, $$delegatedProperties[3]);
    }

    public final m<Long> getCurrentDisplayTime() {
        return (m) this.currentDisplayTime$delegate.a(this, $$delegatedProperties[2]);
    }

    public final m<Long> getCurrentTime() {
        return (m) this.currentTime$delegate.a(this, $$delegatedProperties[0]);
    }

    public final m<Long> getTotalTime() {
        return (m) this.totalTime$delegate.a(this, $$delegatedProperties[1]);
    }

    public final m<Boolean> isCastPlaying() {
        return (m) this.isCastPlaying$delegate.a(this, $$delegatedProperties[4]);
    }

    public final m<Boolean> isSupportStreamTimeShift() {
        return (m) this.isSupportStreamTimeShift$delegate.a(this, $$delegatedProperties[5]);
    }

    public CastStreamTimeShiftContext() {
        this.handler = new Handler(Looper.getMainLooper());
        this.cameraIdFrom = "";
        this.runnable = new a(this);
        this.reRequestData = true;
        this.currentTime$delegate = q.d(this, 0L);
        this.totalTime$delegate = q.d(this, 0L);
        this.currentDisplayTime$delegate = q.d(this, 0L);
        this.atLatest$delegate = q.d(this, new mf1.b(true, false));
        Boolean r100 = Boolean.FALSE;
        this.isCastPlaying$delegate = q.d(this, r100);
        this.isSupportStreamTimeShift$delegate = q.d(this, r100);
    }

    public final long getCameraId() {
        return this.cameraId;
    }

    public final String getCameraIdFrom() {
        return this.cameraIdFrom;
    }

    public final Handler getHandler() {
        return this.handler;
    }

    public final boolean getReRequestData() {
        return this.reRequestData;
    }

    public final long getRoomId() {
        return this.roomId;
    }

    public final Runnable getRunnable() {
        return this.runnable;
    }

    public final boolean isSwitchLivePosition() {
        return this.isSwitchLivePosition;
    }

    public final void initRoomData(DataCenter r100) {
        long r101 = 0;
        if (r100 == null) goto L7;
        Room r102 = z.o(r100);
        if (r102 == null) goto L7;
        long r103 = r102.getRoomId();
    L8:
        this.roomId = r103;
        long r104 = -2;
        if (r100 == null) goto L40;
        Room r105 = z.o(r100);
        if (r105 == null) goto L40;
        EpisodeExtraInfo r106 = r105.getEpisodeComponentData();
        if (r106 == null) goto L40;
        List<IVSCameraInfo> r107 = r106.getCameraInfos();
        if (r107 == null) goto L40;
        if ((!r107.isEmpty()) != true) goto L40;
        RoomContext r108 = RoomContext.a.c(RoomContext.Companion, r100, 0, 2);
        if (r108 == null) goto L25;
        m<Long> r109 = r108.getCameraId();
        if (r109 == null) goto L25;
        Long r110 = r109.getValue();
        if (r110 == null) goto L25;
        long r111 = r110.longValue();
    L27:
        if (r111 <= 0) goto L29;
        r101 = r111;
    L34:
        this.cameraId = r101;
        StringBuilder r112 = new StringBuilder("tempCameraId=");
        r112.append(r111);
        r112.append(",defaultCameraId=");
        Room r113 = z.o(r100);
        if (r113 == null) goto L39;
        EpisodeExtraInfo r114 = r113.getEpisodeComponentData();
        if (r114 == null) goto L39;
        r104 = r114.getDefaultCameraId();
    L39:
        r112.append(r104);
        this.cameraIdFrom = r112.toString();
        return;
    L29:
        Room r115 = z.o(r100);
        if (r115 == null) goto L34;
        EpisodeExtraInfo r116 = r115.getEpisodeComponentData();
        if (r116 == null) goto L34;
        r101 = r116.getDefaultCameraId();
    L25:
        r111 = 0;
    L40:
        if (r100 == null) goto L46;
        Room r117 = z.o(r100);
        if (r117 == null) goto L46;
        EpisodeExtraInfo r118 = r117.getEpisodeComponentData();
        if (r118 == null) goto L46;
        Long r119 = Long.valueOf(r118.getDefaultCameraId());
    L52:
        if (r119 == null) goto L54;
        long r120 = r119.longValue();
    L55:
        this.cameraId = r120;
        StringBuilder r121 = new StringBuilder("defaultCameraId=");
        if (r100 == null) goto L62;
        Room r122 = z.o(r100);
        if (r122 == null) goto L62;
        EpisodeExtraInfo r123 = r122.getEpisodeComponentData();
        if (r123 == null) goto L62;
        long r124 = r123.getDefaultCameraId();
    L63:
        r121.append(r124);
        r121.append(", RoomContext.cameraId=");
        RoomContext r125 = RoomContext.a.c(RoomContext.Companion, r100, 0, 2);
        if (r125 == null) goto L70;
        m<Long> r126 = r125.getCameraId();
        if (r126 == null) goto L70;
        Long r127 = r126.getValue();
        if (r127 == null) goto L70;
        r104 = r127.longValue();
    L70:
        r121.append(r104);
        this.cameraIdFrom = r121.toString();
        return;
    L62:
        r124 = -2;
        goto L63
    L54:
        r120 = 0;
    L46:
        RoomContext r128 = RoomContext.a.c(RoomContext.Companion, r100, 0, 2);
        if (r128 == null) goto L51;
        m<Long> r129 = r128.getCameraId();
        if (r129 == null) goto L51;
        r119 = r129.getValue();
    L51:
        r119 = null;
    L7:
        r103 = 0;
        goto L8
    }

    public final void setCameraId(long r100) {
        this.cameraId = r100;
    }

    public final void setCameraIdFrom(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.cameraIdFrom = r100;
    }

    public final void setReRequestData(boolean r100) {
        this.reRequestData = r100;
    }

    public final void setRoomId(long r100) {
        this.roomId = r100;
    }

    public final void setSwitchLivePosition(boolean r100) {
        this.isSwitchLivePosition = r100;
    }
}
