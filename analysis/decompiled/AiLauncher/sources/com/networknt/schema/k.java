package com.networknt.schema;

import com.networknt.schema.output.OutputUnitData;
import java.util.function.Function;

/* loaded from: classes2.dex */
public final /* synthetic */ class k implements Function {
    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        return OutputUnitData.formatError((Error) obj);
    }
}
