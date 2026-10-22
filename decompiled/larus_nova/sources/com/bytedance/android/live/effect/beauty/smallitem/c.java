package com.bytedance.android.live.effect.beauty.smallitem;

import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate$Type;
import com.bytedance.android.live.effect.base.setting.LiveEffectSettings;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, String> f67662a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, String> f67663b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<String> f67664c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f67665d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final LiveEffectContextFactoryDelegate$Type f67666e;

    public static final class a {
    }

    static {
    }

    public final LiveEffectContextFactoryDelegate$Type getType() {
        return this.f67666e;
    }

    public c(LiveEffectContextFactoryDelegate$Type r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        this.f67666e = r100;
        this.f67662a = new LinkedHashMap();
        this.f67663b = new LinkedHashMap();
        new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        this.f67664c = new ArrayList();
        SettingKey<com.bytedance.android.live.effect.beauty.smallitem.a> r101 = LiveEffectSettings.LIVE_EFFECT_BEAUTY_PANEL_UPGRADE_CONFIG;
        r101.getValue().getClass();
        this.f67665d = r101.getValue().c();
        r101.getValue().getClass();
    }
}
