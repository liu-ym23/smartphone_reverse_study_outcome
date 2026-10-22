package com.bytedance.android.livesdk.config.blackframe;

import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import ns1.a;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0001\u0010B\u0007¢\u0006\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000b¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdk/config/blackframe/AudioBlackFrameOptConfigSerializableObjectImpl;", "Lns1/a;", "", "mEnable", "Z", "s7", "()Z", "", "mOptWidth", "I", "u7", "()I", "mOptHeight", "A1", "<init>", "()V", "Adapter", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class AudioBlackFrameOptConfigSerializableObjectImpl implements a {

    @SerializedName("enable")
    private final boolean mEnable;

    @SerializedName("opt_height")
    private final int mOptHeight;

    @SerializedName("opt_width")
    private final int mOptWidth;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/config/blackframe/AudioBlackFrameOptConfigSerializableObjectImpl$Adapter;", "Lcom/bytedance/tools/kcp/modelx/runtime/internal/decode/SerializableObjectJsonAdapterBase;", "()V", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Adapter extends SerializableObjectJsonAdapterBase {
        public Adapter() {
            super(AudioBlackFrameOptConfigSerializableObjectImpl.class);
        }
    }

    public AudioBlackFrameOptConfigSerializableObjectImpl() {
        this.mEnable = false;
        this.mOptWidth = 0;
        this.mOptHeight = 0;
    }

    @Override // ns1.a
    public final int A1() {
        return this.mOptHeight;
    }

    @Override // ns1.a
    public final boolean s7() {
        return this.mEnable;
    }

    @Override // ns1.a
    public final int u7() {
        return this.mOptWidth;
    }
}
