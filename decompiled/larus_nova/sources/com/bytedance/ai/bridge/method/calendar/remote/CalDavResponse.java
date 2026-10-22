package com.bytedance.ai.bridge.method.calendar.remote;

import com.larus.dora.api.model.FlowDoraWifiScene;
import evc.j;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import o3.v;
import okhttp3.HttpUrl;
import p3.i;

/* JADX INFO: loaded from: classes43.dex */
public final class CalDavResponse {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f35379h = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HttpUrl f35380a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HttpUrl f35381b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final j f35382c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<c> f35383d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<i> f35384e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final HttpUrl f35385f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f35386g;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ai/bridge/method/calendar/remote/CalDavResponse$HrefRelation;", "", "<init>", "(Ljava/lang/String;I)V", "SELF", "MEMBER", FlowDoraWifiScene.OTHER, "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum HrefRelation extends Enum<HrefRelation> {
        public static final HrefRelation MEMBER = null;
        public static final HrefRelation OTHER = null;
        public static final HrefRelation SELF = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ HrefRelation[] f35387a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f35388b = null;

        public static EnumEntries<HrefRelation> getEntries() {
            return f35388b;
        }

        static {
            HrefRelation r100 = new HrefRelation("SELF", 0);
            SELF = r100;
            HrefRelation r101 = new HrefRelation("MEMBER", 1);
            MEMBER = r101;
            HrefRelation r102 = new HrefRelation(FlowDoraWifiScene.OTHER, 2);
            OTHER = r102;
            HrefRelation[] r103 = {r100, r101, r102};
            f35387a = r103;
            f35388b = EnumEntriesKt.enumEntries(r103);
        }

        public static HrefRelation[] values() {
            return (HrefRelation[]) f35387a.clone();
        }

        public static HrefRelation valueOf(String r100) {
            return (HrefRelation) r27.a.a(HrefRelation.class, r100);
        }

        public HrefRelation(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CalDavResponse) == true) goto L8;
        return false;
    L8:
        CalDavResponse r101 = (CalDavResponse) r100;
        if (Intrinsics.areEqual(this.f35380a, r101.f35380a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f35381b, r101.f35381b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f35382c, r101.f35382c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f35383d, r101.f35383d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f35384e, r101.f35384e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f35385f, r101.f35385f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f35380a.hashCode() * 31) + this.f35381b.hashCode()) * 31;
        j r101 = this.f35382c;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (((r100 + r103) * 31) + this.f35383d.hashCode()) * 31;
        List<i> r105 = this.f35384e;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        HttpUrl r108 = this.f35385f;
        if (r108 == null) goto L15;
        r102 = r108.hashCode();
    L15:
        return r107 + r102;
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "CalDavResponse(requestedUrl=" + this.f35380a + ", href=" + this.f35381b + ", status=" + this.f35382c + ", propstat=" + this.f35383d + ", error=" + this.f35384e + ", newLocation=" + this.f35385f + ')';
    }

    public final boolean b() {
        j r100 = this.f35382c;
        if (r100 != null) goto L5;
    L8:
        return true;
    L5:
        if ((r100.f474522b / 100) == 2) goto L8;
        return false;
    }

    public final <T extends Property> T a(Class<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        return (T) CollectionsKt.firstOrNull(CollectionsKt.filterIsInstance((List) this.f35386g.getValue(), r100));
    }

    public CalDavResponse(HttpUrl r100, HttpUrl r101, j r102, List<c> r103, List<i> r104, HttpUrl r105) {
        Intrinsics.checkNotNullParameter(r100, "requestedUrl");
        Intrinsics.checkNotNullParameter(r101, "href");
        Intrinsics.checkNotNullParameter(r103, "propstat");
        this.f35380a = r100;
        this.f35381b = r101;
        this.f35382c = r102;
        this.f35383d = r103;
        this.f35384e = r104;
        this.f35385f = r105;
        this.f35386g = LazyKt.lazy(new v(this));
    }
}
