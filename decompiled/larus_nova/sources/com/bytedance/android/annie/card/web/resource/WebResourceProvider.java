package com.bytedance.android.annie.card.web.resource;

import com.bytedance.android.annie.card.base.c;
import com.bytedance.android.annie.card.base.d;
import com.bytedance.android.annie.service.resource.g;
import com.bytedance.android.annie.service.resource.h;
import com.bytedance.android.annie.service.setting.AnnieConfigSettingKeys;
import com.bytedance.android.livesdkapi.depend.model.live.RoomIntroLabel;
import com.ss.android.lark.inv.export.router.InvRouter;
import com.ss.android.ugc.effectmanager.common.EffectConstants;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class WebResourceProvider implements d {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final boolean f39206f = false;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Lazy<Boolean> f39207g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final List<String> f39208h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Set<String> f39209i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Lazy<Collection<String>> f39210j = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g f39211a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f39212b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ConcurrentHashMap<String, h> f39213c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public c f39214d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f39215e;

    public static final class a {
    }

    static {
        f39206f = AnnieConfigSettingKeys.DISABLE_WEB_VIEW_RETRY_RESOURCE.a().booleanValue();
        f39207g = LazyKt.lazy(WebResourceProvider$Companion$forceUseForest$2.INSTANCE);
        f39208h = CollectionsKt.mutableListOf(new String[]{".js", ".html", ".css"});
        f39209i = SetsKt.setOf(new String[]{".js", ".html", ".css", InvRouter.FLOW_SUFFIX, ".ico", ".jpeg", ".webp", ".jpg", RoomIntroLabel.ICON_URL_SUFFIX_DEFAULT, EffectConstants.GIF_FILE_SUFFIX, ".wott", ".svg", ".ttf"});
        f39210j = LazyKt.lazy(WebResourceProvider$Companion$AVAILABLE_SUFFIX_ALLOW_LIST$2.INSTANCE);
    }

    @Override // com.bytedance.android.annie.card.base.d
    public final ConcurrentHashMap<String, h> a() {
        return this.f39213c;
    }

    public WebResourceProvider(g r100) {
        Intrinsics.checkNotNullParameter(r100, "config");
        this.f39211a = r100;
        this.f39213c = new ConcurrentHashMap();
    }
}
