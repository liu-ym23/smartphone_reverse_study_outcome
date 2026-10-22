package com.bytedance.android.livesdkapi.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\b\b\u0007\u0018\u0000 \r2\u00020\u0001:\u0001\rB#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006¢\u0006\u0002\u0010\u0007R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u001c\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/VideoDigitAvatarBgConfig;", "", "maleBg", "", "femaleBg", "smallBgList", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getFemaleBg", "()Ljava/lang/String;", "getMaleBg", "getSmallBgList", "()Ljava/util/List;", "Companion", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class VideoDigitAvatarBgConfig {
    public static final Companion Companion = null;
    private static final String baseUrl = "https://lf3-webcastcdn-tos.douyinstatic.com/obj/live-android/";

    @SerializedName("female_bg")
    private final String femaleBg;

    @SerializedName("male_bg")
    private final String maleBg;

    @SerializedName("small_bg_list")
    private final List<String> smallBgList;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/VideoDigitAvatarBgConfig$Companion;", "", "()V", "baseUrl", "", "defaultInstance", "Lcom/bytedance/android/livesdkapi/model/VideoDigitAvatarBgConfig;", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Companion {
        private Companion() {
        }

        @JvmStatic
        public final VideoDigitAvatarBgConfig defaultInstance() {
            return new VideoDigitAvatarBgConfig("https://lf3-webcastcdn-tos.douyinstatic.com/obj/live-android/video_avatar_bg_male.png", "https://lf3-webcastcdn-tos.douyinstatic.com/obj/live-android/video_avatar_bg_female.png", CollectionsKt.listOf(new String[]{"https://lf3-webcastcdn-tos.douyinstatic.com/obj/live-android/equal_bg_feng.png", "https://lf3-webcastcdn-tos.douyinstatic.com/obj/live-android/equeal_bg_lv.png", "https://lf3-webcastcdn-tos.douyinstatic.com/obj/live-android/equal_bg_zi.png", "https://lf3-webcastcdn-tos.douyinstatic.com/obj/live-android/equal_bg_lan.png"}));
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    @JvmStatic
    public static final VideoDigitAvatarBgConfig defaultInstance() {
        return Companion.defaultInstance();
    }

    public final String getFemaleBg() {
        return this.femaleBg;
    }

    public final String getMaleBg() {
        return this.maleBg;
    }

    public final List<String> getSmallBgList() {
        return this.smallBgList;
    }

    public VideoDigitAvatarBgConfig(String r100, String r101, List<String> r102) {
        Intrinsics.checkNotNullParameter(r100, "maleBg");
        Intrinsics.checkNotNullParameter(r101, "femaleBg");
        Intrinsics.checkNotNullParameter(r102, "smallBgList");
        this.maleBg = r100;
        this.femaleBg = r101;
        this.smallBgList = r102;
    }
}
