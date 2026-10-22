package com.bytedance.android.livesdkapi.feed.model;

import com.bytedance.android.livesdkapi.feed.constant.FeedType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ry.f;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0001(Ba\b\u0002\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\"\u001a\u00020!¢\u0006\u0004\b&\u0010'R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0019\u0010\f\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u0019\u0010\u000e\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\u000f\u0010\u000bR\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0019\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0019\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0019\u0010\u001f\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b\u001f\u0010\t\u001a\u0004\b \u0010\u000bR\u0017\u0010\"\u001a\u00020!8\u0006¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%¨\u0006)"}, d2 = {"Lcom/bytedance/android/livesdkapi/feed/model/HorFollowListParams;", "", "Lcom/bytedance/android/livesdkapi/feed/constant/FeedType;", "feedType", "Lcom/bytedance/android/livesdkapi/feed/constant/FeedType;", "getFeedType", "()Lcom/bytedance/android/livesdkapi/feed/constant/FeedType;", "", "backgroundColor", "Ljava/lang/Integer;", "getBackgroundColor", "()Ljava/lang/Integer;", "liveTagColor", "getLiveTagColor", "liveTagRadius", "getLiveTagRadius", "", "enterFromMerge", "Ljava/lang/String;", "getEnterFromMerge", "()Ljava/lang/String;", "Lry/f;", "avatarBorderAnimController", "Lry/f;", "getAvatarBorderAnimController", "()Lry/f;", "", "titleTextSize", "Ljava/lang/Float;", "getTitleTextSize", "()Ljava/lang/Float;", "titleColor", "getTitleColor", "", "supportStatusView", "Z", "getSupportStatusView", "()Z", "<init>", "(Lcom/bytedance/android/livesdkapi/feed/constant/FeedType;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Lry/f;Ljava/lang/Float;Ljava/lang/Integer;Z)V", "Builder", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class HorFollowListParams {
    private final f avatarBorderAnimController;
    private final Integer backgroundColor;
    private final String enterFromMerge;
    private final FeedType feedType;
    private final Integer liveTagColor;
    private final Integer liveTagRadius;
    private final boolean supportStatusView;
    private final Integer titleColor;
    private final Float titleTextSize;

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\t\b\u0016¢\u0006\u0004\b\u001c\u0010\u001dB\u0011\b\u0016\u0012\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u001c\u0010\u001eJ\u000e\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\b\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\u000b\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\tJ\u000e\u0010\r\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\fJ\u000e\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u0004J\u000e\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u000fJ\u0006\u0010\u0013\u001a\u00020\u0012R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0014R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0015R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\u0015R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010\u0015R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\u0016R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\r\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u001aR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u0015R\u0016\u0010\u0011\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u001b¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/livesdkapi/feed/model/HorFollowListParams$Builder;", "", "Lcom/bytedance/android/livesdkapi/feed/constant/FeedType;", "feedType", "", "color", "backgroundColor", "liveTagColor", "liveTagRadius", "Lry/f;", "animController", "avatarBorderAnimController", "", "titleTextSize", "titleColor", "", "value", "supportStatusView", "Lcom/bytedance/android/livesdkapi/feed/model/HorFollowListParams;", "build", "Lcom/bytedance/android/livesdkapi/feed/constant/FeedType;", "Ljava/lang/Integer;", "Lry/f;", "", "enterFromMerge", "Ljava/lang/String;", "Ljava/lang/Float;", "Z", "<init>", "()V", "(Ljava/lang/String;)V", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Builder {
        private f avatarBorderAnimController;
        private Integer backgroundColor;
        private String enterFromMerge;
        private FeedType feedType;
        private Integer liveTagColor;
        private Integer liveTagRadius;
        private boolean supportStatusView;
        private Integer titleColor;
        private Float titleTextSize;

        public final HorFollowListParams build() {
            return new HorFollowListParams(this.feedType, this.backgroundColor, this.liveTagColor, this.liveTagRadius, this.enterFromMerge, this.avatarBorderAnimController, this.titleTextSize, this.titleColor, this.supportStatusView, null);
        }

        public Builder() {
            this.feedType = FeedType.FOLLOW_FEED;
            this.supportStatusView = true;
        }

        public Builder(String r100) {
            Intrinsics.checkNotNullParameter(r100, "enterFromMerge");
            this.feedType = FeedType.FOLLOW_FEED;
            this.supportStatusView = true;
            this.enterFromMerge = r100;
        }

        public final Builder avatarBorderAnimController(f r100) {
            Intrinsics.checkNotNullParameter(r100, "animController");
            this.avatarBorderAnimController = r100;
            return this;
        }

        public final Builder backgroundColor(int r100) {
            this.backgroundColor = Integer.valueOf(r100);
            return this;
        }

        public final Builder feedType(FeedType r100) {
            Intrinsics.checkNotNullParameter(r100, "feedType");
            this.feedType = r100;
            return this;
        }

        public final Builder liveTagColor(int r100) {
            this.liveTagColor = Integer.valueOf(r100);
            return this;
        }

        public final Builder liveTagRadius(int r100) {
            this.liveTagRadius = Integer.valueOf(r100);
            return this;
        }

        public final Builder supportStatusView(boolean r100) {
            this.supportStatusView = r100;
            return this;
        }

        public final Builder titleColor(int r100) {
            this.titleColor = Integer.valueOf(r100);
            return this;
        }

        public final Builder titleTextSize(float r100) {
            this.titleTextSize = Float.valueOf(r100);
            return this;
        }
    }

    public final f getAvatarBorderAnimController() {
        return this.avatarBorderAnimController;
    }

    public final Integer getBackgroundColor() {
        return this.backgroundColor;
    }

    public final String getEnterFromMerge() {
        return this.enterFromMerge;
    }

    public final FeedType getFeedType() {
        return this.feedType;
    }

    public final Integer getLiveTagColor() {
        return this.liveTagColor;
    }

    public final Integer getLiveTagRadius() {
        return this.liveTagRadius;
    }

    public final boolean getSupportStatusView() {
        return this.supportStatusView;
    }

    public final Integer getTitleColor() {
        return this.titleColor;
    }

    public final Float getTitleTextSize() {
        return this.titleTextSize;
    }

    private HorFollowListParams(FeedType r100, Integer r101, Integer r102, Integer r103, String r104, f r105, Float r106, Integer r107, boolean r108) {
        this.feedType = r100;
        this.backgroundColor = r101;
        this.liveTagColor = r102;
        this.liveTagRadius = r103;
        this.enterFromMerge = r104;
        this.avatarBorderAnimController = r105;
        this.titleTextSize = r106;
        this.titleColor = r107;
        this.supportStatusView = r108;
    }

    public /* synthetic */ HorFollowListParams(FeedType r100, Integer r101, Integer r102, Integer r103, String r104, f r105, Float r106, Integer r107, boolean r108, DefaultConstructorMarker r110) {
        this(r100, r101, r102, r103, r104, r105, r106, r107, r108);
    }

    public /* synthetic */ HorFollowListParams(FeedType r110, Integer r111, Integer r112, Integer r113, String r114, f r115, Float r116, Integer r117, boolean r210, int r211, DefaultConstructorMarker r212) {
        if ((r211 & 1) == 0) goto L5;
        FeedType r100 = FeedType.FOLLOW_FEED;
    L6:
        this(r100, r111, r112, r113, r114, r115, r116, r117, r210);
        return;
    L5:
        r100 = r110;
        goto L6
    }
}
