package com.bytedance.android.live.broadcast.api.model;

import com.bytedance.android.tools.pbadapter.annotation.IgnoreProtoDecode;
import com.bytedance.android.tools.pbadapter.annotation.IgnoreProtoFieldCheck;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@ProtoMessage("webcast.api.room.ListCategoryResponse.CategoryNode")
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\b\u0012\b\u0007\u0018\u0000 A2\u00020\u0001:\u0001BB\u0007¢\u0006\u0004\b?\u0010@R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0018\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u000bR$\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R*\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R$\u0010\u001a\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u0004\u001a\u0004\b\u001b\u0010\u0006\"\u0004\b\u001c\u0010\bR$\u0010\u001d\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u000b\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R$\u0010\"\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\"\u0010\u000b\u001a\u0004\b#\u0010\u001f\"\u0004\b$\u0010!R\"\u0010&\u001a\u00020%8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R$\u0010,\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b,\u0010\u000b\u001a\u0004\b-\u0010\u001f\"\u0004\b.\u0010!R\"\u0010/\u001a\u00020%8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b/\u0010'\u001a\u0004\b/\u0010)\"\u0004\b0\u0010+R*\u00102\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u0001018\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b2\u0010\u0015\u001a\u0004\b3\u0010\u0017\"\u0004\b4\u0010\u0019R\"\u00105\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\"\u0010;\u001a\u00020%8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b;\u0010'\u001a\u0004\b;\u0010)\"\u0004\b<\u0010+R\"\u0010=\u001a\u00020%8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b=\u0010'\u001a\u0004\b=\u0010)\"\u0004\b>\u0010+¨\u0006C"}, d2 = {"Lcom/bytedance/android/live/broadcast/api/model/CategoryNode;", "Ljava/io/Serializable;", "", "categoryId", "Ljava/lang/Long;", "getCategoryId", "()Ljava/lang/Long;", "setCategoryId", "(Ljava/lang/Long;)V", "", "title", "Ljava/lang/String;", "", "level", "Ljava/lang/Integer;", "getLevel", "()Ljava/lang/Integer;", "setLevel", "(Ljava/lang/Integer;)V", "", "subCategories", "Ljava/util/List;", "getSubCategories", "()Ljava/util/List;", "setSubCategories", "(Ljava/util/List;)V", "challengeId", "getChallengeId", "setChallengeId", "challengeName", "getChallengeName", "()Ljava/lang/String;", "setChallengeName", "(Ljava/lang/String;)V", "challengeIdStr", "getChallengeIdStr", "setChallengeIdStr", "", "canChoose", "Z", "getCanChoose", "()Z", "setCanChoose", "(Z)V", "unChooseMsg", "getUnChooseMsg", "setUnChooseMsg", "isRemoved", "setRemoved", "", "categoryAppAndroid", "getCategoryAppAndroid", "setCategoryAppAndroid", "orientation", "I", "getOrientation", "()I", "setOrientation", "(I)V", "isOtherCategory", "setOtherCategory", "isNewCategory", "setNewCategory", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livebroadcast-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CategoryNode implements Serializable, vh7.h {
    public static final a Companion = null;

    @SerializedName("can_choose")
    @Expose
    protected boolean canChoose;

    @SerializedName("category_app_android")
    @Expose
    protected List<String> categoryAppAndroid;

    @SerializedName("category_id")
    @Expose
    protected Long categoryId;

    @SerializedName("challenge_id")
    @Expose
    protected Long challengeId;

    @SerializedName("challenge_id_str")
    @Expose
    protected String challengeIdStr;

    @SerializedName("challenge_name")
    @Expose
    protected String challengeName;

    @IgnoreProtoDecode
    @Expose
    private boolean isNewCategory;

    @SerializedName("is_other_category")
    @Expose
    protected boolean isOtherCategory;

    @IgnoreProtoFieldCheck
    @SerializedName("is_removed")
    @Expose
    private boolean isRemoved;

    @SerializedName("level")
    @Expose
    protected Integer level;

    @SerializedName("orientation")
    @Expose
    protected int orientation;

    @SerializedName("sub_categorys")
    @Expose
    protected List<CategoryNode> subCategories;

    @SerializedName("title")
    @Expose
    public String title;

    @SerializedName("unchoose_msg")
    @Expose
    protected String unChooseMsg;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public CategoryNode() {
    }

    public final boolean getCanChoose() {
        return this.canChoose;
    }

    public final List<String> getCategoryAppAndroid() {
        return this.categoryAppAndroid;
    }

    public final Long getCategoryId() {
        return this.categoryId;
    }

    public final Long getChallengeId() {
        return this.challengeId;
    }

    public final String getChallengeIdStr() {
        return this.challengeIdStr;
    }

    public final String getChallengeName() {
        return this.challengeName;
    }

    public final Integer getLevel() {
        return this.level;
    }

    public final int getOrientation() {
        return this.orientation;
    }

    public final List<CategoryNode> getSubCategories() {
        return this.subCategories;
    }

    public final String getUnChooseMsg() {
        return this.unChooseMsg;
    }

    public final boolean isNewCategory() {
        return this.isNewCategory;
    }

    public final boolean isOtherCategory() {
        return this.isOtherCategory;
    }

    public final boolean isRemoved() {
        return this.isRemoved;
    }

    public CategoryNode(am3.g r100) {
        this.subCategories = new ArrayList();
        this.categoryAppAndroid = new ArrayList();
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L20;
        switch(r102) {
            case 1: goto L19;
            case 2: goto L18;
            case 3: goto L17;
            case 4: goto L15;
            case 5: goto L14;
            case 6: goto L13;
            case 7: goto L12;
            case 8: goto L11;
            case 9: goto L10;
            case 10: goto L6;
            case 11: goto L9;
            case 12: goto L8;
            case 13: goto L6;
            case 14: goto L6;
            case 15: goto L7;
            default: goto L6;
        };
    L7:
        this.isOtherCategory = am3.h.a(r100);
        goto L3
    L8:
        this.orientation = (int) r100.j();
        goto L3
    L9:
        List r103 = this.categoryAppAndroid;
        Object r104 = am3.h.c(r100);
    L16:
        r103.add(r104);
        goto L3
    L10:
        this.unChooseMsg = am3.h.c(r100);
        goto L3
    L11:
        this.canChoose = am3.h.a(r100);
        goto L3
    L12:
        this.challengeIdStr = am3.h.c(r100);
        goto L3
    L13:
        this.challengeName = am3.h.c(r100);
        goto L3
    L14:
        this.challengeId = Long.valueOf(r100.j());
        goto L3
    L15:
        r103 = this.subCategories;
        r104 = new CategoryNode(r100);
        goto L16
    L17:
        this.level = Integer.valueOf(r100.i());
        goto L3
    L18:
        this.title = am3.h.c(r100);
        goto L3
    L19:
        this.categoryId = Long.valueOf(r100.j());
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L20:
        r100.d(r101);
    }

    public final void setCanChoose(boolean r100) {
        this.canChoose = r100;
    }

    public final void setCategoryAppAndroid(List<String> r100) {
        this.categoryAppAndroid = r100;
    }

    public final void setCategoryId(Long r100) {
        this.categoryId = r100;
    }

    public final void setChallengeId(Long r100) {
        this.challengeId = r100;
    }

    public final void setChallengeIdStr(String r100) {
        this.challengeIdStr = r100;
    }

    public final void setChallengeName(String r100) {
        this.challengeName = r100;
    }

    public final void setLevel(Integer r100) {
        this.level = r100;
    }

    public final void setNewCategory(boolean r100) {
        this.isNewCategory = r100;
    }

    public final void setOrientation(int r100) {
        this.orientation = r100;
    }

    public final void setOtherCategory(boolean r100) {
        this.isOtherCategory = r100;
    }

    public final void setRemoved(boolean r100) {
        this.isRemoved = r100;
    }

    public final void setSubCategories(List<CategoryNode> r100) {
        this.subCategories = r100;
    }

    public final void setUnChooseMsg(String r100) {
        this.unChooseMsg = r100;
    }
}
