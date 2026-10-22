package com.volcengine.tos.model.object;

import B7.a;
import androidx.compose.material3.internal.TextFieldImplKt;
import com.fasterxml.jackson.annotation.JsonProperty;

@Deprecated
/* loaded from: classes3.dex */
public class UploadCommonPrefix {

    @JsonProperty(TextFieldImplKt.PrefixId)
    private String prefix;

    public String getPrefix() {
        return this.prefix;
    }

    public UploadCommonPrefix setPrefix(String str) {
        this.prefix = str;
        return this;
    }

    public String toString() {
        return a.q(new StringBuilder("UploadCommonPrefix{prefix='"), this.prefix, "'}");
    }
}
