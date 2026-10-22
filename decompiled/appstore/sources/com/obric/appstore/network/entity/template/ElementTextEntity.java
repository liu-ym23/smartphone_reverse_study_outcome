package com.obric.appstore.network.entity.template;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0004B\u0005¢\u0006\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/obric/appstore/network/entity/template/ElementTextEntity;", "Lcom/obric/appstore/network/entity/template/ElementEntity;", "Lcom/obric/appstore/network/entity/template/ElementTextInfoEntity;", "()V", "Key", "obriccommon_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ElementTextEntity extends ElementEntity<ElementTextInfoEntity> {

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/obric/appstore/network/entity/template/ElementTextEntity$Key;", "", "()V", "CATEGORY_ID", "", "CATEGORY_NAME", "PICTURE", "TITLE", "obriccommon_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Key {

        @NotNull
        public static final String CATEGORY_ID = "category_id";

        @NotNull
        public static final String CATEGORY_NAME = "category_name";

        @NotNull
        public static final Key INSTANCE = null;

        @NotNull
        public static final String PICTURE = "picture";

        @NotNull
        public static final String TITLE = "title";

        static {
            INSTANCE = new Key();
        }

        private Key() {
        }
    }

    public ElementTextEntity() {
        super(null, 0, null, 7, null);
    }
}
