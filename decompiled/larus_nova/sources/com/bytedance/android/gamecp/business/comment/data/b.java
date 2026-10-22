package com.bytedance.android.gamecp.business.comment.data;

import com.bytedance.android.gamecp.host_api.model.user.User;
import com.bytedance.android.tools.pbadapter.annotation.IgnoreProtoFieldCheck;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@ProtoMessage("webcast.data.EvaluationDetail")
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0017\u0018\u00002\u00020\u0001:\u0001\u0014B\u0007¢\u0006\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0018\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u001e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u000f¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/gamecp/business/comment/data/b;", "", "Lcom/bytedance/android/gamecp/host_api/model/user/User;", "gameUser", "Lcom/bytedance/android/gamecp/host_api/model/user/User;", "mUser", "Lcom/bytedance/android/gamecp/business/comment/data/o;", "evaluationInfo", "Lcom/bytedance/android/gamecp/business/comment/data/o;", "Lcom/bytedance/android/gamecp/business/comment/data/m;", "userExtra", "Lcom/bytedance/android/gamecp/business/comment/data/m;", "", "Lcom/bytedance/android/gamecp/business/comment/data/s;", "outsideReplyInfo", "Ljava/util/List;", "Lcom/bytedance/android/gamecp/business/comment/data/h;", "commentHighlightIndex", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public class b implements vh7.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f52035a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Long f52036b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f52037c;

    @SerializedName("highlight_index_list")
    public List<h> commentHighlightIndex;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public g f52038d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public List<j> f52039e;

    @SerializedName("evaluation_info")
    public o evaluationInfo;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f52040f;

    @IgnoreProtoFieldCheck
    @SerializedName("game_user")
    protected User gameUser;

    @IgnoreProtoFieldCheck
    @SerializedName("user")
    protected User mUser;

    @SerializedName("outside_comment_info")
    public List<s> outsideReplyInfo;

    @SerializedName("user_extra")
    public m userExtra;

    public static final class a {
    }

    static {
    }

    public final User a() {
        User r100 = this.gameUser;
        if (r100 == null) goto L5;
        return r100;
    L5:
        return this.mUser;
    }

    public b() {
        this.f52035a = 2;
        this.f52036b = 0L;
        this.f52037c = true;
        this.f52039e = new ArrayList();
        this.commentHighlightIndex = new ArrayList();
    }

    public b(am3.g r100) {
        this.outsideReplyInfo = new ArrayList();
        this.commentHighlightIndex = new ArrayList();
        this.f52035a = 2;
        this.f52036b = 0L;
        this.f52037c = true;
        this.f52039e = new ArrayList();
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L14;
        switch(r102) {
            case 1: goto L13;
            case 2: goto L12;
            case 3: goto L11;
            case 4: goto L9;
            case 5: goto L8;
            case 6: goto L7;
            default: goto L6;
        };
    L7:
        this.gameUser = new User(r100);
        goto L3
    L8:
        List r103 = this.commentHighlightIndex;
        vh7.h r104 = new h(r100);
    L10:
        r103.add(r104);
        goto L3
    L9:
        r103 = this.outsideReplyInfo;
        r104 = new s(r100);
        goto L10
    L11:
        this.userExtra = new m(r100);
        goto L3
    L12:
        this.evaluationInfo = new o(r100);
        goto L3
    L13:
        this.mUser = new User(r100);
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L14:
        r100.d(r101);
        if (this.commentHighlightIndex.isEmpty() == false) goto L33;
        this.commentHighlightIndex = new ArrayList();
        return;
    }

    public final void b(User r100) {
        this.gameUser = r100;
        this.mUser = r100;
    }
}
