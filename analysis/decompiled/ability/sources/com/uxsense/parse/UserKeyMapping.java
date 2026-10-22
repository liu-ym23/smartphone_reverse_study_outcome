package com.uxsense.parse;

import androidx.autofill.HintConstants;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BM\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\nHÆ\u0003JO\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\"HÖ\u0001J\t\u0010#\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006$"}, d2 = {"Lcom/uxsense/parse/UserKeyMapping;", "", "nickname", "", "uuid", "avatar", "age", "bio", HintConstants.AUTOFILL_HINT_GENDER, "statsMapping", "Lcom/uxsense/parse/UserStatsKeyMapping;", AppAgent.CONSTRUCT, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/uxsense/parse/UserStatsKeyMapping;)V", "getNickname", "()Ljava/lang/String;", "getUuid", "getAvatar", "getAge", "getBio", "getGender", "getStatsMapping", "()Lcom/uxsense/parse/UserStatsKeyMapping;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "", "toString", "uxsense_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class UserKeyMapping {
    private final String age;
    private final String avatar;
    private final String bio;
    private final String gender;
    private final String nickname;
    private final UserStatsKeyMapping statsMapping;
    private final String uuid;

    public UserKeyMapping() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    public static /* synthetic */ UserKeyMapping copy$default(UserKeyMapping userKeyMapping, String str, String str2, String str3, String str4, String str5, String str6, UserStatsKeyMapping userStatsKeyMapping, int i, Object obj) {
        if ((i & 1) != 0) {
            str = userKeyMapping.nickname;
        }
        if ((i & 2) != 0) {
            str2 = userKeyMapping.uuid;
        }
        if ((i & 4) != 0) {
            str3 = userKeyMapping.avatar;
        }
        if ((i & 8) != 0) {
            str4 = userKeyMapping.age;
        }
        if ((i & 16) != 0) {
            str5 = userKeyMapping.bio;
        }
        if ((i & 32) != 0) {
            str6 = userKeyMapping.gender;
        }
        if ((i & 64) != 0) {
            userStatsKeyMapping = userKeyMapping.statsMapping;
        }
        String str7 = str6;
        UserStatsKeyMapping userStatsKeyMapping2 = userStatsKeyMapping;
        String str8 = str5;
        String str9 = str3;
        return userKeyMapping.copy(str, str2, str9, str4, str8, str7, userStatsKeyMapping2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getNickname() {
        return this.nickname;
    }

    /* renamed from: component2, reason: from getter */
    public final String getUuid() {
        return this.uuid;
    }

    /* renamed from: component3, reason: from getter */
    public final String getAvatar() {
        return this.avatar;
    }

    /* renamed from: component4, reason: from getter */
    public final String getAge() {
        return this.age;
    }

    /* renamed from: component5, reason: from getter */
    public final String getBio() {
        return this.bio;
    }

    /* renamed from: component6, reason: from getter */
    public final String getGender() {
        return this.gender;
    }

    /* renamed from: component7, reason: from getter */
    public final UserStatsKeyMapping getStatsMapping() {
        return this.statsMapping;
    }

    public final UserKeyMapping copy(String nickname, String uuid, String avatar, String age, String bio, String gender, UserStatsKeyMapping statsMapping) {
        k.f(nickname, "nickname");
        k.f(uuid, "uuid");
        k.f(avatar, "avatar");
        k.f(age, "age");
        k.f(bio, "bio");
        k.f(gender, "gender");
        k.f(statsMapping, "statsMapping");
        return new UserKeyMapping(nickname, uuid, avatar, age, bio, gender, statsMapping);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UserKeyMapping)) {
            return false;
        }
        UserKeyMapping userKeyMapping = (UserKeyMapping) other;
        return k.b(this.nickname, userKeyMapping.nickname) && k.b(this.uuid, userKeyMapping.uuid) && k.b(this.avatar, userKeyMapping.avatar) && k.b(this.age, userKeyMapping.age) && k.b(this.bio, userKeyMapping.bio) && k.b(this.gender, userKeyMapping.gender) && k.b(this.statsMapping, userKeyMapping.statsMapping);
    }

    public final String getAge() {
        return this.age;
    }

    public final String getAvatar() {
        return this.avatar;
    }

    public final String getBio() {
        return this.bio;
    }

    public final String getGender() {
        return this.gender;
    }

    public final String getNickname() {
        return this.nickname;
    }

    public final UserStatsKeyMapping getStatsMapping() {
        return this.statsMapping;
    }

    public final String getUuid() {
        return this.uuid;
    }

    public int hashCode() {
        return this.statsMapping.hashCode() + B7.a.c(B7.a.c(B7.a.c(B7.a.c(B7.a.c(this.nickname.hashCode() * 31, 31, this.uuid), 31, this.avatar), 31, this.age), 31, this.bio), 31, this.gender);
    }

    public String toString() {
        return "UserKeyMapping(nickname=" + this.nickname + ", uuid=" + this.uuid + ", avatar=" + this.avatar + ", age=" + this.age + ", bio=" + this.bio + ", gender=" + this.gender + ", statsMapping=" + this.statsMapping + ')';
    }

    public UserKeyMapping(String nickname, String uuid, String avatar, String age, String bio, String gender, UserStatsKeyMapping statsMapping) {
        k.f(nickname, "nickname");
        k.f(uuid, "uuid");
        k.f(avatar, "avatar");
        k.f(age, "age");
        k.f(bio, "bio");
        k.f(gender, "gender");
        k.f(statsMapping, "statsMapping");
        this.nickname = nickname;
        this.uuid = uuid;
        this.avatar = avatar;
        this.age = age;
        this.bio = bio;
        this.gender = gender;
        this.statsMapping = statsMapping;
    }

    public /* synthetic */ UserKeyMapping(String str, String str2, String str3, String str4, String str5, String str6, UserStatsKeyMapping userStatsKeyMapping, int i, e eVar) {
        this((i & 1) != 0 ? "nickname" : str, (i & 2) != 0 ? "uuid" : str2, (i & 4) != 0 ? "avatar" : str3, (i & 8) != 0 ? "age" : str4, (i & 16) != 0 ? "bio" : str5, (i & 32) != 0 ? HintConstants.AUTOFILL_HINT_GENDER : str6, (i & 64) != 0 ? new UserStatsKeyMapping(null, null, 3, null) : userStatsKeyMapping);
    }
}
