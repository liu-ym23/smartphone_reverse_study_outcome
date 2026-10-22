package P5;

import Z8.C1173v;
import com.autonavi.aps.amapapi.config.Const;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001Bg\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0006\u0012\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u0006¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u001a\u001a\u0004\b\u001b\u0010\u0012R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u001a\u001a\u0004\b\u001c\u0010\u0012R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u001a\u001a\u0004\b\u001d\u0010\u0012R \u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u001c\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010!\u001a\u0004\b\"\u0010#R \u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u001e\u001a\u0004\b$\u0010 R \u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u001e\u001a\u0004\b%\u0010 ¨\u0006&"}, d2 = {"LP5/f;", "", "", "itemId", "title", "subtitle", "", "LP5/h;", "fields", "LP5/g;", "amount", "LP5/i;", "notes", "LP5/a;", "actions", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;LP5/g;Ljava/util/List;Ljava/util/List;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", Const.INTENT_KEY_UMID, Const.INTENT_KEY_BACKGROUND_COMMAND, "f", "Ljava/util/List;", "c", "()Ljava/util/List;", "LP5/g;", Const.INTENT_KEY_PKGNAME, "()LP5/g;", "e", Const.INTENT_KEY_APIKEY, "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: P5.f, reason: from toString */
/* loaded from: classes3.dex */
public final /* data */ class OrderActionItem {

    @SerializedName("actions")
    private final List<OrderActionButton> actions;

    @SerializedName("amount")
    private final OrderAmount amount;

    @SerializedName("fields")
    private final List<OrderField> fields;

    @SerializedName("itemId")
    private final String itemId;

    @SerializedName("notes")
    private final List<OrderNote> notes;

    @SerializedName("subtitle")
    private final String subtitle;

    @SerializedName("title")
    private final String title;

    public OrderActionItem() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    public final List<OrderActionButton> a() {
        return this.actions;
    }

    /* renamed from: b, reason: from getter */
    public final OrderAmount getAmount() {
        return this.amount;
    }

    public final List<OrderField> c() {
        return this.fields;
    }

    /* renamed from: d, reason: from getter */
    public final String getItemId() {
        return this.itemId;
    }

    public final List<OrderNote> e() {
        return this.notes;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OrderActionItem)) {
            return false;
        }
        OrderActionItem orderActionItem = (OrderActionItem) other;
        return p.d(this.itemId, orderActionItem.itemId) && p.d(this.title, orderActionItem.title) && p.d(this.subtitle, orderActionItem.subtitle) && p.d(this.fields, orderActionItem.fields) && p.d(this.amount, orderActionItem.amount) && p.d(this.notes, orderActionItem.notes) && p.d(this.actions, orderActionItem.actions);
    }

    /* renamed from: f, reason: from getter */
    public final String getSubtitle() {
        return this.subtitle;
    }

    /* renamed from: g, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        String str = this.itemId;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.title;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.subtitle;
        int iHashCode3 = (((iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31) + this.fields.hashCode()) * 31;
        OrderAmount orderAmount = this.amount;
        return ((((iHashCode3 + (orderAmount != null ? orderAmount.hashCode() : 0)) * 31) + this.notes.hashCode()) * 31) + this.actions.hashCode();
    }

    public String toString() {
        return "OrderActionItem(itemId=" + this.itemId + ", title=" + this.title + ", subtitle=" + this.subtitle + ", fields=" + this.fields + ", amount=" + this.amount + ", notes=" + this.notes + ", actions=" + this.actions + ")";
    }

    public OrderActionItem(String str, String str2, String str3, List<OrderField> fields, OrderAmount orderAmount, List<OrderNote> notes, List<OrderActionButton> actions) {
        p.i(fields, "fields");
        p.i(notes, "notes");
        p.i(actions, "actions");
        this.itemId = str;
        this.title = str2;
        this.subtitle = str3;
        this.fields = fields;
        this.amount = orderAmount;
        this.notes = notes;
        this.actions = actions;
    }

    public /* synthetic */ OrderActionItem(String str, String str2, String str3, List list, OrderAmount orderAmount, List list2, List list3, int i10, kotlin.jvm.internal.i iVar) {
        this((i10 & 1) != 0 ? null : str, (i10 & 2) != 0 ? null : str2, (i10 & 4) != 0 ? null : str3, (i10 & 8) != 0 ? C1173v.m() : list, (i10 & 16) != 0 ? null : orderAmount, (i10 & 32) != 0 ? C1173v.m() : list2, (i10 & 64) != 0 ? C1173v.m() : list3);
    }
}
