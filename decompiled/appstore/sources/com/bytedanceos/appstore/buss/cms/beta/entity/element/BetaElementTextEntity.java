package com.bytedanceos.appstore.buss.cms.beta.entity.element;

import com.bytedanceos.appstore.buss.cms.beta.entity.BetaElementEntity;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0004B\u0005¢\u0006\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedanceos/appstore/buss/cms/beta/entity/element/BetaElementTextEntity;", "Lcom/bytedanceos/appstore/buss/cms/beta/entity/BetaElementEntity;", "Lcom/bytedanceos/appstore/buss/cms/beta/entity/element/ElementTextInfoEntity;", "()V", "Key", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class BetaElementTextEntity extends BetaElementEntity<ElementTextInfoEntity> {

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/bytedanceos/appstore/buss/cms/beta/entity/element/BetaElementTextEntity$Key;", "", "()V", "BUTTON_TEXT", "", "NAVIGATION_PAGE_ID", "NAVIGATION_TITLE", "PAGE_TITLE", "SHOW_BUTTON", "SHOW_SEARCH", "SUB_TITLE", "TITLE", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Key {

        @NotNull
        public static final String BUTTON_TEXT = "button_text";

        @NotNull
        public static final Key INSTANCE = null;

        @NotNull
        public static final String NAVIGATION_PAGE_ID = "navigation_page_id";

        @NotNull
        public static final String NAVIGATION_TITLE = "navigation_title";

        @NotNull
        public static final String PAGE_TITLE = "page_title";

        @NotNull
        public static final String SHOW_BUTTON = "show_button";

        @NotNull
        public static final String SHOW_SEARCH = "show_search";

        @NotNull
        public static final String SUB_TITLE = "sub_title";

        @NotNull
        public static final String TITLE = "title";

        static {
            INSTANCE = new Key();
        }

        private Key() {
        }
    }

    public BetaElementTextEntity() {
    }
}
