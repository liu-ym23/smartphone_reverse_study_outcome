package com.bytedance.android.livesdk.message.model;

import com.ss.android.ugc.effectmanager.common.EffectConstants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/NormalPaidLinkmicOpenSource;", "", EffectConstants.NORMAL, "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum NormalPaidLinkmicOpenSource extends Enum<NormalPaidLinkmicOpenSource> {
    public static final NormalPaidLinkmicOpenSource NORMAL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ NormalPaidLinkmicOpenSource[] f153606a = null;

    static {
        NormalPaidLinkmicOpenSource r100 = new NormalPaidLinkmicOpenSource();
        NORMAL = r100;
        f153606a = new NormalPaidLinkmicOpenSource[]{r100};
    }

    public static NormalPaidLinkmicOpenSource valueOf(String r100) {
        return (NormalPaidLinkmicOpenSource) r27.a.a(NormalPaidLinkmicOpenSource.class, r100);
    }

    public static NormalPaidLinkmicOpenSource[] values() {
        return (NormalPaidLinkmicOpenSource[]) f153606a.clone();
    }

    public NormalPaidLinkmicOpenSource() {
        super(EffectConstants.NORMAL, 0);
    }
}
