package com.bytedance.android.livesdk.message.model;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0010\u000e\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b$\u0010%R(\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\u000b\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0011\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u0017\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R$\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R$\u0010!\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b!\u0010\u001c\u001a\u0004\b\"\u0010\u001e\"\u0004\b#\u0010 ¨\u0006&"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/u2;", "", "", "Lcom/bytedance/android/livesdk/message/model/t2;", "midiRankList", "Ljava/util/List;", "c", "()Ljava/util/List;", "setMidiRankList", "(Ljava/util/List;)V", "", "displayDuration", "J", "b", "()J", "setDisplayDuration", "(J)V", "userNum", "Ljava/lang/Long;", "f", "()Ljava/lang/Long;", "setUserNum", "(Ljava/lang/Long;)V", "songId", "d", "setSongId", "", "songName", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "setSongName", "(Ljava/lang/String;)V", "chorusTotalScore", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setChorusTotalScore", "<init>", "()V", "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class u2 implements vh7.h {

    @SerializedName("chorus_total_score")
    protected String chorusTotalScore;

    @SerializedName("display_duration")
    protected long displayDuration;

    @SerializedName("chorus_midi_rank")
    protected List<t2> midiRankList;

    @SerializedName("song_id")
    protected Long songId;

    @SerializedName("song_name")
    protected String songName;

    @SerializedName("user_num")
    protected Long userNum;

    public u2() {
        this.midiRankList = new ArrayList();
        this.displayDuration = 5;
        this.userNum = 0L;
        this.songId = 0L;
    }

    public final String a() {
        return this.chorusTotalScore;
    }

    public final long b() {
        return this.displayDuration;
    }

    public final List<t2> c() {
        return this.midiRankList;
    }

    public final Long d() {
        return this.songId;
    }

    public final String e() {
        return this.songName;
    }

    public final Long f() {
        return this.userNum;
    }

    public u2(am3.g r100) {
        this.midiRankList = new ArrayList();
        long r101 = r100.c();
        boolean r102 = false;
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L13;
        switch(r103) {
            case 1: goto L12;
            case 2: goto L11;
            case 3: goto L10;
            case 4: goto L9;
            case 5: goto L8;
            case 6: goto L7;
            default: goto L6;
        };
    L7:
        this.chorusTotalScore = am3.h.c(r100);
        goto L3
    L8:
        this.songName = am3.h.c(r100);
        goto L3
    L9:
        this.songId = Long.valueOf(r100.j());
        goto L3
    L10:
        this.userNum = Long.valueOf(r100.j());
        goto L3
    L11:
        this.displayDuration = r100.j();
        r102 = r102 | true;
        goto L3
    L12:
        this.midiRankList.add(new t2(r100));
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L13:
        r100.d(r101);
        if (this.midiRankList.isEmpty() == false) goto L17;
        this.midiRankList = new ArrayList();
    L17:
        if ((r102 & true) == true) goto L20;
        this.displayDuration = 5;
    L20:
        if (this.userNum != null) goto L23;
        this.userNum = 0L;
    L23:
        if (this.songId != null) goto L42;
        this.songId = 0L;
        return;
    }
}
