package com.bytedance.android.livesdk.interactivity.api.publicscreen;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u000e\b\u0086\u0001\u0018\u0000 \b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\tR\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"com/bytedance/android/livesdk/interactivity/api/publicscreen/PublicScreenConfig$ViewBinderType", "", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/PublicScreenConfig$ViewBinderType;", "", "viewType", "I", "getViewType", "()I", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "COMMON_TEXT", "TEST_CUSTOM_VIEW", "EMOJI_COMMON_TEXT", "INTERACTIVITY_SHARE", "HOVER_AREA", "AI_AUTO_REPLY", "COMBINED_TEXT", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum PublicScreenConfig$ViewBinderType extends Enum<PublicScreenConfig$ViewBinderType> {
    public static final PublicScreenConfig$ViewBinderType AI_AUTO_REPLY = null;
    public static final PublicScreenConfig$ViewBinderType COMBINED_TEXT = null;
    public static final PublicScreenConfig$ViewBinderType COMMON_TEXT = null;
    public static final a Companion = null;
    public static final PublicScreenConfig$ViewBinderType EMOJI_COMMON_TEXT = null;
    public static final PublicScreenConfig$ViewBinderType HOVER_AREA = null;
    public static final PublicScreenConfig$ViewBinderType INTERACTIVITY_SHARE = null;
    public static final PublicScreenConfig$ViewBinderType TEST_CUSTOM_VIEW = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PublicScreenConfig$ViewBinderType[] f133370a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final PublicScreenConfig$ViewBinderType[] f133371b = null;
    private final int viewType;

    public static final class a {
        public a() {
        }
    }

    static {
        PublicScreenConfig$ViewBinderType r100 = new PublicScreenConfig$ViewBinderType("COMMON_TEXT", 0, 10000);
        COMMON_TEXT = r100;
        PublicScreenConfig$ViewBinderType r101 = new PublicScreenConfig$ViewBinderType("TEST_CUSTOM_VIEW", 1, 99999);
        TEST_CUSTOM_VIEW = r101;
        PublicScreenConfig$ViewBinderType r102 = new PublicScreenConfig$ViewBinderType("EMOJI_COMMON_TEXT", 2, 10001);
        EMOJI_COMMON_TEXT = r102;
        PublicScreenConfig$ViewBinderType r103 = new PublicScreenConfig$ViewBinderType("INTERACTIVITY_SHARE", 3, 10002);
        INTERACTIVITY_SHARE = r103;
        PublicScreenConfig$ViewBinderType r104 = new PublicScreenConfig$ViewBinderType("HOVER_AREA", 4, 10003);
        HOVER_AREA = r104;
        PublicScreenConfig$ViewBinderType r105 = new PublicScreenConfig$ViewBinderType("AI_AUTO_REPLY", 5, 10004);
        AI_AUTO_REPLY = r105;
        PublicScreenConfig$ViewBinderType r106 = new PublicScreenConfig$ViewBinderType("COMBINED_TEXT", 6, 10005);
        COMBINED_TEXT = r106;
        f133370a = new PublicScreenConfig$ViewBinderType[]{r100, r101, r102, r103, r104, r105, r106};
        Companion = new a();
        f133371b = values();
    }

    public static PublicScreenConfig$ViewBinderType valueOf(String r100) {
        return (PublicScreenConfig$ViewBinderType) r27.a.a(PublicScreenConfig$ViewBinderType.class, r100);
    }

    public static PublicScreenConfig$ViewBinderType[] values() {
        return (PublicScreenConfig$ViewBinderType[]) f133370a.clone();
    }

    public static final /* synthetic */ PublicScreenConfig$ViewBinderType[] access$getVALUES$cp() {
        return f133371b;
    }

    public final int getViewType() {
        return this.viewType;
    }

    public PublicScreenConfig$ViewBinderType(String r100, int r101, int r102) {
        super(r100, r101);
        this.viewType = r102;
    }
}
