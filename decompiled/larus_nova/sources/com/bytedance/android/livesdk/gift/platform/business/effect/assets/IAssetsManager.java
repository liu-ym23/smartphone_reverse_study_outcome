package com.bytedance.android.livesdk.gift.platform.business.effect.assets;

import androidx.lifecycle.LiveData;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.annotation.AnnotationRetention;

/* JADX INFO: loaded from: classes9.dex */
public interface IAssetsManager extends j {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003B\u0000¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/effect/assets/IAssetsManager$DownloadAssetsSource;", "", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "revenue-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface DownloadAssetsSource {
        public static final a Companion = null;
        public static final int SOURCE_APP_LAUNCH = 1;
        public static final int SOURCE_CLEAR_REMARK_RESOURCE = 13;
        public static final int SOURCE_CLIENTAI_DOWNLOAD = 1010;
        public static final int SOURCE_ENTER_ROOM = 2;
        public static final int SOURCE_FROM_LOCAL_MESSAGE = 12;
        public static final int SOURCE_GIFT_IN_APP = 6;
        public static final int SOURCE_GIFT_PANEL_LOAD_MORE = 1006;
        public static final int SOURCE_GIFT_UPDATE_MESSAGE = 5;
        public static final int SOURCE_INTERACT_GIFT_PANEL = 7;
        public static final int SOURCE_INVALID = -1;
        public static final int SOURCE_JSB_PLAY = 1007;
        public static final int SOURCE_JSB_PRELOADING = 1008;
        public static final int SOURCE_LOCAL_DRESS = 1001;
        public static final int SOURCE_LOCAL_GUEST_STICKER_GIFT = 1002;
        public static final int SOURCE_LOCAL_INTERACT_GIFT = 1005;
        public static final int SOURCE_LOCAL_SEND_GIFT_NOW = 1000;
        public static final int SOURCE_OPEN_GIFT_DIALOG = 3;
        public static final int SOURCE_PREDICT_SEND_GIFT = 1011;
        public static final int SOURCE_ROOM_MESSAGE = 4;
        public static final int SOURCE_UNKNOWN = 0;

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ a f129075a = null;

            public a() {
            }

            static {
                f129075a = new a();
            }
        }

        static {
            Companion = a.f129075a;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003B\u0000¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/effect/assets/IAssetsManager$FetchGiftListSource;", "", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "revenue-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface FetchGiftListSource {
        public static final a Companion = null;
        public static final int SOURCE_AI_GIFT_ASYNC_SORT = 11;
        public static final int SOURCE_APP_LAUNCH = 1;
        public static final int SOURCE_ENTER_ROOM = 2;
        public static final int SOURCE_ENTER_ROOM_LITE = 13;
        public static final int SOURCE_GIFT_DETAIL = 14;
        public static final int SOURCE_GIFT_PANEL_LOAD_MORE = 12;
        public static final int SOURCE_GIFT_PRE_REQUEST = 15;
        public static final int SOURCE_GIFT_SEARCH = 17;
        public static final int SOURCE_GIFT_UPDATE_MESSAGE = 5;
        public static final int SOURCE_LOCAL = 99;
        public static final int SOURCE_MOSTLY_USED_PIN_STATUS_CHANGED = 18;
        public static final int SOURCE_OPEN_GIFT_DIALOG = 3;
        public static final int SOURCE_PK_PERIOD = 10;
        public static final int SOURCE_ROOM_MESSAGE = 4;
        public static final int SOURCE_SYNC_GIFT_FOR_SORT = 16;
        public static final int SOURCE_UNKNOWN = 0;

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ a f129076a = null;

            public a() {
            }

            static {
                f129076a = new a();
            }
        }

        static {
            Companion = a.f129076a;
        }
    }

    public static final class a {
        public static AssetDownloadPriority a(AssetDownloadPriority r100, int r101) {
            if (r100 == null) goto L7;
            if (r100.getPriority() == AssetDownloadPriority.NORMAL.getPriority()) goto L7;
            return r100;
        L7:
            if (r101 == 1000) goto L22;
            if (r101 == 1010) goto L22;
            if (r101 != 4) goto L16;
            return AssetDownloadPriority.OTHER_SEND;
        L16:
            if (r101 != 1007) goto L20;
            return AssetDownloadPriority.JSB_PLAY;
        L20:
            return AssetDownloadPriority.NORMAL;
        L22:
            return AssetDownloadPriority.LOCAL;
        }
    }

    public interface b {
        void a();

        void b(List<? extends com.bytedance.android.live.core.resources.e> r100);
    }

    int B7();

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.j
    String D1(long r100);

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.j
    com.bytedance.android.live.core.resources.e G1(long r100);

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.j
    String H0(long r100);

    boolean Ne(com.bytedance.android.live.core.resources.e r100, f r101, int r102);

    boolean O9(com.bytedance.android.live.core.resources.e r100);

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.j
    void T(b r100);

    void T2(int r100, String r101);

    void cb(String r100);

    void d4(int r100, boolean r101, long r102, String r103);

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.j
    boolean g1(long r100);

    String gn(long r100, boolean r101);

    LiveData<List<Pair<com.bytedance.android.live.core.resources.e, Boolean>>> h0();

    boolean j4(long r100, f r101, int r102);

    void ji(int r100, boolean r101, List<Long> r102, String r103);

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.j
    void l0(b r100);

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.j
    boolean r0(long r100, f r101, int r102, AssetDownloadPriority r103);

    String vg();
}
