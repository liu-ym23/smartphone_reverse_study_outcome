package com.stepos.ailauncher.agent.skill.detail;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0080\b\u0018\u00002\u00020\u0001B3\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0015\u001a\u0004\b\u0016\u0010\u000bR\u001a\u0010\u0006\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0017\u001a\u0004\b\u0018\u0010\rR\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0017\u001a\u0004\b\u0019\u0010\r¨\u0006\u001a"}, d2 = {"Lcom/stepos/ailauncher/agent/skill/detail/b;", "", "", "id", "", "name", "needSkillMd", "testing", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;II)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/Integer;", "getId", "()Ljava/lang/Integer;", "Ljava/lang/String;", "getName", "I", "getNeedSkillMd", "getTesting", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.agent.skill.detail.b, reason: case insensitive filesystem and from toString */
/* loaded from: classes3.dex */
public final /* data */ class GetSkillRequest {

    @SerializedName("id")
    private final Integer id;

    @SerializedName("name")
    private final String name;

    @SerializedName("need_skill_md")
    private final int needSkillMd;

    @SerializedName("testing")
    private final int testing;

    public GetSkillRequest() {
        this(null, null, 0, 0, 15, null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GetSkillRequest)) {
            return false;
        }
        GetSkillRequest getSkillRequest = (GetSkillRequest) other;
        return kotlin.jvm.internal.p.d(this.id, getSkillRequest.id) && kotlin.jvm.internal.p.d(this.name, getSkillRequest.name) && this.needSkillMd == getSkillRequest.needSkillMd && this.testing == getSkillRequest.testing;
    }

    public int hashCode() {
        Integer num = this.id;
        int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
        String str = this.name;
        return ((((iHashCode + (str != null ? str.hashCode() : 0)) * 31) + Integer.hashCode(this.needSkillMd)) * 31) + Integer.hashCode(this.testing);
    }

    public String toString() {
        return "GetSkillRequest(id=" + this.id + ", name=" + this.name + ", needSkillMd=" + this.needSkillMd + ", testing=" + this.testing + ")";
    }

    public GetSkillRequest(Integer num, String str, int i10, int i11) {
        this.id = num;
        this.name = str;
        this.needSkillMd = i10;
        this.testing = i11;
    }

    public /* synthetic */ GetSkillRequest(Integer num, String str, int i10, int i11, int i12, kotlin.jvm.internal.i iVar) {
        this((i12 & 1) != 0 ? null : num, (i12 & 2) != 0 ? null : str, (i12 & 4) != 0 ? 1 : i10, (i12 & 8) != 0 ? 0 : i11);
    }
}
