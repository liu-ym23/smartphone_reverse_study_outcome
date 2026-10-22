package c4;

import com.bytedance.common.wschannel.channel.impl.ok.ws.CustomHeartBeatWebSocket;
import okhttp3.Response;
import okio.ByteString;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {
    public a() {
    }

    public abstract void a(CustomHeartBeatWebSocket r10, int r11, String r12);

    public void b(CustomHeartBeatWebSocket r10, int r11, String r12) {
    }

    public abstract void c(CustomHeartBeatWebSocket r10, Throwable r11, Response r12);

    public abstract void d(CustomHeartBeatWebSocket r10, String r11);

    public abstract void e(CustomHeartBeatWebSocket r10, ByteString r11);

    public abstract void f(CustomHeartBeatWebSocket r10, Response r11);

    public abstract void g(CustomHeartBeatWebSocket r10, ByteString r11);
}
