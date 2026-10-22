package com.bytedance.android.livesdk.gift.platform.business.effect.service;

import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/effect/service/ViewIdentifier;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "Operation", "MediaDecorationBehindSeat", "MediaDecorationFrontSeat", "FourthLineCard", "MediaContainer", "livegift-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum ViewIdentifier extends Enum<ViewIdentifier> {
    public static final ViewIdentifier FourthLineCard = null;
    public static final ViewIdentifier MediaContainer = null;
    public static final ViewIdentifier MediaDecorationBehindSeat = null;
    public static final ViewIdentifier MediaDecorationFrontSeat = null;
    public static final ViewIdentifier Operation = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ViewIdentifier[] f129517a = null;
    private final String value;

    static {
        ViewIdentifier r100 = new ViewIdentifier("Operation", 0, WikiFolderPushPlugin.OPT);
        Operation = r100;
        ViewIdentifier r101 = new ViewIdentifier("MediaDecorationBehindSeat", 1, "media_decoration_behind_seat");
        MediaDecorationBehindSeat = r101;
        ViewIdentifier r102 = new ViewIdentifier("MediaDecorationFrontSeat", 2, "media_decoration_front_seat");
        MediaDecorationFrontSeat = r102;
        ViewIdentifier r103 = new ViewIdentifier("FourthLineCard", 3, "fourth_line");
        FourthLineCard = r103;
        ViewIdentifier r104 = new ViewIdentifier("MediaContainer", 4, "media_container");
        MediaContainer = r104;
        f129517a = new ViewIdentifier[]{r100, r101, r102, r103, r104};
    }

    public static ViewIdentifier valueOf(String r100) {
        return (ViewIdentifier) a.a(ViewIdentifier.class, r100);
    }

    public static ViewIdentifier[] values() {
        return (ViewIdentifier[]) f129517a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public ViewIdentifier(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
