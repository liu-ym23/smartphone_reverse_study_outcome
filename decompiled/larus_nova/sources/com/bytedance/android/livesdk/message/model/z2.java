package com.bytedance.android.livesdk.message.model;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.cert.manager.constants.EventConstant;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b(\u0010)R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\bR$\u0010\u0013\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR$\u0010\u0016\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u000b\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000fR$\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR*\u0010\"\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010 8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'¨\u0006*"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/z2;", "", "", "chorusId", "J", "getChorusId", "()J", "setChorusId", "(J)V", "", EventConstant.Key.RETAIN_PROMPT, "Ljava/lang/String;", "getPrompt", "()Ljava/lang/String;", "setPrompt", "(Ljava/lang/String;)V", "userCount", "c", "setUserCount", "scoreStr", "b", "setScoreStr", "userNumStr", "d", "setUserNumStr", "Lcom/bytedance/android/livesdk/message/model/ChorusConcertSong;", "concertSong", "Lcom/bytedance/android/livesdk/message/model/ChorusConcertSong;", "getConcertSong", "()Lcom/bytedance/android/livesdk/message/model/ChorusConcertSong;", "setConcertSong", "(Lcom/bytedance/android/livesdk/message/model/ChorusConcertSong;)V", "", "Lcom/bytedance/android/livesdk/message/model/t2;", "chorusMidiRank", "Ljava/util/List;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/List;", "setChorusMidiRank", "(Ljava/util/List;)V", "<init>", "()V", "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class z2 implements vh7.h {

    @SerializedName("chorus_id")
    protected long chorusId;

    @SerializedName("chorus_midi_rank")
    protected List<t2> chorusMidiRank;

    @SerializedName("concert_song")
    protected ChorusConcertSong concertSong;

    @SerializedName(EventConstant.Key.RETAIN_PROMPT)
    protected String prompt;

    @SerializedName("score_str")
    protected String scoreStr;

    @SerializedName("user_num")
    protected long userCount;

    @SerializedName("user_num_str")
    protected String userNumStr;

    public z2() {
        this.prompt = "";
        this.userCount = 1;
    }

    public final List<t2> a() {
        return this.chorusMidiRank;
    }

    public final String b() {
        return this.scoreStr;
    }

    public final long c() {
        return this.userCount;
    }

    public final String d() {
        return this.userNumStr;
    }

    public z2(am3.g r100) {
        this.chorusMidiRank = new ArrayList();
        long r101 = r100.c();
        boolean r102 = false;
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L14;
        switch(r103) {
            case 1: goto L13;
            case 2: goto L12;
            case 3: goto L11;
            case 4: goto L10;
            case 5: goto L9;
            case 6: goto L8;
            case 7: goto L7;
            default: goto L6;
        };
    L7:
        this.chorusMidiRank.add(new t2(r100));
        goto L3
    L8:
        this.concertSong = new ChorusConcertSong(r100);
        goto L3
    L9:
        this.userNumStr = am3.h.c(r100);
        goto L3
    L10:
        this.scoreStr = am3.h.c(r100);
        goto L3
    L11:
        this.userCount = r100.j();
        r102 = r102 | true;
        goto L3
    L12:
        this.prompt = am3.h.c(r100);
        goto L3
    L13:
        this.chorusId = r100.j();
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L14:
        r100.d(r101);
        if (this.prompt != null) goto L18;
        this.prompt = "";
    L18:
        if ((r102 & true) == true) goto L39;
        this.userCount = 1;
        return;
    }
}
