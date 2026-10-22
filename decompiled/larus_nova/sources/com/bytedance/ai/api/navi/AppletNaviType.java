package com.bytedance.ai.api.navi;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;

/* JADX INFO: loaded from: classes43.dex */
@Retention(RetentionPolicy.SOURCE)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/bytedance/ai/api/navi/AppletNaviType;", "", "Companion", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@kotlin.annotation.Retention(AnnotationRetention.SOURCE)
public @interface AppletNaviType {
    public static final a Companion = null;
    public static final String DRIVING = "driving";
    public static final String POI = "poi";
    public static final String RIDING = "riding";
    public static final String TRANSIT = "transit";
    public static final String WALKING = "walking";

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f34052a = null;

        static {
            f34052a = new a();
        }

        public a() {
        }
    }

    static {
        Companion = a.f34052a;
    }
}
