package com.bytedanceos.appstore.buss.cms.beta.entity.element;

import com.bytedanceos.appstore.buss.cms.beta.entity.BetaElementEntity;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0004B\u0005¢\u0006\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedanceos/appstore/buss/cms/beta/entity/element/BetaElementArrayEntity;", "Lcom/bytedanceos/appstore/buss/cms/beta/entity/BetaElementEntity;", "Lcom/bytedanceos/appstore/buss/cms/beta/entity/element/ElementArrayInfoEntity;", "()V", "Key", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class BetaElementArrayEntity extends BetaElementEntity<ElementArrayInfoEntity> {

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/bytedanceos/appstore/buss/cms/beta/entity/element/BetaElementArrayEntity$Key;", "", "()V", "BANNER_ARRAY", "", "NAVIGATION_ARRAY", "TITLE_ARRAY", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Key {

        @NotNull
        public static final String BANNER_ARRAY = "banner_array";

        @NotNull
        public static final Key INSTANCE = null;

        @NotNull
        public static final String NAVIGATION_ARRAY = "navigation_array";

        @NotNull
        public static final String TITLE_ARRAY = "title_array";

        static {
            INSTANCE = new Key();
        }

        private Key() {
        }
    }

    public BetaElementArrayEntity() {
    }
}
