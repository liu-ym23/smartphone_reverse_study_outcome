package com.bytedance.android.livesdkapi.depend.model.live;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.text.StringsKt;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.gamecp.api.GetPromotedGamesResponse.Data")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0007\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0005¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/AnchorGamePromoteStatus;", "", "()V", "bubbleMessage", "", "hasAgreePropProtocol", "", "hasPropPermission", "status", "Companion", "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorGamePromoteStatus implements h {
    public static final Companion Companion = null;
    public static final String SET_STATUS_TYPE_CONTRACT = "2";
    public static final String SET_STATUS_TYPE_INTRO = "1";
    public static final String STATUS_IN_PROMOTION_HAS_GAME = "3";
    public static final String STATUS_IN_PROMOTION_NO_GAME = "2";
    public static final String STATUS_NI = "0";
    public static final String STATUS_NOT_IN_PROMOTION_HAS_SHOWN_INTRO = "4";
    public static final String STATUS_NOT_IN_PROMOTION_NOT_SHOWN_INTRO = "5";
    public static final String STATUS_NO_PERMISSION = "1";
    public static final String STATUS_UNKNOWN = "-1";

    @SerializedName("bubble_message")
    public String bubbleMessage;

    @SerializedName("is_agree_prop_protocol")
    public boolean hasAgreePropProtocol;

    @SerializedName("has_prop_permission")
    public boolean hasPropPermission;

    @SerializedName("status")
    public String status;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/AnchorGamePromoteStatus$Companion;", "", "()V", "SET_STATUS_TYPE_CONTRACT", "", "SET_STATUS_TYPE_INTRO", "STATUS_IN_PROMOTION_HAS_GAME", "STATUS_IN_PROMOTION_NO_GAME", "STATUS_NI", "STATUS_NOT_IN_PROMOTION_HAS_SHOWN_INTRO", "STATUS_NOT_IN_PROMOTION_NOT_SHOWN_INTRO", "STATUS_NO_PERMISSION", "STATUS_UNKNOWN", "isValidStatus", "", "status", "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        @JvmStatic
        public final boolean isValidStatus(String r100) {
            Intrinsics.checkNotNullParameter(r100, "status");
            IntRange r101 = new IntRange(CastIntegerProtector.parseInt("1"), CastIntegerProtector.parseInt("5"));
            Integer r102 = StringsKt.toIntOrNull(r100);
            if (r102 != null) goto L5;
        L7:
            return false;
        L5:
            if (r101.contains(r102.intValue()) == false) goto L7;
            return true;
        }
    }

    static {
        Companion = new Companion(null);
    }

    @JvmStatic
    public static final boolean isValidStatus(String r100) {
        return Companion.isValidStatus(r100);
    }

    public AnchorGamePromoteStatus() {
        this.status = "-1";
    }

    public AnchorGamePromoteStatus(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L18;
        if (r102 != 1) goto L8;
        this.status = am3.h.c(r100);
        goto L3
    L8:
        if (r102 != 16) goto L10;
        this.bubbleMessage = am3.h.c(r100);
        goto L3
    L10:
        if (r102 != 6) goto L12;
        this.hasPropPermission = am3.h.a(r100);
        goto L3
    L12:
        if (r102 != 7) goto L13;
        this.hasAgreePropProtocol = am3.h.a(r100);
        goto L3
    L13:
        am3.h.e(r100);
        goto L3
    L18:
        r100.d(r101);
        if (this.status != null) goto L37;
        this.status = "-1";
        return;
    }
}
