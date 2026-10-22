package com.obric.aiagent.executionengine.capabilitymanager.api.matcher;

import com.google.gson.JsonObject;
import com.obric.aiagent.executionengine.capabilitymanager.api.appfunction.c;
import com.obric.capabilitykit.common.AppAction;
import d.c.d;
import java.util.List;

/* JADX INFO: compiled from: IActionMatcherApi.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface IActionMatcherApi {
    Object getAppFunctionSkills(d<? super List<c>> r1);

    Object queryExecutableAppAction(JsonObject r1, d<? super AppAction> r2);

    Object queryExecutableIntent(JsonObject r1, d<? super a> r2);
}
