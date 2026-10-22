package com.bytedance.android.live.room.api.screenrotation.config;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.annotation.AnnotationRetention;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes47.dex */
@Retention(RetentionPolicy.SOURCE)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003B\u0000¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/room/api/screenrotation/config/FoldType;", "", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "experience-api_saasRelease"}, k = 1, mv = {1, 4, 3})
@kotlin.annotation.Retention(AnnotationRetention.SOURCE)
public @interface FoldType {
    public static final a Companion = null;
    public static final int back = 2;
    public static final int front = 1;
    public static final int full = 0;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Map<Integer, String> f99114a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ a f99115b = null;

        public a() {
        }

        static {
            f99115b = new a();
            f99114a = MapsKt.mapOf(new Pair[]{TuplesKt.to(0, "内屏"), TuplesKt.to(1, "外屏"), TuplesKt.to(2, "副屏")});
        }
    }

    static {
        Companion = a.f99115b;
    }
}
