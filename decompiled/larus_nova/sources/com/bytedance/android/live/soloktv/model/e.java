package com.bytedance.android.live.soloktv.model;

import com.bytedance.android.livesdk.chatroom.model.interact.e1;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001e\u0010\u001fR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R*\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006 "}, d2 = {"Lcom/bytedance/android/live/soloktv/model/e;", "", "", "roomId", "Ljava/lang/Long;", "b", "()Ljava/lang/Long;", "setRoomId", "(Ljava/lang/Long;)V", "", "joinChorus", "Ljava/lang/Boolean;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/Boolean;", "setJoinChorus", "(Ljava/lang/Boolean;)V", "", "toast", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "setToast", "(Ljava/lang/String;)V", "", "slideRooms", "Ljava/util/List;", "c", "()Ljava/util/List;", "setSlideRooms", "(Ljava/util/List;)V", "<init>", "()V", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class e implements vh7.h {

    @SerializedName(e1.REPLY_ACTION_JOIN_CHORUS)
    protected Boolean joinChorus;

    @SerializedName("room_id")
    protected Long roomId;

    @SerializedName("slide_rooms")
    protected List<Long> slideRooms;

    @SerializedName("toast")
    protected String toast;

    public e() {
    }

    public final Boolean a() {
        return this.joinChorus;
    }

    public final Long b() {
        return this.roomId;
    }

    public final List<Long> c() {
        return this.slideRooms;
    }

    public final String d() {
        return this.toast;
    }

    public e(am3.g r100) {
        this.slideRooms = new ArrayList();
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L18;
        if (r102 != 1) goto L8;
        this.roomId = Long.valueOf(r100.j());
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.joinChorus = Boolean.valueOf(am3.h.a(r100));
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.toast = am3.h.c(r100);
        goto L3
    L12:
        if (r102 != 4) goto L13;
        this.slideRooms.add(Long.valueOf(r100.j()));
        goto L3
    L13:
        am3.h.e(r100);
        goto L3
    L18:
        r100.d(r101);
    }
}
