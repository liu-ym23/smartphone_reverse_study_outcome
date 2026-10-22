package f4;

import android.os.Handler;
import com.bytedance.common.wschannel.heartbeat.HeartBeatReactListener;
import com.bytedance.common.wschannel.heartbeat.IHeartBeatPolicy;
import com.bytedance.common.wschannel.heartbeat.model.IHeartBeatMeta;

/* JADX INFO: loaded from: classes.dex */
public abstract class a implements IHeartBeatPolicy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public IHeartBeatMeta f19472a;

    public a(IHeartBeatMeta r10) {
        this.f19472a = r10;
    }

    public abstract void a(HeartBeatReactListener r10, Handler r11);
}
