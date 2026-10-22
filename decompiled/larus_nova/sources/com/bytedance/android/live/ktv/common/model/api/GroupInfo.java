package com.bytedance.android.live.ktv.common.model.api;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001:\u0001\u001aB\u0007¢\u0006\u0004\b\u0018\u0010\u0019R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087D¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006R\u001a\u0010\u0014\u001a\u00020\u00138\u0006X\u0087D¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/live/ktv/common/model/api/GroupInfo;", "", "", "id", "J", "b", "()J", "", "name", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "Lpy/k;", "avatar", "Lpy/k;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lpy/k;", "population", "d", "", "user_in_group_status", "I", "e", "()I", "<init>", "()V", "UserInGroupStatus", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class GroupInfo implements vh7.h {

    @SerializedName("avatar")
    protected py.k avatar;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    protected long f69982id;

    @SerializedName("name")
    protected String name;

    @SerializedName("population")
    protected long population;

    @SerializedName("user_in_group_status")
    protected int user_in_group_status;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/live/ktv/common/model/api/GroupInfo$UserInGroupStatus;", "", "", "value", "I", "getValue", "()I", "Clear", "Applied", "Engaged", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum UserInGroupStatus extends Enum<UserInGroupStatus> {
        public static final UserInGroupStatus Applied = null;
        public static final UserInGroupStatus Clear = null;
        public static final UserInGroupStatus Engaged = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ UserInGroupStatus[] f69983a = null;
        private final int value;

        static {
            UserInGroupStatus r100 = new UserInGroupStatus("Clear", 0, 0);
            Clear = r100;
            UserInGroupStatus r101 = new UserInGroupStatus("Applied", 1, 1);
            Applied = r101;
            UserInGroupStatus r102 = new UserInGroupStatus("Engaged", 2, 2);
            Engaged = r102;
            f69983a = new UserInGroupStatus[]{r100, r101, r102};
        }

        public static UserInGroupStatus valueOf(String r100) {
            return (UserInGroupStatus) r27.a.a(UserInGroupStatus.class, r100);
        }

        public static UserInGroupStatus[] values() {
            return (UserInGroupStatus[]) f69983a.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public UserInGroupStatus(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public GroupInfo() {
        this.name = "";
    }

    public final py.k a() {
        return this.avatar;
    }

    public final long b() {
        return this.f69982id;
    }

    public final String c() {
        return this.name;
    }

    public final long d() {
        return this.population;
    }

    public final int e() {
        return this.user_in_group_status;
    }

    /* JADX WARN: Type inference failed for: r2v4, types: [java.lang.Object, py.k] */
    public GroupInfo(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L21;
        if (r102 != 1) goto L8;
        this.f69982id = r100.j();
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.name = am3.h.c(r100);
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.avatar = vh7.f.a(r100, py.k.class);
        goto L3
    L12:
        if (r102 != 4) goto L14;
        this.population = r100.j();
        goto L3
    L14:
        if (r102 != 5) goto L15;
        this.user_in_group_status = r100.i();
        goto L3
    L15:
        am3.h.e(r100);
        goto L3
    L21:
        r100.d(r101);
        if (this.name != null) goto L43;
        this.name = "";
        return;
    }
}
