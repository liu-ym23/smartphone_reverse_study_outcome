package com.bytedance.android.shopping.commentv3.audio;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/shopping/commentv3/audio/ExternalAudioTargetScope;", "", "CURRENT_PAGE_AND_FLOATING_AUDIO", "FLOATING_AUDIO_ONLY", "CURRENT_PAGE_ONLY", UserProfileEvent.POSITION_NONE, "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ExternalAudioTargetScope extends Enum<ExternalAudioTargetScope> {
    public static final ExternalAudioTargetScope CURRENT_PAGE_AND_FLOATING_AUDIO = null;
    public static final ExternalAudioTargetScope CURRENT_PAGE_ONLY = null;
    public static final ExternalAudioTargetScope FLOATING_AUDIO_ONLY = null;
    public static final ExternalAudioTargetScope NONE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ExternalAudioTargetScope[] f172598a = null;

    static {
        ExternalAudioTargetScope r100 = new ExternalAudioTargetScope("CURRENT_PAGE_AND_FLOATING_AUDIO", 0);
        CURRENT_PAGE_AND_FLOATING_AUDIO = r100;
        ExternalAudioTargetScope r101 = new ExternalAudioTargetScope("FLOATING_AUDIO_ONLY", 1);
        FLOATING_AUDIO_ONLY = r101;
        ExternalAudioTargetScope r102 = new ExternalAudioTargetScope("CURRENT_PAGE_ONLY", 2);
        CURRENT_PAGE_ONLY = r102;
        ExternalAudioTargetScope r103 = new ExternalAudioTargetScope(UserProfileEvent.POSITION_NONE, 3);
        NONE = r103;
        f172598a = new ExternalAudioTargetScope[]{r100, r101, r102, r103};
    }

    public static ExternalAudioTargetScope valueOf(String r100) {
        return (ExternalAudioTargetScope) r27.a.a(ExternalAudioTargetScope.class, r100);
    }

    public static ExternalAudioTargetScope[] values() {
        return (ExternalAudioTargetScope[]) f172598a.clone();
    }

    public ExternalAudioTargetScope(String r100, int r101) {
        super(r100, r101);
    }
}
