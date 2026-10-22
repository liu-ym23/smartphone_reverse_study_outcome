package com.bytedance.android.live.liveinteract.multianchor.model;

import android.text.TextUtils;
import com.bytedance.android.service.manager.alliance.IAllianceService;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes46.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
public class MicDress extends FlexModelBase<kd1.b> implements kd1.b {

    @SerializedName(IAllianceService.CONTENT_TYPE_BADGE)
    public LinkmicBadge badge;

    @SerializedName("customized_random_emoji")
    public a linkmicCustomizedRandomEmoji;

    @SerializedName("voice_wave")
    public VoiceWave voiceWave;

    @JsonAdapter(FlexModelJsonAdapter.class)
    public static class LinkmicBadge extends FlexModelBase<kd1.a> implements kd1.a {

        @SerializedName("dress_id")
        public String dressId;

        @SerializedName("show_type")
        public int showType;

        public static final enum LinkmicBadgeShowType extends Enum<LinkmicBadgeShowType> {
            public static final LinkmicBadgeShowType DisplayFirst = null;
            public static final LinkmicBadgeShowType NormalDisplay = null;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ LinkmicBadgeShowType[] f75467a = null;
            private final int value;

            static {
                LinkmicBadgeShowType r100 = new LinkmicBadgeShowType("NormalDisplay", 0, 0);
                NormalDisplay = r100;
                LinkmicBadgeShowType r101 = new LinkmicBadgeShowType("DisplayFirst", 1, 1);
                DisplayFirst = r101;
                f75467a = new LinkmicBadgeShowType[]{r100, r101};
            }

            public static LinkmicBadgeShowType[] values() {
                return (LinkmicBadgeShowType[]) f75467a.clone();
            }

            public static /* synthetic */ int access$000(LinkmicBadgeShowType r100) {
                return r100.value;
            }

            public static LinkmicBadgeShowType valueOf(String r100) {
                return (LinkmicBadgeShowType) r27.a.a(LinkmicBadgeShowType.class, r100);
            }

            public LinkmicBadgeShowType(String r100, int r101, int r102) {
                super(r100, r101);
                this.value = r102;
            }
        }

        public LinkmicBadge() {
            super(kd1.a.class);
            this.showType = LinkmicBadgeShowType.access$000(LinkmicBadgeShowType.NormalDisplay);
        }

        @Override // kd1.a
        public String getDressId() {
            return this.dressId;
        }

        @Override // kd1.a
        public int getShowType() {
            return this.showType;
        }
    }

    @JsonAdapter(FlexModelJsonAdapter.class)
    public static class VoiceWave extends FlexModelBase<kd1.c> implements kd1.c {

        @SerializedName("dress_id")
        public String dressId;

        @SerializedName("high_img")
        public py.k highImg;

        @SerializedName("low_img")
        public py.k lowImg;

        @SerializedName("medium_img")
        public py.k mediumImg;

        public VoiceWave() {
            super(kd1.c.class);
        }

        @Override // kd1.c
        public String getDressId() {
            return this.dressId;
        }

        @Override // kd1.c
        public py.k getHighImg() {
            return this.highImg;
        }

        @Override // kd1.c
        public py.k getLowImg() {
            return this.lowImg;
        }

        @Override // kd1.c
        public py.k getMediumImg() {
            return this.mediumImg;
        }

        public py.k getAnimByState(int r100) {
            if (r100 != 1) goto L7;
            return this.lowImg;
        L7:
            if (r100 != 2) goto L11;
            return this.mediumImg;
        L11:
            return this.highImg;
        }

        public String getAnimUrlByState(int r100) {
            if (r100 != 1) goto L11;
            py.k r101 = this.lowImg;
            if (r101 != null) goto L7;
            return null;
        L7:
            if (r101.getUrls().isEmpty() == false) goto L9;
            return null;
        L9:
            return (String) ListProtector.get(this.lowImg.getUrls(), 0);
        L11:
            if (r100 != 2) goto L18;
            py.k r102 = this.mediumImg;
            if (r102 != null) goto L15;
            return null;
        L15:
            if (r102.getUrls().isEmpty() == false) goto L17;
            return null;
        L17:
            return (String) ListProtector.get(this.mediumImg.getUrls(), 0);
        L18:
            py.k r103 = this.highImg;
            if (r103 != null) goto L21;
            return null;
        L21:
            if (r103.getUrls().isEmpty() == false) goto L23;
            return null;
        L23:
            return (String) ListProtector.get(this.highImg.getUrls(), 0);
        }
    }

    public static class a {

        @SerializedName("emoji_displayd_dynamic_image")
        public py.k dynamicImage;

        @SerializedName("random_num")
        public long randomNum;

        @SerializedName("status")
        public int status;

        @SerializedName("emoji_status_image")
        public py.k statusImage;

        @SerializedName("trigger_reason")
        public String triggerReason;

        /* JADX INFO: renamed from: ts, reason: collision with root package name */
        @SerializedName("refresh_timestamp")
        public long f75468ts;

        @SerializedName("type")
        public int type;

        public a() {
        }
    }

    public MicDress() {
        super(kd1.b.class);
    }

    @Override // kd1.b
    public kd1.a getBadge() {
        return this.badge;
    }

    @Override // kd1.b
    public kd1.c getVoiceWave() {
        return this.voiceWave;
    }

    public boolean isEqual(MicDress r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        VoiceWave r101 = this.voiceWave;
        if (r101 == null) goto L11;
        VoiceWave r102 = r100.voiceWave;
        if (r102 == null) goto L11;
        return TextUtils.equals(r101.dressId, r102.dressId);
    L11:
        return false;
    }
}
