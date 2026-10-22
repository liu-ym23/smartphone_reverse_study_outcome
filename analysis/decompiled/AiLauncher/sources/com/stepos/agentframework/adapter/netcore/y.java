package com.stepos.agentframework.adapter.netcore;

import com.autonavi.aps.amapapi.config.Const;
import e8.C4011c;
import e8.UploadConfig;
import h8.C4148a;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\r\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/stepos/agentframework/adapter/netcore/y;", "", "<init>", "()V", "Le8/b;", "config", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Le8/b;)V", "", "TAG", "Ljava/lang/String;", "", "initialized", "Z", "protocol_netcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class y {
    public static final y INSTANCE = new y();
    private static final String TAG = "TOSUploadHelper";
    private static volatile boolean initialized;

    public final void a(UploadConfig config) {
        kotlin.jvm.internal.p.i(config, "config");
        if (initialized) {
            return;
        }
        synchronized (this) {
            try {
                if (!initialized) {
                    C4011c.f32340a.a(config);
                    initialized = true;
                    C4148a.k(TAG, "TOS SDK initialized", false, 4, null);
                }
                Y8.t tVar = Y8.t.f7040a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
