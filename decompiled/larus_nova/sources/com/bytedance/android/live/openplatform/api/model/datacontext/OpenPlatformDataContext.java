package com.bytedance.android.live.openplatform.api.model.datacontext;

import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.b;
import com.bytedance.live.datacontext.d;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\b&\u0018\u0000 \u00062\u00020\u0001:\u0001\u0007B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\b"}, d2 = {"Lcom/bytedance/android/live/openplatform/api/model/datacontext/OpenPlatformDataContext;", "Lcom/bytedance/live/datacontext/DataContext;", "", "share", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "liveopenplatform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class OpenPlatformDataContext extends DataContext {
    public static final a Companion = null;

    public static final class a {
        public a() {
        }

        @JvmStatic
        public static OpenPlatformDataContext a(Class r100) {
            Intrinsics.checkNotNullParameter(r100, "clazz");
            return (OpenPlatformDataContext) d.e(r100, r100);
        }
    }

    static {
        Companion = new a();
    }

    @JvmStatic
    public static final <T extends OpenPlatformDataContext> T getShared(Class<T> r100) {
        Companion.getClass();
        return (T) a.a(r100);
    }

    public final void share() {
        b.a(this, getClass());
    }

    public OpenPlatformDataContext() {
    }
}
