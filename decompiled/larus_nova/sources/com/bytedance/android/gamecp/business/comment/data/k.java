package com.bytedance.android.gamecp.business.comment.data;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@ProtoMessage("webcast.data.CommentDetail")
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001:\u0001\nB\u0007¢\u0006\u0004\b\b\u0010\tR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u001e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/gamecp/business/comment/data/k;", "", "Lcom/bytedance/android/gamecp/business/comment/data/s;", "replyInfo", "Lcom/bytedance/android/gamecp/business/comment/data/s;", "", "childReplyList", "Ljava/util/List;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class k implements vh7.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f52043a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b f52044b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f52045c;

    @SerializedName("out_side_comment_info")
    public List<s> childReplyList;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f52046d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f52047e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f52048f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f52049g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f52050h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f52051i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f52052j;

    @SerializedName("comment_info")
    public s replyInfo;

    public static final class a {
    }

    static {
    }

    public k() {
        this.f52043a = 1;
    }

    public k(am3.g r100) {
        this.childReplyList = new ArrayList();
        this.f52043a = 1;
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L11;
        if (r102 != 1) goto L7;
        this.replyInfo = new s(r100);
        goto L3
    L7:
        if (r102 != 2) goto L8;
        this.childReplyList.add(new s(r100));
        goto L3
    L8:
        am3.h.e(r100);
        goto L3
    L11:
        r100.d(r101);
    }
}
