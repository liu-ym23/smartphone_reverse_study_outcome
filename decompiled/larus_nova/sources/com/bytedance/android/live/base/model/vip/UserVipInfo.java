package com.bytedance.android.live.base.model.vip;

import am3.g;
import com.bytedance.android.livesdkapi.performance.ILoadStallMonitor;
import com.bytedance.android.service.manager.alliance.IAllianceService;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import com.ss.android.dypay.api.DyPayConstant;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes45.dex */
@ProtoMessage("webcast.data.UserVIPInfo")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010$\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u0002\n\u0002\b\u0014\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u00101\u001a\u0004\u0018\u00010\u0004J\u0006\u00102\u001a\u00020\nJ\u0006\u00103\u001a\u00020\nJ\b\u00104\u001a\u0004\u0018\u00010\u0013J\u0006\u00105\u001a\u00020\nJ\u0014\u00106\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001cJ\u0006\u00107\u001a\u00020\nJ\u0006\u00108\u001a\u00020\nJ\u0006\u00109\u001a\u00020)J\u0006\u0010:\u001a\u00020\nJ\u0010\u0010;\u001a\u00020<2\b\u0010=\u001a\u0004\u0018\u00010\u0004J\u000e\u0010>\u001a\u00020<2\u0006\u0010?\u001a\u00020\nJ\u000e\u0010@\u001a\u00020<2\u0006\u0010A\u001a\u00020\nJ\u0010\u0010B\u001a\u00020<2\b\u0010C\u001a\u0004\u0018\u00010\u0013J\u000e\u0010D\u001a\u00020<2\u0006\u0010E\u001a\u00020\nJ\u001c\u0010F\u001a\u00020<2\u0014\u0010G\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001cJ\u000e\u0010H\u001a\u00020<2\u0006\u0010I\u001a\u00020\nJ\u000e\u0010J\u001a\u00020<2\u0006\u0010K\u001a\u00020\nJ\u000e\u0010L\u001a\u00020<2\u0006\u0010M\u001a\u00020)J\u000e\u0010N\u001a\u00020<2\u0006\u0010O\u001a\u00020\nR \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR \u0010\u0012\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0018\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\f\"\u0004\b\u001a\u0010\u000eR,\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001e\u0010\"\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\f\"\u0004\b$\u0010\u000eR\u001e\u0010%\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\f\"\u0004\b'\u0010\u000eR\u001e\u0010(\u001a\u00020)8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001e\u0010.\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\f\"\u0004\b0\u0010\u000e¨\u0006P"}, d2 = {"Lcom/bytedance/android/live/base/model/vip/UserVipInfo;", "", "()V", "_badges", "Lcom/bytedance/android/live/base/model/vip/VipBadge;", "get_badges", "()Lcom/bytedance/android/live/base/model/vip/VipBadge;", "set_badges", "(Lcom/bytedance/android/live/base/model/vip/VipBadge;)V", "_endTime", "", "get_endTime", "()J", "set_endTime", "(J)V", "_level", "get_level", "set_level", "_name", "", "get_name", "()Ljava/lang/String;", "set_name", "(Ljava/lang/String;)V", "_needConsume", "get_needConsume", "set_needConsume", "_privileges", "", "", "get_privileges", "()Ljava/util/Map;", "set_privileges", "(Ljava/util/Map;)V", "_remainTime", "get_remainTime", "set_remainTime", "_startTime", "get_startTime", "set_startTime", "_status", "", "get_status", "()I", "set_status", "(I)V", "_totalConsume", "get_totalConsume", "set_totalConsume", "getBadges", "getEndTime", "getLevel", "getName", "getNeedConsume", "getPrivileges", "getRemainTime", "getStartTime", "getStatus", "getTotalConsume", "setBadges", "", "badges", "setEndTime", "endTime", "setLevel", "level", "setName", "name", "setNeedConsume", "needConsume", "setPrivileges", "privileges", "setRemainTime", "remainTime", "setStartTime", DyPayConstant.KEY_START_TIME, "setStatus", "status", "setTotalConsume", "totalConsume", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class UserVipInfo implements h {

    @SerializedName(IAllianceService.CONTENT_TYPE_BADGE)
    protected VipBadge _badges;

    @SerializedName("end_time")
    protected long _endTime;

    @SerializedName("vip_level")
    protected long _level;

    @SerializedName("vip_level_name")
    protected String _name;

    @SerializedName("target_consume")
    protected long _needConsume;

    @SerializedName("privileges")
    protected Map<Long, Boolean> _privileges;

    @SerializedName("remaining_days")
    protected long _remainTime;

    @SerializedName(ILoadStallMonitor.START_TIME)
    protected long _startTime;

    @SerializedName("status")
    protected int _status;

    @SerializedName("total_consume")
    protected long _totalConsume;

    public UserVipInfo() {
    }

    public final VipBadge getBadges() {
        return this._badges;
    }

    public final long getEndTime() {
        return this._endTime;
    }

    public final long getLevel() {
        return this._level;
    }

    public final String getName() {
        return this._name;
    }

    public final long getNeedConsume() {
        return this._needConsume;
    }

    public final Map<Long, Boolean> getPrivileges() {
        return this._privileges;
    }

    public final long getRemainTime() {
        return this._remainTime;
    }

    public final long getStartTime() {
        return this._startTime;
    }

    public final int getStatus() {
        return this._status;
    }

    public final long getTotalConsume() {
        return this._totalConsume;
    }

    public final VipBadge get_badges() {
        return this._badges;
    }

    public final long get_endTime() {
        return this._endTime;
    }

    public final long get_level() {
        return this._level;
    }

    public final String get_name() {
        return this._name;
    }

    public final long get_needConsume() {
        return this._needConsume;
    }

    public final Map<Long, Boolean> get_privileges() {
        return this._privileges;
    }

    public final long get_remainTime() {
        return this._remainTime;
    }

    public final long get_startTime() {
        return this._startTime;
    }

    public final int get_status() {
        return this._status;
    }

    public final long get_totalConsume() {
        return this._totalConsume;
    }

    public UserVipInfo(g r110) {
        this._privileges = new HashMap();
        long r100 = r110.c();
    L3:
        int r101 = r110.f();
        if (r101 == (-1)) goto L34;
        switch(r101) {
            case 1: goto L33;
            case 2: goto L32;
            case 3: goto L31;
            case 4: goto L30;
            case 5: goto L29;
            case 6: goto L28;
            case 7: goto L27;
            case 8: goto L26;
            case 9: goto L25;
            case 10: goto L7;
            default: goto L6;
        };
    L7:
        long r102 = r110.c();
        Long r103 = null;
        Boolean r104 = null;
    L8:
        int r105 = r110.f();
        if (r105 == (-1)) goto L17;
        if (r105 != 1) goto L13;
        r103 = Long.valueOf(r110.j());
        goto L8
    L13:
        if (r105 != 2) goto L14;
        r104 = Boolean.valueOf(am3.h.a(r110));
        goto L8
    L14:
        am3.h.e(r110);
        goto L8
    L17:
        r110.d(r102);
        Map<Long, Boolean> r106 = this._privileges;
        if (r103 == null) goto L24;
        if (r104 == null) goto L22;
        r106.put(r103, r104);
        goto L3
    L22:
        throw new IllegalStateException("Value must not be null");
    L24:
        throw new IllegalStateException("Key must not be null");
    L25:
        this._badges = new VipBadge(r110);
        goto L3
    L26:
        this._needConsume = r110.j();
        goto L3
    L27:
        this._totalConsume = r110.j();
        goto L3
    L28:
        this._remainTime = r110.j();
        goto L3
    L29:
        this._endTime = r110.j();
        goto L3
    L30:
        this._startTime = r110.j();
        goto L3
    L31:
        this._status = r110.i();
        goto L3
    L32:
        this._name = am3.h.c(r110);
        goto L3
    L33:
        this._level = r110.j();
        goto L3
    L6:
        am3.h.e(r110);
        goto L3
    L34:
        r110.d(r100);
    }

    public final void setBadges(VipBadge r100) {
        this._badges = r100;
    }

    public final void setEndTime(long r100) {
        this._endTime = r100;
    }

    public final void setLevel(long r100) {
        this._level = r100;
    }

    public final void setName(String r100) {
        this._name = r100;
    }

    public final void setNeedConsume(long r100) {
        this._needConsume = r100;
    }

    public final void setPrivileges(Map<Long, Boolean> r100) {
        this._privileges = r100;
    }

    public final void setRemainTime(long r100) {
        this._remainTime = r100;
    }

    public final void setStartTime(long r100) {
        this._startTime = r100;
    }

    public final void setStatus(int r100) {
        this._status = r100;
    }

    public final void setTotalConsume(long r100) {
        this._totalConsume = r100;
    }

    public final void set_badges(VipBadge r100) {
        this._badges = r100;
    }

    public final void set_endTime(long r100) {
        this._endTime = r100;
    }

    public final void set_level(long r100) {
        this._level = r100;
    }

    public final void set_name(String r100) {
        this._name = r100;
    }

    public final void set_needConsume(long r100) {
        this._needConsume = r100;
    }

    public final void set_privileges(Map<Long, Boolean> r100) {
        this._privileges = r100;
    }

    public final void set_remainTime(long r100) {
        this._remainTime = r100;
    }

    public final void set_startTime(long r100) {
        this._startTime = r100;
    }

    public final void set_status(int r100) {
        this._status = r100;
    }

    public final void set_totalConsume(long r100) {
        this._totalConsume = r100;
    }
}
