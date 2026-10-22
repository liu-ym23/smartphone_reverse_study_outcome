package com.obric.aikernel.base.interfaces;

import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: compiled from: CallAIKernelFromPython.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0005H&J\u001a\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\tH&¨\u0006\f"}, d2 = {"Lcom/obric/aikernel/base/interfaces/CallAIKernelFromPython;", "", "onUpdateModelList", "", "models", "", "pushDebugPackage", "business", "runModel", "Lorg/json/JSONObject;", "modelInfo", "args", "BaseInterfaces_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface CallAIKernelFromPython {
    void onUpdateModelList(String r1);

    void pushDebugPackage(String r1);

    JSONObject runModel(String r1, JSONObject r2);
}
