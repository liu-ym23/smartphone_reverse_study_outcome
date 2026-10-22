package com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdkapi.depend.model.LocalSubStickerItem;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001:\u0002\f\rB\u0007¢\u0006\u0004\b\n\u0010\u000bR*\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdk/config/l81;", "", "", "Lcom/bytedance/android/livesdk/config/l81$b;", "config", "Ljava/util/List;", "getConfig", "()Ljava/util/List;", "setConfig", "(Ljava/util/List;)V", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class l81 {

    @SerializedName("config")
    private List<b> config;

    public static final class a {
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0017\u0010\u0018R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\f\"\u0004\b\r\u0010\u000eR*\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/livesdk/config/l81$b;", "", "Lcom/bytedance/android/livesdkapi/depend/model/live/LiveMode;", "mode", "Lcom/bytedance/android/livesdkapi/depend/model/live/LiveMode;", "getMode", "()Lcom/bytedance/android/livesdkapi/depend/model/live/LiveMode;", "b", "(Lcom/bytedance/android/livesdkapi/depend/model/live/LiveMode;)V", "", "isOldAnchor", "Z", "()Z", "c", "(Z)V", "", "", "mItems", "Ljava/util/List;", "getMItems", "()Ljava/util/List;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "(Ljava/util/List;)V", "<init>", "()V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class b {

        @SerializedName("isOldAnchor")
        private boolean isOldAnchor;

        @SerializedName("items")
        private List<String> mItems;

        @SerializedName("mode")
        private LiveMode mode;

        public final void c() {
            this.isOldAnchor = true;
        }

        public b() {
            this.mode = LiveMode.VIDEO;
            this.isOldAnchor = true;
            this.mItems = new ArrayList();
        }

        public final void a(List<String> r100) {
            this.mItems = r100;
        }

        public final void b(LiveMode r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.mode = r100;
        }
    }

    static {
        b r100 = new b();
        r100.b(LiveMode.VIDEO);
        r100.c();
        r100.a(CollectionsKt.mutableListOf(new String[]{"REVERSE_CAMERA", LocalSubStickerItem.BEAUTY_TYPE_BEAUTY, "STICKER", "LIVE_INFO", "COMMODITY", "GAME_PROMOTE", "LITTLE_GAME", "WELFARE", "ACTIVITY_ZONE", "MINI_APP", "SHARE", "GROUP_PURCHASE", "PAID_LIVE", "SETTING", "TASK"}));
        b r101 = new b();
        r101.b(LiveMode.AUDIO);
        r101.c();
        r101.a(CollectionsKt.mutableListOf(new String[]{"LIVE_INFO", "COMMODITY", "GAME_PROMOTE", "LITTLE_GAME", "ACTIVITY_ZONE", "DOU_PLUS", "MINI_APP", "SHARE", "WELFARE", "TASK", "AUDIO_THEME"}));
        b r102 = new b();
        r102.b(LiveMode.SCREEN_RECORD);
        r102.c();
        r102.a(CollectionsKt.mutableListOf(new String[]{"HELP", "GAME_ORIENTATION", "LIVE_INFO", "COMMODITY", "GAME_PROMOTE", "LITTLE_GAME", "ACTIVITY_ZONE", "DOU_PLUS", "MINI_APP", "SHARE", "BROADCAST_MIRROR", "WELFARE", "STAR_GRAPH_TASK", "TASK"}));
        b r103 = new b();
        r103.b(LiveMode.THIRD_PARTY);
        r103.c();
        r103.a(CollectionsKt.mutableListOf(new String[]{"HELP", "COMMODITY", "DOU_PLUS", "MINI_APP", "SHARE", "SETTING", "GAME_PROMOTE"}));
        b r104 = new b();
        r104.b(LiveMode.MEDIA);
        r104.c();
        r104.a(CollectionsKt.mutableListOf(new String[]{"REVERSE_CAMERA", LocalSubStickerItem.BEAUTY_TYPE_BEAUTY, "SHARE", "WELFARE", "SETTING"}));
        new l81().config = CollectionsKt.mutableListOf(new b[]{r100, r101, r102, r103, r104});
    }

    public l81() {
        this.config = new ArrayList();
    }
}
