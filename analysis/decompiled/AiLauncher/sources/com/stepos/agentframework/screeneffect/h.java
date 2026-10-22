package com.stepos.agentframework.screeneffect;

import com.autonavi.aps.amapapi.config.Const;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0006\u0018\u0000 \u00142\u00020\u0001:\u0001\u0007B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\n\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\r\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\t0\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0015"}, d2 = {"Lcom/stepos/agentframework/screeneffect/h;", "", "<init>", "()V", "Lcom/stepos/agentframework/screeneffect/a;", "callback", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Lcom/stepos/agentframework/screeneffect/a;)V", "", "mLastCallbackRms", "D", "", "mLastCallbackTime", "J", "", "mSampleBuffer", "Ljava/util/List;", "mWaveDetectCallback", "Lcom/stepos/agentframework/screeneffect/a;", "Companion", "uikit_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class h {
    private static final long CALLBACK_INTERVAL_MS = 300;
    public static final float DB_MAPPING_MAX = 12.0f;
    public static final float DB_MAPPING_MIN = 0.5f;
    public static final double MIN_DB = -120.0d;
    private static final double MIN_SIGNIFICANT_CHANGE = 0.15d;
    private static final long SAMPLE_INTERVAL_MS = 30;
    private double mLastCallbackRms;
    private long mLastCallbackTime;
    private final List<Double> mSampleBuffer = new ArrayList();
    private a mWaveDetectCallback;

    public void a(a callback) {
        this.mWaveDetectCallback = callback;
    }
}
