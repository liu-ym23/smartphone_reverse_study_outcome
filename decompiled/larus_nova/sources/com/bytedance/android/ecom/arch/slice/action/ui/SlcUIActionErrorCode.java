package com.bytedance.android.ecom.arch.slice.action.ui;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Retention(RetentionPolicy.RUNTIME)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0086\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003B\u0000¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/ecom/arch/slice/action/ui/SlcUIActionErrorCode;", "", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "slice-render_release"}, k = 1, mv = {1, 4, 0})
public @interface SlcUIActionErrorCode {
    public static final a Companion = null;
    public static final int EMPTY_TYPE = 1;
    public static final int INVALID_PARAMS = 4;
    public static final int SLICE_KEY_NOT_FOUND = 2;
    public static final int SUCCESS = 0;
    public static final int UNSUPPORTED_TYPE = 3;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f49999a = null;

        public a() {
        }

        static {
            f49999a = new a();
        }
    }

    static {
        Companion = a.f49999a;
    }
}
