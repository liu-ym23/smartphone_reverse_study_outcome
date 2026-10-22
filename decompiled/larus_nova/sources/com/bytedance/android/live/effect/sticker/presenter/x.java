package com.bytedance.android.live.effect.sticker.presenter;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import io.reactivex.disposables.CompositeDisposable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, a> f68413a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<Object> f68414b;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001a\u0010\u000b\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001a\u0010\r\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006R\u001a\u0010\u000f\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006R\u001a\u0010\u0011\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/live/effect/sticker/presenter/x$a;", "", "", "stickerID", "Ljava/lang/String;", "getStickerID", "()Ljava/lang/String;", "extra", "getExtra", "teaLogParams", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "messageType", "getMessageType", "arg1", "getArg1", "arg2", "getArg2", "arg3", "getArg3", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a {

        @SerializedName("arg1")
        private final String arg1;

        @SerializedName("arg2")
        private final String arg2;

        @SerializedName("arg3")
        private final String arg3;

        @SerializedName("extra")
        private final String extra;

        @SerializedName("message_type")
        private final String messageType;

        @SerializedName("sticker_id")
        private final String stickerID;

        @SerializedName("tea_log_params")
        private final String teaLogParams;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof a) == false) goto L20;
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.stickerID, r101.stickerID) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.extra, r101.extra) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.teaLogParams, r101.teaLogParams) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.messageType, r101.messageType) == true) goto L14;
            return false;
        L14:
            if (Intrinsics.areEqual(this.arg1, r101.arg1) == true) goto L16;
            return false;
        L16:
            if (Intrinsics.areEqual(this.arg2, r101.arg2) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.arg3, r101.arg3) == true) goto L31;
            return false;
        L31:
            return true;
        L20:
            return false;
        }

        public final int hashCode() {
            String r100 = this.stickerID;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            String r104 = this.extra;
            if (r104 == null) goto L9;
            int r105 = r104.hashCode();
        L10:
            int r106 = (r103 + r105) * 31;
            String r107 = this.teaLogParams;
            if (r107 == null) goto L13;
            int r108 = r107.hashCode();
        L14:
            int r109 = (r106 + r108) * 31;
            String r110 = this.messageType;
            if (r110 == null) goto L17;
            int r111 = r110.hashCode();
        L18:
            int r112 = (r109 + r111) * 31;
            String r113 = this.arg1;
            if (r113 == null) goto L21;
            int r114 = r113.hashCode();
        L22:
            int r115 = (r112 + r114) * 31;
            String r116 = this.arg2;
            if (r116 == null) goto L25;
            int r117 = r116.hashCode();
        L26:
            int r118 = (r115 + r117) * 31;
            String r119 = this.arg3;
            if (r119 == null) goto L30;
            r101 = r119.hashCode();
        L30:
            return r118 + r101;
        L25:
            r117 = 0;
            goto L26
        L21:
            r114 = 0;
            goto L22
        L17:
            r111 = 0;
            goto L18
        L13:
            r108 = 0;
            goto L14
        L9:
            r105 = 0;
            goto L10
        L5:
            r102 = 0;
            goto L6
        }

        public final String toString() {
            return "InteractStickerInfo(stickerID=" + this.stickerID + ", extra=" + this.extra + ", teaLogParams=" + this.teaLogParams + ", messageType=" + this.messageType + ", arg1=" + this.arg1 + ", arg2=" + this.arg2 + ", arg3=" + this.arg3 + ")";
        }

        public final String a() {
            return this.teaLogParams;
        }
    }

    public x() {
        this.f68413a = new LinkedHashMap();
        this.f68414b = new ArrayList();
        new CompositeDisposable();
    }
}
