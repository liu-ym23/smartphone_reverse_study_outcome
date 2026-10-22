package com.bytedance.android.live.base.model.user;

import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes45.dex */
public class ProfileStyleTemplate {
    public static long TEMPLATE_ECOM = 1;
    public static long TEMPLATE_HONOUR = 0;
    public static long TEMPLATE_LOCAL_LIFE = 3;

    @SerializedName("template_description")
    String templateDescription;

    @SerializedName(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_TEMPLATE_ID)
    long templateId;

    @SerializedName("template_name")
    String templateName;

    @SerializedName("template_url")
    py.k templateUrl;

    public ProfileStyleTemplate() {
    }

    public String getTemplateDescription() {
        return this.templateDescription;
    }

    public long getTemplateId() {
        return this.templateId;
    }

    public String getTemplateName() {
        return this.templateName;
    }

    public py.k getTemplateUrl() {
        return this.templateUrl;
    }
}
