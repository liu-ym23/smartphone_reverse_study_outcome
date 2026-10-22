package com.bytedance.android.ec.hybrid.data.entity;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;

/* JADX INFO: loaded from: classes44.dex */
@Retention(RetentionPolicy.SOURCE)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003B\u0000¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/ec/hybrid/data/entity/ECHybridApiType;", "", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-hybrid_saasRelease"}, k = 1, mv = {1, 4, 3})
@kotlin.annotation.Retention(AnnotationRetention.SOURCE)
public @interface ECHybridApiType {
    public static final int CACHE = 1;
    public static final int CALLBACK = 0;
    public static final int CALLBACK_AND_CACHE = 2;
    public static final a Companion = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f46665a = null;

        public a() {
        }

        static {
            f46665a = new a();
        }
    }

    static {
        Companion = a.f46665a;
    }
}
