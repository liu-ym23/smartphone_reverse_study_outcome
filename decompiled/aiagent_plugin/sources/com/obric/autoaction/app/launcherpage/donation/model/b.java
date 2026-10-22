package com.obric.autoaction.app.launcherpage.donation.model;

import com.bytedance.bdturing.localstorage.DbHelper;
import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: compiled from: QuestionSort.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName(DbHelper.COL_ID)
    private final String f23808a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SerializedName("sort")
    private final String f23809b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SerializedName("question")
    private final List<Question> f23810c;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
        return false;
    L8:
        b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
        if (o.a(this.f23808a, r6.f23808a) == true) goto L12;
        return false;
    L12:
        if (o.a(this.f23809b, r6.f23809b) == true) goto L15;
        return false;
    L15:
        if (o.a(this.f23810c, r6.f23810c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        String r0 = this.f23808a;
        if (r0 != null) goto L5;
        int r1 = 0;
    L7:
        return (((r1 * 31) + this.f23809b.hashCode()) * 31) + this.f23810c.hashCode();
    L5:
        r1 = r0.hashCode();
        goto L7
    }

    public String toString() {
        return "QuestionSort(id=" + this.f23808a + ", sort=" + this.f23809b + ", questionList=" + this.f23810c + ')';
    }

    public b(String r3, String r4, List<Question> r5) {
        List<Question> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        o.e(r4, "sort");
        o.e(r6, "questionList");
        this.f23808a = r3;
        this.f23809b = r4;
        this.f23810c = r6;
    }

    public final String a() {
        return this.f23809b;
    }

    public final List<Question> b() {
        return this.f23810c;
    }
}
