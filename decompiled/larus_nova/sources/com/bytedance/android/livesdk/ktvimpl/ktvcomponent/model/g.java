package com.bytedance.android.livesdk.ktvimpl.ktvcomponent.model;

import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0015\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001c\u0010\u001dR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u0016\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R$\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u0004\u001a\u0004\b\u001a\u0010\u0006\"\u0004\b\u001b\u0010\b¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/ktvcomponent/model/g;", "", "", "audienceSingEnable", "Ljava/lang/Boolean;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/Boolean;", "setAudienceSingEnable", "(Ljava/lang/Boolean;)V", "", "openSource", "Ljava/lang/Integer;", "d", "()Ljava/lang/Integer;", "setOpenSource", "(Ljava/lang/Integer;)V", "multiChorusSwitch", "Z", "b", "()Z", "setMultiChorusSwitch", "(Z)V", "openStageHideLyricsSwitch", "e", "f", "openRealtimeChorusSwitch", "c", "setOpenRealtimeChorusSwitch", "<init>", "()V", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class g implements vh7.h {

    @SerializedName("open_audience_add_song_switch")
    protected Boolean audienceSingEnable;

    @SerializedName("open_audience_multi_chorus_switch")
    protected boolean multiChorusSwitch;

    @SerializedName("open_realtime_chorus_switch")
    protected Boolean openRealtimeChorusSwitch;

    @SerializedName(ILiveRoomPlayFragmentConstant.EXTRA_OPEN_SOURCE)
    protected Integer openSource;

    @SerializedName("open_stage_hide_lyrics_switch")
    protected boolean openStageHideLyricsSwitch;

    public final void f() {
        this.openStageHideLyricsSwitch = true;
    }

    public g() {
        Boolean r100 = Boolean.FALSE;
        this.audienceSingEnable = r100;
        this.openRealtimeChorusSwitch = r100;
    }

    public final Boolean a() {
        return this.audienceSingEnable;
    }

    public final boolean b() {
        return this.multiChorusSwitch;
    }

    public final Boolean c() {
        return this.openRealtimeChorusSwitch;
    }

    public final Integer d() {
        return this.openSource;
    }

    public final boolean e() {
        return this.openStageHideLyricsSwitch;
    }

    public g(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L21;
        if (r102 != 1) goto L8;
        this.audienceSingEnable = Boolean.valueOf(am3.h.a(r100));
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.openSource = Integer.valueOf(r100.i());
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.multiChorusSwitch = am3.h.a(r100);
        goto L3
    L12:
        if (r102 != 4) goto L14;
        this.openStageHideLyricsSwitch = am3.h.a(r100);
        goto L3
    L14:
        if (r102 != 5) goto L15;
        this.openRealtimeChorusSwitch = Boolean.valueOf(am3.h.a(r100));
        goto L3
    L15:
        am3.h.e(r100);
        goto L3
    L21:
        r100.d(r101);
        if (this.audienceSingEnable != null) goto L25;
        this.audienceSingEnable = Boolean.FALSE;
    L25:
        if (this.openRealtimeChorusSwitch != null) goto L46;
        this.openRealtimeChorusSwitch = Boolean.FALSE;
        return;
    }
}
