package com.volcengine.tos.model.object;

import B7.a;
import androidx.compose.material3.internal.TextFieldImplKt;
import com.fasterxml.jackson.annotation.JsonProperty;

/* loaded from: classes3.dex */
public class ListedCommonPrefix {

    @JsonProperty(TextFieldImplKt.PrefixId)
    private String prefix;

    public String getPrefix() {
        return this.prefix;
    }

    public void setPrefix(String str) {
        this.prefix = str;
    }

    public String toString() {
        return a.q(new StringBuilder("ListedCommonPrefix{prefix='"), this.prefix, "'}");
    }
}
