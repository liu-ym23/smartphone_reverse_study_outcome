package com.bytedance.android.livesdk.config.setting;

import com.bytedance.android.livesdk.config.b00;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\u0018\u00002\u00020\u0001:\u0001\u0005B\u0007¢\u0006\u0004\b\u0012\u0010\u0013R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/livesdk/config/setting/k;", "", "", "enable", "Z", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Z", "setEnable", "(Z)V", "highlightComposePin", "c", "setHighlightComposePin", "highlightComposeAnnouncement", "b", "setHighlightComposeAnnouncement", "highlightContainerRefactor", "getHighlightContainerRefactor", "setHighlightContainerRefactor", "<init>", "()V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f121212a = 0;

    @SerializedName("enable")
    private boolean enable;

    @SerializedName("highlight_compose_announcement")
    private boolean highlightComposeAnnouncement;

    @SerializedName("highlight_compose_pin")
    private boolean highlightComposePin;

    @SerializedName("highlight_container_refactor")
    private boolean highlightContainerRefactor;

    public static final class a {
        @JvmStatic
        public static boolean a() {
            k r100 = b00.f119833a.getValue();
            if (r100.a() == true) goto L5;
        L7:
            return false;
        L5:
            if (r100.b() == false) goto L7;
            return true;
        }
    }

    static {
    }

    public k() {
        this.enable = true;
        this.highlightComposePin = true;
        this.highlightComposeAnnouncement = true;
        this.highlightContainerRefactor = true;
    }

    public final boolean a() {
        return this.enable;
    }

    public final boolean b() {
        return this.highlightComposeAnnouncement;
    }

    public final boolean c() {
        return this.highlightComposePin;
    }
}
