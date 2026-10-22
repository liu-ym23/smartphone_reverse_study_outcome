package com.bytedance.android.livesdk.interactivity.api.utils;

import com.larus.media.MediaScene;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class MessageStyleFormatter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f133767a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f133768b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f133769c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy f133770d = null;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/utils/MessageStyleFormatter$StyleType;", "", "CHAT", "GIFT", "INTERACT", MediaScene.SYSTEM, "DEFAULT", "ENTER", "RED_BOX", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum StyleType extends Enum<StyleType> {
        public static final StyleType CHAT = null;
        public static final StyleType DEFAULT = null;
        public static final StyleType ENTER = null;
        public static final StyleType GIFT = null;
        public static final StyleType INTERACT = null;
        public static final StyleType RED_BOX = null;
        public static final StyleType SYSTEM = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ StyleType[] f133771a = null;

        static {
            StyleType r100 = new StyleType("CHAT", 0);
            CHAT = r100;
            StyleType r101 = new StyleType("GIFT", 1);
            GIFT = r101;
            StyleType r102 = new StyleType("INTERACT", 2);
            INTERACT = r102;
            StyleType r103 = new StyleType(MediaScene.SYSTEM, 3);
            SYSTEM = r103;
            StyleType r104 = new StyleType("DEFAULT", 4);
            DEFAULT = r104;
            StyleType r105 = new StyleType("ENTER", 5);
            ENTER = r105;
            StyleType r106 = new StyleType("RED_BOX", 6);
            RED_BOX = r106;
            f133771a = new StyleType[]{r100, r101, r102, r103, r104, r105, r106};
        }

        public static StyleType valueOf(String r100) {
            return (StyleType) r27.a.a(StyleType.class, r100);
        }

        public static StyleType[] values() {
            return (StyleType[]) f133771a.clone();
        }

        public StyleType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final HashMap<StyleType, b> f133772a;

        public a() {
            throw null;
        }

        public a(HashMap r100) {
            Intrinsics.checkNotNullParameter(r100, "colorMap");
            this.f133772a = r100;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f133773a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f133774b;

        public b(int r100, int r101) {
            this.f133773a = r100;
            this.f133774b = r101;
        }
    }

    static {
        f133767a = LazyKt.lazy(MessageStyleFormatter$userWarmColorMap$2.INSTANCE);
        f133768b = LazyKt.lazy(MessageStyleFormatter$anchorWarmColorMap$2.INSTANCE);
        f133769c = LazyKt.lazy(MessageStyleFormatter$userExperiment2$2.INSTANCE);
        f133770d = LazyKt.lazy(MessageStyleFormatter$anchorExperiment3$2.INSTANCE);
    }

    @JvmStatic
    public static final b a(StyleType r100, boolean r101) {
        if (r101 == false) goto L4;
        a r102 = (a) f133770d.getValue();
    L5:
        HashMap<StyleType, b> r103 = r102.f133772a;
        b r104 = r103.get(r100);
        if (r104 != null) goto L9;
        b r105 = r103.get(StyleType.DEFAULT);
        Intrinsics.checkNotNull(r105);
        return r105;
    L9:
        return r104;
    L4:
        r102 = (a) f133769c.getValue();
        goto L5
    }
}
