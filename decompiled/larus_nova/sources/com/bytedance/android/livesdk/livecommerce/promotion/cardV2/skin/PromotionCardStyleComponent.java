package com.bytedance.android.livesdk.livecommerce.promotion.cardV2.skin;

import com.bytedance.android.livesdk.livecommerce.skin.model.ECLiveSkinBtnUIConfig;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0001\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\rR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/promotion/cardV2/skin/PromotionCardStyleComponent;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "Lkotlin/reflect/KClass;", "dataClass", "Lkotlin/reflect/KClass;", "getDataClass", "()Lkotlin/reflect/KClass;", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "BUTTON", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum PromotionCardStyleComponent extends Enum<PromotionCardStyleComponent> {
    public static final PromotionCardStyleComponent BUTTON = null;
    public static final a Companion = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PromotionCardStyleComponent[] f150711a = null;
    private final KClass<?> dataClass;
    private final String value;

    public static final class a {
        public a() {
        }
    }

    static {
        PromotionCardStyleComponent r100 = new PromotionCardStyleComponent(Reflection.getOrCreateKotlinClass(ECLiveSkinBtnUIConfig.class));
        BUTTON = r100;
        f150711a = new PromotionCardStyleComponent[]{r100};
        Companion = new a();
    }

    public static PromotionCardStyleComponent valueOf(String r100) {
        return (PromotionCardStyleComponent) r27.a.a(PromotionCardStyleComponent.class, r100);
    }

    public static PromotionCardStyleComponent[] values() {
        return (PromotionCardStyleComponent[]) f150711a.clone();
    }

    public final KClass<?> getDataClass() {
        return this.dataClass;
    }

    public final String getValue() {
        return this.value;
    }

    public PromotionCardStyleComponent(KClass r100) {
        super("BUTTON", 0);
        this.value = "button";
        this.dataClass = r100;
    }
}
