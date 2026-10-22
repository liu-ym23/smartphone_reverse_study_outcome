package com.bytedance.android.shopping.mall.feed.ability;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.shopping.mall.feed.jsb.ECMallOpenSchemaJsb;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f176853c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f176854a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f176855b;

    /* JADX INFO: renamed from: com.bytedance.android.shopping.mall.feed.ability.a$a, reason: collision with other inner class name */
    public static final class C2619a {
    }

    static {
    }

    public a(String r100, FragmentActivity r101, ECMallOpenSchemaJsb r102) {
        Intrinsics.checkNotNullParameter(r100, "sceneID");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "openSchemaProxy");
        this.f176854a = r100;
        this.f176855b = r101;
    }
}
