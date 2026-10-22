package com.bytedance.android.shopping.api.mall.common.homepage.card.headercard.model;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u000f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/AnimationType;", "", "", "value", "I", "getValue", "()I", UserProfileEvent.POSITION_NONE, "PRODUCT_CAROUSEL", "TAG_FLIP", "TAG_FLIP_AND_PRODUCT_CAROUSEL", "TAG_PRODUCT_CAROUSEL", "TASK_CAROUSEL", "LOTTIE_WITH_INFO", "TAG_SUB_PRODUCT_CAROUSEL", "LOTTIE_CAROUSEL", "WEBP_CAROUSEL", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum AnimationType extends Enum<AnimationType> {
    public static final AnimationType LOTTIE_CAROUSEL = null;
    public static final AnimationType LOTTIE_WITH_INFO = null;
    public static final AnimationType NONE = null;
    public static final AnimationType PRODUCT_CAROUSEL = null;
    public static final AnimationType TAG_FLIP = null;
    public static final AnimationType TAG_FLIP_AND_PRODUCT_CAROUSEL = null;
    public static final AnimationType TAG_PRODUCT_CAROUSEL = null;
    public static final AnimationType TAG_SUB_PRODUCT_CAROUSEL = null;
    public static final AnimationType TASK_CAROUSEL = null;
    public static final AnimationType WEBP_CAROUSEL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AnimationType[] f170320a = null;
    private final int value;

    public static AnimationType valueOf(String r100) {
        return (AnimationType) a.a(AnimationType.class, r100);
    }

    public static AnimationType[] values() {
        return (AnimationType[]) f170320a.clone();
    }

    static {
        AnimationType r100 = new AnimationType(UserProfileEvent.POSITION_NONE, 0, 0);
        NONE = r100;
        AnimationType r101 = new AnimationType("PRODUCT_CAROUSEL", 1, 1);
        PRODUCT_CAROUSEL = r101;
        AnimationType r102 = new AnimationType("TAG_FLIP", 2, 2);
        TAG_FLIP = r102;
        AnimationType r103 = new AnimationType("TAG_FLIP_AND_PRODUCT_CAROUSEL", 3, 3);
        TAG_FLIP_AND_PRODUCT_CAROUSEL = r103;
        AnimationType r104 = new AnimationType("TAG_PRODUCT_CAROUSEL", 4, 4);
        TAG_PRODUCT_CAROUSEL = r104;
        AnimationType r105 = new AnimationType("TASK_CAROUSEL", 5, 5);
        TASK_CAROUSEL = r105;
        AnimationType r106 = new AnimationType("LOTTIE_WITH_INFO", 6, 6);
        LOTTIE_WITH_INFO = r106;
        AnimationType r107 = new AnimationType("TAG_SUB_PRODUCT_CAROUSEL", 7, 7);
        TAG_SUB_PRODUCT_CAROUSEL = r107;
        AnimationType r108 = new AnimationType("LOTTIE_CAROUSEL", 8, 8);
        LOTTIE_CAROUSEL = r108;
        AnimationType r109 = new AnimationType("WEBP_CAROUSEL", 9, 9);
        WEBP_CAROUSEL = r109;
        f170320a = new AnimationType[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109};
    }

    public final int getValue() {
        return this.value;
    }

    public AnimationType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
