package com.stepos.aiengine.client;

import com.amap.api.services.cloud.CloudSearch;
import com.stepos.aiengine.client.BaseModel;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003:\u0002\u0004\u0005\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/stepos/aiengine/client/ModelType;", "M", "Lcom/stepos/aiengine/client/BaseModel;", "", CloudSearch.SearchBound.LOCAL_SHAPE, "Remote", "Lcom/stepos/aiengine/client/ModelType$Local;", "Lcom/stepos/aiengine/client/ModelType$Remote;", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface ModelType<M extends BaseModel> {

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0013\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bHÖ\u0003J\t\u0010\t\u001a\u00020\nHÖ\u0001J\t\u0010\u000b\u001a\u00020\fHÖ\u0001¨\u0006\r"}, d2 = {"Lcom/stepos/aiengine/client/ModelType$Local;", "Lcom/stepos/aiengine/client/ModelType;", "Lcom/stepos/aiengine/client/LocalModel;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class Local implements ModelType<LocalModel> {
        public static final Local INSTANCE = new Local();

        public boolean equals(Object other) {
            return this == other || (other instanceof Local);
        }

        public int hashCode() {
            return 1165739568;
        }

        public String toString() {
            return CloudSearch.SearchBound.LOCAL_SHAPE;
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0013\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bHÖ\u0003J\t\u0010\t\u001a\u00020\nHÖ\u0001J\t\u0010\u000b\u001a\u00020\fHÖ\u0001¨\u0006\r"}, d2 = {"Lcom/stepos/aiengine/client/ModelType$Remote;", "Lcom/stepos/aiengine/client/ModelType;", "Lcom/stepos/aiengine/client/RemoteModel;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class Remote implements ModelType<RemoteModel> {
        public static final Remote INSTANCE = new Remote();

        public boolean equals(Object other) {
            return this == other || (other instanceof Remote);
        }

        public int hashCode() {
            return 1941039649;
        }

        public String toString() {
            return "Remote";
        }
    }
}
