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
public final class ClassicApps {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Companion f10628d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f10629a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f10630b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List f10631c;

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r10) {
            this();
        }

        public final ClassicApps a(JSONObject r10) {
            q.g(r10, "jsonObject");
            String r11 = r10.optString("name");
            JSONObject r12 = r10.optJSONObject("category");
            if (r12 == null) goto L5;
            String r13 = r12.optString("name");
        L6:
            if (r13 != null) goto L8;
            r13 = "";
        L8:
            if (r12 == null) goto L13;
            JSONArray r14 = r12.optJSONArray("apps");
            if (r14 == null) goto L13;
            List r15 = JsonUtilsKt.c(r14, ClassicApps$Companion$fromJson$apps$1.INSTANCE);
            if (r15 == null) goto L13;
        L14:
            q.d(r11);
            ArrayList r16 = new ArrayList(u.r(r15, 10));
            Iterator r17 = r15.iterator();
        L16:
            if (r17.hasNext() == false) goto L19;
            r16.add(((CommonAppEntity) r17.next()).convertAppInfo());
            goto L16
        L19:
            return new ClassicApps(r11, r13, r16);
        L13:
            r15 = t.i();
            goto L14
        L5:
            r13 = null;
            goto L6
        }

        public Companion() {
        }
    }

    static {
        f10628d = new Companion(null);
    }

    public ClassicApps(String r10, String r11, List r12) {
        q.g(r10, "name");
        q.g(r11, "categoryName");
        q.g(r12, "apps");
        this.f10629a = r10;
        this.f10630b = r11;
        this.f10631c = r12;
    }

    public final List a() {
        return this.f10631c;
    }

    public final String b() {
        return this.f10630b;
    }

    public final String c() {
        return this.f10629a;
    }
}
