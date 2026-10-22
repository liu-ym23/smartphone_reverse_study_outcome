package com.stepos.aiengine.cta;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.stepos.policy.sdk.activity.PolicyHtmlViewerActivity;
import h0.e;
import kotlin.Pair;
import kotlin.collections.b;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class PolicyLocalDocActivity extends Activity {

    /* renamed from: a, reason: collision with root package name */
    public static final Object f5767a = b.g0(new Pair("personal", new a("file:////android_asset/personal.html", "个人信息收集清单")), new Pair("permission", new a("file:////android_asset/permission.html", "权限清单")));

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final String f5768a;

        /* renamed from: b, reason: collision with root package name */
        public final String f5769b;

        public a(String str, String str2) {
            this.f5768a = str;
            this.f5769b = str2;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return g.b(this.f5768a, aVar.f5768a) && g.b(this.f5769b, aVar.f5769b);
        }

        public final int hashCode() {
            return this.f5769b.hashCode() + (this.f5768a.hashCode() * 31);
        }

        public final String toString() {
            return e.c("LocalDoc(assetUri=", this.f5768a, ", title=", this.f5769b, ")");
        }
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [java.lang.Object, java.util.Map] */
    @Override // android.app.Activity
    public final void onCreate(Bundle bundle) {
        Uri data;
        super.onCreate(bundle);
        Intent intent = getIntent();
        String lastPathSegment = (intent == null || (data = intent.getData()) == null) ? null : data.getLastPathSegment();
        a aVar = lastPathSegment != null ? (a) f5767a.get(lastPathSegment) : null;
        if (aVar != null) {
            PolicyHtmlViewerActivity.Companion.start(this, aVar.f5768a, aVar.f5769b);
        }
        finish();
    }
}
