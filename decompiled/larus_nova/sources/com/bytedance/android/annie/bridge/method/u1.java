package com.bytedance.android.annie.bridge.method;

import android.util.Pair;
import com.bytedance.android.annie.bridge.method.abs.RequestResultModel;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: classes43.dex */
public final class u1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f38832a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List<? extends Pair<String, String>> f38833b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public byte[] f38834c;

    public static abstract class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final e7.s0 f38835a;

        public a(e7.s0 r100) {
            Intrinsics.checkNotNullParameter(r100, "params");
            this.f38835a = r100;
        }

        public final RequestResultModel a(u1 r100) {
            Intrinsics.checkNotNullParameter(r100, "<this>");
            RequestResultModel r101 = new RequestResultModel();
            r101.b(RequestResultModel.Code.Success);
            String r102 = this.f38835a.f();
            Intrinsics.checkNotNull(r102);
            byte[] r103 = r100.f38834c;
            if (Intrinsics.areEqual(r102, "json") == false) goto L5;
            JsonParser r104 = new JsonParser();
            Intrinsics.checkNotNull(r103);
            Object r105 = GsonProtectorUtils.parse(r104, new String(r103, Charsets.UTF_8)).getAsJsonObject();
        L6:
            r101.f(r105);
            r101.d(Integer.valueOf(r100.f38832a));
            r101.g(this.f38835a.f());
            List<? extends Pair<String, String>> r106 = r100.f38833b;
            if (r106 == null) goto L12;
            JsonObject r107 = new JsonObject();
            Iterator<T> r108 = r106.iterator();
        L10:
            if (r108.hasNext() == false) goto L13;
            Pair r109 = (Pair) r108.next();
            r107.addProperty((String) r109.first, (String) r109.second);
        L13:
            r101.c(r107);
            return r101;
        L12:
            r107 = null;
            goto L13
        L5:
            Intrinsics.checkNotNull(r103);
            r105 = new String(r103, Charsets.UTF_8);
            goto L6
        }
    }

    public static final class b extends a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final e7.s0 f38836b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final c f38837c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final CallContext f38838d;

        public static String b(JsonElement r100) {
            if (r100 != null) goto L16;
            return "";
        L16:
            Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L7
            Object r102 = Result.m9449constructorimpl(r100.getAsString());     // Catch: Throwable -> L7
        L10:
            if (Result.m9455isFailureimpl(r102) == false) goto L12;
            r102 = null;
        L12:
            String r103 = (String) r102;
            if (r103 == null) goto L15;
            return r103;
        L15:
            return com.bytedance.android.annie.api.data.subscribe.d.c(r100);
        L7:
            th = move-exception;
            Result.Companion r104 = Result.Companion;
            r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L10
        }

        public static List c(JsonObject r100) {
            if (r100 == null) goto L14;
            ArrayList r101 = new ArrayList();
            Iterator<T> r102 = r100.entrySet().iterator();
        L5:
            if (r102.hasNext() == false) goto L18;
            Map.Entry r103 = (Map.Entry) r102.next();
            Object r104 = r103.getKey();
            JsonElement r105 = (JsonElement) r103.getValue();
            if (r105 == null) goto L9;
            String r106 = r105.getAsString();
        L10:
            if (r106 != null) goto L12;
            r106 = "";
        L12:
            r101.add(new Pair(r104, r106));
            goto L5
        L9:
            r106 = null;
            goto L10
        L18:
            return r101;
        L14:
            return CollectionsKt.emptyList();
        }

        public b(e7.s0 r100, t1 r101, CallContext r102) {
            Intrinsics.checkNotNullParameter(r100, "params");
            Intrinsics.checkNotNullParameter(r101, "callback");
            Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
            super(r100);
            this.f38836b = r100;
            this.f38837c = r101;
            this.f38838d = r102;
        }
    }

    public interface c {
        void a(RequestResultModel r100);

        void onFail(Throwable r100);
    }

    public u1() {
    }
}
