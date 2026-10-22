package com.bytedance.android.ecom.arch.slice.render;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;

/* JADX INFO: loaded from: classes44.dex */
@Retention(RetentionPolicy.SOURCE)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003B\u0000¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/ecom/arch/slice/render/SlcFlexDirection;", "", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "slice-render_release"}, k = 1, mv = {1, 4, 0})
@kotlin.annotation.Retention(AnnotationRetention.SOURCE)
public @interface SlcFlexDirection {
    public static final a Companion = null;
    public static final String FLEX_COLUMN = "column";
    public static final String FLEX_COLUMN_REVERSE = "column-reverse";
    public static final String FLEX_ROW = "row";
    public static final String FLEX_ROW_REVERSE = "row-reverse";

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f50096a = null;

        public a() {
        }

        static {
            f50096a = new a();
        }
    }

    static {
        Companion = a.f50096a;
    }
}
