package com.obric.appstore.network.entity.template;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0004B\u0005¢\u0006\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/obric/appstore/network/entity/template/ElementArrayEntity;", "Lcom/obric/appstore/network/entity/template/ElementEntity;", "Lcom/obric/appstore/network/entity/template/ElementArrayInfoEntity;", "()V", "Key", "obriccommon_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ElementArrayEntity extends ElementEntity<ElementArrayInfoEntity> {

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/obric/appstore/network/entity/template/ElementArrayEntity$Key;", "", "()V", "APP_MATRIX", "", "NAVI_ARRAY", "TITLE_ARRAY", "obriccommon_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Key {

        @NotNull
        public static final String APP_MATRIX = "app_matrix";

        @NotNull
        public static final Key INSTANCE = null;

        @NotNull
        public static final String NAVI_ARRAY = "navi_array";

        @NotNull
        public static final String TITLE_ARRAY = "title_array";

        static {
            INSTANCE = new Key();
        }

        private Key() {
        }
    }

    public ElementArrayEntity() {
        super(null, 0, null, 7, null);
    }
}
