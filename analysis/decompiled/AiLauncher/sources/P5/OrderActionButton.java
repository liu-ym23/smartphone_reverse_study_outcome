package P5;

import com.autonavi.aps.amapapi.config.Const;
import com.google.gson.annotations.SerializedName;
import com.stepos.ailauncher.foundation.appui.card.provider.alipay.AlipayXuiLiveClickReceiver;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0013\u001a\u0004\b\u0014\u0010\u000bR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0013\u001a\u0004\b\u0015\u0010\u000bR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0016\u0010\u000bR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0013\u001a\u0004\b\u0017\u0010\u000bR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0013\u001a\u0004\b\u0018\u0010\u000b¨\u0006\u0019"}, d2 = {"LP5/a;", "", "", "label", AlipayXuiLiveClickReceiver.EXTRA_APP_LINK, "webLink", "chatReplyText", "buttonIcon", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_APIKEY, "c", "getChatReplyText", "getButtonIcon", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: P5.a, reason: from toString */
/* loaded from: classes3.dex */
public final /* data */ class OrderActionButton {

    @SerializedName(AlipayXuiLiveClickReceiver.EXTRA_APP_LINK)
    private final String appLink;

    @SerializedName("buttonIcon")
    private final String buttonIcon;

    @SerializedName("chatReplyText")
    private final String chatReplyText;

    @SerializedName("label")
    private final String label;

    @SerializedName("webLink")
    private final String webLink;

    public OrderActionButton() {
        this(null, null, null, null, null, 31, null);
    }

    /* renamed from: a, reason: from getter */
    public final String getAppLink() {
        return this.appLink;
    }

    /* renamed from: b, reason: from getter */
    public final String getLabel() {
        return this.label;
    }

    /* renamed from: c, reason: from getter */
    public final String getWebLink() {
        return this.webLink;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OrderActionButton)) {
            return false;
        }
        OrderActionButton orderActionButton = (OrderActionButton) other;
        return p.d(this.label, orderActionButton.label) && p.d(this.appLink, orderActionButton.appLink) && p.d(this.webLink, orderActionButton.webLink) && p.d(this.chatReplyText, orderActionButton.chatReplyText) && p.d(this.buttonIcon, orderActionButton.buttonIcon);
    }

    public int hashCode() {
        String str = this.label;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.appLink;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.webLink;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.chatReplyText;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.buttonIcon;
        return iHashCode4 + (str5 != null ? str5.hashCode() : 0);
    }

    public String toString() {
        return "OrderActionButton(label=" + this.label + ", appLink=" + this.appLink + ", webLink=" + this.webLink + ", chatReplyText=" + this.chatReplyText + ", buttonIcon=" + this.buttonIcon + ")";
    }

    public OrderActionButton(String str, String str2, String str3, String str4, String str5) {
        this.label = str;
        this.appLink = str2;
        this.webLink = str3;
        this.chatReplyText = str4;
        this.buttonIcon = str5;
    }

    public /* synthetic */ OrderActionButton(String str, String str2, String str3, String str4, String str5, int i10, kotlin.jvm.internal.i iVar) {
        this((i10 & 1) != 0 ? null : str, (i10 & 2) != 0 ? null : str2, (i10 & 4) != 0 ? null : str3, (i10 & 8) != 0 ? null : str4, (i10 & 16) != 0 ? null : str5);
    }
}
