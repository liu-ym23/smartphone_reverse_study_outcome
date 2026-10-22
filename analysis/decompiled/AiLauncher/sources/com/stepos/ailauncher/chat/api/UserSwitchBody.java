package com.stepos.ailauncher.chat.api;

import com.stepos.ailauncher.chat.trace.ChatTracker;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/stepos/ailauncher/chat/api/UserSwitchBody;", "", "key", "", "value_json", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getKey", "()Ljava/lang/String;", "getValue_json", "component1", "component2", ChatTracker.CLICK_COPY, "equals", "", "other", "hashCode", "", "toString", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class UserSwitchBody {
    private final String key;
    private final String value_json;

    public UserSwitchBody(String key, String value_json) {
        p.i(key, "key");
        p.i(value_json, "value_json");
        this.key = key;
        this.value_json = value_json;
    }

    public static /* synthetic */ UserSwitchBody copy$default(UserSwitchBody userSwitchBody, String str, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = userSwitchBody.key;
        }
        if ((i10 & 2) != 0) {
            str2 = userSwitchBody.value_json;
        }
        return userSwitchBody.copy(str, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getKey() {
        return this.key;
    }

    /* renamed from: component2, reason: from getter */
    public final String getValue_json() {
        return this.value_json;
    }

    public final UserSwitchBody copy(String key, String value_json) {
        p.i(key, "key");
        p.i(value_json, "value_json");
        return new UserSwitchBody(key, value_json);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UserSwitchBody)) {
            return false;
        }
        UserSwitchBody userSwitchBody = (UserSwitchBody) other;
        return p.d(this.key, userSwitchBody.key) && p.d(this.value_json, userSwitchBody.value_json);
    }

    public final String getKey() {
        return this.key;
    }

    public final String getValue_json() {
        return this.value_json;
    }

    public int hashCode() {
        return (this.key.hashCode() * 31) + this.value_json.hashCode();
    }

    public String toString() {
        return "UserSwitchBody(key=" + this.key + ", value_json=" + this.value_json + ")";
    }
}
