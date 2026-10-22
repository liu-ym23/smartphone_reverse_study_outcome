package com.bytedance.android.live.base.model.data.activityemoji;

import am3.g;
import com.google.gson.annotations.SerializedName;
import com.tencent.open.SocialConstants;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import py.k;
import vh7.f;
import vh7.h;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b(\u0010)R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR$\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R$\u0010\u001a\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u000b\u001a\u0004\b\u001b\u0010\r\"\u0004\b\u001c\u0010\u000fR*\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001d8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\"\u0010%\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b%\u0010\u0004\u001a\u0004\b&\u0010\u0006\"\u0004\b'\u0010\b¨\u0006*"}, d2 = {"Lcom/bytedance/android/live/base/model/data/activityemoji/ActivityEmojiGroup;", "", "", "id", "J", "getId", "()J", "setId", "(J)V", "", "idStr", "Ljava/lang/String;", "getIdStr", "()Ljava/lang/String;", "setIdStr", "(Ljava/lang/String;)V", "name", "getName", "setName", "Lpy/k;", "tagIcon", "Lpy/k;", "getTagIcon", "()Lpy/k;", "setTagIcon", "(Lpy/k;)V", SocialConstants.PARAM_APP_DESC, "getDesc", "setDesc", "", "Lcom/bytedance/android/live/base/model/data/activityemoji/b;", "activityEmojiList", "Ljava/util/List;", "getActivityEmojiList", "()Ljava/util/List;", "setActivityEmojiList", "(Ljava/util/List;)V", "insertEmojiNum", "getInsertEmojiNum", "setInsertEmojiNum", "<init>", "()V", "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ActivityEmojiGroup implements h {

    @SerializedName("emoji_list")
    protected List<b> activityEmojiList;

    @SerializedName(SocialConstants.PARAM_APP_DESC)
    protected String desc;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    protected long f58828id;

    @SerializedName("id_str")
    protected String idStr;

    @SerializedName("insert_emoji_num")
    protected long insertEmojiNum;

    @SerializedName("name")
    protected String name;

    @SerializedName("tag_icon")
    protected k tagIcon;

    public ActivityEmojiGroup() {
    }

    public final List<b> getActivityEmojiList() {
        return this.activityEmojiList;
    }

    public final String getDesc() {
        return this.desc;
    }

    public final long getId() {
        return this.f58828id;
    }

    public final String getIdStr() {
        return this.idStr;
    }

    public final long getInsertEmojiNum() {
        return this.insertEmojiNum;
    }

    public final String getName() {
        return this.name;
    }

    public final k getTagIcon() {
        return this.tagIcon;
    }

    /* JADX WARN: Type inference failed for: r2v5, types: [java.lang.Object, py.k] */
    public ActivityEmojiGroup(g r100) {
        this.activityEmojiList = new ArrayList();
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L14;
        switch(r102) {
            case 1: goto L13;
            case 2: goto L12;
            case 3: goto L11;
            case 4: goto L10;
            case 5: goto L9;
            case 6: goto L8;
            case 7: goto L7;
            default: goto L6;
        };
    L7:
        this.insertEmojiNum = r100.j();
        goto L3
    L8:
        this.activityEmojiList.add((b) f.a(r100, b.class));
        goto L3
    L9:
        this.desc = am3.h.c(r100);
        goto L3
    L10:
        this.tagIcon = f.a(r100, k.class);
        goto L3
    L11:
        this.name = am3.h.c(r100);
        goto L3
    L12:
        this.idStr = am3.h.c(r100);
        goto L3
    L13:
        this.f58828id = r100.j();
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L14:
        r100.d(r101);
    }

    public final void setActivityEmojiList(List<b> r100) {
        this.activityEmojiList = r100;
    }

    public final void setDesc(String r100) {
        this.desc = r100;
    }

    public final void setId(long r100) {
        this.f58828id = r100;
    }

    public final void setIdStr(String r100) {
        this.idStr = r100;
    }

    public final void setInsertEmojiNum(long r100) {
        this.insertEmojiNum = r100;
    }

    public final void setName(String r100) {
        this.name = r100;
    }

    public final void setTagIcon(k r100) {
        this.tagIcon = r100;
    }
}
