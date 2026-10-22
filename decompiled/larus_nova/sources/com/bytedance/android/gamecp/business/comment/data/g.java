package com.bytedance.android.gamecp.business.comment.data;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@ProtoMessage("webcast.data.GradeInfo")
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u001e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/bytedance/android/gamecp/business/comment/data/g;", "", "", "avgGrade", "D", "versionGrade", "", "Lcom/bytedance/android/gamecp/business/comment/data/w;", "starGroups", "Ljava/util/List;", "<init>", "()V", "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class g implements vh7.h {

    @SerializedName("avg_grade")
    public double avgGrade;

    @SerializedName("star_groups")
    public List<w> starGroups;

    @SerializedName("version_grade")
    public double versionGrade;

    public g() {
        this.avgGrade = -1.0d;
        this.versionGrade = -1.0d;
    }

    public g(am3.g r100) {
        this.starGroups = new ArrayList();
        long r101 = r100.c();
        int r102 = 0;
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L14;
        if (r103 != 1) goto L7;
        this.avgGrade = Double.longBitsToDouble(r100.h());
        r102 = r102 | 1;
        goto L3
    L7:
        if (r103 != 2) goto L9;
        this.versionGrade = Double.longBitsToDouble(r100.h());
        r102 = r102 | 2;
        goto L3
    L9:
        if (r103 != 3) goto L10;
        this.starGroups.add(new w(r100));
        goto L3
    L10:
        am3.h.e(r100);
        goto L3
    L14:
        r100.d(r101);
        if ((r102 & 1) != 0) goto L18;
        this.avgGrade = -1.0d;
    L18:
        if ((r102 & 2) != 0) goto L33;
        this.versionGrade = -1.0d;
        return;
    }
}
