package com.bytedance.android.livesdkapi.announcement;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0016\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB!\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdkapi/announcement/OpenAnnounceBaseConfig;", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "enterFromType", "", "callback", "Lcom/bytedance/android/livesdkapi/announcement/IAnnouncementService$AnnouncementDialogCallback;", "(Landroid/content/Context;ILcom/bytedance/android/livesdkapi/announcement/IAnnouncementService$AnnouncementDialogCallback;)V", "getCallback", "()Lcom/bytedance/android/livesdkapi/announcement/IAnnouncementService$AnnouncementDialogCallback;", "getContext", "()Landroid/content/Context;", "getEnterFromType", "()I", "Companion", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public class OpenAnnounceBaseConfig {
    public static final Companion Companion = null;
    private static final int audienceEndLive = 0;
    private static final int audienceIntroInfo = 0;
    private static final int audiencePersonalPage = 0;
    private static final int audienceProfileCard = 0;
    private static final int audienceVideoExtension = 0;
    private static final int createVideoExtension = 0;
    private static final int createVideoStick = 0;
    private static final int error = 0;
    private static final int fansGroupFastEnter = 0;
    private static final int fansGroupMorePanel = 0;
    private static final int feCenter = 0;
    private static final int feCenterGrow = 0;
    private static final int feEndlive = 0;
    private static final int feRedPacket = 0;
    private static final int feTrendAnnounceList = 0;
    private static final int feTrendDetail = 0;
    private static final int feTrendHomePage = 0;
    private static final int liveMore = 0;
    private static final int liveStartPage = 0;
    private static final int liveSticker = 0;
    private static final int nativeFanGroup = 0;
    private static final int nativeFastVideo = 0;
    private final IAnnouncementService.AnnouncementDialogCallback callback;
    private final Context context;
    private final int enterFromType;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b-\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0014\u0010\r\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006R\u0014\u0010\u000f\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0006R\u0014\u0010\u0011\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0006R\u0014\u0010\u0013\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0006R\u0014\u0010\u0015\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0006R\u0014\u0010\u0017\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0006R\u0014\u0010\u0019\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0006R\u0014\u0010\u001b\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0006R\u0014\u0010\u001d\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0006R\u0014\u0010\u001f\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0006R\u0014\u0010!\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0006R\u0014\u0010#\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0006R\u0014\u0010%\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0006R\u0014\u0010'\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u0006R\u0014\u0010)\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u0006R\u0014\u0010+\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u0006R\u0014\u0010-\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\u0006R\u0014\u0010/\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\u0006¨\u00061"}, d2 = {"Lcom/bytedance/android/livesdkapi/announcement/OpenAnnounceBaseConfig$Companion;", "", "()V", "audienceEndLive", "", "getAudienceEndLive", "()I", "audienceIntroInfo", "getAudienceIntroInfo", "audiencePersonalPage", "getAudiencePersonalPage", "audienceProfileCard", "getAudienceProfileCard", "audienceVideoExtension", "getAudienceVideoExtension", "createVideoExtension", "getCreateVideoExtension", "createVideoStick", "getCreateVideoStick", "error", "getError", "fansGroupFastEnter", "getFansGroupFastEnter", "fansGroupMorePanel", "getFansGroupMorePanel", "feCenter", "getFeCenter", "feCenterGrow", "getFeCenterGrow", "feEndlive", "getFeEndlive", "feRedPacket", "getFeRedPacket", "feTrendAnnounceList", "getFeTrendAnnounceList", "feTrendDetail", "getFeTrendDetail", "feTrendHomePage", "getFeTrendHomePage", "liveMore", "getLiveMore", "liveStartPage", "getLiveStartPage", "liveSticker", "getLiveSticker", "nativeFanGroup", "getNativeFanGroup", "nativeFastVideo", "getNativeFastVideo", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public final int getAudienceEndLive() {
            return OpenAnnounceBaseConfig.access$getAudienceEndLive$cp();
        }

        public final int getAudienceIntroInfo() {
            return OpenAnnounceBaseConfig.access$getAudienceIntroInfo$cp();
        }

        public final int getAudiencePersonalPage() {
            return OpenAnnounceBaseConfig.access$getAudiencePersonalPage$cp();
        }

        public final int getAudienceProfileCard() {
            return OpenAnnounceBaseConfig.access$getAudienceProfileCard$cp();
        }

        public final int getAudienceVideoExtension() {
            return OpenAnnounceBaseConfig.access$getAudienceVideoExtension$cp();
        }

        public final int getCreateVideoExtension() {
            return OpenAnnounceBaseConfig.access$getCreateVideoExtension$cp();
        }

        public final int getCreateVideoStick() {
            return OpenAnnounceBaseConfig.access$getCreateVideoStick$cp();
        }

        public final int getError() {
            return OpenAnnounceBaseConfig.access$getError$cp();
        }

        public final int getFansGroupFastEnter() {
            return OpenAnnounceBaseConfig.access$getFansGroupFastEnter$cp();
        }

        public final int getFansGroupMorePanel() {
            return OpenAnnounceBaseConfig.access$getFansGroupMorePanel$cp();
        }

        public final int getFeCenter() {
            return OpenAnnounceBaseConfig.access$getFeCenter$cp();
        }

        public final int getFeCenterGrow() {
            return OpenAnnounceBaseConfig.access$getFeCenterGrow$cp();
        }

        public final int getFeEndlive() {
            return OpenAnnounceBaseConfig.access$getFeEndlive$cp();
        }

        public final int getFeRedPacket() {
            return OpenAnnounceBaseConfig.access$getFeRedPacket$cp();
        }

        public final int getFeTrendAnnounceList() {
            return OpenAnnounceBaseConfig.access$getFeTrendAnnounceList$cp();
        }

        public final int getFeTrendDetail() {
            return OpenAnnounceBaseConfig.access$getFeTrendDetail$cp();
        }

        public final int getFeTrendHomePage() {
            return OpenAnnounceBaseConfig.access$getFeTrendHomePage$cp();
        }

        public final int getLiveMore() {
            return OpenAnnounceBaseConfig.access$getLiveMore$cp();
        }

        public final int getLiveStartPage() {
            return OpenAnnounceBaseConfig.access$getLiveStartPage$cp();
        }

        public final int getLiveSticker() {
            return OpenAnnounceBaseConfig.access$getLiveSticker$cp();
        }

        public final int getNativeFanGroup() {
            return OpenAnnounceBaseConfig.access$getNativeFanGroup$cp();
        }

        public final int getNativeFastVideo() {
            return OpenAnnounceBaseConfig.access$getNativeFastVideo$cp();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
        error = -1;
        liveMore = 1;
        liveSticker = 2;
        feCenter = 3;
        nativeFanGroup = 4;
        feTrendHomePage = 5;
        feTrendAnnounceList = 6;
        feTrendDetail = 7;
        feCenterGrow = 8;
        createVideoStick = 9;
        createVideoExtension = 10;
        feEndlive = 11;
        nativeFastVideo = 12;
        fansGroupMorePanel = 13;
        fansGroupFastEnter = 14;
        feRedPacket = 16;
        audienceVideoExtension = 100;
        audiencePersonalPage = 101;
        audienceProfileCard = 102;
        audienceEndLive = 103;
        audienceIntroInfo = 104;
    }

    public static final /* synthetic */ int access$getAudienceEndLive$cp() {
        return audienceEndLive;
    }

    public static final /* synthetic */ int access$getAudienceIntroInfo$cp() {
        return audienceIntroInfo;
    }

    public static final /* synthetic */ int access$getAudiencePersonalPage$cp() {
        return audiencePersonalPage;
    }

    public static final /* synthetic */ int access$getAudienceProfileCard$cp() {
        return audienceProfileCard;
    }

    public static final /* synthetic */ int access$getAudienceVideoExtension$cp() {
        return audienceVideoExtension;
    }

    public static final /* synthetic */ int access$getCreateVideoExtension$cp() {
        return createVideoExtension;
    }

    public static final /* synthetic */ int access$getCreateVideoStick$cp() {
        return createVideoStick;
    }

    public static final /* synthetic */ int access$getError$cp() {
        return error;
    }

    public static final /* synthetic */ int access$getFansGroupFastEnter$cp() {
        return fansGroupFastEnter;
    }

    public static final /* synthetic */ int access$getFansGroupMorePanel$cp() {
        return fansGroupMorePanel;
    }

    public static final /* synthetic */ int access$getFeCenter$cp() {
        return feCenter;
    }

    public static final /* synthetic */ int access$getFeCenterGrow$cp() {
        return feCenterGrow;
    }

    public static final /* synthetic */ int access$getFeEndlive$cp() {
        return feEndlive;
    }

    public static final /* synthetic */ int access$getFeRedPacket$cp() {
        return feRedPacket;
    }

    public static final /* synthetic */ int access$getFeTrendAnnounceList$cp() {
        return feTrendAnnounceList;
    }

    public static final /* synthetic */ int access$getFeTrendDetail$cp() {
        return feTrendDetail;
    }

    public static final /* synthetic */ int access$getFeTrendHomePage$cp() {
        return feTrendHomePage;
    }

    public static final /* synthetic */ int access$getLiveMore$cp() {
        return liveMore;
    }

    public static final /* synthetic */ int access$getLiveStartPage$cp() {
        return liveStartPage;
    }

    public static final /* synthetic */ int access$getLiveSticker$cp() {
        return liveSticker;
    }

    public static final /* synthetic */ int access$getNativeFanGroup$cp() {
        return nativeFanGroup;
    }

    public static final /* synthetic */ int access$getNativeFastVideo$cp() {
        return nativeFastVideo;
    }

    public final IAnnouncementService.AnnouncementDialogCallback getCallback() {
        return this.callback;
    }

    public final Context getContext() {
        return this.context;
    }

    public final int getEnterFromType() {
        return this.enterFromType;
    }

    public OpenAnnounceBaseConfig(Context r100, int r101, IAnnouncementService.AnnouncementDialogCallback r102) {
        this.context = r100;
        this.enterFromType = r101;
        this.callback = r102;
    }
}
