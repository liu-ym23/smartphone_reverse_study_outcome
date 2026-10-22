package com.bytedance.android.shopping.utils;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.bytedance.android.ec.core.anchorv3.PdpPerfOpt;
import com.bytedance.android.shopping.anchorv3.ExceptionFixer;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
public final class b {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f187047e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public JSONObject f187048a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final JSONArray f187049b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final JSONArray f187050c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final JSONArray f187051d;

    public static final class a {
        public a() {
        }

        public static void a(String r100) {
            int r101 = b.f187047e;
            Intrinsics.checkNotNullParameter(r100, "message");
            if (PdpPerfOpt.e() == true) goto L7;
            xh.a r102 = xh.c.a("Detail");
            xh.b r103 = new xh.b();
            r103.c("AnchorV4CrashHelper");
            r103.b("Default");
            r103.a(r100);
            r102.f(4, r103);
            return;
        }
    }

    static {
        new a();
    }

    public final String toString() {
        JSONObject r100 = new JSONObject();
        r100.put("TAG", "AnchorV4CrashHelper");
        r100.put("recyclerViewInfo", this.f187048a);
        JSONObject r101 = new JSONObject();
        r101.put("cvoRecords", this.f187049b);
        r101.put("requestRecords", this.f187050c);
        r101.put("gulRecords", this.f187051d);
        Unit r102 = Unit.INSTANCE;
        r100.put("pdpInfo", r101);
        return r100.toString();
    }

    public b() {
        this.f187048a = new JSONObject();
        this.f187049b = new JSONArray();
        this.f187050c = new JSONArray();
        this.f187051d = new JSONArray();
    }

    public final void a(RecyclerView r110, StaggeredGridLayoutManager r210) {
        Intrinsics.checkNotNullParameter(r110, "recyclerView");
        Intrinsics.checkNotNullParameter(r210, "layoutManager");
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L18
        this.f187048a = new JSONObject();     // Catch: Throwable -> L18
        Object r101 = ExceptionFixer.b(r210, "mLazySpanLookup", ExceptionFixer.f164390a, null);     // Catch: Throwable -> L18
        Object r102 = ExceptionFixer.b(r101, "mData", ExceptionFixer.f164391b, null);     // Catch: Throwable -> L18
        Object r103 = ExceptionFixer.b(r101, "mFullSpanItems", ExceptionFixer.f164392c, null);     // Catch: Throwable -> L18
        if ((r102 instanceof int[]) == false) goto L7;
        this.f187048a.put("mLazySpanLookup.mData.size", ((int[]) r102).length);     // Catch: Throwable -> L18
    L7:
        if ((r103 instanceof List) == true) goto L9;
        r103 = null;
    L9:
        List r104 = (List) r103;     // Catch: Throwable -> L18
        if (r104 == null) goto L16;
        JSONArray r105 = new JSONArray();     // Catch: Throwable -> L18
        Iterator r106 = r104.iterator();     // Catch: Throwable -> L18
    L13:
        if (r106.hasNext() == false) goto L15;
        r105.put(ExceptionFixer.b(r106.next(), "mPosition", ExceptionFixer.f164393d, null));     // Catch: Throwable -> L18
        goto L13
    L15:
        this.f187048a.put("mLazySpanLookup.mFullSpanItems", r105);     // Catch: Throwable -> L18
    L16:
        JSONObject r107 = this.f187048a;     // Catch: Throwable -> L18
        JSONObject r108 = new JSONObject();     // Catch: Throwable -> L18
        r108.put("childCount", r110.getChildCount());     // Catch: Throwable -> L18
        int[] r109 = new int[r210.getSpanCount()];     // Catch: Throwable -> L18
        Arrays.fill(r109, -1);     // Catch: Throwable -> L18
        r210.findFirstVisibleItemPositions(r109);     // Catch: Throwable -> L18
        r108.put("firstVisiblePosition", CollectionsKt.joinToString$default(ArraysKt.toList(r109), null, null, null, 0, null, null, 63, null));     // Catch: Throwable -> L18
        Arrays.fill(r109, -1);     // Catch: Throwable -> L18
        r210.findLastVisibleItemPositions(r109);     // Catch: Throwable -> L18
        r108.put("lastVisiblePosition", CollectionsKt.joinToString$default(ArraysKt.toList(r109), null, null, null, 0, null, null, 63, null));     // Catch: Throwable -> L18
        Unit r111 = Unit.INSTANCE;     // Catch: Throwable -> L18
        Result.m9449constructorimpl(r107.put("recyclerView", r108));     // Catch: Throwable -> L18
        return;
    L18:
        th = move-exception;
        Result.Companion r112 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }
}
