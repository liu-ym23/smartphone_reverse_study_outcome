package com.bytedance.android.livesdk.interactivity.api.utils;

import com.bytedance.common.wschannel.WsConstants;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u0012\n\u0002\b\n\b\u0007\u0018\u0000 \u00112\u00020\u0001:\u0001\u0012B\u0011\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0010\u0010\u000fR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/utils/PSTopMessagePayload;", "", "", "actualRoomId", "J", "getActualRoomId", "()J", "setActualRoomId", "(J)V", "", WsConstants.KEY_PAYLOAD, "[B", "getPayload", "()[B", "setPayload", "([B)V", "<init>", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PSTopMessagePayload {
    public static final a Companion = null;
    public static final String TAG = "PS_BACKEND_TOP_MESSAGE";
    private long actualRoomId;
    private byte[] payload;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public final long getActualRoomId() {
        return this.actualRoomId;
    }

    public final byte[] getPayload() {
        return this.payload;
    }

    public PSTopMessagePayload(byte[] r100) {
        this.payload = r100;
    }

    public final void setActualRoomId(long r100) {
        this.actualRoomId = r100;
    }

    public final void setPayload(byte[] r100) {
        this.payload = r100;
    }
}
