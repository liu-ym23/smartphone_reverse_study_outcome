package com.obric.autoaction.app.launcherpage.donation.model;

import com.bytedance.apm.battery.dao.DBHelper;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.io.Serializable;
import org.json.JSONObject;

/* JADX INFO: compiled from: Question.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class Question implements Serializable {

    @SerializedName(DbHelper.COL_ID)
    private final long id;

    @SerializedName("name")
    private final String name;

    @SerializedName(DBHelper.BATTERY_COL_PROCESS_NAME)
    private final String process;

    @SerializedName("require")
    private final String require;

    @SerializedName("reward")
    private String reward;

    public static /* synthetic */ Question copy$default(Question r7, long r8, String r10, String r11, String r12, String r13, int r14, Object r15) {
        if ((r14 & 1) == 0) goto L5;
        r8 = r7.id;
    L5:
        long r1 = r8;
        if ((r14 & 2) == 0) goto L8;
        r10 = r7.name;
    L8:
        String r3 = r10;
        if ((r14 & 4) == 0) goto L11;
        r11 = r7.reward;
    L11:
        String r4 = r11;
        if ((r14 & 8) == 0) goto L14;
        r12 = r7.process;
    L14:
        String r5 = r12;
        if ((r14 & 16) == 0) goto L18;
        r13 = r7.require;
    L18:
        return r7.copy(r1, r3, r4, r5, r13);
    }

    public final long component1() {
        return this.id;
    }

    public final String component2() {
        return this.name;
    }

    public final String component3() {
        return this.reward;
    }

    public final String component4() {
        return this.process;
    }

    public final String component5() {
        return this.require;
    }

    public final Question copy(long r8, String r10, String r11, String r12, String r13) {
        o.e(r10, "name");
        o.e(r12, DBHelper.BATTERY_COL_PROCESS_NAME);
        o.e(r13, "require");
        return new Question(r8, r10, r11, r12, r13);
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, Question.class) == true) goto L8;
        return false;
    L8:
        Question r10 = (Question) ZeusTransformUtils.preCheckCast(r9, Question.class, "com.obric.aiagent.plugin");
        if (this.id == r10.id) goto L12;
        return false;
    L12:
        if (o.a(this.name, r10.name) == true) goto L15;
        return false;
    L15:
        if (o.a(this.reward, r10.reward) == true) goto L18;
        return false;
    L18:
        if (o.a(this.process, r10.process) == true) goto L21;
        return false;
    L21:
        if (o.a(this.require, r10.require) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        int r0 = ((Long.hashCode(this.id) * 31) + this.name.hashCode()) * 31;
        String r1 = this.reward;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return ((((r0 + r2) * 31) + this.process.hashCode()) * 31) + this.require.hashCode();
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public String toString() {
        return "Question(id=" + this.id + ", name=" + this.name + ", reward=" + this.reward + ", process=" + this.process + ", require=" + this.require + ')';
    }

    public Question(long r2, String r4, String r5, String r6, String r7) {
        o.e(r4, "name");
        o.e(r6, DBHelper.BATTERY_COL_PROCESS_NAME);
        o.e(r7, "require");
        this.id = r2;
        this.name = r4;
        this.reward = r5;
        this.process = r6;
        this.require = r7;
    }

    public final long getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final String getReward() {
        return this.reward;
    }

    public final void setReward(String r1) {
        this.reward = r1;
    }

    public final String getProcess() {
        return this.process;
    }

    public final String getRequire() {
        return this.require;
    }

    public final JSONObject toJson() {
        JSONObject r0 = new JSONObject();
        r0.put(DbHelper.COL_ID, this.id);
        r0.put("name", this.name);
        r0.put(DBHelper.BATTERY_COL_PROCESS_NAME, this.process);
        r0.put("require", this.require);
        return r0;
    }
}
