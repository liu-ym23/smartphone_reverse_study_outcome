package com.bytedance.android.anniex.base.depend;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes43.dex */
public class ApplicationDepend {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f40279a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f40280b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f40281c;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0086\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003B\u0000¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/anniex/base/depend/ApplicationDepend$DomainParty;", "", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "anniex_release"}, k = 1, mv = {1, 4, 3})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface DomainParty {
        public static final a Companion = null;
        public static final int FIRST = 1;
        public static final int SECOND = 2;
        public static final int THIRD = 3;

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ a f40282a = null;

            static {
                f40282a = new a();
            }

            public a() {
            }
        }

        static {
            Companion = a.f40282a;
        }
    }

    public Boolean b() {
        return null;
    }

    public final int a() {
        return ((Number) this.f40280b.getValue()).intValue();
    }

    public ApplicationDepend() {
        this.f40280b = LazyKt.lazy(new ApplicationDepend$cachedThemeColor$2(this));
        this.f40281c = LazyKt.lazy(new ApplicationDepend$cachedTextColor$2(this));
    }
}
