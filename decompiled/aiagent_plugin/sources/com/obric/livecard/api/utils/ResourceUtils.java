package com.obric.livecard.api.utils;

import android.content.Context;
import android.net.Uri;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: compiled from: ResourceUtils.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class ResourceUtils {
    public static final ResourceUtils INSTANCE = null;

    /* JADX INFO: compiled from: ResourceUtils.kt */
    @Target({ElementType.TYPE_USE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface ResourceType {
        public static final String ALPHA_VIDEO = "alpha-video";
        public static final String APP_DRAWABLE = "drawable";
        public static final String APP_ICON = "app_icon";
        public static final Companion Companion = null;
        public static final String LOTTIE = "lottie";
        public static final String STRING = "stringId";
        public static final String SVG = "svg";

        /* JADX INFO: compiled from: ResourceUtils.kt */
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = null;
            public static final String ALPHA_VIDEO = "alpha-video";
            public static final String APP_DRAWABLE = "drawable";
            public static final String APP_ICON = "app_icon";
            public static final String LOTTIE = "lottie";
            public static final String STRING = "stringId";
            public static final String SVG = "svg";

            static {
                $$INSTANCE = new Companion();
            }

            private Companion() {
            }
        }

        static {
            Companion = Companion.$$INSTANCE;
        }
    }

    static {
        INSTANCE = new ResourceUtils();
    }

    private ResourceUtils() {
    }

    public final String getString(int r2) {
        return "stringId://" + r2;
    }

    public final String getDrawable(Context r2, int r3) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        o.e(r1, "context");
        String r4 = new Uri.Builder().scheme("content").authority("com.island.local.file").appendQueryParameter(DbHelper.COL_ID, String.valueOf(r3)).appendQueryParameter("pkg", r1.getPackageName()).appendQueryParameter("type", "drawable").build().toString();
        o.c(r4, "Builder().scheme(\"conten…      .build().toString()");
        return r4;
    }

    public final String getApplicationIcon(String r2) {
        o.e(r2, "packageName");
        String r1 = new Uri.Builder().scheme("content").authority("com.island.local.file").appendQueryParameter("pkg", r2).appendQueryParameter("type", "app_icon").build().toString();
        o.c(r1, "Builder().scheme(\"conten…      .build().toString()");
        return r1;
    }

    public final String getAssetsFile(Context r4, String r5, String r6) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        o.e(r3, "context");
        o.e(r5, "fileName");
        o.e(r6, "type");
        String r7 = new Uri.Builder().scheme("content").authority("com.island.local.file").appendQueryParameter("fileName", r5).appendQueryParameter("pkg", r3.getPackageName()).appendQueryParameter("type", r6).build().toString();
        o.c(r7, "Builder().scheme(\"conten…      .build().toString()");
        return r7;
    }
}
