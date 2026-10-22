package com.bytedance.android.live.schema.api;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes47.dex */
public interface e {

    public static final class a implements e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int f100499a = 0;

        @Override // com.bytedance.android.live.schema.api.e
        public final void a(String r100, JSONObject r101, JSONObject r102, JSONObject r103, JSONObject r104) {
            Intrinsics.checkNotNullParameter(r100, "eventName");
            Intrinsics.checkNotNullParameter(r101, "category");
            Intrinsics.checkNotNullParameter(r102, "metric");
            Intrinsics.checkNotNullParameter(r103, "extra");
            Intrinsics.checkNotNullParameter(r104, "common");
        }

        static {
        }
    }

    void a(String r100, JSONObject r101, JSONObject r102, JSONObject r103, JSONObject r104);
}
