package com.stepos.core.data;

import android.os.Parcel;
import com.stepos.core.data.base.Content;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class ListContent extends Content {
    public static final Companion Companion = new Companion(null);
    public static final int LIST_CONTENT_TYPE = -10;
    private final List<Pair<String, Content>> items;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ListContent(List<? extends Pair<String, ? extends Content>> items) {
        super(-10);
        g.f(items, "items");
        this.items = items;
    }

    @Override // com.stepos.core.data.base.Content, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final List<Pair<String, Content>> getItems() {
        return this.items;
    }

    @Override // com.stepos.core.data.base.Content, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        g.f(parcel, "parcel");
        throw new UnsupportedOperationException("ListContent is in-process only, cannot serialize to Parcel");
    }
}
