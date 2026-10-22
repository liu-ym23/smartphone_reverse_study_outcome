package com.bytedance.android.format.model;

import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\tJ\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003JJ\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0005HÖ\u0001R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000bR\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0011\u0010\u000e¨\u0006 "}, d2 = {"Lcom/bytedance/android/format/model/SimpleSkillInfo;", "Ljava/io/Serializable;", "skillId", "", "skillName", "", GXTemplateKey.GAIAX_TEMPLATE_ID, "sendText", "iconUrl", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;)V", "getIconUrl", "()Ljava/lang/String;", "getSendText", "getSkillId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getSkillName", "getTemplateId", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;)Lcom/bytedance/android/format/model/SimpleSkillInfo;", "equals", "", "other", "", "hashCode", "", "toString", "format-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SimpleSkillInfo implements Serializable {

    @SerializedName("icon_url")
    private final String iconUrl;

    @SerializedName("send_text")
    private final String sendText;

    @SerializedName("skill_id")
    private final Long skillId;

    @SerializedName("skill_name")
    private final String skillName;

    @SerializedName(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_TEMPLATE_ID)
    private final Long templateId;

    public SimpleSkillInfo() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ SimpleSkillInfo copy$default(SimpleSkillInfo r100, Long r101, String r102, Long r103, String r104, String r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.skillId;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.skillName;
    L8:
        String r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.templateId;
    L11:
        Long r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.sendText;
    L14:
        String r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.iconUrl;
    L17:
        Long r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final Long component1() {
        return this.skillId;
    }

    public final String component2() {
        return this.skillName;
    }

    public final Long component3() {
        return this.templateId;
    }

    public final String component4() {
        return this.sendText;
    }

    public final String component5() {
        return this.iconUrl;
    }

    public final SimpleSkillInfo copy(Long r100, String r101, Long r110, String r111, String r112) {
        return new SimpleSkillInfo(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof SimpleSkillInfo) == false) goto L16;
        SimpleSkillInfo r101 = (SimpleSkillInfo) r100;
        if (Intrinsics.areEqual(this.skillId, r101.skillId) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.skillName, r101.skillName) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.templateId, r101.templateId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.sendText, r101.sendText) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.iconUrl, r101.iconUrl) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public int hashCode() {
        Long r100 = this.skillId;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.skillName;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Long r107 = this.templateId;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.sendText;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.iconUrl;
        if (r113 == null) goto L22;
        r101 = r113.hashCode();
    L22:
        return r112 + r101;
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "SimpleSkillInfo(skillId=" + this.skillId + ", skillName=" + this.skillName + ", templateId=" + this.templateId + ", sendText=" + this.sendText + ", iconUrl=" + this.iconUrl + ")";
    }

    public final String getIconUrl() {
        return this.iconUrl;
    }

    public final String getSendText() {
        return this.sendText;
    }

    public final Long getSkillId() {
        return this.skillId;
    }

    public final String getSkillName() {
        return this.skillName;
    }

    public final Long getTemplateId() {
        return this.templateId;
    }

    public SimpleSkillInfo(Long r100, String r101, Long r102, String r103, String r104) {
        this.skillId = r100;
        this.skillName = r101;
        this.templateId = r102;
        this.sendText = r103;
        this.iconUrl = r104;
    }

    public /* synthetic */ SimpleSkillInfo(Long r100, String r101, Long r102, String r103, String r104, int r110, DefaultConstructorMarker r111) {
        if ((r110 & 1) == 0) goto L5;
        Long r112 = null;
    L7:
        if ((r110 & 2) == 0) goto L9;
        String r105 = null;
    L11:
        if ((r110 & 4) == 0) goto L13;
        Long r106 = null;
    L15:
        if ((r110 & 8) == 0) goto L17;
        String r107 = null;
    L19:
        if ((r110 & 16) == 0) goto L21;
        String r113 = null;
    L22:
        this(r112, r105, r106, r107, r113);
        return;
    L21:
        r113 = r104;
        goto L22
    L17:
        r107 = r103;
        goto L19
    L13:
        r106 = r102;
        goto L15
    L9:
        r105 = r101;
        goto L11
    L5:
        r112 = r100;
        goto L7
    }
}
