package com.stepos.ability.manager.discovery.ai_activity_widget;

import Ba.f;
import D7.v;
import H7.c;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import b4.C0825a;
import io.modelcontextprotocol.spec.McpSchema;
import j9.m;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.k;
import m9.AbstractC1683A;
import m9.AbstractC1691I;
import u9.d;

/* loaded from: classes3.dex */
public final class a {
    public static final List a(PackageManager packageManager) {
        Intent intentAddCategory = new Intent("com.stepos.ability.AI_ACTIVITY").addCategory("android.intent.category.DEFAULT");
        k.e(intentAddCategory, "addCategory(...)");
        List<ResolveInfo> listQueryIntentActivities = packageManager.queryIntentActivities(intentAddCategory, PackageManager.ResolveInfoFlags.of(128L));
        k.c(listQueryIntentActivities);
        return listQueryIntentActivities;
    }

    public static final C0825a b(ResolveInfo resolveInfo) {
        String string;
        ActivityInfo activityInfo = resolveInfo.activityInfo;
        if (activityInfo != null) {
            Bundle bundle = activityInfo.metaData;
            if (bundle == null || (((string = bundle.getString("stepos_ai_activity_description_key")) == null || string.length() == 0) && ((string = bundle.getString("zyql_ai_activity_description_key")) == null || string.length() <= 0))) {
                string = null;
            }
            if (string != null) {
                String str = activityInfo.packageName;
                String str2 = activityInfo.name;
                k.c(str);
                k.c(str2);
                McpSchema.Tool toolBuild = new McpSchema.Tool.Builder().name(B7.a.B(m.I0('.', str, str), "_open_", v.I0(m.E0(str2, new char[]{'$'}), "_", null, null, new f(28), 30))).description(string).inputSchema(new McpSchema.JsonSchema("object", kotlin.collections.a.M(), EmptyList.f4893a, Boolean.FALSE, null, null)).build();
                k.c(toolBuild);
                return new C0825a(toolBuild, kotlin.collections.a.R(new Pair("ZYQL_AI_ACTIVITY_WIDGET_TOOL_NAME", "open_app_by_package"), new Pair("ZYQL_AI_ACTIVITY_WIDGET_PKG", str), new Pair("ZYQL_AI_ACTIVITY_WIDGET_CLS", str2)), 15, "2");
            }
        }
        return null;
    }

    public static Object c(Context context, c cVar) {
        d dVar = AbstractC1691I.f5315a;
        return AbstractC1683A.w(u9.c.f6743a, new AiActivityScanner$getAvailableTools$2(context, null), cVar);
    }

    public static Object d(Context context, String str, c cVar) {
        d dVar = AbstractC1691I.f5315a;
        return AbstractC1683A.w(u9.c.f6743a, new AiActivityScanner$getAvailableTools$4(str, context, null), cVar);
    }
}
