package com.bytedance.android.livesdk.chatroom.vs_base.base.setting.config;

import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.effectmanager.common.EffectConstants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0001\u0018\u0000 \u00112\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0012R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\r\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/vs_base/base/setting/config/ReplayBarrageSettingSpeed;", "", "", "level", "I", "getLevel", "()I", "", "factor", FaceService.girlLabel, "getFactor", "()F", "", "des", "Ljava/lang/String;", "getDes", "()Ljava/lang/String;", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "SLOW", EffectConstants.NORMAL, "FAST", "vs-base_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ReplayBarrageSettingSpeed extends Enum<ReplayBarrageSettingSpeed> {
    public static final a Companion = null;
    public static final ReplayBarrageSettingSpeed FAST = null;
    public static final ReplayBarrageSettingSpeed NORMAL = null;
    public static final ReplayBarrageSettingSpeed SLOW = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ReplayBarrageSettingSpeed[] f117915a = null;
    private final String des;
    private final float factor;
    private final int level;

    public static final class a {
        public a() {
        }

        public static ReplayBarrageSettingSpeed a(int r100) {
            ReplayBarrageSettingSpeed[] r101 = ReplayBarrageSettingSpeed.values();
            int r102 = r101.length;
            int r103 = 0;
        L3:
            if (r103 >= r102) goto L11;
            ReplayBarrageSettingSpeed r104 = r101[r103];
            if (r104.getLevel() != r100) goto L7;
            boolean r105 = true;
        L8:
            if (r105 == true) goto L12;
            r103 = r103 + 1;
        L12:
            if (r104 == null) goto L14;
            return r104;
        L14:
            return ReplayBarrageSettingSpeed.NORMAL;
        L7:
            r105 = false;
            goto L8
        L11:
            r104 = null;
            goto L12
        }
    }

    static {
        ReplayBarrageSettingSpeed r100 = new ReplayBarrageSettingSpeed("SLOW", 0, 0, 0.5f, "慢速");
        SLOW = r100;
        ReplayBarrageSettingSpeed r101 = new ReplayBarrageSettingSpeed(EffectConstants.NORMAL, 1, 1, 1.0f, "正常");
        NORMAL = r101;
        ReplayBarrageSettingSpeed r102 = new ReplayBarrageSettingSpeed("FAST", 2, 2, 1.5f, "快速");
        FAST = r102;
        f117915a = new ReplayBarrageSettingSpeed[]{r100, r101, r102};
        Companion = new a();
    }

    public static ReplayBarrageSettingSpeed valueOf(String r100) {
        return (ReplayBarrageSettingSpeed) r27.a.a(ReplayBarrageSettingSpeed.class, r100);
    }

    public static ReplayBarrageSettingSpeed[] values() {
        return (ReplayBarrageSettingSpeed[]) f117915a.clone();
    }

    public final String getDes() {
        return this.des;
    }

    public final float getFactor() {
        return this.factor;
    }

    public final int getLevel() {
        return this.level;
    }

    public ReplayBarrageSettingSpeed(String r100, int r101, int r102, float r103, String r104) {
        super(r100, r101);
        this.level = r102;
        this.factor = r103;
        this.des = r104;
    }
}
