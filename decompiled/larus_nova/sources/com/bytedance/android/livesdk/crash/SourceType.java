package com.bytedance.android.livesdk.crash;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;

/* JADX INFO: loaded from: classes8.dex */
@Retention(RetentionPolicy.SOURCE)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003B\u0000¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/crash/SourceType;", "", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
@kotlin.annotation.Retention(AnnotationRetention.SOURCE)
public @interface SourceType {
    public static final String ANCHOR = "anchor";
    public static final a Companion = null;
    public static final String DEFAULT = "audience";
    public static final String REPLAY = "REPLAY";
    public static final String VS_PLAY = "vs_play";
    public static final String VS_SHOW = "vs_show";
    public static final String VS_VIDEO = "vs_video";

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f121926a = null;

        public a() {
        }

        static {
            f121926a = new a();
        }
    }

    static {
        Companion = a.f121926a;
    }
}
