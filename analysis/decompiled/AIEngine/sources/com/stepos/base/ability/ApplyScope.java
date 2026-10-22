package com.stepos.base.ability;

import com.stepos.core.common.telemetry.ModelCallFlywheelBizMapper;
import gc.q;
import java.util.Locale;
import kotlin.jvm.internal.g;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class ApplyScope {

    /* renamed from: a, reason: collision with root package name */
    public static final a f6188a;

    /* renamed from: b, reason: collision with root package name */
    public static final ApplyScope f6189b;

    /* renamed from: c, reason: collision with root package name */
    public static final ApplyScope f6190c;

    /* renamed from: d, reason: collision with root package name */
    public static final ApplyScope f6191d;

    /* renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ ApplyScope[] f6192e;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a {
        public static ApplyScope a(String str) {
            String lowerCase;
            String string;
            if (str == null || (string = q.L0(str).toString()) == null) {
                lowerCase = null;
            } else {
                lowerCase = string.toLowerCase(Locale.ROOT);
                g.e(lowerCase, "toLowerCase(...)");
            }
            return g.b(lowerCase, ModelCallFlywheelBizMapper.MODEL_PATH_CLOUD) ? ApplyScope.f6190c : g.b(lowerCase, "local") ? ApplyScope.f6191d : ApplyScope.f6189b;
        }
    }

    static {
        ApplyScope applyScope = new ApplyScope("ALL", 0);
        f6189b = applyScope;
        ApplyScope applyScope2 = new ApplyScope("CLOUD", 1);
        f6190c = applyScope2;
        ApplyScope applyScope3 = new ApplyScope("LOCAL", 2);
        f6191d = applyScope3;
        ApplyScope[] applyScopeArr = {applyScope, applyScope2, applyScope3};
        f6192e = applyScopeArr;
        kotlin.enums.a.a(applyScopeArr);
        f6188a = new a();
    }

    public ApplyScope() {
        throw null;
    }

    public static ApplyScope valueOf(String str) {
        return (ApplyScope) Enum.valueOf(ApplyScope.class, str);
    }

    public static ApplyScope[] values() {
        return (ApplyScope[]) f6192e.clone();
    }
}
