package com.bytedance.android.window.shop.home.tab.tabplugin;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import ti.j;

/* JADX INFO: loaded from: classes14.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f188941a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f188942b;

    public static final class a implements j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Function1<JSONObject, Unit> f188943a;

        /* JADX WARN: Multi-variable type inference failed */
        public a(Function1<? super JSONObject, Unit> r100) {
            Intrinsics.checkNotNullParameter(r100, "action");
            this.f188943a = r100;
        }

        @Override // ti.j
        public final void a(JSONObject r100) {
            Intrinsics.checkNotNullParameter(r100, "params");
            this.f188943a.invoke(r100);
        }
    }

    public c(String r100, Function1<? super JSONObject, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "actionName");
        Intrinsics.checkNotNullParameter(r101, "subscriber");
        this.f188942b = r100;
        this.f188941a = new a(r101);
    }
}
