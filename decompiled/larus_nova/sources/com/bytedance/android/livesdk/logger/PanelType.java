package com.bytedance.android.livesdk.logger;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import kotlin.annotation.AnnotationTarget;

/* JADX INFO: loaded from: classes10.dex */
@Target({ElementType.PARAMETER, ElementType.TYPE_USE})
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003B\u0000¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/logger/PanelType;", "", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
@kotlin.annotation.Target(allowedTargets = {AnnotationTarget.VALUE_PARAMETER, AnnotationTarget.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface PanelType {
    public static final String APPLY_PANEL = "apply_panel";
    public static final a Companion = null;
    public static final String INVITE_PANEL = "invite_panel";
    public static final String ORDER_SONG_PANEL = "order_song_panel";

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f153461a = null;

        public a() {
        }

        static {
            f153461a = new a();
        }
    }

    static {
        Companion = a.f153461a;
    }
}
