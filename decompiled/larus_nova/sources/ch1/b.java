package ch1;

import com.bytedance.android.livesdk.chatroom.event.live.MonitorMessageType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MonitorMessageType f23757a;

    public b() {
        this(0);
    }

    public final MonitorMessageType getType() {
        return this.f23757a;
    }

    public b(MonitorMessageType r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        this.f23757a = r100;
    }

    public /* synthetic */ b(int r100) {
        this(MonitorMessageType.UNKNOWN);
    }
}
