package com.bytedance.android.live.liveinteract.voicechat.interactacting;

import com.alibaba.gaiax.model.GXAnimation;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/live/liveinteract/voicechat/interactacting/InteractActingStatus;", "", "", "value", "I", "getValue", "()I", "UNKNOWN", GXAnimation.STATE_START, GXAnimation.STATE_END, "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum InteractActingStatus extends Enum<InteractActingStatus> {
    public static final InteractActingStatus END = null;
    public static final InteractActingStatus START = null;
    public static final InteractActingStatus UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ InteractActingStatus[] f80294a = null;
    private final int value;

    static {
        InteractActingStatus r100 = new InteractActingStatus("UNKNOWN", 0, 0);
        UNKNOWN = r100;
        InteractActingStatus r101 = new InteractActingStatus(GXAnimation.STATE_START, 1, 1);
        START = r101;
        InteractActingStatus r102 = new InteractActingStatus(GXAnimation.STATE_END, 2, 2);
        END = r102;
        f80294a = new InteractActingStatus[]{r100, r101, r102};
    }

    public static InteractActingStatus valueOf(String r100) {
        return (InteractActingStatus) a.a(InteractActingStatus.class, r100);
    }

    public static InteractActingStatus[] values() {
        return (InteractActingStatus[]) f80294a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public InteractActingStatus(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
