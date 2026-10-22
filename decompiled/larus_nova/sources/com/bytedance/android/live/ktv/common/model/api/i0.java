package com.bytedance.android.live.ktv.common.model.api;

import com.bytedance.android.livesdk.d9;
import com.bytedance.android.tools.pbadapter.annotation.IgnoreProtoFieldCheck;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b7\u0010\u000bR0\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\b\u0004\u0010\u0005\u0012\u0004\b\n\u0010\u000b\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR0\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\b\r\u0010\u0005\u0012\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR(\u0010\u0011\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\b\u0011\u0010\u0012\u0012\u0004\b\u0017\u0010\u000b\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R(\u0010\u0018\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\b\u0018\u0010\u0019\u0012\u0004\b\u001e\u0010\u000b\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010\u001f\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010\u0012\u001a\u0004\b \u0010\u0014\"\u0004\b!\u0010\u0016R\"\u0010#\u001a\u00020\"8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\"\u0010)\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b)\u0010\u0019\u001a\u0004\b*\u0010\u001b\"\u0004\b+\u0010\u001dR0\u0010.\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020-\u0018\u00010,8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R0\u00104\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020-\u0018\u00010,8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b4\u0010/\u001a\u0004\b5\u00101\"\u0004\b6\u00103¨\u00068"}, d2 = {"Lcom/bytedance/android/live/ktv/common/model/api/i0;", "", "", "", "chorusUsers", "Ljava/util/List;", "getChorusUsers", "()Ljava/util/List;", "setChorusUsers", "(Ljava/util/List;)V", "getChorusUsers$annotations", "()V", "", "chorusUserOpenIds", "getChorusUserOpenIds", "setChorusUserOpenIds", "getChorusUserOpenIds$annotations", "leadUserId", "J", "getLeadUserId", "()J", "setLeadUserId", "(J)V", "getLeadUserId$annotations", "leadOpenId", "Ljava/lang/String;", "getLeadOpenId", "()Ljava/lang/String;", "setLeadOpenId", "(Ljava/lang/String;)V", "getLeadOpenId$annotations", "songId", "d", "setSongId", "", "songType", "I", "getSongType", "()I", "setSongType", "(I)V", "chorusId", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setChorusId", "", "Lcom/bytedance/android/live/ktv/common/model/api/l0;", "userBaseMap", "Ljava/util/Map;", "getUserBaseMap", "()Ljava/util/Map;", "setUserBaseMap", "(Ljava/util/Map;)V", "openUserBaseMap", "getOpenUserBaseMap", "setOpenUserBaseMap", "<init>", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class i0 implements vh7.h {

    @SerializedName("chorus_id")
    protected String chorusId;

    @IgnoreProtoFieldCheck
    @SerializedName("user_open_ids")
    protected List<String> chorusUserOpenIds;

    @IgnoreProtoFieldCheck
    @SerializedName("user_ids")
    protected List<Long> chorusUsers;

    @IgnoreProtoFieldCheck
    @SerializedName("leader_user_open_id")
    protected String leadOpenId;

    @IgnoreProtoFieldCheck
    @SerializedName("leader_user_id")
    protected long leadUserId;

    @IgnoreProtoFieldCheck
    @SerializedName("open_user_base_map")
    protected Map<String, l0> openUserBaseMap;

    @SerializedName("song_id")
    protected long songId;

    @SerializedName("song_type")
    protected int songType;

    @IgnoreProtoFieldCheck
    @SerializedName("user_base_map")
    protected Map<Long, l0> userBaseMap;

    public final String c() {
        return d9.c(Long.valueOf(this.leadUserId), this.leadOpenId);
    }

    public i0() {
        this.leadOpenId = "";
        this.chorusId = "";
    }

    public final String a() {
        return this.chorusId;
    }

    public final List<String> b() {
        return this.chorusUserOpenIds;
    }

    public final long d() {
        return this.songId;
    }

    public final Map<String, l0> e() {
        return this.openUserBaseMap;
    }

    public i0(am3.g r110) {
        this.chorusUsers = new ArrayList();
        this.chorusUserOpenIds = new ArrayList();
        this.userBaseMap = new HashMap();
        this.openUserBaseMap = new HashMap();
        long r100 = r110.c();
    L3:
        int r101 = r110.f();
        if (r101 == (-1)) goto L49;
        Object r102 = null;
        switch(r101) {
            case 1: goto L47;
            case 2: goto L46;
            case 3: goto L45;
            case 4: goto L44;
            case 5: goto L28;
            case 6: goto L27;
            default: goto L7;
        };
    L27:
        this.chorusId = am3.h.c(r110);
        goto L3
    L28:
        long r103 = r110.c();
        l0 r104 = null;
    L29:
        int r111 = r110.f();
        if (r111 == (-1)) goto L36;
        if (r111 != 1) goto L32;
        r102 = Long.valueOf(r110.j());
        goto L29
    L32:
        if (r111 != 2) goto L33;
        r104 = new l0(r110);
        goto L29
    L33:
        am3.h.e(r110);
        goto L29
    L36:
        r110.d(r103);
        Map r105 = this.userBaseMap;
        if (r102 == null) goto L43;
        if (r104 == null) goto L41;
    L39:
        r105.put(r102, r104);
        goto L3
    L41:
        throw new IllegalStateException("Value must not be null");
    L43:
        throw new IllegalStateException("Key must not be null");
    L44:
        this.songType = r110.i();
        goto L3
    L45:
        this.songId = r110.j();
        goto L3
    L46:
        this.leadUserId = r110.j();
        goto L3
    L47:
        List r106 = this.chorusUsers;
        Comparable r107 = Long.valueOf(r110.j());
    L48:
        r106.add(r107);
        goto L3
    L7:
        switch(r101) {
            case 5000: goto L26;
            case 5001: goto L25;
            case 5002: goto L9;
            default: goto L8;
        };
    L9:
        long r108 = r110.c();
        r104 = null;
    L10:
        int r112 = r110.f();
        if (r112 == (-1)) goto L17;
        if (r112 != 1) goto L13;
        r102 = am3.h.c(r110);
        goto L10
    L13:
        if (r112 != 2) goto L14;
        r104 = new l0(r110);
        goto L10
    L14:
        am3.h.e(r110);
        goto L10
    L17:
        r110.d(r108);
        r105 = this.openUserBaseMap;
        if (r102 == null) goto L24;
        if (r104 != null) goto L39;
        throw new IllegalStateException("Value must not be null");
    L24:
        throw new IllegalStateException("Key must not be null");
    L25:
        this.leadOpenId = am3.h.c(r110);
        goto L3
    L26:
        r106 = this.chorusUserOpenIds;
        r107 = am3.h.c(r110);
        goto L48
    L8:
        am3.h.e(r110);
        goto L3
    L49:
        r110.d(r100);
        if (this.leadOpenId != null) goto L53;
        this.leadOpenId = "";
    L53:
        if (this.chorusId != null) goto L99;
        this.chorusId = "";
        return;
    }
}
