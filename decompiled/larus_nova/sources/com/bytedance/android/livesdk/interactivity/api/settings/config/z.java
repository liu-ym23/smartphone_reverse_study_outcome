package com.bytedance.android.livesdk.interactivity.api.settings.config;

import com.amap.api.col.s.ce;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import r52.e2;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0018\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0001\nB\u0007¢\u0006\u0004\b\"\u0010#R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\"\u0010\u0012\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\"\u0010\u0015\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\"\u0010\u0018\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0004\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\"\u0010\u001c\u001a\u00020\u001b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!¨\u0006$"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/settings/config/z;", "", "", "enable", "Z", ce.f26391f, "()Z", "setEnable", "(Z)V", "anchorEnable", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setAnchorEnable", "disableAnswerPin", "b", "setDisableAnswerPin", "disableVideoPin", "f", "setDisableVideoPin", "disableMicroAppPin", "d", "setDisableMicroAppPin", "disableIMPin", "c", "setDisableIMPin", "disablePictureTextPin", "e", "setDisablePictureTextPin", "", "maxShowCount", "I", "h", "()I", "setMaxShowCount", "(I)V", "<init>", "()V", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f133764a = null;

    @SerializedName("anchor_enable")
    private boolean anchorEnable;

    @SerializedName("disable_answer_pin")
    private boolean disableAnswerPin;

    @SerializedName("disable_im_pin")
    private boolean disableIMPin;

    @SerializedName("disable_micro_app_pin")
    private boolean disableMicroAppPin;

    @SerializedName("disable_picture_text_pin")
    private boolean disablePictureTextPin;

    @SerializedName("disable_video_pin")
    private boolean disableVideoPin;

    @SerializedName("enable")
    private boolean enable;

    @SerializedName("max_show_count")
    private int maxShowCount;

    public static final class a {
        public a() {
        }

        public static z b() {
            return e2.f536172a.getValue();
        }

        @JvmStatic
        public static boolean a(DataCenter r100) {
            if (r100 != null) goto L5;
        L7:
            boolean r101 = false;
        L8:
            if (r101 == true) goto L27;
            if (r100 == null) goto L21;
            IRoom r102 = com.bytedance.android.live.core.utils.a0.f66111a;
            Intrinsics.checkNotNullParameter(r100, "$this$isMiddlewareAudienceMediaOrVsRoom");
            if (com.bytedance.android.live.core.utils.a0.d(r100, false) == false) goto L14;
        L18:
            boolean r103 = false;
        L19:
            if (r103 == true) goto L21;
            boolean r104 = true;
        L23:
            if (b().g() == false) goto L28;
            if (r104 == false) goto L29;
            return true;
        L29:
            return false;
        L28:
            return false;
        L14:
            if (com.bytedance.android.live.core.utils.a0.k(r100) == false) goto L16;
        L17:
            r103 = true;
            goto L19
        L16:
            if (com.bytedance.android.live.core.utils.a0.j(r100) == false) goto L18;
        L21:
            r104 = false;
            goto L23
        L27:
            return b().a();
        L5:
            if (com.bytedance.android.live.core.utils.a0.d(r100, false) != true) goto L7;
            r101 = true;
            goto L8
        }
    }

    static {
        f133764a = new a();
    }

    public z() {
        this.anchorEnable = true;
        this.disableAnswerPin = true;
        this.disableVideoPin = true;
        this.disableMicroAppPin = true;
        this.disableIMPin = true;
        this.disablePictureTextPin = true;
        this.maxShowCount = 2;
    }

    public final boolean a() {
        return this.anchorEnable;
    }

    public final boolean b() {
        return this.disableAnswerPin;
    }

    public final boolean c() {
        return this.disableIMPin;
    }

    public final boolean d() {
        return this.disableMicroAppPin;
    }

    public final boolean e() {
        return this.disablePictureTextPin;
    }

    public final boolean f() {
        return this.disableVideoPin;
    }

    public final boolean g() {
        return this.enable;
    }

    public final int h() {
        return this.maxShowCount;
    }
}
