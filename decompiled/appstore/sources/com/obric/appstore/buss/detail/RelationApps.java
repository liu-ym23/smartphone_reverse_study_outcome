package com.obric.appstore.buss.detail;

import com.obric.appstore.network.entity.CommonAppEntity;
import com.obric.appstore.util.JsonUtilsKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.t;
import kotlin.collections.u;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class RelationApps {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Companion f10632e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f10633a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f10634b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f10635c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List f10636d;

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r10) {
            this();
        }

        public final RelationApps a(JSONObject r10) {
            q.g(r10, "jsonObject");
            String r11 = r10.optString("name");
            JSONObject r12 = r10.optJSONObject("category");
            String r13 = null;
            if (r12 == null) goto L5;
            JSONObject r14 = r12.optJSONObject("similar_recommend");
        L6:
            if (r14 == null) goto L8;
            JSONObject r15 = r14.optJSONObject("category");
        L9:
            if (r15 == null) goto L11;
            String r16 = r15.optString("id");
        L12:
            String r17 = "";
            if (r16 != null) goto L15;
            r16 = "";
        L15:
            if (r15 == null) goto L17;
            r13 = r15.optString("name");
        L17:
            if (r13 == null) goto L20;
            r17 = r13;
        L20:
            if (r14 == null) goto L25;
            JSONArray r18 = r14.optJSONArray("apps");
            if (r18 == null) goto L25;
            List r19 = JsonUtilsKt.c(r18, RelationApps$Companion$fromJson$apps$1.INSTANCE);
            if (r19 == null) goto L25;
        L26:
            q.d(r11);
            ArrayList r20 = new ArrayList(u.r(r19, 10));
            Iterator r21 = r19.iterator();
        L28:
            if (r21.hasNext() == false) goto L31;
            r20.add(((CommonAppEntity) r21.next()).convertAppInfo());
            goto L28
        L31:
            return new RelationApps(r11, r16, r17, r20);
        L25:
            r19 = t.i();
            goto L26
        L11:
            r16 = null;
            goto L12
        L8:
            r15 = null;
            goto L9
        L5:
            r14 = null;
            goto L6
        }

        public Companion() {
        }
    }

    static {
        f10632e = new Companion(null);
    }

    public RelationApps(String r10, String r11, String r12, List r13) {
        q.g(r10, "name");
        q.g(r11, "categoryId");
        q.g(r12, "categoryName");
        q.g(r13, "apps");
        this.f10633a = r10;
        this.f10634b = r11;
        this.f10635c = r12;
        this.f10636d = r13;
    }

    public final List a() {
        return this.f10636d;
    }

    public final String b() {
        return this.f10634b;
    }

    public final String c() {
        return this.f10635c;
    }

    public final String d() {
        return this.f10633a;
    }
}
