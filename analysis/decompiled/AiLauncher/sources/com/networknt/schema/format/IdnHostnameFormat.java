package com.networknt.schema.format;

import com.networknt.schema.ExecutionContext;
import com.networknt.schema.utils.RFC5892;

/* loaded from: classes2.dex */
public class IdnHostnameFormat implements Format {
    @Override // com.networknt.schema.format.Format
    public String getMessageKey() {
        return "format.idn-hostname";
    }

    @Override // com.networknt.schema.format.Format
    public String getName() {
        return "idn-hostname";
    }

    @Override // com.networknt.schema.format.Format
    public boolean matches(ExecutionContext executionContext, String str) {
        if (str == null) {
            return true;
        }
        return RFC5892.isValid(str);
    }
}
