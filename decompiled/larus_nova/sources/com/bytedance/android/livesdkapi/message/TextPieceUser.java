package com.bytedance.android.livesdkapi.message;

import com.bytedance.android.live.base.model.m;
import com.bytedance.android.live.base.model.message.i5;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
public class TextPieceUser extends FlexModelBase<i5> implements i5 {

    @SerializedName("left_additional_content")
    String leftAdditionalContent;

    @SerializedName("right_additional_content")
    String rightAdditionalContent;

    @SerializedName("self_show_real_name")
    boolean selfShowRealName;

    @SerializedName("user")
    IBaseUser user;

    @SerializedName("with_colon")
    boolean withColon;

    public TextPieceUser() {
        super(i5.class);
    }

    public String toString() {
        return "TextPieceUser{user=" + this.user + ", withColon=" + this.withColon + '}';
    }

    @Override // com.bytedance.android.live.base.model.message.i5
    public String getLeftAdditionalContent() {
        return this.leftAdditionalContent;
    }

    @Override // com.bytedance.android.live.base.model.message.i5
    public String getPostfixString() {
        return this.rightAdditionalContent;
    }

    @Override // com.bytedance.android.live.base.model.message.i5
    public String getPrefixString() {
        return this.leftAdditionalContent;
    }

    @Override // com.bytedance.android.live.base.model.message.i5
    public String getRightAdditionalContent() {
        return this.rightAdditionalContent;
    }

    @Override // com.bytedance.android.live.base.model.message.i5
    public boolean getSelfShowRealName() {
        return this.selfShowRealName;
    }

    @Override // com.bytedance.android.live.base.model.message.i5
    public IBaseUser getUser() {
        return this.user;
    }

    @Override // com.bytedance.android.live.base.model.message.i5
    public boolean getWithColon() {
        return this.withColon;
    }

    @Override // com.bytedance.android.live.base.model.message.i5
    public boolean isWithColon() {
        return this.withColon;
    }

    @Override // com.bytedance.android.live.base.model.message.i5
    public boolean selfShowRealName() {
        return this.selfShowRealName;
    }

    @Override // com.bytedance.android.live.base.model.message.i5
    public void setUser(IBaseUser r100) {
        this.user = (IBaseUser) m.b(r100, IBaseUser.class);
    }

    @Override // com.bytedance.android.live.base.model.message.i5
    public void setWithColon(boolean r100) {
        this.withColon = r100;
    }
}
