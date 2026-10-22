package com.stepos.ailauncher.task.space;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.Parameters;
import java.io.Serializable;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\f\u001a\u00020\u0006¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0016\u001a\u0004\b\u0017\u0010\u000fR\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0016\u001a\u0004\b\u0018\u0010\u000fR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0016\u001a\u0004\b\u0019\u0010\u000fR\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0019\u0010\t\u001a\u0004\u0018\u00010\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f¨\u0006 "}, d2 = {"Lcom/stepos/ailauncher/task/space/MemorySettingResponse;", "Ljava/io/Serializable;", "", "status", "user_id", Parameters.DEVICE_ID, "", "memory_share_enabled", "", "version", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Integer;)V", "f", "()Z", "toString", "()Ljava/lang/String;", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "c", Const.INTENT_KEY_UMID, Const.INTENT_KEY_APIKEY, "Ljava/lang/Boolean;", Const.INTENT_KEY_PKGNAME, "()Ljava/lang/Boolean;", "Ljava/lang/Integer;", "e", "()Ljava/lang/Integer;", "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class MemorySettingResponse implements Serializable {
    private final String device_id;
    private final Boolean memory_share_enabled;
    private final String status;
    private final String user_id;
    private final Integer version;

    public MemorySettingResponse() {
        this(null, null, null, null, null, 31, null);
    }

    /* renamed from: a, reason: from getter */
    public final String getDevice_id() {
        return this.device_id;
    }

    /* renamed from: b, reason: from getter */
    public final Boolean getMemory_share_enabled() {
        return this.memory_share_enabled;
    }

    /* renamed from: c, reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    /* renamed from: d, reason: from getter */
    public final String getUser_id() {
        return this.user_id;
    }

    /* renamed from: e, reason: from getter */
    public final Integer getVersion() {
        return this.version;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MemorySettingResponse)) {
            return false;
        }
        MemorySettingResponse memorySettingResponse = (MemorySettingResponse) other;
        return kotlin.jvm.internal.p.d(this.status, memorySettingResponse.status) && kotlin.jvm.internal.p.d(this.user_id, memorySettingResponse.user_id) && kotlin.jvm.internal.p.d(this.device_id, memorySettingResponse.device_id) && kotlin.jvm.internal.p.d(this.memory_share_enabled, memorySettingResponse.memory_share_enabled) && kotlin.jvm.internal.p.d(this.version, memorySettingResponse.version);
    }

    public final boolean f() {
        return kotlin.jvm.internal.p.d(this.status, "success");
    }

    public int hashCode() {
        String str = this.status;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.user_id;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.device_id;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Boolean bool = this.memory_share_enabled;
        int iHashCode4 = (iHashCode3 + (bool == null ? 0 : bool.hashCode())) * 31;
        Integer num = this.version;
        return iHashCode4 + (num != null ? num.hashCode() : 0);
    }

    public String toString() {
        return "MemorySettingResponse(status=" + this.status + ", user_id=" + this.user_id + ", device_id=" + this.device_id + ", memory_share_enabled=" + this.memory_share_enabled + ", version=" + this.version + ")";
    }

    public MemorySettingResponse(String str, String str2, String str3, Boolean bool, Integer num) {
        this.status = str;
        this.user_id = str2;
        this.device_id = str3;
        this.memory_share_enabled = bool;
        this.version = num;
    }

    public /* synthetic */ MemorySettingResponse(String str, String str2, String str3, Boolean bool, Integer num, int i10, kotlin.jvm.internal.i iVar) {
        this((i10 & 1) != 0 ? null : str, (i10 & 2) != 0 ? null : str2, (i10 & 4) != 0 ? null : str3, (i10 & 8) != 0 ? null : bool, (i10 & 16) != 0 ? -1 : num);
    }
}
