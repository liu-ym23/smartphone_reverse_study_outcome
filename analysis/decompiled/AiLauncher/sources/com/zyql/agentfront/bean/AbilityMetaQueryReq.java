package com.zyql.agentfront.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardProvider;
import io.ktor.http.ContentDisposition;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u0000 &2\u00020\u0001:\u0001'B+\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0007\u0010\bB\u0011\b\u0016\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0007\u0010\u000bJ\u001f\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0018\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0014J:\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u0014J\u0010\u0010\u001b\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\u001b\u0010\u0012J\u001a\u0010\u001f\u001a\u00020\u001e2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cHÖ\u0003¢\u0006\u0004\b\u001f\u0010 R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010!\u001a\u0004\b\"\u0010\u0014R\u001f\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010#\u001a\u0004\b$\u0010\u0016R\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010!\u001a\u0004\b%\u0010\u0014¨\u0006("}, d2 = {"Lcom/zyql/agentfront/bean/AbilityMetaQueryReq;", "Landroid/os/Parcelable;", "", "query", "", "categories", DidiCardProvider.KEY_TRACE_ID, "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "Landroid/os/Parcel;", "parcel", "(Landroid/os/Parcel;)V", "", "flags", "LY8/t;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "component1", "()Ljava/lang/String;", "component2", "()Ljava/util/List;", "component3", ChatTracker.CLICK_COPY, "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)Lcom/zyql/agentfront/bean/AbilityMetaQueryReq;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getQuery", "Ljava/util/List;", "getCategories", "getTraceId", "CREATOR", Const.INTENT_KEY_APIKEY, "bean_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class AbilityMetaQueryReq implements Parcelable {

    /* renamed from: CREATOR, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final List<String> categories;
    private final String query;
    private final String traceId;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/zyql/agentfront/bean/AbilityMetaQueryReq$a;", "Landroid/os/Parcelable$Creator;", "Lcom/zyql/agentfront/bean/AbilityMetaQueryReq;", "<init>", "()V", "Landroid/os/Parcel;", "parcel", Const.INTENT_KEY_APIKEY, "(Landroid/os/Parcel;)Lcom/zyql/agentfront/bean/AbilityMetaQueryReq;", "", ContentDisposition.Parameters.Size, "", Const.INTENT_KEY_PKGNAME, "(I)[Lcom/zyql/agentfront/bean/AbilityMetaQueryReq;", "bean_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.zyql.agentfront.bean.AbilityMetaQueryReq$a, reason: from kotlin metadata */
    public static final class Companion implements Parcelable.Creator<AbilityMetaQueryReq> {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public AbilityMetaQueryReq createFromParcel(Parcel parcel) {
            p.i(parcel, "parcel");
            return new AbilityMetaQueryReq(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public AbilityMetaQueryReq[] newArray(int size) {
            return new AbilityMetaQueryReq[size];
        }

        public Companion() {
        }
    }

    public AbilityMetaQueryReq(String str, List<String> list, String str2) {
        this.query = str;
        this.categories = list;
        this.traceId = str2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AbilityMetaQueryReq copy$default(AbilityMetaQueryReq abilityMetaQueryReq, String str, List list, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = abilityMetaQueryReq.query;
        }
        if ((i10 & 2) != 0) {
            list = abilityMetaQueryReq.categories;
        }
        if ((i10 & 4) != 0) {
            str2 = abilityMetaQueryReq.traceId;
        }
        return abilityMetaQueryReq.copy(str, list, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getQuery() {
        return this.query;
    }

    public final List<String> component2() {
        return this.categories;
    }

    /* renamed from: component3, reason: from getter */
    public final String getTraceId() {
        return this.traceId;
    }

    public final AbilityMetaQueryReq copy(String query, List<String> categories, String traceId) {
        return new AbilityMetaQueryReq(query, categories, traceId);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AbilityMetaQueryReq)) {
            return false;
        }
        AbilityMetaQueryReq abilityMetaQueryReq = (AbilityMetaQueryReq) other;
        return p.d(this.query, abilityMetaQueryReq.query) && p.d(this.categories, abilityMetaQueryReq.categories) && p.d(this.traceId, abilityMetaQueryReq.traceId);
    }

    public final List<String> getCategories() {
        return this.categories;
    }

    public final String getQuery() {
        return this.query;
    }

    public final String getTraceId() {
        return this.traceId;
    }

    public int hashCode() {
        String str = this.query;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        List<String> list = this.categories;
        int iHashCode2 = (iHashCode + (list == null ? 0 : list.hashCode())) * 31;
        String str2 = this.traceId;
        return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "AbilityMetaQueryReq(query=" + this.query + ", categories=" + this.categories + ", traceId=" + this.traceId + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        p.i(parcel, "parcel");
        parcel.writeString(this.query);
        parcel.writeStringList(this.categories);
        parcel.writeString(this.traceId);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AbilityMetaQueryReq(Parcel parcel) {
        this(parcel.readString(), parcel.createStringArrayList(), parcel.readString());
        p.i(parcel, "parcel");
    }
}
