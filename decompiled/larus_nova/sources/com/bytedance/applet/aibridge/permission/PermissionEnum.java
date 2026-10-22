package com.bytedance.applet.aibridge.permission;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes14.dex */
@Retention(RetentionPolicy.RUNTIME)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0086\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/bytedance/applet/aibridge/permission/PermissionEnum;", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public @interface PermissionEnum {
    public static final String BACKGROUND_LOCATION = "background_location";
    public static final String CALENDAR = "calendar";
    public static final a Companion = null;
    public static final String LOCATION = "location";
    public static final String NOTIFICATION = "notification";

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f191396a = null;

        static {
            f191396a = new a();
        }

        public a() {
        }
    }

    static {
        Companion = a.f191396a;
    }
}
