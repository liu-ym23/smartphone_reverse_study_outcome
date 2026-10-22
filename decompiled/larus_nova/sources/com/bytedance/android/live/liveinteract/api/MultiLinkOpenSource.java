package com.bytedance.android.live.liveinteract.api;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;

/* JADX INFO: loaded from: classes46.dex */
@Retention(RetentionPolicy.SOURCE)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003B\u0000¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/liveinteract/api/MultiLinkOpenSource;", "", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "liveinteract-api_saasRelease"}, k = 1, mv = {1, 5, 1})
@kotlin.annotation.Retention(AnnotationRetention.SOURCE)
public @interface MultiLinkOpenSource {
    public static final String AUTO = "InitV2_auto";
    public static final String COMMON_BACKUP_WDIGET_UPLOAD = "common_backup_widget_unload";
    public static final a Companion = null;
    public static final String DEFAULT = "default";
    public static final String FAST_INIT_MODE = "fast_init_mode";
    public static final String INIT_V2 = "initV2";
    public static final String INNER_TOOLS = "initV2_innerTools";
    public static final String MESSAGE = "message";
    public static final String PK_SWITCH = "pk_switch";
    public static final String SYNC_ROOM = "syncRoom";

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f71427a = null;

        public a() {
        }

        static {
            f71427a = new a();
        }
    }

    static {
        Companion = a.f71427a;
    }
}
