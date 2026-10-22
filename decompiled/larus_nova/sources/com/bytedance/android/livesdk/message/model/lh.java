package com.bytedance.android.livesdk.message.model;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000f\u0010\u0010R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\b¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/lh;", "", "", "audienceSingEnable", "Z", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Z", "setAudienceSingEnable", "(Z)V", "multiChorusSwitch", "b", "setMultiChorusSwitch", "openStageHideLyricsSwitch", "c", "setOpenStageHideLyricsSwitch", "<init>", "()V", "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class lh implements vh7.h {

    @SerializedName("open_audience_add_song_switch")
    protected boolean audienceSingEnable;

    @SerializedName("open_audience_multi_chorus_switch")
    protected boolean multiChorusSwitch;

    @SerializedName("open_stage_hide_lyrics_switch")
    protected boolean openStageHideLyricsSwitch;

    public lh() {
    }

    public lh(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        if (r102 != 1) goto L8;
        this.audienceSingEnable = am3.h.a(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.multiChorusSwitch = am3.h.a(r100);
        goto L3
    L10:
        if (r102 != 3) goto L11;
        this.openStageHideLyricsSwitch = am3.h.a(r100);
        goto L3
    L11:
        am3.h.e(r100);
        goto L3
    L15:
        r100.d(r101);
    }

    public final boolean a() {
        return this.audienceSingEnable;
    }

    public final boolean b() {
        return this.multiChorusSwitch;
    }

    public final boolean c() {
        return this.openStageHideLyricsSwitch;
    }
}
