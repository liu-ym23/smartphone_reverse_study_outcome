package com.bytedance.android.livesdk.interactivity.api.entity;

import com.ss.android.ugc.effectmanager.common.EffectConstants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/entity/PSMessagePriority;", "", "", "priority", "Ljava/lang/String;", "getPriority", "()Ljava/lang/String;", "HIGH", EffectConstants.NORMAL, "LOW", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum PSMessagePriority extends Enum<PSMessagePriority> {
    public static final PSMessagePriority HIGH = null;
    public static final PSMessagePriority LOW = null;
    public static final PSMessagePriority NORMAL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PSMessagePriority[] f133131a = null;
    private final String priority;

    static {
        PSMessagePriority r100 = new PSMessagePriority("HIGH", 0, "high");
        HIGH = r100;
        PSMessagePriority r101 = new PSMessagePriority(EffectConstants.NORMAL, 1, "normal");
        NORMAL = r101;
        PSMessagePriority r102 = new PSMessagePriority("LOW", 2, "low");
        LOW = r102;
        f133131a = new PSMessagePriority[]{r100, r101, r102};
    }

    public static PSMessagePriority valueOf(String r100) {
        return (PSMessagePriority) r27.a.a(PSMessagePriority.class, r100);
    }

    public static PSMessagePriority[] values() {
        return (PSMessagePriority[]) f133131a.clone();
    }

    public final String getPriority() {
        return this.priority;
    }

    public PSMessagePriority(String r100, int r101, String r102) {
        super(r100, r101);
        this.priority = r102;
    }
}
