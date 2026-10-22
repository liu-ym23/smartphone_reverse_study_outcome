package com.bytedance.android.livesdk.chatroom.ui;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/ui/AudienceResolutionType;", "", "normal", "auto", "livecommonui_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum AudienceResolutionType extends Enum<AudienceResolutionType> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AudienceResolutionType[] f112093a = null;
    public static final AudienceResolutionType auto = null;
    public static final AudienceResolutionType normal = null;

    static {
        AudienceResolutionType r100 = new AudienceResolutionType("normal", 0);
        normal = r100;
        AudienceResolutionType r101 = new AudienceResolutionType("auto", 1);
        auto = r101;
        f112093a = new AudienceResolutionType[]{r100, r101};
    }

    public static AudienceResolutionType valueOf(String r100) {
        return (AudienceResolutionType) r27.a.a(AudienceResolutionType.class, r100);
    }

    public static AudienceResolutionType[] values() {
        return (AudienceResolutionType[]) f112093a.clone();
    }

    public AudienceResolutionType(String r100, int r101) {
        super(r100, r101);
    }
}
