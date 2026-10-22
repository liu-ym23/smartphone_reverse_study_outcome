package com.bytedance.android.livesdk.chatroom.likeegg;

import am3.g;
import com.bytedance.android.live.base.annotation.ForMain;
import com.bytedance.android.live.base.model.data.f;
import com.bytedance.android.live.base.model.data.n;
import com.bytedance.android.live.base.model.message.m0;
import com.bytedance.android.livesdkapi.message.HighlightAreaPriorityConfig;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001:\u0003\u001c\u001d\u001eB\u0007¢\u0006\u0004\b\u001a\u0010\u001bR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0018\u0010\t\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\f\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u000e\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\rR\u0016\u0010\u000f\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\rR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0007R\u0016\u0010\u0014\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\rR\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0007R\u0016\u0010\u0016\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\rR\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/likeegg/a;", "", "Lcom/bytedance/android/live/base/model/message/m0;", "commonData", "Lcom/bytedance/android/live/base/model/message/m0;", "", "content", "Ljava/lang/String;", "Lcom/bytedance/android/livesdk/chatroom/likeegg/a$c;", "trayColor", "Lcom/bytedance/android/livesdk/chatroom/likeegg/a$c;", "", "userStartTimestamp", "J", "userStartSecond", "duration", "Lcom/bytedance/android/livesdk/chatroom/likeegg/a$b;", "jumpDetail", "Lcom/bytedance/android/livesdk/chatroom/likeegg/a$b;", "prepareContent", "prepareDuration", "finishContent", "finishDuration", "Lcom/bytedance/android/livesdkapi/message/HighlightAreaPriorityConfig;", "highlightAreaPriorityConfig", "Lcom/bytedance/android/livesdkapi/message/HighlightAreaPriorityConfig;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "c", "vs-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a implements h {

    @SerializedName("common")
    public m0 commonData;

    @SerializedName("content")
    public String content;

    @SerializedName("duration")
    public long duration;

    @SerializedName("finish_content")
    public String finishContent;

    @SerializedName("finish_duration")
    public long finishDuration;

    @SerializedName("highlight_area_priority_config")
    public HighlightAreaPriorityConfig highlightAreaPriorityConfig;

    @SerializedName("jump_detail")
    public b jumpDetail;

    @SerializedName("prepare_content")
    public String prepareContent;

    @SerializedName("prepare_duration")
    public long prepareDuration;

    @SerializedName("trayColor")
    public c trayColor;

    @SerializedName("user_start_second")
    public long userStartSecond;

    @SerializedName("user_start_timestamp")
    public long userStartTimestamp;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.chatroom.likeegg.a$a, reason: collision with other inner class name */
    public static final class C1615a {
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0018\u0010\t\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/likeegg/a$b;", "", "", "type", "I", "Lcom/bytedance/android/live/base/model/data/f;", "photoJumpDetail", "Lcom/bytedance/android/live/base/model/data/f;", "Lcom/bytedance/android/live/base/model/data/n;", "templatePhotoJumpDetail", "Lcom/bytedance/android/live/base/model/data/n;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "vs-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    @ForMain
    public static final class b implements h {

        @SerializedName("photo_jump_detail")
        public f photoJumpDetail;

        @SerializedName("template_photo_jump_detail")
        public n templatePhotoJumpDetail;

        @SerializedName("type")
        public int type;

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.chatroom.likeegg.a$b$a, reason: collision with other inner class name */
        public static final class C1616a {
        }

        static {
        }

        public final String toString() {
            return "LikeEggJumpDetail(type=" + this.type + ", photoJumpDetail=" + this.photoJumpDetail + ", templatePhotoJumpDetail=" + this.templatePhotoJumpDetail + ")";
        }

        public b() {
            this.type = 1;
        }

        public b(g r100) {
            long r101 = r100.c();
            boolean r102 = false;
        L3:
            int r103 = r100.f();
            if (r103 == (-1)) goto L14;
            if (r103 != 1) goto L7;
            this.type = r100.i();
            r102 = r102 | true;
            goto L3
        L7:
            if (r103 != 2) goto L9;
            this.photoJumpDetail = new f(r100);
            goto L3
        L9:
            if (r103 != 3) goto L10;
            this.templatePhotoJumpDetail = new n(r100);
            goto L3
        L10:
            am3.h.e(r100);
            goto L3
        L14:
            r100.d(r101);
            if ((r102 & true) == true) goto L30;
            this.type = 1;
            return;
        }
    }

    @ForMain
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0006\u0010\u0007R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/likeegg/a$c;", "", "", "backgroundColor", "Ljava/lang/String;", "barColor", "<init>", "()V", "vs-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class c implements h {

        @SerializedName("background_color")
        public String backgroundColor;

        @SerializedName("bar_color")
        public String barColor;

        public c() {
        }

        public c(g r100) {
            long r101 = r100.c();
        L3:
            int r102 = r100.f();
            if (r102 == (-1)) goto L12;
            if (r102 != 1) goto L8;
            this.backgroundColor = am3.h.c(r100);
            goto L3
        L8:
            if (r102 != 2) goto L9;
            this.barColor = am3.h.c(r100);
            goto L3
        L9:
            am3.h.e(r100);
            goto L3
        L12:
            r100.d(r101);
        }
    }

    static {
    }

    public final String toString() {
        return "LikeEggMessage(content=" + this.content + ", trayColor=" + this.trayColor + ", userStartTimestamp=" + this.userStartTimestamp + ", userStartSecond=" + this.userStartSecond + ", duration=" + this.duration + ", jumpDetail=" + this.jumpDetail + ", prepareContent=" + this.prepareContent + ", prepareDuration=" + this.prepareDuration + ", finishContent=" + this.finishContent + ", finishDuration=" + this.finishDuration + ')';
    }

    public a() {
        this.duration = 10000;
        this.prepareDuration = 3000;
        this.finishDuration = 3000;
    }

    /* JADX WARN: Type inference failed for: r3v13, types: [com.bytedance.android.live.base.model.message.m0, java.lang.Object] */
    public a(g r100) {
        long r101 = r100.c();
        int r102 = 0;
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L21;
        if (r103 != 255) goto L7;
        this.commonData = vh7.f.a(r100, m0.class);
        goto L3
    L7:
        switch(r103) {
            case 1: goto L19;
            case 2: goto L18;
            case 3: goto L17;
            case 4: goto L16;
            case 5: goto L15;
            case 6: goto L14;
            case 7: goto L13;
            case 8: goto L12;
            case 9: goto L11;
            case 10: goto L10;
            case 11: goto L9;
            default: goto L8;
        };
    L9:
        this.highlightAreaPriorityConfig = new HighlightAreaPriorityConfig(r100);
        goto L3
    L10:
        this.finishDuration = r100.j();
        r102 = r102 | 4;
        goto L3
    L11:
        this.finishContent = am3.h.c(r100);
        goto L3
    L12:
        this.prepareDuration = r100.j();
        r102 = r102 | 2;
        goto L3
    L13:
        this.prepareContent = am3.h.c(r100);
        goto L3
    L14:
        this.jumpDetail = new b(r100);
        goto L3
    L15:
        this.duration = r100.j();
        r102 = r102 | 1;
        goto L3
    L16:
        this.userStartSecond = r100.j();
        goto L3
    L17:
        this.userStartTimestamp = r100.j();
        goto L3
    L18:
        this.trayColor = new c(r100);
        goto L3
    L19:
        this.content = am3.h.c(r100);
        goto L3
    L8:
        am3.h.e(r100);
        goto L3
    L21:
        r100.d(r101);
        if ((r102 & 1) != 0) goto L25;
        this.duration = 10000;
    L25:
        if ((r102 & 2) != 0) goto L28;
        this.prepareDuration = 3000;
    L28:
        if ((r102 & 4) != 0) goto L60;
        this.finishDuration = 3000;
        return;
    }
}
