package com.bytedanceos.appstore.buss.entity;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/bytedanceos/appstore/buss/entity/ApiType;", "", "()V", ApiType.appManagerMyApps, "", ApiType.appManagerUpdate, ApiType.appManagerWish, "category", ApiType.categorySingle, ApiType.gameSubscribe, ApiType.gift, ApiType.pageApps, "recommend", ApiType.setting, ApiType.systemApps, ApiType.topList, "topic", ApiType.web, "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ApiType {

    @NotNull
    public static final ApiType INSTANCE = null;

    @NotNull
    public static final String appManagerMyApps = "appManagerMyApps";

    @NotNull
    public static final String appManagerUpdate = "appManagerUpdate";

    @NotNull
    public static final String appManagerWish = "appManagerWish";

    @NotNull
    public static final String category = "category";

    @NotNull
    public static final String categorySingle = "categorySingle";

    @NotNull
    public static final String gameSubscribe = "gameSubscribe";

    @NotNull
    public static final String gift = "gift";

    @NotNull
    public static final String pageApps = "pageApps";

    @NotNull
    public static final String recommend = "recommend";

    @NotNull
    public static final String setting = "setting";

    @NotNull
    public static final String systemApps = "systemApps";

    @NotNull
    public static final String topList = "topList";

    @NotNull
    public static final String topic = "topic";

    @NotNull
    public static final String web = "web";

    static {
        INSTANCE = new ApiType();
    }

    private ApiType() {
    }
}
