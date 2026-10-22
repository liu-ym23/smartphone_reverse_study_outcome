package com.bytedance.android.ec.window.base.common.bubble;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;

/* JADX INFO: loaded from: classes44.dex */
public abstract class ECWindowBubbleStrategy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f49110a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f49111b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Integer f49112c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f49113d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f49114e;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003B\u0000¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/ec/window/base/common/bubble/ECWindowBubbleStrategy$ECDirection;", "", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface ECDirection {
        public static final int BOTTOM = 4;
        public static final a Companion = null;
        public static final int LEFT = 1;
        public static final int RIGHT = 3;
        public static final int TOP = 2;

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ a f49115a = null;

            public a() {
            }

            static {
                f49115a = new a();
            }
        }

        static {
            Companion = a.f49115a;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003B\u0000¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/ec/window/base/common/bubble/ECWindowBubbleStrategy$ECGravity;", "", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface ECGravity {
        public static final a Companion = null;
        public static final int DEFAULT = -1;
        public static final int END = 3;
        public static final int MIDDLE = 2;
        public static final int START = 1;

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ a f49116a = null;

            public a() {
            }

            static {
                f49116a = new a();
            }
        }

        static {
            Companion = a.f49116a;
        }
    }

    public ECWindowBubbleStrategy(int r100, int r101, Integer r102, int r103, int r104) {
        this.f49110a = r100;
        this.f49111b = r101;
        this.f49112c = r102;
        this.f49113d = r103;
        this.f49114e = r104;
    }
}
