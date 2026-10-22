package E4;

import android.os.Bundle;
import com.autonavi.aps.amapapi.config.Const;
import java.util.Map;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0005\b\t\n\u000b\fR\u0014\u0010\u0005\u001a\u00020\u00028&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0004\u0082\u0001\u0005\r\u000e\u000f\u0010\u0011¨\u0006\u0012À\u0006\u0003"}, d2 = {"LE4/d;", "", "", "getCardId", "()Ljava/lang/String;", "cardId", "getBusinessType", "businessType", Const.INTENT_KEY_APIKEY, "e", Const.INTENT_KEY_PKGNAME, "c", Const.INTENT_KEY_UMID, "LE4/d$a;", "LE4/d$b;", "LE4/d$c;", "LE4/d$d;", "LE4/d$e;", "floatcard_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface d {

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0015\u001a\u0004\b\u0016\u0010\fR\u001a\u0010\u0004\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0015\u001a\u0004\b\u0017\u0010\fR\u001a\u0010\u0006\u001a\u00020\u00058\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0015\u001a\u0004\b\u001b\u0010\fR\u0017\u0010\b\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\b\u0010\u0018\u001a\u0004\b\u001c\u0010\u001a¨\u0006\u001d"}, d2 = {"LE4/d$a;", "LE4/d;", "", "cardId", "businessType", "Landroid/os/Bundle;", "requestPayload", "actionId", "payload", "<init>", "(Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;Ljava/lang/String;Landroid/os/Bundle;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getCardId", "getBusinessType", "Landroid/os/Bundle;", "getRequestPayload", "()Landroid/os/Bundle;", Const.INTENT_KEY_APIKEY, Const.INTENT_KEY_PKGNAME, "floatcard_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: E4.d$a, reason: from toString */
    public static final /* data */ class ActionClicked implements d {
        private final String actionId;
        private final String businessType;
        private final String cardId;
        private final Bundle payload;
        private final Bundle requestPayload;

        public ActionClicked(String cardId, String businessType, Bundle requestPayload, String actionId, Bundle payload) {
            kotlin.jvm.internal.p.i(cardId, "cardId");
            kotlin.jvm.internal.p.i(businessType, "businessType");
            kotlin.jvm.internal.p.i(requestPayload, "requestPayload");
            kotlin.jvm.internal.p.i(actionId, "actionId");
            kotlin.jvm.internal.p.i(payload, "payload");
            this.cardId = cardId;
            this.businessType = businessType;
            this.requestPayload = requestPayload;
            this.actionId = actionId;
            this.payload = payload;
        }

        /* renamed from: a, reason: from getter */
        public final String getActionId() {
            return this.actionId;
        }

        /* renamed from: b, reason: from getter */
        public final Bundle getPayload() {
            return this.payload;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ActionClicked)) {
                return false;
            }
            ActionClicked actionClicked = (ActionClicked) other;
            return kotlin.jvm.internal.p.d(this.cardId, actionClicked.cardId) && kotlin.jvm.internal.p.d(this.businessType, actionClicked.businessType) && kotlin.jvm.internal.p.d(this.requestPayload, actionClicked.requestPayload) && kotlin.jvm.internal.p.d(this.actionId, actionClicked.actionId) && kotlin.jvm.internal.p.d(this.payload, actionClicked.payload);
        }

        @Override // E4.d
        public String getBusinessType() {
            return this.businessType;
        }

        @Override // E4.d
        public String getCardId() {
            return this.cardId;
        }

        public int hashCode() {
            return (((((((this.cardId.hashCode() * 31) + this.businessType.hashCode()) * 31) + this.requestPayload.hashCode()) * 31) + this.actionId.hashCode()) * 31) + this.payload.hashCode();
        }

        public String toString() {
            return "ActionClicked(cardId=" + this.cardId + ", businessType=" + this.businessType + ", requestPayload=" + this.requestPayload + ", actionId=" + this.actionId + ", payload=" + this.payload + ")";
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bHÖ\u0003¢\u0006\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0004R\u001a\u0010\u0010\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u000e\u001a\u0004\b\u0011\u0010\u0004R\u001a\u0010\u0013\u001a\u00020\u00128\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"LE4/d$b;", "LE4/d;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "cardId", "Ljava/lang/String;", "getCardId", "businessType", "getBusinessType", "Landroid/os/Bundle;", "requestPayload", "Landroid/os/Bundle;", "getRequestPayload", "()Landroid/os/Bundle;", "floatcard_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: E4.d$b, reason: from toString */
    public static final /* data */ class CardClicked implements d {
        private final String businessType;
        private final String cardId;
        private final Bundle requestPayload;

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CardClicked)) {
                return false;
            }
            CardClicked cardClicked = (CardClicked) other;
            return kotlin.jvm.internal.p.d(this.cardId, cardClicked.cardId) && kotlin.jvm.internal.p.d(this.businessType, cardClicked.businessType) && kotlin.jvm.internal.p.d(this.requestPayload, cardClicked.requestPayload);
        }

        @Override // E4.d
        public String getBusinessType() {
            return this.businessType;
        }

        @Override // E4.d
        public String getCardId() {
            return this.cardId;
        }

        public int hashCode() {
            return (((this.cardId.hashCode() * 31) + this.businessType.hashCode()) * 31) + this.requestPayload.hashCode();
        }

        public String toString() {
            return "CardClicked(cardId=" + this.cardId + ", businessType=" + this.businessType + ", requestPayload=" + this.requestPayload + ")";
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0013\u001a\u0004\b\u0014\u0010\nR\u001a\u0010\u0004\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0013\u001a\u0004\b\u0015\u0010\nR\u001a\u0010\u0006\u001a\u00020\u00058\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"LE4/d$c;", "LE4/d;", "", "cardId", "businessType", "Landroid/os/Bundle;", "requestPayload", "<init>", "(Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getCardId", "getBusinessType", "Landroid/os/Bundle;", "getRequestPayload", "()Landroid/os/Bundle;", "floatcard_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: E4.d$c, reason: from toString */
    public static final /* data */ class Exposed implements d {
        private final String businessType;
        private final String cardId;
        private final Bundle requestPayload;

        public Exposed(String cardId, String businessType, Bundle requestPayload) {
            kotlin.jvm.internal.p.i(cardId, "cardId");
            kotlin.jvm.internal.p.i(businessType, "businessType");
            kotlin.jvm.internal.p.i(requestPayload, "requestPayload");
            this.cardId = cardId;
            this.businessType = businessType;
            this.requestPayload = requestPayload;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Exposed)) {
                return false;
            }
            Exposed exposed = (Exposed) other;
            return kotlin.jvm.internal.p.d(this.cardId, exposed.cardId) && kotlin.jvm.internal.p.d(this.businessType, exposed.businessType) && kotlin.jvm.internal.p.d(this.requestPayload, exposed.requestPayload);
        }

        @Override // E4.d
        public String getBusinessType() {
            return this.businessType;
        }

        @Override // E4.d
        public String getCardId() {
            return this.cardId;
        }

        public int hashCode() {
            return (((this.cardId.hashCode() * 31) + this.businessType.hashCode()) * 31) + this.requestPayload.hashCode();
        }

        public String toString() {
            return "Exposed(cardId=" + this.cardId + ", businessType=" + this.businessType + ", requestPayload=" + this.requestPayload + ")";
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0014\u001a\u0004\b\u0015\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0014\u001a\u0004\b\u0016\u0010\u000bR\u001a\u0010\u0006\u001a\u00020\u00058\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0014\u001a\u0004\b\u001a\u0010\u000b¨\u0006\u001b"}, d2 = {"LE4/d$d;", "LE4/d;", "", "cardId", "businessType", "Landroid/os/Bundle;", "requestPayload", "url", "<init>", "(Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getCardId", "getBusinessType", "Landroid/os/Bundle;", "getRequestPayload", "()Landroid/os/Bundle;", Const.INTENT_KEY_APIKEY, "floatcard_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: E4.d$d, reason: collision with other inner class name and from toString */
    public static final /* data */ class LinkClicked implements d {
        private final String businessType;
        private final String cardId;
        private final Bundle requestPayload;
        private final String url;

        public LinkClicked(String cardId, String businessType, Bundle requestPayload, String url) {
            kotlin.jvm.internal.p.i(cardId, "cardId");
            kotlin.jvm.internal.p.i(businessType, "businessType");
            kotlin.jvm.internal.p.i(requestPayload, "requestPayload");
            kotlin.jvm.internal.p.i(url, "url");
            this.cardId = cardId;
            this.businessType = businessType;
            this.requestPayload = requestPayload;
            this.url = url;
        }

        /* renamed from: a, reason: from getter */
        public final String getUrl() {
            return this.url;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof LinkClicked)) {
                return false;
            }
            LinkClicked linkClicked = (LinkClicked) other;
            return kotlin.jvm.internal.p.d(this.cardId, linkClicked.cardId) && kotlin.jvm.internal.p.d(this.businessType, linkClicked.businessType) && kotlin.jvm.internal.p.d(this.requestPayload, linkClicked.requestPayload) && kotlin.jvm.internal.p.d(this.url, linkClicked.url);
        }

        @Override // E4.d
        public String getBusinessType() {
            return this.businessType;
        }

        @Override // E4.d
        public String getCardId() {
            return this.cardId;
        }

        public int hashCode() {
            return (((((this.cardId.hashCode() * 31) + this.businessType.hashCode()) * 31) + this.requestPayload.hashCode()) * 31) + this.url.hashCode();
        }

        public String toString() {
            return "LinkClicked(cardId=" + this.cardId + ", businessType=" + this.businessType + ", requestPayload=" + this.requestPayload + ", url=" + this.url + ")";
        }
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0005¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0018\u001a\u0004\b\u0019\u0010\u000fR\u001a\u0010\u0004\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0018\u001a\u0004\b\u001a\u0010\u000fR\u001a\u0010\u0006\u001a\u00020\u00058\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0018\u001a\u0004\b\u001e\u0010\u000fR#\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0\b8\u0006¢\u0006\f\n\u0004\b\n\u0010\u001f\u001a\u0004\b \u0010!R\u0017\u0010\u000b\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u001b\u001a\u0004\b\"\u0010\u001d¨\u0006#"}, d2 = {"LE4/d$e;", "LE4/d;", "", "cardId", "businessType", "Landroid/os/Bundle;", "requestPayload", "submitActionId", "", "LE4/n;", "values", "payload", "<init>", "(Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;Ljava/lang/String;Ljava/util/Map;Landroid/os/Bundle;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getCardId", "getBusinessType", "Landroid/os/Bundle;", "getRequestPayload", "()Landroid/os/Bundle;", "getSubmitActionId", "Ljava/util/Map;", Const.INTENT_KEY_APIKEY, "()Ljava/util/Map;", "getPayload", "floatcard_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: E4.d$e, reason: from toString */
    public static final /* data */ class Submit implements d {
        private final String businessType;
        private final String cardId;
        private final Bundle payload;
        private final Bundle requestPayload;
        private final String submitActionId;
        private final Map<String, n> values;

        /* JADX WARN: Multi-variable type inference failed */
        public Submit(String cardId, String businessType, Bundle requestPayload, String submitActionId, Map<String, ? extends n> values, Bundle payload) {
            kotlin.jvm.internal.p.i(cardId, "cardId");
            kotlin.jvm.internal.p.i(businessType, "businessType");
            kotlin.jvm.internal.p.i(requestPayload, "requestPayload");
            kotlin.jvm.internal.p.i(submitActionId, "submitActionId");
            kotlin.jvm.internal.p.i(values, "values");
            kotlin.jvm.internal.p.i(payload, "payload");
            this.cardId = cardId;
            this.businessType = businessType;
            this.requestPayload = requestPayload;
            this.submitActionId = submitActionId;
            this.values = values;
            this.payload = payload;
        }

        public final Map<String, n> a() {
            return this.values;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Submit)) {
                return false;
            }
            Submit submit = (Submit) other;
            return kotlin.jvm.internal.p.d(this.cardId, submit.cardId) && kotlin.jvm.internal.p.d(this.businessType, submit.businessType) && kotlin.jvm.internal.p.d(this.requestPayload, submit.requestPayload) && kotlin.jvm.internal.p.d(this.submitActionId, submit.submitActionId) && kotlin.jvm.internal.p.d(this.values, submit.values) && kotlin.jvm.internal.p.d(this.payload, submit.payload);
        }

        @Override // E4.d
        public String getBusinessType() {
            return this.businessType;
        }

        @Override // E4.d
        public String getCardId() {
            return this.cardId;
        }

        public int hashCode() {
            return (((((((((this.cardId.hashCode() * 31) + this.businessType.hashCode()) * 31) + this.requestPayload.hashCode()) * 31) + this.submitActionId.hashCode()) * 31) + this.values.hashCode()) * 31) + this.payload.hashCode();
        }

        public String toString() {
            return "Submit(cardId=" + this.cardId + ", businessType=" + this.businessType + ", requestPayload=" + this.requestPayload + ", submitActionId=" + this.submitActionId + ", values=" + this.values + ", payload=" + this.payload + ")";
        }
    }

    String getBusinessType();

    String getCardId();
}
